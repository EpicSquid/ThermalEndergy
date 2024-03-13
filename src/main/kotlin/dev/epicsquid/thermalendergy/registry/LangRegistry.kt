package dev.epicsquid.thermalendergy.registry

import dev.epicsquid.thermalendergy.ThermalEndergy
import dev.epicsquid.thermalendergy.ThermalEndergy.Companion.registrate
import net.minecraft.network.chat.Component

object LangRegistry {
	val tab: Component = registrate.addRawLang("itemGroup." + ThermalEndergy.MODID, "Thermal Endergy")

	fun classload() {}
}
