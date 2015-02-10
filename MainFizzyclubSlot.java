package FizzyClubMods;

import FizzyClubMods.Block.MinelifeBlock;
import FizzyClubMods.Gui.FizzyclubSlotGuiHandler;
import FizzyClubMods.Gui.packet.FizzyclubSlotPacketHandler;
import FizzyClubMods.Items.FizzyclubArmor;
import FizzyClubMods.Proxy.FizzyclubServer;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;


@Mod(modid = MainFizzyclubSlot.ModID , name = MainFizzyclubSlot.Name , version = MainFizzyclubSlot.Version )
@NetworkMod(clientSideRequired = true , serverSideRequired=true, packetHandler= FizzyclubSlotPacketHandler.class, channels={"Minelife"})
public class MainFizzyclubSlot {

	@Mod.Instance("MainMinelife")
	public static MainFizzyclubSlot instance;
	public static final String ModID = "MainMinelife";
	public static final String Name = "MinelifeMod";
	public static final String Version = "Beta";
	
	@SidedProxy(clientSide = "FizzyClubMods.Proxy.FizzyclubClient",serverSide = "FizzyClubMods.Proxy.FizzyclubServer")
	public static FizzyclubServer proxy;
	
	
	
	@EventHandler
	public void load (FMLInitializationEvent event){
		MinelifeBlock.init();
	    proxy.renderPlayer();
	    proxy.registerKeyhandler();
		NetworkRegistry.instance().registerGuiHandler(instance, new FizzyclubSlotGuiHandler());
		FizzyclubArmor.registerWing();
		FizzyclubArmor.registerBuff();
	}
}
