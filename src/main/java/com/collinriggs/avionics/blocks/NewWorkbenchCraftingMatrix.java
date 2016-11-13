package com.collinriggs.avionics.blocks;

import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

/**
 * Created by CF on 2016-11-13.
 */
public class NewWorkbenchCraftingMatrix extends InventoryCrafting {
    private final IInventory inventory;
    private final int inventoryStartIndex;
    private final Container container;

    public NewWorkbenchCraftingMatrix(IInventory inventory, int inventoryStartIndex, Container eventHandlerIn, int width, int height) {
        super(eventHandlerIn, width, height);

        this.inventory = inventory;
        this.inventoryStartIndex = inventoryStartIndex;
        this.container = eventHandlerIn;
    }

    /**
     * Returns the number of slots in the inventory.
     */
    @Override
    public int getSizeInventory() {
        return super.getWidth() * super.getHeight();
    }

    /**
     * Returns the stack in the given slot.
     */
    @Override
    @Nullable
    public ItemStack getStackInSlot(int index) {
        return ((index < 0) || (index >= this.getSizeInventory()))
                ? null
                : this.inventory.getStackInSlot(this.inventoryStartIndex + index);
    }

    /**
     * Removes a stack from the given slot and returns it.
     */
    @Override
    public ItemStack removeStackFromSlot(int index) {
        ItemStack stack = this.getStackInSlot(index);
        if (stack != null) {
            this.inventory.setInventorySlotContents(this.inventoryStartIndex + index, null);
        }
        return stack;
    }

    /**
     * Removes up to a specified number of items from an inventory slot and returns them in a new stack.
     */
    @Override
    @Nullable
    public ItemStack decrStackSize(int index, int count)
    {
        ItemStack stackIn = this.getStackInSlot(index);
        ItemStack stack = (stackIn == null) ? null : stackIn.splitStack(count);
        if (stackIn.stackSize <= 0) {
            this.setInventorySlotContents(index, null);
        }

        if (stack != null) {
            this.container.onCraftMatrixChanged(this);
        }
        return stack;
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    @Override
    public void setInventorySlotContents(int index, @Nullable ItemStack stack) {
        if ((index >= 0) && (index < this.getSizeInventory())) {
            this.inventory.setInventorySlotContents(this.inventoryStartIndex + index, stack);
            this.container.onCraftMatrixChanged(this);
        }
    }
}
