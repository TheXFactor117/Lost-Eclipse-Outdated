package com.thexfactor117.losteclipse.capabilities.player;

import javax.annotation.Nullable;

import com.thexfactor117.losteclipse.capabilities.api.ICharacterLevel;

import net.minecraft.entity.EntityLivingBase;

/**
 * 
 * @author TheXFactor117
 *
 */
public class CharacterLevel implements ICharacterLevel
{
	private int level;
	private int experience;
	
	@SuppressWarnings("unused")
	private final EntityLivingBase entity;
	
	public CharacterLevel(@Nullable EntityLivingBase entity)
	{
		this.entity = entity;
		this.level = 1;
		this.experience = 0;
	}

	@Override
	public int getLevel() 
	{
		return level;
	}
	
	@Override
	public void increaseLevel()
	{
		this.level++;
	}

	@Override
	public void setLevel(int level) 
	{
		this.level = level;
	}

	@Override
	public int getExperience() 
	{
		return experience;
	}
	
	@Override
	public void addExperience(int amount)
	{
		this.experience += amount;
	}

	@Override
	public void setExperience(int amount) 
	{
		this.experience = amount;
	}

	@Override
	public int getLevelUpExperience(int currentLevel) 
	{
		return 0;
	}
}
