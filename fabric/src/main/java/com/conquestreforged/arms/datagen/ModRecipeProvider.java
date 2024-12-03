package com.conquestreforged.arms.datagen;

import com.conquestreforged.arms.init.ItemInit;
import com.conquestreforged.arms.init.ModTags;
import com.conquestreforged.arms.items.ModSpear;
import com.conquestreforged.arms.items.ModSword;
import com.conquestreforged.arms.recipe.ModRecipeSerializer;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.SingleItemRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.SwordItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        Registries.ITEM.stream().filter(item -> Registries.ITEM.getId(item).getNamespace().equals("conquest")).forEach(item -> {
            Item itemOutput = item.asItem();
            if (itemOutput instanceof ModSword || itemOutput instanceof ModSpear) {
                this.offerArmsStationRecipe(exporter, RecipeCategory.COMBAT, itemOutput, ModTags.Items.METAL_SWORDS);
            }
        });
    }

    public static void offerArmsStationRecipe(Consumer<RecipeJsonProvider> exporter, RecipeCategory category, ItemConvertible output, TagKey<Item> input) {
        SingleItemRecipeJsonBuilder var10000 = createArmsStation(Ingredient.fromTag(input), category, output);
        String var10002 = getItemPath(output) + "_from_" + input.toString();
        var10000.offerTo(exporter, var10002);
    }

    public static SingleItemRecipeJsonBuilder createArmsStation(Ingredient input, RecipeCategory category, ItemConvertible output) {
        return new SingleItemRecipeJsonBuilder(category, ModRecipeSerializer.ARMS_STATION, input, output, 1);
    }

    /*@Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> recipeConsumer) {
        //armsStation(Ingredient.of(Items.IRON_CHESTPLATE), ItemInit.CRUSADER_CHEST.get()).save(recipeConsumer);

        ItemInit.dataGenItemRecipes.forEach(registryItem -> {
            Item item = registryItem.get();
            if (item instanceof SwordItem || item instanceof ModSpear) {
                createSwordRecipe(recipeConsumer, (TieredItem) registryItem.get());
            } else if (item instanceof AxeItem) {
                createAxeRecipe(recipeConsumer, (TieredItem) registryItem.get());
            } else if (item instanceof ArmorItem) {
                createArmorRecipe(recipeConsumer, (ArmorItem) registryItem.get());
            } else if (item instanceof ModShield) {
                armsStation(Ingredient.of(Items.SHIELD), item)
                        .unlockedBy("has_" + Items.SHIELD, inventoryTrigger(ItemPredicate.Builder.item().of(Items.SHIELD).build()))
                        .save(recipeConsumer);
            } else if (item instanceof BowItem) {
                createBowRecipe(recipeConsumer, registryItem.get());
            } else if (item instanceof CrossbowItem) {
                createXBowRecipe(recipeConsumer, registryItem.get());
            }
        });
    }

    private void createBowRecipe(Consumer<FinishedRecipe> recipeConsumer, Item result) {
        Item ingredientItem = Items.BOW;
        armsStation(Ingredient.of(ingredientItem), result)
                .unlockedBy("has_" + ingredientItem, inventoryTrigger(ItemPredicate.Builder.item().of(ingredientItem).build()))
                .save(recipeConsumer);
    }

    private void createXBowRecipe(Consumer<FinishedRecipe> recipeConsumer, Item result) {
        Item ingredientItem = Items.CROSSBOW;
        armsStation(Ingredient.of(ingredientItem), result)
                .unlockedBy("has_" + ingredientItem, inventoryTrigger(ItemPredicate.Builder.item().of(ingredientItem).build()))
                .save(recipeConsumer);
    }

    private void createAxeRecipe(Consumer<FinishedRecipe> recipeConsumer, TieredItem result) {
        Item ingredientItem = Items.WOODEN_AXE;
        Tier tier = result.getTier();

        if (Tiers.IRON.equals(tier)) {
            ingredientItem = Items.IRON_AXE;
        } else if (Tiers.DIAMOND.equals(tier)) {
            ingredientItem = Items.DIAMOND_AXE;
        } else if (Tiers.NETHERITE.equals(tier)) {
            ingredientItem = Items.NETHERITE_AXE;
        }

        armsStation(Ingredient.of(ingredientItem), result)
                .unlockedBy("has_" + ingredientItem, inventoryTrigger(ItemPredicate.Builder.item().of(ingredientItem).build()))
                .save(recipeConsumer);
    }

    private void createSwordRecipe(Consumer<FinishedRecipe> recipeConsumer, TieredItem result) {
        Item ingredientItem = Items.WOODEN_SWORD;
        Tier tier = result.getTier();

        if (Tiers.IRON.equals(tier)) {
            ingredientItem = Items.IRON_SWORD;
        } else if (Tiers.DIAMOND.equals(tier)) {
            ingredientItem = Items.DIAMOND_SWORD;
        } else if (Tiers.NETHERITE.equals(tier)) {
            ingredientItem = Items.NETHERITE_SWORD;
        }

        armsStation(Ingredient.of(ingredientItem), result)
                .unlockedBy("has_" + ingredientItem, inventoryTrigger(ItemPredicate.Builder.item().of(ingredientItem).build()))
                .save(recipeConsumer);
    }

    private void createArmorRecipe(Consumer<FinishedRecipe> recipeConsumer, ArmorItem result) {
        Item ingredientItem;
        switch (result.getMaterial().getName()) {
            default:
            case "bronze":
            case "iron":
                switch(result.getSlot().getName()) {
                    default:
                    case "feet":
                        ingredientItem = (Items.IRON_BOOTS);
                        break;
                    case "legs":
                        ingredientItem = (Items.IRON_LEGGINGS);
                        break;
                    case "chest":
                        ingredientItem = (Items.IRON_CHESTPLATE);
                        break;
                    case "head":
                        ingredientItem = (Items.IRON_HELMET);
                        break;
                }
                break;
            case "diamond":
                switch(result.getSlot().getName()) {
                    default:
                    case "feet":
                        ingredientItem = (Items.DIAMOND_BOOTS);
                        break;
                    case "legs":
                        ingredientItem = (Items.DIAMOND_LEGGINGS);
                        break;
                    case "chest":
                        ingredientItem = (Items.DIAMOND_CHESTPLATE);
                        break;
                    case "head":
                        ingredientItem = (Items.DIAMOND_HELMET);
                        break;
                }
                break;
            case "netherite":
                switch(result.getSlot().getName()) {
                    default:
                    case "feet":
                        ingredientItem = (Items.NETHERITE_BOOTS);
                        break;
                    case "legs":
                        ingredientItem = (Items.NETHERITE_LEGGINGS);
                        break;
                    case "chest":
                        ingredientItem = (Items.NETHERITE_CHESTPLATE);
                        break;
                    case "head":
                        ingredientItem = Items.NETHERITE_HELMET;
                        break;
                }
                break;
            case "quilt":
            case "cloth":
            case "leather":
                switch(result.getSlot().getName()) {
                    default:
                    case "feet":
                        ingredientItem = (Items.LEATHER_BOOTS);
                        break;
                    case "legs":
                        ingredientItem = (Items.LEATHER_LEGGINGS);
                        break;
                    case "chest":
                        ingredientItem = (Items.LEATHER_CHESTPLATE);
                        break;
                    case "head":
                        ingredientItem = (Items.LEATHER_HELMET);
                        break;
                }
                break;
        }

        armsStation(Ingredient.of(ingredientItem), result)
                .unlockedBy("has_" + ingredientItem, inventoryTrigger(ItemPredicate.Builder.item().of(ingredientItem).build()))
                .save(recipeConsumer);
    }

    public static SingleItemRecipeBuilder armsStation(Ingredient ingredient, ItemLike itemLike) {
        return new SingleItemRecipeBuilder(ModRecipes.ARMS_STATION_SERIALIZER, ingredient, itemLike, 1);
    }*/
}