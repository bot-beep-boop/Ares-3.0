import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class aqg {
   private static final List<ob> a;

   static {
      a = Lists.newArrayList(new ob[]{new ob(zy.j, 0, 1, 5, 10), new ob(zy.k, 0, 1, 3, 5), new ob(zy.aC, 0, 4, 9, 5), new ob(zy.aW, zd.l.b(), 4, 9, 5), new ob(zy.i, 0, 1, 2, 3), new ob(zy.h, 0, 3, 8, 10), new ob(zy.P, 0, 1, 3, 15), new ob(zy.b, 0, 1, 1, 1), new ob(zw.a(afi.av), 0, 4, 8, 1), new ob(zy.bh, 0, 2, 4, 10), new ob(zy.bg, 0, 2, 4, 10), new ob(zy.aA, 0, 1, 1, 3), new ob(zy.ck, 0, 1, 1, 1)});
   }

   private static aqt a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5, int var6) {
      int var7 = var1.nextInt(100);
      aqe var8;
      if (var7 >= 80) {
         var8 = aqg.b.a(var0, var1, var2, var3, var4, var5);
         if (var8 != null) {
            return new aqg.b(var6, var1, var8, var5);
         }
      } else if (var7 >= 70) {
         var8 = aqg.d.a(var0, var1, var2, var3, var4, var5);
         if (var8 != null) {
            return new aqg.d(var6, var1, var8, var5);
         }
      } else {
         var8 = aqg.a.a(var0, var1, var2, var3, var4, var5);
         if (var8 != null) {
            return new aqg.a(var6, var1, var8, var5);
         }
      }

      return null;
   }

   public static void a() {
      aqr.a(aqg.a.class, "MSCorridor");
      aqr.a(aqg.b.class, "MSCrossing");
      aqr.a(aqg.c.class, "MSRoom");
      aqr.a(aqg.d.class, "MSStairs");
   }

   private static aqt b(aqt var0, List<aqt> var1, Random var2, int var3, int var4, int var5, cq var6, int var7) {
      if (var7 > 8) {
         return null;
      } else if (Math.abs(var3 - var0.c().a) <= 80 && Math.abs(var5 - var0.c().c) <= 80) {
         aqt var8 = a(var1, var2, var3, var4, var5, var6, var7 + 1);
         if (var8 != null) {
            var1.add(var8);
            var8.a(var0, var1, var2);
         }

         return var8;
      } else {
         return null;
      }
   }

   static aqt a(aqt var0, List var1, Random var2, int var3, int var4, int var5, cq var6, int var7) {
      return b(var0, var1, var2, var3, var4, var5, var6, var7);
   }

   static List b() {
      return a;
   }

   public static class a extends aqt {
      private boolean b;
      private boolean a;
      private boolean c;
      private int d;

      public static aqe a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5) {
         aqe var6 = new aqe(var2, var3, var4, var2, var3 + 2, var4);

         int var7;
         for(var7 = var1.nextInt(3) + 2; var7 > 0; --var7) {
            int var8 = var7 * 5;
            switch(var5) {
            case c:
               var6.d = var2 + 2;
               var6.c = var4 - (var8 - 1);
               break;
            case d:
               var6.d = var2 + 2;
               var6.f = var4 + (var8 - 1);
               break;
            case e:
               var6.a = var2 - (var8 - 1);
               var6.f = var4 + 2;
               break;
            case f:
               var6.d = var2 + (var8 - 1);
               var6.f = var4 + 2;
            }

            if (aqt.a(var0, var6) == null) {
               break;
            }
         }

         return var7 > 0 ? var6 : null;
      }

      protected void b(dn var1) {
         this.a = var1.n("hr");
         this.b = var1.n("sc");
         this.c = var1.n("hps");
         this.d = var1.f("Num");
      }

      public a() {
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         int var4 = this.d();
         int var5 = var3.nextInt(4);
         if (this.m != null) {
            switch(this.m) {
            case c:
               if (var5 <= 1) {
                  aqg.a(var1, var2, var3, this.l.a, this.l.b - 1 + var3.nextInt(3), this.l.c - 1, this.m, var4);
               } else if (var5 == 2) {
                  aqg.a(var1, var2, var3, this.l.a - 1, this.l.b - 1 + var3.nextInt(3), this.l.c, cq.e, var4);
               } else {
                  aqg.a(var1, var2, var3, this.l.d + 1, this.l.b - 1 + var3.nextInt(3), this.l.c, cq.f, var4);
               }
               break;
            case d:
               if (var5 <= 1) {
                  aqg.a(var1, var2, var3, this.l.a, this.l.b - 1 + var3.nextInt(3), this.l.f + 1, this.m, var4);
               } else if (var5 == 2) {
                  aqg.a(var1, var2, var3, this.l.a - 1, this.l.b - 1 + var3.nextInt(3), this.l.f - 3, cq.e, var4);
               } else {
                  aqg.a(var1, var2, var3, this.l.d + 1, this.l.b - 1 + var3.nextInt(3), this.l.f - 3, cq.f, var4);
               }
               break;
            case e:
               if (var5 <= 1) {
                  aqg.a(var1, var2, var3, this.l.a - 1, this.l.b - 1 + var3.nextInt(3), this.l.c, this.m, var4);
               } else if (var5 == 2) {
                  aqg.a(var1, var2, var3, this.l.a, this.l.b - 1 + var3.nextInt(3), this.l.c - 1, cq.c, var4);
               } else {
                  aqg.a(var1, var2, var3, this.l.a, this.l.b - 1 + var3.nextInt(3), this.l.f + 1, cq.d, var4);
               }
               break;
            case f:
               if (var5 <= 1) {
                  aqg.a(var1, var2, var3, this.l.d + 1, this.l.b - 1 + var3.nextInt(3), this.l.c, this.m, var4);
               } else if (var5 == 2) {
                  aqg.a(var1, var2, var3, this.l.d - 3, this.l.b - 1 + var3.nextInt(3), this.l.c - 1, cq.c, var4);
               } else {
                  aqg.a(var1, var2, var3, this.l.d - 3, this.l.b - 1 + var3.nextInt(3), this.l.f + 1, cq.d, var4);
               }
            }
         }

         if (var4 < 8) {
            int var6;
            int var7;
            if (this.m != cq.c && this.m != cq.d) {
               for(var6 = this.l.a + 3; var6 + 3 <= this.l.d; var6 += 5) {
                  var7 = var3.nextInt(5);
                  if (var7 == 0) {
                     aqg.a(var1, var2, var3, var6, this.l.b, this.l.c - 1, cq.c, var4 + 1);
                  } else if (var7 == 1) {
                     aqg.a(var1, var2, var3, var6, this.l.b, this.l.f + 1, cq.d, var4 + 1);
                  }
               }
            } else {
               for(var6 = this.l.c + 3; var6 + 3 <= this.l.f; var6 += 5) {
                  var7 = var3.nextInt(5);
                  if (var7 == 0) {
                     aqg.a(var1, var2, var3, this.l.a - 1, this.l.b, var6, cq.e, var4 + 1);
                  } else if (var7 == 1) {
                     aqg.a(var1, var2, var3, this.l.d + 1, this.l.b, var6, cq.f, var4 + 1);
                  }
               }
            }
         }

      }

      protected boolean a(adm var1, aqe var2, Random var3, int var4, int var5, int var6, List<ob> var7, int var8) {
         cj var9 = new cj(this.a(var4, var6), this.d(var5), this.b(var4, var6));
         if (var2.b((df)var9) && var1.p(var9).c().t() == arm.a) {
            int var10 = var3.nextBoolean() ? 1 : 0;
            var1.a((cj)var9, (alz)afi.av.a(this.a(afi.av, var10)), 2);
            vb var11 = new vb(var1, (double)((float)var9.n() + 0.5F), (double)((float)var9.o() + 0.5F), (double)((float)var9.p() + 0.5F));
            ob.a(var3, var7, (og)var11, var8);
            var1.d((pk)var11);
            return true;
         } else {
            return false;
         }
      }

      protected void a(dn var1) {
         var1.a("hr", this.a);
         var1.a("sc", this.b);
         var1.a("hps", this.c);
         var1.a("Num", this.d);
      }

      public a(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.l = var3;
         this.a = var2.nextInt(3) == 0;
         this.b = !this.a && var2.nextInt(23) == 0;
         if (this.m != cq.c && this.m != cq.d) {
            this.d = var3.c() / 5;
         } else {
            this.d = var3.e() / 5;
         }

      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.a(var1, var3)) {
            return false;
         } else {
            boolean var4 = false;
            boolean var5 = true;
            boolean var6 = false;
            boolean var7 = true;
            int var8 = this.d * 5 - 1;
            this.a(var1, var3, 0, 0, 0, 2, 1, var8, afi.a.Q(), afi.a.Q(), false);
            this.a(var1, var3, var2, 0.8F, 0, 2, 0, 2, 2, var8, afi.a.Q(), afi.a.Q(), false);
            if (this.b) {
               this.a(var1, var3, var2, 0.6F, 0, 0, 0, 2, 1, var8, afi.G.Q(), afi.a.Q(), false);
            }

            int var9;
            int var10;
            for(var9 = 0; var9 < this.d; ++var9) {
               var10 = 2 + var9 * 5;
               this.a(var1, var3, 0, 0, var10, 0, 1, var10, afi.aO.Q(), afi.a.Q(), false);
               this.a(var1, var3, 2, 0, var10, 2, 1, var10, afi.aO.Q(), afi.a.Q(), false);
               if (var2.nextInt(4) == 0) {
                  this.a(var1, var3, 0, 2, var10, 0, 2, var10, afi.f.Q(), afi.a.Q(), false);
                  this.a(var1, var3, 2, 2, var10, 2, 2, var10, afi.f.Q(), afi.a.Q(), false);
               } else {
                  this.a(var1, var3, 0, 2, var10, 2, 2, var10, afi.f.Q(), afi.a.Q(), false);
               }

               this.a(var1, var3, var2, 0.1F, 0, 2, var10 - 1, afi.G.Q());
               this.a(var1, var3, var2, 0.1F, 2, 2, var10 - 1, afi.G.Q());
               this.a(var1, var3, var2, 0.1F, 0, 2, var10 + 1, afi.G.Q());
               this.a(var1, var3, var2, 0.1F, 2, 2, var10 + 1, afi.G.Q());
               this.a(var1, var3, var2, 0.05F, 0, 2, var10 - 2, afi.G.Q());
               this.a(var1, var3, var2, 0.05F, 2, 2, var10 - 2, afi.G.Q());
               this.a(var1, var3, var2, 0.05F, 0, 2, var10 + 2, afi.G.Q());
               this.a(var1, var3, var2, 0.05F, 2, 2, var10 + 2, afi.G.Q());
               this.a(var1, var3, var2, 0.05F, 1, 2, var10 - 1, afi.aa.a(cq.b.a()));
               this.a(var1, var3, var2, 0.05F, 1, 2, var10 + 1, afi.aa.a(cq.b.a()));
               if (var2.nextInt(100) == 0) {
                  this.a(var1, var3, var2, 2, 0, var10 - 1, ob.a(aqg.b(), zy.cd.b(var2)), 3 + var2.nextInt(4));
               }

               if (var2.nextInt(100) == 0) {
                  this.a(var1, var3, var2, 0, 0, var10 + 1, ob.a(aqg.b(), zy.cd.b(var2)), 3 + var2.nextInt(4));
               }

               if (this.b && !this.c) {
                  int var11 = this.d(0);
                  int var12 = var10 - 1 + var2.nextInt(3);
                  int var13 = this.a(1, var12);
                  var12 = this.b(1, var12);
                  cj var14 = new cj(var13, var11, var12);
                  if (var3.b((df)var14)) {
                     this.c = true;
                     var1.a((cj)var14, (alz)afi.ac.Q(), 2);
                     akw var15 = var1.s(var14);
                     if (var15 instanceof all) {
                        ((all)var15).b().a("CaveSpider");
                     }
                  }
               }
            }

            for(var9 = 0; var9 <= 2; ++var9) {
               for(var10 = 0; var10 <= var8; ++var10) {
                  byte var17 = -1;
                  alz var18 = this.a(var1, var9, var17, var10, var3);
                  if (var18.c().t() == arm.a) {
                     byte var19 = -1;
                     this.a(var1, afi.f.Q(), var9, var19, var10, var3);
                  }
               }
            }

            if (this.a) {
               for(var9 = 0; var9 <= var8; ++var9) {
                  alz var16 = this.a(var1, 1, -1, var9, var3);
                  if (var16.c().t() != arm.a && var16.c().o()) {
                     this.a(var1, var3, var2, 0.7F, 1, 0, var9, afi.av.a(this.a(afi.av, 0)));
                  }
               }
            }

            return true;
         }
      }
   }

   public static class c extends aqt {
      private List<aqe> a = Lists.newLinkedList();

      public c(int var1, Random var2, int var3, int var4) {
         super(var1);
         this.l = new aqe(var3, 50, var4, var3 + 7 + var2.nextInt(6), 54 + var2.nextInt(6), var4 + 7 + var2.nextInt(6));
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         int var4 = this.d();
         int var6 = this.l.d() - 3 - 1;
         if (var6 <= 0) {
            var6 = 1;
         }

         int var5;
         aqt var7;
         aqe var8;
         for(var5 = 0; var5 < this.l.c(); var5 += 4) {
            var5 += var3.nextInt(this.l.c());
            if (var5 + 3 > this.l.c()) {
               break;
            }

            var7 = aqg.a(var1, var2, var3, this.l.a + var5, this.l.b + var3.nextInt(var6) + 1, this.l.c - 1, cq.c, var4);
            if (var7 != null) {
               var8 = var7.c();
               this.a.add(new aqe(var8.a, var8.b, this.l.c, var8.d, var8.e, this.l.c + 1));
            }
         }

         for(var5 = 0; var5 < this.l.c(); var5 += 4) {
            var5 += var3.nextInt(this.l.c());
            if (var5 + 3 > this.l.c()) {
               break;
            }

            var7 = aqg.a(var1, var2, var3, this.l.a + var5, this.l.b + var3.nextInt(var6) + 1, this.l.f + 1, cq.d, var4);
            if (var7 != null) {
               var8 = var7.c();
               this.a.add(new aqe(var8.a, var8.b, this.l.f - 1, var8.d, var8.e, this.l.f));
            }
         }

         for(var5 = 0; var5 < this.l.e(); var5 += 4) {
            var5 += var3.nextInt(this.l.e());
            if (var5 + 3 > this.l.e()) {
               break;
            }

            var7 = aqg.a(var1, var2, var3, this.l.a - 1, this.l.b + var3.nextInt(var6) + 1, this.l.c + var5, cq.e, var4);
            if (var7 != null) {
               var8 = var7.c();
               this.a.add(new aqe(this.l.a, var8.b, var8.c, this.l.a + 1, var8.e, var8.f));
            }
         }

         for(var5 = 0; var5 < this.l.e(); var5 += 4) {
            var5 += var3.nextInt(this.l.e());
            if (var5 + 3 > this.l.e()) {
               break;
            }

            var7 = aqg.a(var1, var2, var3, this.l.d + 1, this.l.b + var3.nextInt(var6) + 1, this.l.c + var5, cq.f, var4);
            if (var7 != null) {
               var8 = var7.c();
               this.a.add(new aqe(this.l.d - 1, var8.b, var8.c, this.l.d, var8.e, var8.f));
            }
         }

      }

      public c() {
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.a(var1, var3)) {
            return false;
         } else {
            this.a(var1, var3, this.l.a, this.l.b, this.l.c, this.l.d, this.l.b, this.l.f, afi.d.Q(), afi.a.Q(), true);
            this.a(var1, var3, this.l.a, this.l.b + 1, this.l.c, this.l.d, Math.min(this.l.b + 3, this.l.e), this.l.f, afi.a.Q(), afi.a.Q(), false);
            Iterator var4 = this.a.iterator();

            while(var4.hasNext()) {
               aqe var5 = (aqe)var4.next();
               this.a(var1, var3, var5.a, var5.e - 2, var5.c, var5.d, var5.e, var5.f, afi.a.Q(), afi.a.Q(), false);
            }

            this.a(var1, var3, this.l.a, this.l.b + 4, this.l.c, this.l.d, this.l.e, this.l.f, afi.a.Q(), false);
            return true;
         }
      }

      protected void a(dn var1) {
         du var2 = new du();
         Iterator var3 = this.a.iterator();

         while(var3.hasNext()) {
            aqe var4 = (aqe)var3.next();
            var2.a((eb)var4.g());
         }

         var1.a((String)"Entrances", (eb)var2);
      }

      protected void b(dn var1) {
         du var2 = var1.c("Entrances", 11);

         for(int var3 = 0; var3 < var2.c(); ++var3) {
            this.a.add(new aqe(var2.c(var3)));
         }

      }

      public void a(int var1, int var2, int var3) {
         super.a(var1, var2, var3);
         Iterator var4 = this.a.iterator();

         while(var4.hasNext()) {
            aqe var5 = (aqe)var4.next();
            var5.a(var1, var2, var3);
         }

      }
   }

   public static class d extends aqt {
      protected void b(dn var1) {
      }

      public d() {
      }

      public static aqe a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5) {
         aqe var6 = new aqe(var2, var3 - 5, var4, var2, var3 + 2, var4);
         switch(var5) {
         case c:
            var6.d = var2 + 2;
            var6.c = var4 - 8;
            break;
         case d:
            var6.d = var2 + 2;
            var6.f = var4 + 8;
            break;
         case e:
            var6.a = var2 - 8;
            var6.f = var4 + 2;
            break;
         case f:
            var6.d = var2 + 8;
            var6.f = var4 + 2;
         }

         return aqt.a(var0, var6) != null ? null : var6;
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.a(var1, var3)) {
            return false;
         } else {
            this.a(var1, var3, 0, 5, 0, 2, 7, 1, afi.a.Q(), afi.a.Q(), false);
            this.a(var1, var3, 0, 0, 7, 2, 2, 8, afi.a.Q(), afi.a.Q(), false);

            for(int var4 = 0; var4 < 5; ++var4) {
               this.a(var1, var3, 0, 5 - var4 - (var4 < 4 ? 1 : 0), 2 + var4, 2, 7 - var4, 2 + var4, afi.a.Q(), afi.a.Q(), false);
            }

            return true;
         }
      }

      protected void a(dn var1) {
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         int var4 = this.d();
         if (this.m != null) {
            switch(this.m) {
            case c:
               aqg.a(var1, var2, var3, this.l.a, this.l.b, this.l.c - 1, cq.c, var4);
               break;
            case d:
               aqg.a(var1, var2, var3, this.l.a, this.l.b, this.l.f + 1, cq.d, var4);
               break;
            case e:
               aqg.a(var1, var2, var3, this.l.a - 1, this.l.b, this.l.c, cq.e, var4);
               break;
            case f:
               aqg.a(var1, var2, var3, this.l.d + 1, this.l.b, this.l.c, cq.f, var4);
            }
         }

      }

      public d(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.m = var4;
         this.l = var3;
      }
   }

   public static class b extends aqt {
      private cq a;
      private boolean b;

      protected void a(dn var1) {
         var1.a("tf", this.b);
         var1.a("D", this.a.b());
      }

      public static aqe a(List<aqt> var0, Random var1, int var2, int var3, int var4, cq var5) {
         aqe var6 = new aqe(var2, var3, var4, var2, var3 + 2, var4);
         if (var1.nextInt(4) == 0) {
            var6.e += 4;
         }

         switch(var5) {
         case c:
            var6.a = var2 - 1;
            var6.d = var2 + 3;
            var6.c = var4 - 4;
            break;
         case d:
            var6.a = var2 - 1;
            var6.d = var2 + 3;
            var6.f = var4 + 4;
            break;
         case e:
            var6.a = var2 - 4;
            var6.c = var4 - 1;
            var6.f = var4 + 3;
            break;
         case f:
            var6.d = var2 + 4;
            var6.c = var4 - 1;
            var6.f = var4 + 3;
         }

         return aqt.a(var0, var6) != null ? null : var6;
      }

      public b() {
      }

      public b(int var1, Random var2, aqe var3, cq var4) {
         super(var1);
         this.a = var4;
         this.l = var3;
         this.b = var3.d() > 3;
      }

      protected void b(dn var1) {
         this.b = var1.n("tf");
         this.a = cq.b(var1.f("D"));
      }

      public void a(aqt var1, List<aqt> var2, Random var3) {
         int var4 = this.d();
         switch(this.a) {
         case c:
            aqg.a(var1, var2, var3, this.l.a + 1, this.l.b, this.l.c - 1, cq.c, var4);
            aqg.a(var1, var2, var3, this.l.a - 1, this.l.b, this.l.c + 1, cq.e, var4);
            aqg.a(var1, var2, var3, this.l.d + 1, this.l.b, this.l.c + 1, cq.f, var4);
            break;
         case d:
            aqg.a(var1, var2, var3, this.l.a + 1, this.l.b, this.l.f + 1, cq.d, var4);
            aqg.a(var1, var2, var3, this.l.a - 1, this.l.b, this.l.c + 1, cq.e, var4);
            aqg.a(var1, var2, var3, this.l.d + 1, this.l.b, this.l.c + 1, cq.f, var4);
            break;
         case e:
            aqg.a(var1, var2, var3, this.l.a + 1, this.l.b, this.l.c - 1, cq.c, var4);
            aqg.a(var1, var2, var3, this.l.a + 1, this.l.b, this.l.f + 1, cq.d, var4);
            aqg.a(var1, var2, var3, this.l.a - 1, this.l.b, this.l.c + 1, cq.e, var4);
            break;
         case f:
            aqg.a(var1, var2, var3, this.l.a + 1, this.l.b, this.l.c - 1, cq.c, var4);
            aqg.a(var1, var2, var3, this.l.a + 1, this.l.b, this.l.f + 1, cq.d, var4);
            aqg.a(var1, var2, var3, this.l.d + 1, this.l.b, this.l.c + 1, cq.f, var4);
         }

         if (this.b) {
            if (var3.nextBoolean()) {
               aqg.a(var1, var2, var3, this.l.a + 1, this.l.b + 3 + 1, this.l.c - 1, cq.c, var4);
            }

            if (var3.nextBoolean()) {
               aqg.a(var1, var2, var3, this.l.a - 1, this.l.b + 3 + 1, this.l.c + 1, cq.e, var4);
            }

            if (var3.nextBoolean()) {
               aqg.a(var1, var2, var3, this.l.d + 1, this.l.b + 3 + 1, this.l.c + 1, cq.f, var4);
            }

            if (var3.nextBoolean()) {
               aqg.a(var1, var2, var3, this.l.a + 1, this.l.b + 3 + 1, this.l.f + 1, cq.d, var4);
            }
         }

      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (this.a(var1, var3)) {
            return false;
         } else {
            if (this.b) {
               this.a(var1, var3, this.l.a + 1, this.l.b, this.l.c, this.l.d - 1, this.l.b + 3 - 1, this.l.f, afi.a.Q(), afi.a.Q(), false);
               this.a(var1, var3, this.l.a, this.l.b, this.l.c + 1, this.l.d, this.l.b + 3 - 1, this.l.f - 1, afi.a.Q(), afi.a.Q(), false);
               this.a(var1, var3, this.l.a + 1, this.l.e - 2, this.l.c, this.l.d - 1, this.l.e, this.l.f, afi.a.Q(), afi.a.Q(), false);
               this.a(var1, var3, this.l.a, this.l.e - 2, this.l.c + 1, this.l.d, this.l.e, this.l.f - 1, afi.a.Q(), afi.a.Q(), false);
               this.a(var1, var3, this.l.a + 1, this.l.b + 3, this.l.c + 1, this.l.d - 1, this.l.b + 3, this.l.f - 1, afi.a.Q(), afi.a.Q(), false);
            } else {
               this.a(var1, var3, this.l.a + 1, this.l.b, this.l.c, this.l.d - 1, this.l.e, this.l.f, afi.a.Q(), afi.a.Q(), false);
               this.a(var1, var3, this.l.a, this.l.b, this.l.c + 1, this.l.d, this.l.e, this.l.f - 1, afi.a.Q(), afi.a.Q(), false);
            }

            this.a(var1, var3, this.l.a + 1, this.l.b, this.l.c + 1, this.l.a + 1, this.l.e, this.l.c + 1, afi.f.Q(), afi.a.Q(), false);
            this.a(var1, var3, this.l.a + 1, this.l.b, this.l.f - 1, this.l.a + 1, this.l.e, this.l.f - 1, afi.f.Q(), afi.a.Q(), false);
            this.a(var1, var3, this.l.d - 1, this.l.b, this.l.c + 1, this.l.d - 1, this.l.e, this.l.c + 1, afi.f.Q(), afi.a.Q(), false);
            this.a(var1, var3, this.l.d - 1, this.l.b, this.l.f - 1, this.l.d - 1, this.l.e, this.l.f - 1, afi.f.Q(), afi.a.Q(), false);

            for(int var4 = this.l.a; var4 <= this.l.d; ++var4) {
               for(int var5 = this.l.c; var5 <= this.l.f; ++var5) {
                  if (this.a(var1, var4, this.l.b - 1, var5, var3).c().t() == arm.a) {
                     this.a(var1, afi.f.Q(), var4, this.l.b - 1, var5, var3);
                  }
               }
            }

            return true;
         }
      }
   }
}
