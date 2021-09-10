import org.lwjgl.opengl.GL11;

public class bfn {
   private zx d;
   private static final jy b = new jy("textures/misc/underwater.png");
   private int i = -1;
   private static final jy a = new jy("textures/map/map_background.png");
   private final bjh h;
   private final biu g;
   private final ave c;
   private float e;
   private float f;

   private void d(float var1) {
      float var2 = -0.4F * ns.a(ns.c(var1) * 3.1415927F);
      float var3 = 0.2F * ns.a(ns.c(var1) * 3.1415927F * 2.0F);
      float var4 = -0.2F * ns.a(var1 * 3.1415927F);
      bfl.b(var2, var3, var4);
   }

   public void b() {
      this.e = 0.0F;
   }

   private void a(bet var1, float var2) {
      float var3 = (float)var1.bR() - var2 + 1.0F;
      float var4 = var3 / (float)this.d.l();
      float var5 = ns.e(ns.b(var3 / 4.0F * 3.1415927F) * 0.1F);
      if (var4 >= 0.8F) {
         var5 = 0.0F;
      }

      bfl.b(0.0F, var5, 0.0F);
      float var6 = 1.0F - (float)Math.pow((double)var4, 27.0D);
      bfl.b(var6 * 0.6F, var6 * -0.5F, var6 * 0.0F);
      bfl.b(var6 * 90.0F, 0.0F, 1.0F, 0.0F);
      bfl.b(var6 * 10.0F, 1.0F, 0.0F, 0.0F);
      bfl.b(var6 * 30.0F, 0.0F, 0.0F, 1.0F);
   }

   public void a() {
      this.f = this.e;
      bew var1 = this.c.h;
      zx var2 = var1.bi.h();
      boolean var3 = false;
      if (this.d != null && var2 != null) {
         if (!this.d.c(var2)) {
            var3 = true;
         }
      } else if (this.d == null && var2 == null) {
         var3 = false;
      } else {
         var3 = true;
      }

      float var4 = 0.4F;
      float var5 = var3 ? 0.0F : 1.0F;
      float var6 = ns.a(var5 - this.e, -var4, var4);
      this.e += var6;
      if (this.e < 0.1F) {
         this.d = var2;
         this.i = var1.bi.c;
      }

   }

   private boolean a(afh var1) {
      return var1 != null && var1.m() == adf.d;
   }

   private void a(bln var1) {
      bfl.E();
      bfl.b(54.0F, 0.0F, 1.0F, 0.0F);
      bfl.b(64.0F, 1.0F, 0.0F, 0.0F);
      bfl.b(-62.0F, 0.0F, 0.0F, 1.0F);
      bfl.b(0.25F, -0.85F, 0.75F);
      var1.b(this.c.h);
      bfl.F();
   }

   private void d() {
      bfl.b(-0.5F, 0.2F, 0.0F);
      bfl.b(30.0F, 0.0F, 1.0F, 0.0F);
      bfl.b(-80.0F, 1.0F, 0.0F, 0.0F);
      bfl.b(60.0F, 0.0F, 1.0F, 0.0F);
   }

   private float c(float var1) {
      float var2 = 1.0F - var1 / 45.0F + 0.1F;
      var2 = ns.a(var2, 0.0F, 1.0F);
      var2 = -ns.b(var2 * 3.1415927F) * 0.5F + 0.5F;
      return var2;
   }

   private void a(float var1, bet var2) {
      bfl.b(-18.0F, 0.0F, 0.0F, 1.0F);
      bfl.b(-12.0F, 0.0F, 1.0F, 0.0F);
      bfl.b(-8.0F, 1.0F, 0.0F, 0.0F);
      bfl.b(-0.9F, 0.2F, 0.0F);
      float var3 = (float)this.d.l() - ((float)var2.bR() - var1 + 1.0F);
      float var4 = var3 / 20.0F;
      var4 = (var4 * var4 + var4 * 2.0F) / 3.0F;
      if (var4 > 1.0F) {
         var4 = 1.0F;
      }

      if (var4 > 0.1F) {
         float var5 = ns.a((var3 - 0.1F) * 1.3F);
         float var6 = var4 - 0.1F;
         float var7 = var5 * var6;
         bfl.b(var7 * 0.0F, var7 * 0.01F, var7 * 0.0F);
      }

      bfl.b(var4 * 0.0F, var4 * 0.0F, var4 * 0.1F);
      bfl.a(1.0F, 1.0F, 1.0F + var4 * 0.2F);
   }

