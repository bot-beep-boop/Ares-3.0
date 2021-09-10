package net.minecraft.client.gui.achievement;

import java.io.IOException;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.IProgressMeter;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;

public class GuiAchievements extends GuiScreen implements IProgressMeter {
   protected int field_146563_h;
   protected GuiScreen parentScreen;
   private static final int field_146572_y;
   private static final int field_146571_z;
   private static final int field_146560_B;
   private int field_146554_D;
   private static final ResourceLocation ACHIEVEMENT_BACKGROUND;
   protected int field_146557_g = 202;
   protected double field_146566_v;
   private StatFileWriter statFileWriter;
   protected double field_146567_u;
   private boolean loadingAchievements = true;
   protected double field_146568_t;
   private static final int field_146559_A;
   protected double field_146565_w;
   protected double field_146573_x;
   protected int field_146564_i;
   protected double field_146569_s;
   protected int field_146555_f = 256;
   protected float field_146570_r = 1.0F;

   public void updateScreen() {
      if (!this.loadingAchievements) {
         this.field_146569_s = this.field_146567_u;
         this.field_146568_t = this.field_146566_v;
         double var1 = this.field_146565_w - this.field_146567_u;
         double var3 = this.field_146573_x - this.field_146566_v;
         if (var1 * var1 + var3 * var3 < 4.0D) {
            this.field_146567_u += var1;
            this.field_146566_v += var3;
         } else {
            this.field_146567_u += var1 * 0.85D;
            this.field_146566_v += var3 * 0.85D;
         }
      }

   }

   protected void drawTitle() {
      int var1 = (width - this.field_146555_f) / 2;
      int var2 = (height - this.field_146557_g) / 2;
      this.fontRendererObj.drawString(I18n.format("gui.achievements"), var1 + 15, var2 + 5, 4210752);
   }

   private TextureAtlasSprite func_175371_a(Block var1) {
      return Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getTexture(var1.getDefaultState());
   }

   public void initGui() {
      this.mc.getNetHandler().addToSendQueue(new C16PacketClientStatus(C16PacketClientStatus.EnumState.REQUEST_STATS));
      this.buttonList.clear();
      this.buttonList.add(new GuiOptionButton(1, width / 2 + 24, height / 2 + 74, 80, 20, I18n.format("gui.done")));
   }

   static {
      field_146572_y = AchievementList.minDisplayColumn * 24 - 112;
      field_146571_z = AchievementList.minDisplayRow * 24 - 112;
      field_146559_A = AchievementList.maxDisplayColumn * 24 - 77;
      field_146560_B = AchievementList.maxDisplayRow * 24 - 77;
      ACHIEVEMENT_BACKGROUND = new ResourceLocation("textures/gui/achievement/achievement_background.png");
   }

   public GuiAchievements(GuiScreen var1, StatFileWriter var2) {
      this.parentScreen = var1;
      this.statFileWriter = var2;
      short var3 = 141;
      short var4 = 141;
      this.field_146569_s = this.field_146567_u = this.field_146565_w = (double)(AchievementList.openInventory.displayColumn * 24 - var3 / 2 - 12);
      this.field_146568_t = this.field_146566_v = this.field_146573_x = (double)(AchievementList.openInventory.displayRow * 24 - var4 / 2);
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (!this.loadingAchievements && var1.id == 1) {
         this.mc.displayGuiScreen(this.parentScreen);
      }

   }

   public boolean doesGuiPauseGame() {
      return !this.loadingAchievements;
   }

   protected void keyTyped(char var1, int var2) throws IOException {
      if (var2 == this.mc.gameSettings.keyBindInventory.getKeyCode()) {
         this.mc.displayGuiScreen((GuiScreen)null);
         this.mc.setIngameFocus();
      } else {
         super.keyTyped(var1, var2);
      }

   }

