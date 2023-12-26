package com.deepdark.block;

import com.deepdark.deepdark;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block warden_ore = registerBlock("warden_ore",
        new ExperienceDroppingBlock(UniformIntProvider.create(5, 10), FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).strength(30f, 30f)));
    public static final Block deepslate_warden_ore = registerBlock("deepslate_warden_ore",
        new ExperienceDroppingBlock(UniformIntProvider.create(6, 11), FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE).strength(45f, 30f)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(deepdark.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(deepdark.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        deepdark.LOGGER.info("Registered Blocks");
    }
}
