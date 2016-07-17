package com.thexfactor117.losteclipse.client.rendering.monsters;

import com.thexfactor117.losteclipse.Reference;
import com.thexfactor117.losteclipse.client.models.ModelGhostBat;
import com.thexfactor117.losteclipse.entities.monsters.EntityGhost;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * 
 * @author TheXFactor117
 *
 */
public class RenderGhost extends RenderLiving<EntityGhost>
{
	protected ResourceLocation ghostBat = new ResourceLocation(Reference.MODID + ":textures/entity/ghost-bat.png");
	
	public RenderGhost(RenderManager manager)
	{
		super(manager, new ModelGhostBat(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGhost entity) 
	{
		return ghostBat;
	}
	
	@Override
	public void doRender(EntityGhost entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);        
    }
}
