package dev.epicsquid.thermalendergy.registry

import dev.epicsquid.thermalendergy.ThermalEndergy
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.RegistryObject

object CreativeTabsRegistry {

	private val registrate = ThermalEndergy.registrate

	private val register: DeferredRegister<CreativeModeTab> =
		DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ThermalEndergy.MODID)

	val tab: RegistryObject<CreativeModeTab> = register.register("base") {
		CreativeModeTab.builder()
			.icon { ItemStack(BlockRegistry.stellariumBlock.get()) }
			.title(Component.translatable("itemGroup." + ThermalEndergy.MODID))
			.displayItems { _, output ->
				registrate.getAll(Registries.ITEM).forEach { output.accept(it.get()) }
			}
			.build()
	}

	fun register(modEventBus: IEventBus) {
		modEventBus.register(register)
	}
}