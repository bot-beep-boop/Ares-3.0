import java.util.Iterator;
import org.lwjgl.opengl.GL11;

public abstract class biv<T extends pk> {
   protected final biu b;
   private static final jy a = new jy("textures/misc/shadow.png");
   protected float d = 1.0F;
   protected float c;

   public static void a(aug var0, double var1, double var3, double var5) {
      bfl.x();
      bfx var7 = bfx.a();
      bfd var8 = var7.c();
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      var8.c(var1, var3, var5);
      var8.a(7, bms.h);
      var8.b(var0.a, var0.e, var0.c).c(0.0F, 0.0F, -1.0F).d();
      var8.b(var0.d, var0.e, var0.c).c(0.0F, 0.0F, -1.0F).d();
      var8.b(var0.d, var0.b, var0.c).c(0.0F, 0.0F, -1.0F).d();
      var8.b(var0.a, var0.b, var0.c).c(0.0F, 0.0F, -1.0F).d();
      var8.b(var0.a, var0.b, var0.f).c(0.0F, 0.0F, 1.0F).d();
      var8.b(var0.d, var0.b, var0.f).c(0.0F, 0.0F, 1.0F).d();
      var8.b(var0.d, var0.e, var0.f).c(0.0F, 0.0F, 1.0F).d();
      var8.b(var0.a, var0.e, var0.f).c(0.0F, 0.0F, 1.0F).d();
      var8.b(var0.a, var0.b, var0.c).c(0.0F, -1.0F, 0.0F).d();
      var8.b(var0.d, var0.b, var0.c).c(0.0F, -1.0F, 0.0F).d();
      var8.b(var0.d, var0.b, var0.f).c(0.0F, -1.0F, 0.0F).d();
      var8.b(var0.a, var0.b, var0.f).c(0.0F, -1.0F, 0.0F).d();
      var8.b(var0.a, var0.e, var0.f).c(0.0F, 1.0F, 0.0F).d();
      var8.b(var0.d, var0.e, var0.f).c(0.0F, 1.0F, 0.0F).d();
      var8.b(var0.d, var0.e, var0.c).c(0.0F, 1.0F, 0.0F).d();
      var8.b(var0.a, var0.e, var0.c).c(0.0F, 1.0F, 0.0F).d();
      var8.b(var0.a, var0.b, var0.f).c(-1.0F, 0.0F, 0.0F).d();
      var8.b(var0.a, var0.e, var0.f).c(-1.0F, 0.0F, 0.0F).d();
      var8.b(var0.a, var0.e, var0.c).c(-1.0F, 0.0F, 0.0F).d();
      var8.b(var0.a, var0.b, var0.c).c(-1.0F, 0.0F, 0.0F).d();
      var8.b(var0.d, var0.b, var0.c).c(1.0F, 0.0F, 0.0F).d();
      var8.b(var0.d, var0.e, var0.c).c(1.0F, 0.0F, 0.0F).d();
      var8.b(var0.d, var0.e, var0.f).c(1.0F, 0.0F, 0.0F).d();
      var8.b(var0.d, var0.b, var0.f).c(1.0F, 0.0F, 0.0F).d();
      var7.b();
      var8.c(0.0D, 0.0D, 0.0D);
      bfl.w();
   }

   private void a(afh var1, double var2, double var4, double var6, cj var8, float var9, float var10, double var11, double var13, double var15) {
      if (var1.d()) {
         bfx var17 = bfx.a();
         bfd var18 = var17.c();
         double var19 = ((double)var9 - (var4 - ((double)var8.o() + var13)) / 2.0D) * 0.5D * (double)this.a().o(var8);
         if (!(var19 < 0.0D)) {
            if (var19 > 1.0D) {
               var19 = 1.0D;
            }

            double var21 = (double)var8.n() + var1.B() + var11;
            double var23 = (double)var8.n() + var1.C() + var11;
            double var25 = (double)var8.o() + var1.D() + var13 + 0.015625D;
            double var27 = (double)var8.p() + var1.F() + var15;
            double var29 = (double)var8.p() + var1.G() + var15;
            float var31 = (float)((var2 - var21) / 2.0D / (double)var10 + 0.5D);
            float var32 = (float)((var2 - var23) / 2.0D / (double)var10 + 0.5D);
            float var33 = (float)((var6 - var27) / 2.0D / (double)var10 + 0.5D);
            float var34 = (float)((var6 - var29) / 2.0D / (double)var10 + 0.5D);
            var18.b(var21, var25, var27).a((double)var31, (double)var33).a(1.0F, 1.0F, 1.0F, (float)var19).d();
            var18.b(var21, var25, var29).a((double)var31, (double)var34).a(1.0F, 1.0F, 1.0F, (float)var19).d();
            var18.b(var23, var25, var29).a((double)var32, (double)var34).a(1.0F, 1.0F, 1.0F, (float)var19).d();
            var18.b(var23, var25, var27).a((double)var32, (double)var33).a(1.0F, 1.0F, 1.0F, (float)var19).d();
         }
      }
   }

