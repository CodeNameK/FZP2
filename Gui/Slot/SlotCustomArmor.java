package FizzyClubMods.Gui.Slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import FizzyClubMods.Gui.Funtion.INVFunction;
import FizzyClubMods.Gui.Inv.MinelifeInv;
import FizzyClubMods.Items.ItemCustomArmor;

public class SlotCustomArmor extends Slot
{
  public int type;
  public EntityPlayer player;

  public SlotCustomArmor(MinelifeInv inv, int var2, int var3, int var4, EntityPlayer var5)
  {
    super(inv, var2, var3, var4);
    this.player = var5;
    this.type = var2;
  }

  public int getSlotStackLimit()
  {
    return 1;
  }

  public boolean isItemValid(ItemStack var1) {
    if (var1 == null)
    {
      return true;
    }
    if ((var1.getItem() instanceof ItemCustomArmor))
    {
    	ItemCustomArmor var2 = (ItemCustomArmor)var1.getItem();

      switch (this.type)
      {
      case 0:
        if (var2.armortype == 0)
        {
          return true;
        }

        return false;
      case 1:
        if (var2.armortype == 1)
        {
          return true;
        }

        return false;
      case 2:
        if (var2.armortype == 2)
        {
          return true;
        }

        return false;
      case 3:
        if (var2.armortype == 3)
        {
          return true;
        }

        return false;
      case 4:
        if (var2.armortype == 4)
        {
          return true;
        }

        return false;
      case 5:
        if (var2.armortype == 5)
        {
          return true;
        }

        return false;
      case 6:
        if (var2.armortype == 6)
        {
          return true;
        }

        return false;
      case 7:
        if (var2.armortype == 7)
        {
          return true;
        }
        return false;
      }

      System.out.println("Unknown Item type:" + this.type);
      return false;
    }

    return false;
  }
  public boolean canTakeStack(EntityPlayer var1)
  {
    this.player = var1;
    return super.canTakeStack(var1);
  }

  public void putStack(ItemStack var1) {
    if (this.inventory != null)
    {
      this.inventory.setInventorySlotContents(this.type, var1);
    }

    onSlotChanged();
  }

  public void onSlotChanged() {
    INVFunction.addEntry(this.player.username, (MinelifeInv)this.inventory);
    super.onSlotChanged();
  }
}