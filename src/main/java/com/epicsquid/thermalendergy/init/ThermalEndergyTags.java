package com.epicsquid.thermalendergy.init;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ThermalEndergyTags {

	public static final TagKey<Item> STELLARIUM_INGOT = new TagKey<>(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "ingots/stellarium"));
	public static final TagKey<Item> STELLARIUM_NUGGET = new TagKey<>(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "nuggets/stellarium"));
	public static final TagKey<Item> STELLARIUM_GEAR = new TagKey<>(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "gears/stellarium"));
	public static final TagKey<Item> STELLARIUM_PLATE = new TagKey<>(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "plates/stellarium"));
	public static final TagKey<Item> MELODIUM_INGOT = new TagKey<>(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "ingots/melodium"));
	public static final TagKey<Item> MELODIUM_NUGGET = new TagKey<>(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "nuggets/melodium"));
	public static final TagKey<Item> MELODIUM_GEAR = new TagKey<>(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "gears/melodium"));
	public static final TagKey<Item> MELODIUM_PLATE = new TagKey<>(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "plates/melodium"));
	public static final TagKey<Item> CRYSTALIUM_INGOT = new TagKey<>(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "ingots/crystalium"));
	public static final TagKey<Item> CRYSTALIUM_NUGGET = new TagKey<>(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "nuggets/crystalium"));
	public static final TagKey<Item> CRYSTALIUM_GEAR = new TagKey<>(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "gears/crystalium"));
	public static final TagKey<Item> CRYSTALIUM_PLATE = new TagKey<>(Registry.ITEM_REGISTRY, new ResourceLocation("forge", "plates/crystalium"));
}
