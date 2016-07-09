package com.thexfactor117.losteclipse.capabilities.player;

import javax.annotation.Nullable;

import com.thexfactor117.losteclipse.api.capabilities.IFlameCloak;

import net.minecraft.entity.EntityLivingBase;

/**
 * 
 * @author TheXFactor117
 *
 */
public class FlameCloak implements IFlameCloak
{
	private boolean hasFlameCloak;
	@SuppressWarnings("unused")
	private final EntityLivingBase entity;
	
	public FlameCloak(@Nullable EntityLivingBase entity)
	{
		this.entity = entity;
	}

	@Override
	public boolean hasFlameCloak()
	{
		return hasFlameCloak;
	}

	@Override
	public void setFlameCloak(boolean value) 
	{
		hasFlameCloak = value;
	}
}
