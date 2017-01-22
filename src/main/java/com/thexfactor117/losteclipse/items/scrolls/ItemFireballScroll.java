package com.thexfactor117.losteclipse.items.scrolls;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.entities.projectiles.EntityFireball;
import com.thexfactor117.losteclipse.init.ModItems;
import com.thexfactor117.losteclipse.items.base.ItemLE;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ItemFireballScroll extends ItemLE
{
	public ItemFireballScroll(String name, Rarity rarity) 
	{
		super(name, rarity);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
	{		
		ItemStack stack = player.inventory.getCurrentItem();
		
		if (player.inventory.getCurrentItem().getItem() == ModItems.fireballScroll)
		{
			if (!world.isRemote)
			{
				Vec3d look = player.getLookVec();
				double x = look.xCoord;
				double y = look.yCoord;
				double z = look.zCoord;
				EntityFireball fireball = new EntityFireball(world, x, y, z, 1.0F, 0F);
				fireball.setPosition(player.posX + look.xCoord, player.posY + look.yCoord + 1.5, player.posZ + look.zCoord);
				world.spawnEntityInWorld(fireball);
				// decrease stack size by 1
				stack.func_190918_g(1);
			}
		}
		
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}
}
