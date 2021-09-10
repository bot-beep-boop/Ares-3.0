package net.optifine.gui;

import com.mojang.authlib.exceptions.InvalidCredentialsException;
import java.math.BigInteger;
import java.net.URI;
import java.util.Random;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.src.Config;
import net.optifine.Lang;

public class GuiScreenCapeOF extends GuiScreenOF {
   private String message;
   private final GuiScreen parentScreen;
   private GuiButtonOF buttonCopyLink;
   private FontRenderer fontRenderer;
   private String title;
   private long messageHideTimeMs;
   private String linkUrl;

   public GuiScreenCapeOF(GuiScreen var1) {
      this.fontRenderer = Config.getMinecraft().fontRendererObj;
      this.parentScreen = var1;
   }

   protected void actionPerformed(GuiButton var1) {
      if (var1.enabled) {
         if (var1.id == 200) {
            this.mc.displayGuiScreen(this.parentScreen);
         }

         if (var1.id == 210) {
            try {
               String var2 = this.mc.getSession().getProfile().getName();
               String var3 = this.mc.getSession().getProfile().getId().toString().replace("-", "");
               String var4 = this.mc.getSession().getToken();
               Random var5 = new Random();
               Random var6 = new Random((long)System.identityHashCode(new Object()));
               BigInteger var7 = new BigInteger(128, var5);
               BigInteger var8 = new BigInteger(128, var6);
               BigInteger var9 = var7.xor(var8);
               String var10 = var9.toString(16);
               this.mc.getSessionService().joinServer(this.mc.getSession().getProfile(), var4, var10);
               String var11 = "https://optifine.net/capeChange?u=" + var3 + "&n=" + var2 + "&s=" + var10;
               boolean var12 = Config.openWebLink(new URI(var11));
               if (var12) {
                  this.showMessage(Lang.get("of.message.capeOF.openEditor"), 10000L);
               } else {
                  this.showMessage(Lang.get("of.message.capeOF.openEditorError"), 10000L);
                  this.setLinkUrl(var11);
               }
            } catch (InvalidCredentialsException var13) {
               Config.showGuiMessage(I18n.format("of.message.capeOF.error1"), I18n.format("of.message.capeOF.error2", var13.getMessage()));
               Config.warn("Mojang authentication failed");
               Config.warn(var13.getClass().getName() + ": " + var13.getMessage());
            } catch (Exception var14) {
               Config.warn("Error opening OptiFine cape link");
               Config.warn(var14.getClass().getName() + ": " + var14.getMessage());
            }
         }

         if (var1.id == 220) {
            this.showMessage(Lang.get("of.message.capeOF.reloadCape"), 15000L);
            if (this.mc.thePlayer != null) {
               long var15 = 15000L;
               long var16 = System.currentTimeMillis() + var15;
               this.mc.thePlayer.setReloadCapeTimeMs(var16);
            }
         }

         if (var1.id == 230 && this.linkUrl != null) {
            setClipboardString(this.linkUrl);
         }
      }

   }

   public void setLinkUrl(String var1) {
      this.linkUrl = var1;
      this.buttonCopyLink.visible = var1 != null;
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.drawCenteredString(this.fontRenderer, this.title, width / 2, 20, 16777215);
      if (this.message != null) {
         this.drawCenteredString(this.fontRenderer, this.message, width / 2, height / 6 + 60, 16777215);
         if (System.currentTimeMillis() > this.messageHideTimeMs) {
            this.message = null;
            this.setLinkUrl((String)null);
         }
      }

      super.drawScreen(var1, var2, var3);
   }

   private void showMessage(String var1, long var2) {
      this.message = var1;
      this.messageHideTimeMs = System.currentTimeMillis() + var2;
      this.setLinkUrl((String)null);
   }

   public void initGui() {
      byte var1 = 0;
      this.title = I18n.format("of.options.capeOF.title");
      int var2 = var1 + 2;
      this.buttonList.add(new GuiButtonOF(210, width / 2 - 155, height / 6 + 24 * (var2 >> 1), 150, 20, I18n.format("of.options.capeOF.openEditor")));
      this.buttonList.add(new GuiButtonOF(220, width / 2 - 155 + 160, height / 6 + 24 * (var2 >> 1), 150, 20, I18n.format("of.options.capeOF.reloadCape")));
      var2 += 6;
      this.buttonCopyLink = new GuiButtonOF(230, width / 2 - 100, height / 6 + 24 * (var2 >> 1), 200, 20, I18n.format("of.options.capeOF.copyEditorLink"));
      this.buttonCopyLink.visible = this.linkUrl != null;
      this.buttonList.add(this.buttonCopyLink);
      var2 += 4;
      this.buttonList.add(new GuiButtonOF(200, width / 2 - 100, height / 6 + 24 * (var2 >> 1), I18n.format("gui.done")));
   }
}
