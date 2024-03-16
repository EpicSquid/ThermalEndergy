package dev.epicsquid.thermalendergy.data

import dev.epicsquid.thermalendergy.ThermalEndergy
import dev.epicsquid.thermalendergy.registry.BlockRegistry
import net.minecraft.core.HolderLookup.Provider
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.tags.TagKey
import net.minecraft.world.level.block.Block
import net.minecraftforge.common.data.BlockTagsProvider
import net.minecraftforge.common.data.ExistingFileHelper
import java.util.concurrent.CompletableFuture

class ThermalEndergyBlockTags(
	output: PackOutput,
	lookupProvider: CompletableFuture<Provider>,
	existingFileHelper: ExistingFileHelper?
) : BlockTagsProvider(output, lookupProvider, ThermalEndergy.MODID, existingFileHelper) {

	companion object {
		val PRISMALIUM_STORAGE_BLOCK: TagKey<Block> =
			BlockTags.create(ResourceLocation("forge", "storage_blocks/prismalium"))
		val MELODIUM_STORAGE_BLOCK: TagKey<Block> = BlockTags.create(ResourceLocation("forge", "storage_blocks/melodium"))
		val STELLARIUM_STORAGE_BLOCK: TagKey<Block> =
			BlockTags.create(ResourceLocation("forge", "storage_blocks/stellarium"))
	}

	override fun addTags(pProvider: Provider) {
		tag(BlockTags.MINEABLE_WITH_PICKAXE)
			.add(BlockRegistry.prismaliumBlock, BlockRegistry.melodiumBlock, BlockRegistry.stellariumBlock)
		tag(BlockTags.NEEDS_IRON_TOOL)
			.add(BlockRegistry.prismaliumBlock, BlockRegistry.melodiumBlock, BlockRegistry.stellariumBlock)
		tag(BlockTags.BEACON_BASE_BLOCKS)
			.add(BlockRegistry.prismaliumBlock, BlockRegistry.melodiumBlock, BlockRegistry.stellariumBlock)
		tag(PRISMALIUM_STORAGE_BLOCK)
			.add(BlockRegistry.prismaliumBlock)
		tag(MELODIUM_STORAGE_BLOCK)
			.add(BlockRegistry.melodiumBlock)
		tag(STELLARIUM_STORAGE_BLOCK)
			.add(BlockRegistry.stellariumBlock)
	}
}