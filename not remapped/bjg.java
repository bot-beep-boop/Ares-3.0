import org.lwjgl.opengl.GL11;

public class bjg extends biv<uo> {
   private bjh h;
   private final bov g = new bov("item_frame", "map");
   private static final jy a = new jy("textures/map/map_background.png");
   private final bov f = new bov("item_frame", "normal");
   private final ave e = ave.A();

   private void b(uo var1) {
      zx var2 = var1.o();
      if (var2 != null) {
         uz var3 = new uz(var1.o, 0.0D, 0.0D, 0.0D, var2);
         zw var4 = var3.l().b();
         var3.l().b = 1;
         var3.a = 0.0F;
         bfl.E();
         bfl.f();
         int var5 = var1.p();
         if (var4 == zy.bd) {
            var5 = var5 % 4 * 2;
         }

         bfl.b((float)var5 * 360.0F / 8.0F, 0.0F, 0.0F, 1.0F);
         if (var4 == zy.bd) {
            this.b.a.a(a);
            bfl.b(180.0F, 0.0F, 0.0F, 1.0F);
            float var6 = 0.0078125F;
            bfl.a(var6, var6, var6);
            bfl.b(-64.0F, -64.0F, 0.0F);
            atg var7 = zy.bd.a(var3.l(), var1.o);
            bfl.b(0.0F, 0.0F, -1.0F);
            if (var7 != null) {
               this.e.o.k().a(var7, true);
            }
         } else {
            bmi var12 = null;
            if (var4 == zy.aQ) {
               var12 = this.e.T().a(bmp.l);
               this.e.P().a(bmh.g);
               if (var12 instanceof bmp) {
                  bmp var13 = (bmp)var12;
                  double var8 = var13.j;
                  double var10 = var13.k;
                  var13.j = 0.0D;
                  var13.k = 0.0D;
                  var13.a(var1.o, var1.s, var1.u, (double)ns.g((float)(180 + var1.b.b() * 90)), false, true);
                  var13.j = var8;
                  var13.k = var10;
               } else {
                  var12 = null;
               }
            }

            bfl.a(0.5F, 0.5F, 0.5F);
            if (!this.h.a(var3.l()) || var4 instanceof aat) {
               bfl.b(180.0F, 0.0F, 1.0F, 0.0F);
            }

            bfl.a();
            avc.b();
            this.h.a(var3.l(), bgr.b.g);
            avc.a();
            bfl.b();
            if (var12 != null && var12.k() > 0) {
               var12.j();
            }
         }

         bfl.e();
         bfl.F();
      }
   }

   protected void a(uo var1, double var2, double var4, double var6) {
      if (ave.v() && var1.o() != null && var1.o().s() && this.b.d == var1) {
         float var8 = 1.6F;
         float var9 = 0.016666668F * var8;
         double var10 = var1.h(this.b.c);
         float var12 = var1.av() ? 32.0F : 64.0F;
         if (var10 < (double)(var12 * var12)) {
            String var13 = var1.o().q();
            if (var1.av()) {
               avn var14 = this.c();
               bfl.E();
               bfl.b((float)var2 + 0.0F, (float)var4 + var1.K + 0.5F, (float)var6);
               GL11.glNormal3f(0.0F, 1.0F, 0.0F);
               bfl.b(-this.b.e, 0.0F, 1.0F, 0.0F);
               bfl.b(this.b.f, 1.0F, 0.0F, 0.0F);
               bfl.a(-var9, -var9, var9);
               bfl.f();
               bfl.b(0.0F, 0.25F / var9, 0.0F);
               bfl.a(false);
               bfl.l();
               bfl.b(770, 771);
               bfx var15 = bfx.a();
               bfd var16 = var15.c();
               int var17 = var14.a(var13) / 2;
               bfl.x();
               var16.a(7, bms.f);
               var16.b((double)(-var17 - 1), -1.0D, 0.0D).a(0.0F, 0.0F, 0.0F, 0.25F).d();
               var16.b((double)(-var17 - 1), 8.0D, 0.0D).a(0.0F, 0.0F, 0.0F, 0.25F).d();
               var16.b((double)(var17 + 1), 8.0D, 0.0D).a(0.0F, 0.0F, 0.0F, 0.25F).d();
               var16.b((double)(var17 + 1), -1.0D, 0.0D).a(0.0F, 0.0F, 0.0F, 0.25F).d();
               var15.b();
               bfl.w();
               bfl.a(true);
               var14.a(var13, -var14.a(var13) / 2, 0, 553648127);
               bfl.e();
               bfl.k();
               bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
               bfl.F();
            } else {
               this.a(var1, var13, var2, var4, var6, 64);
            }
         }
      }

   }

   public void a(uo var1, double var2, double var4, double var6, float var8, float var9) {
      bfl.E();
      cj var10 = var1.n();
      double var11 = (double)var10.n() - var1.s + var2;
      double var13 = (double)var10.o() - var1.t + var4;
      double var15 = (double)var10.p() - var1.u + var6;
      bfl.b(var11 + 0.5D, var13 + 0.5D, var15 + 0.5D);
      bfl.b(180.0F - var1.y, 0.0F, 1.0F, 0.0F);
      this.b.a.a(bmh.g);
      bgd var17 = this.e.ae();
      bou var18 = var17.a().b();
      boq var19;
      if (var1.o() != null && var1.o().b() == zy.bd) {
         var19 = var18.a(this.g);
      } else {
         var19 = var18.a(this.f);
      }

      bfl.E();
      bfl.b(-0.5F, -0.5F, -0.5F);
      var17.b().a(var19, 1.0F, 1.0F, 1.0F, 1.0F);
      bfl.F();
      bfl.b(0.0F, 0.0F, 0.4375F);
      this.b(var1);
      bfl.F();
      this.a(var1, var2 + (double)((float)var1.b.g() * 0.3F), var4 - 0.25D, var6 + (double)((float)var1.b.i() * 0.3F));
   }

   protected jy a(pk var1) {
      return this.a((uo)var1);
   }

   public bjg(biu var1, bjh var2) {
      super(var1);
      this.h = var2;
   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((uo)var1, var2, var4, var6, var8, var9);
   }

   protected void a(pk var1, double var2, double var4, double var6) {
      this.a((uo)var1, var2, var4, var6);
   }

   protected jy a(uo var1) {
      return null;
   }
}
