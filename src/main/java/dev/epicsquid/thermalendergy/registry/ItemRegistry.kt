package dev.epicsquid.thermalendergy.registry

import cofh.core.item.CoinItem
import cofh.core.item.CountedItem
import cofh.core.item.ItemCoFH
import cofh.core.util.helpers.AugmentDataHelper
import cofh.lib.util.constants.NBTTags
import cofh.thermal.lib.common.ThermalFlags
import cofh.thermal.lib.item.AugmentItem
import com.tterrag.registrate.Registrate
import com.tterrag.registrate.builders.ItemBuilder
import com.tterrag.registrate.providers.DataGenContext
import com.tterrag.registrate.providers.RegistrateItemModelProvider
import com.tterrag.registrate.providers.RegistrateRecipeProvider
import com.tterrag.registrate.util.DataIngredient
import dev.epicsquid.thermalendergy.ThermalEndergy
import dev.epicsquid.thermalendergy.data.ThermalEndergyTags
import dev.epicsquid.thermalendergy.utils.registryEntry
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.data.recipes.ShapelessRecipeBuilder
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.ItemTags
import net.minecraft.world.item.*
import net.minecraft.world.item.Item.Properties
import net.minecraft.world.item.Rarity.RARE
import net.minecraft.world.item.Rarity.UNCOMMON
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.level.block.Blocks
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile
import net.minecraftforge.common.Tags.Items

object ItemRegistry {
	private val countPredicate = ResourceLocation("count")
	private val registrate = ThermalEndergy.registrate

	val prismaliumIngot = registerEndergyAlloy("prismalium", UNCOMMON).register()
	val melodiumIngot = registerEndergyAlloy("melodium", RARE).register()
	val stellariumIngot = registerEndergyAlloy("stellarium", RARE).register()

	val prismaliumUpgrade: ItemCoFH by registryEntry {
		registrate.item<ItemCoFH>("endergy_upgrade_1") { props: Properties ->
			AugmentItem(
				props,
				AugmentDataHelper.builder()
					.type(NBTTags.TAG_AUGMENT_TYPE_UPGRADE)
					.mod(NBTTags.TAG_AUGMENT_BASE_MOD, 6.0f)
					.build()
			).setShowInGroups(ThermalFlags.getFlag(ThermalFlags.FLAG_UPGRADE_AUGMENTS))
		}
			.tab { ThermalEndergy.tab }
			.model { item: DataGenContext<Item, ItemCoFH>, p: RegistrateItemModelProvider ->
				p.generated(
					item,
					ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_1"),
					ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_1_lights"),
					ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_anim")
				)
			}
			.lang("Pristine Integral Components")
			.recipe { item: DataGenContext<Item, ItemCoFH>, p: RegistrateRecipeProvider ->
				ShapedRecipeBuilder.shaped(item.entry)
					.pattern("IXI")
					.pattern("GCG")
					.pattern("IXI")
					.define('I', ThermalEndergyTags.prismaliumIngot)
					.define('C', ThermalEndergyTags.upgrade3)
					.define('G', ItemTags.create(ResourceLocation("forge", "gears/enderium")))
					.define('X', net.minecraft.world.item.Items.ENDER_EYE)
					.unlockedBy("has_ingot", DataIngredient.tag(ThermalEndergyTags.prismaliumIngot).getCritereon(p))
					.save(p, p.safeId(item.entry))
			}
			.register()
	}

