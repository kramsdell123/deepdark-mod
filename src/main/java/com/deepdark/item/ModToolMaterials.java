package com.deepdark.item;

import java.util.function.Supplier;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public enum ModToolMaterials implements ToolMaterial {
    DeactivatedWarden(5, 2031, 9.0F, 4.0F, 15, () -> Ingredient.ofItems(ModItems.warden_scales)),
    Warden(6, 10000, 300f, 4f, 50, () -> Ingredient.ofItems(ModItems.wardens_heart));
    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient){
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
    
}
