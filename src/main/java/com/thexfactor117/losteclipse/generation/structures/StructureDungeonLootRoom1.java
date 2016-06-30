package com.thexfactor117.losteclipse.generation.structures;

import java.util.Random;

import com.thexfactor117.losteclipse.generation.StructureLEBase;
import com.thexfactor117.losteclipse.init.ModLootTables;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * 
 * @author TheXFactor117
 *
 */
public class StructureDungeonLootRoom1 extends StructureLEBase
{		
	private final int[][] stoneBrickPos = new int[][]
	{
		// layer 0
		{0, 0, 0}, {1, 0, 0}, {2, 0, 0}, {3, 0, 0}, {4, 0, 0}, {5, 0, 0}, {6, 0, 0},
		{0, 0, 1}, {1, 0, 1}, {2, 0, 1}, {3, 0, 1}, {4, 0, 1}, {5, 0, 1}, {6, 0, 1},
		{0, 0, 2}, {1, 0, 2}, {2, 0, 2}, {3, 0, 2}, {4, 0, 2}, {5, 0, 2}, {6, 0, 2},
		{0, 0, 3}, {1, 0, 3}, {2, 0, 3}, {3, 0, 3}, {4, 0, 3}, {5, 0, 3}, {6, 0, 3},
		{0, 0, 4}, {1, 0, 4}, {2, 0, 4}, {3, 0, 4}, {4, 0, 4}, {5, 0, 4}, {6, 0, 4},
		{0, 0, 5}, {1, 0, 5}, {2, 0, 5}, {3, 0, 5}, {4, 0, 5}, {5, 0, 5}, {6, 0, 5},
		{0, 0, 6}, {1, 0, 6}, {2, 0, 6}, {3, 0, 6}, {4, 0, 6}, {5, 0, 6}, {6, 0, 6},
		{0, 0, 7}, {1, 0, 7}, {2, 0, 7}, {3, 0, 7}, {4, 0, 7}, {5, 0, 7}, {6, 0, 7},
		{0, 0, 8}, {1, 0, 8}, {2, 0, 8}, {3, 0, 8}, {4, 0, 8}, {5, 0, 8}, {6, 0, 8},
		{0, 0, 9}, {1, 0, 9}, {2, 0, 9}, {3, 0, 9}, {4, 0, 9}, {5, 0, 9}, {6, 0, 9},
		// layer 1
		{0, 1, 0}, {1, 1, 0}, {2, 1, 0}, {4, 1, 0}, {5, 1, 0}, {6, 1, 0},
		{0, 1, 9}, {1, 1, 9}, {2, 1, 9}, {3, 1, 9}, {4, 1, 9}, {5, 1, 9}, {6, 1, 9},
		{0, 1, 1}, {0, 1, 2}, {0, 1, 3}, {0, 1, 4}, {0, 1, 5}, {0, 1, 6}, {0, 1, 7}, {0, 1, 8},
		{6, 1, 1}, {6, 1, 2}, {6, 1, 3}, {6, 1, 4}, {6, 1, 5}, {6, 1, 6}, {6, 1, 7}, {6, 1, 8},
		// layer 2
		{0, 2, 0}, {1, 2, 0}, {2, 2, 0}, {4, 2, 0}, {5, 2, 0}, {6, 2, 0},
		{0, 2, 9}, {1, 2, 9}, {2, 2, 9}, {3, 2, 9}, {4, 2, 9}, {5, 2, 9}, {6, 2, 9},
		{0, 2, 1}, {0, 2, 2}, {0, 2, 3}, {0, 2, 4}, {0, 2, 5}, {0, 2, 6}, {0, 2, 7}, {0, 2, 8},
		{6, 2, 1}, {6, 2, 2}, {6, 2, 3}, {6, 2, 4}, {6, 2, 5}, {6, 2, 6}, {6, 2, 7}, {6, 2, 8},
		// layer 3
		{0, 3, 0}, {1, 3, 0}, {2, 3, 0}, {3, 3, 0}, {4, 3, 0}, {5, 3, 0}, {6, 3, 0},
		{0, 3, 9}, {1, 3, 9}, {2, 3, 9}, {3, 3, 9}, {4, 3, 9}, {5, 3, 9}, {6, 3, 9},
		{0, 3, 1}, {0, 3, 2}, {0, 3, 3}, {0, 3, 4}, {0, 3, 5}, {0, 3, 6}, {0, 3, 7}, {0, 3, 8},
		{6, 3, 1}, {6, 3, 2}, {6, 3, 3}, {6, 3, 4}, {6, 3, 5}, {6, 3, 6}, {6, 3, 7}, {6, 3, 8},
		// layer 4
		{0, 4, 0}, {1, 4, 0}, {2, 4, 0}, {3, 4, 0}, {4, 4, 0}, {5, 4, 0}, {6, 4, 0},
		{0, 4, 1}, {1, 4, 1}, {2, 4, 1}, {3, 4, 1}, {4, 4, 1}, {5, 4, 1}, {6, 4, 1},
		{0, 4, 2}, {1, 4, 2}, {2, 4, 2}, {3, 4, 2}, {4, 4, 2}, {5, 4, 2}, {6, 4, 2},
		{0, 4, 3}, {1, 4, 3}, {2, 4, 3}, {3, 4, 3}, {4, 4, 3}, {5, 4, 3}, {6, 4, 3},
		{0, 4, 4}, {1, 4, 4}, {2, 4, 4}, {3, 4, 4}, {4, 4, 4}, {5, 4, 4}, {6, 4, 4},
		{0, 4, 5}, {1, 4, 5}, {2, 4, 5}, {3, 4, 5}, {4, 4, 5}, {5, 4, 5}, {6, 4, 5},
		{0, 4, 6}, {1, 4, 6}, {2, 4, 6}, {3, 4, 6}, {4, 4, 6}, {5, 4, 6}, {6, 4, 6},
		{0, 4, 7}, {1, 4, 7}, {2, 4, 7}, {3, 4, 7}, {4, 4, 7}, {5, 4, 7}, {6, 4, 7},
		{0, 4, 8}, {1, 4, 8}, {2, 4, 8}, {3, 4, 8}, {4, 4, 8}, {5, 4, 8}, {6, 4, 8},
		{0, 4, 9}, {1, 4, 9}, {2, 4, 9}, {3, 4, 9}, {4, 4, 9}, {5, 4, 9}, {6, 4, 9}
	};
	private final int[][] cobwebPos = new int[][]
	{
		// corner 1
		{1, 1, 1}, {1, 2, 1}, {2, 1, 1},
		// corner 2
		{5, 1, 1}, {5, 2, 1}, {5, 3, 1}, {5, 3, 2},
		// corner 3
		{1, 2, 8}, {1, 3, 8}, {1, 3, 7}, {2, 3, 8},
		// corner 4
		{5, 3, 8},
		// misc
		{1, 1, 5}, {1, 1, 4}
	};
	private final int[] chestPos1 = new int[] {1, 1, 3};
	private final int[] chestPos2 = new int[] {1, 1, 6};
	private final int[] chestPos3 = new int[] {5, 1, 8};
	private final int[] chestPos4 = new int[] {5, 1, 2};
	
