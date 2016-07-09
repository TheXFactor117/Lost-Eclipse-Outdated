package com.thexfactor117.losteclipse.items.scrolls;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.api.capabilities.IFlameCloak;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityFlameCloak;
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
public class ItemFlameCloakScroll extends ItemLE
{
	public ItemFlameCloakScroll(String name, Rarity rarity) 
	{
		super(name, rarity);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand)
	{		
		if (player.inventory.getCurrentItem().getItem() == ModItems.flameCloakScroll)
		{
			if (!world.isRemote)
			{
				IFlameCloak flameCloak = player.getCapability(CapabilityFlameCloak.FLAME_CLOAK_CAP, null);
				
				if (flameCloak != null)
				{
					flameCloak.setFlameCloak(true);
				}
				
				stack.stackSize--;
			}
		}
		
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}
}
