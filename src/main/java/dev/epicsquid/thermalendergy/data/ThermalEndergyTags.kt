package dev.epicsquid.thermalendergy.data

import dev.epicsquid.thermalendergy.ThermalEndergy
import net.minecraft.data.DataGenerator
import net.minecraft.data.tags.BlockTagsProvider
import net.minecraft.data.tags.ItemTagsProvider
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.ItemTags
import net.minecraftforge.common.data.ExistingFileHelper

class ThermalEndergyTags(
	dataGenerator: DataGenerator,
	blockTagsProvider: BlockTagsProvider,
	existingFileHelper: ExistingFileHelper
) : ItemTagsProvider(dataGenerator, blockTagsProvider, ThermalEndergy.MODID, existingFileHelper) {
	public override fun addTags() {
		tag(upgrade3).addOptional(ResourceLocation("thermal", "upgrade_augment_3"))
	}

	companion object {
		val stellariumIngot = ItemTags.create(ResourceLocation("forge", "ingots/stellarium"))
		val melodiumIngot = ItemTags.create(ResourceLocation("forge", "ingots/melodium"))
		val prismaliumIngot = ItemTags.create(ResourceLocation("forge", "ingots/prismalium"))
		val upgrade3 = ItemTags.create(ResourceLocation("thermalendergy", "upgrade_3"))
	}
}
