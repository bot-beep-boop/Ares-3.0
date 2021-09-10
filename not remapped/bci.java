public class bci extends bbo {
   public bct d;
   public bct a;
   public bct e;
   public bct c;
   public bct f;
   public bct b;

   public bci(float var1, float var2, int var3, int var4) {
      this.a = (new bct(this)).b(var3, var4);
      this.a.a(0.0F, 0.0F + var2, 0.0F);
      this.a.a(0, 0).a(-4.0F, -10.0F, -4.0F, 8, 10, 8, var1);
      this.f = (new bct(this)).b(var3, var4);
      this.f.a(0.0F, var2 - 2.0F, 0.0F);
      this.f.a(24, 0).a(-1.0F, -1.0F, -6.0F, 2, 4, 2, var1);
      this.a.a(this.f);
      this.b = (new bct(this)).b(var3, var4);
      this.b.a(0.0F, 0.0F + var2, 0.0F);
      this.b.a(16, 20).a(-4.0F, 0.0F, -3.0F, 8, 12, 6, var1);
      this.b.a(0, 38).a(-4.0F, 0.0F, -3.0F, 8, 18, 6, var1 + 0.5F);
      this.c = (new bct(this)).b(var3, var4);
      this.c.a(0.0F, 0.0F + var2 + 2.0F, 0.0F);
      this.c.a(44, 22).a(-8.0F, -2.0F, -2.0F, 4, 8, 4, var1);
      this.c.a(44, 22).a(4.0F, -2.0F, -2.0F, 4, 8, 4, var1);
      this.c.a(40, 38).a(-4.0F, 2.0F, -2.0F, 8, 4, 4, var1);
      this.d = (new bct(this, 0, 22)).b(var3, var4);
      this.d.a(-2.0F, 12.0F + var2, 0.0F);
      this.d.a(-2.0F, 0.0F, -2.0F, 4, 12, 4, var1);
      this.e = (new bct(this, 0, 22)).b(var3, var4);
      this.e.i = true;
      this.e.a(2.0F, 12.0F + var2, 0.0F);
      this.e.a(-2.0F, 0.0F, -2.0F, 4, 12, 4, var1);
   }

   public void a(float var1, float var2, float var3, float var4, float var5, float var6, pk var7) {
      this.a.g = var4 / 57.295776F;
      this.a.f = var5 / 57.295776F;
      this.c.d = 3.0F;
      this.c.e = -1.0F;
      this.c.f = -0.75F;
      this.d.f = ns.b(var1 * 0.6662F) * 1.4F * var2 * 0.5F;
      this.e.f = ns.b(var1 * 0.6662F + 3.1415927F) * 1.4F * var2 * 0.5F;
      this.d.g = 0.0F;
      this.e.g = 0.0F;
   }

   public bci(float var1) {
      this(var1, 0.0F, 64, 64);
   }

   public void a(pk var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.a(var2, var3, var4, var5, var6, var7, var1);
      this.a.a(var7);
      this.b.a(var7);
      this.d.a(var7);
      this.e.a(var7);
      this.c.a(var7);
   }
}
