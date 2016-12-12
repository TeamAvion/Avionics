/*******************************************************************************
 * Copyright (c) TheDragonTeam 2016.
 ******************************************************************************/

package com.collinriggs.avionics.compat;

//import com.collinriggs.avionics.Constants;
import com.collinriggs.avionics.blocks.ContainerAvionicTable;
import com.collinriggs.avionics.blocks.GuiAvionicTable;
import com.collinriggs.avionics.blocks.ModBlocks;
import com.collinriggs.avionics.recipe.WorkbenchCraftingManager;
import mezz.jei.api.*;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;


import javax.annotation.Nonnull;

/**
 * Created by Deathly
 */
 /*
@JEIPlugin
public class AvionicsPlugin extends BlankModPlugin {

    @Override
    public void register(@Nonnull IModRegistry registry) {

        IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        IGuiHelper guiHelper = jeiHelpers.getGuiHelper();


        registry.addRecipeCategories( new AvionicRecipeCategory(guiHelper));

        registry.addRecipeClickArea(GuiAvionicTable.class, 88, 32, 28, 23, VanillaRecipeCategoryUid.CRAFTING);
        registry.addRecipeClickArea(GuiAvionicTable.class, 88, 32, 28, 23, Constants.AvionicRecipeCategoryUID);

        IRecipeTransferRegistry recipeTransferRegistry = registry.getRecipeTransferRegistry();

        recipeTransferRegistry.addRecipeTransferHandler(ContainerAvionicTable.class, VanillaRecipeCategoryUid.CRAFTING, 1, 9, 10, 36);
        recipeTransferRegistry.addRecipeTransferHandler(ContainerAvionicTable.class, Constants.AvionicRecipeCategoryUID, 1, 9, 10, 36);

        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.avionicTable), VanillaRecipeCategoryUid.CRAFTING);
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.avionicTable), Constants.AvionicRecipeCategoryUID);

        registry.addRecipes(WorkbenchCraftingManager.getInstance().getRecipeList());

        addDescription(registry, ModBlocks.avionicTable, "Custom recipes coming soon! Works as a normal Crafting Table for now!");
    }


    private void addDescription(@Nonnull IModRegistry registry, Item item, String description) {
        registry.addDescription(new ItemStack(item), description);
    }

    private void addDescription(@Nonnull IModRegistry registry, Block block, String description) {
        registry.addDescription(new ItemStack(block), description);
    }


}
*/
