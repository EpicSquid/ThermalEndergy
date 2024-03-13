package dev.epicsquid.thermalendergy.data

import dev.epicsquid.thermalendergy.ThermalEndergy
import net.minecraft.core.HolderLookup.Provider
import net.minecraft.data.PackOutput
import net.minecraft.data.tags.ItemTagsProvider
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.ItemTags
import net.minecraft.world.level.block.Block
import net.minecraftforge.common.data.ExistingFileHelper
import java.util.concurrent.CompletableFuture

class ThermalEndergyTags(
	output: PackOutput,
	lookupProvider: CompletableFuture<Provider>,
	blockTags: CompletableFuture<TagLookup<Block>>,
	existingFileHelper: ExistingFileHelper
) : ItemTagsProvider(output, lookupProvider, blockTags, ThermalEndergy.MODID, existingFileHelper) {
	public override fun addTags(provider: Provider) {
		tag(upgrade3).addOptional(ResourceLocation("thermal", "upgrade_augment_3"))
	}

	companion object {
		val stellariumIngot = ItemTags.create(ResourceLocation("forge", "ingots/stellarium"))
		val melodiumIngot = ItemTags.create(ResourceLocation("forge", "ingots/melodium"))
		val prismaliumIngot = ItemTags.create(ResourceLocation("forge", "ingots/prismalium"))
		val upgrade3 = ItemTags.create(ResourceLocation("thermalendergy", "upgrade_3"))
	}
}
