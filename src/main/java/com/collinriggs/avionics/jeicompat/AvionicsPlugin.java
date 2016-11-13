/*******************************************************************************
 * Copyright (c) TheDragonTeam 2016.
 ******************************************************************************/

package com.collinriggs.avionics.jeicompat;

import com.collinriggs.avionics.Constants;
import com.collinriggs.avionics.blocks.ContainerNewWorkbench;
import com.collinriggs.avionics.blocks.GuiNewWorkbench;
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
@JEIPlugin
public class AvionicsPlugin extends BlankModPlugin {

    public static IJeiHelpers jeiHelper;

    @Override
    public void register(@Nonnull IModRegistry registry) {
        jeiHelper = registry.getJeiHelpers();


        registry.addRecipeCategories(
                new WorkbenchRecipeCategory()
        );

        registry.addRecipeClickArea(GuiNewWorkbench.class, 88, 32, 28, 23, VanillaRecipeCategoryUid.CRAFTING);

        IRecipeTransferRegistry recipeTransferRegistry = registry.getRecipeTransferRegistry();

        recipeTransferRegistry.addRecipeTransferHandler(ContainerNewWorkbench.class, VanillaRecipeCategoryUid.CRAFTING, 1, 9, 10, 36);

        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.newWorkbench), VanillaRecipeCategoryUid.CRAFTING);

        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.newWorkbench), Constants.Compat.JEI_CATEGORY_WORKBENCH);

        registry.addRecipes(WorkbenchCraftingManager.getInstance().getRecipeList());

        addDescription(registry, ModBlocks.newWorkbench, "Custom recipes coming soon! Works as a normal Crafting Table for now!");
    }


    private void addDescription(@Nonnull IModRegistry registry, Item item, String description) {
        registry.addDescription(new ItemStack(item), description);
    }

    private void addDescription(@Nonnull IModRegistry registry, Block block, String description) {
        registry.addDescription(new ItemStack(block), description);
    }


}