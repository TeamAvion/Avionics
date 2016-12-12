package com.collinriggs.avionics.compat;

//import com.collinriggs.avionics.Constants;
import com.collinriggs.avionics.Items.ModItems;
import com.collinriggs.avionics.blocks.ContainerAvionicTable;
import com.collinriggs.avionics.blocks.GuiAvionicTable;
import com.collinriggs.avionics.blocks.ModBlocks;
import com.collinriggs.avionics.recipe.WorkbenchCraftingManager;
import mezz.jei.api.*;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.item.ItemStack;

/**
 * Created by Deathly on 12/12/2016 at 12:48 PM.
 */
@JEIPlugin
public class AvionPlugin implements IModPlugin {
    @Override
    public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry) {

    }

    @Override
    public void registerIngredients(IModIngredientRegistration registry) {

    }

    @Override
    public void register(IModRegistry registry) {

        IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        IGuiHelper guiHelper = jeiHelpers.getGuiHelper();


        registry.addRecipeCategories( new AvionCategory(guiHelper));

        registry.addRecipeClickArea(GuiAvionicTable.class, 88, 32, 28, 23, VanillaRecipeCategoryUid.CRAFTING);
        registry.addRecipeClickArea(GuiAvionicTable.class, 88, 32, 28, 23, AvionUID.CRAFTING);

        IRecipeTransferRegistry recipeTransferRegistry = registry.getRecipeTransferRegistry();

        recipeTransferRegistry.addRecipeTransferHandler(ContainerAvionicTable.class, VanillaRecipeCategoryUid.CRAFTING, 2, 9, 10, 36);
        recipeTransferRegistry.addRecipeTransferHandler(ContainerAvionicTable.class, AvionUID.CRAFTING, 2, 9, 10, 36);

        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.avionicTable), VanillaRecipeCategoryUid.CRAFTING);
        registry.addRecipeCategoryCraftingItem(new ItemStack(ModBlocks.avionicTable), AvionUID.CRAFTING);

        registry.addRecipes(WorkbenchCraftingManager.getInstance().getRecipeList());

        //addDescription(registry, ModBlocks.avionicTable, "Custom recipes coming soon! Works as a normal Crafting Table for now!");
       // IJeiHelpers helpers = registry.getJeiHelpers();
        //IItemBlacklist blacklist = helpers.getItemBlacklist();

       // blacklist.addItemToBlacklist(new ItemStack(ModBlocks.pureblacklit));
       // blacklist.addItemToBlacklist(new ItemStack(ModBlocks.purebrownlit));
       // blacklist.addItemToBlacklist(new ItemStack(ModBlocks.purebluelit));
       // blacklist.addItemToBlacklist(new ItemStack(ModBlocks.puremagentalit));
       // blacklist.addItemToBlacklist(new ItemStack(ModBlocks.purepinklit));
       // blacklist.addItemToBlacklist(new ItemStack(ModBlocks.purepurplelit));
       // blacklist.addItemToBlacklist(new ItemStack(ModBlocks.pureredlit));
       // blacklist.addItemToBlacklist(new ItemStack(ModBlocks.pureorangelit));
       // blacklist.addItemToBlacklist(new ItemStack(ModBlocks.purewhitelit));
       // blacklist.addItemToBlacklist(new ItemStack(ModBlocks.puregreenlit));
       // blacklist.addItemToBlacklist(new ItemStack(ModBlocks.puregreylit));
       // blacklist.addItemToBlacklist(new ItemStack(ModBlocks.purelightbluelit));
       // blacklist.addItemToBlacklist(new ItemStack(ModBlocks.purelightgreylit));
       // blacklist.addItemToBlacklist(new ItemStack(ModBlocks.purelimelit));
       // blacklist.addItemToBlacklist(new ItemStack(ModBlocks.purecyanlit));
       //blacklist.addItemToBlacklist(new ItemStack(ModBlocks.pureyellowlit));
       // blacklist.addItemToBlacklist(new ItemStack(ModItems.TAvionLogo));
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {

    }
}
