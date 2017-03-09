package com.thexfactor117.losteclipse.client.gui.leveling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thexfactor117.losteclipse.LostEclipse;
import com.thexfactor117.losteclipse.capabilities.api.ICharacterLevel;
import com.thexfactor117.losteclipse.capabilities.api.ISkillTree;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityCharacterLevel;
import com.thexfactor117.losteclipse.capabilities.player.CapabilitySkillTree;
import com.thexfactor117.losteclipse.util.GuiHandler;
import com.thexfactor117.losteclipse.util.SkillTreeHelper;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.client.config.HoverChecker;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 
 * @author TheXFactor117
 *
 */
public class GuiWarrior extends GuiScreen
{	
	private int fortificationMax = 3;
	private int heavyLiftingMax = 2;
	private int vigorMax = 5;
	private int regenerationMax = 3;
	private int powerMax = 3;
	private int swordsmanMax = 2;
	private int bruteMax = 2;
	
	private GuiButton previous;
	
	private GuiButton fortification;
	private GuiButton heavyLifting;
	private GuiButton vigor;
	private GuiButton regeneration;
	private GuiButton power;
	private GuiButton swordsman;
	private GuiButton brute;
	
	@SideOnly(Side.CLIENT)
	@Override
	public void initGui() 
	{
		int buttonWidth = 75;
		int buttonHeight = 20;
		
		previous = new GuiButton(0, width / 2 - 50, height - 20, 100, 20, I18n.format("losteclipse.gui.goback"));
		
		fortification = new GuiButton(1, width / 2 - 150, 60, buttonWidth, buttonHeight, I18n.format("losteclipse.leveling.skills.warrior.fortification"));
		heavyLifting = new GuiButton(2, width / 2 - 150, 85, buttonWidth, buttonHeight, I18n.format("losteclipse.leveling.skills.warrior.heavyLifting"));
		
		vigor = new GuiButton(3, width / 2 - (buttonWidth / 2), 60, buttonWidth, buttonHeight, I18n.format("losteclipse.leveling.skills.warrior.vigor"));
		regeneration = new GuiButton(4, width / 2 - (buttonWidth / 2), 85, buttonWidth, buttonHeight, I18n.format("losteclipse.leveling.skills.warrior.regeneration"));
		
		power = new GuiButton(5, width / 2 + 100, 60, buttonWidth, buttonHeight, I18n.format("losteclipse.leveling.skills.warrior.power"));
		swordsman = new GuiButton(6, width / 2 + 60, 85, buttonWidth, buttonHeight, I18n.format("losteclipse.leveling.skills.warrior.swordsman"));
		brute = new GuiButton(7, width / 2 + 140, 85, buttonWidth, buttonHeight, I18n.format("losteclipse.leveling.skills.warrior.brute"));

		buttonList.add(previous);
		
		buttonList.add(fortification);
		buttonList.add(heavyLifting);
		buttonList.add(vigor);
		buttonList.add(regeneration);
		buttonList.add(power);
		buttonList.add(swordsman);
		buttonList.add(brute);
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
			displayButtons();
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	protected void actionPerformed(GuiButton button) throws IOException
	{
		EntityPlayerSP player = mc.player;
		
		if (player != null)
		{
			if (button == previous)
				player.openGui(LostEclipse.instance, GuiHandler.CHARACTER_LEVELING, player.getEntityWorld(), (int) player.posX, (int) player.posY, (int) player.posZ);
		}
	}
	
	private void drawStrings(EntityPlayer player, int mouseX, int mouseY)
	{
		ICharacterLevel charLevel = player.getCapability(CapabilityCharacterLevel.CHARACTER_LEVEL, null);
		
		if (charLevel != null)
		{
			drawTooltips(player, mouseX, mouseY);
			
			this.drawCenteredString(fontRendererObj, TextFormatting.RED + I18n.format("losteclipse.leveling.skills.warrior"), width / 2, 20, 0xFFFFFF);
			this.drawCenteredString(fontRendererObj, I18n.format("losteclipse.leveling.skills.points") + ": " + charLevel.getSkillPoints(), width / 2, 40, 0xFFFFFF);
		}
		else
		{
			drawCenteredString(fontRendererObj, "Error drawing screen. Character doesn't have a level.", width / 2, 20, 0xFFFFFF);
		}
	}
	
	private void displayButtons()
	{
		
	}
	
	private void drawTooltips(EntityPlayer player, int mouseX, int mouseY)
	{
		ISkillTree tree = player.getCapability(CapabilitySkillTree.SKILL_TREE, null);
		
		if (tree != null)
		{
			HoverChecker fortification = new HoverChecker(this.fortification, 0);
			HoverChecker heavyLifting = new HoverChecker(this.heavyLifting, 0);
			HoverChecker vigor = new HoverChecker(this.vigor, 0);
			HoverChecker regeneration = new HoverChecker(this.regeneration, 0);
			HoverChecker power = new HoverChecker(this.power, 0);
			HoverChecker swordsman = new HoverChecker(this.swordsman, 0);
			HoverChecker brute = new HoverChecker(this.brute, 0);
			
			if (fortification.checkHover(mouseX, mouseY))
			{
				List<String> list = new ArrayList<String>();
				list.add(TextFormatting.RED + I18n.format("losteclipse.leveling.skills.warrior.fortification") + " (" + tree.getFortificationTier() + "/" + fortificationMax + ")");
				list.add("");
				list.add(I18n.format("losteclipse.leveling.skills.warrior.fortification.info1"));
				list.add("");
				list.add(I18n.format("losteclipse.leveling.skills.tier") + " 1: " + TextFormatting.RED + "+" + SkillTreeHelper.FORTIFICATION_1 + "%");
				list.add(I18n.format("losteclipse.leveling.skills.tier") + " 2: " + TextFormatting.RED + "+" + SkillTreeHelper.FORTIFICATION_2 + "%");
				list.add(I18n.format("losteclipse.leveling.skills.tier") + " 3: " + TextFormatting.RED + "+" + SkillTreeHelper.FORTIFICATION_3 + "%");
				drawHoveringText(list, mouseX + 3, mouseY + 3);
			}
			
			if (heavyLifting.checkHover(mouseX, mouseY))
			{
				List<String> list = new ArrayList<String>();
				list.add(TextFormatting.RED + I18n.format("losteclipse.leveling.skills.warrior.heavyLifting") + " (" + tree.getHeavyLiftingTier() + "/" + heavyLiftingMax + ")");
				list.add("");
				list.add(I18n.format("losteclipse.leveling.skills.warrior.heavyLifting.info1"));
				list.add("");
				list.add(I18n.format("losteclipse.leveling.skills.tier") + " 1: " + TextFormatting.RED + "+" + SkillTreeHelper.HEAVY_LIFTING_1 + "%");
				list.add(I18n.format("losteclipse.leveling.skills.tier") + " 2: " + TextFormatting.RED + "+" + SkillTreeHelper.HEAVY_LIFTING_2 + "%");
				drawHoveringText(list, mouseX + 3, mouseY + 3);
			}
			
			if (vigor.checkHover(mouseX, mouseY))
			{
				List<String> list = new ArrayList<String>();
				list.add(TextFormatting.RED + I18n.format("losteclipse.leveling.skills.warrior.vigor") + " (" + tree.getVigorTier() + "/" + vigorMax + ")");
				list.add("");
				list.add(I18n.format("losteclipse.leveling.skills.warrior.vigor.info1"));
				list.add("");
				list.add(I18n.format("losteclipse.leveling.skills.tier") + " 1: " + TextFormatting.RED + "+" + SkillTreeHelper.VIGOR_1);
				list.add(I18n.format("losteclipse.leveling.skills.tier") + " 2: " + TextFormatting.RED + "+" + SkillTreeHelper.VIGOR_2);
				list.add(I18n.format("losteclipse.leveling.skills.tier") + " 3: " + TextFormatting.RED + "+" + SkillTreeHelper.VIGOR_3);
				list.add(I18n.format("losteclipse.leveling.skills.tier") + " 4: " + TextFormatting.RED + "+" + SkillTreeHelper.VIGOR_4);
				list.add(I18n.format("losteclipse.leveling.skills.tier") + " 5: " + TextFormatting.RED + "+" + SkillTreeHelper.VIGOR_5);
				drawHoveringText(list, mouseX + 3, mouseY + 3);
			}
			
			if (regeneration.checkHover(mouseX, mouseY))
			{
				List<String> list = new ArrayList<String>();
				list.add(TextFormatting.RED + I18n.format("losteclipse.leveling.skills.warrior.regeneration") + " (" + tree.getRegenerationTier() + "/" + regenerationMax + ")");
				list.add("");
				list.add(I18n.format("losteclipse.leveling.skills.warrior.regeneration.info1"));
				list.add("");
				list.add(I18n.format("losteclipse.leveling.skills.tier") + " 1: " + TextFormatting.RED + "+" + SkillTreeHelper.REGENERATION_1 + "/sec");
				list.add(I18n.format("losteclipse.leveling.skills.tier") + " 2: " + TextFormatting.RED + "+" + SkillTreeHelper.REGENERATION_2 + "/sec");
				list.add(I18n.format("losteclipse.leveling.skills.tier") + " 3: " + TextFormatting.RED + "+" + SkillTreeHelper.REGENERATION_3 + "/sec");
				drawHoveringText(list, mouseX + 3, mouseY + 3);
			}
			
			if (power.checkHover(mouseX, mouseY))
			{
				List<String> list = new ArrayList<String>();
				list.add(TextFormatting.RED + I18n.format("losteclipse.leveling.skills.warrior.power") + " (" + tree.getPowerTier() + "/" + powerMax + ")");
				list.add("");
				list.add(I18n.format("losteclipse.leveling.skills.warrior.power.info1"));
				list.add("");
				list.add(I18n.format("losteclipse.leveling.skills.tier") + " 1: " + TextFormatting.RED + "+" + SkillTreeHelper.POWER_1 + "%");
				list.add(I18n.format("losteclipse.leveling.skills.tier") + " 2: " + TextFormatting.RED + "+" + SkillTreeHelper.POWER_2 + "%");
				list.add(I18n.format("losteclipse.leveling.skills.tier") + " 3: " + TextFormatting.RED + "+" + SkillTreeHelper.POWER_3 + "%");
				drawHoveringText(list, mouseX + 3, mouseY + 3);
			}
			
			if (swordsman.checkHover(mouseX, mouseY))
			{
				List<String> list = new ArrayList<String>();
				list.add(TextFormatting.RED + I18n.format("losteclipse.leveling.skills.warrior.swordsman") + " (" + tree.getSwordsmanTier() + "/" + swordsmanMax + ")");
				list.add("");
				list.add(I18n.format("losteclipse.leveling.skills.warrior.swordsman.info1"));
				list.add("");
				list.add(I18n.format("losteclipse.leveling.skills.tier") + " 1: " + TextFormatting.RED + "+" + SkillTreeHelper.SWORDSMAN_1 + "%");
				list.add(I18n.format("losteclipse.leveling.skills.tier") + " 2: " + TextFormatting.RED + "+" + SkillTreeHelper.SWORDSMAN_2 + "%");
				drawHoveringText(list, mouseX + 3, mouseY + 3);
			}
			
			if (brute.checkHover(mouseX, mouseY))
			{
				List<String> list = new ArrayList<String>();
				list.add(TextFormatting.RED + I18n.format("losteclipse.leveling.skills.warrior.brute") + " (" + tree.getBruteTier() + "/" + bruteMax + ")");
				list.add("");
				list.add(I18n.format("losteclipse.leveling.skills.warrior.brute.info1"));
				list.add("");
				list.add(I18n.format("losteclipse.leveling.skills.tier") + " 1: " + TextFormatting.RED + "+" + SkillTreeHelper.BRUTE_1 + "%");
				list.add(I18n.format("losteclipse.leveling.skills.tier") + " 2: " + TextFormatting.RED + "+" + SkillTreeHelper.BRUTE_2 + "%");
				drawHoveringText(list, mouseX + 3, mouseY + 3);
			}
		}
	}
}
