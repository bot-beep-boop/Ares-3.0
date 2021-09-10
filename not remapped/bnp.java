import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.InsecureTextureException;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class bnp {
   private final MinecraftSessionService d;
   private final LoadingCache<GameProfile, Map<Type, MinecraftProfileTexture>> e;
   private final bmj b;
   private static final ExecutorService a;
   private final File c;

   static MinecraftSessionService a(bnp var0) {
      return var0.d;
   }

   public bnp(bmj var1, File var2, MinecraftSessionService var3) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.e = CacheBuilder.newBuilder().expireAfterAccess(15L, TimeUnit.SECONDS).build(new CacheLoader<GameProfile, Map<Type, MinecraftProfileTexture>>(this) {
         final bnp a;

         public Object load(Object var1) throws Exception {
            return this.a((GameProfile)var1);
         }

         public Map<Type, MinecraftProfileTexture> a(GameProfile var1) throws Exception {
            return ave.A().aa().getTextures(var1, false);
         }

         {
            this.a = var1;
         }
      });
   }

   public void a(GameProfile var1, bnp.a var2, boolean var3) {
      a.submit(new Runnable(this, var1, var3, var2) {
         final bnp.a c;
         final bnp d;
         final boolean b;
         final GameProfile a;

         {
            this.d = var1;
            this.a = var2;
            this.b = var3;
            this.c = var4;
         }

         public void run() {
            HashMap var1 = Maps.newHashMap();

            try {
               var1.putAll(bnp.a(this.d).getTextures(this.a, this.b));
            } catch (InsecureTextureException var3) {
            }

            if (var1.isEmpty() && this.a.getId().equals(ave.A().L().e().getId())) {
               this.a.getProperties().clear();
               this.a.getProperties().putAll(ave.A().N());
               var1.putAll(bnp.a(this.d).getTextures(this.a, false));
            }

            ave.A().a(new Runnable(this, var1) {
               final Map a;
               final <undefinedtype> b;

               {
                  this.b = var1;
                  this.a = var2;
               }

               public void run() {
                  if (this.a.containsKey(Type.SKIN)) {
                     this.b.d.a((MinecraftProfileTexture)this.a.get(Type.SKIN), Type.SKIN, this.b.c);
                  }

                  if (this.a.containsKey(Type.CAPE)) {
                     this.b.d.a((MinecraftProfileTexture)this.a.get(Type.CAPE), Type.CAPE, this.b.c);
                  }

               }
            });
         }
      });
   }

   public Map<Type, MinecraftProfileTexture> a(GameProfile var1) {
      return (Map)this.e.getUnchecked(var1);
   }

   public jy a(MinecraftProfileTexture var1, Type var2) {
      return this.a(var1, var2, (bnp.a)null);
   }

   public jy a(MinecraftProfileTexture var1, Type var2, bnp.a var3) {
      jy var4 = new jy("skins/" + var1.getHash());
      bmk var5 = this.b.b(var4);
      if (var5 != null) {
         if (var3 != null) {
            var3.a(var2, var4, var1);
         }
      } else {
         File var6 = new File(this.c, var1.getHash().length() > 2 ? var1.getHash().substring(0, 2) : "xx");
         File var7 = new File(var6, var1.getHash());
         bfs var8 = var2 == Type.SKIN ? new bfs() : null;
         bma var9 = new bma(var7, var1.getUrl(), bmz.a(), new bfm(this, var8, var3, var2, var4, var1) {
            final bfm a;
            final jy d;
            final Type c;
            final bnp.a b;
            final MinecraftProfileTexture e;
            final bnp f;

            public void a() {
               if (this.a != null) {
                  this.a.a();
               }

               if (this.b != null) {
                  this.b.a(this.c, this.d, this.e);
               }

            }

            public BufferedImage a(BufferedImage var1) {
               if (this.a != null) {
                  var1 = this.a.a(var1);
               }

               return var1;
            }

            {
               this.f = var1;
               this.a = var2;
               this.b = var3;
               this.c = var4;
               this.d = var5;
               this.e = var6;
            }
         });
         this.b.a((jy)var4, (bmk)var9);
      }

      return var4;
   }

   static {
      a = new ThreadPoolExecutor(0, 2, 1L, TimeUnit.MINUTES, new LinkedBlockingQueue());
   }

   public interface a {
      void a(Type var1, jy var2, MinecraftProfileTexture var3);
   }
}
