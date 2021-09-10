import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;

public abstract class aqq extends any {
   protected Map<Long, aqu> e = Maps.newHashMap();
   private aqs d;

   protected abstract aqu b(int var1, int var2);

   private void a(int var1, int var2, aqu var3) {
      this.d.a(var3.a(var1, var2), var1, var2);
      this.d.c();
   }

   public cj b(adm var1, cj var2) {
      this.c = var1;
      this.a(var1);
      this.b.setSeed(var1.J());
      long var3 = this.b.nextLong();
      long var5 = this.b.nextLong();
      long var7 = (long)(var2.n() >> 4) * var3;
      long var9 = (long)(var2.p() >> 4) * var5;
      this.b.setSeed(var7 ^ var9 ^ var1.J());
      this.a(var1, var2.n() >> 4, var2.p() >> 4, 0, 0, (ans)null);
      double var11 = Double.MAX_VALUE;
      cj var13 = null;
      Iterator var14 = this.e.values().iterator();

      cj var17;
      double var18;
      while(var14.hasNext()) {
         aqu var15 = (aqu)var14.next();
         if (var15.d()) {
            aqt var16 = (aqt)var15.b().get(0);
            var17 = var16.a();
            var18 = var17.i(var2);
            if (var18 < var11) {
               var11 = var18;
               var13 = var17;
            }
         }
      }

      if (var13 != null) {
         return var13;
      } else {
         List var20 = this.z_();
         if (var20 != null) {
            cj var21 = null;
            Iterator var22 = var20.iterator();

            while(var22.hasNext()) {
               var17 = (cj)var22.next();
               var18 = var17.i(var2);
               if (var18 < var11) {
                  var11 = var18;
                  var21 = var17;
               }
            }

            return var21;
         } else {
            return null;
         }
      }
   }

   public boolean a(adm var1, Random var2, adg var3) {
      this.a(var1);
      int var4 = (var3.a << 4) + 8;
      int var5 = (var3.b << 4) + 8;
      boolean var6 = false;
      Iterator var7 = this.e.values().iterator();

      while(var7.hasNext()) {
         aqu var8 = (aqu)var7.next();
         if (var8.d() && var8.a(var3) && var8.a().a(var4, var5, var4 + 15, var5 + 15)) {
            var8.a(var1, var2, new aqe(var4, var5, var4 + 15, var5 + 15));
            var8.b(var3);
            var6 = true;
            this.a(var8.e(), var8.f(), var8);
         }
      }

      return var6;
   }

   protected aqu c(cj var1) {
      Iterator var2 = this.e.values().iterator();

      while(true) {
         aqu var3;
         do {
            do {
               if (!var2.hasNext()) {
                  return null;
               }

               var3 = (aqu)var2.next();
            } while(!var3.d());
         } while(!var3.a().b((df)var1));

         Iterator var4 = var3.b().iterator();

         while(var4.hasNext()) {
            aqt var5 = (aqt)var4.next();
            if (var5.c().b((df)var1)) {
               return var3;
            }
         }
      }
   }

   protected abstract boolean a(int var1, int var2);

   public boolean a(adm var1, cj var2) {
      this.a(var1);
      Iterator var3 = this.e.values().iterator();

      aqu var4;
      do {
         if (!var3.hasNext()) {
            return false;
         }

         var4 = (aqu)var3.next();
      } while(!var4.d() || !var4.a().b((df)var2));

      return true;
   }

   public boolean b(cj var1) {
      this.a(this.c);
      return this.c(var1) != null;
   }

   protected List<cj> z_() {
      return null;
   }

   protected final void a(adm var1, int var2, int var3, int var4, int var5, ans var6) {
      this.a(var1);
      if (!this.e.containsKey(adg.a(var2, var3))) {
         this.b.nextInt();

         try {
            if (this.a(var2, var3)) {
               aqu var7 = this.b(var2, var3);
               this.e.put(adg.a(var2, var3), var7);
               this.a(var2, var3, var7);
            }

         } catch (Throwable var10) {
            b var8 = b.a(var10, "Exception preparing structure feature");
            c var9 = var8.a("Feature being prepared");
            var9.a("Is feature chunk", new Callable<String>(this, var2, var3) {
               final int a;
               final aqq c;
               final int b;

               public String a() throws Exception {
                  return this.c.a(this.a, this.b) ? "True" : "False";
               }

               {
                  this.c = var1;
                  this.a = var2;
                  this.b = var3;
               }

               public Object call() throws Exception {
                  return this.a();
               }
            });
            var9.a((String)"Chunk location", (Object)String.format("%d,%d", var2, var3));
            var9.a("Chunk pos hash", new Callable<String>(this, var2, var3) {
               final int a;
               final aqq c;
               final int b;

               {
                  this.c = var1;
                  this.a = var2;
                  this.b = var3;
               }

               public Object call() throws Exception {
                  return this.a();
               }

               public String a() throws Exception {
                  return String.valueOf(adg.a(this.a, this.b));
               }
            });
            var9.a("Structure type", new Callable<String>(this) {
               final aqq a;

               public Object call() throws Exception {
                  return this.a();
               }

               public String a() throws Exception {
                  return this.a.getClass().getCanonicalName();
               }

               {
                  this.a = var1;
               }
            });
            throw new e(var8);
         }
      }
   }

   public abstract String a();

   private void a(adm var1) {
      if (this.d == null) {
         this.d = (aqs)var1.a(aqs.class, this.a());
         if (this.d == null) {
            this.d = new aqs(this.a());
            var1.a((String)this.a(), (ate)this.d);
         } else {
            dn var2 = this.d.a();
            Iterator var3 = var2.c().iterator();

            while(var3.hasNext()) {
               String var4 = (String)var3.next();
               eb var5 = var2.a(var4);
               if (var5.a() == 10) {
                  dn var6 = (dn)var5;
                  if (var6.c("ChunkX") && var6.c("ChunkZ")) {
                     int var7 = var6.f("ChunkX");
                     int var8 = var6.f("ChunkZ");
                     aqu var9 = aqr.a(var6, var1);
                     if (var9 != null) {
                        this.e.put(adg.a(var7, var8), var9);
                     }
                  }
               }
            }
         }
      }

   }
}
