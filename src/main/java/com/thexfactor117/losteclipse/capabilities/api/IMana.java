package com.thexfactor117.losteclipse.capabilities.api;

/**
 * 
 * @author TheXFactor117
 *
 */
public interface IMana 
{
	float getMana();
	void addMana(float amount);
	void setMana(float amount);
	float getMaxMana();
	void addMaxMana(float amount);
	void setMaxMana(float amount);
	float getManaPerSec();
	void addManaPerSec(float amount);
	void setManaPerSec(float amount);
}
