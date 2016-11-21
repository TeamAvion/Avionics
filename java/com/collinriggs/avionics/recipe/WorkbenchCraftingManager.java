package com.collinriggs.avionics.recipe;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockStone;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.BlockStoneSlabNew;
import net.minecraft.block.BlockWall;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipeBookCloning;
import net.minecraft.item.crafting.RecipeFireworks;
import net.minecraft.item.crafting.RecipeRepairItem;
import net.minecraft.item.crafting.RecipeTippedArrow;
import net.minecraft.item.crafting.RecipesArmorDyes;
import net.minecraft.item.crafting.RecipesMapCloning;
import net.minecraft.item.crafting.RecipesMapExtending;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class WorkbenchCraftingManager {
    
    private static final WorkbenchCraftingManager INSTANCE = new WorkbenchCraftingManager();
    private final List<IRecipe> recipes = Lists.<IRecipe>newArrayList();

	public static WorkbenchCraftingManager getInstance() {
	    return INSTANCE;
	}
    
	public WorkbenchCraftingManager() {
		this.addRecipe(new ItemStack(Blocks.COBBLESTONE, 1), new Object[] {"##", "##", '#', new ItemStack(Blocks.STONE_SLAB, 1, 3)});

    	(new CustomRecipesTools()).addRecipes(this);
        (new CustomRecipesWeapons()).addRecipes(this);
        (new CustomRecipesIngots()).addRecipes(this);
        (new CustomRecipesFood()).addRecipes(this);
        (new CustomRecipesCrafting()).addRecipes(this);
        (new CustomRecipesArmor()).addRecipes(this);
        (new CustomRecipesDyes()).addRecipes(this);
        (new CustomRecipesBanners()).addRecipes(this);
        (new CustomShieldRecipes()).addRecipes(this);
        Collections.sort(this.recipes, new Comparator<IRecipe>()
        {
            public int compare(IRecipe p_compare_1_, IRecipe p_compare_2_)
            {
                return p_compare_1_ instanceof ShapelessRecipes && p_compare_2_ instanceof ShapedRecipes ? 1 : (p_compare_2_ instanceof ShapelessRecipes && p_compare_1_ instanceof ShapedRecipes ? -1 : (p_compare_2_.getRecipeSize() < p_compare_1_.getRecipeSize() ? -1 : (p_compare_2_.getRecipeSize() > p_compare_1_.getRecipeSize() ? 1 : 0)));
            }
        });
	}
    public ShapedRecipes addRecipe(ItemStack stack, Object... recipeComponents) {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (recipeComponents[i] instanceof String[]) {
            String[] astring = (String[]) ((String[]) recipeComponents[i++]);

            for (int l = 0; l < astring.length; ++l) {
                String s2 = astring[l];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        } else {
            while (recipeComponents[i] instanceof String) {
                String s1 = (String) recipeComponents[i++];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }

        Map<Character, ItemStack> map;

        for (map = Maps.<Character, ItemStack>newHashMap(); i < recipeComponents.length; i += 2) {
            Character character = (Character) recipeComponents[i];
            ItemStack itemstack = null;

            if (recipeComponents[i + 1] instanceof Item) {
                itemstack = new ItemStack((Item) recipeComponents[i + 1]);
            } else if (recipeComponents[i + 1] instanceof Block) {
                itemstack = new ItemStack((Block) recipeComponents[i + 1], 1, 32767);
            } else if (recipeComponents[i + 1] instanceof ItemStack) {
                itemstack = (ItemStack) recipeComponents[i + 1];
            }

            map.put(character, itemstack);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1) {
            char c0 = s.charAt(i1);

            if (map.containsKey(Character.valueOf(c0))) {
                aitemstack[i1] = ((ItemStack) map.get(Character.valueOf(c0))).copy();
            } else {
                aitemstack[i1] = null;
            }
        }

        ShapedRecipes shapedrecipes = new ShapedRecipes(j, k, aitemstack, stack);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }

    public void addShapelessRecipe(ItemStack stack, Object... recipeComponents) {
        List<ItemStack> list = Lists.<ItemStack>newArrayList();

        for (Object object : recipeComponents) {
            if (object instanceof ItemStack) {
                list.add(((ItemStack) object).copy());
            } else if (object instanceof Item) {
                list.add(new ItemStack((Item) object));
            } else {
                if (!(object instanceof Block)) {
                    throw new IllegalArgumentException("Invalid shapeless recipe: unknown type " + object.getClass().getName() + "!");
                }

                list.add(new ItemStack((Block) object));
            }
        }

        this.recipes.add(new ShapelessRecipes(stack, list));
    }
    
    public void addRecipe(IRecipe recipe) {
        this.recipes.add(recipe);
    }

    public void removeRecipe(IRecipe recipe) {
        this.recipes.remove(recipe);
    }

    @Nullable
    public ItemStack findMatchingRecipe(InventoryCrafting craftMatrix, World worldIn) {
        for (IRecipe irecipe : this.recipes) {
            if (irecipe.matches(craftMatrix, worldIn)) {
                return irecipe.getCraftingResult(craftMatrix);
            }
        }

        return null;
    }

    public ItemStack[] getRemainingItems(InventoryCrafting craftMatrix, World worldIn) {
        for (IRecipe irecipe : this.recipes) {
            if (irecipe.matches(craftMatrix, worldIn)) {
                return irecipe.getRemainingItems(craftMatrix);
            }
        }

        ItemStack[] aitemstack = new ItemStack[craftMatrix.getSizeInventory()];

        for (int i = 0; i < aitemstack.length; ++i) {
            aitemstack[i] = craftMatrix.getStackInSlot(i);
        }

        return aitemstack;
    }

    public List<IRecipe> getRecipeList() {
        return this.recipes;
    }
}