   private void b(float var1, float var2) {
      bfl.b(0.56F, -0.52F, -0.71999997F);
      bfl.b(0.0F, var1 * -0.6F, 0.0F);
      bfl.b(45.0F, 0.0F, 1.0F, 0.0F);
      float var3 = ns.a(var2 * var2 * 3.1415927F);
      float var4 = ns.a(ns.c(var2) * 3.1415927F);
      bfl.b(var3 * -20.0F, 0.0F, 1.0F, 0.0F);
      bfl.b(var4 * -20.0F, 0.0F, 0.0F, 1.0F);
      bfl.b(var4 * -80.0F, 1.0F, 0.0F, 0.0F);
      bfl.a(0.4F, 0.4F, 0.4F);
   }

   private void a(bet var1, float var2, float var3, float var4) {
      float var5 = -0.4F * ns.a(ns.c(var4) * 3.1415927F);
      float var6 = 0.2F * ns.a(ns.c(var4) * 3.1415927F * 2.0F);
      float var7 = -0.2F * ns.a(var4 * 3.1415927F);
      bfl.b(var5, var6, var7);
      float var8 = this.c(var2);
      bfl.b(0.0F, 0.04F, -0.72F);
      bfl.b(0.0F, var3 * -1.2F, 0.0F);
      bfl.b(0.0F, var8 * -0.5F, 0.0F);
      bfl.b(90.0F, 0.0F, 1.0F, 0.0F);
      bfl.b(var8 * -85.0F, 0.0F, 0.0F, 1.0F);
      bfl.b(0.0F, 1.0F, 0.0F, 0.0F);
      this.b(var1);
      float var9 = ns.a(var4 * var4 * 3.1415927F);
      float var10 = ns.a(ns.c(var4) * 3.1415927F);
      bfl.b(var9 * -20.0F, 0.0F, 1.0F, 0.0F);
      bfl.b(var10 * -20.0F, 0.0F, 0.0F, 1.0F);
      bfl.b(var10 * -80.0F, 1.0F, 0.0F, 0.0F);
      bfl.a(0.38F, 0.38F, 0.38F);
      bfl.b(90.0F, 0.0F, 1.0F, 0.0F);
      bfl.b(180.0F, 0.0F, 0.0F, 1.0F);
      bfl.b(0.0F, 1.0F, 0.0F, 0.0F);
      bfl.b(-1.0F, -1.0F, 0.0F);
      bfl.a(0.015625F, 0.015625F, 0.015625F);
      this.c.P().a(a);
      bfx var11 = bfx.a();
      bfd var12 = var11.c();
      GL11.glNormal3f(0.0F, 0.0F, -1.0F);
      var12.a(7, bms.g);
      var12.b(-7.0D, 135.0D, 0.0D).a(0.0D, 1.0D).d();
      var12.b(135.0D, 135.0D, 0.0D).a(1.0D, 1.0D).d();
      var12.b(135.0D, -7.0D, 0.0D).a(1.0D, 0.0D).d();
      var12.b(-7.0D, -7.0D, 0.0D).a(0.0D, 0.0D).d();
      var11.b();
      atg var13 = zy.bd.a(this.d, this.c.f);
      if (var13 != null) {
         this.c.o.k().a(var13, false);
      }

   }

   public bfn(ave var1) {
      this.c = var1;
      this.g = var1.af();
      this.h = var1.ag();
   }

   public void c() {
      this.e = 0.0F;
   }

   private void a(bet var1) {
      int var2 = this.c.f.b(new cj(var1.s, var1.t + (double)var1.aS(), var1.u), 0);
      float var3 = (float)(var2 & '\uffff');
      float var4 = (float)(var2 >> 16);
      bqs.a(bqs.r, var3, var4);
   }

   public void b(float var1) {
      bfl.c();
      if (this.c.h.aj()) {
         alz var2 = this.c.f.p(new cj(this.c.h));
         bew var3 = this.c.h;

         for(int var4 = 0; var4 < 8; ++var4) {
            double var5 = var3.s + (double)(((float)((var4 >> 0) % 2) - 0.5F) * var3.J * 0.8F);
            double var7 = var3.t + (double)(((float)((var4 >> 1) % 2) - 0.5F) * 0.1F);
            double var9 = var3.u + (double)(((float)((var4 >> 2) % 2) - 0.5F) * var3.J * 0.8F);
            cj var11 = new cj(var5, var7 + (double)var3.aS(), var9);
            alz var12 = this.c.f.p(var11);
            if (var12.c().w()) {
               var2 = var12;
            }
         }

         if (var2.c().b() != -1) {
            this.a(var1, this.c.ae().a().a(var2));
         }
      }

      if (!this.c.h.v()) {
         if (this.c.h.a((arm)arm.h)) {
            this.e(var1);
         }

         if (this.c.h.at()) {
            this.f(var1);
         }
      }

      bfl.d();
   }

