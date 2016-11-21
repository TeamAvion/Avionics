package com.collinriggs.avionics.utils;

/**
 * Created by Deathly on 11/12/2016.
 */
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class EventHandler {

    @SubscribeEvent
    public void  itemTooltip(ItemTooltipEvent event){
        Block itemStack = Blocks.CRAFTING_TABLE;
        if (event.getItemStack().getItem() == Items.APPLE) {
            event.getToolTip().add("Disabled Via Config");
        }
    }

}
