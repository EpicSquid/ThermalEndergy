package com.epicsquid.thermalendergy.init;

import com.epicsquid.thermalendergy.ThermalEndergy;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class ThermalEndergyTags extends ItemTagsProvider {

	public static final TagKey<Item> STELLARIUM_INGOT = ItemTags.create(new ResourceLocation("forge", "ingots/stellarium"));
	public static final TagKey<Item> MELODIUM_INGOT = ItemTags.create(new ResourceLocation("forge", "ingots/melodium"));
	public static final TagKey<Item> PRISMALIUM_INGOT = ItemTags.create(new ResourceLocation("forge", "ingots/prismalium"));
	public static final TagKey<Item> UPGRADE_3 = ItemTags.create(new ResourceLocation("thermalendergy", "upgrade_3"));

	public ThermalEndergyTags(DataGenerator gen, BlockTagsProvider prov, @Nullable ExistingFileHelper existingFileHelper) {
		super(gen, prov, ThermalEndergy.MODID, existingFileHelper);
	}

	@Override
	public void addTags() {
		tag(UPGRADE_3).addOptional(new ResourceLocation("thermal", "upgrade_augment_3"));
	}
}
