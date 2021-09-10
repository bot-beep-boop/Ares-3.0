import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.List;

public class tp extends tm implements oh {
   private int bC;
   private boolean bG;
   private boolean bF;
   private int bN;
   private static final String[] bx = new String[]{"textures/entity/horse/horse_white.png", "textures/entity/horse/horse_creamy.png", "textures/entity/horse/horse_chestnut.png", "textures/entity/horse/horse_brown.png", "textures/entity/horse/horse_black.png", "textures/entity/horse/horse_gray.png", "textures/entity/horse/horse_darkbrown.png"};
   private static final Predicate<pk> bs = new Predicate<pk>() {
      public boolean a(pk var1) {
         return var1 instanceof tp && ((tp)var1).cA();
      }

      public boolean apply(Object var1) {
         return this.a((pk)var1);
      }
   };
   private xj bE;
   private static final String[] bu = new String[]{null, "textures/entity/horse/armor/horse_armor_iron.png", "textures/entity/horse/armor/horse_armor_gold.png", "textures/entity/horse/armor/horse_armor_diamond.png"};
   private static final int[] bw = new int[]{0, 5, 7, 11};
   private float bM;
   private static final String[] by = new String[]{"hwh", "hcr", "hch", "hbr", "hbl", "hgr", "hdb"};
   protected int bq;
   private String[] bP = new String[3];
   private float bJ;
   private boolean bQ = false;
   private static final String[] bA = new String[]{"", "wo_", "wmo", "wdo", "bdo"};
   private static final qb bt = (new qj((qb)null, "horse.jumpStrength", 0.7D, 0.0D, 2.0D)).a("Jump Strength").a(true);
   protected float br;
   private int bD;
   private static final String[] bv = new String[]{"", "meo", "goo", "dio"};
   protected boolean bp;
   private int bB;
   private float bK;
   private float bI;
   private float bH;
   public int bm;
   private float bL;
   private String bO;
   private static final String[] bz = new String[]{null, "textures/entity/horse/horse_markings_white.png", "textures/entity/horse/horse_markings_whitefield.png", "textures/entity/horse/horse_markings_whitedots.png", "textures/entity/horse/horse_markings_blackdots.png"};
   public int bo;

   public float r(float var1) {
      return this.bM + (this.bL - this.bM) * var1;
   }

   public boolean cb() {
      return !this.cR() && super.cb();
   }

   public void cX() {
      this.a((pk)this, (xj)this.bE);
      this.cE();
   }

   public void a(byte var1) {
      if (var1 == 7) {
         this.t(true);
      } else if (var1 == 6) {
         this.t(false);
      } else {
         super.a(var1);
      }

   }

   public void al() {
      super.al();
      if (this.bK > 0.0F) {
         float var1 = ns.a(this.aI * 3.1415927F / 180.0F);
         float var2 = ns.b(this.aI * 3.1415927F / 180.0F);
         float var3 = 0.7F * this.bK;
         float var4 = 0.15F * this.bK;
         this.l.b(this.s + (double)(var3 * var1), this.t + this.an() + this.l.am() + (double)var4, this.u - (double)(var3 * var2));
         if (this.l instanceof pr) {
            ((pr)this.l).aI = this.aI;
         }
      }

   }

   protected void t(boolean var1) {
      cy var2 = var1 ? cy.I : cy.l;

      for(int var3 = 0; var3 < 7; ++var3) {
         double var4 = this.V.nextGaussian() * 0.02D;
         double var6 = this.V.nextGaussian() * 0.02D;
         double var8 = this.V.nextGaussian() * 0.02D;
         this.o.a(var2, this.s + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, this.t + 0.5D + (double)(this.V.nextFloat() * this.K), this.u + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, var4, var6, var8);
      }

   }

   public boolean cS() {
      return this.cR() || this.cl() == 2;
   }

   public void l(boolean var1) {
      this.c(2, var1);
   }

   public void n(boolean var1) {
      this.c(16, var1);
   }

   public boolean cR() {
      int var1 = this.cl();
      return var1 == 3 || var1 == 4;
   }

   protected boolean bD() {
      if (this.l != null && this.cG()) {
         return true;
      } else {
         return this.cy() || this.cz();
      }
   }

   public void o(boolean var1) {
      this.c(8, var1);
   }

