package dev.epicsquid.thermalendergy.data

import dev.epicsquid.thermalendergy.ThermalEndergy
import net.minecraft.core.HolderLookup.Provider
import net.minecraft.data.PackOutput
import net.minecraft.data.tags.ItemTagsProvider
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.ItemTags
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraftforge.common.data.BlockTagsProvider
import net.minecraftforge.common.data.ExistingFileHelper
import java.util.concurrent.CompletableFuture

class ThermalEndergyItemTags(
	output: PackOutput,
	lookupProvider: CompletableFuture<Provider>,
	blockTags: BlockTagsProvider,
	existingFileHelper: ExistingFileHelper
) : ItemTagsProvider(output, lookupProvider, blockTags.contentsGetter(), ThermalEndergy.MODID, existingFileHelper) {

	companion object {
		val STELLARIUM_INGOT: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "ingots/stellarium"))
		val MELODIUM_INGOT: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "ingots/melodium"))
		val PRISMALIUM_INGOT: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "ingots/prismalium"))
		val UPGRADE_3: TagKey<Item> = ItemTags.create(ResourceLocation("thermalendergy", "upgrade_3"))
	}

	public override fun addTags(provider: Provider) {
		tag(UPGRADE_3)
			.addOptional(UPGRADE_3.location)
	}
}
