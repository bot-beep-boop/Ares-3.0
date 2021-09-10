package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerHopper;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiHopper extends GuiContainer {
   private IInventory hopperInventory;
   private static final ResourceLocation HOPPER_GUI_TEXTURE = new ResourceLocation("textures/gui/container/hopper.png");
   private IInventory playerInventory;

   protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      this.mc.getTextureManager().bindTexture(HOPPER_GUI_TEXTURE);
      int var4 = (width - this.xSize) / 2;
      int var5 = (height - this.ySize) / 2;
      drawTexturedModalRect(var4, var5, 0, 0, this.xSize, this.ySize);
   }

   protected void drawGuiContainerForegroundLayer(int var1, int var2) {
      this.fontRendererObj.drawString(this.hopperInventory.getDisplayName().getUnformattedText(), 8, 6, 4210752);
      this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
   }

   public GuiHopper(InventoryPlayer var1, IInventory var2) {
      super(new ContainerHopper(var1, var2, Minecraft.getMinecraft().thePlayer));
      this.playerInventory = var1;
      this.hopperInventory = var2;
      this.allowUserInput = false;
      this.ySize = 133;
   }
}
