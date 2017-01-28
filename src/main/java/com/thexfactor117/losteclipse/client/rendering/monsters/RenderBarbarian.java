package com.thexfactor117.losteclipse.client.rendering.monsters;

import com.thexfactor117.losteclipse.entities.monsters.EntityBarbarian;
import com.thexfactor117.losteclipse.util.Reference;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * 
 * @author TheXFactor117
 *
 */
public class RenderBarbarian extends RenderBiped<EntityBarbarian>
{
	protected ResourceLocation texture = new ResourceLocation(Reference.MODID + ":textures/entity/barbarian.png");
	
	public RenderBarbarian(RenderManager manager)
	{
		super(manager, new ModelBiped(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBarbarian entity) 
	{
		return texture;
	}
}
