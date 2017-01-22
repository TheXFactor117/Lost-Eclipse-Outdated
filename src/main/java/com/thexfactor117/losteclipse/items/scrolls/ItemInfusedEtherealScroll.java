package com.thexfactor117.losteclipse.items.scrolls;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.init.ModItems;
import com.thexfactor117.losteclipse.items.base.ItemLE;

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
public class ItemInfusedEtherealScroll extends ItemLE
{
	public ItemInfusedEtherealScroll(String name, Rarity rarity) 
	{
		super(name, rarity);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
	{		
		ItemStack stack = player.inventory.getCurrentItem();
		
		if (player.inventory.getCurrentItem().getItem() == ModItems.infusedEtherealScroll)
		{
			if (!world.isRemote)
			{
				player.setHealth(player.getMaxHealth());
				
				// decrease stack size by 1
				stack.func_190918_g(1);
			}
		}
		
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}
}
