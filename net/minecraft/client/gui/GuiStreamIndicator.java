package net.minecraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

public class GuiStreamIndicator {
   private static final ResourceLocation locationStreamIndicator = new ResourceLocation("textures/gui/stream_indicator.png");
   private final Minecraft mc;
   private int streamAlphaDelta = 1;
   private float streamAlpha = 1.0F;

   private void render(int var1, int var2, int var3, int var4) {
      GlStateManager.color(1.0F, 1.0F, 1.0F, 0.65F + 0.35000002F * this.streamAlpha);
      this.mc.getTextureManager().bindTexture(locationStreamIndicator);
      float var5 = 150.0F;
      float var6 = 0.0F;
      float var7 = (float)var3 * 0.015625F;
      float var8 = 1.0F;
      float var9 = (float)(var3 + 16) * 0.015625F;
      Tessellator var10 = Tessellator.getInstance();
      WorldRenderer var11 = var10.getWorldRenderer();
      var11.begin(7, DefaultVertexFormats.POSITION_TEX);
      var11.pos((double)(var1 - 16 - var4), (double)(var2 + 16), (double)var5).tex((double)var6, (double)var9).endVertex();
      var11.pos((double)(var1 - var4), (double)(var2 + 16), (double)var5).tex((double)var8, (double)var9).endVertex();
      var11.pos((double)(var1 - var4), (double)var2, (double)var5).tex((double)var8, (double)var7).endVertex();
      var11.pos((double)(var1 - 16 - var4), (double)var2, (double)var5).tex((double)var6, (double)var7).endVertex();
      var10.draw();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public GuiStreamIndicator(Minecraft var1) {
      this.mc = var1;
   }

   private int func_152440_b() {
      return this.mc.getTwitchStream().isPaused() ? 16 : 0;
   }

   public void render(int var1, int var2) {
   }

   private int func_152438_c() {
      return this.mc.getTwitchStream().func_152929_G() ? 48 : 32;
   }

   public void updateStreamAlpha() {
      if (this.mc.getTwitchStream().isBroadcasting()) {
         this.streamAlpha += 0.025F * (float)this.streamAlphaDelta;
         if (this.streamAlpha < 0.0F) {
            this.streamAlphaDelta *= -1;
            this.streamAlpha = 0.0F;
         } else if (this.streamAlpha > 1.0F) {
            this.streamAlphaDelta *= -1;
            this.streamAlpha = 1.0F;
         }
      } else {
         this.streamAlpha = 1.0F;
         this.streamAlphaDelta = 1;
      }

   }
}
