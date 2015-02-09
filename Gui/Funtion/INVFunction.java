package FizzyClubMods.Gui.Funtion;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import FizzyClubMods.Gui.Inv.MinelifeInv;

public class INVFunction
{
  public static void addEntry(String var1, MinelifeInv var2)
  {
    if ((MinecraftServer.getServer() != null) && (MinecraftServer.getServer().getConfigurationManager() != null))
    {
      EntityPlayerMP var3 = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(var1);
      try
      {
        if (var3 != null)
        {
          if (var3.getEntityData().hasKey("PlayerPersisted"))
          {
            var3.getEntityData().getCompoundTag("PlayerPersisted").setCompoundTag("MinelifeInv", var2.writeToNBT(new NBTTagCompound("MinelifeInv")));
          }
          else
          {
            var3.getEntityData().setCompoundTag("PlayerPersisted", new NBTTagCompound("PlayerPersisted"));
            var3.getEntityData().getCompoundTag("PlayerPersisted").setCompoundTag("MinelifeInv", var2.writeToNBT(new NBTTagCompound("MinelifeInv")));
          }
        }
      }
      catch (Throwable var5)
      {
        var5.printStackTrace();
      }
    }
  }

  public static MinelifeInv getInventory(String var1) {
	  MinelifeInv var2 = new MinelifeInv(var1);

    if ((MinecraftServer.getServer() != null) && (MinecraftServer.getServer().getConfigurationManager() != null))
    {
      EntityPlayerMP var3 = MinecraftServer.getServer().getConfigurationManager().getPlayerForUsername(var1);

      if (var3 != null)
      {
        if ((var3.getEntityData().hasKey("PlayerPersisted")) && (var3.getEntityData().getCompoundTag("PlayerPersisted").hasKey("MinelifeInv")))
        {
          var2.readFromNBT(var3.getEntityData().getCompoundTag("PlayerPersisted").getCompoundTag("MinelifeInv"));
        }
        else
        {
          if (!var3.getEntityData().hasKey("PlayerPersisted"))
          {
            var3.getEntityData().setCompoundTag("PlayerPersisted", new NBTTagCompound("PlayerPersisted"));
          }

          var3.getEntityData().getCompoundTag("PlayerPersisted").setCompoundTag("MinelifeInv", var2.writeToNBT(new NBTTagCompound()));
        }
      }
    }

    return var2;
  }
}