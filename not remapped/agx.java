import java.util.Random;

public class agx extends afc {
   public static final amm<agx.a> b = amm.a("contents", agx.a.class);
   public static final amn a = amn.a("legacy_data", 0, 15);

   public String f() {
      return di.a("item.flowerPot.name");
   }

   public int c(alz var1) {
      return (Integer)var1.b(a);
   }

   public boolean M() {
      return true;
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (!adm.a((adq)var1, (cj)var2.b())) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

   }

   public agx() {
      super(arm.q);
      this.j(this.M.b().a(b, agx.a.a).a(a, 0));
      this.j();
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      zx var9 = var4.bi.h();
      if (var9 != null && var9.b() instanceof yo) {
         alg var10 = this.f(var1, var2);
         if (var10 == null) {
            return false;
         } else if (var10.b() != null) {
            return false;
         } else {
            afh var11 = afh.a(var9.b());
            if (!this.a(var11, var9.i())) {
               return false;
            } else {
               var10.a(var9.b(), var9.i());
               var10.p_();
               var1.h(var2);
               var4.b(na.T);
               if (!var4.bA.d && --var9.b <= 0) {
                  var4.bi.a(var4.bi.c, (zx)null);
               }

               return true;
            }
         }
      } else {
         return false;
      }
   }

   public void b(adm var1, cj var2, alz var3) {
      alg var4 = this.f(var1, var2);
      if (var4 != null && var4.b() != null) {
         a(var1, var2, new zx(var4.b(), 1, var4.c()));
      }

      super.b(var1, var2, var3);
   }

   public int j(adm var1, cj var2) {
      alg var3 = this.f(var1, var2);
      return var3 != null && var3.b() != null ? var3.c() : 0;
   }

   private alg f(adm var1, cj var2) {
      akw var3 = var1.s(var2);
      return var3 instanceof alg ? (alg)var3 : null;
   }

