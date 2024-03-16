package dev.epicsquid.thermalendergy.registry

import cofh.core.common.item.CoinItem
import cofh.core.common.item.CountedItem
import cofh.core.common.item.ItemCoFH
import cofh.core.util.helpers.AugmentDataHelper
import cofh.lib.util.constants.NBTTags
import cofh.thermal.lib.common.item.AugmentItem
import dev.epicsquid.thermalendergy.ThermalEndergy
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.Item.Properties
import net.minecraft.world.item.Rarity
import net.minecraft.world.item.Rarity.RARE
import net.minecraft.world.item.Rarity.UNCOMMON
import net.minecraftforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.forge.ObjectHolderDelegate
import thedarkcolour.kotlinforforge.forge.registerObject

object ItemRegistry {
	val REGISTRY = DeferredRegister.create(Registries.ITEM, ThermalEndergy.MODID)

	private val countPredicate = ResourceLocation("count")

	val prismaliumIngot by registerEndergyAlloy("prismalium", UNCOMMON)
	val melodiumIngot by registerEndergyAlloy("melodium", RARE)
	val sterllariumIngot by registerEndergyAlloy("stellarium", RARE)

	val prismaliumBlock by REGISTRY.registerObject("prismalium_block") {
		BlockItem(BlockRegistry.prismaliumBlock, Properties().rarity(UNCOMMON))
	}
	val melodiumBlock by REGISTRY.registerObject("melodium_block") {
		BlockItem(BlockRegistry.melodiumBlock, Properties().rarity(RARE))
	}
	val stellariumBlock by REGISTRY.registerObject("stellarium_block") {
		BlockItem(BlockRegistry.stellariumBlock, Properties().rarity(RARE))
	}

	val prismaliumUpgrade by REGISTRY.registerObject("endergy_upgrade_1") {
		AugmentItem(
			Properties(),
			AugmentDataHelper.builder()
				.type(NBTTags.TAG_AUGMENT_TYPE_UPGRADE)
				.mod(NBTTags.TAG_AUGMENT_BASE_MOD, 6.0f)
				.build()
		)
	}
//			.model { item: DataGenContext<Item, ItemCoFH>, p: RegistrateItemModelProvider ->
//				p.generated(
//					item,
//					ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_1"),
//					ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_1_lights"),
//					ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_anim")
//				)
//			}
//			.lang("Pristine Integral Components")
//			.recipe { item: DataGenContext<Item, ItemCoFH>, p: RegistrateRecipeProvider ->
//				ShapedRecipeBuilder.shaped(MISC, item.entry)
//					.pattern("IXI")
//					.pattern("GCG")
//					.pattern("IXI")
//					.define('I', ThermalEndergyItemTags.PRISMALIUM_INGOT)
//					.define('C', ThermalEndergyItemTags.UPGRADE_3)
//					.define('G', ItemTags.create(ResourceLocation("forge", "gears/enderium")))
//					.define('X', Items.ENDER_EYE)
//					.unlockedBy("has_ingot", DataIngredient.tag(ThermalEndergyItemTags.PRISMALIUM_INGOT).getCritereon(p))
//					.save(p, p.safeId(item.entry))
//			}

	val melodiumUpgrade by REGISTRY.registerObject("endergy_upgrade_2") {
		AugmentItem(
			Properties(),
			AugmentDataHelper.builder()
				.type(NBTTags.TAG_AUGMENT_TYPE_UPGRADE)
				.mod(NBTTags.TAG_AUGMENT_BASE_MOD, 8.5f)
				.build()
		)
	}
//			.model { item: DataGenContext<Item, ItemCoFH>, p: RegistrateItemModelProvider ->
//				p.generated(
//					item,
//					ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_2"),
//					ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_2_lights"),
//					ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_anim")
//				)
//			}
//			.lang("Melodic Integral Components")
//			.recipe { item: DataGenContext<Item?, ItemCoFH>, p: RegistrateRecipeProvider ->
//				ShapedRecipeBuilder.shaped(MISC, item.entry)
//					.pattern("IXI")
//					.pattern("GCG")
//					.pattern("IXI")
//					.define('I', ThermalEndergyItemTags.MELODIUM_INGOT)
//					.define('C', prismaliumUpgrade)
//					.define('G', ItemTags.create(ResourceLocation("forge", "gears/prismalium")))
//					.define('X', Items.SHULKER_SHELL)
//					.unlockedBy("has_ingot", DataIngredient.tag(ThermalEndergyItemTags.MELODIUM_INGOT).getCritereon(p))
//					.save(p, p.safeId(item.entry))
//			}

