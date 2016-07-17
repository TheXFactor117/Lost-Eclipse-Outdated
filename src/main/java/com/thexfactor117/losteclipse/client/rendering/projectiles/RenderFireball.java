package com.thexfactor117.losteclipse.client.rendering.projectiles;

import com.thexfactor117.losteclipse.entities.projectiles.EntityFireball;
import com.thexfactor117.losteclipse.init.ModItems;
import com.thexfactor117.losteclipse.client.rendering.RenderModProjectile;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.ItemStack;

/**
 * 
 * @author TheXFactor117
 *
 */
public class RenderFireball<T extends EntityFireball> extends RenderModProjectile<T>
{
	public RenderFireball(RenderManager renderManager) 
	{
		super(renderManager);
	}
	
	@Override
	public ItemStack getStackToRender(T entityIn)
    {
        return new ItemStack(ModItems.astrillGemFragment);
    }
}