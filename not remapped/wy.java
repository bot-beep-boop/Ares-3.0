import java.util.List;
import java.util.UUID;

public abstract class wy extends pk implements wv {
   public int b;
   private int i;
   private pr g;
   private int d = -1;
   private afh f;
   private int c = -1;
   private int ar;
   private int e = -1;
   protected boolean a;
   private String h;

   protected float j() {
      return 1.5F;
   }

   public void i(double var1, double var3, double var5) {
      this.v = var1;
      this.w = var3;
      this.x = var5;
      if (this.B == 0.0F && this.A == 0.0F) {
         float var7 = ns.a(var1 * var1 + var5 * var5);
         this.A = this.y = (float)(ns.b(var1, var5) * 180.0D / 3.1415927410125732D);
         this.B = this.z = (float)(ns.b(var3, (double)var7) * 180.0D / 3.1415927410125732D);
      }

   }

   public void b(dn var1) {
      var1.a("xTile", (short)this.c);
      var1.a("yTile", (short)this.d);
      var1.a("zTile", (short)this.e);
      jy var2 = (jy)afh.c.c(this.f);
      var1.a("inTile", var2 == null ? "" : var2.toString());
      var1.a("shake", (byte)this.b);
      var1.a("inGround", (byte)(this.a ? 1 : 0));
      if ((this.h == null || this.h.length() == 0) && this.g instanceof wn) {
         this.h = this.g.e_();
      }

      var1.a("ownerName", this.h == null ? "" : this.h);
   }

   public wy(adm var1, pr var2) {
      super(var1);
      this.g = var2;
      this.a(0.25F, 0.25F);
      this.b(var2.s, var2.t + (double)var2.aS(), var2.u, var2.y, var2.z);
      this.s -= (double)(ns.b(this.y / 180.0F * 3.1415927F) * 0.16F);
      this.t -= 0.10000000149011612D;
      this.u -= (double)(ns.a(this.y / 180.0F * 3.1415927F) * 0.16F);
      this.b(this.s, this.t, this.u);
      float var3 = 0.4F;
      this.v = (double)(-ns.a(this.y / 180.0F * 3.1415927F) * ns.b(this.z / 180.0F * 3.1415927F) * var3);
      this.x = (double)(ns.b(this.y / 180.0F * 3.1415927F) * ns.b(this.z / 180.0F * 3.1415927F) * var3);
      this.w = (double)(-ns.a((this.z + this.l()) / 180.0F * 3.1415927F) * var3);
      this.c(this.v, this.w, this.x, this.j(), 1.0F);
   }

   protected abstract void a(auh var1);

   public boolean a(double var1) {
      double var3 = this.aR().a() * 4.0D;
      if (Double.isNaN(var3)) {
         var3 = 4.0D;
      }

      var3 *= 64.0D;
      return var1 < var3 * var3;
   }

   public wy(adm var1) {
      super(var1);
      this.a(0.25F, 0.25F);
   }

   protected void h() {
   }

   protected float l() {
      return 0.0F;
   }

   public void c(double var1, double var3, double var5, float var7, float var8) {
      float var9 = ns.a(var1 * var1 + var3 * var3 + var5 * var5);
      var1 /= (double)var9;
      var3 /= (double)var9;
      var5 /= (double)var9;
      var1 += this.V.nextGaussian() * 0.007499999832361937D * (double)var8;
      var3 += this.V.nextGaussian() * 0.007499999832361937D * (double)var8;
      var5 += this.V.nextGaussian() * 0.007499999832361937D * (double)var8;
      var1 *= (double)var7;
      var3 *= (double)var7;
      var5 *= (double)var7;
      this.v = var1;
      this.w = var3;
      this.x = var5;
      float var10 = ns.a(var1 * var1 + var5 * var5);
      this.A = this.y = (float)(ns.b(var1, var5) * 180.0D / 3.1415927410125732D);
      this.B = this.z = (float)(ns.b(var3, (double)var10) * 180.0D / 3.1415927410125732D);
      this.i = 0;
   }

   public void a(dn var1) {
      this.c = var1.e("xTile");
      this.d = var1.e("yTile");
      this.e = var1.e("zTile");
      if (var1.b("inTile", 8)) {
         this.f = afh.b(var1.j("inTile"));
      } else {
         this.f = afh.c(var1.d("inTile") & 255);
      }

      this.b = var1.d("shake") & 255;
      this.a = var1.d("inGround") == 1;
      this.g = null;
      this.h = var1.j("ownerName");
      if (this.h != null && this.h.length() == 0) {
         this.h = null;
      }

      this.g = this.n();
   }

