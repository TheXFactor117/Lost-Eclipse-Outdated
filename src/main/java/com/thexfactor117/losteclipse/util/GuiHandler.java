package com.thexfactor117.losteclipse.util;

import com.thexfactor117.losteclipse.client.gui.GuiMana;
import com.thexfactor117.losteclipse.client.gui.leveling.GuiAssassin;
import com.thexfactor117.losteclipse.client.gui.leveling.GuiCharacterLevel;
import com.thexfactor117.losteclipse.client.gui.leveling.GuiHunter;
import com.thexfactor117.losteclipse.client.gui.leveling.GuiMage;
import com.thexfactor117.losteclipse.client.gui.leveling.GuiSkillTree;
import com.thexfactor117.losteclipse.client.gui.leveling.GuiWarrior;

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
	public static final int SKILL_TREE = 2;
	public static final int WARRIOR = 3;
	public static final int HUNTER = 4;
	public static final int MAGE = 5;
	public static final int ASSASSIN = 6;
	
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
		else if (ID == SKILL_TREE)
			return new GuiSkillTree();
		else if (ID == WARRIOR)
			return new GuiWarrior();
		else if (ID == HUNTER)
			return new GuiHunter();
		else if (ID == MAGE)
			return new GuiMage();
		else if (ID == ASSASSIN)
			return new GuiAssassin();
		
		return null;
	}
}
