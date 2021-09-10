package net.minecraft.client.gui;

import com.aresclient.discordrpc.DiscordApp;
import com.aresclient.utils.GuiImages;
import com.aresclient.utils.update.Updater;
import com.aresclient.visuals.GuiLogin;
import com.aresclient.visuals.utils.AnimatedButton;
import com.aresclient.visuals.utils.ImageButton;
import com.aresclient.visuals.utils.items.DropDownMenu;
import com.google.common.collect.Lists;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.realms.RealmsBridge;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.demo.DemoWorldServer;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.WorldInfo;
import net.optifine.CustomPanorama;
import net.optifine.CustomPanoramaProperties;
import net.optifine.reflect.Reflector;
import org.apache.commons.io.Charsets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.Project;

public class GuiMainMenu extends GuiScreen implements GuiYesNoCallback {
   private static final ResourceLocation[] titlePanoramaPaths = new ResourceLocation[]{new ResourceLocation("textures/gui/title/background/panorama_0.png"), new ResourceLocation("textures/gui/title/background/panorama_1.png"), new ResourceLocation("textures/gui/title/background/panorama_2.png"), new ResourceLocation("textures/gui/title/background/panorama_3.png"), new ResourceLocation("textures/gui/title/background/panorama_4.png"), new ResourceLocation("textures/gui/title/background/panorama_5.png")};
   private GuiButton modButton;
   private int field_92023_s;
   private String openGLWarningLink;
   private int field_92019_w;
   private String openGLWarning1;
   private boolean field_175375_v = true;
   private static final Random RANDOM = new Random();
   private int panoramaTimer;
   private GuiButton buttonResetDemo;
   private String openGLWarning2;
   private String splashText;
   private static final ResourceLocation minecraftTitleTextures = new ResourceLocation("textures/gui/title/minecraft.png");
   public static final String field_96138_a;
   private int field_92022_t;
   private float updateCounter;
   private static final ResourceLocation splashTexts = new ResourceLocation("texts/splashes.txt");
   private GuiButton realmsButton;
   private boolean field_183502_L;
   private static final Logger logger = LogManager.getLogger();
   private int field_92020_v;
   private DynamicTexture viewportTexture;
   private final Object threadLock = new Object();
   public static int wallpaper = 1;
   private static final AtomicInteger field_175373_f = new AtomicInteger(0);
   private int field_92024_r;
   private ResourceLocation backgroundTexture;
   private GuiScreen modUpdateNotification;
   private int field_92021_u;
   private GuiScreen field_183503_M;

   public void onGuiClosed() {
      if (this.field_183503_M != null) {
         this.field_183503_M.onGuiClosed();
      }

   }

   public void drawScreen(int var1, int var2, float var3) {
      GlStateManager.disableAlpha();
      GlStateManager.pushMatrix();
      GlStateManager.translate((float)(GuiScreen.width / 2 + 90), 70.0F, 0.0F);
      GlStateManager.rotate(-20.0F, 0.0F, 0.0F, 1.0F);
      GlStateManager.popMatrix();
      this.drawDefaultBackground();
      GuiImages.drawBackgroundPicture(GuiScreen.width, GuiScreen.height, "Ares/Wallpaper/bg" + wallpaper + ".png");
      if (!Updater.IsUptoday) {
         this.drawRoundedRect(3, 3, 90, 25, 3, Color.DARK_GRAY);
         this.drawString(this.fontRendererObj, "New Update!", 27, 12, Color.white.getRGB());
         DropDownMenu.drawTexture(new ResourceLocation("Ares/Icons/Logos/Light.png"), 7.0F, 7.0F, 18.0F, 18.0F);
      }

      this.drawRoundedRect(3, 3, 90, 25, 3, Color.DARK_GRAY);
      this.drawString(this.fontRendererObj, "BETA CLIENT", 27, 12, Color.white.getRGB());
      DropDownMenu.drawTexture(new ResourceLocation("Ares/Icons/Logos/Light.png"), 7.0F, 7.0F, 18.0F, 18.0F);
      if (this.openGLWarning1 != null && this.openGLWarning1.length() > 0) {
         drawRect(this.field_92022_t - 2, this.field_92021_u - 2, this.field_92020_v + 2, this.field_92019_w - 1, 1428160512);
         this.drawString(this.fontRendererObj, this.openGLWarning1, this.field_92022_t, this.field_92021_u, -1);
         this.drawString(this.fontRendererObj, this.openGLWarning2, (GuiScreen.width - this.field_92024_r) / 2, ((GuiButton)this.buttonList.get(0)).yPosition - 12, -1);
      }

      super.drawScreen(var1, var2, var3);
      if (this.func_183501_a()) {
         this.field_183503_M.drawScreen(var1, var2, var3);
      }

      if (this.modUpdateNotification != null) {
         this.modUpdateNotification.drawScreen(var1, var2, var3);
      }

   }

