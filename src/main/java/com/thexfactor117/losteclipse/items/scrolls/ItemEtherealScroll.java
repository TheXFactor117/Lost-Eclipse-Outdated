package com.thexfactor117.losteclipse.items.scrolls;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.init.ModItems;
import com.thexfactor117.losteclipse.items.ItemLE;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ItemEtherealScroll extends ItemLE
{
	public ItemEtherealScroll(String name, Rarity rarity) 
	{
		super(name, rarity);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand)
	{		
		if (player.inventory.getCurrentItem().getItem() == ModItems.etherealScroll)
		{
			if (!world.isRemote)
			{
				player.setHealth(player.getHealth() + 10);
				
				if (player.getHealth() > player.getMaxHealth()) player.setHealth(player.getMaxHealth());
				
				stack.stackSize--;
			}
		}
		
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}
}