package com.thexfactor117.losteclipse.generation;

import java.util.Random;

import com.thexfactor117.losteclipse.LostEclipse;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
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
	protected int xOffset;
	
	@Override
	public boolean generate(World world, Random rand, BlockPos position) 
	{
		return false;
	}
	
	/**
	 * Builds an entire layer of blocks according to the arrays of block positions.
	 * @param world
	 * @param frontLeftCorner
	 * @param blockPositions
	 * @param toPlace
	 * @param facing
	 */
	protected void buildLayer(World world, BlockPos frontLeftCorner, int[][] blockPositions, IBlockState toPlace, EnumFacing facing)
	{
		// iterate through the entire int[][]
		for(int[] coord : blockPositions)
		{
			placeBlock(world, frontLeftCorner, coord[0], coord[1], coord[2], toPlace, facing);
		}
	}
	
	/**
	 * Places a block using an array of offsets.
	 * @param world
	 * @param frontLeftCorner
	 * @param offsets
	 * @param toPlace
	 * @param facing
	 */
	protected void placeBlock(World world, BlockPos frontLeftCorner, int[] offsets, IBlockState toPlace, EnumFacing facing)
	{
		placeBlock(world, frontLeftCorner, offsets[0], offsets[1], offsets[2], toPlace, facing);
	}
	
	/**
	 * Places a block using corner position and offsets
	 * @param world
	 * @param frontLeftCorner
	 * @param offsetX
	 * @param offsetY
	 * @param offsetZ
	 * @param toPlace
	 * @param facing
	 */
	protected void placeBlock(World world, BlockPos frontLeftCorner, int offsetX, int offsetY, int offsetZ, IBlockState toPlace, EnumFacing facing)
	{	
		//BlockPos placePos = frontLeftCorner.add(offsetX, offsetY, offsetZ);
		BlockPos placePos = getPosFromCorner(frontLeftCorner, offsetX, offsetY, offsetZ, facing);
		world.setBlockState(placePos, toPlace, 3);
	}
	
	/**
	 * Places air blocks in a cube in order to clear out the space for a structure to spawn.
	 * @param world
	 * @param frontLeftCorner
	 * @param maxX
	 * @param maxY
	 * @param maxZ
	 * @param facing
	 */
	protected void placeAirBlocks(World world, BlockPos frontLeftCorner, int maxX, int maxY, int maxZ, EnumFacing facing, int minY)
	{
		IBlockState air = Blocks.AIR.getDefaultState();
		
		for (int x = 0; x < maxX; x++)
		{
			for (int y = 0 - minY; y < maxY; y++)
			{
				for (int z = 0; z < maxZ; z++)
				{
					BlockPos airblocks = getPosFromCorner(frontLeftCorner, maxX, maxY, maxZ, facing);
					world.setBlockState(airblocks, air);
				}
			}
		}
	}
	
	/**
	 * Checks to see if the structure can spawn underground by checking block materials for all 4 corners and Y-positions.
	 * @param world
	 * @param posUnderGround
	 * @param maxX
	 * @param maxY
	 * @param maxZ
	 * @param minY
	 * @return
	 */
	protected boolean canSpawnUnderground(World world, BlockPos posUnderGround, int maxX, int maxY, int maxZ, int minY)
	{
		boolean corner1 = canReplaceMaterial(world, posUnderGround, Material.ROCK);
		boolean corner2 = canReplaceMaterial(world, posUnderGround.add(maxX, 0, 0), Material.ROCK);
		boolean corner3 = canReplaceMaterial(world, posUnderGround.add(0, 0, maxZ), Material.ROCK);
		boolean corner4 = canReplaceMaterial(world, posUnderGround.add(maxX, 0, maxZ), Material.ROCK);
		
		return posUnderGround.getY() > minY && posUnderGround.getY() < maxY && corner1 && corner2 && corner3 && corner4;
	}
	
	/**
	 * Checks to see if the structure can spawn underground by checking block materials and Y-positions.
	 * @param world
	 * @param posUnderGround
	 * @param minY
	 * @param maxY
	 * @return
	 */
	protected boolean canSpawnUnderground(World world, BlockPos posUnderGround, int minY, int maxY)
	{
		boolean corner = canReplaceMaterial(world, posUnderGround, Material.ROCK);
		
		return posUnderGround.getY() > minY && posUnderGround.getY() < maxY && corner;
	}
	
	/**
	 * Checks the four corners of the structure spot.
	 * @param world
	 * @param posAboveGround
	 * @param maxX - max x direction of structure (relative to structure corner)
	 * @param maxZ - max z direction of structure (relative to structure corner)
	 * @return
	 */
	protected boolean canSpawnAboveGround(World world, BlockPos posAboveGround, int maxX, int maxZ)
	{
		boolean corner1Air = canReplaceAboveGround(world, posAboveGround);
		boolean corner2Air = canReplaceAboveGround(world, posAboveGround.add(maxX, 0, 0));
		boolean corner4Air = canReplaceAboveGround(world, posAboveGround.add(0, 0, maxZ));
		boolean corner3Air = canReplaceAboveGround(world, posAboveGround.add(maxX, 0, maxZ));
		
		return posAboveGround.getY() > 0 && corner1Air && corner2Air && corner3Air && corner4Air;
	}
	
	protected boolean canReplaceAboveGround(World world, BlockPos pos)
	{
		Material material = world.getBlockState(pos).getMaterial();
		return material.isReplaceable() || material == Material.PLANTS || material == Material.LEAVES || material == Material.GRASS;
	}
	
	protected boolean canReplaceMaterial(World world, BlockPos pos, Material materials)
	{
		Material material = world.getBlockState(pos).getMaterial();
		return material == materials;
	}
	
	public BlockPos getPosFromCorner1(BlockPos corner, int maxDisForward, int maxDisRight, EnumFacing forward)
	{			
		EnumFacing right = forward.rotateY();
		
		switch (forward)
		{
			case NORTH: 
				LostEclipse.LOGGER.info("NORTH: " + forward + " " + maxDisForward);
				return corner.offset(forward, 0).offset(right, 0);
			case EAST: 
				LostEclipse.LOGGER.info("EAST: " + forward + " " + maxDisForward + " " + right + " " + maxDisRight);
				return corner.offset(forward, maxDisForward).offset(right, maxDisRight);
			case SOUTH: 
				LostEclipse.LOGGER.info("SOUTH: " + forward + " " + maxDisForward + right + " " + maxDisRight);
				return corner.offset(right, 0);
			case WEST: 
				LostEclipse.LOGGER.info("WEST: " + forward + " " + maxDisForward + right + " " + maxDisRight);
				return corner.offset(forward, 6).offset(right, 3 );
			default: break;
		}
				
		return corner.offset(forward, maxDisForward).offset(right, maxDisRight);
	}
	
	public BlockPos getPosFromCorner(BlockPos corner, int disForward, int disUp, int disRight, EnumFacing forward)
	{
		EnumFacing right = forward.rotateY();
		return corner.offset(forward, disForward).offset(right, disRight).up(disUp);
	}
	
	protected EnumFacing getRandomSideWithoutOffset(Random rand)
	{
		int side = rand.nextInt(4);
		
		switch (side)
		{
			case 0: 
				return EnumFacing.NORTH;
			case 1: 
				return EnumFacing.SOUTH;
			case 2: 
				return EnumFacing.EAST;
			case 3: 
				return EnumFacing.WEST;
		}
		
		return null;
	}
}
