public class bce extends bbo {
   public bct c;
   public bct g;
   public bct j;
   public bct k;
   public bct a;
   public bct b;
   public bct f;
   public bct i;
   public bct d;
   public bct e;
   public bct h;

   public void a(float var1, float var2, float var3, float var4, float var5, float var6, pk var7) {
      this.a.g = var4 / 57.295776F;
      this.a.f = var5 / 57.295776F;
      float var8 = 0.7853982F;
      this.d.h = -var8;
      this.e.h = var8;
      this.f.h = -var8 * 0.74F;
      this.g.h = var8 * 0.74F;
      this.h.h = -var8 * 0.74F;
      this.i.h = var8 * 0.74F;
      this.j.h = -var8;
      this.k.h = var8;
      float var9 = -0.0F;
      float var10 = 0.3926991F;
      this.d.g = var10 * 2.0F + var9;
      this.e.g = -var10 * 2.0F - var9;
      this.f.g = var10 * 1.0F + var9;
      this.g.g = -var10 * 1.0F - var9;
      this.h.g = -var10 * 1.0F + var9;
      this.i.g = var10 * 1.0F - var9;
      this.j.g = -var10 * 2.0F + var9;
      this.k.g = var10 * 2.0F - var9;
      float var11 = -(ns.b(var1 * 0.6662F * 2.0F + 0.0F) * 0.4F) * var2;
      float var12 = -(ns.b(var1 * 0.6662F * 2.0F + 3.1415927F) * 0.4F) * var2;
      float var13 = -(ns.b(var1 * 0.6662F * 2.0F + 1.5707964F) * 0.4F) * var2;
      float var14 = -(ns.b(var1 * 0.6662F * 2.0F + 4.712389F) * 0.4F) * var2;
      float var15 = Math.abs(ns.a(var1 * 0.6662F + 0.0F) * 0.4F) * var2;
      float var16 = Math.abs(ns.a(var1 * 0.6662F + 3.1415927F) * 0.4F) * var2;
      float var17 = Math.abs(ns.a(var1 * 0.6662F + 1.5707964F) * 0.4F) * var2;
      float var18 = Math.abs(ns.a(var1 * 0.6662F + 4.712389F) * 0.4F) * var2;
      bct var10000 = this.d;
      var10000.g += var11;
      var10000 = this.e;
      var10000.g += -var11;
      var10000 = this.f;
      var10000.g += var12;
      var10000 = this.g;
      var10000.g += -var12;
      var10000 = this.h;
      var10000.g += var13;
      var10000 = this.i;
      var10000.g += -var13;
      var10000 = this.j;
      var10000.g += var14;
      var10000 = this.k;
      var10000.g += -var14;
      var10000 = this.d;
      var10000.h += var15;
      var10000 = this.e;
      var10000.h += -var15;
      var10000 = this.f;
      var10000.h += var16;
      var10000 = this.g;
      var10000.h += -var16;
      var10000 = this.h;
      var10000.h += var17;
      var10000 = this.i;
      var10000.h += -var17;
      var10000 = this.j;
      var10000.h += var18;
      var10000 = this.k;
      var10000.h += -var18;
   }

   public void a(pk var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.a(var2, var3, var4, var5, var6, var7, var1);
      this.a.a(var7);
      this.b.a(var7);
      this.c.a(var7);
      this.d.a(var7);
      this.e.a(var7);
      this.f.a(var7);
      this.g.a(var7);
      this.h.a(var7);
      this.i.a(var7);
      this.j.a(var7);
      this.k.a(var7);
   }

   public bce() {
      float var1 = 0.0F;
      byte var2 = 15;
      this.a = new bct(this, 32, 4);
      this.a.a(-4.0F, -4.0F, -8.0F, 8, 8, 8, var1);
      this.a.a(0.0F, (float)var2, -3.0F);
      this.b = new bct(this, 0, 0);
      this.b.a(-3.0F, -3.0F, -3.0F, 6, 6, 6, var1);
      this.b.a(0.0F, (float)var2, 0.0F);
      this.c = new bct(this, 0, 12);
      this.c.a(-5.0F, -4.0F, -6.0F, 10, 8, 12, var1);
      this.c.a(0.0F, (float)var2, 9.0F);
      this.d = new bct(this, 18, 0);
      this.d.a(-15.0F, -1.0F, -1.0F, 16, 2, 2, var1);
      this.d.a(-4.0F, (float)var2, 2.0F);
      this.e = new bct(this, 18, 0);
      this.e.a(-1.0F, -1.0F, -1.0F, 16, 2, 2, var1);
      this.e.a(4.0F, (float)var2, 2.0F);
      this.f = new bct(this, 18, 0);
      this.f.a(-15.0F, -1.0F, -1.0F, 16, 2, 2, var1);
      this.f.a(-4.0F, (float)var2, 1.0F);
      this.g = new bct(this, 18, 0);
      this.g.a(-1.0F, -1.0F, -1.0F, 16, 2, 2, var1);
      this.g.a(4.0F, (float)var2, 1.0F);
      this.h = new bct(this, 18, 0);
      this.h.a(-15.0F, -1.0F, -1.0F, 16, 2, 2, var1);
      this.h.a(-4.0F, (float)var2, 0.0F);
      this.i = new bct(this, 18, 0);
      this.i.a(-1.0F, -1.0F, -1.0F, 16, 2, 2, var1);
      this.i.a(4.0F, (float)var2, 0.0F);
      this.j = new bct(this, 18, 0);
      this.j.a(-15.0F, -1.0F, -1.0F, 16, 2, 2, var1);
      this.j.a(-4.0F, (float)var2, -1.0F);
      this.k = new bct(this, 18, 0);
      this.k.a(-1.0F, -1.0F, -1.0F, 16, 2, 2, var1);
      this.k.a(4.0F, (float)var2, -1.0F);
   }
}