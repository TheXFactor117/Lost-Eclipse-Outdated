package com.thexfactor117.losteclipse.generation;

import java.util.ArrayList;

import com.thexfactor117.losteclipse.LostEclipse;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.TemplateManager;

/**
 * 
 * @author TheXFactor117
 *
 */
public class GenerateProcedural
{
	public static int roomCount = 0;
	private static ArrayList<BlockPos> roomPositions = new ArrayList<BlockPos>();
	private static ArrayList<BlockPos> hallwayPositions = new ArrayList<BlockPos>();
	private static ArrayList<PotentialPosition> potentialPositions = new ArrayList<PotentialPosition>();
	
	public static void procedurallyGenerate(TemplateManager manager, World world, BlockPos startingPos, int maxRooms)
	{
		LostEclipse.LOGGER.info("Max Rooms: " + maxRooms + "\tRoom Count: " + roomCount);

		if (roomCount == maxRooms) 
		{
			for (int i = 0; i < roomPositions.size(); i++) roomPositions.remove(i);
			for (int i = 0; i < hallwayPositions.size(); i++) hallwayPositions.remove(i);
			for (int i = 0; i < potentialPositions.size(); i++) potentialPositions.remove(i);
			roomCount = 0;
			return;
		}

		if (roomCount != maxRooms)
		{
			if (roomCount == 0)
				ProceduralUtil.generateStartingRoom(manager, world, startingPos, roomPositions, hallwayPositions, potentialPositions, maxRooms);
			else
			{
				LostEclipse.LOGGER.info("Generating rooms!");
				ProceduralUtil.generateRooms(manager, world, roomPositions, hallwayPositions, potentialPositions, maxRooms);
			}
		}
		
		for (int i = 0; i < potentialPositions.size(); i++) 
			potentialPositions.remove(i);
		
		roomCount++;
		procedurallyGenerate(manager, world, startingPos, maxRooms);
	}
}
