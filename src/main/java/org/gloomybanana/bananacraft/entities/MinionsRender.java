package org.gloomybanana.bananacraft.entities;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.gloomybanana.bananacraft.BananaCraft;

public class MinionsRender extends MobRenderer<MinionsEntity,MinionsModel> {
    public MinionsRender(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new MinionsModel(), 1F);
    }


    public MinionsRender(EntityRendererManager renderManagerIn, MinionsModel entityModelIn, float shadowSizeIn) {
        super(renderManagerIn, entityModelIn, shadowSizeIn);
    }

    @Override
    public ResourceLocation getEntityTexture(MinionsEntity entity) {
        return new ResourceLocation(BananaCraft.MOD_ID, "textures/entity/minions.png");
    }
}
