package com.thexfactor117.losteclipse.items;

import java.util.Random;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.generation.structures.StructureTower;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ItemTest extends ItemLE
{
	public ItemTest(String name, Rarity rarity) 
	{
		super(name, rarity);
	}
	
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		if (!world.isRemote)
		{
			Random random = world.rand;
			StructureTower structure = new StructureTower();
			structure.generate(world, random, pos);
			
			return EnumActionResult.SUCCESS;
		}
		
		return EnumActionResult.PASS;
    }
}