package net.optifine.shaders.gui;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.gui.GuiYesNo;
import net.minecraft.client.gui.GuiYesNoCallback;
import net.minecraft.client.resources.I18n;
import net.minecraft.src.Config;
import net.optifine.Lang;
import net.optifine.shaders.IShaderPack;
import net.optifine.shaders.Shaders;
import net.optifine.util.ResUtils;

class GuiSlotShaders extends GuiSlot {
   private long lastClickedCached = 0L;
   final GuiShaders shadersGui;
   private int selectedIndex;
   private ArrayList shaderslist;

   protected void drawSlot(int var1, int var2, int var3, int var4, int var5, int var6) {
      String var7 = (String)this.shaderslist.get(var1);
      if (var7.equals("OFF")) {
         var7 = Lang.get("of.options.shaders.packNone");
      } else if (var7.equals("(internal)")) {
         var7 = Lang.get("of.options.shaders.packDefault");
      }

      this.shadersGui.drawCenteredString(var7, this.width / 2, var3 + 1, 14737632);
   }

   protected void drawBackground() {
   }

   protected int getScrollBarX() {
      return this.width - 6;
   }

   private void selectIndex(int var1) {
      this.selectedIndex = var1;
      this.lastClickedCached = this.lastClicked;
      Shaders.setShaderPack((String)this.shaderslist.get(var1));
      Shaders.uninit();
      this.shadersGui.updateButtons();
   }

   public GuiSlotShaders(GuiShaders var1, int var2, int var3, int var4, int var5, int var6) {
      super(var1.getMc(), var2, var3, var4, var5, var6);
      this.shadersGui = var1;
      this.updateList();
      this.amountScrolled = 0.0F;
      int var7 = this.selectedIndex * var6;
      int var8 = (var5 - var4) / 2;
      if (var7 > var8) {
         this.scrollBy(var7 - var8);
      }

   }

   protected int getContentHeight() {
      return this.getSize() * 18;
   }

   static void access$0(GuiSlotShaders var0, int var1) {
      var0.selectIndex(var1);
   }

   protected void elementClicked(int var1, boolean var2, int var3, int var4) {
      if (var1 != this.selectedIndex || this.lastClicked != this.lastClickedCached) {
         String var5 = (String)this.shaderslist.get(var1);
         IShaderPack var6 = Shaders.getShaderPack(var5);
         if (this.checkCompatible(var6, var1)) {
            this.selectIndex(var1);
         }
      }

   }

   public int getListWidth() {
      return this.width - 20;
   }

   protected boolean isSelected(int var1) {
      return var1 == this.selectedIndex;
   }

   public void updateList() {
      this.shaderslist = Shaders.listOfShaders();
      this.selectedIndex = 0;
      int var1 = 0;

      for(int var2 = this.shaderslist.size(); var1 < var2; ++var1) {
         if (((String)this.shaderslist.get(var1)).equals(Shaders.currentShaderName)) {
            this.selectedIndex = var1;
            break;
         }
      }

   }

   protected int getSize() {
      return this.shaderslist.size();
   }

   static Minecraft access$1(GuiSlotShaders var0) {
      return var0.mc;
   }

   public int getSelectedIndex() {
      return this.selectedIndex;
   }

   private boolean checkCompatible(IShaderPack var1, int var2) {
      if (var1 == null) {
         return true;
      } else {
         InputStream var3 = var1.getResourceAsStream("/shaders/shaders.properties");
         Properties var4 = ResUtils.readProperties(var3, "Shaders");
         if (var4 == null) {
            return true;
         } else {
            String var5 = "version.1.8.9";
            String var6 = var4.getProperty(var5);
            if (var6 == null) {
               return true;
            } else {
               var6 = var6.trim();
               String var7 = "L5";
               int var8 = Config.compareRelease(var7, var6);
               if (var8 >= 0) {
                  return true;
               } else {
                  String var9 = ("HD_U_" + var6).replace('_', ' ');
                  String var10 = I18n.format("of.message.shaders.nv1", var9);
                  String var11 = I18n.format("of.message.shaders.nv2");
                  GuiYesNoCallback var13 = new GuiYesNoCallback(this, var2) {
                     final GuiSlotShaders this$0;
                     private final int val$j;

                     {
                        this.this$0 = var1;
                        this.val$j = var2;
                     }

                     public void confirmClicked(boolean var1, int var2) {
                        if (var1) {
                           GuiSlotShaders.access$0(this.this$0, this.val$j);
                        }

                        GuiSlotShaders.access$1(this.this$0).displayGuiScreen(this.this$0.shadersGui);
                     }
                  };
                  GuiYesNo var14 = new GuiYesNo(var13, var10, var11, 0);
                  this.mc.displayGuiScreen(var14);
                  return false;
               }
            }
         }
      }
   }
}
