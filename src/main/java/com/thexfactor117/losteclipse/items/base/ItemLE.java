package com.thexfactor117.losteclipse.items.base;

import java.util.List;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.init.ModTabs;
import com.thexfactor117.losteclipse.util.Reference;

import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ItemLE extends ItemBase
{
	protected Rarity rarity;
	
	public ItemLE(String name, Rarity rarity)
	{
		super(name, Reference.MODID);
		this.setCreativeTab(ModTabs.tabLE);
		this.rarity = rarity;
	}
	
	public ItemLE(String name, CreativeTabs tab, Rarity rarity)
	{
		super(name, Reference.MODID, tab);
		this.rarity = rarity;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced)
    {		
		tooltip.add(rarity.getColor() + TextFormatting.ITALIC + I18n.format("levels.rarity." + rarity.ordinal()));
    }
}
