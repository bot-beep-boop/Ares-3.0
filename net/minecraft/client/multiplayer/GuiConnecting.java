package net.minecraft.client.multiplayer;

import com.aresclient.discordrpc.DiscordApp;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.network.NetHandlerLoginClient;
import net.minecraft.client.resources.I18n;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.handshake.client.C00Handshake;
import net.minecraft.network.login.client.C00PacketLoginStart;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GuiConnecting extends GuiScreen {
   private NetworkManager networkManager;
   private final GuiScreen previousGuiScreen;
   private boolean cancel;
   private static final AtomicInteger CONNECTION_ID = new AtomicInteger(0);
   private static final Logger logger = LogManager.getLogger();

   static Logger access$5() {
      return logger;
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 0) {
         this.cancel = true;
         if (this.networkManager != null) {
            this.networkManager.closeChannel(new ChatComponentText("Aborted"));
         }

         this.mc.displayGuiScreen(this.previousGuiScreen);
      }

   }

   static NetworkManager access$3(GuiConnecting var0) {
      return var0.networkManager;
   }

   public void initGui() {
      this.buttonList.clear();
      this.buttonList.add(new GuiButton(0, width / 2 - 100, height / 4 + 120 + 12, I18n.format("gui.cancel")));
   }

   protected void keyTyped(char var1, int var2) throws IOException {
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      if (this.networkManager == null) {
         this.drawCenteredString(this.fontRendererObj, I18n.format("connect.connecting"), width / 2, height / 2 - 50, 16777215);
      } else {
         this.drawCenteredString(this.fontRendererObj, I18n.format("connect.authorizing"), width / 2, height / 2 - 50, 16777215);
      }

      super.drawScreen(var1, var2, var3);
   }

   public GuiConnecting(GuiScreen var1, Minecraft var2, String var3, int var4) {
      this.mc = var2;
      this.previousGuiScreen = var1;
      var2.loadWorld((WorldClient)null);
      this.connect(var3, var4);
   }

   static Minecraft access$1(GuiConnecting var0) {
      return var0.mc;
   }

   static boolean access$0(GuiConnecting var0) {
      return var0.cancel;
   }

   public GuiConnecting(GuiScreen var1, Minecraft var2, ServerData var3) {
      this.mc = var2;
      this.previousGuiScreen = var1;
      ServerAddress var4 = ServerAddress.fromString(var3.serverIP);
      var2.loadWorld((WorldClient)null);
      var2.setServerData(var3);
      this.connect(var4.getIP(), var4.getPort());
   }

   public void updateScreen() {
      if (this.networkManager != null) {
         if (this.networkManager.isChannelOpen()) {
            this.networkManager.processReceivedPackets();
         } else {
            this.networkManager.checkDisconnected();
         }
      }

   }

   static void access$2(GuiConnecting var0, NetworkManager var1) {
      var0.networkManager = var1;
   }

   static GuiScreen access$4(GuiConnecting var0) {
      return var0.previousGuiScreen;
   }

   private void connect(String var1, int var2) {
      DiscordApp.update(this.mc.getCurrentServerData().serverIP, "Ingame", true);
      logger.info("Connecting to " + var1 + ", " + var2);
      (new Thread(this, "Server Connector #" + CONNECTION_ID.incrementAndGet(), var1, var2) {
         final GuiConnecting this$0;
         private final String val$ip;
         private final int val$port;

         {
            this.this$0 = var1;
            this.val$ip = var3;
            this.val$port = var4;
         }

         public void run() {
            InetAddress var1 = null;

            try {
               if (GuiConnecting.access$0(this.this$0)) {
                  return;
               }

               var1 = InetAddress.getByName(this.val$ip);
               GuiConnecting.access$2(this.this$0, NetworkManager.createNetworkManagerAndConnect(var1, this.val$port, GuiConnecting.access$1(this.this$0).gameSettings.isUsingNativeTransport()));
               GuiConnecting.access$3(this.this$0).setNetHandler(new NetHandlerLoginClient(GuiConnecting.access$3(this.this$0), GuiConnecting.access$1(this.this$0), GuiConnecting.access$4(this.this$0)));
               GuiConnecting.access$3(this.this$0).sendPacket(new C00Handshake(47, this.val$ip, this.val$port, EnumConnectionState.LOGIN));
               GuiConnecting.access$3(this.this$0).sendPacket(new C00PacketLoginStart(GuiConnecting.access$1(this.this$0).getSession().getProfile()));
            } catch (UnknownHostException var5) {
               if (GuiConnecting.access$0(this.this$0)) {
                  return;
               }

               GuiConnecting.access$5().error("Couldn't connect to server", var5);
               GuiConnecting.access$1(this.this$0).displayGuiScreen(new GuiDisconnected(GuiConnecting.access$4(this.this$0), "connect.failed", new ChatComponentTranslation("disconnect.genericReason", new Object[]{"Unknown host"})));
            } catch (Exception var6) {
               if (GuiConnecting.access$0(this.this$0)) {
                  return;
               }

               GuiConnecting.access$5().error("Couldn't connect to server", var6);
               String var3 = var6.toString();
               if (var1 != null) {
                  String var4 = var1.toString() + ":" + this.val$port;
                  var3 = var3.replaceAll(var4, "");
               }

               GuiConnecting.access$1(this.this$0).displayGuiScreen(new GuiDisconnected(GuiConnecting.access$4(this.this$0), "connect.failed", new ChatComponentTranslation("disconnect.genericReason", new Object[]{var3})));
            }

         }
      }).start();
   }
}
