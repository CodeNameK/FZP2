package FizzyClubMods.Gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import FizzyClubMods.Gui.Con.InventoryContainer;
import FizzyClubMods.Gui.Funtion.INVFunction;
import FizzyClubMods.Gui.Inv.MinelifeInv;
import cpw.mods.fml.common.network.IGuiHandler;

public class FizzyclubSlotGuiHandler
implements IGuiHandler
{
public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
{
  if (ID == 1)
  {
    return new InventoryContainer(player, INVFunction.getInventory(player.username));
  }
  return null;
}

public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
{
  if (ID == 1)
  {
    return new GuiInventory(player, new MinelifeInv(player.username));
  }
  return null;
}
}