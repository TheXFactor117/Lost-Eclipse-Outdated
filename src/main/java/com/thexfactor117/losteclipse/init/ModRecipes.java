package com.thexfactor117.losteclipse.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ModRecipes 
{
	public static void registerRecipes()
	{
		registerMiscRecipes();
		registerArmoryRecipes();
	}
	
	public static void registerMiscRecipes()
	{
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.astrillGem), new Object[] { "AAA", "AAA", "AAA", 'A', ModItems.astrillGemFragment });
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.staffBase), new Object[] { "B", "A", "A", 'A', Items.STICK, 'B', ModItems.golemGyro });
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.frostDust, 2), new Object[] { ModItems.frostRod });
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.frostRod), new Object[] { ModItems.frostDust, Items.STICK });
	}
	
	public static void registerArmoryRecipes()
	{
		// tools
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.verantiumPick), new Object[] { "AAA", " B ", " B ", 'A', ModItems.verantiumIngot, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.verantiumShovel), new Object[] { "A", "B", "B", 'A', ModItems.verantiumIngot, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.verantiumAxe), new Object[] { "AA ", "AB ", " B ", 'A', ModItems.verantiumIngot, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.astrillPick), new Object[] { "AAA", " B ", " B ", 'A', ModItems.astrillGem, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.astrillShovel), new Object[] { "A", "B", "B", 'A', ModItems.astrillGem, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.astrillAxe), new Object[] { "AA ", "AB ", " B ", 'A', ModItems.astrillGem, 'B', Items.STICK });
		
		// armor
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.verantiumHelmet), new Object[] { "AAA", "A A", 'A', ModItems.verantiumIngot });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.verantiumChestplate), new Object[] { "A A", "AAA", "AAA", 'A', ModItems.verantiumIngot });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.verantiumLeggings), new Object[] { "AAA", "A A", "A A", 'A', ModItems.verantiumIngot });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.verantiumBoots), new Object[] { "A A", "A A", 'A', ModItems.verantiumIngot });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.astrillHelmet), new Object[] { "AAA", "A A", 'A', ModItems.astrillGem });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.astrillChestplate), new Object[] { "A A", "AAA", "AAA", 'A', ModItems.astrillGem });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.astrillLeggings), new Object[] { "AAA", "A A", "A A", 'A', ModItems.astrillGem });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.astrillBoots), new Object[] { "A A", "A A", 'A', ModItems.astrillGem });
		
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.gyroChestplate), new Object[] { "A A", "AAA", "AAA", 'A', ModItems.golemGyro });
		
		// generic melee
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.woodDagger), new Object[] { "A", "B", 'A', Blocks.PLANKS, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.woodMace), new Object[] { " A ", "ABA", " B ", 'A', Blocks.PLANKS, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.stoneDagger), new Object[] { "A", "B", 'A', Blocks.COBBLESTONE, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.stoneMace), new Object[] { " A ", "ABA", " B ", 'A', Blocks.COBBLESTONE, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.goldDagger), new Object[] { "A", "B", 'A', Items.GOLD_INGOT, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.goldMace), new Object[] { " A ", "ABA", " B ", 'A', Items.GOLD_INGOT, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.ironDagger), new Object[] { "A", "B", 'A', Items.IRON_INGOT, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.ironMace), new Object[] { " A ", "ABA", " B ", 'A', Items.IRON_INGOT, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.verantiumDagger), new Object[] { "A", "B", 'A', ModItems.verantiumIngot, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.verantiumSword), new Object[] { "A", "A", "B", 'A', ModItems.verantiumIngot, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.verantiumMace), new Object[] { " A ", "ABA", " B ", 'A', ModItems.verantiumIngot, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.vexalDagger), new Object[] { "A", "B", 'A', ModItems.vexalGem, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.vexalSword), new Object[] { "A", "A", "B", 'A', ModItems.vexalGem, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.vexalMace), new Object[] { " A ", "ABA", " B ", 'A', ModItems.vexalGem, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.diamondDagger), new Object[] { "A", "B", 'A', Items.DIAMOND, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.diamondMace), new Object[] { " A ", "ABA", " B ", 'A', Items.DIAMOND, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.astrillDagger), new Object[] { "A", "B", 'A', ModItems.astrillGem, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.astrillSword), new Object[] { "A", "A", "B", 'A', ModItems.astrillGem, 'B', Items.STICK });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.astrillMace), new Object[] { " A ", "ABA", " B ", 'A', ModItems.astrillGem, 'B', Items.STICK });
		
		// special melee
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.gyroMace), new Object[] { " A ", "ABA", " B ", 'A', ModItems.golemGyro, 'B', Items.STICK });
		
		// ranged
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.ironStaff), new Object[] { "A", "B", "A", 'A', Items.IRON_INGOT, 'B', ModItems.staffBase });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.verantiumStaff), new Object[] { "A", "B", "A", 'A', ModItems.verantiumIngot, 'B', ModItems.staffBase });
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.astrillStaff), new Object[] { "A", "B", "A", 'A', ModItems.astrillGem, 'B', ModItems.staffBase });
	}
}
