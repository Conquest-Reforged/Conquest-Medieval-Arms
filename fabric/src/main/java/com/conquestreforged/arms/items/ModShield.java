package com.conquestreforged.arms.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ModShield extends ShieldItem {
    private final String toolTipName;
    private final int linesAmt;

    public ModShield(Item.Settings props, String name, Integer linesAmt) {
        super(props);
        this.toolTipName = name;
        this.linesAmt = linesAmt;
    }

    @Override
    public int getMaxUseTime(ItemStack stack) {
        //return 72000
        return super.getMaxUseTime(stack);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        for (int i = 1; i <= linesAmt; i++) {
            tooltip.add(Text.translatable("tooltip." + MOD_ID + ".item." + toolTipName + i));
        }
    }
}
