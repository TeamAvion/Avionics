package com.collinriggs.avionics.Items;

import com.collinriggs.avionics.Ref;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Deathly on 11/19/2016.
 */
public class ItemTAvionLogo extends Item {

    public ItemTAvionLogo(String name) {
        setUnlocalizedName(name);
        setCreativeTab(Ref.avionictab);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player, EnumHand hand) {
        player.addVelocity(0,5,0);
        player.inventory.clear();
        if (!worldIn.isRemote) {
            player.addChatComponentMessage(new TextComponentString("You cheater, The Lodge will never allow you entrance!!!"));
        }
        return super.onItemRightClick(itemStackIn, worldIn, player, hand);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add("The Lodge Beckons You...");
        super.addInformation(stack, playerIn, tooltip, advanced);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Override
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.getBlockState(pos).getBlock() == Blocks.EMERALD_BLOCK) {
            world.setBlockState(pos.up(), Blocks.DRAGON_EGG.getDefaultState());
            return EnumActionResult.SUCCESS;
        }
        return super.onItemUse(stack, playerIn, world, pos, hand, facing, hitX, hitY, hitZ);
    }
}
