package com.thexfactor117.losteclipse.generation.structures;

import java.util.Random;

import com.thexfactor117.losteclipse.LostEclipse;
import com.thexfactor117.losteclipse.generation.StructureLEProcedurallyGenerated;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

/**
 * 
 * @author TheXFactor117
 *
 */
public class StructureDungeon extends StructureLEProcedurallyGenerated
{
	private int roomCount;
	
	@Override
	public boolean generate(World world, Random rand, BlockPos position)
	{	
		if (this.canSpawnUnderground(world, position, 2, 50))
		{
			int maxRooms = rand.nextInt(6);
			LostEclipse.LOGGER.info("Procedural generation beginning...");
			EnumFacing side = getRandomSideWithoutOffset(rand);
			this.procedurallyGenerate(world, rand, position, maxRooms, side);
			return true;
		}
		
		return false;
	}
	
	protected void procedurallyGenerate(World world, Random rand, BlockPos position, int maxRooms, EnumFacing side)
	{
		if (roomCount == maxRooms) return;
		
		WorldGenerator lootRoom = new StructureDungeonLootRoom1();
		
		BlockPos newPosition = position;
		
		if (roomCount == 0) lootRoom.generate(world, rand, position);
		else
		{
			newPosition = getPosFromCorner(position, 6, 9, side);
			
			lootRoom.generate(world, rand, newPosition);
			LostEclipse.LOGGER.info("Loot room generated. Count: " + roomCount);
			LostEclipse.LOGGER.info("Loot Room " + roomCount + "coords:" + newPosition);
		}
		
		roomCount++;
		procedurallyGenerate(world, rand, newPosition, maxRooms, side);
	}
}
