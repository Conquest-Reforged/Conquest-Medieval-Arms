package com.conquestreforged.arms.util;

import com.conquestreforged.arms.ConquestMedievalArms;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static class Items {

        public static final TagKey<Item> SPEARS = forgeTag("weapons/spears");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(ConquestMedievalArms.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }
    }
}
