import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;

public abstract class adm implements adq {
   int[] H;
   protected final nm<pk> l = new nm();
   public final List<akw> h = Lists.newArrayList();
   public final List<wn> j = Lists.newArrayList();
   protected final int n = 1013904223;
   protected float p;
   protected th A;
   protected boolean y;
   protected float r;
   public final boolean D;
   public final anm t;
   protected float o;
   private long d = 16777215L;
   protected int m = (new Random()).nextInt();
   protected final List<pk> g = Lists.newArrayList();
   protected aua z;
   protected boolean F;
   public final List<akw> i = Lists.newArrayList();
   public final List<pk> f = Lists.newArrayList();
   protected auo C = new auo();
   protected Set<adg> E = Sets.newHashSet();
   private boolean M;
   protected ato x;
   public final List<pk> k = Lists.newArrayList();
   private final List<akw> c = Lists.newArrayList();
   public final nt B;
   protected float q;
   private int I;
   protected amv v;
   private final ams N;
   public final Random s = new Random();
   protected final atp w;
   private int L;
   protected List<ado> u = Lists.newArrayList();
   protected boolean G;
   private final List<akw> b = Lists.newArrayList();
   private int a = 63;
   private final Calendar K = Calendar.getInstance();
   protected boolean e;
   private int J;

   public boolean ad() {
      return this.y;
   }

   public int a(ads var1, cj var2) {
      if (this.t.o() && var1 == ads.a) {
         return 0;
      } else {
         if (var2.o() < 0) {
            var2 = new cj(var2.n(), 0, var2.p());
         }

         if (!this.a(var2)) {
            return var1.c;
         } else if (!this.e(var2)) {
            return var1.c;
         } else if (this.p(var2).c().s()) {
            int var8 = this.b(var1, var2.a());
            int var4 = this.b(var1, var2.f());
            int var5 = this.b(var1, var2.e());
            int var6 = this.b(var1, var2.d());
            int var7 = this.b(var1, var2.c());
            if (var4 > var8) {
               var8 = var4;
            }

            if (var5 > var8) {
               var8 = var5;
            }

            if (var6 > var8) {
               var8 = var6;
            }

            if (var7 > var8) {
               var8 = var7;
            }

            return var8;
         } else {
            amy var3 = this.f(var2);
            return var3.a(var1, var2);
         }
      }
   }

   public void a(cj var1, afh var2, cq var3) {
      if (var3 != cq.e) {
         this.d(var1.e(), var2);
      }

      if (var3 != cq.f) {
         this.d(var1.f(), var2);
      }

      if (var3 != cq.a) {
         this.d(var1.b(), var2);
      }

      if (var3 != cq.b) {
         this.d(var1.a(), var2);
      }

      if (var3 != cq.c) {
         this.d(var1.c(), var2);
      }

      if (var3 != cq.d) {
         this.d(var1.d(), var2);
      }

   }

   public wn a(pk var1, double var2) {
      return this.a(var1.s, var1.t, var1.u, var2);
   }

   public void a(adp var1) {
      this.x.d(true);
   }

   public boolean a(cj var1, alz var2, int var3) {
      if (!this.a(var1)) {
         return false;
      } else if (!this.D && this.x.u() == adr.g) {
         return false;
      } else {
         amy var4 = this.f(var1);
         afh var5 = var2.c();
         alz var6 = var4.a(var1, var2);
         if (var6 == null) {
            return false;
         } else {
            afh var7 = var6.c();
            if (var5.p() != var7.p() || var5.r() != var7.r()) {
               this.B.a("checkLight");
               this.x(var1);
               this.B.b();
            }

            if ((var3 & 2) != 0 && (!this.D || (var3 & 4) == 0) && var4.i()) {
               this.h(var1);
            }

            if (!this.D && (var3 & 1) != 0) {
               this.b(var1, var6.c());
               if (var5.O()) {
                  this.e(var1, var5);
               }
            }

            return true;
         }
      }
   }

   public void a(cj var1, String var2) {
      for(int var3 = 0; var3 < this.u.size(); ++var3) {
         ((ado)this.u.get(var3)).a(var2, var1);
      }

   }

