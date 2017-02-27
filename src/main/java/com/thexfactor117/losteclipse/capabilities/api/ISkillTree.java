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
	
	/*
	 * Hunter
	 */
	int getProtectionTier();
	void setProtectionTier(int tier);
	
	int getArcheryTier();
	void setArcheryTier(int tier);
	
	int getQuickDrawTier();
	void setQuickDrawTier(int tier);
	
	int getRecoveryTier();
	void setRecoveryTier(int tier);
	
	int getParalyzeTier();
	void setParalyzeTier(int tier);

	/*
	 * Mage
	 */
	int getManaTier();
	void setManaTier(int tier);
	
	int getSorceryTier();
	void setSorceryTier(int tier);
	
	int getKnowledgeTier();
	void setKnowledgeTier(int tier);
	
	int getMastermindTier();
	void setMastermindTier(int tier);
	
	/*
	 * Assassin
	 */
	int getAgilityTier();
	void setAgilityTier(int tier);
	
	int getPrecisionTier();
	void setPrecisionTier(int tier);
	
	int getSlashTier();
	void setSlashTier(int tier);
	
	int getCriticalTier();
	void setCriticalTier(int tier);
	
	int getDestructionTier();
	void setDestructionTier(int tier);
}
