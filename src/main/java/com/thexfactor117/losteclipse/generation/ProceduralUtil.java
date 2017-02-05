package com.thexfactor117.losteclipse.generation;

import java.util.ArrayList;
import java.util.Map.Entry;

import com.thexfactor117.losteclipse.LostEclipse;
import com.thexfactor117.losteclipse.init.ModLootTables;
import com.thexfactor117.losteclipse.util.Reference;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ProceduralUtil 
{	
	/**
	 * Generate a randomized room at the given pos. Add position of room to ArrayList.
	 * @param manager
	 * @param world
	 * @param pos
	 * @param settings
	 * @param rotation
	 * @param positions
	 * @param roomCount
	 */
	public static void generateStartingRoom(TemplateManager manager, World world, BlockPos center, ArrayList<BlockPos> roomPositions, ArrayList<BlockPos> hallwayPositions, ArrayList<PotentialPosition> potentialPositions, int roomCount)
	{
		for (BlockPos position : roomPositions)
		{
			if (position.equals(center))
				return;
		}
		
		LostEclipse.LOGGER.info("Generating starting room.");
		
		Rotation rotation = Rotation.values()[(int) (Math.random() * 4)];
		generateRandomRoom(manager, world, center, rotation, roomPositions, hallwayPositions, potentialPositions);
	}
	
	public static void generateRooms(TemplateManager manager, World world, ArrayList<BlockPos> roomPositions, ArrayList<BlockPos> hallwayPositions, ArrayList<PotentialPosition> potentialPositions, int roomCount)
	{	
		int size = potentialPositions.size();
		
		for (int i = 0; i < size; i++)
		{
			LostEclipse.LOGGER.info("Potential size: " + potentialPositions.size());
			BlockPos center = potentialPositions.get(i).getPos();
			Rotation rotation = potentialPositions.get(i).getRotation();
			LostEclipse.LOGGER.info("Generating randomized rooms off of hallways.");
			generateRandomRoom(manager, world, center, rotation, roomPositions, hallwayPositions, potentialPositions);
		}
	}
	
	private static void generateRandomRoom(TemplateManager manager, World world, BlockPos center, Rotation rotation, ArrayList<BlockPos> roomPositions, ArrayList<BlockPos> hallwayPositions, ArrayList<PotentialPosition> potentialPositions)
	{
		// if there is a room at a potential position, return.
		for (int i = 0; i < roomPositions.size(); i++)
		{
			for (int j = 0; j < potentialPositions.size(); j++)
			{
				if (roomPositions.get(i).equals(potentialPositions.get(j).getPos()))
				{
					LostEclipse.LOGGER.info("Room position and potential positions matched.");
					return;
				}
			}
		}
		
		// settings and such
		PlacementSettings settings = new PlacementSettings().setRotation(rotation);
		Template template = getRandomizedDungeonTemplate(manager, world);
		LostEclipse.LOGGER.info("Room rotation: " + rotation);
		
		// add blocks (and handle any data blocks)
		BlockPos corner = translateToCorner(template, center, rotation); // translate from center to corner
		template.addBlocksToWorld(world, corner, settings); // spawn in template at corner pos
		handleDataBlocks(template, world, corner, settings); // update chest contents
		roomPositions.add(center); // add template position to array
		
		int hallways = (int) (Math.random() * 3 + 1);
		LostEclipse.LOGGER.info("Hallways: " + hallways);
		
		for (int i = 1; i <= hallways; i++)
		{
			Rotation hallwayRotation = Rotation.values()[(int) (Math.random() * 4)];
			LostEclipse.LOGGER.info("Generating hallways off room at rotation: " + hallwayRotation);
			generateHallway(manager, world, center, hallwayRotation, hallwayPositions, potentialPositions);
		}
	}
	
	/**
	 * Generate a hallway off of the previous Template.
	 * @param manager
	 * @param world
	 * @param pos
	 * @param settings
	 * @param rotation
	 */
	private static void generateHallway(TemplateManager manager, World world, BlockPos roomCenter, Rotation rotation, ArrayList<BlockPos> hallwayPositions, ArrayList<PotentialPosition> potentialPositions)
	{	
		// add hallway blocks
		Template hallway = getRandomizedHallwayTemplate(manager, world);
		BlockPos hallwayCenter = getHallwayPosition(hallway, roomCenter, rotation);
		
		for (BlockPos position : hallwayPositions) // check to make sure hallway can spawn. If not, exit.
		{
			if (position.equals(hallwayCenter))
				return;
		}
		
		PlacementSettings settings = new PlacementSettings().setRotation(rotation);
		BlockPos hallwayCorner = translateHallwayToCorner(hallway, hallwayCenter, rotation);
		hallway.addBlocksToWorld(world, hallwayCorner, settings);
		handleDataBlocks(hallway, world, hallwayCorner, settings);
		hallwayPositions.add(hallwayCenter);

		for (int i = 0; i < 4; i++)
		{
			BlockPos potentialPosition = getRoomPosition(getRandomizedDungeonTemplate(manager, world), hallwayCenter, Rotation.values()[i]);
			potentialPositions.add(new PotentialPosition(potentialPosition, Rotation.values()[i]));
		}
	}
	
	private static Template getRandomizedDungeonTemplate(TemplateManager manager, World world)
	{
		ArrayList<Template> templates = new ArrayList<Template>();
		
		templates.add(manager.getTemplate(world.getMinecraftServer(), new ResourceLocation(Reference.MODID, "loot_room_1")));
		
		return templates.get((int) (Math.random() * (templates.size() - 1)));
	}
	
	private static Template getRandomizedHallwayTemplate(TemplateManager manager, World world)
	{
		ArrayList<Template> templates = new ArrayList<Template>();
		
		templates.add(manager.getTemplate(world.getMinecraftServer(), new ResourceLocation(Reference.MODID, "hallway_1")));
		
		return templates.get((int) (Math.random() * (templates.size() - 1)));
	}
	
	/**
	 * Iterates through every Data Structure Block in the given template. Used to add loot to chests.
	 * @param template
	 * @param world
	 * @param pos
	 * @param settings
	 */
	private static void handleDataBlocks(Template template, World world, BlockPos pos, PlacementSettings settings)
	{
		// loop through all data blocks within the structure
		for (Entry<BlockPos, String> e : template.getDataBlocks(pos, settings).entrySet())
		{
			if ("chest".equals(e.getValue())) // check data block tag
			{
				BlockPos dataPos = e.getKey();
				world.setBlockState(dataPos, Blocks.AIR.getDefaultState(), 3); // remove data block
				TileEntity chestEntity = world.getTileEntity(dataPos.down()); // chest is located under data block
							
				if (chestEntity instanceof TileEntityChest)
					((TileEntityChest) chestEntity).setLootTable(ModLootTables.STRUCTURE_ABANDONED_HOUSE, world.rand.nextLong());
			}
		}
	}
	
	public static BlockPos translateToCenter(Template template, BlockPos originalPos, Rotation rotation)
	{
		int x = originalPos.getX();
		int z = originalPos.getZ();
		
		switch (rotation)
		{
			case NONE:
				x += template.getSize().getX() / 2;
				z += template.getSize().getZ() / 2;
				break;
			case CLOCKWISE_90:
				x -= template.getSize().getX() / 2;
				z += template.getSize().getZ() / 2;
				break;
			case CLOCKWISE_180:
				x -= template.getSize().getX() / 2;
				z -= template.getSize().getZ() / 2;
				break;
			case COUNTERCLOCKWISE_90:
				x += template.getSize().getX() / 2;
				z -= template.getSize().getZ() / 2;
				break;
		}
		
		return new BlockPos(x, originalPos.getY(), z);
	}
	
	public static BlockPos translateToCorner(Template template, BlockPos originalPos, Rotation rotation)
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
	
	public static BlockPos translateHallwayToCorner(Template template, BlockPos hallwayCenter, Rotation rotation)
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
				z -= template.getSize().getX() / 2 + 1;
				break;
			case CLOCKWISE_180:
				x += template.getSize().getX() / 2;
				z += template.getSize().getZ() / 2;
				break;
			case COUNTERCLOCKWISE_90:
				x -= template.getSize().getZ() / 2;
				z += template.getSize().getX() / 2 + 1;
				break;
		}
		
		return new BlockPos(x, hallwayCenter.getY(), z);
	}
	
	public static BlockPos getHallwayPosition(Template template, BlockPos roomCenter, Rotation rotation)
	{
		int x = roomCenter.getX();
		int z = roomCenter.getZ();
		
		switch (rotation)
		{
			case NONE:
				x += template.getSize().getX() - 1;
				break;
			case CLOCKWISE_90:
				z += template.getSize().getX() - 2;
				break;
			case CLOCKWISE_180:
				x -= template.getSize().getX() - 1;
				break;
			case COUNTERCLOCKWISE_90:
				z -= template.getSize().getX() - 2;
				break;
		}
		
		return new BlockPos(x, roomCenter.getY(), z);
	}
	
	public static BlockPos getRoomPosition(Template template, BlockPos hallwayCenter, Rotation rotation)
	{
		int x = hallwayCenter.getX();
		int z = hallwayCenter.getZ();
		
		switch (rotation)
		{
			case NONE:
				x += template.getSize().getX() - 1;
				break;
			case CLOCKWISE_90:
				z -= template.getSize().getZ() - 1;
				break;
			case CLOCKWISE_180:
				x -= template.getSize().getX() - 1;
				break;
			case COUNTERCLOCKWISE_90:
				z += template.getSize().getZ() - 1;
				break;
		}
		
		return new BlockPos(x, hallwayCenter.getY(), z);
	}
	
	/**
	 * Checks to see if the structure can spawn underground by checking block materials and Y-positions.
	 * @param world
	 * @param posUnderGround
	 * @param minY
	 * @param maxY
	 * @return
	 */
	protected static boolean canSpawnUnderground(World world, BlockPos posUnderGround, int minY, int maxY)
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
	protected static boolean canReplaceMaterial(World world, BlockPos pos, Material materials)
	{
		Material material = world.getBlockState(pos).getMaterial();
		return material == materials;
	}
}
