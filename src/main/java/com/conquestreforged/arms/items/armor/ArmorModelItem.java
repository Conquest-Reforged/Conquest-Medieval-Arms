package com.conquestreforged.arms.items.armor;

import com.conquestreforged.arms.items.armor.models.ModelGenericBoots;
import com.conquestreforged.arms.items.armor.models.ModelGenericChest;
import com.conquestreforged.arms.items.armor.models.ModelGenericHelmet;
import com.conquestreforged.arms.items.armor.models.ModelGenericLegs;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.IItemRenderProperties;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class ArmorModelItem extends ArmorItem {

    private final String armorTexture;

    public ArmorModelItem(ArmorMaterial material, EquipmentSlot head, Properties props, String armorTexture) {
        super(material, head, props);
        this.armorTexture = armorTexture;

    }

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {
            @Nullable
            @Override
            public HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
                switch (slot) {
                    default:
                    case HEAD:
                        return new ModelGenericHelmet<>(Minecraft.getInstance().getEntityModels().bakeLayer(ModelGenericHelmet.LAYER_LOCATION));
                    case CHEST:
                        return new ModelGenericChest<>(Minecraft.getInstance().getEntityModels().bakeLayer(ModelGenericChest.LAYER_LOCATION));
                    case LEGS:
                        return new ModelGenericLegs<>(Minecraft.getInstance().getEntityModels().bakeLayer(ModelGenericLegs.LAYER_LOCATION));
                    case FEET:
                        return new ModelGenericBoots<>(Minecraft.getInstance().getEntityModels().bakeLayer(ModelGenericBoots.LAYER_LOCATION));
                }
            }
        });
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        return armorTexture;
    }
}
