package com.conquestreforged.arms;


import com.conquestreforged.arms.init.BlockInit;
import com.conquestreforged.arms.init.ItemInit;
import com.conquestreforged.arms.items.armor.ArmorModelItem;
import com.conquestreforged.arms.items.armor.VanillaHelmetItem;
import com.conquestreforged.arms.recipe.ModRecipeSerializer;
import com.conquestreforged.arms.recipe.ModRecipeType;
import com.conquestreforged.arms.screens.ModScreenHandlerType;
import mod.azure.azurelib.common.animation.cache.AzIdentityRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.registries.BuiltInRegistries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConquestMedievalArms implements ModInitializer {
    public static final String MOD_ID = "conquest_armory";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ItemInit.registerModItems();
        BlockInit.registerModBlocks();
        ModRecipeType.register();
        ModRecipeSerializer.register();
        ModScreenHandlerType.register();
        BuiltInRegistries.ITEM.stream()
                .filter(item -> item instanceof ArmorModelItem || item instanceof VanillaHelmetItem)
                .forEach(AzIdentityRegistry::register);
        //AttackEntityCallback.EVENT.register(new AttackEntityHandler());
    }
}
