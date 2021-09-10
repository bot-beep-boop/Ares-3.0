package net.minecraft.client.gui;

import com.aresclient.utils.notification.Notification;
import com.aresclient.utils.notification.NotificationManager;
import com.aresclient.utils.notification.NotificationType;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.stream.GuiTwitchUserMode;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.EntityList;
import net.minecraft.event.ClickEvent;
import net.minecraft.event.HoverEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.JsonToNBT;
import net.minecraft.nbt.NBTException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatList;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IChatComponent;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import tv.twitch.chat.ChatUserInfo;

public abstract class GuiScreen extends Gui implements GuiYesNoCallback {
   protected List<GuiLabel> labelList = Lists.newArrayList();
   private int touchValue;
   protected FontRenderer fontRendererObj;
   private long lastMouseEvent;
   private GuiButton selectedButton;
   private static final Set<String> PROTOCOLS = Sets.newHashSet(new String[]{"http", "https"});
   protected List<GuiButton> buttonList = Lists.newArrayList();
   static String cosmetics = "";
   public static int width;
   protected RenderItem itemRender;
   protected int eventButton;
   protected Minecraft mc;
   private static final Logger LOGGER = LogManager.getLogger();
   private static final Splitter NEWLINE_SPLITTER = Splitter.on('\n');
   public boolean allowUserInput;
   public static int height;
   private URI clickedLinkURI;

   public void confirmClicked(boolean var1, int var2) {
      if (var2 == 31102009) {
         if (var1) {
            this.openWebLink(this.clickedLinkURI);
         }

         this.clickedLinkURI = null;
         this.mc.displayGuiScreen(this);
      }

   }

   protected void renderToolTip(ItemStack var1, int var2, int var3) {
      List var4 = var1.getTooltip(this.mc.thePlayer, this.mc.gameSettings.advancedItemTooltips);

      for(int var5 = 0; var5 < var4.size(); ++var5) {
         if (var5 == 0) {
            var4.set(var5, var1.getRarity().rarityColor + (String)var4.get(var5));
         } else {
            var4.set(var5, EnumChatFormatting.GRAY + (String)var4.get(var5));
         }
      }

      this.drawHoveringText(var4, var2, var3);
   }

   protected void setText(String var1, boolean var2) {
   }

   public static boolean isKeyComboCtrlA(int var0) {
      return var0 == 30 && isCtrlKeyDown() && !isShiftKeyDown() && !isAltKeyDown();
   }

   protected boolean handleComponentClick(IChatComponent var1) {
      if (var1 == null) {
         return false;
      } else {
         ClickEvent var2 = var1.getChatStyle().getChatClickEvent();
         if (isShiftKeyDown()) {
            if (var1.getChatStyle().getInsertion() != null) {
               this.setText(var1.getChatStyle().getInsertion(), false);
            }
         } else if (var2 != null) {
            URI var3;
            if (var2.getAction() == ClickEvent.Action.OPEN_URL) {
               if (!this.mc.gameSettings.chatLinks) {
                  return false;
               }

               try {
                  var3 = new URI(var2.getValue());
                  String var4 = var3.getScheme();
                  if (var4 == null) {
                     throw new URISyntaxException(var2.getValue(), "Missing protocol");
                  }

                  if (!PROTOCOLS.contains(var4.toLowerCase())) {
                     throw new URISyntaxException(var2.getValue(), "Unsupported protocol: " + var4.toLowerCase());
                  }

                  if (this.mc.gameSettings.chatLinksPrompt) {
                     this.clickedLinkURI = var3;
                     this.mc.displayGuiScreen(new GuiConfirmOpenLink(this, var2.getValue(), 31102009, false));
                  } else {
                     this.openWebLink(var3);
                  }
               } catch (URISyntaxException var5) {
                  LOGGER.error("Can't open url for " + var2, var5);
               }
            } else if (var2.getAction() == ClickEvent.Action.OPEN_FILE) {
               var3 = (new File(var2.getValue())).toURI();
               this.openWebLink(var3);
            } else if (var2.getAction() == ClickEvent.Action.SUGGEST_COMMAND) {
               this.setText(var2.getValue(), true);
            } else if (var2.getAction() == ClickEvent.Action.RUN_COMMAND) {
               this.sendChatMessage(var2.getValue(), false);
            } else if (var2.getAction() == ClickEvent.Action.TWITCH_USER_INFO) {
               ChatUserInfo var6 = this.mc.getTwitchStream().func_152926_a(var2.getValue());
               if (var6 != null) {
                  this.mc.displayGuiScreen(new GuiTwitchUserMode(this.mc.getTwitchStream(), var6));
               } else {
                  LOGGER.error("Tried to handle twitch user but couldn't find them!");
               }
            } else {
               LOGGER.error("Don't know how to handle " + var2);
            }

            return true;
         }

         return false;
      }
   }

