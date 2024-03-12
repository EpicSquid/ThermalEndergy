package dev.epicsquid.thermalendergy

import com.tterrag.registrate.Registrate
import dev.epicsquid.thermalendergy.data.ThermalEndergyTags
import dev.epicsquid.thermalendergy.registry.BlockRegistry
import dev.epicsquid.thermalendergy.registry.CreativeTabsRegistry
import dev.epicsquid.thermalendergy.registry.ItemRegistry
import dev.epicsquid.thermalendergy.registry.LangRegistry
import dev.epicsquid.thermalendergy.registry.LangRegistry.tab
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.minecraftforge.common.data.ForgeBlockTagsProvider
import net.minecraftforge.common.data.ForgeItemTagsProvider
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext

@Mod(ThermalEndergy.MODID)
class ThermalEndergy {
	companion object {
		const val MODID = "thermalendergy"

		val registrate: Registrate by lazy { Registrate.create(MODID) }
	}

	init {
		FMLJavaModLoadingContext.get().modEventBus.addListener { event: GatherDataEvent -> gatherData(event) }

		CreativeTabsRegistry.classload()
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
