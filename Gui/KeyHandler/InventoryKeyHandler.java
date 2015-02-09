package FizzyClubMods.Gui.KeyHandler;

import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;

public class InventoryKeyHandler extends KeyBindingRegistry.KeyHandler
{
  static KeyBinding InventoryKey = new KeyBinding("Cosplay Menu", 19);
  Player var2;
  EntityPlayer var3 = (EntityPlayer)this.var2;

  public InventoryKeyHandler() {
    super(new KeyBinding[] { InventoryKey }, new boolean[] { false });
  }

  public String getLabel()
  {
    return "Minelife";
  }

  public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
  {
  }

  public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd)
  {
    Minecraft mc = Minecraft.getMinecraft();
    GuiScreen current = mc.currentScreen;
    if (current == null)
    {
      ByteArrayOutputStream var4 = new ByteArrayOutputStream();
      DataOutputStream var5 = new DataOutputStream(var4);
      try
      {
        var5.writeInt(1);
        Packet250CustomPayload var6 = new Packet250CustomPayload("Minelife", var4.toByteArray());
        PacketDispatcher.sendPacketToServer(var6);
        System.out.println("Packet Open gui Send");
      }
      catch (IOException var7)
      {
        var7.printStackTrace();
      }
    }
  }

  public EnumSet<TickType> ticks()
  {
    return EnumSet.of(TickType.CLIENT);
  }
}