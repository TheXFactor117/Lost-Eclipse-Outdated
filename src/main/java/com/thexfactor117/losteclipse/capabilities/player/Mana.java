package com.thexfactor117.losteclipse.capabilities.player;

import javax.annotation.Nullable;

import com.thexfactor117.losteclipse.capabilities.api.IMana;

import net.minecraft.entity.EntityLivingBase;

public class Mana implements IMana
{
	private int mana;
	@SuppressWarnings("unused")
	private final EntityLivingBase entity;
	
	public Mana(@Nullable EntityLivingBase entity)
	{
		this.entity = entity;
	}
	
	@Override
	public int getMana() 
	{
		return mana;
	}

	@Override
	public void setMana(int amount) 
	{
		mana = amount;
	}
}