   private void a(pk var1, double var2, double var4, double var6, float var8) {
      bfl.f();
      bmh var9 = ave.A().T();
      bmi var10 = var9.a("minecraft:blocks/fire_layer_0");
      bmi var11 = var9.a("minecraft:blocks/fire_layer_1");
      bfl.E();
      bfl.b((float)var2, (float)var4, (float)var6);
      float var12 = var1.J * 1.4F;
      bfl.a(var12, var12, var12);
      bfx var13 = bfx.a();
      bfd var14 = var13.c();
      float var15 = 0.5F;
      float var16 = 0.0F;
      float var17 = var1.K / var12;
      float var18 = (float)(var1.t - var1.aR().b);
      bfl.b(-this.b.e, 0.0F, 1.0F, 0.0F);
      bfl.b(0.0F, 0.0F, -0.3F + (float)((int)var17) * 0.02F);
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      float var19 = 0.0F;
      int var20 = 0;
      var14.a(7, bms.g);

      while(var17 > 0.0F) {
         bmi var21 = var20 % 2 == 0 ? var10 : var11;
         this.a(bmh.g);
         float var22 = var21.e();
         float var23 = var21.g();
         float var24 = var21.f();
         float var25 = var21.h();
         if (var20 / 2 % 2 == 0) {
            float var26 = var24;
            var24 = var22;
            var22 = var26;
         }

         var14.b((double)(var15 - var16), (double)(0.0F - var18), (double)var19).a((double)var24, (double)var25).d();
         var14.b((double)(-var15 - var16), (double)(0.0F - var18), (double)var19).a((double)var22, (double)var25).d();
         var14.b((double)(-var15 - var16), (double)(1.4F - var18), (double)var19).a((double)var22, (double)var23).d();
         var14.b((double)(var15 - var16), (double)(1.4F - var18), (double)var19).a((double)var24, (double)var23).d();
         var17 -= 0.45F;
         var18 -= 0.45F;
         var15 *= 0.9F;
         var19 += 0.03F;
         ++var20;
      }

      var13.b();
      bfl.F();
      bfl.e();
   }

   protected biv(biu var1) {
      this.b = var1;
   }

   public boolean a(T var1, bia var2, double var3, double var5, double var7) {
      aug var9 = var1.aR();
      if (var9.b() || var9.a() == 0.0D) {
         var9 = new aug(var1.s - 2.0D, var1.t - 2.0D, var1.u - 2.0D, var1.s + 2.0D, var1.t + 2.0D, var1.u + 2.0D);
      }

      return var1.h(var3, var5, var7) && (var1.ah || var2.a(var9));
   }

   protected abstract jy a(T var1);

   public avn c() {
      return this.b.c();
   }

   public void a(T var1, double var2, double var4, double var6, float var8, float var9) {
      this.a(var1, var2, var4, var6);
   }

   public void b(pk var1, double var2, double var4, double var6, float var8, float var9) {
      if (this.b.g != null) {
         if (this.b.g.W && this.c > 0.0F && !var1.ax() && this.b.a()) {
            double var10 = this.b.b(var1.s, var1.t, var1.u);
            float var12 = (float)((1.0D - var10 / 256.0D) * (double)this.d);
            if (var12 > 0.0F) {
               this.c(var1, var2, var4, var6, var12, var9);
            }
         }

         if (var1.aJ() && (!(var1 instanceof wn) || !((wn)var1).v())) {
            this.a(var1, var2, var4, var6, var9);
         }

      }
   }

   protected void a(T var1, double var2, double var4, double var6) {
      if (this.b(var1)) {
         this.a(var1, var1.f_().d(), var2, var4, var6, 64);
      }
   }

