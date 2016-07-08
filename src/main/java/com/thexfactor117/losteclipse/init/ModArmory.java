package com.thexfactor117.losteclipse.init;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.Reference;
import com.thexfactor117.losteclipse.items.melee.ItemLEAdvancedMelee;
import com.thexfactor117.losteclipse.items.melee.ItemLEMelee;
import com.thexfactor117.losteclipse.items.ranged.ItemAstrillStaff;
import com.thexfactor117.losteclipse.items.ranged.ItemBlizzardStaff;
import com.thexfactor117.losteclipse.items.ranged.ItemElementalStaff;
import com.thexfactor117.losteclipse.items.ranged.ItemInfernoStaff;
import com.thexfactor117.losteclipse.items.ranged.ItemIronStaff;
import com.thexfactor117.losteclipse.items.ranged.ItemLightningStaff;
import com.thexfactor117.losteclipse.items.ranged.ItemMalachiteStaff;
import com.thexfactor117.losteclipse.items.ranged.ItemOblivionStaff;
import com.thexfactor117.losteclipse.items.base.ItemBaseArmor;
import com.thexfactor117.losteclipse.items.base.ItemBaseAxe;
import com.thexfactor117.losteclipse.items.base.ItemBasePickaxe;
import com.thexfactor117.losteclipse.items.base.ItemBaseShovel;
import com.thexfactor117.losteclipse.misc.RegisterHelper;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
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
	
	// armor
	public static ArmorMaterial malachite_armor = EnumHelper.addArmorMaterial("malachite_armor", Reference.MODID + ":malachiteArmor", 15, new int[] { 2, 6, 5, 2 }, 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static ArmorMaterial astrill_armor = EnumHelper.addArmorMaterial("astrill_armor", Reference.MODID + ":astrillArmor", 40, new int[] { 4, 8, 5, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F);
	
	public static ArmorMaterial gyro_chestplate = EnumHelper.addArmorMaterial("gyro_chestplate", Reference.MODID + ":gyroChestplate", 33, new int [] { 1, 10, 1, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F);
	
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
	
	// armor
	public static Item malachiteHelmet = new ItemBaseArmor(malachite_armor, EntityEquipmentSlot.HEAD, "malachiteHelmet", Reference.MODID, ModTabs.tabLE);
	public static Item malachiteChestplate = new ItemBaseArmor(malachite_armor, EntityEquipmentSlot.CHEST, "malachiteChestplate", Reference.MODID, ModTabs.tabLE);
	public static Item malachiteLeggings = new ItemBaseArmor(malachite_armor, EntityEquipmentSlot.LEGS, "malachiteLeggings", Reference.MODID, ModTabs.tabLE);
	public static Item malachiteBoots = new ItemBaseArmor(malachite_armor, EntityEquipmentSlot.FEET, "malachiteBoots", Reference.MODID, ModTabs.tabLE);
	public static Item astrillHelmet = new ItemBaseArmor(astrill_armor, EntityEquipmentSlot.HEAD, "astrillHelmet", Reference.MODID, ModTabs.tabLE);
	public static Item astrillChestplate = new ItemBaseArmor(astrill_armor, EntityEquipmentSlot.CHEST, "astrillChestplate", Reference.MODID, ModTabs.tabLE);
	public static Item astrillLeggings = new ItemBaseArmor(astrill_armor, EntityEquipmentSlot.LEGS, "astrillLeggings", Reference.MODID, ModTabs.tabLE);
	public static Item astrillBoots = new ItemBaseArmor(astrill_armor, EntityEquipmentSlot.FEET, "astrillBoots", Reference.MODID, ModTabs.tabLE);
	
	public static Item gyroChestplate = new ItemBaseArmor(gyro_chestplate, EntityEquipmentSlot.CHEST, "gyroChestplate", Reference.MODID, ModTabs.tabLE);
	
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
	
	// ranged
	public static Item ironStaff = new ItemIronStaff("ironStaff", Rarity.UNCOMMON);
	public static Item malachiteStaff = new ItemMalachiteStaff("malachiteStaff", Rarity.RARE);
	public static Item astrillStaff = new ItemAstrillStaff("astrillStaff", Rarity.LEGENDARY);
	public static Item infernoStaff = new ItemInfernoStaff("infernoStaff", Rarity.UNCOMMON);
	public static Item blizzardStaff = new ItemBlizzardStaff("blizzardStaff", Rarity.UNCOMMON);
	public static Item lightningStaff = new ItemLightningStaff("lightningStaff", Rarity.RARE);
	public static Item elementalStaff = new ItemElementalStaff("elementalStaff", Rarity.RARE);
	public static Item oblivionStaff = new ItemOblivionStaff("oblivionStaff", Rarity.LEGENDARY);
	
	public static void registerItems()
	{
		// tools
		RegisterHelper.registerItems(malachitePick);
		RegisterHelper.registerItems(malachiteShovel);
		RegisterHelper.registerItems(malachiteAxe);
		RegisterHelper.registerItems(astrillPick);
		RegisterHelper.registerItems(astrillShovel);
		RegisterHelper.registerItems(astrillAxe);
		
		// armor
		RegisterHelper.registerItems(malachiteHelmet);
		RegisterHelper.registerItems(malachiteChestplate);
		RegisterHelper.registerItems(malachiteLeggings);
		RegisterHelper.registerItems(malachiteBoots);
		RegisterHelper.registerItems(astrillHelmet);
		RegisterHelper.registerItems(astrillChestplate);
		RegisterHelper.registerItems(astrillLeggings);
		RegisterHelper.registerItems(astrillBoots);
		
		RegisterHelper.registerItems(gyroChestplate);
		
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
		
		// ranged
		RegisterHelper.registerItems(ironStaff);
		RegisterHelper.registerItems(malachiteStaff);
		RegisterHelper.registerItems(astrillStaff);
		RegisterHelper.registerItems(infernoStaff);
		RegisterHelper.registerItems(blizzardStaff);
		RegisterHelper.registerItems(lightningStaff);
		RegisterHelper.registerItems(elementalStaff);
		RegisterHelper.registerItems(oblivionStaff);
	}
}
