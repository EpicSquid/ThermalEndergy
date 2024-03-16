package dev.epicsquid.thermalendergy.registry

import dev.epicsquid.thermalendergy.ThermalEndergy
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTabs
import net.minecraftforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.forge.registerObject

object CreativeTabsRegistry {
	val REGISTRY: DeferredRegister<CreativeModeTab> =
		DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ThermalEndergy.MODID)

	val tab by REGISTRY.registerObject("base") {
		CreativeModeTab.builder()
			.icon { ItemRegistry.stellariumIngot.defaultInstance }
			.title(Component.translatable("itemGroup." + ThermalEndergy.MODID))
			.displayItems { _, output ->
				ItemRegistry.REGISTRY.entries.forEach {
					output.accept(it.get())
				}
			}
			.withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
			.build()
	}
}