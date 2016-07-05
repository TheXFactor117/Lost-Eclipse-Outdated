package com.thexfactor117.losteclipse.generation.structures.dungeons;

import java.util.Random;

import com.thexfactor117.losteclipse.generation.StructureLEBase;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * 
 * @author TheXFactor117
 *
 */
public class StructureDungeonEntrance extends StructureLEBase
{
	protected EnumFacing facing;
	
	protected StructureDungeonEntrance(EnumFacing facing)
	{
		this.facing = facing;
	}
	
	//private final int[][] stoneBrickPos = new int[][]
	//{
		
	//};
	
	@Override
	public boolean generate(World world, Random rand, BlockPos position) 
	{
		return true;
	}
}
