package com.thexfactor117.losteclipse.generation.structures;

import java.util.Random;

import com.thexfactor117.losteclipse.LostEclipse;
import com.thexfactor117.losteclipse.generation.StructureLEBase;
import com.thexfactor117.losteclipse.init.ModLootTables;

import net.minecraft.block.BlockLadder;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * 
 * @author TheXFactor117
 *
 */
public class StructureTower extends StructureLEBase
{
	private final int[][] bricksPos = new int[][]
	{
		// layer -1
		{1, -1, 5}, {1, -1, 6}, {1, -1, 7},
		{2, -1, 3}, {2, -1, 4}, {2, -1, 5}, {2, -1, 6}, {2, -1, 7}, {2, -1, 8}, {2, -1, 9},
		{3, -1, 2}, {3, -1, 3}, {3, -1, 4}, {3, -1, 5}, {3, -1, 6}, {3, -1, 7}, {3, -1, 8}, {3, -1, 9}, {3, -1, 10},
		{4, -1, 2}, {4, -1, 3}, {4, -1, 4}, {4, -1, 5}, {4, -1, 6}, {4, -1, 7}, {4, -1, 8}, {4, -1, 9}, {4, -1, 10},
		{5, -1, 1}, {5, -1, 2}, {5, -1, 3}, {5, -1, 4}, {5, -1, 5}, {5, -1, 6}, {5, -1, 7}, {5, -1, 8}, {5, -1, 9}, {5, -1, 10}, {5, -1, 11},
		{6, -1, 1}, {6, -1, 2}, {6, -1, 3}, {6, -1, 4}, {6, -1, 5}, {6, -1, 6}, {6, -1, 7}, {6, -1, 8}, {6, -1, 9}, {6, -1, 10}, {6, -1, 11},
		{7, -1, 1}, {7, -1, 2}, {7, -1, 3}, {7, -1, 4}, {7, -1, 5}, {7, -1, 6}, {7, -1, 7}, {7, -1, 8}, {7, -1, 9}, {7, -1, 10}, {7, -1, 11},
		{8, -1, 2}, {8, -1, 3}, {8, -1, 4}, {8, -1, 5}, {8, -1, 6}, {8, -1, 7}, {8, -1, 8}, {8, -1, 9}, {8, -1, 10},
		{9, -1, 2}, {9, -1, 3}, {9, -1, 4}, {9, -1, 5}, {9, -1, 6}, {9, -1, 7}, {9, -1, 8}, {9, -1, 9}, {9, -1, 10},
		{10, -1, 3}, {10, -1, 4}, {10, -1, 5}, {10, -1, 6}, {10, -1, 7}, {10, -1, 8}, {10, -1, 9},
		{11, -1, 5}, {11, -1, 6}, {11, -1, 7},
		// layer 0-3
		{2, 0, 2}, {2, 0, 10}, {10, 0, 2}, {10, 0, 10},
		{2, 1, 2}, {2, 1, 10}, {10, 1, 2}, {10, 1, 10},
		{2, 2, 2}, {2, 2, 10}, {10, 2, 2}, {10, 2, 10},
		{2, 3, 2}, {2, 3, 10}, {10, 3, 2}, {10, 3, 10},
		// layer 4
		{2, 4, 2}, /*{2, 4, 3},*/ {2, 4, 4}, {2, 4, 5}, {2, 4, 6}, {2, 4, 7}, {2, 4, 8}, {2, 4, 9}, {2, 4, 10},
		{3, 4, 2}, {3, 4, 3}, {3, 4, 4}, {3, 4, 5}, {3, 4, 6}, {3, 4, 7}, {3, 4, 8}, {3, 4, 9}, {3, 4, 10},
		{4, 4, 2}, {4, 4, 3}, {4, 4, 4}, {4, 4, 5}, {4, 4, 6}, {4, 4, 7}, {4, 4, 8}, {4, 4, 9}, {4, 4, 10},
		{5, 4, 2}, {5, 4, 3}, {5, 4, 4}, {5, 4, 5}, {5, 4, 6}, {5, 4, 7}, {5, 4, 8}, {5, 4, 9}, {5, 4, 10},
		{6, 4, 2}, {6, 4, 3}, {6, 4, 4}, {6, 4, 5}, {6, 4, 6}, {6, 4, 7}, {6, 4, 8}, {6, 4, 9}, {6, 4, 10},
		{7, 4, 2}, {7, 4, 3}, {7, 4, 4}, {7, 4, 5}, {7, 4, 6}, {7, 4, 7}, {7, 4, 8}, {7, 4, 9}, {7, 4, 10},
		{8, 4, 2}, {8, 4, 3}, {8, 4, 4}, {8, 4, 5}, {8, 4, 6}, {8, 4, 7}, {8, 4, 8}, {8, 4, 9}, {8, 4, 10},
		{9, 4, 2}, {9, 4, 3}, {9, 4, 4}, {9, 4, 5}, {9, 4, 6}, {9, 4, 7}, {9, 4, 8}, {9, 4, 9}, {9, 4, 10},
		{10, 4, 2}, {10, 4, 3}, {10, 4, 4}, {10, 4, 5}, {10, 4, 6}, {10, 4, 7}, {10, 4, 8}, {10, 4, 9}, {10, 4, 10},
		// layer 5
		{0, 5, 3}, {0, 5, 4}, {0, 5, 5}, {0, 5, 6}, {0, 5, 7}, {0, 5, 8}, {0, 5, 9},
		{1, 5, 1}, {1, 5, 2}, {1, 5, 3}, {1, 5, 4}, {1, 5, 5}, {1, 5, 6}, {1, 5, 7}, {1, 5, 8}, {1, 5, 9}, {1, 5, 10}, {1, 5, 11},
		{2, 5, 1}, {2, 5, 2}, {2, 5, 10}, {2, 5, 11},
		{3, 5, 0}, {3, 5, 1}, {3, 5, 11}, {3, 5, 12},
		{4, 5, 0}, {4, 5, 1}, {4, 5, 11}, {4, 5, 12},
		{5, 5, 0}, {5, 5, 1}, {5, 5, 11}, {5, 5, 12},
		{6, 5, 0}, {6, 5, 1}, {6, 5, 11}, {6, 5, 12},
		{7, 5, 0}, {7, 5, 1}, {7, 5, 11}, {7, 5, 12},
		{8, 5, 0}, {8, 5, 1}, {8, 5, 11}, {8, 5, 12},
		{9, 5, 0}, {9, 5, 1}, {9, 5, 11}, {9, 5, 12},
		{10, 5, 1}, {10, 5, 2}, {10, 5, 10}, {10, 5, 11},
		{11, 5, 1}, {11, 5, 2}, {11, 5, 3}, {11, 5, 4}, {11, 5, 5}, {11, 5, 6}, {11, 5, 7}, {11, 5, 8}, {11, 5, 9}, {11, 5, 10}, {11, 5, 11},
		{12, 5, 3}, {12, 5, 4}, {12, 5, 5}, {12, 5, 6}, {12, 5, 7}, {12, 5, 8}, {12, 5, 9},
	};
	private final int[][] logsPos = new int[][]
	{
		// layer 0-4
		{1, 0, 3}, {1, 0, 9}, {3, 0, 1}, {3, 0, 11}, {9, 0, 1}, {9, 0, 11}, {11, 0, 3}, {11, 0, 9},
		{1, 1, 3}, {1, 1, 9}, {3, 1, 1}, {3, 1, 11}, {9, 1, 1}, {9, 1, 11}, {11, 1, 3}, {11, 1, 9},
		{1, 2, 3}, {1, 2, 9}, {3, 2, 1}, {3, 2, 11}, {9, 2, 1}, {9, 2, 11}, {11, 2, 3}, {11, 2, 9},
		{1, 3, 3}, {1, 3, 9}, {3, 3, 1}, {3, 3, 11}, {9, 3, 1}, {9, 3, 11}, {11, 3, 3}, {11, 3, 9},
		{1, 4, 3}, {1, 4, 9}, {3, 4, 1}, {3, 4, 11}, {9, 4, 1}, {9, 4, 11}, {11, 4, 3}, {11, 4, 9},
	};
	private final int[][] cobblestonePos = new int[][]
	{
		// layer 0-2
		{1, 0, 4}, {1, 0, 8}, {4, 0, 1}, {4, 0, 11}, {8, 0, 1}, {8, 0, 11}, {11, 0, 4}, {11, 0, 8},
		{1, 1, 4}, {1, 1, 8}, {4, 1, 1}, {4, 1, 11}, {8, 1, 1}, {8, 1, 11}, {11, 1, 4}, {11, 1, 8},
		{1, 2, 4}, {1, 2, 8}, {4, 2, 1}, {4, 2, 11}, {8, 2, 1}, {8, 2, 11}, {11, 2, 4}, {11, 2, 8},
		// layer 3
		{1, 3, 4}, {1, 3, 5}, {1, 3, 7}, {1, 3, 8}, 
		{4, 3, 1}, {4, 3, 11}, {5, 3, 1}, {7, 3, 1},
		{8, 3, 1}, {8, 3, 11}, {5, 3, 11}, {7, 3, 11},
		{11, 3, 4}, {11, 3, 8}, {11, 3, 5}, {11, 3, 7},
		// layer 4
		{1, 4, 4}, {1, 4, 5}, {1, 4, 6}, {1, 4, 7}, {1, 4, 8},
		{11, 4, 4}, {11, 4, 5}, {11, 4, 6}, {11, 4, 7}, {11, 4, 8},
		{4, 4, 1}, {5, 4, 1}, {6, 4, 1}, {7, 4, 1}, {8, 4, 1},
		{4, 4, 11}, {5, 4, 11}, {6, 4, 11}, {7, 4, 11}, {8, 4, 11}
	};
	private final int[][] ladderPos = new int[][]
	{
		{2, 0, 3}, {2, 1, 3}, {2, 2, 3}, {2, 3, 3}, {2, 4, 3}, {2, 5, 3}
	};
	private final int[] chestPos1 = new int[] {3, 0, 2};
	private final int[] chestPos2 = new int[] {9, 0, 10};
	private final int[] chestPos3 = new int[] {9, 5, 2};
	private final int[] chestPos4 = new int[] {2, 5, 9};
	
