package com.conquestreforged.arms.items.armor;

import com.conquestreforged.arms.items.armor.models.ModelArabianHelmet;
import com.conquestreforged.arms.items.armor.models.ModelFatimidHelmet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.IItemRenderProperties;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class ArabianHelmItem extends ArmorModelItem {

    public ArabianHelmItem(ArmorMaterial material, EquipmentSlot head, Properties props, String armorTexture) {
        super(material, head, props, armorTexture);
    }

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {
            @Nullable
            @Override
            public HumanoidModel<?> getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> _default) {
                return new ModelArabianHelmet<>(Minecraft.getInstance().getEntityModels().bakeLayer(ModelArabianHelmet.LAYER_LOCATION));
            }
        });
    }
}
