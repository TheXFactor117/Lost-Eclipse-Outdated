package com.thexfactor117.losteclipse.init;

import com.thexfactor117.levels.leveling.Rarity;
import com.thexfactor117.losteclipse.items.ItemLE;
import com.thexfactor117.losteclipse.items.ItemSoulGem;
import com.thexfactor117.losteclipse.items.ItemTest;
import com.thexfactor117.losteclipse.items.scrolls.ItemElementalScroll;
import com.thexfactor117.losteclipse.items.scrolls.ItemEtherealScroll;
import com.thexfactor117.losteclipse.items.scrolls.ItemFireballScroll;
import com.thexfactor117.losteclipse.items.scrolls.ItemFrostbiteScroll;
import com.thexfactor117.losteclipse.items.scrolls.ItemRadiationScroll;
import com.thexfactor117.losteclipse.items.scrolls.ItemVoidScroll;
import com.thexfactor117.xlib.misc.RegisterHelper;

import net.minecraft.item.Item;

/**
 * 
 * @author TheXFactor117
 *
 */
public class ModItems 
{
	// artifacts
	public static Item eclipse = new ItemLE("eclipse", Rarity.ANCIENT);
	public static Item omega = new ItemLE("omega", Rarity.ANCIENT);
	public static Item inheritance = new ItemLE("inheritance", Rarity.ANCIENT);
	public static Item mythic = new ItemLE("mythic", Rarity.ANCIENT);
	public static Item nova = new ItemLE("nova", Rarity.ANCIENT);
	
	// ingots & gems
	public static Item malachiteIngot = new ItemLE("malachiteIngot", Rarity.UNCOMMON);
	public static Item vexalGem = new ItemLE("vexalGem", Rarity.RARE);
	public static Item astrillGem = new ItemLE("astrillGem", Rarity.LEGENDARY);
	public static Item astrillGemFragment = new ItemLE("astrillGemFragment", Rarity.RARE);
	public static Item soulGem = new ItemSoulGem("soulGem", Rarity.RARE);
	public static Item soulGemFragment = new ItemLE("soulGemFragment", Rarity.UNCOMMON);
	public static Item etherealGem = new ItemLE("etherealGem", Rarity.RARE);
	
	// scrolls
	public static Item fireballScroll = new ItemFireballScroll("fireballScroll", Rarity.UNCOMMON);
	public static Item frostbiteScroll = new ItemFrostbiteScroll("frostbiteScroll", Rarity.UNCOMMON);
	public static Item etherealScroll = new ItemEtherealScroll("etherealScroll", Rarity.RARE);
	public static Item radiationScroll = new ItemRadiationScroll("radiationScroll", Rarity.RARE);
	public static Item elementalScroll = new ItemElementalScroll("elementalScroll", Rarity.RARE);
	public static Item voidScroll = new ItemVoidScroll("voidScroll", Rarity.LEGENDARY);
	
	// misc
	public static Item staffBase = new ItemLE("staffBase", Rarity.BASIC);
	public static Item frostRod = new ItemLE("frostRod", Rarity.BASIC);
	public static Item frostDust = new ItemLE("frostDust", Rarity.BASIC);
	public static Item golemGyro = new ItemLE("golemGyro", Rarity.UNCOMMON);
	
	// test
	public static Item testItem = new ItemTest("testItem", Rarity.ANCIENT);
	
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
		RegisterHelper.registerItems(vexalGem);
		RegisterHelper.registerItems(astrillGem);
		RegisterHelper.registerItems(astrillGemFragment);
		RegisterHelper.registerItems(soulGem);
		RegisterHelper.registerItems(soulGemFragment);
		RegisterHelper.registerItems(etherealGem);
		
		// scrolls
		RegisterHelper.registerItems(fireballScroll);
		RegisterHelper.registerItems(frostbiteScroll);
		RegisterHelper.registerItems(etherealScroll);
		RegisterHelper.registerItems(radiationScroll);
		RegisterHelper.registerItems(elementalScroll);
		RegisterHelper.registerItems(voidScroll);
		
		// misc
		RegisterHelper.registerItems(staffBase);
		RegisterHelper.registerItems(frostRod);
		RegisterHelper.registerItems(frostDust);
		RegisterHelper.registerItems(golemGyro);
		
		// test
		RegisterHelper.registerItems(testItem);
	}
}