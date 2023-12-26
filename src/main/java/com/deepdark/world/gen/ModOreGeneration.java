package com.deepdark.world.gen;

import com.deepdark.world.ModPlacedFeatures;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModOreGeneration {
    public static void generateOres() {
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), 
            GenerationStep.Feature.UNDERGROUND_ORES, ModPlacedFeatures.warden_ore_placed_key);
    }
}
