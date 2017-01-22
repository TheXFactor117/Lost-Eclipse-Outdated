package com.thexfactor117.losteclipse.init;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.items.ItemSoulGem;
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
import com.thexfactor117.losteclipse.items.scrolls.ItemElementalScroll;
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
import com.thexfactor117.losteclipse.misc.RegisterHelper;

import net.minecraft.item.Item;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ModItems 
{
	// artifacts
	public static Item eclipse = new ItemLE("eclipse", Rarity.ARCHAIC);
	public static Item omega = new ItemLE("omega", Rarity.ARCHAIC);
	public static Item inheritance = new ItemLE("inheritance", Rarity.ARCHAIC);
	public static Item mythic = new ItemLE("mythic", Rarity.ARCHAIC);
	public static Item nova = new ItemLE("nova", Rarity.ARCHAIC);
	
	// ingots & gems
	public static Item malachiteIngot = new ItemLE("malachiteIngot", Rarity.UNCOMMON);
	public static Item garnet = new ItemLE("garnet", Rarity.UNCOMMON);
	public static Item soulGemFragment = new ItemLE("soulGemFragment", Rarity.UNCOMMON);
	public static Item soulGem = new ItemSoulGem("soulGem", Rarity.RARE);
	public static Item flawlessGarnet = new ItemLE("flawlessGarnet", Rarity.RARE);
	public static Item onyxGem = new ItemLE("onyxGem", Rarity.RARE);
	public static Item amethyst = new ItemLE("amethyst", Rarity.RARE);
	public static Item vexalGem = new ItemLE("vexalGem", Rarity.RARE);
	public static Item etherealGem = new ItemLE("etherealGem", Rarity.RARE);
	public static Item astrillGemFragment = new ItemLE("astrillGemFragment", Rarity.RARE);
	public static Item astrillGem = new ItemLE("astrillGem", Rarity.LEGENDARY);
	public static Item flawlessAmethyst = new ItemLE("flawlessAmethyst", Rarity.LEGENDARY);
	public static Item chysoliteGem = new ItemLE("chysoliteGem", Rarity.LEGENDARY);
	
	// glyphs
	public static Item fireGlyph = new ItemLE("fireGlyph", Rarity.COMMON);
	public static Item frostGlyph = new ItemLE("frostGlyph", Rarity.COMMON);
	public static Item poisonGlyph = new ItemLE("poisonGlyph", Rarity.COMMON);
	public static Item strengthGlyph = new ItemLE("strengthGlyph", Rarity.UNCOMMON);
	public static Item minorDamageGlyph = new ItemLE("minorDamageGlyph", Rarity.UNCOMMON);
	public static Item minorEtherealGlyph = new ItemLE("minorEtherealGlyph", Rarity.UNCOMMON);
	public static Item hardenedGlyph = new ItemLE("hardenedGlyph", Rarity.UNCOMMON);
	public static Item elementalGlyph = new ItemLE("elementalGlyph", Rarity.RARE);
	public static Item darkenedGlyph = new ItemLE("darkenedGlyph", Rarity.RARE);
	public static Item brightenedGlyph = new ItemLE("brightenedGlyph", Rarity.RARE);
	public static Item bloodGlyph = new ItemLE("bloodGlyph", Rarity.RARE);
	public static Item absorbtionGlyph = new ItemLE("absorbtionGlyph", Rarity.RARE);
	public static Item minorConjurationGlyph = new ItemLE("minorConjurationGlyph", Rarity.RARE);
	public static Item majorEtherealGlyph = new ItemLE("majorEtherealGlyph", Rarity.LEGENDARY);
	public static Item chainedGlyph = new ItemLE("chainedGlyph", Rarity.LEGENDARY);
	public static Item invisibilityGlyph = new ItemLE("invisibilityGlyph", Rarity.LEGENDARY);
	public static Item majorConjurationGlyph = new ItemLE("majorConjurationGlyph", Rarity.LEGENDARY);
	public static Item voidGlyph = new ItemLE("voidGlyph", Rarity.ARCHAIC);
	
	// scrolls
	public static Item fireballScroll = new ItemFireballScroll("fireballScroll", Rarity.UNCOMMON);
	public static Item frostbiteScroll = new ItemFrostbiteScroll("frostbiteScroll", Rarity.UNCOMMON);
	public static Item hardenedScroll = new ItemHardenedScroll("hardenedScroll", Rarity.UNCOMMON);
	public static Item etherealScroll = new ItemEtherealScroll("etherealScroll", Rarity.RARE);
	public static Item radiationScroll = new ItemRadiationScroll("radiationScroll", Rarity.RARE);
	public static Item elementalScroll = new ItemElementalScroll("elementalScroll", Rarity.RARE);
	public static Item familiarConjurationScroll = new ItemFamiliarConjurationScroll("familiarConjurationScroll", Rarity.RARE);
	public static Item flameCloakScroll = new ItemFlameCloakScroll("flameCloakScroll", Rarity.RARE);
	public static Item invisibilityScroll = new ItemInvisibilityScroll("invisibilityScroll", Rarity.LEGENDARY);
	public static Item infusedEtherealScroll = new ItemInfusedEtherealScroll("infusedEtherealScroll", Rarity.LEGENDARY);
	public static Item voidScroll = new ItemVoidScroll("voidScroll", Rarity.LEGENDARY);
	public static Item remyScroll = new ItemRemyScroll("remyScroll", Rarity.ARCHAIC);
	
	// jewelry
	public static Item minorHealthGoldenRing = new ItemGoldenRingMinorHealth("minorHealthGoldenRing", Rarity.UNCOMMON);
	public static Item minorDamageGoldenRing = new ItemGoldenRingMinorDamage("minorDamageGoldenRing", Rarity.UNCOMMON);
	public static Item fireResistanceBelt = new ItemBeltFireResistance("fireResistanceBelt", Rarity.UNCOMMON);
	public static Item soulRing = new ItemRing("soulRing", Rarity.RARE);
	public static Item soulAmulet = new ItemAmulet("soulAmulet", Rarity.RARE);
	public static Item healthGoldenRing = new ItemGoldenRingHealth("healthGoldenRing", Rarity.RARE);
	public static Item damageGoldenRing = new ItemGoldenRingDamage("damageGoldenRing", Rarity.RARE);
	public static Item resistanceBelt = new ItemBeltResistance("resistanceBelt", Rarity.RARE);
	public static Item infusedSoulRing = new ItemRing("infusedSoulRing", Rarity.LEGENDARY);
	public static Item infusedSoulAmulet = new ItemAmulet("infusedSoulAmulet", Rarity.LEGENDARY);
	public static Item valadurSoulAmulet = new ItemAmulet("valadurSoulAmulet", Rarity.ARCHAIC);
	public static Item forerunnerBelt = new ItemBelt("forerunnerBelt", Rarity.ARCHAIC);
	
	// misc
	public static Item staffBase = new ItemLE("staffBase", Rarity.COMMON);
	public static Item frostRod = new ItemLE("frostRod", Rarity.COMMON);
	public static Item frostDust = new ItemLE("frostDust", Rarity.COMMON);
	public static Item goldenRing = new ItemLE("goldenRing", Rarity.COMMON);
	public static Item basicGlyphPattern = new ItemLE("basicGlyphPattern", Rarity.COMMON);
	public static Item golemGyro = new ItemLE("golemGyro", Rarity.UNCOMMON);
	public static Item diamondRing = new ItemLE("diamondRing", Rarity.RARE);
	public static Item rareGlyphPattern = new ItemLE("rareGlyphPattern", Rarity.RARE);
	public static Item astrillRing = new ItemLE("astrillRing", Rarity.LEGENDARY);
	public static Item legendaryGlyphPattern = new ItemLE("legendaryGlyphPattern", Rarity.LEGENDARY);
	
	// test
	public static Item testItem = new ItemTest("testItem", Rarity.ARCHAIC);
	
	public static void registerItems()
	{
		// artifacts
		RegisterHelper.registerItems(eclipse);
		RegisterHelper.registerItems(omega);
		RegisterHelper.registerItems(inheritance);
		RegisterHelper.registerItems(mythic);
		RegisterHelper.registerItems(nova);
		
		// ingots & gems
		RegisterHelper.registerItems(malachiteIngot);
		RegisterHelper.registerItems(garnet);
		RegisterHelper.registerItems(soulGemFragment);
		RegisterHelper.registerItems(soulGem);
		RegisterHelper.registerItems(flawlessGarnet);
		RegisterHelper.registerItems(onyxGem);
		RegisterHelper.registerItems(amethyst);
		RegisterHelper.registerItems(vexalGem);
		RegisterHelper.registerItems(etherealGem);
		RegisterHelper.registerItems(astrillGemFragment);
		RegisterHelper.registerItems(astrillGem);
		RegisterHelper.registerItems(flawlessAmethyst);
		RegisterHelper.registerItems(chysoliteGem);
		
		// glyphs
		RegisterHelper.registerItems(fireGlyph);
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
		RegisterHelper.registerItems(voidGlyph);
		
		// scrolls
		RegisterHelper.registerItems(fireballScroll);
		RegisterHelper.registerItems(frostbiteScroll);
		RegisterHelper.registerItems(hardenedScroll);
		RegisterHelper.registerItems(etherealScroll);
		RegisterHelper.registerItems(radiationScroll);
		RegisterHelper.registerItems(elementalScroll);
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