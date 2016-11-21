package com.collinriggs.avionics.Items;

import com.collinriggs.avionics.Ref;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Deathly on 11/20/2016 at 2:36 AM.
 */
public class ItemPurifiedDust extends Item {
    public ItemPurifiedDust(String name) {
        setUnlocalizedName(name);
        setCreativeTab(Ref.avionictab);
    }
}
