package org.gloomybanana.bananacraft.entities;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class MinionsModel extends EntityModel<MinionsEntity> {
    private final ModelRenderer body;
    private final ModelRenderer left_arm;
    private final ModelRenderer right_arm;
    private final ModelRenderer left_leg;
    private final ModelRenderer right_leg;
    private final ModelRenderer left_eye;
    private final ModelRenderer right_eye;

    public MinionsModel() {
        textureWidth = 32;
        textureHeight = 32;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 16.0F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-2.0F, -4.0F, -4.0F, 6.0F, 10.0F, 8.0F, 0.0F, false);

        left_arm = new ModelRenderer(this);
        left_arm.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(left_arm);
        left_arm.setTextureOffset(4, 0).addBox(0.0F, 0.0F, 4.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        right_arm = new ModelRenderer(this);
        right_arm.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(right_arm);
        right_arm.setTextureOffset(0, 0).addBox(0.0F, 0.0F, -5.0F, 1.0F, 5.0F, 1.0F, 0.0F, false);

        left_leg = new ModelRenderer(this);
        left_leg.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(left_leg);
        left_leg.setTextureOffset(9, 20).addBox(1.0F, 6.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        left_leg.setTextureOffset(10, 18).addBox(0.0F, 7.0F, 1.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        right_leg = new ModelRenderer(this);
        right_leg.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(right_leg);
        right_leg.setTextureOffset(5, 20).addBox(1.0F, 6.0F, -2.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        right_leg.setTextureOffset(4, 18).addBox(0.0F, 7.0F, -2.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        left_eye = new ModelRenderer(this);
        left_eye.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(left_eye);
        left_eye.setTextureOffset(16, 18).addBox(-3.0F, -3.0F, 3.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        left_eye.setTextureOffset(16, 18).addBox(-3.0F, -3.0F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        left_eye.setTextureOffset(0, 18).addBox(-3.0F, -4.0F, 1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        left_eye.setTextureOffset(0, 18).addBox(-3.0F, -1.0F, 1.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        right_eye = new ModelRenderer(this);
        right_eye.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(right_eye);
        right_eye.setTextureOffset(16, 18).addBox(-3.0F, -3.0F, -1.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        right_eye.setTextureOffset(16, 18).addBox(-3.0F, -3.0F, -4.0F, 1.0F, 2.0F, 1.0F, 0.0F, false);
        right_eye.setTextureOffset(0, 18).addBox(-3.0F, -4.0F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        right_eye.setTextureOffset(0, 18).addBox(-3.0F, -1.0F, -3.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(MinionsEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        body.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
