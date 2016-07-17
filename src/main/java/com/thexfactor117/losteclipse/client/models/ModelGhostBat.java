package com.thexfactor117.losteclipse.client.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ModelGhostBat extends ModelBase 
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
    public ModelRenderer Head2;
    public ModelRenderer Head3;
    public ModelRenderer Head4;
    public ModelRenderer Hand2;
    public ModelRenderer Hand3;
    public ModelRenderer Hand4;
    public ModelRenderer BatKnob;
    public ModelRenderer BatHandle;
    public ModelRenderer BatBarrel;
    public ModelRenderer BatTip;

    public ModelGhostBat() 
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.Head2 = new ModelRenderer(this, 49, 10);
        this.Head2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head2.addBox(-3.0F, -7.5F, -4.0F, 6, 6, 8, 0.0F);
        this.Hand2 = new ModelRenderer(this, 77, 18);
        this.Hand2.setRotationPoint(8.0F, 2.0F, 0.0F);
        this.Hand2.addBox(-1.5F, -1.5F, -2.5F, 3, 3, 5, 0.0F);
        this.Cloth4 = new ModelRenderer(this, 97, 0);
        this.Cloth4.setRotationPoint(0.0F, 12.0F, 0.0F);
        this.Cloth4.addBox(-2.5F, -1.0F, -2.5F, 5, 5, 5, 0.0F);
        this.setRotateAngle(Cloth4, 0.2617993877991494F, 0.0F, 0.0F);
        this.BatBarrel = new ModelRenderer(this, 0, 36);
        this.BatBarrel.setRotationPoint(8.0F, 0.0F, 0.0F);
        this.BatBarrel.addBox(0.0F, -1.0F, -1.0F, 11, 2, 2, 0.0F);
        this.Cloth6 = new ModelRenderer(this, 16, 7);
        this.Cloth6.setRotationPoint(0.0F, 3.5F, 0.0F);
        this.Cloth6.addBox(-1.5F, -0.5F, -1.5F, 3, 3, 3, 0.0F);
        this.setRotateAngle(Cloth6, 0.2617993877991494F, 0.0F, 0.0F);
        this.Head3 = new ModelRenderer(this, 97, 10);
        this.Head3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head3.addBox(-4.0F, -7.5F, -3.0F, 8, 6, 6, 0.0F);
        this.Hand4 = new ModelRenderer(this, 93, 22);
        this.Hand4.setRotationPoint(8.0F, 2.0F, 0.0F);
        this.Hand4.addBox(-1.5F, -2.5F, -1.5F, 3, 5, 3, 0.0F);
        this.Hand1 = new ModelRenderer(this, 57, 0);
        this.Hand1.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.Hand1.addBox(6.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F);
        this.Cloth3 = new ModelRenderer(this, 73, 0);
        this.Cloth3.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.Cloth3.addBox(-3.0F, 0.0F, -3.0F, 6, 12, 6, 0.0F);
        this.setRotateAngle(Cloth3, 0.08726646259971647F, 0.0F, 0.0F);
        this.Head1 = new ModelRenderer(this, 29, 0);
        this.Head1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head1.addBox(-3.5F, -8.0F, -3.5F, 7, 7, 7, 0.0F);
        this.setRotateAngle(Head1, -0.08726646259971647F, 0.0F, 0.0F);
        this.Cloth8 = new ModelRenderer(this, 0, 0);
        this.Cloth8.setRotationPoint(0.0F, 1.5F, 0.0F);
        this.Cloth8.addBox(-0.5F, -0.2F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(Cloth8, 0.2617993877991494F, 0.0F, 0.0F);
        this.Cloth2 = new ModelRenderer(this, 16, 0);
        this.Cloth2.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.Cloth2.addBox(-2.5F, 0.0F, -2.5F, 5, 2, 5, 0.0F);
        this.setRotateAngle(Cloth2, 0.08726646259971647F, 0.0F, 0.0F);
        this.Head4 = new ModelRenderer(this, 10, 13);
        this.Head4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Head4.addBox(-3.0F, -8.5F, -3.0F, 6, 8, 6, 0.0F);
        this.BatTip = new ModelRenderer(this, 0, 40);
        this.BatTip.setRotationPoint(11.0F, 0.0F, 0.0F);
        this.BatTip.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.Cloth1 = new ModelRenderer(this, 0, 0);
        this.Cloth1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Cloth1.addBox(-2.0F, 1.0F, -2.0F, 4, 2, 4, 0.0F);
        this.setRotateAngle(Cloth1, 0.08726646259971647F, 0.0F, 0.0F);
        this.Hand3 = new ModelRenderer(this, 34, 21);
        this.Hand3.setRotationPoint(8.0F, 2.0F, 0.0F);
        this.Hand3.addBox(-2.5F, -1.5F, -1.5F, 5, 3, 3, 0.0F);
        this.BatHandle = new ModelRenderer(this, 0, 34);
        this.BatHandle.setRotationPoint(-4.0F, 0.0F, 0.0F);
        this.BatHandle.addBox(0.0F, -0.5F, -0.5F, 8, 1, 1, 0.0F);
        this.BatKnob = new ModelRenderer(this, 0, 30);
        this.BatKnob.setRotationPoint(8.0F, 2.0F, 0.0F);
        this.BatKnob.addBox(-4.5F, -1.0F, -1.0F, 1, 2, 2, 0.0F);
        this.Cloth5 = new ModelRenderer(this, 0, 6);
        this.Cloth5.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.Cloth5.addBox(-2.0F, -0.5F, -2.0F, 4, 4, 4, 0.0F);
        this.setRotateAngle(Cloth5, 0.2617993877991494F, 0.0F, 0.0F);
        this.Cloth7 = new ModelRenderer(this, 12, 0);
        this.Cloth7.setRotationPoint(0.0F, 2.5F, 0.0F);
        this.Cloth7.addBox(-1.0F, -0.5F, -1.0F, 2, 2, 2, 0.0F);
        this.setRotateAngle(Cloth7, 0.2617993877991494F, 0.0F, 0.0F);
        this.Head1.addChild(this.Head2);
        this.Hand1.addChild(this.Hand2);
        this.Cloth3.addChild(this.Cloth4);
        this.BatHandle.addChild(this.BatBarrel);
        this.Cloth5.addChild(this.Cloth6);
        this.Head1.addChild(this.Head3);
        this.Hand1.addChild(this.Hand4);
        this.Cloth1.addChild(this.Hand1);
        this.Cloth2.addChild(this.Cloth3);
        this.Cloth1.addChild(this.Head1);
        this.Cloth7.addChild(this.Cloth8);
        this.Cloth1.addChild(this.Cloth2);
        this.Head1.addChild(this.Head4);
        this.BatBarrel.addChild(this.BatTip);
        this.Hand1.addChild(this.Hand3);
        this.BatKnob.addChild(this.BatHandle);
        this.Hand1.addChild(this.BatKnob);
        this.Cloth4.addChild(this.Cloth5);
        this.Cloth6.addChild(this.Cloth7);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) 
    { 
        super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    	this.Cloth1.render(scale);
    	this.Head1.rotateAngleY = netHeadYaw / (180F / (float)Math.PI);
        this.Head1.rotateAngleX = headPitch / (180F / (float)Math.PI);
    }
    
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
