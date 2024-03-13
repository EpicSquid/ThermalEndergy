package dev.epicsquid.thermalendergy.utils

import com.tterrag.registrate.AbstractRegistrate
import net.minecraftforge.eventbus.api.IEventBus
import thedarkcolour.kotlinforforge.forge.MOD_BUS

class ThermalEndergyRegistrate(modId: String) : AbstractRegistrate<ThermalEndergyRegistrate>(modId) {

	companion object {
		fun create(modId: String): ThermalEndergyRegistrate {
			return ThermalEndergyRegistrate(modId)
		}
	}

	override fun getModEventBus(): IEventBus {
		return MOD_BUS
	}
}