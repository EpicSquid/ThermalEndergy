package dev.epicsquid.thermalendergy

import com.tterrag.registrate.Registrate
import dev.epicsquid.thermalendergy.registry.BlockRegistry
import dev.epicsquid.thermalendergy.registry.ItemRegistry
import dev.epicsquid.thermalendergy.registry.LangRegistry
import dev.epicsquid.thermalendergy.data.ThermalEndergyTags
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.minecraftforge.common.data.ForgeBlockTagsProvider
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import javax.annotation.Nonnull

@Mod(ThermalEndergy.MODID)
class ThermalEndergy {
	companion object {
		const val MODID = "thermalendergy"

		val registrate by lazy { Registrate.create(MODID).creativeModeTab { tab } }

		val tab: CreativeModeTab = object : CreativeModeTab(MODID) {
			@Nonnull
			override fun makeIcon(): ItemStack {
				return ItemStack(BlockRegistry.stellariumBlock.get())
			}
		}
	}

	init {
		FMLJavaModLoadingContext.get().modEventBus.addListener { event: GatherDataEvent -> gatherData(event) }

		BlockRegistry.classload()
		ItemRegistry.classload()
		LangRegistry.classload()
	}

	private fun gatherData(event: GatherDataEvent) {
		val generator = event.generator
		val blockTagsProvider = ForgeBlockTagsProvider(generator, event.existingFileHelper)
		generator.addProvider(event.includeServer(), ThermalEndergyTags(generator, blockTagsProvider, event.existingFileHelper))
	}
}
