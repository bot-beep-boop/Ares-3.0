import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class le extends adm implements od {
   private final adt R = new adt();
   private static final List<ob> U;
   private final adu Q;
   private List<adw> V = Lists.newArrayList();
   protected final tg d = new tg(this);
   private final MinecraftServer I;
   private final Map<UUID, pk> N = Maps.newHashMap();
   private int P;
   private le.a[] S = new le.a[]{new le.a(), new le.a()};
   private int T;
   public ld b;
   private final Set<adw> L = Sets.newHashSet();
   private final la J;
   private final lc K;
   private final TreeSet<adw> M = new TreeSet();
   public boolean c;
   private boolean O;
   private static final Logger a = LogManager.getLogger();

   public pk a(UUID var1) {
      return (pk)this.N.get(var1);
   }

   private boolean ai() {
      return this.I.ag();
   }

   protected cj a(cj var1) {
      cj var2 = this.q(var1);
      aug var3 = (new aug(var2, new cj(var2.n(), this.U(), var2.p()))).b(3.0D, 3.0D, 3.0D);
      List var4 = this.a(pr.class, var3, new Predicate<pr>(this) {
         final le a;

         public boolean apply(Object var1) {
            return this.a((pr)var1);
         }

         public boolean a(pr var1) {
            return var1 != null && var1.ai() && this.a.i(var1.c());
         }

         {
            this.a = var1;
         }
      });
      return !var4.isEmpty() ? ((pr)var4.get(this.s.nextInt(var4.size()))).c() : var2;
   }

   private void aj() {
      this.x.f(false);
      this.x.c(true);
      this.x.b(false);
      this.x.a(false);
      this.x.i(1000000000);
      this.x.c(6000L);
      this.x.a(adp.a.e);
      this.x.g(false);
      this.x.a(oj.a);
      this.x.e(true);
      this.Q().a("doDaylightCycle", "false");
   }

   public List<adw> a(aqe var1, boolean var2) {
      ArrayList var3 = null;

      for(int var4 = 0; var4 < 2; ++var4) {
         Iterator var5;
         if (var4 == 0) {
            var5 = this.M.iterator();
         } else {
            var5 = this.V.iterator();
         }

         while(var5.hasNext()) {
            adw var6 = (adw)var5.next();
            cj var7 = var6.a;
            if (var7.n() >= var1.a && var7.n() < var1.d && var7.p() >= var1.c && var7.p() < var1.f) {
               if (var2) {
                  this.L.remove(var6);
                  var5.remove();
               }

               if (var3 == null) {
                  var3 = Lists.newArrayList();
               }

               var3.add(var6);
            }
         }
      }

      return var3;
   }

   public void n() {
      if (this.v.e()) {
         this.v.c();
      }
   }

   public void a(pk var1, boolean var2) {
      if (!this.ai() && (var1 instanceof tm || var1 instanceof tz)) {
         var1.J();
      }

      if (!this.ah() && var1 instanceof wh) {
         var1.J();
      }

      super.a(var1, var2);
   }

   public void g() {
      if (this.x.d() <= 0) {
         this.x.b(this.F() + 1);
      }

      int var1 = this.x.c();
      int var2 = this.x.e();
      int var3 = 0;

      while(this.c(new cj(var1, 0, var2)).t() == arm.a) {
         var1 += this.s.nextInt(8) - this.s.nextInt(8);
         var2 += this.s.nextInt(8) - this.s.nextInt(8);
         ++var3;
         if (var3 == 10000) {
            break;
         }
      }

      this.x.a(var1);
      this.x.c(var2);
   }

   public boolean a(wn var1, cj var2) {
      return !this.I.a(this, var2, var1) && this.af().a(var2);
   }

   public void c() {
      super.c();
      if (this.P().t() && this.aa() != oj.d) {
         this.P().a(oj.d);
      }

      this.t.m().b();
      if (this.f()) {
         if (this.Q().b("doDaylightCycle")) {
            long var1 = this.x.g() + 24000L;
            this.x.c(var1 - var1 % 24000L);
         }

         this.e();
      }

      this.B.a("mobSpawner");
      if (this.Q().b("doMobSpawning") && this.x.u() != adr.g) {
         this.R.a(this, this.F, this.G, this.x.f() % 400L == 0L);
      }

      this.B.c("chunkSource");
      this.v.d();
      int var3 = this.a(1.0F);
      if (var3 != this.ab()) {
         this.c(var3);
      }

      this.x.b(this.x.f() + 1L);
      if (this.Q().b("doDaylightCycle")) {
         this.x.c(this.x.g() + 1L);
      }

      this.B.c("tickPending");
      this.a(false);
      this.B.c("tickBlocks");
      this.h();
      this.B.c("chunkMap");
      this.K.b();
      this.B.c("village");
      this.A.a();
      this.d.a();
      this.B.c("portalForcer");
      this.Q.a(this.K());
      this.B.b();
      this.ak();
   }

   private void b(adp var1) {
      if (!this.t.e()) {
         this.x.a(cj.a.b(this.t.i()));
      } else if (this.x.u() == adr.g) {
         this.x.a(cj.a.a());
      } else {
         this.y = true;
         aec var2 = this.t.m();
         List var3 = var2.a();
         Random var4 = new Random(this.J());
         cj var5 = var2.a(0, 0, 256, var3, var4);
         int var6 = 0;
         int var7 = this.t.i();
         int var8 = 0;
         if (var5 != null) {
            var6 = var5.n();
            var8 = var5.p();
         } else {
            a.warn("Unable to find spawn biome");
         }

         int var9 = 0;

         while(!this.t.a(var6, var8)) {
            var6 += var4.nextInt(64) - var4.nextInt(64);
            var8 += var4.nextInt(64) - var4.nextInt(64);
            ++var9;
            if (var9 == 1000) {
               break;
            }
         }

         this.x.a(new cj(var6, var7, var8));
         this.y = false;
         if (var1.c()) {
            this.l();
         }

      }
   }

   public adu u() {
      return this.Q;
   }

   protected int q() {
      return this.I.ap().s();
   }

   public boolean c(pk var1) {
      if (super.c(var1)) {
         this.I.ap().a(var1.s, var1.t, var1.u, 512.0D, this.t.q(), new fm(var1));
         return true;
      } else {
         return false;
      }
   }

   public boolean a(boolean var1) {
      if (this.x.u() == adr.g) {
         return false;
      } else {
         int var2 = this.M.size();
         if (var2 != this.L.size()) {
            throw new IllegalStateException("TickNextTick list out of synch");
         } else {
            if (var2 > 1000) {
               var2 = 1000;
            }

            this.B.a("cleaning");

            adw var4;
            for(int var3 = 0; var3 < var2; ++var3) {
               var4 = (adw)this.M.first();
               if (!var1 && var4.b > this.x.f()) {
                  break;
               }

               this.M.remove(var4);
               this.L.remove(var4);
               this.V.add(var4);
            }

            this.B.b();
            this.B.a("ticking");
            Iterator var11 = this.V.iterator();

            while(var11.hasNext()) {
               var4 = (adw)var11.next();
               var11.remove();
               byte var5 = 0;
               if (this.a((cj)var4.a.a(-var5, -var5, -var5), (cj)var4.a.a(var5, var5, var5))) {
                  alz var6 = this.p(var4.a);
                  if (var6.c().t() != arm.a && afh.a(var6.c(), var4.a())) {
                     try {
                        var6.c().b((adm)this, var4.a, var6, (Random)this.s);
                     } catch (Throwable var10) {
                        b var8 = b.a(var10, "Exception while ticking a block");
                        c var9 = var8.a("Block being ticked");
                        c.a(var9, var4.a, var6);
                        throw new e(var8);
                     }
                  }
               } else {
                  this.a(var4.a, var4.a(), 0);
               }
            }

            this.B.b();
            this.V.clear();
            return !this.M.isEmpty();
         }
      }
   }

   public adm b() {
      this.z = new aua(this.w);
      String var1 = th.a(this.t);
      th var2 = (th)this.z.a(th.class, var1);
      if (var2 == null) {
         this.A = new th(this);
         this.z.a((String)var1, (ate)this.A);
      } else {
         this.A = var2;
         this.A.a((adm)this);
      }

      this.C = new kk(this.I);
      aup var3 = (aup)this.z.a(aup.class, "scoreboard");
      if (var3 == null) {
         var3 = new aup();
         this.z.a((String)"scoreboard", (ate)var3);
      }

      var3.a(this.C);
      ((kk)this.C).a(var3);
      this.af().c(this.x.C(), this.x.D());
      this.af().c(this.x.I());
      this.af().b(this.x.H());
      this.af().c(this.x.J());
      this.af().b(this.x.K());
      if (this.x.F() > 0L) {
         this.af().a(this.x.E(), this.x.G(), this.x.F());
      } else {
         this.af().a(this.x.E());
      }

      return this;
   }

   protected void h() {
      super.h();
      if (this.x.u() == adr.g) {
         Iterator var20 = this.E.iterator();

         while(var20.hasNext()) {
            adg var21 = (adg)var20.next();
            this.a(var21.a, var21.b).b(false);
         }

      } else {
         int var1 = 0;
         int var2 = 0;

         for(Iterator var3 = this.E.iterator(); var3.hasNext(); this.B.b()) {
            adg var4 = (adg)var3.next();
            int var5 = var4.a * 16;
            int var6 = var4.b * 16;
            this.B.a("getChunk");
            amy var7 = this.a(var4.a, var4.b);
            this.a(var5, var6, var7);
            this.B.c("tickChunk");
            var7.b(false);
            this.B.c("thunder");
            int var8;
            cj var9;
            if (this.s.nextInt(100000) == 0 && this.S() && this.R()) {
               this.m = this.m * 3 + 1013904223;
               var8 = this.m >> 2;
               var9 = this.a(new cj(var5 + (var8 & 15), 0, var6 + (var8 >> 8 & 15)));
               if (this.C(var9)) {
                  this.c(new uv(this, (double)var9.n(), (double)var9.o(), (double)var9.p()));
               }
            }

            this.B.c("iceandsnow");
            if (this.s.nextInt(16) == 0) {
               this.m = this.m * 3 + 1013904223;
               var8 = this.m >> 2;
               var9 = this.q(new cj(var5 + (var8 & 15), 0, var6 + (var8 >> 8 & 15)));
               cj var10 = var9.b();
               if (this.w(var10)) {
                  this.a((cj)var10, (alz)afi.aI.Q());
               }

               if (this.S() && this.f(var9, true)) {
                  this.a((cj)var9, (alz)afi.aH.Q());
               }

               if (this.S() && this.b((cj)var10).e()) {
                  this.p(var10).c().k(this, var10);
               }
            }

            this.B.c("tickBlocks");
            var8 = this.Q().c("randomTickSpeed");
            if (var8 > 0) {
               amz[] var22 = var7.h();
               int var23 = var22.length;

               for(int var11 = 0; var11 < var23; ++var11) {
                  amz var12 = var22[var11];
                  if (var12 != null && var12.b()) {
                     for(int var13 = 0; var13 < var8; ++var13) {
                        this.m = this.m * 3 + 1013904223;
                        int var14 = this.m >> 2;
                        int var15 = var14 & 15;
                        int var16 = var14 >> 8 & 15;
                        int var17 = var14 >> 16 & 15;
                        ++var2;
                        alz var18 = var12.a(var15, var17, var16);
                        afh var19 = var18.c();
                        if (var19.y()) {
                           ++var1;
                           var19.a((adm)this, new cj(var15 + var5, var17 + var12.d(), var16 + var6), (alz)var18, (Random)this.s);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   public boolean a(cj var1, afh var2) {
      adw var3 = new adw(var1, var2);
      return this.V.contains(var3);
   }

   public void a(cy var1, double var2, double var4, double var6, int var8, double var9, double var11, double var13, double var15, int... var17) {
      this.a(var1, false, var2, var4, var6, var8, var9, var11, var13, var15, var17);
   }

   public void a(pk var1, byte var2) {
      this.s().b(var1, new gi(var1, var2));
   }

   protected void a() throws adn {
      this.I();
      this.x.a(this.af().h());
      this.x.d(this.af().f());
      this.x.c(this.af().g());
      this.x.e(this.af().m());
      this.x.f(this.af().n());
      this.x.j(this.af().q());
      this.x.k(this.af().p());
      this.x.b(this.af().j());
      this.x.e(this.af().i());
      this.w.a(this.x, this.I.ap().t());
      this.z.a();
   }

   protected void b(pk var1) {
      super.b(var1);
      this.l.d(var1.F());
      this.N.remove(var1.aK());
      pk[] var2 = var1.aB();
      if (var2 != null) {
         for(int var3 = 0; var3 < var2.length; ++var3) {
            this.l.d(var2[var3].F());
         }
      }

   }

   public adi a(pk var1, double var2, double var4, double var6, float var8, boolean var9, boolean var10) {
      adi var11 = new adi(this, var1, var2, var4, var6, var8, var9, var10);
      var11.a();
      var11.a(false);
      if (!var10) {
         var11.d();
      }

      Iterator var12 = this.j.iterator();

      while(var12.hasNext()) {
         wn var13 = (wn)var12.next();
         if (var13.e(var2, var4, var6) < 4096.0D) {
            ((lf)var13).a.a((ff)(new gk(var2, var4, var6, var8, var11.e(), (aui)var11.b().get(var13))));
         }
      }

      return var11;
   }

   public void i() {
      if (this.j.isEmpty()) {
         if (this.P++ >= 1200) {
            return;
         }
      } else {
         this.j();
      }

      super.i();
   }

   public void a(cy var1, boolean var2, double var3, double var5, double var7, int var9, double var10, double var12, double var14, double var16, int... var18) {
      gr var19 = new gr(var1, var2, (float)var3, (float)var5, (float)var7, (float)var10, (float)var12, (float)var14, (float)var16, var9, var18);

      for(int var20 = 0; var20 < this.j.size(); ++var20) {
         lf var21 = (lf)this.j.get(var20);
         cj var22 = var21.c();
         double var23 = var22.c(var3, var5, var7);
         if (var23 <= 256.0D || var2 && var23 <= 65536.0D) {
            var21.a.a((ff)var19);
         }
      }

   }

   public lc t() {
      return this.K;
   }

   private void ag() {
      this.x.g(0);
      this.x.b(false);
      this.x.f(0);
      this.x.a(false);
   }

   protected void a(pk var1) {
      super.a(var1);
      this.l.a(var1.F(), var1);
      this.N.put(var1.aK(), var1);
      pk[] var2 = var1.aB();
      if (var2 != null) {
         for(int var3 = 0; var3 < var2.length; ++var3) {
            this.l.a(var2[var3].F(), var2[var3]);
         }
      }

   }

   public cj m() {
      return this.t.h();
   }

   public void a(boolean var1, nu var2) throws adn {
      if (this.v.e()) {
         if (var2 != null) {
            var2.a("Saving level");
         }

         this.a();
         if (var2 != null) {
            var2.c("Saving chunks");
         }

         this.v.a(var1, var2);
         ArrayList var3 = Lists.newArrayList(this.b.a());
         Iterator var4 = var3.iterator();

         while(var4.hasNext()) {
            amy var5 = (amy)var4.next();
            if (var5 != null && !this.K.a(var5.a, var5.b)) {
               this.b.b(var5.a, var5.b);
            }
         }

      }
   }

   public void c(cj var1, afh var2, int var3, int var4) {
      ade var5 = new ade(var1, var2, var3, var4);
      Iterator var6 = this.S[this.T].iterator();

      ade var7;
      do {
         if (!var6.hasNext()) {
            this.S[this.T].add(var5);
            return;
         }

         var7 = (ade)var6.next();
      } while(!var7.equals(var5));

   }

   static {
      U = Lists.newArrayList(new ob[]{new ob(zy.y, 0, 1, 3, 10), new ob(zw.a(afi.f), 0, 1, 3, 10), new ob(zw.a(afi.r), 0, 1, 3, 10), new ob(zy.t, 0, 1, 1, 3), new ob(zy.p, 0, 1, 1, 5), new ob(zy.s, 0, 1, 1, 3), new ob(zy.o, 0, 1, 1, 5), new ob(zy.e, 0, 2, 3, 5), new ob(zy.P, 0, 2, 3, 3), new ob(zw.a(afi.s), 0, 1, 3, 10)});
   }

   public void a(cj var1, afh var2, int var3) {
      this.a(var1, var2, var3, 0);
   }

   protected void l() {
      aol var1 = new aol(U, 10);

      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = this.x.c() + this.s.nextInt(6) - this.s.nextInt(6);
         int var4 = this.x.e() + this.s.nextInt(6) - this.s.nextInt(6);
         cj var5 = this.r(new cj(var3, 0, var4)).a();
         if (var1.b(this, this.s, var5)) {
            break;
         }
      }

   }

   public void b(cj var1, afh var2, int var3, int var4) {
      adw var5 = new adw(var1, var2);
      var5.a(var4);
      if (var2.t() != arm.a) {
         var5.a((long)var3 + this.x.f());
      }

      if (!this.L.contains(var5)) {
         this.L.add(var5);
         this.M.add(var5);
      }

   }

   public ListenableFuture<Object> a(Runnable var1) {
      return this.I.a(var1);
   }

   public List<adw> a(amy var1, boolean var2) {
      adg var3 = var1.j();
      int var4 = (var3.a << 4) - 2;
      int var5 = var4 + 16 + 2;
      int var6 = (var3.b << 4) - 2;
      int var7 = var6 + 16 + 2;
      return this.a(new aqe(var4, 0, var6, var5, 256, var7), var2);
   }

   protected void e() {
      this.O = false;
      Iterator var1 = this.j.iterator();

      while(var1.hasNext()) {
         wn var2 = (wn)var1.next();
         if (var2.bJ()) {
            var2.a(false, false, true);
         }
      }

      this.ag();
   }

   private void ak() {
      while(!this.S[this.T].isEmpty()) {
         int var1 = this.T;
         this.T ^= 1;
         Iterator var2 = this.S[var1].iterator();

         while(var2.hasNext()) {
            ade var3 = (ade)var2.next();
            if (this.a(var3)) {
               this.I.ap().a((double)var3.a().n(), (double)var3.a().o(), (double)var3.a().p(), 64.0D, this.t.q(), new fu(var3.a(), var3.d(), var3.b(), var3.c()));
            }
         }

         this.S[var1].clear();
      }

   }

   public MinecraftServer r() {
      return this.I;
   }

   public le(MinecraftServer var1, atp var2, ato var3, int var4, nt var5) {
      super(var2, var3, anm.a(var4), var5, false);
      this.I = var1;
      this.J = new la(this);
      this.K = new lc(this);
      this.t.a(this);
      this.v = this.k();
      this.Q = new adu(this);
      this.B();
      this.C();
      this.af().a(var1.aI());
   }

   public la s() {
      return this.J;
   }

   public void a(cj var1, afh var2, int var3, int var4) {
      adw var5 = new adw(var1, var2);
      byte var6 = 0;
      if (this.e && var2.t() != arm.a) {
         if (var2.N()) {
            var6 = 8;
            if (this.a((cj)var5.a.a(-var6, -var6, -var6), (cj)var5.a.a(var6, var6, var6))) {
               alz var7 = this.p(var5.a);
               if (var7.c().t() != arm.a && var7.c() == var5.a()) {
                  var7.c().b((adm)this, var5.a, var7, (Random)this.s);
               }
            }

            return;
         }

         var3 = 1;
      }

      if (this.a((cj)var1.a(-var6, -var6, -var6), (cj)var1.a(var6, var6, var6))) {
         if (var2.t() != arm.a) {
            var5.a((long)var3 + this.x.f());
            var5.a(var4);
         }

         if (!this.L.contains(var5)) {
            this.L.add(var5);
            this.M.add(var5);
         }
      }

   }

   public boolean f() {
      if (this.O && !this.D) {
         Iterator var1 = this.j.iterator();

         wn var2;
         do {
            if (!var1.hasNext()) {
               return true;
            }

            var2 = (wn)var1.next();
         } while(!var2.v() && var2.cf());

         return false;
      } else {
         return false;
      }
   }

   public void j() {
      this.P = 0;
   }

   private boolean ah() {
      return this.I.ah();
   }

   public boolean a(pt var1, ady.c var2, cj var3) {
      List var4 = this.N().a(var1, var3);
      return var4 != null && !var4.isEmpty() ? var4.contains(var2) : false;
   }

   public void a(adp var1) {
      if (!this.x.w()) {
         try {
            this.b(var1);
            if (this.x.u() == adr.g) {
               this.aj();
            }

            super.a(var1);
         } catch (Throwable var6) {
            b var3 = b.a(var6, "Exception initializing level");

            try {
               this.a((b)var3);
            } catch (Throwable var5) {
            }

            throw new e(var3);
         }

         this.x.d(true);
      }

   }

   public ady.c a(pt var1, cj var2) {
      List var3 = this.N().a(var1, var2);
      return var3 != null && !var3.isEmpty() ? (ady.c)oa.a(this.s, var3) : null;
   }

   protected void p() {
      boolean var1 = this.S();
      super.p();
      if (this.o != this.p) {
         this.I.ap().a((ff)(new gm(7, this.p)), this.t.q());
      }

      if (this.q != this.r) {
         this.I.ap().a((ff)(new gm(8, this.r)), this.t.q());
      }

      if (var1 != this.S()) {
         if (var1) {
            this.I.ap().a((ff)(new gm(2, 0.0F)));
         } else {
            this.I.ap().a((ff)(new gm(1, 0.0F)));
         }

         this.I.ap().a((ff)(new gm(7, this.p)));
         this.I.ap().a((ff)(new gm(8, this.r)));
      }

   }

   private boolean a(ade var1) {
      alz var2 = this.p(var1.a());
      return var2.c() == var1.d() ? var2.c().a(this, var1.a(), var2, var1.b(), var1.c()) : false;
   }

   public boolean aJ() {
      return this.I.aJ();
   }

   public List<akw> a(int var1, int var2, int var3, int var4, int var5, int var6) {
      ArrayList var7 = Lists.newArrayList();

      for(int var8 = 0; var8 < this.h.size(); ++var8) {
         akw var9 = (akw)this.h.get(var8);
         cj var10 = var9.v();
         if (var10.n() >= var1 && var10.o() >= var2 && var10.p() >= var3 && var10.n() < var4 && var10.o() < var5 && var10.p() < var6) {
            var7.add(var9);
         }
      }

      return var7;
   }

   public void d() {
      this.O = false;
      if (!this.j.isEmpty()) {
         int var1 = 0;
         int var2 = 0;
         Iterator var3 = this.j.iterator();

         while(var3.hasNext()) {
            wn var4 = (wn)var3.next();
            if (var4.v()) {
               ++var1;
            } else if (var4.bJ()) {
               ++var2;
            }
         }

         this.O = var2 > 0 && var2 >= this.j.size() - var1;
      }

   }

   public void o() {
      this.w.a();
   }

   protected amv k() {
      and var1 = this.w.a(this.t);
      this.b = new ld(this, var1, this.t.c());
      return this.b;
   }

   static class a extends ArrayList<ade> {
      a(Object var1) {
         this();
      }

      private a() {
      }
   }
}
