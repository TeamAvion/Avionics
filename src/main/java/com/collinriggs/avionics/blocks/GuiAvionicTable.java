package com.collinriggs.avionics.blocks;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiAvionicTable extends GuiContainer {
    private static final ResourceLocation ARP_WORKBENCH_GUI_TEXTURES = new ResourceLocation("avionics:textures/gui/container/gui_workbench.png");

    public GuiAvionicTable(InventoryPlayer playerInv, TileEntityAvionicTable tileEntity, World worldIn) {
        super(new ContainerAvionicTable(playerInv, tileEntity, worldIn));
        this.xSize = 176;
        this.ySize = 165;
    }

    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.fontRendererObj.drawString(I18n.format("container.avionics.workbench", new Object[0]), 24, 6, 0x0000FF);
        this.fontRendererObj.drawString(I18n.format("container.avionics.inventory", new Object[0]), 8, this.ySize - 96 + 2, 0x0000FF);
    }

    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(ARP_WORKBENCH_GUI_TEXTURES);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
    }
}
