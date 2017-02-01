package com.thexfactor117.losteclipse.generation;

import java.util.Random;

import com.thexfactor117.losteclipse.generation.structures.StructureAbandonedHouse;
import com.thexfactor117.losteclipse.generation.structures.StructureShrine;
import com.thexfactor117.losteclipse.generation.structures.StructureTower;
import com.thexfactor117.losteclipse.init.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
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
		generateOverworldOres(world, rand, blockX, blockZ);
		generateOverworldStructures(world, rand, blockX, blockZ);
	}
	
	private void generateNether(World world, Random rand, int chunkX, int chunkZ) {}
	private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {}
	
	/**
	 * Generates ores in the overworld. Helper method to make things cleaner.
	 * @param world
	 * @param rand
	 * @param blockX
	 * @param blockZ
	 */
	private void generateOverworldOres(World world, Random rand, int blockX, int blockZ)
	{
		IBlockState malachiteOre = ModBlocks.verantiumBlock.getDefaultState();
		IBlockState vexalOre = ModBlocks.vexalOre.getDefaultState();
		IBlockState astrillOre = ModBlocks.astrillOre.getDefaultState();
		
		addOreSpawn(malachiteOre, world, rand, blockX, blockZ, 16, 16, 4 + rand.nextInt(4), 14, 1, 64);
		addOreSpawn(vexalOre, world, rand, blockX, blockZ, 16, 16, 2 + rand.nextInt(2), 6, 24, 48);
		addOreSpawn(astrillOre, world, rand, blockX, blockZ, 16, 16, 1, 3, rand.nextInt(1), 15);
	}
	
	/**
	 * Generates structures in the overworld. Helper method to make things cleaner.
	 * @param world
	 * @param rand
	 * @param blockX
	 * @param blockZ
	 */
	private void generateOverworldStructures(World world, Random rand, int blockX, int blockZ)
	{
		WorldGenerator abandonedHouse = new StructureAbandonedHouse();
		if (rand.nextInt(75) == 0)
		{
			int randX = blockX + rand.nextInt(16);
			int randZ = blockZ + rand.nextInt(16);
			int groundY = getGroundFromAbove(world, randX, randZ);
			abandonedHouse.generate(world, rand, new BlockPos(randX, groundY + 1, randZ));
		}
		
		WorldGenerator shrine = new StructureShrine();
		if (rand.nextInt(75) == 0)
		{
			int randX = blockX + rand.nextInt(16);
			int randZ = blockZ + rand.nextInt(16);
			int groundY = getGroundFromAbove(world, randX, randZ);
			shrine.generate(world, rand, new BlockPos(randX, groundY + 1, randZ));
		}
		
		WorldGenerator tower = new StructureTower();
		if (rand.nextInt(100) == 0)
		{
			int randX = blockX + rand.nextInt(16);
			int randZ = blockZ + rand.nextInt(16);
			int groundY = getGroundFromAbove(world, randX, randZ);
			tower.generate(world, rand, new BlockPos(randX, groundY + 1, randZ));
		}
	}
	
	/**
	 * Gets the Y-value of the ground at a specifix x/y coordinate.
	 * @param world
	 * @param x
	 * @param z
	 * @return
	 */
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
	
	/**
	 * Adds the specified block to be generated in throughout the world. 
	 * Key parameters: maxVeinSize, chanceToSpawn, minY, maxY.
	 * @param block
	 * @param world
	 * @param random
	 * @param blockXPos
	 * @param blockZPos
	 * @param maxX
	 * @param maxZ
	 * @param maxVeinSize
	 * @param chanceToSpawn
	 * @param minY
	 * @param maxY
	 */
	private void addOreSpawn(IBlockState block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY)
	{
		for (int i = 0; i < chanceToSpawn; i++)
		{
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(maxZ);
			new WorldGenMinable(block, maxVeinSize).generate(world, random, new BlockPos(posX, posY, posZ));
		}
	}
}
