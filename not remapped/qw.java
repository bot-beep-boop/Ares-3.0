public class qw extends rd {
   private boolean d;
   private float c;
   private final float b;
   private int e;
   private int f;
   private final ps a;

   public qw(ps var1, float var2) {
      this.a = var1;
      this.b = var2;
      this.a(7);
   }

   public void g() {
      this.d = true;
      this.e = 0;
      this.f = this.a.bc().nextInt(841) + 140;
   }

   public boolean f() {
      return this.d;
   }

   public boolean a() {
      return this.a.ai() && this.a.l != null && this.a.l instanceof wn && (this.d || this.a.bW());
   }

   public void c() {
      this.c = 0.0F;
   }

   public void e() {
      wn var1 = (wn)this.a.l;
      py var2 = (py)this.a;
      float var3 = ns.g(var1.y - this.a.y) * 0.5F;
      if (var3 > 5.0F) {
         var3 = 5.0F;
      }

      if (var3 < -5.0F) {
         var3 = -5.0F;
      }

      this.a.y = ns.g(this.a.y + var3);
      if (this.c < this.b) {
         this.c += (this.b - this.c) * 0.01F;
      }

      if (this.c > this.b) {
         this.c = this.b;
      }

      int var4 = ns.c(this.a.s);
      int var5 = ns.c(this.a.t);
      int var6 = ns.c(this.a.u);
      float var7 = this.c;
      if (this.d) {
         if (this.e++ > this.f) {
            this.d = false;
         }

         var7 += var7 * 1.15F * ns.a((float)this.e / (float)this.f * 3.1415927F);
      }

      float var8 = 0.91F;
      if (this.a.C) {
         var8 = this.a.o.p(new cj(ns.d((float)var4), ns.d((float)var5) - 1, ns.d((float)var6))).c().L * 0.91F;
      }

      float var9 = 0.16277136F / (var8 * var8 * var8);
      float var10 = ns.a(var2.y * 3.1415927F / 180.0F);
      float var11 = ns.b(var2.y * 3.1415927F / 180.0F);
      float var12 = var2.bI() * var9;
      float var13 = Math.max(var7, 1.0F);
      var13 = var12 / var13;
      float var14 = var7 * var13;
      float var15 = -(var14 * var10);
      float var16 = var14 * var11;
      if (ns.e(var15) > ns.e(var16)) {
         if (var15 < 0.0F) {
            var15 -= this.a.J / 2.0F;
         }

         if (var15 > 0.0F) {
            var15 += this.a.J / 2.0F;
         }

         var16 = 0.0F;
      } else {
         var15 = 0.0F;
         if (var16 < 0.0F) {
            var16 -= this.a.J / 2.0F;
         }

         if (var16 > 0.0F) {
            var16 += this.a.J / 2.0F;
         }
      }

      int var17 = ns.c(this.a.s + (double)var15);
      int var18 = ns.c(this.a.u + (double)var16);
      int var19 = ns.d(this.a.J + 1.0F);
      int var20 = ns.d(this.a.K + var1.K + 1.0F);
      int var21 = ns.d(this.a.J + 1.0F);
      if (var4 != var17 || var6 != var18) {
         afh var22 = this.a.o.p(new cj(var4, var5, var6)).c();
         boolean var23 = !this.a(var22) && (var22.t() != arm.a || !this.a(this.a.o.p(new cj(var4, var5 - 1, var6)).c()));
         if (var23 && 0 == ata.a(this.a.o, this.a, var17, var5, var18, var19, var20, var21, false, false, true) && 1 == ata.a(this.a.o, this.a, var4, var5 + 1, var6, var19, var20, var21, false, false, true) && 1 == ata.a(this.a.o, this.a, var17, var5 + 1, var18, var19, var20, var21, false, false, true)) {
            var2.r().a();
         }
      }

      if (!var1.bA.d && this.c >= this.b * 0.5F && this.a.bc().nextFloat() < 0.006F && !this.d) {
         zx var24 = var1.bA();
         if (var24 != null && var24.b() == zy.bY) {
            var24.a(1, (pr)var1);
            if (var24.b == 0) {
               zx var25 = new zx(zy.aR);
               var25.d(var24.o());
               var1.bi.a[var1.bi.c] = var25;
            }
         }
      }

      this.a.g(0.0F, var7);
   }

   public boolean h() {
      return !this.f() && this.c > this.b * 0.3F;
   }

   public void d() {
      this.d = false;
      this.c = 0.0F;
   }

   private boolean a(afh var1) {
      return var1 instanceof aju || var1 instanceof ahh;
   }
}
