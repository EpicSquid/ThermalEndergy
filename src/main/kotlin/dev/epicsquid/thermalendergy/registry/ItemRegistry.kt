package dev.epicsquid.thermalendergy.registry

import cofh.core.common.item.CoinItem
import cofh.core.common.item.CountedItem
import cofh.core.common.item.ItemCoFH
import cofh.core.util.helpers.AugmentDataHelper
import cofh.lib.util.constants.NBTTags
import cofh.thermal.lib.common.item.AugmentItem
import dev.epicsquid.thermalendergy.ThermalEndergy
import net.minecraft.core.registries.Registries
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

	val prismaliumIngot by registerEndergyAlloy("prismalium", UNCOMMON)
	val melodiumIngot by registerEndergyAlloy("melodium", RARE)
	val stellariumIngot by registerEndergyAlloy("stellarium", RARE)

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

	val melodiumUpgrade by REGISTRY.registerObject("endergy_upgrade_2") {
		AugmentItem(
			Properties(),
			AugmentDataHelper.builder()
				.type(NBTTags.TAG_AUGMENT_TYPE_UPGRADE)
				.mod(NBTTags.TAG_AUGMENT_BASE_MOD, 8.5f)
				.build()
		)
	}

	val stellariumUpgrade by REGISTRY.registerObject("endergy_upgrade_3") {
		AugmentItem(
			Properties(),
			AugmentDataHelper.builder()
				.type(NBTTags.TAG_AUGMENT_TYPE_UPGRADE)
				.mod(NBTTags.TAG_AUGMENT_BASE_MOD, 12f)
				.build()
		)
	}

	val vibratingCore by REGISTRY.registerObject("vibrating_core") {
		Item(Properties().rarity(Rarity.UNCOMMON))
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

	val dynamoConsumptionNullifier by REGISTRY.registerObject("dynamo_consumption_nullifier_augment") {
		AugmentItem(
			Properties(),
			AugmentDataHelper.builder()
				.type(NBTTags.TAG_AUGMENT_TYPE_DYNAMO)
				.mod(NBTTags.TAG_AUGMENT_DYNAMO_ENERGY, 1.5f)
				.build()
		)
	}

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

	private fun registerEndergyAlloy(prefix: String, rarity: Rarity): ObjectHolderDelegate<Item> {
		REGISTRY.registerObject("${prefix}_nugget") {
			ItemCoFH(Properties().rarity(rarity))
		}
		REGISTRY.registerObject("${prefix}_dust") {
			ItemCoFH(Properties().rarity(rarity))
		}
		REGISTRY.registerObject("${prefix}_gear") {
			ItemCoFH(Properties().rarity(rarity))
		}
		REGISTRY.registerObject("${prefix}_plate") {
			CountedItem(Properties().rarity(rarity))
		}
		REGISTRY.registerObject("${prefix}_coin") {
			CoinItem(Properties().rarity(rarity))
		}
		return REGISTRY.registerObject("${prefix}_ingot") {
			ItemCoFH(Properties().rarity(rarity))
		}
	}
}
