public class bav extends bbo {
   private bct a;
   private bct e;
   private bct c;
   private bct d;
   private bct b;
   private bct f;

   public void a(float var1, float var2, float var3, float var4, float var5, float var6, pk var7) {
      float var8;
      if (((tk)var7).n()) {
         var8 = 57.295776F;
         this.a.f = var5 / 57.295776F;
         this.a.g = 3.1415927F - var4 / 57.295776F;
         this.a.h = 3.1415927F;
         this.a.a(0.0F, -2.0F, 0.0F);
         this.c.a(-3.0F, 0.0F, 3.0F);
         this.d.a(3.0F, 0.0F, 3.0F);
         this.b.f = 3.1415927F;
         this.c.f = -0.15707964F;
         this.c.g = -1.2566371F;
         this.e.g = -1.7278761F;
         this.d.f = this.c.f;
         this.d.g = -this.c.g;
         this.f.g = -this.e.g;
      } else {
         var8 = 57.295776F;
         this.a.f = var5 / 57.295776F;
         this.a.g = var4 / 57.295776F;
         this.a.h = 0.0F;
         this.a.a(0.0F, 0.0F, 0.0F);
         this.c.a(0.0F, 0.0F, 0.0F);
         this.d.a(0.0F, 0.0F, 0.0F);
         this.b.f = 0.7853982F + ns.b(var3 * 0.1F) * 0.15F;
         this.b.g = 0.0F;
         this.c.g = ns.b(var3 * 1.3F) * 3.1415927F * 0.25F;
         this.d.g = -this.c.g;
         this.e.g = this.c.g * 0.5F;
         this.f.g = -this.c.g * 0.5F;
      }

   }

   public void a(pk var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.a(var2, var3, var4, var5, var6, var7, var1);
      this.a.a(var7);
      this.b.a(var7);
   }

   public bav() {
      this.t = 64;
      this.u = 64;
      this.a = new bct(this, 0, 0);
      this.a.a(-3.0F, -3.0F, -3.0F, 6, 6, 6);
      bct var1 = new bct(this, 24, 0);
      var1.a(-4.0F, -6.0F, -2.0F, 3, 4, 1);
      this.a.a(var1);
      bct var2 = new bct(this, 24, 0);
      var2.i = true;
      var2.a(1.0F, -6.0F, -2.0F, 3, 4, 1);
      this.a.a(var2);
      this.b = new bct(this, 0, 16);
      this.b.a(-3.0F, 4.0F, -3.0F, 6, 12, 6);
      this.b.a(0, 34).a(-5.0F, 16.0F, 0.0F, 10, 6, 1);
      this.c = new bct(this, 42, 0);
      this.c.a(-12.0F, 1.0F, 1.5F, 10, 16, 1);
      this.e = new bct(this, 24, 16);
      this.e.a(-12.0F, 1.0F, 1.5F);
      this.e.a(-8.0F, 1.0F, 0.0F, 8, 12, 1);
      this.d = new bct(this, 42, 0);
      this.d.i = true;
      this.d.a(2.0F, 1.0F, 1.5F, 10, 16, 1);
      this.f = new bct(this, 24, 16);
      this.f.i = true;
      this.f.a(12.0F, 1.0F, 1.5F);
      this.f.a(0.0F, 1.0F, 0.0F, 8, 12, 1);
      this.b.a(this.c);
      this.b.a(this.d);
      this.c.a(this.e);
      this.d.a(this.f);
   }
}
