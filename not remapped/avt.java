import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class avt extends avp {
   private final ave f;
   private static final Logger a = LogManager.getLogger();
   private final List<ava> i = Lists.newArrayList();
   private final List<ava> h = Lists.newArrayList();
   private int j;
   private boolean k;
   private final List<String> g = Lists.newArrayList();

   public void c(int var1) {
      Iterator var2 = this.i.iterator();

      ava var3;
      while(var2.hasNext()) {
         var3 = (ava)var2.next();
         if (var3.c() == var1) {
            var2.remove();
         }
      }

      var2 = this.h.iterator();

      while(var2.hasNext()) {
         var3 = (ava)var2.next();
         if (var3.c() == var1) {
            var2.remove();
            break;
         }
      }

   }

   public boolean e() {
      return this.f.m instanceof awv;
   }

   public int g() {
      return b(this.e() ? this.f.t.H : this.f.t.G);
   }

   public void a(String var1) {
      if (this.g.isEmpty() || !((String)this.g.get(this.g.size() - 1)).equals(var1)) {
         this.g.add(var1);
      }

   }

   private void a(eu var1, int var2, int var3, boolean var4) {
      if (var2 != 0) {
         this.c(var2);
      }

      int var5 = ns.d((float)this.f() / this.h());
      List var6 = avu.a(var1, var5, this.f.k, false, false);
      boolean var7 = this.e();

      eu var9;
      for(Iterator var8 = var6.iterator(); var8.hasNext(); this.i.add(0, new ava(var3, var9, var2))) {
         var9 = (eu)var8.next();
         if (var7 && this.j > 0) {
            this.k = true;
            this.b(1);
         }
      }

      while(this.i.size() > 100) {
         this.i.remove(this.i.size() - 1);
      }

      if (!var4) {
         this.h.add(0, new ava(var3, var1, var2));

         while(this.h.size() > 100) {
            this.h.remove(this.h.size() - 1);
         }
      }

   }

   public void a(int var1) {
      if (this.f.t.m != wn.b.c) {
         int var2 = this.i();
         boolean var3 = false;
         int var4 = 0;
         int var5 = this.i.size();
         float var6 = this.f.t.q * 0.9F + 0.1F;
         if (var5 > 0) {
            if (this.e()) {
               var3 = true;
            }

            float var7 = this.h();
            int var8 = ns.f((float)this.f() / var7);
            bfl.E();
            bfl.b(2.0F, 20.0F, 0.0F);
            bfl.a(var7, var7, 1.0F);

            int var9;
            int var11;
            int var14;
            for(var9 = 0; var9 + this.j < this.i.size() && var9 < var2; ++var9) {
               ava var10 = (ava)this.i.get(var9 + this.j);
               if (var10 != null) {
                  var11 = var1 - var10.b();
                  if (var11 < 200 || var3) {
                     double var12 = (double)var11 / 200.0D;
                     var12 = 1.0D - var12;
                     var12 *= 10.0D;
                     var12 = ns.a(var12, 0.0D, 1.0D);
                     var12 *= var12;
                     var14 = (int)(255.0D * var12);
                     if (var3) {
                        var14 = 255;
                     }

                     var14 = (int)((float)var14 * var6);
                     ++var4;
                     if (var14 > 3) {
                        byte var15 = 0;
                        int var16 = -var9 * 9;
                        a(var15, var16 - 9, var15 + var8 + 4, var16, var14 / 2 << 24);
                        String var17 = var10.a().d();
                        bfl.l();
                        this.f.k.a(var17, (float)var15, (float)(var16 - 8), 16777215 + (var14 << 24));
                        bfl.c();
                        bfl.k();
                     }
                  }
               }
            }

            if (var3) {
               var9 = this.f.k.a;
               bfl.b(-3.0F, 0.0F, 0.0F);
               int var18 = var5 * var9 + var5;
               var11 = var4 * var9 + var4;
               int var19 = this.j * var11 / var5;
               int var13 = var11 * var11 / var18;
               if (var18 != var11) {
                  var14 = var19 > 0 ? 170 : 96;
                  int var20 = this.k ? 13382451 : 3355562;
                  a(0, -var19, 2, -var19 - var13, var20 + (var14 << 24));
                  a(2, -var19, 1, -var19 - var13, 13421772 + (var14 << 24));
               }
            }

            bfl.F();
         }
      }
   }

   public int f() {
      return a(this.f.t.F);
   }

   public void a(eu var1, int var2) {
      this.a(var1, var2, this.f.q.e(), false);
      a.info("[CHAT] " + var1.c());
   }

   public avt(ave var1) {
      this.f = var1;
   }

   public eu a(int var1, int var2) {
      if (!this.e()) {
         return null;
      } else {
         avr var3 = new avr(this.f);
         int var4 = var3.e();
         float var5 = this.h();
         int var6 = var1 / var4 - 3;
         int var7 = var2 / var4 - 27;
         var6 = ns.d((float)var6 / var5);
         var7 = ns.d((float)var7 / var5);
         if (var6 >= 0 && var7 >= 0) {
            int var8 = Math.min(this.i(), this.i.size());
            if (var6 <= ns.d((float)this.f() / this.h()) && var7 < this.f.k.a * var8 + var8) {
               int var9 = var7 / this.f.k.a + this.j;
               if (var9 >= 0 && var9 < this.i.size()) {
                  ava var10 = (ava)this.i.get(var9);
                  int var11 = 0;
                  Iterator var12 = var10.a().iterator();

                  while(var12.hasNext()) {
                     eu var13 = (eu)var12.next();
                     if (var13 instanceof fa) {
                        var11 += this.f.k.a(avu.a(((fa)var13).g(), false));
                        if (var11 > var6) {
                           return var13;
                        }
                     }
                  }
               }

               return null;
            } else {
               return null;
            }
         } else {
            return null;
         }
      }
   }

   public void b(int var1) {
      this.j += var1;
      int var2 = this.i.size();
      if (this.j > var2 - this.i()) {
         this.j = var2 - this.i();
      }

      if (this.j <= 0) {
         this.j = 0;
         this.k = false;
      }

   }

   public void d() {
      this.j = 0;
      this.k = false;
   }

   public void a() {
      this.i.clear();
      this.h.clear();
      this.g.clear();
   }

   public void a(eu var1) {
      this.a(var1, 0);
   }

   public int i() {
      return this.g() / 9;
   }

   public List<String> c() {
      return this.g;
   }

   public static int a(float var0) {
      short var1 = 320;
      byte var2 = 40;
      return ns.d(var0 * (float)(var1 - var2) + (float)var2);
   }

   public void b() {
      this.i.clear();
      this.d();

      for(int var1 = this.h.size() - 1; var1 >= 0; --var1) {
         ava var2 = (ava)this.h.get(var1);
         this.a(var2.a(), var2.c(), var2.b(), true);
      }

   }

   public float h() {
      return this.f.t.E;
   }

   public static int b(float var0) {
      short var1 = 180;
      byte var2 = 20;
      return ns.d(var0 * (float)(var1 - var2) + (float)var2);
   }
}
