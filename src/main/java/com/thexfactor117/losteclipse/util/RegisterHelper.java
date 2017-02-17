package com.thexfactor117.losteclipse.util;

import com.thexfactor117.losteclipse.blocks.BlockBase;
import com.thexfactor117.losteclipse.items.base.ItemBase;
import com.thexfactor117.losteclipse.items.base.ItemBaseArmor;
import com.thexfactor117.losteclipse.items.base.ItemBaseAxe;
import com.thexfactor117.losteclipse.items.base.ItemBaseHoe;
import com.thexfactor117.losteclipse.items.base.ItemBasePickaxe;
import com.thexfactor117.losteclipse.items.base.ItemBaseShovel;
import com.thexfactor117.losteclipse.items.base.ItemBaseSword;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * 
 * @author TheXFactor117
 *
 */
public class RegisterHelper 
{
	public static void registerItems(Item item)
	{
		GameRegistry.register(item);
		
		if (item instanceof ItemBase)
			((ItemBase) item).registerItemRenderer();
		else if (item instanceof ItemBaseArmor)
			((ItemBaseArmor) item).registerItemRenderer();
		else if (item instanceof ItemBaseAxe)
			((ItemBaseAxe) item).registerItemRenderer();
		else if (item instanceof ItemBaseHoe)
			((ItemBaseHoe) item).registerItemRenderer();
		else if (item instanceof ItemBasePickaxe)
			((ItemBasePickaxe) item).registerItemRenderer();
		else if (item instanceof ItemBaseShovel)
			((ItemBaseShovel) item).registerItemRenderer();
		else if (item instanceof ItemBaseSword)
			((ItemBaseSword) item).registerItemRenderer();
	}
	
	public static void registerBlocks(Block block)
	{
		ItemBlock itemBlock = new ItemBlock(block);
		itemBlock.setRegistryName(block.getRegistryName());
		
		GameRegistry.register(block);
		GameRegistry.register(itemBlock);
		
		if (block instanceof BlockBase)
		{
			((BlockBase) block).registerItemModel(itemBlock);
		}
	}
}
