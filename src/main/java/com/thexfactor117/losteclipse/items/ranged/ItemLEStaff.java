package com.thexfactor117.losteclipse.items.ranged;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.items.ItemSoulGem;
import com.thexfactor117.losteclipse.items.base.ItemLE;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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
	public ItemLEStaff(String name, Rarity rarity) 
	{
		super(name, rarity);
		this.setMaxStackSize(1);
		this.setNoRepair();
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand)
    {
        if (stack != null)
        {
        	for (int i = 0; i < player.inventory.mainInventory.length; i++)
        	{
        		if (player.inventory.mainInventory[i] != null)
        		{
        			if (player.inventory.mainInventory[i].getItem() instanceof ItemSoulGem)
        			{
        				ItemStack soulGemStack = player.inventory.mainInventory[i];
        				
        				if (soulGemStack != null)
        				{
        					NBTTagCompound nbt = soulGemStack.getTagCompound();
        					
        					if (nbt != null)
        					{
        						ItemSoulGem soulGem = (ItemSoulGem) player.inventory.mainInventory[i].getItem();
        						
        						if (soulGem != null)
        						{
        							if (soulGem.getSouls(nbt) > 0)
        							{
        								player.setActiveHand(hand);
        								return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
        							}
        						}
        					}
        				}
        			}
        		}
        	}
        }
        
        return new ActionResult<ItemStack>(EnumActionResult.FAIL, stack);
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