   public boolean a(tm var1) {
      if (var1 == this) {
         return false;
      } else if (var1.getClass() != this.getClass()) {
         return false;
      } else {
         tp var2 = (tp)var1;
         if (this.dg() && var2.dg()) {
            int var3 = this.cl();
            int var4 = var2.cl();
            return var3 == var4 || var3 == 0 && var4 == 1 || var3 == 1 && var4 == 0;
         } else {
            return false;
         }
      }
   }

   public boolean d(int var1, zx var2) {
      if (var1 == 499 && this.cP()) {
         if (var2 == null && this.cw()) {
            this.o(false);
            this.da();
            return true;
         }

         if (var2 != null && var2.b() == zw.a((afh)afi.ae) && !this.cw()) {
            this.o(true);
            this.da();
            return true;
         }
      }

      int var3 = var1 - 400;
      if (var3 >= 0 && var3 < 2 && var3 < this.bE.o_()) {
         if (var3 == 0 && var2 != null && var2.b() != zy.aA) {
            return false;
         } else if (var3 != 1 || (var2 == null || a(var2.b())) && this.cO()) {
            this.bE.a(var3, var2);
            this.db();
            return true;
         } else {
            return false;
         }
      } else {
         int var4 = var1 - 500 + 2;
         if (var4 >= 2 && var4 < this.bE.o_()) {
            this.bE.a(var4, var2);
            return true;
         } else {
            return false;
         }
      }
   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("EatingHaystack", this.cy());
      var1.a("ChestedHorse", this.cw());
      var1.a("HasReproduced", this.cB());
      var1.a("Bred", this.cA());
      var1.a("Type", this.cl());
      var1.a("Variant", this.cm());
      var1.a("Temper", this.cC());
      var1.a("Tame", this.co());
      var1.a("OwnerUUID", this.ct());
      if (this.cw()) {
         du var2 = new du();

         for(int var3 = 2; var3 < this.bE.o_(); ++var3) {
            zx var4 = this.bE.a(var3);
            if (var4 != null) {
               dn var5 = new dn();
               var5.a("Slot", (byte)var3);
               var4.b(var5);
               var2.a((eb)var5);
            }
         }

         var1.a((String)"Items", (eb)var2);
      }

      if (this.bE.a(1) != null) {
         var1.a((String)"ArmorItem", (eb)this.bE.a(1).b(new dn()));
      }

      if (this.bE.a(0) != null) {
         var1.a((String)"SaddleItem", (eb)this.bE.a(0).b(new dn()));
      }

   }

   public boolean bR() {
      this.cD();
      return super.bR();
   }

   public boolean cn() {
      return !this.j_();
   }

   public static boolean a(zw var0) {
      return var0 == zy.ck || var0 == zy.cl || var0 == zy.cm;
   }

   protected void o(float var1) {
      if (var1 > 6.0F && this.cy()) {
         this.r(false);
      }

   }

   public boolean cB() {
      return this.bF;
   }

   public boolean k_() {
      return false;
   }

   public void a(dn var1) {
      super.a(var1);
      this.r(var1.n("EatingHaystack"));
      this.n(var1.n("Bred"));
      this.o(var1.n("ChestedHorse"));
      this.p(var1.n("HasReproduced"));
      this.r(var1.f("Type"));
      this.s(var1.f("Variant"));
      this.t(var1.f("Temper"));
      this.l(var1.n("Tame"));
      String var2 = "";
      if (var1.b("OwnerUUID", 8)) {
         var2 = var1.j("OwnerUUID");
      } else {
         String var3 = var1.j("Owner");
         var2 = lw.a(var3);
      }

      if (var2.length() > 0) {
         this.b(var2);
      }

      qc var8 = this.by().a("Speed");
      if (var8 != null) {
         this.a((qb)vy.d).a(var8.b() * 0.25D);
      }

      if (this.cw()) {
         du var4 = var1.c("Items", 10);
         this.da();

         for(int var5 = 0; var5 < var4.c(); ++var5) {
            dn var6 = var4.b(var5);
            int var7 = var6.d("Slot") & 255;
            if (var7 >= 2 && var7 < this.bE.o_()) {
               this.bE.a(var7, zx.a(var6));
            }
         }
      }

      zx var9;
      if (var1.b("ArmorItem", 10)) {
         var9 = zx.a(var1.m("ArmorItem"));
         if (var9 != null && a(var9.b())) {
            this.bE.a(1, var9);
         }
      }

      if (var1.b("SaddleItem", 10)) {
         var9 = zx.a(var1.m("SaddleItem"));
         if (var9 != null && var9.b() == zy.aA) {
            this.bE.a(0, var9);
         }
      } else if (var1.n("Saddle")) {
         this.bE.a(0, new zx(zy.aA));
      }

      this.db();
   }

