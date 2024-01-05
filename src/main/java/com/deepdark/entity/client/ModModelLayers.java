package com.deepdark.entity.client;

import com.deepdark.deepdark;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer warden_boss = 
        new EntityModelLayer(new Identifier(deepdark.MOD_ID, "warden_boss"), "main");
}
