import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class lc {
   private final le b;
   private static final Logger a = LogManager.getLogger();
   private final int[][] i = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
   private final List<lc.a> e = Lists.newArrayList();
   private final nq<lc.a> d = new nq();
   private final List<lc.a> f = Lists.newArrayList();
   private final List<lf> c = Lists.newArrayList();
   private int g;
   private long h;

   static Logger c() {
      return a;
   }

   public lc(le var1) {
      this.b = var1;
      this.a(var1.r().ap().s());
   }

   static List c(lc var0) {
      return var0.f;
   }

   public void b() {
      long var1 = this.b.K();
      int var3;
      lc.a var4;
      if (var1 - this.h > 8000L) {
         this.h = var1;

         for(var3 = 0; var3 < this.f.size(); ++var3) {
            var4 = (lc.a)this.f.get(var3);
            var4.b();
            var4.a();
         }
      } else {
         for(var3 = 0; var3 < this.e.size(); ++var3) {
            var4 = (lc.a)this.e.get(var3);
            var4.b();
         }
      }

      this.e.clear();
      if (this.c.isEmpty()) {
         anm var5 = this.b.t;
         if (!var5.e()) {
            this.b.b.b();
         }
      }

   }

   static List d(lc var0) {
      return var0.e;
   }

   public le a() {
      return this.b;
   }

   public static int b(int var0) {
      return var0 * 16 - 16;
   }

   private boolean a(int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1 - var3;
      int var7 = var2 - var4;
      if (var6 >= -var5 && var6 <= var5) {
         return var7 >= -var5 && var7 <= var5;
      } else {
         return false;
      }
   }

   public void a(cj var1) {
      int var2 = var1.n() >> 4;
      int var3 = var1.p() >> 4;
      lc.a var4 = this.a(var2, var3, false);
      if (var4 != null) {
         var4.a(var1.n() & 15, var1.o(), var1.p() & 15);
      }

   }

   static le a(lc var0) {
      return var0.b;
   }

   private lc.a a(int var1, int var2, boolean var3) {
      long var4 = (long)var1 + 2147483647L | (long)var2 + 2147483647L << 32;
      lc.a var6 = (lc.a)this.d.a(var4);
      if (var6 == null && var3) {
         var6 = new lc.a(this, var1, var2);
         this.d.a(var4, var6);
         this.f.add(var6);
      }

      return var6;
   }

   public void a(int var1) {
      var1 = ns.a(var1, 3, 32);
      if (var1 != this.g) {
         int var2 = var1 - this.g;
         ArrayList var3 = Lists.newArrayList(this.c);
         Iterator var4 = var3.iterator();

         while(true) {
            while(var4.hasNext()) {
               lf var5 = (lf)var4.next();
               int var6 = (int)var5.s >> 4;
               int var7 = (int)var5.u >> 4;
               int var8;
               int var9;
               if (var2 > 0) {
                  for(var8 = var6 - var1; var8 <= var6 + var1; ++var8) {
                     for(var9 = var7 - var1; var9 <= var7 + var1; ++var9) {
                        lc.a var10 = this.a(var8, var9, true);
                        if (!lc.a.b(var10).contains(var5)) {
                           var10.a(var5);
                        }
                     }
                  }
               } else {
                  for(var8 = var6 - this.g; var8 <= var6 + this.g; ++var8) {
                     for(var9 = var7 - this.g; var9 <= var7 + this.g; ++var9) {
                        if (!this.a(var8, var9, var6, var7, var1)) {
                           this.a(var8, var9, true).b(var5);
                        }
                     }
                  }
               }
            }

            this.g = var1;
            return;
         }
      }
   }

   public void d(lf var1) {
      int var2 = (int)var1.s >> 4;
      int var3 = (int)var1.u >> 4;
      double var4 = var1.d - var1.s;
      double var6 = var1.e - var1.u;
      double var8 = var4 * var4 + var6 * var6;
      if (!(var8 < 64.0D)) {
         int var10 = (int)var1.d >> 4;
         int var11 = (int)var1.e >> 4;
         int var12 = this.g;
         int var13 = var2 - var10;
         int var14 = var3 - var11;
         if (var13 != 0 || var14 != 0) {
            for(int var15 = var2 - var12; var15 <= var2 + var12; ++var15) {
               for(int var16 = var3 - var12; var16 <= var3 + var12; ++var16) {
                  if (!this.a(var15, var16, var10, var11, var12)) {
                     this.a(var15, var16, true).a(var1);
                  }

                  if (!this.a(var15 - var13, var16 - var14, var2, var3, var12)) {
                     lc.a var17 = this.a(var15 - var13, var16 - var14, false);
                     if (var17 != null) {
                        var17.b(var1);
                     }
                  }
               }
            }

            this.b(var1);
            var1.d = var1.s;
            var1.e = var1.u;
         }
      }
   }

   public void c(lf var1) {
      int var2 = (int)var1.d >> 4;
      int var3 = (int)var1.e >> 4;

      for(int var4 = var2 - this.g; var4 <= var2 + this.g; ++var4) {
         for(int var5 = var3 - this.g; var5 <= var3 + this.g; ++var5) {
            lc.a var6 = this.a(var4, var5, false);
            if (var6 != null) {
               var6.b(var1);
            }
         }
      }

      this.c.remove(var1);
   }

   public void b(lf var1) {
      ArrayList var2 = Lists.newArrayList(var1.f);
      int var3 = 0;
      int var4 = this.g;
      int var5 = (int)var1.s >> 4;
      int var6 = (int)var1.u >> 4;
      int var7 = 0;
      int var8 = 0;
      adg var9 = lc.a.a(this.a(var5, var6, true));
      var1.f.clear();
      if (var2.contains(var9)) {
         var1.f.add(var9);
      }

      int var10;
      for(var10 = 1; var10 <= var4 * 2; ++var10) {
         for(int var11 = 0; var11 < 2; ++var11) {
            int[] var12 = this.i[var3++ % 4];

            for(int var13 = 0; var13 < var10; ++var13) {
               var7 += var12[0];
               var8 += var12[1];
               var9 = lc.a.a(this.a(var5 + var7, var6 + var8, true));
               if (var2.contains(var9)) {
                  var1.f.add(var9);
               }
            }
         }
      }

      var3 %= 4;

      for(var10 = 0; var10 < var4 * 2; ++var10) {
         var7 += this.i[var3][0];
         var8 += this.i[var3][1];
         var9 = lc.a.a(this.a(var5 + var7, var6 + var8, true));
         if (var2.contains(var9)) {
            var1.f.add(var9);
         }
      }

   }

   public boolean a(lf var1, int var2, int var3) {
      lc.a var4 = this.a(var2, var3, false);
      return var4 != null && lc.a.b(var4).contains(var1) && !var1.f.contains(lc.a.a(var4));
   }

   static nq b(lc var0) {
      return var0.d;
   }

   public boolean a(int var1, int var2) {
      long var3 = (long)var1 + 2147483647L | (long)var2 + 2147483647L << 32;
      return this.d.a(var3) != null;
   }

   public void a(lf var1) {
      int var2 = (int)var1.s >> 4;
      int var3 = (int)var1.u >> 4;
      var1.d = var1.s;
      var1.e = var1.u;

      for(int var4 = var2 - this.g; var4 <= var2 + this.g; ++var4) {
         for(int var5 = var3 - this.g; var5 <= var3 + this.g; ++var5) {
            this.a(var4, var5, true).a(var1);
         }
      }

      this.c.add(var1);
      this.b(var1);
   }

   class a {
      final lc a;
      private int e;
      private final adg c;
      private final List<lf> b;
      private short[] d;
      private int f;
      private long g;

      public void b() {
         if (this.e != 0) {
            int var1;
            int var2;
            int var3;
            if (this.e == 1) {
               var1 = (this.d[0] >> 12 & 15) + this.c.a * 16;
               var2 = this.d[0] & 255;
               var3 = (this.d[0] >> 8 & 15) + this.c.b * 16;
               cj var4 = new cj(var1, var2, var3);
               this.a((ff)(new fv(lc.a(this.a), var4)));
               if (lc.a(this.a).p(var4).c().z()) {
                  this.a(lc.a(this.a).s(var4));
               }
            } else {
               int var7;
               if (this.e == 64) {
                  var1 = this.c.a * 16;
                  var2 = this.c.b * 16;
                  this.a((ff)(new go(lc.a(this.a).a(this.c.a, this.c.b), false, this.f)));

                  for(var3 = 0; var3 < 16; ++var3) {
                     if ((this.f & 1 << var3) != 0) {
                        var7 = var3 << 4;
                        List var5 = lc.a(this.a).a(var1, var7, var2, var1 + 16, var7 + 16, var2 + 16);

                        for(int var6 = 0; var6 < var5.size(); ++var6) {
                           this.a((akw)var5.get(var6));
                        }
                     }
                  }
               } else {
                  this.a((ff)(new fz(this.e, this.d, lc.a(this.a).a(this.c.a, this.c.b))));

                  for(var1 = 0; var1 < this.e; ++var1) {
                     var2 = (this.d[var1] >> 12 & 15) + this.c.a * 16;
                     var3 = this.d[var1] & 255;
                     var7 = (this.d[var1] >> 8 & 15) + this.c.b * 16;
                     cj var8 = new cj(var2, var3, var7);
                     if (lc.a(this.a).p(var8).c().z()) {
                        this.a(lc.a(this.a).s(var8));
                     }
                  }
               }
            }

            this.e = 0;
            this.f = 0;
         }
      }

      public void a(ff var1) {
         for(int var2 = 0; var2 < this.b.size(); ++var2) {
            lf var3 = (lf)this.b.get(var2);
            if (!var3.f.contains(this.c)) {
               var3.a.a(var1);
            }
         }

      }

      private void a(akw var1) {
         if (var1 != null) {
            ff var2 = var1.y_();
            if (var2 != null) {
               this.a(var2);
            }
         }

      }

      private void a(amy var1) {
         var1.c(var1.w() + lc.a(this.a).K() - this.g);
         this.g = lc.a(this.a).K();
      }

      public void a(lf var1) {
         if (this.b.contains(var1)) {
            lc.c().debug("Failed to add player. {} already is in chunk {}, {}", new Object[]{var1, this.c.a, this.c.b});
         } else {
            if (this.b.isEmpty()) {
               this.g = lc.a(this.a).K();
            }

            this.b.add(var1);
            var1.f.add(this.c);
         }
      }

      public void a(int var1, int var2, int var3) {
         if (this.e == 0) {
            lc.d(this.a).add(this);
         }

         this.f |= 1 << (var2 >> 4);
         if (this.e < 64) {
            short var4 = (short)(var1 << 12 | var3 << 8 | var2);

            for(int var5 = 0; var5 < this.e; ++var5) {
               if (this.d[var5] == var4) {
                  return;
               }
            }

            this.d[this.e++] = var4;
         }

      }

      static List b(lc.a var0) {
         return var0.b;
      }

      static adg a(lc.a var0) {
         return var0.c;
      }

      public a(lc var1, int var2, int var3) {
         this.a = var1;
         this.b = Lists.newArrayList();
         this.d = new short[64];
         this.c = new adg(var2, var3);
         var1.a().b.c(var2, var3);
      }

      public void b(lf var1) {
         if (this.b.contains(var1)) {
            amy var2 = lc.a(this.a).a(this.c.a, this.c.b);
            if (var2.i()) {
               var1.a.a((ff)(new go(var2, true, 0)));
            }

            this.b.remove(var1);
            var1.f.remove(this.c);
            if (this.b.isEmpty()) {
               long var3 = (long)this.c.a + 2147483647L | (long)this.c.b + 2147483647L << 32;
               this.a(var2);
               lc.b(this.a).d(var3);
               lc.c(this.a).remove(this);
               if (this.e > 0) {
                  lc.d(this.a).remove(this);
               }

               this.a.a().b.b(this.c.a, this.c.b);
            }

         }
      }

      public void a() {
         this.a(lc.a(this.a).a(this.c.a, this.c.b));
      }
   }
}
