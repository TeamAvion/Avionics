package com.collinriggs.avionics.blocks;

import com.collinriggs.avionics.test.GuiTinyChest;
import com.collinriggs.avionics.test.TinyChestContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    public static final int GUI_WORKBENCH = 1;
    public static final int GUI_TINYCHEST = 2;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUI_WORKBENCH) {
            return new ContainerNewWorkbench(player.inventory, world);
        }
        if (ID == GUI_TINYCHEST) {
            return new TinyChestContainer(player.inventory, world);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUI_WORKBENCH) {
            return new GuiNewWorkbench(player.inventory, world);
        }
        if (ID == GUI_TINYCHEST) {
            return new GuiTinyChest(player.inventory, world);
        }
        return null;
    }
}