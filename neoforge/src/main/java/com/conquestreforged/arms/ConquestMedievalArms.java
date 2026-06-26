package com.conquestreforged.arms;


import com.conquestreforged.arms.init.BlockInit;
import com.conquestreforged.arms.init.ItemInit;
import com.conquestreforged.arms.items.armor.ArmorModelItem;
import com.conquestreforged.arms.items.armor.ModArmorRenderer;
import com.conquestreforged.arms.items.armor.VanillaHelmetItem;
import com.conquestreforged.arms.items.armor.VanillaHelmetRenderer;
import com.conquestreforged.arms.items.armor.materials.ModArmorMaterials;
import com.conquestreforged.arms.recipe.ModRecipeSerializer;
import com.conquestreforged.arms.recipe.ModRecipeType;
import com.conquestreforged.arms.screens.ArmorStationScreen;
import com.conquestreforged.arms.screens.ModScreenHandlerType;
import com.conquestreforged.arms.util.ModItemProperties;
import mod.azure.azurelib.common.render.armor.AzArmorRendererRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(value = "conquest_armory")
public class ConquestMedievalArms {
    public static final String MOD_ID = "conquest_armory";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public ConquestMedievalArms(IEventBus modEventBus) {
        modEventBus.addListener(this::clientSetup);

        ItemInit.REGISTER.register(modEventBus);
        BlockInit.BLOCKS.register(modEventBus);
        ModArmorMaterials.ARMORMATERIALS.register(modEventBus);
        ModScreenHandlerType.MENUS.register(modEventBus);
        ModRecipeSerializer.register(modEventBus);
        ModRecipeType.register(modEventBus);

        modEventBus.addListener(this::addItemsToGroup);
        modEventBus.addListener(this::registerScreens);
    }

    public void addItemsToGroup(BuildCreativeModeTabContentsEvent event) {
        ConquestMedievalArms.LOGGER.info("Registering Conquest Medieval Arms items.");
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            ItemInit.REGISTER.getEntries().stream().forEach(item -> {
                event.accept(item.get());
            });
        }
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ModItemProperties.addCustomItemProperties();

        BuiltInRegistries.ITEM.stream().filter(block -> BuiltInRegistries.ITEM.getKey(block).getNamespace().equals("conquest_armory")).forEach(item -> {
            if (item instanceof ArmorModelItem armorModelItem) {
                System.out.println("Found armor item: " + BuiltInRegistries.ITEM.getKey(item));

                switch (armorModelItem.getType()) {
                    case ArmorItem.Type.HELMET -> AzArmorRendererRegistry.register(() -> new ModArmorRenderer("helmet_generic", armorModelItem.getArmorTexture()), armorModelItem);
                    case ArmorItem.Type.CHESTPLATE -> AzArmorRendererRegistry.register(() -> new ModArmorRenderer("chestplate_generic", armorModelItem.getArmorTexture()), armorModelItem);
                    case ArmorItem.Type.LEGGINGS -> AzArmorRendererRegistry.register(() -> new ModArmorRenderer("leggings_generic", armorModelItem.getArmorTexture()), armorModelItem);
                    case ArmorItem.Type.BOOTS -> AzArmorRendererRegistry.register(() -> new ModArmorRenderer("boots_generic", armorModelItem.getArmorTexture()), armorModelItem);
                }
            }
            if (item instanceof VanillaHelmetItem vanillaHelmetItem) {
                if (vanillaHelmetItem.getType() == ArmorItem.Type.HELMET) {
                    AzArmorRendererRegistry.register(() -> new VanillaHelmetRenderer("helmet_vanilla", vanillaHelmetItem.getArmorTexture()), vanillaHelmetItem);
                }
            }
        });

    }

    private void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ModScreenHandlerType.ARMS_STATION_SCREEN, ArmorStationScreen::new);
    }
}