   private void db() {
      if (!this.o.D) {
         this.q(this.bE.a(0) != null);
         if (this.cO()) {
            this.e(this.bE.a(1));
         }
      }

   }

   public void e(float var1, float var2) {
      if (var1 > 1.0F) {
         this.a("mob.horse.land", 0.4F, 1.0F);
      }

      int var3 = ns.f((var1 * 0.5F - 3.0F) * var2);
      if (var3 > 0) {
         this.a(ow.i, (float)var3);
         if (this.l != null) {
            this.l.a(ow.i, (float)var3);
         }

         afh var4 = this.o.p(new cj(this.s, this.t - 0.2D - (double)this.A, this.u)).c();
         if (var4.t() != arm.a && !this.R()) {
            afh.b var5 = var4.H;
            this.o.a((pk)this, var5.c(), var5.d() * 0.5F, var5.e() * 0.75F);
         }

      }
   }

   public void a(boolean var1) {
      if (var1) {
         this.a(this.cu());
      } else {
         this.a(1.0F);
      }

   }

   private void cY() {
      this.df();
      if (!this.R()) {
         this.o.a((pk)this, "eating", 1.0F, 1.0F + (this.V.nextFloat() - this.V.nextFloat()) * 0.2F);
      }

   }

   private void dh() {
      if (!this.o.D) {
         this.bD = 1;
         this.s(true);
      }

   }

   private int cZ() {
      int var1 = this.cl();
      return !this.cw() || var1 != 1 && var1 != 2 ? 2 : 17;
   }

   public boolean cG() {
      return this.w(4);
   }

   public boolean cD() {
      int var1 = ns.c(this.s);
      int var2 = ns.c(this.u);
      this.o.b(new cj(var1, 0, var2));
      return true;
   }

   public void s(boolean var1) {
      if (var1) {
         this.r(false);
      }

      this.c(64, var1);
   }

   private int f(zx var1) {
      if (var1 == null) {
         return 0;
      } else {
         zw var2 = var1.b();
         if (var2 == zy.ck) {
            return 1;
         } else if (var2 == zy.cl) {
            return 2;
         } else {
            return var2 == zy.cm ? 3 : 0;
         }
      }
   }

   public void m() {
      if (this.V.nextInt(200) == 0) {
         this.de();
      }

      super.m();
      if (!this.o.D) {
         if (this.V.nextInt(900) == 0 && this.ax == 0) {
            this.h(1.0F);
         }

         if (!this.cy() && this.l == null && this.V.nextInt(300) == 0 && this.o.p(new cj(ns.c(this.s), ns.c(this.t) - 1, ns.c(this.u))).c() == afi.c) {
            this.r(true);
         }

         if (this.cy() && ++this.bB > 50) {
            this.bB = 0;
            this.r(false);
         }

         if (this.cA() && !this.cn() && !this.cy()) {
            tp var1 = this.a(this, 16.0D);
            if (var1 != null && this.h(var1) > 4.0D) {
               this.h.a((pk)var1);
            }
         }
      }

   }

   public void t(int var1) {
      this.bq = var1;
   }

   public int br() {
      return bw[this.cx()];
   }

   public boolean cK() {
      return this.bQ;
   }

   private void c(int var1, boolean var2) {
      int var3 = this.ac.c(16);
      if (var2) {
         this.ac.b(16, var3 | var1);
      } else {
         this.ac.b(16, var3 & ~var1);
      }

   }

   public float p(float var1) {
      return this.bI + (this.bH - this.bI) * var1;
   }

   public void a(oq var1) {
      int var2 = this.cx();
      boolean var3 = this.cG();
      this.db();
      if (this.W > 20) {
         if (var2 == 0 && var2 != this.cx()) {
            this.a("mob.horse.armor", 0.5F, 1.0F);
         } else if (var2 != this.cx()) {
            this.a("mob.horse.armor", 0.5F, 1.0F);
         }

         if (!var3 && this.cG()) {
            this.a("mob.horse.leather", 0.5F, 1.0F);
         }
      }

   }

   protected void h() {
      super.h();
      this.ac.a(16, 0);
      this.ac.a(19, (byte)0);
      this.ac.a(20, 0);
      this.ac.a(21, String.valueOf(""));
      this.ac.a(22, 0);
   }

