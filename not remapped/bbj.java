public class bbj extends bbo {
   public int m;
   public bct k;
   public bct j;
   public bct e;
   public bct i;
   public bct g;
   public int l;
   public boolean n;
   public boolean o;
   public bct h;
   public bct f;

   public bbj() {
      this(0.0F);
   }

   public void a(pk var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.a(var2, var3, var4, var5, var6, var7, var1);
      bfl.E();
      if (this.r) {
         float var8 = 2.0F;
         bfl.a(1.5F / var8, 1.5F / var8, 1.5F / var8);
         bfl.b(0.0F, 16.0F * var7, 0.0F);
         this.e.a(var7);
         bfl.F();
         bfl.E();
         bfl.a(1.0F / var8, 1.0F / var8, 1.0F / var8);
         bfl.b(0.0F, 24.0F * var7, 0.0F);
         this.g.a(var7);
         this.h.a(var7);
         this.i.a(var7);
         this.j.a(var7);
         this.k.a(var7);
         this.f.a(var7);
      } else {
         if (var1.av()) {
            bfl.b(0.0F, 0.2F, 0.0F);
         }

         this.e.a(var7);
         this.g.a(var7);
         this.h.a(var7);
         this.i.a(var7);
         this.j.a(var7);
         this.k.a(var7);
         this.f.a(var7);
      }

      bfl.F();
   }

   public void a(boolean var1) {
      this.e.j = var1;
      this.f.j = var1;
      this.g.j = var1;
      this.h.j = var1;
      this.i.j = var1;
      this.j.j = var1;
      this.k.j = var1;
   }

   public void a(float var1, float var2, float var3, float var4, float var5, float var6, pk var7) {
      this.e.g = var4 / 57.295776F;
      this.e.f = var5 / 57.295776F;
      this.h.f = ns.b(var1 * 0.6662F + 3.1415927F) * 2.0F * var2 * 0.5F;
      this.i.f = ns.b(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
      this.h.h = 0.0F;
      this.i.h = 0.0F;
      this.j.f = ns.b(var1 * 0.6662F) * 1.4F * var2;
      this.k.f = ns.b(var1 * 0.6662F + 3.1415927F) * 1.4F * var2;
      this.j.g = 0.0F;
      this.k.g = 0.0F;
      bct var10000;
      if (this.q) {
         var10000 = this.h;
         var10000.f += -0.62831855F;
         var10000 = this.i;
         var10000.f += -0.62831855F;
         this.j.f = -1.2566371F;
         this.k.f = -1.2566371F;
         this.j.g = 0.31415927F;
         this.k.g = -0.31415927F;
      }

      if (this.l != 0) {
         this.i.f = this.i.f * 0.5F - 0.31415927F * (float)this.l;
      }

      this.h.g = 0.0F;
      this.h.h = 0.0F;
      switch(this.m) {
      case 0:
      case 2:
      default:
         break;
      case 1:
         this.h.f = this.h.f * 0.5F - 0.31415927F * (float)this.m;
         break;
      case 3:
         this.h.f = this.h.f * 0.5F - 0.31415927F * (float)this.m;
         this.h.g = -0.5235988F;
      }

      this.i.g = 0.0F;
      float var8;
      float var9;
      if (this.p > -9990.0F) {
         var8 = this.p;
         this.g.g = ns.a(ns.c(var8) * 3.1415927F * 2.0F) * 0.2F;
         this.h.e = ns.a(this.g.g) * 5.0F;
         this.h.c = -ns.b(this.g.g) * 5.0F;
         this.i.e = -ns.a(this.g.g) * 5.0F;
         this.i.c = ns.b(this.g.g) * 5.0F;
         var10000 = this.h;
         var10000.g += this.g.g;
         var10000 = this.i;
         var10000.g += this.g.g;
         var10000 = this.i;
         var10000.f += this.g.g;
         var8 = 1.0F - this.p;
         var8 *= var8;
         var8 *= var8;
         var8 = 1.0F - var8;
         var9 = ns.a(var8 * 3.1415927F);
         float var10 = ns.a(this.p * 3.1415927F) * -(this.e.f - 0.7F) * 0.75F;
         var10000 = this.h;
         var10000.f = (float)((double)var10000.f - ((double)var9 * 1.2D + (double)var10));
         var10000 = this.h;
         var10000.g += this.g.g * 2.0F;
         var10000 = this.h;
         var10000.h += ns.a(this.p * 3.1415927F) * -0.4F;
      }

      if (this.n) {
         this.g.f = 0.5F;
         var10000 = this.h;
         var10000.f += 0.4F;
         var10000 = this.i;
         var10000.f += 0.4F;
         this.j.e = 4.0F;
         this.k.e = 4.0F;
         this.j.d = 9.0F;
         this.k.d = 9.0F;
         this.e.d = 1.0F;
      } else {
         this.g.f = 0.0F;
         this.j.e = 0.1F;
         this.k.e = 0.1F;
         this.j.d = 12.0F;
         this.k.d = 12.0F;
         this.e.d = 0.0F;
      }

      var10000 = this.h;
      var10000.h += ns.b(var3 * 0.09F) * 0.05F + 0.05F;
      var10000 = this.i;
      var10000.h -= ns.b(var3 * 0.09F) * 0.05F + 0.05F;
      var10000 = this.h;
      var10000.f += ns.a(var3 * 0.067F) * 0.05F;
      var10000 = this.i;
      var10000.f -= ns.a(var3 * 0.067F) * 0.05F;
      if (this.o) {
         var8 = 0.0F;
         var9 = 0.0F;
         this.h.h = 0.0F;
         this.i.h = 0.0F;
         this.h.g = -(0.1F - var8 * 0.6F) + this.e.g;
         this.i.g = 0.1F - var8 * 0.6F + this.e.g + 0.4F;
         this.h.f = -1.5707964F + this.e.f;
         this.i.f = -1.5707964F + this.e.f;
         var10000 = this.h;
         var10000.f -= var8 * 1.2F - var9 * 0.4F;
         var10000 = this.i;
         var10000.f -= var8 * 1.2F - var9 * 0.4F;
         var10000 = this.h;
         var10000.h += ns.b(var3 * 0.09F) * 0.05F + 0.05F;
         var10000 = this.i;
         var10000.h -= ns.b(var3 * 0.09F) * 0.05F + 0.05F;
         var10000 = this.h;
         var10000.f += ns.a(var3 * 0.067F) * 0.05F;
         var10000 = this.i;
         var10000.f -= ns.a(var3 * 0.067F) * 0.05F;
      }

      a(this.e, this.f);
   }

   public bbj(float var1) {
      this(var1, 0.0F, 64, 32);
   }

   public void a(bbo var1) {
      super.a(var1);
      if (var1 instanceof bbj) {
         bbj var2 = (bbj)var1;
         this.l = var2.l;
         this.m = var2.m;
         this.n = var2.n;
         this.o = var2.o;
      }

   }

   public void a(float var1) {
      this.h.c(var1);
   }

   public bbj(float var1, float var2, int var3, int var4) {
      this.t = var3;
      this.u = var4;
      this.e = new bct(this, 0, 0);
      this.e.a(-4.0F, -8.0F, -4.0F, 8, 8, 8, var1);
      this.e.a(0.0F, 0.0F + var2, 0.0F);
      this.f = new bct(this, 32, 0);
      this.f.a(-4.0F, -8.0F, -4.0F, 8, 8, 8, var1 + 0.5F);
      this.f.a(0.0F, 0.0F + var2, 0.0F);
      this.g = new bct(this, 16, 16);
      this.g.a(-4.0F, 0.0F, -2.0F, 8, 12, 4, var1);
      this.g.a(0.0F, 0.0F + var2, 0.0F);
      this.h = new bct(this, 40, 16);
      this.h.a(-3.0F, -2.0F, -2.0F, 4, 12, 4, var1);
      this.h.a(-5.0F, 2.0F + var2, 0.0F);
      this.i = new bct(this, 40, 16);
      this.i.i = true;
      this.i.a(-1.0F, -2.0F, -2.0F, 4, 12, 4, var1);
      this.i.a(5.0F, 2.0F + var2, 0.0F);
      this.j = new bct(this, 0, 16);
      this.j.a(-2.0F, 0.0F, -2.0F, 4, 12, 4, var1);
      this.j.a(-1.9F, 12.0F + var2, 0.0F);
      this.k = new bct(this, 0, 16);
      this.k.i = true;
      this.k.a(-2.0F, 0.0F, -2.0F, 4, 12, 4, var1);
      this.k.a(1.9F, 12.0F + var2, 0.0F);
   }
}
