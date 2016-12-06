package com.collinriggs.avionics.blocks;

import com.collinriggs.avionics.Ref;
import net.minecraft.item.Item;

/**
 * Created by Deathly on 11/20/2016 at 2:13 AM.
 */
public class BaseItem extends Item {
    public BaseItem(String name) {
        setUnlocalizedName(name);
        setCreativeTab(Ref.avionictab);
    }
}
