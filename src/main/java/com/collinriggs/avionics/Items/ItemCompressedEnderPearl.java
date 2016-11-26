package com.collinriggs.avionics.Items;

import com.collinriggs.avionics.Ref;
import net.minecraft.entity.item.EntityEnderPearl;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Deathly on 11/20/2016 at 2:36 AM.
 */
public class ItemCompressedEnderPearl extends Item {
    public ItemCompressedEnderPearl(String name) {
        setUnlocalizedName(name);
        this.maxStackSize = 16;
        setCreativeTab(Ref.avionictab);
    }
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        if (!playerIn.capabilities.isCreativeMode)
        {
            --itemStackIn.stackSize;
        }

        worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_ENDERPEARL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        playerIn.getCooldownTracker().setCooldown(this, 5);

        if (!worldIn.isRemote)
        {
            EntityCompressedEnderPearl entitycompressedenderpearl = new EntityCompressedEnderPearl(worldIn, playerIn);
            entitycompressedenderpearl.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 2.5F, 1.0F);
            worldIn.spawnEntityInWorld(entitycompressedenderpearl);
        }

        playerIn.addStat(StatList.getObjectUseStats(this));
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        tooltip.add("Wow that's far!");
        super.addInformation(stack, playerIn, tooltip, advanced);
    }
}
