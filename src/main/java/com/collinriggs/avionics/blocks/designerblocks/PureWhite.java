package com.collinriggs.avionics.blocks.designerblocks;

import com.collinriggs.avionics.Items.ModItems;
import com.collinriggs.avionics.Ref;
import com.collinriggs.avionics.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.ShapedOreRecipe;

import javax.annotation.Nullable;
import java.util.Random;

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

        setCreativeTab(Ref.avionictab);

        GameRegistry.register(this);
        GameRegistry.register(new ItemBlock(this), getRegistryName());
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn)
    {
        if (worldIn.isBlockPowered(pos))
        {
            worldIn.setBlockState(pos, ModBlocks.purewhitelit.getDefaultState());
        }
        else {
            worldIn.setBlockState(pos, ModBlocks.purewhite.getDefaultState());
        }

    }

    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {

        if (worldIn.isBlockPowered(pos))
        {
            worldIn.setBlockState(pos, ModBlocks.purewhitelit.getDefaultState());
        }
        else {
            worldIn.setBlockState(pos, ModBlocks.purewhite.getDefaultState());
        }
        super.onBlockAdded(worldIn, pos, state);
    }
    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.purewhite);
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(ModBlocks.purewhite);
    }

    protected ItemStack createStackedBlock(IBlockState state)
    {
        return new ItemStack(ModBlocks.purewhite);
    }

}
