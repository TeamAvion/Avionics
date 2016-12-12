package com.collinriggs.avionics.compat;

import com.collinriggs.avionics.Items.ModItems;
import com.collinriggs.avionics.blocks.ModBlocks;
import mezz.jei.api.*;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Optional;

import javax.annotation.Nonnull;

/**
 * Created by Deathly on 11/25/2016 at 1:35 AM.
 */
@Optional.Interface(iface = "mezz.jei.api.IItemBlacklist", modid = "JEI", striprefs = true)
@JEIPlugin
public class JEI implements IModPlugin {
    @Override
    public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry) {

    }

    @Override
    public void registerIngredients(IModIngredientRegistration registry) {

    }

    @Optional.Method(modid = "JEI")
    public void register(@Nonnull IModRegistry registry) {
        IJeiHelpers helpers = registry.getJeiHelpers();
        IItemBlacklist blacklist = helpers.getItemBlacklist();

        blacklist.addItemToBlacklist(new ItemStack(ModBlocks.pureblacklit));
        blacklist.addItemToBlacklist(new ItemStack(ModBlocks.purebrownlit));
        blacklist.addItemToBlacklist(new ItemStack(ModBlocks.purebluelit));
        blacklist.addItemToBlacklist(new ItemStack(ModBlocks.puremagentalit));
        blacklist.addItemToBlacklist(new ItemStack(ModBlocks.purepinklit));
        blacklist.addItemToBlacklist(new ItemStack(ModBlocks.purepurplelit));
        blacklist.addItemToBlacklist(new ItemStack(ModBlocks.pureredlit));
        blacklist.addItemToBlacklist(new ItemStack(ModBlocks.pureorangelit));
        blacklist.addItemToBlacklist(new ItemStack(ModBlocks.purewhitelit));
        blacklist.addItemToBlacklist(new ItemStack(ModBlocks.puregreenlit));
        blacklist.addItemToBlacklist(new ItemStack(ModBlocks.puregreylit));
        blacklist.addItemToBlacklist(new ItemStack(ModBlocks.purelightbluelit));
        blacklist.addItemToBlacklist(new ItemStack(ModBlocks.purelightgreylit));
        blacklist.addItemToBlacklist(new ItemStack(ModBlocks.purelimelit));
        blacklist.addItemToBlacklist(new ItemStack(ModBlocks.purecyanlit));
        blacklist.addItemToBlacklist(new ItemStack(ModBlocks.pureyellowlit));
        blacklist.addItemToBlacklist(new ItemStack(ModItems.TAvionLogo));
    }

    @Override
    public void onRuntimeAvailable(@Nonnull IJeiRuntime jeiRuntime) {

    }
}
