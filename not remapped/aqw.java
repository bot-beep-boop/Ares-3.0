import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class aqw {
   public static void a() {
      aqr.a(aqw.a.class, "ViBH");
      aqr.a(aqw.b.class, "ViDF");
      aqr.a(aqw.c.class, "ViF");
      aqr.a(aqw.d.class, "ViL");
      aqr.a(aqw.f.class, "ViPH");
      aqr.a(aqw.g.class, "ViSH");
      aqr.a(aqw.h.class, "ViSmH");
      aqr.a(aqw.i.class, "ViST");
      aqr.a(aqw.j.class, "ViS");
      aqr.a(aqw.k.class, "ViStart");
      aqr.a(aqw.l.class, "ViSR");
      aqr.a(aqw.m.class, "ViTRH");
      aqr.a(aqw.p.class, "ViW");
   }

   public static List<aqw.e> a(Random var0, int var1) {
      ArrayList var2 = Lists.newArrayList();
      var2.add(new aqw.e(aqw.g.class, 4, ns.a(var0, 2 + var1, 4 + var1 * 2)));
      var2.add(new aqw.e(aqw.i.class, 20, ns.a(var0, 0 + var1, 1 + var1)));
      var2.add(new aqw.e(aqw.a.class, 20, ns.a(var0, 0 + var1, 2 + var1)));
      var2.add(new aqw.e(aqw.h.class, 3, ns.a(var0, 2 + var1, 5 + var1 * 3)));
      var2.add(new aqw.e(aqw.f.class, 15, ns.a(var0, 0 + var1, 2 + var1)));
      var2.add(new aqw.e(aqw.b.class, 3, ns.a(var0, 1 + var1, 4 + var1)));
      var2.add(new aqw.e(aqw.c.class, 3, ns.a(var0, 2 + var1, 4 + var1 * 2)));
      var2.add(new aqw.e(aqw.j.class, 15, ns.a((Random)var0, 0, 1 + var1)));
      var2.add(new aqw.e(aqw.m.class, 8, ns.a(var0, 0 + var1, 3 + var1 * 2)));
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         if (((aqw.e)var3.next()).d == 0) {
            var3.remove();
         }
      }

      return var2;
   }

   private static aqt e(aqw.k var0, List<aqt> var1, Random var2, int var3, int var4, int var5, cq var6, int var7) {
      if (var7 > 3 + var0.c) {
         return null;
      } else if (Math.abs(var3 - var0.c().a) <= 112 && Math.abs(var5 - var0.c().c) <= 112) {
         aqe var8 = aqw.l.a(var0, var1, var2, var3, var4, var5, var6);
         if (var8 != null && var8.b > 10) {
            aqw.l var9 = new aqw.l(var0, var7, var2, var8, var6);
            int var10 = (var9.l.a + var9.l.d) / 2;
            int var11 = (var9.l.c + var9.l.f) / 2;
            int var12 = var9.l.d - var9.l.a;
            int var13 = var9.l.f - var9.l.c;
            int var14 = var12 > var13 ? var12 : var13;
            if (var0.e().a(var10, var11, var14 / 2 + 4, aqv.d)) {
               var1.add(var9);
               var0.g.add(var9);
               return var9;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private static aqt d(aqw.k var0, List<aqt> var1, Random var2, int var3, int var4, int var5, cq var6, int var7) {
      if (var7 > 50) {
         return null;
      } else if (Math.abs(var3 - var0.c().a) <= 112 && Math.abs(var5 - var0.c().c) <= 112) {
         aqw.n var8 = c(var0, var1, var2, var3, var4, var5, var6, var7 + 1);
         if (var8 != null) {
            int var9 = (var8.l.a + var8.l.d) / 2;
            int var10 = (var8.l.c + var8.l.f) / 2;
            int var11 = var8.l.d - var8.l.a;
            int var12 = var8.l.f - var8.l.c;
            int var13 = var11 > var12 ? var11 : var12;
            if (var0.e().a(var9, var10, var13 / 2 + 4, aqv.d)) {
               var1.add(var8);
               var0.f.add(var8);
               return var8;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private static aqw.n c(aqw.k var0, List<aqt> var1, Random var2, int var3, int var4, int var5, cq var6, int var7) {
      int var8 = a(var0.e);
      if (var8 <= 0) {
         return null;
      } else {
         int var9 = 0;

         while(var9 < 5) {
            ++var9;
            int var10 = var2.nextInt(var8);
            Iterator var11 = var0.e.iterator();

            while(var11.hasNext()) {
               aqw.e var12 = (aqw.e)var11.next();
               var10 -= var12.b;
               if (var10 < 0) {
                  if (!var12.a(var7) || var12 == var0.d && var0.e.size() > 1) {
                     break;
                  }

                  aqw.n var13 = a(var0, var12, var1, var2, var3, var4, var5, var6, var7);
                  if (var13 != null) {
                     ++var12.c;
                     var0.d = var12;
                     if (!var12.a()) {
                        var0.e.remove(var12);
                     }

                     return var13;
                  }
               }
            }
         }

         aqe var14 = aqw.d.a(var0, var1, var2, var3, var4, var5, var6);
         if (var14 != null) {
            return new aqw.d(var0, var7, var2, var14, var6);
         } else {
            return null;
         }
      }
   }

   private static int a(List<aqw.e> var0) {
      boolean var1 = false;
      int var2 = 0;

      aqw.e var4;
      for(Iterator var3 = var0.iterator(); var3.hasNext(); var2 += var4.b) {
         var4 = (aqw.e)var3.next();
         if (var4.d > 0 && var4.c < var4.d) {
            var1 = true;
         }
      }

      return var1 ? var2 : -1;
   }

   static aqt b(aqw.k var0, List var1, Random var2, int var3, int var4, int var5, cq var6, int var7) {
      return e(var0, var1, var2, var3, var4, var5, var6, var7);
   }

   static aqt a(aqw.k var0, List var1, Random var2, int var3, int var4, int var5, cq var6, int var7) {
      return d(var0, var1, var2, var3, var4, var5, var6, var7);
   }

   private static aqw.n a(aqw.k var0, aqw.e var1, List<aqt> var2, Random var3, int var4, int var5, int var6, cq var7, int var8) {
      Class var9 = var1.a;
      Object var10 = null;
      if (var9 == aqw.g.class) {
         var10 = aqw.g.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if (var9 == aqw.i.class) {
         var10 = aqw.i.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if (var9 == aqw.a.class) {
         var10 = aqw.a.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if (var9 == aqw.h.class) {
         var10 = aqw.h.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if (var9 == aqw.f.class) {
         var10 = aqw.f.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if (var9 == aqw.b.class) {
         var10 = aqw.b.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if (var9 == aqw.c.class) {
         var10 = aqw.c.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if (var9 == aqw.j.class) {
         var10 = aqw.j.a(var0, var2, var3, var4, var5, var6, var7, var8);
      } else if (var9 == aqw.m.class) {
         var10 = aqw.m.a(var0, var2, var3, var4, var5, var6, var7, var8);
      }

      return (aqw.n)var10;
   }

   public static class d extends aqw.n {
      public d(aqw.k var1, int var2, Random var3, aqe var4, cq var5) {
         super(var1, var2);
         this.m = var5;
         this.l = var4;
      }

      public d() {
      }

      public static aqe a(aqw.k var0, List<aqt> var1, Random var2, int var3, int var4, int var5, cq var6) {
         aqe var7 = aqe.a(var3, var4, var5, 0, 0, 0, 3, 4, 2, var6);
         return aqt.a(var1, var7) != null ? null : var7;
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.h < 0) {
            this.h = this.b(var1, var3);
            if (this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.e + 4 - 1, 0);
         }

         this.a(var1, var3, 0, 0, 0, 2, 3, 1, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, afi.aO.Q(), 1, 0, 0, var3);
         this.a(var1, afi.aO.Q(), 1, 1, 0, var3);
         this.a(var1, afi.aO.Q(), 1, 2, 0, var3);
         this.a(var1, afi.L.a(zd.a.b()), 1, 3, 0, var3);
         boolean var4 = this.m == cq.f || this.m == cq.c;
         this.a(var1, afi.aa.Q().a(akf.a, this.m.e()), var4 ? 2 : 0, 3, 0, var3);
         this.a(var1, afi.aa.Q().a(akf.a, this.m), 1, 3, 1, var3);
         this.a(var1, afi.aa.Q().a(akf.a, this.m.f()), var4 ? 0 : 2, 3, 0, var3);
         this.a(var1, afi.aa.Q().a(akf.a, this.m.d()), 1, 3, -1, var3);
         return true;
      }
   }

   public static class c extends aqw.n {
      private afh a;
      private afh b;

      public c() {
      }

      public c(aqw.k var1, int var2, Random var3, aqe var4, cq var5) {
         super(var1, var2);
         this.m = var5;
         this.l = var4;
         this.a = this.a(var3);
         this.b = this.a(var3);
      }

      protected void b(dn var1) {
         super.b(var1);
         this.a = afh.c(var1.f("CA"));
         this.b = afh.c(var1.f("CB"));
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.h < 0) {
            this.h = this.b(var1, var3);
            if (this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.e + 4 - 1, 0);
         }

         this.a(var1, var3, 0, 1, 0, 6, 4, 8, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 1, 0, 1, 2, 0, 7, afi.ak.Q(), afi.ak.Q(), false);
         this.a(var1, var3, 4, 0, 1, 5, 0, 7, afi.ak.Q(), afi.ak.Q(), false);
         this.a(var1, var3, 0, 0, 0, 0, 0, 8, afi.r.Q(), afi.r.Q(), false);
         this.a(var1, var3, 6, 0, 0, 6, 0, 8, afi.r.Q(), afi.r.Q(), false);
         this.a(var1, var3, 1, 0, 0, 5, 0, 0, afi.r.Q(), afi.r.Q(), false);
         this.a(var1, var3, 1, 0, 8, 5, 0, 8, afi.r.Q(), afi.r.Q(), false);
         this.a(var1, var3, 3, 0, 1, 3, 0, 7, afi.j.Q(), afi.j.Q(), false);

         int var4;
         for(var4 = 1; var4 <= 7; ++var4) {
            this.a(var1, this.a.a(ns.a((Random)var2, 2, 7)), 1, 1, var4, var3);
            this.a(var1, this.a.a(ns.a((Random)var2, 2, 7)), 2, 1, var4, var3);
            this.a(var1, this.b.a(ns.a((Random)var2, 2, 7)), 4, 1, var4, var3);
            this.a(var1, this.b.a(ns.a((Random)var2, 2, 7)), 5, 1, var4, var3);
         }

         for(var4 = 0; var4 < 9; ++var4) {
            for(int var5 = 0; var5 < 7; ++var5) {
               this.b(var1, var5, 4, var4, var3);
               this.b(var1, afi.d.Q(), var5, -1, var4, var3);
            }
         }

         return true;
      }

      public static aqw.c a(aqw.k var0, List<aqt> var1, Random var2, int var3, int var4, int var5, cq var6, int var7) {
         aqe var8 = aqe.a(var3, var4, var5, 0, 0, 0, 7, 4, 9, var6);
         return a((aqe)var8) && aqt.a(var1, var8) == null ? new aqw.c(var0, var7, var2, var8, var6) : null;
      }

      protected void a(dn var1) {
         super.a(var1);
         var1.a("CA", afh.c.b(this.a));
         var1.a("CB", afh.c.b(this.b));
      }

      private afh a(Random var1) {
         switch(var1.nextInt(5)) {
         case 0:
            return afi.cb;
         case 1:
            return afi.cc;
         default:
            return afi.aj;
         }
      }
   }

   public static class j extends aqw.n {
      private static final List<ob> a;
      private boolean b;

      public static aqw.j a(aqw.k var0, List<aqt> var1, Random var2, int var3, int var4, int var5, cq var6, int var7) {
         aqe var8 = aqe.a(var3, var4, var5, 0, 0, 0, 10, 6, 7, var6);
         return a(var8) && aqt.a(var1, var8) == null ? new aqw.j(var0, var7, var2, var8, var6) : null;
      }

      static {
         a = Lists.newArrayList(new ob[]{new ob(zy.i, 0, 1, 3, 3), new ob(zy.j, 0, 1, 5, 10), new ob(zy.k, 0, 1, 3, 5), new ob(zy.P, 0, 1, 3, 15), new ob(zy.e, 0, 1, 3, 15), new ob(zy.b, 0, 1, 1, 5), new ob(zy.l, 0, 1, 1, 5), new ob(zy.Z, 0, 1, 1, 5), new ob(zy.Y, 0, 1, 1, 5), new ob(zy.aa, 0, 1, 1, 5), new ob(zy.ab, 0, 1, 1, 5), new ob(zw.a(afi.Z), 0, 3, 7, 5), new ob(zw.a(afi.g), 0, 3, 7, 5), new ob(zy.aA, 0, 1, 1, 3), new ob(zy.ck, 0, 1, 1, 1), new ob(zy.cl, 0, 1, 1, 1), new ob(zy.cm, 0, 1, 1, 1)});
      }

      protected void b(dn var1) {
         super.b(var1);
         this.b = var1.n("Chest");
      }

      protected int c(int var1, int var2) {
         return 3;
      }

      public j(aqw.k var1, int var2, Random var3, aqe var4, cq var5) {
         super(var1, var2);
         this.m = var5;
         this.l = var4;
      }

      protected void a(dn var1) {
         super.a(var1);
         var1.a("Chest", this.b);
      }

      public j() {
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.h < 0) {
            this.h = this.b(var1, var3);
            if (this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.e + 6 - 1, 0);
         }

         this.a(var1, var3, 0, 1, 0, 9, 4, 6, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 0, 0, 0, 9, 0, 6, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 0, 4, 0, 9, 4, 6, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 0, 5, 0, 9, 5, 6, afi.U.Q(), afi.U.Q(), false);
         this.a(var1, var3, 1, 5, 1, 8, 5, 5, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 1, 1, 0, 2, 3, 0, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 0, 1, 0, 0, 4, 0, afi.r.Q(), afi.r.Q(), false);
         this.a(var1, var3, 3, 1, 0, 3, 4, 0, afi.r.Q(), afi.r.Q(), false);
         this.a(var1, var3, 0, 1, 6, 0, 4, 6, afi.r.Q(), afi.r.Q(), false);
         this.a(var1, afi.f.Q(), 3, 3, 1, var3);
         this.a(var1, var3, 3, 1, 2, 3, 3, 2, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 4, 1, 3, 5, 3, 3, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 0, 1, 1, 0, 3, 5, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 1, 1, 6, 5, 3, 6, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 5, 1, 0, 5, 3, 0, afi.aO.Q(), afi.aO.Q(), false);
         this.a(var1, var3, 9, 1, 0, 9, 3, 0, afi.aO.Q(), afi.aO.Q(), false);
         this.a(var1, var3, 6, 1, 4, 9, 4, 6, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, afi.k.Q(), 7, 1, 5, var3);
         this.a(var1, afi.k.Q(), 8, 1, 5, var3);
         this.a(var1, afi.bi.Q(), 9, 2, 5, var3);
         this.a(var1, afi.bi.Q(), 9, 2, 4, var3);
         this.a(var1, var3, 7, 2, 4, 8, 2, 5, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, afi.e.Q(), 6, 1, 3, var3);
         this.a(var1, afi.al.Q(), 6, 2, 3, var3);
         this.a(var1, afi.al.Q(), 6, 3, 3, var3);
         this.a(var1, afi.T.Q(), 8, 1, 1, var3);
         this.a(var1, afi.bj.Q(), 0, 2, 2, var3);
         this.a(var1, afi.bj.Q(), 0, 2, 4, var3);
         this.a(var1, afi.bj.Q(), 2, 2, 6, var3);
         this.a(var1, afi.bj.Q(), 4, 2, 6, var3);
         this.a(var1, afi.aO.Q(), 2, 1, 4, var3);
         this.a(var1, afi.aB.Q(), 2, 2, 4, var3);
         this.a(var1, afi.f.Q(), 1, 1, 5, var3);
         this.a(var1, afi.ad.a(this.a(afi.ad, 3)), 2, 1, 5, var3);
         this.a(var1, afi.ad.a(this.a(afi.ad, 1)), 1, 1, 4, var3);
         if (!this.b && var3.b((df)(new cj(this.a(5, 5), this.d(1), this.b(5, 5))))) {
            this.b = true;
            this.a(var1, var3, var2, 5, 1, 5, a, 3 + var2.nextInt(6));
         }

         int var4;
         for(var4 = 6; var4 <= 8; ++var4) {
            if (this.a(var1, var4, 0, -1, var3).c().t() == arm.a && this.a(var1, var4, -1, -1, var3).c().t() != arm.a) {
               this.a(var1, afi.aw.a(this.a(afi.aw, 3)), var4, 0, -1, var3);
            }
         }

         for(var4 = 0; var4 < 7; ++var4) {
            for(int var5 = 0; var5 < 10; ++var5) {
               this.b(var1, var5, 6, var4, var3);
               this.b(var1, afi.e.Q(), var5, -1, var4, var3);
            }
         }

         this.a(var1, var3, 7, 1, 1, 1);
         return true;
      }
   }

   public abstract static class o extends aqw.n {
      public o() {
      }

      protected o(aqw.k var1, int var2) {
         super(var1, var2);
      }
   }

   public static class f extends aqw.n {
      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.h < 0) {
            this.h = this.b(var1, var3);
            if (this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.e + 7 - 1, 0);
         }

         this.a(var1, var3, 1, 1, 1, 7, 4, 4, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 2, 1, 6, 8, 4, 10, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 2, 0, 6, 8, 0, 10, afi.d.Q(), afi.d.Q(), false);
         this.a(var1, afi.e.Q(), 6, 0, 6, var3);
         this.a(var1, var3, 2, 1, 6, 2, 1, 10, afi.aO.Q(), afi.aO.Q(), false);
         this.a(var1, var3, 8, 1, 6, 8, 1, 10, afi.aO.Q(), afi.aO.Q(), false);
         this.a(var1, var3, 3, 1, 10, 7, 1, 10, afi.aO.Q(), afi.aO.Q(), false);
         this.a(var1, var3, 1, 0, 1, 7, 0, 4, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 0, 0, 0, 0, 3, 5, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 8, 0, 0, 8, 3, 5, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 1, 0, 0, 7, 1, 0, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 1, 0, 5, 7, 1, 5, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 1, 2, 0, 7, 3, 0, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 1, 2, 5, 7, 3, 5, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 0, 4, 1, 8, 4, 1, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 0, 4, 4, 8, 4, 4, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 0, 5, 2, 8, 5, 3, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, afi.f.Q(), 0, 4, 2, var3);
         this.a(var1, afi.f.Q(), 0, 4, 3, var3);
         this.a(var1, afi.f.Q(), 8, 4, 2, var3);
         this.a(var1, afi.f.Q(), 8, 4, 3, var3);
         int var4 = this.a(afi.ad, 3);
         int var5 = this.a(afi.ad, 2);

         int var6;
         int var7;
         for(var6 = -1; var6 <= 2; ++var6) {
            for(var7 = 0; var7 <= 8; ++var7) {
               this.a(var1, afi.ad.a(var4), var7, 4 + var6, var6, var3);
               this.a(var1, afi.ad.a(var5), var7, 4 + var6, 5 - var6, var3);
            }
         }

         this.a(var1, afi.r.Q(), 0, 2, 1, var3);
         this.a(var1, afi.r.Q(), 0, 2, 4, var3);
         this.a(var1, afi.r.Q(), 8, 2, 1, var3);
         this.a(var1, afi.r.Q(), 8, 2, 4, var3);
         this.a(var1, afi.bj.Q(), 0, 2, 2, var3);
         this.a(var1, afi.bj.Q(), 0, 2, 3, var3);
         this.a(var1, afi.bj.Q(), 8, 2, 2, var3);
         this.a(var1, afi.bj.Q(), 8, 2, 3, var3);
         this.a(var1, afi.bj.Q(), 2, 2, 5, var3);
         this.a(var1, afi.bj.Q(), 3, 2, 5, var3);
         this.a(var1, afi.bj.Q(), 5, 2, 0, var3);
         this.a(var1, afi.bj.Q(), 6, 2, 5, var3);
         this.a(var1, afi.aO.Q(), 2, 1, 3, var3);
         this.a(var1, afi.aB.Q(), 2, 2, 3, var3);
         this.a(var1, afi.f.Q(), 1, 1, 4, var3);
         this.a(var1, afi.ad.a(this.a(afi.ad, 3)), 2, 1, 4, var3);
         this.a(var1, afi.ad.a(this.a(afi.ad, 1)), 1, 1, 3, var3);
         this.a(var1, var3, 5, 0, 1, 7, 0, 3, afi.T.Q(), afi.T.Q(), false);
         this.a(var1, afi.T.Q(), 6, 1, 1, var3);
         this.a(var1, afi.T.Q(), 6, 1, 2, var3);
         this.a(var1, afi.a.Q(), 2, 1, 0, var3);
         this.a(var1, afi.a.Q(), 2, 2, 0, var3);
         this.a(var1, afi.aa.Q().a(akf.a, this.m), 2, 3, 1, var3);
         this.a(var1, var3, var2, 2, 1, 0, cq.b(this.a(afi.ao, 1)));
         if (this.a(var1, 2, 0, -1, var3).c().t() == arm.a && this.a(var1, 2, -1, -1, var3).c().t() != arm.a) {
            this.a(var1, afi.aw.a(this.a(afi.aw, 3)), 2, 0, -1, var3);
         }

         this.a(var1, afi.a.Q(), 6, 1, 5, var3);
         this.a(var1, afi.a.Q(), 6, 2, 5, var3);
         this.a(var1, afi.aa.Q().a(akf.a, this.m.d()), 6, 3, 4, var3);
         this.a(var1, var3, var2, 6, 1, 5, cq.b(this.a(afi.ao, 1)));

         for(var6 = 0; var6 < 5; ++var6) {
            for(var7 = 0; var7 < 9; ++var7) {
               this.b(var1, var7, 7, var6, var3);
               this.b(var1, afi.e.Q(), var7, -1, var6, var3);
            }
         }

         this.a(var1, var3, 4, 1, 2, 2);
         return true;
      }

      protected int c(int var1, int var2) {
         return var1 == 0 ? 4 : super.c(var1, var2);
      }

      public static aqw.f a(aqw.k var0, List<aqt> var1, Random var2, int var3, int var4, int var5, cq var6, int var7) {
         aqe var8 = aqe.a(var3, var4, var5, 0, 0, 0, 9, 7, 11, var6);
         return a(var8) && aqt.a(var1, var8) == null ? new aqw.f(var0, var7, var2, var8, var6) : null;
      }

      public f() {
      }

      public f(aqw.k var1, int var2, Random var3, aqe var4, cq var5) {
         super(var1, var2);
         this.m = var5;
         this.l = var4;
      }
   }

   public static class i extends aqw.n {
      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.h < 0) {
            this.h = this.b(var1, var3);
            if (this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.e + 12 - 1, 0);
         }

         this.a(var1, var3, 1, 1, 1, 3, 3, 7, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 1, 5, 1, 3, 9, 3, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 1, 0, 0, 3, 0, 8, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 1, 1, 0, 3, 10, 0, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 0, 1, 1, 0, 10, 3, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 4, 1, 1, 4, 10, 3, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 0, 0, 4, 0, 4, 7, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 4, 0, 4, 4, 4, 7, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 1, 1, 8, 3, 4, 8, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 1, 5, 4, 3, 10, 4, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 1, 5, 5, 3, 5, 7, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 0, 9, 0, 4, 9, 4, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 0, 4, 0, 4, 4, 4, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, afi.e.Q(), 0, 11, 2, var3);
         this.a(var1, afi.e.Q(), 4, 11, 2, var3);
         this.a(var1, afi.e.Q(), 2, 11, 0, var3);
         this.a(var1, afi.e.Q(), 2, 11, 4, var3);
         this.a(var1, afi.e.Q(), 1, 1, 6, var3);
         this.a(var1, afi.e.Q(), 1, 1, 7, var3);
         this.a(var1, afi.e.Q(), 2, 1, 7, var3);
         this.a(var1, afi.e.Q(), 3, 1, 6, var3);
         this.a(var1, afi.e.Q(), 3, 1, 7, var3);
         this.a(var1, afi.aw.a(this.a(afi.aw, 3)), 1, 1, 5, var3);
         this.a(var1, afi.aw.a(this.a(afi.aw, 3)), 2, 1, 6, var3);
         this.a(var1, afi.aw.a(this.a(afi.aw, 3)), 3, 1, 5, var3);
         this.a(var1, afi.aw.a(this.a(afi.aw, 1)), 1, 2, 7, var3);
         this.a(var1, afi.aw.a(this.a(afi.aw, 0)), 3, 2, 7, var3);
         this.a(var1, afi.bj.Q(), 0, 2, 2, var3);
         this.a(var1, afi.bj.Q(), 0, 3, 2, var3);
         this.a(var1, afi.bj.Q(), 4, 2, 2, var3);
         this.a(var1, afi.bj.Q(), 4, 3, 2, var3);
         this.a(var1, afi.bj.Q(), 0, 6, 2, var3);
         this.a(var1, afi.bj.Q(), 0, 7, 2, var3);
         this.a(var1, afi.bj.Q(), 4, 6, 2, var3);
         this.a(var1, afi.bj.Q(), 4, 7, 2, var3);
         this.a(var1, afi.bj.Q(), 2, 6, 0, var3);
         this.a(var1, afi.bj.Q(), 2, 7, 0, var3);
         this.a(var1, afi.bj.Q(), 2, 6, 4, var3);
         this.a(var1, afi.bj.Q(), 2, 7, 4, var3);
         this.a(var1, afi.bj.Q(), 0, 3, 6, var3);
         this.a(var1, afi.bj.Q(), 4, 3, 6, var3);
         this.a(var1, afi.bj.Q(), 2, 3, 8, var3);
         this.a(var1, afi.aa.Q().a(akf.a, this.m.d()), 2, 4, 7, var3);
         this.a(var1, afi.aa.Q().a(akf.a, this.m.e()), 1, 4, 6, var3);
         this.a(var1, afi.aa.Q().a(akf.a, this.m.f()), 3, 4, 6, var3);
         this.a(var1, afi.aa.Q().a(akf.a, this.m), 2, 4, 5, var3);
         int var4 = this.a(afi.au, 4);

         int var5;
         for(var5 = 1; var5 <= 9; ++var5) {
            this.a(var1, afi.au.a(var4), 3, var5, 3, var3);
         }

         this.a(var1, afi.a.Q(), 2, 1, 0, var3);
         this.a(var1, afi.a.Q(), 2, 2, 0, var3);
         this.a(var1, var3, var2, 2, 1, 0, cq.b(this.a(afi.ao, 1)));
         if (this.a(var1, 2, 0, -1, var3).c().t() == arm.a && this.a(var1, 2, -1, -1, var3).c().t() != arm.a) {
            this.a(var1, afi.aw.a(this.a(afi.aw, 3)), 2, 0, -1, var3);
         }

         for(var5 = 0; var5 < 9; ++var5) {
            for(int var6 = 0; var6 < 5; ++var6) {
               this.b(var1, var6, 12, var5, var3);
               this.b(var1, afi.e.Q(), var6, -1, var5, var3);
            }
         }

         this.a(var1, var3, 2, 1, 2, 1);
         return true;
      }

      protected int c(int var1, int var2) {
         return 2;
      }

      public i() {
      }

      public i(aqw.k var1, int var2, Random var3, aqe var4, cq var5) {
         super(var1, var2);
         this.m = var5;
         this.l = var4;
      }

      public static aqw.i a(aqw.k var0, List<aqt> var1, Random var2, int var3, int var4, int var5, cq var6, int var7) {
         aqe var8 = aqe.a(var3, var4, var5, 0, 0, 0, 5, 12, 9, var6);
         return a(var8) && aqt.a(var1, var8) == null ? new aqw.i(var0, var7, var2, var8, var6) : null;
      }
   }

   public static class p extends aqw.n {
      public p(aqw.k var1, int var2, Random var3, int var4, int var5) {
         super(var1, var2);
         this.m = cq.c.a.a(var3);
         switch(this.m) {
         case c:
         case d:
            this.l = new aqe(var4, 64, var5, var4 + 6 - 1, 78, var5 + 6 - 1);
            break;
         default:
            this.l = new aqe(var4, 64, var5, var4 + 6 - 1, 78, var5 + 6 - 1);
         }

      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         aqw.b((aqw.k)var1, var2, var3, this.l.a - 1, this.l.e - 4, this.l.c + 1, cq.e, this.d());
         aqw.b((aqw.k)var1, var2, var3, this.l.d + 1, this.l.e - 4, this.l.c + 1, cq.f, this.d());
         aqw.b((aqw.k)var1, var2, var3, this.l.a + 1, this.l.e - 4, this.l.c - 1, cq.c, this.d());
         aqw.b((aqw.k)var1, var2, var3, this.l.a + 1, this.l.e - 4, this.l.f + 1, cq.d, this.d());
      }

      public p() {
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.h < 0) {
            this.h = this.b(var1, var3);
            if (this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.e + 3, 0);
         }

         this.a(var1, var3, 1, 0, 1, 4, 12, 4, afi.e.Q(), afi.i.Q(), false);
         this.a(var1, afi.a.Q(), 2, 12, 2, var3);
         this.a(var1, afi.a.Q(), 3, 12, 2, var3);
         this.a(var1, afi.a.Q(), 2, 12, 3, var3);
         this.a(var1, afi.a.Q(), 3, 12, 3, var3);
         this.a(var1, afi.aO.Q(), 1, 13, 1, var3);
         this.a(var1, afi.aO.Q(), 1, 14, 1, var3);
         this.a(var1, afi.aO.Q(), 4, 13, 1, var3);
         this.a(var1, afi.aO.Q(), 4, 14, 1, var3);
         this.a(var1, afi.aO.Q(), 1, 13, 4, var3);
         this.a(var1, afi.aO.Q(), 1, 14, 4, var3);
         this.a(var1, afi.aO.Q(), 4, 13, 4, var3);
         this.a(var1, afi.aO.Q(), 4, 14, 4, var3);
         this.a(var1, var3, 1, 15, 1, 4, 15, 4, afi.e.Q(), afi.e.Q(), false);

         for(int var4 = 0; var4 <= 5; ++var4) {
            for(int var5 = 0; var5 <= 5; ++var5) {
               if (var5 == 0 || var5 == 5 || var4 == 0 || var4 == 5) {
                  this.a(var1, afi.n.Q(), var5, 11, var4, var3);
                  this.b(var1, var5, 12, var4, var3);
               }
            }
         }

         return true;
      }
   }

   public static class k extends aqw.p {
      public List<aqt> g = Lists.newArrayList();
      public aqw.e d;
      public boolean b;
      public List<aqw.e> e;
      public aec a;
      public int c;
      public List<aqt> f = Lists.newArrayList();

      public aec e() {
         return this.a;
      }

      public k() {
      }

      public k(aec var1, int var2, Random var3, int var4, int var5, List<aqw.e> var6, int var7) {
         super((aqw.k)null, 0, var3, var4, var5);
         this.a = var1;
         this.e = var6;
         this.c = var7;
         ady var8 = var1.a(new cj(var4, 0, var5), ady.ad);
         this.b = var8 == ady.r || var8 == ady.G;
         this.a(this.b);
      }
   }

   public static class m extends aqw.n {
      public m() {
      }

      public m(aqw.k var1, int var2, Random var3, aqe var4, cq var5) {
         super(var1, var2);
         this.m = var5;
         this.l = var4;
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.h < 0) {
            this.h = this.b(var1, var3);
            if (this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.e + 7 - 1, 0);
         }

         this.a(var1, var3, 1, 1, 1, 7, 4, 4, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 2, 1, 6, 8, 4, 10, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 2, 0, 5, 8, 0, 10, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 1, 0, 1, 7, 0, 4, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 0, 0, 0, 0, 3, 5, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 8, 0, 0, 8, 3, 10, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 1, 0, 0, 7, 2, 0, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 1, 0, 5, 2, 1, 5, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 2, 0, 6, 2, 3, 10, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 3, 0, 10, 7, 3, 10, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 1, 2, 0, 7, 3, 0, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 1, 2, 5, 2, 3, 5, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 0, 4, 1, 8, 4, 1, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 0, 4, 4, 3, 4, 4, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 0, 5, 2, 8, 5, 3, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, afi.f.Q(), 0, 4, 2, var3);
         this.a(var1, afi.f.Q(), 0, 4, 3, var3);
         this.a(var1, afi.f.Q(), 8, 4, 2, var3);
         this.a(var1, afi.f.Q(), 8, 4, 3, var3);
         this.a(var1, afi.f.Q(), 8, 4, 4, var3);
         int var4 = this.a(afi.ad, 3);
         int var5 = this.a(afi.ad, 2);

         int var6;
         int var7;
         for(var6 = -1; var6 <= 2; ++var6) {
            for(var7 = 0; var7 <= 8; ++var7) {
               this.a(var1, afi.ad.a(var4), var7, 4 + var6, var6, var3);
               if ((var6 > -1 || var7 <= 1) && (var6 > 0 || var7 <= 3) && (var6 > 1 || var7 <= 4 || var7 >= 6)) {
                  this.a(var1, afi.ad.a(var5), var7, 4 + var6, 5 - var6, var3);
               }
            }
         }

         this.a(var1, var3, 3, 4, 5, 3, 4, 10, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 7, 4, 2, 7, 4, 10, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 4, 5, 4, 4, 5, 10, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 6, 5, 4, 6, 5, 10, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 5, 6, 3, 5, 6, 10, afi.f.Q(), afi.f.Q(), false);
         var6 = this.a(afi.ad, 0);

         int var8;
         for(var7 = 4; var7 >= 1; --var7) {
            this.a(var1, afi.f.Q(), var7, 2 + var7, 7 - var7, var3);

            for(var8 = 8 - var7; var8 <= 10; ++var8) {
               this.a(var1, afi.ad.a(var6), var7, 2 + var7, var8, var3);
            }
         }

         var7 = this.a(afi.ad, 1);
         this.a(var1, afi.f.Q(), 6, 6, 3, var3);
         this.a(var1, afi.f.Q(), 7, 5, 4, var3);
         this.a(var1, afi.ad.a(var7), 6, 6, 4, var3);

         int var9;
         for(var8 = 6; var8 <= 8; ++var8) {
            for(var9 = 5; var9 <= 10; ++var9) {
               this.a(var1, afi.ad.a(var7), var8, 12 - var8, var9, var3);
            }
         }

         this.a(var1, afi.r.Q(), 0, 2, 1, var3);
         this.a(var1, afi.r.Q(), 0, 2, 4, var3);
         this.a(var1, afi.bj.Q(), 0, 2, 2, var3);
         this.a(var1, afi.bj.Q(), 0, 2, 3, var3);
         this.a(var1, afi.r.Q(), 4, 2, 0, var3);
         this.a(var1, afi.bj.Q(), 5, 2, 0, var3);
         this.a(var1, afi.r.Q(), 6, 2, 0, var3);
         this.a(var1, afi.r.Q(), 8, 2, 1, var3);
         this.a(var1, afi.bj.Q(), 8, 2, 2, var3);
         this.a(var1, afi.bj.Q(), 8, 2, 3, var3);
         this.a(var1, afi.r.Q(), 8, 2, 4, var3);
         this.a(var1, afi.f.Q(), 8, 2, 5, var3);
         this.a(var1, afi.r.Q(), 8, 2, 6, var3);
         this.a(var1, afi.bj.Q(), 8, 2, 7, var3);
         this.a(var1, afi.bj.Q(), 8, 2, 8, var3);
         this.a(var1, afi.r.Q(), 8, 2, 9, var3);
         this.a(var1, afi.r.Q(), 2, 2, 6, var3);
         this.a(var1, afi.bj.Q(), 2, 2, 7, var3);
         this.a(var1, afi.bj.Q(), 2, 2, 8, var3);
         this.a(var1, afi.r.Q(), 2, 2, 9, var3);
         this.a(var1, afi.r.Q(), 4, 4, 10, var3);
         this.a(var1, afi.bj.Q(), 5, 4, 10, var3);
         this.a(var1, afi.r.Q(), 6, 4, 10, var3);
         this.a(var1, afi.f.Q(), 5, 5, 10, var3);
         this.a(var1, afi.a.Q(), 2, 1, 0, var3);
         this.a(var1, afi.a.Q(), 2, 2, 0, var3);
         this.a(var1, afi.aa.Q().a(akf.a, this.m), 2, 3, 1, var3);
         this.a(var1, var3, var2, 2, 1, 0, cq.b(this.a(afi.ao, 1)));
         this.a(var1, var3, 1, 0, -1, 3, 2, -1, afi.a.Q(), afi.a.Q(), false);
         if (this.a(var1, 2, 0, -1, var3).c().t() == arm.a && this.a(var1, 2, -1, -1, var3).c().t() != arm.a) {
            this.a(var1, afi.aw.a(this.a(afi.aw, 3)), 2, 0, -1, var3);
         }

         for(var8 = 0; var8 < 5; ++var8) {
            for(var9 = 0; var9 < 9; ++var9) {
               this.b(var1, var9, 7, var8, var3);
               this.b(var1, afi.e.Q(), var9, -1, var8, var3);
            }
         }

         for(var8 = 5; var8 < 11; ++var8) {
            for(var9 = 2; var9 < 9; ++var9) {
               this.b(var1, var9, 7, var8, var3);
               this.b(var1, afi.e.Q(), var9, -1, var8, var3);
            }
         }

         this.a(var1, var3, 4, 1, 2, 2);
         return true;
      }

      public static aqw.m a(aqw.k var0, List<aqt> var1, Random var2, int var3, int var4, int var5, cq var6, int var7) {
         aqe var8 = aqe.a(var3, var4, var5, 0, 0, 0, 9, 7, 12, var6);
         return a(var8) && aqt.a(var1, var8) == null ? new aqw.m(var0, var7, var2, var8, var6) : null;
      }
   }

   public static class b extends aqw.n {
      private afh d;
      private afh a;
      private afh b;
      private afh c;

      protected void b(dn var1) {
         super.b(var1);
         this.a = afh.c(var1.f("CA"));
         this.b = afh.c(var1.f("CB"));
         this.c = afh.c(var1.f("CC"));
         this.d = afh.c(var1.f("CD"));
      }

      public b() {
      }

      protected void a(dn var1) {
         super.a(var1);
         var1.a("CA", afh.c.b(this.a));
         var1.a("CB", afh.c.b(this.b));
         var1.a("CC", afh.c.b(this.c));
         var1.a("CD", afh.c.b(this.d));
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.h < 0) {
            this.h = this.b(var1, var3);
            if (this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.e + 4 - 1, 0);
         }

         this.a(var1, var3, 0, 1, 0, 12, 4, 8, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 1, 0, 1, 2, 0, 7, afi.ak.Q(), afi.ak.Q(), false);
         this.a(var1, var3, 4, 0, 1, 5, 0, 7, afi.ak.Q(), afi.ak.Q(), false);
         this.a(var1, var3, 7, 0, 1, 8, 0, 7, afi.ak.Q(), afi.ak.Q(), false);
         this.a(var1, var3, 10, 0, 1, 11, 0, 7, afi.ak.Q(), afi.ak.Q(), false);
         this.a(var1, var3, 0, 0, 0, 0, 0, 8, afi.r.Q(), afi.r.Q(), false);
         this.a(var1, var3, 6, 0, 0, 6, 0, 8, afi.r.Q(), afi.r.Q(), false);
         this.a(var1, var3, 12, 0, 0, 12, 0, 8, afi.r.Q(), afi.r.Q(), false);
         this.a(var1, var3, 1, 0, 0, 11, 0, 0, afi.r.Q(), afi.r.Q(), false);
         this.a(var1, var3, 1, 0, 8, 11, 0, 8, afi.r.Q(), afi.r.Q(), false);
         this.a(var1, var3, 3, 0, 1, 3, 0, 7, afi.j.Q(), afi.j.Q(), false);
         this.a(var1, var3, 9, 0, 1, 9, 0, 7, afi.j.Q(), afi.j.Q(), false);

         int var4;
         for(var4 = 1; var4 <= 7; ++var4) {
            this.a(var1, this.a.a(ns.a((Random)var2, 2, 7)), 1, 1, var4, var3);
            this.a(var1, this.a.a(ns.a((Random)var2, 2, 7)), 2, 1, var4, var3);
            this.a(var1, this.b.a(ns.a((Random)var2, 2, 7)), 4, 1, var4, var3);
            this.a(var1, this.b.a(ns.a((Random)var2, 2, 7)), 5, 1, var4, var3);
            this.a(var1, this.c.a(ns.a((Random)var2, 2, 7)), 7, 1, var4, var3);
            this.a(var1, this.c.a(ns.a((Random)var2, 2, 7)), 8, 1, var4, var3);
            this.a(var1, this.d.a(ns.a((Random)var2, 2, 7)), 10, 1, var4, var3);
            this.a(var1, this.d.a(ns.a((Random)var2, 2, 7)), 11, 1, var4, var3);
         }

         for(var4 = 0; var4 < 9; ++var4) {
            for(int var5 = 0; var5 < 13; ++var5) {
               this.b(var1, var5, 4, var4, var3);
               this.b(var1, afi.d.Q(), var5, -1, var4, var3);
            }
         }

         return true;
      }

      public b(aqw.k var1, int var2, Random var3, aqe var4, cq var5) {
         super(var1, var2);
         this.m = var5;
         this.l = var4;
         this.a = this.a(var3);
         this.b = this.a(var3);
         this.c = this.a(var3);
         this.d = this.a(var3);
      }

      private afh a(Random var1) {
         switch(var1.nextInt(5)) {
         case 0:
            return afi.cb;
         case 1:
            return afi.cc;
         default:
            return afi.aj;
         }
      }

      public static aqw.b a(aqw.k var0, List<aqt> var1, Random var2, int var3, int var4, int var5, cq var6, int var7) {
         aqe var8 = aqe.a(var3, var4, var5, 0, 0, 0, 13, 4, 9, var6);
         return a((aqe)var8) && aqt.a(var1, var8) == null ? new aqw.b(var0, var7, var2, var8, var6) : null;
      }
   }

   public static class l extends aqw.o {
      private int a;

      protected void a(dn var1) {
         super.a(var1);
         var1.a("Length", this.a);
      }

      public l() {
      }

      public l(aqw.k var1, int var2, Random var3, aqe var4, cq var5) {
         super(var1, var2);
         this.m = var5;
         this.l = var4;
         this.a = Math.max(var4.c(), var4.e());
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         alz var4 = this.a(afi.n.Q());
         alz var5 = this.a(afi.e.Q());

         for(int var6 = this.l.a; var6 <= this.l.d; ++var6) {
            for(int var7 = this.l.c; var7 <= this.l.f; ++var7) {
               cj var8 = new cj(var6, 64, var7);
               if (var3.b((df)var8)) {
                  var8 = var1.r(var8).b();
                  var1.a((cj)var8, (alz)var4, 2);
                  var1.a((cj)var8.b(), (alz)var5, 2);
               }
            }
         }

         return true;
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         boolean var4 = false;

         int var5;
         aqt var6;
         for(var5 = var3.nextInt(5); var5 < this.a - 8; var5 += 2 + var3.nextInt(5)) {
            var6 = this.a((aqw.k)var1, var2, var3, 0, var5);
            if (var6 != null) {
               var5 += Math.max(var6.l.c(), var6.l.e());
               var4 = true;
            }
         }

         for(var5 = var3.nextInt(5); var5 < this.a - 8; var5 += 2 + var3.nextInt(5)) {
            var6 = this.b((aqw.k)var1, var2, var3, 0, var5);
            if (var6 != null) {
               var5 += Math.max(var6.l.c(), var6.l.e());
               var4 = true;
            }
         }

         if (var4 && var3.nextInt(3) > 0 && this.m != null) {
            switch(this.m) {
            case c:
               aqw.b((aqw.k)var1, var2, var3, this.l.a - 1, this.l.b, this.l.c, cq.e, this.d());
               break;
            case d:
               aqw.b((aqw.k)var1, var2, var3, this.l.a - 1, this.l.b, this.l.f - 2, cq.e, this.d());
               break;
            case e:
               aqw.b((aqw.k)var1, var2, var3, this.l.a, this.l.b, this.l.c - 1, cq.c, this.d());
               break;
            case f:
               aqw.b((aqw.k)var1, var2, var3, this.l.d - 2, this.l.b, this.l.c - 1, cq.c, this.d());
            }
         }

         if (var4 && var3.nextInt(3) > 0 && this.m != null) {
            switch(this.m) {
            case c:
               aqw.b((aqw.k)var1, var2, var3, this.l.d + 1, this.l.b, this.l.c, cq.f, this.d());
               break;
            case d:
               aqw.b((aqw.k)var1, var2, var3, this.l.d + 1, this.l.b, this.l.f - 2, cq.f, this.d());
               break;
            case e:
               aqw.b((aqw.k)var1, var2, var3, this.l.a, this.l.b, this.l.f + 1, cq.d, this.d());
               break;
            case f:
               aqw.b((aqw.k)var1, var2, var3, this.l.d - 2, this.l.b, this.l.f + 1, cq.d, this.d());
            }
         }

      }

      public static aqe a(aqw.k var0, List<aqt> var1, Random var2, int var3, int var4, int var5, cq var6) {
         for(int var7 = 7 * ns.a((Random)var2, 3, 5); var7 >= 7; var7 -= 7) {
            aqe var8 = aqe.a(var3, var4, var5, 0, 0, 0, 3, 3, var7, var6);
            if (aqt.a(var1, var8) == null) {
               return var8;
            }
         }

         return null;
      }

      protected void b(dn var1) {
         super.b(var1);
         this.a = var1.f("Length");
      }
   }

   public static class e {
      public final int b;
      public int c;
      public Class<? extends aqw.n> a;
      public int d;

      public e(Class<? extends aqw.n> var1, int var2, int var3) {
         this.a = var1;
         this.b = var2;
         this.d = var3;
      }

      public boolean a() {
         return this.d == 0 || this.c < this.d;
      }

      public boolean a(int var1) {
         return this.d == 0 || this.c < this.d;
      }
   }

   public static class h extends aqw.n {
      private int b;
      private boolean a;

      protected void a(dn var1) {
         super.a(var1);
         var1.a("T", this.b);
         var1.a("C", this.a);
      }

      public static aqw.h a(aqw.k var0, List<aqt> var1, Random var2, int var3, int var4, int var5, cq var6, int var7) {
         aqe var8 = aqe.a(var3, var4, var5, 0, 0, 0, 4, 6, 5, var6);
         return a(var8) && aqt.a(var1, var8) == null ? new aqw.h(var0, var7, var2, var8, var6) : null;
      }

      protected void b(dn var1) {
         super.b(var1);
         this.b = var1.f("T");
         this.a = var1.n("C");
      }

      public h(aqw.k var1, int var2, Random var3, aqe var4, cq var5) {
         super(var1, var2);
         this.m = var5;
         this.l = var4;
         this.a = var3.nextBoolean();
         this.b = var3.nextInt(3);
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.h < 0) {
            this.h = this.b(var1, var3);
            if (this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.e + 6 - 1, 0);
         }

         this.a(var1, var3, 1, 1, 1, 3, 5, 4, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 0, 0, 0, 3, 0, 4, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 1, 0, 1, 2, 0, 3, afi.d.Q(), afi.d.Q(), false);
         if (this.a) {
            this.a(var1, var3, 1, 4, 1, 2, 4, 3, afi.r.Q(), afi.r.Q(), false);
         } else {
            this.a(var1, var3, 1, 5, 1, 2, 5, 3, afi.r.Q(), afi.r.Q(), false);
         }

         this.a(var1, afi.r.Q(), 1, 4, 0, var3);
         this.a(var1, afi.r.Q(), 2, 4, 0, var3);
         this.a(var1, afi.r.Q(), 1, 4, 4, var3);
         this.a(var1, afi.r.Q(), 2, 4, 4, var3);
         this.a(var1, afi.r.Q(), 0, 4, 1, var3);
         this.a(var1, afi.r.Q(), 0, 4, 2, var3);
         this.a(var1, afi.r.Q(), 0, 4, 3, var3);
         this.a(var1, afi.r.Q(), 3, 4, 1, var3);
         this.a(var1, afi.r.Q(), 3, 4, 2, var3);
         this.a(var1, afi.r.Q(), 3, 4, 3, var3);
         this.a(var1, var3, 0, 1, 0, 0, 3, 0, afi.r.Q(), afi.r.Q(), false);
         this.a(var1, var3, 3, 1, 0, 3, 3, 0, afi.r.Q(), afi.r.Q(), false);
         this.a(var1, var3, 0, 1, 4, 0, 3, 4, afi.r.Q(), afi.r.Q(), false);
         this.a(var1, var3, 3, 1, 4, 3, 3, 4, afi.r.Q(), afi.r.Q(), false);
         this.a(var1, var3, 0, 1, 1, 0, 3, 3, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 3, 1, 1, 3, 3, 3, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 1, 1, 0, 2, 3, 0, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 1, 1, 4, 2, 3, 4, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, afi.bj.Q(), 0, 2, 2, var3);
         this.a(var1, afi.bj.Q(), 3, 2, 2, var3);
         if (this.b > 0) {
            this.a(var1, afi.aO.Q(), this.b, 1, 3, var3);
            this.a(var1, afi.aB.Q(), this.b, 2, 3, var3);
         }

         this.a(var1, afi.a.Q(), 1, 1, 0, var3);
         this.a(var1, afi.a.Q(), 1, 2, 0, var3);
         this.a(var1, var3, var2, 1, 1, 0, cq.b(this.a(afi.ao, 1)));
         if (this.a(var1, 1, 0, -1, var3).c().t() == arm.a && this.a(var1, 1, -1, -1, var3).c().t() != arm.a) {
            this.a(var1, afi.aw.a(this.a(afi.aw, 3)), 1, 0, -1, var3);
         }

         for(int var4 = 0; var4 < 5; ++var4) {
            for(int var5 = 0; var5 < 4; ++var5) {
               this.b(var1, var5, 6, var4, var3);
               this.b(var1, afi.e.Q(), var5, -1, var4, var3);
            }
         }

         this.a(var1, var3, 1, 1, 2, 1);
         return true;
      }

      public h() {
      }
   }

   public static class g extends aqw.n {
      private boolean a;

      protected void b(dn var1) {
         super.b(var1);
         this.a = var1.n("Terrace");
      }

      public g() {
      }

      protected void a(dn var1) {
         super.a(var1);
         var1.a("Terrace", this.a);
      }

      public g(aqw.k var1, int var2, Random var3, aqe var4, cq var5) {
         super(var1, var2);
         this.m = var5;
         this.l = var4;
         this.a = var3.nextBoolean();
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.h < 0) {
            this.h = this.b(var1, var3);
            if (this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.e + 6 - 1, 0);
         }

         this.a(var1, var3, 0, 0, 0, 4, 0, 4, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 0, 4, 0, 4, 4, 4, afi.r.Q(), afi.r.Q(), false);
         this.a(var1, var3, 1, 4, 1, 3, 4, 3, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, afi.e.Q(), 0, 1, 0, var3);
         this.a(var1, afi.e.Q(), 0, 2, 0, var3);
         this.a(var1, afi.e.Q(), 0, 3, 0, var3);
         this.a(var1, afi.e.Q(), 4, 1, 0, var3);
         this.a(var1, afi.e.Q(), 4, 2, 0, var3);
         this.a(var1, afi.e.Q(), 4, 3, 0, var3);
         this.a(var1, afi.e.Q(), 0, 1, 4, var3);
         this.a(var1, afi.e.Q(), 0, 2, 4, var3);
         this.a(var1, afi.e.Q(), 0, 3, 4, var3);
         this.a(var1, afi.e.Q(), 4, 1, 4, var3);
         this.a(var1, afi.e.Q(), 4, 2, 4, var3);
         this.a(var1, afi.e.Q(), 4, 3, 4, var3);
         this.a(var1, var3, 0, 1, 1, 0, 3, 3, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 4, 1, 1, 4, 3, 3, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 1, 1, 4, 3, 3, 4, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, afi.bj.Q(), 0, 2, 2, var3);
         this.a(var1, afi.bj.Q(), 2, 2, 4, var3);
         this.a(var1, afi.bj.Q(), 4, 2, 2, var3);
         this.a(var1, afi.f.Q(), 1, 1, 0, var3);
         this.a(var1, afi.f.Q(), 1, 2, 0, var3);
         this.a(var1, afi.f.Q(), 1, 3, 0, var3);
         this.a(var1, afi.f.Q(), 2, 3, 0, var3);
         this.a(var1, afi.f.Q(), 3, 3, 0, var3);
         this.a(var1, afi.f.Q(), 3, 2, 0, var3);
         this.a(var1, afi.f.Q(), 3, 1, 0, var3);
         if (this.a(var1, 2, 0, -1, var3).c().t() == arm.a && this.a(var1, 2, -1, -1, var3).c().t() != arm.a) {
            this.a(var1, afi.aw.a(this.a(afi.aw, 3)), 2, 0, -1, var3);
         }

         this.a(var1, var3, 1, 1, 1, 3, 3, 3, afi.a.Q(), afi.a.Q(), false);
         if (this.a) {
            this.a(var1, afi.aO.Q(), 0, 5, 0, var3);
            this.a(var1, afi.aO.Q(), 1, 5, 0, var3);
            this.a(var1, afi.aO.Q(), 2, 5, 0, var3);
            this.a(var1, afi.aO.Q(), 3, 5, 0, var3);
            this.a(var1, afi.aO.Q(), 4, 5, 0, var3);
            this.a(var1, afi.aO.Q(), 0, 5, 4, var3);
            this.a(var1, afi.aO.Q(), 1, 5, 4, var3);
            this.a(var1, afi.aO.Q(), 2, 5, 4, var3);
            this.a(var1, afi.aO.Q(), 3, 5, 4, var3);
            this.a(var1, afi.aO.Q(), 4, 5, 4, var3);
            this.a(var1, afi.aO.Q(), 4, 5, 1, var3);
            this.a(var1, afi.aO.Q(), 4, 5, 2, var3);
            this.a(var1, afi.aO.Q(), 4, 5, 3, var3);
            this.a(var1, afi.aO.Q(), 0, 5, 1, var3);
            this.a(var1, afi.aO.Q(), 0, 5, 2, var3);
            this.a(var1, afi.aO.Q(), 0, 5, 3, var3);
         }

         int var4;
         if (this.a) {
            var4 = this.a(afi.au, 3);
            this.a(var1, afi.au.a(var4), 3, 1, 3, var3);
            this.a(var1, afi.au.a(var4), 3, 2, 3, var3);
            this.a(var1, afi.au.a(var4), 3, 3, 3, var3);
            this.a(var1, afi.au.a(var4), 3, 4, 3, var3);
         }

         this.a(var1, afi.aa.Q().a(akf.a, this.m), 2, 3, 1, var3);

         for(var4 = 0; var4 < 5; ++var4) {
            for(int var5 = 0; var5 < 5; ++var5) {
               this.b(var1, var5, 6, var4, var3);
               this.b(var1, afi.e.Q(), var5, -1, var4, var3);
            }
         }

         this.a(var1, var3, 1, 1, 2, 1);
         return true;
      }

      public static aqw.g a(aqw.k var0, List<aqt> var1, Random var2, int var3, int var4, int var5, cq var6, int var7) {
         aqe var8 = aqe.a(var3, var4, var5, 0, 0, 0, 5, 6, 5, var6);
         return aqt.a(var1, var8) != null ? null : new aqw.g(var0, var7, var2, var8, var6);
      }
   }

   public static class a extends aqw.n {
      public a() {
      }

      protected int c(int var1, int var2) {
         return 1;
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.h < 0) {
            this.h = this.b(var1, var3);
            if (this.h < 0) {
               return true;
            }

            this.l.a(0, this.h - this.l.e + 9 - 1, 0);
         }

         this.a(var1, var3, 1, 1, 1, 7, 5, 4, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 0, 0, 0, 8, 0, 5, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 0, 5, 0, 8, 5, 5, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 0, 6, 1, 8, 6, 4, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 0, 7, 2, 8, 7, 3, afi.e.Q(), afi.e.Q(), false);
         int var4 = this.a(afi.ad, 3);
         int var5 = this.a(afi.ad, 2);

         int var6;
         int var7;
         for(var6 = -1; var6 <= 2; ++var6) {
            for(var7 = 0; var7 <= 8; ++var7) {
               this.a(var1, afi.ad.a(var4), var7, 6 + var6, var6, var3);
               this.a(var1, afi.ad.a(var5), var7, 6 + var6, 5 - var6, var3);
            }
         }

         this.a(var1, var3, 0, 1, 0, 0, 1, 5, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 1, 1, 5, 8, 1, 5, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 8, 1, 0, 8, 1, 4, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 2, 1, 0, 7, 1, 0, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 0, 2, 0, 0, 4, 0, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 0, 2, 5, 0, 4, 5, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 8, 2, 5, 8, 4, 5, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 8, 2, 0, 8, 4, 0, afi.e.Q(), afi.e.Q(), false);
         this.a(var1, var3, 0, 2, 1, 0, 4, 4, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 1, 2, 5, 7, 4, 5, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 8, 2, 1, 8, 4, 4, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 1, 2, 0, 7, 4, 0, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, afi.bj.Q(), 4, 2, 0, var3);
         this.a(var1, afi.bj.Q(), 5, 2, 0, var3);
         this.a(var1, afi.bj.Q(), 6, 2, 0, var3);
         this.a(var1, afi.bj.Q(), 4, 3, 0, var3);
         this.a(var1, afi.bj.Q(), 5, 3, 0, var3);
         this.a(var1, afi.bj.Q(), 6, 3, 0, var3);
         this.a(var1, afi.bj.Q(), 0, 2, 2, var3);
         this.a(var1, afi.bj.Q(), 0, 2, 3, var3);
         this.a(var1, afi.bj.Q(), 0, 3, 2, var3);
         this.a(var1, afi.bj.Q(), 0, 3, 3, var3);
         this.a(var1, afi.bj.Q(), 8, 2, 2, var3);
         this.a(var1, afi.bj.Q(), 8, 2, 3, var3);
         this.a(var1, afi.bj.Q(), 8, 3, 2, var3);
         this.a(var1, afi.bj.Q(), 8, 3, 3, var3);
         this.a(var1, afi.bj.Q(), 2, 2, 5, var3);
         this.a(var1, afi.bj.Q(), 3, 2, 5, var3);
         this.a(var1, afi.bj.Q(), 5, 2, 5, var3);
         this.a(var1, afi.bj.Q(), 6, 2, 5, var3);
         this.a(var1, var3, 1, 4, 1, 7, 4, 1, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 1, 4, 4, 7, 4, 4, afi.f.Q(), afi.f.Q(), false);
         this.a(var1, var3, 1, 3, 4, 7, 3, 4, afi.X.Q(), afi.X.Q(), false);
         this.a(var1, afi.f.Q(), 7, 1, 4, var3);
         this.a(var1, afi.ad.a(this.a(afi.ad, 0)), 7, 1, 3, var3);
         var6 = this.a(afi.ad, 3);
         this.a(var1, afi.ad.a(var6), 6, 1, 4, var3);
         this.a(var1, afi.ad.a(var6), 5, 1, 4, var3);
         this.a(var1, afi.ad.a(var6), 4, 1, 4, var3);
         this.a(var1, afi.ad.a(var6), 3, 1, 4, var3);
         this.a(var1, afi.aO.Q(), 6, 1, 3, var3);
         this.a(var1, afi.aB.Q(), 6, 2, 3, var3);
         this.a(var1, afi.aO.Q(), 4, 1, 3, var3);
         this.a(var1, afi.aB.Q(), 4, 2, 3, var3);
         this.a(var1, afi.ai.Q(), 7, 1, 1, var3);
         this.a(var1, afi.a.Q(), 1, 1, 0, var3);
         this.a(var1, afi.a.Q(), 1, 2, 0, var3);
         this.a(var1, var3, var2, 1, 1, 0, cq.b(this.a(afi.ao, 1)));
         if (this.a(var1, 1, 0, -1, var3).c().t() == arm.a && this.a(var1, 1, -1, -1, var3).c().t() != arm.a) {
            this.a(var1, afi.aw.a(this.a(afi.aw, 3)), 1, 0, -1, var3);
         }

         for(var7 = 0; var7 < 6; ++var7) {
            for(int var8 = 0; var8 < 9; ++var8) {
               this.b(var1, var8, 9, var7, var3);
               this.b(var1, afi.e.Q(), var8, -1, var7, var3);
            }
         }

         this.a(var1, var3, 2, 1, 2, 1);
         return true;
      }

      public a(aqw.k var1, int var2, Random var3, aqe var4, cq var5) {
         super(var1, var2);
         this.m = var5;
         this.l = var4;
      }

      public static aqw.a a(aqw.k var0, List<aqt> var1, Random var2, int var3, int var4, int var5, cq var6, int var7) {
         aqe var8 = aqe.a(var3, var4, var5, 0, 0, 0, 9, 9, 6, var6);
         return a(var8) && aqt.a(var1, var8) == null ? new aqw.a(var0, var7, var2, var8, var6) : null;
      }
   }

   abstract static class n extends aqt {
      private boolean b;
      protected int h = -1;
      private int a;

      protected void b(adm var1, alz var2, int var3, int var4, int var5, aqe var6) {
         alz var7 = this.a(var2);
         super.b(var1, var7, var3, var4, var5, var6);
      }

      protected void b(dn var1) {
         this.h = var1.f("HPos");
         this.a = var1.f("VCount");
         this.b = var1.n("Desert");
      }

      protected void a(adm var1, alz var2, int var3, int var4, int var5, aqe var6) {
         alz var7 = this.a(var2);
         super.a(var1, var7, var3, var4, var5, var6);
      }

      protected int c(int var1, int var2) {
         return var2;
      }

      protected aqt b(aqw.k var1, List<aqt> var2, Random var3, int var4, int var5) {
         if (this.m != null) {
            switch(this.m) {
            case c:
               return aqw.a(var1, var2, var3, this.l.d + 1, this.l.b + var4, this.l.c + var5, cq.f, this.d());
            case d:
               return aqw.a(var1, var2, var3, this.l.d + 1, this.l.b + var4, this.l.c + var5, cq.f, this.d());
            case e:
               return aqw.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.f + 1, cq.d, this.d());
            case f:
               return aqw.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.f + 1, cq.d, this.d());
            }
         }

         return null;
      }

      protected void a(adm var1, aqe var2, int var3, int var4, int var5, int var6, int var7, int var8, alz var9, alz var10, boolean var11) {
         alz var12 = this.a(var9);
         alz var13 = this.a(var10);
         super.a(var1, var2, var3, var4, var5, var6, var7, var8, var12, var13, var11);
      }

      protected aqt a(aqw.k var1, List<aqt> var2, Random var3, int var4, int var5) {
         if (this.m != null) {
            switch(this.m) {
            case c:
               return aqw.a(var1, var2, var3, this.l.a - 1, this.l.b + var4, this.l.c + var5, cq.e, this.d());
            case d:
               return aqw.a(var1, var2, var3, this.l.a - 1, this.l.b + var4, this.l.c + var5, cq.e, this.d());
            case e:
               return aqw.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.c - 1, cq.c, this.d());
            case f:
               return aqw.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.c - 1, cq.c, this.d());
            }
         }

         return null;
      }

      protected static boolean a(aqe var0) {
         return var0 != null && var0.b > 10;
      }

      protected void a(dn var1) {
         var1.a("HPos", this.h);
         var1.a("VCount", this.a);
         var1.a("Desert", this.b);
      }

      protected void a(adm var1, aqe var2, int var3, int var4, int var5, int var6) {
         if (this.a < var6) {
            for(int var7 = this.a; var7 < var6; ++var7) {
               int var8 = this.a(var3 + var7, var5);
               int var9 = this.d(var4);
               int var10 = this.b(var3 + var7, var5);
               if (!var2.b((df)(new cj(var8, var9, var10)))) {
                  break;
               }

               ++this.a;
               wi var11 = new wi(var1);
               var11.b((double)var8 + 0.5D, (double)var9, (double)var10 + 0.5D, 0.0F, 0.0F);
               var11.a(var1.E(new cj(var11)), (pu)null);
               var11.r(this.c(var7, var11.cl()));
               var1.d((pk)var11);
            }

         }
      }

      protected void a(boolean var1) {
         this.b = var1;
      }

      public n() {
      }

      protected alz a(alz var1) {
         if (this.b) {
            if (var1.c() == afi.r || var1.c() == afi.s) {
               return afi.A.Q();
            }

            if (var1.c() == afi.e) {
               return afi.A.a(aji.a.a.a());
            }

            if (var1.c() == afi.f) {
               return afi.A.a(aji.a.c.a());
            }

            if (var1.c() == afi.ad) {
               return afi.bO.Q().a(aju.a, var1.b(aju.a));
            }

            if (var1.c() == afi.aw) {
               return afi.bO.Q().a(aju.a, var1.b(aju.a));
            }

            if (var1.c() == afi.n) {
               return afi.A.Q();
            }
         }

         return var1;
      }

      protected int b(adm var1, aqe var2) {
         int var3 = 0;
         int var4 = 0;
         cj.a var5 = new cj.a();

         for(int var6 = this.l.c; var6 <= this.l.f; ++var6) {
            for(int var7 = this.l.a; var7 <= this.l.d; ++var7) {
               var5.c(var7, 64, var6);
               if (var2.b((df)var5)) {
                  var3 += Math.max(var1.r(var5).o(), var1.t.i());
                  ++var4;
               }
            }
         }

         if (var4 == 0) {
            return -1;
         } else {
            return var3 / var4;
         }
      }

      protected n(aqw.k var1, int var2) {
         super(var2);
         if (var1 != null) {
            this.b = var1.b;
         }

      }
   }
}
