package com.thexfactor117.losteclipse.generation.procedural;

import java.util.ArrayList;
import java.util.Random;

import com.thexfactor117.losteclipse.LostEclipse;

import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.TemplateManager;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ProceduralDungeon extends ProceduralDungeonBase
{	
	public ProceduralDungeon(int maxRooms)
	{
		super(maxRooms);
	}
	
	@Override
	public boolean generate(World world, Random rand, BlockPos position) 
	{
		if (this.canSpawnUnderground(world, position, 2, 50))
		{
			WorldServer server = (WorldServer) world;
			TemplateManager manager = server.getStructureTemplateManager();
			
			procedurallyGenerate(manager, world, position, null, maxRooms);
			
			return true;
		}
		
		return false;
	}
	
	private void procedurallyGenerate(TemplateManager manager, World world, BlockPos startingPos, ArrayList<PotentialPosition> potentialPositions, int maxRooms)
	{
		LostEclipse.LOGGER.info("Generating room " + roomCount + " out of " + maxRooms);
		ArrayList<PotentialPosition> nextPositions = potentialPositions;
		
		if (roomCount == maxRooms)
		{
			return;
		}
		else
		{
			if (roomCount == 0)
			{
				nextPositions = generateStartingRoom(manager, world, startingPos, maxRooms);
			}
			else
			{
				nextPositions = generateRooms(manager, world, potentialPositions, maxRooms);
			}
		}
		
		for (int i = 0; i < nextPositions.size(); i++)
		{
			if (nextPositions.get(i) == null)
			{
				nextPositions.remove(i);
			}
		}
		
		roomCount++;
		procedurallyGenerate(manager, world, startingPos, nextPositions, maxRooms);
	}
	
	/**
	 * Checks to see if the structure can spawn underground by checking block materials and Y-positions.
	 * @param world
	 * @param posUnderGround
	 * @param minY
	 * @param maxY
	 * @return
	 */
	private boolean canSpawnUnderground(World world, BlockPos posUnderGround, int minY, int maxY)
	{
		boolean corner = canReplaceMaterial(world, posUnderGround, Material.ROCK);
		
		return posUnderGround.getY() > minY && posUnderGround.getY() < maxY && corner;
	}
	
	/**
	 * Check this when spawning structures surrounded by the given material.
	 * @param world
	 * @param pos
	 * @param materials
	 * @return
	 */
	private boolean canReplaceMaterial(World world, BlockPos pos, Material materials)
	{
		Material material = world.getBlockState(pos).getMaterial();
		return material == materials;
	}
}
