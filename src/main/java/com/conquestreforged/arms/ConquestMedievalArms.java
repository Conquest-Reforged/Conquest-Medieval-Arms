package com.conquestreforged.arms;


import com.conquestreforged.arms.init.BlockInit;
import com.conquestreforged.arms.init.ItemInit;
import com.conquestreforged.arms.network.NetworkHandler;
import com.conquestreforged.arms.recipe.ModRecipeSerializer;
import com.conquestreforged.arms.recipe.ModRecipeType;
import com.conquestreforged.arms.screens.ArmorStationScreen;
import com.conquestreforged.arms.screens.ModScreenHandlerType;
import com.conquestreforged.arms.util.ModItemProperties;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.item.ItemGroups;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod("conquest_armory")
public class ConquestMedievalArms {
    public static final String MOD_ID = "conquest_armory";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public ConquestMedievalArms() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);

        ItemInit.REGISTER.register(bus);
        BlockInit.BLOCKS.register(bus);
        ModScreenHandlerType.MENUS.register(bus);
        ModRecipeSerializer.register(bus);
        ModRecipeType.register(bus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        bus.addListener(this::addItemsToGroup);
    }

    public void addItemsToGroup(BuildCreativeModeTabContentsEvent event) {
        ConquestMedievalArms.LOGGER.info("Registering Conquest Medieval Arms items.");
        if (event.getTabKey() == ItemGroups.COMBAT) {
            ItemInit.REGISTER.getEntries().stream().forEach(item -> {
                event.accept(item);
            });
        }
    }

    private void onSetup(FMLCommonSetupEvent ev) {
        ev.enqueueWork(() -> {
            //NetworkHandler.init();
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ModItemProperties.addCustomItemProperties();
        HandledScreens.register(ModScreenHandlerType.ARMS_STATION_SCREEN.get(), ArmorStationScreen::new);
    }
}
