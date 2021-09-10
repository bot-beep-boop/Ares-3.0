import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class aqp {
   static int a;
   private static Class<? extends aqp.p> d;
   private static final aqp.f[] b = new aqp.f[]{new aqp.f(aqp.n.class, 40, 0), new aqp.f(aqp.h.class, 5, 5), new aqp.f(aqp.d.class, 20, 0), new aqp.f(aqp.i.class, 20, 0), new aqp.f(aqp.j.class, 10, 6), new aqp.f(aqp.o.class, 5, 5), new aqp.f(aqp.l.class, 5, 5), new aqp.f(aqp.c.class, 5, 4), new aqp.f(aqp.a.class, 5, 4), new aqp.f(aqp.e.class, 10, 2) {
      public boolean a(int var1) {
         return super.a(var1) && var1 > 4;
      }
   }, new aqp.f(aqp.g.class, 20, 1) {
      public boolean a(int var1) {
         return super.a(var1) && var1 > 5;
      }
   }};
   private static List<aqp.f> c;
   private static final aqp.k e = new aqp.k();

   static aqp.k c() {
      return e;
   }

   public static void a() {
      aqr.a(aqp.a.class, "SHCC");
      aqr.a(aqp.b.class, "SHFC");
      aqr.a(aqp.c.class, "SH5C");
      aqr.a(aqp.d.class, "SHLT");
      aqr.a(aqp.e.class, "SHLi");
      aqr.a(aqp.g.class, "SHPR");
      aqr.a(aqp.h.class, "SHPH");
      aqr.a(aqp.i.class, "SHRT");
      aqr.a(aqp.j.class, "SHRC");
      aqr.a(aqp.l.class, "SHSD");
      aqr.a(aqp.m.class, "SHStart");
      aqr.a(aqp.n.class, "SHS");
      aqr.a(aqp.o.class, "SHSSD");
   }

   public static void b() {
      c = Lists.newArrayList();
      aqp.f[] var0 = b;
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         aqp.f var3 = var0[var2];
         var3.c = 0;
         c.add(var3);
      }

      d = null;
   }

   private static aqp.p a(Class<? extends aqp.p> var0, List<aqt> var1, Random var2, int var3, int var4, int var5, cq var6, int var7) {
      Object var8 = null;
      if (var0 == aqp.n.class) {
         var8 = aqp.n.a(var1, var2, var3, var4, var5, var6, var7);
      } else if (var0 == aqp.h.class) {
         var8 = aqp.h.a(var1, var2, var3, var4, var5, var6, var7);
      } else if (var0 == aqp.d.class) {
         var8 = aqp.d.a(var1, var2, var3, var4, var5, var6, var7);
      } else if (var0 == aqp.i.class) {
         var8 = aqp.i.a(var1, var2, var3, var4, var5, var6, var7);
      } else if (var0 == aqp.j.class) {
         var8 = aqp.j.a(var1, var2, var3, var4, var5, var6, var7);
      } else if (var0 == aqp.o.class) {
         var8 = aqp.o.a(var1, var2, var3, var4, var5, var6, var7);
      } else if (var0 == aqp.l.class) {
         var8 = aqp.l.a(var1, var2, var3, var4, var5, var6, var7);
      } else if (var0 == aqp.c.class) {
         var8 = aqp.c.a(var1, var2, var3, var4, var5, var6, var7);
      } else if (var0 == aqp.a.class) {
         var8 = aqp.a.a(var1, var2, var3, var4, var5, var6, var7);
      } else if (var0 == aqp.e.class) {
         var8 = aqp.e.a(var1, var2, var3, var4, var5, var6, var7);
      } else if (var0 == aqp.g.class) {
         var8 = aqp.g.a(var1, var2, var3, var4, var5, var6, var7);
      }

      return (aqp.p)var8;
   }

   private static boolean d() {
      boolean var0 = false;
      a = 0;

      aqp.f var2;
      for(Iterator var1 = c.iterator(); var1.hasNext(); a += var2.b) {
         var2 = (aqp.f)var1.next();
         if (var2.d > 0 && var2.c < var2.d) {
            var0 = true;
         }
      }

      return var0;
   }

   private static aqp.p b(aqp.m var0, List<aqt> var1, Random var2, int var3, int var4, int var5, cq var6, int var7) {
      if (!d()) {
         return null;
      } else {
         if (d != null) {
            aqp.p var8 = a(d, var1, var2, var3, var4, var5, var6, var7);
            d = null;
            if (var8 != null) {
               return var8;
            }
         }

         int var13 = 0;

         while(var13 < 5) {
            ++var13;
            int var9 = var2.nextInt(a);
            Iterator var10 = c.iterator();

            while(var10.hasNext()) {
               aqp.f var11 = (aqp.f)var10.next();
               var9 -= var11.b;
               if (var9 < 0) {
                  if (!var11.a(var7) || var11 == var0.a) {
                     break;
                  }

                  aqp.p var12 = a(var11.a, var1, var2, var3, var4, var5, var6, var7);
                  if (var12 != null) {
                     ++var11.c;
                     var0.a = var11;
                     if (!var11.a()) {
                        c.remove(var11);
                     }

                     return var12;
                  }
               }
            }
         }

         aqe var14 = aqp.b.a(var1, var2, var3, var4, var5, var6);
         if (var14 != null && var14.b > 1) {
            return new aqp.b(var7, var2, var14, var6);
         } else {
            return null;
         }
      }
   }

   static aqt a(aqp.m var0, List var1, Random var2, int var3, int var4, int var5, cq var6, int var7) {
      return c(var0, var1, var2, var3, var4, var5, var6, var7);
   }

   static Class a(Class var0) {
      d = var0;
      return var0;
   }

   private static aqt c(aqp.m var0, List<aqt> var1, Random var2, int var3, int var4, int var5, cq var6, int var7) {
      if (var7 > 50) {
         return null;
      } else if (Math.abs(var3 - var0.c().a) <= 112 && Math.abs(var5 - var0.c().c) <= 112) {
         aqp.p var8 = b(var0, var1, var2, var3, var4, var5, var6, var7 + 1);
         if (var8 != null) {
            var1.add(var8);
            var0.c.add(var8);
         }

         return var8;
      } else {
         return null;
      }
   }

   public static class i extends aqp.d {
      public void a(aqt var1, List<aqt> var2, Random var3) {
         if (this.m != cq.c && this.m != cq.f) {
            this.b((aqp.m)var1, var2, var3, 1, 1);
         } else {
            this.c((aqp.m)var1, var2, var3, 1, 1);
         }

      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.a(var1, var3)) {
            return false;
         } else {
            this.a(var1, var3, 0, 0, 0, 4, 4, 4, true, var2, aqp.c());
            this.a(var1, var2, var3, this.d, 1, 1, 0);
            if (this.m != cq.c && this.m != cq.f) {
               this.a(var1, var3, 0, 1, 1, 0, 3, 3, afi.a.Q(), afi.a.Q(), false);
            } else {
               this.a(var1, var3, 4, 1, 1, 4, 3, 3, afi.a.Q(), afi.a.Q(), false);
            }

            return true;
         }
      }
   }

   public static class o extends aqp.p {
      public static aqp.o a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
         aqe var7 = aqe.a(var2, var3, var4, -1, -7, 0, 5, 11, 8, var5);
         return a(var7) && aqt.a(var0, var7) == null ? new aqp.o(var6, var1, var7, var5) : null;
      }

      public o() {
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         this.a((aqp.m)var1, var2, var3, 1, 1);
      }

      public o(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.d = this.a(var2);
         this.l = var3;
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.a(var1, var3)) {
            return false;
         } else {
            this.a(var1, var3, 0, 0, 0, 4, 10, 7, true, var2, aqp.c());
            this.a(var1, var2, var3, this.d, 1, 7, 0);
            this.a(var1, var2, var3, aqp.p.a.a, 1, 1, 7);
            int var4 = this.a(afi.aw, 2);

            for(int var5 = 0; var5 < 6; ++var5) {
               this.a(var1, afi.aw.a(var4), 1, 6 - var5, 1 + var5, var3);
               this.a(var1, afi.aw.a(var4), 2, 6 - var5, 1 + var5, var3);
               this.a(var1, afi.aw.a(var4), 3, 6 - var5, 1 + var5, var3);
               if (var5 < 5) {
                  this.a(var1, afi.bf.Q(), 1, 5 - var5, 1 + var5, var3);
                  this.a(var1, afi.bf.Q(), 2, 5 - var5, 1 + var5, var3);
                  this.a(var1, afi.bf.Q(), 3, 5 - var5, 1 + var5, var3);
               }
            }

            return true;
         }
      }
   }

   public static class l extends aqp.p {
      private boolean a;

      public void a(aqt var1, List<aqt> var2, Random var3) {
         if (this.a) {
            aqp.a(aqp.c.class);
         }

         this.a((aqp.m)var1, var2, var3, 1, 1);
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.a(var1, var3)) {
            return false;
         } else {
            this.a(var1, var3, 0, 0, 0, 4, 10, 4, true, var2, aqp.c());
            this.a(var1, var2, var3, this.d, 1, 7, 0);
            this.a(var1, var2, var3, aqp.p.a.a, 1, 1, 4);
            this.a(var1, afi.bf.Q(), 2, 6, 1, var3);
            this.a(var1, afi.bf.Q(), 1, 5, 1, var3);
            this.a(var1, afi.U.a(akb.a.a.a()), 1, 6, 1, var3);
            this.a(var1, afi.bf.Q(), 1, 5, 2, var3);
            this.a(var1, afi.bf.Q(), 1, 4, 3, var3);
            this.a(var1, afi.U.a(akb.a.a.a()), 1, 5, 3, var3);
            this.a(var1, afi.bf.Q(), 2, 4, 3, var3);
            this.a(var1, afi.bf.Q(), 3, 3, 3, var3);
            this.a(var1, afi.U.a(akb.a.a.a()), 3, 4, 3, var3);
            this.a(var1, afi.bf.Q(), 3, 3, 2, var3);
            this.a(var1, afi.bf.Q(), 3, 2, 1, var3);
            this.a(var1, afi.U.a(akb.a.a.a()), 3, 3, 1, var3);
            this.a(var1, afi.bf.Q(), 2, 2, 1, var3);
            this.a(var1, afi.bf.Q(), 1, 1, 1, var3);
            this.a(var1, afi.U.a(akb.a.a.a()), 1, 2, 1, var3);
            this.a(var1, afi.bf.Q(), 1, 1, 2, var3);
            this.a(var1, afi.U.a(akb.a.a.a()), 1, 1, 3, var3);
            return true;
         }
      }

      public l() {
      }

      public static aqp.l a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
         aqe var7 = aqe.a(var2, var3, var4, -1, -7, 0, 5, 11, 5, var5);
         return a(var7) && aqt.a(var0, var7) == null ? new aqp.l(var6, var1, var7, var5) : null;
      }

      protected void b(dn var1) {
         super.b(var1);
         this.a = var1.n("Source");
      }

      public l(int var1, Random var2, int var3, int var4) {
         super(var1);
         this.a = true;
         this.m = cq.c.a.a(var2);
         this.d = aqp.p.a.a;
         switch(this.m) {
         case c:
         case d:
            this.l = new aqe(var3, 64, var4, var3 + 5 - 1, 74, var4 + 5 - 1);
            break;
         default:
            this.l = new aqe(var3, 64, var4, var3 + 5 - 1, 74, var4 + 5 - 1);
         }

      }

      public l(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.a = false;
         this.m = var4;
         this.d = this.a(var2);
         this.l = var3;
      }

      protected void a(dn var1) {
         super.a(var1);
         var1.a("Source", this.a);
      }
   }

   public static class g extends aqp.p {
      private boolean a;

      protected void a(dn var1) {
         super.a(var1);
         var1.a("Mob", this.a);
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         if (var1 != null) {
            ((aqp.m)var1).b = this;
         }

      }

      public boolean a(adm var1, Random var2, aqe var3) {
         this.a(var1, var3, 0, 0, 0, 10, 7, 15, false, var2, aqp.c());
         this.a(var1, var2, var3, aqp.p.a.c, 4, 1, 0);
         byte var4 = 6;
         this.a(var1, var3, 1, var4, 1, 1, var4, 14, false, var2, aqp.c());
         this.a(var1, var3, 9, var4, 1, 9, var4, 14, false, var2, aqp.c());
         this.a(var1, var3, 2, var4, 1, 8, var4, 2, false, var2, aqp.c());
         this.a(var1, var3, 2, var4, 14, 8, var4, 14, false, var2, aqp.c());
         this.a(var1, var3, 1, 1, 1, 2, 1, 4, false, var2, aqp.c());
         this.a(var1, var3, 8, 1, 1, 9, 1, 4, false, var2, aqp.c());
         this.a(var1, var3, 1, 1, 1, 1, 1, 3, afi.k.Q(), afi.k.Q(), false);
         this.a(var1, var3, 9, 1, 1, 9, 1, 3, afi.k.Q(), afi.k.Q(), false);
         this.a(var1, var3, 3, 1, 8, 7, 1, 12, false, var2, aqp.c());
         this.a(var1, var3, 4, 1, 9, 6, 1, 11, afi.k.Q(), afi.k.Q(), false);

         int var5;
         for(var5 = 3; var5 < 14; var5 += 2) {
            this.a(var1, var3, 0, 3, var5, 0, 4, var5, afi.bi.Q(), afi.bi.Q(), false);
            this.a(var1, var3, 10, 3, var5, 10, 4, var5, afi.bi.Q(), afi.bi.Q(), false);
         }

         for(var5 = 2; var5 < 9; var5 += 2) {
            this.a(var1, var3, var5, 3, 15, var5, 4, 15, afi.bi.Q(), afi.bi.Q(), false);
         }

         var5 = this.a(afi.bv, 3);
         this.a(var1, var3, 4, 1, 5, 6, 1, 7, false, var2, aqp.c());
         this.a(var1, var3, 4, 2, 6, 6, 2, 7, false, var2, aqp.c());
         this.a(var1, var3, 4, 3, 7, 6, 3, 7, false, var2, aqp.c());

         int var6;
         for(var6 = 4; var6 <= 6; ++var6) {
            this.a(var1, afi.bv.a(var5), var6, 1, 4, var3);
            this.a(var1, afi.bv.a(var5), var6, 2, 5, var3);
            this.a(var1, afi.bv.a(var5), var6, 3, 6, var3);
         }

         var6 = cq.c.b();
         int var7 = cq.d.b();
         int var8 = cq.f.b();
         int var9 = cq.e.b();
         if (this.m != null) {
            switch(this.m) {
            case d:
               var6 = cq.d.b();
               var7 = cq.c.b();
               break;
            case e:
               var6 = cq.e.b();
               var7 = cq.f.b();
               var8 = cq.d.b();
               var9 = cq.c.b();
               break;
            case f:
               var6 = cq.f.b();
               var7 = cq.e.b();
               var8 = cq.d.b();
               var9 = cq.c.b();
            }
         }

         this.a(var1, afi.bG.a(var6).a(ago.b, var2.nextFloat() > 0.9F), 4, 3, 8, var3);
         this.a(var1, afi.bG.a(var6).a(ago.b, var2.nextFloat() > 0.9F), 5, 3, 8, var3);
         this.a(var1, afi.bG.a(var6).a(ago.b, var2.nextFloat() > 0.9F), 6, 3, 8, var3);
         this.a(var1, afi.bG.a(var7).a(ago.b, var2.nextFloat() > 0.9F), 4, 3, 12, var3);
         this.a(var1, afi.bG.a(var7).a(ago.b, var2.nextFloat() > 0.9F), 5, 3, 12, var3);
         this.a(var1, afi.bG.a(var7).a(ago.b, var2.nextFloat() > 0.9F), 6, 3, 12, var3);
         this.a(var1, afi.bG.a(var8).a(ago.b, var2.nextFloat() > 0.9F), 3, 3, 9, var3);
         this.a(var1, afi.bG.a(var8).a(ago.b, var2.nextFloat() > 0.9F), 3, 3, 10, var3);
         this.a(var1, afi.bG.a(var8).a(ago.b, var2.nextFloat() > 0.9F), 3, 3, 11, var3);
         this.a(var1, afi.bG.a(var9).a(ago.b, var2.nextFloat() > 0.9F), 7, 3, 9, var3);
         this.a(var1, afi.bG.a(var9).a(ago.b, var2.nextFloat() > 0.9F), 7, 3, 10, var3);
         this.a(var1, afi.bG.a(var9).a(ago.b, var2.nextFloat() > 0.9F), 7, 3, 11, var3);
         if (!this.a) {
            int var12 = this.d(3);
            cj var10 = new cj(this.a(5, 6), var12, this.b(5, 6));
            if (var3.b((df)var10)) {
               this.a = true;
               var1.a((cj)var10, (alz)afi.ac.Q(), 2);
               akw var11 = var1.s(var10);
               if (var11 instanceof all) {
                  ((all)var11).b().a("Silverfish");
               }
            }
         }

         return true;
      }

      public g(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.l = var3;
      }

      protected void b(dn var1) {
         super.b(var1);
         this.a = var1.n("Mob");
      }

      public g() {
      }

      public static aqp.g a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
         aqe var7 = aqe.a(var2, var3, var4, -4, -1, 0, 11, 8, 16, var5);
         return a(var7) && aqt.a(var0, var7) == null ? new aqp.g(var6, var1, var7, var5) : null;
      }
   }

   public static class n extends aqp.p {
      private boolean a;
      private boolean b;

      protected void a(dn var1) {
         super.a(var1);
         var1.a("Left", this.a);
         var1.a("Right", this.b);
      }

      public static aqp.n a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
         aqe var7 = aqe.a(var2, var3, var4, -1, -1, 0, 5, 5, 7, var5);
         return a(var7) && aqt.a(var0, var7) == null ? new aqp.n(var6, var1, var7, var5) : null;
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         this.a((aqp.m)var1, var2, var3, 1, 1);
         if (this.a) {
            this.b((aqp.m)var1, var2, var3, 1, 2);
         }

         if (this.b) {
            this.c((aqp.m)var1, var2, var3, 1, 2);
         }

      }

      public n(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.d = this.a(var2);
         this.l = var3;
         this.a = var2.nextInt(2) == 0;
         this.b = var2.nextInt(2) == 0;
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.a(var1, var3)) {
            return false;
         } else {
            this.a(var1, var3, 0, 0, 0, 4, 4, 6, true, var2, aqp.c());
            this.a(var1, var2, var3, this.d, 1, 1, 0);
            this.a(var1, var2, var3, aqp.p.a.a, 1, 1, 6);
            this.a(var1, var3, var2, 0.1F, 1, 2, 1, afi.aa.Q());
            this.a(var1, var3, var2, 0.1F, 3, 2, 1, afi.aa.Q());
            this.a(var1, var3, var2, 0.1F, 1, 2, 5, afi.aa.Q());
            this.a(var1, var3, var2, 0.1F, 3, 2, 5, afi.aa.Q());
            if (this.a) {
               this.a(var1, var3, 0, 1, 2, 0, 3, 4, afi.a.Q(), afi.a.Q(), false);
            }

            if (this.b) {
               this.a(var1, var3, 4, 1, 2, 4, 3, 4, afi.a.Q(), afi.a.Q(), false);
            }

            return true;
         }
      }

      protected void b(dn var1) {
         super.b(var1);
         this.a = var1.n("Left");
         this.b = var1.n("Right");
      }

      public n() {
      }
   }

   public static class c extends aqp.p {
      private boolean e;
      private boolean b;
      private boolean c;
      private boolean a;

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.a(var1, var3)) {
            return false;
         } else {
            this.a(var1, var3, 0, 0, 0, 9, 8, 10, true, var2, aqp.c());
            this.a(var1, var2, var3, this.d, 4, 3, 0);
            if (this.a) {
               this.a(var1, var3, 0, 3, 1, 0, 5, 3, afi.a.Q(), afi.a.Q(), false);
            }

            if (this.c) {
               this.a(var1, var3, 9, 3, 1, 9, 5, 3, afi.a.Q(), afi.a.Q(), false);
            }

            if (this.b) {
               this.a(var1, var3, 0, 5, 7, 0, 7, 9, afi.a.Q(), afi.a.Q(), false);
            }

            if (this.e) {
               this.a(var1, var3, 9, 5, 7, 9, 7, 9, afi.a.Q(), afi.a.Q(), false);
            }

            this.a(var1, var3, 5, 1, 10, 7, 3, 10, afi.a.Q(), afi.a.Q(), false);
            this.a(var1, var3, 1, 2, 1, 8, 2, 6, false, var2, aqp.c());
            this.a(var1, var3, 4, 1, 5, 4, 4, 9, false, var2, aqp.c());
            this.a(var1, var3, 8, 1, 5, 8, 4, 9, false, var2, aqp.c());
            this.a(var1, var3, 1, 4, 7, 3, 4, 9, false, var2, aqp.c());
            this.a(var1, var3, 1, 3, 5, 3, 3, 6, false, var2, aqp.c());
            this.a(var1, var3, 1, 3, 4, 3, 3, 4, afi.U.Q(), afi.U.Q(), false);
            this.a(var1, var3, 1, 4, 6, 3, 4, 6, afi.U.Q(), afi.U.Q(), false);
            this.a(var1, var3, 5, 1, 7, 7, 1, 8, false, var2, aqp.c());
            this.a(var1, var3, 5, 1, 9, 7, 1, 9, afi.U.Q(), afi.U.Q(), false);
            this.a(var1, var3, 5, 2, 7, 7, 2, 7, afi.U.Q(), afi.U.Q(), false);
            this.a(var1, var3, 4, 5, 7, 4, 5, 9, afi.U.Q(), afi.U.Q(), false);
            this.a(var1, var3, 8, 5, 7, 8, 5, 9, afi.U.Q(), afi.U.Q(), false);
            this.a(var1, var3, 5, 5, 7, 7, 5, 9, afi.T.Q(), afi.T.Q(), false);
            this.a(var1, afi.aa.Q(), 6, 5, 6, var3);
            return true;
         }
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         int var4 = 3;
         int var5 = 5;
         if (this.m == cq.e || this.m == cq.c) {
            var4 = 8 - var4;
            var5 = 8 - var5;
         }

         this.a((aqp.m)var1, var2, var3, 5, 1);
         if (this.a) {
            this.b((aqp.m)var1, var2, var3, var4, 1);
         }

         if (this.b) {
            this.b((aqp.m)var1, var2, var3, var5, 7);
         }

         if (this.c) {
            this.c((aqp.m)var1, var2, var3, var4, 1);
         }

         if (this.e) {
            this.c((aqp.m)var1, var2, var3, var5, 7);
         }

      }

      public static aqp.c a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
         aqe var7 = aqe.a(var2, var3, var4, -4, -3, 0, 10, 9, 11, var5);
         return a(var7) && aqt.a(var0, var7) == null ? new aqp.c(var6, var1, var7, var5) : null;
      }

      public c() {
      }

      protected void b(dn var1) {
         super.b(var1);
         this.a = var1.n("leftLow");
         this.b = var1.n("leftHigh");
         this.c = var1.n("rightLow");
         this.e = var1.n("rightHigh");
      }

      public c(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.d = this.a(var2);
         this.l = var3;
         this.a = var2.nextBoolean();
         this.b = var2.nextBoolean();
         this.c = var2.nextBoolean();
         this.e = var2.nextInt(3) > 0;
      }

      protected void a(dn var1) {
         super.a(var1);
         var1.a("leftLow", this.a);
         var1.a("leftHigh", this.b);
         var1.a("rightLow", this.c);
         var1.a("rightHigh", this.e);
      }
   }

   static class f {
      public int d;
      public int c;
      public final int b;
      public Class<? extends aqp.p> a;

      public f(Class<? extends aqp.p> var1, int var2, int var3) {
         this.a = var1;
         this.b = var2;
         this.d = var3;
      }

      public boolean a(int var1) {
         return this.d == 0 || this.c < this.d;
      }

      public boolean a() {
         return this.d == 0 || this.c < this.d;
      }
   }

   static class k extends aqt.a {
      public void a(Random var1, int var2, int var3, int var4, boolean var5) {
         if (var5) {
            float var6 = var1.nextFloat();
            if (var6 < 0.2F) {
               this.a = afi.bf.a(ajz.O);
            } else if (var6 < 0.5F) {
               this.a = afi.bf.a(ajz.N);
            } else if (var6 < 0.55F) {
               this.a = afi.be.a(ahz.a.c.a());
            } else {
               this.a = afi.bf.Q();
            }
         } else {
            this.a = afi.a.Q();
         }

      }

      k(Object var1) {
         this();
      }

      private k() {
      }
   }

   public static class h extends aqp.p {
      public h(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.d = this.a(var2);
         this.l = var3;
      }

      public h() {
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.a(var1, var3)) {
            return false;
         } else {
            this.a(var1, var3, 0, 0, 0, 8, 4, 10, true, var2, aqp.c());
            this.a(var1, var2, var3, this.d, 1, 1, 0);
            this.a(var1, var3, 1, 1, 10, 3, 3, 10, afi.a.Q(), afi.a.Q(), false);
            this.a(var1, var3, 4, 1, 1, 4, 3, 1, false, var2, aqp.c());
            this.a(var1, var3, 4, 1, 3, 4, 3, 3, false, var2, aqp.c());
            this.a(var1, var3, 4, 1, 7, 4, 3, 7, false, var2, aqp.c());
            this.a(var1, var3, 4, 1, 9, 4, 3, 9, false, var2, aqp.c());
            this.a(var1, var3, 4, 1, 4, 4, 3, 6, afi.bi.Q(), afi.bi.Q(), false);
            this.a(var1, var3, 5, 1, 5, 7, 3, 5, afi.bi.Q(), afi.bi.Q(), false);
            this.a(var1, afi.bi.Q(), 4, 3, 2, var3);
            this.a(var1, afi.bi.Q(), 4, 3, 8, var3);
            this.a(var1, afi.aA.a(this.a(afi.aA, 3)), 4, 1, 2, var3);
            this.a(var1, afi.aA.a(this.a(afi.aA, 3) + 8), 4, 2, 2, var3);
            this.a(var1, afi.aA.a(this.a(afi.aA, 3)), 4, 1, 8, var3);
            this.a(var1, afi.aA.a(this.a(afi.aA, 3) + 8), 4, 2, 8, var3);
            return true;
         }
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         this.a((aqp.m)var1, var2, var3, 1, 1);
      }

      public static aqp.h a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
         aqe var7 = aqe.a(var2, var3, var4, -1, -1, 0, 9, 5, 11, var5);
         return a(var7) && aqt.a(var0, var7) == null ? new aqp.h(var6, var1, var7, var5) : null;
      }
   }

   public static class e extends aqp.p {
      private boolean b;
      private static final List<ob> a;

      public static aqp.e a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
         aqe var7 = aqe.a(var2, var3, var4, -4, -1, 0, 14, 11, 15, var5);
         if (!a(var7) || aqt.a(var0, var7) != null) {
            var7 = aqe.a(var2, var3, var4, -4, -1, 0, 14, 6, 15, var5);
            if (!a(var7) || aqt.a(var0, var7) != null) {
               return null;
            }
         }

         return new aqp.e(var6, var1, var7, var5);
      }

      static {
         a = Lists.newArrayList(new ob[]{new ob(zy.aL, 0, 1, 3, 20), new ob(zy.aK, 0, 2, 7, 20), new ob(zy.bV, 0, 1, 1, 1), new ob(zy.aQ, 0, 1, 1, 1)});
      }

      protected void a(dn var1) {
         super.a(var1);
         var1.a("Tall", this.b);
      }

      protected void b(dn var1) {
         super.b(var1);
         this.b = var1.n("Tall");
      }

      public e() {
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.a(var1, var3)) {
            return false;
         } else {
            byte var4 = 11;
            if (!this.b) {
               var4 = 6;
            }

            this.a(var1, var3, 0, 0, 0, 13, var4 - 1, 14, true, var2, aqp.c());
            this.a(var1, var2, var3, this.d, 4, 1, 0);
            this.a(var1, var3, var2, 0.07F, 2, 1, 1, 11, 4, 13, afi.G.Q(), afi.G.Q(), false);
            boolean var5 = true;
            boolean var6 = true;

            int var7;
            for(var7 = 1; var7 <= 13; ++var7) {
               if ((var7 - 1) % 4 == 0) {
                  this.a(var1, var3, 1, 1, var7, 1, 4, var7, afi.f.Q(), afi.f.Q(), false);
                  this.a(var1, var3, 12, 1, var7, 12, 4, var7, afi.f.Q(), afi.f.Q(), false);
                  this.a(var1, afi.aa.Q(), 2, 3, var7, var3);
                  this.a(var1, afi.aa.Q(), 11, 3, var7, var3);
                  if (this.b) {
                     this.a(var1, var3, 1, 6, var7, 1, 9, var7, afi.f.Q(), afi.f.Q(), false);
                     this.a(var1, var3, 12, 6, var7, 12, 9, var7, afi.f.Q(), afi.f.Q(), false);
                  }
               } else {
                  this.a(var1, var3, 1, 1, var7, 1, 4, var7, afi.X.Q(), afi.X.Q(), false);
                  this.a(var1, var3, 12, 1, var7, 12, 4, var7, afi.X.Q(), afi.X.Q(), false);
                  if (this.b) {
                     this.a(var1, var3, 1, 6, var7, 1, 9, var7, afi.X.Q(), afi.X.Q(), false);
                     this.a(var1, var3, 12, 6, var7, 12, 9, var7, afi.X.Q(), afi.X.Q(), false);
                  }
               }
            }

            for(var7 = 3; var7 < 12; var7 += 2) {
               this.a(var1, var3, 3, 1, var7, 4, 3, var7, afi.X.Q(), afi.X.Q(), false);
               this.a(var1, var3, 6, 1, var7, 7, 3, var7, afi.X.Q(), afi.X.Q(), false);
               this.a(var1, var3, 9, 1, var7, 10, 3, var7, afi.X.Q(), afi.X.Q(), false);
            }

            if (this.b) {
               this.a(var1, var3, 1, 5, 1, 3, 5, 13, afi.f.Q(), afi.f.Q(), false);
               this.a(var1, var3, 10, 5, 1, 12, 5, 13, afi.f.Q(), afi.f.Q(), false);
               this.a(var1, var3, 4, 5, 1, 9, 5, 2, afi.f.Q(), afi.f.Q(), false);
               this.a(var1, var3, 4, 5, 12, 9, 5, 13, afi.f.Q(), afi.f.Q(), false);
               this.a(var1, afi.f.Q(), 9, 5, 11, var3);
               this.a(var1, afi.f.Q(), 8, 5, 11, var3);
               this.a(var1, afi.f.Q(), 9, 5, 10, var3);
               this.a(var1, var3, 3, 6, 2, 3, 6, 12, afi.aO.Q(), afi.aO.Q(), false);
               this.a(var1, var3, 10, 6, 2, 10, 6, 10, afi.aO.Q(), afi.aO.Q(), false);
               this.a(var1, var3, 4, 6, 2, 9, 6, 2, afi.aO.Q(), afi.aO.Q(), false);
               this.a(var1, var3, 4, 6, 12, 8, 6, 12, afi.aO.Q(), afi.aO.Q(), false);
               this.a(var1, afi.aO.Q(), 9, 6, 11, var3);
               this.a(var1, afi.aO.Q(), 8, 6, 11, var3);
               this.a(var1, afi.aO.Q(), 9, 6, 10, var3);
               var7 = this.a(afi.au, 3);
               this.a(var1, afi.au.a(var7), 10, 1, 13, var3);
               this.a(var1, afi.au.a(var7), 10, 2, 13, var3);
               this.a(var1, afi.au.a(var7), 10, 3, 13, var3);
               this.a(var1, afi.au.a(var7), 10, 4, 13, var3);
               this.a(var1, afi.au.a(var7), 10, 5, 13, var3);
               this.a(var1, afi.au.a(var7), 10, 6, 13, var3);
               this.a(var1, afi.au.a(var7), 10, 7, 13, var3);
               byte var8 = 7;
               byte var9 = 7;
               this.a(var1, afi.aO.Q(), var8 - 1, 9, var9, var3);
               this.a(var1, afi.aO.Q(), var8, 9, var9, var3);
               this.a(var1, afi.aO.Q(), var8 - 1, 8, var9, var3);
               this.a(var1, afi.aO.Q(), var8, 8, var9, var3);
               this.a(var1, afi.aO.Q(), var8 - 1, 7, var9, var3);
               this.a(var1, afi.aO.Q(), var8, 7, var9, var3);
               this.a(var1, afi.aO.Q(), var8 - 2, 7, var9, var3);
               this.a(var1, afi.aO.Q(), var8 + 1, 7, var9, var3);
               this.a(var1, afi.aO.Q(), var8 - 1, 7, var9 - 1, var3);
               this.a(var1, afi.aO.Q(), var8 - 1, 7, var9 + 1, var3);
               this.a(var1, afi.aO.Q(), var8, 7, var9 - 1, var3);
               this.a(var1, afi.aO.Q(), var8, 7, var9 + 1, var3);
               this.a(var1, afi.aa.Q(), var8 - 2, 8, var9, var3);
               this.a(var1, afi.aa.Q(), var8 + 1, 8, var9, var3);
               this.a(var1, afi.aa.Q(), var8 - 1, 8, var9 - 1, var3);
               this.a(var1, afi.aa.Q(), var8 - 1, 8, var9 + 1, var3);
               this.a(var1, afi.aa.Q(), var8, 8, var9 - 1, var3);
               this.a(var1, afi.aa.Q(), var8, 8, var9 + 1, var3);
            }

            this.a(var1, var3, var2, 3, 3, 5, ob.a(a, zy.cd.a(var2, 1, 5, 2)), 1 + var2.nextInt(4));
            if (this.b) {
               this.a(var1, afi.a.Q(), 12, 9, 1, var3);
               this.a(var1, var3, var2, 12, 8, 1, ob.a(a, zy.cd.a(var2, 1, 5, 2)), 1 + var2.nextInt(4));
            }

            return true;
         }
      }

      public e(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.d = this.a(var2);
         this.l = var3;
         this.b = var3.d() > 6;
      }
   }

   public static class m extends aqp.l {
      public aqp.g b;
      public aqp.f a;
      public List<aqt> c = Lists.newArrayList();

      public m(int var1, Random var2, int var3, int var4) {
         super(0, var2, var3, var4);
      }

      public m() {
      }

      public cj a() {
         return this.b != null ? this.b.a() : super.a();
      }
   }

   abstract static class p extends aqt {
      protected aqp.p.a d;

      protected aqt b(aqp.m var1, List<aqt> var2, Random var3, int var4, int var5) {
         if (this.m != null) {
            switch(this.m) {
            case c:
               return aqp.a(var1, var2, var3, this.l.a - 1, this.l.b + var4, this.l.c + var5, cq.e, this.d());
            case d:
               return aqp.a(var1, var2, var3, this.l.a - 1, this.l.b + var4, this.l.c + var5, cq.e, this.d());
            case e:
               return aqp.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.c - 1, cq.c, this.d());
            case f:
               return aqp.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.c - 1, cq.c, this.d());
            }
         }

         return null;
      }

      protected aqp.p.a a(Random var1) {
         int var2 = var1.nextInt(5);
         switch(var2) {
         case 0:
         case 1:
         default:
            return aqp.p.a.a;
         case 2:
            return aqp.p.a.b;
         case 3:
            return aqp.p.a.c;
         case 4:
            return aqp.p.a.d;
         }
      }

      protected static boolean a(aqe var0) {
         return var0 != null && var0.b > 10;
      }

      protected void b(dn var1) {
         this.d = aqp.p.a.valueOf(var1.j("EntryDoor"));
      }

      protected p(int var1) {
         super(var1);
         this.d = aqp.p.a.a;
      }

      protected aqt c(aqp.m var1, List<aqt> var2, Random var3, int var4, int var5) {
         if (this.m != null) {
            switch(this.m) {
            case c:
               return aqp.a(var1, var2, var3, this.l.d + 1, this.l.b + var4, this.l.c + var5, cq.f, this.d());
            case d:
               return aqp.a(var1, var2, var3, this.l.d + 1, this.l.b + var4, this.l.c + var5, cq.f, this.d());
            case e:
               return aqp.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.f + 1, cq.d, this.d());
            case f:
               return aqp.a(var1, var2, var3, this.l.a + var5, this.l.b + var4, this.l.f + 1, cq.d, this.d());
            }
         }

         return null;
      }

      public p() {
         this.d = aqp.p.a.a;
      }

      protected aqt a(aqp.m var1, List<aqt> var2, Random var3, int var4, int var5) {
         if (this.m != null) {
            switch(this.m) {
            case c:
               return aqp.a(var1, var2, var3, this.l.a + var4, this.l.b + var5, this.l.c - 1, this.m, this.d());
            case d:
               return aqp.a(var1, var2, var3, this.l.a + var4, this.l.b + var5, this.l.f + 1, this.m, this.d());
            case e:
               return aqp.a(var1, var2, var3, this.l.a - 1, this.l.b + var5, this.l.c + var4, this.m, this.d());
            case f:
               return aqp.a(var1, var2, var3, this.l.d + 1, this.l.b + var5, this.l.c + var4, this.m, this.d());
            }
         }

         return null;
      }

      protected void a(dn var1) {
         var1.a("EntryDoor", this.d.name());
      }

      protected void a(adm var1, Random var2, aqe var3, aqp.p.a var4, int var5, int var6, int var7) {
         switch(var4) {
         case a:
         default:
            this.a(var1, var3, var5, var6, var7, var5 + 3 - 1, var6 + 3 - 1, var7, afi.a.Q(), afi.a.Q(), false);
            break;
         case b:
            this.a(var1, afi.bf.Q(), var5, var6, var7, var3);
            this.a(var1, afi.bf.Q(), var5, var6 + 1, var7, var3);
            this.a(var1, afi.bf.Q(), var5, var6 + 2, var7, var3);
            this.a(var1, afi.bf.Q(), var5 + 1, var6 + 2, var7, var3);
            this.a(var1, afi.bf.Q(), var5 + 2, var6 + 2, var7, var3);
            this.a(var1, afi.bf.Q(), var5 + 2, var6 + 1, var7, var3);
            this.a(var1, afi.bf.Q(), var5 + 2, var6, var7, var3);
            this.a(var1, afi.ao.Q(), var5 + 1, var6, var7, var3);
            this.a(var1, afi.ao.a(8), var5 + 1, var6 + 1, var7, var3);
            break;
         case c:
            this.a(var1, afi.a.Q(), var5 + 1, var6, var7, var3);
            this.a(var1, afi.a.Q(), var5 + 1, var6 + 1, var7, var3);
            this.a(var1, afi.bi.Q(), var5, var6, var7, var3);
            this.a(var1, afi.bi.Q(), var5, var6 + 1, var7, var3);
            this.a(var1, afi.bi.Q(), var5, var6 + 2, var7, var3);
            this.a(var1, afi.bi.Q(), var5 + 1, var6 + 2, var7, var3);
            this.a(var1, afi.bi.Q(), var5 + 2, var6 + 2, var7, var3);
            this.a(var1, afi.bi.Q(), var5 + 2, var6 + 1, var7, var3);
            this.a(var1, afi.bi.Q(), var5 + 2, var6, var7, var3);
            break;
         case d:
            this.a(var1, afi.bf.Q(), var5, var6, var7, var3);
            this.a(var1, afi.bf.Q(), var5, var6 + 1, var7, var3);
            this.a(var1, afi.bf.Q(), var5, var6 + 2, var7, var3);
            this.a(var1, afi.bf.Q(), var5 + 1, var6 + 2, var7, var3);
            this.a(var1, afi.bf.Q(), var5 + 2, var6 + 2, var7, var3);
            this.a(var1, afi.bf.Q(), var5 + 2, var6 + 1, var7, var3);
            this.a(var1, afi.bf.Q(), var5 + 2, var6, var7, var3);
            this.a(var1, afi.aA.Q(), var5 + 1, var6, var7, var3);
            this.a(var1, afi.aA.a(8), var5 + 1, var6 + 1, var7, var3);
            this.a(var1, afi.aG.a(this.a(afi.aG, 4)), var5 + 2, var6 + 1, var7 + 1, var3);
            this.a(var1, afi.aG.a(this.a(afi.aG, 3)), var5 + 2, var6 + 1, var7 - 1, var3);
         }

      }

      public static enum a {
         b,
         a,
         c,
         d;

         private static final aqp.p.a[] e = new aqp.p.a[]{a, b, c, d};
      }
   }

   public static class j extends aqp.p {
      private static final List<ob> b;
      protected int a;

      public j(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.d = this.a(var2);
         this.l = var3;
         this.a = var2.nextInt(5);
      }

      public j() {
      }

      protected void a(dn var1) {
         super.a(var1);
         var1.a("Type", this.a);
      }

      static {
         b = Lists.newArrayList(new ob[]{new ob(zy.j, 0, 1, 5, 10), new ob(zy.k, 0, 1, 3, 5), new ob(zy.aC, 0, 4, 9, 5), new ob(zy.h, 0, 3, 8, 10), new ob(zy.P, 0, 1, 3, 15), new ob(zy.e, 0, 1, 3, 15), new ob(zy.b, 0, 1, 1, 1)});
      }

      protected void b(dn var1) {
         super.b(var1);
         this.a = var1.f("Type");
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         this.a((aqp.m)var1, var2, var3, 4, 1);
         this.b((aqp.m)var1, var2, var3, 1, 4);
         this.c((aqp.m)var1, var2, var3, 1, 4);
      }

      public static aqp.j a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
         aqe var7 = aqe.a(var2, var3, var4, -4, -1, 0, 11, 7, 11, var5);
         return a(var7) && aqt.a(var0, var7) == null ? new aqp.j(var6, var1, var7, var5) : null;
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.a(var1, var3)) {
            return false;
         } else {
            this.a(var1, var3, 0, 0, 0, 10, 6, 10, true, var2, aqp.c());
            this.a(var1, var2, var3, this.d, 4, 1, 0);
            this.a(var1, var3, 4, 1, 10, 6, 3, 10, afi.a.Q(), afi.a.Q(), false);
            this.a(var1, var3, 0, 1, 4, 0, 3, 6, afi.a.Q(), afi.a.Q(), false);
            this.a(var1, var3, 10, 1, 4, 10, 3, 6, afi.a.Q(), afi.a.Q(), false);
            int var4;
            switch(this.a) {
            case 0:
               this.a(var1, afi.bf.Q(), 5, 1, 5, var3);
               this.a(var1, afi.bf.Q(), 5, 2, 5, var3);
               this.a(var1, afi.bf.Q(), 5, 3, 5, var3);
               this.a(var1, afi.aa.Q(), 4, 3, 5, var3);
               this.a(var1, afi.aa.Q(), 6, 3, 5, var3);
               this.a(var1, afi.aa.Q(), 5, 3, 4, var3);
               this.a(var1, afi.aa.Q(), 5, 3, 6, var3);
               this.a(var1, afi.U.Q(), 4, 1, 4, var3);
               this.a(var1, afi.U.Q(), 4, 1, 5, var3);
               this.a(var1, afi.U.Q(), 4, 1, 6, var3);
               this.a(var1, afi.U.Q(), 6, 1, 4, var3);
               this.a(var1, afi.U.Q(), 6, 1, 5, var3);
               this.a(var1, afi.U.Q(), 6, 1, 6, var3);
               this.a(var1, afi.U.Q(), 5, 1, 4, var3);
               this.a(var1, afi.U.Q(), 5, 1, 6, var3);
               break;
            case 1:
               for(var4 = 0; var4 < 5; ++var4) {
                  this.a(var1, afi.bf.Q(), 3, 1, 3 + var4, var3);
                  this.a(var1, afi.bf.Q(), 7, 1, 3 + var4, var3);
                  this.a(var1, afi.bf.Q(), 3 + var4, 1, 3, var3);
                  this.a(var1, afi.bf.Q(), 3 + var4, 1, 7, var3);
               }

               this.a(var1, afi.bf.Q(), 5, 1, 5, var3);
               this.a(var1, afi.bf.Q(), 5, 2, 5, var3);
               this.a(var1, afi.bf.Q(), 5, 3, 5, var3);
               this.a(var1, afi.i.Q(), 5, 4, 5, var3);
               break;
            case 2:
               for(var4 = 1; var4 <= 9; ++var4) {
                  this.a(var1, afi.e.Q(), 1, 3, var4, var3);
                  this.a(var1, afi.e.Q(), 9, 3, var4, var3);
               }

               for(var4 = 1; var4 <= 9; ++var4) {
                  this.a(var1, afi.e.Q(), var4, 3, 1, var3);
                  this.a(var1, afi.e.Q(), var4, 3, 9, var3);
               }

               this.a(var1, afi.e.Q(), 5, 1, 4, var3);
               this.a(var1, afi.e.Q(), 5, 1, 6, var3);
               this.a(var1, afi.e.Q(), 5, 3, 4, var3);
               this.a(var1, afi.e.Q(), 5, 3, 6, var3);
               this.a(var1, afi.e.Q(), 4, 1, 5, var3);
               this.a(var1, afi.e.Q(), 6, 1, 5, var3);
               this.a(var1, afi.e.Q(), 4, 3, 5, var3);
               this.a(var1, afi.e.Q(), 6, 3, 5, var3);

               for(var4 = 1; var4 <= 3; ++var4) {
                  this.a(var1, afi.e.Q(), 4, var4, 4, var3);
                  this.a(var1, afi.e.Q(), 6, var4, 4, var3);
                  this.a(var1, afi.e.Q(), 4, var4, 6, var3);
                  this.a(var1, afi.e.Q(), 6, var4, 6, var3);
               }

               this.a(var1, afi.aa.Q(), 5, 3, 5, var3);

               for(var4 = 2; var4 <= 8; ++var4) {
                  this.a(var1, afi.f.Q(), 2, 3, var4, var3);
                  this.a(var1, afi.f.Q(), 3, 3, var4, var3);
                  if (var4 <= 3 || var4 >= 7) {
                     this.a(var1, afi.f.Q(), 4, 3, var4, var3);
                     this.a(var1, afi.f.Q(), 5, 3, var4, var3);
                     this.a(var1, afi.f.Q(), 6, 3, var4, var3);
                  }

                  this.a(var1, afi.f.Q(), 7, 3, var4, var3);
                  this.a(var1, afi.f.Q(), 8, 3, var4, var3);
               }

               this.a(var1, afi.au.a(this.a(afi.au, cq.e.a())), 9, 1, 3, var3);
               this.a(var1, afi.au.a(this.a(afi.au, cq.e.a())), 9, 2, 3, var3);
               this.a(var1, afi.au.a(this.a(afi.au, cq.e.a())), 9, 3, 3, var3);
               this.a(var1, var3, var2, 3, 4, 8, ob.a(b, zy.cd.b(var2)), 1 + var2.nextInt(4));
            }

            return true;
         }
      }
   }

   public static class d extends aqp.p {
      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.a(var1, var3)) {
            return false;
         } else {
            this.a(var1, var3, 0, 0, 0, 4, 4, 4, true, var2, aqp.c());
            this.a(var1, var2, var3, this.d, 1, 1, 0);
            if (this.m != cq.c && this.m != cq.f) {
               this.a(var1, var3, 4, 1, 1, 4, 3, 3, afi.a.Q(), afi.a.Q(), false);
            } else {
               this.a(var1, var3, 0, 1, 1, 0, 3, 3, afi.a.Q(), afi.a.Q(), false);
            }

            return true;
         }
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         if (this.m != cq.c && this.m != cq.f) {
            this.c((aqp.m)var1, var2, var3, 1, 1);
         } else {
            this.b((aqp.m)var1, var2, var3, 1, 1);
         }

      }

      public d() {
      }

      public static aqp.d a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
         aqe var7 = aqe.a(var2, var3, var4, -1, -1, 0, 5, 5, 5, var5);
         return a(var7) && aqt.a(var0, var7) == null ? new aqp.d(var6, var1, var7, var5) : null;
      }

      public d(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.d = this.a(var2);
         this.l = var3;
      }
   }

   public static class a extends aqp.p {
      private static final List<ob> a;
      private boolean b;

      public a(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.d = this.a(var2);
         this.l = var3;
      }

      protected void b(dn var1) {
         super.b(var1);
         this.b = var1.n("Chest");
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         this.a((aqp.m)var1, var2, var3, 1, 1);
      }

      static {
         a = Lists.newArrayList(new ob[]{new ob(zy.bu, 0, 1, 1, 10), new ob(zy.i, 0, 1, 3, 3), new ob(zy.j, 0, 1, 5, 10), new ob(zy.k, 0, 1, 3, 5), new ob(zy.aC, 0, 4, 9, 5), new ob(zy.P, 0, 1, 3, 15), new ob(zy.e, 0, 1, 3, 15), new ob(zy.b, 0, 1, 1, 5), new ob(zy.l, 0, 1, 1, 5), new ob(zy.Z, 0, 1, 1, 5), new ob(zy.Y, 0, 1, 1, 5), new ob(zy.aa, 0, 1, 1, 5), new ob(zy.ab, 0, 1, 1, 5), new ob(zy.ao, 0, 1, 1, 1), new ob(zy.aA, 0, 1, 1, 1), new ob(zy.ck, 0, 1, 1, 1), new ob(zy.cl, 0, 1, 1, 1), new ob(zy.cm, 0, 1, 1, 1)});
      }

      public a() {
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.a(var1, var3)) {
            return false;
         } else {
            this.a(var1, var3, 0, 0, 0, 4, 4, 6, true, var2, aqp.c());
            this.a(var1, var2, var3, this.d, 1, 1, 0);
            this.a(var1, var2, var3, aqp.p.a.a, 1, 1, 6);
            this.a(var1, var3, 3, 1, 2, 3, 1, 4, afi.bf.Q(), afi.bf.Q(), false);
            this.a(var1, afi.U.a(akb.a.f.a()), 3, 1, 1, var3);
            this.a(var1, afi.U.a(akb.a.f.a()), 3, 1, 5, var3);
            this.a(var1, afi.U.a(akb.a.f.a()), 3, 2, 2, var3);
            this.a(var1, afi.U.a(akb.a.f.a()), 3, 2, 4, var3);

            for(int var4 = 2; var4 <= 4; ++var4) {
               this.a(var1, afi.U.a(akb.a.f.a()), 2, 1, var4, var3);
            }

            if (!this.b && var3.b((df)(new cj(this.a(3, 3), this.d(2), this.b(3, 3))))) {
               this.b = true;
               this.a(var1, var3, var2, 3, 2, 3, ob.a(a, zy.cd.b(var2)), 2 + var2.nextInt(2));
            }

            return true;
         }
      }

      protected void a(dn var1) {
         super.a(var1);
         var1.a("Chest", this.b);
      }

      public static aqp.a a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
         aqe var7 = aqe.a(var2, var3, var4, -1, -1, 0, 5, 5, 7, var5);
         return a(var7) && aqt.a(var0, var7) == null ? new aqp.a(var6, var1, var7, var5) : null;
      }
   }

   public static class b extends aqp.p {
      private int a;

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.a(var1, var3)) {
            return false;
         } else {
            for(int var4 = 0; var4 < this.a; ++var4) {
               this.a(var1, afi.bf.Q(), 0, 0, var4, var3);
               this.a(var1, afi.bf.Q(), 1, 0, var4, var3);
               this.a(var1, afi.bf.Q(), 2, 0, var4, var3);
               this.a(var1, afi.bf.Q(), 3, 0, var4, var3);
               this.a(var1, afi.bf.Q(), 4, 0, var4, var3);

               for(int var5 = 1; var5 <= 3; ++var5) {
                  this.a(var1, afi.bf.Q(), 0, var5, var4, var3);
                  this.a(var1, afi.a.Q(), 1, var5, var4, var3);
                  this.a(var1, afi.a.Q(), 2, var5, var4, var3);
                  this.a(var1, afi.a.Q(), 3, var5, var4, var3);
                  this.a(var1, afi.bf.Q(), 4, var5, var4, var3);
               }

               this.a(var1, afi.bf.Q(), 0, 4, var4, var3);
               this.a(var1, afi.bf.Q(), 1, 4, var4, var3);
               this.a(var1, afi.bf.Q(), 2, 4, var4, var3);
               this.a(var1, afi.bf.Q(), 3, 4, var4, var3);
               this.a(var1, afi.bf.Q(), 4, 4, var4, var3);
            }

            return true;
         }
      }

      public b(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.l = var3;
         this.a = var4 != cq.c && var4 != cq.d ? var3.c() : var3.e();
      }

      public b() {
      }

      protected void a(dn var1) {
         super.a(var1);
         var1.a("Steps", this.a);
      }

      public static aqe a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5) {
         boolean var6 = true;
         aqe var7 = aqe.a(var2, var3, var4, -1, -1, 0, 5, 5, 4, var5);
         aqt var8 = aqt.a(var0, var7);
         if (var8 == null) {
            return null;
         } else {
            if (var8.c().b == var7.b) {
               for(int var9 = 3; var9 >= 1; --var9) {
                  var7 = aqe.a(var2, var3, var4, -1, -1, 0, 5, 5, var9 - 1, var5);
                  if (!var8.c().a(var7)) {
                     return aqe.a(var2, var3, var4, -1, -1, 0, 5, 5, var9, var5);
                  }
               }
            }

            return null;
         }
      }

      protected void b(dn var1) {
         super.b(var1);
         this.a = var1.f("Steps");
      }
   }
}
