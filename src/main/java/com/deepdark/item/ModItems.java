package com.deepdark.item;

import com.deepdark.deepdark;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item warden_scales = registerItem("warden_scales", new Item(new FabricItemSettings()));

    public static final Item wardens_heart = registerItem("wardens_heart", new Item(new FabricItemSettings()));


    public static final Item deactivated_warden_pickaxe = registerItem("deactivated_warden_pickaxe", 
        new Item(new FabricItemSettings().maxCount(1)));

    public static final Item deactivated_warden_axe = registerItem("deactivated_warden_axe", 
        new Item(new FabricItemSettings().maxCount(1)));


    public static final Item warden_pickaxe = registerItem("warden_pickaxe", 
        new PickaxeItem(ModToolMaterial.Warden, 2, 2f, new FabricItemSettings().maxCount(1)));

    public static final Item warden_axe = registerItem("warden_axe", 
        new AxeItem(ModToolMaterial.Warden, 2.5f, 2.5f, new FabricItemSettings().maxCount(1)));

    public static final Item warden_shovel = registerItem("warden_shovel", 
        new ShovelItem(ModToolMaterial.Warden, 2, 2f, new FabricItemSettings().maxCount(1)));

    public static final Item warden_hoe = registerItem("warden_hoe", 
        new HoeItem(ModToolMaterial.Warden, 2, 2f, new FabricItemSettings().maxCount(1)));

    public static final Item warden_sword = registerItem("warden_sword", 
        new SwordItem(ModToolMaterial.Warden, 7, 5f, new FabricItemSettings().maxCount(1)));



    public static final Item warden_helmet = registerItem("warden_helmet", 
        new ArmorItem(ModArmorMaterials.Warden, ArmorItem.Type.HELMET, new FabricItemSettings().maxCount(1)));

    public static final Item warden_chestplate = registerItem("warden_chestplate", 
        new ArmorItem(ModArmorMaterials.Warden, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().maxCount(1)));

    public static final Item warden_leggings = registerItem("warden_leggings", 
        new ArmorItem(ModArmorMaterials.Warden, ArmorItem.Type.LEGGINGS, new FabricItemSettings().maxCount(1)));

    public static final Item warden_boots = registerItem("warden_boots", 
        new ArmorItem(ModArmorMaterials.Warden, ArmorItem.Type.BOOTS, new FabricItemSettings().maxCount(1)));

        

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(deepdark.MOD_ID, name), item);
    }
    public static void registerModItems() {
        deepdark.LOGGER.info("Registered Items");
    }
}
