package com.thexfactor117.losteclipse.items.ranged;

import javax.annotation.Nullable;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.entities.projectiles.EntityFireball;
import com.thexfactor117.losteclipse.entities.projectiles.EntityFrostbite;
import com.thexfactor117.losteclipse.entities.projectiles.EntityMagic;
import com.thexfactor117.losteclipse.init.ModArmory;
import com.thexfactor117.losteclipse.items.ItemSoulGem;
import com.thexfactor117.losteclipse.items.base.ItemLEStaff;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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
public class ItemElementalStaff extends ItemLEStaff
{
	public ItemElementalStaff(String name, Rarity rarity, int soulsPerUse) 
	{
		super(name, rarity, soulsPerUse);
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
                    return itemstack != null && itemstack.getItem() == ModArmory.elementalStaff ? (float)(stack.getMaxItemUseDuration() - entity.getItemInUseCount()) / 20.0F : 0.0F;
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
				world.playSound(player, player.getPosition(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.NEUTRAL, 1.0F, 1.0F);
				int rand = player.worldObj.rand.nextInt(3);
				
				if (!world.isRemote)
				{
					Vec3d look = player.getLookVec();
					double x = look.xCoord;
					double y = look.yCoord;
					double z = look.zCoord;
					
					switch (rand)
					{
						case 0:
							EntityFireball fireball = new EntityFireball(world, x, y, z, 1.0F, 0F);
							fireball.setPosition(player.posX + look.xCoord, player.posY + look.yCoord + 1.5, player.posZ + look.zCoord);
							world.spawnEntityInWorld(fireball);
						case 1:
							EntityFrostbite frostbite = new EntityFrostbite(world, x, y, z, 1.0F, 0F);
							frostbite.setPosition(player.posX + look.xCoord, player.posY + look.yCoord + 1.5, player.posZ + look.zCoord);
							world.spawnEntityInWorld(frostbite);
						case 2:
							EntityMagic magic = new EntityMagic(world, x, y, z, 1.0F, 0F, 8.0F);
							magic.setPosition(player.posX + look.xCoord, player.posY + look.yCoord + 1.5, player.posZ + look.zCoord);
							world.spawnEntityInWorld(magic);
					}
					
					for (int i = 0; i < player.inventory.mainInventory.length; i++)
		        	{
		        		if (player.inventory.mainInventory[i] != null && player.inventory.mainInventory[i].getItem() instanceof ItemSoulGem)
		        		{
		        			ItemStack soulGemStack = player.inventory.mainInventory[i];
	        				
	        				if (soulGemStack != null)
	        				{
	        					NBTTagCompound nbt = soulGemStack.getTagCompound();
	        					
	        					if (nbt != null)
	        					{
	        						ItemSoulGem soulGem = (ItemSoulGem) player.inventory.mainInventory[i].getItem();
	        						
	        						if (soulGem != null) soulGem.setSouls(nbt, soulGem.getSouls(nbt) - this.getSoulsPerUse());
	        					}
	        				}
		        		}
		        	}
				}
			}
		}
	}
}
