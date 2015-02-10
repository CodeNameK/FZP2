package FizzyClubMods.Gui.packet;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import FizzyClubMods.MainFizzyclubSlot;
import cpw.mods.fml.common.network.FMLNetworkHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class FizzyclubSlotPacketHandler
  implements IPacketHandler
{
  public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
  {
    if (packet.channel.equals("Minelife"))
    {
    	packetClient(packet, player);
    }
  }

  private void packetClient(Packet250CustomPayload packet, Player player)
  {
    DataInputStream dis = new DataInputStream(new ByteArrayInputStream(packet.data));

    EntityPlayer eplayer = (EntityPlayer)player;
    World world = eplayer.worldObj;
    int x = (int)eplayer.posX;
    int y = (int)eplayer.posY;
    int z = (int)eplayer.posZ;
    try
    {
      int packetType = dis.readInt();

      switch (packetType)
      {
      case 1:
        if (!world.isRemote)
        {
          FMLNetworkHandler.openGui(eplayer, MainFizzyclubSlot.instance, 1, world, x, y, z);
        }
        break;
      }
    }
    catch (Exception e)
    {
    }
  }
}