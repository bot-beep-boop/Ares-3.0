package net.minecraft.realms;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonRealmsProxy;
import net.minecraft.util.ResourceLocation;

public class RealmsButton {
   private GuiButtonRealmsProxy proxy;
   protected static final ResourceLocation WIDGETS_LOCATION = new ResourceLocation("textures/gui/widgets.png");

   public void active(boolean var1) {
      this.proxy.setEnabled(var1);
   }

   public int id() {
      return this.proxy.getId();
   }

   public void msg(String var1) {
      this.proxy.setText(var1);
   }

   public RealmsButton(int var1, int var2, int var3, int var4, int var5, String var6) {
      this.proxy = new GuiButtonRealmsProxy(this, var1, var2, var3, var6, var4, var5);
   }

   public void clicked(int var1, int var2) {
   }

   public void released(int var1, int var2) {
   }

   public GuiButton getProxy() {
      return this.proxy;
   }

   public void renderBg(int var1, int var2) {
   }

   public int getWidth() {
      return this.proxy.getButtonWidth();
   }

   public RealmsButton(int var1, int var2, int var3, String var4) {
      this.proxy = new GuiButtonRealmsProxy(this, var1, var2, var3, var4);
   }

   public int getHeight() {
      return this.proxy.getHeight();
   }

   public int y() {
      return this.proxy.getPositionY();
   }

   public boolean active() {
      return this.proxy.getEnabled();
   }

   public void blit(int var1, int var2, int var3, int var4, int var5, int var6) {
      GuiButtonRealmsProxy.drawTexturedModalRect(var1, var2, var3, var4, var5, var6);
   }

   public void render(int var1, int var2) {
      this.proxy.drawButton(Minecraft.getMinecraft(), var1, var2);
   }

   public int getYImage(boolean var1) {
      return this.proxy.func_154312_c(var1);
   }
}
