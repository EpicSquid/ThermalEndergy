package com.epicsquid.thermalendergy.init;

import com.epicsquid.thermalendergy.ThermalEndergy;
import com.tterrag.registrate.Registrate;
import net.minecraft.network.chat.TranslatableComponent;

public class ThermalEndergyLang {


	private static final Registrate REGISTRATE = ThermalEndergy.registrate();

	public static final TranslatableComponent CREATIVE_TAB = REGISTRATE.addRawLang("itemGroup." + ThermalEndergy.MODID, "Thermal Endergy");

	public static void classload() {
	}
}
