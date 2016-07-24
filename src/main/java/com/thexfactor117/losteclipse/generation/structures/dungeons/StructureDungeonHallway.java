package com.thexfactor117.losteclipse.generation.structures.dungeons;

import java.util.Random;

import com.thexfactor117.losteclipse.generation.StructureLEBase;
import com.thexfactor117.losteclipse.init.ModLootTables;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StructureDungeonHallway extends StructureLEBase
{
	protected EnumFacing facing;
	
	public StructureDungeonHallway(EnumFacing facing)
	{
		this.facing = facing;
	}
	
	private final int[][] stoneBricksPos = new int[][]
	{
		// layer 0
		/*{0, 0, 0},*//* {0, 0, 1},*/ {0, 0, 2}, {0, 0, 3}, {0, 0, 4}, {0, 0, 5}, {0, 0, 6}, {0, 0, 7}, {0, 0, 8},
		{1, 0, 0}, {1, 0, 1}, {1, 0, 2}, {1, 0, 3}, {1, 0, 4}, {1, 0, 5}, {1, 0, 6}, {1, 0, 7}, {1, 0, 8},
		{2, 0, 0}, {2, 0, 1}, {2, 0, 2}, {2, 0, 3}, {2, 0, 4}, {2, 0, 5}, {2, 0, 6}, {2, 0, 7}, {2, 0, 8},
		{3, 0, 0}, {3, 0, 1}, {3, 0, 2}, {3, 0, 3}, {3, 0, 4}, {3, 0, 5}, {3, 0, 6}, {3, 0, 7}, {3, 0, 8},
		{4, 0, 0}, {4, 0, 1}, {4, 0, 2}, {4, 0, 3}, {4, 0, 4}, {4, 0, 5}, {4, 0, 6}, {4, 0, 7}, {4, 0, 8},
		// layer 1
		{0, 1, 0}, {0, 1, 1}, {0, 1, 2}, {0, 1, 3}, {0, 1, 4}, {0, 1, 5}, {0, 1, 6}, {0, 1, 7}, {0, 1, 8},
		{1, 1, 0}, {1, 1, 8}, 
		{3, 1, 0}, {3, 1, 8},
		{4, 1, 0}, {4, 1, 1}, {4, 1, 2}, {4, 1, 3}, {4, 1, 4}, {4, 1, 5}, {4, 1, 6}, {4, 1, 7}, {4, 1, 8},
		// layer 2
		{0, 2, 0}, {0, 2, 1}, {0, 2, 2}, {0, 2, 3}, {0, 2, 4}, {0, 2, 5}, {0, 2, 6}, {0, 2, 7}, {0, 2, 8},
		{1, 2, 0}, {1, 2, 8}, 
		{3, 2, 0}, {3, 2, 8},
		{4, 2, 0}, {4, 2, 1}, {4, 2, 2}, {4, 2, 3}, {4, 2, 4}, {4, 2, 5}, {4, 2, 6}, {4, 2, 7}, {4, 2, 8},
		// layer 3
		{0, 3, 0}, {0, 3, 1}, {0, 3, 2}, {0, 3, 3}, {0, 3, 4}, {0, 3, 5}, {0, 3, 6}, {0, 3, 7}, {0, 3, 8},
		{1, 3, 0}, {1, 3, 8}, 
		{2, 3, 0}, {2, 3, 8},
		{3, 3, 0}, {3, 3, 8},
		{4, 3, 0}, {4, 3, 1}, {4, 3, 2}, {4, 3, 3}, {4, 3, 4}, {4, 3, 5}, {4, 3, 6}, {4, 3, 7}, {4, 3, 8},
		// layer 4
		{0, 4, 0}, {0, 4, 1}, {0, 4, 2}, {0, 4, 3}, {0, 4, 4}, {0, 4, 5}, {0, 4, 6}, {0, 4, 7}, {0, 4, 8},
		{1, 4, 0}, {1, 4, 1}, {1, 4, 2}, {1, 4, 3}, {1, 4, 4}, {1, 4, 5}, {1, 4, 6}, {1, 4, 7}, {1, 4, 8},
		{2, 4, 0}, {2, 4, 1}, {2, 4, 2}, {2, 4, 3}, {2, 4, 4}, {2, 4, 5}, {2, 4, 6}, {2, 4, 7}, {2, 4, 8},
		{3, 4, 0}, {3, 4, 1}, {3, 4, 2}, {3, 4, 3}, {3, 4, 4}, {3, 4, 5}, {3, 4, 6}, {3, 4, 7}, {3, 4, 8},
		{4, 4, 0}, {4, 4, 1}, {4, 4, 2}, {4, 4, 3}, {4, 4, 4}, {4, 4, 5}, {4, 4, 6}, {4, 4, 7}, {4, 4, 8},
	};
	private final int[] chestPos1 = new int[] {3, 1, 3};
	private final int[] diamondBlock = new int[] {0, 0, 0};
	
	@Override
	public boolean generate(World world, Random rand, BlockPos position)
	{
		IBlockState stone_brick = Blocks.STONEBRICK.getDefaultState();
		IBlockState chest = Blocks.CHEST.getDefaultState();
		IBlockState diamond = Blocks.DIAMOND_BLOCK.getDefaultState();
		
		placeAirBlocks(world, position, 5, 4, 9, this.facing, 0);
		
		buildLayer(world, position, stoneBricksPos, stone_brick, this.facing);
		placeBlock(world, position, chestPos1, chest, this.facing);
		placeBlock(world, position, diamondBlock, diamond, this.facing);
		
		BlockPos chestActualPos1 = position.add(chestPos1[0], chestPos1[1], chestPos1[2]);
		TileEntityChest chestTE1 = (TileEntityChest) world.getTileEntity(chestActualPos1);
		
		if (chestTE1 != null) chestTE1.setLootTable(ModLootTables.STRUCTURE_ABANDONED_HOUSE, rand.nextLong());
		
		return true;
	}
}
