package com.thexfactor117.losteclipse.items.melee;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import com.google.common.collect.Multimap;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

/**
 * 
 * @author TheXFactor117
 * @author Choonster
 * 
 * Manipulates AttributeModifiers in order to make weapons swing slower, faster, as well as multiply damage values by a multiplier.
 */
public class ItemLEAdvancedMelee extends ItemLEMelee
{
	private double damageMultiplier;
	private double speedMultiplier;
	
	public ItemLEAdvancedMelee(ToolMaterial material, String name, double damageMultiplier, double speedMultiplier, int maxUses) 
	{
		super(material, name);
		this.setMaxDamage(maxUses);
		this.damageMultiplier = damageMultiplier;
		this.speedMultiplier = speedMultiplier;
	}
	
	public ItemLEAdvancedMelee(ToolMaterial material, String name, double damageMultiplier, double speedMultiplier)
	{
		super(material, name);
		this.damageMultiplier = damageMultiplier;
		this.speedMultiplier = speedMultiplier;
	}
	
	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) 
	{
		final Multimap<String, AttributeModifier> modifiers = super.getAttributeModifiers(slot, stack);

		if (slot == EntityEquipmentSlot.MAINHAND) 
		{
			replaceModifier(modifiers, SharedMonsterAttributes.ATTACK_DAMAGE, ATTACK_DAMAGE_MODIFIER, damageMultiplier);
			replaceModifier(modifiers, SharedMonsterAttributes.ATTACK_SPEED, ATTACK_SPEED_MODIFIER, speedMultiplier);
		}

		return modifiers;
	}

	/**
	 * Replace a modifier in the {@link Multimap} with a copy that's had {@code multiplier} applied to its value.
	 *
	 * @param modifierMultimap The MultiMap
	 * @param attribute        The attribute being modified
	 * @param id               The ID of the modifier
	 * @param multiplier       The multiplier to apply
	 */
	private void replaceModifier(Multimap<String, AttributeModifier> modifierMultimap, IAttribute attribute, UUID id, double multiplier) 
	{
		// Get the modifiers for the specified attribute
		final Collection<AttributeModifier> modifiers = modifierMultimap.get(attribute.getName());
		// Find the modifier with the specified ID, if any
		final Optional<AttributeModifier> modifierOptional = modifiers.stream().filter(attributeModifier -> attributeModifier.getID().equals(id)).findFirst();

		if (modifierOptional.isPresent()) // If it exists,
		{
			final AttributeModifier modifier = modifierOptional.get();
			modifiers.remove(modifier); // Remove it
			modifiers.add(new AttributeModifier(modifier.getID(), modifier.getName(), modifier.getAmount() * multiplier, modifier.getOperation())); // Add the new modifier
		}
	}
}
