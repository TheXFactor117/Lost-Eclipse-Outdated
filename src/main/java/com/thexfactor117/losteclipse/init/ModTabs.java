package com.thexfactor117.losteclipse.init;

import com.thexfactor117.losteclipse.tabs.LETab;

import net.minecraft.creativetab.CreativeTabs;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ModTabs 
{
	public static CreativeTabs tabLE = new LETab(CreativeTabs.getNextID(), "tabLE");
	public static CreativeTabs tabLETest = new LETab(CreativeTabs.getNextID(), "tabLETest");
}
