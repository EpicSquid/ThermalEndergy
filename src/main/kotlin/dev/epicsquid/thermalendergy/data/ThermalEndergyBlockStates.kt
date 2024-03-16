package dev.epicsquid.thermalendergy.data

import dev.epicsquid.thermalendergy.ThermalEndergy
import dev.epicsquid.thermalendergy.registry.BlockRegistry
import net.minecraft.data.PackOutput
import net.minecraftforge.client.model.generators.BlockStateProvider
import net.minecraftforge.common.data.ExistingFileHelper

class ThermalEndergyBlockStates(
	output: PackOutput,
	exFileHelper: ExistingFileHelper
) : BlockStateProvider(output, ThermalEndergy.MODID, exFileHelper) {

	override fun registerStatesAndModels() {
		simpleBlock(BlockRegistry.prismaliumBlock)
		simpleBlock(BlockRegistry.melodiumBlock)
		simpleBlock(BlockRegistry.stellariumBlock)
	}
}