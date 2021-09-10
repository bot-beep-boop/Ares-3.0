import com.google.common.base.Charsets;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.exceptions.AuthenticationUnavailableException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.concurrent.Future;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import javax.crypto.SecretKey;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class lo implements jk, km {
   private final MinecraftServer f;
   private static final AtomicInteger b = new AtomicInteger(0);
   private static final Logger c = LogManager.getLogger();
   private final byte[] e = new byte[4];
   private SecretKey k;
   private static final Random d = new Random();
   private String j;
   public final ek a;
   private int h;
   private lo.a g;
   private GameProfile i;
   private lf l;

   static GameProfile b(lo var0) {
      return var0.i;
   }

   public void a(jm var1) {
      Validate.validState(this.g == lo.a.b, "Unexpected key packet", new Object[0]);
      PrivateKey var2 = this.f.Q().getPrivate();
      if (!Arrays.equals(this.e, var1.b(var2))) {
         throw new IllegalStateException("Invalid nonce!");
      } else {
         this.k = var1.a(var2);
         this.g = lo.a.c;
         this.a.a(this.k);
         (new Thread(this, "User Authenticator #" + b.incrementAndGet()) {
            final lo a;

            public void run() {
               GameProfile var1 = lo.b(this.a);

               try {
                  String var2 = (new BigInteger(ng.a(lo.c(this.a), lo.a(this.a).Q().getPublic(), lo.d(this.a)))).toString(16);
                  lo.a(this.a, lo.a(this.a).aD().hasJoinedServer(new GameProfile((UUID)null, var1.getName()), var2));
                  if (lo.b(this.a) != null) {
                     lo.e().info("UUID of player " + lo.b(this.a).getName() + " is " + lo.b(this.a).getId());
                     lo.a(this.a, lo.a.d);
                  } else if (lo.a(this.a).T()) {
                     lo.e().warn("Failed to verify username but will let them in anyway!");
                     lo.a(this.a, this.a.a(var1));
                     lo.a(this.a, lo.a.d);
                  } else {
                     this.a.a("Failed to verify username!");
                     lo.e().error("Username '" + lo.b(this.a).getName() + "' tried to join with an invalid session");
                  }
               } catch (AuthenticationUnavailableException var3) {
                  if (lo.a(this.a).T()) {
                     lo.e().warn("Authentication servers are down but will let them in anyway!");
                     lo.a(this.a, this.a.a(var1));
                     lo.a(this.a, lo.a.d);
                  } else {
                     this.a.a("Authentication servers are down. Please try again later, sorry!");
                     lo.e().error("Couldn't verify username because servers are unavailable");
                  }
               }

            }

            {
               this.a = var1;
            }
         }).start();
      }
   }

   public String d() {
      return this.i != null ? this.i.toString() + " (" + this.a.b().toString() + ")" : String.valueOf(this.a.b());
   }

   public void b() {
      if (!this.i.isComplete()) {
         this.i = this.a(this.i);
      }

      String var1 = this.f.ap().a(this.a.b(), this.i);
      if (var1 != null) {
         this.a(var1);
      } else {
         this.g = lo.a.f;
         if (this.f.aK() >= 0 && !this.a.c()) {
            this.a.a(new ji(this.f.aK()), new ChannelFutureListener(this) {
               final lo a;

               {
                  this.a = var1;
               }

               public void operationComplete(Future var1) throws Exception {
                  this.a((ChannelFuture)var1);
               }

               public void a(ChannelFuture var1) throws Exception {
                  this.a.a.a(lo.a(this.a).aK());
               }
            });
         }

         this.a.a((ff)(new jg(this.i)));
         lf var2 = this.f.ap().a(this.i.getId());
         if (var2 != null) {
            this.g = lo.a.e;
            this.l = this.f.ap().g(this.i);
         } else {
            this.f.ap().a(this.a, this.f.ap().g(this.i));
         }
      }

   }

   public void a(eu var1) {
      c.info(this.d() + " lost connection: " + var1.c());
   }

   public void c() {
      if (this.g == lo.a.d) {
         this.b();
      } else if (this.g == lo.a.e) {
         lf var1 = this.f.ap().a(this.i.getId());
         if (var1 == null) {
            this.g = lo.a.d;
            this.f.ap().a(this.a, this.l);
            this.l = null;
         }
      }

      if (this.h++ == 600) {
         this.a("Took too long to log in");
      }

   }

   static GameProfile a(lo var0, GameProfile var1) {
      return var0.i = var1;
   }

   static MinecraftServer a(lo var0) {
      return var0.f;
   }

   public void a(jl var1) {
      Validate.validState(this.g == lo.a.a, "Unexpected hello packet", new Object[0]);
      this.i = var1.a();
      if (this.f.af() && !this.a.c()) {
         this.g = lo.a.b;
         this.a.a((ff)(new jh(this.j, this.f.Q().getPublic(), this.e)));
      } else {
         this.g = lo.a.d;
      }

   }

   protected GameProfile a(GameProfile var1) {
      UUID var2 = UUID.nameUUIDFromBytes(("OfflinePlayer:" + var1.getName()).getBytes(Charsets.UTF_8));
      return new GameProfile(var2, var1.getName());
   }

   static String c(lo var0) {
      return var0.j;
   }

   public void a(String var1) {
      try {
         c.info("Disconnecting " + this.d() + ": " + var1);
         fa var2 = new fa(var1);
         this.a.a((ff)(new jj(var2)));
         this.a.a((eu)var2);
      } catch (Exception var3) {
         c.error("Error whilst disconnecting player", var3);
      }

   }

   static lo.a a(lo var0, lo.a var1) {
      return var0.g = var1;
   }

   static SecretKey d(lo var0) {
      return var0.k;
   }

   public lo(MinecraftServer var1, ek var2) {
      this.g = lo.a.a;
      this.j = "";
      this.f = var1;
      this.a = var2;
      d.nextBytes(this.e);
   }

   static Logger e() {
      return c;
   }

   static enum a {
      private static final lo.a[] g = new lo.a[]{a, b, c, d, e, f};
      d,
      e,
      f,
      a,
      c,
      b;
   }
}
