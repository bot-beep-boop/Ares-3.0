import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bdg {
   private static final Logger b = LogManager.getLogger();
   private final List<ek> c = Collections.synchronizedList(Lists.newArrayList());
   private static final Splitter a = Splitter.on('\u0000').limit(6);

   public void b() {
      synchronized(this.c) {
         Iterator var2 = this.c.iterator();

         while(var2.hasNext()) {
            ek var3 = (ek)var2.next();
            if (var3.g()) {
               var2.remove();
               var3.a((eu)(new fa("Cancelled")));
            }
         }

      }
   }

   private void b(bde var1) {
      bdd var2 = bdd.a(var1.b);
      ((Bootstrap)((Bootstrap)((Bootstrap)(new Bootstrap()).group((EventLoopGroup)ek.d.c())).handler(new ChannelInitializer<Channel>(this, var2, var1) {
         final bde b;
         final bdg c;
         final bdd a;

         {
            this.c = var1;
            this.a = var2;
            this.b = var3;
         }

         protected void initChannel(Channel var1) throws Exception {
            try {
               var1.config().setOption(ChannelOption.TCP_NODELAY, true);
            } catch (ChannelException var3) {
            }

            var1.pipeline().addLast(new ChannelHandler[]{new SimpleChannelInboundHandler<ByteBuf>(this) {
               final <undefinedtype> a;

               public void channelActive(ChannelHandlerContext var1) throws Exception {
                  super.channelActive(var1);
                  ByteBuf var2 = Unpooled.buffer();

                  try {
                     var2.writeByte(254);
                     var2.writeByte(1);
                     var2.writeByte(250);
                     char[] var3 = "MC|PingHost".toCharArray();
                     var2.writeShort(var3.length);
                     char[] var4 = var3;
                     int var5 = var3.length;

                     int var6;
                     char var7;
                     for(var6 = 0; var6 < var5; ++var6) {
                        var7 = var4[var6];
                        var2.writeChar(var7);
                     }

                     var2.writeShort(7 + 2 * this.a.a.a().length());
                     var2.writeByte(127);
                     var3 = this.a.a.a().toCharArray();
                     var2.writeShort(var3.length);
                     var4 = var3;
                     var5 = var3.length;

                     for(var6 = 0; var6 < var5; ++var6) {
                        var7 = var4[var6];
                        var2.writeChar(var7);
                     }

                     var2.writeInt(this.a.a.b());
                     var1.channel().writeAndFlush(var2).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
                  } finally {
                     var2.release();
                  }
               }

               public void exceptionCaught(ChannelHandlerContext var1, Throwable var2) throws Exception {
                  var1.close();
               }

               protected void channelRead0(ChannelHandlerContext var1, Object var2) throws Exception {
                  this.a(var1, (ByteBuf)var2);
               }

               protected void a(ChannelHandlerContext var1, ByteBuf var2) throws Exception {
                  short var3 = var2.readUnsignedByte();
                  if (var3 == 255) {
                     String var4 = new String(var2.readBytes(var2.readShort() * 2).array(), Charsets.UTF_16BE);
                     String[] var5 = (String[])Iterables.toArray(bdg.d().split(var4), String.class);
                     if ("§1".equals(var5[0])) {
                        int var6 = ns.a(var5[1], 0);
                        String var7 = var5[2];
                        String var8 = var5[3];
                        int var9 = ns.a(var5[4], -1);
                        int var10 = ns.a(var5[5], -1);
                        this.a.b.f = -1;
                        this.a.b.g = var7;
                        this.a.b.d = var8;
                        this.a.b.c = a.h + "" + var9 + "" + a.i + "/" + a.h + var10;
                     }
                  }

                  var1.close();
               }

               {
                  this.a = var1;
               }
            }});
         }
      })).channel(NioSocketChannel.class)).connect(var2.a(), var2.b());
   }

   static Splitter d() {
      return a;
   }

   public void a() {
      synchronized(this.c) {
         Iterator var2 = this.c.iterator();

         while(var2.hasNext()) {
            ek var3 = (ek)var2.next();
            if (var3.g()) {
               var3.a();
            } else {
               var2.remove();
               var3.l();
            }
         }

      }
   }

   static Logger c() {
      return b;
   }

   public void a(bde var1) throws UnknownHostException {
      bdd var2 = bdd.a(var1.b);
      ek var3 = ek.a(InetAddress.getByName(var2.a()), var2.b(), false);
      this.c.add(var3);
      var1.d = "Pinging...";
      var1.e = -1L;
      var1.i = null;
      var3.a((ep)(new jp(this, var3, var1) {
         final bde b;
         final ek a;
         private long f;
         private boolean e;
         final bdg c;
         private boolean d;

         {
            this.c = var1;
            this.a = var2;
            this.b = var3;
            this.d = false;
            this.e = false;
            this.f = 0L;
         }

         public void a(jq var1) {
            long var2 = this.f;
            long var4 = ave.J();
            this.b.e = var4 - var2;
            this.a.a((eu)(new fa("Finished")));
         }

         public void a(jr var1) {
            if (this.e) {
               this.a.a((eu)(new fa("Received unrequested status")));
            } else {
               this.e = true;
               js var2 = var1.a();
               if (var2.a() != null) {
                  this.b.d = var2.a().d();
               } else {
                  this.b.d = "";
               }

               if (var2.c() != null) {
                  this.b.g = var2.c().a();
                  this.b.f = var2.c().b();
               } else {
                  this.b.g = "Old";
                  this.b.f = 0;
               }

               if (var2.b() != null) {
                  this.b.c = a.h + "" + var2.b().b() + "" + a.i + "/" + a.h + var2.b().a();
                  if (ArrayUtils.isNotEmpty(var2.b().c())) {
                     StringBuilder var3 = new StringBuilder();
                     GameProfile[] var4 = var2.b().c();
                     int var5 = var4.length;

                     for(int var6 = 0; var6 < var5; ++var6) {
                        GameProfile var7 = var4[var6];
                        if (var3.length() > 0) {
                           var3.append("\n");
                        }

                        var3.append(var7.getName());
                     }

                     if (var2.b().c().length < var2.b().b()) {
                        if (var3.length() > 0) {
                           var3.append("\n");
                        }

                        var3.append("... and ").append(var2.b().b() - var2.b().c().length).append(" more ...");
                     }

                     this.b.i = var3.toString();
                  }
               } else {
                  this.b.c = a.i + "???";
               }

               if (var2.d() != null) {
                  String var8 = var2.d();
                  if (var8.startsWith("data:image/png;base64,")) {
                     this.b.a(var8.substring("data:image/png;base64,".length()));
                  } else {
                     bdg.c().error("Invalid server icon (unknown format)");
                  }
               } else {
                  this.b.a((String)null);
               }

               this.f = ave.J();
               this.a.a((ff)(new ju(this.f)));
               this.d = true;
            }
         }

         public void a(eu var1) {
            if (!this.d) {
               bdg.c().error("Can't ping " + this.b.b + ": " + var1.c());
               this.b.d = a.e + "Can't connect to server.";
               this.b.c = "";
               bdg.a(this.c, this.b);
            }

         }
      }));

      try {
         var3.a((ff)(new jc(47, var2.a(), var2.b(), el.c)));
         var3.a((ff)(new jv()));
      } catch (Throwable var5) {
         b.error(var5);
      }

   }

   static void a(bdg var0, bde var1) {
      var0.b(var1);
   }
}