	val melodiumUpgrade: ItemCoFH by registryEntry {
		registrate.item<ItemCoFH>("endergy_upgrade_2") { props: Properties ->
			AugmentItem(
				props,
				AugmentDataHelper.builder()
					.type(NBTTags.TAG_AUGMENT_TYPE_UPGRADE)
					.mod(NBTTags.TAG_AUGMENT_BASE_MOD, 8.5f)
					.build()
			).setShowInGroups(ThermalFlags.getFlag(ThermalFlags.FLAG_UPGRADE_AUGMENTS))
		}
			.tab { ThermalEndergy.tab }
			.model { item: DataGenContext<Item, ItemCoFH>, p: RegistrateItemModelProvider ->
				p.generated(
					item,
					ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_2"),
					ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_2_lights"),
					ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_anim")
				)
			}
			.lang("Melodic Integral Components")
			.recipe { item: DataGenContext<Item?, ItemCoFH>, p: RegistrateRecipeProvider ->
				ShapedRecipeBuilder.shaped(item.entry)
					.pattern("IXI")
					.pattern("GCG")
					.pattern("IXI")
					.define('I', ThermalEndergyTags.melodiumIngot)
					.define('C', prismaliumUpgrade)
					.define('G', ItemTags.create(ResourceLocation("forge", "gears/prismalium")))
					.define('X', net.minecraft.world.item.Items.SHULKER_SHELL)
					.unlockedBy("has_ingot", DataIngredient.tag(ThermalEndergyTags.Companion.melodiumIngot).getCritereon(p))
					.save(p, p.safeId(item.entry))
			}
			.register()
	}

	val stellariumUpgrade: ItemCoFH by registryEntry {
		registrate.item<ItemCoFH>("endergy_upgrade_3") { props: Properties ->
			AugmentItem(
				props,
				AugmentDataHelper.builder()
					.type(NBTTags.TAG_AUGMENT_TYPE_UPGRADE)
					.mod(NBTTags.TAG_AUGMENT_BASE_MOD, 12f)
					.build()
			).setShowInGroups(ThermalFlags.getFlag(ThermalFlags.FLAG_UPGRADE_AUGMENTS))
		}
			.tab { ThermalEndergy.tab }
			.model { item: DataGenContext<Item, ItemCoFH>, p: RegistrateItemModelProvider ->
				p.generated(
					item,
					ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_3"),
					ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_3_lights"),
					ResourceLocation(ThermalEndergy.MODID, "item/endergy_upgrade_anim")
				)
			}
			.lang("Stellar Integral Components")
			.recipe { item: DataGenContext<Item, ItemCoFH>, p: RegistrateRecipeProvider ->
				ShapedRecipeBuilder.shaped(item.entry)
					.pattern("IXI")
					.pattern("GCG")
					.pattern("IXI")
					.define('I', ThermalEndergyTags.stellariumIngot)
					.define('C', melodiumUpgrade)
					.define('G', ItemTags.create(ResourceLocation("forge", "gears/melodium")))
					.define('X', Blocks.CLAY)
					.unlockedBy("has_ingot", DataIngredient.tag(ThermalEndergyTags.prismaliumIngot).getCritereon(p))
					.save(p, p.safeId(item.entry))
			}
			.register()
	}

	val melodicRangeAugment: ItemCoFH by registryEntry {
		registrate.item<ItemCoFH>("melodium_range_augment") {props ->
			AugmentItem(
				props,
				AugmentDataHelper.builder()
					.type(NBTTags.TAG_AUGMENT_TYPE_AREA_EFFECT)
					.mod(NBTTags.TAG_AUGMENT_RADIUS, 3f)
					.build()
			).setShowInGroups(ThermalFlags.getFlag(ThermalFlags.FLAG_AREA_AUGMENTS))
		}
			.lang("Melodic Range Augment")
			.register()
	}

