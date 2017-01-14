package com.collinriggs.avionics.blocks;

import com.collinriggs.avionics.blocks.designerblocks.*;
import com.collinriggs.avionics.test.SmallCrate;
import com.collinriggs.avionics.test.TileSmallCrate;
import com.collinriggs.avionics.test.TileTinyCrate;
import com.collinriggs.avionics.test.TinyCrate;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class ModBlocks {

    @Block @TileEntity(tileClass=TileSmallCrate.class, tileName="Small Crate")              public static SmallCrate smallCrate;
    @Block @TileEntity(tileClass=TileEntityAvionicTable.class, tileName="Avionic Table")    public static AvionicTable avionicTable;
    @Block @TileEntity(tileClass=TileTinyCrate.class, tileName="Tiny Crate")                public static TinyCrate tinyCrate;
    @Block public static PureWhite purewhite;
    @Block public static PureBlack pureblack;
    @Block public static PureGrey puregrey;
    @Block public static PureLightGrey purelightgrey;
    @Block public static PureBrown purebrown;
    @Block public static PureBlue pureblue;
    @Block public static PureLightBlue purelightblue;
    @Block public static PureRed purered;
    @Block public static PureOrange pureorange;
    @Block public static PureGreen puregreen;
    @Block public static PureLime purelime;
    @Block public static PureCyan purecyan;
    @Block public static PurePink purepink;
    @Block public static PurePurple purepurple;
    @Block public static PureYellow pureyellow;
    @Block public static PureMagenta puremagenta;
    @Block public static PureBlackLit pureblacklit;
    @Block public static PureBlueLit purebluelit;
    @Block public static PureBrownLit purebrownlit;
    @Block public static PureYellowLit pureyellowlit;
    @Block public static PureWhiteLit purewhitelit;
    @Block public static PureRedLit pureredlit;
    @Block public static PurePinkLit purepinklit;
    @Block public static PurePurpleLit purepurplelit;
    @Block public static PureOrangeLit pureorangelit;
    @Block public static PureMagentaLit puremagentalit;
    @Block public static PureLimeLit purelimelit;
    @Block public static PureLightGreyLit purelightgreylit;
    @Block public static PureLightBlueLit purelightbluelit;
    @Block public static PureGreyLit puregreylit;
    @Block public static PureGreenLit puregreenlit;
    @Block public static PureCyanLit purecyanlit;


    public static void init() {
        smallCrate = new SmallCrate();
        avionicTable = new AvionicTable();
        tinyCrate = new TinyCrate();
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
        // Initiate all models
        ArrayList<Class<? extends net.minecraft.tileentity.TileEntity>> reg = new ArrayList<>();
        Field[] f = ModBlocks.class.getDeclaredFields();
        for(Field f1 : f)
            if(f1.getAnnotation(Block.class)!=null)
                try {
                    f1.getType().getDeclaredMethod("initModel").invoke(f1.get(null));
                    TileEntity a = f1.getAnnotation(TileEntity.class);
                    if(a!=null && !reg.contains(a.tileClass())) {
                        GameRegistry.registerTileEntity(a.tileClass(), a.tileName());
                        reg.add(a.tileClass());
                    }
                } catch (Exception ignored) { }
    }

}