   public void a(pr var1, zx var2, bgr.b var3) {
      if (var2 != null) {
         zw var4 = var2.b();
         afh var5 = afh.a(var4);
         bfl.E();
         if (this.h.a(var2)) {
            bfl.a(2.0F, 2.0F, 2.0F);
            if (this.a(var5)) {
               bfl.a(false);
            }
         }

         this.h.a(var2, var1, var3);
         if (this.a(var5)) {
            bfl.a(true);
         }

         bfl.F();
      }
   }

   private void b(bln var1) {
      bfl.E();
      bfl.b(92.0F, 0.0F, 1.0F, 0.0F);
      bfl.b(45.0F, 1.0F, 0.0F, 0.0F);
      bfl.b(41.0F, 0.0F, 0.0F, 1.0F);
      bfl.b(-0.3F, -1.1F, 0.45F);
      var1.c(this.c.h);
      bfl.F();
   }

   private void a(float var1, bmi var2) {
      this.c.P().a(bmh.g);
      bfx var3 = bfx.a();
      bfd var4 = var3.c();
      float var5 = 0.1F;
      bfl.c(0.1F, 0.1F, 0.1F, 0.5F);
      bfl.E();
      float var6 = -1.0F;
      float var7 = 1.0F;
      float var8 = -1.0F;
      float var9 = 1.0F;
      float var10 = -0.5F;
      float var11 = var2.e();
      float var12 = var2.f();
      float var13 = var2.g();
      float var14 = var2.h();
      var4.a(7, bms.g);
      var4.b(-1.0D, -1.0D, -0.5D).a((double)var12, (double)var14).d();
      var4.b(1.0D, -1.0D, -0.5D).a((double)var11, (double)var14).d();
      var4.b(1.0D, 1.0D, -0.5D).a((double)var11, (double)var13).d();
      var4.b(-1.0D, 1.0D, -0.5D).a((double)var12, (double)var13).d();
      var3.b();
      bfl.F();
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
   }

   private void a(bew var1, float var2) {
      float var3 = var1.i + (var1.g - var1.i) * var2;
      float var4 = var1.h + (var1.f - var1.h) * var2;
      bfl.b((var1.z - var3) * 0.1F, 1.0F, 0.0F, 0.0F);
      bfl.b((var1.y - var4) * 0.1F, 0.0F, 1.0F, 0.0F);
   }

   private void a(bet var1, float var2, float var3) {
      float var4 = -0.3F * ns.a(ns.c(var3) * 3.1415927F);
      float var5 = 0.4F * ns.a(ns.c(var3) * 3.1415927F * 2.0F);
      float var6 = -0.4F * ns.a(var3 * 3.1415927F);
      bfl.b(var4, var5, var6);
      bfl.b(0.64000005F, -0.6F, -0.71999997F);
      bfl.b(0.0F, var2 * -0.6F, 0.0F);
      bfl.b(45.0F, 0.0F, 1.0F, 0.0F);
      float var7 = ns.a(var3 * var3 * 3.1415927F);
      float var8 = ns.a(ns.c(var3) * 3.1415927F);
      bfl.b(var8 * 70.0F, 0.0F, 1.0F, 0.0F);
      bfl.b(var7 * -20.0F, 0.0F, 0.0F, 1.0F);
      this.c.P().a(var1.i());
      bfl.b(-1.0F, 3.6F, 3.5F);
      bfl.b(120.0F, 0.0F, 0.0F, 1.0F);
      bfl.b(200.0F, 1.0F, 0.0F, 0.0F);
      bfl.b(-135.0F, 0.0F, 1.0F, 0.0F);
      bfl.a(1.0F, 1.0F, 1.0F);
      bfl.b(5.6F, 0.0F, 0.0F);
      biv var9 = this.g.a((pk)this.c.h);
      bfl.p();
      bln var10 = (bln)var9;
      var10.b(this.c.h);
      bfl.o();
   }