	private fun registerEndergyAlloy(prefix: String, rarity: Rarity): ItemBuilder<ItemCoFH, Registrate> {
		// Tags
		val nugget = ItemTags.create(ResourceLocation("forge", "nuggets/$prefix"))
		val dust = ItemTags.create(ResourceLocation("forge", "dusts/$prefix"))
		val gear = ItemTags.create(ResourceLocation("forge", "gears/$prefix"))
		val plate = ItemTags.create(ResourceLocation("forge", "plates/$prefix"))
		val ingot = ItemTags.create(ResourceLocation("forge", "ingots/$prefix"))
		val block = ItemTags.create(ResourceLocation("forge", "storage_blocks/$prefix"))
		registrate.item<ItemCoFH>(prefix + "_nugget") { builder: Properties -> ItemCoFH(builder) }
			.properties { props: Properties -> props.tab(ThermalEndergy.tab).rarity(rarity) }
			.tag(nugget)
			.recipe { item: DataGenContext<Item?, ItemCoFH>, p: RegistrateRecipeProvider ->
				ShapelessRecipeBuilder.shapeless(item.entry, 9)
					.requires(ingot)
					.unlockedBy("has_ingot", DataIngredient.tag(ingot).getCritereon(p))
					.save(p, p.safeId(item.entry))
			}
			.register()
		registrate.item<ItemCoFH>(prefix + "_dust") { builder: Properties -> ItemCoFH(builder) }
			.properties { props: Properties -> props.tab(ThermalEndergy.tab).rarity(rarity) }
			.tag(dust)
			.register()
		registrate.item<ItemCoFH>(prefix + "_gear") { builder: Properties -> ItemCoFH(builder) }
			.properties { props: Properties -> props.tab(ThermalEndergy.tab).rarity(rarity) }
			.tag(gear)
			.recipe { item: DataGenContext<Item, ItemCoFH>, p: RegistrateRecipeProvider ->
				ShapedRecipeBuilder.shaped(item.entry)
					.pattern(" I ")
					.pattern("INI")
					.pattern(" I ")
					.define('I', ingot)
					.define('N', Items.NUGGETS_IRON)
					.unlockedBy("has_ingot", DataIngredient.tag(ingot).getCritereon(p))
					.save(p, p.safeId(item.entry))
			}
			.register()
		registrate.item<CountedItem>(prefix + "_plate") { builder: Properties -> CountedItem(builder) }
			.properties { props: Properties -> props.tab(ThermalEndergy.tab).rarity(rarity) }
			.model { item: DataGenContext<Item, CountedItem>, p: RegistrateItemModelProvider ->
				getCountModel(
					p,
					item,
					prefix + "_plate",
					floatArrayOf(0.0f, 0.25f, 0.5f, 1.0f)
				)
			}
			.tag(plate)
			.register()
		registrate.item<CoinItem>(prefix + "_coin") { builder: Properties -> CoinItem(builder) }
			.properties { props: Properties -> props.tab(ThermalEndergy.tab).rarity(rarity) }
			.model { item: DataGenContext<Item, CoinItem>, p: RegistrateItemModelProvider ->
				getCountModel(
					p,
					item,
					prefix + "_coin",
					floatArrayOf(0.0f, 0.03125f, 0.25f, 0.5f, 1.0f)
				)
			}
			.register()
		return registrate.item<ItemCoFH>(prefix + "_ingot") { builder: Properties -> ItemCoFH(builder) }
			.properties { props: Properties -> props.tab(ThermalEndergy.tab).rarity(rarity) }
			.tag(ingot)
			.recipe { item: DataGenContext<Item, ItemCoFH>, p: RegistrateRecipeProvider ->
				SimpleCookingRecipeBuilder.smelting(Ingredient.of(dust), item.entry, 0f, 200)
					.unlockedBy("has_dust", DataIngredient.tag(dust).getCritereon(p))
					.save(p, ResourceLocation(p.safeId(item.entry).namespace, p.safeId(item.entry).path + "_from_dust"))
				ShapelessRecipeBuilder.shapeless(item.entry)
					.requires(Ingredient.of(nugget), 9)
					.unlockedBy("has_ingot", DataIngredient.tag(ingot).getCritereon(p))
					.save(p, p.safeId(item.entry))
				ShapelessRecipeBuilder.shapeless(item.entry, 9)
					.requires(block)
					.unlockedBy("has_block", DataIngredient.tag(block).getCritereon(p))
					.save(p, ResourceLocation(p.safeId(item.entry).namespace, p.safeId(item.entry).path + "_from_block"))
			}
	}

	private fun getCountModel(
		p: RegistrateItemModelProvider,
		item: DataGenContext<Item, *>,
		name: String,
		counts: FloatArray
	) {
		var prov = p.generated(item, ResourceLocation(ThermalEndergy.MODID, "item/" + name + "_0"))
		for (i in counts.indices) {
			prov = prov.override()
				.predicate(countPredicate, counts[i])
				.model(
					p.getBuilder(p.name(item) + "_" + i)
						.parent(UncheckedModelFile("item/generated"))
						.texture("layer0", ResourceLocation(ThermalEndergy.MODID, "item/" + name + "_" + i))
				)
				.end()
		}
	}

	fun classload() {}
}
