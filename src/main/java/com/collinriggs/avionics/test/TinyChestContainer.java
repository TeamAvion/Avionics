package com.collinriggs.avionics.test;

/**
 * Created by Deathly on 11/12/2016.
 */

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class TinyChestContainer extends Container {
//
//    public ItemStackHandler itemSlot = new ItemStackHandler() {
//        @Override
//        public void setStackInSlot(int slot, ItemStack stack) {
//            super.setStackInSlot(slot, stack);
//        }
//
//        @Override
//        public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
//            ItemStack result = super.insertItem(slot, stack, simulate);
//            return result;
//        }
//    };

    private World worldObj;

    public TinyChestContainer(InventoryPlayer playerInventory, IInventory chestInventory, World worldIn) {
        this.worldObj = worldIn;
        this.addSlotToContainer(new Slot(chestInventory, 0, 80, 34));
        for (int k = 0; k < 3; ++k) { //k = y
            for (int i1 = 0; i1 < 9; ++i1) { //i1 = x
                this.addSlotToContainer(new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
            }
        }

        for (int l = 0; l < 9; ++l) { //l = x
            this.addSlotToContainer(new Slot(playerInventory, l, 8 + l * 18, 142));
        }
    }

    private boolean isValidBook(ItemStack stack) {
        return (stack != null) && (stack.getItem() == Items.BOOK);
    }

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

    @Nullable
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 0) {
                if (!this.mergeItemStack(itemstack1, 10, 46, true)) {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (index >= 10 && index < 37) {
                if (!this.mergeItemStack(itemstack1, 37, 46, false)) {
                    return null;
                }
            } else if (index >= 37 && index < 46) {
                if (!this.mergeItemStack(itemstack1, 10, 37, false)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 10, 46, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack) null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(playerIn, itemstack1);
        }

        return itemstack;
    }

//    public boolean canMergeSlot(ItemStack stack, Slot slotIn) {
//        return slotIn.inventory != this.itemSlot && super.canMergeSlot(stack, slotIn);
//    }
}

