import com.mojang.authlib.GameProfile;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.exceptions.AuthenticationUnavailableException;
import com.mojang.authlib.exceptions.InvalidCredentialsException;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.math.BigInteger;
import java.security.PublicKey;
import javax.crypto.SecretKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bcx implements jf {
   private static final Logger a = LogManager.getLogger();
   private final axu c;
   private final ek d;
   private final ave b;
   private GameProfile e;

   private MinecraftSessionService b() {
      return this.b.aa();
   }

   public void a(jj var1) {
      this.d.a(var1.a());
   }

   public void a(jh var1) {
      SecretKey var2 = ng.a();
      String var3 = var1.a();
      PublicKey var4 = var1.b();
      String var5 = (new BigInteger(ng.a(var3, var4, var2))).toString(16);
      if (this.b.D() != null && this.b.D().d()) {
         try {
            this.b().joinServer(this.b.L().e(), this.b.L().d(), var5);
         } catch (AuthenticationException var10) {
            a.warn("Couldn't connect to auth servers but will continue to join LAN");
         }
      } else {
         try {
            this.b().joinServer(this.b.L().e(), this.b.L().d(), var5);
         } catch (AuthenticationUnavailableException var7) {
            this.d.a((eu)(new fb("disconnect.loginFailedInfo", new Object[]{new fb("disconnect.loginFailedInfo.serversUnavailable", new Object[0])})));
            return;
         } catch (InvalidCredentialsException var8) {
            this.d.a((eu)(new fb("disconnect.loginFailedInfo", new Object[]{new fb("disconnect.loginFailedInfo.invalidSession", new Object[0])})));
            return;
         } catch (AuthenticationException var9) {
            this.d.a((eu)(new fb("disconnect.loginFailedInfo", new Object[]{var9.getMessage()})));
            return;
         }
      }

      this.d.a(new jm(var2, var4, var1.c()), new GenericFutureListener<Future<? super Void>>(this, var2) {
         final SecretKey a;
         final bcx b;

         {
            this.b = var1;
            this.a = var2;
         }

         public void operationComplete(Future<? super Void> var1) throws Exception {
            bcx.a(this.b).a(this.a);
         }
      });
   }

   public bcx(ek var1, ave var2, axu var3) {
      this.d = var1;
      this.b = var2;
      this.c = var3;
   }

   public void a(ji var1) {
      if (!this.d.c()) {
         this.d.a(var1.a());
      }

   }

   public void a(eu var1) {
      this.b.a((axu)(new axh(this.c, "connect.failed", var1)));
   }

   static ek a(bcx var0) {
      return var0.d;
   }

   public void a(jg var1) {
      this.e = var1.a();
      this.d.a(el.b);
      this.d.a((ep)(new bcy(this.b, this.c, this.d, this.e)));
   }
}
