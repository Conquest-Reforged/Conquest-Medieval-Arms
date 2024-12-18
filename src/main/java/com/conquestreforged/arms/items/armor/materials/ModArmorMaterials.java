package com.conquestreforged.arms.items.armor.materials;

import com.conquestreforged.arms.ConquestMedievalArms;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public enum ModArmorMaterials implements ArmorMaterial {

    BRONZE("bronze", 800, new int[] {2, 2, 2, 2}, 25, SoundEvents.ARMOR_EQUIP_IRON, 0.0f, Items.IRON_INGOT),
    QUILT("quilt", 800, new int[] {2, 2, 2, 2}, 25, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0f, Items.LEATHER),
    CLOTH("cloth", 800, new int[] {2, 2, 2, 2}, 25, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0f, Items.LEATHER);

    private final String name;
    private final SoundEvent equipSound;
    private final int durability;
    private final int enchantability;
    private final int[] damageReductionAmountArray;
    private final float toughness;
    private final Item repairIngredient;

    ModArmorMaterials(String name, int durability, int[] damageReductionAmountArray, int enchantability, SoundEvent equipSound, float toughness, Item repairIngredient) {
        this.name = name;
        this.durability = durability;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.repairIngredient = repairIngredient;
    }
    @Override
    public int getDurabilityForSlot(@NotNull EquipmentSlot equipmentSlotType) {
        return this.durability;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot equipmentSlotType) {
        return this.damageReductionAmountArray[equipmentSlotType.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public @NotNull SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return Ingredient.of(this.repairIngredient);
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
