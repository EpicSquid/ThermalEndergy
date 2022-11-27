package com.epicsquid.thermalendergy.init;

import cofh.thermal.core.init.TCoreBlocks;
import com.epicsquid.thermalendergy.ThermalEndergy;
import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public class ThermalEndergyBlocks {

	private static final Registrate REGISTRATE = ThermalEndergy.registrate();

	public static final TagKey<Item> PRISMALIUM_ITEM_TAG = ItemTags.create(new ResourceLocation("forge", "storage_blocks/prismalium"));
	public static final TagKey<Block> PRISMALIUM_BLOCK_TAG = BlockTags.create(new ResourceLocation("forge", "storage_blocks/prismalium"));
	private static final TagKey<Item> PRISMALIUM_INGOT = ItemTags.create(new ResourceLocation("forge", "ingots/prismalium"));

	public static final BlockEntry<Block> PRISMALIUM_BLOCK = REGISTRATE.block("prismalium_block", props -> TCoreBlocks.storageBlock())
			.tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL, BlockTags.BEACON_BASE_BLOCKS, PRISMALIUM_BLOCK_TAG)
			.item()
			.tag(PRISMALIUM_ITEM_TAG)
			.tab(() -> ThermalEndergy.CREATIVE_TAB)
			.recipe((item, p) -> ShapelessRecipeBuilder.shapeless(item.getEntry())
					.requires(Ingredient.of(PRISMALIUM_INGOT), 9)
					.unlockedBy("has_block", DataIngredient.tag(PRISMALIUM_ITEM_TAG).getCritereon(p))
					.save(p, new ResourceLocation(ThermalEndergy.MODID, "ingot_to_prismalium_block")))
			.build()
			.register();

	public static final TagKey<Item> MELODIUM_ITEM_TAG = ItemTags.create(new ResourceLocation("forge", "storage_blocks/melodium"));
	public static final TagKey<Block> MELODIUM_BLOCK_TAG = BlockTags.create(new ResourceLocation("forge", "storage_blocks/melodium"));
	private static final TagKey<Item> MELODIUM_INGOT = ItemTags.create(new ResourceLocation("forge", "ingots/melodium"));

	public static final BlockEntry<Block> MELODIUM_BLOCK = REGISTRATE.block("melodium_block", props -> TCoreBlocks.storageBlock())
			.tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL, BlockTags.BEACON_BASE_BLOCKS, MELODIUM_BLOCK_TAG)
			.item()
			.tag(MELODIUM_ITEM_TAG)
			.tab(() -> ThermalEndergy.CREATIVE_TAB)
			.recipe((item, p) -> ShapelessRecipeBuilder.shapeless(item.getEntry())
					.requires(Ingredient.of(MELODIUM_INGOT), 9)
					.unlockedBy("has_block", DataIngredient.tag(MELODIUM_ITEM_TAG).getCritereon(p))
					.save(p, new ResourceLocation(ThermalEndergy.MODID, "ingot_to_melodium_block")))
			.build()
			.register();

	public static final TagKey<Item> STELLARIUM_ITEM_TAG = ItemTags.create(new ResourceLocation("forge", "storage_blocks/stellarium"));
	public static final TagKey<Block> STELLARIUM_BLOCK_TAG = BlockTags.create(new ResourceLocation("forge", "storage_blocks/stellarium"));
	private static final TagKey<Item> STELLARIUM_INGOT = ItemTags.create(new ResourceLocation("forge", "ingots/stellarium"));

	public static final BlockEntry<Block> STELLARIUM_BLOCK = REGISTRATE.block("stellarium_block", props -> TCoreBlocks.storageBlock())
			.tag(BlockTags.MINEABLE_WITH_PICKAXE, BlockTags.NEEDS_IRON_TOOL, BlockTags.BEACON_BASE_BLOCKS, STELLARIUM_BLOCK_TAG)
			.item()
			.tag(STELLARIUM_ITEM_TAG)
			.tab(() -> ThermalEndergy.CREATIVE_TAB)
			.recipe((item, p) -> ShapelessRecipeBuilder.shapeless(item.getEntry())
					.requires(Ingredient.of(STELLARIUM_INGOT), 9)
					.unlockedBy("has_block", DataIngredient.tag(STELLARIUM_ITEM_TAG).getCritereon(p))
					.save(p, new ResourceLocation(ThermalEndergy.MODID, "ingot_to_stellarium_block")))
			.build()
			.register();

	public static void classload() {}
}
