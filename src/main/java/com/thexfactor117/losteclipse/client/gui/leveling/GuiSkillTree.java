package com.thexfactor117.losteclipse.client.gui.leveling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thexfactor117.losteclipse.LostEclipse;
import com.thexfactor117.losteclipse.capabilities.api.ICharacterLevel;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityCharacterLevel;
import com.thexfactor117.losteclipse.util.GuiHandler;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.client.config.HoverChecker;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 
 * @author TheXFactor117
 *
 */
public class GuiSkillTree extends GuiScreen
{
	private GuiButton previous;
	
	private GuiButton warrior;
	private GuiButton hunter;
	private GuiButton mage;
	private GuiButton assassin;
	
	@SideOnly(Side.CLIENT)
	@Override
	public void initGui() 
	{
		previous = new GuiButton(0, width / 2 - 50, height - 20, 100, 20, I18n.format("losteclipse.gui.goback"));
		
		warrior = new GuiButton(1, width / 2 - 120, 70, 50, 20, I18n.format("losteclipse.leveling.skills.warrior"));
		hunter = new GuiButton(2, width / 2 - 60, 70, 50, 20, I18n.format("losteclipse.leveling.skills.hunter"));
		mage = new GuiButton(3, width / 2 + 10, 70, 50, 20, I18n.format("losteclipse.leveling.skills.mage"));
		assassin = new GuiButton(4, width / 2 + 70, 70, 50, 20, I18n.format("losteclipse.leveling.skills.assassin"));
		
		buttonList.add(previous);
		buttonList.add(warrior);
		buttonList.add(hunter);
		buttonList.add(mage);
		buttonList.add(assassin);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void drawScreen(int mouseX, int mouseY, float partialTicks) 
	{
		this.drawDefaultBackground();
		EntityPlayer player = this.mc.player;
		
		super.drawScreen(mouseX, mouseY, partialTicks);
		
		if (player != null)
		{
			drawStrings(player, mouseX, mouseY);
		}		
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	protected void actionPerformed(GuiButton button) throws IOException
	{
		EntityPlayerSP player = mc.player;
		
		if (player != null)
		{
			if (button == warrior)
				player.openGui(LostEclipse.instance, GuiHandler.WARRIOR, player.getEntityWorld(), (int) player.posX, (int) player.posY, (int) player.posZ);
			else if (button == hunter)
				player.openGui(LostEclipse.instance, GuiHandler.HUNTER, player.getEntityWorld(), (int) player.posX, (int) player.posY, (int) player.posZ);
			else if (button == mage)
				player.openGui(LostEclipse.instance, GuiHandler.MAGE, player.getEntityWorld(), (int) player.posX, (int) player.posY, (int) player.posZ);
			else if (button == assassin)
				player.openGui(LostEclipse.instance, GuiHandler.ASSASSIN, player.getEntityWorld(), (int) player.posX, (int) player.posY, (int) player.posZ);
			else if (button == previous)
				player.openGui(LostEclipse.instance, GuiHandler.CHARACTER_LEVELING, player.getEntityWorld(), (int) player.posX, (int) player.posY, (int) player.posZ);
		}
	}
	
	private void drawStrings(EntityPlayer player, int mouseX, int mouseY)
	{
		ICharacterLevel charLevel = player.getCapability(CapabilityCharacterLevel.CHARACTER_LEVEL, null);
		
		if (charLevel != null)
		{
			drawTooltips(mouseX, mouseY);
			
			this.drawCenteredString(fontRendererObj, I18n.format("losteclipse.leveling.skills.tree"), width / 2, 20, 0xFFFFFF);
			this.drawCenteredString(fontRendererObj, I18n.format("losteclipse.leveling.skills.points") + ": " + charLevel.getSkillPoints(), width / 2, 40, 0xFFFFFF);
		}
		else
		{
			drawCenteredString(fontRendererObj, "Error drawing screen. Character doesn't have a level.", width / 2, 20, 0xFFFFFF);
		}
	}
	
	private void drawTooltips(int mouseX, int mouseY)
	{
		HoverChecker warrior = new HoverChecker(this.warrior, 0);
		HoverChecker hunter = new HoverChecker(this.hunter, 0);
		HoverChecker mage = new HoverChecker(this.mage, 0);
		HoverChecker assassin = new HoverChecker(this.assassin, 0);

		if (warrior.checkHover(mouseX, mouseY))
		{
			List<String> list = new ArrayList<String>();
			list.add(I18n.format("losteclipse.leveling.skills.warrior.info"));
			drawHoveringText(list, mouseX + 5, mouseY + 5);
		}
		
		if (hunter.checkHover(mouseX, mouseY))
		{
			List<String> list = new ArrayList<String>();
			list.add(I18n.format("losteclipse.leveling.skills.hunter.info"));
			drawHoveringText(list, mouseX + 3, mouseY + 3);
		}
		
		if (mage.checkHover(mouseX, mouseY))
		{
			List<String> list = new ArrayList<String>();
			list.add(I18n.format("losteclipse.leveling.skills.mage.info"));
			drawHoveringText(list, mouseX + 5, mouseY + 5);
		}
		
		if (assassin.checkHover(mouseX, mouseY))
		{
			List<String> list = new ArrayList<String>();
			list.add(I18n.format("losteclipse.leveling.skills.warrior.info"));
			drawHoveringText(list, mouseX + 5, mouseY + 5);
		}
	}
}
