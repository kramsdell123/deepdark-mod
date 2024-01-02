package com.deepdark.entity.effect;

import com.deepdark.deepdark;
import com.deepdark.entity.effect.types.WardenPowerStatusEffect;

import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModStatusEffects {

    public static StatusEffect warden_power;

    private static StatusEffect registerStatusEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(deepdark.MOD_ID, name), effect);
    }

    public static void registerStatusEffects() {
        warden_power = registerStatusEffect("warden_power", new WardenPowerStatusEffect(StatusEffectCategory.BENEFICIAL, 15559))
            .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, "5c73e542-b6d9-411e-875d-7a5bfba8d2d7", 10000, Operation.ADDITION)
            .addAttributeModifier(EntityAttributes.GENERIC_MAX_HEALTH, "ec1ddf98-ef06-4efa-b095-6dc6e2eb3893", 40.0, Operation.ADDITION);
        deepdark.LOGGER.info("Registered Status Effects");
    }
}