	val stellariumUpgrade by REGISTRY.registerObject("endergy_upgrade_3") {
		AugmentItem(
			Properties(),
			AugmentDataHelper.builder()
				.type(NBTTags.TAG_AUGMENT_TYPE_UPGRADE)
				.mod(NBTTags.TAG_AUGMENT_BASE_MOD, 12f)
				.build()
		)
	}
//		registrate.item<ItemCoFH>("endergy_upgrade_3") { props: Properties ->
//			AugmentItem(
//				props,
//				AugmentDataHelper.builder()
//					.type(NBTTags.TAG_AUGMENT_TYPE_UPGRADE)
//					.mod(NBTTags.TAG_AUGMENT_BASE_MOD, 12f)
//					.build()
//			)
//		}
//			.model { item: DataGenContext<Item, ItemCoFH>, p: RegistrateItemModelProvider ->
//				p.generated(
//					item,
//					ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_3"),
//					ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_3_lights"),
//					ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_anim")
//				)
//			}
//			.lang("Stellar Integral Components")
//			.recipe { item: DataGenContext<Item, ItemCoFH>, p: RegistrateRecipeProvider ->
//				ShapedRecipeBuilder.shaped(MISC, item.entry)
//					.pattern("IXI")
//					.pattern("GCG")
//					.pattern("IXI")
//					.define('I', ThermalEndergyItemTags.STELLARIUM_INGOT)
//					.define('C', melodiumUpgrade)
//					.define('G', ItemTags.create(ResourceLocation("forge", "gears/melodium")))
//					.define('X', Blocks.CLAY)
//					.unlockedBy("has_ingot", DataIngredient.tag(ThermalEndergyItemTags.PRISMALIUM_INGOT).getCritereon(p))
//					.save(p, p.safeId(item.entry))
//			}
//			.register()
//	}

	val vibratingCore by REGISTRY.registerObject("vibrating_core") {
		Item(Properties().rarity(Rarity.UNCOMMON))
//		registrate.item<Item>("vibrating_core", ::Item)
//			.lang("Vibrating Core")
//			.recipe { ctx, p ->
//				ShapedRecipeBuilder.shaped(MISC, ctx.entry)
//					.pattern("G  ")
//					.pattern(" E ")
//					.pattern("  G")
//					.define('G', Tags.Items.INGOTS_GOLD)
//					.define('E', Items.ECHO_SHARD)
//					.unlockedBy("has_shard", DataIngredient.items(Items.ECHO_SHARD).getCritereon(p))
//					.save(p, p.safeId(ctx.entry))
//			}
//			.register()
	}

	val melodicRangeAugment by REGISTRY.registerObject("melodic_range_augment") {
		AugmentItem(
			Properties(),
			AugmentDataHelper.builder()
				.type(NBTTags.TAG_AUGMENT_TYPE_AREA_EFFECT)
				.mod(NBTTags.TAG_AUGMENT_RADIUS, 3f)
				.build()
		)
	}
//		registrate.item<ItemCoFH>("melodic_range_augment") { props ->
//			AugmentItem(
//				props,
//				AugmentDataHelper.builder()
//					.type(NBTTags.TAG_AUGMENT_TYPE_AREA_EFFECT)
//					.mod(NBTTags.TAG_AUGMENT_RADIUS, 3f)
//					.build()
//			)
//		}
//			.recipe { ctx, p ->
//				ShapedRecipeBuilder.shaped(MISC, ctx.entry)
//					.pattern(" G ")
//					.pattern("PVP")
//					.pattern(" G ")
//					.define('V', ItemTags.create(ResourceLocation("forge", "gems/diamond")))
//					.define('G', ItemTags.create(ResourceLocation("forge", "gears/enderium")))
//					.define('P', ItemTags.create(ResourceLocation("forge", "ingots/melodium")))
//					.unlockedBy("has_ingot", DataIngredient.tag(ThermalEndergyItemTags.MELODIUM_INGOT).getCritereon(p))
//					.save(p, p.safeId(ctx.entry))
//			}
//			.lang("Extended Range Augment")
//			.register()
//	}

