package FizzyClubMods.Block;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;

public class MinelifeBlock {

	public static Block pBlock;
	

	public static void init() {
		
	    pBlock = new MinelifeSign();
	    MinelifeBlock.addBlock(pBlock,"test", CreativeTabs.tabBlock);
	}

	

	private static void addBlock(Block block,String BlockName,CreativeTabs tabs) {
		
		LanguageRegistry.addName(block, BlockName);
		GameRegistry.registerBlock(block,BlockName);
	}

//	 private void registerMinelifeEntityClass(Class<? extends Entity> entityClass, String entityName, int eggColor, int eggDotsColor, String visibleName, int entityID)
//	  {
//	    LanguageRegistry.instance().addStringLocalization("entity.minelife." + entityName + ".name", "en_US", visibleName);
//	    EntityRegistry.registerModEntity(entityClass, entityName, entityID, instance, 128, 1, true);
//	    EntityList.IDtoClassMapping.put(Integer.valueOf(entityID), entityClass);
//	    EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityEggInfo(entityID, eggColor, eggDotsColor));
//	  }

}
