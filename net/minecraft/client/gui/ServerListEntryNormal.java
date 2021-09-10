package net.minecraft.client.gui;

import com.google.common.base.Charsets;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;
import java.awt.image.BufferedImage;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServerListEntryNormal implements GuiListExtended.IGuiListEntry {
   private final ServerData server;
   private long field_148298_f;
   private static final ResourceLocation SERVER_SELECTION_BUTTONS = new ResourceLocation("textures/gui/server_selection.png");
   private static final Logger logger = LogManager.getLogger();
   private final ResourceLocation serverIcon;
   private final Minecraft mc;
   private final GuiMultiplayer owner;
   private static final ResourceLocation UNKNOWN_SERVER = new ResourceLocation("textures/misc/unknown_server.png");
   private static final ThreadPoolExecutor field_148302_b = new ScheduledThreadPoolExecutor(5, (new ThreadFactoryBuilder()).setNameFormat("Server Pinger #%d").setDaemon(true).build());
   private String field_148299_g;
   private DynamicTexture field_148305_h;

   static GuiMultiplayer access$0(ServerListEntryNormal var0) {
      return var0.owner;
   }

   public ServerData getServerData() {
      return this.server;
   }

   private void prepareServerIcon() {
      if (this.server.getBase64EncodedIconData() == null) {
         this.mc.getTextureManager().deleteTexture(this.serverIcon);
         this.field_148305_h = null;
      } else {
         ByteBuf var1 = Unpooled.copiedBuffer(this.server.getBase64EncodedIconData(), Charsets.UTF_8);
         ByteBuf var2 = Base64.decode(var1);

         BufferedImage var3;
         label96: {
            try {
               var3 = TextureUtil.readBufferedImage(new ByteBufInputStream(var2));
               Validate.validState(var3.getWidth() == 64, "Must be 64 pixels wide", new Object[0]);
               Validate.validState(var3.getHeight() == 64, "Must be 64 pixels high", new Object[0]);
               break label96;
            } catch (Throwable var8) {
               logger.error("Invalid icon for server " + this.server.serverName + " (" + this.server.serverIP + ")", var8);
               this.server.setBase64EncodedIconData((String)null);
            } finally {
               var1.release();
               var2.release();
            }

            return;
         }

         if (this.field_148305_h == null) {
            this.field_148305_h = new DynamicTexture(var3.getWidth(), var3.getHeight());
            this.mc.getTextureManager().loadTexture(this.serverIcon, this.field_148305_h);
         }

         var3.getRGB(0, 0, var3.getWidth(), var3.getHeight(), this.field_148305_h.getTextureData(), 0, var3.getWidth());
         this.field_148305_h.updateDynamicTexture();
      }

   }

   private boolean func_178013_b() {
      return true;
   }

   public void mouseReleased(int var1, int var2, int var3, int var4, int var5, int var6) {
   }

   public boolean mousePressed(int var1, int var2, int var3, int var4, int var5, int var6) {
      if (var5 <= 32) {
         if (var5 < 32 && var5 > 16 && this.func_178013_b()) {
            this.owner.selectServer(var1);
            this.owner.connectToSelected();
            return true;
         }

         if (var5 < 16 && var6 < 16 && this.owner.func_175392_a(this, var1)) {
            this.owner.func_175391_a(this, var1, GuiScreen.isShiftKeyDown());
            return true;
         }

         if (var5 < 16 && var6 > 16 && this.owner.func_175394_b(this, var1)) {
            this.owner.func_175393_b(this, var1, GuiScreen.isShiftKeyDown());
            return true;
         }
      }

      this.owner.selectServer(var1);
      if (Minecraft.getSystemTime() - this.field_148298_f < 250L) {
         this.owner.connectToSelected();
      }

      this.field_148298_f = Minecraft.getSystemTime();
      return false;
   }

   public void drawEntry(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
      if (!this.server.field_78841_f) {
         this.server.field_78841_f = true;
         this.server.pingToServer = -2L;
         this.server.serverMOTD = "";
         this.server.populationInfo = "";
         field_148302_b.submit(new Runnable(this) {
            final ServerListEntryNormal this$0;

            {
               this.this$0 = var1;
            }

            public void run() {
               try {
                  ServerListEntryNormal.access$0(this.this$0).getOldServerPinger().ping(ServerListEntryNormal.access$1(this.this$0));
               } catch (UnknownHostException var2) {
                  ServerListEntryNormal.access$1(this.this$0).pingToServer = -1L;
                  ServerListEntryNormal.access$1(this.this$0).serverMOTD = EnumChatFormatting.DARK_RED + "Can't resolve hostname";
               } catch (Exception var3) {
                  ServerListEntryNormal.access$1(this.this$0).pingToServer = -1L;
                  ServerListEntryNormal.access$1(this.this$0).serverMOTD = EnumChatFormatting.DARK_RED + "Can't connect to server.";
               }

            }
         });
      }

      boolean var9 = this.server.version > 47;
      boolean var10 = this.server.version < 47;
      boolean var11 = var9 || var10;
      this.mc.fontRendererObj.drawString(this.server.serverName, var2 + 32 + 3, var3 + 1, 16777215);
      List var12 = this.mc.fontRendererObj.listFormattedStringToWidth(this.server.serverMOTD, var4 - 32 - 2);

      for(int var13 = 0; var13 < Math.min(var12.size(), 2); ++var13) {
         this.mc.fontRendererObj.drawString((String)var12.get(var13), var2 + 32 + 3, var3 + 12 + this.mc.fontRendererObj.FONT_HEIGHT * var13, 8421504);
      }

      String var23 = var11 ? EnumChatFormatting.DARK_RED + this.server.gameVersion : this.server.populationInfo;
      int var14 = this.mc.fontRendererObj.getStringWidth(var23);
      this.mc.fontRendererObj.drawString(var23, var2 + var4 - var14 - 15 - 2, var3 + 1, 8421504);
      byte var15 = 0;
      String var16 = null;
      int var17;
      String var18;
      if (var11) {
         var17 = 5;
         var18 = var9 ? "Client out of date!" : "Server out of date!";
         var16 = this.server.playerList;
      } else if (this.server.field_78841_f && this.server.pingToServer != -2L) {
         if (this.server.pingToServer < 0L) {
            var17 = 5;
         } else if (this.server.pingToServer < 150L) {
            var17 = 0;
         } else if (this.server.pingToServer < 300L) {
            var17 = 1;
         } else if (this.server.pingToServer < 600L) {
            var17 = 2;
         } else if (this.server.pingToServer < 1000L) {
            var17 = 3;
         } else {
            var17 = 4;
         }

         if (this.server.pingToServer < 0L) {
            var18 = "(no connection)";
         } else {
            var18 = this.server.pingToServer + "ms";
            var16 = this.server.playerList;
         }
      } else {
         var15 = 1;
         var17 = (int)(Minecraft.getSystemTime() / 100L + (long)(var1 * 2) & 7L);
         if (var17 > 4) {
            var17 = 8 - var17;
         }

         var18 = "Pinging...";
      }

      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      this.mc.getTextureManager().bindTexture(Gui.icons);
      Gui.drawModalRectWithCustomSizedTexture(var2 + var4 - 15, var3, (float)(var15 * 10), (float)(176 + var17 * 8), 10, 8, 256.0F, 256.0F);
      if (this.server.getBase64EncodedIconData() != null && !this.server.getBase64EncodedIconData().equals(this.field_148299_g)) {
         this.field_148299_g = this.server.getBase64EncodedIconData();
         this.prepareServerIcon();
         this.owner.getServerList().saveServerList();
      }

      if (this.field_148305_h != null) {
         this.drawTextureAt(var2, var3, this.serverIcon);
      } else {
         this.drawTextureAt(var2, var3, UNKNOWN_SERVER);
      }

      int var19 = var6 - var2;
      int var20 = var7 - var3;
      if (var19 >= var4 - 15 && var19 <= var4 - 5 && var20 >= 0 && var20 <= 8) {
         this.owner.setHoveringText(var18);
      } else if (var19 >= var4 - var14 - 15 - 2 && var19 <= var4 - 15 - 2 && var20 >= 0 && var20 <= 8) {
         this.owner.setHoveringText(var16);
      }

      if (this.mc.gameSettings.touchscreen || var8) {
         this.mc.getTextureManager().bindTexture(SERVER_SELECTION_BUTTONS);
         Gui.drawRect(var2, var3, var2 + 32, var3 + 32, -1601138544);
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         int var21 = var6 - var2;
         int var22 = var7 - var3;
         if (this.func_178013_b()) {
            if (var21 < 32 && var21 > 16) {
               Gui.drawModalRectWithCustomSizedTexture(var2, var3, 0.0F, 32.0F, 32, 32, 256.0F, 256.0F);
            } else {
               Gui.drawModalRectWithCustomSizedTexture(var2, var3, 0.0F, 0.0F, 32, 32, 256.0F, 256.0F);
            }
         }

         if (this.owner.func_175392_a(this, var1)) {
            if (var21 < 16 && var22 < 16) {
               Gui.drawModalRectWithCustomSizedTexture(var2, var3, 96.0F, 32.0F, 32, 32, 256.0F, 256.0F);
            } else {
               Gui.drawModalRectWithCustomSizedTexture(var2, var3, 96.0F, 0.0F, 32, 32, 256.0F, 256.0F);
            }
         }

         if (this.owner.func_175394_b(this, var1)) {
            if (var21 < 16 && var22 > 16) {
               Gui.drawModalRectWithCustomSizedTexture(var2, var3, 64.0F, 32.0F, 32, 32, 256.0F, 256.0F);
            } else {
               Gui.drawModalRectWithCustomSizedTexture(var2, var3, 64.0F, 0.0F, 32, 32, 256.0F, 256.0F);
            }
         }
      }

   }

   static ServerData access$1(ServerListEntryNormal var0) {
      return var0.server;
   }

   protected ServerListEntryNormal(GuiMultiplayer var1, ServerData var2) {
      this.owner = var1;
      this.server = var2;
      this.mc = Minecraft.getMinecraft();
      this.serverIcon = new ResourceLocation("servers/" + var2.serverIP + "/icon");
      this.field_148305_h = (DynamicTexture)this.mc.getTextureManager().getTexture(this.serverIcon);
   }

   public void setSelected(int var1, int var2, int var3) {
   }

   protected void drawTextureAt(int var1, int var2, ResourceLocation var3) {
      this.mc.getTextureManager().bindTexture(var3);
      GlStateManager.enableBlend();
      Gui.drawModalRectWithCustomSizedTexture(var1, var2, 0.0F, 0.0F, 32, 32, 32.0F, 32.0F);
      GlStateManager.disableBlend();
   }
}
