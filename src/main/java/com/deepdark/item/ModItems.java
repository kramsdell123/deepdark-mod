package com.deepdark.item;

import com.deepdark.deepdark;
import com.deepdark.entity.ModEntities;
import com.deepdark.item.types.WardenArmorItem;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    public static final Item warden_scales = registerItem("warden_scales", new Item(new FabricItemSettings()));

    public static final Item wardens_heart = registerItem("wardens_heart", new Item(new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));


    public static final Item deactivated_warden_pickaxe = registerItem("deactivated_warden_pickaxe", 
        new PickaxeItem(ModToolMaterials.DeactivatedWarden, 1, -2.8f, new FabricItemSettings().maxCount(1)));

    public static final Item deactivated_warden_axe = registerItem("deactivated_warden_axe", 
        new AxeItem(ModToolMaterials.DeactivatedWarden, -4, 0.0F, new FabricItemSettings().maxCount(1)));

    public static final Item deactivated_warden_sword = registerItem("deactivated_warden_sword", 
        new SwordItem(ModToolMaterials.DeactivatedWarden, 3, -2.4F, new FabricItemSettings().maxCount(1)));

    public static final Item deactivated_warden_shovel = registerItem("deactivated_warden_shovel",
        new ShovelItem(ModToolMaterials.DeactivatedWarden, 1.5F, -3.0F, new FabricItemSettings().maxCount(1)));

    public static final Item deactivated_warden_hoe = registerItem("deactivated_warden_hoe",
        new HoeItem(ModToolMaterials.DeactivatedWarden, -4, 0.0F, new FabricItemSettings().maxCount(1)));


    public static final Item warden_pickaxe = registerItem("warden_pickaxe", 
        new PickaxeItem(ModToolMaterials.Warden, 2, 2f, new FabricItemSettings().maxCount(1)));

    public static final Item warden_axe = registerItem("warden_axe", 
        new AxeItem(ModToolMaterials.Warden, 2.5f, 2.5f, new FabricItemSettings().maxCount(1)));

    public static final Item warden_shovel = registerItem("warden_shovel", 
        new ShovelItem(ModToolMaterials.Warden, 2, 2f, new FabricItemSettings().maxCount(1)));

    public static final Item warden_hoe = registerItem("warden_hoe", 
        new HoeItem(ModToolMaterials.Warden, 2, 2f, new FabricItemSettings().maxCount(1)));

    public static final Item warden_sword = registerItem("warden_sword", 
        new SwordItem(ModToolMaterials.Warden, 7, 5f, new FabricItemSettings().maxCount(1)));


    public static final Item deactivated_warden_helmet = registerItem("deactivated_warden_helmet",
        new ArmorItem(ModArmorMaterials.DeactivatedWarden, ArmorItem.Type.HELMET, new FabricItemSettings().maxCount(1)));

    public static final Item deactivated_warden_chestplate = registerItem("deactivated_warden_chestplate",
        new ArmorItem(ModArmorMaterials.DeactivatedWarden, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().maxCount(1)));
        
    public static final Item deactivated_warden_leggings = registerItem("deactivated_warden_leggings",
        new ArmorItem(ModArmorMaterials.DeactivatedWarden, ArmorItem.Type.LEGGINGS, new FabricItemSettings().maxCount(1)));

    public static final Item deactivated_warden_boots = registerItem("deactivated_warden_boots",
        new ArmorItem(ModArmorMaterials.DeactivatedWarden, ArmorItem.Type.BOOTS, new FabricItemSettings().maxCount(1)));
        

    public static final Item warden_helmet = registerItem("warden_helmet", 
        new WardenArmorItem(ModArmorMaterials.Warden, ArmorItem.Type.HELMET, new FabricItemSettings().maxCount(1)));

    public static final Item warden_chestplate = registerItem("warden_chestplate", 
        new WardenArmorItem(ModArmorMaterials.Warden, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().maxCount(1)));

    public static final Item warden_leggings = registerItem("warden_leggings", 
        new WardenArmorItem(ModArmorMaterials.Warden, ArmorItem.Type.LEGGINGS, new FabricItemSettings().maxCount(1)));

    public static final Item warden_boots = registerItem("warden_boots", 
        new WardenArmorItem(ModArmorMaterials.Warden, ArmorItem.Type.BOOTS, new FabricItemSettings().maxCount(1)));


    
    public static final Item warden_boss_spawn_egg = registerItem("warden_boss_spawn_egg",
        new SpawnEggItem(ModEntities.warden_boss, 19942, 0, new FabricItemSettings()));

        

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(deepdark.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register((FabricItemGroupEntries entries) -> {
            entries.add(warden_boss_spawn_egg);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((FabricItemGroupEntries entries) -> {
            entries.add(warden_scales);
            entries.add(wardens_heart);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((FabricItemGroupEntries entries) -> {
            entries.add(warden_pickaxe);
            entries.add(warden_axe);
            entries.add(warden_shovel);
            entries.add(warden_hoe);
            entries.add(deactivated_warden_pickaxe);
            entries.add(deactivated_warden_axe);
            entries.add(deactivated_warden_shovel);
            entries.add(deactivated_warden_hoe);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register((FabricItemGroupEntries entries) -> {
            entries.add(warden_sword);
            entries.add(deactivated_warden_sword);
            entries.add(warden_helmet);
            entries.add(warden_chestplate);
            entries.add(warden_leggings);
            entries.add(warden_boots);
            entries.add(deactivated_warden_helmet);
            entries.add(deactivated_warden_chestplate);
            entries.add(deactivated_warden_leggings);
            entries.add(deactivated_warden_boots);
        });
        deepdark.LOGGER.info("Registered Items");
    }
}
