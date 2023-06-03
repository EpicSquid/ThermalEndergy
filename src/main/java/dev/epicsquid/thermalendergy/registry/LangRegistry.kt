package dev.epicsquid.thermalendergy.registry

import dev.epicsquid.thermalendergy.ThermalEndergy
import net.minecraft.network.chat.Component

object LangRegistry {
	private val registrate = ThermalEndergy.registrate

	val tab: Component = registrate.addRawLang("itemGroup." + ThermalEndergy.MODID, "Thermal Endergy")

	fun classload() {}
}
