package com.aresclient.visuals.hud.modules;

import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.hud.base.impl.MoveableModule;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.EnumChatFormatting;

public class ModuleScoreboard extends MoveableModule {
   private int listWidth;
   private int listHeight;

   public int getHeight() {
      return this.isRenderDummy() ? 25 : this.listHeight;
   }

   public int getWidth() {
      return this.isRenderDummy() ? 75 : this.listWidth;
   }

   public ModuleScoreboard(int var1, int var2) {
      super(var1, var2, true);
   }

   public boolean isRenderDummy() {
      return Minecraft.getMinecraft().theWorld.getScoreboard() == null;
   }

   public void renderScoreboard(ScoreObjective var1, ScaledResolution var2) {
      Scoreboard var3 = var1.getScoreboard();
      Collection var4 = var3.getSortedScores(var1);
      ArrayList var5 = Lists.newArrayList(Iterables.filter(var4, new Predicate<Score>(this) {
         final ModuleScoreboard this$0;

         public boolean apply(Object var1) {
            return this.apply((Score)var1);
         }

         {
            this.this$0 = var1;
         }

         public boolean apply(Score var1) {
            return var1.getPlayerName() != null && !var1.getPlayerName().startsWith("#");
         }
      }));
      ArrayList var20;
      if (var5.size() > 15) {
         var20 = Lists.newArrayList(Iterables.skip(var5, var4.size() - 15));
      } else {
         var20 = var5;
      }

      int var6 = minecraft.fontRendererObj.getStringWidth(var1.getDisplayName());

      String var10;
      for(Iterator var8 = var20.iterator(); var8.hasNext(); var6 = Math.max(var6, minecraft.fontRendererObj.getStringWidth(var10))) {
         Score var7 = (Score)var8.next();
         ScorePlayerTeam var9 = var3.getPlayersTeam(var7.getPlayerName());
         var10 = ScorePlayerTeam.formatPlayerName(var9, var7.getPlayerName()) + ": " + EnumChatFormatting.RED + var7.getScorePoints();
      }

      int var21 = var20.size() * minecraft.fontRendererObj.FONT_HEIGHT;
      int var22 = this.getY() + var21 + 10;
      byte var23 = 3;
      int var24 = this.getX() - var6 + var6 - var23 + 5;
      int var11 = 0;
      Iterator var13 = var20.iterator();

      while(var13.hasNext()) {
         Score var12 = (Score)var13.next();
         ++var11;
         ScorePlayerTeam var14 = var3.getPlayersTeam(var12.getPlayerName());
         String var15 = ScorePlayerTeam.formatPlayerName(var14, var12.getPlayerName());
         String var16 = "" + EnumChatFormatting.RED + var12.getScorePoints();
         int var17 = var22 - var11 * minecraft.fontRendererObj.FONT_HEIGHT;
         int var18 = this.getX() - var23 + 2 + var6;
         Gui.drawRect(var24 - 2, var17, var18, var17 + minecraft.fontRendererObj.FONT_HEIGHT, 1342177280);
         minecraft.fontRendererObj.drawString(var15, var24, var17, 553648127);
         minecraft.fontRendererObj.drawString(var16, var18 - minecraft.fontRendererObj.getStringWidth(var16), var17, 553648127);
         this.listHeight = var21 + 10;
         this.listWidth = var18 - (var24 - 2);
         if (var11 == var20.size()) {
            String var19 = var1.getDisplayName();
            Gui.drawRect(var24 - 2, var17 - minecraft.fontRendererObj.FONT_HEIGHT - 1, var18, var17 - 1, 1610612736);
            Gui.drawRect(var24 - 2, var17 - 1, var18, var17, 1342177280);
            minecraft.fontRendererObj.drawString(var19, var24 + var6 / 2 - minecraft.fontRendererObj.getStringWidth(var19) / 2, var17 - minecraft.fontRendererObj.FONT_HEIGHT, 553648127);
         }
      }

   }

   public void render() {
      if (Minecraft.getMinecraft().theWorld.getScoreboard() != null && ConfigManager.settings.OriginalScoreboard == 1) {
         Scoreboard var1 = Minecraft.getMinecraft().theWorld.getScoreboard();
         Object var2 = null;
         ScorePlayerTeam var3 = var1.getPlayersTeam(Minecraft.getMinecraft().thePlayer.getCommandSenderEntity().getName());
         ScoreObjective var4 = (ScoreObjective)(var2 != null ? var2 : var1.getObjectiveInDisplaySlot(1));
         ScaledResolution var5 = new ScaledResolution(Minecraft.getMinecraft());
         int var6 = var5.getScaledWidth();
         int var7 = var5.getScaledHeight();
         if (var3 != null) {
            int var8 = var3.getChatFormat().getColorIndex();
            if (var8 >= 0) {
               var1.getObjectiveInDisplaySlot(3 + var8);
            }
         }

         if (var4 != null) {
            this.renderScoreboard(var4, var5);
         }

         GlStateManager.enableBlend();
         GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
         GlStateManager.disableAlpha();
         GlStateManager.pushMatrix();
         GlStateManager.translate(0.0F, (float)(var7 - 48), 0.0F);
         GlStateManager.popMatrix();
         var4 = var1.getObjectiveInDisplaySlot(0);
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.disableLighting();
         GlStateManager.enableAlpha();
      }

   }

   public String getName() {
      return "Scoreboard";
   }

   public void renderDummy() {
      if (Minecraft.getMinecraft().theWorld.getScoreboard() != null) {
         Scoreboard var1 = Minecraft.getMinecraft().theWorld.getScoreboard();
         Object var2 = null;
         ScorePlayerTeam var3 = var1.getPlayersTeam(Minecraft.getMinecraft().thePlayer.getCommandSenderEntity().getName());
         ScoreObjective var4 = (ScoreObjective)(var2 != null ? var2 : var1.getObjectiveInDisplaySlot(1));
         ScaledResolution var5 = new ScaledResolution(Minecraft.getMinecraft());
         int var6 = var5.getScaledWidth();
         int var7 = var5.getScaledHeight();
         if (var3 != null) {
            int var8 = var3.getChatFormat().getColorIndex();
            if (var8 >= 0) {
               var1.getObjectiveInDisplaySlot(3 + var8);
            }
         }

         if (var4 != null) {
            this.renderScoreboard(var4, var5);
         }

         GlStateManager.enableBlend();
         GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
         GlStateManager.disableAlpha();
         GlStateManager.pushMatrix();
         GlStateManager.translate(0.0F, (float)(var7 - 48), 0.0F);
         GlStateManager.popMatrix();
         var4 = var1.getObjectiveInDisplaySlot(0);
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.disableLighting();
         GlStateManager.enableAlpha();
      } else {
         minecraft.fontRendererObj.drawString("Scoreboard Placeholder", this.getX(), this.getY(), -1);
      }

   }
}