	@Override
	public boolean generate(World world, Random rand, BlockPos position) 
	{
		//if (canSpawnUnderground(world, position, 6, 50, 9, 10))
		//{
			IBlockState stone_brick = Blocks.STONEBRICK.getDefaultState();
			IBlockState cobweb = Blocks.WEB.getDefaultState();
			IBlockState chest = Blocks.CHEST.getDefaultState();
			
			placeAirBlocks(world, position, 6, 4, 9);
			
			buildLayer(world, position, stoneBrickPos, stone_brick);
			buildLayer(world, position, cobwebPos, cobweb);
			
			placeBlock(world, position, chestPos1, chest);
			placeBlock(world, position, chestPos2, chest);
			placeBlock(world, position, chestPos3, chest);
			placeBlock(world, position, chestPos4, chest);
			
			BlockPos chestActualPos1 = position.add(chestPos1[0], chestPos1[1], chestPos1[2]);
			BlockPos chestActualPos2 = position.add(chestPos2[0], chestPos2[1], chestPos2[2]);
			BlockPos chestActualPos3 = position.add(chestPos3[0], chestPos3[1], chestPos3[2]);
			BlockPos chestActualPos4 = position.add(chestPos4[0], chestPos4[1], chestPos4[2]);
			
			TileEntityChest chestTE1 = (TileEntityChest) world.getTileEntity(chestActualPos1);
			TileEntityChest chestTE2 = (TileEntityChest) world.getTileEntity(chestActualPos2);
			TileEntityChest chestTE3 = (TileEntityChest) world.getTileEntity(chestActualPos3);
			TileEntityChest chestTE4 = (TileEntityChest) world.getTileEntity(chestActualPos4);
			
			if (chestTE1 != null && chestTE2 != null && chestTE3 != null && chestTE4 != null)
			{
				chestTE1.setLootTable(ModLootTables.STRUCTURE_ABANDONED_HOUSE, rand.nextLong());
				chestTE2.setLootTable(ModLootTables.STRUCTURE_ABANDONED_HOUSE, rand.nextLong());
				chestTE3.setLootTable(ModLootTables.STRUCTURE_ABANDONED_HOUSE, rand.nextLong());
				chestTE4.setLootTable(ModLootTables.STRUCTURE_ABANDONED_HOUSE, rand.nextLong());
			}
			
			return true;
		//}
		
		//return false;
	}
}