   public void drawScreen(int var1, int var2, float var3) {
      if (this.loadingAchievements) {
         this.drawDefaultBackground();
         this.drawCenteredString(this.fontRendererObj, I18n.format("multiplayer.downloadingStats"), width / 2, height / 2, 16777215);
         this.drawCenteredString(this.fontRendererObj, lanSearchStates[(int)(Minecraft.getSystemTime() / 150L % (long)lanSearchStates.length)], width / 2, height / 2 + this.fontRendererObj.FONT_HEIGHT * 2, 16777215);
      } else {
         int var4;
         if (Mouse.isButtonDown(0)) {
            var4 = (width - this.field_146555_f) / 2;
            int var5 = (height - this.field_146557_g) / 2;
            int var6 = var4 + 8;
            int var7 = var5 + 17;
            if ((this.field_146554_D == 0 || this.field_146554_D == 1) && var1 >= var6 && var1 < var6 + 224 && var2 >= var7 && var2 < var7 + 155) {
               if (this.field_146554_D == 0) {
                  this.field_146554_D = 1;
               } else {
                  this.field_146567_u -= (double)((float)(var1 - this.field_146563_h) * this.field_146570_r);
                  this.field_146566_v -= (double)((float)(var2 - this.field_146564_i) * this.field_146570_r);
                  this.field_146565_w = this.field_146569_s = this.field_146567_u;
                  this.field_146573_x = this.field_146568_t = this.field_146566_v;
               }

               this.field_146563_h = var1;
               this.field_146564_i = var2;
            }
         } else {
            this.field_146554_D = 0;
         }

         var4 = Mouse.getDWheel();
         float var11 = this.field_146570_r;
         if (var4 < 0) {
            this.field_146570_r += 0.25F;
         } else if (var4 > 0) {
            this.field_146570_r -= 0.25F;
         }

         this.field_146570_r = MathHelper.clamp_float(this.field_146570_r, 1.0F, 2.0F);
         if (this.field_146570_r != var11) {
            float var10000 = var11 - this.field_146570_r;
            float var12 = var11 * (float)this.field_146555_f;
            float var8 = var11 * (float)this.field_146557_g;
            float var9 = this.field_146570_r * (float)this.field_146555_f;
            float var10 = this.field_146570_r * (float)this.field_146557_g;
            this.field_146567_u -= (double)((var9 - var12) * 0.5F);
            this.field_146566_v -= (double)((var10 - var8) * 0.5F);
            this.field_146565_w = this.field_146569_s = this.field_146567_u;
            this.field_146573_x = this.field_146568_t = this.field_146566_v;
         }

         if (this.field_146565_w < (double)field_146572_y) {
            this.field_146565_w = (double)field_146572_y;
         }

         if (this.field_146573_x < (double)field_146571_z) {
            this.field_146573_x = (double)field_146571_z;
         }

         if (this.field_146565_w >= (double)field_146559_A) {
            this.field_146565_w = (double)(field_146559_A - 1);
         }

         if (this.field_146573_x >= (double)field_146560_B) {
            this.field_146573_x = (double)(field_146560_B - 1);
         }

         this.drawDefaultBackground();
         this.drawAchievementScreen(var1, var2, var3);
         GlStateManager.disableLighting();
         GlStateManager.disableDepth();
         this.drawTitle();
         GlStateManager.enableLighting();
         GlStateManager.enableDepth();
      }

   }

   public void doneLoading() {
      if (this.loadingAchievements) {
         this.loadingAchievements = false;
      }

   }

