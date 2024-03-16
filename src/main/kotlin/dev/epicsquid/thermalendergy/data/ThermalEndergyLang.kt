package dev.epicsquid.thermalendergy.data

import dev.epicsquid.thermalendergy.ThermalEndergy
import dev.epicsquid.thermalendergy.registry.BlockRegistry
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
	}
}