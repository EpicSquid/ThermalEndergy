package dev.epicsquid.thermalendergy.registry

import dev.epicsquid.thermalendergy.ThermalEndergy
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.ItemTags
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour.Properties
import net.minecraftforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.forge.registerObject

object BlockRegistry {
	val REGISTRY: DeferredRegister<Block> = DeferredRegister.create(Registries.BLOCK, ThermalEndergy.MODID)

	val prismaliumBlockItemTag = ItemTags.create(ResourceLocation("forge", "storage_blocks/prismalium"))
	private val prismaliumIngotTag = ItemTags.create(ResourceLocation("forge", "ingots/prismalium"))

	val prismaliumBlockObject = REGISTRY.registerObject("prismalium_block") {
		Block(Properties.of().strength(5.0f, 6.0f).requiresCorrectToolForDrops())
	}
	val prismaliumBlock by prismaliumBlockObject
//		registrate.block<Block>("prismalium_block") { Block(it) }
//			.properties { it.strength(5.0f, 6.0f).requiresCorrectToolForDrops() }
//			.tag(
//				BlockTags.MINEABLE_WITH_PICKAXE,
//				BlockTags.NEEDS_IRON_TOOL,
//				BlockTags.BEACON_BASE_BLOCKS,
//				prismaliumBlockTag
//			)
//			.item()
//			.tag(prismaliumBlockItemTag)
//			.recipe { item: DataGenContext<Item, BlockItem>, p: RegistrateRecipeProvider ->
//				ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, item.entry)
//					.requires(Ingredient.of(prismaliumIngotTag), 9)
//					.unlockedBy("has_block", DataIngredient.tag(prismaliumBlockItemTag).getCritereon(p))
//					.save(p, ResourceLocation(ThermalEndergy.MODID, "ingot_to_prismalium_block"))
//			}
//			.build()
//			.register()

	val melodiumBlockItemTag = ItemTags.create(ResourceLocation("forge", "storage_blocks/melodium"))
	private val melodiumIngotTag = ItemTags.create(ResourceLocation("forge", "ingots/melodium"))

	val melodiumBlockObject = REGISTRY.registerObject("melodium_block") {
		Block(Properties.of().strength(5.0f, 6.0f).requiresCorrectToolForDrops())
	}
	val melodiumBlock by melodiumBlockObject

	private val stellariumItemBlockTag: TagKey<Item> =
		ItemTags.create(ResourceLocation("forge", "storage_blocks/stellarium"))
	private val stellariumIngotTag = ItemTags.create(ResourceLocation("forge", "ingots/stellarium"))

	val stellariumBlockObject = REGISTRY.registerObject("stellarium_block") {
		Block(Properties.of().strength(5.0f, 6.0f).requiresCorrectToolForDrops())
	}
	val stellariumBlock by stellariumBlockObject
}
