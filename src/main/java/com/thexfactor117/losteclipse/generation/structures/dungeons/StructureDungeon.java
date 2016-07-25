package com.thexfactor117.losteclipse.generation.structures.dungeons;

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
	private EnumFacing previousFacing;
	
	@Override
	public boolean generate(World world, Random rand, BlockPos position)
	{	
		if (this.canSpawnUnderground(world, position, 2, 100))
		{
			int maxRooms = rand.nextInt(5) + 3;
			LostEclipse.LOGGER.info("Procedural generation beginning...");
			this.procedurallyGenerate(world, rand, position, maxRooms);
			return true;
		}
		
		return false;
	}
	
	protected void procedurallyGenerate(World world, Random rand, BlockPos position, int maxRooms)
	{
		if (roomCount == maxRooms) return;
		
		EnumFacing facing = EnumFacing.getHorizontal(world.rand.nextInt(4));
		
		if (previousFacing != null)
		{
			if (facing == previousFacing.getOpposite()) return;
		}
		
		BlockPos nextPosition = position;
		
		if (roomCount == 0) 
		{
			WorldGenerator entrance = new StructureDungeonEntrance(EnumFacing.NORTH);
			entrance.generate(world, rand, position);
			BlockPos hallwayPosition = this.getPosFromFacing(position, facing);
			WorldGenerator hallway = new StructureDungeonHallway(facing);
			hallway.generate(world, rand, hallwayPosition);
			BlockPos roomPosition = this.getPosFromHallway(hallwayPosition, facing);
			nextPosition = roomPosition;
			this.generateRoom(world, rand, roomPosition, facing);
			previousFacing = facing;
		}
		else
		{
			BlockPos hallwayPosition = this.getPosFromFacing(position, facing, previousFacing);
			WorldGenerator hallway = new StructureDungeonHallway(facing);
			hallway.generate(world, rand, hallwayPosition);
			BlockPos roomPosition = this.getPosFromHallway(hallwayPosition, facing);
			nextPosition = roomPosition;
			this.generateRoom(world, rand, roomPosition, facing);
			previousFacing = facing;
		}
				
		roomCount++;
		procedurallyGenerate(world, rand, nextPosition, maxRooms);
	}
	
	protected void generateRoom(World world, Random rand, BlockPos roomPosition, EnumFacing facing)
	{
		int index = rand.nextInt(3);
		
		switch (index)
		{
			case 0:
				WorldGenerator base = new StructureDungeonBaseRoom(facing);
				base.generate(world, rand, roomPosition);
			case 1:
				WorldGenerator lootRoom = new StructureDungeonLootRoom(facing);
				lootRoom.generate(world, rand, roomPosition);
			case 2:
				WorldGenerator maze = new StructureDungeonMaze(facing);
				maze.generate(world, rand, roomPosition);
		}
	}
}
