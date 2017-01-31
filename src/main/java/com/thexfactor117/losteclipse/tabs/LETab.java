package com.thexfactor117.losteclipse.tabs;

import com.thexfactor117.losteclipse.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 
 * @author TheXFactor117
 *
 */
public class LETab extends CreativeTabs
{
	String name;
	
	public LETab(int par1, String par2)
	{
		super(par1, par2);
		this.name = par2;
	}
	
	@SideOnly(Side.CLIENT)
	public ItemStack getTabIconItem()
	{
		if (this.name == "tab_le") 
		{
			return new ItemStack(ModItems.omega);
		} 
		else if (this.name == "tab_le_test")
		{
			return new ItemStack(ModItems.nova);
		}
		return null;
	}
}
