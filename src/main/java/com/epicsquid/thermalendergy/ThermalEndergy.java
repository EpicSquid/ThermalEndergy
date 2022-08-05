package com.epicsquid.thermalendergy;

import com.epicsquid.thermalendergy.init.ThermalEndergyItems;
import com.mojang.logging.LogUtils;
import com.tterrag.registrate.Registrate;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import javax.annotation.Nonnull;
import java.util.stream.Collectors;

@Mod(ThermalEndergy.MODID)
public class ThermalEndergy
{
    public static final String MODID = "thermalendergy";

    private static final Lazy<Registrate> REGISTRATE = Lazy.of(() -> Registrate.create(MODID));

    public static final CreativeModeTab CREATIVE_TAB = new CreativeModeTab(ThermalEndergy.MODID) {
        @Override
        @Nonnull
        public ItemStack makeIcon() {
            return new ItemStack(ThermalEndergyItems.STELLARIUM_INGOT.get());
        }
    };

    public ThermalEndergy()
    {
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Init items
        ThermalEndergyItems.classload();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }

    public static Registrate registrate() {
        return REGISTRATE.get();
    }
}
