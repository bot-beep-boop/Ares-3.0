import java.util.Random;

public class bjf extends biv<uz> {
   private Random e = new Random();
   private final bjh a;

   public bjf(biu var1, bjh var2) {
      super(var1);
      this.a = var2;
      this.c = 0.15F;
      this.d = 0.75F;
   }

   private int a(zx var1) {
      byte var2 = 1;
      if (var1.b > 48) {
         var2 = 5;
      } else if (var1.b > 32) {
         var2 = 4;
      } else if (var1.b > 16) {
         var2 = 3;
      } else if (var1.b > 1) {
         var2 = 2;
      }

      return var2;
   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((uz)var1, var2, var4, var6, var8, var9);
   }

   protected jy a(uz var1) {
      return bmh.g;
   }

   protected jy a(pk var1) {
      return this.a((uz)var1);
   }

   private int a(uz var1, double var2, double var4, double var6, float var8, boq var9) {
      zx var10 = var1.l();
      zw var11 = var10.b();
      if (var11 == null) {
         return 0;
      } else {
         boolean var12 = var9.c();
         int var13 = this.a(var10);
         float var14 = 0.25F;
         float var15 = ns.a(((float)var1.o() + var8) / 10.0F + var1.a) * 0.1F + 0.1F;
         float var16 = var9.f().b(bgr.b.f).d.y;
         bfl.b((float)var2, (float)var4 + var15 + 0.25F * var16, (float)var6);
         float var17;
         if (var12 || this.b.g != null) {
            var17 = (((float)var1.o() + var8) / 20.0F + var1.a) * 57.295776F;
            bfl.b(var17, 0.0F, 1.0F, 0.0F);
         }

         if (!var12) {
            var17 = -0.0F * (float)(var13 - 1) * 0.5F;
            float var18 = -0.0F * (float)(var13 - 1) * 0.5F;
            float var19 = -0.046875F * (float)(var13 - 1) * 0.5F;
            bfl.b(var17, var18, var19);
         }

         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         return var13;
      }
   }

   public void a(uz var1, double var2, double var4, double var6, float var8, float var9) {
      zx var10 = var1.l();
      this.e.setSeed(187L);
      boolean var11 = false;
      if (this.c(var1)) {
         this.b.a.b(this.a(var1)).b(false, false);
         var11 = true;
      }

      bfl.B();
      bfl.a(516, 0.1F);
      bfl.l();
      bfl.a(770, 771, 1, 0);
      bfl.E();
      boq var12 = this.a.a().a(var10);
      int var13 = this.a(var1, var2, var4, var6, var9, var12);

      for(int var14 = 0; var14 < var13; ++var14) {
         float var15;
         float var16;
         float var17;
         if (var12.c()) {
            bfl.E();
            if (var14 > 0) {
               var15 = (this.e.nextFloat() * 2.0F - 1.0F) * 0.15F;
               var16 = (this.e.nextFloat() * 2.0F - 1.0F) * 0.15F;
               var17 = (this.e.nextFloat() * 2.0F - 1.0F) * 0.15F;
               bfl.b(var15, var16, var17);
            }

            bfl.a(0.5F, 0.5F, 0.5F);
            var12.f().a(bgr.b.f);
            this.a.a(var10, var12);
            bfl.F();
         } else {
            bfl.E();
            var12.f().a(bgr.b.f);
            this.a.a(var10, var12);
            bfl.F();
            var15 = var12.f().o.d.x;
            var16 = var12.f().o.d.y;
            var17 = var12.f().o.d.z;
            bfl.b(0.0F * var15, 0.0F * var16, 0.046875F * var17);
         }
      }

      bfl.F();
      bfl.C();
      bfl.k();
      this.c(var1);
      if (var11) {
         this.b.a.b(this.a(var1)).a();
      }

      super.a(var1, var2, var4, var6, var8, var9);
   }
}
