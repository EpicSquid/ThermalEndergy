package dev.epicsquid.thermalendergy.data

import dev.epicsquid.thermalendergy.ThermalEndergy
import dev.epicsquid.thermalendergy.registry.ItemRegistry
import net.minecraft.advancements.critereon.InventoryChangeTrigger
import net.minecraft.advancements.critereon.ItemPredicate
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.*
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.ItemTags
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.level.block.Blocks
import net.minecraftforge.common.Tags
import net.minecraftforge.registries.ForgeRegistries
import java.util.function.Consumer

class ThermalEndergyRecipes(output: PackOutput) : RecipeProvider(output) {

	override fun buildRecipes(writer: Consumer<FinishedRecipe>) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.prismaliumUpgrade)
			.pattern("IXI")
			.pattern("GCG")
			.pattern("IXI")
			.define('I', ThermalEndergyItemTags.PRISMALIUM_INGOT)
			.define('C', ThermalEndergyItemTags.UPGRADE_3)
			.define('G', ItemTags.create(ResourceLocation("forge", "gears/enderium")))
			.define('X', Items.ENDER_EYE)
			.unlockedBy(
				"has_prismalium", InventoryChangeTrigger.TriggerInstance.hasItems(
					ItemPredicate.Builder.item().of(ThermalEndergyItemTags.PRISMALIUM_INGOT).build()
				)
			)
			.save(writer)

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.melodiumUpgrade)
			.pattern("IXI")
			.pattern("GCG")
			.pattern("IXI")
			.define('I', ThermalEndergyItemTags.MELODIUM_INGOT)
			.define('C', ItemRegistry.prismaliumUpgrade)
			.define('G', ThermalEndergyItemTags.PRISMALIUM_GEAR)
			.define('X', Items.SHULKER_SHELL)
			.unlockedBy(
				"has_melodium", InventoryChangeTrigger.TriggerInstance.hasItems(
					ItemPredicate.Builder.item().of(ThermalEndergyItemTags.MELODIUM_INGOT).build()
				)
			)
			.save(writer)

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.stellariumUpgrade)
			.pattern("IXI")
			.pattern("GCG")
			.pattern("IXI")
			.define('I', ThermalEndergyItemTags.STELLARIUM_INGOT)
			.define('C', ItemRegistry.melodiumUpgrade)
			.define('G', ThermalEndergyItemTags.MELODIUM_GEAR)
			.define('X', Blocks.CLAY)
			.unlockedBy(
				"has_stellarium",
				InventoryChangeTrigger.TriggerInstance.hasItems(
					ItemPredicate.Builder.item().of(ThermalEndergyItemTags.STELLARIUM_INGOT).build()
				)
			)
			.save(writer)

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.vibratingCore)
			.pattern("G  ")
			.pattern(" E ")
			.pattern("  G")
			.define('G', Tags.Items.INGOTS_GOLD)
			.define('E', Items.ECHO_SHARD)
			.unlockedBy(
				"has_echo_shard",
				InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(Items.ECHO_SHARD).build())
			)
			.save(writer)

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.melodicRangeAugment)
			.pattern(" G ")
			.pattern("PVP")
			.pattern(" G ")
			.define('V', ItemTags.create(ResourceLocation("forge", "gems/diamond")))
			.define('G', ItemTags.create(ResourceLocation("forge", "gears/enderium")))
			.define('P', ThermalEndergyItemTags.MELODIUM_INGOT)
			.unlockedBy(
				"has_melodium",
				InventoryChangeTrigger.TriggerInstance.hasItems(
					ItemPredicate.Builder.item().of(ThermalEndergyItemTags.MELODIUM_INGOT).build()
				)
			)
			.save(writer)

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.dynamoConsumptionNullifier)
			.pattern(" G ")
			.pattern("PVP")
			.pattern(" G ")
			.define('V', ItemTags.create(ResourceLocation("thermal", "glass/hardened")))
			.define('G', ItemTags.create(ResourceLocation("forge", "gears/lumium")))
			.define('P', ThermalEndergyItemTags.MELODIUM_PLATE)
			.unlockedBy(
				"has_melodium",
				InventoryChangeTrigger.TriggerInstance.hasItems(
					ItemPredicate.Builder.item().of(ThermalEndergyItemTags.MELODIUM_INGOT).build()
				)
			)
			.save(writer)

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.dynamoFuelNullifier)
			.pattern(" G ")
			.pattern("PVP")
			.pattern(" G ")
			.define('V', ItemTags.create(ResourceLocation("thermal", "glass/hardened")))
			.define('G', ItemTags.create(ResourceLocation("forge", "gears/signalum")))
			.define('P', ThermalEndergyItemTags.PRISMALIUM_PLATE)
			.unlockedBy(
				"has_prismalium",
				InventoryChangeTrigger.TriggerInstance.hasItems(
					ItemPredicate.Builder.item().of(ThermalEndergyItemTags.PRISMALIUM_INGOT).build()
				)
			)
			.save(writer)

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.energyNullifier)
			.pattern(" G ")
			.pattern("PVP")
			.pattern(" G ")
			.define('V', ItemRegistry.vibratingCore)
			.define('G', ItemTags.create(ResourceLocation("forge", "gears/lumium")))
			.define('P', ThermalEndergyItemTags.MELODIUM_PLATE)
			.unlockedBy(
				"has_melodium", InventoryChangeTrigger.TriggerInstance.hasItems(
					ItemPredicate.Builder.item().of(ThermalEndergyItemTags.MELODIUM_INGOT).build()
				)
			)
			.save(writer)

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.efficiencyNullifier)
			.pattern(" G ")
			.pattern("PVP")
			.pattern(" G ")
			.define('V', ItemRegistry.vibratingCore)
			.define('G', ItemTags.create(ResourceLocation("forge", "gears/enderium")))
			.define('P', ThermalEndergyItemTags.MELODIUM_PLATE)
			.unlockedBy(
				"has_melodium",
				InventoryChangeTrigger.TriggerInstance.hasItems(
					ItemPredicate.Builder.item().of(ThermalEndergyItemTags.MELODIUM_INGOT).build()
				)
			)
			.save(writer)

		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.resonantCatalyst)
			.pattern(" G ")
			.pattern("PVP")
			.pattern(" G ")
			.define('V', ItemRegistry.vibratingCore)
			.define('G', ItemTags.create(ResourceLocation("forge", "gears/signalum")))
			.define('P', ThermalEndergyItemTags.PRISMALIUM_PLATE)
			.unlockedBy(
				"has_prismalium",
				InventoryChangeTrigger.TriggerInstance.hasItems(
					ItemPredicate.Builder.item().of(ThermalEndergyItemTags.PRISMALIUM_INGOT).build()
				)
			)
			.save(writer)

		alloy("prismalium", writer)
		alloy("melodium", writer)
		alloy("stellarium", writer)
	}

	private fun alloy(name: String, writer: Consumer<FinishedRecipe>) {
		val trigger = InventoryChangeTrigger.TriggerInstance.hasItems(
			ItemPredicate.Builder.item().of(
				ForgeRegistries.ITEMS.getValue(
					ResourceLocation(
						ThermalEndergy.MODID, name + "_ingot"
					)
				)
			).build()
		)

		ShapelessRecipeBuilder.shapeless(
			RecipeCategory.MISC, ForgeRegistries.ITEMS.getValue(
				ResourceLocation(
					ThermalEndergy.MODID, name + "_nugget"
				)
			)!!, 9
		)
			.requires(ItemTags.create(ResourceLocation("forge", "ingots/$name")))
			.unlockedBy("has_ingot", trigger)
			.save(writer)

		ShapelessRecipeBuilder.shapeless(
			RecipeCategory.MISC, ForgeRegistries.ITEMS.getValue(
				ResourceLocation(
					ThermalEndergy.MODID, name + "_ingot"
				)
			)!!, 9
		)
			.requires(ItemTags.create(ResourceLocation("forge", "storage_blocks/$name")))
			.unlockedBy("has_ingot", trigger)
			.save(writer)

		ShapedRecipeBuilder.shaped(
			RecipeCategory.MISC,
			ForgeRegistries.ITEMS.getValue(ResourceLocation(ThermalEndergy.MODID, name + "_gear"))!!
		)
			.pattern(" I ")
			.pattern("INI")
			.pattern(" I ")
			.define('I', ItemTags.create(ResourceLocation("forge", "ingots/$name")))
			.define('N', Tags.Items.NUGGETS_IRON)
			.unlockedBy("has_ingot", trigger)
			.save(writer)

		SimpleCookingRecipeBuilder.smelting(
			Ingredient.of(ItemTags.create(ResourceLocation("forge", "dusts/$name"))), RecipeCategory.MISC,
			ForgeRegistries.ITEMS.getValue(ResourceLocation(ThermalEndergy.MODID, name + "_ingot"))!!, 0f, 200
		)
			.unlockedBy("has_ingot", trigger)
			.save(writer, ResourceLocation(ThermalEndergy.MODID, name + "_ingot_from_dust"))

		ShapelessRecipeBuilder.shapeless(
			RecipeCategory.MISC,
			ForgeRegistries.ITEMS.getValue(ResourceLocation(ThermalEndergy.MODID, name + "_ingot"))!!,
			1
		)
			.requires(Ingredient.of(ItemTags.create(ResourceLocation("forge", "nuggets/$name"))), 9)
			.unlockedBy("has_ingot", trigger)
			.save(writer, ResourceLocation(ThermalEndergy.MODID, name + "_ingot_from_nugget"))

		ShapelessRecipeBuilder.shapeless(
			RecipeCategory.MISC,
			ForgeRegistries.ITEMS.getValue(ResourceLocation(ThermalEndergy.MODID, name + "_block"))!!,
			1
		)
			.requires(Ingredient.of(ItemTags.create(ResourceLocation("forge", "ingots/$name"))), 9)
			.unlockedBy("has_ingot", trigger)
			.save(writer, ResourceLocation(ThermalEndergy.MODID, name + "_block_from_ingot"))
	}
}