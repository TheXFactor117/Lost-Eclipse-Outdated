package com.thexfactor117.losteclipse.util;

import com.thexfactor117.losteclipse.client.gui.GuiMana;
import com.thexfactor117.losteclipse.client.gui.leveling.GuiCharacterLevel;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * 
 * @author TheXFactor117
 *
 */
public class GuiHandler implements IGuiHandler
{
	public static final int MANA = 0;
	public static final int CHARACTER_LEVELING = 1;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if (ID == MANA)
			return new GuiMana(Minecraft.getMinecraft());
		else if (ID == CHARACTER_LEVELING)
			return new GuiCharacterLevel();
		
		return null;
	}
}
