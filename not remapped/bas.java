public class bas extends bbj {
   public bas(float var1) {
      this(var1, 64, 32);
   }

   public bas() {
      this(0.0F);
   }

   protected bas(float var1, int var2, int var3) {
      super(var1, 0.0F, var2, var3);
   }

   public void a(float var1, float var2, float var3, float var4, float var5, float var6, pk var7) {
      if (var7 instanceof um) {
         um var8 = (um)var7;
         this.e.f = 0.017453292F * var8.t().b();
         this.e.g = 0.017453292F * var8.t().c();
         this.e.h = 0.017453292F * var8.t().d();
         this.e.a(0.0F, 1.0F, 0.0F);
         this.g.f = 0.017453292F * var8.u().b();
         this.g.g = 0.017453292F * var8.u().c();
         this.g.h = 0.017453292F * var8.u().d();
         this.i.f = 0.017453292F * var8.v().b();
         this.i.g = 0.017453292F * var8.v().c();
         this.i.h = 0.017453292F * var8.v().d();
         this.h.f = 0.017453292F * var8.w().b();
         this.h.g = 0.017453292F * var8.w().c();
         this.h.h = 0.017453292F * var8.w().d();
         this.k.f = 0.017453292F * var8.x().b();
         this.k.g = 0.017453292F * var8.x().c();
         this.k.h = 0.017453292F * var8.x().d();
         this.k.a(1.9F, 11.0F, 0.0F);
         this.j.f = 0.017453292F * var8.y().b();
         this.j.g = 0.017453292F * var8.y().c();
         this.j.h = 0.017453292F * var8.y().d();
         this.j.a(-1.9F, 11.0F, 0.0F);
         a(this.e, this.f);
      }
   }
}
