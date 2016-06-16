package com.thexfactor117.losteclipse.init;

import com.thexfactor117.losteclipse.items.melee.ItemLEDagger;
import com.thexfactor117.losteclipse.items.melee.ItemLEMace;
import com.thexfactor117.losteclipse.items.melee.ItemLEMelee;
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
	public static ToolMaterial vexal = EnumHelper.addToolMaterial("vexal", 2, 784, 6.5F, 2.5F, 10);
	public static ToolMaterial astrill = EnumHelper.addToolMaterial("astrill", 3, 2000, 7.0F, 4.0F, 15);
	
	// special melee
	
	
	/*
	 * items
	 */
	// generic melee
	public static Item ironDagger = new ItemLEDagger(ToolMaterial.IRON, "ironDagger", 175);
	public static Item ironMace = new ItemLEMace(ToolMaterial.IRON, "ironMace", 350);
	public static Item malachiteDagger = new ItemLEDagger(malachite, "malachiteDagger", 175);
	public static Item malachiteSword = new ItemLEMelee(malachite, "malachiteSword");
	public static Item malachiteMace = new ItemLEMace(malachite, "malachiteMace", 350);
	public static Item vexalDagger = new ItemLEDagger(vexal, "vexalDagger", 512);
	public static Item vexalSword = new ItemLEMelee(vexal, "vexalSword");
	public static Item vexalMace = new ItemLEMace(vexal, "vexalMace", 1024);
	public static Item astrillDagger = new ItemLEDagger(astrill, "astrillDagger", 1500);
	public static Item astrillSword = new ItemLEMelee(astrill, "astrillSword");
	public static Item astrillMace = new ItemLEMace(astrill, "astrillMace", 2500);
	
	// special melee
	
	public static void registerItems()
	{
		// weapons
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
	}
}
