package FizzyClubMods;

import FizzyClubMods.Block.MinelifeBlock;
import FizzyClubMods.Gui.MinelifeGuiHandler;
import FizzyClubMods.Gui.packet.MinelifePacketHandler;
import FizzyClubMods.Items.MinelifeArmor;
import FizzyClubMods.Proxy.MinelifeServer;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;


@Mod(modid = MainMinelife.ModID , name = MainMinelife.Name , version = MainMinelife.Version )
@NetworkMod(clientSideRequired = true , serverSideRequired=true, packetHandler= MinelifePacketHandler.class, channels={"Minelife"})
public class MainMinelife {

	@Mod.Instance("MainMinelife")
	public static MainMinelife instance;
	public static final String ModID = "MainMinelife";
	public static final String Name = "MinelifeMod";
	public static final String Version = "Beta";
	
	@SidedProxy(clientSide = "MinelifeMod.Proxy.MinelifeClient",serverSide = "MinelifeMod.Proxy.MinelifeServer")
	public static MinelifeServer proxy;
	
	
	
	@EventHandler
	public void load (FMLInitializationEvent event){
		MinelifeBlock.init();
	    proxy.renderPlayer();
	    proxy.registerKeyhandler();
		NetworkRegistry.instance().registerGuiHandler(instance, new MinelifeGuiHandler());
		MinelifeArmor.registerWing();
		MinelifeArmor.registerBuff();
	}
}
