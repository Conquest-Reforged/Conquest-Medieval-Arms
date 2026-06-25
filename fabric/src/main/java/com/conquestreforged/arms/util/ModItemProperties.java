package com.conquestreforged.arms.util;

import com.conquestreforged.arms.ConquestMedievalArms;
import com.conquestreforged.arms.items.ModBow;
import com.conquestreforged.arms.items.ModCrossbow;
import com.conquestreforged.arms.items.ModShield;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ChargedProjectiles;

import java.util.List;
import java.util.stream.Collectors;

public class ModItemProperties {

    public static void addCustomItemProperties() {
        List<Item> shields = BuiltInRegistries.ITEM.stream()
                .filter(shield -> shield instanceof ModShield)
                .collect(Collectors.toList());
        shields.forEach(ModItemProperties::makeShield);

        List<Item> bows = BuiltInRegistries.ITEM.stream()
                .filter(bow -> bow instanceof ModBow)
                .collect(Collectors.toList());
        bows.forEach(ModItemProperties::makeBow);

        List<Item> xbows = BuiltInRegistries.ITEM.stream()
                .filter(xbow -> xbow instanceof ModCrossbow)
                .collect(Collectors.toList());
        xbows.forEach(ModItemProperties::makeCrossbow);
    }

    private static void makeShield(Item item) {
        ItemProperties.register(item, ResourceLocation.parse("blocking"), (stack, level, entity, seed) ->
                entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F
        );
    }

    private static void makeBow(Item item) {
        ItemProperties.register(item, ResourceLocation.parse("pull"), (stack, level, entity, seed) -> {
            if (entity == null) return 0.0F;
            return entity.getUseItem() != stack ? 0.0F :
                    (float)(stack.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / 20.0F;
        });
        ItemProperties.register(item, ResourceLocation.parse("pulling"), (stack, level, entity, seed) ->
                entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F
        );
    }

    private static void makeCrossbow(Item item) {
        ItemProperties.register(item, ResourceLocation.parse("pull"), (stack, level, entity, seed) -> {
            if (entity == null) return 0.0F;
            return CrossbowItem.isCharged(stack) ? 0.0F :
                    (float)(stack.getUseDuration(entity) - entity.getUseItemRemainingTicks()) /
                            (float) CrossbowItem.getChargeDuration(stack, entity);
        });
        ItemProperties.register(item, ResourceLocation.parse("pulling"), (stack, level, entity, seed) ->
                entity != null && entity.isUsingItem() && entity.getUseItem() == stack
                        && !CrossbowItem.isCharged(stack) ? 1.0F : 0.0F
        );
        ItemProperties.register(item, ResourceLocation.parse("charged"), (stack, level, entity, seed) ->
                entity != null && CrossbowItem.isCharged(stack) ? 1.0F : 0.0F
        );
        ItemProperties.register(item, ResourceLocation.parse("firework"), (stack, level, entity, seed) -> {
            if (entity == null || !CrossbowItem.isCharged(stack)) return 0.0F;
            ChargedProjectiles projectiles = stack.get(DataComponents.CHARGED_PROJECTILES);
            return projectiles != null && projectiles.contains(Items.FIREWORK_ROCKET) ? 1.0F : 0.0F;
        });
    }
}