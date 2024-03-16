package dev.epicsquid.thermalendergy

import dev.epicsquid.thermalendergy.data.*
import dev.epicsquid.thermalendergy.registry.BlockRegistry
import dev.epicsquid.thermalendergy.registry.CreativeTabsRegistry
import dev.epicsquid.thermalendergy.registry.ItemRegistry
import net.minecraft.data.loot.LootTableProvider
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets
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
		generator.addProvider(event.includeClient(), ThermalEndergyItemModels(packOutput, existingFileHelper))
		generator.addProvider(event.includeClient(), ThermalEndergyLang(packOutput, "en_us"))

		val blockTags = ThermalEndergyBlockTags(packOutput, lookupProvider, existingFileHelper)
		generator.addProvider(event.includeServer(), blockTags)
		generator.addProvider(
			event.includeServer(),
			ThermalEndergyItemTags(packOutput, lookupProvider, blockTags, existingFileHelper)
		)
		generator.addProvider(event.includeServer(), ThermalEndergyRecipes(packOutput))
		generator.addProvider(
			event.includeServer(), LootTableProvider(
				packOutput, emptySet(), listOf(
					LootTableProvider.SubProviderEntry(::ThermalEndergyLootTables, LootContextParamSets.BLOCK)
				)
			)
		)
	}
}