   protected void drawHoveringText(List<String> var1, int var2, int var3) {
      if (!var1.isEmpty()) {
         GlStateManager.disableRescaleNormal();
         RenderHelper.disableStandardItemLighting();
         GlStateManager.disableLighting();
         GlStateManager.disableDepth();
         int var4 = 0;
         Iterator var6 = var1.iterator();

         int var7;
         while(var6.hasNext()) {
            String var5 = (String)var6.next();
            var7 = this.fontRendererObj.getStringWidth(var5);
            if (var7 > var4) {
               var4 = var7;
            }
         }

         int var13 = var2 + 12;
         int var14 = var3 - 12;
         var7 = 8;
         if (var1.size() > 1) {
            var7 += 2 + (var1.size() - 1) * 10;
         }

         if (var13 + var4 > width) {
            var13 -= 28 + var4;
         }

         if (var14 + var7 + 6 > height) {
            var14 = height - var7 - 6;
         }

         zLevel = 300.0F;
         this.itemRender.zLevel = 300.0F;
         int var8 = -267386864;
         this.drawGradientRect(var13 - 3, var14 - 4, var13 + var4 + 3, var14 - 3, var8, var8);
         this.drawGradientRect(var13 - 3, var14 + var7 + 3, var13 + var4 + 3, var14 + var7 + 4, var8, var8);
         this.drawGradientRect(var13 - 3, var14 - 3, var13 + var4 + 3, var14 + var7 + 3, var8, var8);
         this.drawGradientRect(var13 - 4, var14 - 3, var13 - 3, var14 + var7 + 3, var8, var8);
         this.drawGradientRect(var13 + var4 + 3, var14 - 3, var13 + var4 + 4, var14 + var7 + 3, var8, var8);
         int var9 = 1347420415;
         int var10 = (var9 & 16711422) >> 1 | var9 & -16777216;
         this.drawGradientRect(var13 - 3, var14 - 3 + 1, var13 - 3 + 1, var14 + var7 + 3 - 1, var9, var10);
         this.drawGradientRect(var13 + var4 + 2, var14 - 3 + 1, var13 + var4 + 3, var14 + var7 + 3 - 1, var9, var10);
         this.drawGradientRect(var13 - 3, var14 - 3, var13 + var4 + 3, var14 - 3 + 1, var9, var9);
         this.drawGradientRect(var13 - 3, var14 + var7 + 2, var13 + var4 + 3, var14 + var7 + 3, var10, var10);

         for(int var11 = 0; var11 < var1.size(); ++var11) {
            String var12 = (String)var1.get(var11);
            this.fontRendererObj.drawStringWithShadow(var12, (float)var13, (float)var14, -1);
            if (var11 == 0) {
               var14 += 2;
            }

            var14 += 10;
         }

         zLevel = 0.0F;
         this.itemRender.zLevel = 0.0F;
         GlStateManager.enableLighting();
         GlStateManager.enableDepth();
         RenderHelper.enableStandardItemLighting();
         GlStateManager.enableRescaleNormal();
      }

   }

   public static boolean isShiftKeyDown() {
      return Keyboard.isKeyDown(42) || Keyboard.isKeyDown(54);
   }

   public void initGui() {
   }

   public void drawScreen(int var1, int var2, float var3) {
      int var4;
      for(var4 = 0; var4 < this.buttonList.size(); ++var4) {
         ((GuiButton)this.buttonList.get(var4)).drawButton(this.mc, var1, var2);
      }

      for(var4 = 0; var4 < this.labelList.size(); ++var4) {
         ((GuiLabel)this.labelList.get(var4)).drawLabel(this.mc, var1, var2);
      }

   }

