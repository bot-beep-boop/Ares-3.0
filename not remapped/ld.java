import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ld implements amv {
   private List<amy> h = Lists.newArrayList();
   private amv e;
   private le i;
   private and f;
   private amy d;
   private static final Logger b = LogManager.getLogger();
   public boolean a = true;
   private Set<Long> c = Collections.newSetFromMap(new ConcurrentHashMap());
   private nq<amy> g = new nq();

   public void a(amy var1, int var2, int var3) {
   }

   public boolean a(amv var1, amy var2, int var3, int var4) {
      if (this.e != null && this.e.a(var1, var2, var3, var4)) {
         amy var5 = this.d(var3, var4);
         var5.e();
         return true;
      } else {
         return false;
      }
   }

   public cj a(adm var1, String var2, cj var3) {
      return this.e.a(var1, var2, var3);
   }

   public amy a(cj var1) {
      return this.d(var1.n() >> 4, var1.p() >> 4);
   }

   public ld(le var1, and var2, amv var3) {
      this.d = new amx(var1, 0, 0);
      this.i = var1;
      this.f = var2;
      this.e = var3;
   }

   public void c() {
      if (this.f != null) {
         this.f.b();
      }

   }

   public void b(int var1, int var2) {
      if (this.i.t.e()) {
         if (!this.i.c(var1, var2)) {
            this.c.add(adg.a(var1, var2));
         }
      } else {
         this.c.add(adg.a(var1, var2));
      }

   }

   private amy e(int var1, int var2) {
      if (this.f == null) {
         return null;
      } else {
         try {
            amy var3 = this.f.a(this.i, var1, var2);
            if (var3 != null) {
               var3.b(this.i.K());
               if (this.e != null) {
                  this.e.a(var3, var1, var2);
               }
            }

            return var3;
         } catch (Exception var4) {
            b.error("Couldn't load chunk", var4);
            return null;
         }
      }
   }

   public List<amy> a() {
      return this.h;
   }

   public void b() {
      Iterator var1 = this.h.iterator();

      while(var1.hasNext()) {
         amy var2 = (amy)var1.next();
         this.b(var2.a, var2.b);
      }

   }

   public String f() {
      return "ServerChunkCache: " + this.g.a() + " Drop: " + this.c.size();
   }

   public boolean a(boolean var1, nu var2) {
      int var3 = 0;
      ArrayList var4 = Lists.newArrayList(this.h);

      for(int var5 = 0; var5 < var4.size(); ++var5) {
         amy var6 = (amy)var4.get(var5);
         if (var1) {
            this.a(var6);
         }

         if (var6.a(var1)) {
            this.b(var6);
            var6.f(false);
            ++var3;
            if (var3 == 24 && !var1) {
               return false;
            }
         }
      }

      return true;
   }

   public boolean d() {
      if (!this.i.c) {
         for(int var1 = 0; var1 < 100; ++var1) {
            if (!this.c.isEmpty()) {
               Long var2 = (Long)this.c.iterator().next();
               amy var3 = (amy)this.g.a(var2);
               if (var3 != null) {
                  var3.d();
                  this.b(var3);
                  this.a(var3);
                  this.g.d(var2);
                  this.h.remove(var3);
               }

               this.c.remove(var2);
            }
         }

         if (this.f != null) {
            this.f.a();
         }
      }

      return this.e.d();
   }

   public List<ady.c> a(pt var1, cj var2) {
      return this.e.a(var1, var2);
   }

   private void b(amy var1) {
      if (this.f != null) {
         try {
            var1.b(this.i.K());
            this.f.a(this.i, var1);
         } catch (IOException var3) {
            b.error("Couldn't save chunk", var3);
         } catch (adn var4) {
            b.error("Couldn't save chunk; already in use by another instance of Minecraft?", var4);
         }

      }
   }

   public void a(amv var1, int var2, int var3) {
      amy var4 = this.d(var2, var3);
      if (!var4.t()) {
         var4.n();
         if (this.e != null) {
            this.e.a(var1, var2, var3);
            var4.e();
         }
      }

   }

   private void a(amy var1) {
      if (this.f != null) {
         try {
            this.f.b(this.i, var1);
         } catch (Exception var3) {
            b.error("Couldn't save entities", var3);
         }

      }
   }

   public boolean a(int var1, int var2) {
      return this.g.b(adg.a(var1, var2));
   }

   public amy d(int var1, int var2) {
      amy var3 = (amy)this.g.a(adg.a(var1, var2));
      if (var3 == null) {
         return !this.i.ad() && !this.a ? this.d : this.c(var1, var2);
      } else {
         return var3;
      }
   }

   public boolean e() {
      return !this.i.c;
   }

   public int g() {
      return this.g.a();
   }

   public amy c(int var1, int var2) {
      long var3 = adg.a(var1, var2);
      this.c.remove(var3);
      amy var5 = (amy)this.g.a(var3);
      if (var5 == null) {
         var5 = this.e(var1, var2);
         if (var5 == null) {
            if (this.e == null) {
               var5 = this.d;
            } else {
               try {
                  var5 = this.e.d(var1, var2);
               } catch (Throwable var9) {
                  b var7 = b.a(var9, "Exception generating new chunk");
                  c var8 = var7.a("Chunk to be generated");
                  var8.a((String)"Location", (Object)String.format("%d,%d", var1, var2));
                  var8.a((String)"Position hash", (Object)var3);
                  var8.a((String)"Generator", (Object)this.e.f());
                  throw new e(var7);
               }
            }
         }

         this.g.a(var3, var5);
         this.h.add(var5);
         var5.c();
         var5.a(this, this, var1, var2);
      }

      return var5;
   }
}
