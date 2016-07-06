package com.thexfactor117.losteclipse.init;

import com.thexfactor117.losteclipse.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ModLootTables 
{
	// structures
	public static final ResourceLocation STRUCTURE_ABANDONED_HOUSE = register("structures/abandoned_house");
	
	// monsters
	public static final ResourceLocation ENTITY_BARBARIAN = register("entities/barbarian");
	public static final ResourceLocation ENTITY_BEAR = register("entities/bear");
	public static final ResourceLocation ENTITY_GHOST = register("entities/ghost");
	public static final ResourceLocation ENTITY_GOBLIN = register("entities/goblin");
	public static final ResourceLocation ENTITY_MUMMY = register("entities/mummy");
	public static final ResourceLocation ENTITY_SNOW_BLAZE = register("entities/snow_blaze");
	public static final ResourceLocation ENTITY_VALKYRIE = register("entities/valkyrie");
	public static final ResourceLocation ENTITY_BANDIT = register("entities/bandit");
	public static final ResourceLocation ENTITY_BANSHEE = register("entities/banshee");
	public static final ResourceLocation ENTITY_FROZEN_WIGHT = register("entities/frozen_wight");
	public static final ResourceLocation ENTITY_ORC = register("entities/orc");
	public static final ResourceLocation ENTITY_PIRATE = register("entities/pirate");
	public static final ResourceLocation ENTITY_GOLEM = register("entities/golem");
	public static final ResourceLocation ENTITY_TROLL = register("entities/troll");
	public static final ResourceLocation ENTITY_WRAITH = register("entities/wraith");
	public static final ResourceLocation ENTITY_PHARAOH = register("entities/pharaoh");
	public static final ResourceLocation ENTITY_MINI_GOLEM = register("entities/mini_golem");
	public static final ResourceLocation ENTITY_WRAITH_DEATHLORD = register("entities/wraith_deathlord");
	public static final ResourceLocation ENTITY_KOUYATE = register("entities/kouyate");
	public static final ResourceLocation ENTITY_KING_RAHMAN = register("entities/king_rahman");
	
	private static ResourceLocation register(String name)
	{
		return LootTableList.register(new ResourceLocation(Reference.MODID, name));
	}
}
