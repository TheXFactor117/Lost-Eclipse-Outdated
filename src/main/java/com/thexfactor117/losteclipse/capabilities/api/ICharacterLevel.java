package com.thexfactor117.losteclipse.capabilities.api;

/**
 * 
 * @author TheXFactor117
 *
 */
public interface ICharacterLevel 
{
	/**
	 * Returns the Character Level of the specific player.
	 * @return
	 */
	int getLevel();
	
	/**
	 * Increases the Character Level of the specific player.
	 */
	void increaseLevel();
	
	/**
	 * Sets the Character Level of the specific player.
	 */
	void setLevel(int level);
	
	/**
	 * Returns the experience of the specific player.
	 * @return
	 */
	int getExperience();

	/**
	 * Adds the specific amount of the player's pool of experience.
	 * @param amount
	 */
	void addExperience(int amount);
	
	/**
	 * Sets the specific amount of the player's pool of experience.
	 * @param amount
	 */
	void setExperience(int amount);
	
	/**
	 * Returns the amount of experience needed to level up.
	 * @param currentLevel
	 * @return
	 */
	int getLevelUpExperience(int currentLevel);
}