	val dynamoConsumptionNullifier by REGISTRY.registerObject("dynamo_consumption_nullifier_augment") {
		AugmentItem(
			Properties(),
			AugmentDataHelper.builder()
				.type(NBTTags.TAG_AUGMENT_TYPE_DYNAMO)
				.mod(NBTTags.TAG_AUGMENT_DYNAMO_ENERGY, 1.5f)
				.build()
		)
	}
//		registrate.item<ItemCoFH>("dynamo_consumption_nullifier_augment") { props ->
//			AugmentItem(
//				props,
//				AugmentDataHelper.builder()
//					.type(NBTTags.TAG_AUGMENT_TYPE_DYNAMO)
//					.mod(NBTTags.TAG_AUGMENT_DYNAMO_ENERGY, 1.5f)
//					.build()
//			)
//		}
//			.recipe { ctx, p ->
//				ShapedRecipeBuilder.shaped(MISC, ctx.entry)
//					.pattern(" G ")
//					.pattern("PVP")
//					.pattern(" G ")
//					.define('V', ItemTags.create(ResourceLocation("thermal", "glass/hardened")))
//					.define('G', ItemTags.create(ResourceLocation("forge", "gears/lumium")))
//					.define('P', ItemTags.create(ResourceLocation("forge", "plates/melodium")))
//					.unlockedBy("has_ingot", DataIngredient.tag(ThermalEndergyItemTags.MELODIUM_INGOT).getCritereon(p))
//					.save(p, p.safeId(ctx.entry))
//			}
//			.lang("Consumption Nullifier Augment")
//			.register()
//	}

	val dynamoFuelNullifier by REGISTRY.registerObject("dynamo_fuel_nullifier_augment") {
		AugmentItem(
			Properties(),
			AugmentDataHelper.builder()
				.type(NBTTags.TAG_AUGMENT_TYPE_DYNAMO)
				.mod(NBTTags.TAG_AUGMENT_DYNAMO_POWER, 3.0f)
				.mod(NBTTags.TAG_AUGMENT_DYNAMO_ENERGY, 0.8f)
				.build()
		)
	}
//		registrate.item<ItemCoFH>("dynamo_fuel_nullifier_augment") { props ->
//			AugmentItem(
//				props,
//				AugmentDataHelper.builder()
//					.type(NBTTags.TAG_AUGMENT_TYPE_DYNAMO)
//					.mod(NBTTags.TAG_AUGMENT_DYNAMO_POWER, 3.0f)
//					.mod(NBTTags.TAG_AUGMENT_DYNAMO_ENERGY, 0.8f)
//					.build()
//			)
//		}
//			.recipe { ctx, p ->
//				ShapedRecipeBuilder.shaped(MISC, ctx.entry)
//					.pattern(" G ")
//					.pattern("PVP")
//					.pattern(" G ")
//					.define('V', ItemTags.create(ResourceLocation("thermal", "glass/hardened")))
//					.define('G', ItemTags.create(ResourceLocation("forge", "gears/signalum")))
//					.define('P', ItemTags.create(ResourceLocation("forge", "plates/prismalium")))
//					.unlockedBy("has_ingot", DataIngredient.tag(ThermalEndergyItemTags.MELODIUM_INGOT).getCritereon(p))
//					.save(p, p.safeId(ctx.entry))
//			}
//			.lang("Fuel Nullifier Augment")
//			.register()
//	}

	val energyNullifier by REGISTRY.registerObject("energy_nullifier_augment") {
		AugmentItem(
			Properties(),
			AugmentDataHelper.builder()
				.type(NBTTags.TAG_AUGMENT_TYPE_MACHINE)
				.mod(NBTTags.TAG_AUGMENT_MACHINE_POWER, -0.3f)
				.mod(NBTTags.TAG_AUGMENT_MACHINE_ENERGY, 0.5f)
				.build()
		)
	}
//		registrate.item<ItemCoFH>("energy_nullifier_augment") { props ->
//			AugmentItem(
//				props,
//				AugmentDataHelper.builder()
//					.type(NBTTags.TAG_AUGMENT_TYPE_MACHINE)
//					.mod(NBTTags.TAG_AUGMENT_MACHINE_POWER, -0.3f)
//					.mod(NBTTags.TAG_AUGMENT_MACHINE_ENERGY, 0.5f)
//					.build()
//			)
//		}
//			.recipe { ctx, p ->
//				ShapedRecipeBuilder.shaped(MISC, ctx.entry)
//					.pattern(" G ")
//					.pattern("PVP")
//					.pattern(" G ")
//					.define('V', vibratingCore)
//					.define('G', ItemTags.create(ResourceLocation("forge", "gears/lumium")))
//					.define('P', ItemTags.create(ResourceLocation("forge", "plates/melodium")))
//					.unlockedBy("has_ingot", DataIngredient.tag(ThermalEndergyItemTags.MELODIUM_INGOT).getCritereon(p))
//					.save(p, p.safeId(ctx.entry))
//			}
//			.lang("Energy Nullifier Augment")
//			.register()
//	}

