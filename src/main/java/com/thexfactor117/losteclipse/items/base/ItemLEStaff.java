package com.thexfactor117.losteclipse.items.base;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.capabilities.player.CapabilityMana;
import com.thexfactor117.losteclipse.capabilities.player.Mana;
import com.thexfactor117.losteclipse.init.ModItems;

import baubles.api.BaublesApi;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
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
 * TODO: Optimize this a bit more?
 */
public class ItemLEStaff extends ItemLE
{
	private int manaPerUse;
	private int originalManaPerUse;
	
	public ItemLEStaff(String name, Rarity rarity, int manaPerUse) 
	{
		super(name, rarity);
		this.setMaxStackSize(1);
		this.setNoRepair();
		this.setManaPerUse(manaPerUse);
		this.originalManaPerUse = manaPerUse;
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        if (player.inventory.getCurrentItem() != null)
        {
        	@SuppressWarnings("deprecation")
			IInventory baubles = BaublesApi.getBaubles(player);
			Mana capMana = (Mana) player.getCapability(CapabilityMana.MANA_CAP, null);
			
			if (capMana != null && baubles != null)
			{
				for (int j = 0; j < baubles.getSizeInventory(); j++)
				{
					if (baubles.getStackInSlot(j) != null)
					{	
						if (baubles.getStackInSlot(j).getItem() != null)
						{        											
							if (baubles.getStackInSlot(j).getItem().equals(ModItems.soulRing)) setManaPerUse(getOriginalManaPerUse() - 1);
							if (baubles.getStackInSlot(j).getItem().equals(ModItems.soulAmulet)) setManaPerUse(getOriginalManaPerUse() - 1);
							if (baubles.getStackInSlot(j).getItem().equals(ModItems.infusedSoulRing)) setManaPerUse(getOriginalManaPerUse() - 3);
							if (baubles.getStackInSlot(j).getItem().equals(ModItems.infusedSoulAmulet)) setManaPerUse(getOriginalManaPerUse() - 1);
							if (baubles.getStackInSlot(j).getItem().equals(ModItems.valadurSoulAmulet)) setManaPerUse(0);
							
							if (getManaPerUse() < 0) setManaPerUse(0);
						}
					}
				}
				
				if (capMana.getMana() - getManaPerUse() >= 0)
				{
					player.setActiveHand(hand);
					return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, player.inventory.getCurrentItem());
				}
			}
        }
        
        return new ActionResult<ItemStack>(EnumActionResult.FAIL, player.inventory.getCurrentItem());
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
	
	public int getOriginalManaPerUse()
	{
		return this.originalManaPerUse;
	}
	
	public int getManaPerUse()
	{
		return this.manaPerUse;
	}
	
	public void setManaPerUse(int soulsPerUse)
	{
		this.manaPerUse = soulsPerUse;
	}
}
