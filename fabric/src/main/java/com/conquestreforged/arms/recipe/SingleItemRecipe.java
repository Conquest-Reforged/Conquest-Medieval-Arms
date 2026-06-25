package com.conquestreforged.arms.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;

public abstract class SingleItemRecipe implements Recipe<SingleItemRecipe.Input> {
    protected final Ingredient input;
    protected final ItemStack output;
    private final RecipeType<?> type;
    private final RecipeSerializer<?> serializer;
    protected final String group;

    public SingleItemRecipe(RecipeType<?> type, RecipeSerializer<?> serializer, String group, Ingredient input, ItemStack output) {
        this.type = type;
        this.serializer = serializer;
        this.group = group;
        this.input = input;
        this.output = output;
    }

    @Override
    public RecipeType<?> getType() {
        return this.type;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return this.serializer;
    }

    @Override
    public String getGroup() {
        return this.group;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return this.output;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(this.input);
        return list;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack assemble(Input input, HolderLookup.Provider provider) {
        return this.output.copy();
    }

    // Simple RecipeInput wrapper for a single slot
    public record Input(ItemStack stack) implements RecipeInput {
        @Override
        public ItemStack getItem(int index) {
            if (index != 0) throw new IllegalArgumentException("No item for index " + index);
            return stack;
        }

        @Override
        public int size() {
            return 1;
        }
    }

    public static class Serializer<T extends SingleItemRecipe> implements RecipeSerializer<T> {
        private final MapCodec<T> codec;
        private final StreamCodec<RegistryFriendlyByteBuf, T> streamCodec;

        protected Serializer(RecipeFactory<T> factory) {
            this.codec = RecordCodecBuilder.mapCodec(instance -> instance.group(
                    Codec.STRING.optionalFieldOf("group", "").forGetter(r -> r.group),
                    Ingredient.CODEC.fieldOf("ingredient").forGetter(r -> r.input),
                    ItemStack.CODEC.fieldOf("result").forGetter(r -> r.output)
            ).apply(instance, (group, ingredient, result) -> factory.create(group, ingredient, result)));

            this.streamCodec = StreamCodec.of(
                    (buf, recipe) -> {
                        buf.writeUtf(recipe.group);
                        Ingredient.CONTENTS_STREAM_CODEC.encode(buf, recipe.input);
                        ItemStack.STREAM_CODEC.encode(buf, recipe.output);
                    },
                    buf -> {
                        String group = buf.readUtf();
                        Ingredient ingredient = Ingredient.CONTENTS_STREAM_CODEC.decode(buf);
                        ItemStack result = ItemStack.STREAM_CODEC.decode(buf);
                        return factory.create(group, ingredient, result);
                    }
            );
        }

        @Override
        public MapCodec<T> codec() {
            return this.codec;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, T> streamCodec() {
            return this.streamCodec;
        }

        public interface RecipeFactory<T extends SingleItemRecipe> {
            T create(String group, Ingredient input, ItemStack output);
        }
    }
}