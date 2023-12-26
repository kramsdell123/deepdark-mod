package com.deepdark.world.biome;

import com.deepdark.deepdark;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;

public class ModBiomes {
    public static final RegistryKey<Biome> deep_dark_dimension = RegistryKey.of(RegistryKeys.BIOME, new Identifier(deepdark.MOD_ID, "deep_dark_dimension"));
}