   public pr n() {
      if (this.g == null && this.h != null && this.h.length() > 0) {
         this.g = this.o.a(this.h);
         if (this.g == null && this.o instanceof le) {
            try {
               pk var1 = ((le)this.o).a(UUID.fromString(this.h));
               if (var1 instanceof pr) {
                  this.g = (pr)var1;
               }
            } catch (Throwable var2) {
               this.g = null;
            }
         }
      }

      return this.g;
   }

   protected float m() {
      return 0.03F;
   }

   public wy(adm var1, double var2, double var4, double var6) {
      super(var1);
      this.i = 0;
      this.a(0.25F, 0.25F);
      this.b(var2, var4, var6);
   }

   public void t_() {
      this.P = this.s;
      this.Q = this.t;
      this.R = this.u;
      super.t_();
      if (this.b > 0) {
         --this.b;
      }

      if (this.a) {
         if (this.o.p(new cj(this.c, this.d, this.e)).c() == this.f) {
            ++this.i;
            if (this.i == 1200) {
               this.J();
            }

            return;
         }

         this.a = false;
         this.v *= (double)(this.V.nextFloat() * 0.2F);
         this.w *= (double)(this.V.nextFloat() * 0.2F);
         this.x *= (double)(this.V.nextFloat() * 0.2F);
         this.i = 0;
         this.ar = 0;
      } else {
         ++this.ar;
      }

      aui var1 = new aui(this.s, this.t, this.u);
      aui var2 = new aui(this.s + this.v, this.t + this.w, this.u + this.x);
      auh var3 = this.o.a(var1, var2);
      var1 = new aui(this.s, this.t, this.u);
      var2 = new aui(this.s + this.v, this.t + this.w, this.u + this.x);
      if (var3 != null) {
         var2 = new aui(var3.c.a, var3.c.b, var3.c.c);
      }

      if (!this.o.D) {
         pk var4 = null;
         List var5 = this.o.b((pk)this, (aug)this.aR().a(this.v, this.w, this.x).b(1.0D, 1.0D, 1.0D));
         double var6 = 0.0D;
         pr var8 = this.n();

         for(int var9 = 0; var9 < var5.size(); ++var9) {
            pk var10 = (pk)var5.get(var9);
            if (var10.ad() && (var10 != var8 || this.ar >= 5)) {
               float var11 = 0.3F;
               aug var12 = var10.aR().b((double)var11, (double)var11, (double)var11);
               auh var13 = var12.a(var1, var2);
               if (var13 != null) {
                  double var14 = var1.g(var13.c);
                  if (var14 < var6 || var6 == 0.0D) {
                     var4 = var10;
                     var6 = var14;
                  }
               }
            }
         }

         if (var4 != null) {
            var3 = new auh(var4);
         }
      }

      if (var3 != null) {
         if (var3.a == auh.a.b && this.o.p(var3.a()).c() == afi.aY) {
            this.d(var3.a());
         } else {
            this.a(var3);
         }
      }

      this.s += this.v;
      this.t += this.w;
      this.u += this.x;
      float var16 = ns.a(this.v * this.v + this.x * this.x);
      this.y = (float)(ns.b(this.v, this.x) * 180.0D / 3.1415927410125732D);

      for(this.z = (float)(ns.b(this.w, (double)var16) * 180.0D / 3.1415927410125732D); this.z - this.B < -180.0F; this.B -= 360.0F) {
      }

      while(this.z - this.B >= 180.0F) {
         this.B += 360.0F;
      }

      while(this.y - this.A < -180.0F) {
         this.A -= 360.0F;
      }

      while(this.y - this.A >= 180.0F) {
         this.A += 360.0F;
      }

      this.z = this.B + (this.z - this.B) * 0.2F;
      this.y = this.A + (this.y - this.A) * 0.2F;
      float var17 = 0.99F;
      float var18 = this.m();
      if (this.V()) {
         for(int var7 = 0; var7 < 4; ++var7) {
            float var19 = 0.25F;
            this.o.a(cy.e, this.s - this.v * (double)var19, this.t - this.w * (double)var19, this.u - this.x * (double)var19, this.v, this.w, this.x);
         }

         var17 = 0.8F;
      }

      this.v *= (double)var17;
      this.w *= (double)var17;
      this.x *= (double)var17;
      this.w -= (double)var18;
      this.b(this.s, this.t, this.u);
   }
}