   protected zw A() {
      boolean var1 = this.V.nextInt(4) == 0;
      int var2 = this.cl();
      if (var2 == 4) {
         return zy.aX;
      } else if (var2 == 3) {
         return var1 ? null : zy.bt;
      } else {
         return zy.aF;
      }
   }

   public boolean co() {
      return this.w(2);
   }

   public boolean a(ow var1, float var2) {
      pk var3 = var1.j();
      return this.l != null && this.l.equals(var3) ? false : super.a(var1, var2);
   }

   public float aS() {
      return this.K;
   }

   public float q(float var1) {
      return this.bK + (this.bJ - this.bK) * var1;
   }

   public void b(String var1) {
      this.ac.b(21, var1);
   }

   protected String z() {
      this.df();
      if (this.V.nextInt(10) == 0 && !this.bD()) {
         this.dh();
      }

      int var1 = this.cl();
      if (var1 == 3) {
         return "mob.horse.zombie.idle";
      } else if (var1 == 4) {
         return "mob.horse.skeleton.idle";
      } else {
         return var1 != 1 && var1 != 2 ? "mob.horse.idle" : "mob.horse.donkey.idle";
      }
   }

   public boolean cp() {
      return this.cn();
   }

   public int bV() {
      return 6;
   }

   public void a(ow var1) {
      super.a((ow)var1);
      if (!this.o.D) {
         this.cX();
      }

   }

   public String e_() {
      if (this.l_()) {
         return this.aM();
      } else {
         int var1 = this.cl();
         switch(var1) {
         case 0:
         default:
            return di.a("entity.horse.name");
         case 1:
            return di.a("entity.donkey.name");
         case 2:
            return di.a("entity.mule.name");
         case 3:
            return di.a("entity.zombiehorse.name");
         case 4:
            return di.a("entity.skeletonhorse.name");
         }
      }
   }

   public double cF() {
      return this.a((qb)bt).e();
   }

   public pu a(ok var1, pu var2) {
      Object var7 = super.a(var1, var2);
      boolean var3 = false;
      int var4 = 0;
      int var8;
      if (var7 instanceof tp.a) {
         var8 = ((tp.a)var7).a;
         var4 = ((tp.a)var7).b & 255 | this.V.nextInt(5) << 8;
      } else {
         if (this.V.nextInt(10) == 0) {
            var8 = 1;
         } else {
            int var5 = this.V.nextInt(7);
            int var6 = this.V.nextInt(5);
            var8 = 0;
            var4 = var5 | var6 << 8;
         }

         var7 = new tp.a(var8, var4);
      }

      this.r(var8);
      this.s(var4);
      if (this.V.nextInt(5) == 0) {
         this.b(-24000);
      }

      if (var8 != 4 && var8 != 3) {
         this.a((qb)vy.a).a((double)this.di());
         if (var8 == 0) {
            this.a((qb)vy.d).a(this.dk());
         } else {
            this.a((qb)vy.d).a(0.17499999701976776D);
         }
      } else {
         this.a((qb)vy.a).a(15.0D);
         this.a((qb)vy.d).a(0.20000000298023224D);
      }

      if (var8 != 2 && var8 != 1) {
         this.a((qb)bt).a(this.dj());
      } else {
         this.a((qb)bt).a(0.5D);
      }

      this.i(this.bu());
      return (pu)var7;
   }

   public void cW() {
      this.dh();
      String var1 = this.cH();
      if (var1 != null) {
         this.a(var1, this.bB(), this.bC());
      }

   }

   protected float bB() {
      return 0.8F;
   }

   public boolean cA() {
      return this.w(16);
   }

   public int cC() {
      return this.bq;
   }

   public int u(int var1) {
      int var2 = ns.a(this.cC() + var1, 0, this.cI());
      this.t(var2);
      return var2;
   }

