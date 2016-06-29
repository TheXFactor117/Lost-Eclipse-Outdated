package com.thexfactor117.losteclipse.generation;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

/**
 * 
 * @author TheXFactor117
 *
 */
public class StructureLEBase extends WorldGenerator
{
	@Override
	public boolean generate(World world, Random rand, BlockPos position) 
	{
		return false;
	}
	
	protected void buildLayer(World world, BlockPos frontLeftCorner, int[][] blockPositions, IBlockState toPlace)
	{
		// iterate through the entire int[][]
		for(int[] coord : blockPositions)
		{
			placeBlock(world, frontLeftCorner, coord[0], coord[1], coord[2], toPlace);
		}
	}
	
	protected void placeBlock(World world, BlockPos frontLeftCorner, int[] offsets, IBlockState toPlace)
	{
		placeBlock(world, frontLeftCorner, offsets[0], offsets[1], offsets[2], toPlace);
	}
	
	/** Places a block using corner position and offsets **/
	protected void placeBlock(World world, BlockPos frontLeftCorner, int offsetX, int offsetY, int offsetZ, IBlockState toPlace)
	{	
		// figure out where that block is relative to the corner
		BlockPos placePos = frontLeftCorner.add(offsetX, offsetY, offsetZ);
		world.setBlockState(placePos, toPlace, 2);
	}
	
	protected void placeAirBlocks(World world, BlockPos frontLeftCorner, int maxX, int maxY, int maxZ)
	{
		IBlockState air = Blocks.AIR.getDefaultState();
		
		for (int x = 0; x < maxX; x++)
		{
			for (int y = 0; y < maxY; y++)
			{
				for (int z = 0; z < maxZ; z++)
				{
					BlockPos airblocks = frontLeftCorner.add(x, y, z);
					world.setBlockState(airblocks, air);
				}
			}
		}
	}
	
	protected boolean canSpawnUnderground(World world, BlockPos posUnderGround, int maxX, int maxY, int maxZ, int minY)
	{
		boolean corner1 = canReplaceStone(world, posUnderGround);
		boolean corner2 = canReplaceStone(world, posUnderGround.add(maxX, 0, 0));
		boolean corner3 = canReplaceStone(world, posUnderGround.add(0, 0, maxZ));
		boolean corner4 = canReplaceStone(world, posUnderGround.add(maxX, 0, maxZ));
		
		return posUnderGround.getY() > minY && posUnderGround.getY() < maxY && corner1 && corner2 && corner3 && corner4;
	}
	
	protected boolean canSpawnUnderground(World world, BlockPos posUnderGround, int minY, int maxY)
	{
		boolean corner = canReplaceStone(world, posUnderGround);
		
		return posUnderGround.getY() > minY && posUnderGround.getY() < maxY && corner;
	}
	
	protected boolean canSpawnHere(World world, BlockPos posAboveGround)
	{
		// check all the corners to see which ones are replaceable
		boolean corner1Air = canReplaceAir(world, posAboveGround);
		boolean corner2Air = canReplaceAir(world, posAboveGround.add(8, 0, 0));
		boolean corner4Air = canReplaceAir(world, posAboveGround.add(0, 0, 8));
		boolean corner3Air = canReplaceAir(world, posAboveGround.add(8, 0, 8));
		
		// if Y > 20 and all corners pass the test, it's okay to spawn the structure
		return posAboveGround.getY() > 20 && corner1Air && corner2Air && corner3Air && corner4Air;
	}
	
	protected boolean canReplaceAir(World world, BlockPos pos)
	{
		Block block = world.getBlockState(pos).getBlock();
		@SuppressWarnings("deprecation") // TODO: fix depreciation
		Material material = block.getMaterial(world.getBlockState(pos));
		return material.isReplaceable() || material == Material.PLANTS || material == Material.LEAVES;
	}
	
	protected boolean canReplaceStone(World world, BlockPos pos)
	{
		Block block = world.getBlockState(pos).getBlock();
		@SuppressWarnings("deprecation") // TODO: fix depreciation
		Material material = block.getMaterial(world.getBlockState(pos));
		return material == Material.ROCK;
	}
}
