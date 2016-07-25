package com.thexfactor117.losteclipse.items.base;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.init.ModItems;
import com.thexfactor117.losteclipse.items.ItemSoulGem;

import baubles.api.BaublesApi;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
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
 * TODO: Optimize this a bit more?
 */
public class ItemLEStaff extends ItemLE
{
	public int soulsPerUse;
	public int originalSoulsPerUse;
	
	public ItemLEStaff(String name, Rarity rarity, int soulsPerUse) 
	{
		super(name, rarity);
		this.setMaxStackSize(1);
		this.setNoRepair();
		this.setSoulsPerUse(soulsPerUse);
		this.originalSoulsPerUse = soulsPerUse;
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
        							IInventory baubles = BaublesApi.getBaubles(player);
        							
        							if (baubles != null)
        							{
        								for (int j = 0; j < baubles.getSizeInventory(); j++)
        								{
        									if (baubles.getStackInSlot(j) != null)
        									{	
        										if (baubles.getStackInSlot(j).getItem() != null)
        										{        											
        											if (baubles.getStackInSlot(j).getItem().equals(ModItems.soulRing)) this.setSoulsPerUse(this.getOriginalSoulsPerUse() - 1);
        											if (baubles.getStackInSlot(j).getItem().equals(ModItems.soulAmulet)) this.setSoulsPerUse(this.getOriginalSoulsPerUse() - 1);
        											if (baubles.getStackInSlot(j).getItem().equals(ModItems.infusedSoulRing)) this.setSoulsPerUse(this.getOriginalSoulsPerUse() - 3);
        											if (baubles.getStackInSlot(j).getItem().equals(ModItems.infusedSoulAmulet)) this.setSoulsPerUse(this.getOriginalSoulsPerUse() - 1);
        											if (baubles.getStackInSlot(j).getItem().equals(ModItems.valadurSoulAmulet)) this.setSoulsPerUse(0);
        											
        											if (this.getSoulsPerUse() < 0) this.setSoulsPerUse(0);
        											
        											if (soulGem.getSouls(nbt) > 0)
        		        							{
        		        								player.setActiveHand(hand);
        		        								return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
        		        							}
        										}
        									}
        								}
        							}
        							
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
	
	public int getOriginalSoulsPerUse()
	{
		return this.originalSoulsPerUse;
	}
	
	public int getSoulsPerUse()
	{
		return this.soulsPerUse;
	}
	
	public void setSoulsPerUse(int soulsPerUse)
	{
		this.soulsPerUse = soulsPerUse;
	}
}
