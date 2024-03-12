package dev.epicsquid.thermalendergy.registry

import dev.epicsquid.thermalendergy.ThermalEndergy
import dev.epicsquid.thermalendergy.ThermalEndergy.Companion.registrate
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack

object CreativeTabsRegistry {
	val tab: CreativeModeTab = CreativeModeTab.builder()
		.icon { ItemStack(BlockRegistry.stellariumBlock.get()) }
		.title(Component.literal(ThermalEndergy.MODID)) // todo check this
		.build()

	fun classload() {
	}
}