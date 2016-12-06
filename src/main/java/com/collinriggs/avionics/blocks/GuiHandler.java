package com.collinriggs.avionics.blocks;

import com.collinriggs.avionics.test.GuiSmallCrate;
import com.collinriggs.avionics.test.GuiTinyCrate;
import com.collinriggs.avionics.test.SmallCrateContainer;
import com.collinriggs.avionics.test.TinyCrateContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.items.IItemHandler;

public class GuiHandler implements IGuiHandler {

    public static final int GUI_WORKBENCH = 1;
    public static final int GUI_TINYCHEST = 2;
    public static final int GUI_MINICHEST = 3;

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == GUI_WORKBENCH) {
            BlockPos pos = new BlockPos(x, y, z);
            TileEntity entity = world.getTileEntity(pos);
            if (entity instanceof TileEntityAvionicTable) {
                return new ContainerAvionicTable(player.inventory, (TileEntityAvionicTable)entity, world);
            }
        }
        if (id == GUI_TINYCHEST) {
            BlockPos pos = new BlockPos(x, y, z);
            TileEntity entity = world.getTileEntity(pos);
            if (entity instanceof IInventory) {
                return new TinyCrateContainer(player.inventory, (IInventory)entity); //, world);
            }
        }
        if (id == GUI_MINICHEST) {
            BlockPos pos = new BlockPos(x, y, z);
            TileEntity entity = world.getTileEntity(pos);
            if (entity instanceof IItemHandler) {
                return new SmallCrateContainer(player.inventory, (IInventory)entity); //, world);
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == GUI_WORKBENCH) {
            BlockPos pos = new BlockPos(x, y, z);
            TileEntity entity = world.getTileEntity(pos);
            if (entity instanceof TileEntityAvionicTable) {
                return new GuiAvionicTable(player.inventory, (TileEntityAvionicTable)entity, world);
            }
        }
        if (id == GUI_TINYCHEST) {
            TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));
            if (entity instanceof IInventory) {
                return new GuiTinyCrate(player.inventory, (IInventory) entity); // , world);
            }
        }
        if (id == GUI_MINICHEST) {
            TileEntity entity = world.getTileEntity(new BlockPos(x, y, z));
            if (entity instanceof IItemHandler) {
                return new GuiSmallCrate(player.inventory, (IInventory) entity); // , world);
            }
        }
        return null;
    }
}