   protected void mouseClickMove(int var1, int var2, int var3, long var4) {
   }

   public void onGuiClosed() {
   }

   public void sendChatMessage(String var1, boolean var2) {
      if (var2) {
         this.mc.ingameGUI.getChatGUI().addToSentMessages(var1);
      }

      this.mc.thePlayer.sendChatMessage(var1);
   }

   public void drawDefaultBackground() {
      this.drawWorldBackground(0);
   }

   public static boolean isKeyComboCtrlX(int var0) {
      return var0 == 45 && isCtrlKeyDown() && !isShiftKeyDown() && !isAltKeyDown();
   }

   public void setWorldAndResolution(Minecraft var1, int var2, int var3) {
      this.mc = var1;
      this.itemRender = var1.getRenderItem();
      this.fontRendererObj = var1.fontRendererObj;
      width = var2;
      height = var3;
      this.buttonList.clear();
      this.initGui();
   }

   protected void mouseReleased(int var1, int var2, int var3) {
      if (this.selectedButton != null && var3 == 0) {
         this.selectedButton.mouseReleased(var1, var2);
         this.selectedButton = null;
      }

   }

   public void handleMouseInput() throws IOException {
      int var1 = Mouse.getEventX() * width / this.mc.displayWidth;
      int var2 = height - Mouse.getEventY() * height / this.mc.displayHeight - 1;
      int var3 = Mouse.getEventButton();
      if (Mouse.getEventButtonState()) {
         if (this.mc.gameSettings.touchscreen && this.touchValue++ > 0) {
            return;
         }

         this.eventButton = var3;
         this.lastMouseEvent = Minecraft.getSystemTime();
         this.mouseClicked(var1, var2, this.eventButton);
      } else if (var3 != -1) {
         if (this.mc.gameSettings.touchscreen && --this.touchValue > 0) {
            return;
         }

         this.eventButton = -1;
         this.mouseReleased(var1, var2, var3);
      } else if (this.eventButton != -1 && this.lastMouseEvent > 0L) {
         long var4 = Minecraft.getSystemTime() - this.lastMouseEvent;
         this.mouseClickMove(var1, var2, this.eventButton, var4);
      }

   }

   protected void drawCreativeTabHoveringText(String var1, int var2, int var3) {
      this.drawHoveringText(Arrays.asList(var1), var2, var3);
   }