   protected void drawAchievementScreen(int var1, int var2, float var3) {
      int var4 = MathHelper.floor_double(this.field_146569_s + (this.field_146567_u - this.field_146569_s) * (double)var3);
      int var5 = MathHelper.floor_double(this.field_146568_t + (this.field_146566_v - this.field_146568_t) * (double)var3);
      if (var4 < field_146572_y) {
         var4 = field_146572_y;
      }

      if (var5 < field_146571_z) {
         var5 = field_146571_z;
      }

      if (var4 >= field_146559_A) {
         var4 = field_146559_A - 1;
      }

      if (var5 >= field_146560_B) {
         var5 = field_146560_B - 1;
      }

      int var6 = (width - this.field_146555_f) / 2;
      int var7 = (height - this.field_146557_g) / 2;
      int var8 = var6 + 16;
      int var9 = var7 + 17;
      zLevel = 0.0F;
      GlStateManager.depthFunc(518);
      GlStateManager.pushMatrix();
      GlStateManager.translate((float)var8, (float)var9, -200.0F);
      GlStateManager.scale(1.0F / this.field_146570_r, 1.0F / this.field_146570_r, 0.0F);
      GlStateManager.enableTexture2D();
      GlStateManager.disableLighting();
      GlStateManager.enableRescaleNormal();
      GlStateManager.enableColorMaterial();
      int var10 = var4 + 288 >> 4;
      int var11 = var5 + 288 >> 4;
      int var12 = (var4 + 288) % 16;
      int var13 = (var5 + 288) % 16;
      boolean var14 = true;
      boolean var15 = true;
      boolean var16 = true;
      boolean var17 = true;
      boolean var18 = true;
      Random var19 = new Random();
      float var20 = 16.0F / this.field_146570_r;
      float var21 = 16.0F / this.field_146570_r;

      int var22;
      float var23;
      int var24;
      int var25;
      for(var22 = 0; (float)var22 * var20 - (float)var13 < 155.0F; ++var22) {
         var23 = 0.6F - (float)(var11 + var22) / 25.0F * 0.3F;
         GlStateManager.color(var23, var23, var23, 1.0F);

         for(var24 = 0; (float)var24 * var21 - (float)var12 < 224.0F; ++var24) {
            var19.setSeed((long)(this.mc.getSession().getPlayerID().hashCode() + var10 + var24 + (var11 + var22) * 16));
            var25 = var19.nextInt(1 + var11 + var22) + (var11 + var22) / 2;
            TextureAtlasSprite var26 = this.func_175371_a(Blocks.sand);
            if (var25 <= 37 && var11 + var22 != 35) {
               if (var25 == 22) {
                  if (var19.nextInt(2) == 0) {
                     var26 = this.func_175371_a(Blocks.diamond_ore);
                  } else {
                     var26 = this.func_175371_a(Blocks.redstone_ore);
                  }
               } else if (var25 == 10) {
                  var26 = this.func_175371_a(Blocks.iron_ore);
               } else if (var25 == 8) {
                  var26 = this.func_175371_a(Blocks.coal_ore);
               } else if (var25 > 4) {
                  var26 = this.func_175371_a(Blocks.stone);
               } else if (var25 > 0) {
                  var26 = this.func_175371_a(Blocks.dirt);
               }
            } else {
               Block var27 = Blocks.bedrock;
               var26 = this.func_175371_a(var27);
            }

            this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
            this.drawTexturedModalRect(var24 * 16 - var12, var22 * 16 - var13, var26, 16, 16);
         }
      }

      GlStateManager.enableDepth();
      GlStateManager.depthFunc(515);
      this.mc.getTextureManager().bindTexture(ACHIEVEMENT_BACKGROUND);

      int var30;
      int var31;
      int var37;
      for(var22 = 0; var22 < AchievementList.achievementList.size(); ++var22) {
         Achievement var34 = (Achievement)AchievementList.achievementList.get(var22);
         if (var34.parentAchievement != null) {
            var24 = var34.displayColumn * 24 - var4 + 11;
            var25 = var34.displayRow * 24 - var5 + 11;
            int var39 = var34.parentAchievement.displayColumn * 24 - var4 + 11;
            var37 = var34.parentAchievement.displayRow * 24 - var5 + 11;
            boolean var28 = this.statFileWriter.hasAchievementUnlocked(var34);
            boolean var29 = this.statFileWriter.canUnlockAchievement(var34);
            var30 = this.statFileWriter.func_150874_c(var34);
            if (var30 <= 4) {
               var31 = -16777216;
               if (var28) {
                  var31 = -6250336;
               } else if (var29) {
                  var31 = -16711936;
               }

               this.drawHorizontalLine(var24, var39, var25, var31);
               this.drawVerticalLine(var39, var25, var37, var31);
               if (var24 > var39) {
                  drawTexturedModalRect(var24 - 11 - 7, var25 - 5, 114, 234, 7, 11);
               } else if (var24 < var39) {
                  drawTexturedModalRect(var24 + 11, var25 - 5, 107, 234, 7, 11);
               } else if (var25 > var37) {
                  drawTexturedModalRect(var24 - 5, var25 - 11 - 7, 96, 234, 11, 7);
               } else if (var25 < var37) {
                  drawTexturedModalRect(var24 - 5, var25 + 11, 96, 241, 11, 7);
               }
            }
         }
      }

      Achievement var33 = null;
      var23 = (float)(var1 - var8) * this.field_146570_r;
      float var35 = (float)(var2 - var9) * this.field_146570_r;
      RenderHelper.enableGUIStandardItemLighting();
      GlStateManager.disableLighting();
      GlStateManager.enableRescaleNormal();
      GlStateManager.enableColorMaterial();

      int var38;
      int var41;
      for(var25 = 0; var25 < AchievementList.achievementList.size(); ++var25) {
         Achievement var40 = (Achievement)AchievementList.achievementList.get(var25);
         var37 = var40.displayColumn * 24 - var4;
         var38 = var40.displayRow * 24 - var5;
         if (var37 >= -24 && var38 >= -24 && (float)var37 <= 224.0F * this.field_146570_r && (float)var38 <= 155.0F * this.field_146570_r) {
            var41 = this.statFileWriter.func_150874_c(var40);
            float var43;
            if (this.statFileWriter.hasAchievementUnlocked(var40)) {
               var43 = 0.75F;
               GlStateManager.color(var43, var43, var43, 1.0F);
            } else if (this.statFileWriter.canUnlockAchievement(var40)) {
               var43 = 1.0F;
               GlStateManager.color(var43, var43, var43, 1.0F);
            } else if (var41 < 3) {
               var43 = 0.3F;
               GlStateManager.color(var43, var43, var43, 1.0F);
            } else if (var41 == 3) {
               var43 = 0.2F;
               GlStateManager.color(var43, var43, var43, 1.0F);
            } else {
               if (var41 != 4) {
                  continue;
               }

               var43 = 0.1F;
               GlStateManager.color(var43, var43, var43, 1.0F);
            }

            this.mc.getTextureManager().bindTexture(ACHIEVEMENT_BACKGROUND);
            if (var40.getSpecial()) {
               drawTexturedModalRect(var37 - 2, var38 - 2, 26, 202, 26, 26);
            } else {
               drawTexturedModalRect(var37 - 2, var38 - 2, 0, 202, 26, 26);
            }

            if (!this.statFileWriter.canUnlockAchievement(var40)) {
               var43 = 0.1F;
               GlStateManager.color(var43, var43, var43, 1.0F);
               this.itemRender.isNotRenderingEffectsInGUI(false);
            }

            GlStateManager.enableLighting();
            GlStateManager.enableCull();
            this.itemRender.renderItemAndEffectIntoGUI(var40.theItemStack, var37 + 3, var38 + 3);
            GlStateManager.blendFunc(770, 771);
            GlStateManager.disableLighting();
            if (!this.statFileWriter.canUnlockAchievement(var40)) {
               this.itemRender.isNotRenderingEffectsInGUI(true);
            }

            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            if (var23 >= (float)var37 && var23 <= (float)(var37 + 22) && var35 >= (float)var38 && var35 <= (float)(var38 + 22)) {
               var33 = var40;
            }
         }
      }

      GlStateManager.disableDepth();
      GlStateManager.enableBlend();
      GlStateManager.popMatrix();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      this.mc.getTextureManager().bindTexture(ACHIEVEMENT_BACKGROUND);
      drawTexturedModalRect(var6, var7, 0, 0, this.field_146555_f, this.field_146557_g);
      zLevel = 0.0F;
      GlStateManager.depthFunc(515);
      GlStateManager.disableDepth();
      GlStateManager.enableTexture2D();
      super.drawScreen(var1, var2, var3);
      if (var33 != null) {
         String var36 = var33.getStatName().getUnformattedText();
         String var42 = var33.getDescription();
         var37 = var1 + 12;
         var38 = var2 - 4;
         var41 = this.statFileWriter.func_150874_c(var33);
         if (this.statFileWriter.canUnlockAchievement(var33)) {
            var30 = Math.max(this.fontRendererObj.getStringWidth(var36), 120);
            var31 = this.fontRendererObj.splitStringWidth(var42, var30);
            if (this.statFileWriter.hasAchievementUnlocked(var33)) {
               var31 += 12;
            }

            this.drawGradientRect(var37 - 3, var38 - 3, var37 + var30 + 3, var38 + var31 + 3 + 12, -1073741824, -1073741824);
            this.fontRendererObj.drawSplitString(var42, var37, var38 + 12, var30, -6250336);
            if (this.statFileWriter.hasAchievementUnlocked(var33)) {
               this.fontRendererObj.drawStringWithShadow(I18n.format("achievement.taken"), (float)var37, (float)(var38 + var31 + 4), -7302913);
            }
         } else {
            int var32;
            String var44;
            if (var41 == 3) {
               var36 = I18n.format("achievement.unknown");
               var30 = Math.max(this.fontRendererObj.getStringWidth(var36), 120);
               var44 = (new ChatComponentTranslation("achievement.requires", new Object[]{var33.parentAchievement.getStatName()})).getUnformattedText();
               var32 = this.fontRendererObj.splitStringWidth(var44, var30);
               this.drawGradientRect(var37 - 3, var38 - 3, var37 + var30 + 3, var38 + var32 + 12 + 3, -1073741824, -1073741824);
               this.fontRendererObj.drawSplitString(var44, var37, var38 + 12, var30, -9416624);
            } else if (var41 < 3) {
               var30 = Math.max(this.fontRendererObj.getStringWidth(var36), 120);
               var44 = (new ChatComponentTranslation("achievement.requires", new Object[]{var33.parentAchievement.getStatName()})).getUnformattedText();
               var32 = this.fontRendererObj.splitStringWidth(var44, var30);
               this.drawGradientRect(var37 - 3, var38 - 3, var37 + var30 + 3, var38 + var32 + 12 + 3, -1073741824, -1073741824);
               this.fontRendererObj.drawSplitString(var44, var37, var38 + 12, var30, -9416624);
            } else {
               var36 = null;
            }
         }

         if (var36 != null) {
            this.fontRendererObj.drawStringWithShadow(var36, (float)var37, (float)var38, this.statFileWriter.canUnlockAchievement(var33) ? (var33.getSpecial() ? -128 : -1) : (var33.getSpecial() ? -8355776 : -8355712));
         }
      }

      GlStateManager.enableDepth();
      GlStateManager.enableLighting();
      RenderHelper.disableStandardItemLighting();
   }
}
