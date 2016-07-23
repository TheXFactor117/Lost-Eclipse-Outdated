package com.thexfactor117.losteclipse.generation;

import java.util.Random;

import com.thexfactor117.losteclipse.LostEclipse;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

/**
 * 
 * @author TheXFactor117
 *
 */
public class StructureLEProcedurallyGenerated extends StructureLEBase
{
	public BlockPos getPosFromFacing(BlockPos oldPos, EnumFacing facing)
	{
		LostEclipse.LOGGER.info("FACING: " + facing);
		
		switch (facing)
		{
			case EAST: return this.getPosFromCorner(oldPos, 3, 0, 10, facing);
			case NORTH: return this.getPosFromCorner(oldPos, -7, 0, 10, facing);
			case SOUTH: return this.getPosFromCorner(oldPos, 3, 0, 0, facing);
			case WEST: return this.getPosFromCorner(oldPos, -7, 0, 0, facing);
			case UP:
				break;
			case DOWN:
				break;
			default:
				return oldPos;
		}
		LostEclipse.LOGGER.info("First Facing: " + facing);
		return this.getPosFromCorner(oldPos, 3, 0, 10, facing);
	}
	
	public BlockPos getPosFromFacing1(BlockPos oldPos, EnumFacing facing, EnumFacing previousFacing)
	{
		switch (previousFacing)
		{
			case EAST: 
				LostEclipse.LOGGER.info("EAST!");
				return this.getPosFromCorner(oldPos, 3, 0, 10, facing);
			case NORTH: 
				LostEclipse.LOGGER.info("NORTH!");
				return this.getPosFromCorner(oldPos, 10, 0, 3, facing);
			case SOUTH: 
				LostEclipse.LOGGER.info("SOUTH!");
				return this.getPosFromCorner(oldPos, 3, 0, 10, facing);
			case WEST: 
				LostEclipse.LOGGER.info("WEST!");
				return this.getPosFromCorner(oldPos, 0, 0, 0, facing);
			case UP:
				break;
			case DOWN:
				break;
			default:
				return oldPos;
		}
		
		return this.getPosFromCorner(oldPos, 3, 0, 10, facing);
	}
	
	public BlockPos getPosFromHallway(BlockPos oldPos, EnumFacing facing)
	{
		return this.getPosFromCorner(oldPos, -3, 0, 8, facing);
	}
	
	protected EnumFacing getRandomSide(Random rand, int roomCount)
	{
		int side = rand.nextInt(4);
		
		switch (side)
		{
			case 0: 
				this.setOffsetDistance(-9);
				return EnumFacing.NORTH;
			case 1: 
				this.setOffsetDistance(9);
				return EnumFacing.SOUTH;
			case 2: 
				this.setOffsetDistance(-6);
				return EnumFacing.EAST;
			case 3: 
				this.setOffsetDistance(6);
				return EnumFacing.WEST;
		}
		
		return null;
	}

	/**
	 * Returns amount to offset the x coordinate based on facing, assuming default facing of EAST
	 * @param dx	The default offset for x coordinate
	 * @param dz	The default offset for z coordinate
	 * @return		Value r such that (x + r) is the correct x position for this facing
	 */
	public int getOffsetX(int dx, int dz, EnumFacing facing) 
	{
		switch (facing) 
		{
			case EAST: return dx;
			case NORTH: return dz;
			case WEST: return -dx;
			case SOUTH: return -dz;
			default: return dx;
		}
	}

	/**
	 * Returns amount to offset the z coordinate based on facing, assuming default facing of EAST
	 * @param dx	The default offset for x coordinate
	 * @param dz	The default offset for z coordinate
	 * @return		Value r such that (z + r) is the correct z position for this facing
	 */
	public int getOffsetZ(int dx, int dz, EnumFacing facing) 
	{
		switch (facing) 
		{
			case EAST: return dz;
			case NORTH: return -dx;
			case WEST: return -dz;
			case SOUTH: return dx;
			default: return dz;
		}
	}
	
	protected int getOffsetFromSide(EnumFacing side)
	{
		if (side == EnumFacing.NORTH) return -9;
		if (side == EnumFacing.SOUTH) return 9;
		if (side == EnumFacing.EAST) return -6;
		if (side == EnumFacing.WEST) return 6;
		
		return 0;
	}
	
	protected void setOffsetDistance(int offset)
	{
		this.xOffset = offset;
	}
	
	protected int getOffsetDistance()
	{
		return this.xOffset;
	}
}
