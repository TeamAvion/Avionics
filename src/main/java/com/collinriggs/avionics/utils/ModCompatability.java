package com.collinriggs.avionics.utils;

import net.minecraftforge.fml.common.Loader;
import com.collinriggs.avionics.compat.ICompatibility;

import java.util.ArrayList;

/**
 * Created by Deathly
 */
public class ModCompatability {
    private static ArrayList<ICompatibility> compatibilities = new ArrayList<ICompatibility>();

    public static void registerModCompat() {
        compatibilities.add(new JustEnoughItemsCompatability());
    }

    public static void loadCompat(ICompatibility.InitializationPhase phase) {
        for (ICompatibility compatibility : compatibilities)
            if (Loader.isModLoaded(compatibility.getMODID()) && compatibility.enableCompat())
                compatibility.loadCompatibility(phase);
    }
}
