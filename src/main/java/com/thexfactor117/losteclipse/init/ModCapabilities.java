package com.thexfactor117.losteclipse.init;

import com.thexfactor117.losteclipse.capabilities.player.CapabilityFlameCloak;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityPlayerMaxHealth;

public class ModCapabilities 
{
	public static void registerCapabilities()
	{
		CapabilityFlameCloak.register();
		CapabilityPlayerMaxHealth.register();
	}
}
