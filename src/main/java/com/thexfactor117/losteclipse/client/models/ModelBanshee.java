package com.thexfactor117.losteclipse.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ModelBanshee extends ModelBase 
{
    public ModelRenderer Cloth1;
    public ModelRenderer Cloth2;
    public ModelRenderer Head1;
    public ModelRenderer Hand1;
    public ModelRenderer Cloth3;
    public ModelRenderer Cloth4;
    public ModelRenderer Cloth5;
    public ModelRenderer Cloth6;
    public ModelRenderer Cloth7;
    public ModelRenderer Cloth8;
    public ModelRenderer Cloth9;
    public ModelRenderer Head2;
    public ModelRenderer Head3;
    public ModelRenderer Head4;
    public ModelRenderer Hand2;
    public ModelRenderer Hand3;
    public ModelRenderer Hand4;
    public ModelRenderer SwordPommel;
    public ModelRenderer SwordHandle;
    public ModelRenderer SwordCrossGuard1;
    public ModelRenderer SwordCrossGuard2;
    public ModelRenderer SwordBlade;
    public ModelRenderer SwordTip1;
    public ModelRenderer SwordTip2;

    public ModelBanshee() 
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.SwordPommel = new ModelRenderer(this, 0, 40);
        this.SwordPommel.setRotationPoint(10.5F, 0.0F, 0.0F);
        this.SwordPommel.addBox(-4.5F, -0.5F, -1.0F, 1, 1, 2, 0.0F);
        this.Hand3 = new ModelRenderer(this, 107, 30);
        this.Hand3.setRotationPoint(10.5F, 0.0F, 0.0F);
        this.Hand3.addBox(-3.0F, -2.0F, -2.0F, 6, 4, 4, 0.0F);
        this.Cloth5 = new ModelRenderer(this, 68, 10);
        this.Cloth5.setRotationPoint(0.0F, 3.5F, 0.0F);
        this.Cloth5.addBox(-2.5F, -0.5F, -2.5F, 5, 4, 5, 0.0F);
        this.setRotateAngle(Cloth5, 0.2617993877991494F, 0.0F, 0.0F);
        this.Hand2 = new ModelRenderer(this, 107, 20);
        this.Hand2.setRotationPoint(10.5F, 0.0F, 0.0F);
        this.Hand2.addBox(-2.0F, -2.0F, -3.0F, 4, 4, 6, 0.0F);
        this.Hand4 = new ModelRenderer(this, 0, 28);
        this.Hand4.setRotationPoint(10.5F, 0.0F, 0.0F);
        this.Hand4.addBox(-2.0F, -3.0F, -2.0F, 4, 6, 4, 0.0F);
        this.Head1 = new ModelRenderer(this, 36, 0);
        this.Head1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head1.addBox(-4.0F, -8.5F, -4.0F, 8, 8, 8, 0.0F);
        this.setRotateAngle(Head1, -0.08726646259971647F, 0.0F, 0.0F);
        this.SwordCrossGuard2 = new ModelRenderer(this, 12, 44);
        this.SwordCrossGuard2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.SwordCrossGuard2.addBox(0.5F, -0.5F, -3.0F, 1, 1, 6, 0.0F);
        this.Cloth4 = new ModelRenderer(this, 0, 7);
        this.Cloth4.setRotationPoint(0.0F, 13.0F, 0.0F);
        this.Cloth4.addBox(-3.0F, -1.0F, -3.0F, 6, 5, 6, 0.0F);
        this.setRotateAngle(Cloth4, 0.2617993877991494F, 0.0F, 0.0F);
        this.Head2 = new ModelRenderer(this, 15, 16);
        this.Head2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head2.addBox(-3.5F, -8.0F, -4.5F, 7, 7, 9, 0.0F);
        this.Cloth3 = new ModelRenderer(this, 88, 0);
        this.Cloth3.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Cloth3.addBox(-3.5F, 0.0F, -3.5F, 7, 13, 7, 0.0F);
        this.setRotateAngle(Cloth3, 0.08726646259971647F, 0.0F, 0.0F);
        this.Cloth6 = new ModelRenderer(this, 109, 0);
        this.Cloth6.setRotationPoint(0.0F, 3.5F, 0.0F);
        this.Cloth6.addBox(-2.0F, -0.5F, -2.0F, 4, 3, 4, 0.0F);
        this.setRotateAngle(Cloth6, 0.2617993877991494F, 0.0F, 0.0F);
        this.Cloth7 = new ModelRenderer(this, 60, 0);
        this.Cloth7.setRotationPoint(0.0F, 2.5F, 0.0F);
        this.Cloth7.addBox(-1.5F, -0.5F, -1.5F, 3, 2, 3, 0.0F);
        this.setRotateAngle(Cloth7, 0.2617993877991494F, 0.0F, 0.0F);
        this.Cloth8 = new ModelRenderer(this, 15, 0);
        this.Cloth8.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.Cloth8.addBox(-1.0F, -0.2F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(Cloth8, 0.2617993877991494F, 0.0F, 0.0F);
        this.Head4 = new ModelRenderer(this, 79, 20);
        this.Head4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head4.addBox(-3.5F, -9.0F, -3.5F, 7, 9, 7, 0.0F);
        this.Cloth1 = new ModelRenderer(this, 0, 0);
        this.Cloth1.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.Cloth1.addBox(-2.5F, 1.0F, -2.5F, 5, 2, 5, 0.0F);
        this.setRotateAngle(Cloth1, 0.08726646259971647F, 0.0F, 0.0F);
        this.Cloth2 = new ModelRenderer(this, 20, 0);
        this.Cloth2.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.Cloth2.addBox(-3.0F, 0.0F, -3.0F, 6, 2, 6, 0.0F);
        this.setRotateAngle(Cloth2, 0.08726646259971647F, 0.0F, 0.0F);
        this.SwordTip1 = new ModelRenderer(this, 0, 55);
        this.SwordTip1.setRotationPoint(12.0F, 0.0F, 0.0F);
        this.SwordTip1.addBox(0.0F, -0.5F, -1.0F, 2, 1, 2, 0.0F);
        this.SwordTip2 = new ModelRenderer(this, 0, 58);
        this.SwordTip2.setRotationPoint(2.0F, 0.0F, 0.0F);
        this.SwordTip2.addBox(0.0F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.Cloth9 = new ModelRenderer(this, 0, 0);
        this.Cloth9.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.Cloth9.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Cloth9, 0.2617993877991494F, 0.0F, 0.0F);
        this.SwordCrossGuard1 = new ModelRenderer(this, 0, 45);
        this.SwordCrossGuard1.setRotationPoint(7.0F, 0.0F, 0.0F);
        this.SwordCrossGuard1.addBox(0.0F, -1.0F, -2.0F, 2, 2, 4, 0.0F);
        this.Head3 = new ModelRenderer(this, 47, 19);
        this.Head3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head3.addBox(-4.5F, -8.0F, -3.5F, 9, 7, 7, 0.0F);
        this.SwordHandle = new ModelRenderer(this, 0, 43);
        this.SwordHandle.setRotationPoint(-3.5F, 0.0F, 0.0F);
        this.SwordHandle.addBox(0.0F, -0.5F, -0.5F, 7, 1, 1, 0.0F);
        this.Hand1 = new ModelRenderer(this, 68, 0);
        this.Hand1.setRotationPoint(0.0F, 8.0F, 1.0F);
        this.Hand1.addBox(8.0F, -2.5F, -2.5F, 5, 5, 5, 0.0F);
        this.SwordBlade = new ModelRenderer(this, 0, 51);
        this.SwordBlade.setRotationPoint(2.0F, 0.0F, 0.0F);
        this.SwordBlade.addBox(0.0F, -0.5F, -1.5F, 12, 1, 3, 0.0F);
        this.Hand1.addChild(this.SwordPommel);
        this.Hand1.addChild(this.Hand3);
        this.Cloth4.addChild(this.Cloth5);
        this.Hand1.addChild(this.Hand2);
        this.Hand1.addChild(this.Hand4);
        this.Cloth1.addChild(this.Head1);
        this.SwordCrossGuard1.addChild(this.SwordCrossGuard2);
        this.Cloth3.addChild(this.Cloth4);
        this.Head1.addChild(this.Head2);
        this.Cloth2.addChild(this.Cloth3);
        this.Cloth5.addChild(this.Cloth6);
        this.Cloth6.addChild(this.Cloth7);
        this.Cloth7.addChild(this.Cloth8);
        this.Head1.addChild(this.Head4);
        this.Cloth1.addChild(this.Cloth2);
        this.SwordBlade.addChild(this.SwordTip1);
        this.SwordTip1.addChild(this.SwordTip2);
        this.Cloth8.addChild(this.Cloth9);
        this.SwordHandle.addChild(this.SwordCrossGuard1);
        this.Head1.addChild(this.Head3);
        this.SwordPommel.addChild(this.SwordHandle);
        this.Cloth1.addChild(this.Hand1);
        this.SwordCrossGuard1.addChild(this.SwordBlade);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) 
    { 
    	super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    	this.Cloth1.render(scale);
        this.Head1.rotateAngleY = netHeadYaw / (180F / (float)Math.PI);
        this.Head1.rotateAngleX = headPitch / (180F / (float)Math.PI);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
