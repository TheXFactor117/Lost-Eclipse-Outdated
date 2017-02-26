package com.thexfactor117.losteclipse.init;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.items.ItemTest;
import com.thexfactor117.losteclipse.items.base.ItemAmulet;
import com.thexfactor117.losteclipse.items.base.ItemBelt;
import com.thexfactor117.losteclipse.items.base.ItemLE;
import com.thexfactor117.losteclipse.items.base.ItemRing;
import com.thexfactor117.losteclipse.items.jewelry.ItemBeltFireResistance;
import com.thexfactor117.losteclipse.items.jewelry.ItemBeltResistance;
import com.thexfactor117.losteclipse.items.jewelry.ItemGoldenRingDamage;
import com.thexfactor117.losteclipse.items.jewelry.ItemGoldenRingHealth;
import com.thexfactor117.losteclipse.items.jewelry.ItemGoldenRingMinorDamage;
import com.thexfactor117.losteclipse.items.jewelry.ItemGoldenRingMinorHealth;
import com.thexfactor117.losteclipse.items.scrolls.ItemEtherealScroll;
import com.thexfactor117.losteclipse.items.scrolls.ItemFamiliarConjurationScroll;
import com.thexfactor117.losteclipse.items.scrolls.ItemFireballScroll;
import com.thexfactor117.losteclipse.items.scrolls.ItemFlameCloakScroll;
import com.thexfactor117.losteclipse.items.scrolls.ItemFrostbiteScroll;
import com.thexfactor117.losteclipse.items.scrolls.ItemHardenedScroll;
import com.thexfactor117.losteclipse.items.scrolls.ItemInfusedEtherealScroll;
import com.thexfactor117.losteclipse.items.scrolls.ItemInvisibilityScroll;
import com.thexfactor117.losteclipse.items.scrolls.ItemRadiationScroll;
import com.thexfactor117.losteclipse.items.scrolls.ItemRemyScroll;
import com.thexfactor117.losteclipse.items.scrolls.ItemVoidScroll;
import com.thexfactor117.losteclipse.util.RegisterHelper;

