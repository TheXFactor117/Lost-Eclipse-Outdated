package com.thexfactor117.losteclipse.capabilities.player;

import javax.annotation.Nullable;

import com.thexfactor117.losteclipse.capabilities.api.ISkillTree;

import net.minecraft.entity.EntityLivingBase;

/**
 * 
 * @author TheXFactor117
 *
 */
public class SkillTree implements ISkillTree
{
	private int fortificationTier;
	private int heavyLiftingTier;
	private int vigorTier;
	private int regenerationTier;
	private int powerTier;
	private int swordsmanTier;
	private int bruteTier;
	
	@SuppressWarnings("unused")
	private final EntityLivingBase entity;
	
	public SkillTree(@Nullable EntityLivingBase entity)
	{
		this.entity = entity;
	}

	@Override
	public int getFortificationTier() 
	{
		return fortificationTier;
	}

	@Override
	public void setFortificationTier(int tier) 
	{
		fortificationTier = tier;
	}

	@Override
	public int getHeavyLiftingTier() 
	{
		return heavyLiftingTier;
	}

	@Override
	public void setHeavyLiftingTier(int tier) 
	{
		heavyLiftingTier = tier;
	}

	@Override
	public int getVigorTier() 
	{
		return vigorTier;
	}

	@Override
	public void setVigorTier(int tier) 
	{
		vigorTier = tier;
	}

	@Override
	public int getRegenerationTier() 
	{
		return regenerationTier;
	}

	@Override
	public void setRegenerationTier(int tier) 
	{
		regenerationTier = tier;
	}

	@Override
	public int getPowerTier() 
	{
		return powerTier;
	}

	@Override
	public void setPowerTier(int tier) 
	{
		powerTier = tier;
	}

	@Override
	public int getSwordsmanTier() 
	{
		return swordsmanTier;
	}

	@Override
	public void setSwordsmanTier(int tier) 
	{
		swordsmanTier = tier;
	}

	@Override
	public int getBruteTier() 
	{
		return bruteTier;
	}

	@Override
	public void setBruteTier(int tier) 
	{
		bruteTier = tier;
	}
}
