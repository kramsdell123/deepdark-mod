package com.deepdark.world.biome;

import com.deepdark.deepdark;
import com.deepdark.world.biome.surface.ModMaterialRules;

import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderApi implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, deepdark.MOD_ID, ModMaterialRules.makeRules());
    }
}

