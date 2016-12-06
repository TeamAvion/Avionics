package com.collinriggs.avionics.test;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

/**
 * Created by Deathly on 12/4/2016 at 5:00 AM.
 */
public class SmallCrateContainer extends Container {

    public ItemStackHandler itemSlot = new ItemStackHandler() {
        @Override
        public void setStackInSlot(int slot, ItemStack stack) {
            super.setStackInSlot(slot, stack);
        }

        @Override
        public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
            ItemStack result = super.insertItem(slot, stack, simulate);
            return result;
        }
    };


    private World worldObj;

    public SmallCrateContainer(InventoryPlayer playerInventory, IInventory chestInventory/* , World worldIn */) {
        // this.worldObj = worldIn;
        //this.addSlotToContainer(new Slot(chestInventory, 0, 80, 34));
        for (int k = 0; k < 3; ++k) { //k = y
            for (int i1 = 0; i1 < 5; ++i1) { //i1 = x
                this.addSlotToContainer(new Slot(chestInventory, i1 + k * 5 , 44 + i1 * 18, 21 + k * 18));
            }
        }
        for (int k = 0; k < 3; ++k) { //k = y
            for (int i1 = 0; i1 < 9; ++i1) { //i1 = x
                this.addSlotToContainer(new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 92 + k * 18));
            }
        }

        for (int l = 0; l < 9; ++l) { //l = x
            this.addSlotToContainer(new Slot(playerInventory, l, 8 + l * 18, 150));
        }
    }
    /**
     * il + k * 9 + 9 =>(column) + (row) * (total columns) + (start index)
     * 8 + i1 * 18 => (start x) + (column) * (slot width)
     * 84 + k * 18 => (start y) + (row) * (slot height)
     */

    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

    @Nullable
    @Override
    public Slot getSlotFromInventory(IInventory inv, int slotIn) {
        if (this.inventoryItemStacks == null) {
            getSlotFromInventory(inv, slotIn).inventory.clear();
        }
        return super.getSlotFromInventory(inv, slotIn);
    }

    public void onContainerClosed(EntityPlayer playerIn) {
    }

    @Override
    @Nullable
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = null;
        Slot slot = this.inventorySlots.get(index);

        if ((slot != null) && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < 15) {
                if (!this.mergeItemStack(itemstack1, 15, this.inventorySlots.size(), true)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, 15, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }
}
