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
	public static void generateStartingRoom(TemplateManager manager, World world, BlockPos center, int roomCount)
	{
		for (BlockPos position : GenerateProcedural.roomPositions)
		{
			if (position.equals(center))
				return;
		}
		
		LostEclipse.LOGGER.info("Generating starting room.");
		
		Rotation rotation = Rotation.values()[(int) (Math.random() * 4)];
		generateRandomRoom(manager, world, center, rotation);
	}
	
	public static void generateRooms(TemplateManager manager, World world, int roomCount)
	{	
		int size = GenerateProcedural.potentialPositions.size();
		LostEclipse.LOGGER.info("Potential size: " + GenerateProcedural.potentialPositions.size());
		
		for (int i = 0; i < size; i++)
		{
			BlockPos center = GenerateProcedural.potentialPositions.get(i).getPos();
			Rotation rotation = GenerateProcedural.potentialPositions.get(i).getRotation();
			LostEclipse.LOGGER.info("Generating randomized rooms off of hallways.");
			generateRandomRoom(manager, world, center, rotation);
		}
	}
	
	private static void generateRandomRoom(TemplateManager manager, World world, BlockPos center, Rotation rotation)
	{
		// if there is a room at a potential position, return.
		for (int i = 0; i < GenerateProcedural.roomPositions.size(); i++)
		{
			if (center.equals(GenerateProcedural.roomPositions.get(i)))
			{
				LostEclipse.LOGGER.info("Room and potential position matched.");
				return;
			}
		}
		
		// settings and such
		PlacementSettings settings = new PlacementSettings().setRotation(rotation);
		Template template = getRandomizedDungeonTemplate(manager, world);
		
		// add blocks (and handle any data blocks)
		BlockPos corner = translateToCorner(template, center, rotation); // translate from center to corner
		template.addBlocksToWorld(world, corner, settings); // spawn in template at corner pos
		handleDataBlocks(template, world, corner, settings); // update chest contents
		GenerateProcedural.roomPositions.add(center); // add template position to array
		GenerateProcedural.potentialPositions.remove(center);
		
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
					if (!none) generateHallway(manager, world, center, hallwayRotation);
					else generateHallway(manager, world, center, hallwayRotation.add(hallwayRotation));
					none = true;
					break;
				case CLOCKWISE_90:
					if (!clockwise) generateHallway(manager, world, center, hallwayRotation);
					else generateHallway(manager, world, center, hallwayRotation.add(hallwayRotation));
					clockwise = true;
					break;
				case CLOCKWISE_180:
					if (!clockwise180) generateHallway(manager, world, center, hallwayRotation);
					else generateHallway(manager, world, center, hallwayRotation.add(hallwayRotation));
					clockwise180 = true;
					break;
				case COUNTERCLOCKWISE_90:
					if (!counterclockwise) generateHallway(manager, world, center, hallwayRotation);
					else generateHallway(manager, world, center, hallwayRotation.add(hallwayRotation));
					counterclockwise = true;
					break;
			}
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
	private static void generateHallway(TemplateManager manager, World world, BlockPos roomCenter, Rotation rotation)
	{	
		// add hallway blocks
		Template hallway = getRandomizedHallwayTemplate(manager, world);
		BlockPos hallwayCenter = getHallwayPosition(hallway, roomCenter, rotation);
		
		for (BlockPos position : GenerateProcedural.hallwayPositions) // check to make sure hallway can spawn. If not, exit.
		{
			if (position.equals(hallwayCenter))
				return;
		}
		
		PlacementSettings settings = new PlacementSettings().setRotation(rotation);
		BlockPos hallwayCorner = translateHallwayToCorner(hallway, hallwayCenter, rotation);
		hallway.addBlocksToWorld(world, hallwayCorner, settings);
		handleDataBlocks(hallway, world, hallwayCorner, settings);
		GenerateProcedural.hallwayPositions.add(hallwayCenter);
		
		BlockPos potentialPosition = getRoomPosition(getRandomizedDungeonTemplate(manager, world), hallwayCenter, rotation);
		GenerateProcedural.potentialPositions.add(new PotentialPosition(potentialPosition, rotation));
		LostEclipse.LOGGER.info("Size: " + GenerateProcedural.potentialPositions.size());
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
