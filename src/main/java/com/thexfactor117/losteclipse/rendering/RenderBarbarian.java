package com.thexfactor117.losteclipse.rendering;

import com.thexfactor117.losteclipse.Reference;
import com.thexfactor117.losteclipse.entities.monsters.EntityBarbarian;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

/**
 * 
 * @author TheXFactor117
 *
 */
@SuppressWarnings("rawtypes")
public class RenderBarbarian extends RenderLiving
{
	protected ResourceLocation texture;
	
	public RenderBarbarian(RenderManager manager, ModelBase base, float shadowSize)
	{
		super(manager, base, shadowSize);
		
	}
	
	@Override
    protected void preRenderCallback(EntityLivingBase entity, float f)
    {
        preRenderCallbackSerpent((EntityBarbarian) entity, f);
    }
  
    protected void preRenderCallbackSerpent(EntityBarbarian entity, float f)
    {
        // some people do some G11 transformations or blends here, like you can do
        // GL11.glScalef(2F, 2F, 2F); to scale up the entity
        // which is used for Slime entities.  I suggest having the entity cast to
        // your custom type to make it easier to access fields from your 
        // custom entity, eg. GL11.glScalef(entity.scaleFactor, entity.scaleFactor, 
        // entity.scaleFactor); 
    }

    protected void setEntityTexture()
    {
        texture = new ResourceLocation(Reference.MODID + ":textures/entity/barbarian.png");
    }

    /**
    * Returns the location of an entity's texture. Doesn't seem to be called 
    * unless you call Render.bindEntityTexture.
    */
    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return texture;
    }
}
