package com.conquestreforged.arms.init;

import com.conquestreforged.arms.ConquestMedievalArms;
import com.conquestreforged.arms.block.entity.custom.ArmorStationBlock;
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
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.function.Function;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(BuiltInRegistries.BLOCK, MOD_ID);

    public static final DeferredHolder<Block, ArmorStationBlock> ARMS_STATION_BLOCK =
            registerBlock("arms_station", ArmorStationBlock::new, Blocks.SMITHING_TABLE.properties(),
                    "tooltip." + MOD_ID + ".block.arms_station");

    private static <T extends Block> DeferredHolder<Block, T> registerBlock(
            String name, Function<BlockBehaviour.Properties, T> factory,
            BlockBehaviour.Properties props, String tooltipKey) {

        DeferredHolder<Block, T> holder = BLOCKS.register(name, () -> factory.apply(props));
        ItemInit.REGISTER.register(name, () -> new BlockItem(holder.get(), new Item.Properties()) {
            @Override
            public void appendHoverText(ItemStack stack, Item.TooltipContext context,
                                        List<Component> tooltip, TooltipFlag type) {
                tooltip.add(Component.translatable(tooltipKey));
            }
        });
        return holder;
    }
}
