package com.conquestreforged.arms.init;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> METAL_SWORDS =
                createTag("metal_swords");
        public static final TagKey<Item> METAL_AXES =
                createTag("metal_axes");
        public static final TagKey<Item> METAL_BOOTS =
                createTag("metal_boots");
        public static final TagKey<Item> METAL_LEGGINGS =
                createTag("metal_leggings");
        public static final TagKey<Item> NETAL_CHESTPLATES =
                createTag("metal_chestplates");
        public static final TagKey<Item> METAL_HELMETS =
                createTag("metal_helmets");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, name));
        }
    }
}
