package com.thexfactor117.losteclipse.generation.structures;

import java.util.Random;

import com.thexfactor117.losteclipse.generation.StructureLEBase;
import com.thexfactor117.losteclipse.init.ModLootTables;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockSlab;
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
public class StructureAbandonedHouse extends StructureLEBase
{
	// Format: int[][] { {distanceRight, distanceUp, distanceBack} } 
	private final int[][] logsPos = new int[][]
	{
		{1, 0, 1}, {1, 0, 7}, {7, 0, 7}, {7, 0, 1},
		{1, 1, 1}, {1, 1, 7}, {7, 1, 7}, {7, 1, 1},
		{1, 2, 1}, {1, 2, 7}, {7, 2, 7}, {7, 2, 1},
		{1, 3, 1}, {1, 3, 7}, {7, 3, 7}, {7, 3, 1}
	};
	private final int[][] planksPos = new int[][]
	{
		// layer 0
		{1, 0, 2}, {1, 0, 3}, {1, 0, 4}, {1, 0, 5}, {1, 0, 6},
		{2, 0, 1}, {2, 0, 2}, {2, 0, 3}, {2, 0, 4}, {2, 0, 5}, {2, 0, 6}, {2, 0, 7},
		{3, 0, 1}, {3, 0, 2}, {3, 0, 3}, {3, 0, 4}, {3, 0, 5}, {3, 0, 6}, {3, 0, 7},
		{4, 0, 1}, {4, 0, 2}, {4, 0, 3}, {4, 0, 4}, {4, 0, 5}, {4, 0, 6}, {4, 0, 7},
		{5, 0, 1}, {5, 0, 2}, {5, 0, 3}, {5, 0, 4}, {5, 0, 5}, {5, 0, 6}, {5, 0, 7},
		{6, 0, 1}, {6, 0, 2}, {6, 0, 3}, {6, 0, 4}, {6, 0, 5}, {6, 0, 6}, {6, 0, 7},
		{7, 0, 2}, {7, 0, 3}, {7, 0, 4}, {7, 0, 5}, {7, 0, 6},
		// layer 1
		{1, 1, 2}, {1, 1, 3}, {1, 1, 4}, {1, 1, 5}, {1, 1, 6},
		{7, 1, 2}, {7, 1, 3}, {7, 1, 4}, {7, 1, 5}, {7, 1, 6},
		{2, 1, 1}, {3, 1, 1}, {5, 1, 1}, {6, 1, 1},
		{2, 1, 7}, {3, 1, 7}, {4, 1, 7}, {5, 1, 7}, {6, 1, 7},
		// layer 2
		{1, 2, 2}, {1, 2, 6}, {2, 2, 1}, {2, 2, 7}, {3, 2, 1}, {5, 2, 1}, {6, 2, 1}, {6, 2, 7}, {7, 2, 2}, {7, 2, 6},
		// layer 3
		{1, 3, 2}, {1, 3, 3}, {1, 3, 4}, {1, 3, 5}, {1, 3, 6},
		{7, 3, 2}, {7, 3, 3}, {7, 3, 4}, {7, 3, 5}, {7, 3, 6},
		{2, 3, 1}, {3, 3, 1}, {4, 3, 1}, {5, 3, 1}, {6, 3, 1},
		{2, 3, 7}, {3, 3, 7}, {4, 3, 7}, {5, 3, 7}, {6, 3, 7},
		// layer 4
		{2, 4, 2}, {3, 4, 2}, {4, 4, 2}, {5, 4, 2}, {6, 4, 2},
		{2, 4, 3}, {3, 4, 3}, {4, 4, 3}, {5, 4, 3}, {6, 4, 3},
		{2, 4, 4}, {3, 4, 4}, {4, 4, 4}, {5, 4, 4}, {6, 4, 4},
		{2, 4, 5}, {3, 4, 5}, {4, 4, 5}, {5, 4, 5}, {6, 4, 5},
		{2, 4, 6}, {3, 4, 6}, {4, 4, 6}, {5, 4, 6}, {6, 4, 6}
	};
	private final int[][] slabsPos = new int[][]
	{
		// layer 3
		{0, 3, 0}, {1, 3, 0}, {2, 3, 0}, {3, 3, 0}, {4, 3, 0}, {5, 3, 0}, {6, 3, 0}, {7, 3, 0}, {8, 3, 0},
		{0, 3, 8}, {1, 3, 8}, {2, 3, 8}, {3, 3, 8}, {4, 3, 8}, {5, 3, 8}, {6, 3, 8}, {7, 3, 8}, {8, 3, 8},
		{0, 3, 1}, {0, 3, 2}, {0, 3, 3}, {0, 3, 4}, {0, 3, 5}, {0, 3, 6}, {0, 3, 7},
		{8, 3, 1}, {8, 3, 2}, {8, 3, 3}, {8, 3, 4}, {8, 3, 5}, {8, 3, 6}, {8, 3, 7}
	};
	private final int[][] slabsPos2 = new int[][]
	{
		// layer 4
		{1, 4, 1}, {2, 4, 1}, {3, 4, 1}, {4, 4, 1}, {5, 4, 1}, {6, 4, 1}, {7, 4, 1},
		{1, 4, 7}, {2, 4, 7}, {3, 4, 7}, {4, 4, 7}, {5, 4, 7}, {6, 4, 7}, {7, 4, 7},
		{1, 4, 2}, {1, 4, 3}, {1, 4, 4}, {1, 4, 5}, {1, 4, 6},
		{7, 4, 2}, {7, 4, 3}, {7, 4, 4}, {7, 4, 5}, {7, 4, 6}
	};
	private final int[][] panesPos = new int[][]
	{
		// layer 2
		{1, 2, 3}, {1, 2, 4}, {1, 2, 5},
		{7, 2, 3}, {7, 2, 4}, {7, 2, 5},
		{3, 2, 7}, {4, 2, 7}, {5, 2, 7},
	};
	private final int[] doorBottomPos = new int[] {4, 1, 1};
	private final int[] doorTopPos = new int[] {4, 2, 1};
	private final int[] chestPos1 = new int[] {2, 1, 2};
	private final int[] chestPos2 = new int[] {6, 1, 6};
	