	val efficiencyNullifier by REGISTRY.registerObject("efficiency_nullifier_augment") {
		AugmentItem(
			Properties(),
			AugmentDataHelper.builder()
				.type(NBTTags.TAG_AUGMENT_TYPE_MACHINE)
				.mod(NBTTags.TAG_AUGMENT_MACHINE_POWER, 3.0f)
				.mod(NBTTags.TAG_AUGMENT_MACHINE_ENERGY, 1.5f)
				.build()
		)
	}
//		registrate.item<ItemCoFH>("efficiency_nullifier_augment") { props ->
//			AugmentItem(
//				props,
//				AugmentDataHelper.builder()
//					.type(NBTTags.TAG_AUGMENT_TYPE_MACHINE)
//					.mod(NBTTags.TAG_AUGMENT_MACHINE_POWER, 3.0f)
//					.mod(NBTTags.TAG_AUGMENT_MACHINE_ENERGY, 1.5f)
//					.build()
//			)
//		}
//			.recipe { ctx, p ->
//				ShapedRecipeBuilder.shaped(MISC, ctx.entry)
//					.pattern(" G ")
//					.pattern("PVP")
//					.pattern(" G ")
//					.define('V', vibratingCore)
//					.define('G', ItemTags.create(ResourceLocation("forge", "gears/enderium")))
//					.define('P', ItemTags.create(ResourceLocation("forge", "plates/melodium")))
//					.unlockedBy("has_ingot", DataIngredient.tag(ThermalEndergyItemTags.MELODIUM_INGOT).getCritereon(p))
//					.save(p, p.safeId(ctx.entry))
//			}
//			.lang("Efficiency Nullifier Augment")
//			.register()
//	}

	val resonantCatalyst by REGISTRY.registerObject("resonant_catalyst_augment") {
		AugmentItem(
			Properties(),
			AugmentDataHelper.builder()
				.type(NBTTags.TAG_AUGMENT_TYPE_MACHINE)
				.mod(NBTTags.TAG_AUGMENT_MACHINE_CATALYST, 0.15f)
				.mod(NBTTags.TAG_AUGMENT_MACHINE_ENERGY, 1.5f)
				.build()
		)
	}
//		registrate.item<ItemCoFH>("resonant_catalyst_augment") { props ->
//			AugmentItem(
//				props,
//				AugmentDataHelper.builder()
//					.type(NBTTags.TAG_AUGMENT_TYPE_MACHINE)
//					.mod(NBTTags.TAG_AUGMENT_MACHINE_CATALYST, 0.15f)
//					.mod(NBTTags.TAG_AUGMENT_MACHINE_ENERGY, 1.5f)
//					.build()
//			)
//		}
//			.recipe { ctx, p ->
//				ShapedRecipeBuilder.shaped(MISC, ctx.entry)
//					.pattern(" G ")
//					.pattern("PVP")
//					.pattern(" G ")
//					.define('V', vibratingCore)
//					.define('G', ItemTags.create(ResourceLocation("forge", "gears/signalum")))
//					.define('P', ItemTags.create(ResourceLocation("forge", "plates/prismalium")))
//					.unlockedBy("has_ingot", DataIngredient.tag(ThermalEndergyItemTags.MELODIUM_INGOT).getCritereon(p))
//					.save(p, p.safeId(ctx.entry))
//			}
//			.lang("Catalyst Resonation Chamber Augment")
//			.register()
//	}

