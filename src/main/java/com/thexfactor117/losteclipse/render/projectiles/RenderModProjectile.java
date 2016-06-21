package com.thexfactor117.losteclipse.render.projectiles;

import com.thexfactor117.losteclipse.Reference;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderTippedArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 
 * @author TheXFactor117
 *
 */
@SideOnly(Side.CLIENT)
public class RenderModProjectile extends RenderTippedArrow
{
	private static final ResourceLocation ENTITY_TEXTURE = new ResourceLocation(Reference.MODID, "textures/entity/entityMagic.png");

	public RenderModProjectile(RenderManager renderManager) 
	{
		super(renderManager);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityTippedArrow entity) 
	{
		return ENTITY_TEXTURE;
	}
}
