package com.thexfactor117.losteclipse.generation;

import java.util.ArrayList;
import java.util.Map.Entry;

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
	public static void generate(TemplateManager manager, World world, BlockPos pos)
	{
		if (canSpawnUnderground(world, pos, 2, 100))
		{
			int maxRooms = 5 + (int) Math.random() * 10;
			procedurallyGenerate(manager, world, pos, maxRooms);
		}
	}
	
	private static void procedurallyGenerate(TemplateManager manager, World world, BlockPos pos, int maxRooms)
	{
		int roomCount = 0;
		ArrayList<BlockPos> positions = new ArrayList<BlockPos>(); // stores previous room positions
		
		if (roomCount != maxRooms)
		{
			Template template = getRandomizedDungeonTemplate(manager, world);
			Rotation rotation = Rotation.values()[(int) Math.random() * 4];
			PlacementSettings settings = new PlacementSettings().setRotation(rotation);
			template.addBlocksToWorld(world, pos, settings); // spawn in template
			handleDataBlocks(template, world, pos, settings); // update chest contents
			positions.add(roomCount, pos); // add template position to array

			Template hallway = manager.getTemplate(world.getMinecraftServer(), new ResourceLocation(Reference.MODID, "hallway"));
		}
		
		roomCount++;
		procedurallyGenerate(manager, world, pos, maxRooms);
	}
	
	private static Template getRandomizedDungeonTemplate(TemplateManager manager, World world)
	{
		ArrayList<Template> templates = new ArrayList<Template>();
		
		templates.add(manager.getTemplate(world.getMinecraftServer(), new ResourceLocation(Reference.MODID, "main_room")));
		
		return templates.get((int) Math.random() * (templates.size() - 1));
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
				x = originalPos.getX() + (template.getSize().getX() / 2);
				z = originalPos.getZ() + (template.getSize().getZ() / 2);
				break;
			case CLOCKWISE_90:
				x = originalPos.getX() - (template.getSize().getX() / 2);
				z = originalPos.getZ() + (template.getSize().getZ() / 2);
				break;
			case CLOCKWISE_180:
				x = originalPos.getX() - (template.getSize().getX() / 2);
				z = originalPos.getZ() - (template.getSize().getZ() / 2);
				break;
			case COUNTERCLOCKWISE_90:
				x = originalPos.getX() + (template.getSize().getX() / 2);
				z = originalPos.getZ() - (template.getSize().getZ() / 2);
				break;
		}
		
		return new BlockPos(x, originalPos.getY(), z);
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
