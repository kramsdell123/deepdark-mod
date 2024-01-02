package com.deepdark.item.types;

import com.deepdark.entity.effect.ModStatusEffects;
import com.deepdark.item.ModItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class WardenArmorItem extends ArmorItem {
    public WardenArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                try{
                    WardenArmorItem helmet = (WardenArmorItem) player.getInventory().getArmorStack(3).getItem();
                    WardenArmorItem chestPlate = (WardenArmorItem) player.getInventory().getArmorStack(2).getItem();
                    WardenArmorItem leggings = (WardenArmorItem) player.getInventory().getArmorStack(1).getItem();
                    WardenArmorItem boots = (WardenArmorItem) player.getInventory().getArmorStack(0).getItem();
                    
                    if(
                        helmet == ModItems.warden_helmet&&
                        chestPlate == ModItems.warden_chestplate&&
                        leggings == ModItems.warden_leggings&&
                        boots == ModItems.warden_boots
                    ) {
                        player.addStatusEffect(new StatusEffectInstance(ModStatusEffects.warden_power, 1, 0, true, false, true));
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 1, 10000, true, false, false));
                    }
                } catch(ClassCastException e) {}
            }
        }
    }
}
