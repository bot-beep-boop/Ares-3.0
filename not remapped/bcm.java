public class bcm extends bbo {
   bct g;
   public bct b;
   public bct d;
   public bct e;
   public bct c;
   public bct a;
   bct h;
   public bct f;

   public void a(float var1, float var2, float var3, float var4, float var5, float var6, pk var7) {
      super.a(var1, var2, var3, var4, var5, var6, var7);
      this.a.f = var5 / 57.295776F;
      this.a.g = var4 / 57.295776F;
      this.g.f = var3;
   }

   public bcm() {
      float var1 = 0.0F;
      float var2 = 13.5F;
      this.a = new bct(this, 0, 0);
      this.a.a(-3.0F, -3.0F, -2.0F, 6, 6, 4, var1);
      this.a.a(-1.0F, var2, -7.0F);
      this.b = new bct(this, 18, 14);
      this.b.a(-4.0F, -2.0F, -3.0F, 6, 9, 6, var1);
      this.b.a(0.0F, 14.0F, 2.0F);
      this.h = new bct(this, 21, 0);
      this.h.a(-4.0F, -3.0F, -3.0F, 8, 6, 7, var1);
      this.h.a(-1.0F, 14.0F, 2.0F);
      this.c = new bct(this, 0, 18);
      this.c.a(-1.0F, 0.0F, -1.0F, 2, 8, 2, var1);
      this.c.a(-2.5F, 16.0F, 7.0F);
      this.d = new bct(this, 0, 18);
      this.d.a(-1.0F, 0.0F, -1.0F, 2, 8, 2, var1);
      this.d.a(0.5F, 16.0F, 7.0F);
      this.e = new bct(this, 0, 18);
      this.e.a(-1.0F, 0.0F, -1.0F, 2, 8, 2, var1);
      this.e.a(-2.5F, 16.0F, -4.0F);
      this.f = new bct(this, 0, 18);
      this.f.a(-1.0F, 0.0F, -1.0F, 2, 8, 2, var1);
      this.f.a(0.5F, 16.0F, -4.0F);
      this.g = new bct(this, 9, 18);
      this.g.a(-1.0F, 0.0F, -1.0F, 2, 8, 2, var1);
      this.g.a(-1.0F, 12.0F, 8.0F);
      this.a.a(16, 14).a(-3.0F, -5.0F, 0.0F, 2, 2, 1, var1);
      this.a.a(16, 14).a(1.0F, -5.0F, 0.0F, 2, 2, 1, var1);
      this.a.a(0, 10).a(-1.5F, 0.0F, -5.0F, 3, 3, 4, var1);
   }

   public void a(pk var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      super.a(var1, var2, var3, var4, var5, var6, var7);
      this.a(var2, var3, var4, var5, var6, var7, var1);
      if (this.r) {
         float var8 = 2.0F;
         bfl.E();
         bfl.b(0.0F, 5.0F * var7, 2.0F * var7);
         this.a.b(var7);
         bfl.F();
         bfl.E();
         bfl.a(1.0F / var8, 1.0F / var8, 1.0F / var8);
         bfl.b(0.0F, 24.0F * var7, 0.0F);
         this.b.a(var7);
         this.c.a(var7);
         this.d.a(var7);
         this.e.a(var7);
         this.f.a(var7);
         this.g.b(var7);
         this.h.a(var7);
         bfl.F();
      } else {
         this.a.b(var7);
         this.b.a(var7);
         this.c.a(var7);
         this.d.a(var7);
         this.e.a(var7);
         this.f.a(var7);
         this.g.b(var7);
         this.h.a(var7);
      }

   }

   public void a(pr var1, float var2, float var3, float var4) {
      ua var5 = (ua)var1;
      if (var5.cv()) {
         this.g.g = 0.0F;
      } else {
         this.g.g = ns.b(var2 * 0.6662F) * 1.4F * var3;
      }

      if (var5.cn()) {
         this.h.a(-1.0F, 16.0F, -3.0F);
         this.h.f = 1.2566371F;
         this.h.g = 0.0F;
         this.b.a(0.0F, 18.0F, 0.0F);
         this.b.f = 0.7853982F;
         this.g.a(-1.0F, 21.0F, 6.0F);
         this.c.a(-2.5F, 22.0F, 2.0F);
         this.c.f = 4.712389F;
         this.d.a(0.5F, 22.0F, 2.0F);
         this.d.f = 4.712389F;
         this.e.f = 5.811947F;
         this.e.a(-2.49F, 17.0F, -4.0F);
         this.f.f = 5.811947F;
         this.f.a(0.51F, 17.0F, -4.0F);
      } else {
         this.b.a(0.0F, 14.0F, 2.0F);
         this.b.f = 1.5707964F;
         this.h.a(-1.0F, 14.0F, -3.0F);
         this.h.f = this.b.f;
         this.g.a(-1.0F, 12.0F, 8.0F);
         this.c.a(-2.5F, 16.0F, 7.0F);
         this.d.a(0.5F, 16.0F, 7.0F);
         this.e.a(-2.5F, 16.0F, -4.0F);
         this.f.a(0.5F, 16.0F, -4.0F);
         this.c.f = ns.b(var2 * 0.6662F) * 1.4F * var3;
         this.d.f = ns.b(var2 * 0.6662F + 3.1415927F) * 1.4F * var3;
         this.e.f = ns.b(var2 * 0.6662F + 3.1415927F) * 1.4F * var3;
         this.f.f = ns.b(var2 * 0.6662F) * 1.4F * var3;
      }

      this.a.h = var5.q(var4) + var5.i(var4, 0.0F);
      this.h.h = var5.i(var4, -0.08F);
      this.b.h = var5.i(var4, -0.16F);
      this.g.h = var5.i(var4, -0.2F);
   }
}
