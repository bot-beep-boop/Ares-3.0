public class bcp extends bbo {
   private bct a;
   private bct b = new bct(this, "glass");
   private bct c;

   public bcp(float var1, boolean var2) {
      this.b.a(0, 0).a(-4.0F, -4.0F, -4.0F, 8, 8, 8);
      this.a = new bct(this, "cube");
      this.a.a(32, 0).a(-4.0F, -4.0F, -4.0F, 8, 8, 8);
      if (var2) {
         this.c = new bct(this, "base");
         this.c.a(0, 16).a(-6.0F, 0.0F, -6.0F, 12, 4, 12);
      }

   }

   public void a(pk var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      bfl.E();
      bfl.a(2.0F, 2.0F, 2.0F);
      bfl.b(0.0F, -0.5F, 0.0F);
      if (this.c != null) {
         this.c.a(var7);
      }

      bfl.b(var3, 0.0F, 1.0F, 0.0F);
      bfl.b(0.0F, 0.8F + var4, 0.0F);
      bfl.b(60.0F, 0.7071F, 0.0F, 0.7071F);
      this.b.a(var7);
      float var8 = 0.875F;
      bfl.a(var8, var8, var8);
      bfl.b(60.0F, 0.7071F, 0.0F, 0.7071F);
      bfl.b(var3, 0.0F, 1.0F, 0.0F);
      this.b.a(var7);
      bfl.a(var8, var8, var8);
      bfl.b(60.0F, 0.7071F, 0.0F, 0.7071F);
      bfl.b(var3, 0.0F, 1.0F, 0.0F);
      this.a.a(var7);
      bfl.F();
   }
}
