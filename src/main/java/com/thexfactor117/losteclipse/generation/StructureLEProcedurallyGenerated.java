package com.thexfactor117.losteclipse.generation;

import com.thexfactor117.losteclipse.LostEclipse;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;

/**
 * 
 * @author TheXFactor117
 *
 * TODO: Remove the hardcoded limitations?
 */
public class StructureLEProcedurallyGenerated extends StructureLEBase
{
	/**
	 * Using the position and facing provided, generate a new BlockPos using the hardcoded offsets below. All Dungeon rooms
	 * should have the same dimensions, so these offsets should never break (they will if the room dimensions are different!).
	 * @param oldPos
	 * @param facing
	 * @return
	 */
	public BlockPos getPosFromFacing(BlockPos oldPos, EnumFacing facing)
	{
		LostEclipse.LOGGER.info("FACING: " + facing);
		
		switch (facing)
		{
			case NORTH: return this.getPosFromCorner(oldPos, 3, 0, 10, facing);
			case EAST: return this.getPosFromCorner(oldPos, 3, 0, 0, facing);
			case SOUTH: return this.getPosFromCorner(oldPos, -7, 0, 0, facing);
			case WEST: return this.getPosFromCorner(oldPos, -7, 0, 10, facing);
			default: return oldPos;
		}
	}
	
	/**
	 * Using the position, facing, and previous facing provided, generate a new BlockPos using the hardcoded offsets below. All Dungeon rooms
	 * should have the same dimensions, so these offsets should never break (they will if the room dimensions are different!).
	 * @param oldPos
	 * @param facing
	 * @param previousFacing
	 * @return
	 */
	public BlockPos getPosFromFacing(BlockPos oldPos, EnumFacing facing, EnumFacing previousFacing)
	{
		LostEclipse.LOGGER.info("PREV FACING: " + previousFacing);
		LostEclipse.LOGGER.info("NEW FACING: " + facing);
		
		switch (previousFacing)
		{
			case NORTH: 
				switch (facing)
				{
					case NORTH: return this.getPosFromCorner(oldPos, 3, 0, 10, facing);
					case EAST: return this.getPosFromCorner(oldPos, 3, 0, 0, facing);
					case SOUTH: return this.getPosFromCorner(oldPos, -7, 0, 0, facing);
					case WEST: return this.getPosFromCorner(oldPos, -7, 0, 10, facing);
					default: return oldPos;
				}
			case EAST: 
				switch (facing)
				{
					case NORTH: return this.getPosFromCorner(oldPos, -7, 0, 10, facing);
					case EAST: return this.getPosFromCorner(oldPos, 3, 0, 10, facing);
					case SOUTH: return this.getPosFromCorner(oldPos, 3, 0, 0, facing);
					case WEST: return this.getPosFromCorner(oldPos, -7, 0, 0, facing);
					default: return oldPos;
				}
			case SOUTH: 
				switch (facing)
				{
				case NORTH: return this.getPosFromCorner(oldPos, -7, 0, 0, facing);
					case EAST: return this.getPosFromCorner(oldPos, -7, 0, 10, facing);
					case SOUTH: return this.getPosFromCorner(oldPos, 3, 0, 10, facing);
					case WEST: return this.getPosFromCorner(oldPos, 3, 0, 0, facing);
					default: return oldPos;
				}
			case WEST: 
				switch (facing)
				{
					case NORTH: return this.getPosFromCorner(oldPos, 3, 0, 0, facing);
					case EAST: return this.getPosFromCorner(oldPos, -7, 0, 0, facing);
					case SOUTH: return this.getPosFromCorner(oldPos, -7, 0, 10, facing);
					case WEST: return this.getPosFromCorner(oldPos, 3, 0, 10, facing);
					default: return oldPos;
				}
			default: return oldPos;
		}
	}
	
	/**
	 * Gets the new room position based on the hallways position and facing.
	 * @param oldPos
	 * @param facing
	 * @return
	 */
	public BlockPos getPosFromHallway(BlockPos oldPos, EnumFacing facing)
	{
		return this.getPosFromCorner(oldPos, -3, 0, 8, facing);
	}
}