	private fun registerEndergyAlloy(prefix: String, rarity: Rarity): ObjectHolderDelegate<Item> {
		// Tags
//		val nugget = ItemTags.create(ResourceLocation("forge", "nuggets/$prefix"))
//		val dust = ItemTags.create(ResourceLocation("forge", "dusts/$prefix"))
//		val gear = ItemTags.create(ResourceLocation("forge", "gears/$prefix"))
//		val plate = ItemTags.create(ResourceLocation("forge", "plates/$prefix"))
//		val ingot = ItemTags.create(ResourceLocation("forge", "ingots/$prefix"))
//		val block = ItemTags.create(ResourceLocation("forge", "storage_blocks/$prefix"))
		REGISTRY.registerObject("${prefix}_nugget") {
			ItemCoFH(Properties().rarity(rarity))
		}
//		registrate.item<ItemCoFH>(prefix + "_nugget") { builder: Properties -> ItemCoFH(builder) }
//			.properties { props: Properties -> props.rarity(rarity) }
//			.tag(nugget)
//			.recipe { item: DataGenContext<Item?, ItemCoFH>, p: RegistrateRecipeProvider ->
//				ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, item.entry, 9)
//					.requires(ingot)
//					.unlockedBy("has_ingot", DataIngredient.tag(ingot).getCritereon(p))
//					.save(p, p.safeId(item.entry))
//			}
//			.register()
		REGISTRY.registerObject("${prefix}_dust") {
			ItemCoFH(Properties().rarity(rarity))
		}
//		registrate.item<ItemCoFH>(prefix + "_dust") { builder: Properties -> ItemCoFH(builder) }
//			.properties { props: Properties -> props.rarity(rarity) }
//			.tag(dust)
//			.register()
		REGISTRY.registerObject("${prefix}_gear") {
			ItemCoFH(Properties().rarity(rarity))
		}
//		registrate.item<ItemCoFH>(prefix + "_gear") { builder: Properties -> ItemCoFH(builder) }
//			.properties { props: Properties -> props.rarity(rarity) }
//			.tag(gear)
//			.recipe { item: DataGenContext<Item, ItemCoFH>, p: RegistrateRecipeProvider ->
//				ShapedRecipeBuilder.shaped(RecipeCategory.MISC, item.entry)
//					.pattern(" I ")
//					.pattern("INI")
//					.pattern(" I ")
//					.define('I', ingot)
//					.define('N', Tags.Items.NUGGETS_IRON)
//					.unlockedBy("has_ingot", DataIngredient.tag(ingot).getCritereon(p))
//					.save(p, p.safeId(item.entry))
//			}
//			.register()
		REGISTRY.registerObject("${prefix}_plate") {
			CountedItem(Properties().rarity(rarity))
		}
//		registrate.item<CountedItem>(prefix + "_plate") { builder: Properties -> CountedItem(builder) }
//			.properties { props: Properties -> props.rarity(rarity) }
//			.model { item: DataGenContext<Item, CountedItem>, p: RegistrateItemModelProvider ->
//				getCountModel(
//					p,
//					item,
//					prefix + "_plate",
//					floatArrayOf(0.0f, 0.25f, 0.5f, 1.0f)
//				)
//			}
//			.tag(plate)
//			.register()
		REGISTRY.registerObject("${prefix}_coin") {
			CoinItem(Properties().rarity(rarity))
		}
//		registrate.item<CoinItem>(prefix + "_coin") { builder: Properties -> CoinItem(builder) }
//			.properties { props: Properties -> props.rarity(rarity) }
//			.model { item: DataGenContext<Item, CoinItem>, p: RegistrateItemModelProvider ->
//				getCountModel(
//					p,
//					item,
//					prefix + "_coin",
//					floatArrayOf(0.0f, 0.03125f, 0.25f, 0.5f, 1.0f)
//				)
//			}
//			.register()
		return REGISTRY.registerObject("${prefix}_ingot") {
			ItemCoFH(Properties().rarity(rarity))
		}
//		return registrate.item<ItemCoFH>(prefix + "_ingot") { builder: Properties -> ItemCoFH(builder) }
//			.properties { props: Properties -> props.rarity(rarity) }
//			.tag(ingot)
//			.recipe { item: DataGenContext<Item, ItemCoFH>, p: RegistrateRecipeProvider ->
//				SimpleCookingRecipeBuilder.smelting(Ingredient.of(dust), RecipeCategory.MISC, item.entry, 0f, 200)
//					.unlockedBy("has_dust", DataIngredient.tag(dust).getCritereon(p))
//					.save(p, ResourceLocation(p.safeId(item.entry).namespace, p.safeId(item.entry).path + "_from_dust"))
//				ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, item.entry)
//					.requires(Ingredient.of(nugget), 9)
//					.unlockedBy("has_ingot", DataIngredient.tag(ingot).getCritereon(p))
//					.save(p, p.safeId(item.entry))
//				ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, item.entry, 9)
//					.requires(block)
//					.unlockedBy("has_block", DataIngredient.tag(block).getCritereon(p))
//					.save(p, ResourceLocation(p.safeId(item.entry).namespace, p.safeId(item.entry).path + "_from_block"))
//			}
	}

//	private fun getCountModel(
//		p: RegistrateItemModelProvider,
//		item: DataGenContext<Item, *>,
//		name: String,
//		counts: FloatArray
//	) {
//		var prov = p.generated(item, ResourceLocation(ThermalEndergy.MODID, "item/" + name + "_0"))
//		for (i in counts.indices) {
//			prov = prov.override()
//				.predicate(countPredicate, counts[i])
//				.model(
//					p.getBuilder(p.name(item) + "_" + i)
//						.parent(UncheckedModelFile("item/generated"))
//						.texture("layer0", ResourceLocation(ThermalEndergy.MODID, "item/" + name + "_" + i))
//				)
//				.end()
//		}
//	}
}
