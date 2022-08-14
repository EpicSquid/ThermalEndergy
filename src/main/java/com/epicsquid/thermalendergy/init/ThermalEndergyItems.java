package com.epicsquid.thermalendergy.init;

import cofh.core.item.CoinItem;
import cofh.core.item.CountedItem;
import cofh.core.item.ItemCoFH;
import cofh.lib.util.helpers.AugmentDataHelper;
import cofh.thermal.lib.item.AugmentItem;
import com.epicsquid.thermalendergy.ThermalEndergy;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateItemModelProvider;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;

import static cofh.lib.util.constants.NBTTags.TAG_AUGMENT_BASE_MOD;
import static cofh.lib.util.constants.NBTTags.TAG_AUGMENT_TYPE_UPGRADE;
import static cofh.thermal.lib.common.ThermalFlags.FLAG_UPGRADE_AUGMENTS;
import static cofh.thermal.lib.common.ThermalFlags.getFlag;

public class ThermalEndergyItems {

	private static final ResourceLocation COUNT_PREDICATE = new ResourceLocation("count");
	private static final Registrate REGISTRATE = ThermalEndergy.registrate();

	public static final ItemEntry<ItemCoFH> PRISMALIUM_INGOT = registerEndergyAlloy("prismalium", Rarity.UNCOMMON);
	public static final ItemEntry<ItemCoFH> MELODIUM_INGOT = registerEndergyAlloy("melodium", Rarity.UNCOMMON);
	public static final ItemEntry<ItemCoFH> STELLARIUM_INGOT = registerEndergyAlloy("stellarium", Rarity.RARE);

	public static final ItemEntry<ItemCoFH> PRISMALIUM_UPGRADE = REGISTRATE.item("endergy_upgrade_1", props -> new AugmentItem(props,
					AugmentDataHelper.builder()
							.type(TAG_AUGMENT_TYPE_UPGRADE)
							.mod(TAG_AUGMENT_BASE_MOD, 6.0f)
							.build()).setShowInGroups(getFlag(FLAG_UPGRADE_AUGMENTS)))
			.tab(() -> ThermalEndergy.CREATIVE_TAB)
			.model((item, p) -> p.generated(item,
					new ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_1"),
					new ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_1_lights"),
					new ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_anim")))
			.lang("Pristine Integral Components")
			.register();

	public static final ItemEntry<ItemCoFH> MELODIUM_UPGRADE = REGISTRATE.item("endergy_upgrade_2", props -> new AugmentItem(props,
					AugmentDataHelper.builder()
							.type(TAG_AUGMENT_TYPE_UPGRADE)
							.mod(TAG_AUGMENT_BASE_MOD, 8.5f)
							.build()).setShowInGroups(getFlag(FLAG_UPGRADE_AUGMENTS)))
			.tab(() -> ThermalEndergy.CREATIVE_TAB)
			.model((item, p) -> p.generated(item,
					new ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_2"),
					new ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_2_lights"),
					new ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_anim")))
			.lang("Melodic Integral Components")
			.register();

	public static final ItemEntry<ItemCoFH> STELLARIUM_UPGRADE = REGISTRATE.item("endergy_upgrade_3", props -> new AugmentItem(props,
					AugmentDataHelper.builder()
							.type(TAG_AUGMENT_TYPE_UPGRADE)
							.mod(TAG_AUGMENT_BASE_MOD, 12f)
							.build()).setShowInGroups(getFlag(FLAG_UPGRADE_AUGMENTS)))
			.tab(() -> ThermalEndergy.CREATIVE_TAB)
			.model((item, p) -> p.generated(item,
					new ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_3"),
					new ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_3_lights"),
					new ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_anim")))
			.lang("Stellar Integral Components")
			.register();

	public static ItemEntry<ItemCoFH> registerEndergyAlloy(String prefix, Rarity rarity) {
		REGISTRATE.item(prefix + "_nugget", ItemCoFH::new)
				.properties(props -> props.tab(ThermalEndergy.CREATIVE_TAB).rarity(rarity))
				.tag(new TagKey<>(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "nuggets/" + prefix)))
				.register();
		REGISTRATE.item(prefix + "_dust", ItemCoFH::new)
				.properties(props -> props.tab(ThermalEndergy.CREATIVE_TAB).rarity(rarity))
				.tag(new TagKey<>(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "dusts/" + prefix)))
				.register();
		REGISTRATE.item(prefix + "_gear", ItemCoFH::new)
				.properties(props -> props.tab(ThermalEndergy.CREATIVE_TAB).rarity(rarity))
				.tag(new TagKey<>(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "gears/" + prefix)))
				.register();
		REGISTRATE.item(prefix + "_plate", CountedItem::new)
				.properties(props -> props.tab(ThermalEndergy.CREATIVE_TAB).rarity(rarity))
				.model((item, p) -> getCountModel(p, item, prefix + "_plate", new float[]{0.0f, 0.25f, 0.5f, 1.0f}))
				.tag(new TagKey<>(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "plates/" + prefix)))
				.register();
		REGISTRATE.item(prefix + "_coin", CoinItem::new)
				.properties(props -> props.tab(ThermalEndergy.CREATIVE_TAB).rarity(rarity))
				.model((item, p) -> getCountModel(p, item, prefix + "_coin", new float[]{0.0f, 0.03125f, 0.25f, 0.5f, 1.0f}))
				.register();
		return REGISTRATE.item(prefix + "_ingot", ItemCoFH::new)
				.properties(props -> props.tab(ThermalEndergy.CREATIVE_TAB).rarity(rarity))
				.tag(new TagKey<>(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "ingots/" + prefix)))
				.register();
	}

	public static void getCountModel(RegistrateItemModelProvider p, DataGenContext<Item, ?> item, String name, float[] counts) {
		var prov = p.generated(item, new ResourceLocation(ThermalEndergy.MODID, "item/" + name + "_0"));
		for (int i = 0; i < counts.length; i++) {
			prov = prov.override()
					.predicate(COUNT_PREDICATE, counts[i])
					.model(p.getBuilder(p.name(item) + "_" + i)
							.parent(new ModelFile.UncheckedModelFile("item/generated"))
							.texture("layer0", new ResourceLocation(ThermalEndergy.MODID, "item/" + name + "_" + i)))
					.end();
		}
	}

	public static void classload() {
	}
}
