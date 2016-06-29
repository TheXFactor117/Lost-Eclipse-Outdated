package com.thexfactor117.losteclipse.generation.structures;

import java.util.Random;

import com.thexfactor117.losteclipse.LostEclipse;
import com.thexfactor117.losteclipse.generation.StructureLEBase;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

/**
 * 
 * @author TheXFactor117
 *
 */
public class StructureDungeon extends StructureLEBase
{
	private int roomCount;
	private int xOffset;
	
	@Override
	public boolean generate(World world, Random rand, BlockPos position)
	{	
		if (this.canSpawnUnderground(world, position, 10, 50))
		{
			int maxRooms = rand.nextInt(6);
			LostEclipse.LOGGER.info("Procedural generation beginning...");
			this.procedurallyGenerate(world, rand, position, maxRooms);
			return true;
		}
		
		return false;
	}
	
	protected void procedurallyGenerate(World world, Random rand, BlockPos position, int maxRooms)
	{
		if (roomCount == maxRooms) return;
		
		WorldGenerator lootRoom = new StructureDungeonLootRoom1();
		
		lootRoom.generate(world, rand, position);
		
		BlockPos newPosition = position.offset(getRandomSide(rand), this.getOffsetDistance());
		
		roomCount++;
		procedurallyGenerate(world, rand, newPosition, maxRooms);
	}
	
	protected EnumFacing getRandomSide(Random rand)
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
				this.setOffsetDistance(6);
				return EnumFacing.EAST;
			case 3: 
				this.setOffsetDistance(6);
				return EnumFacing.WEST;
		}
		
		return null;
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
