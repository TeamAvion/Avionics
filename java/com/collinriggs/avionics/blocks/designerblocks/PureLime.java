package com.collinriggs.avionics.blocks.designerblocks;

/**
 * Created by Deathly on 11/19/2016 at 9:39 PM.
 */
import com.collinriggs.avionics.Ref;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Deathly on 11/19/2016.
 */
public class PureLime extends Block {
    public PureLime() {
        super(Material.WOOD);

        setUnlocalizedName("purelime");
        setResistance(100F);
        setHardness(0.5F);
        setRegistryName("purelime");
        setHarvestLevel("pickaxe", 0);
        setLightLevel(1F);

        setCreativeTab(Ref.avionictab);

        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this), getRegistryName());
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}