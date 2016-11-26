package com.collinriggs.avionics.proxy;

import com.collinriggs.avionics.Items.ModItems;
import com.collinriggs.avionics.blocks.ModBlocks;

import com.collinriggs.avionics.recipe.ModRecipes;
import com.collinriggs.avionics.utils.ModOreDict;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ModBlocks.initModels();

    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        ModItems.registerRenders();
<<<<<<< HEAD
        ModRecipes.init();
        ModOreDict.registerOeDictEntries();
=======
>>>>>>> refs/remotes/origin/master
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }

}
