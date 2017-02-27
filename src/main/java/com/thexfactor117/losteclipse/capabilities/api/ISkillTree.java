package com.thexfactor117.losteclipse.capabilities.api;

/**
 * 
 * @author TheXFactor117
 *
 */
public interface ISkillTree 
{
	/*
	 * Warrior
	 */
	int getFortificationTier();
	void setFortificationTier(int tier);
	
	int getHeavyLiftingTier();
	void setHeavyLiftingTier(int tier);
	
	int getVigorTier();
	void setVigorTier(int tier);
	
	int getRegenerationTier();
	void setRegenerationTier(int tier);
	
	int getPowerTier();
	void setPowerTier(int tier);
	
	int getSwordsmanTier();
	void setSwordsmanTier(int tier);
	
	int getBruteTier();
	void setBruteTier(int tier);
}