   private boolean func_183501_a() {
      return Minecraft.getMinecraft().gameSettings.getOptionOrdinalValue(GameSettings.Options.REALMS_NOTIFICATIONS) && this.field_183503_M != null;
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 0) {
         this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
      }

      if (var1.id == 5) {
         this.mc.displayGuiScreen(new GuiLogin(this));
      }

      if (var1.id == 1) {
         this.mc.displayGuiScreen(new GuiSelectWorld(this));
      }

      if (var1.id == 2) {
         this.mc.displayGuiScreen(new GuiMultiplayer(this));
      }

      if (var1.id == 14 && this.realmsButton.visible) {
         this.switchToRealms();
      }

      if (var1.id == 4) {
         this.mc.shutdown();
      }

      if (var1.id == 6 && Reflector.GuiModList_Constructor.exists()) {
         this.mc.displayGuiScreen((GuiScreen)Reflector.newInstance(Reflector.GuiModList_Constructor, this));
      }

      if (var1.id == 11) {
         this.mc.launchIntegratedServer("Demo_World", "Demo_World", DemoWorldServer.demoWorldSettings);
      }

      if (var1.id == 10) {
         if (wallpaper <= 3) {
            ++wallpaper;
         } else {
            wallpaper = 1;
         }
      }

      if (var1.id == 12) {
         ISaveFormat var2 = this.mc.getSaveLoader();
         WorldInfo var3 = var2.getWorldInfo("Demo_World");
         if (var3 != null) {
            GuiYesNo var4 = GuiSelectWorld.makeDeleteWorldYesNo(this, var3.getWorldName(), 12);
            this.mc.displayGuiScreen(var4);
         }
      }

   }

   private void switchToRealms() {
      RealmsBridge var1 = new RealmsBridge();
      var1.switchToRealms(this);
   }

   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      super.mouseClicked(var1, var2, var3);
      synchronized(this.threadLock) {
         if (this.openGLWarning1.length() > 0 && var1 >= this.field_92022_t && var1 <= this.field_92020_v && var2 >= this.field_92021_u && var2 <= this.field_92019_w) {
            GuiConfirmOpenLink var5 = new GuiConfirmOpenLink(this, this.openGLWarningLink, 13, true);
            var5.disableSecurityWarning();
            this.mc.displayGuiScreen(var5);
         }
      }

      if (this.func_183501_a()) {
         this.field_183503_M.mouseClicked(var1, var2, var3);
      }

   }

   protected void keyTyped(char var1, int var2) throws IOException {
   }

   private void rotateAndBlurSkybox(float var1) {
      this.mc.getTextureManager().bindTexture(this.backgroundTexture);
      GL11.glTexParameteri(3553, 10241, 9729);
      GL11.glTexParameteri(3553, 10240, 9729);
      GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, 256, 256);
      GlStateManager.enableBlend();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.colorMask(true, true, true, false);
      Tessellator var2 = Tessellator.getInstance();
      WorldRenderer var3 = var2.getWorldRenderer();
      var3.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
      GlStateManager.disableAlpha();
      byte var4 = 3;
      int var5 = 3;
      CustomPanoramaProperties var6 = CustomPanorama.getCustomPanoramaProperties();
      if (var6 != null) {
         var5 = var6.getBlur2();
      }

      for(int var7 = 0; var7 < var5; ++var7) {
         float var8 = 1.0F / (float)(var7 + 1);
         int var9 = GuiScreen.width;
         int var10 = GuiScreen.height;
         float var11 = (float)(var7 - var4 / 2) / 256.0F;
         var3.pos((double)var9, (double)var10, (double)Gui.zLevel).tex((double)(0.0F + var11), 1.0D).color(1.0F, 1.0F, 1.0F, var8).endVertex();
         var3.pos((double)var9, 0.0D, (double)Gui.zLevel).tex((double)(1.0F + var11), 1.0D).color(1.0F, 1.0F, 1.0F, var8).endVertex();
         var3.pos(0.0D, 0.0D, (double)Gui.zLevel).tex((double)(1.0F + var11), 0.0D).color(1.0F, 1.0F, 1.0F, var8).endVertex();
         var3.pos(0.0D, (double)var10, (double)Gui.zLevel).tex((double)(0.0F + var11), 0.0D).color(1.0F, 1.0F, 1.0F, var8).endVertex();
      }

      var2.draw();
      GlStateManager.enableAlpha();
      GlStateManager.colorMask(true, true, true, true);
   }

   public boolean doesGuiPauseGame() {
      return false;
   }

   public GuiMainMenu() {
      this.openGLWarning2 = field_96138_a;
      this.field_183502_L = false;
      this.splashText = "missingno";
      BufferedReader var1 = null;

      try {
         ArrayList var2 = Lists.newArrayList();
         var1 = new BufferedReader(new InputStreamReader(Minecraft.getMinecraft().getResourceManager().getResource(splashTexts).getInputStream(), Charsets.UTF_8));

         String var3;
         while((var3 = var1.readLine()) != null) {
            var3 = var3.trim();
            if (!var3.isEmpty()) {
               var2.add(var3);
            }
         }

         if (!var2.isEmpty()) {
            do {
               this.splashText = (String)var2.get(RANDOM.nextInt(var2.size()));
            } while(this.splashText.hashCode() == 125780783);
         }
      } catch (IOException var12) {
      } finally {
         if (var1 != null) {
            try {
               var1.close();
            } catch (IOException var11) {
            }
         }

      }

      this.updateCounter = RANDOM.nextFloat();
      this.openGLWarning1 = "";
      if (!GLContext.getCapabilities().OpenGL20 && !OpenGlHelper.areShadersSupported()) {
         this.openGLWarning1 = I18n.format("title.oldgl1");
         this.openGLWarning2 = I18n.format("title.oldgl2");
         this.openGLWarningLink = "https://help.mojang.com/customer/portal/articles/325948?ref=game";
      }

   }

   private void addSingleplayerMultiplayerButtons(int var1, int var2) {
      this.buttonList.add(new GuiButton(1, GuiScreen.width / 2 - 100, var1, I18n.format("menu.singleplayer")));
      this.buttonList.add(new GuiButton(2, GuiScreen.width / 2 - 100, var1 + var2 * 1, I18n.format("menu.multiplayer")));
      if (Reflector.GuiModList_Constructor.exists()) {
         this.buttonList.add(this.realmsButton = new GuiButton(14, GuiScreen.width / 2 + 2, var1 + var2 * 2, 98, 20, I18n.format("menu.online").replace("Minecraft", "").trim()));
         this.buttonList.add(this.modButton = new GuiButton(6, GuiScreen.width / 2 - 100, var1 + var2 * 2, 98, 20, I18n.format("fml.menu.mods")));
      } else {
         this.buttonList.add(this.realmsButton = new GuiButton(14, GuiScreen.width / 2 - 100, var1 + var2 * 2, I18n.format("menu.online")));
      }

   }

   public void confirmClicked(boolean var1, int var2) {
      if (var1 && var2 == 12) {
         ISaveFormat var6 = this.mc.getSaveLoader();
         var6.flushCache();
         var6.deleteWorldDirectory("Demo_World");
         this.mc.displayGuiScreen(this);
      } else if (var2 == 13) {
         if (var1) {
            try {
               Class var3 = Class.forName("java.awt.Desktop");
               Object var4 = var3.getMethod("getDesktop").invoke((Object)null);
               var3.getMethod("browse", URI.class).invoke(var4, new URI(this.openGLWarningLink));
            } catch (Throwable var5) {
               logger.error("Couldn't open link", var5);
            }
         }

         this.mc.displayGuiScreen(this);
      }

   }

   private void drawPanorama(int var1, int var2, float var3) {
      Tessellator var4 = Tessellator.getInstance();
      WorldRenderer var5 = var4.getWorldRenderer();
      GlStateManager.matrixMode(5889);
      GlStateManager.pushMatrix();
      GlStateManager.loadIdentity();
      Project.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
      GlStateManager.matrixMode(5888);
      GlStateManager.pushMatrix();
      GlStateManager.loadIdentity();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);
      GlStateManager.rotate(90.0F, 0.0F, 0.0F, 1.0F);
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      GlStateManager.disableCull();
      GlStateManager.depthMask(false);
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      byte var6 = 8;
      int var7 = 64;
      CustomPanoramaProperties var8 = CustomPanorama.getCustomPanoramaProperties();
      if (var8 != null) {
         var7 = var8.getBlur1();
      }

      for(int var9 = 0; var9 < var7; ++var9) {
         GlStateManager.pushMatrix();
         float var10 = ((float)(var9 % var6) / (float)var6 - 0.5F) / 64.0F;
         float var11 = ((float)(var9 / var6) / (float)var6 - 0.5F) / 64.0F;
         float var12 = 0.0F;
         GlStateManager.translate(var10, var11, var12);
         GlStateManager.rotate(MathHelper.sin(((float)this.panoramaTimer + var3) / 400.0F) * 25.0F + 20.0F, 1.0F, 0.0F, 0.0F);
         GlStateManager.rotate(-((float)this.panoramaTimer + var3) * 0.1F, 0.0F, 1.0F, 0.0F);

         for(int var13 = 0; var13 < 6; ++var13) {
            GlStateManager.pushMatrix();
            if (var13 == 1) {
               GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
            }

            if (var13 == 2) {
               GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
            }

            if (var13 == 3) {
               GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
            }

            if (var13 == 4) {
               GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
            }

            if (var13 == 5) {
               GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
            }

            ResourceLocation[] var14 = titlePanoramaPaths;
            if (var8 != null) {
               var14 = var8.getPanoramaLocations();
            }

            this.mc.getTextureManager().bindTexture(var14[var13]);
            var5.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            int var15 = 255 / (var9 + 1);
            float var16 = 0.0F;
            var5.pos(-1.0D, -1.0D, 1.0D).tex(0.0D, 0.0D).color(255, 255, 255, var15).endVertex();
            var5.pos(1.0D, -1.0D, 1.0D).tex(1.0D, 0.0D).color(255, 255, 255, var15).endVertex();
            var5.pos(1.0D, 1.0D, 1.0D).tex(1.0D, 1.0D).color(255, 255, 255, var15).endVertex();
            var5.pos(-1.0D, 1.0D, 1.0D).tex(0.0D, 1.0D).color(255, 255, 255, var15).endVertex();
            var4.draw();
            GlStateManager.popMatrix();
         }

         GlStateManager.popMatrix();
         GlStateManager.colorMask(true, true, true, false);
      }

      var5.setTranslation(0.0D, 0.0D, 0.0D);
      GlStateManager.colorMask(true, true, true, true);
      GlStateManager.matrixMode(5889);
      GlStateManager.popMatrix();
      GlStateManager.matrixMode(5888);
      GlStateManager.popMatrix();
      GlStateManager.depthMask(true);
      GlStateManager.enableCull();
      GlStateManager.enableDepth();
   }

   private void addDemoButtons(int var1, int var2) {
      this.buttonList.add(new GuiButton(11, GuiScreen.width / 2 - 100, var1, I18n.format("menu.playdemo")));
      this.buttonList.add(this.buttonResetDemo = new GuiButton(12, GuiScreen.width / 2 - 100, var1 + var2 * 1, I18n.format("menu.resetdemo")));
      ISaveFormat var3 = this.mc.getSaveLoader();
      WorldInfo var4 = var3.getWorldInfo("Demo_World");
      if (var4 == null) {
         this.buttonResetDemo.enabled = false;
      }

   }

   private void renderSkybox(int var1, int var2, float var3) {
      this.mc.getFramebuffer().unbindFramebuffer();
      GlStateManager.viewport(0, 0, 256, 256);
      this.drawPanorama(var1, var2, var3);
      this.rotateAndBlurSkybox(var3);
      int var4 = 3;
      CustomPanoramaProperties var5 = CustomPanorama.getCustomPanoramaProperties();
      if (var5 != null) {
         var4 = var5.getBlur3();
      }

      for(int var6 = 0; var6 < var4; ++var6) {
         this.rotateAndBlurSkybox(var3);
         this.rotateAndBlurSkybox(var3);
      }

      this.mc.getFramebuffer().bindFramebuffer(true);
      GlStateManager.viewport(0, 0, this.mc.displayWidth, this.mc.displayHeight);
      float var13 = GuiScreen.width > GuiScreen.height ? 120.0F / (float)GuiScreen.width : 120.0F / (float)GuiScreen.height;
      float var7 = (float)GuiScreen.height * var13 / 256.0F;
      float var8 = (float)GuiScreen.width * var13 / 256.0F;
      int var9 = GuiScreen.width;
      int var10 = GuiScreen.height;
      Tessellator var11 = Tessellator.getInstance();
      WorldRenderer var12 = var11.getWorldRenderer();
      var12.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
      var12.pos(0.0D, (double)var10, (double)Gui.zLevel).tex((double)(0.5F - var7), (double)(0.5F + var8)).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
      var12.pos((double)var9, (double)var10, (double)Gui.zLevel).tex((double)(0.5F - var7), (double)(0.5F - var8)).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
      var12.pos((double)var9, 0.0D, (double)Gui.zLevel).tex((double)(0.5F + var7), (double)(0.5F - var8)).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
      var12.pos(0.0D, 0.0D, (double)Gui.zLevel).tex((double)(0.5F + var7), (double)(0.5F + var8)).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
      var11.draw();
   }

   public void initGui() {
      DiscordApp.update("Menu", "", false);
      int var1 = GuiScreen.height / 4;
      this.buttonList.add(new ImageButton(10, GuiScreen.width / 2 - var1 / 2, GuiScreen.height / 2 - var1 / 2, var1, var1, new ResourceLocation("Ares/Icons/Logos/Light.png")));
      int var2 = GuiScreen.height / 10;
      this.buttonList.add(new AnimatedButton(1, GuiScreen.width / 2 - var2 * 2 - var2 / 2, GuiScreen.height - var2 - 10, var2, var2, "Ares/Icons/Animated/Singleplayer/Singleplayer ("));
      this.buttonList.add(new AnimatedButton(2, GuiScreen.width / 2 - var2 * 1 - var2 / 2, GuiScreen.height - var2 - 10, var2, var2, "Ares/Icons/Animated/Multiplayer/Multiplayer ("));
      this.buttonList.add(new AnimatedButton(5, GuiScreen.width / 2 - var2 / 2, GuiScreen.height - var2 - 10, var2, var2, "Ares/Icons/Animated/Login/Login ("));
      this.buttonList.add(new AnimatedButton(0, GuiScreen.width / 2 + var2 * 1 - var2 / 2, GuiScreen.height - var2 - 10, var2, var2, "Ares/Icons/Animated/Settings/Settings ("));
      this.buttonList.add(new AnimatedButton(4, GuiScreen.width / 2 + var2 * 2 - var2 / 2, GuiScreen.height - var2 - 10, var2, var2, "Ares/Icons/Animated/Exit/Exit ("));
   }

   private void drawArc(int var1, int var2, int var3, int var4, int var5, Color var6) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f((float)var6.getRed() / 255.0F, (float)var6.getGreen() / 255.0F, (float)var6.getBlue() / 255.0F, (float)var6.getAlpha() / 255.0F);
      WorldRenderer var7 = Tessellator.getInstance().getWorldRenderer();
      var7.begin(6, DefaultVertexFormats.POSITION);
      var7.pos((double)var1, (double)var2, 0.0D).endVertex();

      for(int var8 = (int)((double)var4 / 360.0D * 100.0D); var8 <= (int)((double)var5 / 360.0D * 100.0D); ++var8) {
         double var9 = 6.283185307179586D * (double)var8 / 100.0D + Math.toRadians(180.0D);
         var7.pos((double)var1 + Math.sin(var9) * (double)var3, (double)var2 + Math.cos(var9) * (double)var3, 0.0D).endVertex();
      }

      Tessellator.getInstance().draw();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   static {
      field_96138_a = "Please click " + EnumChatFormatting.UNDERLINE + "here" + EnumChatFormatting.RESET + " for more information.";
   }

   private void drawRoundedRect(int var1, int var2, int var3, int var4, int var5, Color var6) {
      Gui.drawRect(var1, var2 + var5, var1 + var5, var2 + var4 - var5, var6.getRGB());
      Gui.drawRect(var1 + var5, var2, var1 + var3 - var5, var2 + var4, var6.getRGB());
      Gui.drawRect(var1 + var3 - var5, var2 + var5, var1 + var3, var2 + var4 - var5, var6.getRGB());
      this.drawArc(var1 + var5, var2 + var5, var5, 0, 90, var6);
      this.drawArc(var1 + var3 - var5, var2 + var5, var5, 270, 360, var6);
      this.drawArc(var1 + var3 - var5, var2 + var4 - var5, var5, 180, 270, var6);
      this.drawArc(var1 + var5, var2 + var4 - var5, var5, 90, 180, var6);
   }

   public void updateScreen() {
      ++this.panoramaTimer;
      if (this.func_183501_a()) {
         this.field_183503_M.updateScreen();
      }

   }
}
