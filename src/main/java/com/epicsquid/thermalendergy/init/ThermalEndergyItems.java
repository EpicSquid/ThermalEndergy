package com.epicsquid.thermalendergy.init;

import com.epicsquid.thermalendergy.ThermalEndergy;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

public class ThermalEndergyItems {

	private static final Registrate REGISTRATE = ThermalEndergy.registrate();

	public static final ItemEntry<Item> MELODIUM_INGOT = REGISTRATE.item("melodium_ingot", Item::new).tab(() -> ThermalEndergy.CREATIVE_TAB).register();
	public static final ItemEntry<Item> CRYSTALIUM_INGOT = REGISTRATE.item("crystalium_ingot", Item::new).tab(() -> ThermalEndergy.CREATIVE_TAB).register();
	public static final ItemEntry<Item> STELLARIUM_INGOT = REGISTRATE.item("stellarium_ingot", Item::new).tab(() -> ThermalEndergy.CREATIVE_TAB).register();

	public static void classload() {
	}
}