	@Override
	public boolean generate(World world, Random rand, BlockPos position) 
	{
		if (canSpawnAboveGround(world, position, 8, 8))
		{
			IBlockState log = Blocks.LOG.getDefaultState();
			IBlockState plank = Blocks.PLANKS.getDefaultState();
			IBlockState slab = Blocks.WOODEN_SLAB.getDefaultState().withProperty(BlockSlab.HALF, BlockSlab.EnumBlockHalf.TOP);
			IBlockState slab2 = Blocks.WOODEN_SLAB.getDefaultState().withProperty(BlockSlab.HALF, BlockSlab.EnumBlockHalf.BOTTOM);
			IBlockState glass_pane = Blocks.GLASS_PANE.getDefaultState();
			IBlockState doorBottom = Blocks.OAK_DOOR.getDefaultState().withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.LOWER);
			IBlockState doorTop = Blocks.OAK_DOOR.getDefaultState().withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER);
			IBlockState chest = Blocks.CHEST.getDefaultState();
			
			EnumFacing side = EnumFacing.getHorizontal(world.rand.nextInt(4));
			
			buildLayer(world, position, logsPos, log, side);
			buildLayer(world, position, planksPos, plank, side);
			buildLayer(world, position, slabsPos, slab, side);
			buildLayer(world, position, slabsPos2, slab2, side);
			buildLayer(world, position, panesPos, glass_pane, side);
			
			placeBlock(world, position, doorBottomPos, doorBottom, side);
			placeBlock(world, position, doorTopPos, doorTop, side);
			placeBlock(world, position, chestPos1, chest, side);
			placeBlock(world, position, chestPos2, chest, side);
			
			BlockPos chestActualPos1 = getPosFromCorner(position, chestPos1[0], chestPos1[1], chestPos1[2], side);
			BlockPos chestActualPos2 = getPosFromCorner(position, chestPos2[0], chestPos2[1], chestPos2[2], side);
			
			TileEntityChest chestTE1 = (TileEntityChest) world.getTileEntity(chestActualPos1);
			TileEntityChest chestTE2 = (TileEntityChest) world.getTileEntity(chestActualPos2);
			
			if (chestTE1 != null && chestTE2 != null)
			{
				chestTE1.setLootTable(ModLootTables.STRUCTURE_ABANDONED_HOUSE, rand.nextLong());
				chestTE2.setLootTable(ModLootTables.STRUCTURE_ABANDONED_HOUSE, rand.nextLong());
			}
			
			return true;
		}
		
		return false;
	}
}
