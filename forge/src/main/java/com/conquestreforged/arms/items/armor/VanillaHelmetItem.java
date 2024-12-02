package com.conquestreforged.arms.items.armor;

import mod.azure.azurelibarmor.animatable.GeoItem;
import mod.azure.azurelibarmor.animatable.client.RenderProvider;
import mod.azure.azurelibarmor.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelibarmor.core.animation.AnimatableManager;
import mod.azure.azurelibarmor.util.AzureLibUtil;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class VanillaHelmetItem extends GenericArmorItem implements GeoItem {

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);
    public final ArmorMaterial customMaterial;

    public VanillaHelmetItem(ArmorMaterial material, Type head, Settings props, String armorTexture, Float cloth, Float mail, Float plate) {
        super(material, head, props, armorTexture, cloth, mail, plate);
        this.customMaterial = material;
    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private VanillaHelmetRenderer renderer;

            @Override
            @NotNull
            public BipedEntityModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, BipedEntityModel<LivingEntity> original) {
                if (renderer == null) {
                    renderer = new VanillaHelmetRenderer();
                }
                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
