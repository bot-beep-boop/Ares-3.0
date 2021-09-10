import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class aqn {
   public static void a() {
      aqr.a(aqn.a.class, "TeDP");
      aqr.a(aqn.b.class, "TeJP");
      aqr.a(aqn.d.class, "TeSH");
   }

   public static class b extends aqn.c {
      private boolean g;
      private boolean h;
      private static final List<ob> j;
      private static aqn.b.a k;
      private boolean e;
      private boolean f;
      private static final List<ob> i;

      public b() {
      }

      static {
         i = Lists.newArrayList(new ob[]{new ob(zy.i, 0, 1, 3, 3), new ob(zy.j, 0, 1, 5, 10), new ob(zy.k, 0, 2, 7, 15), new ob(zy.bO, 0, 1, 3, 2), new ob(zy.aX, 0, 4, 6, 20), new ob(zy.bt, 0, 3, 7, 16), new ob(zy.aA, 0, 1, 1, 3), new ob(zy.ck, 0, 1, 1, 1), new ob(zy.cl, 0, 1, 1, 1), new ob(zy.cm, 0, 1, 1, 1)});
         j = Lists.newArrayList(new ob[]{new ob(zy.g, 0, 2, 7, 30)});
         k = new aqn.b.a();
      }

      protected void b(dn var1) {
         super.b(var1);
         this.e = var1.n("placedMainChest");
         this.f = var1.n("placedHiddenChest");
         this.g = var1.n("placedTrap1");
         this.h = var1.n("placedTrap2");
      }

      protected void a(dn var1) {
         super.a(var1);
         var1.a("placedMainChest", this.e);
         var1.a("placedHiddenChest", this.f);
         var1.a("placedTrap1", this.g);
         var1.a("placedTrap2", this.h);
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (!this.a(var1, var3, 0)) {
            return false;
         } else {
            int var4 = this.a(afi.aw, 3);
            int var5 = this.a(afi.aw, 2);
            int var6 = this.a(afi.aw, 0);
            int var7 = this.a(afi.aw, 1);
            this.a(var1, var3, 0, -4, 0, this.a - 1, 0, this.c - 1, false, var2, k);
            this.a(var1, var3, 2, 1, 2, 9, 2, 2, false, var2, k);
            this.a(var1, var3, 2, 1, 12, 9, 2, 12, false, var2, k);
            this.a(var1, var3, 2, 1, 3, 2, 2, 11, false, var2, k);
            this.a(var1, var3, 9, 1, 3, 9, 2, 11, false, var2, k);
            this.a(var1, var3, 1, 3, 1, 10, 6, 1, false, var2, k);
            this.a(var1, var3, 1, 3, 13, 10, 6, 13, false, var2, k);
            this.a(var1, var3, 1, 3, 2, 1, 6, 12, false, var2, k);
            this.a(var1, var3, 10, 3, 2, 10, 6, 12, false, var2, k);
            this.a(var1, var3, 2, 3, 2, 9, 3, 12, false, var2, k);
            this.a(var1, var3, 2, 6, 2, 9, 6, 12, false, var2, k);
            this.a(var1, var3, 3, 7, 3, 8, 7, 11, false, var2, k);
            this.a(var1, var3, 4, 8, 4, 7, 8, 10, false, var2, k);
            this.a(var1, var3, 3, 1, 3, 8, 2, 11);
            this.a(var1, var3, 4, 3, 6, 7, 3, 9);
            this.a(var1, var3, 2, 4, 2, 9, 5, 12);
            this.a(var1, var3, 4, 6, 5, 7, 6, 9);
            this.a(var1, var3, 5, 7, 6, 6, 7, 8);
            this.a(var1, var3, 5, 1, 2, 6, 2, 2);
            this.a(var1, var3, 5, 2, 12, 6, 2, 12);
            this.a(var1, var3, 5, 5, 1, 6, 5, 1);
            this.a(var1, var3, 5, 5, 13, 6, 5, 13);
            this.a(var1, afi.a.Q(), 1, 5, 5, var3);
            this.a(var1, afi.a.Q(), 10, 5, 5, var3);
            this.a(var1, afi.a.Q(), 1, 5, 9, var3);
            this.a(var1, afi.a.Q(), 10, 5, 9, var3);

            int var8;
            for(var8 = 0; var8 <= 14; var8 += 14) {
               this.a(var1, var3, 2, 4, var8, 2, 5, var8, false, var2, k);
               this.a(var1, var3, 4, 4, var8, 4, 5, var8, false, var2, k);
               this.a(var1, var3, 7, 4, var8, 7, 5, var8, false, var2, k);
               this.a(var1, var3, 9, 4, var8, 9, 5, var8, false, var2, k);
            }

            this.a(var1, var3, 5, 6, 0, 6, 6, 0, false, var2, k);

            for(var8 = 0; var8 <= 11; var8 += 11) {
               for(int var9 = 2; var9 <= 12; var9 += 2) {
                  this.a(var1, var3, var8, 4, var9, var8, 5, var9, false, var2, k);
               }

               this.a(var1, var3, var8, 6, 5, var8, 6, 5, false, var2, k);
               this.a(var1, var3, var8, 6, 9, var8, 6, 9, false, var2, k);
            }

            this.a(var1, var3, 2, 7, 2, 2, 9, 2, false, var2, k);
            this.a(var1, var3, 9, 7, 2, 9, 9, 2, false, var2, k);
            this.a(var1, var3, 2, 7, 12, 2, 9, 12, false, var2, k);
            this.a(var1, var3, 9, 7, 12, 9, 9, 12, false, var2, k);
            this.a(var1, var3, 4, 9, 4, 4, 9, 4, false, var2, k);
            this.a(var1, var3, 7, 9, 4, 7, 9, 4, false, var2, k);
            this.a(var1, var3, 4, 9, 10, 4, 9, 10, false, var2, k);
            this.a(var1, var3, 7, 9, 10, 7, 9, 10, false, var2, k);
            this.a(var1, var3, 5, 9, 7, 6, 9, 7, false, var2, k);
            this.a(var1, afi.aw.a(var4), 5, 9, 6, var3);
            this.a(var1, afi.aw.a(var4), 6, 9, 6, var3);
            this.a(var1, afi.aw.a(var5), 5, 9, 8, var3);
            this.a(var1, afi.aw.a(var5), 6, 9, 8, var3);
            this.a(var1, afi.aw.a(var4), 4, 0, 0, var3);
            this.a(var1, afi.aw.a(var4), 5, 0, 0, var3);
            this.a(var1, afi.aw.a(var4), 6, 0, 0, var3);
            this.a(var1, afi.aw.a(var4), 7, 0, 0, var3);
            this.a(var1, afi.aw.a(var4), 4, 1, 8, var3);
            this.a(var1, afi.aw.a(var4), 4, 2, 9, var3);
            this.a(var1, afi.aw.a(var4), 4, 3, 10, var3);
            this.a(var1, afi.aw.a(var4), 7, 1, 8, var3);
            this.a(var1, afi.aw.a(var4), 7, 2, 9, var3);
            this.a(var1, afi.aw.a(var4), 7, 3, 10, var3);
            this.a(var1, var3, 4, 1, 9, 4, 1, 9, false, var2, k);
            this.a(var1, var3, 7, 1, 9, 7, 1, 9, false, var2, k);
            this.a(var1, var3, 4, 1, 10, 7, 2, 10, false, var2, k);
            this.a(var1, var3, 5, 4, 5, 6, 4, 5, false, var2, k);
            this.a(var1, afi.aw.a(var6), 4, 4, 5, var3);
            this.a(var1, afi.aw.a(var7), 7, 4, 5, var3);

            for(var8 = 0; var8 < 4; ++var8) {
               this.a(var1, afi.aw.a(var5), 5, 0 - var8, 6 + var8, var3);
               this.a(var1, afi.aw.a(var5), 6, 0 - var8, 6 + var8, var3);
               this.a(var1, var3, 5, 0 - var8, 7 + var8, 6, 0 - var8, 9 + var8);
            }

            this.a(var1, var3, 1, -3, 12, 10, -1, 13);
            this.a(var1, var3, 1, -3, 1, 3, -1, 13);
            this.a(var1, var3, 1, -3, 1, 9, -1, 5);

            for(var8 = 1; var8 <= 13; var8 += 2) {
               this.a(var1, var3, 1, -3, var8, 1, -2, var8, false, var2, k);
            }

            for(var8 = 2; var8 <= 12; var8 += 2) {
               this.a(var1, var3, 1, -1, var8, 3, -1, var8, false, var2, k);
            }

            this.a(var1, var3, 2, -2, 1, 5, -2, 1, false, var2, k);
            this.a(var1, var3, 7, -2, 1, 9, -2, 1, false, var2, k);
            this.a(var1, var3, 6, -3, 1, 6, -3, 1, false, var2, k);
            this.a(var1, var3, 6, -1, 1, 6, -1, 1, false, var2, k);
            this.a(var1, afi.bR.a(this.a(afi.bR, cq.f.b())).a(akj.N, true), 1, -3, 8, var3);
            this.a(var1, afi.bR.a(this.a(afi.bR, cq.e.b())).a(akj.N, true), 4, -3, 8, var3);
            this.a(var1, afi.bS.Q().a(aki.N, true), 2, -3, 8, var3);
            this.a(var1, afi.bS.Q().a(aki.N, true), 3, -3, 8, var3);
            this.a(var1, afi.af.Q(), 5, -3, 7, var3);
            this.a(var1, afi.af.Q(), 5, -3, 6, var3);
            this.a(var1, afi.af.Q(), 5, -3, 5, var3);
            this.a(var1, afi.af.Q(), 5, -3, 4, var3);
            this.a(var1, afi.af.Q(), 5, -3, 3, var3);
            this.a(var1, afi.af.Q(), 5, -3, 2, var3);
            this.a(var1, afi.af.Q(), 5, -3, 1, var3);
            this.a(var1, afi.af.Q(), 4, -3, 1, var3);
            this.a(var1, afi.Y.Q(), 3, -3, 1, var3);
            if (!this.g) {
               this.g = this.a(var1, var3, var2, 3, -2, 1, cq.c.a(), j, 2);
            }

            this.a(var1, afi.bn.a(15), 3, -2, 2, var3);
            this.a(var1, afi.bR.a(this.a(afi.bR, cq.c.b())).a(akj.N, true), 7, -3, 1, var3);
            this.a(var1, afi.bR.a(this.a(afi.bR, cq.d.b())).a(akj.N, true), 7, -3, 5, var3);
            this.a(var1, afi.bS.Q().a(aki.N, true), 7, -3, 2, var3);
            this.a(var1, afi.bS.Q().a(aki.N, true), 7, -3, 3, var3);
            this.a(var1, afi.bS.Q().a(aki.N, true), 7, -3, 4, var3);
            this.a(var1, afi.af.Q(), 8, -3, 6, var3);
            this.a(var1, afi.af.Q(), 9, -3, 6, var3);
            this.a(var1, afi.af.Q(), 9, -3, 5, var3);
            this.a(var1, afi.Y.Q(), 9, -3, 4, var3);
            this.a(var1, afi.af.Q(), 9, -2, 4, var3);
            if (!this.h) {
               this.h = this.a(var1, var3, var2, 9, -2, 3, cq.e.a(), j, 2);
            }

            this.a(var1, afi.bn.a(15), 8, -1, 3, var3);
            this.a(var1, afi.bn.a(15), 8, -2, 3, var3);
            if (!this.e) {
               this.e = this.a(var1, var3, var2, 8, -3, 3, ob.a(i, zy.cd.b(var2)), 2 + var2.nextInt(5));
            }

            this.a(var1, afi.Y.Q(), 9, -3, 2, var3);
            this.a(var1, afi.Y.Q(), 8, -3, 1, var3);
            this.a(var1, afi.Y.Q(), 4, -3, 5, var3);
            this.a(var1, afi.Y.Q(), 5, -2, 5, var3);
            this.a(var1, afi.Y.Q(), 5, -1, 5, var3);
            this.a(var1, afi.Y.Q(), 6, -3, 5, var3);
            this.a(var1, afi.Y.Q(), 7, -2, 5, var3);
            this.a(var1, afi.Y.Q(), 7, -1, 5, var3);
            this.a(var1, afi.Y.Q(), 8, -3, 5, var3);
            this.a(var1, var3, 9, -1, 1, 9, -1, 5, false, var2, k);
            this.a(var1, var3, 8, -3, 8, 10, -1, 10);
            this.a(var1, afi.bf.a(ajz.P), 8, -2, 11, var3);
            this.a(var1, afi.bf.a(ajz.P), 9, -2, 11, var3);
            this.a(var1, afi.bf.a(ajz.P), 10, -2, 11, var3);
            this.a(var1, afi.ay.a(ahu.a(cq.a(this.a(afi.ay, cq.c.a())))), 8, -2, 12, var3);
            this.a(var1, afi.ay.a(ahu.a(cq.a(this.a(afi.ay, cq.c.a())))), 9, -2, 12, var3);
            this.a(var1, afi.ay.a(ahu.a(cq.a(this.a(afi.ay, cq.c.a())))), 10, -2, 12, var3);
            this.a(var1, var3, 8, -3, 8, 8, -3, 10, false, var2, k);
            this.a(var1, var3, 10, -3, 8, 10, -3, 10, false, var2, k);
            this.a(var1, afi.Y.Q(), 10, -2, 9, var3);
            this.a(var1, afi.af.Q(), 8, -2, 9, var3);
            this.a(var1, afi.af.Q(), 8, -2, 10, var3);
            this.a(var1, afi.af.Q(), 10, -1, 9, var3);
            this.a(var1, afi.F.a(cq.b.a()), 9, -2, 8, var3);
            this.a(var1, afi.F.a(this.a(afi.F, cq.e.a())), 10, -2, 8, var3);
            this.a(var1, afi.F.a(this.a(afi.F, cq.e.a())), 10, -1, 8, var3);
            this.a(var1, afi.bb.a(this.a(afi.bb, cq.c.b())), 10, -2, 10, var3);
            if (!this.f) {
               this.f = this.a(var1, var3, var2, 9, -3, 10, ob.a(i, zy.cd.b(var2)), 2 + var2.nextInt(5));
            }

            return true;
         }
      }

      public b(Random var1, int var2, int var3) {
         super(var1, var2, 64, var3, 12, 10, 15);
      }

      static class a extends aqt.a {
         public void a(Random var1, int var2, int var3, int var4, boolean var5) {
            if (var1.nextFloat() < 0.4F) {
               this.a = afi.e.Q();
            } else {
               this.a = afi.Y.Q();
            }

         }

         a(Object var1) {
            this();
         }

         private a() {
         }
      }
   }

   public static class d extends aqn.c {
      private boolean e;

      protected void b(dn var1) {
         super.b(var1);
         this.e = var1.n("Witch");
      }

      public d() {
      }

      public d(Random var1, int var2, int var3) {
         super(var1, var2, 64, var3, 7, 7, 9);
      }

      protected void a(dn var1) {
         super.a(var1);
         var1.a("Witch", this.e);
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         if (!this.a(var1, var3, 0)) {
            return false;
         } else {
            this.a(var1, var3, 1, 1, 1, 5, 1, 7, afi.f.a(aio.a.b.a()), afi.f.a(aio.a.b.a()), false);
            this.a(var1, var3, 1, 4, 2, 5, 4, 7, afi.f.a(aio.a.b.a()), afi.f.a(aio.a.b.a()), false);
            this.a(var1, var3, 2, 1, 0, 4, 1, 0, afi.f.a(aio.a.b.a()), afi.f.a(aio.a.b.a()), false);
            this.a(var1, var3, 2, 2, 2, 3, 3, 2, afi.f.a(aio.a.b.a()), afi.f.a(aio.a.b.a()), false);
            this.a(var1, var3, 1, 2, 3, 1, 3, 6, afi.f.a(aio.a.b.a()), afi.f.a(aio.a.b.a()), false);
            this.a(var1, var3, 5, 2, 3, 5, 3, 6, afi.f.a(aio.a.b.a()), afi.f.a(aio.a.b.a()), false);
            this.a(var1, var3, 2, 2, 7, 4, 3, 7, afi.f.a(aio.a.b.a()), afi.f.a(aio.a.b.a()), false);
            this.a(var1, var3, 1, 0, 2, 1, 3, 2, afi.r.Q(), afi.r.Q(), false);
            this.a(var1, var3, 5, 0, 2, 5, 3, 2, afi.r.Q(), afi.r.Q(), false);
            this.a(var1, var3, 1, 0, 7, 1, 3, 7, afi.r.Q(), afi.r.Q(), false);
            this.a(var1, var3, 5, 0, 7, 5, 3, 7, afi.r.Q(), afi.r.Q(), false);
            this.a(var1, afi.aO.Q(), 2, 3, 2, var3);
            this.a(var1, afi.aO.Q(), 3, 3, 7, var3);
            this.a(var1, afi.a.Q(), 1, 3, 4, var3);
            this.a(var1, afi.a.Q(), 5, 3, 4, var3);
            this.a(var1, afi.a.Q(), 5, 3, 5, var3);
            this.a(var1, afi.ca.Q().a(agx.b, agx.a.r), 1, 3, 5, var3);
            this.a(var1, afi.ai.Q(), 3, 2, 6, var3);
            this.a(var1, afi.bE.Q(), 4, 2, 6, var3);
            this.a(var1, afi.aO.Q(), 1, 2, 1, var3);
            this.a(var1, afi.aO.Q(), 5, 2, 1, var3);
            int var4 = this.a(afi.ad, 3);
            int var5 = this.a(afi.ad, 1);
            int var6 = this.a(afi.ad, 0);
            int var7 = this.a(afi.ad, 2);
            this.a(var1, var3, 0, 4, 1, 6, 4, 1, afi.bU.a(var4), afi.bU.a(var4), false);
            this.a(var1, var3, 0, 4, 2, 0, 4, 7, afi.bU.a(var6), afi.bU.a(var6), false);
            this.a(var1, var3, 6, 4, 2, 6, 4, 7, afi.bU.a(var5), afi.bU.a(var5), false);
            this.a(var1, var3, 0, 4, 8, 6, 4, 8, afi.bU.a(var7), afi.bU.a(var7), false);

            int var8;
            int var9;
            for(var8 = 2; var8 <= 7; var8 += 5) {
               for(var9 = 1; var9 <= 5; var9 += 4) {
                  this.b(var1, afi.r.Q(), var9, -1, var8, var3);
               }
            }

            if (!this.e) {
               var8 = this.a(2, 5);
               var9 = this.d(2);
               int var10 = this.b(2, 5);
               if (var3.b((df)(new cj(var8, var9, var10)))) {
                  this.e = true;
                  wd var11 = new wd(var1);
                  var11.b((double)var8 + 0.5D, (double)var9, (double)var10 + 0.5D, 0.0F, 0.0F);
                  var11.a(var1.E(new cj(var8, var9, var10)), (pu)null);
                  var1.d((pk)var11);
               }
            }

            return true;
         }
      }
   }

   abstract static class c extends aqt {
      protected int a;
      protected int c;
      protected int b;
      protected int d = -1;

      protected boolean a(adm var1, aqe var2, int var3) {
         if (this.d >= 0) {
            return true;
         } else {
            int var4 = 0;
            int var5 = 0;
            cj.a var6 = new cj.a();

            for(int var7 = this.l.c; var7 <= this.l.f; ++var7) {
               for(int var8 = this.l.a; var8 <= this.l.d; ++var8) {
                  var6.c(var8, 64, var7);
                  if (var2.b((df)var6)) {
                     var4 += Math.max(var1.r(var6).o(), var1.t.i());
                     ++var5;
                  }
               }
            }

            if (var5 == 0) {
               return false;
            } else {
               this.d = var4 / var5;
               this.l.a(0, this.d - this.l.b + var3, 0);
               return true;
            }
         }
      }

      protected void a(dn var1) {
         var1.a("Width", this.a);
         var1.a("Height", this.b);
         var1.a("Depth", this.c);
         var1.a("HPos", this.d);
      }

      protected c(Random var1, int var2, int var3, int var4, int var5, int var6, int var7) {
         super(0);
         this.a = var5;
         this.b = var6;
         this.c = var7;
         this.m = cq.c.a.a(var1);
         switch(this.m) {
         case c:
         case d:
            this.l = new aqe(var2, var3, var4, var2 + var5 - 1, var3 + var6 - 1, var4 + var7 - 1);
            break;
         default:
            this.l = new aqe(var2, var3, var4, var2 + var7 - 1, var3 + var6 - 1, var4 + var5 - 1);
         }

      }

      protected void b(dn var1) {
         this.a = var1.f("Width");
         this.b = var1.f("Height");
         this.c = var1.f("Depth");
         this.d = var1.f("HPos");
      }

      public c() {
      }
   }

   public static class a extends aqn.c {
      private boolean[] e = new boolean[4];
      private static final List<ob> f;

      static {
         f = Lists.newArrayList(new ob[]{new ob(zy.i, 0, 1, 3, 3), new ob(zy.j, 0, 1, 5, 10), new ob(zy.k, 0, 2, 7, 15), new ob(zy.bO, 0, 1, 3, 2), new ob(zy.aX, 0, 4, 6, 20), new ob(zy.bt, 0, 3, 7, 16), new ob(zy.aA, 0, 1, 1, 3), new ob(zy.ck, 0, 1, 1, 1), new ob(zy.cl, 0, 1, 1, 1), new ob(zy.cm, 0, 1, 1, 1)});
      }

      public boolean a(adm var1, Random var2, aqe var3) {
         this.a(var1, var3, 0, -4, 0, this.a - 1, 0, this.c - 1, afi.A.Q(), afi.A.Q(), false);

         int var4;
         for(var4 = 1; var4 <= 9; ++var4) {
            this.a(var1, var3, var4, var4, var4, this.a - 1 - var4, var4, this.c - 1 - var4, afi.A.Q(), afi.A.Q(), false);
            this.a(var1, var3, var4 + 1, var4, var4 + 1, this.a - 2 - var4, var4, this.c - 2 - var4, afi.a.Q(), afi.a.Q(), false);
         }

         int var5;
         for(var4 = 0; var4 < this.a; ++var4) {
            for(var5 = 0; var5 < this.c; ++var5) {
               byte var6 = -5;
               this.b(var1, afi.A.Q(), var4, var6, var5, var3);
            }
         }

         var4 = this.a(afi.bO, 3);
         var5 = this.a(afi.bO, 2);
         int var14 = this.a(afi.bO, 0);
         int var7 = this.a(afi.bO, 1);
         int var8 = ~zd.b.b() & 15;
         int var9 = ~zd.l.b() & 15;
         this.a(var1, var3, 0, 0, 0, 4, 9, 4, afi.A.Q(), afi.a.Q(), false);
         this.a(var1, var3, 1, 10, 1, 3, 10, 3, afi.A.Q(), afi.A.Q(), false);
         this.a(var1, afi.bO.a(var4), 2, 10, 0, var3);
         this.a(var1, afi.bO.a(var5), 2, 10, 4, var3);
         this.a(var1, afi.bO.a(var14), 0, 10, 2, var3);
         this.a(var1, afi.bO.a(var7), 4, 10, 2, var3);
         this.a(var1, var3, this.a - 5, 0, 0, this.a - 1, 9, 4, afi.A.Q(), afi.a.Q(), false);
         this.a(var1, var3, this.a - 4, 10, 1, this.a - 2, 10, 3, afi.A.Q(), afi.A.Q(), false);
         this.a(var1, afi.bO.a(var4), this.a - 3, 10, 0, var3);
         this.a(var1, afi.bO.a(var5), this.a - 3, 10, 4, var3);
         this.a(var1, afi.bO.a(var14), this.a - 5, 10, 2, var3);
         this.a(var1, afi.bO.a(var7), this.a - 1, 10, 2, var3);
         this.a(var1, var3, 8, 0, 0, 12, 4, 4, afi.A.Q(), afi.a.Q(), false);
         this.a(var1, var3, 9, 1, 0, 11, 3, 4, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, afi.A.a(aji.a.c.a()), 9, 1, 1, var3);
         this.a(var1, afi.A.a(aji.a.c.a()), 9, 2, 1, var3);
         this.a(var1, afi.A.a(aji.a.c.a()), 9, 3, 1, var3);
         this.a(var1, afi.A.a(aji.a.c.a()), 10, 3, 1, var3);
         this.a(var1, afi.A.a(aji.a.c.a()), 11, 3, 1, var3);
         this.a(var1, afi.A.a(aji.a.c.a()), 11, 2, 1, var3);
         this.a(var1, afi.A.a(aji.a.c.a()), 11, 1, 1, var3);
         this.a(var1, var3, 4, 1, 1, 8, 3, 3, afi.A.Q(), afi.a.Q(), false);
         this.a(var1, var3, 4, 1, 2, 8, 2, 2, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 12, 1, 1, 16, 3, 3, afi.A.Q(), afi.a.Q(), false);
         this.a(var1, var3, 12, 1, 2, 16, 2, 2, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 5, 4, 5, this.a - 6, 4, this.c - 6, afi.A.Q(), afi.A.Q(), false);
         this.a(var1, var3, 9, 4, 9, 11, 4, 11, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, 8, 1, 8, 8, 3, 8, afi.A.a(aji.a.c.a()), afi.A.a(aji.a.c.a()), false);
         this.a(var1, var3, 12, 1, 8, 12, 3, 8, afi.A.a(aji.a.c.a()), afi.A.a(aji.a.c.a()), false);
         this.a(var1, var3, 8, 1, 12, 8, 3, 12, afi.A.a(aji.a.c.a()), afi.A.a(aji.a.c.a()), false);
         this.a(var1, var3, 12, 1, 12, 12, 3, 12, afi.A.a(aji.a.c.a()), afi.A.a(aji.a.c.a()), false);
         this.a(var1, var3, 1, 1, 5, 4, 4, 11, afi.A.Q(), afi.A.Q(), false);
         this.a(var1, var3, this.a - 5, 1, 5, this.a - 2, 4, 11, afi.A.Q(), afi.A.Q(), false);
         this.a(var1, var3, 6, 7, 9, 6, 7, 11, afi.A.Q(), afi.A.Q(), false);
         this.a(var1, var3, this.a - 7, 7, 9, this.a - 7, 7, 11, afi.A.Q(), afi.A.Q(), false);
         this.a(var1, var3, 5, 5, 9, 5, 7, 11, afi.A.a(aji.a.c.a()), afi.A.a(aji.a.c.a()), false);
         this.a(var1, var3, this.a - 6, 5, 9, this.a - 6, 7, 11, afi.A.a(aji.a.c.a()), afi.A.a(aji.a.c.a()), false);
         this.a(var1, afi.a.Q(), 5, 5, 10, var3);
         this.a(var1, afi.a.Q(), 5, 6, 10, var3);
         this.a(var1, afi.a.Q(), 6, 6, 10, var3);
         this.a(var1, afi.a.Q(), this.a - 6, 5, 10, var3);
         this.a(var1, afi.a.Q(), this.a - 6, 6, 10, var3);
         this.a(var1, afi.a.Q(), this.a - 7, 6, 10, var3);
         this.a(var1, var3, 2, 4, 4, 2, 6, 4, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, this.a - 3, 4, 4, this.a - 3, 6, 4, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, afi.bO.a(var4), 2, 4, 5, var3);
         this.a(var1, afi.bO.a(var4), 2, 3, 4, var3);
         this.a(var1, afi.bO.a(var4), this.a - 3, 4, 5, var3);
         this.a(var1, afi.bO.a(var4), this.a - 3, 3, 4, var3);
         this.a(var1, var3, 1, 1, 3, 2, 2, 3, afi.A.Q(), afi.A.Q(), false);
         this.a(var1, var3, this.a - 3, 1, 3, this.a - 2, 2, 3, afi.A.Q(), afi.A.Q(), false);
         this.a(var1, afi.bO.Q(), 1, 1, 2, var3);
         this.a(var1, afi.bO.Q(), this.a - 2, 1, 2, var3);
         this.a(var1, afi.U.a(akb.a.b.a()), 1, 2, 2, var3);
         this.a(var1, afi.U.a(akb.a.b.a()), this.a - 2, 2, 2, var3);
         this.a(var1, afi.bO.a(var7), 2, 1, 2, var3);
         this.a(var1, afi.bO.a(var14), this.a - 3, 1, 2, var3);
         this.a(var1, var3, 4, 3, 5, 4, 3, 18, afi.A.Q(), afi.A.Q(), false);
         this.a(var1, var3, this.a - 5, 3, 5, this.a - 5, 3, 17, afi.A.Q(), afi.A.Q(), false);
         this.a(var1, var3, 3, 1, 5, 4, 2, 16, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, var3, this.a - 6, 1, 5, this.a - 5, 2, 16, afi.a.Q(), afi.a.Q(), false);

         int var10;
         for(var10 = 5; var10 <= 17; var10 += 2) {
            this.a(var1, afi.A.a(aji.a.c.a()), 4, 1, var10, var3);
            this.a(var1, afi.A.a(aji.a.b.a()), 4, 2, var10, var3);
            this.a(var1, afi.A.a(aji.a.c.a()), this.a - 5, 1, var10, var3);
            this.a(var1, afi.A.a(aji.a.b.a()), this.a - 5, 2, var10, var3);
         }

         this.a(var1, afi.cu.a(var8), 10, 0, 7, var3);
         this.a(var1, afi.cu.a(var8), 10, 0, 8, var3);
         this.a(var1, afi.cu.a(var8), 9, 0, 9, var3);
         this.a(var1, afi.cu.a(var8), 11, 0, 9, var3);
         this.a(var1, afi.cu.a(var8), 8, 0, 10, var3);
         this.a(var1, afi.cu.a(var8), 12, 0, 10, var3);
         this.a(var1, afi.cu.a(var8), 7, 0, 10, var3);
         this.a(var1, afi.cu.a(var8), 13, 0, 10, var3);
         this.a(var1, afi.cu.a(var8), 9, 0, 11, var3);
         this.a(var1, afi.cu.a(var8), 11, 0, 11, var3);
         this.a(var1, afi.cu.a(var8), 10, 0, 12, var3);
         this.a(var1, afi.cu.a(var8), 10, 0, 13, var3);
         this.a(var1, afi.cu.a(var9), 10, 0, 10, var3);

         for(var10 = 0; var10 <= this.a - 1; var10 += this.a - 1) {
            this.a(var1, afi.A.a(aji.a.c.a()), var10, 2, 1, var3);
            this.a(var1, afi.cu.a(var8), var10, 2, 2, var3);
            this.a(var1, afi.A.a(aji.a.c.a()), var10, 2, 3, var3);
            this.a(var1, afi.A.a(aji.a.c.a()), var10, 3, 1, var3);
            this.a(var1, afi.cu.a(var8), var10, 3, 2, var3);
            this.a(var1, afi.A.a(aji.a.c.a()), var10, 3, 3, var3);
            this.a(var1, afi.cu.a(var8), var10, 4, 1, var3);
            this.a(var1, afi.A.a(aji.a.b.a()), var10, 4, 2, var3);
            this.a(var1, afi.cu.a(var8), var10, 4, 3, var3);
            this.a(var1, afi.A.a(aji.a.c.a()), var10, 5, 1, var3);
            this.a(var1, afi.cu.a(var8), var10, 5, 2, var3);
            this.a(var1, afi.A.a(aji.a.c.a()), var10, 5, 3, var3);
            this.a(var1, afi.cu.a(var8), var10, 6, 1, var3);
            this.a(var1, afi.A.a(aji.a.b.a()), var10, 6, 2, var3);
            this.a(var1, afi.cu.a(var8), var10, 6, 3, var3);
            this.a(var1, afi.cu.a(var8), var10, 7, 1, var3);
            this.a(var1, afi.cu.a(var8), var10, 7, 2, var3);
            this.a(var1, afi.cu.a(var8), var10, 7, 3, var3);
            this.a(var1, afi.A.a(aji.a.c.a()), var10, 8, 1, var3);
            this.a(var1, afi.A.a(aji.a.c.a()), var10, 8, 2, var3);
            this.a(var1, afi.A.a(aji.a.c.a()), var10, 8, 3, var3);
         }

         for(var10 = 2; var10 <= this.a - 3; var10 += this.a - 3 - 2) {
            this.a(var1, afi.A.a(aji.a.c.a()), var10 - 1, 2, 0, var3);
            this.a(var1, afi.cu.a(var8), var10, 2, 0, var3);
            this.a(var1, afi.A.a(aji.a.c.a()), var10 + 1, 2, 0, var3);
            this.a(var1, afi.A.a(aji.a.c.a()), var10 - 1, 3, 0, var3);
            this.a(var1, afi.cu.a(var8), var10, 3, 0, var3);
            this.a(var1, afi.A.a(aji.a.c.a()), var10 + 1, 3, 0, var3);
            this.a(var1, afi.cu.a(var8), var10 - 1, 4, 0, var3);
            this.a(var1, afi.A.a(aji.a.b.a()), var10, 4, 0, var3);
            this.a(var1, afi.cu.a(var8), var10 + 1, 4, 0, var3);
            this.a(var1, afi.A.a(aji.a.c.a()), var10 - 1, 5, 0, var3);
            this.a(var1, afi.cu.a(var8), var10, 5, 0, var3);
            this.a(var1, afi.A.a(aji.a.c.a()), var10 + 1, 5, 0, var3);
            this.a(var1, afi.cu.a(var8), var10 - 1, 6, 0, var3);
            this.a(var1, afi.A.a(aji.a.b.a()), var10, 6, 0, var3);
            this.a(var1, afi.cu.a(var8), var10 + 1, 6, 0, var3);
            this.a(var1, afi.cu.a(var8), var10 - 1, 7, 0, var3);
            this.a(var1, afi.cu.a(var8), var10, 7, 0, var3);
            this.a(var1, afi.cu.a(var8), var10 + 1, 7, 0, var3);
            this.a(var1, afi.A.a(aji.a.c.a()), var10 - 1, 8, 0, var3);
            this.a(var1, afi.A.a(aji.a.c.a()), var10, 8, 0, var3);
            this.a(var1, afi.A.a(aji.a.c.a()), var10 + 1, 8, 0, var3);
         }

         this.a(var1, var3, 8, 4, 0, 12, 6, 0, afi.A.a(aji.a.c.a()), afi.A.a(aji.a.c.a()), false);
         this.a(var1, afi.a.Q(), 8, 6, 0, var3);
         this.a(var1, afi.a.Q(), 12, 6, 0, var3);
         this.a(var1, afi.cu.a(var8), 9, 5, 0, var3);
         this.a(var1, afi.A.a(aji.a.b.a()), 10, 5, 0, var3);
         this.a(var1, afi.cu.a(var8), 11, 5, 0, var3);
         this.a(var1, var3, 8, -14, 8, 12, -11, 12, afi.A.a(aji.a.c.a()), afi.A.a(aji.a.c.a()), false);
         this.a(var1, var3, 8, -10, 8, 12, -10, 12, afi.A.a(aji.a.b.a()), afi.A.a(aji.a.b.a()), false);
         this.a(var1, var3, 8, -9, 8, 12, -9, 12, afi.A.a(aji.a.c.a()), afi.A.a(aji.a.c.a()), false);
         this.a(var1, var3, 8, -8, 8, 12, -1, 12, afi.A.Q(), afi.A.Q(), false);
         this.a(var1, var3, 9, -11, 9, 11, -1, 11, afi.a.Q(), afi.a.Q(), false);
         this.a(var1, afi.az.Q(), 10, -11, 10, var3);
         this.a(var1, var3, 9, -13, 9, 11, -13, 11, afi.W.Q(), afi.a.Q(), false);
         this.a(var1, afi.a.Q(), 8, -11, 10, var3);
         this.a(var1, afi.a.Q(), 8, -10, 10, var3);
         this.a(var1, afi.A.a(aji.a.b.a()), 7, -10, 10, var3);
         this.a(var1, afi.A.a(aji.a.c.a()), 7, -11, 10, var3);
         this.a(var1, afi.a.Q(), 12, -11, 10, var3);
         this.a(var1, afi.a.Q(), 12, -10, 10, var3);
         this.a(var1, afi.A.a(aji.a.b.a()), 13, -10, 10, var3);
         this.a(var1, afi.A.a(aji.a.c.a()), 13, -11, 10, var3);
         this.a(var1, afi.a.Q(), 10, -11, 8, var3);
         this.a(var1, afi.a.Q(), 10, -10, 8, var3);
         this.a(var1, afi.A.a(aji.a.b.a()), 10, -10, 7, var3);
         this.a(var1, afi.A.a(aji.a.c.a()), 10, -11, 7, var3);
         this.a(var1, afi.a.Q(), 10, -11, 12, var3);
         this.a(var1, afi.a.Q(), 10, -10, 12, var3);
         this.a(var1, afi.A.a(aji.a.b.a()), 10, -10, 13, var3);
         this.a(var1, afi.A.a(aji.a.c.a()), 10, -11, 13, var3);
         Iterator var15 = cq.c.a.iterator();

         while(var15.hasNext()) {
            cq var11 = (cq)var15.next();
            if (!this.e[var11.b()]) {
               int var12 = var11.g() * 2;
               int var13 = var11.i() * 2;
               this.e[var11.b()] = this.a(var1, var3, var2, 10 + var12, -11, 10 + var13, ob.a(f, zy.cd.b(var2)), 2 + var2.nextInt(5));
            }
         }

         return true;
      }

      public a() {
      }

      protected void a(dn var1) {
         super.a(var1);
         var1.a("hasPlacedChest0", this.e[0]);
         var1.a("hasPlacedChest1", this.e[1]);
         var1.a("hasPlacedChest2", this.e[2]);
         var1.a("hasPlacedChest3", this.e[3]);
      }

      public a(Random var1, int var2, int var3) {
         super(var1, var2, 64, var3, 21, 15, 21);
      }

      protected void b(dn var1) {
         super.b(var1);
         this.e[0] = var1.n("hasPlacedChest0");
         this.e[1] = var1.n("hasPlacedChest1");
         this.e[2] = var1.n("hasPlacedChest2");
         this.e[3] = var1.n("hasPlacedChest3");
      }
   }
}
