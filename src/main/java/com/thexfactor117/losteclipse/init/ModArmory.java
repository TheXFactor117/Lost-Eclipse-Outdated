package com.thexfactor117.losteclipse.init;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.items.base.ItemBaseArmor;
import com.thexfactor117.losteclipse.items.base.ItemBaseAxe;
import com.thexfactor117.losteclipse.items.base.ItemBasePickaxe;
import com.thexfactor117.losteclipse.items.base.ItemBaseShovel;
import com.thexfactor117.losteclipse.items.melee.ItemLEAdvancedMelee;
import com.thexfactor117.losteclipse.items.melee.ItemLEMelee;
import com.thexfactor117.losteclipse.items.ranged.ItemAstrillStaff;
import com.thexfactor117.losteclipse.items.ranged.ItemBlizzardStaff;
import com.thexfactor117.losteclipse.items.ranged.ItemElementalStaff;
import com.thexfactor117.losteclipse.items.ranged.ItemInfernoStaff;
import com.thexfactor117.losteclipse.items.ranged.ItemIronStaff;
import com.thexfactor117.losteclipse.items.ranged.ItemLightningStaff;
import com.thexfactor117.losteclipse.items.ranged.ItemOblivionStaff;
import com.thexfactor117.losteclipse.items.ranged.ItemVerantiumStaff;
import com.thexfactor117.losteclipse.util.Reference;
import com.thexfactor117.losteclipse.util.RegisterHelper;

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
	public static ToolMaterial verantium = EnumHelper.addToolMaterial("verantium", 2, 250, 6.0F, 2.0F, 14);
	public static ToolMaterial vexal = EnumHelper.addToolMaterial("vexal", 2, 768, 6.5F, 2.5F, 10);
	public static ToolMaterial astrill = EnumHelper.addToolMaterial("astrill", 3, 2000, 7.0F, 4.0F, 15);
	
	// special melee
	public static ToolMaterial crystallized = EnumHelper.addToolMaterial("crystallized", 2, 256, 6.0F, 3.0F, 25);
	public static ToolMaterial gyro = EnumHelper.addToolMaterial("gyro", 2, 768, 6.0F, 6.0F, 15);
	public static ToolMaterial shadow = EnumHelper.addToolMaterial("shadow", 2, 384, 6.0F, 4.0F, 20);
	public static ToolMaterial malice = EnumHelper.addToolMaterial("malice", 2, 448, 6.0F, 4.0F, 10);
	public static ToolMaterial woe = EnumHelper.addToolMaterial("woe", 2, 512, 6.0F, 5.5F, 20);
	public static ToolMaterial dark_malice = EnumHelper.addToolMaterial("dark_malice", 2, 640, 6.0F, 7.0F, 25);
	public static ToolMaterial soul_infused = EnumHelper.addToolMaterial("soul_infused", 2, 448, 6.0F, 5.0F, 10);
	public static ToolMaterial divine = EnumHelper.addToolMaterial("divine", 2, 384, 6.0F, 6.0F, 25);
	public static ToolMaterial void_hammer = EnumHelper.addToolMaterial("void_hammer", 2, 1024, 6.0F, 12.0F, 15);
	public static ToolMaterial excalibur = EnumHelper.addToolMaterial("excalibur", 2, 512, 6.0F, 8.0F, 15);
	public static ToolMaterial ardon = EnumHelper.addToolMaterial("ardon", 2, 1600, 6.0F, 10.0F, 20);
	public static ToolMaterial founder = EnumHelper.addToolMaterial("founder", 2, 2200, 6.0F, 15.0F, 15);
	
	// armor
	public static ArmorMaterial verantium_armor = EnumHelper.addArmorMaterial("malachite_armor", Reference.MODID + ":verantiumArmor", 15, new int[] { 2, 6, 5, 2 }, 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	public static ArmorMaterial astrill_armor = EnumHelper.addArmorMaterial("astrill_armor", Reference.MODID + ":astrillArmor", 40, new int[] { 4, 8, 5, 3 }, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F);
	
	public static ArmorMaterial gyro_chestplate = EnumHelper.addArmorMaterial("gyro_chestplate", Reference.MODID + ":gyroChestplate", 33, new int [] { 1, 10, 1, 1 }, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F);
	
	/*
	 * items
	 */
	// tools
	public static Item verantiumPick = new ItemBasePickaxe(verantium, "verantium_pick", Reference.MODID, ModTabs.tabLE);
	public static Item verantiumShovel = new ItemBaseShovel(verantium, "verantium_shovel", Reference.MODID, ModTabs.tabLE);
	public static Item verantiumAxe = new ItemBaseAxe(verantium, "verantium_axe", Reference.MODID, ModTabs.tabLE, verantium.getDamageVsEntity(), verantium.getEfficiencyOnProperMaterial()); // TODO: fix damage/speed for axes
	public static Item astrillPick = new ItemBasePickaxe(astrill, "astrill_pick", Reference.MODID, ModTabs.tabLE);
	public static Item astrillShovel = new ItemBaseShovel(astrill, "astrill_shovel", Reference.MODID, ModTabs.tabLE);
	public static Item astrillAxe = new ItemBaseAxe(astrill, "astrill_axe", Reference.MODID, ModTabs.tabLE, astrill.getDamageVsEntity(), astrill.getEfficiencyOnProperMaterial()); // TODO: fix damage/speed for axes
	
	// armor
	public static Item verantiumHelmet = new ItemBaseArmor(verantium_armor, EntityEquipmentSlot.HEAD, "verantium_helmet", Reference.MODID, ModTabs.tabLE);
	public static Item verantiumChestplate = new ItemBaseArmor(verantium_armor, EntityEquipmentSlot.CHEST, "verantium_chestplate", Reference.MODID, ModTabs.tabLE);
	public static Item verantiumLeggings = new ItemBaseArmor(verantium_armor, EntityEquipmentSlot.LEGS, "verantium_leggings", Reference.MODID, ModTabs.tabLE);
	public static Item verantiumBoots = new ItemBaseArmor(verantium_armor, EntityEquipmentSlot.FEET, "verantium_boots", Reference.MODID, ModTabs.tabLE);
	public static Item astrillHelmet = new ItemBaseArmor(astrill_armor, EntityEquipmentSlot.HEAD, "astrill_helmet", Reference.MODID, ModTabs.tabLE);
	public static Item astrillChestplate = new ItemBaseArmor(astrill_armor, EntityEquipmentSlot.CHEST, "astrill_chestplate", Reference.MODID, ModTabs.tabLE);
	public static Item astrillLeggings = new ItemBaseArmor(astrill_armor, EntityEquipmentSlot.LEGS, "astrill_leggings", Reference.MODID, ModTabs.tabLE);
	public static Item astrillBoots = new ItemBaseArmor(astrill_armor, EntityEquipmentSlot.FEET, "astrill_boots", Reference.MODID, ModTabs.tabLE);
	
	public static Item gyroChestplate = new ItemBaseArmor(gyro_chestplate, EntityEquipmentSlot.CHEST, "gyro_chestplate", Reference.MODID, ModTabs.tabLE);
	
	// generic melee
	// vanilla
	public static Item woodDagger = new ItemLEAdvancedMelee(ToolMaterial.WOOD, "wood_dagger", 0.5, 0.5, 40);
	public static Item woodMace = new ItemLEAdvancedMelee(ToolMaterial.WOOD, "wood_mace", 1.25, 1.25, 80);
	public static Item stoneDagger = new ItemLEAdvancedMelee(ToolMaterial.STONE, "stone_dagger", 0.5, 0.5, 100);
	public static Item stoneMace = new ItemLEAdvancedMelee(ToolMaterial.STONE, "stone_mace", 1.25, 1.25, 160);
	public static Item goldDagger = new ItemLEAdvancedMelee(ToolMaterial.GOLD, "gold_dagger", 0.5, 0.5, 20);
	public static Item goldMace = new ItemLEAdvancedMelee(ToolMaterial.GOLD, "gold_mace", 1.25, 1.25, 40);
	public static Item ironDagger = new ItemLEAdvancedMelee(ToolMaterial.IRON, "iron_dagger", 0.5, 0.5, 175);
	public static Item ironMace = new ItemLEAdvancedMelee(ToolMaterial.IRON, "iron_mace", 1.25, 1.25, 350);
	public static Item diamondDagger = new ItemLEAdvancedMelee(ToolMaterial.DIAMOND, "diamond_dagger", 0.5, 0.5, 1200);
	public static Item diamondMace = new ItemLEAdvancedMelee(ToolMaterial.DIAMOND, "diamond_mace", 1.25, 1.25, 1800);
	// modded
	public static Item verantiumDagger = new ItemLEAdvancedMelee(verantium, "verantium_dagger", 0.5, 0.5, 175);
	public static Item verantiumSword = new ItemLEMelee(verantium, "verantium_sword");
	public static Item verantiumMace = new ItemLEAdvancedMelee(verantium, "verantium_mace", 1.25, 1.25, 350);
	public static Item vexalDagger = new ItemLEAdvancedMelee(vexal, "vexal_dagger", 0.5, 0.5, 512);
	public static Item vexalSword = new ItemLEMelee(vexal, "vexal_sword");
	public static Item vexalMace = new ItemLEAdvancedMelee(vexal, "vexal_mace", 1.25, 1.25, 1024);
	public static Item astrillDagger = new ItemLEAdvancedMelee(astrill, "astrill_dagger", 0.5, 0.5, 1500);
	public static Item astrillSword = new ItemLEMelee(astrill, "astrill_sword");
	public static Item astrillMace = new ItemLEAdvancedMelee(astrill, "astrill_mace", 1.25, 1.25, 2500);
	
	// special melee
	public static Item crystallizedSword = new ItemLEMelee(crystallized, "crystallized_sword");
	public static Item gyroMace = new ItemLEAdvancedMelee(gyro, "gyro_mace", 1, 1.25);
	public static Item shadowBlade = new ItemLEMelee(shadow, "shadow_blade");
	public static Item maliceBlade = new ItemLEMelee(malice, "malice_blade");
	public static Item woeBlade = new ItemLEAdvancedMelee(woe, "woe_blade", 1, 0.5);
	public static Item darkMaliceBlade = new ItemLEMelee(dark_malice, "dark_malice_blade");
	public static Item soulInfusedSword = new ItemLEMelee(soul_infused, "soul_infused_sword");
	public static Item divineRapier = new ItemLEAdvancedMelee(divine, "divine_rapier", 1, 0.75);
	public static Item voidHammer = new ItemLEAdvancedMelee(void_hammer, "void_hammer", 1, 1.5);
	public static Item excaliburRapier = new ItemLEAdvancedMelee(excalibur, "excalibur_rapier", 1, 0.75);
	public static Item ardonsDagger = new ItemLEAdvancedMelee(ardon, "ardons_dagger", 1, 0.5);
	public static Item foundersBlade = new ItemLEMelee(founder, "founders_blade");
	
	// ranged
	public static Item ironStaff = new ItemIronStaff("iron_staff", Rarity.UNCOMMON, 1);
	public static Item verantiumStaff = new ItemVerantiumStaff("verantium_staff", Rarity.RARE, 2);
	public static Item astrillStaff = new ItemAstrillStaff("astrill_staff", Rarity.LEGENDARY, 3);
	public static Item infernoStaff = new ItemInfernoStaff("inferno_staff", Rarity.UNCOMMON, 1);
	public static Item blizzardStaff = new ItemBlizzardStaff("blizzard_staff", Rarity.UNCOMMON, 1);
	public static Item lightningStaff = new ItemLightningStaff("lightning_staff", Rarity.RARE, 2);
	public static Item elementalStaff = new ItemElementalStaff("elemental_staff", Rarity.RARE, 2);
	public static Item oblivionStaff = new ItemOblivionStaff("oblivion_staff", Rarity.LEGENDARY, 3);
	
	public static void registerItems()
	{
		// tools
		RegisterHelper.registerItems(verantiumPick);
		RegisterHelper.registerItems(verantiumShovel);
		RegisterHelper.registerItems(verantiumAxe);
		RegisterHelper.registerItems(astrillPick);
		RegisterHelper.registerItems(astrillShovel);
		RegisterHelper.registerItems(astrillAxe);
		
		// armor
		RegisterHelper.registerItems(verantiumHelmet);
		RegisterHelper.registerItems(verantiumChestplate);
		RegisterHelper.registerItems(verantiumLeggings);
		RegisterHelper.registerItems(verantiumBoots);
		RegisterHelper.registerItems(astrillHelmet);
		RegisterHelper.registerItems(astrillChestplate);
		RegisterHelper.registerItems(astrillLeggings);
		RegisterHelper.registerItems(astrillBoots);
		
		RegisterHelper.registerItems(gyroChestplate);
		
		// generic melee
		// vanilla
		RegisterHelper.registerItems(woodDagger);
		RegisterHelper.registerItems(woodMace);
		RegisterHelper.registerItems(stoneDagger);
		RegisterHelper.registerItems(stoneMace);
		RegisterHelper.registerItems(goldDagger);
		RegisterHelper.registerItems(goldMace);
		RegisterHelper.registerItems(ironDagger);
		RegisterHelper.registerItems(ironMace);
		RegisterHelper.registerItems(diamondDagger);
		RegisterHelper.registerItems(diamondMace);
		// modded
		RegisterHelper.registerItems(verantiumDagger);
		RegisterHelper.registerItems(verantiumSword);
		RegisterHelper.registerItems(verantiumMace);
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
		RegisterHelper.registerItems(woeBlade);
		RegisterHelper.registerItems(darkMaliceBlade);
		RegisterHelper.registerItems(soulInfusedSword);
		RegisterHelper.registerItems(divineRapier);
		RegisterHelper.registerItems(voidHammer);
		RegisterHelper.registerItems(excaliburRapier);
		RegisterHelper.registerItems(ardonsDagger);
		RegisterHelper.registerItems(foundersBlade);
		
		// ranged
		RegisterHelper.registerItems(ironStaff);
		RegisterHelper.registerItems(verantiumStaff);
		RegisterHelper.registerItems(astrillStaff);
		RegisterHelper.registerItems(infernoStaff);
		RegisterHelper.registerItems(blizzardStaff);
		RegisterHelper.registerItems(lightningStaff);
		RegisterHelper.registerItems(elementalStaff);
		RegisterHelper.registerItems(oblivionStaff);
	}
}
