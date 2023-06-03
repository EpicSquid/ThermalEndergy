package dev.epicsquid.thermalendergy.registry

import cofh.thermal.core.util.RegistrationHelper
import com.tterrag.registrate.providers.DataGenContext
import com.tterrag.registrate.providers.RegistrateRecipeProvider
import com.tterrag.registrate.util.DataIngredient
import com.tterrag.registrate.util.entry.BlockEntry
import dev.epicsquid.thermalendergy.ThermalEndergy
import net.minecraft.data.recipes.ShapelessRecipeBuilder
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.tags.ItemTags
import net.minecraft.tags.TagKey
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour.Properties

object BlockRegistry {
	private val registrate = ThermalEndergy.registrate

	val prismaliumBlockItemTag = ItemTags.create(ResourceLocation("forge", "storage_blocks/prismalium"))
	val prismaliumBlockTag = BlockTags.create(ResourceLocation("forge", "storage_blocks/prismalium"))
	private val prismaliumIngotTag = ItemTags.create(ResourceLocation("forge", "ingots/prismalium"))

	val prismaliumBlock =
		registrate.block<Block>("prismalium_block") { _: Properties -> RegistrationHelper.storageBlock() }
			.tag(
				BlockTags.MINEABLE_WITH_PICKAXE,
				BlockTags.NEEDS_IRON_TOOL,
				BlockTags.BEACON_BASE_BLOCKS,
				prismaliumBlockTag
			)
			.item()
			.tag(prismaliumBlockItemTag)
			.tab { ThermalEndergy.tab }
			.recipe { item: DataGenContext<Item, BlockItem>, p: RegistrateRecipeProvider ->
				ShapelessRecipeBuilder.shapeless(item.entry)
					.requires(Ingredient.of(prismaliumIngotTag), 9)
					.unlockedBy("has_block", DataIngredient.tag(prismaliumBlockItemTag).getCritereon(p))
					.save(p, ResourceLocation(ThermalEndergy.MODID, "ingot_to_prismalium_block"))
			}
			.build()
			.register()

	val melodiumBlockItemTag = ItemTags.create(ResourceLocation("forge", "storage_blocks/melodium"))
	val melodiumBlockTag = BlockTags.create(ResourceLocation("forge", "storage_blocks/melodium"))
	private val melodiumIngotTag = ItemTags.create(ResourceLocation("forge", "ingots/melodium"))

	val melodiumBlock =
		registrate.block<Block>("melodium_block") { _: Properties -> RegistrationHelper.storageBlock() }
			.tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL, BlockTags.BEACON_BASE_BLOCKS, melodiumBlockTag)
			.item()
			.tag(melodiumBlockItemTag)
			.tab { ThermalEndergy.tab }
			.recipe { item: DataGenContext<Item, BlockItem>, p: RegistrateRecipeProvider ->
				ShapelessRecipeBuilder.shapeless(item.entry)
					.requires(Ingredient.of(melodiumIngotTag), 9)
					.unlockedBy("has_block", DataIngredient.tag(melodiumBlockItemTag).getCritereon(p))
					.save(p, ResourceLocation(ThermalEndergy.MODID, "ingot_to_melodium_block"))
			}
			.build()
			.register()

	private val stellariumItemBlockTag: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "storage_blocks/stellarium"))
	private val stellariumBlockTag: TagKey<Block> = BlockTags.create(ResourceLocation("forge", "storage_blocks/stellarium"))
	private val stellariumIngotTag = ItemTags.create(ResourceLocation("forge", "ingots/stellarium"))

	val stellariumBlock: BlockEntry<Block> =
		registrate.block<Block>("stellarium_block") { _: Properties -> RegistrationHelper.storageBlock() }
			.tag(
				BlockTags.MINEABLE_WITH_PICKAXE,
				BlockTags.NEEDS_IRON_TOOL,
				BlockTags.BEACON_BASE_BLOCKS,
				stellariumBlockTag
			)
			.item()
			.tag(stellariumItemBlockTag)
			.tab { ThermalEndergy.tab }
			.recipe { item: DataGenContext<Item, BlockItem>, p: RegistrateRecipeProvider ->
				ShapelessRecipeBuilder.shapeless(item.entry)
					.requires(Ingredient.of(stellariumIngotTag), 9)
					.unlockedBy("has_block", DataIngredient.tag(stellariumItemBlockTag).getCritereon(p))
					.save(p, ResourceLocation(ThermalEndergy.MODID, "ingot_to_stellarium_block"))
			}
			.build()
			.register()

	fun classload() {}
}