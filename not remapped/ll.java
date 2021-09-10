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
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ll {
   private final List<ek> h = Collections.synchronizedList(Lists.newArrayList());
   public static final no<LocalEventLoopGroup> c = new no<LocalEventLoopGroup>() {
      protected LocalEventLoopGroup a() {
         return new LocalEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Local Server IO #%d").setDaemon(true).build());
      }

      protected Object b() {
         return this.a();
      }
   };
   private final MinecraftServer f;
   public boolean d;
   public static final no<EpollEventLoopGroup> b = new no<EpollEventLoopGroup>() {
      protected EpollEventLoopGroup a() {
         return new EpollEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Epoll Server IO #%d").setDaemon(true).build());
      }

      protected Object b() {
         return this.a();
      }
   };
   public static final no<NioEventLoopGroup> a = new no<NioEventLoopGroup>() {
      protected NioEventLoopGroup a() {
         return new NioEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Server IO #%d").setDaemon(true).build());
      }

      protected Object b() {
         return this.a();
      }
   };
   private final List<ChannelFuture> g = Collections.synchronizedList(Lists.newArrayList());
   private static final Logger e = LogManager.getLogger();

   public ll(MinecraftServer var1) {
      this.f = var1;
      this.d = true;
   }

   public void c() {
      synchronized(this.h) {
         Iterator var2 = this.h.iterator();

         while(true) {
            while(true) {
               ek var3;
               do {
                  if (!var2.hasNext()) {
                     return;
                  }

                  var3 = (ek)var2.next();
               } while(var3.h());

               if (!var3.g()) {
                  var2.remove();
                  var3.l();
               } else {
                  try {
                     var3.a();
                  } catch (Exception var8) {
                     if (var3.c()) {
                        b var10 = b.a(var8, "Ticking memory connection");
                        c var6 = var10.a("Ticking connection");
                        var6.a("Connection", new Callable<String>(this, var3) {
                           final ll b;
                           final ek a;

                           public String a() throws Exception {
                              return this.a.toString();
                           }

                           {
                              this.b = var1;
                              this.a = var2;
                           }

                           public Object call() throws Exception {
                              return this.a();
                           }
                        });
                        throw new e(var10);
                     }

                     e.warn("Failed to handle packet for " + var3.b(), var8);
                     fa var5 = new fa("Internal server error");
                     var3.a(new gh(var5), new GenericFutureListener<Future<? super Void>>(this, var3, var5) {
                        final ek a;
                        final fa b;
                        final ll c;

                        public void operationComplete(Future<? super Void> var1) throws Exception {
                           this.a.a((eu)this.b);
                        }

                        {
                           this.c = var1;
                           this.a = var2;
                           this.b = var3;
                        }
                     });
                     var3.k();
                  }
               }
            }
         }
      }
   }

   public void b() {
      this.d = false;
      Iterator var1 = this.g.iterator();

      while(var1.hasNext()) {
         ChannelFuture var2 = (ChannelFuture)var1.next();

         try {
            var2.channel().close().sync();
         } catch (InterruptedException var4) {
            e.error("Interrupted whilst closing channel");
         }
      }

   }

   public MinecraftServer d() {
      return this.f;
   }

   public SocketAddress a() {
      ChannelFuture var1;
      synchronized(this.g) {
         var1 = ((ServerBootstrap)((ServerBootstrap)(new ServerBootstrap()).channel(LocalServerChannel.class)).childHandler(new ChannelInitializer<Channel>(this) {
            final ll a;

            protected void initChannel(Channel var1) throws Exception {
               ek var2 = new ek(fg.a);
               var2.a((ep)(new lk(ll.b(this.a), var2)));
               ll.a(this.a).add(var2);
               var1.pipeline().addLast("packet_handler", var2);
            }

            {
               this.a = var1;
            }
         }).group((EventLoopGroup)a.c()).localAddress(LocalAddress.ANY)).bind().syncUninterruptibly();
         this.g.add(var1);
      }

      return var1.channel().localAddress();
   }

   public void a(InetAddress var1, int var2) throws IOException {
      synchronized(this.g) {
         Class var4;
         no var5;
         if (Epoll.isAvailable() && this.f.ai()) {
            var4 = EpollServerSocketChannel.class;
            var5 = b;
            e.info("Using epoll channel type");
         } else {
            var4 = NioServerSocketChannel.class;
            var5 = a;
            e.info("Using default channel type");
         }

         this.g.add(((ServerBootstrap)((ServerBootstrap)(new ServerBootstrap()).channel(var4)).childHandler(new ChannelInitializer<Channel>(this) {
            final ll a;

            protected void initChannel(Channel var1) throws Exception {
               try {
                  var1.config().setOption(ChannelOption.TCP_NODELAY, true);
               } catch (ChannelException var3) {
               }

               var1.pipeline().addLast("timeout", new ReadTimeoutHandler(30)).addLast("legacy_query", new lj(this.a)).addLast("splitter", new eq()).addLast("decoder", new en(fg.a)).addLast("prepender", new er()).addLast("encoder", new eo(fg.b));
               ek var2 = new ek(fg.a);
               ll.a(this.a).add(var2);
               var1.pipeline().addLast("packet_handler", var2);
               var2.a((ep)(new ln(ll.b(this.a), var2)));
            }

            {
               this.a = var1;
            }
         }).group((EventLoopGroup)var5.c()).localAddress(var1, var2)).bind().syncUninterruptibly());
      }
   }

   static MinecraftServer b(ll var0) {
      return var0.f;
   }

   static List a(ll var0) {
      return var0.h;
   }
}
