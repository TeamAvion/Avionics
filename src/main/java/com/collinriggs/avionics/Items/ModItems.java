package com.collinriggs.avionics.Items;

<<<<<<< HEAD
=======
import com.collinriggs.avionics.Avionics;
>>>>>>> refs/remotes/origin/master
import com.collinriggs.avionics.Ref;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
<<<<<<< HEAD
=======
import net.minecraft.util.TabCompleter;
>>>>>>> refs/remotes/origin/master
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Deathly on 11/19/2016.
 */
public class ModItems {

    public static Item TAvionLogo;
<<<<<<< HEAD
    public static Item purifieddust;
    public static Item compressedenderpearl;

    public static void preInit(){
        TAvionLogo = new ItemTAvionLogo("tavionlogo");
        purifieddust = new ItemPurifiedDust("purifieddust");
        compressedenderpearl = new ItemCompressedEnderPearl("compressed_enderpearl");
=======

    public static void preInit(){
        TAvionLogo = new ItemTAvionLogo("tavionlogo");
>>>>>>> refs/remotes/origin/master

        registerItems();
    }

    public static void registerItems() {
        GameRegistry.register(TAvionLogo, new ResourceLocation(Ref.modid, "tavionlogo"));
<<<<<<< HEAD
        GameRegistry.register(purifieddust, new ResourceLocation(Ref.modid, "purifieddust"));
        GameRegistry.register(compressedenderpearl, new ResourceLocation(Ref.modid,"compressed_enderpearl"));
=======
>>>>>>> refs/remotes/origin/master
    }

    public static void registerRenders() {
        registerRender(TAvionLogo);
<<<<<<< HEAD
        registerRender(purifieddust);
        registerRender(compressedenderpearl);
=======
>>>>>>> refs/remotes/origin/master
    }

    private static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Ref.modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
