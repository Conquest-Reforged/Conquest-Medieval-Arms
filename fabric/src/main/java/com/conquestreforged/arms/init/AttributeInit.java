package com.conquestreforged.arms.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.attributes.Attribute;

public class AttributeInit {
    //public static final EntityAttribute MATERIAL = register("generic.material", )

    private static Attribute register(String id, Attribute attribute) {
        return Registry.register(BuiltInRegistries.ATTRIBUTE, id, attribute);
    }
}
