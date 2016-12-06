package com.collinriggs.avionics.blocks;

import javax.annotation.Nullable;

import com.collinriggs.avionics.recipe.WorkbenchCraftingManager;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;

public class ContainerAvionicTable extends Container {

    public InventoryCrafting craftMatrix; // = new InventoryCrafting(this, 3, 3);
    public IInventory craftResult = new InventoryCraftResult();
//    public ItemStackHandler bookSlot = new ItemStackHandler() {
//        @Override
//        public void setStackInSlot(int slot, ItemStack stack) {
//            if (false == ContainerAvionicTable.this.isValidBook(stack)) {
//                return;
//            }
//            super.setStackInSlot(slot, stack);
//            ContainerAvionicTable.this.onCraftMatrixChanged(ContainerAvionicTable.this.craftMatrix);
//        }
//
//        @Override
//        public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
//            if (false == ContainerAvionicTable.this.isValidBook(stack)) {
//                return stack;
//            }
//            ItemStack result = super.insertItem(slot, stack, simulate);
//            ContainerAvionicTable.this.onCraftMatrixChanged(ContainerAvionicTable.this.craftMatrix);
//            return result;
//        }
//    };
    private Slot bookSlot;

    private World worldObj;

    public ContainerAvionicTable(InventoryPlayer playerInventory, TileEntityAvionicTable workbench, World worldIn) {
        this.worldObj = worldIn;
        this.addSlotToContainer(this.bookSlot = new Slot(workbench, 0, 8, 35) {
            @Override
            public boolean isItemValid(@Nullable ItemStack stack) {
                return ContainerAvionicTable.this.isValidBook(stack);
            }
        });
        this.craftMatrix = new NewWorkbenchCraftingMatrix(workbench, 1, this, 3, 3);
        this.addSlotToContainer(new SlotCrafting(playerInventory.player, this.craftMatrix, this.craftResult, 0, 124, 35));

        for (int i = 0; i < 3; ++i) { //i = y
            for (int j = 0; j < 3; ++j) { //j = x
                this.addSlotToContainer(new Slot(this.craftMatrix, j + i * 3, 30 + j * 18, 17 + i * 18));
            }
        }

        for (int k = 0; k < 3; ++k) { //k = y
            for (int i1 = 0; i1 < 9; ++i1) { //i1 = x
                this.addSlotToContainer(new Slot(playerInventory, i1 + k * 9 + 9, 8 + i1 * 18, 84 + k * 18));
            }
        }

        for (int l = 0; l < 9; ++l) { //l = x
            this.addSlotToContainer(new Slot(playerInventory, l, 8 + l * 18, 142));
        }

        this.onCraftMatrixChanged(this.craftMatrix);

        // this.addSlotToContainer(new SlotItemHandler(this.bookSlot, 0, 8, 35));
    }

    private boolean isValidBook(ItemStack stack) {
        return (stack != null) && (stack.getItem() == Items.BOOK);
    }

    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;
    }

    public void onCraftMatrixChanged(IInventory inventoryIn) {

        ItemStack toCraft = null;

        if (this.isValidBook(this.bookSlot.getStack())) {

            // only handle custom recipes if we have a book
            toCraft = WorkbenchCraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj);
        }else if (toCraft == null)

        {
            // test for Vanilla Recipe
            toCraft = CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj);
        }

        this.craftResult.setInventorySlotContents(0, toCraft);

    }

    @Nullable
    @Override
    public Slot getSlotFromInventory(IInventory inv, int slotIn) {
        if (this.inventoryItemStacks == null) {
            getSlotFromInventory(inv, slotIn).inventory.clear();
        }
        return super.getSlotFromInventory(inv, slotIn);
    }

//    public void onContainerClosed(EntityPlayer playerIn) {
//        super.onContainerClosed(playerIn);
//
//        if (!this.worldObj.isRemote) {
//            for (int i = 0; i < 9; ++i) {
//                ItemStack itemstack = this.craftMatrix.removeStackFromSlot(i);
//
//                if (itemstack != null) {
//                    playerIn.dropItem(itemstack, false);
//                }
//            }
//            ItemStack bookStack = this.bookSlot.getStackInSlot(0);
//            if (bookStack != null) {
//                playerIn.dropItem(bookStack, false);
//            }
//        }
//    }

    @Nullable
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = null;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            //  0      : book
            //  1 -  9 : crafting grid
            // 10      : crafting result
            // 11 - 37 : inventory
            // 38 - 46 : hotbar

            if (index == 0) {
                if (!this.mergeItemStack(itemstack1, 11, 47, true)) {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (index >= 11 && index <= 37) {
                if (!this.mergeItemStack(itemstack1, 38, 47, true)) {
                    return null;
                }
            } else if (index >= 38 && index <= 46) {
                if (!this.mergeItemStack(itemstack1, 11, 38, false)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 11, 47, true)) {
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

    public boolean canMergeSlot(ItemStack stack, Slot slotIn) {
        return slotIn.inventory != this.craftResult && super.canMergeSlot(stack, slotIn);
    }
}