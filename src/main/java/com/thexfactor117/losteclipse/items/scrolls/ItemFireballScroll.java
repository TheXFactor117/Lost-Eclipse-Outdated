package com.thexfactor117.losteclipse.items.scrolls;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.init.ModItems;
import com.thexfactor117.losteclipse.items.ItemLE;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemFireballScroll extends ItemLE
{
	public ItemFireballScroll(String name, Rarity rarity) 
	{
		super(name, rarity);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand)
	{		
		if (player.inventory.getCurrentItem().getItem() == ModItems.fireballScroll)
		{
			if (!world.isRemote)
			{
				/**
				 * Vec3 is used to find the players position, as well as
				 * the direction the player is facing so that the entity
				 * will 'fly' in a straight path.
				 */
				Vec3d look = player.getLookVec();
				EntitySmallFireball fireball = new EntitySmallFireball(world);
				fireball.setPosition(player.posX + look.xCoord, player.posY + look.yCoord + 1.5, player.posZ + look.zCoord);
				world.spawnEntityInWorld(fireball);
				fireball.setVelocity(0.5, 0.5, 0.5);
				stack.stackSize--;
			}
		}
		
		return new ActionResult<ItemStack>(EnumActionResult.PASS, stack);
	}
}
