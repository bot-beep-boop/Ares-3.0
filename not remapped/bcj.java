public class bcj extends bbj {
   public bcj() {
      this(0.0F, 0.0F, false);
   }

   public bcj(float var1, float var2, boolean var3) {
      super(var1, 0.0F, 64, var3 ? 32 : 64);
      if (var3) {
         this.e = new bct(this, 0, 0);
         this.e.a(-4.0F, -10.0F, -4.0F, 8, 8, 8, var1);
         this.e.a(0.0F, 0.0F + var2, 0.0F);
      } else {
         this.e = new bct(this);
         this.e.a(0.0F, 0.0F + var2, 0.0F);
         this.e.a(0, 32).a(-4.0F, -10.0F, -4.0F, 8, 10, 8, var1);
         this.e.a(24, 32).a(-1.0F, -3.0F, -6.0F, 2, 4, 2, var1);
      }

   }

   public void a(float var1, float var2, float var3, float var4, float var5, float var6, pk var7) {
      super.a(var1, var2, var3, var4, var5, var6, var7);
      float var8 = ns.a(this.p * 3.1415927F);
      float var9 = ns.a((1.0F - (1.0F - this.p) * (1.0F - this.p)) * 3.1415927F);
      this.h.h = 0.0F;
      this.i.h = 0.0F;
      this.h.g = -(0.1F - var8 * 0.6F);
      this.i.g = 0.1F - var8 * 0.6F;
      this.h.f = -1.5707964F;
      this.i.f = -1.5707964F;
      bct var10000 = this.h;
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
}
