package com.thexfactor117.losteclipse.config;

import java.io.File;
import java.util.List;

import com.google.common.collect.Lists;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

/**
 * 
 * @author TheXFactor117
 *
 */
public class Config 
{
	// configuration files
	private static Configuration main;
	private static Configuration worldgen;
	
	/*
	 * MAIN
	 */
	
	public static int difficulty = 1; // 0 = normal, 1 = hard, 2 = legendary
	
	/*
	 * WORLDGEN
	 */
	
	public static boolean spawnSmallHouse = true;
	public static boolean spawnDungeons = true;
	public static boolean spawnCastle = true;
	
	// chances
	public static int smallHouseChance = 150;
	public static int castleChance = 200;
	public static int proceduralDungeonChance = 500;
	
	public static void init(File dir)
	{
		main = new Configuration(new File(dir.getPath(), "losteclipse.cfg"));
		worldgen = new Configuration(new File(dir.getPath(), "worldgen.cfg"));
		
		sync();
	}
	
	private static void sync()
	{
		syncMain();
		syncWorldGens();
	}
	
	private static void syncMain()
	{
		String category = "main";
		List<String> propOrder = Lists.newArrayList();
		Property prop;
		
		prop = main.get(category, "difficulty", difficulty);
		prop.setComment("Changes the difficulty of the mod: 0 = normal, 1 = hard, 2 = legendary.");
		difficulty = prop.getInt();
		propOrder.add(prop.getName());
		
		main.setCategoryPropertyOrder(category, propOrder);
		main.save();
	}
	
	private static void syncWorldGens()
	{
		String category = "worldgen";
		List<String> propOrder = Lists.newArrayList();
		Property prop;

		prop = worldgen.get(category, "spawnSmallHouse", spawnSmallHouse);
		prop.setComment("If true, structures will spawn throughout the world (excludes dungeons).");
		spawnSmallHouse = prop.getBoolean();
		propOrder.add(prop.getName());
		
		prop = worldgen.get(category, "spawnCastle", spawnCastle);
		prop.setComment("If true, structures will spawn throughout the world (excludes dungeons).");
		spawnCastle = prop.getBoolean();
		propOrder.add(prop.getName());
		
		prop = worldgen.get(category, "spawnDungeons", spawnDungeons);
		prop.setComment("If true, dungeons will spawn throughout the world.");
		spawnDungeons = prop.getBoolean();
		propOrder.add(prop.getName());
		
		// chances
		prop = worldgen.get(category, "smallHouseChance", smallHouseChance);
		prop.setComment("Determines how frequently Small Houses will spawn. Higher numbers = less frequently (1 / number = percentage per chunk)");
		smallHouseChance = prop.getInt();
		propOrder.add(prop.getName());
		
		prop = worldgen.get(category, "castleChance", castleChance);
		prop.setComment("Determines how frequently Castles will spawn. Higher numbers = less frequently (1 / number = percentage per chunk)");
		castleChance = prop.getInt();
		propOrder.add(prop.getName());
		
		prop = worldgen.get(category, "proceduralDungeonChance", proceduralDungeonChance);
		prop.setComment("Determines how frequently Dungeons will spawn. Higher numbers = less frequently (1 / number = percentage per chunk). BE CAREFUL WITH THIS ONE. Higher frequencies can mess things up.");
		proceduralDungeonChance = prop.getInt();
		propOrder.add(prop.getName());
		
		worldgen.setCategoryPropertyOrder(category, propOrder);
		worldgen.save();
	}
}
