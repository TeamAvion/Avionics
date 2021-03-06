package com.collinriggs.avionics.compat;

//import com.collinriggs.avionics.Constants;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.ICraftingGridHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeCategory;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.wrapper.ICraftingRecipeWrapper;
import mezz.jei.api.recipe.wrapper.IShapedCraftingRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

//import static com.collinriggs.avionics.Constants.AvionicRecipeCategoryUID;


/**
 * Created by Deathly on 11/27/2016 at 6:20 PM.
 */
/*(
 public class AvionicRecipeCategory extends BlankRecipeCategory<ICraftingRecipeWrapper> {

    public static final int width = 144;
    public static final int height = 60;
    private static final int craftOutputSlot = 0;
    private static final int craftInputSlot1 = 1;

    private final IDrawable background;
    private final ICraftingGridHelper craftingGridHelper;

    public AvionicRecipeCategory(IGuiHelper iGuiHelper){
        final ResourceLocation GUI_AVIONIC = new ResourceLocation("avionics:textures/gui/container/gui_workbench.png");
        craftingGridHelper = iGuiHelper.createCraftingGridHelper(craftInputSlot1, craftOutputSlot);
        background = iGuiHelper.createDrawable(GUI_AVIONIC, 4,13,144,60);
    }


    @Override
    public String getUid() {
        return AvionicRecipeCategoryUID;
    }


    @Override
    public String getTitle() {
        return ("Avionic Crafting");
    }


    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public void drawExtras(@Nonnull Minecraft minecraft) {

    }

    @Override
    public void drawAnimations(@Nonnull Minecraft minecraft) {

    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, ICraftingRecipeWrapper recipeWrapper, IIngredients ingredients) {
        IGuiItemStackGroup guiItemStacks = recipeLayout.getItemStacks();

        guiItemStacks.init(craftOutputSlot, false, 94, 18);

        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 3; ++x) {
                int index = craftInputSlot1 + x + (y * 3);
                guiItemStacks.init(index, true, x * 18, y * 18);
            }
        }

        if (recipeWrapper instanceof IShapedCraftingRecipeWrapper) {
            IShapedCraftingRecipeWrapper wrapper = (IShapedCraftingRecipeWrapper) recipeWrapper;
            craftingGridHelper.setInput(guiItemStacks, wrapper.getInputs(), wrapper.getWidth(), wrapper.getHeight());
            craftingGridHelper.setOutput(guiItemStacks, wrapper.getOutputs());
        } else {
            craftingGridHelper.setInput(guiItemStacks, recipeWrapper.getInputs());
            craftingGridHelper.setOutput(guiItemStacks, recipeWrapper.getOutputs());
        }
    }

}
*/

