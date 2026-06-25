package com.conquestreforged.arms.init;

import com.conquestreforged.arms.ConquestMedievalArms;
import com.conquestreforged.arms.block.entity.custom.ArmorStationBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import java.util.List;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class BlockInit {

    public static final Block ARMS_STATION_BLOCK = registerBlock("arms_station", new ArmorStationBlock(FabricBlockSettings.copyOf(Blocks.SMITHING_TABLE)), "tooltip." + MOD_ID + ".block.arms_station");

    private static Block registerBlock(String name, Block block, String tooltipKey) {
        registerBlockItem(name, block, tooltipKey);
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block, String tooltipKey) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, name), new BlockItem(block, new Item.Properties()) {
            @Override
            public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltip, TooltipFlag type) {
                tooltip.add(Component.translatable(tooltipKey));
            }
        });
    }
    public static void registerModBlocks() {
        ConquestMedievalArms.LOGGER.info("Registering Conquest Medieval Arms Blocks");
    }

}
