import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class aqj {
   private static final aqj.n[] a = new aqj.n[]{new aqj.n(aqj.c.class, 30, 0, true), new aqj.n(aqj.a.class, 10, 4), new aqj.n(aqj.o.class, 10, 4), new aqj.n(aqj.p.class, 10, 3), new aqj.n(aqj.l.class, 5, 2), new aqj.n(aqj.f.class, 5, 1)};
   private static final aqj.n[] b = new aqj.n[]{new aqj.n(aqj.i.class, 25, 0, true), new aqj.n(aqj.g.class, 15, 5), new aqj.n(aqj.j.class, 5, 10), new aqj.n(aqj.h.class, 5, 10), new aqj.n(aqj.d.class, 10, 3, true), new aqj.n(aqj.e.class, 7, 2), new aqj.n(aqj.k.class, 5, 2)};

   static aqj.m a(aqj.n var0, List var1, Random var2, int var3, int var4, int var5, cq var6, int var7) {
      return b(var0, var1, var2, var3, var4, var5, var6, var7);
   }

   private static aqj.m b(aqj.n var0, List<aqt> var1, Random var2, int var3, int var4, int var5, cq var6, int var7) {
      Class var8 = var0.a;
      Object var9 = null;
      if (var8 == aqj.c.class) {
         var9 = aqj.c.a(var1, var2, var3, var4, var5, var6, var7);
      } else if (var8 == aqj.a.class) {
         var9 = aqj.a.a(var1, var2, var3, var4, var5, var6, var7);
      } else if (var8 == aqj.o.class) {
         var9 = aqj.o.a(var1, var2, var3, var4, var5, var6, var7);
      } else if (var8 == aqj.p.class) {
         var9 = aqj.p.a(var1, var2, var3, var4, var5, var7, var6);
      } else if (var8 == aqj.l.class) {
         var9 = aqj.l.a(var1, var2, var3, var4, var5, var7, var6);
      } else if (var8 == aqj.f.class) {
         var9 = aqj.f.a(var1, var2, var3, var4, var5, var6, var7);
      } else if (var8 == aqj.i.class) {
         var9 = aqj.i.a(var1, var2, var3, var4, var5, var6, var7);
      } else if (var8 == aqj.j.class) {
         var9 = aqj.j.a(var1, var2, var3, var4, var5, var6, var7);
      } else if (var8 == aqj.h.class) {
         var9 = aqj.h.a(var1, var2, var3, var4, var5, var6, var7);
      } else if (var8 == aqj.d.class) {
         var9 = aqj.d.a(var1, var2, var3, var4, var5, var6, var7);
      } else if (var8 == aqj.e.class) {
         var9 = aqj.e.a(var1, var2, var3, var4, var5, var6, var7);
      } else if (var8 == aqj.g.class) {
         var9 = aqj.g.a(var1, var2, var3, var4, var5, var6, var7);
      } else if (var8 == aqj.k.class) {
         var9 = aqj.k.a(var1, var2, var3, var4, var5, var6, var7);
      }

      return (aqj.m)var9;
   }

   static aqj.n[] c() {
      return b;
   }

   static aqj.n[] b() {
      return a;
   }

   public static void a() {
      aqr.a(aqj.a.class, "NeBCr");
      aqr.a(aqj.b.class, "NeBEF");
      aqr.a(aqj.c.class, "NeBS");
      aqr.a(aqj.d.class, "NeCCS");
      aqr.a(aqj.e.class, "NeCTB");
      aqr.a(aqj.f.class, "NeCE");
      aqr.a(aqj.g.class, "NeSCSC");
      aqr.a(aqj.h.class, "NeSCLT");
      aqr.a(aqj.i.class, "NeSC");
      aqr.a(aqj.j.class, "NeSCRT");
      aqr.a(aqj.k.class, "NeCSR");
      aqr.a(aqj.l.class, "NeMT");
      aqr.a(aqj.o.class, "NeRC");
      aqr.a(aqj.p.class, "NeSR");
      aqr.a(aqj.q.class, "NeStart");
   }

   public static class e extends aqj.m {
      public boolean a(adm var1, Random var2, aqe var3) {
         this.a(var1, var3, 0, 0, 0, 8, 1, 8, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 2, 0, 8, 5, 8, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 0, 6, 0, 8, 6, 5, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 2, 0, 2, 5, 0, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 6, 2, 0, 8, 5, 0, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 1, 3, 0, 1, 4, 0, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 7, 3, 0, 7, 4, 0, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 0, 2, 4, 8, 2, 8, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 1, 1, 4, 2, 2, 4, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 6, 1, 4, 7, 2, 4, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 0, 3, 8, 8, 3, 8, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 0, 3, 6, 0, 3, 7, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 8, 3, 6, 8, 3, 7, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 0, 3, 4, 0, 5, 5, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 8, 3, 4, 8, 5, 5, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 1, 3, 5, 2, 5, 5, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 6, 3, 5, 7, 5, 5, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 1, 4, 5, 1, 5, 5, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 7, 4, 5, 7, 5, 5, afi.bz.Q(), afi.bz.Q(), false);

         for(int var4 = 0; var4 <= 5; ++var4) {
            for(int var5 = 0; var5 <= 8; ++var5) {
               this.b(var1, afi.by.Q(), var5, -1, var4, var3);
            }
         }

         return true;
      }

      public e(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.l = var3;
      }

      public static aqj.e a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
         aqe var7 = aqe.a(var2, var3, var4, -3, 0, 0, 9, 7, 9, var5);
         return a(var7) && aqt.a(var0, var7) == null ? new aqj.e(var6, var1, var7, var5) : null;
      }

      public e() {
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         byte var4 = 1;
         if (this.m == cq.e || this.m == cq.c) {
            var4 = 5;
         }

         this.b((aqj.q)var1, var2, var3, 0, var4, var3.nextInt(8) > 0);
         this.c((aqj.q)var1, var2, var3, 0, var4, var3.nextInt(8) > 0);
      }
   }

   public static class h extends aqj.m {
      private boolean b;

      protected void a(dn var1) {
         super.a(var1);
         var1.a("Chest", this.b);
      }

      public h(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.l = var3;
         this.b = var2.nextInt(3) == 0;
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         this.a(var1, var3, 0, 0, 0, 4, 1, 4, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 2, 0, 4, 5, 4, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 4, 2, 0, 4, 5, 4, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 4, 3, 1, 4, 4, 1, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 4, 3, 3, 4, 4, 3, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 0, 2, 0, 0, 5, 0, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 2, 4, 3, 5, 4, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 1, 3, 4, 1, 4, 4, afi.bz.Q(), afi.by.Q(), false);
         this.a(var1, var3, 3, 3, 4, 3, 4, 4, afi.bz.Q(), afi.by.Q(), false);
         if (this.b && var3.b((df)(new cj(this.a(3, 3), this.d(2), this.b(3, 3))))) {
            this.b = false;
            this.a(var1, var3, var2, 3, 2, 3, a, 2 + var2.nextInt(4));
         }

         this.a(var1, var3, 0, 6, 0, 4, 6, 4, afi.by.Q(), afi.by.Q(), false);

         for(int var4 = 0; var4 <= 4; ++var4) {
            for(int var5 = 0; var5 <= 4; ++var5) {
               this.b(var1, afi.by.Q(), var4, -1, var5, var3);
            }
         }

         return true;
      }

      public h() {
      }

      protected void b(dn var1) {
         super.b(var1);
         this.b = var1.n("Chest");
      }

      public static aqj.h a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
         aqe var7 = aqe.a(var2, var3, var4, -1, 0, 0, 5, 7, 5, var5);
         return a(var7) && aqt.a(var0, var7) == null ? new aqj.h(var6, var1, var7, var5) : null;
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         this.b((aqj.q)var1, var2, var3, 0, 1, true);
      }
   }

   public static class p extends aqj.m {
      public p() {
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         this.a(var1, var3, 0, 0, 0, 6, 1, 6, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 2, 0, 6, 10, 6, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 0, 2, 0, 1, 8, 0, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 5, 2, 0, 6, 8, 0, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 2, 1, 0, 8, 6, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 6, 2, 1, 6, 8, 6, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 1, 2, 6, 5, 8, 6, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 3, 2, 0, 5, 4, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 6, 3, 2, 6, 5, 2, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 6, 3, 4, 6, 5, 4, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, afi.by.Q(), 5, 2, 5, var3);
         this.a(var1, var3, 4, 2, 5, 4, 3, 5, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 3, 2, 5, 3, 4, 5, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 2, 2, 5, 2, 5, 5, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 1, 2, 5, 1, 6, 5, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 1, 7, 1, 5, 7, 4, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 6, 8, 2, 6, 8, 4, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 2, 6, 0, 4, 8, 0, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 2, 5, 0, 4, 5, 0, afi.bz.Q(), afi.bz.Q(), false);

         for(int var4 = 0; var4 <= 6; ++var4) {
            for(int var5 = 0; var5 <= 6; ++var5) {
               this.b(var1, afi.by.Q(), var4, -1, var5, var3);
            }
         }

         return true;
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         this.c((aqj.q)var1, var2, var3, 6, 2, false);
      }

      public static aqj.p a(List<aqt> var0, Random var1, int var2, int var3, int var4, int var5, cq var6) {
         aqe var7 = aqe.a(var2, var3, var4, -2, 0, 0, 7, 11, 7, var6);
         return a(var7) && aqt.a(var0, var7) == null ? new aqj.p(var5, var1, var7, var6) : null;
      }

      public p(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.l = var3;
      }
   }

   public static class q extends aqj.a {
      public List<aqj.n> c;
      public List<aqt> e = Lists.newArrayList();
      public aqj.n b;
      public List<aqj.n> d;

      protected void b(dn var1) {
         super.b(var1);
      }

      public q(Random var1, int var2, int var3) {
         super(var1, var2, var3);
         this.c = Lists.newArrayList();
         aqj.n[] var4 = aqj.b();
         int var5 = var4.length;

         int var6;
         aqj.n var7;
         for(var6 = 0; var6 < var5; ++var6) {
            var7 = var4[var6];
            var7.c = 0;
            this.c.add(var7);
         }

         this.d = Lists.newArrayList();
         var4 = aqj.c();
         var5 = var4.length;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = var4[var6];
            var7.c = 0;
            this.d.add(var7);
         }

      }

      public q() {
      }

      protected void a(dn var1) {
         super.a(var1);
      }
   }

   public static class d extends aqj.m {
      public d(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.l = var3;
      }

      public static aqj.d a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
         aqe var7 = aqe.a(var2, var3, var4, -1, -7, 0, 5, 14, 10, var5);
         return a(var7) && aqt.a(var0, var7) == null ? new aqj.d(var6, var1, var7, var5) : null;
      }

      public d() {
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         int var4 = this.a(afi.bA, 2);

         for(int var5 = 0; var5 <= 9; ++var5) {
            int var6 = Math.max(1, 7 - var5);
            int var7 = Math.min(Math.max(var6 + 5, 14 - var5), 13);
            int var8 = var5;
            this.a(var1, var3, 0, 0, var5, 4, var6, var5, afi.by.Q(), afi.by.Q(), false);
            this.a(var1, var3, 1, var6 + 1, var5, 3, var7 - 1, var5, afi.a.Q(), afi.a.Q(), false);
            if (var5 <= 6) {
               this.a(var1, afi.bA.a(var4), 1, var6 + 1, var5, var3);
               this.a(var1, afi.bA.a(var4), 2, var6 + 1, var5, var3);
               this.a(var1, afi.bA.a(var4), 3, var6 + 1, var5, var3);
            }

            this.a(var1, var3, 0, var7, var5, 4, var7, var5, afi.by.Q(), afi.by.Q(), false);
            this.a(var1, var3, 0, var6 + 1, var5, 0, var7 - 1, var5, afi.by.Q(), afi.by.Q(), false);
            this.a(var1, var3, 4, var6 + 1, var5, 4, var7 - 1, var5, afi.by.Q(), afi.by.Q(), false);
            if ((var5 & 1) == 0) {
               this.a(var1, var3, 0, var6 + 2, var5, 0, var6 + 3, var5, afi.bz.Q(), afi.bz.Q(), false);
               this.a(var1, var3, 4, var6 + 2, var5, 4, var6 + 3, var5, afi.bz.Q(), afi.bz.Q(), false);
            }

            for(int var9 = 0; var9 <= 4; ++var9) {
               this.b(var1, afi.by.Q(), var9, -1, var8, var3);
            }
         }

         return true;
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         this.a((aqj.q)var1, var2, var3, 1, 0, true);
      }
   }

   public static class f extends aqj.m {
      public f() {
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         this.a((aqj.q)var1, var2, var3, 5, 3, true);
      }

      public f(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.l = var3;
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         this.a(var1, var3, 0, 3, 0, 12, 4, 12, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 5, 0, 12, 13, 12, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 0, 5, 0, 1, 12, 12, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 11, 5, 0, 12, 12, 12, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 2, 5, 11, 4, 12, 12, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 8, 5, 11, 10, 12, 12, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 5, 9, 11, 7, 12, 12, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 2, 5, 0, 4, 12, 1, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 8, 5, 0, 10, 12, 1, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 5, 9, 0, 7, 12, 1, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 2, 11, 2, 10, 12, 10, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 5, 8, 0, 7, 8, 0, afi.bz.Q(), afi.bz.Q(), false);

         int var4;
         for(var4 = 1; var4 <= 11; var4 += 2) {
            this.a(var1, var3, var4, 10, 0, var4, 11, 0, afi.bz.Q(), afi.bz.Q(), false);
            this.a(var1, var3, var4, 10, 12, var4, 11, 12, afi.bz.Q(), afi.bz.Q(), false);
            this.a(var1, var3, 0, 10, var4, 0, 11, var4, afi.bz.Q(), afi.bz.Q(), false);
            this.a(var1, var3, 12, 10, var4, 12, 11, var4, afi.bz.Q(), afi.bz.Q(), false);
            this.a(var1, afi.by.Q(), var4, 13, 0, var3);
            this.a(var1, afi.by.Q(), var4, 13, 12, var3);
            this.a(var1, afi.by.Q(), 0, 13, var4, var3);
            this.a(var1, afi.by.Q(), 12, 13, var4, var3);
            this.a(var1, afi.bz.Q(), var4 + 1, 13, 0, var3);
            this.a(var1, afi.bz.Q(), var4 + 1, 13, 12, var3);
            this.a(var1, afi.bz.Q(), 0, 13, var4 + 1, var3);
            this.a(var1, afi.bz.Q(), 12, 13, var4 + 1, var3);
         }

         this.a(var1, afi.bz.Q(), 0, 13, 0, var3);
         this.a(var1, afi.bz.Q(), 0, 13, 12, var3);
         this.a(var1, afi.bz.Q(), 0, 13, 0, var3);
         this.a(var1, afi.bz.Q(), 12, 13, 0, var3);

         for(var4 = 3; var4 <= 9; var4 += 2) {
            this.a(var1, var3, 1, 7, var4, 1, 8, var4, afi.bz.Q(), afi.bz.Q(), false);
            this.a(var1, var3, 11, 7, var4, 11, 8, var4, afi.bz.Q(), afi.bz.Q(), false);
         }

         this.a(var1, var3, 4, 2, 0, 8, 2, 12, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 2, 4, 12, 2, 8, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 4, 0, 0, 8, 1, 3, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 4, 0, 9, 8, 1, 12, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 0, 4, 3, 1, 8, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 9, 0, 4, 12, 1, 8, afi.by.Q(), afi.by.Q(), false);

         int var5;
         for(var4 = 4; var4 <= 8; ++var4) {
            for(var5 = 0; var5 <= 2; ++var5) {
               this.b(var1, afi.by.Q(), var4, -1, var5, var3);
               this.b(var1, afi.by.Q(), var4, -1, 12 - var5, var3);
            }
         }

         for(var4 = 0; var4 <= 2; ++var4) {
            for(var5 = 4; var5 <= 8; ++var5) {
               this.b(var1, afi.by.Q(), var4, -1, var5, var3);
               this.b(var1, afi.by.Q(), 12 - var4, -1, var5, var3);
            }
         }

         this.a(var1, var3, 5, 5, 5, 7, 5, 7, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 6, 1, 6, 6, 4, 6, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, afi.by.Q(), 6, 0, 6, var3);
         this.a(var1, afi.k.Q(), 6, 5, 6, var3);
         cj var6 = new cj(this.a(6, 6), this.d(5), this.b(6, 6));
         if (var3.b((df)var6)) {
            var1.a((afh)afi.k, (cj)var6, (Random)var2);
         }

         return true;
      }

      public static aqj.f a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
         aqe var7 = aqe.a(var2, var3, var4, -5, -3, 0, 13, 14, 13, var5);
         return a(var7) && aqt.a(var0, var7) == null ? new aqj.f(var6, var1, var7, var5) : null;
      }
   }

   public static class g extends aqj.m {
      public g() {
      }

      public static aqj.g a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
         aqe var7 = aqe.a(var2, var3, var4, -1, 0, 0, 5, 7, 5, var5);
         return a(var7) && aqt.a(var0, var7) == null ? new aqj.g(var6, var1, var7, var5) : null;
      }

      public g(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.l = var3;
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         this.a((aqj.q)var1, var2, var3, 1, 0, true);
         this.b((aqj.q)var1, var2, var3, 0, 1, true);
         this.c((aqj.q)var1, var2, var3, 0, 1, true);
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         this.a(var1, var3, 0, 0, 0, 4, 1, 4, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 2, 0, 4, 5, 4, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 0, 2, 0, 0, 5, 0, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 4, 2, 0, 4, 5, 0, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 2, 4, 0, 5, 4, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 4, 2, 4, 4, 5, 4, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 6, 0, 4, 6, 4, afi.by.Q(), afi.by.Q(), false);

         for(int var4 = 0; var4 <= 4; ++var4) {
            for(int var5 = 0; var5 <= 4; ++var5) {
               this.b(var1, afi.by.Q(), var4, -1, var5, var3);
            }
         }

         return true;
      }
   }

   abstract static class m extends aqt {
      protected static final List<ob> a;

      static {
         a = Lists.newArrayList(new ob[]{new ob(zy.i, 0, 1, 3, 5), new ob(zy.j, 0, 1, 5, 5), new ob(zy.k, 0, 1, 3, 15), new ob(zy.B, 0, 1, 1, 5), new ob(zy.ah, 0, 1, 1, 5), new ob(zy.d, 0, 1, 1, 5), new ob(zy.by, 0, 3, 7, 5), new ob(zy.aA, 0, 1, 1, 10), new ob(zy.cl, 0, 1, 1, 8), new ob(zy.ck, 0, 1, 1, 5), new ob(zy.cm, 0, 1, 1, 3), new ob(zw.a(afi.Z), 0, 2, 4, 2)});
      }

      protected aqt a(aqj.q var1, List<aqt> var2, Random var3, int var4, int var5, boolean var6) {
         if (this.m != null) {
            switch(this.m) {
            case c:
               return this.a(var1, var2, var3, this.l.a + var4, this.l.b + var5, this.l.c - 1, this.m, this.d(), var6);
            case d:
               return this.a(var1, var2, var3, this.l.a + var4, this.l.b + var5, this.l.f + 1, this.m, this.d(), var6);
            case e:
               return this.a(var1, var2, var3, this.l.a - 1, this.l.b + var5, this.l.c + var4, this.m, this.d(), var6);
            case f:
               return this.a(var1, var2, var3, this.l.d + 1, this.l.b + var5, this.l.c + var4, this.m, this.d(), var6);
            }
         }

         return null;
      }

      public m() {
      }

      protected void b(dn var1) {
      }

      protected void a(dn var1) {
      }

      private aqj.m a(aqj.q var1, List<aqj.n> var2, List<aqt> var3, Random var4, int var5, int var6, int var7, cq var8, int var9) {
         int var10 = this.a(var2);
         boolean var11 = var10 > 0 && var9 <= 30;
         int var12 = 0;

         while(var12 < 5 && var11) {
            ++var12;
            int var13 = var4.nextInt(var10);
            Iterator var14 = var2.iterator();

            while(var14.hasNext()) {
               aqj.n var15 = (aqj.n)var14.next();
               var13 -= var15.b;
               if (var13 < 0) {
                  if (!var15.a(var9) || var15 == var1.b && !var15.e) {
                     break;
                  }

                  aqj.m var16 = aqj.a(var15, var3, var4, var5, var6, var7, var8, var9);
                  if (var16 != null) {
                     ++var15.c;
                     var1.b = var15;
                     if (!var15.a()) {
                        var2.remove(var15);
                     }

                     return var16;
                  }
               }
            }
         }

         return aqj.b.a(var3, var4, var5, var6, var7, var8, var9);
      }

      protected static boolean a(aqe var0) {
         return var0 != null && var0.b > 10;
      }

      protected aqt c(aqj.q var1, List<aqt> var2, Random var3, int var4, int var5, boolean var6) {
         if (this.m != null) {
            switch(this.m) {
            case c:
               return this.a(var1, var2, var3, this.l.d + 1, this.l.b + var4, this.l.c + var5, cq.f, this.d(), var6);
            case d:
               return this.a(var1, var2, var3, this.l.d + 1, this.l.b + var4, this.l.c + var5, cq.f, this.d(), var6);
            case e:
               return this.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.f + 1, cq.d, this.d(), var6);
            case f:
               return this.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.f + 1, cq.d, this.d(), var6);
            }
         }

         return null;
      }

      private int a(List<aqj.n> var1) {
         boolean var2 = false;
         int var3 = 0;

         aqj.n var5;
         for(Iterator var4 = var1.iterator(); var4.hasNext(); var3 += var5.b) {
            var5 = (aqj.n)var4.next();
            if (var5.d > 0 && var5.c < var5.d) {
               var2 = true;
            }
         }

         return var2 ? var3 : -1;
      }

      protected aqt b(aqj.q var1, List<aqt> var2, Random var3, int var4, int var5, boolean var6) {
         if (this.m != null) {
            switch(this.m) {
            case c:
               return this.a(var1, var2, var3, this.l.a - 1, this.l.b + var4, this.l.c + var5, cq.e, this.d(), var6);
            case d:
               return this.a(var1, var2, var3, this.l.a - 1, this.l.b + var4, this.l.c + var5, cq.e, this.d(), var6);
            case e:
               return this.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.c - 1, cq.c, this.d(), var6);
            case f:
               return this.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.c - 1, cq.c, this.d(), var6);
            }
         }

         return null;
      }

      private aqt a(aqj.q var1, List<aqt> var2, Random var3, int var4, int var5, int var6, cq var7, int var8, boolean var9) {
         if (Math.abs(var4 - var1.c().a) <= 112 && Math.abs(var6 - var1.c().c) <= 112) {
            List var10 = var1.c;
            if (var9) {
               var10 = var1.d;
            }

            aqj.m var11 = this.a(var1, var10, var2, var3, var4, var5, var6, var7, var8 + 1);
            if (var11 != null) {
               var2.add(var11);
               var1.e.add(var11);
            }

            return var11;
         } else {
            return aqj.b.a(var2, var3, var4, var5, var6, var7, var8);
         }
      }

      protected m(int var1) {
         super(var1);
      }
   }

   public static class b extends aqj.m {
      private int b;

      public static aqj.b a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
         aqe var7 = aqe.a(var2, var3, var4, -1, -3, 0, 5, 10, 8, var5);
         return a(var7) && aqt.a(var0, var7) == null ? new aqj.b(var6, var1, var7, var5) : null;
      }

      public b(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.l = var3;
         this.b = var2.nextInt();
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         Random var4 = new Random((long)this.b);

         int var5;
         int var6;
         int var7;
         for(var5 = 0; var5 <= 4; ++var5) {
            for(var6 = 3; var6 <= 4; ++var6) {
               var7 = var4.nextInt(8);
               this.a(var1, var3, var5, var6, 0, var5, var6, var7, afi.by.Q(), afi.by.Q(), false);
            }
         }

         var5 = var4.nextInt(8);
         this.a(var1, var3, 0, 5, 0, 0, 5, var5, afi.by.Q(), afi.by.Q(), false);
         var5 = var4.nextInt(8);
         this.a(var1, var3, 4, 5, 0, 4, 5, var5, afi.by.Q(), afi.by.Q(), false);

         for(var5 = 0; var5 <= 4; ++var5) {
            var6 = var4.nextInt(5);
            this.a(var1, var3, var5, 2, 0, var5, 2, var6, afi.by.Q(), afi.by.Q(), false);
         }

         for(var5 = 0; var5 <= 4; ++var5) {
            for(var6 = 0; var6 <= 1; ++var6) {
               var7 = var4.nextInt(3);
               this.a(var1, var3, var5, var6, 0, var5, var6, var7, afi.by.Q(), afi.by.Q(), false);
            }
         }

         return true;
      }

      protected void b(dn var1) {
         super.b(var1);
         this.b = var1.f("Seed");
      }

      protected void a(dn var1) {
         super.a(var1);
         var1.a("Seed", this.b);
      }

      public b() {
      }
   }

   public static class i extends aqj.m {
      public void a(aqt var1, List<aqt> var2, Random var3) {
         this.a((aqj.q)var1, var2, var3, 1, 0, true);
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         this.a(var1, var3, 0, 0, 0, 4, 1, 4, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 2, 0, 4, 5, 4, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 0, 2, 0, 0, 5, 4, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 4, 2, 0, 4, 5, 4, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 3, 1, 0, 4, 1, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 0, 3, 3, 0, 4, 3, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 4, 3, 1, 4, 4, 1, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 4, 3, 3, 4, 4, 3, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 0, 6, 0, 4, 6, 4, afi.by.Q(), afi.by.Q(), false);

         for(int var4 = 0; var4 <= 4; ++var4) {
            for(int var5 = 0; var5 <= 4; ++var5) {
               this.b(var1, afi.by.Q(), var4, -1, var5, var3);
            }
         }

         return true;
      }

      public i(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.l = var3;
      }

      public i() {
      }

      public static aqj.i a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
         aqe var7 = aqe.a(var2, var3, var4, -1, 0, 0, 5, 7, 5, var5);
         return a(var7) && aqt.a(var0, var7) == null ? new aqj.i(var6, var1, var7, var5) : null;
      }
   }

   public static class j extends aqj.m {
      private boolean b;

      protected void a(dn var1) {
         super.a(var1);
         var1.a("Chest", this.b);
      }

      protected void b(dn var1) {
         super.b(var1);
         this.b = var1.n("Chest");
      }

      public static aqj.j a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
         aqe var7 = aqe.a(var2, var3, var4, -1, 0, 0, 5, 7, 5, var5);
         return a(var7) && aqt.a(var0, var7) == null ? new aqj.j(var6, var1, var7, var5) : null;
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         this.c((aqj.q)var1, var2, var3, 0, 1, true);
      }

      public j() {
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         this.a(var1, var3, 0, 0, 0, 4, 1, 4, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 2, 0, 4, 5, 4, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 0, 2, 0, 0, 5, 4, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 3, 1, 0, 4, 1, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 0, 3, 3, 0, 4, 3, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 4, 2, 0, 4, 5, 0, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 1, 2, 4, 4, 5, 4, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 1, 3, 4, 1, 4, 4, afi.bz.Q(), afi.by.Q(), false);
         this.a(var1, var3, 3, 3, 4, 3, 4, 4, afi.bz.Q(), afi.by.Q(), false);
         if (this.b && var3.b((df)(new cj(this.a(1, 3), this.d(2), this.b(1, 3))))) {
            this.b = false;
            this.a(var1, var3, var2, 1, 2, 3, a, 2 + var2.nextInt(4));
         }

         this.a(var1, var3, 0, 6, 0, 4, 6, 4, afi.by.Q(), afi.by.Q(), false);

         for(int var4 = 0; var4 <= 4; ++var4) {
            for(int var5 = 0; var5 <= 4; ++var5) {
               this.b(var1, afi.by.Q(), var4, -1, var5, var3);
            }
         }

         return true;
      }

      public j(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.l = var3;
         this.b = var2.nextInt(3) == 0;
      }
   }

   public static class l extends aqj.m {
      private boolean b;

      public l() {
      }

      public static aqj.l a(List<aqt> var0, Random var1, int var2, int var3, int var4, int var5, cq var6) {
         aqe var7 = aqe.a(var2, var3, var4, -2, 0, 0, 7, 8, 9, var6);
         return a(var7) && aqt.a(var0, var7) == null ? new aqj.l(var5, var1, var7, var6) : null;
      }

      protected void b(dn var1) {
         super.b(var1);
         this.b = var1.n("Mob");
      }

      public l(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.l = var3;
      }

      protected void a(dn var1) {
         super.a(var1);
         var1.a("Mob", this.b);
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         this.a(var1, var3, 0, 2, 0, 6, 7, 7, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 1, 0, 0, 5, 1, 7, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 1, 2, 1, 5, 2, 7, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 1, 3, 2, 5, 3, 7, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 1, 4, 3, 5, 4, 7, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 1, 2, 0, 1, 4, 2, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 5, 2, 0, 5, 4, 2, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 1, 5, 2, 1, 5, 3, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 5, 5, 2, 5, 5, 3, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 5, 3, 0, 5, 8, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 6, 5, 3, 6, 5, 8, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 1, 5, 8, 5, 5, 8, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, afi.bz.Q(), 1, 6, 3, var3);
         this.a(var1, afi.bz.Q(), 5, 6, 3, var3);
         this.a(var1, var3, 0, 6, 3, 0, 6, 8, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 6, 6, 3, 6, 6, 8, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 1, 6, 8, 5, 7, 8, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 2, 8, 8, 4, 8, 8, afi.bz.Q(), afi.bz.Q(), false);
         if (!this.b) {
            cj var4 = new cj(this.a(3, 5), this.d(5), this.b(3, 5));
            if (var3.b((df)var4)) {
               this.b = true;
               var1.a((cj)var4, (alz)afi.ac.Q(), 2);
               akw var5 = var1.s(var4);
               if (var5 instanceof all) {
                  ((all)var5).b().a("Blaze");
               }
            }
         }

         for(int var6 = 0; var6 <= 6; ++var6) {
            for(int var7 = 0; var7 <= 6; ++var7) {
               this.b(var1, afi.by.Q(), var6, -1, var7, var3);
            }
         }

         return true;
      }
   }

   public static class c extends aqj.m {
      public c() {
      }

      public static aqj.c a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
         aqe var7 = aqe.a(var2, var3, var4, -1, -3, 0, 5, 10, 19, var5);
         return a(var7) && aqt.a(var0, var7) == null ? new aqj.c(var6, var1, var7, var5) : null;
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         this.a(var1, var3, 0, 3, 0, 4, 4, 18, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 1, 5, 0, 3, 7, 18, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 0, 5, 0, 0, 5, 18, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 4, 5, 0, 4, 5, 18, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 2, 0, 4, 2, 5, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 2, 13, 4, 2, 18, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 0, 0, 4, 1, 3, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 0, 15, 4, 1, 18, afi.by.Q(), afi.by.Q(), false);

         for(int var4 = 0; var4 <= 4; ++var4) {
            for(int var5 = 0; var5 <= 2; ++var5) {
               this.b(var1, afi.by.Q(), var4, -1, var5, var3);
               this.b(var1, afi.by.Q(), var4, -1, 18 - var5, var3);
            }
         }

         this.a(var1, var3, 0, 1, 1, 0, 4, 1, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 0, 3, 4, 0, 4, 4, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 0, 3, 14, 0, 4, 14, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 0, 1, 17, 0, 4, 17, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 4, 1, 1, 4, 4, 1, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 4, 3, 4, 4, 4, 4, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 4, 3, 14, 4, 4, 14, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 4, 1, 17, 4, 4, 17, afi.bz.Q(), afi.bz.Q(), false);
         return true;
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         this.a((aqj.q)var1, var2, var3, 1, 3, false);
      }

      public c(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.l = var3;
      }
   }

   public static class a extends aqj.m {
      public void a(aqt var1, List<aqt> var2, Random var3) {
         this.a((aqj.q)var1, var2, var3, 8, 3, false);
         this.b((aqj.q)var1, var2, var3, 3, 8, false);
         this.c((aqj.q)var1, var2, var3, 3, 8, false);
      }

      public a() {
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         this.a(var1, var3, 7, 3, 0, 11, 4, 18, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 3, 7, 18, 4, 11, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 8, 5, 0, 10, 7, 18, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 0, 5, 8, 18, 7, 10, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 7, 5, 0, 7, 5, 7, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 7, 5, 11, 7, 5, 18, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 11, 5, 0, 11, 5, 7, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 11, 5, 11, 11, 5, 18, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 5, 7, 7, 5, 7, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 11, 5, 7, 18, 5, 7, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 5, 11, 7, 5, 11, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 11, 5, 11, 18, 5, 11, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 7, 2, 0, 11, 2, 5, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 7, 2, 13, 11, 2, 18, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 7, 0, 0, 11, 1, 3, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 7, 0, 15, 11, 1, 18, afi.by.Q(), afi.by.Q(), false);

         int var4;
         int var5;
         for(var4 = 7; var4 <= 11; ++var4) {
            for(var5 = 0; var5 <= 2; ++var5) {
               this.b(var1, afi.by.Q(), var4, -1, var5, var3);
               this.b(var1, afi.by.Q(), var4, -1, 18 - var5, var3);
            }
         }

         this.a(var1, var3, 0, 2, 7, 5, 2, 11, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 13, 2, 7, 18, 2, 11, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 0, 7, 3, 1, 11, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 15, 0, 7, 18, 1, 11, afi.by.Q(), afi.by.Q(), false);

         for(var4 = 0; var4 <= 2; ++var4) {
            for(var5 = 7; var5 <= 11; ++var5) {
               this.b(var1, afi.by.Q(), var4, -1, var5, var3);
               this.b(var1, afi.by.Q(), 18 - var4, -1, var5, var3);
            }
         }

         return true;
      }

      protected a(Random var1, int var2, int var3) {
         super(0);
         this.m = cq.c.a.a(var1);
         switch(this.m) {
         case c:
         case d:
            this.l = new aqe(var2, 64, var3, var2 + 19 - 1, 73, var3 + 19 - 1);
            break;
         default:
            this.l = new aqe(var2, 64, var3, var2 + 19 - 1, 73, var3 + 19 - 1);
         }

      }

      public static aqj.a a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
         aqe var7 = aqe.a(var2, var3, var4, -8, -3, 0, 19, 10, 19, var5);
         return a(var7) && aqt.a(var0, var7) == null ? new aqj.a(var6, var1, var7, var5) : null;
      }

      public a(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.l = var3;
      }
   }

   static class n {
      public int d;
      public final int b;
      public Class<? extends aqj.m> a;
      public int c;
      public boolean e;

      public n(Class<? extends aqj.m> var1, int var2, int var3) {
         this(var1, var2, var3, false);
      }

      public n(Class<? extends aqj.m> var1, int var2, int var3, boolean var4) {
         this.a = var1;
         this.b = var2;
         this.d = var3;
         this.e = var4;
      }

      public boolean a() {
         return this.d == 0 || this.c < this.d;
      }

      public boolean a(int var1) {
         return this.d == 0 || this.c < this.d;
      }
   }

   public static class o extends aqj.m {
      public o() {
      }

      public o(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.l = var3;
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         this.a(var1, var3, 0, 0, 0, 6, 1, 6, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 2, 0, 6, 7, 6, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 0, 2, 0, 1, 6, 0, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 2, 6, 1, 6, 6, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 5, 2, 0, 6, 6, 0, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 5, 2, 6, 6, 6, 6, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 2, 0, 0, 6, 1, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 2, 5, 0, 6, 6, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 6, 2, 0, 6, 6, 1, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 6, 2, 5, 6, 6, 6, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 2, 6, 0, 4, 6, 0, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 2, 5, 0, 4, 5, 0, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 2, 6, 6, 4, 6, 6, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 2, 5, 6, 4, 5, 6, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 0, 6, 2, 0, 6, 4, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 5, 2, 0, 5, 4, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 6, 6, 2, 6, 6, 4, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 6, 5, 2, 6, 5, 4, afi.bz.Q(), afi.bz.Q(), false);

         for(int var4 = 0; var4 <= 6; ++var4) {
            for(int var5 = 0; var5 <= 6; ++var5) {
               this.b(var1, afi.by.Q(), var4, -1, var5, var3);
            }
         }

         return true;
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         this.a((aqj.q)var1, var2, var3, 2, 0, false);
         this.b((aqj.q)var1, var2, var3, 0, 2, false);
         this.c((aqj.q)var1, var2, var3, 0, 2, false);
      }

      public static aqj.o a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
         aqe var7 = aqe.a(var2, var3, var4, -2, 0, 0, 7, 9, 7, var5);
         return a(var7) && aqt.a(var0, var7) == null ? new aqj.o(var6, var1, var7, var5) : null;
      }
   }

   public static class k extends aqj.m {
      public k() {
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         this.a((aqj.q)var1, var2, var3, 5, 3, true);
         this.a((aqj.q)var1, var2, var3, 5, 11, true);
      }

      public static aqj.k a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
         aqe var7 = aqe.a(var2, var3, var4, -5, -3, 0, 13, 14, 13, var5);
         return a(var7) && aqt.a(var0, var7) == null ? new aqj.k(var6, var1, var7, var5) : null;
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         this.a(var1, var3, 0, 3, 0, 12, 4, 12, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 5, 0, 12, 13, 12, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 0, 5, 0, 1, 12, 12, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 11, 5, 0, 12, 12, 12, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 2, 5, 11, 4, 12, 12, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 8, 5, 11, 10, 12, 12, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 5, 9, 11, 7, 12, 12, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 2, 5, 0, 4, 12, 1, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 8, 5, 0, 10, 12, 1, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 5, 9, 0, 7, 12, 1, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 2, 11, 2, 10, 12, 10, afi.by.Q(), afi.by.Q(), false);

         int var4;
         for(var4 = 1; var4 <= 11; var4 += 2) {
            this.a(var1, var3, var4, 10, 0, var4, 11, 0, afi.bz.Q(), afi.bz.Q(), false);
            this.a(var1, var3, var4, 10, 12, var4, 11, 12, afi.bz.Q(), afi.bz.Q(), false);
            this.a(var1, var3, 0, 10, var4, 0, 11, var4, afi.bz.Q(), afi.bz.Q(), false);
            this.a(var1, var3, 12, 10, var4, 12, 11, var4, afi.bz.Q(), afi.bz.Q(), false);
            this.a(var1, afi.by.Q(), var4, 13, 0, var3);
            this.a(var1, afi.by.Q(), var4, 13, 12, var3);
            this.a(var1, afi.by.Q(), 0, 13, var4, var3);
            this.a(var1, afi.by.Q(), 12, 13, var4, var3);
            this.a(var1, afi.bz.Q(), var4 + 1, 13, 0, var3);
            this.a(var1, afi.bz.Q(), var4 + 1, 13, 12, var3);
            this.a(var1, afi.bz.Q(), 0, 13, var4 + 1, var3);
            this.a(var1, afi.bz.Q(), 12, 13, var4 + 1, var3);
         }

         this.a(var1, afi.bz.Q(), 0, 13, 0, var3);
         this.a(var1, afi.bz.Q(), 0, 13, 12, var3);
         this.a(var1, afi.bz.Q(), 0, 13, 0, var3);
         this.a(var1, afi.bz.Q(), 12, 13, 0, var3);

         for(var4 = 3; var4 <= 9; var4 += 2) {
            this.a(var1, var3, 1, 7, var4, 1, 8, var4, afi.bz.Q(), afi.bz.Q(), false);
            this.a(var1, var3, 11, 7, var4, 11, 8, var4, afi.bz.Q(), afi.bz.Q(), false);
         }

         var4 = this.a(afi.bA, 3);

         int var5;
         int var6;
         int var7;
         for(var5 = 0; var5 <= 6; ++var5) {
            var6 = var5 + 4;

            for(var7 = 5; var7 <= 7; ++var7) {
               this.a(var1, afi.bA.a(var4), var7, 5 + var5, var6, var3);
            }

            if (var6 >= 5 && var6 <= 8) {
               this.a(var1, var3, 5, 5, var6, 7, var5 + 4, var6, afi.by.Q(), afi.by.Q(), false);
            } else if (var6 >= 9 && var6 <= 10) {
               this.a(var1, var3, 5, 8, var6, 7, var5 + 4, var6, afi.by.Q(), afi.by.Q(), false);
            }

            if (var5 >= 1) {
               this.a(var1, var3, 5, 6 + var5, var6, 7, 9 + var5, var6, afi.a.Q(), afi.a.Q(), false);
            }
         }

         for(var5 = 5; var5 <= 7; ++var5) {
            this.a(var1, afi.bA.a(var4), var5, 12, 11, var3);
         }

         this.a(var1, var3, 5, 6, 7, 5, 7, 7, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 7, 6, 7, 7, 7, 7, afi.bz.Q(), afi.bz.Q(), false);
         this.a(var1, var3, 5, 13, 12, 7, 13, 12, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 2, 5, 2, 3, 5, 3, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 2, 5, 9, 3, 5, 10, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 2, 5, 4, 2, 5, 8, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 9, 5, 2, 10, 5, 3, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 9, 5, 9, 10, 5, 10, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 10, 5, 4, 10, 5, 8, afi.by.Q(), afi.by.Q(), false);
         var5 = this.a(afi.bA, 0);
         var6 = this.a(afi.bA, 1);
         this.a(var1, afi.bA.a(var6), 4, 5, 2, var3);
         this.a(var1, afi.bA.a(var6), 4, 5, 3, var3);
         this.a(var1, afi.bA.a(var6), 4, 5, 9, var3);
         this.a(var1, afi.bA.a(var6), 4, 5, 10, var3);
         this.a(var1, afi.bA.a(var5), 8, 5, 2, var3);
         this.a(var1, afi.bA.a(var5), 8, 5, 3, var3);
         this.a(var1, afi.bA.a(var5), 8, 5, 9, var3);
         this.a(var1, afi.bA.a(var5), 8, 5, 10, var3);
         this.a(var1, var3, 3, 4, 4, 4, 4, 8, afi.aW.Q(), afi.aW.Q(), false);
         this.a(var1, var3, 8, 4, 4, 9, 4, 8, afi.aW.Q(), afi.aW.Q(), false);
         this.a(var1, var3, 3, 5, 4, 4, 5, 8, afi.bB.Q(), afi.bB.Q(), false);
         this.a(var1, var3, 8, 5, 4, 9, 5, 8, afi.bB.Q(), afi.bB.Q(), false);
         this.a(var1, var3, 4, 2, 0, 8, 2, 12, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 2, 4, 12, 2, 8, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 4, 0, 0, 8, 1, 3, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 4, 0, 9, 8, 1, 12, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 0, 0, 4, 3, 1, 8, afi.by.Q(), afi.by.Q(), false);
         this.a(var1, var3, 9, 0, 4, 12, 1, 8, afi.by.Q(), afi.by.Q(), false);

         int var8;
         for(var7 = 4; var7 <= 8; ++var7) {
            for(var8 = 0; var8 <= 2; ++var8) {
               this.b(var1, afi.by.Q(), var7, -1, var8, var3);
               this.b(var1, afi.by.Q(), var7, -1, 12 - var8, var3);
            }
         }

         for(var7 = 0; var7 <= 2; ++var7) {
            for(var8 = 4; var8 <= 8; ++var8) {
               this.b(var1, afi.by.Q(), var7, -1, var8, var3);
               this.b(var1, afi.by.Q(), 12 - var7, -1, var8, var3);
            }
         }

         return true;
      }

      public k(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.l = var3;
      }
   }
}
