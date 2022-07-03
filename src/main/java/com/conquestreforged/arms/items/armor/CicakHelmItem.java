package com.conquestreforged.arms.items.armor;

import com.conquestreforged.arms.items.armor.models.ModelCicakHelmet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.IItemRenderProperties;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class CicakHelmItem extends ArmorModelItem {

    public CicakHelmItem(ArmorMaterial material, EquipmentSlot head, Properties props, String armorTexture, Float cloth, Float mail, Float plate) {
        super(material, head, props, armorTexture, cloth, mail, plate);
    }

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {
            @Nullable
            @Override
            public HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
                return new ModelCicakHelmet<>(Minecraft.getInstance().getEntityModels().bakeLayer(ModelCicakHelmet.LAYER_LOCATION));
            }
        });
    }

}
