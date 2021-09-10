package com.aresclient.visuals.hud.modules;

import com.aresclient.visuals.hud.base.impl.MoveableModule;
import java.util.Collection;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class ModulePotions extends MoveableModule {
   protected float zLevelFloat;

   public void render() {
      byte var1 = 21;
      byte var2 = 14;
      int var3 = 16;
      int var4 = this.getY();
      int var5 = this.getX();
      Collection var6 = Minecraft.getMinecraft().thePlayer.getActivePotionEffects();
      if (!var6.isEmpty()) {
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.disableLighting();
         int var7 = 33;
         if (var6.size() > 5) {
            var7 = 132 / (var6.size() - 1);
         }

         for(Iterator var9 = Minecraft.getMinecraft().thePlayer.getActivePotionEffects().iterator(); var9.hasNext(); var3 += var7) {
            PotionEffect var8 = (PotionEffect)var9.next();
            Potion var10 = Potion.potionTypes[var8.getPotionID()];
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            if (var10.hasStatusIcon()) {
               Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/inventory.png"));
               int var11 = var10.getStatusIconIndex();
               this.drawTexturedModalRect(var5 + var1 - 20, var4 + var3 - var2, 0 + var11 % 8 * 18, 198 + var11 / 8 * 18, 18, 18);
            }

            String var13 = I18n.format(var10.getName());
            if (var8.getAmplifier() == 1) {
               var13 = var13 + " " + I18n.format("enchantment.level.2");
            } else if (var8.getAmplifier() == 2) {
               var13 = var13 + " " + I18n.format("enchantment.level.3");
            } else if (var8.getAmplifier() == 3) {
               var13 = var13 + " " + I18n.format("enchantment.level.4");
            }

            Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(var13, (float)(var5 + var1), (float)(var4 + var3 - var2), 16777215);
            String var12 = Potion.getDurationString(var8);
            Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(var12, (float)(var5 + var1), (float)(var4 + var3 + 10 - var2), 8355711);
         }
      }

   }

   public int getWidth() {
      return 100;
   }

   public boolean isRenderDummy() {
      return true;
   }

   public int getHeight() {
      return 160;
   }

   public ModulePotions(int var1, int var2) {
      super(var1, var2, true);
   }

   public void renderDummy() {
      byte var1 = 21;
      byte var2 = 14;
      int var3 = 16;
      int var4 = this.getY();
      int var5 = this.getX();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.disableLighting();
      byte var6 = 33;

      for(int var7 = 0; var7 < 4; ++var7) {
         PotionEffect var8 = new PotionEffect(var7 + 1, 25);
         Potion var9 = Potion.potionTypes[var8.getPotionID()];
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         if (var9.hasStatusIcon()) {
            Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/gui/container/inventory.png"));
            int var10 = var9.getStatusIconIndex();
            this.drawTexturedModalRect(var5 + var1 - 20, var4 + var3 - var2, 0 + var10 % 8 * 18, 198 + var10 / 8 * 18, 18, 18);
         }

         String var12 = I18n.format(var9.getName());
         if (var8.getAmplifier() == 1) {
            var12 = var12 + " " + I18n.format("enchantment.level.2");
         } else if (var8.getAmplifier() == 2) {
            var12 = var12 + " " + I18n.format("enchantment.level.3");
         } else if (var8.getAmplifier() == 3) {
            var12 = var12 + " " + I18n.format("enchantment.level.4");
         }

         Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(var12, (float)(var5 + var1), (float)(var4 + var3 - var2), 16777215);
         String var11 = Potion.getDurationString(var8);
         Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(var11, (float)(var5 + var1), (float)(var4 + var3 + 10 - var2), 8355711);
         var3 += var6;
      }

   }

   public String getName() {
      return "Potionstatus";
   }

   public void drawTexturedModalRect(int var1, int var2, int var3, int var4, int var5, int var6) {
      float var7 = 0.00390625F;
      float var8 = 0.00390625F;
      Tessellator var9 = Tessellator.getInstance();
      WorldRenderer var10 = var9.getWorldRenderer();
      var10.begin(7, DefaultVertexFormats.POSITION_TEX);
      var10.pos((double)var1, (double)(var2 + var6), (double)this.zLevelFloat).tex((double)((float)var3 * var7), (double)((float)(var4 + var6) * var8)).endVertex();
      var10.pos((double)(var1 + var5), (double)(var2 + var6), (double)this.zLevelFloat).tex((double)((float)(var3 + var5) * var7), (double)((float)(var4 + var6) * var8)).endVertex();
      var10.pos((double)(var1 + var5), (double)var2, (double)this.zLevelFloat).tex((double)((float)(var3 + var5) * var7), (double)((float)var4 * var8)).endVertex();
      var10.pos((double)var1, (double)var2, (double)this.zLevelFloat).tex((double)((float)var3 * var7), (double)((float)var4 * var8)).endVertex();
      var9.draw();
   }
}
