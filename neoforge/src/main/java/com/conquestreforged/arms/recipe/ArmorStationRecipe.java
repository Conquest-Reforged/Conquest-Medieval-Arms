package com.conquestreforged.arms.recipe;

import com.conquestreforged.arms.init.BlockInit;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;

import static net.minecraft.world.item.Item.BASE_ATTACK_DAMAGE_ID;
import static net.minecraft.world.item.Item.BASE_ATTACK_SPEED_ID;

public class ArmorStationRecipe extends SingleItemRecipe {  // YOUR SingleItemRecipe
    public ArmorStationRecipe(String group, Ingredient ingredient, ItemStack result) {
        super(ModRecipeType.ARMS_STATION, ModRecipeSerializer.ARMS_STATION, group, ingredient, result);
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(BlockInit.ARMS_STATION_BLOCK.get());
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public boolean matches(SingleRecipeInput recipeInput, Level level) {
        return this.ingredient.test(recipeInput.getItem(0));  // ingredient, not input
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return this.result;  // result, not output
    }

    @Override
    public ItemStack assemble(SingleRecipeInput recipeInput, HolderLookup.Provider provider) {
        ItemStack resultItem = this.result.copy();  // result, not output
        ItemStack inputItemStack = recipeInput.getItem(0);  // getItem(0), not .stack()
        Item inputItem = inputItemStack.getItem();

        // Copy existing components
        CustomData existingData = inputItemStack.get(DataComponents.CUSTOM_DATA);
        if (existingData != null) {
            resultItem.set(DataComponents.CUSTOM_DATA, existingData);
        }
        var enchantments = inputItemStack.get(DataComponents.ENCHANTMENTS);
        if (enchantments != null) {
            resultItem.set(DataComponents.ENCHANTMENTS, enchantments);
        }
        var customName = inputItemStack.get(DataComponents.CUSTOM_NAME);
        if (customName != null) {
            resultItem.set(DataComponents.CUSTOM_NAME, customName);
        }

        // Detect and write material
        String material = null;
        String description = inputItem.getDescription().getString().toLowerCase();
        if (description.contains("iron")) material = "iron";
        else if (description.contains("netherite")) material = "netherite";
        else if (description.contains("diamond")) material = "diamond";

        if (material != null) {
            String finalMaterial = material;
            CustomData.update(DataComponents.CUSTOM_DATA, resultItem, tag -> tag.putString("material", finalMaterial));
        }

        // Bake attribute modifiers onto the stack based on material
        if (resultItem.getItem() instanceof SwordItem tieredItem) {
            ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();

            float dmgBoost = tieredItem.getTier().getAttackDamageBonus();
            switch (material != null ? material : "") {
                case "iron" -> dmgBoost = Tiers.IRON.getAttackDamageBonus();
                case "diamond" -> dmgBoost = Tiers.DIAMOND.getAttackDamageBonus();
                case "netherite" -> dmgBoost = Tiers.NETHERITE.getAttackDamageBonus();
            }

            float attackDamage = 3.0f + dmgBoost; // 3.0 = weapon base

            builder.add(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(BASE_ATTACK_DAMAGE_ID,
                            attackDamage,
                            AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.MAINHAND);

            // Optional but recommended — vanilla always sets this too
            builder.add(Attributes.ATTACK_SPEED,
                    new AttributeModifier(BASE_ATTACK_SPEED_ID,
                            -2.4, // sword default; axes use -3.0 or similar
                            AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.MAINHAND);

            resultItem.set(DataComponents.ATTRIBUTE_MODIFIERS, builder.build()); // <-- this was missing
        }
        else if (resultItem.getItem() instanceof AxeItem) {
            ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();

            double axeDamage = switch (material != null ? material : "") {
                case "iron" -> 8.0;
                case "diamond" -> 8.0;
                case "netherite" -> 9.0;
                default -> 6.0; // stone fallback
            };

            double axeSpeed = switch (material != null ? material : "") {
                case "iron" -> 0.9;
                case "diamond" -> 1.0;
                case "netherite" -> 1.0;
                default -> 0.8;
            };

            builder.add(Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(BASE_ATTACK_DAMAGE_ID,
                            axeDamage,
                            AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.MAINHAND);

            builder.add(Attributes.ATTACK_SPEED,
                    new AttributeModifier(BASE_ATTACK_SPEED_ID,
                            axeSpeed - 4.0, // subtract player base of 4.0
                            AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.MAINHAND);

            resultItem.set(DataComponents.ATTRIBUTE_MODIFIERS, builder.build());
        }
        else if (resultItem.getItem() instanceof ArmorItem armorItem) {
            ArmorItem.Type armorType = armorItem.getType();
            EquipmentSlotGroup slotGroup = EquipmentSlotGroup.bySlot(armorType.getSlot());
            ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();

            switch (material != null ? material : "") {
                case "iron" -> builder.add(Attributes.ARMOR,
                        new AttributeModifier(ResourceLocation.withDefaultNamespace("armor.body"),
                                ArmorMaterials.IRON.value().getDefense(armorType),
                                AttributeModifier.Operation.ADD_VALUE),
                        slotGroup);
                case "diamond" -> {
                    builder.add(Attributes.ARMOR,
                            new AttributeModifier(ResourceLocation.withDefaultNamespace("armor.body"),
                                    ArmorMaterials.DIAMOND.value().getDefense(armorType),
                                    AttributeModifier.Operation.ADD_VALUE),
                            slotGroup);
                    builder.add(Attributes.ARMOR_TOUGHNESS,
                            new AttributeModifier(ResourceLocation.withDefaultNamespace("armor.toughness"),
                                    2.0, AttributeModifier.Operation.ADD_VALUE),
                            slotGroup);
                }
                case "netherite" -> {
                    builder.add(Attributes.ARMOR,
                            new AttributeModifier(ResourceLocation.withDefaultNamespace("armor.body"),
                                    ArmorMaterials.NETHERITE.value().getDefense(armorType),
                                    AttributeModifier.Operation.ADD_VALUE),
                            slotGroup);
                    builder.add(Attributes.ARMOR_TOUGHNESS,
                            new AttributeModifier(ResourceLocation.withDefaultNamespace("armor.toughness"),
                                    3.0, AttributeModifier.Operation.ADD_VALUE),
                            slotGroup);
                    builder.add(Attributes.KNOCKBACK_RESISTANCE,
                            new AttributeModifier(ResourceLocation.withDefaultNamespace("armor.knockback_resistance"),
                                    0.1, AttributeModifier.Operation.ADD_VALUE),
                            slotGroup);
                }
                default -> builder.add(Attributes.ARMOR,
                        new AttributeModifier(ResourceLocation.withDefaultNamespace("armor.body"),
                                armorItem.getMaterial().value().getDefense(armorType),
                                AttributeModifier.Operation.ADD_VALUE),
                        slotGroup);
            }

            resultItem.set(DataComponents.ATTRIBUTE_MODIFIERS, builder.build());
        }

        return resultItem;
    }
}