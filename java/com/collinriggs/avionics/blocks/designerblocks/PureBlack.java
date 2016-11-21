package com.collinriggs.avionics.blocks.designerblocks;

/**
 * Created by Deathly on 11/19/2016 at 9:39 PM.
 */
import com.collinriggs.avionics.Ref;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Deathly on 11/19/2016.
 */
public class PureBlack extends Block {
    public PureBlack() {
        super(Material.REDSTONE_LIGHT);

        setUnlocalizedName("pureblack");
        setResistance(100F);
        setHardness(0.5F);
        setRegistryName("pureblack");
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
            setLightLevel(1F);
            worldIn.scheduleUpdate(pos, this, 4);
        }
        else {
            setLightLevel(0F);
            worldIn.scheduleUpdate(pos, this, 4);
        }

    }

}