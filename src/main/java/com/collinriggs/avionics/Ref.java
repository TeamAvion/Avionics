package com.collinriggs.avionics;

import com.collinriggs.avionics.Items.ModItems;
import com.collinriggs.avionics.blocks.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Deathly
 */

public class Ref {

	public static final String
			modid = "avionics",
            modname = "Avionics",
            version = "1.0.2";

		public static final CreativeTabs avionictab= new CreativeTabs("avionictab") {
			@Override public Item getTabIconItem() {
				return ModItems.TAvionLogo;
			}
		};
}
