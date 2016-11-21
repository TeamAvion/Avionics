package com.collinriggs.avionics.utils;

import com.collinriggs.avionics.blocks.ModBlocks;
import net.minecraft.item.ItemStack;

import static net.minecraftforge.oredict.OreDictionary.WILDCARD_VALUE;
import static net.minecraftforge.oredict.OreDictionary.registerOre;
/**
 * Created by Deathly on 11/20/2016 at 3:46 AM.
 */
public class ModOreDict {
    public static void registerOeDictEntries() {
        registerOre("colorBrick", new ItemStack(ModBlocks.pureblue, 1));
        registerOre("colorBrick", new ItemStack(ModBlocks.purered, 1));
        registerOre("colorBrick", new ItemStack(ModBlocks.puregrey, 1));
        registerOre("colorBrick", new ItemStack(ModBlocks.pureyellow, 1));
        registerOre("colorBrick", new ItemStack(ModBlocks.puregreen, 1));
        registerOre("colorBrick", new ItemStack(ModBlocks.purebrown, 1));
        registerOre("colorBrick", new ItemStack(ModBlocks.purecyan, 1));
        registerOre("colorBrick", new ItemStack(ModBlocks.purelime, 1));
        registerOre("colorBrick", new ItemStack(ModBlocks.purepurple, 1));
        registerOre("colorBrick", new ItemStack(ModBlocks.purepink, 1));
        registerOre("colorBrick", new ItemStack(ModBlocks.pureorange, 1));
        registerOre("colorBrick", new ItemStack(ModBlocks.purewhite, 1));
        registerOre("colorBrick", new ItemStack(ModBlocks.pureblack, 1));
        registerOre("colorBrick", new ItemStack(ModBlocks.puremagenta, 1));
        registerOre("colorBrick", new ItemStack(ModBlocks.purelightblue, 1));
        registerOre("colorBrick", new ItemStack(ModBlocks.purelightgrey, 1));
    }
}
