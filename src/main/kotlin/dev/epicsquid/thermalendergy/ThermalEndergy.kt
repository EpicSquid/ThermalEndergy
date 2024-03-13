package dev.epicsquid.thermalendergy

import com.tterrag.registrate.Registrate
import dev.epicsquid.thermalendergy.registry.*
import net.minecraftforge.common.data.ForgeBlockTagsProvider
import net.minecraftforge.common.data.ForgeItemTagsProvider
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext

@Mod(ThermalEndergy.MODID)
class ThermalEndergy {
	companion object {
		const val MODID = "dev/epicsquid/thermalendergy"

		val registrate: Registrate by lazy { Registrate.create(MODID) }
	}

	init {
		val modEventBus = FMLJavaModLoadingContext.get().modEventBus
		modEventBus.addListener { event: GatherDataEvent -> gatherData(event) }
		CreativeTabsRegistry.register(modEventBus)

		BlockRegistry.classload()
		ItemRegistry.classload()
		LangRegistry.classload()
	}

	private fun gatherData(event: GatherDataEvent) {
		val generator = event.generator
		val blockTagsProvider = ForgeBlockTagsProvider(generator.packOutput, event.lookupProvider, event.existingFileHelper)
		val itemTagsProvider = ForgeItemTagsProvider(
			generator.packOutput,
			event.lookupProvider,
			blockTagsProvider.contentsGetter(),
			event.existingFileHelper
		)
		generator.addProvider(
			event.includeServer(),
			ThermalEndergyTags(
				generator.packOutput,
				event.lookupProvider,
				itemTagsProvider.contentsGetter(),
				blockTagsProvider.contentsGetter(),
				event.existingFileHelper
			)
		)
	}
}
