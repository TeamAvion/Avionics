package com.collinriggs.avionics.blocks;

import com.collinriggs.avionics.Avionics;
import com.collinriggs.avionics.test.GuiTinyChest;
import com.collinriggs.avionics.test.TinyChestContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    public static final int GUI_WORKBENCH = 1;
    public static final int GUI_TINYCHEST = 2;

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == GUI_WORKBENCH) {
            BlockPos pos = new BlockPos(x, y, z);
            TileEntity entity = world.getTileEntity(pos);
            if (entity instanceof TileEntityNewWorkbench) {
                return new ContainerNewWorkbench(player.inventory, (TileEntityNewWorkbench)entity, world);
            }
        }
        if (id == GUI_TINYCHEST) {
            BlockPos pos = new BlockPos(x, y, z);
            TileEntity entity = world.getTileEntity(pos);
            if (entity instanceof IInventory) {
                return new TinyChestContainer(player.inventory, (IInventory)entity); //, world);
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == GUI_WORKBENCH) {
            BlockPos pos = new BlockPos(x, y, z);
            TileEntity entity = world.getTileEntity(pos);
            if (entity instanceof TileEntityNewWorkbench) {
                return new GuiNewWorkbench(player.inventory, (TileEntityNewWorkbench)entity, world);
            }
        }
        if (id == GUI_TINYCHEST) {
            TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));
            if (entity instanceof IInventory) {
                return new GuiTinyChest(player.inventory, (IInventory) entity); // , world);
            }
        }
        return null;
    }
}