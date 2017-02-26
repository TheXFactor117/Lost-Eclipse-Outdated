package com.thexfactor117.losteclipse.generation;

import java.util.Map.Entry;
import java.util.Random;

import com.thexfactor117.losteclipse.LostEclipse;
import com.thexfactor117.losteclipse.config.Config;
import com.thexfactor117.losteclipse.generation.procedural.ProceduralDungeon;
import com.thexfactor117.losteclipse.init.ModBlocks;
import com.thexfactor117.losteclipse.init.ModLootTables;
import com.thexfactor117.losteclipse.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
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
		IBlockState verantiumOre = ModBlocks.verantiumOre.getDefaultState();
		IBlockState vexalOre = ModBlocks.vexalOre.getDefaultState();
		IBlockState astrillOre = ModBlocks.astrillOre.getDefaultState();
		
		addOreSpawn(verantiumOre, world, rand, blockX, blockZ, 16, 16, 4 + rand.nextInt(4), 14, 1, 64);
		addOreSpawn(vexalOre, world, rand, blockX, blockZ, 16, 16, 2 + rand.nextInt(2), 6, 24, 48);
		addOreSpawn(astrillOre, world, rand, blockX, blockZ, 16, 16, 1, 3, 1, 15);
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
		if (Config.spawnStructures)
		{
			WorldServer server = (WorldServer) world;
			TemplateManager manager = server.getStructureTemplateManager();
			
			// templates
			Template smallHouse = manager.getTemplate(world.getMinecraftServer(), new ResourceLocation(Reference.MODID, "smallhouse"));
			Template castle = manager.getTemplate(world.getMinecraftServer(), new ResourceLocation(Reference.MODID, "castle1"));
			
			// structures
			if ((int) (Math.random() * Config.smallHouseChance) == 0)
			{
				int randX = blockX + (int) Math.random() * 16;
				int randZ = blockZ + (int) Math.random() * 16;
				int groundY = getGroundFromAbove(world, randX, randZ);
				BlockPos pos = new BlockPos(randX, groundY, randZ);
				
				if (canSpawnHere(smallHouse, world, pos))
				{
					LostEclipse.LOGGER.info("Generating Small House at " + pos);
					smallHouse.addBlocksToWorld(world, pos, new PlacementSettings());
					handleDataBlocks(smallHouse, world, pos, new PlacementSettings());
				}
			}
			
			if ((int) (Math.random() * Config.castleChance) == 0)
			{
				int randX = blockX + (int) Math.random() * 16;
				int randZ = blockZ + (int) Math.random() * 16;
				int groundY = getGroundFromAbove(world, randX, randZ);
				BlockPos pos = new BlockPos(randX, groundY, randZ);
				
				if (canSpawnHere(castle, world, pos) && world.getBiome(pos) == Biomes.PLAINS)
				{
					LostEclipse.LOGGER.info("Generating Castle at " + pos);
					castle.addBlocksToWorld(world, pos, new PlacementSettings());
					handleDataBlocks(castle, world, pos, new PlacementSettings());
				}
			}
		}
		
		if (Config.spawnDungeons)
		{
			// dungeons
			if ((int) (Math.random() * 500) == 0)
			{
				int randX = blockX + (int) Math.random() * 16;
				int randZ = blockZ + (int) Math.random() * 16;
				int y = (int) (Math.random() * 45 + 5);
				BlockPos pos = new BlockPos(randX, y, randZ);
				int maxRooms = 4 + (int) (Math.random() * 2);
				LostEclipse.LOGGER.info("Generating Dungeon (" + maxRooms + ") at " + pos);
				
				ProceduralDungeon dungeon = new ProceduralDungeon(maxRooms);
				dungeon.generate(world, rand, pos);
			}
		}
	}
	
	/**
	 * Gets the Y-value of the ground at a specifix x/y coordinate.
	 * @param world
	 * @param x
	 * @param z
	 * @return
	 */
	private int getGroundFromAbove(World world, int x, int z)
	{
		int y = 255;
		boolean foundGround = false;
		while(!foundGround && y-- >= 63)
		{
			Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
			foundGround = blockAt == Blocks.DIRT || blockAt == Blocks.GRASS || blockAt == Blocks.SAND || blockAt == Blocks.SNOW || blockAt == Blocks.SNOW_LAYER;
		}

		return y;
	}
	
	private boolean canSpawnHere(Template template, World world, BlockPos posAboveGround)
	{
		int zwidth = template.getSize().getZ();
		int xwidth = template.getSize().getX();
		
		// check all the corners to see which ones are replaceable
		boolean corner1 = isCornerValid(world, posAboveGround);
		boolean corner2 = isCornerValid(world, posAboveGround.add(xwidth, 0, zwidth));
		
		// if Y > 20 and all corners pass the test, it's okay to spawn the structure
		return posAboveGround.getY() > 63 && corner1 && corner2;
	}
	
	private boolean isCornerValid(World world, BlockPos pos)
	{
		int variation = 3;
		int highestBlock = getGroundFromAbove(world, pos.getX(), pos.getZ());
		
		if (highestBlock > pos.getY() - variation && highestBlock < pos.getY() + variation)
			return true;
		
		LostEclipse.LOGGER.info("Canceling gen for this structure.");
		
		return false;
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
	
	/**
	 * Iterates through every Data Structure Block in the given template. Used to add loot to chests.
	 * @param template
	 * @param world
	 * @param pos
	 * @param settings
	 */
	private void handleDataBlocks(Template template, World world, BlockPos pos, PlacementSettings settings)
	{
		// loop through all data blocks within the structure
		for (Entry<BlockPos, String> e : template.getDataBlocks(pos, settings).entrySet())
		{
			if ("common_chest".equals(e.getValue())) // check data block tag
			{
				BlockPos dataPos = e.getKey();
				world.setBlockState(dataPos, Blocks.AIR.getDefaultState(), 3); // remove data block
				TileEntity chestEntity = world.getTileEntity(dataPos.down()); // chest is located under data block
							
				if (chestEntity instanceof TileEntityChest)
				{
					int rand = (int) (Math.random() * 100 + 1);

					if (rand <= 85) ((TileEntityChest) chestEntity).setLootTable(ModLootTables.STRUCTURE_COMMON, world.rand.nextLong());
					else if (rand > 95) ((TileEntityChest) chestEntity).setLootTable(ModLootTables.STRUCTURE_LEGENDARY, world.rand.nextLong());
					else ((TileEntityChest) chestEntity).setLootTable(ModLootTables.STRUCTURE_RARE, world.rand.nextLong());
				}
			}
			else if ("rare_chest".equals(e.getValue())) // check data block tag
			{
				BlockPos dataPos = e.getKey();
				world.setBlockState(dataPos, Blocks.AIR.getDefaultState(), 3); // remove data block
				TileEntity chestEntity = world.getTileEntity(dataPos.down()); // chest is located under data block
							
				if (chestEntity instanceof TileEntityChest)
				{
					int rand = (int) (Math.random() * 100 + 1);

					if (rand <= 40) ((TileEntityChest) chestEntity).setLootTable(ModLootTables.STRUCTURE_COMMON, world.rand.nextLong());
					else if (rand > 90) ((TileEntityChest) chestEntity).setLootTable(ModLootTables.STRUCTURE_LEGENDARY, world.rand.nextLong());
					else ((TileEntityChest) chestEntity).setLootTable(ModLootTables.STRUCTURE_RARE, world.rand.nextLong());
				}
			}
			else if ("legendary_chest".equals(e.getValue())) // check data block tag
			{
				BlockPos dataPos = e.getKey();
				world.setBlockState(dataPos, Blocks.AIR.getDefaultState(), 3); // remove data block
				TileEntity chestEntity = world.getTileEntity(dataPos.down()); // chest is located under data block
							
				if (chestEntity instanceof TileEntityChest)
				{
					int rand = (int) (Math.random() * 100 + 1);
					
					if (rand <= 10) ((TileEntityChest) chestEntity).setLootTable(ModLootTables.STRUCTURE_COMMON, world.rand.nextLong());
					else if (rand > 50) ((TileEntityChest) chestEntity).setLootTable(ModLootTables.STRUCTURE_LEGENDARY, world.rand.nextLong());
					else ((TileEntityChest) chestEntity).setLootTable(ModLootTables.STRUCTURE_RARE, world.rand.nextLong());
				}
			}
		}
	}
}