   private adm a() {
      return this.b.b;
   }

   public void a(jy var1) {
      this.b.a.a(var1);
   }

   public biu d() {
      return this.b;
   }

   protected boolean c(T var1) {
      jy var2 = this.a(var1);
      if (var2 == null) {
         return false;
      } else {
         this.a(var2);
         return true;
      }
   }

   protected void a(T var1, String var2, double var3, double var5, double var7, int var9) {
      double var10 = var1.h(this.b.c);
      if (!(var10 > (double)(var9 * var9))) {
         avn var12 = this.c();
         float var13 = 1.6F;
         float var14 = 0.016666668F * var13;
         bfl.E();
         bfl.b((float)var3 + 0.0F, (float)var5 + var1.K + 0.5F, (float)var7);
         GL11.glNormal3f(0.0F, 1.0F, 0.0F);
         bfl.b(-this.b.e, 0.0F, 1.0F, 0.0F);
         bfl.b(this.b.f, 1.0F, 0.0F, 0.0F);
         bfl.a(-var14, -var14, var14);
         bfl.f();
         bfl.a(false);
         bfl.i();
         bfl.l();
         bfl.a(770, 771, 1, 0);
         bfx var15 = bfx.a();
         bfd var16 = var15.c();
         byte var17 = 0;
         if (var2.equals("deadmau5")) {
            var17 = -10;
         }

         int var18 = var12.a(var2) / 2;
         bfl.x();
         var16.a(7, bms.f);
         var16.b((double)(-var18 - 1), (double)(-1 + var17), 0.0D).a(0.0F, 0.0F, 0.0F, 0.25F).d();
         var16.b((double)(-var18 - 1), (double)(8 + var17), 0.0D).a(0.0F, 0.0F, 0.0F, 0.25F).d();
         var16.b((double)(var18 + 1), (double)(8 + var17), 0.0D).a(0.0F, 0.0F, 0.0F, 0.25F).d();
         var16.b((double)(var18 + 1), (double)(-1 + var17), 0.0D).a(0.0F, 0.0F, 0.0F, 0.25F).d();
         var15.b();
         bfl.w();
         var12.a(var2, -var12.a(var2) / 2, var17, 553648127);
         bfl.j();
         bfl.a(true);
         var12.a(var2, -var12.a(var2) / 2, var17, -1);
         bfl.e();
         bfl.k();
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         bfl.F();
      }
   }

   private void c(pk var1, double var2, double var4, double var6, float var8, float var9) {
      bfl.l();
      bfl.b(770, 771);
      this.b.a.a(a);
      adm var10 = this.a();
      bfl.a(false);
      float var11 = this.c;
      if (var1 instanceof ps) {
         ps var12 = (ps)var1;
         var11 *= var12.bT();
         if (var12.j_()) {
            var11 *= 0.5F;
         }
      }

      double var35 = var1.P + (var1.s - var1.P) * (double)var9;
      double var14 = var1.Q + (var1.t - var1.Q) * (double)var9;
      double var16 = var1.R + (var1.u - var1.R) * (double)var9;
      int var18 = ns.c(var35 - (double)var11);
      int var19 = ns.c(var35 + (double)var11);
      int var20 = ns.c(var14 - (double)var11);
      int var21 = ns.c(var14);
      int var22 = ns.c(var16 - (double)var11);
      int var23 = ns.c(var16 + (double)var11);
      double var24 = var2 - var35;
      double var26 = var4 - var14;
      double var28 = var6 - var16;
      bfx var30 = bfx.a();
      bfd var31 = var30.c();
      var31.a(7, bms.i);
      Iterator var32 = cj.b(new cj(var18, var20, var22), new cj(var19, var21, var23)).iterator();

      while(var32.hasNext()) {
         cj var33 = (cj)var32.next();
         afh var34 = var10.p(var33.b()).c();
         if (var34.b() != -1 && var10.l(var33) > 3) {
            this.a(var34, var2, var4, var6, var33, var8, var11, var24, var26, var28);
         }
      }

      var30.b();
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      bfl.k();
      bfl.a(true);
   }

   protected boolean b(T var1) {
      return var1.aO() && var1.l_();
   }

   protected void a(T var1, double var2, double var4, double var6, String var8, float var9, double var10) {
      this.a(var1, var8, var2, var4, var6, 64);
   }
}