   public void j() {
      float var1 = 0.375F;
      float var2 = var1 / 2.0F;
      this.a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, var1, 0.5F + var2);
   }

   public adf m() {
      return adf.c;
   }

   public zw a(alz var1, Random var2, int var3) {
      return zy.bQ;
   }

   public akw a(adm var1, int var2) {
      Object var3 = null;
      int var4 = 0;
      switch(var2) {
      case 1:
         var3 = afi.O;
         var4 = agw.a.b.b();
         break;
      case 2:
         var3 = afi.N;
         break;
      case 3:
         var3 = afi.g;
         var4 = aio.a.a.a();
         break;
      case 4:
         var3 = afi.g;
         var4 = aio.a.b.a();
         break;
      case 5:
         var3 = afi.g;
         var4 = aio.a.c.a();
         break;
      case 6:
         var3 = afi.g;
         var4 = aio.a.d.a();
         break;
      case 7:
         var3 = afi.Q;
         break;
      case 8:
         var3 = afi.P;
         break;
      case 9:
         var3 = afi.aK;
         break;
      case 10:
         var3 = afi.I;
         break;
      case 11:
         var3 = afi.H;
         var4 = akc.a.c.a();
         break;
      case 12:
         var3 = afi.g;
         var4 = aio.a.e.a();
         break;
      case 13:
         var3 = afi.g;
         var4 = aio.a.f.a();
      }

      return new alg(zw.a((afh)var3), var4);
   }

   private boolean a(afh var1, int var2) {
      if (var1 != afi.N && var1 != afi.O && var1 != afi.aK && var1 != afi.P && var1 != afi.Q && var1 != afi.g && var1 != afi.I) {
         return var1 == afi.H && var2 == akc.a.c.a();
      } else {
         return true;
      }
   }

   public int a(adq var1, cj var2, int var3) {
      akw var4 = var1.s(var2);
      if (var4 instanceof alg) {
         zw var5 = ((alg)var4).b();
         if (var5 instanceof yo) {
            return afh.a(var5).a(var1, var2, var3);
         }
      }

      return 16777215;
   }

   protected ama e() {
      return new ama(this, new amo[]{b, a});
   }

   public boolean d() {
      return false;
   }

   public void a(adm var1, cj var2, alz var3, wn var4) {
      super.a(var1, var2, var3, var4);
      if (var4.bA.d) {
         alg var5 = this.f(var1, var2);
         if (var5 != null) {
            var5.a((zw)null, 0);
         }
      }

   }

   public int b() {
      return 3;
   }

   public zw c(adm var1, cj var2) {
      alg var3 = this.f(var1, var2);
      return var3 != null && var3.b() != null ? var3.b() : zy.bQ;
   }

   public boolean d(adm var1, cj var2) {
      return super.d(var1, var2) && adm.a((adq)var1, (cj)var2.b());
   }

   public alz a(alz var1, adq var2, cj var3) {
      agx.a var4 = agx.a.a;
      akw var5 = var2.s(var3);
      if (var5 instanceof alg) {
         alg var6 = (alg)var5;
         zw var7 = var6.b();
         if (var7 instanceof yo) {
            int var8 = var6.c();
            afh var9 = afh.a(var7);
            if (var9 == afi.g) {
               switch(aio.a.a(var8)) {
               case a:
                  var4 = agx.a.l;
                  break;
               case b:
                  var4 = agx.a.m;
                  break;
               case c:
                  var4 = agx.a.n;
                  break;
               case d:
                  var4 = agx.a.o;
                  break;
               case e:
                  var4 = agx.a.p;
                  break;
               case f:
                  var4 = agx.a.q;
                  break;
               default:
                  var4 = agx.a.a;
               }
            } else if (var9 == afi.H) {
               switch(var8) {
               case 0:
                  var4 = agx.a.t;
                  break;
               case 2:
                  var4 = agx.a.u;
                  break;
               default:
                  var4 = agx.a.a;
               }
            } else if (var9 == afi.N) {
               var4 = agx.a.k;
            } else if (var9 == afi.O) {
               switch(agw.a.a(agw.b.b, var8)) {
               case b:
                  var4 = agx.a.b;
                  break;
               case c:
                  var4 = agx.a.c;
                  break;
               case d:
                  var4 = agx.a.d;
                  break;
               case e:
                  var4 = agx.a.e;
                  break;
               case f:
                  var4 = agx.a.f;
                  break;
               case g:
                  var4 = agx.a.g;
                  break;
               case h:
                  var4 = agx.a.h;
                  break;
               case i:
                  var4 = agx.a.i;
                  break;
               case j:
                  var4 = agx.a.j;
                  break;
               default:
                  var4 = agx.a.a;
               }
            } else if (var9 == afi.Q) {
               var4 = agx.a.r;
            } else if (var9 == afi.P) {
               var4 = agx.a.s;
            } else if (var9 == afi.I) {
               var4 = agx.a.t;
            } else if (var9 == afi.aK) {
               var4 = agx.a.v;
            }
         }
      }

      return var1.a(b, var4);
   }

   public boolean c() {
      return false;
   }

   public static enum a implements nw {
      n("birch_sapling"),
      j("oxeye_daisy"),
      v("cactus"),
      u("fern"),
      l("oak_sapling"),
      g("orange_tulip"),
      t("dead_bush"),
      p("acacia_sapling"),
      a("empty"),
      k("dandelion"),
      h("white_tulip"),
      d("allium"),
      o("jungle_sapling"),
      r("mushroom_red");

      private final String w;
      c("blue_orchid"),
      f("red_tulip"),
      m("spruce_sapling"),
      b("rose"),
      q("dark_oak_sapling"),
      e("houstonia"),
      s("mushroom_brown");

      private static final agx.a[] x = new agx.a[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v};
      i("pink_tulip");

      public String toString() {
         return this.w;
      }

      public String l() {
         return this.w;
      }

      private a(String var3) {
         this.w = var3;
      }
   }
}
