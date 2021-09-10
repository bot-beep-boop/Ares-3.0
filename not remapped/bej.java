import java.util.Random;

public class bej extends beb {
   private static final Random a = new Random();
   private int az = 128;

   public void t_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      if (this.f++ >= this.g) {
         this.J();
      }

      this.k(this.az + (7 - this.f * 8 / this.g));
      this.w += 0.004D;
      this.d(this.v, this.w, this.x);
      if (this.t == this.q) {
         this.v *= 1.1D;
         this.x *= 1.1D;
      }

      this.v *= 0.9599999785423279D;
      this.w *= 0.9599999785423279D;
      this.x *= 0.9599999785423279D;
      if (this.C) {
         this.v *= 0.699999988079071D;
         this.x *= 0.699999988079071D;
      }

   }

   protected bej(adm var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      super(var1, var2, var4, var6, 0.5D - a.nextDouble(), var10, 0.5D - a.nextDouble());
      this.w *= 0.20000000298023224D;
      if (var8 == 0.0D && var12 == 0.0D) {
         this.v *= 0.10000000149011612D;
         this.x *= 0.10000000149011612D;
      }

      this.h *= 0.75F;
      this.g = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
      this.T = false;
   }

   public void a(bfd var1, pk var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = ((float)this.f + var3) / (float)this.g * 32.0F;
      var9 = ns.a(var9, 0.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public void a(int var1) {
      this.az = var1;
   }

   public static class e implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         bej var16 = new bej(var2, var3, var5, var7, var9, var11, var13);
         ((bej)var16).a(144);
         float var17 = var2.s.nextFloat() * 0.5F + 0.35F;
         var16.b(1.0F * var17, 0.0F * var17, 1.0F * var17);
         return var16;
      }
   }

   public static class d implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new bej(var2, var3, var5, var7, var9, var11, var13);
      }
   }

   public static class a implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         bej var16 = new bej(var2, var3, var5, var7, var9, var11, var13);
         var16.i(0.15F);
         var16.b((float)var9, (float)var11, (float)var13);
         return var16;
      }
   }

   public static class c implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         bej var16 = new bej(var2, var3, var5, var7, var9, var11, var13);
         var16.b((float)var9, (float)var11, (float)var13);
         return var16;
      }
   }

   public static class b implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         bej var16 = new bej(var2, var3, var5, var7, var9, var11, var13);
         ((bej)var16).a(144);
         return var16;
      }
   }
}
