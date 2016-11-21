package com.collinriggs.avionics.blocks.designerblocks;

import com.collinriggs.avionics.Items.ModItems;
import com.collinriggs.avionics.Ref;
import com.collinriggs.avionics.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by Deathly on 11/19/2016.
 */
public class PureWhite extends Block {
    public PureWhite() {
        super(Material.WOOD);

        setUnlocalizedName("purewhite");
        setResistance(100F);
        setHardness(0.5F);
        setRegistryName("purewhite");
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
