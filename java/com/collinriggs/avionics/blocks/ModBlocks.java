package com.collinriggs.avionics.blocks;


import com.collinriggs.avionics.blocks.designerblocks.*;
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
    public static PureWhite purewhite;
    public static PureBlack pureblack;
    public static PureGrey puregrey;
    public static PureLightGrey purelightgrey;
    public static PureBrown purebrown;
    public static PureBlue pureblue;
    public static PureLightBlue purelightblue;
    public static PureRed purered;
    public static PureOrange pureorange;
    public static PureGreen puregreen;
    public static PureLime purelime;
    public static PureCyan purecyan;
    public static PurePink purepink;
    public static PurePurple purepurple;
    public static PureYellow pureyellow;
    public static PureMagenta puremagenta;


    public static void init() {
        newWorkbench = new NewCraftingTable();
        tinychest = new TinyChest();
        purewhite = new PureWhite();
        pureblack = new PureBlack();
        puregrey = new PureGrey();
        purelightgrey = new PureLightGrey();
        purebrown = new PureBrown();
        pureblue = new PureBlue();
        purelightblue = new PureLightBlue();
        purered = new PureRed();
        pureorange = new PureOrange();
        puregreen = new PureGreen();
        purelime = new PureLime();
        purecyan = new PureCyan();
        purepink = new PurePink();
        purepurple = new PurePurple();
        pureyellow = new PureYellow();
        puremagenta = new PureMagenta();
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        newWorkbench.initModel();
        tinychest.initModel();
        purewhite.initModel();
        pureblack.initModel();
        puregrey.initModel();
        purelightgrey.initModel();
        purebrown.initModel();
        pureblue.initModel();
        purelightblue.initModel();
        purered.initModel();
        pureorange.initModel();
        puregreen.initModel();
        purelime.initModel();
        purecyan.initModel();
        purepink.initModel();
        purepurple.initModel();
        pureyellow.initModel();
        puremagenta.initModel();
    }

}