   private void f(float var1) {
      bfx var2 = bfx.a();
      bfd var3 = var2.c();
      bfl.c(1.0F, 1.0F, 1.0F, 0.9F);
      bfl.c(519);
      bfl.a(false);
      bfl.l();
      bfl.a(770, 771, 1, 0);
      float var4 = 1.0F;

      for(int var5 = 0; var5 < 2; ++var5) {
         bfl.E();
         bmi var6 = this.c.T().a("minecraft:blocks/fire_layer_1");
         this.c.P().a(bmh.g);
         float var7 = var6.e();
         float var8 = var6.f();
         float var9 = var6.g();
         float var10 = var6.h();
         float var11 = (0.0F - var4) / 2.0F;
         float var12 = var11 + var4;
         float var13 = 0.0F - var4 / 2.0F;
         float var14 = var13 + var4;
         float var15 = -0.5F;
         bfl.b((float)(-(var5 * 2 - 1)) * 0.24F, -0.3F, 0.0F);
         bfl.b((float)(var5 * 2 - 1) * 10.0F, 0.0F, 1.0F, 0.0F);
         var3.a(7, bms.g);
         var3.b((double)var11, (double)var13, (double)var15).a((double)var8, (double)var10).d();
         var3.b((double)var12, (double)var13, (double)var15).a((double)var7, (double)var10).d();
         var3.b((double)var12, (double)var14, (double)var15).a((double)var7, (double)var9).d();
         var3.b((double)var11, (double)var14, (double)var15).a((double)var8, (double)var9).d();
         var2.b();
         bfl.F();
      }

      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      bfl.k();
      bfl.a(true);
      bfl.c(515);
   }

   public void a(float var1) {
      float var2 = 1.0F - (this.f + (this.e - this.f) * var1);
      bew var3 = this.c.h;
      float var4 = var3.l(var1);
      float var5 = var3.B + (var3.z - var3.B) * var1;
      float var6 = var3.A + (var3.y - var3.A) * var1;
      this.a(var5, var6);
      this.a((bet)var3);
      this.a((bew)var3, var1);
      bfl.B();
      bfl.E();
      if (this.d != null) {
         if (this.d.b() == zy.bd) {
            this.a(var3, var5, var2, var4);
         } else if (var3.bR() > 0) {
            aba var7 = this.d.m();
            switch(var7) {
            case a:
               this.b(var2, 0.0F);
               break;
            case b:
            case c:
               this.a((bet)var3, var1);
               this.b(var2, 0.0F);
               break;
            case d:
               this.b(var2, 0.0F);
               this.d();
               break;
            case e:
               this.b(var2, 0.0F);
               this.a(var1, (bet)var3);
            }
         } else {
            this.d(var4);
            this.b(var2, var4);
         }

         this.a(var3, this.d, bgr.b.c);
      } else if (!var3.ax()) {
         this.a(var3, var2, var4);
      }

      bfl.F();
      bfl.C();
      avc.a();
   }

   private void b(bet var1) {
      this.c.P().a(var1.i());
      biv var2 = this.g.a((pk)this.c.h);
      bln var3 = (bln)var2;
      if (!var1.ax()) {
         bfl.p();
         this.a(var3);
         this.b(var3);
         bfl.o();
      }

   }

   private void a(float var1, float var2) {
      bfl.E();
      bfl.b(var1, 1.0F, 0.0F, 0.0F);
      bfl.b(var2, 0.0F, 1.0F, 0.0F);
      avc.b();
      bfl.F();
   }

   private void e(float var1) {
      this.c.P().a(b);
      bfx var2 = bfx.a();
      bfd var3 = var2.c();
      float var4 = this.c.h.c(var1);
      bfl.c(var4, var4, var4, 0.5F);
      bfl.l();
      bfl.a(770, 771, 1, 0);
      bfl.E();
      float var5 = 4.0F;
      float var6 = -1.0F;
      float var7 = 1.0F;
      float var8 = -1.0F;
      float var9 = 1.0F;
      float var10 = -0.5F;
      float var11 = -this.c.h.y / 64.0F;
      float var12 = this.c.h.z / 64.0F;
      var3.a(7, bms.g);
      var3.b(-1.0D, -1.0D, -0.5D).a((double)(4.0F + var11), (double)(4.0F + var12)).d();
      var3.b(1.0D, -1.0D, -0.5D).a((double)(0.0F + var11), (double)(4.0F + var12)).d();
      var3.b(1.0D, 1.0D, -0.5D).a((double)(0.0F + var11), (double)(0.0F + var12)).d();
      var3.b(-1.0D, 1.0D, -0.5D).a((double)(4.0F + var11), (double)(0.0F + var12)).d();
      var2.b();
      bfl.F();
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      bfl.k();
   }
}
