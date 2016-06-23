package com.thexfactor117.losteclipse.items.ranged;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.items.ItemLE;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
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
public class ItemLEStaff extends ItemLE
{
	public ItemLEStaff(String name, Rarity rarity, int durability) 
	{
		super(name, rarity);
		this.setMaxStackSize(1);
		this.setMaxDamage(durability);
		this.setNoRepair();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand)
    {
        boolean flag = stack != null;

        if (!player.capabilities.isCreativeMode && !flag)
        {
            return !flag ? new ActionResult(EnumActionResult.FAIL, stack) : new ActionResult(EnumActionResult.PASS, stack);
        }
        else
        {
            player.setActiveHand(hand);
            return new ActionResult(EnumActionResult.SUCCESS, stack);
        }
    }
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
    {
        return 300;
    }
	
	@Override
	public EnumAction getItemUseAction(ItemStack itemstack)
	{
		return EnumAction.NONE;
	}
}
