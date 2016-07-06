package com.thexfactor117.losteclipse.items;

import java.util.List;

import com.thexfactor117.levels.leveling.Rarity;

import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ItemSoulGem extends ItemLE
{
	public ItemSoulGem(String name, Rarity rarity) 
	{
		super(name, rarity);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
		NBTTagCompound nbt = stack.getTagCompound();
		
		if (nbt == null)
		{
			stack.setTagCompound(new NBTTagCompound());
			nbt = stack.getTagCompound();
			
			if (nbt != null)
			{
				nbt.setInteger("MAX_SOULS", 300);
			}
		}
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced)
    {		
		tooltip.add(rarity.getColor() + TextFormatting.ITALIC + I18n.format("levels.rarity." + rarity.ordinal()));
		
		NBTTagCompound nbt = stack.getTagCompound();
		
		if (nbt != null)
		{
			tooltip.add("");
			tooltip.add("Souls: " + getSouls(nbt) + " / " + getMaxSouls(nbt));
		}
    }
	
	public void setSouls(NBTTagCompound nbt, int souls)
	{
		if (nbt != null) nbt.setInteger("SOULS", souls);
	}
	
	public int getSouls(NBTTagCompound nbt)
	{
		return nbt != null ? nbt.getInteger("SOULS") : 0;
	}
	
	public int getMaxSouls(NBTTagCompound nbt)
	{
		return nbt != null ? nbt.getInteger("MAX_SOULS") : 0;
	}
}
