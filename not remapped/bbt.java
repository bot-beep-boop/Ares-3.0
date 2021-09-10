public class bbt extends bbo {
   public bct f;
   protected float h = 4.0F;
   public bct e;
   public bct a = new bct(this, 0, 0);
   public bct d;
   protected float g = 8.0F;
   public bct b;
   public bct c;

   public void a(float var1, float var2, float var3, float var4, float var5, float var6, pk var7) {
      float var8 = 57.295776F;
      this.a.f = var5 / 57.295776F;
      this.a.g = var4 / 57.295776F;
      this.b.f = 1.5707964F;
      this.c.f = ns.b(var1 * 0.6662F) * 1.4F * var2;
      this.d.f = ns.b(var1 * 0.6662F + 3.1415927F) * 1.4F * var2;
      this.e.f = ns.b(var1 * 0.6662F + 3.1415927F) * 1.4F * var2;
      this.f.f = ns.b(var1 * 0.6662F) * 1.4F * var2;
   }

   public bbt(int var1, float var2) {
      this.a.a(-4.0F, -4.0F, -8.0F, 8, 8, 8, var2);
      this.a.a(0.0F, (float)(18 - var1), -6.0F);
      this.b = new bct(this, 28, 8);
      this.b.a(-5.0F, -10.0F, -7.0F, 10, 16, 8, var2);
      this.b.a(0.0F, (float)(17 - var1), 2.0F);
      this.c = new bct(this, 0, 16);
      this.c.a(-2.0F, 0.0F, -2.0F, 4, var1, 4, var2);
      this.c.a(-3.0F, (float)(24 - var1), 7.0F);
      this.d = new bct(this, 0, 16);
      this.d.a(-2.0F, 0.0F, -2.0F, 4, var1, 4, var2);
      this.d.a(3.0F, (float)(24 - var1), 7.0F);
      this.e = new bct(this, 0, 16);
      this.e.a(-2.0F, 0.0F, -2.0F, 4, var1, 4, var2);
      this.e.a(-3.0F, (float)(24 - var1), -5.0F);
      this.f = new bct(this, 0, 16);
      this.f.a(-2.0F, 0.0F, -2.0F, 4, var1, 4, var2);
      this.f.a(3.0F, (float)(24 - var1), -5.0F);
   }

   public void a(pk var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.a(var2, var3, var4, var5, var6, var7, var1);
      if (this.r) {
         float var8 = 2.0F;
         bfl.E();
         bfl.b(0.0F, this.g * var7, this.h * var7);
         this.a.a(var7);
         bfl.F();
         bfl.E();
         bfl.a(1.0F / var8, 1.0F / var8, 1.0F / var8);
         bfl.b(0.0F, 24.0F * var7, 0.0F);
         this.b.a(var7);
         this.c.a(var7);
         this.d.a(var7);
         this.e.a(var7);
         this.f.a(var7);
         bfl.F();
      } else {
         this.a.a(var7);
         this.b.a(var7);
         this.c.a(var7);
         this.d.a(var7);
         this.e.a(var7);
         this.f.a(var7);
      }

   }
}
