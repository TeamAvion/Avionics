package com.collinriggs.avionics.blocks;


<<<<<<< HEAD
import com.collinriggs.avionics.blocks.designerblocks.*;
=======
>>>>>>> refs/remotes/origin/master
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
    public static PureBlackLit pureblacklit;
    public static PureBlueLit purebluelit;
    public static PureBrownLit purebrownlit;
    public static PureYellowLit pureyellowlit;
    public static PureWhiteLit purewhitelit;
    public static PureRedLit pureredlit;
    public static PurePinkLit purepinklit;
    public static PurePurpleLit purepurplelit;
    public static PureOrangeLit pureorangelit;
    public static PureMagentaLit puremagentalit;
    public static PureLimeLit purelimelit;
    public static PureLightGreyLit purelightgreylit;
    public static PureLightBlueLit purelightbluelit;
    public static PureGreyLit puregreylit;
    public static PureGreenLit puregreenlit;
    public static PureCyanLit purecyanlit;


    public static void init() {
        newWorkbench = new NewCraftingTable();
        tinychest = new TinyChest();
        //Colors
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
        //Lit Colors
        pureblacklit = new PureBlackLit();
        purebrownlit = new PureBrownLit();
        purebluelit = new PureBlueLit();
        purelightbluelit = new PureLightBlueLit();
        purelightgreylit = new PureLightGreyLit();
        pureorangelit = new PureOrangeLit();
        purepinklit = new PurePinkLit();
        purepurplelit = new PurePurpleLit();
        purecyanlit = new PureCyanLit();
        purelimelit = new PureLimeLit();
        puregreenlit = new PureGreenLit();
        pureredlit = new PureRedLit();
        purewhitelit = new PureWhiteLit();
        puregreylit = new PureGreyLit();
        pureyellowlit = new PureYellowLit();
        puremagentalit = new PureMagentaLit();

    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        newWorkbench.initModel();
        tinychest.initModel();
        //Colors
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
        //Lit Colors
        pureblacklit.initModel();
        puremagentalit.initModel();
        pureyellowlit.initModel();
        purebluelit.initModel();
        puregreenlit.initModel();
        purebrownlit.initModel();
        purecyanlit.initModel();
        purelightbluelit.initModel();
        puregreylit.initModel();
        purelightgreylit.initModel();
        purepinklit.initModel();
        pureorangelit.initModel();
        purewhitelit.initModel();
        purelimelit.initModel();
        pureredlit.initModel();
        purepurplelit.initModel();
    }

}
