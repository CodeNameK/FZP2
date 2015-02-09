package FizzyClubMods.Gui.Inv;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import FizzyClubMods.Gui.Funtion.INVFunction;

public class MinelifeInv implements IInventory {
	
	
	public ItemStack[] ArmorSlots = new ItemStack[8];
	public String playername;

	public MinelifeInv(String name) {
		playername = name;
	}

	public ItemStack getWing() {
		return this.ArmorSlots[0];
	}

	public ItemStack getBuff() {
		return this.ArmorSlots[1];
	}

	public int getSizeInventory() {
		return this.ArmorSlots.length;
	}

	public ItemStack getStackInSlot(int i) {
		return (i >= 0) && (i < this.ArmorSlots.length) ? this.ArmorSlots[i]: null;
	}

	public ItemStack decrStackSize(int i, int j) {
		if (this.ArmorSlots[i] != null) {
			if (this.ArmorSlots[i].stackSize <= j) {
				ItemStack var3 = this.ArmorSlots[i];
				this.ArmorSlots[i] = null;
				return var3;
			}

			ItemStack var3 = this.ArmorSlots[i].splitStack(j);

			if (this.ArmorSlots[i].stackSize == 0) {
				this.ArmorSlots[i] = null;
			}

			return var3;
		}

		return null;
	}

	public ItemStack getStackInSlotOnClosing(int i) {
		INVFunction.addEntry(this.playername, this);
		return null;
	}

	public void setInventorySlotContents(int i, ItemStack itemstack) {
		this.ArmorSlots[i] = itemstack;
		INVFunction.addEntry(this.playername, this);
	}

	public String getInvName() {
		return "Minelifeinventory";
	}

	public boolean isInvNameLocalized() {
		return false;
	}

	public int getInventoryStackLimit() {
		return 1;
	}

	public void onInventoryChanged() {
	}

	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		EntityPlayerMP var2 = MinecraftServer.getServer()
				.getConfigurationManager()
				.getPlayerForUsername(this.playername);
		return !var2.isDead;
	}

	public void openChest() {
	}

	public void closeChest() {
	}

	public NBTTagCompound writeToNBT(NBTTagCompound var1) {
		NBTTagList var2 = new NBTTagList();

		for (int var3 = 0; var3 < this.ArmorSlots.length; var3++) {
			if (this.ArmorSlots[var3] != null) {
				NBTTagCompound var4 = new NBTTagCompound();
				var4.setByte("SlotNum", (byte) var3);

				if (var3 == 6) {
					System.out.println("writing...");
				}

				this.ArmorSlots[var3].writeToNBT(var4);
				var2.appendTag(var4);
			}
		}

		var1.setTag("Slot", var2);
		return var1;
	}

	public void readFromNBT(NBTTagCompound var1) {
		NBTTagList var2 = var1.getTagList("Slot");
		this.ArmorSlots = new ItemStack[getSizeInventory()];

		for (int var3 = 0; var3 < var2.tagCount(); var3++) {
			NBTTagCompound var4 = (NBTTagCompound) var2.tagAt(var3);
			byte var5 = var4.getByte("SlotNum");

			if ((var5 >= 0) && (var5 < this.ArmorSlots.length)) {
				try {
					this.ArmorSlots[var5] = ItemStack
							.loadItemStackFromNBT(var4);
				} catch (Throwable var7) {
					var7.printStackTrace();
				}
			}
		}

		INVFunction.addEntry(this.playername, this);
	}

	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}

}