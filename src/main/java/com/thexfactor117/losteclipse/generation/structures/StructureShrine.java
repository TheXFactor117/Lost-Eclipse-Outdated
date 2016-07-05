package com.thexfactor117.losteclipse.generation.structures;

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
public class StructureShrine extends StructureLEBase
{
	// Format: int[][] { {distanceRight, distanceUp, distanceBack} } 
	private final int[][] bricksPos = new int[][]
	{
		// layer -1
		{1, -1, 3}, {2, -1, 3}, {3, -1, 1}, {3, -1, 2}, {3, -1, 3}, {3, -1, 4}, {4, -1, 3},
		// layer 0
		{0, 0, 1}, {0, 0, 2}, {0, 0, 3}, {0, 0, 4}, {0, 0, 5},
		{1, 0, 0}, {1, 0, 1}, {1, 0, 2}, {1, 0, 4}, {1, 0, 5}, {1, 0, 6},
		{2, 0, 0}, {2, 0, 1}, {2, 0, 2}, {2, 0, 4}, {2, 0, 5}, {2, 0, 6},
		{3, 0, 0}, {3, 0, 5}, {3, 0, 6},
		{4, 0, 0}, {4, 0, 1}, {4, 0, 2}, {4, 0, 4}, {4, 0, 5}, {4, 0, 6},
		{5, 0, 0}, {5, 0, 1}, {5, 0, 2}, {5, 0, 3}, {5, 0, 4}, {5, 0, 5}, {5, 0, 6},
		{6, 0, 1}, {6, 0, 2}, {6, 0, 3}, {6, 0, 4}, {6, 0, 5}, {6, 0, 6},
		// layer 1
		{2, 1, 2}, {2, 1, 4}, {2, 1, 5},
		{3, 1, 5},
		{4, 1, 2}, {4, 1, 5},
		{5, 1, 2}, {5, 1, 3}, {5, 1, 4}, {5, 1, 5},
		// layer 2
		{2, 2, 2}, {2, 2, 3}, {2, 2, 4},
		{3, 2, 2}, {3, 2, 3}, {3, 2, 4},
		{4, 2, 2}, {4, 2, 3}, {4, 2, 4},
		// layer 3
		{2, 3, 3}, {2, 3, 4},
		{3, 3, 2}, {3, 3, 3}, {3, 3, 4},
		{4, 3, 2}, {4, 3, 3}, {4, 3, 4},
		// layer 4
		{2, 4, 4},
		{3, 4, 3}, {3, 4, 4},
		{4, 4, 2}, {4, 4, 3}, {4, 4, 4},
		// layer 5
		{3, 5, 4},
		{4, 5, 2}, {4, 5, 3}, {4, 5, 4},
		// layer 6
		{3, 6, 4},
		{4, 6, 3}, {4, 6, 4},
		// layer 7
		{4, 7, 4},
		// layer 8
		{4, 8, 4}
	};
	private final int[] chestPos1 = new int[] {3, 0, 4};
	private final int[] chestPos2 = new int[] {4, 0, 3};
	
	@Override
	public boolean generate(World world, Random rand, BlockPos position)
	{
		if (canSpawnAboveGround(world, position, 7, 7))
		{
			IBlockState stone_brick = Blocks.STONEBRICK.getDefaultState();
			IBlockState chest = Blocks.CHEST.getDefaultState();
			
			EnumFacing side = getRandomSideWithoutOffset(rand);
			
			placeAirBlocks(world, position, 7, 8, 7, side, 1);
			
			buildLayer(world, position, bricksPos, stone_brick, side);
			placeBlock(world, position, chestPos1, chest, side);
			placeBlock(world, position, chestPos2, chest, side);

			BlockPos chestActualPos1 = getPosFromCorner(position, chestPos1[0], chestPos1[2], side);
			BlockPos chestActualPos2 = getPosFromCorner(position, chestPos2[0], chestPos2[2], side);
			
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
