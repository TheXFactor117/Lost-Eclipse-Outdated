package com.thexfactor117.losteclipse.generation.procedural;

import java.util.ArrayList;
import java.util.Map.Entry;

import com.thexfactor117.losteclipse.LostEclipse;
import com.thexfactor117.losteclipse.init.ModLootTables;
import com.thexfactor117.losteclipse.util.Reference;

import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

public abstract class ProceduralDungeonBase extends WorldGenerator
{
	protected int roomCount = 0;
	protected int maxRooms;
	private ArrayList<BlockPos> roomPositions;
	private ArrayList<BlockPos> hallwayPositions;
	
	public ProceduralDungeonBase(int maxRooms)
	{
		this.maxRooms = maxRooms;
		this.roomPositions = new ArrayList<BlockPos>();
		this.hallwayPositions = new ArrayList<BlockPos>();
	}
	
	public ArrayList<PotentialPosition> generateStartingRoom(TemplateManager manager, World world, BlockPos center, int roomCount)
	{
		for (BlockPos position : roomPositions)
		{
			if (position.equals(center))
				return null;
		}
		
		LostEclipse.LOGGER.info("Generating starting room.");
		ArrayList<PotentialPosition> nextPotentialPositions = new ArrayList<PotentialPosition>();
		
		Rotation rotation = Rotation.values()[(int) (Math.random() * 4)];
		ArrayList<PotentialPosition> nextPositions = generateRandomRoom(manager, world, center, rotation);
		
		for (PotentialPosition position : nextPositions)
		{
			if (position != null)
				nextPotentialPositions.add(position);
		}
		
		return nextPotentialPositions;
	}
	
	public ArrayList<PotentialPosition> generateRooms(TemplateManager manager, World world, ArrayList<PotentialPosition> potentialPositions, int roomCount)
	{	
		LostEclipse.LOGGER.info("Potential size: " + potentialPositions.size());
		ArrayList<PotentialPosition> nextPotentialPositions = new ArrayList<PotentialPosition>();
		
		for (int i = 0; i < potentialPositions.size(); i++)
		{
			BlockPos center = potentialPositions.get(i).getPos();
			Rotation rotation = potentialPositions.get(i).getRotation();
			LostEclipse.LOGGER.info("Generating randomized rooms off of hallways.");
			ArrayList<PotentialPosition> nextPositions = generateRandomRoom(manager, world, center, rotation);
			
			if (nextPositions != null)
			{
				for (PotentialPosition position : nextPositions)
				{
					if (position != null)
						nextPotentialPositions.add(position);
				}
			}
		}
		
		return nextPotentialPositions;
	}
	
	private ArrayList<PotentialPosition> generateRandomRoom(TemplateManager manager, World world, BlockPos center, Rotation rotation)
	{
		// if there is a room at a potential position, return.
		for (int i = 0; i < roomPositions.size(); i++)
		{
			if (center.equals(roomPositions.get(i)))
			{
				LostEclipse.LOGGER.info("Room and potential position matched.");
				return null;
			}
		}
		
		// settings and such
		PlacementSettings settings = new PlacementSettings().setRotation(rotation);
		Template template = getRandomizedDungeonTemplate(manager, world);
		
		// add blocks (and handle any data blocks)
		BlockPos corner = translateToCorner(template, center, rotation); // translate from center to corner
		template.addBlocksToWorld(world, corner, settings); // spawn in template at corner pos
		handleDataBlocks(template, world, corner, settings); // update chest contents
		roomPositions.add(center); // add template position to array
		
		ArrayList<PotentialPosition> potentialPositions = new ArrayList<PotentialPosition>();
		
		int hallways = (int) (Math.random() * 3 + 1);
		LostEclipse.LOGGER.info("Hallways: " + hallways);
		
		for (int i = 1; i <= hallways; i++)
		{
			boolean none = false;
			boolean clockwise = false;
			boolean clockwise180 = false;
			boolean counterclockwise = false;
			
			Rotation hallwayRotation = Rotation.values()[(int) (Math.random() * 4)];
			LostEclipse.LOGGER.info("Hallway Rotation: " + hallwayRotation);
			
			switch (hallwayRotation)
			{
				case NONE:
					if (!none) potentialPositions.add(generateHallway(manager, world, center, hallwayRotation));
					else potentialPositions.add(generateHallway(manager, world, center, hallwayRotation));
					none = true;
					break;
				case CLOCKWISE_90:
					if (!clockwise) potentialPositions.add(generateHallway(manager, world, center, hallwayRotation));
					else potentialPositions.add(generateHallway(manager, world, center, hallwayRotation));
					clockwise = true;
					break;
				case CLOCKWISE_180:
					if (!clockwise180) potentialPositions.add(generateHallway(manager, world, center, hallwayRotation));
					else potentialPositions.add(generateHallway(manager, world, center, hallwayRotation));
					clockwise180 = true;
					break;
				case COUNTERCLOCKWISE_90:
					if (!counterclockwise) potentialPositions.add(generateHallway(manager, world, center, hallwayRotation));
					else potentialPositions.add(generateHallway(manager, world, center, hallwayRotation));
					counterclockwise = true;
					break;
			}
		}
		
		for (int i = 0; i < potentialPositions.size(); i++)
		{
			if (potentialPositions.get(i) == null)
				potentialPositions.remove(i);
		}
		
		return potentialPositions;
	}
	
