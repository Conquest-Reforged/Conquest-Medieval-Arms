package com.conquestreforged.arms.screens;

import com.conquestreforged.arms.recipe.ArmorStationRecipe;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import java.util.List;

public class ArmorStationScreen extends HandledScreen<ArmorStationMenu> {
    private static final Identifier BG_LOCATION = new Identifier("textures/gui/container/stonecutter.png");
    private static final int SCROLLER_WIDTH = 12;
    private static final int SCROLLER_HEIGHT = 15;
    private static final int RECIPES_COLUMNS = 4;
    private static final int RECIPES_ROWS = 3;
    private static final int RECIPES_IMAGE_SIZE_WIDTH = 16;
    private static final int RECIPES_IMAGE_SIZE_HEIGHT = 18;
    private static final int SCROLLER_FULL_HEIGHT = 54;
    private static final int RECIPES_X = 52;
    private static final int RECIPES_Y = 14;
    private float scrollOffs;
    private boolean scrolling;
    private int startIndex;
    private boolean displayRecipes;

    public ArmorStationScreen(ArmorStationMenu handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        handler.setContentsChangedListener(this::containerChanged);
        --this.titleY;
    }

    @Override
    public void render(DrawContext graphics, int mouseX, int mouseY, float delta) {
        super.render(graphics, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(graphics, mouseX, mouseY);
    }

    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        this.renderBackground(context);
        int i = this.x;
        int j = this.y;
        context.drawTexture(BG_LOCATION, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
        int k = (int)(41.0F * this.scrollOffs);
        context.drawTexture(BG_LOCATION, i + 119, j + 15 + k, 176 + (this.isScrollBarActive() ? 0 : 12), 0, 12, 15);
        int l = this.x + 52;
        int m = this.y + 14;
        int n = this.startIndex + 12;
        this.renderRecipeBackground(context, mouseX, mouseY, l, m, n);
        this.renderRecipeIcons(context, l, m, n);
    }

    protected void drawMouseoverTooltip(DrawContext context, int p_99334_, int p_99335_) {
        super.drawMouseoverTooltip(context, p_99334_, p_99335_);
        if (this.displayRecipes) {
            int i = this.x + 52;
            int j = this.y + 14;
            int k = this.startIndex + 12;
            List<ArmorStationRecipe> list = this.handler.getAvailableRecipes();

            for(int l = this.startIndex; l < k && l < this.handler.getAvailableRecipeCount(); ++l) {
                int i1 = l - this.startIndex;
                int j1 = i + i1 % 4 * 16;
                int k1 = j + i1 / 4 * 18 + 2;
                if (p_99334_ >= j1 && p_99334_ < j1 + 16 && p_99335_ >= k1 && p_99335_ < k1 + 18) {
                    context.drawItemTooltip(this.textRenderer, (list.get(l)).getOutput(this.client.world.getRegistryManager()), x, y);
                }
            }
        }

    }

    private void renderRecipeBackground(DrawContext p_99342_, int p_99343_, int p_99344_, int p_99345_, int p_99346_, int p_99347_) {
        for(int i = this.startIndex; i < p_99347_ && i < this.handler.getAvailableRecipeCount(); ++i) {
            int j = i - this.startIndex;
            int k = p_99345_ + j % 4 * 16;
            int l = j / 4;
            int i1 = p_99346_ + l * 18 + 2;
            int j1 = this.backgroundHeight;
            if (i == this.handler.getSelectedRecipe()) {
                j1 += 18;
            } else if (p_99343_ >= k && p_99344_ >= i1 && p_99343_ < k + 16 && p_99344_ < i1 + 18) {
                j1 += 36;
            }

            p_99342_.drawTexture(BG_LOCATION, k, i1 - 1, 0, j1, 16, 18);
        }

    }

    private void renderRecipeIcons(DrawContext context, int x, int y, int scrollOffset) {
        List<ArmorStationRecipe> list = (this.handler).getAvailableRecipes();

        for(int i = this.startIndex; i < scrollOffset && i < (this.handler).getAvailableRecipeCount(); ++i) {
            int j = i - this.startIndex;
            int k = x + j % 4 * 16;
            int l = j / 4;
            int m = y + l * 18 + 2;
            context.drawItem((list.get(i)).getOutput(this.client.world.getRegistryManager()), k, m);
        }

    }

    public boolean mouseClicked(double p_99318_, double p_99319_, int p_99320_) {
        this.scrolling = false;
        if (this.displayRecipes) {
            int i = this.x + 52;
            int j = this.y + 14;
            int k = this.startIndex + 12;

            for(int l = this.startIndex; l < k; ++l) {
                int i1 = l - this.startIndex;
                double d0 = p_99318_ - (double)(i + i1 % 4 * 16);
                double d1 = p_99319_ - (double)(j + i1 / 4 * 18);
                if (d0 >= 0.0D && d1 >= 0.0D && d0 < 16.0D && d1 < 18.0D && this.handler.onButtonClick(this.client.player, l)) {
                    MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0F));
                    this.client.interactionManager.clickButton((this.handler).syncId, l);
                    return true;
                }
            }

            i = this.x + 119;
            j = this.y + 9;
            if (p_99318_ >= (double)i && p_99318_ < (double)(i + 12) && p_99319_ >= (double)j && p_99319_ < (double)(j + 54)) {
                this.scrolling = true;
            }
        }

        return super.mouseClicked(p_99318_, p_99319_, p_99320_);
    }

    public boolean mouseDragged(double p_99322_, double p_99323_, int p_99324_, double p_99325_, double p_99326_) {
        if (this.scrolling && this.isScrollBarActive()) {
            int i = this.y + 14;
            int j = i + 54;
            this.scrollOffs = ((float)p_99323_ - (float)i - 7.5F) / ((float)(j - i) - 15.0F);
            this.scrollOffs = MathHelper.clamp(this.scrollOffs, 0.0F, 1.0F);
            this.startIndex = (int)((double)(this.scrollOffs * (float)this.getOffscreenRows()) + 0.5D) * 4;
            return true;
        } else {
            return super.mouseDragged(p_99322_, p_99323_, p_99324_, p_99325_, p_99326_);
        }
    }

    public boolean mouseScrolled(double p_99314_, double p_99315_, double p_99316_) {
        if (this.isScrollBarActive()) {
            int i = this.getOffscreenRows();
            float f = (float)p_99316_ / (float)i;
            this.scrollOffs = MathHelper.clamp(this.scrollOffs - f, 0.0F, 1.0F);
            this.startIndex = (int)((double)(this.scrollOffs * (float)i) + 0.5D) * 4;
        }

        return true;
    }

    private boolean isScrollBarActive() {
        return this.displayRecipes && this.handler.getAvailableRecipeCount() > 12;
    }

    protected int getOffscreenRows() {
        return (this.handler.getAvailableRecipeCount() + 4 - 1) / 4 - 3;
    }

    private void containerChanged() {
        this.displayRecipes = this.handler.canCraft();
        if (!this.displayRecipes) {
            this.scrollOffs = 0.0F;
            this.startIndex = 0;
        }

    }
}
