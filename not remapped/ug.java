import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ug extends ps implements ud, vq, uc {
   public double a;
   public boolean bx;
   public ue bq;
   public ue bo;
   public float bv;
   public ue[] bm;
   public ue br;
   private pk bA;
   public ue bp;
   public double[][] bk = new double[64][3];
   public int bl = -1;
   public boolean bw;
   public float bu;
   public int by;
   public double b;
   public double c;
   public ue bn;
   public uf bz;
   public ue bs;
   public ue bt;

   protected String z() {
      return "mob.enderdragon.growl";
   }

   private float b(double var1) {
      return (float)ns.g(var1);
   }

   protected float bB() {
      return 5.0F;
   }

   public boolean a(ue var1, ow var2, float var3) {
      if (var1 != this.bn) {
         var3 = var3 / 4.0F + 1.0F;
      }

      float var4 = this.y * 3.1415927F / 180.0F;
      float var5 = ns.a(var4);
      float var6 = ns.b(var4);
      this.a = this.s + (double)(var5 * 5.0F) + (double)((this.V.nextFloat() - 0.5F) * 2.0F);
      this.b = this.t + (double)(this.V.nextFloat() * 3.0F) + 1.0D;
      this.c = this.u - (double)(var6 * 5.0F) + (double)((this.V.nextFloat() - 0.5F) * 2.0F);
      this.bA = null;
      if (var2.j() instanceof wn || var2.c()) {
         this.e(var2, var3);
      }

      return true;
   }

   private boolean b(aug var1) {
      int var2 = ns.c(var1.a);
      int var3 = ns.c(var1.b);
      int var4 = ns.c(var1.c);
      int var5 = ns.c(var1.d);
      int var6 = ns.c(var1.e);
      int var7 = ns.c(var1.f);
      boolean var8 = false;
      boolean var9 = false;

      for(int var10 = var2; var10 <= var5; ++var10) {
         for(int var11 = var3; var11 <= var6; ++var11) {
            for(int var12 = var4; var12 <= var7; ++var12) {
               cj var13 = new cj(var10, var11, var12);
               afh var14 = this.o.p(var13).c();
               if (var14.t() != arm.a) {
                  if (var14 != afi.cv && var14 != afi.Z && var14 != afi.bH && var14 != afi.h && var14 != afi.bX && this.o.Q().b("mobGriefing")) {
                     var9 = this.o.g(var13) || var9;
                  } else {
                     var8 = true;
                  }
               }
            }
         }
      }

      if (var9) {
         double var16 = var1.a + (var1.d - var1.a) * (double)this.V.nextFloat();
         double var17 = var1.b + (var1.e - var1.b) * (double)this.V.nextFloat();
         double var18 = var1.c + (var1.f - var1.c) * (double)this.V.nextFloat();
         this.o.a(cy.b, var16, var17, var18, 0.0D, 0.0D, 0.0D);
      }

      return var8;
   }

   public double[] b(int var1, float var2) {
      if (this.bn() <= 0.0F) {
         var2 = 0.0F;
      }

      var2 = 1.0F - var2;
      int var3 = this.bl - var1 * 1 & 63;
      int var4 = this.bl - var1 * 1 - 1 & 63;
      double[] var5 = new double[3];
      double var6 = this.bk[var3][0];
      double var8 = ns.g(this.bk[var4][0] - var6);
      var5[0] = var6 + var8 * (double)var2;
      var6 = this.bk[var3][1];
      var8 = this.bk[var4][1] - var6;
      var5[1] = var6 + var8 * (double)var2;
      var5[2] = this.bk[var3][2] + (this.bk[var4][2] - this.bk[var3][2]) * (double)var2;
      return var5;
   }

   protected void aZ() {
      ++this.by;
      if (this.by >= 180 && this.by <= 200) {
         float var1 = (this.V.nextFloat() - 0.5F) * 8.0F;
         float var2 = (this.V.nextFloat() - 0.5F) * 4.0F;
         float var3 = (this.V.nextFloat() - 0.5F) * 8.0F;
         this.o.a(cy.c, this.s + (double)var1, this.t + 2.0D + (double)var2, this.u + (double)var3, 0.0D, 0.0D, 0.0D);
      }

      boolean var4 = this.o.Q().b("doMobLoot");
      int var5;
      int var6;
      if (!this.o.D) {
         if (this.by > 150 && this.by % 5 == 0 && var4) {
            var5 = 1000;

            while(var5 > 0) {
               var6 = pp.a(var5);
               var5 -= var6;
               this.o.d((pk)(new pp(this.o, this.s, this.t, this.u, var6)));
            }
         }

         if (this.by == 1) {
            this.o.a(1018, new cj(this), 0);
         }
      }

      this.d(0.0D, 0.10000000149011612D, 0.0D);
      this.aI = this.y += 20.0F;
      if (this.by == 200 && !this.o.D) {
         if (var4) {
            var5 = 2000;

            while(var5 > 0) {
               var6 = pp.a(var5);
               var5 -= var6;
               this.o.d((pk)(new pp(this.o, this.s, this.t, this.u, var6)));
            }
         }

         this.a(new cj(this.s, 64.0D, this.u));
         this.J();
      }

   }

   public ug(adm var1) {
      super(var1);
      this.bm = new ue[]{this.bn = new ue(this, "head", 6.0F, 6.0F), this.bo = new ue(this, "body", 8.0F, 8.0F), this.bp = new ue(this, "tail", 4.0F, 4.0F), this.bq = new ue(this, "tail", 4.0F, 4.0F), this.br = new ue(this, "tail", 4.0F, 4.0F), this.bs = new ue(this, "wing", 4.0F, 4.0F), this.bt = new ue(this, "wing", 4.0F, 4.0F)};
      this.i(this.bu());
      this.a(16.0F, 8.0F);
      this.T = true;
      this.ab = true;
      this.b = 100.0D;
      this.ah = true;
   }

   private void n() {
      if (this.bz != null) {
         if (this.bz.I) {
            if (!this.o.D) {
               this.a(this.bn, ow.a((adi)null), 10.0F);
            }

            this.bz = null;
         } else if (this.W % 10 == 0 && this.bn() < this.bu()) {
            this.i(this.bn() + 1.0F);
         }
      }

      if (this.V.nextInt(10) == 0) {
         float var1 = 32.0F;
         List var2 = this.o.a(uf.class, this.aR().b((double)var1, (double)var1, (double)var1));
         uf var3 = null;
         double var4 = Double.MAX_VALUE;
         Iterator var6 = var2.iterator();

         while(var6.hasNext()) {
            uf var7 = (uf)var6.next();
            double var8 = var7.h(this);
            if (var8 < var4) {
               var4 = var8;
               var3 = var7;
            }
         }

         this.bz = var3;
      }

   }

   public void G() {
      this.J();
   }

   public adm a() {
      return this.o;
   }

   private void b(List<pk> var1) {
      for(int var2 = 0; var2 < var1.size(); ++var2) {
         pk var3 = (pk)var1.get(var2);
         if (var3 instanceof pr) {
            var3.a(ow.a((pr)this), 10.0F);
            this.a(this, var3);
         }
      }

   }

   private void a(List<pk> var1) {
      double var2 = (this.bo.aR().a + this.bo.aR().d) / 2.0D;
      double var4 = (this.bo.aR().c + this.bo.aR().f) / 2.0D;
      Iterator var6 = var1.iterator();

      while(var6.hasNext()) {
         pk var7 = (pk)var6.next();
         if (var7 instanceof pr) {
            double var8 = var7.s - var2;
            double var10 = var7.u - var4;
            double var12 = var8 * var8 + var10 * var10;
            var7.g(var8 / var12 * 4.0D, 0.20000000298023224D, var10 / var12 * 4.0D);
         }
      }

   }

   public boolean ad() {
      return false;
   }

   public void m() {
      float var1;
      float var2;
      if (this.o.D) {
         var1 = ns.b(this.bv * 3.1415927F * 2.0F);
         var2 = ns.b(this.bu * 3.1415927F * 2.0F);
         if (var2 <= -0.3F && var1 >= -0.3F && !this.R()) {
            this.o.a(this.s, this.t, this.u, "mob.enderdragon.wings", 5.0F, 0.8F + this.V.nextFloat() * 0.3F, false);
         }
      }

      this.bu = this.bv;
      float var3;
      if (this.bn() <= 0.0F) {
         var1 = (this.V.nextFloat() - 0.5F) * 8.0F;
         var2 = (this.V.nextFloat() - 0.5F) * 4.0F;
         var3 = (this.V.nextFloat() - 0.5F) * 8.0F;
         this.o.a(cy.b, this.s + (double)var1, this.t + 2.0D + (double)var2, this.u + (double)var3, 0.0D, 0.0D, 0.0D);
      } else {
         this.n();
         var1 = 0.2F / (ns.a(this.v * this.v + this.x * this.x) * 10.0F + 1.0F);
         var1 *= (float)Math.pow(2.0D, this.w);
         if (this.bx) {
            this.bv += var1 * 0.5F;
         } else {
            this.bv += var1;
         }

         this.y = ns.g(this.y);
         if (this.ce()) {
            this.bv = 0.5F;
         } else {
            if (this.bl < 0) {
               for(int var27 = 0; var27 < this.bk.length; ++var27) {
                  this.bk[var27][0] = (double)this.y;
                  this.bk[var27][1] = this.t;
               }
            }

            if (++this.bl == this.bk.length) {
               this.bl = 0;
            }

            this.bk[this.bl][0] = (double)this.y;
            this.bk[this.bl][1] = this.t;
            double var4;
            double var6;
            double var8;
            double var28;
            float var33;
            if (this.o.D) {
               if (this.bc > 0) {
                  var28 = this.s + (this.bd - this.s) / (double)this.bc;
                  var4 = this.t + (this.be - this.t) / (double)this.bc;
                  var6 = this.u + (this.bf - this.u) / (double)this.bc;
                  var8 = ns.g(this.bg - (double)this.y);
                  this.y = (float)((double)this.y + var8 / (double)this.bc);
                  this.z = (float)((double)this.z + (this.bh - (double)this.z) / (double)this.bc);
                  --this.bc;
                  this.b(var28, var4, var6);
                  this.b(this.y, this.z);
               }
            } else {
               var28 = this.a - this.s;
               var4 = this.b - this.t;
               var6 = this.c - this.u;
               var8 = var28 * var28 + var4 * var4 + var6 * var6;
               double var16;
               if (this.bA != null) {
                  this.a = this.bA.s;
                  this.c = this.bA.u;
                  double var10 = this.a - this.s;
                  double var12 = this.c - this.u;
                  double var14 = Math.sqrt(var10 * var10 + var12 * var12);
                  var16 = 0.4000000059604645D + var14 / 80.0D - 1.0D;
                  if (var16 > 10.0D) {
                     var16 = 10.0D;
                  }

                  this.b = this.bA.aR().b + var16;
               } else {
                  this.a += this.V.nextGaussian() * 2.0D;
                  this.c += this.V.nextGaussian() * 2.0D;
               }

               if (this.bw || var8 < 100.0D || var8 > 22500.0D || this.D || this.E) {
                  this.cf();
               }

               var4 /= (double)ns.a(var28 * var28 + var6 * var6);
               var33 = 0.6F;
               var4 = ns.a(var4, (double)(-var33), (double)var33);
               this.w += var4 * 0.10000000149011612D;
               this.y = ns.g(this.y);
               double var11 = 180.0D - ns.b(var28, var6) * 180.0D / 3.1415927410125732D;
               double var13 = ns.g(var11 - (double)this.y);
               if (var13 > 50.0D) {
                  var13 = 50.0D;
               }

               if (var13 < -50.0D) {
                  var13 = -50.0D;
               }

               aui var15 = (new aui(this.a - this.s, this.b - this.t, this.c - this.u)).a();
               var16 = (double)(-ns.b(this.y * 3.1415927F / 180.0F));
               aui var18 = (new aui((double)ns.a(this.y * 3.1415927F / 180.0F), this.w, var16)).a();
               float var19 = ((float)var18.b(var15) + 0.5F) / 1.5F;
               if (var19 < 0.0F) {
                  var19 = 0.0F;
               }

               this.bb *= 0.8F;
               float var20 = ns.a(this.v * this.v + this.x * this.x) * 1.0F + 1.0F;
               double var21 = Math.sqrt(this.v * this.v + this.x * this.x) * 1.0D + 1.0D;
               if (var21 > 40.0D) {
                  var21 = 40.0D;
               }

               this.bb = (float)((double)this.bb + var13 * (0.699999988079071D / var21 / (double)var20));
               this.y += this.bb * 0.1F;
               float var23 = (float)(2.0D / (var21 + 1.0D));
               float var24 = 0.06F;
               this.a(0.0F, -1.0F, var24 * (var19 * var23 + (1.0F - var23)));
               if (this.bx) {
                  this.d(this.v * 0.800000011920929D, this.w * 0.800000011920929D, this.x * 0.800000011920929D);
               } else {
                  this.d(this.v, this.w, this.x);
               }

               aui var25 = (new aui(this.v, this.w, this.x)).a();
               float var26 = ((float)var25.b(var18) + 1.0F) / 2.0F;
               var26 = 0.8F + 0.15F * var26;
               this.v *= (double)var26;
               this.x *= (double)var26;
               this.w *= 0.9100000262260437D;
            }

            this.aI = this.y;
            this.bn.J = this.bn.K = 3.0F;
            this.bp.J = this.bp.K = 2.0F;
            this.bq.J = this.bq.K = 2.0F;
            this.br.J = this.br.K = 2.0F;
            this.bo.K = 3.0F;
            this.bo.J = 5.0F;
            this.bs.K = 2.0F;
            this.bs.J = 4.0F;
            this.bt.K = 3.0F;
            this.bt.J = 4.0F;
            var2 = (float)(this.b(5, 1.0F)[1] - this.b(10, 1.0F)[1]) * 10.0F / 180.0F * 3.1415927F;
            var3 = ns.b(var2);
            float var29 = -ns.a(var2);
            float var5 = this.y * 3.1415927F / 180.0F;
            float var30 = ns.a(var5);
            float var7 = ns.b(var5);
            this.bo.t_();
            this.bo.b(this.s + (double)(var30 * 0.5F), this.t, this.u - (double)(var7 * 0.5F), 0.0F, 0.0F);
            this.bs.t_();
            this.bs.b(this.s + (double)(var7 * 4.5F), this.t + 2.0D, this.u + (double)(var30 * 4.5F), 0.0F, 0.0F);
            this.bt.t_();
            this.bt.b(this.s - (double)(var7 * 4.5F), this.t + 2.0D, this.u - (double)(var30 * 4.5F), 0.0F, 0.0F);
            if (!this.o.D && this.au == 0) {
               this.a(this.o.b((pk)this, (aug)this.bs.aR().b(4.0D, 2.0D, 4.0D).c(0.0D, -2.0D, 0.0D)));
               this.a(this.o.b((pk)this, (aug)this.bt.aR().b(4.0D, 2.0D, 4.0D).c(0.0D, -2.0D, 0.0D)));
               this.b(this.o.b((pk)this, (aug)this.bn.aR().b(1.0D, 1.0D, 1.0D)));
            }

            double[] var31 = this.b(5, 1.0F);
            double[] var9 = this.b(0, 1.0F);
            var33 = ns.a(this.y * 3.1415927F / 180.0F - this.bb * 0.01F);
            float var35 = ns.b(this.y * 3.1415927F / 180.0F - this.bb * 0.01F);
            this.bn.t_();
            this.bn.b(this.s + (double)(var33 * 5.5F * var3), this.t + (var9[1] - var31[1]) * 1.0D + (double)(var29 * 5.5F), this.u - (double)(var35 * 5.5F * var3), 0.0F, 0.0F);

            for(int var32 = 0; var32 < 3; ++var32) {
               ue var34 = null;
               if (var32 == 0) {
                  var34 = this.bp;
               }

               if (var32 == 1) {
                  var34 = this.bq;
               }

               if (var32 == 2) {
                  var34 = this.br;
               }

               double[] var36 = this.b(12 + var32 * 2, 1.0F);
               float var37 = this.y * 3.1415927F / 180.0F + this.b(var36[0] - var31[0]) * 3.1415927F / 180.0F * 1.0F;
               float var39 = ns.a(var37);
               float var38 = ns.b(var37);
               float var40 = 1.5F;
               float var41 = (float)(var32 + 1) * 2.0F;
               var34.t_();
               var34.b(this.s - (double)((var30 * var40 + var39 * var41) * var3), this.t + (var36[1] - var31[1]) * 1.0D - (double)((var41 + var40) * var29) + 1.5D, this.u + (double)((var7 * var40 + var38 * var41) * var3), 0.0F, 0.0F);
            }

            if (!this.o.D) {
               this.bx = this.b(this.bn.aR()) | this.b(this.bo.aR());
            }

         }
      }
   }

   protected void D() {
   }

   public pk[] aB() {
      return this.bm;
   }

   protected void aX() {
      super.aX();
      this.a((qb)vy.a).a(200.0D);
   }

   public boolean a(ow var1, float var2) {
      if (var1 instanceof ox && ((ox)var1).w()) {
         this.e(var1, var2);
      }

      return false;
   }

   private void a(cj var1) {
      boolean var2 = true;
      double var3 = 12.25D;
      double var5 = 6.25D;

      for(int var7 = -1; var7 <= 32; ++var7) {
         for(int var8 = -4; var8 <= 4; ++var8) {
            for(int var9 = -4; var9 <= 4; ++var9) {
               double var10 = (double)(var8 * var8 + var9 * var9);
               if (!(var10 > 12.25D)) {
                  cj var12 = var1.a(var8, var7, var9);
                  if (var7 < 0) {
                     if (var10 <= 6.25D) {
                        this.o.a(var12, afi.h.Q());
                     }
                  } else if (var7 > 0) {
                     this.o.a(var12, afi.a.Q());
                  } else if (var10 > 6.25D) {
                     this.o.a(var12, afi.h.Q());
                  } else {
                     this.o.a(var12, afi.bF.Q());
                  }
               }
            }
         }
      }

      this.o.a(var1, afi.h.Q());
      this.o.a(var1.a(), afi.h.Q());
      cj var13 = var1.b(2);
      this.o.a(var13, afi.h.Q());
      this.o.a(var13.e(), afi.aa.Q().a(akf.a, cq.f));
      this.o.a(var13.f(), afi.aa.Q().a(akf.a, cq.e));
      this.o.a(var13.c(), afi.aa.Q().a(akf.a, cq.d));
      this.o.a(var13.d(), afi.aa.Q().a(akf.a, cq.c));
      this.o.a(var1.b(3), afi.h.Q());
      this.o.a(var1.b(4), afi.bI.Q());
   }

   protected void h() {
      super.h();
   }

   private void cf() {
      this.bw = false;
      ArrayList var1 = Lists.newArrayList(this.o.j);
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         if (((wn)var2.next()).v()) {
            var2.remove();
         }
      }

      if (this.V.nextInt(2) == 0 && !var1.isEmpty()) {
         this.bA = (pk)var1.get(this.V.nextInt(var1.size()));
      } else {
         boolean var3;
         do {
            this.a = 0.0D;
            this.b = (double)(70.0F + this.V.nextFloat() * 50.0F);
            this.c = 0.0D;
            this.a += (double)(this.V.nextFloat() * 120.0F - 60.0F);
            this.c += (double)(this.V.nextFloat() * 120.0F - 60.0F);
            double var4 = this.s - this.a;
            double var6 = this.t - this.b;
            double var8 = this.u - this.c;
            var3 = var4 * var4 + var6 * var6 + var8 * var8 > 100.0D;
         } while(!var3);

         this.bA = null;
      }

   }

   protected boolean e(ow var1, float var2) {
      return super.a(var1, var2);
   }

   protected String bo() {
      return "mob.enderdragon.hit";
   }
}