   public boolean a(aug var1, arm var2) {
      int var3 = ns.c(var1.a);
      int var4 = ns.c(var1.d + 1.0D);
      int var5 = ns.c(var1.b);
      int var6 = ns.c(var1.e + 1.0D);
      int var7 = ns.c(var1.c);
      int var8 = ns.c(var1.f + 1.0D);
      cj.a var9 = new cj.a();

      for(int var10 = var3; var10 < var4; ++var10) {
         for(int var11 = var5; var11 < var6; ++var11) {
            for(int var12 = var7; var12 < var8; ++var12) {
               if (this.p(var9.c(var10, var11, var12)).c().t() == var2) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public aua T() {
      return this.z;
   }

   public wn a(String var1) {
      for(int var2 = 0; var2 < this.j.size(); ++var2) {
         wn var3 = (wn)this.j.get(var2);
         if (var1.equals(var3.e_())) {
            return var3;
         }
      }

      return null;
   }

   public boolean w(cj var1) {
      return this.e(var1, true);
   }

   public boolean d(cj var1, boolean var2) {
      if (!this.a(var1)) {
         return var2;
      } else {
         amy var3 = this.v.a(var1);
         if (var3.f()) {
            return var2;
         } else {
            afh var4 = this.p(var1).c();
            return var4.t().k() && var4.d();
         }
      }
   }

   public void b(cj var1, afh var2) {
      if (this.x.u() != adr.g) {
         this.c(var1, var2);
      }

   }

   public boolean a(akw var1) {
      boolean var2 = this.h.add(var1);
      if (var2 && var1 instanceof km) {
         this.i.add(var1);
      }

      return var2;
   }

   public List<adw> a(aqe var1, boolean var2) {
      return null;
   }

   public int F() {
      return this.a;
   }

   public void e(cj var1, afh var2) {
      Iterator var3 = cq.c.a.iterator();

      while(var3.hasNext()) {
         cq var4 = (cq)var3.next();
         cj var5 = var1.a(var4);
         if (this.e(var5)) {
            alz var6 = this.p(var5);
            if (afi.cj.e(var6.c())) {
               var6.c().a(this, var5, var6, var2);
            } else if (var6.c().v()) {
               var5 = var5.a(var4);
               var6 = this.p(var5);
               if (afi.cj.e(var6.c())) {
                  var6.c().a(this, var5, var6, var2);
               }
            }
         }
      }

   }

   public int b(ads var1, cj var2) {
      if (var2.o() < 0) {
         var2 = new cj(var2.n(), 0, var2.p());
      }

      if (!this.a(var2)) {
         return var1.c;
      } else if (!this.e(var2)) {
         return var1.c;
      } else {
         amy var3 = this.f(var2);
         return var3.a(var1, var2);
      }
   }

   public int c(cj var1, cq var2) {
      alz var3 = this.p(var1);
      afh var4 = var3.c();
      return var4.v() ? this.y(var1) : var4.a((adq)this, var1, (alz)var3, (cq)var2);
   }

   public ato P() {
      return this.x;
   }

   public <T extends pk> List<T> a(Class<? extends T> var1, aug var2) {
      return this.a(var1, var2, po.d);
   }

   public amv N() {
      return this.v;
   }

   protected abstract int q();

   public adi a(pk var1, double var2, double var4, double var6, float var8, boolean var9, boolean var10) {
      adi var11 = new adi(this, var1, var2, var4, var6, var8, var9, var10);
      var11.a();
      var11.a(true);
      return var11;
   }

   public boolean a(cj var1, cj var2, boolean var3) {
      return this.a(var1.n(), var1.o(), var1.p(), var2.n(), var2.o(), var2.p(), var3);
   }

   public int U() {
      return 256;
   }

   public boolean R() {
      return (double)this.h(1.0F) > 0.9D;
   }

   public boolean b(aug var1, arm var2) {
      int var3 = ns.c(var1.a);
      int var4 = ns.c(var1.d + 1.0D);
      int var5 = ns.c(var1.b);
      int var6 = ns.c(var1.e + 1.0D);
      int var7 = ns.c(var1.c);
      int var8 = ns.c(var1.f + 1.0D);
      cj.a var9 = new cj.a();

      for(int var10 = var3; var10 < var4; ++var10) {
         for(int var11 = var5; var11 < var6; ++var11) {
            for(int var12 = var7; var12 < var8; ++var12) {
               alz var13 = this.p(var9.c(var10, var11, var12));
               afh var14 = var13.c();
               if (var14.t() == var2) {
                  int var15 = (Integer)var13.b(ahv.b);
                  double var16 = (double)(var11 + 1);
                  if (var15 < 8) {
                     var16 = (double)(var11 + 1) - (double)var15 / 8.0D;
                  }

                  if (var16 >= var1.b) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   private int a(cj var1, ads var2) {
      if (var2 == ads.a && this.i(var1)) {
         return 15;
      } else {
         afh var3 = this.p(var1).c();
         int var4 = var2 == ads.a ? 0 : var3.r();
         int var5 = var3.p();
         if (var5 >= 15 && var3.r() > 0) {
            var5 = 1;
         }

         if (var5 < 1) {
            var5 = 1;
         }

         if (var5 >= 15) {
            return 0;
         } else if (var4 >= 14) {
            return var4;
         } else {
            cq[] var6 = cq.values();
            int var7 = var6.length;

            for(int var8 = 0; var8 < var7; ++var8) {
               cq var9 = var6[var8];
               cj var10 = var1.a(var9);
               int var11 = this.b(var2, var10) - var5;
               if (var11 > var4) {
                  var4 = var11;
               }

               if (var4 >= 14) {
                  return var4;
               }
            }

            return var4;
         }
      }
   }

   public boolean a(wn var1, cj var2, cq var3) {
      var2 = var2.a(var3);
      if (this.p(var2).c() == afi.ab) {
         this.a(var1, 1004, var2, 0);
         this.g(var2);
         return true;
      } else {
         return false;
      }
   }

   public int c(cj var1, boolean var2) {
      if (var1.n() >= -30000000 && var1.p() >= -30000000 && var1.n() < 30000000 && var1.p() < 30000000) {
         if (var2 && this.p(var1).c().s()) {
            int var8 = this.c(var1.a(), false);
            int var4 = this.c(var1.f(), false);
            int var5 = this.c(var1.e(), false);
            int var6 = this.c(var1.d(), false);
            int var7 = this.c(var1.c(), false);
            if (var4 > var8) {
               var8 = var4;
            }

            if (var5 > var8) {
               var8 = var5;
            }

            if (var6 > var8) {
               var8 = var6;
            }

            if (var7 > var8) {
               var8 = var7;
            }

            return var8;
         } else if (var1.o() < 0) {
            return 0;
         } else {
            if (var1.o() >= 256) {
               var1 = new cj(var1.n(), 255, var1.p());
            }

            amy var3 = this.f(var1);
            return var3.a(var1, this.I);
         }
      } else {
         return 15;
      }
   }

   public void c(cj var1, afh var2) {
      this.d(var1.e(), var2);
      this.d(var1.f(), var2);
      this.d(var1.b(), var2);
      this.d(var1.a(), var2);
      this.d(var1.c(), var2);
      this.d(var1.d(), var2);
   }

   public boolean a(cj var1, int var2) {
      return this.a(var1, var2, true);
   }

   public boolean d(cj var1) {
      return this.p(var1).c().t() == arm.a;
   }

   public boolean W() {
      return false;
   }

   protected void C() {
      if (this.x.p()) {
         this.p = 1.0F;
         if (this.x.n()) {
            this.r = 1.0F;
         }
      }

   }

   public boolean d(aug var1) {
      int var2 = ns.c(var1.a);
      int var3 = ns.c(var1.d);
      int var4 = ns.c(var1.b);
      int var5 = ns.c(var1.e);
      int var6 = ns.c(var1.c);
      int var7 = ns.c(var1.f);
      cj.a var8 = new cj.a();

      for(int var9 = var2; var9 <= var3; ++var9) {
         for(int var10 = var4; var10 <= var5; ++var10) {
            for(int var11 = var6; var11 <= var7; ++var11) {
               afh var12 = this.p(var8.c(var9, var10, var11)).c();
               if (var12.t().d()) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public void a(ads var1, cj var2, int var3) {
      if (this.a(var2)) {
         if (this.e(var2)) {
            amy var4 = this.f(var2);
            var4.a(var1, var2, var3);
            this.n(var2);
         }
      }
   }

   public <T extends pk> List<T> b(Class<? extends T> var1, Predicate<? super T> var2) {
      ArrayList var3 = Lists.newArrayList();
      Iterator var4 = this.j.iterator();

      while(var4.hasNext()) {
         pk var5 = (pk)var4.next();
         if (var1.isAssignableFrom(var5.getClass()) && var2.apply(var5)) {
            var3.add(var5);
         }
      }

      return var3;
   }

   public void c(Collection<pk> var1) {
      this.g.addAll(var1);
   }

   public boolean C(cj var1) {
      if (!this.S()) {
         return false;
      } else if (!this.i(var1)) {
         return false;
      } else if (this.q(var1).o() > var1.o()) {
         return false;
      } else {
         ady var2 = this.b(var1);
         if (var2.d()) {
            return false;
         } else {
            return this.f(var1, false) ? false : var2.e();
         }
      }
   }

   public boolean e(cj var1, boolean var2) {
      ady var3 = this.b(var1);
      float var4 = var3.a(var1);
      if (var4 > 0.15F) {
         return false;
      } else {
         if (var1.o() >= 0 && var1.o() < 256 && this.b(ads.b, var1) < 10) {
            alz var5 = this.p(var1);
            afh var6 = var5.c();
            if ((var6 == afi.j || var6 == afi.i) && (Integer)var5.b(ahv.b) == 0) {
               if (!var2) {
                  return true;
               }

               boolean var7 = this.F(var1.e()) && this.F(var1.f()) && this.F(var1.c()) && this.F(var1.d());
               if (!var7) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public void i(float var1) {
      this.q = var1;
      this.r = var1;
   }

   public boolean a(afh var1, cj var2, boolean var3, cq var4, pk var5, zx var6) {
      afh var7 = this.p(var2).c();
      aug var8 = var3 ? null : var1.a(this, var2, var1.Q());
      if (var8 != null && !this.a(var8, var5)) {
         return false;
      } else if (var7.t() == arm.q && var1 == afi.cf) {
         return true;
      } else {
         return var7.t().j() && var1.a(this, var2, var4, var6);
      }
   }

   public wn a(double var1, double var3, double var5, double var7) {
      double var9 = -1.0D;
      wn var11 = null;

      for(int var12 = 0; var12 < this.j.size(); ++var12) {
         wn var13 = (wn)this.j.get(var12);
         if (po.d.apply(var13)) {
            double var14 = var13.e(var1, var3, var5);
            if ((var7 < 0.0D || var14 < var7 * var7) && (var9 == -1.0D || var14 < var9)) {
               var9 = var14;
               var11 = var13;
            }
         }
      }

      return var11;
   }

   public pk a(int var1) {
      return (pk)this.l.a(var1);
   }

   public void b(cj var1, akw var2) {
      if (this.e(var1)) {
         this.f(var1).e();
      }

   }

   public void a(cy var1, double var2, double var4, double var6, double var8, double var10, double var12, int... var14) {
      this.a(var1.c(), var1.e(), var2, var4, var6, var8, var10, var12, var14);
   }

   public boolean c(ads var1, cj var2) {
      if (!this.a(var2, 17, false)) {
         return false;
      } else {
         int var3 = 0;
         int var4 = 0;
         this.B.a("getBrightness");
         int var5 = this.b(var1, var2);
         int var6 = this.a(var2, var1);
         int var7 = var2.n();
         int var8 = var2.o();
         int var9 = var2.p();
         int var10;
         int var11;
         int var12;
         int var13;
         int var16;
         int var17;
         int var18;
         int var19;
         if (var6 > var5) {
            this.H[var4++] = 133152;
         } else if (var6 < var5) {
            this.H[var4++] = 133152 | var5 << 18;

            label151:
            while(true) {
               int var14;
               do {
                  do {
                     cj var15;
                     do {
                        if (var3 >= var4) {
                           var3 = 0;
                           break label151;
                        }

                        var10 = this.H[var3++];
                        var11 = (var10 & 63) - 32 + var7;
                        var12 = (var10 >> 6 & 63) - 32 + var8;
                        var13 = (var10 >> 12 & 63) - 32 + var9;
                        var14 = var10 >> 18 & 15;
                        var15 = new cj(var11, var12, var13);
                        var16 = this.b(var1, var15);
                     } while(var16 != var14);

                     this.a((ads)var1, (cj)var15, 0);
                  } while(var14 <= 0);

                  var17 = ns.a(var11 - var7);
                  var18 = ns.a(var12 - var8);
                  var19 = ns.a(var13 - var9);
               } while(var17 + var18 + var19 >= 17);

               cj.a var20 = new cj.a();
               cq[] var21 = cq.values();
               int var22 = var21.length;

               for(int var23 = 0; var23 < var22; ++var23) {
                  cq var24 = var21[var23];
                  int var25 = var11 + var24.g();
                  int var26 = var12 + var24.h();
                  int var27 = var13 + var24.i();
                  var20.c(var25, var26, var27);
                  int var28 = Math.max(1, this.p(var20).c().p());
                  var16 = this.b((ads)var1, (cj)var20);
                  if (var16 == var14 - var28 && var4 < this.H.length) {
                     this.H[var4++] = var25 - var7 + 32 | var26 - var8 + 32 << 6 | var27 - var9 + 32 << 12 | var14 - var28 << 18;
                  }
               }
            }
         }

         this.B.b();
         this.B.a("checkedPosition < toCheckCount");

         while(var3 < var4) {
            var10 = this.H[var3++];
            var11 = (var10 & 63) - 32 + var7;
            var12 = (var10 >> 6 & 63) - 32 + var8;
            var13 = (var10 >> 12 & 63) - 32 + var9;
            cj var29 = new cj(var11, var12, var13);
            int var30 = this.b(var1, var29);
            var16 = this.a(var29, var1);
            if (var16 != var30) {
               this.a(var1, var29, var16);
               if (var16 > var30) {
                  var17 = Math.abs(var11 - var7);
                  var18 = Math.abs(var12 - var8);
                  var19 = Math.abs(var13 - var9);
                  boolean var31 = var4 < this.H.length - 6;
                  if (var17 + var18 + var19 < 17 && var31) {
                     if (this.b(var1, var29.e()) < var16) {
                        this.H[var4++] = var11 - 1 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
                     }

                     if (this.b(var1, var29.f()) < var16) {
                        this.H[var4++] = var11 + 1 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
                     }

                     if (this.b(var1, var29.b()) < var16) {
                        this.H[var4++] = var11 - var7 + 32 + (var12 - 1 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
                     }

                     if (this.b(var1, var29.a()) < var16) {
                        this.H[var4++] = var11 - var7 + 32 + (var12 + 1 - var8 + 32 << 6) + (var13 - var9 + 32 << 12);
                     }

                     if (this.b(var1, var29.c()) < var16) {
                        this.H[var4++] = var11 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 - 1 - var9 + 32 << 12);
                     }

                     if (this.b(var1, var29.d()) < var16) {
                        this.H[var4++] = var11 - var7 + 32 + (var12 - var8 + 32 << 6) + (var13 + 1 - var9 + 32 << 12);
                     }
                  }
               }
            }
         }

         this.B.b();
         return true;
      }
   }

   public int x() {
      return this.t.a(this.x.g());
   }

   public <T extends pk> List<T> a(Class<? extends T> var1, Predicate<? super T> var2) {
      ArrayList var3 = Lists.newArrayList();
      Iterator var4 = this.f.iterator();

      while(var4.hasNext()) {
         pk var5 = (pk)var4.next();
         if (var1.isAssignableFrom(var5.getClass()) && var2.apply(var5)) {
            var3.add(var5);
         }
      }

      return var3;
   }

   public boolean d(pk var1) {
      int var2 = ns.c(var1.s / 16.0D);
      int var3 = ns.c(var1.u / 16.0D);
      boolean var4 = var1.n;
      if (var1 instanceof wn) {
         var4 = true;
      }

      if (!var4 && !this.a(var2, var3, true)) {
         return false;
      } else {
         if (var1 instanceof wn) {
            wn var5 = (wn)var1;
            this.j.add(var5);
            this.d();
         }

         this.a(var2, var3).a(var1);
         this.f.add(var1);
         this.a(var1);
         return true;
      }
   }

   public float h(float var1) {
      return (this.q + (this.r - this.q) * var1) * this.j(var1);
   }

   public boolean a(wn var1, cj var2) {
      return true;
   }

   public double X() {
      return this.x.u() == adr.c ? 0.0D : 63.0D;
   }

   protected void b(pk var1) {
      for(int var2 = 0; var2 < this.u.size(); ++var2) {
         ((ado)this.u.get(var2)).b(var1);
      }

   }

   public String z() {
      return "All: " + this.f.size();
   }

   public void d() {
   }

   public void b(int var1) {
      this.a = var1;
   }

   public aui e(float var1) {
      float var2 = this.c(var1);
      float var3 = ns.b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
      var3 = ns.a(var3, 0.0F, 1.0F);
      float var4 = (float)(this.d >> 16 & 255L) / 255.0F;
      float var5 = (float)(this.d >> 8 & 255L) / 255.0F;
      float var6 = (float)(this.d & 255L) / 255.0F;
      float var7 = this.j(var1);
      float var8;
      float var9;
      if (var7 > 0.0F) {
         var8 = (var4 * 0.3F + var5 * 0.59F + var6 * 0.11F) * 0.6F;
         var9 = 1.0F - var7 * 0.95F;
         var4 = var4 * var9 + var8 * (1.0F - var9);
         var5 = var5 * var9 + var8 * (1.0F - var9);
         var6 = var6 * var9 + var8 * (1.0F - var9);
      }

      var4 *= var3 * 0.9F + 0.1F;
      var5 *= var3 * 0.9F + 0.1F;
      var6 *= var3 * 0.85F + 0.15F;
      var8 = this.h(var1);
      if (var8 > 0.0F) {
         var9 = (var4 * 0.3F + var5 * 0.59F + var6 * 0.11F) * 0.2F;
         float var10 = 1.0F - var8 * 0.95F;
         var4 = var4 * var10 + var9 * (1.0F - var10);
         var5 = var5 * var10 + var9 * (1.0F - var10);
         var6 = var6 * var10 + var9 * (1.0F - var10);
      }

      return new aui((double)var4, (double)var5, (double)var6);
   }

   public List<aug> a(pk var1, aug var2) {
      ArrayList var3 = Lists.newArrayList();
      int var4 = ns.c(var2.a);
      int var5 = ns.c(var2.d + 1.0D);
      int var6 = ns.c(var2.b);
      int var7 = ns.c(var2.e + 1.0D);
      int var8 = ns.c(var2.c);
      int var9 = ns.c(var2.f + 1.0D);
      ams var10 = this.af();
      boolean var11 = var1.aT();
      boolean var12 = this.a(var10, var1);
      alz var13 = afi.b.Q();
      cj.a var14 = new cj.a();

      for(int var15 = var4; var15 < var5; ++var15) {
         for(int var16 = var8; var16 < var9; ++var16) {
            if (this.e((cj)var14.c(var15, 64, var16))) {
               for(int var17 = var6 - 1; var17 < var7; ++var17) {
                  var14.c(var15, var17, var16);
                  if (var11 && var12) {
                     var1.h(false);
                  } else if (!var11 && !var12) {
                     var1.h(true);
                  }

                  alz var18 = var13;
                  if (var10.a((cj)var14) || !var12) {
                     var18 = this.p(var14);
                  }

                  var18.c().a(this, var14, var18, var2, var3, var1);
               }
            }
         }
      }

      double var20 = 0.25D;
      List var21 = this.b(var1, var2.b(var20, var20, var20));

      for(int var22 = 0; var22 < var21.size(); ++var22) {
         if (var1.l != var21 && var1.m != var21) {
            aug var19 = ((pk)var21.get(var22)).S();
            if (var19 != null && var19.b(var2)) {
               var3.add(var19);
            }

            var19 = var1.j((pk)var21.get(var22));
            if (var19 != null && var19.b(var2)) {
               var3.add(var19);
            }
         }
      }

      return var3;
   }

   public float a(aui var1, aug var2) {
      double var3 = 1.0D / ((var2.d - var2.a) * 2.0D + 1.0D);
      double var5 = 1.0D / ((var2.e - var2.b) * 2.0D + 1.0D);
      double var7 = 1.0D / ((var2.f - var2.c) * 2.0D + 1.0D);
      double var9 = (1.0D - Math.floor(1.0D / var3) * var3) / 2.0D;
      double var11 = (1.0D - Math.floor(1.0D / var7) * var7) / 2.0D;
      if (!(var3 < 0.0D) && !(var5 < 0.0D) && !(var7 < 0.0D)) {
         int var13 = 0;
         int var14 = 0;

         for(float var15 = 0.0F; var15 <= 1.0F; var15 = (float)((double)var15 + var3)) {
            for(float var16 = 0.0F; var16 <= 1.0F; var16 = (float)((double)var16 + var5)) {
               for(float var17 = 0.0F; var17 <= 1.0F; var17 = (float)((double)var17 + var7)) {
                  double var18 = var2.a + (var2.d - var2.a) * (double)var15;
                  double var20 = var2.b + (var2.e - var2.b) * (double)var16;
                  double var22 = var2.c + (var2.f - var2.c) * (double)var17;
                  if (this.a(new aui(var18 + var9, var20, var22 + var11), var1) == null) {
                     ++var13;
                  }

                  ++var14;
               }
            }
         }

         return (float)var13 / (float)var14;
      } else {
         return 0.0F;
      }
   }

   public boolean g(cj var1) {
      return this.a((cj)var1, (alz)afi.a.Q(), 3);
   }

   public boolean a(aqe var1) {
      return this.b(var1, true);
   }

   public int ac() {
      return this.J;
   }

   public boolean a(cj var1, int var2, boolean var3) {
      return this.a(var1.n() - var2, var1.o() - var2, var1.p() - var2, var1.n() + var2, var1.o() + var2, var1.p() + var2, var3);
   }

   public int a(cj var1, cq var2) {
      alz var3 = this.p(var1);
      return var3.c().b((adq)this, var1, var3, (cq)var2);
   }

   public void d(int var1) {
      this.J = var1;
   }

   public float c(float var1) {
      return this.t.a(this.x.g(), var1);
   }

   public void a(pk var1, boolean var2) {
      int var3 = ns.c(var1.s);
      int var4 = ns.c(var1.u);
      byte var5 = 32;
      if (!var2 || this.a(var3 - var5, 0, var4 - var5, var3 + var5, 0, var4 + var5, true)) {
         var1.P = var1.s;
         var1.Q = var1.t;
         var1.R = var1.u;
         var1.A = var1.y;
         var1.B = var1.z;
         if (var2 && var1.ad) {
            ++var1.W;
            if (var1.m != null) {
               var1.ak();
            } else {
               var1.t_();
            }
         }

         this.B.a("chunkCheck");
         if (Double.isNaN(var1.s) || Double.isInfinite(var1.s)) {
            var1.s = var1.P;
         }

         if (Double.isNaN(var1.t) || Double.isInfinite(var1.t)) {
            var1.t = var1.Q;
         }

         if (Double.isNaN(var1.u) || Double.isInfinite(var1.u)) {
            var1.u = var1.R;
         }

         if (Double.isNaN((double)var1.z) || Double.isInfinite((double)var1.z)) {
            var1.z = var1.B;
         }

         if (Double.isNaN((double)var1.y) || Double.isInfinite((double)var1.y)) {
            var1.y = var1.A;
         }

         int var6 = ns.c(var1.s / 16.0D);
         int var7 = ns.c(var1.t / 16.0D);
         int var8 = ns.c(var1.u / 16.0D);
         if (!var1.ad || var1.ae != var6 || var1.af != var7 || var1.ag != var8) {
            if (var1.ad && this.a(var1.ae, var1.ag, true)) {
               this.a(var1.ae, var1.ag).a(var1, var1.af);
            }

            if (this.a(var6, var8, true)) {
               var1.ad = true;
               this.a(var6, var8).a(var1);
            } else {
               var1.ad = false;
            }
         }

         this.B.b();
         if (var2 && var1.ad && var1.l != null) {
            if (!var1.l.I && var1.l.m == var1) {
               this.g(var1.l);
            } else {
               var1.l.m = null;
               var1.l = null;
            }
         }

      }
   }

   public void b(int var1, cj var2, int var3) {
      this.a((wn)null, var1, var2, var3);
   }

   public int y(cj var1) {
      byte var2 = 0;
      int var3 = Math.max(var2, this.a(var1.b(), cq.a));
      if (var3 >= 15) {
         return var3;
      } else {
         var3 = Math.max(var3, this.a(var1.a(), cq.b));
         if (var3 >= 15) {
            return var3;
         } else {
            var3 = Math.max(var3, this.a(var1.c(), cq.c));
            if (var3 >= 15) {
               return var3;
            } else {
               var3 = Math.max(var3, this.a(var1.d(), cq.d));
               if (var3 >= 15) {
                  return var3;
               } else {
                  var3 = Math.max(var3, this.a(var1.e(), cq.e));
                  if (var3 >= 15) {
                     return var3;
                  } else {
                     var3 = Math.max(var3, this.a(var1.f(), cq.f));
                     return var3 >= 15 ? var3 : var3;
                  }
               }
            }
         }
      }
   }

   public List<pk> a(pk var1, aug var2, Predicate<? super pk> var3) {
      ArrayList var4 = Lists.newArrayList();
      int var5 = ns.c((var2.a - 2.0D) / 16.0D);
      int var6 = ns.c((var2.d + 2.0D) / 16.0D);
      int var7 = ns.c((var2.c - 2.0D) / 16.0D);
      int var8 = ns.c((var2.f + 2.0D) / 16.0D);

      for(int var9 = var5; var9 <= var6; ++var9) {
         for(int var10 = var7; var10 <= var8; ++var10) {
            if (this.a(var9, var10, true)) {
               this.a(var9, var10).a((pk)var1, var2, var4, var3);
            }
         }
      }

      return var4;
   }

   public void i() {
      this.B.a("entities");
      this.B.a("global");

      int var1;
      pk var2;
      b var4;
      c var5;
      for(var1 = 0; var1 < this.k.size(); ++var1) {
         var2 = (pk)this.k.get(var1);

         try {
            ++var2.W;
            var2.t_();
         } catch (Throwable var9) {
            var4 = b.a(var9, "Ticking entity");
            var5 = var4.a("Entity being ticked");
            if (var2 == null) {
               var5.a((String)"Entity", (Object)"~~NULL~~");
            } else {
               var2.a(var5);
            }

            throw new e(var4);
         }

         if (var2.I) {
            this.k.remove(var1--);
         }
      }

      this.B.c("remove");
      this.f.removeAll(this.g);

      int var3;
      int var14;
      for(var1 = 0; var1 < this.g.size(); ++var1) {
         var2 = (pk)this.g.get(var1);
         var3 = var2.ae;
         var14 = var2.ag;
         if (var2.ad && this.a(var3, var14, true)) {
            this.a(var3, var14).b(var2);
         }
      }

      for(var1 = 0; var1 < this.g.size(); ++var1) {
         this.b((pk)this.g.get(var1));
      }

      this.g.clear();
      this.B.c("regular");

      for(var1 = 0; var1 < this.f.size(); ++var1) {
         var2 = (pk)this.f.get(var1);
         if (var2.m != null) {
            if (!var2.m.I && var2.m.l == var2) {
               continue;
            }

            var2.m.l = null;
            var2.m = null;
         }

         this.B.a("tick");
         if (!var2.I) {
            try {
               this.g(var2);
            } catch (Throwable var8) {
               var4 = b.a(var8, "Ticking entity");
               var5 = var4.a("Entity being ticked");
               var2.a(var5);
               throw new e(var4);
            }
         }

         this.B.b();
         this.B.a("remove");
         if (var2.I) {
            var3 = var2.ae;
            var14 = var2.ag;
            if (var2.ad && this.a(var3, var14, true)) {
               this.a(var3, var14).b(var2);
            }

            this.f.remove(var1--);
            this.b(var2);
         }

         this.B.b();
      }

      this.B.c("blockEntities");
      this.M = true;
      Iterator var15 = this.i.iterator();

      while(var15.hasNext()) {
         akw var10 = (akw)var15.next();
         if (!var10.x() && var10.t()) {
            cj var12 = var10.v();
            if (this.e(var12) && this.N.a(var12)) {
               try {
                  ((km)var10).c();
               } catch (Throwable var7) {
                  b var16 = b.a(var7, "Ticking block entity");
                  c var6 = var16.a("Block entity being ticked");
                  var10.a(var6);
                  throw new e(var16);
               }
            }
         }

         if (var10.x()) {
            var15.remove();
            this.h.remove(var10);
            if (this.e(var10.v())) {
               this.f(var10.v()).e(var10.v());
            }
         }
      }

      this.M = false;
      if (!this.c.isEmpty()) {
         this.i.removeAll(this.c);
         this.h.removeAll(this.c);
         this.c.clear();
      }

      this.B.c("pendingBlockEntities");
      if (!this.b.isEmpty()) {
         for(int var11 = 0; var11 < this.b.size(); ++var11) {
            akw var13 = (akw)this.b.get(var11);
            if (!var13.x()) {
               if (!this.h.contains(var13)) {
                  this.a(var13);
               }

               if (this.e(var13.v())) {
                  this.f(var13.v()).a(var13.v(), var13);
               }

               this.h(var13.v());
            }
         }

         this.b.clear();
      }

      this.B.b();
      this.B.b();
   }

   public List<pk> E() {
      return this.f;
   }

   public void a(String var1, ate var2) {
      this.z.a(var1, var2);
   }

   public long J() {
      return this.x.b();
   }

   public void a(wn var1, int var2, cj var3, int var4) {
      try {
         for(int var5 = 0; var5 < this.u.size(); ++var5) {
            ((ado)this.u.get(var5)).a(var1, var2, var3, var4);
         }

      } catch (Throwable var8) {
         b var6 = b.a(var8, "Playing level event");
         c var7 = var6.a("Level event being played");
         var7.a((String)"Block coordinates", (Object)c.a(var3));
         var7.a((String)"Event source", (Object)var1);
         var7.a((String)"Event type", (Object)var2);
         var7.a((String)"Event data", (Object)var4);
         throw new e(var6);
      }
   }

   public void a(wn var1, String var2, float var3, float var4) {
      for(int var5 = 0; var5 < this.u.size(); ++var5) {
         ((ado)this.u.get(var5)).a(var1, var2, var1.s, var1.t, var1.u, var3, var4);
      }

   }

   public float g(float var1) {
      float var2 = this.c(var1);
      float var3 = 1.0F - (ns.b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.25F);
      var3 = ns.a(var3, 0.0F, 1.0F);
      return var3 * var3 * 0.5F;
   }

   public long L() {
      return this.x.g();
   }

   public void b(long var1) {
      this.x.c(var1);
   }

   public void e(pk var1) {
      if (var1.l != null) {
         var1.l.a((pk)null);
      }

      if (var1.m != null) {
         var1.a((pk)null);
      }

      var1.J();
      if (var1 instanceof wn) {
         this.j.remove(var1);
         this.d();
         this.b(var1);
      }

   }

   public void c(cj var1, afh var2, int var3, int var4) {
      var2.a(this, var1, this.p(var1), var3, var4);
   }

   public static boolean a(adq var0, cj var1) {
      alz var2 = var0.p(var1);
      afh var3 = var2.c();
      if (var3.t().k() && var3.d()) {
         return true;
      } else if (var3 instanceof aju) {
         return var2.b(aju.b) == aju.a.a;
      } else if (var3 instanceof ahh) {
         return var2.b(ahh.a) == ahh.a.a;
      } else if (var3 instanceof ahn) {
         return true;
      } else if (var3 instanceof ajp) {
         return (Integer)var2.b(ajp.a) == 7;
      } else {
         return false;
      }
   }

   public boolean a(aug var1, pk var2) {
      List var3 = this.b((pk)null, (aug)var1);

      for(int var4 = 0; var4 < var3.size(); ++var4) {
         pk var5 = (pk)var3.get(var4);
         if (!var5.I && var5.k && var5 != var2 && (var2 == null || var2.m != var5 && var2.l != var5)) {
            return false;
         }
      }

      return true;
   }

   public afh c(cj var1) {
      cj var2;
      for(var2 = new cj(var1.n(), this.F(), var1.p()); !this.d(var2.a()); var2 = var2.a()) {
      }

      return this.p(var2).c();
   }

   public boolean c(aug var1) {
      int var2 = ns.c(var1.a);
      int var3 = ns.c(var1.d);
      int var4 = ns.c(var1.b);
      int var5 = ns.c(var1.e);
      int var6 = ns.c(var1.c);
      int var7 = ns.c(var1.f);
      cj.a var8 = new cj.a();

      for(int var9 = var2; var9 <= var3; ++var9) {
         for(int var10 = var4; var10 <= var5; ++var10) {
            for(int var11 = var6; var11 <= var7; ++var11) {
               afh var12 = this.p(var8.c(var9, var10, var11)).c();
               if (var12.t() != arm.a) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public void b(Collection<pk> var1) {
      this.f.addAll(var1);
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         pk var3 = (pk)var2.next();
         this.a(var3);
      }

   }

   public void b(cj var1, afh var2, int var3, int var4) {
   }

   public ams af() {
      return this.N;
   }

   public List<pk> b(pk var1, aug var2) {
      return this.a(var1, var2, po.d);
   }

   public void b(cj var1, cj var2) {
      this.b(var1.n(), var1.o(), var1.p(), var2.n(), var2.o(), var2.p());
   }

   public boolean f(cj var1, boolean var2) {
      ady var3 = this.b(var1);
      float var4 = var3.a(var1);
      if (var4 > 0.15F) {
         return false;
      } else if (!var2) {
         return true;
      } else {
         if (var1.o() >= 0 && var1.o() < 256 && this.b(ads.b, var1) < 10) {
            afh var5 = this.p(var1).c();
            if (var5.t() == arm.a && afi.aH.d(this, var1)) {
               return true;
            }
         }

         return false;
      }
   }

   public void a(int var1, cj var2, int var3) {
      for(int var4 = 0; var4 < this.u.size(); ++var4) {
         ((ado)this.u.get(var4)).a(var1, var2, var3);
      }

   }

   public akw s(cj var1) {
      if (!this.a(var1)) {
         return null;
      } else {
         akw var2 = null;
         int var3;
         akw var4;
         if (this.M) {
            for(var3 = 0; var3 < this.b.size(); ++var3) {
               var4 = (akw)this.b.get(var3);
               if (!var4.x() && var4.v().equals(var1)) {
                  var2 = var4;
                  break;
               }
            }
         }

         if (var2 == null) {
            var2 = this.f(var1).a(var1, amy.a.a);
         }

         if (var2 == null) {
            for(var3 = 0; var3 < this.b.size(); ++var3) {
               var4 = (akw)this.b.get(var3);
               if (!var4.x() && var4.v().equals(var1)) {
                  var2 = var4;
                  break;
               }
            }
         }

         return var2;
      }
   }

   public cj r(cj var1) {
      amy var2 = this.f(var1);

      cj var3;
      cj var4;
      for(var3 = new cj(var1.n(), var2.g() + 16, var1.p()); var3.o() >= 0; var3 = var4) {
         var4 = var3.b();
         arm var5 = var2.a(var4).t();
         if (var5.c() && var5 != arm.j) {
            break;
         }
      }

      return var3;
   }

   protected void a(int var1, int var2, amy var3) {
      this.B.c("moodSound");
      if (this.L == 0 && !this.D) {
         this.m = this.m * 3 + 1013904223;
         int var4 = this.m >> 2;
         int var5 = var4 & 15;
         int var6 = var4 >> 8 & 15;
         int var7 = var4 >> 16 & 255;
         cj var8 = new cj(var5, var7, var6);
         afh var9 = var3.a(var8);
         var5 += var1;
         var6 += var2;
         if (var9.t() == arm.a && this.k(var8) <= this.s.nextInt(8) && this.b(ads.a, var8) <= 0) {
            wn var10 = this.a((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D, 8.0D);
            if (var10 != null && var10.e((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D) > 4.0D) {
               this.a((double)var5 + 0.5D, (double)var7 + 0.5D, (double)var6 + 0.5D, "ambient.cave.cave", 0.7F, 0.8F + this.s.nextFloat() * 0.2F);
               this.L = this.s.nextInt(12000) + 6000;
            }
         }
      }

      this.B.c("checkLight");
      var3.m();
   }

   public int l(cj var1) {
      return this.c(var1, true);
   }

   public boolean b(cj var1, cq var2) {
      return this.c(var1, var2) > 0;
   }

   public wn b(UUID var1) {
      for(int var2 = 0; var2 < this.j.size(); ++var2) {
         wn var3 = (wn)this.j.get(var2);
         if (var1.equals(var3.aK())) {
            return var3;
         }
      }

      return null;
   }

   public void a(double var1, double var3, double var5, double var7, double var9, double var11, dn var13) {
   }

   public boolean i(cj var1) {
      return this.f(var1).d(var1);
   }

   protected abstract amv k();

   public boolean u(cj var1) {
      alz var2 = this.p(var1);
      aug var3 = var2.c().a(this, var1, var2);
      return var3 != null && var3.a() >= 1.0D;
   }

   public void a(afh var1, cj var2, Random var3) {
      this.e = true;
      var1.b(this, var2, this.p(var2), var3);
      this.e = false;
   }

   public float b(float var1) {
      float var2 = this.c(var1);
      float var3 = 1.0F - (ns.b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.2F);
      var3 = ns.a(var3, 0.0F, 1.0F);
      var3 = 1.0F - var3;
      var3 = (float)((double)var3 * (1.0D - (double)(this.j(var1) * 5.0F) / 16.0D));
      var3 = (float)((double)var3 * (1.0D - (double)(this.h(var1) * 5.0F) / 16.0D));
      return var3 * 0.8F + 0.2F;
   }

   public alz p(cj var1) {
      if (!this.a(var1)) {
         return afi.a.Q();
      } else {
         amy var2 = this.f(var1);
         return var2.g(var1);
      }
   }

   public boolean a(ams var1, pk var2) {
      double var3 = var1.b();
      double var5 = var1.c();
      double var7 = var1.d();
      double var9 = var1.e();
      if (var2.aT()) {
         ++var3;
         ++var5;
         --var7;
         --var9;
      } else {
         --var3;
         --var5;
         ++var7;
         ++var9;
      }

      return var2.s > var3 && var2.s < var7 && var2.u > var5 && var2.u < var9;
   }

   public auh a(aui var1, aui var2) {
      return this.a(var1, var2, false, false, false);
   }

   public <T extends pk> T a(Class<? extends T> var1, aug var2, T var3) {
      List var4 = this.a(var1, var2);
      pk var5 = null;
      double var6 = Double.MAX_VALUE;

      for(int var8 = 0; var8 < var4.size(); ++var8) {
         pk var9 = (pk)var4.get(var8);
         if (var9 != var3 && po.d.apply(var9)) {
            double var10 = var3.h(var9);
            if (!(var10 > var6)) {
               var5 = var9;
               var6 = var10;
            }
         }
      }

      return var5;
   }

   private boolean F(cj var1) {
      return this.p(var1).c().t() == arm.h;
   }

   public boolean v(cj var1) {
      return this.e(var1, false);
   }

   public boolean j(cj var1) {
      if (var1.o() >= this.F()) {
         return this.i(var1);
      } else {
         cj var2 = new cj(var1.n(), this.F(), var1.p());
         if (!this.i(var2)) {
            return false;
         } else {
            for(var2 = var2.b(); var2.o() > var1.o(); var2 = var2.b()) {
               afh var3 = this.p(var2).c();
               if (var3.p() > 0 && !var3.t().d()) {
                  return false;
               }
            }

            return true;
         }
      }
   }

   public int V() {
      return this.t.o() ? 128 : 256;
   }

   public aui a(pk var1, float var2) {
      float var3 = this.c(var2);
      float var4 = ns.b(var3 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
      var4 = ns.a(var4, 0.0F, 1.0F);
      int var5 = ns.c(var1.s);
      int var6 = ns.c(var1.t);
      int var7 = ns.c(var1.u);
      cj var8 = new cj(var5, var6, var7);
      ady var9 = this.b(var8);
      float var10 = var9.a(var8);
      int var11 = var9.a(var10);
      float var12 = (float)(var11 >> 16 & 255) / 255.0F;
      float var13 = (float)(var11 >> 8 & 255) / 255.0F;
      float var14 = (float)(var11 & 255) / 255.0F;
      var12 *= var4;
      var13 *= var4;
      var14 *= var4;
      float var15 = this.j(var2);
      float var16;
      float var17;
      if (var15 > 0.0F) {
         var16 = (var12 * 0.3F + var13 * 0.59F + var14 * 0.11F) * 0.6F;
         var17 = 1.0F - var15 * 0.75F;
         var12 = var12 * var17 + var16 * (1.0F - var17);
         var13 = var13 * var17 + var16 * (1.0F - var17);
         var14 = var14 * var17 + var16 * (1.0F - var17);
      }

      var16 = this.h(var2);
      if (var16 > 0.0F) {
         var17 = (var12 * 0.3F + var13 * 0.59F + var14 * 0.11F) * 0.2F;
         float var18 = 1.0F - var16 * 0.75F;
         var12 = var12 * var18 + var17 * (1.0F - var18);
         var13 = var13 * var18 + var17 * (1.0F - var18);
         var14 = var14 * var18 + var17 * (1.0F - var18);
      }

      if (this.J > 0) {
         var17 = (float)this.J - var2;
         if (var17 > 1.0F) {
            var17 = 1.0F;
         }

         var17 *= 0.45F;
         var12 = var12 * (1.0F - var17) + 0.8F * var17;
         var13 = var13 * (1.0F - var17) + 0.8F * var17;
         var14 = var14 * (1.0F - var17) + 1.0F * var17;
      }

      return new aui((double)var12, (double)var13, (double)var14);
   }

   public th ae() {
      return this.A;
   }

   public amy a(int var1, int var2) {
      return this.v.d(var1, var2);
   }

   public boolean x(cj var1) {
      boolean var2 = false;
      if (!this.t.o()) {
         var2 |= this.c(ads.a, var1);
      }

      var2 |= this.c(ads.b, var1);
      return var2;
   }

   public void a(ado var1) {
      this.u.add(var1);
   }

   public boolean e(aug var1) {
      int var2 = ns.c(var1.a);
      int var3 = ns.c(var1.d + 1.0D);
      int var4 = ns.c(var1.b);
      int var5 = ns.c(var1.e + 1.0D);
      int var6 = ns.c(var1.c);
      int var7 = ns.c(var1.f + 1.0D);
      if (this.a(var2, var4, var6, var3, var5, var7, true)) {
         cj.a var8 = new cj.a();

         for(int var9 = var2; var9 < var3; ++var9) {
            for(int var10 = var4; var10 < var5; ++var10) {
               for(int var11 = var6; var11 < var7; ++var11) {
                  afh var12 = this.p(var8.c(var9, var10, var11)).c();
                  if (var12 == afi.ab || var12 == afi.k || var12 == afi.l) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   private void a(int var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
      for(int var16 = 0; var16 < this.u.size(); ++var16) {
         ((ado)this.u.get(var16)).a(var1, var2, var3, var5, var7, var9, var11, var13, var15);
      }

   }

   public adk Q() {
      return this.x.x();
   }

   public boolean b(cj var1, boolean var2) {
      alz var3 = this.p(var1);
      afh var4 = var3.c();
      if (var4.t() == arm.a) {
         return false;
      } else {
         this.b(2001, var1, afh.f(var3));
         if (var2) {
            var4.b(this, var1, var3, 0);
         }

         return this.a((cj)var1, (alz)afi.a.Q(), 3);
      }
   }

   public void H() {
   }

   public int A(cj var1) {
      int var2 = 0;
      cq[] var3 = cq.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         cq var6 = var3[var5];
         int var7 = this.c(var1.a(var6), var6);
         if (var7 >= 15) {
            return 15;
         }

         if (var7 > var2) {
            var2 = var7;
         }
      }

      return var2;
   }

   protected void a(pk var1) {
      for(int var2 = 0; var2 < this.u.size(); ++var2) {
         ((ado)this.u.get(var2)).a(var1);
      }

   }

   public void n(cj var1) {
      for(int var2 = 0; var2 < this.u.size(); ++var2) {
         ((ado)this.u.get(var2)).b(var1);
      }

   }

   public void d(cj var1, afh var2) {
      if (!this.D) {
         alz var3 = this.p(var1);

         try {
            var3.c().a(this, var1, var3, var2);
         } catch (Throwable var7) {
            b var5 = b.a(var7, "Exception while updating neighbours");
            c var6 = var5.a("Block being updated");
            var6.a("Source block type", new Callable<String>(this, var2) {
               final adm b;
               final afh a;

               public String a() throws Exception {
                  try {
                     return String.format("ID #%d (%s // %s)", afh.a(this.a), this.a.a(), this.a.getClass().getCanonicalName());
                  } catch (Throwable var2) {
                     return "ID #" + afh.a(this.a);
                  }
               }

               public Object call() throws Exception {
                  return this.a();
               }

               {
                  this.b = var1;
                  this.a = var2;
               }
            });
            c.a(var6, var1, var3);
            throw new e(var5);
         }
      }
   }

   public void a(cj var1, afh var2, int var3) {
   }

   public void g(pk var1) {
      this.a(var1, true);
   }

   public cj m(cj var1) {
      int var2;
      if (var1.n() >= -30000000 && var1.p() >= -30000000 && var1.n() < 30000000 && var1.p() < 30000000) {
         if (this.a(var1.n() >> 4, var1.p() >> 4, true)) {
            var2 = this.a(var1.n() >> 4, var1.p() >> 4).b(var1.n() & 15, var1.p() & 15);
         } else {
            var2 = 0;
         }
      } else {
         var2 = this.F() + 1;
      }

      return new cj(var1.n(), var2, var1.p());
   }

   public cj M() {
      cj var1 = new cj(this.x.c(), this.x.d(), this.x.e());
      if (!this.af().a(var1)) {
         var1 = this.m(new cj(this.af().f(), 0.0D, this.af().g()));
      }

      return var1;
   }

   public void B() {
      int var1 = this.a(1.0F);
      if (var1 != this.I) {
         this.I = var1;
      }

   }

   public auh a(aui var1, aui var2, boolean var3, boolean var4, boolean var5) {
      if (!Double.isNaN(var1.a) && !Double.isNaN(var1.b) && !Double.isNaN(var1.c)) {
         if (!Double.isNaN(var2.a) && !Double.isNaN(var2.b) && !Double.isNaN(var2.c)) {
            int var6 = ns.c(var2.a);
            int var7 = ns.c(var2.b);
            int var8 = ns.c(var2.c);
            int var9 = ns.c(var1.a);
            int var10 = ns.c(var1.b);
            int var11 = ns.c(var1.c);
            cj var12 = new cj(var9, var10, var11);
            alz var13 = this.p(var12);
            afh var14 = var13.c();
            if ((!var4 || var14.a(this, var12, var13) != null) && var14.a(var13, var3)) {
               auh var15 = var14.a(this, var12, var1, var2);
               if (var15 != null) {
                  return var15;
               }
            }

            auh var40 = null;
            int var41 = 200;

            while(var41-- >= 0) {
               if (Double.isNaN(var1.a) || Double.isNaN(var1.b) || Double.isNaN(var1.c)) {
                  return null;
               }

               if (var9 == var6 && var10 == var7 && var11 == var8) {
                  return var5 ? var40 : null;
               }

               boolean var42 = true;
               boolean var16 = true;
               boolean var17 = true;
               double var18 = 999.0D;
               double var20 = 999.0D;
               double var22 = 999.0D;
               if (var6 > var9) {
                  var18 = (double)var9 + 1.0D;
               } else if (var6 < var9) {
                  var18 = (double)var9 + 0.0D;
               } else {
                  var42 = false;
               }

               if (var7 > var10) {
                  var20 = (double)var10 + 1.0D;
               } else if (var7 < var10) {
                  var20 = (double)var10 + 0.0D;
               } else {
                  var16 = false;
               }

               if (var8 > var11) {
                  var22 = (double)var11 + 1.0D;
               } else if (var8 < var11) {
                  var22 = (double)var11 + 0.0D;
               } else {
                  var17 = false;
               }

               double var24 = 999.0D;
               double var26 = 999.0D;
               double var28 = 999.0D;
               double var30 = var2.a - var1.a;
               double var32 = var2.b - var1.b;
               double var34 = var2.c - var1.c;
               if (var42) {
                  var24 = (var18 - var1.a) / var30;
               }

               if (var16) {
                  var26 = (var20 - var1.b) / var32;
               }

               if (var17) {
                  var28 = (var22 - var1.c) / var34;
               }

               if (var24 == -0.0D) {
                  var24 = -1.0E-4D;
               }

               if (var26 == -0.0D) {
                  var26 = -1.0E-4D;
               }

               if (var28 == -0.0D) {
                  var28 = -1.0E-4D;
               }

               cq var36;
               if (var24 < var26 && var24 < var28) {
                  var36 = var6 > var9 ? cq.e : cq.f;
                  var1 = new aui(var18, var1.b + var32 * var24, var1.c + var34 * var24);
               } else if (var26 < var28) {
                  var36 = var7 > var10 ? cq.a : cq.b;
                  var1 = new aui(var1.a + var30 * var26, var20, var1.c + var34 * var26);
               } else {
                  var36 = var8 > var11 ? cq.c : cq.d;
                  var1 = new aui(var1.a + var30 * var28, var1.b + var32 * var28, var22);
               }

               var9 = ns.c(var1.a) - (var36 == cq.f ? 1 : 0);
               var10 = ns.c(var1.b) - (var36 == cq.b ? 1 : 0);
               var11 = ns.c(var1.c) - (var36 == cq.d ? 1 : 0);
               var12 = new cj(var9, var10, var11);
               alz var37 = this.p(var12);
               afh var38 = var37.c();
               if (!var4 || var38.a(this, var12, var37) != null) {
                  if (var38.a(var37, var3)) {
                     auh var39 = var38.a(this, var12, var1, var2);
                     if (var39 != null) {
                        return var39;
                     }
                  } else {
                     var40 = new auh(auh.a.a, var1, var36, var12);
                  }
               }
            }

            return var5 ? var40 : null;
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   public void a(boolean var1, boolean var2) {
      this.F = var1;
      this.G = var2;
   }

   protected void p() {
      if (!this.t.o()) {
         if (!this.D) {
            int var1 = this.x.A();
            if (var1 > 0) {
               --var1;
               this.x.i(var1);
               this.x.f(this.x.n() ? 1 : 2);
               this.x.g(this.x.p() ? 1 : 2);
            }

            int var2 = this.x.o();
            if (var2 <= 0) {
               if (this.x.n()) {
                  this.x.f(this.s.nextInt(12000) + 3600);
               } else {
                  this.x.f(this.s.nextInt(168000) + 12000);
               }
            } else {
               --var2;
               this.x.f(var2);
               if (var2 <= 0) {
                  this.x.a(!this.x.n());
               }
            }

            this.q = this.r;
            if (this.x.n()) {
               this.r = (float)((double)this.r + 0.01D);
            } else {
               this.r = (float)((double)this.r - 0.01D);
            }

            this.r = ns.a(this.r, 0.0F, 1.0F);
            int var3 = this.x.q();
            if (var3 <= 0) {
               if (this.x.p()) {
                  this.x.g(this.s.nextInt(12000) + 12000);
               } else {
                  this.x.g(this.s.nextInt(168000) + 12000);
               }
            } else {
               --var3;
               this.x.g(var3);
               if (var3 <= 0) {
                  this.x.b(!this.x.p());
               }
            }

            this.o = this.p;
            if (this.x.p()) {
               this.p = (float)((double)this.p + 0.01D);
            } else {
               this.p = (float)((double)this.p - 0.01D);
            }

            this.p = ns.a(this.p, 0.0F, 1.0F);
         }
      }
   }

   public adi a(pk var1, double var2, double var4, double var6, float var8, boolean var9) {
      return this.a(var1, var2, var4, var6, var8, false, var9);
   }

   public auh a(aui var1, aui var2, boolean var3) {
      return this.a(var1, var2, var3, false, false);
   }

   public int a(float var1) {
      float var2 = this.c(var1);
      float var3 = 1.0F - (ns.b(var2 * 3.1415927F * 2.0F) * 2.0F + 0.5F);
      var3 = ns.a(var3, 0.0F, 1.0F);
      var3 = 1.0F - var3;
      var3 = (float)((double)var3 * (1.0D - (double)(this.j(var1) * 5.0F) / 16.0D));
      var3 = (float)((double)var3 * (1.0D - (double)(this.h(var1) * 5.0F) / 16.0D));
      var3 = 1.0F - var3;
      return (int)(var3 * 11.0F);
   }

   public aui f(float var1) {
      float var2 = this.c(var1);
      return this.t.b(var2, var1);
   }

   public void a(double var1, double var3, double var5, String var7, float var8, float var9) {
      for(int var10 = 0; var10 < this.u.size(); ++var10) {
         ((ado)this.u.get(var10)).a(var7, var1, var3, var5, var8, var9);
      }

   }

   public auo Z() {
      return this.C;
   }

   public boolean e(cj var1) {
      return this.a(var1, true);
   }

   protected boolean a(int var1, int var2, boolean var3) {
      return this.v.a(var1, var2) && (var3 || !this.v.d(var1, var2).f());
   }

   public boolean w() {
      return this.I < 4;
   }

   public List<adw> a(amy var1, boolean var2) {
      return null;
   }

   public float o(cj var1) {
      return this.t.p()[this.l(var1)];
   }

   public void a(double var1, double var3, double var5, String var7, float var8, float var9, boolean var10) {
   }

   public long K() {
      return this.x.f();
   }

   public String A() {
      return this.v.f();
   }

   public boolean a(cj var1, cj var2) {
      return this.a(var1, var2, true);
   }

   public void I() throws adn {
      this.w.c();
   }

   public int b(int var1, int var2) {
      if (var1 >= -30000000 && var2 >= -30000000 && var1 < 30000000 && var2 < 30000000) {
         if (!this.a(var1 >> 4, var2 >> 4, true)) {
            return 0;
         } else {
            amy var3 = this.a(var1 >> 4, var2 >> 4);
            return var3.v();
         }
      } else {
         return this.F() + 1;
      }
   }

   public void c(int var1) {
      this.I = var1;
   }

   public boolean a(aug var1, arm var2, pk var3) {
      int var4 = ns.c(var1.a);
      int var5 = ns.c(var1.d + 1.0D);
      int var6 = ns.c(var1.b);
      int var7 = ns.c(var1.e + 1.0D);
      int var8 = ns.c(var1.c);
      int var9 = ns.c(var1.f + 1.0D);
      if (!this.a(var4, var6, var8, var5, var7, var9, true)) {
         return false;
      } else {
         boolean var10 = false;
         aui var11 = new aui(0.0D, 0.0D, 0.0D);
         cj.a var12 = new cj.a();

         for(int var13 = var4; var13 < var5; ++var13) {
            for(int var14 = var6; var14 < var7; ++var14) {
               for(int var15 = var8; var15 < var9; ++var15) {
                  var12.c(var13, var14, var15);
                  alz var16 = this.p(var12);
                  afh var17 = var16.c();
                  if (var17.t() == var2) {
                     double var18 = (double)((float)(var14 + 1) - ahv.b((Integer)var16.b(ahv.b)));
                     if ((double)var7 >= var18) {
                        var10 = true;
                        var11 = var17.a((adm)this, var12, (pk)var3, (aui)var11);
                     }
                  }
               }
            }
         }

         if (var11.b() > 0.0D && var3.aL()) {
            var11 = var11.a();
            double var20 = 0.014D;
            var3.v += var11.a * var20;
            var3.w += var11.b * var20;
            var3.x += var11.c * var20;
         }

         return var10;
      }
   }

   public void a(cy var1, boolean var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
      this.a(var1.c(), var1.e() | var2, var3, var5, var7, var9, var11, var13, var15);
   }

   public ady b(cj var1) {
      if (this.e(var1)) {
         amy var2 = this.f(var1);

         try {
            return var2.a(var1, this.t.m());
         } catch (Throwable var6) {
            b var4 = b.a(var6, "Getting biome");
            c var5 = var4.a("Coordinates of biome request");
            var5.a("Location", new Callable<String>(this, var1) {
               final cj a;
               final adm b;

               public Object call() throws Exception {
                  return this.a();
               }

               {
                  this.b = var1;
                  this.a = var2;
               }

               public String a() throws Exception {
                  return c.a(this.a);
               }
            });
            throw new e(var4);
         }
      } else {
         return this.t.m().a(var1, ady.q);
      }
   }

   public oj aa() {
      return this.P().y();
   }

   public void c(int var1, cj var2, int var3) {
      for(int var4 = 0; var4 < this.u.size(); ++var4) {
         ado var5 = (ado)this.u.get(var4);
         var5.b(var1, var2, var3);
      }

   }

   public void a(cj var1, afh var2, int var3, int var4) {
   }

   public void B(cj var1) {
      this.x.a(var1);
   }

   public void a(int var1, int var2, int var3, int var4) {
      int var5;
      if (var3 > var4) {
         var5 = var4;
         var4 = var3;
         var3 = var5;
      }

      if (!this.t.o()) {
         for(var5 = var3; var5 <= var4; ++var5) {
            this.c(ads.a, new cj(var1, var5, var2));
         }
      }

      this.b(var1, var3, var2, var1, var4, var2);
   }

   public int k(cj var1) {
      if (var1.o() < 0) {
         return 0;
      } else {
         if (var1.o() >= 256) {
            var1 = new cj(var1.n(), 255, var1.p());
         }

         return this.f(var1).a((cj)var1, 0);
      }
   }

   public float d(float var1) {
      float var2 = this.c(var1);
      return var2 * 3.1415927F * 2.0F;
   }

   public aec v() {
      return this.t.m();
   }

   public void c() {
      this.p();
   }

   public boolean z(cj var1) {
      if (this.c(var1.b(), cq.a) > 0) {
         return true;
      } else if (this.c(var1.a(), cq.b) > 0) {
         return true;
      } else if (this.c(var1.c(), cq.c) > 0) {
         return true;
      } else if (this.c(var1.d(), cq.d) > 0) {
         return true;
      } else if (this.c(var1.e(), cq.e) > 0) {
         return true;
      } else {
         return this.c(var1.f(), cq.f) > 0;
      }
   }

   public void g() {
      this.B(new cj(8, 64, 8));
   }

   public <T extends pk> List<T> a(Class<? extends T> var1, aug var2, Predicate<? super T> var3) {
      int var4 = ns.c((var2.a - 2.0D) / 16.0D);
      int var5 = ns.c((var2.d + 2.0D) / 16.0D);
      int var6 = ns.c((var2.c - 2.0D) / 16.0D);
      int var7 = ns.c((var2.f + 2.0D) / 16.0D);
      ArrayList var8 = Lists.newArrayList();

      for(int var9 = var4; var9 <= var5; ++var9) {
         for(int var10 = var6; var10 <= var7; ++var10) {
            if (this.a(var9, var10, true)) {
               this.a(var9, var10).a((Class)var1, var2, var8, var3);
            }
         }
      }

      return var8;
   }

   public c a(b var1) {
      c var2 = var1.a("Affected level", 1);
      var2.a((String)"Level name", (Object)(this.x == null ? "????" : this.x.k()));
      var2.a("All players", new Callable<String>(this) {
         final adm a;

         public Object call() throws Exception {
            return this.a();
         }

         public String a() {
            return this.a.j.size() + " total; " + this.a.j.toString();
         }

         {
            this.a = var1;
         }
      });
      var2.a("Chunk stats", new Callable<String>(this) {
         final adm a;

         {
            this.a = var1;
         }

         public String a() {
            return this.a.v.f();
         }

         public Object call() throws Exception {
            return this.a();
         }
      });

      try {
         this.x.a(var2);
      } catch (Throwable var4) {
         var2.a("Level Data Unobtainable", var4);
      }

      return var2;
   }

   public boolean a(boolean var1) {
      return false;
   }

   public void b(ado var1) {
      this.u.remove(var1);
   }

   public void h(cj var1) {
      for(int var2 = 0; var2 < this.u.size(); ++var2) {
         ((ado)this.u.get(var2)).a(var1);
      }

   }

   public List<aug> a(aug var1) {
      ArrayList var2 = Lists.newArrayList();
      int var3 = ns.c(var1.a);
      int var4 = ns.c(var1.d + 1.0D);
      int var5 = ns.c(var1.b);
      int var6 = ns.c(var1.e + 1.0D);
      int var7 = ns.c(var1.c);
      int var8 = ns.c(var1.f + 1.0D);
      cj.a var9 = new cj.a();

      for(int var10 = var3; var10 < var4; ++var10) {
         for(int var11 = var7; var11 < var8; ++var11) {
            if (this.e((cj)var9.c(var10, 64, var11))) {
               for(int var12 = var5 - 1; var12 < var6; ++var12) {
                  var9.c(var10, var12, var11);
                  alz var13;
                  if (var10 >= -30000000 && var10 < 30000000 && var11 >= -30000000 && var11 < 30000000) {
                     var13 = this.p(var9);
                  } else {
                     var13 = afi.h.Q();
                  }

                  var13.c().a(this, var9, var13, var1, var2, (pk)null);
               }
            }
         }
      }

      return var2;
   }

   public boolean a(cj var1, alz var2) {
      return this.a((cj)var1, (alz)var2, 3);
   }

   public void t(cj var1) {
      akw var2 = this.s(var1);
      if (var2 != null && this.M) {
         var2.y();
         this.b.remove(var2);
      } else {
         if (var2 != null) {
            this.b.remove(var2);
            this.h.remove(var2);
            this.i.remove(var2);
         }

         this.f(var1).e(var1);
      }

   }

   public boolean c(pk var1) {
      this.k.add(var1);
      return true;
   }

   public void h(pk var1) {
      int var2 = ns.c(var1.s / 16.0D);
      int var3 = ns.c(var1.u / 16.0D);
      byte var4 = 2;

      for(int var5 = var2 - var4; var5 <= var2 + var4; ++var5) {
         for(int var6 = var3 - var4; var6 <= var3 + var4; ++var6) {
            this.a(var5, var6);
         }
      }

      if (!this.f.contains(var1)) {
         this.f.add(var1);
      }

   }

   public boolean a(cj var1, boolean var2) {
      return !this.a(var1) ? false : this.a(var1.n() >> 4, var1.p() >> 4, var2);
   }

   public boolean a(cj var1, afh var2) {
      return false;
   }

   public float y() {
      return anm.a[this.t.a(this.x.g())];
   }

   public void b(int var1, int var2, int var3, int var4, int var5, int var6) {
      for(int var7 = 0; var7 < this.u.size(); ++var7) {
         ((ado)this.u.get(var7)).a(var1, var2, var3, var4, var5, var6);
      }

   }

   protected void h() {
      this.D();
   }

   public float j(float var1) {
      return this.o + (this.p - this.o) * var1;
   }

   protected void D() {
      this.E.clear();
      this.B.a("buildList");

      int var1;
      wn var2;
      int var3;
      int var4;
      int var5;
      for(var1 = 0; var1 < this.j.size(); ++var1) {
         var2 = (wn)this.j.get(var1);
         var3 = ns.c(var2.s / 16.0D);
         var4 = ns.c(var2.u / 16.0D);
         var5 = this.q();

         for(int var6 = -var5; var6 <= var5; ++var6) {
            for(int var7 = -var5; var7 <= var5; ++var7) {
               this.E.add(new adg(var6 + var3, var7 + var4));
            }
         }
      }

      this.B.b();
      if (this.L > 0) {
         --this.L;
      }

      this.B.a("playerCheckLight");
      if (!this.j.isEmpty()) {
         var1 = this.s.nextInt(this.j.size());
         var2 = (wn)this.j.get(var1);
         var3 = ns.c(var2.s) + this.s.nextInt(11) - 5;
         var4 = ns.c(var2.t) + this.s.nextInt(11) - 5;
         var5 = ns.c(var2.u) + this.s.nextInt(11) - 5;
         this.x(new cj(var3, var4, var5));
      }

      this.B.b();
   }

   public atp O() {
      return this.w;
   }

   public boolean b(double var1, double var3, double var5, double var7) {
      for(int var9 = 0; var9 < this.j.size(); ++var9) {
         wn var10 = (wn)this.j.get(var9);
         if (po.d.apply(var10)) {
            double var11 = var10.e(var1, var3, var5);
            if (var7 < 0.0D || var11 < var7 * var7) {
               return true;
            }
         }
      }

      return false;
   }

   public boolean b(aug var1) {
      return this.a((aug)var1, (pk)null);
   }

   public Calendar Y() {
      if (this.K() % 600L == 0L) {
         this.K.setTimeInMillis(MinecraftServer.az());
      }

      return this.K;
   }

   public void a(pk var1, byte var2) {
   }

   public int a(Class<?> var1) {
      int var2 = 0;
      Iterator var3 = this.f.iterator();

      while(true) {
         pk var4;
         do {
            if (!var3.hasNext()) {
               return var2;
            }

            var4 = (pk)var3.next();
         } while(var4 instanceof ps && ((ps)var4).bZ());

         if (var1.isAssignableFrom(var4.getClass())) {
            ++var2;
         }
      }
   }

   public void a(cj var1, akw var2) {
      if (var2 != null && !var2.x()) {
         if (this.M) {
            var2.a(var1);
            Iterator var3 = this.b.iterator();

            while(var3.hasNext()) {
               akw var4 = (akw)var3.next();
               if (var4.v().equals(var1)) {
                  var4.y();
                  var3.remove();
               }
            }

            this.b.add(var2);
         } else {
            this.a(var2);
            this.f(var1).a(var1, var2);
         }
      }

   }

   public boolean b(aqe var1, boolean var2) {
      return this.a(var1.a, var1.b, var1.c, var1.d, var1.e, var1.f, var2);
   }

   public int b(String var1) {
      return this.z.a(var1);
   }

   public void a(long var1) {
      this.x.b(var1);
   }

   public adr G() {
      return this.x.u();
   }

   protected adm(atp var1, ato var2, anm var3, nt var4, boolean var5) {
      this.L = this.s.nextInt(12000);
      this.F = true;
      this.G = true;
      this.H = new int['耀'];
      this.w = var1;
      this.B = var4;
      this.x = var2;
      this.t = var3;
      this.D = var5;
      this.N = var3.r();
   }

   public void a(pk var1, String var2, float var3, float var4) {
      for(int var5 = 0; var5 < this.u.size(); ++var5) {
         ((ado)this.u.get(var5)).a(var2, var1.s, var1.t, var1.u, var3, var4);
      }

   }

   public Random a(int var1, int var2, int var3) {
      long var4 = (long)var1 * 341873128712L + (long)var2 * 132897987541L + this.P().b() + (long)var3;
      this.s.setSeed(var4);
      return this.s;
   }

   public boolean S() {
      return (double)this.j(1.0F) > 0.2D;
   }

   public boolean c(int var1, int var2) {
      cj var3 = this.M();
      int var4 = var1 * 16 + 8 - var3.n();
      int var5 = var2 * 16 + 8 - var3.p();
      short var6 = 128;
      return var4 >= -var6 && var4 <= var6 && var5 >= -var6 && var5 <= var6;
   }

   public cj a(String var1, cj var2) {
      return this.N().a(this, var1, var2);
   }

   public ate a(Class<? extends ate> var1, String var2) {
      return this.z.a(var1, var2);
   }

   private boolean a(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      if (var5 >= 0 && var2 < 256) {
         var1 >>= 4;
         var3 >>= 4;
         var4 >>= 4;
         var6 >>= 4;

         for(int var8 = var1; var8 <= var4; ++var8) {
            for(int var9 = var3; var9 <= var6; ++var9) {
               if (!this.a(var8, var9, var7)) {
                  return false;
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public adm b() {
      return this;
   }

   public ok E(cj var1) {
      long var2 = 0L;
      float var4 = 0.0F;
      if (this.e(var1)) {
         var4 = this.y();
         var2 = this.f(var1).w();
      }

      return new ok(this.aa(), this.L(), var2, var4);
   }

   public cj q(cj var1) {
      return this.f(var1).h(var1);
   }

   public boolean D(cj var1) {
      ady var2 = this.b(var1);
      return var2.f();
   }

   public int ab() {
      return this.I;
   }

   public void a(Collection<akw> var1) {
      if (this.M) {
         this.b.addAll(var1);
      } else {
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            akw var3 = (akw)var2.next();
            this.h.add(var3);
            if (var3 instanceof km) {
               this.i.add(var3);
            }
         }
      }

   }

   public int b(cj var1, int var2) {
      int var3 = this.a(ads.a, var1);
      int var4 = this.a(ads.b, var1);
      if (var4 < var2) {
         var4 = var2;
      }

      return var3 << 20 | var4 << 4;
   }

   private boolean a(cj var1) {
      return var1.n() >= -30000000 && var1.p() >= -30000000 && var1.n() < 30000000 && var1.p() < 30000000 && var1.o() >= 0 && var1.o() < 256;
   }

   public amy f(cj var1) {
      return this.a(var1.n() >> 4, var1.p() >> 4);
   }

   public void f(pk var1) {
      var1.J();
      if (var1 instanceof wn) {
         this.j.remove(var1);
         this.d();
      }

      int var2 = var1.ae;
      int var3 = var1.ag;
      if (var1.ad && this.a(var2, var3, true)) {
         this.a(var2, var3).b(var1);
      }

      this.f.remove(var1);
      this.b(var1);
   }

   public void k(float var1) {
      this.o = var1;
      this.p = var1;
   }

   public void b(akw var1) {
      this.c.add(var1);
   }
}
