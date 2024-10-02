package com.conquestreforged.arms.init;

import com.conquestreforged.arms.block.entity.custom.ArmorStationBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);

    public static final RegistryObject<Block> ARMS_STATION_BLOCK = registerBlock("arms_station", () -> new ArmorStationBlock(AbstractBlock.Settings.copy(Blocks.SMITHING_TABLE)), "tooltip." + MOD_ID + ".block.arms_station");

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tooltipKey);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, String tooltipKey) {
        return ItemInit.REGISTER.register(name, (() -> new BlockItem(block.get(), new Item.Settings()) {
            @Override
            public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                tooltip.add(Text.translatable(tooltipKey));
            }
        }));
    }
}
