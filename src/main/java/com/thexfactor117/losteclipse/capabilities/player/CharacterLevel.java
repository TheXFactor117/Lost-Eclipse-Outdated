package com.thexfactor117.losteclipse.capabilities.player;

import javax.annotation.Nullable;

import com.thexfactor117.losteclipse.LostEclipse;
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
	private int skillPoints;
	
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
		level++;
		addSkillPoint();
		LostEclipse.LOGGER.info("Level increased to " + level + "\tSkill Points: " + skillPoints);
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
		experience += amount;
		
		if (experience >= getLevelUpExperience())
			increaseLevel();
	}

	@Override
	public void setExperience(int amount) 
	{
		experience = amount;
	}

	@Override
	public int getLevelUpExperience() 
	{
		return 20 * level;
	}
	
	@Override
	public int getSkillPoints()
	{
		return skillPoints;
	}
	
	@Override
	public void addSkillPoint()
	{
		skillPoints++;
	}
	
	@Override
	public void setSkillPoints(int amount)
	{
		skillPoints = amount;
	}
}
