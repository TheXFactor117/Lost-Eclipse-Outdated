package com.thexfactor117.losteclipse.client.rendering.monsters;

import com.thexfactor117.losteclipse.Reference;
import com.thexfactor117.losteclipse.client.models.ModelBanshee;
import com.thexfactor117.losteclipse.entities.monsters.EntityBanshee;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * 
 * @author TheXFactor117
 *
 */
public class RenderBanshee extends RenderLiving<EntityBanshee>
{
	protected ResourceLocation banshee = new ResourceLocation(Reference.MODID + ":textures/entity/banshee.png");
	
	public RenderBanshee(RenderManager manager)
	{
		super(manager, new ModelBanshee(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBanshee entity) 
	{
		return banshee;
	}
}
