package com.conquestreforged.arms.init;

import com.conquestreforged.arms.ConquestMedievalArms;
import com.conquestreforged.arms.block.entity.custom.ArmorStationBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class BlockInit {

    //public static final Block ARMS_STATION_BLOCK = registerBlock("arms_station", new ArmorStationBlock(FabricBlockSettings.copyOf(Blocks.SMITHING_TABLE)), "tooltip." + MOD_ID + ".block.arms_station");

    private static Block registerBlock(String name, Block block, String tooltipKey) {
        registerBlockItem(name, block, tooltipKey);
        return Registry.register(Registries.BLOCK, new Identifier(MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block, String tooltipKey) {
        return Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), new BlockItem(block, new FabricItemSettings()) {
            @Override
            public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                tooltip.add(Text.translatable(tooltipKey));
            }
        });
    }
    public static void registerModBlocks() {
        ConquestMedievalArms.LOGGER.info("Registering Conquest Medieval Arms Blocks");
    }

}
