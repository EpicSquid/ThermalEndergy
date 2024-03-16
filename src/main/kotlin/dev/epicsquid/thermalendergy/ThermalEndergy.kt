package dev.epicsquid.thermalendergy

import dev.epicsquid.thermalendergy.data.ThermalEndergyBlockStates
import dev.epicsquid.thermalendergy.data.ThermalEndergyBlockTags
import dev.epicsquid.thermalendergy.data.ThermalEndergyItemTags
import dev.epicsquid.thermalendergy.data.ThermalEndergyLang
import dev.epicsquid.thermalendergy.registry.BlockRegistry
import dev.epicsquid.thermalendergy.registry.CreativeTabsRegistry
import dev.epicsquid.thermalendergy.registry.ItemRegistry
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(ThermalEndergy.MODID)
object ThermalEndergy {
	const val MODID = "thermalendergy"

	init {
		val modEventBus = MOD_BUS
		modEventBus.addListener { event: GatherDataEvent -> gatherData(event) }
		CreativeTabsRegistry.REGISTRY.register(modEventBus)
		BlockRegistry.REGISTRY.register(modEventBus)
		ItemRegistry.REGISTRY.register(modEventBus)
	}

	private fun gatherData(event: GatherDataEvent) {
		val generator = event.generator
		val packOutput = generator.packOutput
		val lookupProvider = event.lookupProvider
		val existingFileHelper = event.existingFileHelper

		generator.addProvider(event.includeClient(), ThermalEndergyBlockStates(packOutput, existingFileHelper))
		generator.addProvider(event.includeClient(), ThermalEndergyLang(packOutput, "en_us"))

		val blockTags = ThermalEndergyBlockTags(packOutput, lookupProvider, existingFileHelper)
		generator.addProvider(event.includeServer(), blockTags)
		generator.addProvider(
			event.includeServer(),
			ThermalEndergyItemTags(packOutput, lookupProvider, blockTags, existingFileHelper)
		)
	}
}