	@Override
	public boolean generate(World world, Random rand, BlockPos position)
	{
		if (canSpawnAboveGround(world, position, 12, 12))
		{
			EnumFacing side = EnumFacing.getHorizontal(world.rand.nextInt(4));
			
			IBlockState stone_brick = Blocks.STONEBRICK.getDefaultState();
			IBlockState log = Blocks.LOG.getDefaultState();
			IBlockState cobblestone = Blocks.COBBLESTONE.getDefaultState();
			IBlockState ladder = Blocks.LADDER.getDefaultState().withProperty(BlockLadder.FACING, side);
			IBlockState chest = Blocks.CHEST.getDefaultState();
			
			placeAirBlocks(world, position, 12, 5, 12, side, 0);
			
			buildLayer(world, position, bricksPos, stone_brick, side);
			buildLayer(world, position, logsPos, log, side);
			buildLayer(world, position, cobblestonePos, cobblestone, side);
			buildLayer(world, position, ladderPos, ladder, side);
			
			placeBlock(world, position, chestPos1, chest, side);
			placeBlock(world, position, chestPos2, chest, side);
			placeBlock(world, position, chestPos3, chest, side);
			placeBlock(world, position, chestPos4, chest, side);
			
			BlockPos chestActualPos1 = getPosFromCorner(position, chestPos1[0], 0, chestPos1[2], side);
			BlockPos chestActualPos2 = getPosFromCorner(position, chestPos2[0], 0, chestPos2[2], side);
			BlockPos chestActualPos3 = getPosFromCorner(position, chestPos3[0], chestPos3[1], chestPos3[2], side);
			BlockPos chestActualPos4 = getPosFromCorner(position, chestPos4[0], chestPos4[1], chestPos4[2], side);
			
			TileEntityChest chestTE1 = (TileEntityChest) world.getTileEntity(chestActualPos1);
			TileEntityChest chestTE2 = (TileEntityChest) world.getTileEntity(chestActualPos2);
			TileEntityChest chestTE3 = (TileEntityChest) world.getTileEntity(chestActualPos3);
			TileEntityChest chestTE4 = (TileEntityChest) world.getTileEntity(chestActualPos4);
			
			if (chestTE1 != null && chestTE2 != null && chestTE3 != null && chestTE4 != null)
			{
				LostEclipse.LOGGER.info("Hello?");
				chestTE1.setLootTable(ModLootTables.STRUCTURE_ABANDONED_HOUSE, rand.nextLong());
				chestTE2.setLootTable(ModLootTables.STRUCTURE_ABANDONED_HOUSE, rand.nextLong());
				chestTE3.setLootTable(ModLootTables.STRUCTURE_ABANDONED_HOUSE, rand.nextLong());
				chestTE4.setLootTable(ModLootTables.STRUCTURE_ABANDONED_HOUSE, rand.nextLong());
			}
			
			return true;
		}
		
		return false;
	}
}
