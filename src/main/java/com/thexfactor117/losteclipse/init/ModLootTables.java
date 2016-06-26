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
	public static final ResourceLocation ENTITY_BARBARIAN = register("entity_barbarian");
	
	private static ResourceLocation register(String id)
	{
		return LootTableList.register(new ResourceLocation(Reference.MODID, id));
	}
}
