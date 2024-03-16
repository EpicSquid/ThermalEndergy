package dev.epicsquid.thermalendergy.data

import dev.epicsquid.thermalendergy.ThermalEndergy
import net.minecraft.core.HolderLookup.Provider
import net.minecraft.data.PackOutput
import net.minecraft.data.tags.ItemTagsProvider
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.ItemTags
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
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
		val PRISMALIUM_INGOT: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "ingots/prismalium"))
		val PRISMALIUM_NUGGET: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "nuggets/prismalium"))
		val PRISMALIUM_DUST: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "dusts/prismalium"))
		val PRISMALIUM_GEAR: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "gears/prismalium"))
		val PRISMALIUM_PLATE: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "plates/prismalium"))
		val PRISMALIUM_COIN: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "coins/prismalium"))
		val PRISMALIUM_BLOCK: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "storage_blocks/prismalium"))

		val MELODIUM_INGOT: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "ingots/melodium"))
		val MELODIUM_NUGGET: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "nuggets/melodium"))
		val MELODIUM_DUST: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "dusts/melodium"))
		val MELODIUM_GEAR: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "gears/melodium"))
		val MELODIUM_PLATE: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "plates/melodium"))
		val MELODIUM_COIN: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "coins/melodium"))
		val MELODIUM_BLOCK: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "storage_blocks/melodium"))

		val STELLARIUM_INGOT: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "ingots/stellarium"))
		val STELLARIUM_NUGGET: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "nuggets/stellarium"))
		val STELLARIUM_DUST: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "dusts/stellarium"))
		val STELLARIUM_GEAR: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "gears/stellarium"))
		val STELLARIUM_PLATE: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "plates/stellarium"))
		val STELLARIUM_COIN: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "coins/stellarium"))
		val STELLARIUM_BLOCK: TagKey<Item> = ItemTags.create(ResourceLocation("forge", "storage_blocks/stellarium"))

		val UPGRADE_3: TagKey<Item> = ItemTags.create(ResourceLocation("thermalendergy", "upgrade_3"))
	}

	public override fun addTags(provider: Provider) {
		tag(UPGRADE_3)
			.addOptional(ResourceLocation("thermal", "upgrade_augment_3"))

		alloyTag("prismalium")
		alloyTag("melodium")
		alloyTag("stellarium")
	}

	private fun alloyTag(name: String) {
		alloyTag(name, "ingot")
		alloyTag(name, "nugget")
		alloyTag(name, "dust")
		alloyTag(name, "gear")
		alloyTag(name, "plate")
		alloyTag(name, "coin")
		alloyTag(name, "storage_block")
	}

	private fun alloyTag(name: String, suffix: String) {
		tag(ItemTags.create(ResourceLocation("forge", "${suffix}s/$name")))
			.addOptional(ResourceLocation(ThermalEndergy.MODID, "${name}_$suffix"))
	}
}
