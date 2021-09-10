import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.authlib.GameProfile;
import io.netty.buffer.Unpooled;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class lf extends wn implements xn {
   private boolean bO = true;
   private boolean bS = true;
   private pk bU = null;
   public double d;
   public final List<adg> f = Lists.newLinkedList();
   private wn.b bR;
   private float bM = -1.0E8F;
   private float bL = Float.MIN_VALUE;
   public final MinecraftServer b;
   private String bI = "en_US";
   private final List<Integer> bJ = Lists.newLinkedList();
   public lm a;
   private static final Logger bH = LogManager.getLogger();
   private int bQ = 60;
   public final lg c;
   public boolean i;
   public boolean g;
   private long bT = System.currentTimeMillis();
   private int bN = -99999999;
   public int h;
   private final mv bK;
   private int bV;
   public double e;
   private int bP = -99999999;

   public void b(eu var1) {
      this.a.a((ff)(new fy(var1)));
   }

   public void a(mw var1, int var2) {
      if (var1 != null) {
         this.bK.b(this, var1, var2);
         Iterator var3 = this.cp().a(var1.k()).iterator();

         while(var3.hasNext()) {
            auk var4 = (auk)var3.next();
            this.cp().c(this.e_(), var4).a(var2);
         }

         if (this.bK.e()) {
            this.bK.a(this);
         }

      }
   }

   public void q() {
      if (this.l != null) {
         this.l.a((pk)this);
      }

      if (this.bw) {
         this.a(true, false, false);
      }

   }

   protected void s() {
      this.a.a((ff)(new gi(this, (byte)9)));
      super.s();
   }

   protected void a(double var1, boolean var3, afh var4, cj var5) {
   }

   public void a(pk var1, int var2) {
      super.a((pk)var1, var2);
      this.bk.b();
   }

   public void a(og var1) {
      if (this.bk != this.bj) {
         this.n();
      }

      if (var1 instanceof oo) {
         oo var2 = (oo)var1;
         if (var2.r_() && !this.a((on)var2.i()) && !this.v()) {
            this.a.a((ff)(new fy(new fb("container.isLocked", new Object[]{var1.f_()}), (byte)2)));
            this.a.a((ff)(new gs("random.door_close", this.s, this.t, this.u, 1.0F, 1.0F)));
            return;
         }
      }

      this.cs();
      if (var1 instanceof ol) {
         this.a.a((ff)(new gc(this.bV, ((ol)var1).k(), var1.f_(), var1.o_())));
         this.bk = ((ol)var1).a(this.bi, this);
      } else {
         this.a.a((ff)(new gc(this.bV, "minecraft:container", var1.f_(), var1.o_())));
         this.bk = new xo(this.bi, var1, this);
      }

      this.bk.d = this.bV;
      this.bk.a((xn)this);
   }

   protected void b(pf var1) {
      super.b((pf)var1);
      this.a.a((ff)(new hc(this.F(), var1)));
   }

   public void a(adp.a var1) {
      this.c.a(var1);
      this.a.a((ff)(new gm(3, (float)var1.a())));
      if (var1 == adp.a.e) {
         this.a((pk)null);
      } else {
         this.e(this);
      }

      this.t();
      this.bP();
   }

   public void a(aln var1) {
      var1.a((wn)this);
      this.a.a((ff)(new gw(var1.v())));
   }

   public void g_() {
      this.bk.a((xn)this);
   }

   private boolean cr() {
      return this.b.aj();
   }

   public void h_() {
      super.h_();
      this.a.a((ff)(new gy(this.bs(), gy.a.a)));
   }

   public void e(pk var1) {
      pk var2 = this.C();
      this.bU = (pk)(var1 == null ? this : var1);
      if (var2 != this.bU) {
         this.a.a((ff)(new hh(this.bU)));
         this.a(this.bU.s, this.bU.t, this.bU.u);
      }

   }

   public void f(pk var1) {
      if (this.c.b() == adp.a.e) {
         this.e(var1);
      } else {
         super.f(var1);
      }

   }

   public void d(pk var1) {
      if (var1 instanceof wn) {
         this.a.a((ff)(new hb(new int[]{var1.F()})));
      } else {
         this.bJ.add(var1.F());
      }

   }

   public void b(pk var1) {
      this.u().s().b(this, new fq(var1, 4));
   }

   public void c(int var1) {
      if (this.am == 1 && var1 == 1) {
         this.b((mw)mr.D);
         this.o.e((pk)this);
         this.i = true;
         this.a.a((ff)(new gm(4, 0.0F)));
      } else {
         if (this.am == 0 && var1 == 1) {
            this.b((mw)mr.C);
            cj var2 = this.b.a(var1).m();
            if (var2 != null) {
               this.a.a((double)var2.n(), (double)var2.o(), (double)var2.p(), 0.0F, 0.0F);
            }

            var1 = 1;
         } else {
            this.b((mw)mr.y);
         }

         this.b.ap().a(this, var1);
         this.bP = -1;
         this.bM = -1.0F;
         this.bN = -1;
      }

   }

   private void a(akw var1) {
      if (var1 != null) {
         ff var2 = var1.y_();
         if (var2 != null) {
            this.a.a(var2);
         }
      }

   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("playerGameType", this.c.b().a());
   }

   public void a(wn var1, boolean var2) {
      super.a(var1, var2);
      this.bP = -1;
      this.bM = -1.0F;
      this.bN = -1;
      this.bJ.addAll(((lf)var1).bJ);
   }

   public void a(ih var1) {
      this.bI = var1.a();
      this.bR = var1.c();
      this.bS = var1.d();
      this.H().b(10, (byte)var1.e());
   }

   public boolean v() {
      return this.c.b() == adp.a.e;
   }

   public void t_() {
      this.c.a();
      --this.bQ;
      if (this.Z > 0) {
         --this.Z;
      }

      this.bk.b();
      if (!this.o.D && !this.bk.a((wn)this)) {
         this.n();
         this.bk = this.bj;
      }

      while(!this.bJ.isEmpty()) {
         int var1 = Math.min(this.bJ.size(), Integer.MAX_VALUE);
         int[] var2 = new int[var1];
         Iterator var3 = this.bJ.iterator();
         int var4 = 0;

         while(var3.hasNext() && var4 < var1) {
            var2[var4++] = (Integer)var3.next();
            var3.remove();
         }

         this.a.a((ff)(new hb(var2)));
      }

      if (!this.f.isEmpty()) {
         ArrayList var6 = Lists.newArrayList();
         Iterator var8 = this.f.iterator();
         ArrayList var9 = Lists.newArrayList();

         amy var5;
         while(var8.hasNext() && var6.size() < 10) {
            adg var10 = (adg)var8.next();
            if (var10 != null) {
               if (this.o.e(new cj(var10.a << 4, 0, var10.b << 4))) {
                  var5 = this.o.a(var10.a, var10.b);
                  if (var5.i()) {
                     var6.add(var5);
                     var9.addAll(((le)this.o).a(var10.a * 16, 0, var10.b * 16, var10.a * 16 + 16, 256, var10.b * 16 + 16));
                     var8.remove();
                  }
               }
            } else {
               var8.remove();
            }
         }

         if (!var6.isEmpty()) {
            if (var6.size() == 1) {
               this.a.a((ff)(new go((amy)var6.get(0), true, 65535)));
            } else {
               this.a.a((ff)(new gp(var6)));
            }

            Iterator var11 = var9.iterator();

            while(var11.hasNext()) {
               akw var12 = (akw)var11.next();
               this.a(var12);
            }

            var11 = var6.iterator();

            while(var11.hasNext()) {
               var5 = (amy)var11.next();
               this.u().s().a(this, var5);
            }
         }
      }

      pk var7 = this.C();
      if (var7 != this) {
         if (!var7.ai()) {
            this.e(this);
         } else {
            this.a(var7.s, var7.t, var7.u, var7.y, var7.z);
            this.b.ap().d(this);
            if (this.av()) {
               this.e(this);
            }
         }
      }

   }

   public pk C() {
      return (pk)(this.bU == null ? this : this.bU);
   }

   public void a(mw var1) {
      if (var1 != null) {
         this.bK.a(this, var1, 0);
         Iterator var2 = this.cp().a(var1.k()).iterator();

         while(var2.hasNext()) {
            auk var3 = (auk)var2.next();
            this.cp().c(this.e_(), var3).c(0);
         }

         if (this.bK.e()) {
            this.bK.a(this);
         }

      }
   }

   public void l() {
      try {
         super.t_();

         for(int var1 = 0; var1 < this.bi.o_(); ++var1) {
            zx var6 = this.bi.a(var1);
            if (var6 != null && var6.b().f()) {
               ff var8 = ((yy)var6.b()).c(var6, this.o, this);
               if (var8 != null) {
                  this.a.a(var8);
               }
            }
         }

         if (this.bn() != this.bM || this.bN != this.bl.a() || this.bl.e() == 0.0F != this.bO) {
            this.a.a((ff)(new hp(this.bn(), this.bl.a(), this.bl.e())));
            this.bM = this.bn();
            this.bN = this.bl.a();
            this.bO = this.bl.e() == 0.0F;
         }

         if (this.bn() + this.bN() != this.bL) {
            this.bL = this.bn() + this.bN();
            Collection var5 = this.cp().a(auu.g);
            Iterator var7 = var5.iterator();

            while(var7.hasNext()) {
               auk var9 = (auk)var7.next();
               this.cp().c(this.e_(), var9).a(Arrays.asList(this));
            }
         }

         if (this.bC != this.bP) {
            this.bP = this.bC;
            this.a.a((ff)(new ho(this.bD, this.bC, this.bB)));
         }

         if (this.W % 20 * 5 == 0 && !this.A().a((mq)mr.L)) {
            this.i_();
         }

      } catch (Throwable var4) {
         .b var2 = .b.a(var4, "Ticking player");
         c var3 = var2.a("Player being ticked");
         this.a((c)var3);
         throw new e(var2);
      }
   }

   public void t() {
      if (this.a != null) {
         this.a.a((ff)(new gx(this.bA)));
         this.B();
      }
   }

   public void a(xi var1, List<zx> var2) {
      this.a.a((ff)(new gd(var1.d, var2)));
      this.a.a((ff)(new gf(-1, -1, this.bi.p())));
   }

   public void a(ow var1) {
      if (this.o.Q().b("showDeathMessages")) {
         auq var2 = this.bO();
         if (var2 != null && var2.j() != auq.a.a) {
            if (var2.j() == auq.a.c) {
               this.b.ap().a((wn)this, (eu)this.bs().b());
            } else if (var2.j() == auq.a.d) {
               this.b.ap().b((wn)this, (eu)this.bs().b());
            }
         } else {
            this.b.ap().a(this.bs().b());
         }
      }

      if (!this.o.Q().b("keepInventory")) {
         this.bi.n();
      }

      Collection var6 = this.o.Z().a(auu.d);
      Iterator var3 = var6.iterator();

      while(var3.hasNext()) {
         auk var4 = (auk)var3.next();
         aum var5 = this.cp().c(this.e_(), var4);
         var5.a();
      }

      pr var7 = this.bt();
      if (var7 != null) {
         pm.a var8 = (pm.a)pm.a.get(pm.a((pk)var7));
         if (var8 != null) {
            this.b((mw)var8.e);
         }

         var7.b(this, this.aW);
      }

      this.b((mw)na.y);
      this.a(na.h);
      this.bs().g();
   }

   public void a(pk var1) {
      pk var2 = this.m;
      super.a((pk)var1);
      if (var1 != var2) {
         this.a.a((ff)(new hl(0, this, this.m)));
         this.a.a(this.s, this.t, this.u, this.y, this.z);
      }

   }

   public void a(dn var1) {
      super.a(var1);
      if (var1.b("playerGameType", 99)) {
         if (MinecraftServer.N().ax()) {
            this.c.a(MinecraftServer.N().m());
         } else {
            this.c.a(adp.a.a(var1.f("playerGameType")));
         }
      }

   }

   public wn.b y() {
      return this.bR;
   }

   public void b(int var1) {
      super.b(var1);
      this.bP = -1;
   }

   protected void a(pf var1) {
      super.a((pf)var1);
      this.a.a((ff)(new ib(this.F(), var1)));
   }

   public void a(xi var1) {
      this.a(var1, var1.a());
   }

   public eu E() {
      return null;
   }

   public void a(boolean var1, boolean var2, boolean var3) {
      if (this.bJ()) {
         this.u().s().b(this, new fq(this, 2));
      }

      super.a(var1, var2, var3);
      if (this.a != null) {
         this.a.a(this.s, this.t, this.u, this.y, this.z);
      }

   }

   public void o() {
      if (!this.g) {
         this.a.a((ff)(new gf(-1, -1, this.bi.p())));
      }
   }

   public void a(zx var1, int var2) {
      super.a(var1, var2);
      if (var1 != null && var1.b() != null && var1.b().e(var1) == aba.b) {
         this.u().s().b(this, new fq(this, 3));
      }

   }

   public void a(xi var1, int var2, zx var3) {
      if (!(var1.a(var2) instanceof yf)) {
         if (!this.g) {
            this.a.a((ff)(new gf(var1.d, var2, var3)));
         }
      }
   }

   public void a(double var1, double var3, double var5) {
      this.a.a(var1, var3, var5, this.y, this.z);
   }

   public void a(tp var1, og var2) {
      if (this.bk != this.bj) {
         this.n();
      }

      this.cs();
      this.a.a((ff)(new gc(this.bV, "EntityHorse", var2.f_(), var2.o_(), var1.F())));
      this.bk = new xx(this.bi, var2, var1, this);
      this.bk.d = this.bV;
      this.bk.a((xn)this);
   }

   public void a(int var1) {
      super.a(var1);
      this.bP = -1;
   }

   private void cs() {
      this.bV = this.bV % 100 + 1;
   }

   public long D() {
      return this.bT;
   }

   public void p() {
      this.bk.b((wn)this);
      this.bk = this.bj;
   }

   public void a(float var1, float var2, boolean var3, boolean var4) {
      if (this.m != null) {
         if (var1 >= -1.0F && var1 <= 1.0F) {
            this.aZ = var1;
         }

         if (var2 >= -1.0F && var2 <= 1.0F) {
            this.ba = var2;
         }

         this.aY = var3;
         this.c(var4);
      }

   }

   protected void a(pf var1, boolean var2) {
      super.a((pf)var1, var2);
      this.a.a((ff)(new ib(this.F(), var1)));
   }

   public void a(zx var1) {
      zw var2 = var1.b();
      if (var2 == zy.bN) {
         this.a.a((ff)(new gg("MC|BOpen", new em(Unpooled.buffer()))));
      }

   }

   public void a(double var1, boolean var3) {
      int var4 = ns.c(this.s);
      int var5 = ns.c(this.t - 0.20000000298023224D);
      int var6 = ns.c(this.u);
      cj var7 = new cj(var4, var5, var6);
      afh var8 = this.o.p(var7).c();
      if (var8.t() == arm.a) {
         afh var9 = this.o.p(var7.b()).c();
         if (var9 instanceof agt || var9 instanceof akl || var9 instanceof agu) {
            var7 = var7.b();
            var8 = this.o.p(var7).c();
         }
      }

      super.a(var1, var3, var8, var7);
   }

   public cj c() {
      return new cj(this.s, this.t + 0.5D, this.u);
   }

   public void c(pk var1) {
      this.u().s().b(this, new fq(var1, 5));
   }

   protected void i_() {
      ady var1 = this.o.b(new cj(ns.c(this.s), 0, ns.c(this.u)));
      String var2 = var1.ah;
      nc var3 = (nc)this.A().b(mr.L);
      if (var3 == null) {
         var3 = (nc)this.A().a(mr.L, new nc());
      }

      var3.add(var2);
      if (this.A().b(mr.L) && var3.size() >= ady.n.size()) {
         HashSet var4 = Sets.newHashSet(ady.n);
         Iterator var5 = var3.iterator();

         while(var5.hasNext()) {
            String var6 = (String)var5.next();
            Iterator var7 = var4.iterator();

            while(var7.hasNext()) {
               ady var8 = (ady)var7.next();
               if (var8.ah.equals(var6)) {
                  var7.remove();
               }
            }

            if (var4.isEmpty()) {
               break;
            }
         }

         if (var4.isEmpty()) {
            this.b((mw)mr.L);
         }
      }

   }

   public wn.a a(cj var1) {
      wn.a var2 = super.a(var1);
      if (var2 == wn.a.a) {
         ha var3 = new ha(this, var1);
         this.u().s().a((pk)this, (ff)var3);
         this.a.a(this.s, this.t, this.u, this.y, this.z);
         this.a.a((ff)var3);
      }

      return var2;
   }

   public void a(xi var1, og var2) {
      for(int var3 = 0; var3 < var2.g(); ++var3) {
         this.a.a((ff)(new ge(var1.d, var3, var2.a_(var3))));
      }

   }

   public boolean a(ow var1, float var2) {
      if (this.b((ow)var1)) {
         return false;
      } else {
         boolean var3 = this.b.ae() && this.cr() && "fall".equals(var1.p);
         if (!var3 && this.bQ > 0 && var1 != ow.j) {
            return false;
         } else {
            if (var1 instanceof ox) {
               pk var4 = var1.j();
               if (var4 instanceof wn && !this.a((wn)var4)) {
                  return false;
               }

               if (var4 instanceof wq) {
                  wq var5 = (wq)var4;
                  if (var5.c instanceof wn && !this.a((wn)var5.c)) {
                     return false;
                  }
               }
            }

            return super.a(var1, var2);
         }
      }
   }

   public boolean a(lf var1) {
      if (var1.v()) {
         return this.C() == this;
      } else {
         return this.v() ? false : super.a((lf)var1);
      }
   }

   public void j() {
      super.j();
      this.a.a((ff)(new gy(this.bs(), gy.a.b)));
   }

   public String w() {
      String var1 = this.a.a.b().toString();
      var1 = var1.substring(var1.indexOf("/") + 1);
      var1 = var1.substring(0, var1.indexOf(":"));
      return var1;
   }

   public mv A() {
      return this.bK;
   }

   public void a(acy var1) {
      this.cs();
      this.bk = new yb(this.bi, var1, this.o);
      this.bk.d = this.bV;
      this.bk.a((xn)this);
      ya var2 = ((yb)this.bk).e();
      eu var3 = var1.f_();
      this.a.a((ff)(new gc(this.bV, "minecraft:villager", var3, var2.o_())));
      ada var4 = var1.b_(this);
      if (var4 != null) {
         em var5 = new em(Unpooled.buffer());
         var5.writeInt(this.bV);
         var4.a(var5);
         this.a.a((ff)(new gg("MC|TrList", var5)));
      }

   }

   public le u() {
      return (le)this.o;
   }

   public boolean a(int var1, String var2) {
      if ("seed".equals(var2) && !this.b.ae()) {
         return true;
      } else if (!"tell".equals(var2) && !"help".equals(var2) && !"me".equals(var2) && !"trigger".equals(var2)) {
         if (this.b.ap().h(this.cd())) {
            lz var3 = (lz)this.b.ap().m().b(this.cd());
            if (var3 != null) {
               return var3.a() >= var1;
            } else {
               return this.b.p() >= var1;
            }
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   public void a(eu var1) {
      this.a.a((ff)(new fy(var1)));
   }

   public void r() {
      this.bM = -1.0E8F;
   }

   public void a(xi var1, int var2, int var3) {
      this.a.a((ff)(new ge(var1.d, var2, var3)));
   }

   public void z() {
      this.bT = MinecraftServer.az();
   }

   protected void B() {
      if (this.v()) {
         this.bj();
         this.e(true);
      } else {
         super.B();
      }

      this.u().s().a(this);
   }

   public void n() {
      this.a.a((ff)(new gb(this.bk.d)));
      this.p();
   }

   public lf(MinecraftServer var1, le var2, GameProfile var3, lg var4) {
      super(var2, var3);
      var4.b = this;
      this.c = var4;
      cj var5 = var2.M();
      if (!var2.t.o() && var2.P().r() != adp.a.d) {
         int var6 = Math.max(5, var1.aw() - 6);
         int var7 = ns.c(var2.af().b((double)var5.n(), (double)var5.p()));
         if (var7 < var6) {
            var6 = var7;
         }

         if (var7 <= 1) {
            var6 = 1;
         }

         var5 = var2.r(var5.a(this.V.nextInt(var6 * 2) - var6, 0, this.V.nextInt(var6 * 2) - var6));
      }

      this.b = var1;
      this.bK = var1.ap().a((wn)this);
      this.S = 0.0F;
      this.a(var5, 0.0F, 0.0F);

      while(!var2.a((pk)this, (aug)this.aR()).isEmpty() && this.t < 255.0D) {
         this.b(this.s, this.t + 1.0D, this.u);
      }

   }

   public void a(ol var1) {
      this.cs();
      this.a.a((ff)(new gc(this.bV, var1.k(), var1.f_())));
      this.bk = var1.a(this.bi, this);
      this.bk.d = this.bV;
      this.bk.a((xn)this);
   }

   public void a(String var1, String var2) {
      this.a.a((ff)(new hd(var1, var2)));
   }

   public boolean a(wn var1) {
      return !this.cr() ? false : super.a(var1);
   }
}
