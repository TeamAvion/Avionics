package com.collinriggs.avionics.recipe;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ModWorkbenchRecipes {
	
	public void addRecipes(WorkbenchCraftingManager custommanager) {
		custommanager.addRecipe(new ItemStack(Blocks.FURNACE), new Object[] {"MMM", "MaM", "MMM", 'M', Blocks.COBBLESTONE});
		custommanager.addRecipe(new ItemStack(Blocks.COMMAND_BLOCK), new Object[] {"MMM", "MMM", "MMM", 'M', Blocks.DIRT});

	}

}
