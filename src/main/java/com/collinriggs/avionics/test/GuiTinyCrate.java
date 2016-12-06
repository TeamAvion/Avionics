package com.collinriggs.avionics.test;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Jeremy on 11/12/2016.
 */

public class GuiTinyCrate extends GuiContainer {
    private static final ResourceLocation TINYBENCH_GUI = new ResourceLocation("avionics:textures/gui/dirtcontainer.png");

    public GuiTinyCrate(InventoryPlayer playerInventory, IInventory chestInventory) { //}, World worldIn) {
        super(new TinyCrateContainer(playerInventory, chestInventory)); // , worldIn));
        this.xSize = 176;
        this.ySize = 166;
    }

    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.fontRendererObj.drawString(I18n.format("container.avionics.tinycrate", new Object[0]), 8, 6, 0x0000FF);
        this.fontRendererObj.drawString(I18n.format("container.avionics.inventory", new Object[0]), 8, this.ySize - 96 + 2, 0x0000FF);
    }

    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TINYBENCH_GUI);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
    }
}

