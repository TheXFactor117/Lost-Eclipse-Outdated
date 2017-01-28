package com.thexfactor117.losteclipse.items.melee;

import com.thexfactor117.losteclipse.init.ModTabs;
import com.thexfactor117.losteclipse.items.base.ItemBaseSword;
import com.thexfactor117.losteclipse.util.Reference;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ItemLEMelee extends ItemBaseSword
{
	public ItemLEMelee(ToolMaterial material, String name)
	{
		super(material, name, Reference.MODID, ModTabs.tabLE);
	}
}
