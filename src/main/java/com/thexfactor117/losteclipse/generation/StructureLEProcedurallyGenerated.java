package com.thexfactor117.losteclipse.generation;

import java.util.Random;

import net.minecraft.util.EnumFacing;

/**
 * 
 * @author TheXFactor117
 *
 */
public class StructureLEProcedurallyGenerated extends StructureLEBase
{
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
