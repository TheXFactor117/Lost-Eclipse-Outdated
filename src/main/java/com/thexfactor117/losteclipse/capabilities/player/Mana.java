package com.thexfactor117.losteclipse.capabilities.player;

import javax.annotation.Nullable;

import com.thexfactor117.losteclipse.capabilities.api.IMana;

import net.minecraft.entity.EntityLivingBase;

/**
 * 
 * @author TheXFactor117
 *
 */
public class Mana implements IMana
{
	private float mana;
	private float maxMana;
	private float manaPerSec;
	
	@SuppressWarnings("unused")
	private final EntityLivingBase entity;
	
	public Mana(@Nullable EntityLivingBase entity)
	{
		this.entity = entity;
	}
	
	@Override
	public float getMana() 
	{
		return mana;
	}
	
	@Override
	public void addMana(float amount)
	{
		mana += amount;
	}

	@Override
	public void setMana(float amount) 
	{
		mana = amount;
	}

	@Override
	public float getMaxMana() 
	{
		return maxMana;
	}
	
	@Override
	public void addMaxMana(float amount)
	{
		maxMana += amount;
	}

	@Override
	public void setMaxMana(float amount) 
	{
		maxMana = amount;
	}

	@Override
	public float getManaPerSec() 
	{
		return manaPerSec;
	}
	
	@Override
	public void addManaPerSec(float amount)
	{
		manaPerSec += amount;
	}

	@Override
	public void setManaPerSec(float amount) 
	{
		manaPerSec = amount;
	}
}
