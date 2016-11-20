package com.collinriggs.avionics.blocks;


import com.collinriggs.avionics.test.TinyChest;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    public static NewCraftingTable newWorkbench;
    public static TinyChest tinychest;

    public static void init() {
        newWorkbench = new NewCraftingTable();
        tinychest = new TinyChest();
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        newWorkbench.initModel();
        tinychest.initModel();
    }

}
