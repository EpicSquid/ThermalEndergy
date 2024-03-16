package dev.epicsquid.thermalendergy.data

import dev.epicsquid.thermalendergy.ThermalEndergy
import dev.epicsquid.thermalendergy.registry.BlockRegistry
import net.minecraft.data.PackOutput
import net.minecraft.world.level.block.Block
import net.minecraftforge.client.model.generators.BlockStateProvider
import net.minecraftforge.common.data.ExistingFileHelper

class ThermalEndergyBlockStates(
	output: PackOutput,
	exFileHelper: ExistingFileHelper
) : BlockStateProvider(output, ThermalEndergy.MODID, exFileHelper) {

	override fun registerStatesAndModels() {
		BlockRegistry.REGISTRY.entries.forEach {
			simpleBlock(it.get())
		}
	}
}