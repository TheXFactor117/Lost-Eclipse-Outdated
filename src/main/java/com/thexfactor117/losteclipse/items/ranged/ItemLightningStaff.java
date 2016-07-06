package com.thexfactor117.losteclipse.items.ranged;

import javax.annotation.Nullable;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.entities.projectiles.EntityLightning;
import com.thexfactor117.losteclipse.init.ModArmory;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ItemLightningStaff extends ItemLEStaff
{
	public ItemLightningStaff(String name, Rarity rarity, int durability) 
	{
		super(name, rarity, durability);
		this.addPropertyOverride(new ResourceLocation("pull"), new IItemPropertyGetter()
		{
			@SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World world, @Nullable EntityLivingBase entity)
            {
                if (entity == null)
                {
                    return 0.0F;
                }
                else
                {
                    ItemStack itemstack = entity.getActiveItemStack();
                    return itemstack != null && itemstack.getItem() == ModArmory.lightningStaff ? (float)(stack.getMaxItemUseDuration() - entity.getItemInUseCount()) / 20.0F : 0.0F;
                }
            }
		});
		this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World world, @Nullable EntityLivingBase entity)
            {
                return entity != null && entity.isHandActive() && entity.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityLivingBase entity, int count)
	{
		int duration = getMaxItemUseDuration(stack) - count;
		float var = duration / 20.0F;
		var = (var * var + var * 2.0F) / 5.0F;

		if (var < 1.0F) return;
		if (var >= 1.0F)
		{
			var = 1.0F;
		}
		
		if (entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) entity;
			
			if (player.capabilities.isCreativeMode || player.inventory.hasItemStack(stack))
			{
				stack.damageItem(1, player);
				world.playSound(player, player.getPosition(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.NEUTRAL, 1.0F, 1.0F);
				
				if (!world.isRemote)
				{
					Vec3d look = player.getLookVec();
					double x = look.xCoord;
					double y = look.yCoord;
					double z = look.zCoord;
					EntityLightning lightning = new EntityLightning(world, x, y, z, 1.0F, 0F);
					lightning.setPosition(player.posX + look.xCoord, player.posY + look.yCoord + 1.5, player.posZ + look.zCoord);
					world.spawnEntityInWorld(lightning);
				}
			}
		}
	}
}