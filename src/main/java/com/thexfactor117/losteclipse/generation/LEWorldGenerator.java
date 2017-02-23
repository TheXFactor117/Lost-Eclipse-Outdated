package com.thexfactor117.losteclipse.generation;

import java.util.Map.Entry;
import java.util.Random;
import org.apache.logging.log4j.Logger;

import com.google.common.base.*;
import com.thexfactor117.losteclipse.LostEclipse;
import com.thexfactor117.losteclipse.config.Config;
import com.thexfactor117.losteclipse.generation.procedural.ProceduralDungeon;
import com.thexfactor117.losteclipse.init.ModBlocks;
import com.thexfactor117.losteclipse.init.ModLootTables;
import com.thexfactor117.losteclipse.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.*;
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
public class LEWorldGenerator implements IWorldGenerator {
	private static final Logger LOGGER = LostEclipse.LOGGER;

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		int blockX = chunkX * 16;
		int blockZ = chunkZ * 16;

		switch (world.provider.getDimension()) {
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

	private void generateOverworld(World world, Random rand, int blockX, int blockZ) {
		generateOverworldOres(world, rand, blockX, blockZ);
		generateOverworldStructures(world, rand, blockX, blockZ);
	}

	private void generateNether(World world, Random rand, int chunkX, int chunkZ) {
	}

	private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {
	}

	/**
	 * Generates ores in the overworld. Helper method to make things cleaner.
	 * 
	 * @param world
	 * @param rand
	 * @param blockX
	 * @param blockZ
	 */
	private void generateOverworldOres(World world, Random rand, int blockX, int blockZ) {

		addOreSpawn(ModBlocks.verantiumOre.getDefaultState(), world, rand, blockX, blockZ, 16, 16, 4 + rand.nextInt(4),
				14, 1, 64, BlockMatcher.forBlock(Blocks.STONE));
		addOreSpawn(ModBlocks.vexalOre.getDefaultState(), world, rand, blockX, blockZ, 16, 16, 2 + rand.nextInt(2), 6,
				24, 48, BlockMatcher.forBlock(Blocks.STONE));
		addOreSpawn(ModBlocks.astrillOre.getDefaultState(), world, rand, blockX, blockZ, 16, 16, 1, 3, 1, 15,
				BlockMatcher.forBlock(Blocks.STONE));
	}

	/**
	 * Generates structures in the overworld. Helper method to make things
	 * cleaner.
	 * 
	 * @param world
	 * @param rand
	 * @param blockX
	 * @param blockZ
	 */
	private void generateOverworldStructures(World world, Random rand, int blockX, int blockZ) {
		
		String spawnSmallHouse = Config.spawnSmallHouseString;
		String spawnDungeons = Config.spawnDungeonsString;
		String spawnCastle = Config.spawnCastleString;
		
		WorldServer server = (WorldServer) world;
		TemplateManager manager = server.getStructureTemplateManager();

		//Houses
		generateProcedurally(world, rand, Config.smallHouseChance, blockX, blockZ, spawnSmallHouse, true, manager.getTemplate(world.getMinecraftServer(), new ResourceLocation(Reference.MODID, "smallhouse")));
		//Castles
		generateProcedurally(world, rand, Config.castleChance, blockX, blockZ, spawnCastle, true, manager.getTemplate(world.getMinecraftServer(), new ResourceLocation(Reference.MODID, "castle1")));
		// Dungeons
		generateProcedurally(world, rand, Config.proceduralDungeonChance, blockX, blockZ, spawnDungeons, false, null);
	}

	/**
	 * 
	 * @param world
	 *            the world instance
	 * @param rand
	 *            the random number generated by the world
	 * @param chance
	 *            the chance of the structure spawning
	 * @param blockX
	 *            the block pos on x
	 * @param blockZ
	 *            the block pos on z
	 * @param config
	 *            the structure spawning boolean
	 * @param template
	 *            the template for the structure
	 */

	private void generateProcedurally(World world, Random rand, int chance, int blockX, int blockZ, String config,
			boolean isSurfaceStructure, Template template) {
		if (config.equals("spawnDungeons") && !isSurfaceStructure) {
			// dungeons
			if ((int) (Math.random() * chance) == 0) {
				int randX = blockX + (int) Math.random() * 16;
				int randZ = blockZ + (int) Math.random() * 16;
				int y = (int) (Math.random() * 45 + 5);
				BlockPos pos = new BlockPos(randX, y, randZ);
				int maxRooms = 4 + (int) (Math.random() * 2);
				LOGGER.info("Generating Dungeon (" + maxRooms + ") at " + pos);

				ProceduralDungeon dungeon = new ProceduralDungeon(maxRooms);
				dungeon.generate(world, rand, pos);
			}
		} else if (config.equals("spawnSmallHouse") && isSurfaceStructure) {
			if ((int) (Math.random() * chance) == 0) {
				int randX = blockX + (int) Math.random() * 16;
				int randZ = blockZ + (int) Math.random() * 16;
				int groundY = getGroundFromAbove(world, randX, randZ);
				BlockPos pos = new BlockPos(randX, groundY, randZ);

				if (canSpawnHere(template, world, pos)) {
					LOGGER.info("Generating Small House at " + pos);
					template.addBlocksToWorld(world, pos, new PlacementSettings());
					handleDataBlocks(template, world, pos, new PlacementSettings());
				}
			}
		}else if(config.equals("spawnCastle") && isSurfaceStructure){
			if ((int) (Math.random() * chance) == 0) {
				int randX = blockX + (int) Math.random() * 16;
				int randZ = blockZ + (int) Math.random() * 16;
				int groundY = getGroundFromAbove(world, randX, randZ);
				BlockPos pos = new BlockPos(randX, groundY, randZ);

				if (canSpawnHere(template, world, pos)) {
					LOGGER.info("Generating Castle at " + pos);
					template.addBlocksToWorld(world, pos, new PlacementSettings());
					handleDataBlocks(template, world, pos, new PlacementSettings());
				}
			}
		}
	}

	/**
	 * Gets the Y-value of the ground at a specifix x/y coordinate.
	 * 
	 * @param world
	 * @param x
	 * @param z
	 * @return
	 */
	private int getGroundFromAbove(World world, int x, int z) {
		int y = 255;
		boolean foundGround = false;
		while (!foundGround && y-- >= 63) {
			Block blockAt = world.getBlockState(new BlockPos(x, y, z)).getBlock();
			foundGround = blockAt == Blocks.DIRT || blockAt == Blocks.GRASS || blockAt == Blocks.SAND
					|| blockAt == Blocks.SNOW || blockAt == Blocks.SNOW_LAYER;
		}

		return y;
	}

	private boolean canSpawnHere(Template template, World world, BlockPos posAboveGround) {
		int zwidth = template.getSize().getZ();
		int xwidth = template.getSize().getX();

		// check all the corners to see which ones are replaceable
		boolean corner1 = isCornerValid(world, posAboveGround);
		boolean corner2 = isCornerValid(world, posAboveGround.add(xwidth, 0, zwidth));

		// if Y > 63 and all corners pass the test, it's okay to spawn the
		// structure
		return posAboveGround.getY() > 63 && corner1 && corner2;
	}

	private boolean isCornerValid(World world, BlockPos pos) {
		int variation = 3;
		int highestBlock = getGroundFromAbove(world, pos.getX(), pos.getZ());
		boolean isHeightValid = highestBlock > pos.getY() - variation && highestBlock < pos.getY() + variation;

		if (isHeightValid) {
			LOGGER.info("Corner valid.");
			return true;
		}

		LOGGER.info("Canceling gen for this structure.");

		return false;
	}

	/**
	 * Adds the specified block to be generated in throughout the world. Key
	 * parameters: maxVeinSize, chanceToSpawn, minY, maxY.
	 * 
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
	private void addOreSpawn(IBlockState block, World world, Random random, int blockXPos, int blockZPos, int maxX,
			int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY, Predicate<IBlockState> genInBlock) {
		for (int i = 0; i < chanceToSpawn; i++) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(maxZ);
			new WorldGenMinable(block, maxVeinSize, genInBlock).generate(world, random, new BlockPos(posX, posY, posZ));
		}
	}

	/**
	 * Iterates through every Data Structure Block in the given template. Used
	 * to add loot to chests.
	 * 
	 * @param template
	 * @param world
	 * @param pos
	 * @param settings
	 */
	private void handleDataBlocks(Template template, World world, BlockPos pos, PlacementSettings settings) {
		// loop through all data blocks within the structure
		for (Entry<BlockPos, String> e : template.getDataBlocks(pos, settings).entrySet()) {
			if ("common_chest".equals(e.getValue())) // check data block tag
			{
				BlockPos dataPos = e.getKey();
				world.setBlockState(dataPos, Blocks.AIR.getDefaultState(), 3); // remove
																				// data
																				// block
				TileEntity chestEntity = world.getTileEntity(dataPos.down()); // chest
																				// is
																				// located
																				// under
																				// data
																				// block

				if (chestEntity instanceof TileEntityChest) {
					int rand = (int) (Math.random() * 100 + 1);

					if (rand <= 85)
						((TileEntityChest) chestEntity).setLootTable(ModLootTables.STRUCTURE_COMMON,
								world.rand.nextLong());
					else if (rand > 95)
						((TileEntityChest) chestEntity).setLootTable(ModLootTables.STRUCTURE_LEGENDARY,
								world.rand.nextLong());
					else
						((TileEntityChest) chestEntity).setLootTable(ModLootTables.STRUCTURE_RARE,
								world.rand.nextLong());
				}
			} else if ("rare_chest".equals(e.getValue())) // check data block
															// tag
			{
				BlockPos dataPos = e.getKey();
				world.setBlockState(dataPos, Blocks.AIR.getDefaultState(), 3); // remove
																				// data
																				// block
				TileEntity chestEntity = world.getTileEntity(dataPos.down()); // chest
																				// is
																				// located
																				// under
																				// data
																				// block

				if (chestEntity instanceof TileEntityChest) {
					int rand = (int) (Math.random() * 100 + 1);

					if (rand <= 40)
						((TileEntityChest) chestEntity).setLootTable(ModLootTables.STRUCTURE_COMMON,
								world.rand.nextLong());
					else if (rand > 90)
						((TileEntityChest) chestEntity).setLootTable(ModLootTables.STRUCTURE_LEGENDARY,
								world.rand.nextLong());
					else
						((TileEntityChest) chestEntity).setLootTable(ModLootTables.STRUCTURE_RARE,
								world.rand.nextLong());
				}
			} else if ("legendary_chest".equals(e.getValue())) // check data
																// block tag
			{
				BlockPos dataPos = e.getKey();
				world.setBlockState(dataPos, Blocks.AIR.getDefaultState(), 3); // remove
																				// data
																				// block
				TileEntity chestEntity = world.getTileEntity(dataPos.down()); // chest
																				// is
																				// located
																				// under
																				// data
																				// block

				if (chestEntity instanceof TileEntityChest) {
					int rand = (int) (Math.random() * 100 + 1);

					if (rand <= 10)
						((TileEntityChest) chestEntity).setLootTable(ModLootTables.STRUCTURE_COMMON,
								world.rand.nextLong());
					else if (rand > 50)
						((TileEntityChest) chestEntity).setLootTable(ModLootTables.STRUCTURE_LEGENDARY,
								world.rand.nextLong());
					else
						((TileEntityChest) chestEntity).setLootTable(ModLootTables.STRUCTURE_RARE,
								world.rand.nextLong());
				}
			}
		}
	}
}
