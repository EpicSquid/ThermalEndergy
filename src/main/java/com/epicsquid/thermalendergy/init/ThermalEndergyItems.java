package com.epicsquid.thermalendergy.init;

import cofh.core.item.ItemCoFH;
import cofh.lib.util.helpers.AugmentDataHelper;
import cofh.thermal.lib.item.AugmentItem;
import com.epicsquid.thermalendergy.ThermalEndergy;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.providers.RegistrateItemModelProvider;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.registries.ForgeRegistries;

import static cofh.lib.util.constants.NBTTags.TAG_AUGMENT_BASE_MOD;
import static cofh.lib.util.constants.NBTTags.TAG_AUGMENT_TYPE_UPGRADE;
import static cofh.thermal.core.util.RegistrationHelper.registerItem;
import static cofh.thermal.lib.common.ThermalFlags.FLAG_UPGRADE_AUGMENTS;
import static cofh.thermal.lib.common.ThermalFlags.getFlag;
import static cofh.thermal.lib.common.ThermalItemGroups.THERMAL_ITEMS;

public class ThermalEndergyItems {

	private static final Registrate REGISTRATE = ThermalEndergy.registrate();

	public static final ItemEntry<Item> MELODIUM_INGOT = REGISTRATE.item("melodium_ingot", Item::new).tab(() -> ThermalEndergy.CREATIVE_TAB).register();
	public static final ItemEntry<Item> PRISMALIUM_INGOT = REGISTRATE.item("prismalium_ingot", Item::new).tab(() -> ThermalEndergy.CREATIVE_TAB).register();
	public static final ItemEntry<Item> STELLARIUM_INGOT = REGISTRATE.item("stellarium_ingot", Item::new).tab(() -> ThermalEndergy.CREATIVE_TAB).register();

	public static final ItemEntry<ItemCoFH> CRYSTALIUM_UPGRADE = REGISTRATE.item("endergy_upgrade_1", props -> new AugmentItem(props,
					AugmentDataHelper.builder()
							.type(TAG_AUGMENT_TYPE_UPGRADE)
							.mod(TAG_AUGMENT_BASE_MOD, 6.0f)
							.build()).setShowInGroups(getFlag(FLAG_UPGRADE_AUGMENTS)))
			.tab(() -> ThermalEndergy.CREATIVE_TAB)
			.model((item, p) -> p.generated(item,
					new ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_1"),
					new ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_1_lights"),
					new ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_anim")))
			.lang("Crystalium Integral Components")
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
			.lang("Melodium Integral Components")
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
			.lang("Stellarium Integral Components")
			.register();

	public static void classload() {
	}
}
