package com.collinriggs.avionics.test;

/**
 * Created by Deathly on 11/12/2016.
 */
import javax.annotation.Nullable;

import com.collinriggs.avionics.Avionics;

import com.collinriggs.avionics.blocks.GuiHandler;
import com.collinriggs.avionics.blocks.TileEntityNewWorkbench;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TinyChest extends Block {

    public TinyChest() {
        super(Material.ROCK);

        setUnlocalizedName("tinychest");
        setResistance(1000.0F);
        setHardness(10.0F);
        setHarvestLevel("pickaxe", 2);
        setRegistryName("Tinychest");

        setCreativeTab(CreativeTabs.MISC);

        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this), getRegistryName());
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileTinyChest();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {playerIn.openGui(Avionics.instance, GuiHandler.GUI_TINYCHEST, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;
    }
}
