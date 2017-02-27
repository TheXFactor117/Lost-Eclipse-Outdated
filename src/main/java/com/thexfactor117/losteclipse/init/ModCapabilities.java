package com.thexfactor117.losteclipse.init;

import com.thexfactor117.losteclipse.capabilities.player.CapabilityCharacterLevel;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityFlameCloak;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityMana;

public class ModCapabilities 
{
	public static void registerCapabilities()
	{
		CapabilityFlameCloak.register();
		CapabilityMana.register();
		CapabilityCharacterLevel.register();
	}
}
