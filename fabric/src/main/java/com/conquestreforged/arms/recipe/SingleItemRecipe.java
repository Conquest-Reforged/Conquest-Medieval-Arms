package com.conquestreforged.arms.recipe;

import com.mojang.datafixers.Products;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

import java.util.Objects;
import java.util.function.Function;

public abstract class SingleItemRecipe implements Recipe<SingleRecipeInput> {
    protected final Ingredient ingredient;
    protected final ItemStack result;
    private final RecipeType<?> type;
    private final RecipeSerializer<?> serializer;
    protected final String group;

    public SingleItemRecipe(RecipeType<?> recipeType, RecipeSerializer<?> recipeSerializer, String string, Ingredient ingredient, ItemStack itemStack) {
        this.type = recipeType;
        this.serializer = recipeSerializer;
        this.group = string;
        this.ingredient = ingredient;
        this.result = itemStack;
    }

    public RecipeType<?> getType() {
        return this.type;
    }

    public RecipeSerializer<?> getSerializer() {
        return this.serializer;
    }

    public String getGroup() {
        return this.group;
    }

    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return this.result;
    }

    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonNullList = NonNullList.create();
        nonNullList.add(this.ingredient);
        return nonNullList;
    }

    public boolean canCraftInDimensions(int i, int j) {
        return true;
    }

    public ItemStack assemble(SingleRecipeInput singleRecipeInput, HolderLookup.Provider provider) {
        return this.result.copy();
    }

    public static class Serializer<T extends SingleItemRecipe> implements RecipeSerializer<T> {
        final SingleItemRecipe.Factory<T> factory;
        private final MapCodec<T> codec;
        private final StreamCodec<RegistryFriendlyByteBuf, T> streamCodec;

        protected Serializer(SingleItemRecipe.Factory<T> factory) {
            this.factory = factory;
            this.codec = RecordCodecBuilder.mapCodec((instance) -> {
                Products.P3<RecordCodecBuilder.Mu<T>, String, Ingredient, ItemStack> var10000 = instance.group(
                        Codec.STRING.optionalFieldOf("group", "").forGetter((recipe) -> recipe.group),
                        Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter((recipe) -> recipe.ingredient),
                        ItemStack.STRICT_CODEC.fieldOf("result").forGetter((recipe) -> recipe.result)
                );
                Objects.requireNonNull(factory);
                return var10000.apply(instance, factory::create);
            });
            this.streamCodec = StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8, (recipe) -> recipe.group,
                    Ingredient.CONTENTS_STREAM_CODEC, (recipe) -> recipe.ingredient,
                    ItemStack.STREAM_CODEC, (recipe) -> recipe.result,
                    factory::create
            );
        }

        public MapCodec<T> codec() {
            return this.codec;
        }

        public StreamCodec<RegistryFriendlyByteBuf, T> streamCodec() {
            return this.streamCodec;
        }
    }

    public interface Factory<T extends SingleItemRecipe> {
        T create(String group, Ingredient ingredient, ItemStack result);
    }
}
