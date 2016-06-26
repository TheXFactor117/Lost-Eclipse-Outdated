package com.thexfactor117.losteclipse.rendering.projectiles;

import com.thexfactor117.losteclipse.entities.projectiles.EntityMagic;
import com.thexfactor117.losteclipse.init.ModItems;
import com.thexfactor117.losteclipse.rendering.RenderModProjectile;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.ItemStack;

/**
 * 
 * @author TheXFactor117
 *
 */
public class RenderLightning<T extends EntityMagic> extends RenderModProjectile<T>
{
	public RenderLightning(RenderManager renderManager) 
	{
		super(renderManager);
	}
	
	@Override
	public ItemStack getStackToRender(T entityIn)
    {
        return new ItemStack(ModItems.astrillGemFragment);
    }
}