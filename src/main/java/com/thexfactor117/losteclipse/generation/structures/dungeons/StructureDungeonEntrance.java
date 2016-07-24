package com.thexfactor117.losteclipse.generation.structures.dungeons;

import java.util.Random;

import com.thexfactor117.losteclipse.generation.StructureLEBase;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * 
 * @author TheXFactor117
 *
 */
public class StructureDungeonEntrance extends StructureLEBase
{
	protected EnumFacing facing;
	
	protected StructureDungeonEntrance(EnumFacing facing)
	{
		this.facing = facing;
	}
	
	private final int[][] stoneBricksPos = new int[][]
	{
		{0, 1, 0}, {1, 1, 0},
		// layer 0
		{0, 0, 2}, {0, 0, 3}, {0, 0, 4}, {0, 0, 5}, {0, 0, 6}, {0, 0, 7}, {0, 0, 8},
		{1, 0, 1}, {1, 0, 2}, {1, 0, 3}, {1, 0, 4}, {1, 0, 5}, {1, 0, 6}, {1, 0, 7}, {1, 0, 8}, {1, 0, 9},
		{2, 0, 0}, {2, 0, 1}, {2, 0, 2}, {2, 0, 3}, {2, 0, 4}, {2, 0, 5}, {2, 0, 6}, {2, 0, 7}, {2, 0, 8}, {2, 0, 9}, {2, 0, 10},
		{3, 0, 0}, {3, 0, 1}, {3, 0, 2}, {3, 0, 3}, {3, 0, 4}, {3, 0, 5}, {3, 0, 6}, {3, 0, 7}, {3, 0, 8}, {3, 0, 9}, {3, 0, 10},
		{4, 0, 0}, {4, 0, 1}, {4, 0, 2}, {4, 0, 3}, {4, 0, 4}, {4, 0, 5}, {4, 0, 6}, {4, 0, 7}, {4, 0, 8}, {4, 0, 9}, {4, 0, 10},
		{5, 0, 0}, {5, 0, 1}, {5, 0, 2}, {5, 0, 3}, {5, 0, 4}, {5, 0, 5}, {5, 0, 6}, {5, 0, 7}, {5, 0, 8}, {5, 0, 9}, {5, 0, 10},
		{6, 0, 0}, {6, 0, 1}, {6, 0, 2}, {6, 0, 3}, {6, 0, 4}, {6, 0, 5}, {6, 0, 6}, {6, 0, 7}, {6, 0, 8}, {6, 0, 9}, {6, 0, 10},
		{7, 0, 0}, {7, 0, 1}, {7, 0, 2}, {7, 0, 3}, {7, 0, 4}, {7, 0, 5}, {7, 0, 6}, {7, 0, 7}, {7, 0, 8}, {7, 0, 9}, {7, 0, 10},
		{8, 0, 0}, {8, 0, 1}, {8, 0, 2}, {8, 0, 3}, {8, 0, 4}, {8, 0, 5}, {8, 0, 6}, {8, 0, 7}, {8, 0, 8}, {8, 0, 9}, {8, 0, 10},
		{9, 0, 1}, {9, 0, 2}, {9, 0, 3}, {9, 0, 4}, {9, 0, 5}, {9, 0, 6}, {9, 0, 7}, {9, 0, 8}, {9, 0, 9},
		{10, 0, 2}, {10, 0, 3}, {10, 0, 4}, {10, 0, 5}, {10, 0, 6}, {10, 0, 7}, {10, 0, 8},
		// layer 1
		{0, 1, 2}, {0, 1, 3}, {0, 1, 4}, {0, 1, 6}, {0, 1, 7}, {0, 1, 8},
		{1, 1, 1}, {1, 1, 9},
		{2, 1, 0}, {2, 1, 10},
		{3, 1, 0}, {3, 1, 10},
		{4, 1, 0}, {4, 1, 10},
		{6, 1, 0}, {6, 1, 10},
		{7, 1, 0}, {7, 1, 10},
		{8, 1, 0}, {8, 1, 10},
		{9, 1, 1}, {9, 1, 9},
		{10, 1, 2}, {10, 1, 3}, {10, 1, 4}, {10, 1, 6}, {10, 1, 7}, {10, 1, 8},
		// layer 2
		{0, 2, 2}, {0, 2, 3}, {0, 2, 4}, {0, 2, 6}, {0, 2, 7}, {0, 2, 8},
		{1, 2, 1}, {1, 2, 9},
		{2, 2, 0}, {2, 2, 10},
		{3, 2, 0}, {3, 2, 10},
		{4, 2, 0}, {4, 2, 10},
		{6, 2, 0}, {6, 2, 10},
		{7, 2, 0}, {7, 2, 10},
		{8, 2, 0}, {8, 2, 10},
		{9, 2, 1}, {9, 2, 9},
		{10, 2, 2}, {10, 2, 3}, {10, 2, 4}, {10, 2, 6}, {10, 2, 7}, {10, 2, 8},
		// layer 3
		{0, 3, 2}, {0, 3, 3}, {0, 3, 4}, {0, 3, 5}, {0, 3, 6}, {0, 3, 7}, {0, 3, 8},
		{1, 3, 1}, {1, 3, 9},
		{2, 3, 0}, {2, 3, 10},
		{3, 3, 0}, {3, 3, 10},
		{4, 3, 0}, {4, 3, 10},
		{5, 3, 0}, {5, 3, 10},
		{6, 3, 0}, {6, 3, 10},
		{7, 3, 0}, {7, 3, 10},
		{8, 3, 0}, {8, 3, 10},
		{9, 3, 1}, {9, 3, 9},
		{10, 3, 2}, {10, 3, 3}, {10, 3, 4}, {10, 3, 5}, {10, 3, 6}, {10, 3, 7}, {10, 3, 8},
		// layer 4
		{0, 4, 2}, {0, 4, 3}, {0, 4, 4}, {0, 4, 5}, {0, 4, 6}, {0, 4, 7}, {0, 4, 8},
		{1, 4, 1}, {1, 4, 2}, {1, 4, 3}, {1, 4, 4}, {1, 4, 5}, {1, 4, 6}, {1, 4, 7}, {1, 4, 8}, {1, 4, 9},
		{2, 4, 0}, {2, 4, 1}, {2, 4, 2}, {2, 4, 3}, {2, 4, 4}, {2, 4, 5}, {2, 4, 6}, {2, 4, 7}, {2, 4, 8}, {2, 4, 9}, {2, 4, 10},
		{3, 4, 0}, {3, 4, 1}, {3, 4, 2}, {3, 4, 3}, {3, 4, 4}, {3, 4, 5}, {3, 4, 6}, {3, 4, 7}, {3, 4, 8}, {3, 4, 9}, {3, 4, 10},
		{4, 4, 0}, {4, 4, 1}, {4, 4, 2}, {4, 4, 3}, {4, 4, 4}, {4, 4, 5}, {4, 4, 6}, {4, 4, 7}, {4, 4, 8}, {4, 4, 9}, {4, 4, 10},
		{5, 4, 0}, {5, 4, 1}, {5, 4, 2}, {5, 4, 3}, {5, 4, 4}, {5, 4, 5}, {5, 4, 6}, {5, 4, 7}, {5, 4, 8}, {5, 4, 9}, {5, 4, 10},
		{6, 4, 0}, {6, 4, 1}, {6, 4, 2}, {6, 4, 3}, {6, 4, 4}, {6, 4, 5}, {6, 4, 6}, {6, 4, 7}, {6, 4, 8}, {6, 4, 9}, {6, 4, 10},
		{7, 4, 0}, {7, 4, 1}, {7, 4, 2}, {7, 4, 3}, {7, 4, 4}, {7, 4, 5}, {7, 4, 6}, {7, 4, 7}, {7, 4, 8}, {7, 4, 9}, {7, 4, 10},
		{8, 4, 0}, {8, 4, 1}, {8, 4, 2}, {8, 4, 3}, {8, 4, 4}, {8, 4, 5}, {8, 4, 6}, {8, 4, 7}, {8, 4, 8}, {8, 4, 9}, {8, 4, 10},
		{9, 4, 1}, {9, 4, 2}, {9, 4, 3}, {9, 4, 4}, {9, 4, 5}, {9, 4, 6}, {9, 4, 7}, {9, 4, 8}, {9, 4, 9},
		{10, 4, 2}, {10, 4, 3}, {10, 4, 4}, {10, 4, 5}, {10, 4, 6}, {10, 4, 7}, {10, 4, 8}
	};
	
	@Override
	public boolean generate(World world, Random rand, BlockPos position)
	{
		IBlockState stone_brick = Blocks.STONEBRICK.getDefaultState();
		placeAirBlocks(world, position.add(1, 0, 1), 9, 4, 9, this.facing, 0);
		buildLayer(world, position, stoneBricksPos, stone_brick, this.facing);
		
		return true;
	}
}
