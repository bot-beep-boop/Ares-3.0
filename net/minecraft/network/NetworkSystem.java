package net.minecraft.network;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.local.LocalAddress;
import io.netty.channel.local.LocalEventLoopGroup;
import io.netty.channel.local.LocalServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import net.minecraft.client.network.NetHandlerHandshakeMemory;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.network.play.server.S40PacketDisconnect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.NetHandlerHandshakeTCP;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.LazyLoadBase;
import net.minecraft.util.MessageDeserializer;
import net.minecraft.util.MessageDeserializer2;
import net.minecraft.util.MessageSerializer;
import net.minecraft.util.MessageSerializer2;
import net.minecraft.util.ReportedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NetworkSystem {
   public boolean isAlive;
   private final List<NetworkManager> networkManagers = Collections.synchronizedList(Lists.newArrayList());
   public static final LazyLoadBase<NioEventLoopGroup> eventLoops = new LazyLoadBase<NioEventLoopGroup>() {
      protected Object load() {
         return this.load();
      }

      protected NioEventLoopGroup load() {
         return new NioEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Server IO #%d").setDaemon(true).build());
      }
   };
   public static final LazyLoadBase<LocalEventLoopGroup> SERVER_LOCAL_EVENTLOOP = new LazyLoadBase<LocalEventLoopGroup>() {
      protected Object load() {
         return this.load();
      }

      protected LocalEventLoopGroup load() {
         return new LocalEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Local Server IO #%d").setDaemon(true).build());
      }
   };
   private final MinecraftServer mcServer;
   private final List<ChannelFuture> endpoints = Collections.synchronizedList(Lists.newArrayList());
   private static final Logger logger = LogManager.getLogger();
   public static final LazyLoadBase<EpollEventLoopGroup> SERVER_EPOLL_EVENTLOOP = new LazyLoadBase<EpollEventLoopGroup>() {
      protected EpollEventLoopGroup load() {
         return new EpollEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Epoll Server IO #%d").setDaemon(true).build());
      }

      protected Object load() {
         return this.load();
      }
   };

   public MinecraftServer getServer() {
      return this.mcServer;
   }

   static MinecraftServer access$1(NetworkSystem var0) {
      return var0.mcServer;
   }

   public void addLanEndpoint(InetAddress var1, int var2) throws IOException {
      synchronized(this.endpoints) {
         Class var4;
         LazyLoadBase var5;
         if (Epoll.isAvailable() && this.mcServer.shouldUseNativeTransport()) {
            var4 = EpollServerSocketChannel.class;
            var5 = SERVER_EPOLL_EVENTLOOP;
            logger.info("Using epoll channel type");
         } else {
            var4 = NioServerSocketChannel.class;
            var5 = eventLoops;
            logger.info("Using default channel type");
         }

         this.endpoints.add(((ServerBootstrap)((ServerBootstrap)(new ServerBootstrap()).channel(var4)).childHandler(new ChannelInitializer<Channel>(this) {
            final NetworkSystem this$0;

            protected void initChannel(Channel var1) throws Exception {
               try {
                  var1.config().setOption(ChannelOption.TCP_NODELAY, true);
               } catch (ChannelException var3) {
               }

               var1.pipeline().addLast("timeout", new ReadTimeoutHandler(30)).addLast("legacy_query", new PingResponseHandler(this.this$0)).addLast("splitter", new MessageDeserializer2()).addLast("decoder", new MessageDeserializer(EnumPacketDirection.SERVERBOUND)).addLast("prepender", new MessageSerializer2()).addLast("encoder", new MessageSerializer(EnumPacketDirection.CLIENTBOUND));
               NetworkManager var2 = new NetworkManager(EnumPacketDirection.SERVERBOUND);
               NetworkSystem.access$0(this.this$0).add(var2);
               var1.pipeline().addLast("packet_handler", var2);
               var2.setNetHandler(new NetHandlerHandshakeTCP(NetworkSystem.access$1(this.this$0), var2));
            }

            {
               this.this$0 = var1;
            }
         }).group((EventLoopGroup)var5.getValue()).localAddress(var1, var2)).bind().syncUninterruptibly());
      }
   }

   static List access$0(NetworkSystem var0) {
      return var0.networkManagers;
   }

   public NetworkSystem(MinecraftServer var1) {
      this.mcServer = var1;
      this.isAlive = true;
   }

   public void networkTick() {
      synchronized(this.networkManagers) {
         Iterator var2 = this.networkManagers.iterator();

         while(true) {
            while(true) {
               NetworkManager var3;
               do {
                  if (!var2.hasNext()) {
                     return;
                  }

                  var3 = (NetworkManager)var2.next();
               } while(var3.hasNoChannel());

               if (!var3.isChannelOpen()) {
                  var2.remove();
                  var3.checkDisconnected();
               } else {
                  try {
                     var3.processReceivedPackets();
                  } catch (Exception var7) {
                     if (var3.isLocalChannel()) {
                        CrashReport var9 = CrashReport.makeCrashReport(var7, "Ticking memory connection");
                        CrashReportCategory var6 = var9.makeCategory("Ticking connection");
                        var6.addCrashSectionCallable("Connection", new Callable<String>(this, var3) {
                           final NetworkSystem this$0;
                           private final NetworkManager val$networkmanager;

                           public Object call() throws Exception {
                              return this.call();
                           }

                           {
                              this.this$0 = var1;
                              this.val$networkmanager = var2;
                           }

                           public String call() throws Exception {
                              return this.val$networkmanager.toString();
                           }
                        });
                        throw new ReportedException(var9);
                     }

                     logger.warn("Failed to handle packet for " + var3.getRemoteAddress(), var7);
                     ChatComponentText var5 = new ChatComponentText("Internal server error");
                     var3.sendPacket(new S40PacketDisconnect(var5), new GenericFutureListener<Future<? super Void>>(this, var3, var5) {
                        final NetworkSystem this$0;
                        private final NetworkManager val$networkmanager;
                        private final ChatComponentText val$chatcomponenttext;

                        {
                           this.this$0 = var1;
                           this.val$networkmanager = var2;
                           this.val$chatcomponenttext = var3;
                        }

                        public void operationComplete(Future<? super Void> var1) throws Exception {
                           this.val$networkmanager.closeChannel(this.val$chatcomponenttext);
                        }
                     });
                     var3.disableAutoRead();
                  }
               }
            }
         }
      }
   }

   public void terminateEndpoints() {
      this.isAlive = false;
      Iterator var2 = this.endpoints.iterator();

      while(var2.hasNext()) {
         ChannelFuture var1 = (ChannelFuture)var2.next();

         try {
            var1.channel().close().sync();
         } catch (InterruptedException var4) {
            logger.error("Interrupted whilst closing channel");
         }
      }

   }

   public SocketAddress addLocalEndpoint() {
      ChannelFuture var1;
      synchronized(this.endpoints) {
         var1 = ((ServerBootstrap)((ServerBootstrap)(new ServerBootstrap()).channel(LocalServerChannel.class)).childHandler(new ChannelInitializer<Channel>(this) {
            final NetworkSystem this$0;

            {
               this.this$0 = var1;
            }

            protected void initChannel(Channel var1) throws Exception {
               NetworkManager var2 = new NetworkManager(EnumPacketDirection.SERVERBOUND);
               var2.setNetHandler(new NetHandlerHandshakeMemory(NetworkSystem.access$1(this.this$0), var2));
               NetworkSystem.access$0(this.this$0).add(var2);
               var1.pipeline().addLast("packet_handler", var2);
            }
         }).group((EventLoopGroup)eventLoops.getValue()).localAddress(LocalAddress.ANY)).bind().syncUninterruptibly();
         this.endpoints.add(var1);
      }

      return var1.channel().localAddress();
   }
}
