package net.minecraft.realms;

import java.net.InetAddress;
import java.net.UnknownHostException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetHandlerLoginClient;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.handshake.client.C00Handshake;
import net.minecraft.network.login.client.C00PacketLoginStart;
import net.minecraft.util.ChatComponentTranslation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RealmsConnect {
   private final RealmsScreen onlineScreen;
   private NetworkManager connection;
   private static final Logger LOGGER = LogManager.getLogger();
   private boolean aborted = false;

   static void access$1(RealmsConnect var0, NetworkManager var1) {
      var0.connection = var1;
   }

   public void connect(String var1, int var2) {
      Realms.setConnectedToRealms(true);
      (new Thread(this, "Realms-connect-task", var1, var2) {
         final RealmsConnect this$0;
         private final int val$p_connect_2_;
         private final String val$p_connect_1_;

         {
            this.this$0 = var1;
            this.val$p_connect_1_ = var3;
            this.val$p_connect_2_ = var4;
         }

         public void run() {
            InetAddress var1 = null;

            try {
               var1 = InetAddress.getByName(this.val$p_connect_1_);
               if (RealmsConnect.access$0(this.this$0)) {
                  return;
               }

               RealmsConnect.access$1(this.this$0, NetworkManager.createNetworkManagerAndConnect(var1, this.val$p_connect_2_, Minecraft.getMinecraft().gameSettings.isUsingNativeTransport()));
               if (RealmsConnect.access$0(this.this$0)) {
                  return;
               }

               RealmsConnect.access$2(this.this$0).setNetHandler(new NetHandlerLoginClient(RealmsConnect.access$2(this.this$0), Minecraft.getMinecraft(), RealmsConnect.access$3(this.this$0).getProxy()));
               if (RealmsConnect.access$0(this.this$0)) {
                  return;
               }

               RealmsConnect.access$2(this.this$0).sendPacket(new C00Handshake(47, this.val$p_connect_1_, this.val$p_connect_2_, EnumConnectionState.LOGIN));
               if (RealmsConnect.access$0(this.this$0)) {
                  return;
               }

               RealmsConnect.access$2(this.this$0).sendPacket(new C00PacketLoginStart(Minecraft.getMinecraft().getSession().getProfile()));
            } catch (UnknownHostException var5) {
               Realms.clearResourcePack();
               if (RealmsConnect.access$0(this.this$0)) {
                  return;
               }

               RealmsConnect.access$4().error("Couldn't connect to world", var5);
               Minecraft.getMinecraft().getResourcePackRepository().clearResourcePack();
               Realms.setScreen(new DisconnectedRealmsScreen(RealmsConnect.access$3(this.this$0), "connect.failed", new ChatComponentTranslation("disconnect.genericReason", new Object[]{"Unknown host '" + this.val$p_connect_1_ + "'"})));
            } catch (Exception var6) {
               Realms.clearResourcePack();
               if (RealmsConnect.access$0(this.this$0)) {
                  return;
               }

               RealmsConnect.access$4().error("Couldn't connect to world", var6);
               String var3 = var6.toString();
               if (var1 != null) {
                  String var4 = var1.toString() + ":" + this.val$p_connect_2_;
                  var3 = var3.replaceAll(var4, "");
               }

               Realms.setScreen(new DisconnectedRealmsScreen(RealmsConnect.access$3(this.this$0), "connect.failed", new ChatComponentTranslation("disconnect.genericReason", new Object[]{var3})));
            }

         }
      }).start();
   }

   static NetworkManager access$2(RealmsConnect var0) {
      return var0.connection;
   }

   public void abort() {
      this.aborted = true;
   }

   static RealmsScreen access$3(RealmsConnect var0) {
      return var0.onlineScreen;
   }

   public RealmsConnect(RealmsScreen var1) {
      this.onlineScreen = var1;
   }

   static Logger access$4() {
      return LOGGER;
   }

   static boolean access$0(RealmsConnect var0) {
      return var0.aborted;
   }

   public void tick() {
      if (this.connection != null) {
         if (this.connection.isChannelOpen()) {
            this.connection.processReceivedPackets();
         } else {
            this.connection.checkDisconnected();
         }
      }

   }
}
