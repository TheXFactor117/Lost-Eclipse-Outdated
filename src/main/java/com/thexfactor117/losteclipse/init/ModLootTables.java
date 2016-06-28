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
	public static final ResourceLocation STRUCTURE_ABANDONED_HOUSE = register("structure_abandoned_house");
	
	// monsters
	public static final ResourceLocation ENTITY_BARBARIAN = register("entity_barbarian");
	public static final ResourceLocation ENTITY_BEAR = register("entity_bear");
	public static final ResourceLocation ENTITY_GHOST = register("entity_ghost");
	public static final ResourceLocation ENTITY_GOBLIN = register("entity_goblin");
	public static final ResourceLocation ENTITY_MUMMY = register("entity_mummy");
	public static final ResourceLocation ENTITY_SNOW_BLAZE = register("entity_snow_blaze");
	public static final ResourceLocation ENTITY_VALKYRIE = register("entity_valkyrie");
	public static final ResourceLocation ENTITY_BANDIT = register("entity_bandit");
	public static final ResourceLocation ENTITY_BANSHEE = register("entity_banshee");
	public static final ResourceLocation ENTITY_FROZEN_WIGHT = register("entity_frozen_wight");
	public static final ResourceLocation ENTITY_ORC = register("entity_orc");
	public static final ResourceLocation ENTITY_PIRATE = register("entity_pirate");
	public static final ResourceLocation ENTITY_GOLEM = register("entity_golem");
	public static final ResourceLocation ENTITY_TROLL = register("entity_troll");
	public static final ResourceLocation ENTITY_WRAITH = register("entity_wraith");
	public static final ResourceLocation ENTITY_PHARAOH = register("entity_pharaoh");
	public static final ResourceLocation ENTITY_MINI_GOLEM = register("entity_mini_golem");
	public static final ResourceLocation ENTITY_WRAITH_DEATHLORD = register("entity_wraith_deathlord");
	public static final ResourceLocation ENTITY_KOUYATE = register("entity_kouyate");
	public static final ResourceLocation ENTITY_KING_RAHMAN = register("entity_king_rahman");
	
	private static ResourceLocation register(String id)
	{
		return LootTableList.register(new ResourceLocation(Reference.MODID, id));
	}
}