   public void g(float var1, float var2) {
      if (this.l != null && this.l instanceof pr && this.cG()) {
         this.A = this.y = this.l.y;
         this.z = this.l.z * 0.5F;
         this.b(this.y, this.z);
         this.aK = this.aI = this.y;
         var1 = ((pr)this.l).aZ * 0.5F;
         var2 = ((pr)this.l).ba;
         if (var2 <= 0.0F) {
            var2 *= 0.25F;
            this.bN = 0;
         }

         if (this.C && this.br == 0.0F && this.cz() && !this.bG) {
            var1 = 0.0F;
            var2 = 0.0F;
         }

         if (this.br > 0.0F && !this.cv() && this.C) {
            this.w = this.cF() * (double)this.br;
            if (this.a((pe)pe.j)) {
               this.w += (double)((float)(this.b((pe)pe.j).c() + 1) * 0.1F);
            }

            this.m(true);
            this.ai = true;
            if (var2 > 0.0F) {
               float var3 = ns.a(this.y * 3.1415927F / 180.0F);
               float var4 = ns.b(this.y * 3.1415927F / 180.0F);
               this.v += (double)(-0.4F * var3 * this.br);
               this.x += (double)(0.4F * var4 * this.br);
               this.a("mob.horse.jump", 0.4F, 1.0F);
            }

            this.br = 0.0F;
         }

         this.S = 1.0F;
         this.aM = this.bI() * 0.1F;
         if (!this.o.D) {
            this.k((float)this.a((qb)vy.d).e());
            super.g(var1, var2);
         }

         if (this.C) {
            this.br = 0.0F;
            this.m(false);
         }

         this.aA = this.aB;
         double var8 = this.s - this.p;
         double var5 = this.u - this.r;
         float var7 = ns.a(var8 * var8 + var5 * var5) * 4.0F;
         if (var7 > 1.0F) {
            var7 = 1.0F;
         }

         this.aB += (var7 - this.aB) * 0.4F;
         this.aC += this.aB;
      } else {
         this.S = 0.5F;
         this.aM = 0.02F;
         super.g(var1, var2);
      }
   }

   public boolean cO() {
      return this.cl() == 0;
   }

   private double dj() {
      return 0.4000000059604645D + this.V.nextDouble() * 0.2D + this.V.nextDouble() * 0.2D + this.V.nextDouble() * 0.2D;
   }

   public void e(zx var1) {
      this.ac.b(22, this.f(var1));
      this.dc();
   }

   public void r(boolean var1) {
      this.f(var1);
   }

   public void t_() {
      super.t_();
      if (this.o.D && this.ac.a()) {
         this.ac.e();
         this.dc();
      }

      if (this.bC > 0 && ++this.bC > 30) {
         this.bC = 0;
         this.c(128, false);
      }

      if (!this.o.D && this.bD > 0 && ++this.bD > 20) {
         this.bD = 0;
         this.s(false);
      }

      if (this.bm > 0 && ++this.bm > 8) {
         this.bm = 0;
      }

      if (this.bo > 0) {
         ++this.bo;
         if (this.bo > 300) {
            this.bo = 0;
         }
      }

      this.bI = this.bH;
      if (this.cy()) {
         this.bH += (1.0F - this.bH) * 0.4F + 0.05F;
         if (this.bH > 1.0F) {
            this.bH = 1.0F;
         }
      } else {
         this.bH += (0.0F - this.bH) * 0.4F - 0.05F;
         if (this.bH < 0.0F) {
            this.bH = 0.0F;
         }
      }

      this.bK = this.bJ;
      if (this.cz()) {
         this.bI = this.bH = 0.0F;
         this.bJ += (1.0F - this.bJ) * 0.4F + 0.05F;
         if (this.bJ > 1.0F) {
            this.bJ = 1.0F;
         }
      } else {
         this.bG = false;
         this.bJ += (0.8F * this.bJ * this.bJ * this.bJ - this.bJ) * 0.6F - 0.05F;
         if (this.bJ < 0.0F) {
            this.bJ = 0.0F;
         }
      }

      this.bM = this.bL;
      if (this.w(128)) {
         this.bL += (1.0F - this.bL) * 0.7F + 0.05F;
         if (this.bL > 1.0F) {
            this.bL = 1.0F;
         }
      } else {
         this.bL += (0.0F - this.bL) * 0.7F - 0.05F;
         if (this.bL < 0.0F) {
            this.bL = 0.0F;
         }
      }

   }

   public tp(adm var1) {
      super(var1);
      this.a(1.4F, 1.6F);
      this.ab = false;
      this.o(false);
      ((sv)this.s()).a(true);
      this.i.a(0, new ra(this));
      this.i.a(1, new rv(this, 1.2D));
      this.i.a(1, new sd(this, 1.2D));
      this.i.a(2, new qv(this, 1.0D));
      this.i.a(4, new rc(this, 1.0D));
      this.i.a(6, new rz(this, 0.7D));
      this.i.a(7, new ri(this, wn.class, 6.0F));
      this.i.a(8, new ry(this));
      this.da();
   }

