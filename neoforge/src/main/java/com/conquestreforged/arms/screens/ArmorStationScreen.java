package com.conquestreforged.arms.screens;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;

import java.util.List;

public class ArmorStationScreen extends AbstractContainerScreen<ArmorStationScreenHandler> {
    private static final ResourceLocation SCROLLER_SPRITE = ResourceLocation.fromNamespaceAndPath("minecraft", "container/stonecutter/scroller");
    private static final ResourceLocation SCROLLER_DISABLED_SPRITE = ResourceLocation.fromNamespaceAndPath("minecraft", "container/stonecutter/scroller_disabled");
    private static final ResourceLocation RECIPE_SELECTED_SPRITE = ResourceLocation.fromNamespaceAndPath("minecraft", "container/stonecutter/recipe_selected");
    private static final ResourceLocation RECIPE_HIGHLIGHTED_SPRITE = ResourceLocation.fromNamespaceAndPath("minecraft", "container/stonecutter/recipe_highlighted");
    private static final ResourceLocation RECIPE_SPRITE = ResourceLocation.fromNamespaceAndPath("minecraft", "container/stonecutter/recipe");
    private static final ResourceLocation BG_LOCATION = ResourceLocation.parse("textures/gui/container/stonecutter.png");

    private float scrollOffs;
    private boolean scrolling;
    private int startIndex;
    private boolean displayRecipes;

    public ArmorStationScreen(ArmorStationScreenHandler handler, Inventory inventory, Component title) {
        super(handler, inventory, title);
        handler.setContentsChangedListener(this::containerChanged);
        --this.titleLabelY;
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
        super.render(graphics, mouseX, mouseY, delta);
        this.renderTooltip(graphics, mouseX, mouseY);
    }

    @Override
    protected void renderBg(GuiGraphics graphics, float delta, int mouseX, int mouseY) {
        int i = this.leftPos;
        int j = this.topPos;
        graphics.blit(BG_LOCATION, i, j, 0, 0, this.imageWidth, this.imageHeight);
        int k = (int)(41.0f * this.scrollOffs);
        ResourceLocation scroller = this.isScrollBarActive() ? SCROLLER_SPRITE : SCROLLER_DISABLED_SPRITE;
        graphics.blitSprite(scroller, i + 119, j + 15 + k, 12, 15);
        int l = this.leftPos + 52;
        int m = this.topPos + 14;
        int n = this.startIndex + 12;
        this.renderButtons(graphics, mouseX, mouseY, l, m, n);
        this.renderRecipes(graphics, l, m, n);
    }

    @Override
    protected void renderTooltip(GuiGraphics graphics, int x, int y) {
        super.renderTooltip(graphics, x, y);
        if (this.displayRecipes) {
            int i = this.leftPos + 52;
            int j = this.topPos + 14;
            int k = this.startIndex + 12;
            var list = this.menu.getAvailableRecipes();
            for (int l = this.startIndex; l < k && l < this.menu.getAvailableRecipeCount(); ++l) {
                int m = l - this.startIndex;
                int n = i + m % 4 * 16;
                int o = j + m / 4 * 18 + 2;
                if (x >= n && x < n + 16 && y >= o && y < o + 18) {
                    graphics.renderTooltip(this.font, list.get(l).value().getResultItem(this.minecraft.level.registryAccess()), x, y);
                }
            }
        }
    }

    private void renderButtons(GuiGraphics graphics, int mouseX, int mouseY, int x, int y, int end) {
        for (int i = this.startIndex; i < end && i < this.menu.getAvailableRecipeCount(); ++i) {
            int j = i - this.startIndex;
            int k = x + j % 4 * 16;
            int l = j / 4;
            int m = y + l * 18 + 2;
            ResourceLocation sprite;
            if (i == this.menu.getSelectedRecipe()) {
                sprite = RECIPE_SELECTED_SPRITE;
            } else if (mouseX >= k && mouseY >= m && mouseX < k + 16 && mouseY < m + 18) {
                sprite = RECIPE_HIGHLIGHTED_SPRITE;
            } else {
                sprite = RECIPE_SPRITE;
            }
            graphics.blitSprite(sprite, k, m - 1, 16, 18);
        }
    }

    private void renderRecipes(GuiGraphics graphics, int x, int y, int end) {
        var list = this.menu.getAvailableRecipes();
        for (int i = this.startIndex; i < end && i < this.menu.getAvailableRecipeCount(); ++i) {
            int j = i - this.startIndex;
            int k = x + j % 4 * 16;
            int l = j / 4;
            int m = y + l * 18 + 2;
            graphics.renderItem(list.get(i).value().getResultItem(this.minecraft.level.registryAccess()), k, m);
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.scrolling = false;
        if (this.displayRecipes) {
            int i = this.leftPos + 52;
            int j = this.topPos + 14;
            int k = this.startIndex + 12;
            for (int l = this.startIndex; l < k; ++l) {
                int m = l - this.startIndex;
                double d = mouseX - (double)(i + m % 4 * 16);
                double e = mouseY - (double)(j + m / 4 * 18);
                if (d >= 0.0 && e >= 0.0 && d < 16.0 && e < 18.0
                        && this.menu.clickMenuButton(this.minecraft.player, l)) {
                    Minecraft.getInstance().getSoundManager().play(
                            SimpleSoundInstance.forUI(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0f));
                    this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, l);
                    return true;
                }
            }
            i = this.leftPos + 119;
            j = this.topPos + 9;
            if (mouseX >= i && mouseX < i + 12 && mouseY >= j && mouseY < j + 54) {
                this.scrolling = true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (this.scrolling && this.isScrollBarActive()) {
            int i = this.topPos + 14;
            int j = i + 54;
            this.scrollOffs = ((float)mouseY - (float)i - 7.5f) / ((float)(j - i) - 15.0f);
            this.scrollOffs = Mth.clamp(this.scrollOffs, 0.0f, 1.0f);
            this.startIndex = (int)((double)(this.scrollOffs * (float)this.getOffscreenRows()) + 0.5) * 4;
            return true;
        }
        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double horizontal, double vertical) {
        if (this.isScrollBarActive()) {
            int i = this.getOffscreenRows();
            float f = (float)vertical / (float)i;
            this.scrollOffs = Mth.clamp(this.scrollOffs - f, 0.0f, 1.0f);
            this.startIndex = (int)((double)(this.scrollOffs * (float)i) + 0.5) * 4;
        }
        return true;
    }

    private boolean isScrollBarActive() {
        return this.displayRecipes && this.menu.getAvailableRecipeCount() > 12;
    }

    protected int getOffscreenRows() {
        return (this.menu.getAvailableRecipeCount() + 4 - 1) / 4 - 3;
    }

    private void containerChanged() {
        this.displayRecipes = this.menu.canCraft();
        if (!this.displayRecipes) {
            this.scrollOffs = 0.0f;
            this.startIndex = 0;
        }
    }
}