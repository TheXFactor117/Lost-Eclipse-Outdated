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

/**
 * 
 * @author TheXFactor117
 *
 */
public class StructureDungeonLootRoom extends StructureLEBase
{
	protected EnumFacing facing;
	
	public StructureDungeonLootRoom(EnumFacing facing)
	{
		this.facing = facing;
	}
	
	private final int[][] stoneBricksPos = new int[][]
	{
		// layer 0
		{0, 0, 0}, {0, 0, 1}, {0, 0, 2}, {0, 0, 3}, {0, 0, 4}, {0, 0, 5}, {0, 0, 6}, {0, 0, 7}, {0, 0, 8}, {0, 0, 9}, {0, 0, 10},
		{1, 0, 0}, {1, 0, 1}, {1, 0, 2}, {1, 0, 3}, {1, 0, 4}, {1, 0, 5}, {1, 0, 6}, {1, 0, 7}, {1, 0, 8}, {1, 0, 9}, {1, 0, 10},
		{2, 0, 0}, {2, 0, 1}, {2, 0, 2}, {2, 0, 3}, {2, 0, 4}, {2, 0, 5}, {2, 0, 6}, {2, 0, 7}, {2, 0, 8}, {2, 0, 9}, {2, 0, 10},
		{3, 0, 0}, {3, 0, 1}, {3, 0, 2}, {3, 0, 3}, {3, 0, 4}, {3, 0, 5}, {3, 0, 6}, {3, 0, 7}, {3, 0, 8}, {3, 0, 9}, {3, 0, 10},
		{4, 0, 0}, {4, 0, 1}, {4, 0, 2}, {4, 0, 3}, {4, 0, 4}, {4, 0, 5}, {4, 0, 6}, {4, 0, 7}, {4, 0, 8}, {4, 0, 9}, {4, 0, 10},
		{5, 0, 0}, {5, 0, 1}, {5, 0, 2}, {5, 0, 3}, {5, 0, 4}, {5, 0, 5}, {5, 0, 6}, {5, 0, 7}, {5, 0, 8}, {5, 0, 9}, {5, 0, 10},
		{6, 0, 0}, {6, 0, 1}, {6, 0, 2}, {6, 0, 3}, {6, 0, 4}, {6, 0, 5}, {6, 0, 6}, {6, 0, 7}, {6, 0, 8}, {6, 0, 9}, {6, 0, 10},
		{7, 0, 0}, {7, 0, 1}, {7, 0, 2}, {7, 0, 3}, {7, 0, 4}, {7, 0, 5}, {7, 0, 6}, {7, 0, 7}, {7, 0, 8}, {7, 0, 9}, {7, 0, 10},
		{8, 0, 0}, {8, 0, 1}, {8, 0, 2}, {8, 0, 3}, {8, 0, 4}, {8, 0, 5}, {8, 0, 6}, {8, 0, 7}, {8, 0, 8}, {8, 0, 9}, {8, 0, 10},
		{9, 0, 0}, {9, 0, 1}, {9, 0, 2}, {9, 0, 3}, {9, 0, 4}, {9, 0, 5}, {9, 0, 6}, {9, 0, 7}, {9, 0, 8}, {9, 0, 9}, {9, 0, 10},
		{10, 0, 0}, {10, 0, 1}, {10, 0, 2}, {10, 0, 3}, {10, 0, 4}, {10, 0, 5}, {10, 0, 6}, {10, 0, 7}, {10, 0, 8}, {10, 0, 9}, {10, 0, 10},
		// layer 1
		{0, 1, 0}, {0, 1, 1}, {0, 1, 2}, {0, 1, 3}, {0, 1, 4}, {0, 1, 6}, {0, 1, 7}, {0, 1, 8}, {0, 1, 9}, {0, 1, 10},
		{1, 1, 0}, {2, 1, 0}, {3, 1, 0}, {4, 1, 0}, {6, 1, 0}, {7, 1, 0}, {8, 1, 0}, {9, 1, 0},
		{1, 1, 10}, {2, 1, 10}, {3, 1, 10}, {4, 1, 10}, {6, 1, 10}, {7, 1, 10}, {8, 1, 10}, {9, 1, 10},
		{10, 1, 0}, {10, 1, 1}, {10, 1, 2}, {10, 1, 3}, {10, 1, 4}, {10, 1, 6}, {10, 1, 7}, {10, 1, 8}, {10, 1, 9}, {10, 1, 10},
		// layer 2
		{0, 2, 0}, {0, 2, 1}, {0, 2, 2}, {0, 2, 3}, {0, 2, 4}, {0, 2, 6}, {0, 2, 7}, {0, 2, 8}, {0, 2, 9}, {0, 2, 10},
		{1, 2, 0}, {2, 2, 0}, {3, 2, 0}, {4, 2, 0}, {6, 2, 0}, {7, 2, 0}, {8, 2, 0}, {9, 2, 0},
		{1, 2, 10}, {2, 2, 10}, {3, 2, 10}, {4, 2, 10}, {6, 2, 10}, {7, 2, 10}, {8, 2, 10}, {9, 2, 10},
		{10, 2, 0}, {10, 2, 1}, {10, 2, 2}, {10, 2, 3}, {10, 2, 4}, {10, 2, 6}, {10, 2, 7}, {10, 2, 8}, {10, 2, 9}, {10, 2, 10},
		// layer 3
		{0, 3, 0}, {0, 3, 1}, {0, 3, 2}, {0, 3, 3}, {0, 3, 4}, {0, 3, 5}, {0, 3, 6}, {0, 3, 7}, {0, 3, 8}, {0, 3, 9}, {0, 3, 10},
		{1, 3, 0}, {2, 3, 0}, {3, 3, 0}, {4, 3, 0}, {5, 3, 0}, {6, 3, 0}, {7, 3, 0}, {8, 3, 0}, {9, 3, 0},
		{1, 3, 10}, {2, 3, 10}, {3, 3, 10}, {4, 3, 10}, {5, 3, 10}, {6, 3, 10}, {7, 3, 10}, {8, 3, 10}, {9, 3, 10},
		{10, 3, 0}, {10, 3, 1}, {10, 3, 2}, {10, 3, 3}, {10, 3, 4}, {10, 3, 5}, {10, 3, 6}, {10, 3, 7}, {10, 3, 8}, {10, 3, 9}, {10, 3, 10},
		// layer 4
		{0, 4, 0}, {0, 4, 1}, {0, 4, 2}, {0, 4, 3}, {0, 4, 4}, {0, 4, 5}, {0, 4, 6}, {0, 4, 7}, {0, 4, 8}, {0, 4, 9}, {0, 4, 10},
		{1, 4, 0}, {1, 4, 1}, {1, 4, 2}, {1, 4, 3}, {1, 4, 4}, {1, 4, 5}, {1, 4, 6}, {1, 4, 7}, {1, 4, 8}, {1, 4, 9}, {1, 4, 10},
		{2, 4, 0}, {2, 4, 1}, {2, 4, 2}, {2, 4, 3}, {2, 4, 4}, {2, 4, 5}, {2, 4, 6}, {2, 4, 7}, {2, 4, 8}, {2, 4, 9}, {2, 4, 10},
		{3, 4, 0}, {3, 4, 1}, {3, 4, 2}, {3, 4, 3}, {3, 4, 4}, {3, 4, 5}, {3, 4, 6}, {3, 4, 7}, {3, 4, 8}, {3, 4, 9}, {3, 4, 10},
		{4, 4, 0}, {4, 4, 1}, {4, 4, 2}, {4, 4, 3}, {4, 4, 4}, {4, 4, 5}, {4, 4, 6}, {4, 4, 7}, {4, 4, 8}, {4, 4, 9}, {4, 4, 10},
		{5, 4, 0}, {5, 4, 1}, {5, 4, 2}, {5, 4, 3}, {5, 4, 4}, {5, 4, 5}, {5, 4, 6}, {5, 4, 7}, {5, 4, 8}, {5, 4, 9}, {5, 4, 10},
		{6, 4, 0}, {6, 4, 1}, {6, 4, 2}, {6, 4, 3}, {6, 4, 4}, {6, 4, 5}, {6, 4, 6}, {6, 4, 7}, {6, 4, 8}, {6, 4, 9}, {6, 4, 10},
		{7, 4, 0}, {7, 4, 1}, {7, 4, 2}, {7, 4, 3}, {7, 4, 4}, {7, 4, 5}, {7, 4, 6}, {7, 4, 7}, {7, 4, 8}, {7, 4, 9}, {7, 4, 10},
		{8, 4, 0}, {8, 4, 1}, {8, 4, 2}, {8, 4, 3}, {8, 4, 4}, {8, 4, 5}, {8, 4, 6}, {8, 4, 7}, {8, 4, 8}, {8, 4, 9}, {8, 4, 10},
		{9, 4, 0}, {9, 4, 1}, {9, 4, 2}, {9, 4, 3}, {9, 4, 4}, {9, 4, 5}, {9, 4, 6}, {9, 4, 7}, {9, 4, 8}, {9, 4, 9}, {9, 4, 10},
		{10, 4, 0}, {10, 4, 1}, {10, 4, 2}, {10, 4, 3}, {10, 4, 4}, {10, 4, 5}, {10, 4, 6}, {10, 4, 7}, {10, 4, 8}, {10, 4, 9}, {10, 4, 10}
	};
	private final int[] chestPos1 = new int[] {1, 1, 1};
	private final int[] chestPos2 = new int[] {9, 1, 9};
	private final int[] chestPos3 = new int[] {9, 1, 1};
	private final int[] chestPos4 = new int[] {1, 1, 9};
	