   protected tp a(pk var1, double var2) {
      double var4 = Double.MAX_VALUE;
      pk var6 = null;
      List var7 = this.o.a(var1, var1.aR().a(var2, var2, var2), bs);
      Iterator var8 = var7.iterator();

      while(var8.hasNext()) {
         pk var9 = (pk)var8.next();
         double var10 = var9.e(var1.s, var1.t, var1.u);
         if (var10 < var4) {
            var6 = var9;
            var4 = var10;
         }
      }

      return (tp)var6;
   }

   public float cu() {
      return 0.5F;
   }

   private boolean dg() {
      return this.l == null && this.m == null && this.co() && this.cn() && !this.cS() && this.bn() >= this.bu() && this.cr();
   }

   public boolean cP() {
      int var1 = this.cl();
      return var1 == 2 || var1 == 1;
   }

   public boolean cw() {
      return this.w(8);
   }

   public boolean cz() {
      return this.w(64);
   }

   public boolean h(wn var1) {
      this.b(var1.aK().toString());
      this.l(true);
      return true;
   }

   private void da() {
      xj var1 = this.bE;
      this.bE = new xj("HorseChest", this.cZ());
      this.bE.a(this.e_());
      if (var1 != null) {
         var1.b(this);
         int var2 = Math.min(var1.o_(), this.bE.o_());

         for(int var3 = 0; var3 < var2; ++var3) {
            zx var4 = var1.a(var3);
            if (var4 != null) {
               this.bE.a(var3, var4.k());
            }
         }
      }

      this.bE.a(this);
      this.db();
   }

   public void p(boolean var1) {
      this.bF = var1;
   }

   public boolean cy() {
      return this.w(32);
   }

   public void f(boolean var1) {
      this.c(32, var1);
   }

   public void r(int var1) {
      this.ac.b(19, (byte)var1);
      this.dc();
   }

   public int cm() {
      return this.ac.c(20);
   }

   public boolean ae() {
      return this.l == null;
   }

   private void dd() {
      this.bO = "horse/";
      this.bP[0] = null;
      this.bP[1] = null;
      this.bP[2] = null;
      int var1 = this.cl();
      int var2 = this.cm();
      int var3;
      if (var1 == 0) {
         var3 = var2 & 255;
         int var4 = (var2 & '\uff00') >> 8;
         if (var3 >= bx.length) {
            this.bQ = false;
            return;
         }

         this.bP[0] = bx[var3];
         this.bO = this.bO + by[var3];
         if (var4 >= bz.length) {
            this.bQ = false;
            return;
         }

         this.bP[1] = bz[var4];
         this.bO = this.bO + bA[var4];
      } else {
         this.bP[0] = "";
         this.bO = this.bO + "_" + var1 + "_";
      }

      var3 = this.cx();
      if (var3 >= bu.length) {
         this.bQ = false;
      } else {
         this.bP[2] = bu[var3];
         this.bO = this.bO + bv[var3];
         this.bQ = true;
      }
   }

   public boolean cv() {
      return this.bp;
   }

   private void a(pk var1, xj var2) {
      if (var2 != null && !this.o.D) {
         for(int var3 = 0; var3 < var2.o_(); ++var3) {
            zx var4 = var2.a(var3);
            if (var4 != null) {
               this.a(var4, 0.0F);
            }
         }

      }
   }

