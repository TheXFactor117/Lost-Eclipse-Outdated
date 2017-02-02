package com.thexfactor117.losteclipse.items;

import java.util.Map.Entry;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.generation.ProceduralUtil;
import com.thexfactor117.losteclipse.init.ModLootTables;
import com.thexfactor117.losteclipse.init.ModTabs;
import com.thexfactor117.losteclipse.items.base.ItemLE;
import com.thexfactor117.losteclipse.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

/**
 * 
 * @author TheXFactor117
 *
 * Test Item. Serves as a debugging tool.
 */
public class ItemTest extends ItemLE
{
	public ItemTest(String name, Rarity rarity) 
	{
		super(name, ModTabs.tabLETest, rarity);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		if (!world.isRemote)
		{
			/*Mana capMana = (Mana) player.getCapability(CapabilityMana.MANA_CAP, null);

			if (capMana != null)
			{
				capMana.setMana(50);
				LostEclipse.network.sendTo(new PacketMana(capMana.getMana()), (EntityPlayerMP) player);
			}*/
			
			WorldServer server = (WorldServer) world;
			TemplateManager manager = server.getStructureTemplateManager();
			ResourceLocation location = new ResourceLocation(Reference.MODID, "loot_room_1");
			Template smallHouse = manager.get(world.getMinecraftServer(), location);
			PlacementSettings settings = new PlacementSettings().setRotation(Rotation.CLOCKWISE_180);

			if (smallHouse != null)
			{
				smallHouse.addBlocksToWorld(world, pos, settings);
				BlockPos center = ProceduralUtil.translateToCenter(smallHouse, pos, Rotation.CLOCKWISE_180);
				world.setBlockState(center, Blocks.DIAMOND_BLOCK.getDefaultState());
				
				// test chest loot generation
				for (Entry<BlockPos, String> e : smallHouse.getDataBlocks(pos, settings).entrySet())
				{
					if ("chest".equals(e.getValue()))
					{
						BlockPos dataPos = e.getKey();
						world.setBlockState(dataPos, Blocks.AIR.getDefaultState(), 3);
						TileEntity chestEntity = world.getTileEntity(dataPos.down());
						
						if (chestEntity instanceof TileEntityChest)
							((TileEntityChest) chestEntity).setLootTable(ModLootTables.STRUCTURE_ABANDONED_HOUSE, world.rand.nextLong());
					}
				}
			}

			return EnumActionResult.SUCCESS;
		}
		
		return EnumActionResult.PASS;
    }
}
