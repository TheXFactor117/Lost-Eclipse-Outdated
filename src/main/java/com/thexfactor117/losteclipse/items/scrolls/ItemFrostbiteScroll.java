package com.thexfactor117.losteclipse.items.scrolls;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.entities.projectiles.EntityFrostbite;
import com.thexfactor117.losteclipse.init.ModItems;
import com.thexfactor117.losteclipse.items.ItemLE;

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
public class ItemFrostbiteScroll extends ItemLE
{
	public ItemFrostbiteScroll(String name, Rarity rarity) 
	{
		super(name, rarity);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand)
	{		
		if (player.inventory.getCurrentItem().getItem() == ModItems.frostbiteScroll)
		{
			if (!world.isRemote)
			{
				/**
				 * Vec3 is used to find the players position, as well as
				 * the direction the player is facing so that the entity
				 * will 'fly' in a straight path.
				 */
				Vec3d look = player.getLookVec();
				double x = look.xCoord;
				double y = look.yCoord;
				double z = look.zCoord;
				EntityFrostbite frostbite = new EntityFrostbite(world, x, y, z, 1.0F, 0F);
				frostbite.setPosition(player.posX + look.xCoord, player.posY + look.yCoord + 1.5, player.posZ + look.zCoord);
				world.spawnEntityInWorld(frostbite);
				stack.stackSize--;
			}
		}
		
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}
}
