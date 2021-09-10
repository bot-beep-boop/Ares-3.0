public class bay extends bbo {
   public bct f = (new bct(this)).a(24, 10).a(0.0F, -4.0F, 0.0F, 5, 8, 0);
   public bct c = (new bct(this)).a(0, 10).a(0.0F, -4.0F, -0.99F, 5, 8, 1);
   public bct d = (new bct(this)).a(12, 10).a(0.0F, -4.0F, -0.01F, 5, 8, 1);
   public bct b = (new bct(this)).a(16, 0).a(0.0F, -5.0F, 0.0F, 6, 10, 0);
   public bct g = (new bct(this)).a(12, 0).a(-1.0F, -5.0F, 0.0F, 2, 10, 0);
   public bct a = (new bct(this)).a(0, 0).a(-6.0F, -5.0F, 0.0F, 6, 10, 0);
   public bct e = (new bct(this)).a(24, 10).a(0.0F, -4.0F, 0.0F, 5, 8, 0);

   public void a(float var1, float var2, float var3, float var4, float var5, float var6, pk var7) {
      float var8 = (ns.a(var1 * 0.02F) * 0.1F + 1.25F) * var4;
      this.a.g = 3.1415927F + var8;
      this.b.g = -var8;
      this.c.g = var8;
      this.d.g = -var8;
      this.e.g = var8 - var8 * 2.0F * var2;
      this.f.g = var8 - var8 * 2.0F * var3;
      this.c.c = ns.a(var8);
      this.d.c = ns.a(var8);
      this.e.c = ns.a(var8);
      this.f.c = ns.a(var8);
   }

   public bay() {
      this.a.a(0.0F, 0.0F, -1.0F);
      this.b.a(0.0F, 0.0F, 1.0F);
      this.g.g = 1.5707964F;
   }

   public void a(pk var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.a(var2, var3, var4, var5, var6, var7, var1);
      this.a.a(var7);
      this.b.a(var7);
      this.g.a(var7);
      this.c.a(var7);
      this.d.a(var7);
      this.e.a(var7);
      this.f.a(var7);
   }
}
