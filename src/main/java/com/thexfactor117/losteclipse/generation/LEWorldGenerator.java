package com.thexfactor117.losteclipse.generation;

import java.util.Random;

import com.thexfactor117.losteclipse.generation.structures.StructureAbandonedHouse;
import com.thexfactor117.losteclipse.generation.structures.StructureDungeonLootRoom1;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

/**
 * 
 * @author TheXFactor117
 *
 */
public class LEWorldGenerator implements IWorldGenerator
{
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		int blockX = chunkX * 16;
		int blockZ = chunkZ * 16;
		
		switch (world.provider.getDimension())
		{
			case -1: 
				generateNether(world, rand, blockX, blockZ);
				break;
			case 0: 
				generateOverworld(world, rand, blockX, blockZ);
				break;
			case 1: 
				generateEnd(world, rand, blockX, blockZ);
				break;
		}
	}
	
	private void generateOverworld(World world, Random rand, int blockX, int blockZ)
	{
		WorldGenerator abandonedHouse = new StructureAbandonedHouse();
		if (rand.nextInt(4) == 0)
		{
			int randX = blockX + rand.nextInt(16);
			int randZ = blockZ + rand.nextInt(16);
			int groundY = getGroundFromAbove(world, randX, randZ);
			abandonedHouse.generate(world, rand, new BlockPos(randX, groundY + 1, randZ));
		}
		
		WorldGenerator lootRoom = new StructureDungeonLootRoom1();
		if (rand.nextInt(4) == 0)
		{
			int randX = blockX + rand.nextInt(16);
			int randZ = blockZ + rand.nextInt(16);
			int randY = rand.nextInt(51);
			lootRoom.generate(world, rand, new BlockPos(randX, randY, randZ));
		}
	}
	
	private void generateNether(World world, Random rand, int chunkX, int chunkZ) {}
	private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {}
	
	public static int getGroundFromAbove(World world, int x, int z)
	{
		int y = 255;
		boolean foundGround = false;
		while(!foundGround && y-- >= 0)
		{
			Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundGround = blockAt == Blocks.DIRT || blockAt == Blocks.GRASS;
		}

		return y;
	}
}
