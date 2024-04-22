package com.conquestreforged.arms.items.armor;

import com.conquestreforged.arms.items.armor.models.ModArmorModel;
import com.conquestreforged.arms.items.armor.models.VanillaHelmetModel;
import mod.azure.azurelibarmor.renderer.GeoArmorRenderer;
import net.minecraft.entity.EquipmentSlot;

public class VanillaHelmetRenderer extends GeoArmorRenderer<VanillaHelmetItem> {
    public VanillaHelmetRenderer() {
        super(new VanillaHelmetModel());
    }

    @Override
    protected void applyBoneVisibilityBySlot(EquipmentSlot currentSlot) {
        this.setVisible(false);
        switch(currentSlot) {
            case HEAD:
                this.setBoneVisible(this.head, true);
                break;
            case CHEST:
            case LEGS:
                this.setBoneVisible(this.body, true);
                this.setBoneVisible(this.rightArm, true);
                this.setBoneVisible(this.leftArm, true);
                this.setBoneVisible(this.rightLeg, true);
                this.setBoneVisible(this.leftLeg, true);
                break;
            case FEET:
                this.setBoneVisible(this.rightLeg, true);
                this.setBoneVisible(this.leftLeg, true);
                this.setBoneVisible(this.rightBoot, true);
                this.setBoneVisible(this.leftBoot, true);
                break;
            case MAINHAND:
            case OFFHAND:
        }
    }
}
