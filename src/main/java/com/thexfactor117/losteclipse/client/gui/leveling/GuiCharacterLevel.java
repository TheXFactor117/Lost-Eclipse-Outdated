package com.thexfactor117.losteclipse.client.gui.leveling;

import java.io.IOException;

import com.thexfactor117.losteclipse.capabilities.api.ICharacterLevel;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityCharacterLevel;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 
 * @author TheXFactor117
 *
 */
public class GuiCharacterLevel extends GuiScreen
{
	@Override
	@SideOnly(Side.CLIENT)
	public void initGui()
	{
		// create buttons
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void drawScreen(int mouseX, int mouseY, float partialTicks) 
	{
		this.drawDefaultBackground();
		EntityPlayer player = this.mc.player;
		
		if (player != null)
		{
			drawStrings(player);
		}
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	protected void actionPerformed(GuiButton button) throws IOException
	{
		// do stuff with buttons
	}
	
	private void drawStrings(EntityPlayer player)
	{
		ICharacterLevel charLevel = player.getCapability(CapabilityCharacterLevel.CHARACTER_LEVEL, null);
		
		if (charLevel != null)
		{
			drawCenteredString(fontRendererObj, player.getName(), width / 2, 20, 0xFFFFFF);
			drawString(fontRendererObj, I18n.format("levels.misc.level") + ": " + charLevel.getLevel(), width / 2 - 50, 40, 0xFFFFFF);
			drawString(fontRendererObj, I18n.format("levels.misc.experience") + ": " + charLevel.getExperience() + " / " + charLevel.getLevelUpExperience(), width / 2 - 50, 50, 0xFFFFFF);
		}
		else
		{
			drawCenteredString(fontRendererObj, "Error drawing screen. Character doesn't have a level.", width / 2, 20, 0xFFFFFF);
		}
	}
	
	@Override
	public boolean doesGuiPauseGame()
	{
		return false;
	}
}
