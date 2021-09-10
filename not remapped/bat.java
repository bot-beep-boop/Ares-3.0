public class bat extends bas {
   public bct c;
   public bct a;
   public bct d;
   public bct b;

   public void a(pk var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      super.a(var1, var2, var3, var4, var5, var6, var7);
      bfl.E();
      if (this.r) {
         float var8 = 2.0F;
         bfl.a(1.0F / var8, 1.0F / var8, 1.0F / var8);
         bfl.b(0.0F, 24.0F * var7, 0.0F);
         this.a.a(var7);
         this.b.a(var7);
         this.c.a(var7);
         this.d.a(var7);
      } else {
         if (var1.av()) {
            bfl.b(0.0F, 0.2F, 0.0F);
         }

         this.a.a(var7);
         this.b.a(var7);
         this.c.a(var7);
         this.d.a(var7);
      }

      bfl.F();
   }

   public void a(float var1) {
      boolean var2 = this.h.j;
      this.h.j = true;
      super.a(var1);
      this.h.j = var2;
   }

   public bat() {
      this(0.0F);
   }

   public void a(float var1, float var2, float var3, float var4, float var5, float var6, pk var7) {
      super.a(var1, var2, var3, var4, var5, var6, var7);
      if (var7 instanceof um) {
         um var8 = (um)var7;
         this.i.j = var8.q();
         this.h.j = var8.q();
         this.d.j = !var8.r();
         this.k.a(1.9F, 12.0F, 0.0F);
         this.j.a(-1.9F, 12.0F, 0.0F);
         this.a.f = 0.017453292F * var8.u().b();
         this.a.g = 0.017453292F * var8.u().c();
         this.a.h = 0.017453292F * var8.u().d();
         this.b.f = 0.017453292F * var8.u().b();
         this.b.g = 0.017453292F * var8.u().c();
         this.b.h = 0.017453292F * var8.u().d();
         this.c.f = 0.017453292F * var8.u().b();
         this.c.g = 0.017453292F * var8.u().c();
         this.c.h = 0.017453292F * var8.u().d();
         float var9 = (var8.x().b() + var8.y().b()) / 2.0F;
         float var10 = (var8.x().c() + var8.y().c()) / 2.0F;
         float var11 = (var8.x().d() + var8.y().d()) / 2.0F;
         this.d.f = 0.0F;
         this.d.g = 0.017453292F * -var7.y;
         this.d.h = 0.0F;
      }
   }

   public bat(float var1) {
      super(var1, 64, 64);
      this.e = new bct(this, 0, 0);
      this.e.a(-1.0F, -7.0F, -1.0F, 2, 7, 2, var1);
      this.e.a(0.0F, 0.0F, 0.0F);
      this.g = new bct(this, 0, 26);
      this.g.a(-6.0F, 0.0F, -1.5F, 12, 3, 3, var1);
      this.g.a(0.0F, 0.0F, 0.0F);
      this.h = new bct(this, 24, 0);
      this.h.a(-2.0F, -2.0F, -1.0F, 2, 12, 2, var1);
      this.h.a(-5.0F, 2.0F, 0.0F);
      this.i = new bct(this, 32, 16);
      this.i.i = true;
      this.i.a(0.0F, -2.0F, -1.0F, 2, 12, 2, var1);
      this.i.a(5.0F, 2.0F, 0.0F);
      this.j = new bct(this, 8, 0);
      this.j.a(-1.0F, 0.0F, -1.0F, 2, 11, 2, var1);
      this.j.a(-1.9F, 12.0F, 0.0F);
      this.k = new bct(this, 40, 16);
      this.k.i = true;
      this.k.a(-1.0F, 0.0F, -1.0F, 2, 11, 2, var1);
      this.k.a(1.9F, 12.0F, 0.0F);
      this.a = new bct(this, 16, 0);
      this.a.a(-3.0F, 3.0F, -1.0F, 2, 7, 2, var1);
      this.a.a(0.0F, 0.0F, 0.0F);
      this.a.j = true;
      this.b = new bct(this, 48, 16);
      this.b.a(1.0F, 3.0F, -1.0F, 2, 7, 2, var1);
      this.b.a(0.0F, 0.0F, 0.0F);
      this.c = new bct(this, 0, 48);
      this.c.a(-4.0F, 10.0F, -1.0F, 8, 2, 2, var1);
      this.c.a(0.0F, 0.0F, 0.0F);
      this.d = new bct(this, 0, 32);
      this.d.a(-6.0F, 11.0F, -6.0F, 12, 1, 12, var1);
      this.d.a(0.0F, 12.0F, 0.0F);
   }
}
