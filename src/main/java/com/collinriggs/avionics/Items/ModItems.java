package com.collinriggs.avionics.Items;

import com.collinriggs.avionics.Avionics;
import com.collinriggs.avionics.Ref;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.TabCompleter;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Deathly on 11/19/2016.
 */
public class ModItems {

    public static Item TAvionLogo;

    public static void preInit(){
        TAvionLogo = new ItemTAvionLogo("tavionlogo");

        registerItems();
    }

    public static void registerItems() {
        GameRegistry.register(TAvionLogo, new ResourceLocation(Ref.modid, "tavionlogo"));
    }

    public static void registerRenders() {
        registerRender(TAvionLogo);
    }

    private static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Ref.modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
