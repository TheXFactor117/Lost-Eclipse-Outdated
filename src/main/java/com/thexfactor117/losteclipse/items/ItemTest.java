package com.thexfactor117.losteclipse.items;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.generation.GenerateProcedural;
import com.thexfactor117.losteclipse.init.ModTabs;
import com.thexfactor117.losteclipse.items.base.ItemLE;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
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
			GenerateProcedural.procedurallyGenerate(manager, world, pos, 4);

			return EnumActionResult.SUCCESS;
		}
		
		return EnumActionResult.PASS;
    }
}
