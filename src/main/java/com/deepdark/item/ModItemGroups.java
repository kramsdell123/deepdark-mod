package com.deepdark.item;
import com.deepdark.deepdark;
import com.deepdark.block.ModBlocks;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup deepdark_group = Registry.register(Registries.ITEM_GROUP, 
    new Identifier(deepdark.MOD_ID, "deepdark_group"),
    FabricItemGroup.builder().displayName(Text.translatable("itemgroup.deepdark"))
    .icon(() -> new ItemStack(Blocks.SCULK_SENSOR)).entries((displayContext, entries) -> {
        entries.add(ModItems.warden_scales);
        entries.add(ModItems.wardens_heart);
        entries.add(ModItems.warden_pickaxe);
        entries.add(ModItems.warden_axe);
        entries.add(ModItems.warden_sword);
        entries.add(ModItems.warden_shovel);
        entries.add(ModItems.warden_hoe);
        entries.add(ModItems.deactivated_warden_pickaxe);
        entries.add(ModItems.deactivated_warden_axe);
        entries.add(ModItems.warden_helmet);
        entries.add(ModItems.warden_chestplate);
        entries.add(ModItems.warden_leggings);
        entries.add(ModItems.warden_boots);
        entries.add(ModBlocks.warden_ore);
        entries.add(ModBlocks.deepslate_warden_ore);
    }).build());
    public static void registerItemGroups() {
        deepdark.LOGGER.info("Registered Item Groups");
    }
}
