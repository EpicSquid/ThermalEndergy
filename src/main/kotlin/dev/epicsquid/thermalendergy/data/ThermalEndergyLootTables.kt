package dev.epicsquid.thermalendergy.data

import dev.epicsquid.thermalendergy.ThermalEndergy
import dev.epicsquid.thermalendergy.registry.BlockRegistry
import net.minecraft.data.loot.packs.VanillaBlockLoot
import net.minecraft.world.level.block.Block
import net.minecraftforge.registries.ForgeRegistries
import java.util.stream.Collectors


class ThermalEndergyLootTables : VanillaBlockLoot() {

	override fun generate() {
		dropSelf(BlockRegistry.melodiumBlock)
		dropSelf(BlockRegistry.prismaliumBlock)
		dropSelf(BlockRegistry.stellariumBlock)
	}

	override fun getKnownBlocks(): MutableIterable<Block> {
		return ForgeRegistries.BLOCKS.entries.stream()
			.filter { it.key.location().namespace == ThermalEndergy.MODID }
			.map { it.value }
			.collect(Collectors.toList())
	}
}