import net.minecraft.item.Item;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ModItems 
{
	// artifacts
	public static Item eclipse = new ItemLE("artifact_eclipse", Rarity.ARCHAIC);
	public static Item omega = new ItemLE("artifact_omega", Rarity.ARCHAIC);
	public static Item inheritance = new ItemLE("artifact_inheritance", Rarity.ARCHAIC);
	public static Item mythic = new ItemLE("artifact_mythic", Rarity.ARCHAIC);
	public static Item nova = new ItemLE("artifact_nova", Rarity.ARCHAIC);
	
	// ingots & gems
	public static Item garnet = new ItemLE("garnet", Rarity.COMMON);
	public static Item verantiumIngot = new ItemLE("verantium_ingot", Rarity.UNCOMMON);
	public static Item onyxGem = new ItemLE("onyx_gem", Rarity.RARE);
	public static Item amethyst = new ItemLE("amethyst", Rarity.RARE);
	public static Item vexalGem = new ItemLE("vexal_gem", Rarity.RARE);
	public static Item etherealGem = new ItemLE("ethereal_gem", Rarity.ULTRA_RARE);
	public static Item astrillGemFragment = new ItemLE("astrill_gem_fragment", Rarity.ULTRA_RARE);
	public static Item astrillGem = new ItemLE("astrill_gem", Rarity.LEGENDARY);
	public static Item inferniteGem = new ItemLE("infernite_gem", Rarity.LEGENDARY);
	
	// glyphs
	/*public static Item fireGlyph = new ItemLE("fire_glyph", Rarity.COMMON);
	public static Item frostGlyph = new ItemLE("frost_glyph", Rarity.COMMON);
	public static Item poisonGlyph = new ItemLE("poison_glyph", Rarity.COMMON);
	public static Item strengthGlyph = new ItemLE("strength_glyph", Rarity.UNCOMMON);
	public static Item minorDamageGlyph = new ItemLE("minor_damage_glyph", Rarity.UNCOMMON);
	public static Item minorEtherealGlyph = new ItemLE("minor_ethereal_glyph", Rarity.UNCOMMON);
	public static Item hardenedGlyph = new ItemLE("hardened_glyph", Rarity.UNCOMMON);
	public static Item elementalGlyph = new ItemLE("elemental_glyph", Rarity.RARE);
	public static Item darkenedGlyph = new ItemLE("darkened_glyph", Rarity.RARE);
	public static Item brightenedGlyph = new ItemLE("brightened_glyph", Rarity.RARE);
	public static Item bloodGlyph = new ItemLE("blood_glyph", Rarity.RARE);
	public static Item absorbtionGlyph = new ItemLE("absorbtion_glyph", Rarity.RARE);
	public static Item minorConjurationGlyph = new ItemLE("minor_conjuration_glyph", Rarity.RARE);
	public static Item majorEtherealGlyph = new ItemLE("major_ethereal_glyph", Rarity.LEGENDARY);
	public static Item chainedGlyph = new ItemLE("chained_glyph", Rarity.LEGENDARY);
	public static Item invisibilityGlyph = new ItemLE("invisibility_glyph", Rarity.LEGENDARY);
	public static Item majorConjurationGlyph = new ItemLE("major_conjuration_glyph", Rarity.LEGENDARY);
	public static Item voidGlyph = new ItemLE("void_glyph", Rarity.ARCHAIC);*/
	
	// scrolls
	public static Item fireballScroll = new ItemFireballScroll("fireball_scroll", Rarity.UNCOMMON);
	public static Item frostbiteScroll = new ItemFrostbiteScroll("frostbite_scroll", Rarity.UNCOMMON);
	public static Item hardenedScroll = new ItemHardenedScroll("hardened_scroll", Rarity.UNCOMMON);
	public static Item etherealScroll = new ItemEtherealScroll("ethereal_scroll", Rarity.RARE);
	public static Item radiationScroll = new ItemRadiationScroll("radiation_scroll", Rarity.RARE);
	public static Item familiarConjurationScroll = new ItemFamiliarConjurationScroll("familiar_conjuration_scroll", Rarity.RARE);
	public static Item flameCloakScroll = new ItemFlameCloakScroll("flame_cloak_scroll", Rarity.RARE);
	public static Item invisibilityScroll = new ItemInvisibilityScroll("invisibility_scroll", Rarity.ULTRA_RARE);
	public static Item infusedEtherealScroll = new ItemInfusedEtherealScroll("infused_ethereal_scroll", Rarity.ULTRA_RARE);
	public static Item voidScroll = new ItemVoidScroll("void_scroll", Rarity.LEGENDARY);
	public static Item remyScroll = new ItemRemyScroll("remy_scroll", Rarity.ARCHAIC);
	
	// jewelry
	public static Item minorHealthGoldenRing = new ItemGoldenRingMinorHealth("minor_health_golden_ring", Rarity.UNCOMMON);
	public static Item minorDamageGoldenRing = new ItemGoldenRingMinorDamage("minor_damage_golden_ring", Rarity.UNCOMMON);
	public static Item fireResistanceBelt = new ItemBeltFireResistance("fire_resistance_belt", Rarity.UNCOMMON);
	public static Item soulRing = new ItemRing("soul_ring", Rarity.RARE);
	public static Item soulAmulet = new ItemAmulet("soul_amulet", Rarity.RARE);
	public static Item healthGoldenRing = new ItemGoldenRingHealth("health_golden_ring", Rarity.RARE);
	public static Item damageGoldenRing = new ItemGoldenRingDamage("damage_golden_ring", Rarity.RARE);
	public static Item resistanceBelt = new ItemBeltResistance("resistance_belt", Rarity.RARE);
	public static Item infusedSoulRing = new ItemRing("infused_soul_ring", Rarity.ULTRA_RARE);
	public static Item infusedSoulAmulet = new ItemAmulet("infused_soul_amulet", Rarity.ULTRA_RARE);
	public static Item valadurSoulAmulet = new ItemAmulet("valadur_soul_amulet", Rarity.ARCHAIC);
	public static Item forerunnerBelt = new ItemBelt("forerunner_belt", Rarity.ARCHAIC);
	
	// misc
	public static Item staffBase = new ItemLE("staff_base", Rarity.COMMON);
	public static Item frostRod = new ItemLE("frost_rod", Rarity.COMMON);
	public static Item frostDust = new ItemLE("frost_dust", Rarity.COMMON);
	public static Item goldenRing = new ItemLE("golden_ring", Rarity.COMMON);
	public static Item basicGlyphPattern = new ItemLE("basic_glyph_pattern", Rarity.COMMON);
	public static Item golemGyro = new ItemLE("golem_gyro", Rarity.UNCOMMON);
	public static Item diamondRing = new ItemLE("diamond_ring", Rarity.RARE);
	public static Item rareGlyphPattern = new ItemLE("rare_glyph_pattern", Rarity.RARE);
	public static Item astrillRing = new ItemLE("astrill_ring", Rarity.LEGENDARY);
	public static Item legendaryGlyphPattern = new ItemLE("legendary_glyph_pattern", Rarity.LEGENDARY);
	
	// test
	public static Item testItem = new ItemTest("test_item", Rarity.ARCHAIC);
	
	public static void registerItems()
	{
		// artifacts
		RegisterHelper.registerItems(eclipse);
		RegisterHelper.registerItems(omega);
		RegisterHelper.registerItems(inheritance);
		RegisterHelper.registerItems(mythic);
		RegisterHelper.registerItems(nova);
		
		// ingots & gems
		RegisterHelper.registerItems(verantiumIngot);
		RegisterHelper.registerItems(garnet);
		RegisterHelper.registerItems(onyxGem);
		RegisterHelper.registerItems(amethyst);
		RegisterHelper.registerItems(vexalGem);
		RegisterHelper.registerItems(etherealGem);
		RegisterHelper.registerItems(astrillGemFragment);
		RegisterHelper.registerItems(astrillGem);
		RegisterHelper.registerItems(inferniteGem);
		
		// glyphs
		/*RegisterHelper.registerItems(fireGlyph);
		RegisterHelper.registerItems(frostGlyph);
		RegisterHelper.registerItems(poisonGlyph);
		RegisterHelper.registerItems(strengthGlyph);
		RegisterHelper.registerItems(minorDamageGlyph);
		RegisterHelper.registerItems(minorEtherealGlyph);
		RegisterHelper.registerItems(hardenedGlyph);
		RegisterHelper.registerItems(elementalGlyph);
		RegisterHelper.registerItems(darkenedGlyph);
		RegisterHelper.registerItems(brightenedGlyph);
		RegisterHelper.registerItems(bloodGlyph);
		RegisterHelper.registerItems(absorbtionGlyph);
		RegisterHelper.registerItems(minorConjurationGlyph);
		RegisterHelper.registerItems(majorEtherealGlyph);
		RegisterHelper.registerItems(chainedGlyph);
		RegisterHelper.registerItems(invisibilityGlyph);
		RegisterHelper.registerItems(majorConjurationGlyph);
		RegisterHelper.registerItems(voidGlyph);*/
		
		// scrolls
		RegisterHelper.registerItems(fireballScroll);
		RegisterHelper.registerItems(frostbiteScroll);
		RegisterHelper.registerItems(hardenedScroll);
		RegisterHelper.registerItems(etherealScroll);
		RegisterHelper.registerItems(radiationScroll);
		RegisterHelper.registerItems(familiarConjurationScroll);
		RegisterHelper.registerItems(flameCloakScroll);
		RegisterHelper.registerItems(invisibilityScroll);
		RegisterHelper.registerItems(infusedEtherealScroll);
		RegisterHelper.registerItems(voidScroll);
		RegisterHelper.registerItems(remyScroll);
		
		// jewelry
		RegisterHelper.registerItems(minorHealthGoldenRing);
		RegisterHelper.registerItems(minorDamageGoldenRing);
		RegisterHelper.registerItems(fireResistanceBelt);
		RegisterHelper.registerItems(soulRing);
		RegisterHelper.registerItems(soulAmulet);
		RegisterHelper.registerItems(healthGoldenRing);
		RegisterHelper.registerItems(damageGoldenRing);
		RegisterHelper.registerItems(resistanceBelt);
		RegisterHelper.registerItems(infusedSoulRing);
		RegisterHelper.registerItems(infusedSoulAmulet);
		RegisterHelper.registerItems(valadurSoulAmulet);
		RegisterHelper.registerItems(forerunnerBelt);
		
		// misc
		RegisterHelper.registerItems(staffBase);
		RegisterHelper.registerItems(frostRod);
		RegisterHelper.registerItems(frostDust);
		RegisterHelper.registerItems(goldenRing);
		RegisterHelper.registerItems(basicGlyphPattern);
		RegisterHelper.registerItems(golemGyro);
		RegisterHelper.registerItems(diamondRing);
		RegisterHelper.registerItems(rareGlyphPattern);
		RegisterHelper.registerItems(astrillRing);
		RegisterHelper.registerItems(legendaryGlyphPattern);
		
		// test
		RegisterHelper.registerItems(testItem);
	}
}