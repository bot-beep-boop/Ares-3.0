import java.util.Random;

public class bis extends bjo<vo> {
   private static final jy a = new jy("textures/entity/enderman/enderman.png");
   private bbd e;
   private Random j = new Random();

   public void a(ps var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((vo)var1, var2, var4, var6, var8, var9);
   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((vo)var1, var2, var4, var6, var8, var9);
   }

   public bis(biu var1) {
      super(var1, new bbd(0.0F), 0.5F);
      this.e = (bbd)super.f;
      this.a((blb)(new bkw(this)));
      this.a((blb)(new bkq(this)));
   }

   protected jy a(pk var1) {
      return this.a((vo)var1);
   }

   public void a(vo var1, double var2, double var4, double var6, float var8, float var9) {
      this.e.a = var1.cm().c().t() != arm.a;
      this.e.b = var1.co();
      if (var1.co()) {
         double var10 = 0.02D;
         var2 += this.j.nextGaussian() * var10;
         var6 += this.j.nextGaussian() * var10;
      }

      super.a((ps)var1, var2, var4, var6, var8, var9);
   }

   public void a(pr var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((vo)var1, var2, var4, var6, var8, var9);
   }

   protected jy a(vo var1) {
      return a;
   }
}
