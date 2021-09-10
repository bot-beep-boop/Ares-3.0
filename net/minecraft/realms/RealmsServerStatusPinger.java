package net.minecraft.realms;

import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.ServerStatusResponse;
import net.minecraft.network.handshake.client.C00Handshake;
import net.minecraft.network.status.INetHandlerStatusClient;
import net.minecraft.network.status.client.C00PacketServerQuery;
import net.minecraft.network.status.client.C01PacketPing;
import net.minecraft.network.status.server.S00PacketServerInfo;
import net.minecraft.network.status.server.S01PacketPong;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RealmsServerStatusPinger {
   private static final Logger LOGGER = LogManager.getLogger();
   private final List<NetworkManager> connections = Collections.synchronizedList(Lists.newArrayList());

   public void removeAll() {
      synchronized(this.connections) {
         Iterator var2 = this.connections.iterator();

         while(var2.hasNext()) {
            NetworkManager var3 = (NetworkManager)var2.next();
            if (var3.isChannelOpen()) {
               var2.remove();
               var3.closeChannel(new ChatComponentText("Cancelled"));
            }
         }

      }
   }

   public void pingServer(String var1, RealmsServerPing var2) throws UnknownHostException {
      if (var1 != null && !var1.startsWith("0.0.0.0") && !var1.isEmpty()) {
         RealmsServerAddress var3 = RealmsServerAddress.parseString(var1);
         NetworkManager var4 = NetworkManager.createNetworkManagerAndConnect(InetAddress.getByName(var3.getHost()), var3.getPort(), false);
         this.connections.add(var4);
         var4.setNetHandler(new INetHandlerStatusClient(this, var2, var4, var1) {
            private boolean field_154345_e;
            private final RealmsServerPing val$p_pingServer_2_;
            private final String val$p_pingServer_1_;
            private final NetworkManager val$networkmanager;
            final RealmsServerStatusPinger this$0;

            public void handleServerInfo(S00PacketServerInfo var1) {
               ServerStatusResponse var2 = var1.getResponse();
               if (var2.getPlayerCountData() != null) {
                  this.val$p_pingServer_2_.nrOfPlayers = String.valueOf(var2.getPlayerCountData().getOnlinePlayerCount());
                  if (ArrayUtils.isNotEmpty(var2.getPlayerCountData().getPlayers())) {
                     StringBuilder var3 = new StringBuilder();
                     GameProfile[] var7;
                     int var6 = (var7 = var2.getPlayerCountData().getPlayers()).length;

                     for(int var5 = 0; var5 < var6; ++var5) {
                        GameProfile var4 = var7[var5];
                        if (var3.length() > 0) {
                           var3.append("\n");
                        }

                        var3.append(var4.getName());
                     }

                     if (var2.getPlayerCountData().getPlayers().length < var2.getPlayerCountData().getOnlinePlayerCount()) {
                        if (var3.length() > 0) {
                           var3.append("\n");
                        }

                        var3.append("... and ").append(var2.getPlayerCountData().getOnlinePlayerCount() - var2.getPlayerCountData().getPlayers().length).append(" more ...");
                     }

                     this.val$p_pingServer_2_.playerList = var3.toString();
                  }
               } else {
                  this.val$p_pingServer_2_.playerList = "";
               }

               this.val$networkmanager.sendPacket(new C01PacketPing(Realms.currentTimeMillis()));
               this.field_154345_e = true;
            }

            public void onDisconnect(IChatComponent var1) {
               if (!this.field_154345_e) {
                  RealmsServerStatusPinger.access$0().error("Can't ping " + this.val$p_pingServer_1_ + ": " + var1.getUnformattedText());
               }

            }

            public void handlePong(S01PacketPong var1) {
               this.val$networkmanager.closeChannel(new ChatComponentText("Finished"));
            }

            {
               this.this$0 = var1;
               this.val$p_pingServer_2_ = var2;
               this.val$networkmanager = var3;
               this.val$p_pingServer_1_ = var4;
               this.field_154345_e = false;
            }
         });

         try {
            var4.sendPacket(new C00Handshake(RealmsSharedConstants.NETWORK_PROTOCOL_VERSION, var3.getHost(), var3.getPort(), EnumConnectionState.STATUS));
            var4.sendPacket(new C00PacketServerQuery());
         } catch (Throwable var6) {
            LOGGER.error(var6);
         }
      }

   }

   public void tick() {
      synchronized(this.connections) {
         Iterator var2 = this.connections.iterator();

         while(var2.hasNext()) {
            NetworkManager var3 = (NetworkManager)var2.next();
            if (var3.isChannelOpen()) {
               var3.processReceivedPackets();
            } else {
               var2.remove();
               var3.checkDisconnected();
            }
         }

      }
   }

   static Logger access$0() {
      return LOGGER;
   }
}