	private PotentialPosition generateHallway(TemplateManager manager, World world, BlockPos roomCenter, Rotation rotation)
	{			
		Template hallway = getRandomizedHallwayTemplate(manager, world); // get hallway and its center position
		BlockPos hallwayCenter = getHallwayPosition(hallway, roomCenter, rotation);
		
		for (BlockPos position : hallwayPositions) // check to make sure hallway can spawn. If not, exit.
		{
			if (position.equals(hallwayCenter))
				return null;
		}

		PlacementSettings settings = new PlacementSettings().setRotation(rotation);
		BlockPos hallwayCorner = translateHallwayToCorner(hallway, hallwayCenter, rotation);
		hallway.addBlocksToWorld(world, hallwayCorner, settings); // add hallway into world at translated position
		handleDataBlocks(hallway, world, hallwayCorner, settings);
		hallwayPositions.add(hallwayCenter); // add hallway to hallwayPositions list
		
		BlockPos potentialPosition = getRoomPosition(getRandomizedDungeonTemplate(manager, world), hallwayCenter, rotation);
		
		return new PotentialPosition(potentialPosition, rotation);
	}
	
	private Template getRandomizedDungeonTemplate(TemplateManager manager, World world)
	{
		ArrayList<Template> templates = new ArrayList<Template>();
		
		templates.add(manager.getTemplate(world.getMinecraftServer(), new ResourceLocation(Reference.MODID, "loot_room_1")));
		templates.add(manager.getTemplate(world.getMinecraftServer(), new ResourceLocation(Reference.MODID, "loot_room_2")));
		templates.add(manager.getTemplate(world.getMinecraftServer(), new ResourceLocation(Reference.MODID, "loot_room_3")));
		
		return templates.get((int) (Math.random() * (templates.size())));
	}
	
	private Template getRandomizedHallwayTemplate(TemplateManager manager, World world)
	{
		ArrayList<Template> templates = new ArrayList<Template>();
		
		templates.add(manager.getTemplate(world.getMinecraftServer(), new ResourceLocation(Reference.MODID, "hallway_1")));
		templates.add(manager.getTemplate(world.getMinecraftServer(), new ResourceLocation(Reference.MODID, "hallway_2")));
		templates.add(manager.getTemplate(world.getMinecraftServer(), new ResourceLocation(Reference.MODID, "hallway_3")));
		
		return templates.get((int) (Math.random() * (templates.size())));
	}
	
	/**
	 * Iterates through every Data Structure Block in the given template. Used to add loot to chests.
	 * @param template
	 * @param world
	 * @param pos
	 * @param settings
	 */
	protected void handleDataBlocks(Template template, World world, BlockPos pos, PlacementSettings settings)
	{
		// loop through all data blocks within the structure
		for (Entry<BlockPos, String> e : template.getDataBlocks(pos, settings).entrySet())
		{
			if ("common".equals(e.getValue())) // check data block tag
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
			else if ("rare".equals(e.getValue())) // check data block tag
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
			else if ("legendary".equals(e.getValue())) // check data block tag
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
	
	protected BlockPos translateToCorner(Template template, BlockPos originalPos, Rotation rotation)
	{
		int x = originalPos.getX();
		int z = originalPos.getZ();
		
		switch (rotation)
		{
			case NONE:
				x -= template.getSize().getX() / 2;
				z -= template.getSize().getZ() / 2;
				break;
			case CLOCKWISE_90:
				x += template.getSize().getX() / 2;
				z -= template.getSize().getZ() / 2;
				break;
			case CLOCKWISE_180:
				x += template.getSize().getX() / 2;
				z += template.getSize().getZ() / 2;
				break;
			case COUNTERCLOCKWISE_90:
				x -= template.getSize().getX() / 2;
				z += template.getSize().getZ() / 2;
				break;
		}
		
		return new BlockPos(x, originalPos.getY(), z);
	}
	
	protected BlockPos translateHallwayToCorner(Template template, BlockPos hallwayCenter, Rotation rotation)
	{
		int x = hallwayCenter.getX();
		int z = hallwayCenter.getZ();
		
		switch (rotation)
		{
			case NONE:
				x -= template.getSize().getX() / 2;
				z -= template.getSize().getZ() / 2;
				break;
			case CLOCKWISE_90:
				x += template.getSize().getZ() / 2;
				z -= template.getSize().getX() / 2;
				break;
			case CLOCKWISE_180:
				x += template.getSize().getX() / 2;
				z += template.getSize().getZ() / 2;
				break;
			case COUNTERCLOCKWISE_90:
				x -= template.getSize().getZ() / 2;
				z += template.getSize().getX() / 2;
				break;
		}
		
		return new BlockPos(x, hallwayCenter.getY(), z);
	}
	
	protected BlockPos getHallwayPosition(Template template, BlockPos roomCenter, Rotation rotation)
	{
		int x = roomCenter.getX();
		int z = roomCenter.getZ();
		
		switch (rotation)
		{
			case NONE:
				x += template.getSize().getX() - 1;
				break;
			case CLOCKWISE_90:
				z += template.getSize().getX() - 1;
				break;
			case CLOCKWISE_180:
				x -= template.getSize().getX() - 1;
				break;
			case COUNTERCLOCKWISE_90:
				z -= template.getSize().getX() - 1;
				break;
		}
		
		return new BlockPos(x, roomCenter.getY(), z);
	}
	
	protected BlockPos getRoomPosition(Template template, BlockPos hallwayCenter, Rotation rotation)
	{
		int x = hallwayCenter.getX();
		int z = hallwayCenter.getZ();
		
		switch (rotation)
		{
			case NONE:
				x += template.getSize().getX() - 1;
				break;
			case CLOCKWISE_90:
				z += template.getSize().getZ() - 1;
				break;
			case CLOCKWISE_180:
				x -= template.getSize().getX() - 1;
				break;
			case COUNTERCLOCKWISE_90:
				z -= template.getSize().getZ() - 1;
				break;
		}
		
		return new BlockPos(x, hallwayCenter.getY(), z);
	}
}
