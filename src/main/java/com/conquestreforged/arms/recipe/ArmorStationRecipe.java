package com.conquestreforged.arms.recipe;

import com.conquestreforged.arms.ConquestMedievalArms;
import com.google.gson.JsonObject;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.CuttingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class ArmorStationRecipe extends CuttingRecipe {

    public ArmorStationRecipe(Identifier id, String string, Ingredient recipeItems, ItemStack output) {
        super(Type.INSTANCE, ModRecipes.ARMS_STATION_SERIALIZER, id, string, recipeItems, output);
    }
    @Override
    public boolean matches(Inventory inventory, World world) {
        if (world.isClient()) {
            return false;
        }
        return this.input.test(inventory.getStack(0));
    }

    public static class Type implements RecipeType<ArmorStationRecipe> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "arms_station";
    }

    public static class Serializer implements RecipeSerializer<ArmorStationRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final Identifier ID =
                new Identifier(ConquestMedievalArms.MOD_ID, "arms_station");

        @Override
        public ArmorStationRecipe read(Identifier id, JsonObject json) {
            String group = JsonHelper.getString(json, "group", "");

            Ingredient ingredient;
            if (JsonHelper.hasArray(json, "ingredient")) {
                ingredient = Ingredient.fromJson(JsonHelper.getArray(json, "ingredient"));
            } else {
                ingredient = Ingredient.fromJson(JsonHelper.getObject(json, "ingredient"));
            }

            String s1 = JsonHelper.getString(json, "result");
            int i = JsonHelper.getInt(json, "count");
            ItemStack itemstack = new ItemStack(Registries.ITEM.get(new Identifier(s1)), i);

            return new ArmorStationRecipe(id, group , ingredient, itemstack);
        }

        @Nullable
        @Override
        public ArmorStationRecipe read(Identifier id, PacketByteBuf buf) {
            String group = buf.readString();
            Ingredient ingredient = Ingredient.fromPacket(buf);
            ItemStack itemstack = buf.readItemStack();

            return new ArmorStationRecipe(id, group, ingredient, itemstack);
        }

        @Override
        public void write(PacketByteBuf buf, ArmorStationRecipe recipe) {
            buf.writeString(recipe.group);
            recipe.input.write(buf);
            buf.writeItemStack(recipe.output);
        }

    }
}
