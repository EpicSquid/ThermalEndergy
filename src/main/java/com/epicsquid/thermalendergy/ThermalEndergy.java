package com.epicsquid.thermalendergy;

import com.epicsquid.thermalendergy.init.ThermalEndergyBlocks;
import com.epicsquid.thermalendergy.init.ThermalEndergyItems;
import com.epicsquid.thermalendergy.init.ThermalEndergyLang;
import com.epicsquid.thermalendergy.init.ThermalEndergyTags;
import com.tterrag.registrate.Registrate;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ForgeBlockTagsProvider;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import javax.annotation.Nonnull;

@Mod(ThermalEndergy.MODID)
public class ThermalEndergy {
	public static final String MODID = "thermalendergy";

	private static final Lazy<Registrate> REGISTRATE = Lazy.of(() -> Registrate.create(MODID));

	public static final CreativeModeTab CREATIVE_TAB = new CreativeModeTab(ThermalEndergy.MODID) {
		@Override
		@Nonnull
		public ItemStack makeIcon() {
			return new ItemStack(ThermalEndergyBlocks.STELLARIUM_BLOCK.get());
		}
	};

	public ThermalEndergy() {
		// Register the setup method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::gatherData);

		// Init items
		ThermalEndergyBlocks.classload();
		ThermalEndergyItems.classload();
		ThermalEndergyLang.classload();

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);
	}

	public void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		ForgeBlockTagsProvider b = new ForgeBlockTagsProvider(generator, event.getExistingFileHelper());
		generator.addProvider(event.includeServer(), new ThermalEndergyTags(generator, b, event.getExistingFileHelper()));
	}

	private void setup(final FMLCommonSetupEvent event) {

	}

	public static Registrate registrate() {
		return REGISTRATE.get();
	}
}
