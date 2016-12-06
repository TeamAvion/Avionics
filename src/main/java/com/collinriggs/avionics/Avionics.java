package com.collinriggs.avionics;

import com.collinriggs.avionics.Items.ModItems;
import com.collinriggs.avionics.blocks.GuiHandler;
import com.collinriggs.avionics.proxy.CommonProxy;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.apache.logging.log4j.Logger;

@Mod(modid = Ref.modid, name = Ref.modname, version = Ref.version)
public class Avionics {

	public static boolean disableFurnace = false;
	public static boolean disableCraftingTable = false;
	public static boolean enableTableRecipe = true;

	@Instance(value = Ref.modid)
	public static Avionics instance;

	@SidedProxy(clientSide = "com.collinriggs.avionics.proxy.ClientProxy", serverSide = "com.collinriggs.avionics.proxy.ServerProxy")
	public static CommonProxy proxy;

	public static Logger logger;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = event.getModLog();
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();

		disableCraftingTable = config.getBoolean("disableCraftingTable", Configuration.CATEGORY_GENERAL, true, "Disables Crafting Table");
		disableFurnace = config.getBoolean("disableFurnace", Configuration.CATEGORY_GENERAL, false, "Disables Furnace");
		enableTableRecipe = config.getBoolean("enableTableRecipe", Configuration.CATEGORY_GENERAL, false, "Enables custom Crafting Recipe for the Avionic Table. False makes it identical to the Vanilla Crafting Table Recipe.");

		config.save();
		proxy.preInit(event);
		ModItems.preInit();

		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
	}


	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
		//Crafting
	}
}
