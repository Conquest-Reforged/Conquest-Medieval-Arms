package com.conquestreforged.arms.items.armor.materials;

import com.conquestreforged.arms.ConquestMedievalArms;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;
import java.util.Map;

public class ModArmorMaterials {

    public static final DeferredRegister<ArmorMaterial> ARMORMATERIALS = DeferredRegister.create(BuiltInRegistries.ARMOR_MATERIAL, ConquestMedievalArms.MOD_ID);



    public static final Holder<ArmorMaterial> METAL_GENERIC = register("metal_generic",
            Map.of(
                    ArmorItem.Type.HELMET, 0,
                    ArmorItem.Type.CHESTPLATE, 0,
                    ArmorItem.Type.LEGGINGS, 0,
                    ArmorItem.Type.BOOTS, 0
            ),
            25, SoundEvents.ARMOR_EQUIP_IRON, 0.0f, 0.0f, Items.IRON_INGOT);

    public static final Holder<ArmorMaterial> BRONZE = register("bronze",
            Map.of(
                    ArmorItem.Type.HELMET, 2,
                    ArmorItem.Type.CHESTPLATE, 2,
                    ArmorItem.Type.LEGGINGS, 2,
                    ArmorItem.Type.BOOTS, 2
            ),
            25, SoundEvents.ARMOR_EQUIP_IRON, 0.0f, 0.0f, Items.IRON_INGOT);

    public static final Holder<ArmorMaterial> QUILT = register("quilt",
            Map.of(
                    ArmorItem.Type.HELMET, 2,
                    ArmorItem.Type.CHESTPLATE, 2,
                    ArmorItem.Type.LEGGINGS, 2,
                    ArmorItem.Type.BOOTS, 2
            ),
            25, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0f, 0.0f, Items.LEATHER);

    public static final Holder<ArmorMaterial> CLOTH = register("cloth",
            Map.of(
                    ArmorItem.Type.HELMET, 2,
                    ArmorItem.Type.CHESTPLATE, 2,
                    ArmorItem.Type.LEGGINGS, 2,
                    ArmorItem.Type.BOOTS, 2
            ),
            25, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0f, 0.0f, Items.LEATHER);

    private static Holder<ArmorMaterial> register(String name, Map<ArmorItem.Type, Integer> defense,
                                                  int enchantability, Holder<SoundEvent> equipSound,
                                                  float toughness, float knockbackResistance,
                                                  net.minecraft.world.item.Item repairItem) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("conquest", name);
        ArmorMaterial material = new ArmorMaterial(
                defense,
                enchantability,
                equipSound,
                () -> Ingredient.of(repairItem),
                List.of(new ArmorMaterial.Layer(id)),
                toughness,
                knockbackResistance
        );
        return ARMORMATERIALS.register(name, () -> material);
    }
}