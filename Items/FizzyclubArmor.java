package FizzyClubMods.Items;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FizzyclubArmor {
	
	public static int ItemID = 3500;
	
	
	  public static Item Wing1;
	  public static Item Wing2;
	  
	  public static Item Buff1;

	  public static void registerWing()
	  {
	    Wing1 = new ItemCustomArmor(ItemID++, 0, 0, "").setUnlocalizedName("Wing1").setCreativeTab(CreativeTabs.tabCombat);
	    LanguageRegistry.addName(Wing1, "§6Wing 1FF");
	    Wing2 = new ItemCustomArmor(ItemID++, 0, 0, "").setUnlocalizedName("Wing2").setCreativeTab(CreativeTabs.tabCombat);
	    LanguageRegistry.addName(Wing2, "§6Wing FF2");
	  }
	  
	  public static void registerBuff(){
		  
		  Buff1 = new ItemCustomArmor(ItemID++, 1, 1, "").setCreativeTab(CreativeTabs.tabCombat);
		  LanguageRegistry.addName(Buff1, "§6Buff 1");
	  }
	  
}
