package com.thexfactor117.losteclipse.init;

import com.thexfactor117.losteclipse.Reference;
import com.thexfactor117.losteclipse.items.melee.ItemLEAdvancedMelee;
import com.thexfactor117.losteclipse.items.melee.ItemLEMelee;
import com.thexfactor117.xlib.items.ItemBaseAxe;
import com.thexfactor117.xlib.items.ItemBasePickaxe;
import com.thexfactor117.xlib.items.ItemBaseShovel;
import com.thexfactor117.xlib.misc.RegisterHelper;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ModArmory 
{
	/*
	 * materials
	 */
	// generic melee
	public static ToolMaterial malachite = EnumHelper.addToolMaterial("malachite", 2, 250, 6.0F, 2.0F, 14);
	public static ToolMaterial vexal = EnumHelper.addToolMaterial("vexal", 2, 768, 6.5F, 2.5F, 10);
	public static ToolMaterial astrill = EnumHelper.addToolMaterial("astrill", 3, 2000, 7.0F, 4.0F, 15);
	
	// special melee
	public static ToolMaterial crystallized = EnumHelper.addToolMaterial("crystallized", 2, 256, 6.0F, 3.0F, 25);
	public static ToolMaterial gyro = EnumHelper.addToolMaterial("gyro", 2, 768, 6.0F, 6.0F, 15);
	public static ToolMaterial shadow = EnumHelper.addToolMaterial("shadow", 2, 384, 6.0F, 4.0F, 20);
	public static ToolMaterial malice = EnumHelper.addToolMaterial("malice", 2, 448, 6.0F, 4.0F, 10);
	public static ToolMaterial dark_malice = EnumHelper.addToolMaterial("dark_malice", 2, 640, 6.0F, 7.0F, 25);
	public static ToolMaterial divine = EnumHelper.addToolMaterial("divine", 2, 384, 6.0F, 6.0F, 25);
	public static ToolMaterial void_hammer = EnumHelper.addToolMaterial("void_hammer", 2, 1024, 6.0F, 12.0F, 15);
	public static ToolMaterial excalibur = EnumHelper.addToolMaterial("excalibur", 2, 512, 6.0F, 8.0F, 15);
	
	/*
	 * items
	 */
	// tools
	public static Item malachitePick = new ItemBasePickaxe(malachite, "malachitePick", Reference.MODID, ModTabs.tabLE);
	public static Item malachiteShovel = new ItemBaseShovel(malachite, "malachiteShovel", Reference.MODID, ModTabs.tabLE);
	public static Item malachiteAxe = new ItemBaseAxe(malachite, "malachiteAxe", Reference.MODID, ModTabs.tabLE, malachite.getDamageVsEntity(), malachite.getEfficiencyOnProperMaterial()); // TODO: fix damage/speed for axes
	public static Item astrillPick = new ItemBasePickaxe(astrill, "astrillPick", Reference.MODID, ModTabs.tabLE);
	public static Item astrillShovel = new ItemBaseShovel(astrill, "astrillShovel", Reference.MODID, ModTabs.tabLE);
	public static Item astrillAxe = new ItemBaseAxe(astrill, "astrillAxe", Reference.MODID, ModTabs.tabLE, malachite.getDamageVsEntity(), malachite.getEfficiencyOnProperMaterial()); // TODO: fix damage/speed for axes

	// generic melee
	public static Item ironDagger = new ItemLEAdvancedMelee(ToolMaterial.IRON, "ironDagger", 0.5, 0.5, 175);
	public static Item ironMace = new ItemLEAdvancedMelee(ToolMaterial.IRON, "ironMace", 1.25, 1.25, 350);
	public static Item malachiteDagger = new ItemLEAdvancedMelee(malachite, "malachiteDagger", 0.5, 0.5, 175);
	public static Item malachiteSword = new ItemLEMelee(malachite, "malachiteSword");
	public static Item malachiteMace = new ItemLEAdvancedMelee(malachite, "malachiteMace", 1.25, 1.25, 350);
	public static Item vexalDagger = new ItemLEAdvancedMelee(vexal, "vexalDagger", 0.5, 0.5, 512);
	public static Item vexalSword = new ItemLEMelee(vexal, "vexalSword");
	public static Item vexalMace = new ItemLEAdvancedMelee(vexal, "vexalMace", 1.25, 1.25, 1024);
	public static Item astrillDagger = new ItemLEAdvancedMelee(astrill, "astrillDagger", 0.5, 0.5, 1500);
	public static Item astrillSword = new ItemLEMelee(astrill, "astrillSword");
	public static Item astrillMace = new ItemLEAdvancedMelee(astrill, "astrillMace", 1.25, 1.25, 2500);
	
	// special melee
	public static Item crystallizedSword = new ItemLEMelee(crystallized, "crystallizedSword");
	public static Item gyroMace = new ItemLEAdvancedMelee(gyro, "gyroMace", 1, 1.25);
	public static Item shadowBlade = new ItemLEMelee(shadow, "shadowBlade");
	public static Item maliceBlade = new ItemLEMelee(malice, "maliceBlade");
	public static Item darkMaliceBlade = new ItemLEMelee(dark_malice, "darkMaliceBlade");
	public static Item divineRapier = new ItemLEAdvancedMelee(divine, "divineRapier", 1, 0.75);
	public static Item voidHammer = new ItemLEAdvancedMelee(void_hammer, "voidHammer", 1, 1.5);
	public static Item excaliburRapier = new ItemLEAdvancedMelee(excalibur, "excaliburRapier", 1, 0.75);
	
	public static void registerItems()
	{
		// tools
		RegisterHelper.registerItems(malachitePick);
		RegisterHelper.registerItems(malachiteShovel);
		RegisterHelper.registerItems(malachiteAxe);
		RegisterHelper.registerItems(astrillPick);
		RegisterHelper.registerItems(astrillShovel);
		RegisterHelper.registerItems(astrillAxe);
		
		// generic melee
		RegisterHelper.registerItems(ironDagger);
		RegisterHelper.registerItems(ironMace);
		RegisterHelper.registerItems(malachiteDagger);
		RegisterHelper.registerItems(malachiteSword);
		RegisterHelper.registerItems(malachiteMace);
		RegisterHelper.registerItems(vexalDagger);
		RegisterHelper.registerItems(vexalSword);
		RegisterHelper.registerItems(vexalMace);
		RegisterHelper.registerItems(astrillDagger);
		RegisterHelper.registerItems(astrillSword);
		RegisterHelper.registerItems(astrillMace);
		
		// special melee
		RegisterHelper.registerItems(crystallizedSword);
		RegisterHelper.registerItems(gyroMace);
		RegisterHelper.registerItems(shadowBlade);
		RegisterHelper.registerItems(maliceBlade);
		RegisterHelper.registerItems(darkMaliceBlade);
		RegisterHelper.registerItems(divineRapier);
		RegisterHelper.registerItems(voidHammer);
		RegisterHelper.registerItems(excaliburRapier);
	}
}