	@Override
	public boolean generate(World world, Random rand, BlockPos position)
	{
		IBlockState stone_brick = Blocks.STONEBRICK.getDefaultState();
		IBlockState chest = Blocks.CHEST.getDefaultState();
		
		placeAirBlocks(world, position, 10, 4, 10, this.facing, 0);
		
		buildLayer(world, position, stoneBricksPos, stone_brick, this.facing);
		
		placeBlock(world, position, chestPos1, chest, this.facing);
		placeBlock(world, position, chestPos2, chest, this.facing);
		
		BlockPos chestActualPos1 = position.add(chestPos1[0], chestPos1[1], chestPos1[2]);
		BlockPos chestActualPos2 = position.add(chestPos2[0], chestPos2[1], chestPos2[2]);
		
		TileEntityChest chestTE1 = (TileEntityChest) world.getTileEntity(chestActualPos1);
		TileEntityChest chestTE2 = (TileEntityChest) world.getTileEntity(chestActualPos2);
		
		if (chestTE1 != null && chestTE2 != null) 
		{	
			chestTE1.setLootTable(ModLootTables.STRUCTURE_ABANDONED_HOUSE, rand.nextLong());
			chestTE2.setLootTable(ModLootTables.STRUCTURE_ABANDONED_HOUSE, rand.nextLong());
		}
		
		if (rand.nextInt(4) == 0) generateBonusChests(world, rand, position, chest);
		
		return true;
	}
	
	public void generateBonusChests(World world, Random rand, BlockPos position, IBlockState chest)
	{
		placeBlock(world, position, chestPos3, chest, this.facing);
		placeBlock(world, position, chestPos4, chest, this.facing);
		
		BlockPos chestActualPos3 = position.add(chestPos3[0], chestPos3[1], chestPos3[2]);
		BlockPos chestActualPos4 = position.add(chestPos4[0], chestPos4[1], chestPos4[2]);
		
		TileEntityChest chestTE3 = (TileEntityChest) world.getTileEntity(chestActualPos3);
		TileEntityChest chestTE4 = (TileEntityChest) world.getTileEntity(chestActualPos4);
		
		if (chestTE3 != null && chestTE4 != null) 
		{	
			chestTE3.setLootTable(ModLootTables.STRUCTURE_ABANDONED_HOUSE, rand.nextLong());
			chestTE4.setLootTable(ModLootTables.STRUCTURE_ABANDONED_HOUSE, rand.nextLong());
		}
	}
}
