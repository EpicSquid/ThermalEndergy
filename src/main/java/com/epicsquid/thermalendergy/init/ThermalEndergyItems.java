package com.epicsquid.thermalendergy.init;

import cofh.core.item.ItemCoFH;
import cofh.lib.util.helpers.AugmentDataHelper;
import cofh.thermal.lib.item.AugmentItem;
import com.epicsquid.thermalendergy.ThermalEndergy;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

import static cofh.lib.util.constants.NBTTags.TAG_AUGMENT_BASE_MOD;
import static cofh.lib.util.constants.NBTTags.TAG_AUGMENT_TYPE_UPGRADE;
import static cofh.thermal.core.util.RegistrationHelper.registerItem;
import static cofh.thermal.lib.common.ThermalFlags.FLAG_UPGRADE_AUGMENTS;
import static cofh.thermal.lib.common.ThermalFlags.getFlag;
import static cofh.thermal.lib.common.ThermalItemGroups.THERMAL_ITEMS;

public class ThermalEndergyItems {

	private static final Registrate REGISTRATE = ThermalEndergy.registrate();

	public static final ItemEntry<Item> MELODIUM_INGOT = REGISTRATE.item("melodium_ingot", Item::new).tab(() -> ThermalEndergy.CREATIVE_TAB).register();
	public static final ItemEntry<Item> CRYSTALIUM_INGOT = REGISTRATE.item("crystalium_ingot", Item::new).tab(() -> ThermalEndergy.CREATIVE_TAB).register();
	public static final ItemEntry<Item> STELLARIUM_INGOT = REGISTRATE.item("stellarium_ingot", Item::new).tab(() -> ThermalEndergy.CREATIVE_TAB).register();

	public static final ItemEntry<ItemCoFH> CRYSTALIUM_UPGRADE = REGISTRATE.item("endergy_upgrade_1", props -> new AugmentItem(props,
					AugmentDataHelper.builder()
									.type(TAG_AUGMENT_TYPE_UPGRADE)
									.mod(TAG_AUGMENT_BASE_MOD, 4.0f)
									.build()).setShowInGroups(getFlag(FLAG_UPGRADE_AUGMENTS)))
					.tab(() -> ThermalEndergy.CREATIVE_TAB)
					.lang("Crystalium Integral Components")
					.register();

	public static final ItemEntry<ItemCoFH> MELODIUM_UPGRADE = REGISTRATE.item("endergy_upgrade_2", props -> new AugmentItem(props,
					AugmentDataHelper.builder()
									.type(TAG_AUGMENT_TYPE_UPGRADE)
									.mod(TAG_AUGMENT_BASE_MOD, 6.0f)
									.build()).setShowInGroups(getFlag(FLAG_UPGRADE_AUGMENTS)))
					.tab(() -> ThermalEndergy.CREATIVE_TAB)
					.lang("Melodium Integral Components")
					.register();

	public static final ItemEntry<ItemCoFH> STELLARIUM_UPGRADE = REGISTRATE.item("endergy_upgrade_3", props -> new AugmentItem(props,
					AugmentDataHelper.builder()
									.type(TAG_AUGMENT_TYPE_UPGRADE)
									.mod(TAG_AUGMENT_BASE_MOD, 8.5f)
									.build()).setShowInGroups(getFlag(FLAG_UPGRADE_AUGMENTS)))
					.tab(() -> ThermalEndergy.CREATIVE_TAB)
					.lang("Stellarium Integral Components")
					.register();

	public static void classload() {
	}
}
