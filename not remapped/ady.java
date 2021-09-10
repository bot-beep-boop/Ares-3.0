import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class ady {
   public float aq;
   protected apt aC;
   public alz al;
   public float ap;
   protected apv aA;
   protected static final ady.a i = new ady.a(1.0F, 0.5F);
   public int ar;
   public static final ady J;
   protected static final ard af;
   protected static final ady.a g = new ady.a(0.45F, 0.3F);
   public static final ady x;
   public static final ady v;
   protected List<ady.c> at;
   public static final ady Q;
   public float an;
   protected List<ady.c> au;
   public static final ady I;
   public static final ady p;
   protected static final ard ae;
   public static final ady F;
   public static final ady X;
   public static final ady W;
   public static final ady T;
   protected boolean ax;
   protected static final ady.a b = new ady.a(-0.5F, 0.0F);
   protected static final aos ag;
   public float ao;
   public static final ady D;
   public int ai;
   public static final Set<ady> n = Sets.newHashSet();
   public int am;
   protected static final ady.a c = new ady.a(-1.0F, 0.1F);
   protected List<ady.c> av;
   private static final Logger aD = LogManager.getLogger();
   public static final ady K;
   public static final ady q;
   public final int az;
   protected static final ady.a e = new ady.a(0.125F, 0.05F);
   public aeb as;
   public static final Map<String, ady> o = Maps.newHashMap();
   protected boolean ay;
   public static final ady N;
   protected static final ady.a j = new ady.a(0.0F, 0.025F);
   public int aj;
   public alz ak;
   public static final ady O;
   public static final ady E;
   public static final ady u;
   protected static final ady.a f = new ady.a(0.2F, 0.2F);
   protected static final ady.a h = new ady.a(1.5F, 0.025F);
   public static final ady B;
   public static final ady ad;
   public static final ady M;
   protected aoi aB;
   public static final ady H;
   public static final ady V;
   public String ah;
   public static final ady G;
   public static final ady w;
   protected static final ady.a m = new ady.a(-0.2F, 0.1F);
   public static final ady L;
   private static final ady[] aE = new ady[256];
   public static final ady Y;
   public static final ady s;
   public static final ady y;
   public static final ady ab;
   protected List<ady.c> aw;
   public static final ady U;
   public static final ady A;
   protected static final ady.a a = new ady.a(0.1F, 0.2F);
   public static final ady Z;
   public static final ady z;
   protected static final ady.a l = new ady.a(0.2F, 0.3F);
   public static final ady aa;
   public static final ady r;
   public static final ady P;
   public static final ady S;
   public static final ady C;
   public static final ady t;
   protected static final ady.a d = new ady.a(-1.8F, 0.1F);
   public static final ady ac;
   public static final ady R;
   protected static final ady.a k = new ady.a(0.1F, 0.8F);

   protected ady a(int var1) {
      this.am = var1;
      return this;
   }

   protected ady b() {
      this.ay = false;
      return this;
   }

   protected ady c() {
      this.ax = true;
      return this;
   }

   static {
      p = (new aen(0)).b(112).a("Ocean").a(c);
      q = (new aeo(1)).b(9286496).a("Plains");
      r = (new aed(2)).b(16421912).a("Desert").b().a(2.0F, 0.0F).a(e);
      s = (new aee(3, false)).b(6316128).a("Extreme Hills").a(i).a(0.2F, 0.3F);
      t = (new aeg(4, 0)).b(353825).a("Forest");
      u = (new aeu(5, 0)).b(747097).a("Taiga").a(5159473).a(0.25F, 0.8F).a(f);
      v = (new aet(6)).b(522674).a("Swampland").a(9154376).a(m).a(0.8F, 0.9F);
      w = (new aeq(7)).b(255).a("River").a(b);
      x = (new aeh(8)).b(16711680).a("Hell").b().a(2.0F, 0.0F);
      y = (new aev(9)).b(8421631).a("The End").b();
      z = (new aen(10)).b(9474208).a("FrozenOcean").c().a(c).a(0.0F, 0.5F);
      A = (new aeq(11)).b(10526975).a("FrozenRiver").c().a(b).a(0.0F, 0.5F);
      B = (new aei(12, false)).b(16777215).a("Ice Plains").c().a(0.0F, 0.5F).a(e);
      C = (new aei(13, false)).b(10526880).a("Ice Mountains").c().a(g).a(0.0F, 0.5F);
      D = (new ael(14)).b(16711935).a("MushroomIsland").a(0.9F, 1.0F).a(l);
      E = (new ael(15)).b(10486015).a("MushroomIslandShore").a(0.9F, 1.0F).a(j);
      F = (new adx(16)).b(16440917).a("Beach").a(0.8F, 0.4F).a(j);
      G = (new aed(17)).b(13786898).a("DesertHills").b().a(2.0F, 0.0F).a(g);
      H = (new aeg(18, 0)).b(2250012).a("ForestHills").a(g);
      I = (new aeu(19, 0)).b(1456435).a("TaigaHills").a(5159473).a(0.25F, 0.8F).a(g);
      J = (new aee(20, true)).b(7501978).a("Extreme Hills Edge").a(i.a()).a(0.2F, 0.3F);
      K = (new aej(21, false)).b(5470985).a("Jungle").a(5470985).a(0.95F, 0.9F);
      L = (new aej(22, false)).b(2900485).a("JungleHills").a(5470985).a(0.95F, 0.9F).a(g);
      M = (new aej(23, true)).b(6458135).a("JungleEdge").a(5470985).a(0.95F, 0.8F);
      N = (new aen(24)).b(48).a("Deep Ocean").a(d);
      O = (new aes(25)).b(10658436).a("Stone Beach").a(0.2F, 0.3F).a(k);
      P = (new adx(26)).b(16445632).a("Cold Beach").a(0.05F, 0.3F).a(j).c();
      Q = (new aeg(27, 2)).a("Birch Forest").b(3175492);
      R = (new aeg(28, 2)).a("Birch Forest Hills").b(2055986).a(g);
      S = (new aeg(29, 3)).b(4215066).a("Roofed Forest");
      T = (new aeu(30, 0)).b(3233098).a("Cold Taiga").a(5159473).c().a(-0.5F, 0.4F).a(f).c(16777215);
      U = (new aeu(31, 0)).b(2375478).a("Cold Taiga Hills").a(5159473).c().a(-0.5F, 0.4F).a(g).c(16777215);
      V = (new aeu(32, 1)).b(5858897).a("Mega Taiga").a(5159473).a(0.3F, 0.8F).a(f);
      W = (new aeu(33, 1)).b(4542270).a("Mega Taiga Hills").a(5159473).a(0.3F, 0.8F).a(g);
      X = (new aee(34, true)).b(5271632).a("Extreme Hills+").a(i).a(0.2F, 0.3F);
      Y = (new aer(35)).b(12431967).a("Savanna").a(1.2F, 0.0F).b().a(e);
      Z = (new aer(36)).b(10984804).a("Savanna Plateau").a(1.0F, 0.0F).b().a(h);
      aa = (new aek(37, false, false)).b(14238997).a("Mesa");
      ab = (new aek(38, false, true)).b(11573093).a("Mesa Plateau F").a(h);
      ac = (new aek(39, false, false)).b(13274213).a("Mesa Plateau").a(h);
      ad = p;
      q.k();
      r.k();
      t.k();
      u.k();
      v.k();
      B.k();
      K.k();
      M.k();
      T.k();
      Y.k();
      Z.k();
      aa.k();
      ab.k();
      ac.k();
      Q.k();
      R.k();
      S.k();
      V.k();
      s.k();
      X.k();
      V.d(W.az + 128).a("Redwood Taiga Hills M");
      ady[] var0 = aE;
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         ady var3 = var0[var2];
         if (var3 != null) {
            if (o.containsKey(var3.ah)) {
               throw new Error("Biome \"" + var3.ah + "\" is defined as both ID " + ((ady)o.get(var3.ah)).az + " and " + var3.az);
            }

            o.put(var3.ah, var3);
            if (var3.az < 128) {
               n.add(var3);
            }
         }
      }

      n.remove(x);
      n.remove(y);
      n.remove(z);
      n.remove(J);
      ae = new ard(new Random(1234L), 1);
      af = new ard(new Random(2345L), 1);
      ag = new aos();
   }

   protected aeb a() {
      return new aeb();
   }

   protected ady k() {
      return this.d(this.az + 128);
   }

   protected ady a(String var1) {
      this.ah = var1;
      return this;
   }

   public final float i() {
      return this.aq;
   }

   public int b(cj var1) {
      double var2 = (double)ns.a(this.a(var1), 0.0F, 1.0F);
      double var4 = (double)ns.a(this.i(), 0.0F, 1.0F);
      return adl.a(var2, var4);
   }

   protected ady b(int var1) {
      this.a(var1, false);
      return this;
   }

   public int a(float var1) {
      var1 /= 3.0F;
      var1 = ns.a(var1, -1.0F, 1.0F);
      return ns.c(0.62222224F - var1 * 0.05F, 0.5F + var1 * 0.1F, 1.0F);
   }

   public int c(cj var1) {
      double var2 = (double)ns.a(this.a(var1), 0.0F, 1.0F);
      double var4 = (double)ns.a(this.i(), 0.0F, 1.0F);
      return adj.a(var2, var4);
   }

   public List<ady.c> a(pt var1) {
      switch(var1) {
      case a:
         return this.at;
      case b:
         return this.au;
      case d:
         return this.av;
      case c:
         return this.aw;
      default:
         return Collections.emptyList();
      }
   }

   public ady.b m() {
      if ((double)this.ap < 0.2D) {
         return ady.b.b;
      } else {
         return (double)this.ap < 1.0D ? ady.b.c : ady.b.d;
      }
   }

   protected ady a(int var1, boolean var2) {
      this.ai = var1;
      if (var2) {
         this.aj = (var1 & 16711422) >> 1;
      } else {
         this.aj = var1;
      }

      return this;
   }

   public boolean d() {
      return this.j();
   }

   protected final ady a(ady.a var1) {
      this.an = var1.a;
      this.ao = var1.b;
      return this;
   }

   public aot b(Random var1) {
      return new apu(akc.a.b);
   }

   public static ady[] n() {
      return aE;
   }

   public static ady a(int var0, ady var1) {
      if (var0 >= 0 && var0 <= aE.length) {
         ady var2 = aE[var0];
         return var2 == null ? var1 : var2;
      } else {
         aD.warn("Biome ID is out of bounds: " + var0 + ", defaulting to 0 (Ocean)");
         return p;
      }
   }

   public boolean a(ady var1) {
      if (var1 == this) {
         return true;
      } else if (var1 == null) {
         return false;
      } else {
         return this.l() == var1.l();
      }
   }

   public agw.a a(Random var1, cj var2) {
      return var1.nextInt(3) > 0 ? agw.a.a : agw.a.b;
   }

   public final int h() {
      return (int)(this.aq * 65536.0F);
   }

   protected ady c(int var1) {
      this.aj = var1;
      return this;
   }

   public boolean f() {
      return this.aq > 0.85F;
   }

   protected ady d(int var1) {
      return new aem(var1, this);
   }

   public boolean e() {
      return this.j() ? false : this.ay;
   }

   public void a(adm var1, Random var2, cj var3) {
      this.as.a(var1, var2, this, var3);
   }

   public final float a(cj var1) {
      if (var1.o() > 64) {
         float var2 = (float)(ae.a((double)var1.n() * 1.0D / 8.0D, (double)var1.p() * 1.0D / 8.0D) * 4.0D);
         return this.ap - (var2 + (float)var1.o() - 64.0F) * 0.05F / 30.0F;
      } else {
         return this.ap;
      }
   }

   public Class<? extends ady> l() {
      return this.getClass();
   }

   protected ady a(float var1, float var2) {
      if (var1 > 0.1F && var1 < 0.2F) {
         throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
      } else {
         this.ap = var1;
         this.aq = var2;
         return this;
      }
   }

   public boolean j() {
      return this.ax;
   }

   public aoh a(Random var1) {
      return (aoh)(var1.nextInt(10) == 0 ? this.aB : this.aA);
   }

   public final void b(adm var1, Random var2, ans var3, int var4, int var5, double var6) {
      int var8 = var1.F();
      alz var9 = this.ak;
      alz var10 = this.al;
      int var11 = -1;
      int var12 = (int)(var6 / 3.0D + 3.0D + var2.nextDouble() * 0.25D);
      int var13 = var4 & 15;
      int var14 = var5 & 15;
      cj.a var15 = new cj.a();

      for(int var16 = 255; var16 >= 0; --var16) {
         if (var16 <= var2.nextInt(5)) {
            var3.a(var14, var16, var13, afi.h.Q());
         } else {
            alz var17 = var3.a(var14, var16, var13);
            if (var17.c().t() == arm.a) {
               var11 = -1;
            } else if (var17.c() == afi.b) {
               if (var11 == -1) {
                  if (var12 <= 0) {
                     var9 = null;
                     var10 = afi.b.Q();
                  } else if (var16 >= var8 - 4 && var16 <= var8 + 1) {
                     var9 = this.ak;
                     var10 = this.al;
                  }

                  if (var16 < var8 && (var9 == null || var9.c().t() == arm.a)) {
                     if (this.a((cj)var15.c(var4, var16, var5)) < 0.15F) {
                        var9 = afi.aI.Q();
                     } else {
                        var9 = afi.j.Q();
                     }
                  }

                  var11 = var12;
                  if (var16 >= var8 - 1) {
                     var3.a(var14, var16, var13, var9);
                  } else if (var16 < var8 - 7 - var12) {
                     var9 = null;
                     var10 = afi.b.Q();
                     var3.a(var14, var16, var13, afi.n.Q());
                  } else {
                     var3.a(var14, var16, var13, var10);
                  }
               } else if (var11 > 0) {
                  --var11;
                  var3.a(var14, var16, var13, var10);
                  if (var11 == 0 && var10.c() == afi.m) {
                     var11 = var2.nextInt(4) + Math.max(0, var16 - 63);
                     var10 = var10.b(ajh.a) == ajh.a.b ? afi.cM.Q() : afi.A.Q();
                  }
               }
            }
         }
      }

   }

   public float g() {
      return 0.1F;
   }

   protected ady(int var1) {
      this.ak = afi.c.Q();
      this.al = afi.d.Q();
      this.am = 5169201;
      this.an = a.a;
      this.ao = a.b;
      this.ap = 0.5F;
      this.aq = 0.5F;
      this.ar = 16777215;
      this.at = Lists.newArrayList();
      this.au = Lists.newArrayList();
      this.av = Lists.newArrayList();
      this.aw = Lists.newArrayList();
      this.ay = true;
      this.aA = new apv(false);
      this.aB = new aoi(false);
      this.aC = new apt();
      this.az = var1;
      aE[var1] = this;
      this.as = this.a();
      this.au.add(new ady.c(tv.class, 12, 4, 4));
      this.au.add(new ady.c(tu.class, 10, 3, 3));
      this.au.add(new ady.c(tt.class, 10, 4, 4));
      this.au.add(new ady.c(tn.class, 10, 4, 4));
      this.au.add(new ady.c(to.class, 8, 4, 4));
      this.at.add(new ady.c(wc.class, 100, 4, 4));
      this.at.add(new ady.c(we.class, 100, 4, 4));
      this.at.add(new ady.c(wa.class, 100, 4, 4));
      this.at.add(new ady.c(vn.class, 100, 4, 4));
      this.at.add(new ady.c(wb.class, 100, 4, 4));
      this.at.add(new ady.c(vo.class, 10, 1, 4));
      this.at.add(new ady.c(wd.class, 5, 1, 1));
      this.av.add(new ady.c(tx.class, 10, 4, 4));
      this.aw.add(new ady.c(tk.class, 10, 8, 8));
   }

   public void a(adm var1, Random var2, ans var3, int var4, int var5, double var6) {
      this.b(var1, var2, var3, var4, var5, var6);
   }

   public static ady e(int var0) {
      return a(var0, (ady)null);
   }

   public static enum b {
      c;

      private static final ady.b[] e = new ady.b[]{a, b, c, d};
      d,
      a,
      b;
   }

   public static class a {
      public float b;
      public float a;

      public ady.a a() {
         return new ady.a(this.a * 0.8F, this.b * 0.6F);
      }

      public a(float var1, float var2) {
         this.a = var1;
         this.b = var2;
      }
   }

   public static class c extends oa.a {
      public int d;
      public Class<? extends ps> b;
      public int c;

      public c(Class<? extends ps> var1, int var2, int var3, int var4) {
         super(var2);
         this.b = var1;
         this.c = var3;
         this.d = var4;
      }

      public String toString() {
         return this.b.getSimpleName() + "*(" + this.c + "-" + this.d + "):" + this.a;
      }
   }
}
