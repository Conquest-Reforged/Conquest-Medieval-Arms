package com.conquestreforged.arms.datagen;

import com.conquestreforged.arms.init.ItemInit;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.item.*;

public class ModItemModelProvider extends FabricModelProvider {

    public ModItemModelProvider(FabricDataOutput output) {
        super(output);
    }

    /*private ItemModelBuilder armorItem(Item item) {
        return withExistingParent(item.getRegistryName().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(ConquestMedievalArms.MOD_ID, "item/armor/" + item.getRegistryName().getPath()
                .replace("refined_", "")
                .replace("exquisite_", "")
                )
        );
    }

    private ItemModelBuilder axeItem(Item item) {
        return withExistingParent(item.getRegistryName().getPath(), new ResourceLocation(ConquestMedievalArms.MOD_ID + ":item/axe"))
                .texture("layer0", new ResourceLocation(ConquestMedievalArms.MOD_ID, "item/melee/" + item.getRegistryName().getPath()
                                .replace("refined_", "")
                                .replace("exquisite_", "")
                        )
                );
    }

    private ItemModelBuilder swordItem(Item item) {
        return withExistingParent(item.getRegistryName().getPath(), new ResourceLocation(ConquestMedievalArms.MOD_ID + ":item/sword"))
                .texture("layer0", new ResourceLocation(ConquestMedievalArms.MOD_ID, "item/melee/" + item.getRegistryName().getPath()
                        .replace("refined_", "")
                        .replace("exquisite_", "")
                        )
                );
    }

    private ItemModelBuilder shieldItem(Item item) {
        ItemModelBuilder modelNormal = withExistingParent(item.getRegistryName().getPath(), new ResourceLocation(ConquestMedievalArms.MOD_ID + ":item/shield"))
                .texture("layer0", new ResourceLocation(ConquestMedievalArms.MOD_ID, "item/shields/" + item.getRegistryName().getPath()));

        ModelFile modelBlocking = singleTexture(item.getRegistryName().getPath() + "_blocking", modLoc("item/shield_blocking"), "layer0", modLoc("item/shields/" + item.getRegistryName().getPath()));

        //ItemModelBuilder modelBlocking = withExistingParent(item.getRegistryName().getPath(), new ResourceLocation(ArmsOfConquest.MOD_ID + ":item/" + item.getRegistryName().getPath() + "_blocking"))
        //        .texture("layer0", new ResourceLocation(ArmsOfConquest.MOD_ID, "item/" + item.getRegistryName().getPath()));


        return modelNormal.override()
                .predicate(new ResourceLocation("blocking"), 1)
                .model(modelBlocking)
                .end();
    }*/

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
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

        itemModelGenerator.register();
    }
}
