package dev.epicsquid.thermalendergy.data

import dev.epicsquid.thermalendergy.ThermalEndergy
import dev.epicsquid.thermalendergy.registry.ItemRegistry
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.ItemLike
import net.minecraftforge.client.model.generators.ItemModelProvider
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile
import net.minecraftforge.common.data.ExistingFileHelper
import net.minecraftforge.registries.ForgeRegistries

class ThermalEndergyItemModels(
	output: PackOutput,
	existingFileHelper: ExistingFileHelper
) : ItemModelProvider(output, ThermalEndergy.MODID, existingFileHelper) {

	override fun registerModels() {
		block(ItemRegistry.prismaliumBlock)
		block(ItemRegistry.melodiumBlock)
		block(ItemRegistry.stellariumBlock)

		alloy("prismalium")
		alloy("melodium")
		alloy("stellarium")

		upgrade(ItemRegistry.prismaliumUpgrade)
		upgrade(ItemRegistry.melodiumUpgrade)
		upgrade(ItemRegistry.stellariumUpgrade)

		generated(ItemRegistry.vibratingCore)
		generated(ItemRegistry.melodicRangeAugment)
		generated(ItemRegistry.dynamoConsumptionNullifier)
		generated(ItemRegistry.dynamoFuelNullifier)
		generated(ItemRegistry.energyNullifier)
		generated(ItemRegistry.efficiencyNullifier)
		generated(ItemRegistry.resonantCatalyst)
	}

	private fun name(item: ItemLike): String {
		return ForgeRegistries.ITEMS.getKey(item.asItem())!!.path
	}

	private fun alloy(name: String) {
		alloy(name, "ingot")
		alloy(name, "nugget")
		alloy(name, "dust")
		alloy(name, "gear")
		count(name, "plate", floatArrayOf(0.0f, 0.25f, 0.5f, 1.0f))
		count(name, "coin", floatArrayOf(0.0f, 0.03125f, 0.25f, 0.5f, 1.0f))
	}

	private fun alloy(name: String, suffix: String) {
		getBuilder("${name}_$suffix")
			.parent(UncheckedModelFile("item/generated"))
			.texture("layer0", modLoc("item/${name}_$suffix"))
	}


	private val countPredicate = ResourceLocation("count")

	private fun count(
		name: String,
		suffix: String,
		counts: FloatArray
	) {
		var prov = getBuilder("${name}_$suffix")
			.parent(UncheckedModelFile("item/generated"))
			.texture("layer0", modLoc("item/${name}_${suffix}_0"))
		for (i in counts.indices) {
			prov = prov.override()
				.predicate(countPredicate, counts[i])
				.model(
					getBuilder("item/${name}_${suffix}_$i")
						.parent(UncheckedModelFile("item/generated"))
						.texture("layer0", modLoc("item/${name}_${suffix}_$i"))
				)
				.end()
		}
	}

	private fun upgrade(item: ItemLike) {
		getBuilder(name(item))
			.parent(UncheckedModelFile("item/generated"))
			.texture("layer0", modLoc("item/${name(item)}"))
			.texture("layer1", modLoc("item/${name(item)}_lights"))
			.texture("layer2", modLoc("item/endergy_upgrade_anim"))
	}

	private fun block(item: ItemLike) {
		withExistingParent(
			name(item),
			modLoc("block/${name(item)}")
		)
	}

	private fun generated(item: ItemLike) {
		generated(name(item))
	}

	private fun generated(name: String) {
		getBuilder(name)
			.parent(UncheckedModelFile("item/generated"))
			.texture("layer0", modLoc("item/$name"))
	}
}