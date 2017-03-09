package com.thexfactor117.losteclipse.client.gui.leveling;

import java.io.IOException;

import com.thexfactor117.losteclipse.LostEclipse;
import com.thexfactor117.losteclipse.capabilities.api.ICharacterLevel;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityCharacterLevel;
import com.thexfactor117.losteclipse.util.GuiHandler;

import net.minecraft.client.entity.EntityPlayerSP;
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
	private GuiButton skillTree;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void initGui()
	{
		skillTree = new GuiButton(0, width / 2 - 50, 100, 100, 20, I18n.format("losteclipse.leveling.skills.tree"));
		
		this.buttonList.add(skillTree);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void drawScreen(int mouseX, int mouseY, float partialTicks) 
	{
		this.drawDefaultBackground();
		EntityPlayer player = this.mc.player;
		
		if (player != null)
		{
			drawStrings(player, mouseX, mouseY);
		}
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	protected void actionPerformed(GuiButton button) throws IOException
	{
		if (button == skillTree)
		{
			EntityPlayerSP player = mc.player;
			
			if (player != null)
			{
				player.openGui(LostEclipse.instance, GuiHandler.SKILL_TREE, player.getEntityWorld(), (int) player.posX, (int) player.posY, (int) player.posZ);
			}
		}
	}
	
	private void drawStrings(EntityPlayer player, int mouseX, int mouseY)
	{
		ICharacterLevel charLevel = player.getCapability(CapabilityCharacterLevel.CHARACTER_LEVEL, null);
		
		if (charLevel != null)
		{
			drawCenteredString(fontRendererObj, player.getName(), width / 2, 20, 0xFFFFFF);
			drawString(fontRendererObj, I18n.format("levels.misc.level") + ": " + charLevel.getLevel(), width / 2 - 50, 40, 0xFFFFFF);
			drawString(fontRendererObj, I18n.format("levels.misc.experience") + ": " + charLevel.getExperience() + " / " + charLevel.getLevelUpExperience(), width / 2 - 50, 50, 0xFFFFFF);
			drawString(fontRendererObj, I18n.format("losteclipse.leveling.skills.points") + ": " + charLevel.getSkillPoints(), width / 2 - 50, 60, 0xFFFFFF);
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
