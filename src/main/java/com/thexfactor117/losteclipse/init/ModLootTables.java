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
	public static final ResourceLocation ENTITY_COMMON_NORMAL = register("entities/common/common_normal");
	public static final ResourceLocation ENTITY_COMMON_HARDENED = register("entities/common/common_hardened");
	public static final ResourceLocation ENTITY_COMMON_SUPERIOR = register("entities/common/common_superior");
	public static final ResourceLocation ENTITY_COMMON_ELITE = register("entities/common/common_elite");
	public static final ResourceLocation ENTITY_COMMON_LEGENDARY = register("entities/common/common_legendary");
	public static final ResourceLocation ENTITY_SEMI_RARE_NORMAL = register("entities/semirare/semirare_normal");
	public static final ResourceLocation ENTITY_SEMI_RARE_HARDENED = register("entities/semirare/semirare_hardened");
	public static final ResourceLocation ENTITY_SEMI_RARE_SUPERIOR = register("entities/semirare/semirare_superior");
	public static final ResourceLocation ENTITY_SEMI_RARE_ELITE = register("entities/semirare/semirare_elite");
	public static final ResourceLocation ENTITY_SEMI_RARE_LEGENDARY = register("entities/semirare/semirare_legendary");
	public static final ResourceLocation ENTITY_RARE_NORMAL = register("entities/rare/rare_normal");
	public static final ResourceLocation ENTITY_RARE_HARDENED = register("entities/rare/rare_hardened");
	public static final ResourceLocation ENTITY_RARE_SUPERIOR = register("entities/rare/rare_superior");
	public static final ResourceLocation ENTITY_RARE_ELITE = register("entities/rare/rare_elite");
	public static final ResourceLocation ENTITY_RARE_LEGENDARY = register("entities/rare/rare_legendary");
	public static final ResourceLocation ENTITY_SEMI_BOSS_NORMAL = register("entities/semiboss/semiboss_normal");
	public static final ResourceLocation ENTITY_SEMI_BOSS_HARDENED = register("entities/semiboss/semiboss_hardened");
	public static final ResourceLocation ENTITY_SEMI_BOSS_SUPERIOR = register("entities/semiboss/semiboss_superior");
	public static final ResourceLocation ENTITY_SEMI_BOSS_ELITE = register("entities/semiboss/semiboss_elite");
	public static final ResourceLocation ENTITY_SEMI_BOSS_LEGENDARY = register("entities/semiboss/semiboss_legendary");
		
	private static ResourceLocation register(String name)
	{
		return LootTableList.register(new ResourceLocation(Reference.MODID, name));
	}
}
