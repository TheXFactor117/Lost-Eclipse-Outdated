package com.thexfactor117.losteclipse.capabilities.player;

import javax.annotation.Nullable;

import com.thexfactor117.losteclipse.capabilities.api.IMaxMana;

import net.minecraft.entity.EntityLivingBase;

/**
 * 
 * @author TheXFactor117
 *
 */
public class MaxMana implements IMaxMana
{
	private int mana;
	@SuppressWarnings("unused")
	private final EntityLivingBase entity;
	
	public MaxMana(@Nullable EntityLivingBase entity)
	{
		this.entity = entity;
	}
	
	@Override
	public int getMaxMana() 
	{
		return mana;
	}

	@Override
	public void setMaxMana(int amount) 
	{
		mana = amount;
	}
}
