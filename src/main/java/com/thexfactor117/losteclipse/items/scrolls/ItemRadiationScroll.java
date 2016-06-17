package com.thexfactor117.losteclipse.items.scrolls;

import java.util.Iterator;
import java.util.List;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.init.ModItems;
import com.thexfactor117.losteclipse.items.ItemLE;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ItemRadiationScroll extends ItemLE
{
	public ItemRadiationScroll(String name, Rarity rarity) 
	{
		super(name, rarity);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand)
	{		
		if (player.inventory.getCurrentItem().getItem() == ModItems.radiationScroll)
		{
			if (!world.isRemote)
			{
				List entityList = world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(player.posX - 10, player.posY - 10, player.posZ - 10, player.posX + 10, player.posY + 10, player.posZ + 10));
				Iterator iterator = entityList.iterator();
				
				while (iterator.hasNext())
				{
                    Entity entity = (Entity) iterator.next();
					if (entity instanceof EntityMob) entity.setFire(5);
				}
				
				stack.stackSize--;
			}
		}
		
		return new ActionResult<ItemStack>(EnumActionResult.PASS, stack);
	}
}
