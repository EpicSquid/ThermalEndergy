package dev.epicsquid.thermalendergy

import com.tterrag.registrate.Registrate
import dev.epicsquid.thermalendergy.data.ThermalEndergyTags
import dev.epicsquid.thermalendergy.registry.BlockRegistry
import dev.epicsquid.thermalendergy.registry.CreativeTabsRegistry
import dev.epicsquid.thermalendergy.registry.ItemRegistry
import dev.epicsquid.thermalendergy.registry.LangRegistry
import dev.epicsquid.thermalendergy.utils.ThermalEndergyRegistrate
import net.minecraftforge.common.data.ForgeBlockTagsProvider
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(ThermalEndergy.MODID)
object ThermalEndergy {
	const val MODID = "thermalendergy"

	val registrate: ThermalEndergyRegistrate by lazy { ThermalEndergyRegistrate.create(MODID) }

	init {
		val modEventBus = MOD_BUS
		modEventBus.addListener { event: GatherDataEvent -> gatherData(event) }
		CreativeTabsRegistry.register(modEventBus)

		BlockRegistry.classload()
		ItemRegistry.classload()
		LangRegistry.classload()
	}

	private fun gatherData(event: GatherDataEvent) {
		val generator = event.generator
		val blockTagsProvider = ForgeBlockTagsProvider(generator.packOutput, event.lookupProvider, event.existingFileHelper)
		generator.addProvider(
			event.includeServer(),
			ThermalEndergyTags(
				generator.packOutput,
				event.lookupProvider,
				blockTagsProvider.contentsGetter(),
				event.existingFileHelper
			)
		)
	}
}
