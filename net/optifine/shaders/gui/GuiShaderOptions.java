package net.optifine.shaders.gui;

import java.util.Iterator;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.src.Config;
import net.minecraft.util.MathHelper;
import net.optifine.Lang;
import net.optifine.gui.GuiScreenOF;
import net.optifine.gui.TooltipManager;
import net.optifine.gui.TooltipProviderShaderOptions;
import net.optifine.shaders.Shaders;
import net.optifine.shaders.config.ShaderOption;
import net.optifine.shaders.config.ShaderOptionProfile;
import net.optifine.shaders.config.ShaderOptionScreen;

public class GuiShaderOptions extends GuiScreenOF {
   private boolean changed;
   private String screenText;
   public static final String OPTION_PROFILE = "<profile>";
   public static final String OPTION_REST = "*";
   private GameSettings settings;
   private TooltipManager tooltipManager;
   protected String title;
   private String screenName;
   public static final String OPTION_EMPTY = "<empty>";
   private GuiScreen prevScreen;

   public GuiShaderOptions(GuiScreen var1, GameSettings var2) {
      this.tooltipManager = new TooltipManager(this, new TooltipProviderShaderOptions());
      this.screenName = null;
      this.screenText = null;
      this.changed = false;
      this.title = "Shader Options";
      this.prevScreen = var1;
      this.settings = var2;
   }

   public void initGui() {
      this.title = I18n.format("of.options.shaderOptionsTitle");
      byte var1 = 100;
      boolean var2 = false;
      byte var3 = 30;
      byte var4 = 20;
      byte var5 = 120;
      byte var6 = 20;
      int var7 = Shaders.getShaderPackColumns(this.screenName, 2);
      ShaderOption[] var8 = Shaders.getShaderPackOptions(this.screenName);
      if (var8 != null) {
         int var9 = MathHelper.ceiling_double_int((double)var8.length / 9.0D);
         if (var7 < var9) {
            var7 = var9;
         }

         for(int var10 = 0; var10 < var8.length; ++var10) {
            ShaderOption var11 = var8[var10];
            if (var11 != null && var11.isVisible()) {
               int var12 = var10 % var7;
               int var13 = var10 / var7;
               int var14 = Math.min(width / var7, 200);
               int var20 = (width - var14 * var7) / 2;
               int var15 = var12 * var14 + 5 + var20;
               int var16 = var3 + var13 * var4;
               int var17 = var14 - 10;
               String var18 = getButtonText(var11, var17);
               Object var19;
               if (Shaders.isShaderPackOptionSlider(var11.getName())) {
                  var19 = new GuiSliderShaderOption(var1 + var10, var15, var16, var17, var6, var11, var18);
               } else {
                  var19 = new GuiButtonShaderOption(var1 + var10, var15, var16, var17, var6, var11, var18);
               }

               ((GuiButtonShaderOption)var19).enabled = var11.isEnabled();
               this.buttonList.add(var19);
            }
         }
      }

      this.buttonList.add(new GuiButton(201, width / 2 - var5 - 20, height / 6 + 168 + 11, var5, var6, I18n.format("controls.reset")));
      this.buttonList.add(new GuiButton(200, width / 2 + 20, height / 6 + 168 + 11, var5, var6, I18n.format("gui.done")));
   }

   protected void actionPerformed(GuiButton var1) {
      if (var1.enabled) {
         if (var1.id < 200 && var1 instanceof GuiButtonShaderOption) {
            GuiButtonShaderOption var2 = (GuiButtonShaderOption)var1;
            ShaderOption var3 = var2.getShaderOption();
            if (var3 instanceof ShaderOptionScreen) {
               String var8 = var3.getName();
               GuiShaderOptions var5 = new GuiShaderOptions(this, this.settings, var8);
               this.mc.displayGuiScreen(var5);
               return;
            }

            if (isShiftKeyDown()) {
               var3.resetValue();
            } else if (var2.isSwitchable()) {
               var3.nextValue();
            }

            this.updateAllButtons();
            this.changed = true;
         }

         if (var1.id == 201) {
            ShaderOption[] var6 = Shaders.getChangedOptions(Shaders.getShaderPackOptions());

            for(int var7 = 0; var7 < var6.length; ++var7) {
               ShaderOption var4 = var6[var7];
               var4.resetValue();
               this.changed = true;
            }

            this.updateAllButtons();
         }

         if (var1.id == 200) {
            if (this.changed) {
               Shaders.saveShaderPackOptions();
               this.changed = false;
               Shaders.uninit();
            }

            this.mc.displayGuiScreen(this.prevScreen);
         }
      }

   }

   protected void actionPerformedRightClick(GuiButton var1) {
      if (var1 instanceof GuiButtonShaderOption) {
         GuiButtonShaderOption var2 = (GuiButtonShaderOption)var1;
         ShaderOption var3 = var2.getShaderOption();
         if (isShiftKeyDown()) {
            var3.resetValue();
         } else if (var2.isSwitchable()) {
            var3.prevValue();
         }

         this.updateAllButtons();
         this.changed = true;
      }

   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      if (this.screenText != null) {
         this.drawCenteredString(this.fontRendererObj, this.screenText, width / 2, 15, 16777215);
      } else {
         this.drawCenteredString(this.fontRendererObj, this.title, width / 2, 15, 16777215);
      }

      super.drawScreen(var1, var2, var3);
      this.tooltipManager.drawTooltips(var1, var2, this.buttonList);
   }

   public static String getButtonText(ShaderOption var0, int var1) {
      String var2 = var0.getNameText();
      if (var0 instanceof ShaderOptionScreen) {
         ShaderOptionScreen var6 = (ShaderOptionScreen)var0;
         return var2 + "...";
      } else {
         FontRenderer var3 = Config.getMinecraft().fontRendererObj;

         for(int var4 = var3.getStringWidth(": " + Lang.getOff()) + 5; var3.getStringWidth(var2) + var4 >= var1 && var2.length() > 0; var2 = var2.substring(0, var2.length() - 1)) {
         }

         String var7 = var0.isChanged() ? var0.getValueColor(var0.getValue()) : "";
         String var5 = var0.getValueText(var0.getValue());
         return var2 + ": " + var7 + var5;
      }
   }

   private void updateAllButtons() {
      Iterator var2 = this.buttonList.iterator();

      while(var2.hasNext()) {
         GuiButton var1 = (GuiButton)var2.next();
         if (var1 instanceof GuiButtonShaderOption) {
            GuiButtonShaderOption var3 = (GuiButtonShaderOption)var1;
            ShaderOption var4 = var3.getShaderOption();
            if (var4 instanceof ShaderOptionProfile) {
               ShaderOptionProfile var5 = (ShaderOptionProfile)var4;
               var5.updateProfile();
            }

            var3.displayString = getButtonText(var4, var3.getButtonWidth());
            var3.valueChanged();
         }
      }

   }

   public GuiShaderOptions(GuiScreen var1, GameSettings var2, String var3) {
      this(var1, var2);
      this.screenName = var3;
      if (var3 != null) {
         this.screenText = Shaders.translate("screen." + var3, var3);
      }

   }

   public void onGuiClosed() {
      super.onGuiClosed();
      if (this.changed) {
         Shaders.saveShaderPackOptions();
         this.changed = false;
         Shaders.uninit();
      }

   }
}
