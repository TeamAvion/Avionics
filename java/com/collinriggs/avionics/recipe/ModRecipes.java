package com.collinriggs.avionics.recipe;

/**
 * Created by Deathly on 11/20/2016 at 1:09 AM.
 */
import com.collinriggs.avionics.Avionics;
import com.collinriggs.avionics.Items.ModItems;
import com.collinriggs.avionics.blocks.ModBlocks;
import com.collinriggs.avionics.utils.ModOreDict;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import static net.minecraft.init.Items.*;
import static net.minecraft.item.Item.getByNameOrId;
import static net.minecraftforge.fml.common.registry.GameRegistry.addRecipe;
import static net.minecraftforge.fml.common.registry.GameRegistry.addShapelessRecipe;
public class ModRecipes {

    public static void init() {
        addShapedRecipes();
        addShapelessRecipes();
    }

    private static void addShapelessRecipes() {
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.purewhite),Items.WATER_BUCKET,"colorBrick"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.purewhite),Items.POTIONITEM,"colorBrick"));
    }

    private static void addShapedRecipes() {
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.purewhite, 16),"xax","aya","xax",'a', ModItems.purifieddust,'y', Blocks.STONE);
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.purifieddust),"axa","xyx","axa",'x', Blocks.STONE,'y', Items.GLOWSTONE_DUST);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.pureblack, 8),"aaa","aya","aaa",'a', ModBlocks.purewhite,'y', Items.DYE);
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.purered, 8),"aaa","aya","aaa",'a', ModBlocks.purewhite,'y', new ItemStack(Items.DYE, 1, 1));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.puregreen, 8),"aaa","aya","aaa",'a', ModBlocks.purewhite,'y', new ItemStack(Items.DYE, 1, 2));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.purebrown, 8),"aaa","aya","aaa",'a', ModBlocks.purewhite,'y', new ItemStack(Items.DYE, 1, 3));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.pureblue, 8),"aaa","aya","aaa",'a', ModBlocks.purewhite,'y', new ItemStack(Items.DYE, 1, 4));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.purepurple, 8),"aaa","aya","aaa",'a', ModBlocks.purewhite,'y', new ItemStack(Items.DYE, 1, 5));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.purecyan, 8),"aaa","aya","aaa",'a', ModBlocks.purewhite,'y', new ItemStack(Items.DYE, 1, 6));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.purelightgrey, 8),"aaa","aya","aaa",'a', ModBlocks.purewhite,'y', new ItemStack(Items.DYE, 1, 7));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.puregrey, 8),"aaa","aya","aaa",'a', ModBlocks.purewhite,'y', new ItemStack(Items.DYE, 1, 8));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.purepink, 8),"aaa","aya","aaa",'a', ModBlocks.purewhite,'y', new ItemStack(Items.DYE, 1, 9));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.purelime, 8),"aaa","aya","aaa",'a', ModBlocks.purewhite,'y', new ItemStack(Items.DYE, 1, 10));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.pureyellow, 8),"aaa","aya","aaa",'a', ModBlocks.purewhite,'y', new ItemStack(Items.DYE, 1, 11));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.purelightblue, 8),"aaa","aya","aaa",'a', ModBlocks.purewhite,'y', new ItemStack(Items.DYE, 1, 12));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.puremagenta, 8),"aaa","aya","aaa",'a', ModBlocks.purewhite,'y', new ItemStack(Items.DYE, 1, 13));
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.pureorange, 8),"aaa","aya","aaa",'a', ModBlocks.purewhite,'y', new ItemStack(Items.DYE, 1, 14));
        if (Avionics.enableTableRecipe == true) {
            GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.newWorkbench),"aaa","byb","bbb",'a', Blocks.QUARTZ_BLOCK,'b', Blocks.LAPIS_BLOCK, 'y', Blocks.CRAFTING_TABLE);
        }
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.tinychest),"aaa","axa","aaa",'a', new ItemStack(Items.DYE, 1, 4));


    }
}