   public void handleKeyboardInput() throws IOException {
      char var1 = Keyboard.getEventCharacter();
      if (Keyboard.getEventKey() == 0 && var1 >= ' ' || Keyboard.getEventKeyState()) {
         this.keyTyped(var1, Keyboard.getEventKey());
      }

      this.mc.dispatchKeypresses();
   }

   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      if (var3 == 0) {
         for(int var4 = 0; var4 < this.buttonList.size(); ++var4) {
            GuiButton var5 = (GuiButton)this.buttonList.get(var4);
            if (var5.mousePressed(this.mc, var1, var2)) {
               this.selectedButton = var5;
               var5.playPressSound(this.mc.getSoundHandler());
               this.actionPerformed(var5);
            }
         }
      }

   }

   public static boolean isCtrlKeyDown() {
      if (Minecraft.isRunningOnMac) {
         return Keyboard.isKeyDown(219) || Keyboard.isKeyDown(220);
      } else {
         return Keyboard.isKeyDown(29) || Keyboard.isKeyDown(157);
      }
   }

   public void sendChatMessage(String var1) {
      if (var1.equals(".gm1")) {
         Minecraft.getMinecraft().thePlayer.sendChatMessage("/gamemode 1");
      } else if (var1.equals(".gm0")) {
         Minecraft.getMinecraft().thePlayer.sendChatMessage("/gamemode 0");
      } else if (var1.equals(".gm2")) {
         Minecraft.getMinecraft().thePlayer.sendChatMessage("/gamemode 2");
      } else if (var1.equals(".wc")) {
         Minecraft.getMinecraft().thePlayer.sendChatMessage("/weather clear");
      } else if (var1.equals(".day")) {
         Minecraft.getMinecraft().thePlayer.sendChatMessage("/time set day");
      } else if (var1.equals(".night")) {
         Minecraft.getMinecraft().thePlayer.sendChatMessage("/time set 18000");
      } else if (var1.equals(".sunset")) {
         Minecraft.getMinecraft().thePlayer.sendChatMessage("/time set 23800");
      } else if (var1.equals(".gm3")) {
         Minecraft.getMinecraft().thePlayer.sendChatMessage("/gamemode 3");
      } else if (!var1.equals(".c") && !var1.equals(".clear")) {
         if (var1.equals(".ip")) {
            NotificationManager.show(new Notification(NotificationType.WARNING, "Mods", Minecraft.getMinecraft().getCurrentServerData().serverIP, 2));
         } else if (var1.equals(".time")) {
            NotificationManager.show(new Notification(NotificationType.INFO, "Time:", "" + Minecraft.getMinecraft().theWorld.getTotalWorldTime(), 4));
         } else {
            this.sendChatMessage(var1, true);
         }
      } else {
         Minecraft.getMinecraft().ingameGUI.getChatGUI().clearChatMessages();
      }

   }

   public void onResize(Minecraft var1, int var2, int var3) {
      this.setWorldAndResolution(var1, var2, var3);
   }

   public void handleInput() throws IOException {
      if (Mouse.isCreated()) {
         while(Mouse.next()) {
            this.handleMouseInput();
         }
      }

      if (Keyboard.isCreated()) {
         while(Keyboard.next()) {
            this.handleKeyboardInput();
         }
      }

   }

   public boolean doesGuiPauseGame() {
      return true;
   }

   protected void handleComponentHover(IChatComponent var1, int var2, int var3) {
      if (var1 != null && var1.getChatStyle().getChatHoverEvent() != null) {
         HoverEvent var4 = var1.getChatStyle().getChatHoverEvent();
         if (var4.getAction() == HoverEvent.Action.SHOW_ITEM) {
            ItemStack var5 = null;

            try {
               NBTTagCompound var6 = JsonToNBT.getTagFromJson(var4.getValue().getUnformattedText());
               if (var6 instanceof NBTTagCompound) {
                  var5 = ItemStack.loadItemStackFromNBT((NBTTagCompound)var6);
               }
            } catch (NBTException var11) {
            }

            if (var5 != null) {
               this.renderToolTip(var5, var2, var3);
            } else {
               this.drawCreativeTabHoveringText(EnumChatFormatting.RED + "Invalid Item!", var2, var3);
            }
         } else {
            String var8;
            if (var4.getAction() == HoverEvent.Action.SHOW_ENTITY) {
               if (this.mc.gameSettings.advancedItemTooltips) {
                  try {
                     NBTTagCompound var12 = JsonToNBT.getTagFromJson(var4.getValue().getUnformattedText());
                     if (var12 instanceof NBTTagCompound) {
                        ArrayList var14 = Lists.newArrayList();
                        NBTTagCompound var7 = (NBTTagCompound)var12;
                        var14.add(var7.getString("name"));
                        if (var7.hasKey("type", 8)) {
                           var8 = var7.getString("type");
                           var14.add("Type: " + var8 + " (" + EntityList.getIDFromString(var8) + ")");
                        }

                        var14.add(var7.getString("id"));
                        this.drawHoveringText(var14, var2, var3);
                     } else {
                        this.drawCreativeTabHoveringText(EnumChatFormatting.RED + "Invalid Entity!", var2, var3);
                     }
                  } catch (NBTException var10) {
                     this.drawCreativeTabHoveringText(EnumChatFormatting.RED + "Invalid Entity!", var2, var3);
                  }
               }
            } else if (var4.getAction() == HoverEvent.Action.SHOW_TEXT) {
               this.drawHoveringText(NEWLINE_SPLITTER.splitToList(var4.getValue().getFormattedText()), var2, var3);
            } else if (var4.getAction() == HoverEvent.Action.SHOW_ACHIEVEMENT) {
               StatBase var13 = StatList.getOneShotStat(var4.getValue().getUnformattedText());
               if (var13 != null) {
                  IChatComponent var15 = var13.getStatName();
                  ChatComponentTranslation var16 = new ChatComponentTranslation("stats.tooltip.type." + (var13.isAchievement() ? "achievement" : "statistic"), new Object[0]);
                  var16.getChatStyle().setItalic(true);
                  var8 = var13 instanceof Achievement ? ((Achievement)var13).getDescription() : null;
                  ArrayList var9 = Lists.newArrayList(new String[]{var15.getFormattedText(), var16.getFormattedText()});
                  if (var8 != null) {
                     var9.addAll(this.fontRendererObj.listFormattedStringToWidth(var8, 150));
                  }

                  this.drawHoveringText(var9, var2, var3);
               } else {
                  this.drawCreativeTabHoveringText(EnumChatFormatting.RED + "Invalid statistic/achievement!", var2, var3);
               }
            }
         }

         GlStateManager.disableLighting();
      }

   }

   protected void actionPerformed(GuiButton var1) throws IOException {
   }

   public static String getClipboardString() {
      try {
         Transferable var0 = Toolkit.getDefaultToolkit().getSystemClipboard().getContents((Object)null);
         if (var0 != null && var0.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            return (String)var0.getTransferData(DataFlavor.stringFlavor);
         }
      } catch (Exception var1) {
      }

      return "";
   }

   public void drawBackground(int var1) {
      GlStateManager.disableLighting();
      GlStateManager.disableFog();
      Tessellator var2 = Tessellator.getInstance();
      WorldRenderer var3 = var2.getWorldRenderer();
      this.mc.getTextureManager().bindTexture(optionsBackground);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      float var4 = 32.0F;
      var3.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
      var3.pos(0.0D, (double)height, 0.0D).tex(0.0D, (double)((float)height / 32.0F + (float)var1)).color(64, 64, 64, 255).endVertex();
      var3.pos((double)width, (double)height, 0.0D).tex((double)((float)width / 32.0F), (double)((float)height / 32.0F + (float)var1)).color(64, 64, 64, 255).endVertex();
      var3.pos((double)width, 0.0D, 0.0D).tex((double)((float)width / 32.0F), (double)var1).color(64, 64, 64, 255).endVertex();
      var3.pos(0.0D, 0.0D, 0.0D).tex(0.0D, (double)var1).color(64, 64, 64, 255).endVertex();
      var2.draw();
   }

   public static void setClipboardString(String var0) {
      if (!StringUtils.isEmpty(var0)) {
         try {
            StringSelection var1 = new StringSelection(var0);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(var1, (ClipboardOwner)null);
         } catch (Exception var2) {
         }
      }

   }

   public static boolean isKeyComboCtrlC(int var0) {
      return var0 == 46 && isCtrlKeyDown() && !isShiftKeyDown() && !isAltKeyDown();
   }

   private void openWebLink(URI var1) {
      try {
         Class var2 = Class.forName("java.awt.Desktop");
         Object var3 = var2.getMethod("getDesktop").invoke((Object)null);
         var2.getMethod("browse", URI.class).invoke(var3, var1);
      } catch (Throwable var4) {
         LOGGER.error("Couldn't open link", var4);
      }

   }

   public void updateScreen() {
   }

   protected void keyTyped(char var1, int var2) throws IOException {
      if (var2 == 1) {
         this.mc.displayGuiScreen((GuiScreen)null);
         if (this.mc.currentScreen == null) {
            this.mc.setIngameFocus();
         }
      }

   }

   public static boolean isAltKeyDown() {
      return Keyboard.isKeyDown(56) || Keyboard.isKeyDown(184);
   }

   public void drawWorldBackground(int var1) {
      if (this.mc.theWorld != null) {
         this.drawGradientRect(0, 0, width, height, -1072689136, -804253680);
      } else {
         this.drawBackground(var1);
      }

   }

   public void setGuiSize(int var1, int var2) {
      width = var1;
      height = var2;
   }

   public static boolean isKeyComboCtrlV(int var0) {
      return var0 == 47 && isCtrlKeyDown() && !isShiftKeyDown() && !isAltKeyDown();
   }
}
