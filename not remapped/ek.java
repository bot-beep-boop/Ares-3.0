import com.google.common.collect.Queues;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollSocketChannel;
import io.netty.channel.local.LocalChannel;
import io.netty.channel.local.LocalEventLoopGroup;
import io.netty.channel.local.LocalServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.TimeoutException;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.crypto.SecretKey;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class ek extends SimpleChannelInboundHandler<ff> {
   public static final no<EpollEventLoopGroup> e;
   private ep m;
   private boolean o;
   private SocketAddress l;
   public static final Marker b;
   public static final Marker a = MarkerManager.getMarker("NETWORK");
   public static final AttributeKey<el> c;
   private final ReentrantReadWriteLock j = new ReentrantReadWriteLock();
   private boolean p;
   private Channel k;
   private final Queue<ek.a> i = Queues.newConcurrentLinkedQueue();
   public static final no<LocalEventLoopGroup> f;
   private static final Logger g = LogManager.getLogger();
   private final fg h;
   private eu n;
   public static final no<NioEventLoopGroup> d;

   public void exceptionCaught(ChannelHandlerContext var1, Throwable var2) throws Exception {
      fb var3;
      if (var2 instanceof TimeoutException) {
         var3 = new fb("disconnect.timeout", new Object[0]);
      } else {
         var3 = new fb("disconnect.genericReason", new Object[]{"Internal Exception: " + var2});
      }

      this.a((eu)var3);
   }

   public void channelActive(ChannelHandlerContext var1) throws Exception {
      super.channelActive(var1);
      this.k = var1.channel();
      this.l = this.k.remoteAddress();

      try {
         this.a(el.a);
      } catch (Throwable var3) {
         g.fatal(var3);
      }

   }

   public void a(ff var1) {
      if (this.g()) {
         this.m();
         this.a((ff)var1, (GenericFutureListener[])null);
      } else {
         this.j.writeLock().lock();

         try {
            this.i.add(new ek.a(var1, (GenericFutureListener[])null));
         } finally {
            this.j.writeLock().unlock();
         }
      }

   }

   public boolean g() {
      return this.k != null && this.k.isOpen();
   }

   public ep i() {
      return this.m;
   }

   public ek(fg var1) {
      this.h = var1;
   }

   public static ek a(SocketAddress var0) {
      ek var1 = new ek(fg.b);
      ((Bootstrap)((Bootstrap)((Bootstrap)(new Bootstrap()).group((EventLoopGroup)f.c())).handler(new ChannelInitializer<Channel>(var1) {
         final ek a;

         protected void initChannel(Channel var1) throws Exception {
            var1.pipeline().addLast("packet_handler", this.a);
         }

         {
            this.a = var1;
         }
      })).channel(LocalChannel.class)).connect(var0).syncUninterruptibly();
      return var1;
   }

   public void l() {
      if (this.k != null && !this.k.isOpen()) {
         if (!this.p) {
            this.p = true;
            if (this.j() != null) {
               this.i().a(this.j());
            } else if (this.i() != null) {
               this.i().a(new fa("Disconnected"));
            }
         } else {
            g.warn("handleDisconnection() called twice");
         }

      }
   }

   static Channel a(ek var0) {
      return var0.k;
   }

   private void m() {
      if (this.k != null && this.k.isOpen()) {
         this.j.readLock().lock();

         try {
            while(!this.i.isEmpty()) {
               ek.a var1 = (ek.a)this.i.poll();
               this.a(ek.a.a(var1), ek.a.b(var1));
            }
         } finally {
            this.j.readLock().unlock();
         }

      }
   }

   public void a(el var1) {
      this.k.attr(c).set(var1);
      this.k.config().setAutoRead(true);
      g.debug("Enabled auto read");
   }

   public SocketAddress b() {
      return this.l;
   }

   public void a(SecretKey var1) {
      this.o = true;
      this.k.pipeline().addBefore("splitter", "decrypt", new eg(ng.a(2, var1)));
      this.k.pipeline().addBefore("prepender", "encrypt", new eh(ng.a(1, var1)));
   }

   public boolean c() {
      return this.k instanceof LocalChannel || this.k instanceof LocalServerChannel;
   }

   public void channelInactive(ChannelHandlerContext var1) throws Exception {
      this.a((eu)(new fb("disconnect.endOfStream", new Object[0])));
   }

   public void k() {
      this.k.config().setAutoRead(false);
   }

   public void a(ep var1) {
      Validate.notNull(var1, "packetListener", new Object[0]);
      g.debug("Set listener of {} to {}", new Object[]{this, var1});
      this.m = var1;
   }

   public boolean h() {
      return this.k == null;
   }

   public static ek a(InetAddress var0, int var1, boolean var2) {
      ek var3 = new ek(fg.b);
      Class var4;
      no var5;
      if (Epoll.isAvailable() && var2) {
         var4 = EpollSocketChannel.class;
         var5 = e;
      } else {
         var4 = NioSocketChannel.class;
         var5 = d;
      }

      ((Bootstrap)((Bootstrap)((Bootstrap)(new Bootstrap()).group((EventLoopGroup)var5.c())).handler(new ChannelInitializer<Channel>(var3) {
         final ek a;

         {
            this.a = var1;
         }

         protected void initChannel(Channel var1) throws Exception {
            try {
               var1.config().setOption(ChannelOption.TCP_NODELAY, true);
            } catch (ChannelException var3) {
            }

            var1.pipeline().addLast("timeout", new ReadTimeoutHandler(30)).addLast("splitter", new eq()).addLast("decoder", new en(fg.b)).addLast("prepender", new er()).addLast("encoder", new eo(fg.a)).addLast("packet_handler", this.a);
         }
      })).channel(var4)).connect(var0, var1).syncUninterruptibly();
      return var3;
   }

   public void a(int var1) {
      if (var1 >= 0) {
         if (this.k.pipeline().get("decompress") instanceof ei) {
            ((ei)this.k.pipeline().get("decompress")).a(var1);
         } else {
            this.k.pipeline().addBefore("decoder", "decompress", new ei(var1));
         }

         if (this.k.pipeline().get("compress") instanceof ej) {
            ((ej)this.k.pipeline().get("decompress")).a(var1);
         } else {
            this.k.pipeline().addBefore("encoder", "compress", new ej(var1));
         }
      } else {
         if (this.k.pipeline().get("decompress") instanceof ei) {
            this.k.pipeline().remove("decompress");
         }

         if (this.k.pipeline().get("compress") instanceof ej) {
            this.k.pipeline().remove("compress");
         }
      }

   }

   static {
      b = MarkerManager.getMarker("NETWORK_PACKETS", a);
      c = AttributeKey.valueOf("protocol");
      d = new no<NioEventLoopGroup>() {
         protected NioEventLoopGroup a() {
            return new NioEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Client IO #%d").setDaemon(true).build());
         }

         protected Object b() {
            return this.a();
         }
      };
      e = new no<EpollEventLoopGroup>() {
         protected EpollEventLoopGroup a() {
            return new EpollEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Epoll Client IO #%d").setDaemon(true).build());
         }

         protected Object b() {
            return this.a();
         }
      };
      f = new no<LocalEventLoopGroup>() {
         protected Object b() {
            return this.a();
         }

         protected LocalEventLoopGroup a() {
            return new LocalEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Local Client IO #%d").setDaemon(true).build());
         }
      };
   }

   public void a() {
      this.m();
      if (this.m instanceof km) {
         ((km)this.m).c();
      }

      this.k.flush();
   }

   private void a(ff var1, GenericFutureListener<? extends Future<? super Void>>[] var2) {
      el var3 = el.a(var1);
      el var4 = (el)this.k.attr(c).get();
      if (var4 != var3) {
         g.debug("Disabled auto read");
         this.k.config().setAutoRead(false);
      }

      if (this.k.eventLoop().inEventLoop()) {
         if (var3 != var4) {
            this.a(var3);
         }

         ChannelFuture var5 = this.k.writeAndFlush(var1);
         if (var2 != null) {
            var5.addListeners(var2);
         }

         var5.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
      } else {
         this.k.eventLoop().execute(new Runnable(this, var3, var4, var1, var2) {
            final ek e;
            final el b;
            final ff c;
            final GenericFutureListener[] d;
            final el a;

            public void run() {
               if (this.a != this.b) {
                  this.e.a(this.a);
               }

               ChannelFuture var1 = ek.a(this.e).writeAndFlush(this.c);
               if (this.d != null) {
                  var1.addListeners(this.d);
               }

               var1.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
            }

            {
               this.e = var1;
               this.a = var2;
               this.b = var3;
               this.c = var4;
               this.d = var5;
            }
         });
      }

   }

   public eu j() {
      return this.n;
   }

   public void a(eu var1) {
      if (this.k.isOpen()) {
         this.k.close().awaitUninterruptibly();
         this.n = var1;
      }

   }

   protected void channelRead0(ChannelHandlerContext var1, Object var2) throws Exception {
      this.a(var1, (ff)var2);
   }

   public void a(ff var1, GenericFutureListener<? extends Future<? super Void>> var2, GenericFutureListener<? extends Future<? super Void>>... var3) {
      if (this.g()) {
         this.m();
         this.a(var1, (GenericFutureListener[])ArrayUtils.add(var3, 0, var2));
      } else {
         this.j.writeLock().lock();

         try {
            this.i.add(new ek.a(var1, (GenericFutureListener[])ArrayUtils.add(var3, 0, var2)));
         } finally {
            this.j.writeLock().unlock();
         }
      }

   }

   public boolean f() {
      return this.o;
   }

   protected void a(ChannelHandlerContext var1, ff var2) throws Exception {
      if (this.k.isOpen()) {
         try {
            var2.a(this.m);
         } catch (ki var4) {
         }
      }

   }

   static class a {
      private final ff a;
      private final GenericFutureListener<? extends Future<? super Void>>[] b;

      public a(ff var1, GenericFutureListener<? extends Future<? super Void>>... var2) {
         this.a = var1;
         this.b = var2;
      }

      static ff a(ek.a var0) {
         return var0.a;
      }

      static GenericFutureListener[] b(ek.a var0) {
         return var0.b;
      }
   }
}
