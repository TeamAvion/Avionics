package com.collinriggs.avionics.Items;

import com.collinriggs.avionics.Ref;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Deathly on 11/19/2016.
 */
public class ModItems {

    public static Item TAvionLogo;
    public static Item purifieddust;

    public static void preInit(){
        TAvionLogo = new ItemTAvionLogo("tavionlogo");
        purifieddust = new ItemPurifiedDust("purifieddust");

        registerItems();
    }

    public static void registerItems() {
        GameRegistry.register(TAvionLogo, new ResourceLocation(Ref.modid, "tavionlogo"));
        GameRegistry.register(purifieddust, new ResourceLocation(Ref.modid, "purifieddust"));
    }

    public static void registerRenders() {
        registerRender(TAvionLogo);
        registerRender(purifieddust);
    }

    private static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Ref.modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
