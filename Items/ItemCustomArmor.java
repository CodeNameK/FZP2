package FizzyClubMods.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemCustomArmor extends Item
{
  private final int[] maxDamageArray = { 30, 20, 50, 20, 30, 30 };
  public int armortype;
  public int renderindex;
  private String Name;

  @SideOnly(Side.CLIENT)
  public void registerIcons(IconRegister par1IconRegister)
  {
    String getnameicon = getUnlocalizedName().substring(getUnlocalizedName().lastIndexOf(".") + 1);
    this.itemIcon = par1IconRegister.registerIcon("WaterWorld:" + getnameicon);
  }

  public ItemCustomArmor(int par1, int par2, int par3, String par4) {
    super(par1);
    this.armortype = par2;
    this.maxStackSize = 1;
    setCreativeTab(CreativeTabs.tabCombat);
    setMaxDamage(par3);
    this.Name = par4;
  }
  public void armorEffects(ItemStack var1, EntityPlayer var2) {
  }
  public void effectSwitch(int var1, EntityPlayer var2, ItemStack var3) {
  }
  public void getMilkEffect(ItemStack var1, int var2, EntityPlayer var3) {
  }
  public void healWeapon(EntityPlayer var1, int var2) {
  }

  int[] getMaxDamageArray() {
    return this.maxDamageArray;
  }

  public void addInformation(ItemStack var1, EntityPlayer var2, List var3, boolean var4)
  {
  }

  public String toString()
  {
    return this.Name;
  }
}