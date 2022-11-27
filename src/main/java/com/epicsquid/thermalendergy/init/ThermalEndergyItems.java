package com.epicsquid.thermalendergy.init;

import cofh.core.item.CoinItem;
import cofh.core.item.CountedItem;
import cofh.core.item.ItemCoFH;
import cofh.core.util.helpers.AugmentDataHelper;
import cofh.thermal.lib.item.AugmentItem;
import com.epicsquid.thermalendergy.ThermalEndergy;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateItemModelProvider;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.core.Registry;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.Tags;

import static cofh.lib.util.constants.NBTTags.TAG_AUGMENT_BASE_MOD;
import static cofh.lib.util.constants.NBTTags.TAG_AUGMENT_TYPE_UPGRADE;
import static cofh.thermal.lib.common.ThermalFlags.FLAG_UPGRADE_AUGMENTS;
import static cofh.thermal.lib.common.ThermalFlags.getFlag;

public class ThermalEndergyItems {

	private static final ResourceLocation COUNT_PREDICATE = new ResourceLocation("count");
	private static final Registrate REGISTRATE = ThermalEndergy.registrate();
	public static final ItemEntry<ItemCoFH> PRISMALIUM_INGOT = registerEndergyAlloy("prismalium", Rarity.UNCOMMON)
			.register();
	public static final ItemEntry<ItemCoFH> MELODIUM_INGOT = registerEndergyAlloy("melodium", Rarity.RARE).register();
	public static final ItemEntry<ItemCoFH> STELLARIUM_INGOT = registerEndergyAlloy("stellarium", Rarity.RARE).register();

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

	public static ItemBuilder<ItemCoFH, Registrate> registerEndergyAlloy(String prefix, Rarity rarity) {
		// Tags
		var nugget = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "nuggets/" + prefix));
		var dust = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "dusts/" + prefix));
		var gear = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "gears/" + prefix));
		var plate = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "plates/" + prefix));
		var ingot = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "ingots/" + prefix));
		var block = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "storage_blocks/" + prefix));

		REGISTRATE.item(prefix + "_nugget", ItemCoFH::new)
				.properties(props -> props.tab(ThermalEndergy.CREATIVE_TAB).rarity(rarity))
				.tag(nugget)
				.recipe((item, p) -> ShapelessRecipeBuilder.shapeless(item.getEntry(), 9)
						.requires(ingot)
						.unlockedBy("has_ingot", DataIngredient.tag(ingot).getCritereon(p))
						.save(p, p.safeId(item.getEntry())))
				.register();
		REGISTRATE.item(prefix + "_dust", ItemCoFH::new)
				.properties(props -> props.tab(ThermalEndergy.CREATIVE_TAB).rarity(rarity))
				.tag(dust)
				.register();
		REGISTRATE.item(prefix + "_gear", ItemCoFH::new)
				.properties(props -> props.tab(ThermalEndergy.CREATIVE_TAB).rarity(rarity))
				.tag(gear)
				.recipe((item, p) -> ShapedRecipeBuilder.shaped(item.getEntry())
						.pattern(" I ")
						.pattern("INI")
						.pattern(" I ")
						.define('I', ingot)
						.define('N', Tags.Items.NUGGETS_IRON)
						.unlockedBy("has_ingot", DataIngredient.tag(ingot).getCritereon(p))
						.save(p, p.safeId(item.getEntry())))
				.register();
		REGISTRATE.item(prefix + "_plate", CountedItem::new)
				.properties(props -> props.tab(ThermalEndergy.CREATIVE_TAB).rarity(rarity))
				.model((item, p) -> getCountModel(p, item, prefix + "_plate", new float[]{0.0f, 0.25f, 0.5f, 1.0f}))
				.tag(plate)
				.register();
		REGISTRATE.item(prefix + "_coin", CoinItem::new)
				.properties(props -> props.tab(ThermalEndergy.CREATIVE_TAB).rarity(rarity))
				.model((item, p) -> getCountModel(p, item, prefix + "_coin", new float[]{0.0f, 0.03125f, 0.25f, 0.5f, 1.0f}))
				.register();
		return REGISTRATE.item(prefix + "_ingot", ItemCoFH::new)
				.properties(props -> props.tab(ThermalEndergy.CREATIVE_TAB).rarity(rarity))
				.tag(ingot)
				.recipe((item, p) -> {
					SimpleCookingRecipeBuilder.smelting(Ingredient.of(dust), item.getEntry(), 0, 200)
							.unlockedBy("has_dust", DataIngredient.tag(dust).getCritereon(p))
							.save(p, new ResourceLocation(p.safeId(item.getEntry()).getNamespace(), p.safeId(item.getEntry()).getPath() + "_from_dust"));
					ShapelessRecipeBuilder.shapeless(item.getEntry())
							.requires(Ingredient.of(nugget), 9)
							.unlockedBy("has_ingot", DataIngredient.tag(ingot).getCritereon(p))
							.save(p, p.safeId(item.getEntry()));
					ShapelessRecipeBuilder.shapeless(item.getEntry(), 9)
							.requires(block)
							.unlockedBy("has_block", DataIngredient.tag(block).getCritereon(p))
							.save(p,  new ResourceLocation(p.safeId(item.getEntry()).getNamespace(), p.safeId(item.getEntry()).getPath() + "_from_block"));
				});
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
