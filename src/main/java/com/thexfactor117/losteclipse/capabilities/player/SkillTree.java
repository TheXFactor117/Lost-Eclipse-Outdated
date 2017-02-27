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
	// warrior
	private int fortificationTier;
	private int heavyLiftingTier;
	private int vigorTier;
	private int regenerationTier;
	private int powerTier;
	private int swordsmanTier;
	private int bruteTier;
	
	// hunter
	private int protectionTier;
	private int archeryTier;
	private int quickDrawTier;
	private int recoveryTier;
	private int paralyzeTier;
	
	// mage
	private int manaTier;
	private int sorceryTier;
	private int knowledgeTier;
	private int mastermindTier;
	
	// assassin
	private int agilityTier;
	private int precisionTier;
	private int slashTier;
	private int criticalTier;
	private int destructionTier;
	
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

	@Override
	public int getProtectionTier() 
	{
		return protectionTier;
	}

	@Override
	public void setProtectionTier(int tier) 
	{
		protectionTier = tier;
	}

	@Override
	public int getArcheryTier() 
	{
		return archeryTier;
	}

	@Override
	public void setArcheryTier(int tier) 
	{
		archeryTier = tier;
	}

	@Override
	public int getQuickDrawTier() 
	{
		return quickDrawTier;
	}

	@Override
	public void setQuickDrawTier(int tier) 
	{
		quickDrawTier = tier;
	}

	@Override
	public int getRecoveryTier() 
	{
		return recoveryTier;
	}

	@Override
	public void setRecoveryTier(int tier) 
	{
		recoveryTier = tier;
	}

	@Override
	public int getParalyzeTier() 
	{
		return paralyzeTier;
	}

	@Override
	public void setParalyzeTier(int tier) 
	{
		paralyzeTier = tier;
	}

	@Override
	public int getManaTier() 
	{
		return manaTier;
	}

	@Override
	public void setManaTier(int tier) 
	{
		manaTier = tier;
	}

	@Override
	public int getSorceryTier() 
	{
		return sorceryTier;
	}

	@Override
	public void setSorceryTier(int tier) 
	{
		sorceryTier = tier;
	}

	@Override
	public int getKnowledgeTier() 
	{
		return knowledgeTier;
	}

	@Override
	public void setKnowledgeTier(int tier) 
	{
		knowledgeTier = tier;
	}

	@Override
	public int getMastermindTier()
	{
		return mastermindTier;
	}

	@Override
	public void setMastermindTier(int tier) 
	{
		mastermindTier = tier;
	}

	@Override
	public int getAgilityTier() 
	{
		return agilityTier;
	}

	@Override
	public void setAgilityTier(int tier) 
	{
		agilityTier = tier;
	}

	@Override
	public int getPrecisionTier() 
	{
		return precisionTier;
	}

	@Override
	public void setPrecisionTier(int tier) 
	{
		precisionTier = tier;
	}

	@Override
	public int getSlashTier() 
	{
		return slashTier;
	}

	@Override
	public void setSlashTier(int tier) 
	{
		slashTier = tier;
	}

	@Override
	public int getCriticalTier() 
	{
		return criticalTier;
	}

	@Override
	public void setCriticalTier(int tier) 
	{
		criticalTier = tier;
	}

	@Override
	public int getDestructionTier() 
	{
		return destructionTier;
	}

	@Override
	public void setDestructionTier(int tier) 
	{
		destructionTier = tier;
	}
}
