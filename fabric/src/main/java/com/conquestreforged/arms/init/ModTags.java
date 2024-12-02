package com.conquestreforged.arms.init;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import static com.conquestreforged.arms.ConquestMedievalArms.MOD_ID;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> METAL_SWORDS =
                createTag("metal_swords");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(MOD_ID, name));
        }
    }
}
