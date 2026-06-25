package com.conquestreforged.arms.datagen;

import com.conquestreforged.arms.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.world.item.*;

public class ModItemModelProvider extends FabricModelProvider {

    public ModItemModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        ItemInit.dataGenItemModels.forEach(registryItem -> {
            Item item = registryItem.asItem();
            if (item instanceof SwordItem) {
                //swordItem(item);
            } else if (item instanceof AxeItem) {
                //axeItem(item);
            } else if (item instanceof ShieldItem) {
                //shieldItem(item);
            } else if (item instanceof ArmorItem){
                //armorItem(item);
            }
        });

        itemModelGenerator.run();
    }
}
