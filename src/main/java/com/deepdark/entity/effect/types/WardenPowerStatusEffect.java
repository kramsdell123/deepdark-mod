package com.deepdark.entity.effect.types;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class WardenPowerStatusEffect extends StatusEffect {

    public WardenPowerStatusEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        super.onApplied(entity, amplifier);
        entity.heal(10f);
        if(entity instanceof PlayerEntity player) {
            player.getHungerManager().add(20, 0);
        }
    }

}