package FizzyClubMods.Gui.Con;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import FizzyClubMods.Gui.Funtion.INVFunction;
import FizzyClubMods.Gui.Inv.MinelifeInv;
import FizzyClubMods.Gui.Slot.SlotArmor;
import FizzyClubMods.Gui.Slot.SlotCustomArmor;

public class InventoryContainer extends Container {
	
	
	MinelifeInv inventory;
	public InventoryContainer(EntityPlayer entityplayer, MinelifeInv inv) {
		int var3;
		int var4;

		addSlotToContainer(new SlotCustomArmor(inv, 0, 80, 10, entityplayer));
		addSlotToContainer(new SlotCustomArmor(inv, 1, 80, 60, entityplayer));

		for (var3 = 0; var3 < 4; ++var3) {
			addSlotToContainer(new SlotArmor(entityplayer, inv,
					inv.getSizeInventory() - 1 - var3, 8, 8 + var3 * 18, var3));
		}
		for (var3 = 0; var3 < 9; var3++) {
			addSlotToContainer(new Slot(entityplayer.inventory, var3,
					8 + var3 * 18, 142));
		}
		for (var3 = 0; var3 < 3; var3++) {
			for (var4 = 0; var4 < 9; var4++) {
				addSlotToContainer(new Slot(entityplayer.inventory, var4 + var3
						* 9 + 9, 8 + var4 * 18, 84 + var3 * 18));
				// addSlotToContainer(new Slot(entityplayer.inventory, var4 +
				// (var3 + 1) * 9, 9 + var4 * 18, 108 + var3 * 18));
			}
		}
		if (inv == null) {
			inv = INVFunction.getInventory(entityplayer.username);
		}

		if (isPlayerNotUsingContainer(entityplayer)) {
			setPlayerIsPresent(entityplayer, true);
		}
		this.inventory = inv;
	}
	

	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}

	
}