   public boolean a(wn var1) {
      zx var2 = var1.bi.h();
      if (var2 != null && var2.b() == zy.bJ) {
         return super.a(var1);
      } else if (!this.co() && this.cR()) {
         return false;
      } else if (this.co() && this.cn() && var1.av()) {
         this.g(var1);
         return true;
      } else if (this.cp() && this.l != null) {
         return super.a(var1);
      } else {
         if (var2 != null) {
            boolean var3 = false;
            if (this.cO()) {
               byte var4 = -1;
               if (var2.b() == zy.ck) {
                  var4 = 1;
               } else if (var2.b() == zy.cl) {
                  var4 = 2;
               } else if (var2.b() == zy.cm) {
                  var4 = 3;
               }

               if (var4 >= 0) {
                  if (!this.co()) {
                     this.cW();
                     return true;
                  }

                  this.g(var1);
                  return true;
               }
            }

            if (!var3 && !this.cR()) {
               float var7 = 0.0F;
               short var5 = 0;
               byte var6 = 0;
               if (var2.b() == zy.O) {
                  var7 = 2.0F;
                  var5 = 20;
                  var6 = 3;
               } else if (var2.b() == zy.aY) {
                  var7 = 1.0F;
                  var5 = 30;
                  var6 = 3;
               } else if (afh.a(var2.b()) == afi.cx) {
                  var7 = 20.0F;
                  var5 = 180;
               } else if (var2.b() == zy.e) {
                  var7 = 3.0F;
                  var5 = 60;
                  var6 = 3;
               } else if (var2.b() == zy.bW) {
                  var7 = 4.0F;
                  var5 = 60;
                  var6 = 5;
                  if (this.co() && this.l() == 0) {
                     var3 = true;
                     this.c(var1);
                  }
               } else if (var2.b() == zy.ao) {
                  var7 = 10.0F;
                  var5 = 240;
                  var6 = 10;
                  if (this.co() && this.l() == 0) {
                     var3 = true;
                     this.c(var1);
                  }
               }

               if (this.bn() < this.bu() && var7 > 0.0F) {
                  this.h(var7);
                  var3 = true;
               }

               if (!this.cn() && var5 > 0) {
                  this.a(var5);
                  var3 = true;
               }

               if (var6 > 0 && (var3 || !this.co()) && var6 < this.cI()) {
                  var3 = true;
                  this.u(var6);
               }

               if (var3) {
                  this.cY();
               }
            }

            if (!this.co() && !var3) {
               if (var2 != null && var2.a((wn)var1, (pr)this)) {
                  return true;
               }

               this.cW();
               return true;
            }

            if (!var3 && this.cP() && !this.cw() && var2.b() == zw.a((afh)afi.ae)) {
               this.o(true);
               this.a("mob.chickenplop", 1.0F, (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F);
               var3 = true;
               this.da();
            }

            if (!var3 && this.cp() && !this.cG() && var2.b() == zy.aA) {
               this.g(var1);
               return true;
            }

            if (var3) {
               if (!var1.bA.d && --var2.b == 0) {
                  var1.bi.a(var1.bi.c, (zx)null);
               }

               return true;
            }
         }

         if (this.cp() && this.l == null) {
            if (var2 != null && var2.a((wn)var1, (pr)this)) {
               return true;
            } else {
               this.i(var1);
               return true;
            }
         } else {
            return super.a(var1);
         }
      }
   }

   private void df() {
      if (!this.o.D) {
         this.bC = 1;
         this.c(128, true);
      }

   }

   public boolean cJ() {
      return this.cl() == 0 || this.cx() > 0;
   }

   public boolean d(zx var1) {
      return false;
   }

   private void de() {
      this.bm = 1;
   }

   public String ct() {
      return this.ac.e(21);
   }

   public void s(int var1) {
      this.ac.b(20, var1);
      this.dc();
   }

   protected String bo() {
      this.df();
      if (this.V.nextInt(3) == 0) {
         this.dh();
      }

      int var1 = this.cl();
      if (var1 == 3) {
         return "mob.horse.zombie.hit";
      } else if (var1 == 4) {
         return "mob.horse.skeleton.hit";
      } else {
         return var1 != 1 && var1 != 2 ? "mob.horse.hit" : "mob.horse.donkey.hit";
      }
   }

   private double dk() {
      return (0.44999998807907104D + this.V.nextDouble() * 0.3D + this.V.nextDouble() * 0.3D + this.V.nextDouble() * 0.3D) * 0.25D;
   }

   private void i(wn var1) {
      var1.y = this.y;
      var1.z = this.z;
      this.r(false);
      this.s(false);
      if (!this.o.D) {
         var1.a((pk)this);
      }

   }

   protected String cH() {
      this.df();
      this.dh();
      int var1 = this.cl();
      if (var1 != 3 && var1 != 4) {
         return var1 != 1 && var1 != 2 ? "mob.horse.angry" : "mob.horse.donkey.angry";
      } else {
         return null;
      }
   }

   public int cl() {
      return this.ac.a(19);
   }

   public void cE() {
      if (!this.o.D && this.cw()) {
         this.a(zw.a((afh)afi.ae), 1);
         this.o(false);
      }
   }

   public void q(boolean var1) {
      this.c(4, var1);
   }

   public int cx() {
      return this.ac.c(22);
   }

   public ph a(ph var1) {
      tp var2 = (tp)var1;
      tp var3 = new tp(this.o);
      int var4 = this.cl();
      int var5 = var2.cl();
      int var6 = 0;
      if (var4 == var5) {
         var6 = var4;
      } else if (var4 == 0 && var5 == 1 || var4 == 1 && var5 == 0) {
         var6 = 2;
      }

      if (var6 == 0) {
         int var8 = this.V.nextInt(9);
         int var7;
         if (var8 < 4) {
            var7 = this.cm() & 255;
         } else if (var8 < 8) {
            var7 = var2.cm() & 255;
         } else {
            var7 = this.V.nextInt(7);
         }

         int var9 = this.V.nextInt(5);
         if (var9 < 2) {
            var7 |= this.cm() & '\uff00';
         } else if (var9 < 4) {
            var7 |= var2.cm() & '\uff00';
         } else {
            var7 |= this.V.nextInt(5) << 8 & '\uff00';
         }

         var3.s(var7);
      }

      var3.r(var6);
      double var14 = this.a((qb)vy.a).b() + var1.a((qb)vy.a).b() + (double)this.di();
      var3.a((qb)vy.a).a(var14 / 3.0D);
      double var13 = this.a((qb)bt).b() + var1.a((qb)bt).b() + this.dj();
      var3.a((qb)bt).a(var13 / 3.0D);
      double var11 = this.a((qb)vy.d).b() + var1.a((qb)vy.d).b() + this.dk();
      var3.a((qb)vy.d).a(var11 / 3.0D);
      return var3;
   }

   protected void a(cj var1, afh var2) {
      afh.b var3 = var2.H;
      if (this.o.p(var1.a()).c() == afi.aH) {
         var3 = afi.aH.H;
      }

      if (!var2.t().d()) {
         int var4 = this.cl();
         if (this.l != null && var4 != 1 && var4 != 2) {
            ++this.bN;
            if (this.bN > 5 && this.bN % 3 == 0) {
               this.a("mob.horse.gallop", var3.d() * 0.15F, var3.e());
               if (var4 == 0 && this.V.nextInt(10) == 0) {
                  this.a("mob.horse.breathe", var3.d() * 0.6F, var3.e());
               }
            } else if (this.bN <= 5) {
               this.a("mob.horse.wood", var3.d() * 0.15F, var3.e());
            }
         } else if (var3 == afh.f) {
            this.a("mob.horse.wood", var3.d() * 0.15F, var3.e());
         } else {
            this.a("mob.horse.soft", var3.d() * 0.15F, var3.e());
         }
      }

   }

   private boolean w(int var1) {
      return (this.ac.c(16) & var1) != 0;
   }

   public String[] cM() {
      if (this.bO == null) {
         this.dd();
      }

      return this.bP;
   }

   protected void aX() {
      super.aX();
      this.by().b(bt);
      this.a((qb)vy.a).a(53.0D);
      this.a((qb)vy.d).a(0.22499999403953552D);
   }

   public void g(wn var1) {
      if (!this.o.D && (this.l == null || this.l == var1) && this.co()) {
         this.bE.a(this.e_());
         var1.a(this, this.bE);
      }

   }

   public void v(int var1) {
      if (this.cG()) {
         if (var1 < 0) {
            var1 = 0;
         } else {
            this.bG = true;
            this.dh();
         }

         if (var1 >= 90) {
            this.br = 1.0F;
         } else {
            this.br = 0.4F + 0.4F * (float)var1 / 90.0F;
         }
      }

   }

   protected String bp() {
      this.df();
      int var1 = this.cl();
      if (var1 == 3) {
         return "mob.horse.zombie.death";
      } else if (var1 == 4) {
         return "mob.horse.skeleton.death";
      } else {
         return var1 != 1 && var1 != 2 ? "mob.horse.death" : "mob.horse.donkey.death";
      }
   }

   private float di() {
      return 15.0F + (float)this.V.nextInt(8) + (float)this.V.nextInt(9);
   }

   public String cL() {
      if (this.bO == null) {
         this.dd();
      }

      return this.bO;
   }

   public int cI() {
      return 100;
   }

   private void dc() {
      this.bO = null;
   }

   public void m(boolean var1) {
      this.bp = var1;
   }

   public int w() {
      return 400;
   }

   public static class a implements pu {
      public int a;
      public int b;

      public a(int var1, int var2) {
         this.a = var1;
         this.b = var2;
      }
   }
}
