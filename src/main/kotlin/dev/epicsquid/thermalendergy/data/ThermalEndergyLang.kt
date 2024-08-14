package dev.epicsquid.thermalendergy.data

import dev.epicsquid.thermalendergy.ThermalEndergy
import dev.epicsquid.thermalendergy.registry.BlockRegistry
import dev.epicsquid.thermalendergy.registry.ItemRegistry
import net.minecraft.data.PackOutput
import net.minecraftforge.common.data.LanguageProvider

class ThermalEndergyLang(
	output: PackOutput,
	locale: String
) : LanguageProvider(output, ThermalEndergy.MODID, locale) {

	override fun addTranslations() {
		add(BlockRegistry.melodiumBlock, "Melodium Block")
		add(BlockRegistry.prismaliumBlock, "Prismalium Block")
		add(BlockRegistry.stellariumBlock, "Stellarium Block")

		add("itemGroup.${ThermalEndergy.MODID}", "Thermal Endergy")

		alloy("prismalium")
		alloy("melodium")
		alloy("stellarium")

		add(ItemRegistry.prismaliumUpgrade, "Pristine Integral Components")
		add(ItemRegistry.melodiumUpgrade, "Melodic Integral Components")
		add(ItemRegistry.stellariumUpgrade, "Stellar Integral Components")
		add(ItemRegistry.vibratingCore, "Vibrating Core")
		add(ItemRegistry.melodicRangeAugment, "Extended Range Augment")
		add(ItemRegistry.dynamoConsumptionNullifier, "Consumption Nullifier Augment")
		add(ItemRegistry.dynamoFuelNullifier, "Fuel Nullifier Augment")
		add(ItemRegistry.energyNullifier, "Energy Nullifier Augment")
		add(ItemRegistry.efficiencyNullifier, "Efficiency Nullifier Augment")
		add(ItemRegistry.resonantCatalyst, "Catalyst Resonation Chamber Augment")
	}

	private fun alloy(name: String) {
		alloy(name, "ingot")
		alloy(name, "nugget")
		alloy(name, "dust")
		alloy(name, "gear")
		alloy(name, "plate")
		alloy(name, "coin")
	}

	private fun alloy(name: String, suffix: String) {
		add("item.${ThermalEndergy.MODID}.${name}_$suffix", "${name.capitalize()} ${suffix.capitalize()}")
	}
}