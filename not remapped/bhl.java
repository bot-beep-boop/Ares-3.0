import java.nio.FloatBuffer;
import java.util.Random;

public class bhl extends bhd<alp> {
   FloatBuffer c = avd.h(16);
   private static final jy d = new jy("textures/environment/end_sky.png");
   private static final Random f = new Random(31100L);
   private static final jy e = new jy("textures/entity/end_portal.png");

   public void a(akw var1, double var2, double var4, double var6, float var8, int var9) {
      this.a((alp)var1, var2, var4, var6, var8, var9);
   }

   private FloatBuffer a(float var1, float var2, float var3, float var4) {
      this.c.clear();
      this.c.put(var1).put(var2).put(var3).put(var4);
      this.c.flip();
      return this.c;
   }

   public void a(alp var1, double var2, double var4, double var6, float var8, int var9) {
      float var10 = (float)this.b.j;
      float var11 = (float)this.b.k;
      float var12 = (float)this.b.l;
      bfl.f();
      f.setSeed(31100L);
      float var13 = 0.75F;

      for(int var14 = 0; var14 < 16; ++var14) {
         bfl.E();
         float var15 = (float)(16 - var14);
         float var16 = 0.0625F;
         float var17 = 1.0F / (var15 + 1.0F);
         if (var14 == 0) {
            this.a(d);
            var17 = 0.1F;
            var15 = 65.0F;
            var16 = 0.125F;
            bfl.l();
            bfl.b(770, 771);
         }

         if (var14 >= 1) {
            this.a(e);
         }

         if (var14 == 1) {
            bfl.l();
            bfl.b(1, 1);
            var16 = 0.5F;
         }

         float var18 = (float)(-(var4 + (double)var13));
         float var19 = var18 + (float)auz.a().b;
         float var20 = var18 + var15 + (float)auz.a().b;
         float var21 = var19 / var20;
         var21 += (float)(var4 + (double)var13);
         bfl.b(var10, var21, var12);
         bfl.a(bfl.o.a, 9217);
         bfl.a(bfl.o.b, 9217);
         bfl.a(bfl.o.c, 9217);
         bfl.a(bfl.o.d, 9216);
         bfl.a(bfl.o.a, 9473, this.a(1.0F, 0.0F, 0.0F, 0.0F));
         bfl.a(bfl.o.b, 9473, this.a(0.0F, 0.0F, 1.0F, 0.0F));
         bfl.a(bfl.o.c, 9473, this.a(0.0F, 0.0F, 0.0F, 1.0F));
         bfl.a(bfl.o.d, 9474, this.a(0.0F, 1.0F, 0.0F, 0.0F));
         bfl.a(bfl.o.a);
         bfl.a(bfl.o.b);
         bfl.a(bfl.o.c);
         bfl.a(bfl.o.d);
         bfl.F();
         bfl.n(5890);
         bfl.E();
         bfl.D();
         bfl.b(0.0F, (float)(ave.J() % 700000L) / 700000.0F, 0.0F);
         bfl.a(var16, var16, var16);
         bfl.b(0.5F, 0.5F, 0.0F);
         bfl.b((float)(var14 * var14 * 4321 + var14 * 9) * 2.0F, 0.0F, 0.0F, 1.0F);
         bfl.b(-0.5F, -0.5F, 0.0F);
         bfl.b(-var10, -var12, -var11);
         var19 = var18 + (float)auz.a().b;
         bfl.b((float)auz.a().a * var15 / var19, (float)auz.a().c * var15 / var19, -var11);
         bfx var25 = bfx.a();
         bfd var26 = var25.c();
         var26.a(7, bms.f);
         float var22 = (f.nextFloat() * 0.5F + 0.1F) * var17;
         float var23 = (f.nextFloat() * 0.5F + 0.4F) * var17;
         float var24 = (f.nextFloat() * 0.5F + 0.5F) * var17;
         if (var14 == 0) {
            var22 = var23 = var24 = 1.0F * var17;
         }

         var26.b(var2, var4 + (double)var13, var6).a(var22, var23, var24, 1.0F).d();
         var26.b(var2, var4 + (double)var13, var6 + 1.0D).a(var22, var23, var24, 1.0F).d();
         var26.b(var2 + 1.0D, var4 + (double)var13, var6 + 1.0D).a(var22, var23, var24, 1.0F).d();
         var26.b(var2 + 1.0D, var4 + (double)var13, var6).a(var22, var23, var24, 1.0F).d();
         var25.b();
         bfl.F();
         bfl.n(5888);
         this.a(d);
      }

      bfl.k();
      bfl.b(bfl.o.a);
      bfl.b(bfl.o.b);
      bfl.b(bfl.o.c);
      bfl.b(bfl.o.d);
      bfl.e();
   }
}
