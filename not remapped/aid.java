import java.util.Random;

public class aid extends afm {
   public static final amn a = amn.a("age", 0, 3);

   public int a(Random var1) {
      return 0;
   }

   public zw a(alz var1, Random var2, int var3) {
      return null;
   }

   public zw c(adm var1, cj var2) {
      return zy.by;
   }

   protected boolean c(afh var1) {
      return var1 == afi.aW;
   }

   public boolean f(adm var1, cj var2, alz var3) {
      return this.c(var1.p(var2.b()).c());
   }

   protected aid() {
      super(arm.k, arn.D);
      this.j(this.M.b().a(a, 0));
      this.a(true);
      float var1 = 0.5F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
      this.a((yz)null);
   }

   public alz a(int var1) {
      return this.Q().a(a, var1);
   }

   public int c(alz var1) {
      return (Integer)var1.b(a);
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public void a(adm var1, cj var2, alz var3, float var4, int var5) {
      if (!var1.D) {
         int var6 = 1;
         if ((Integer)var3.b(a) >= 3) {
            var6 = 2 + var1.s.nextInt(3);
            if (var5 > 0) {
               var6 += var1.s.nextInt(var5 + 1);
            }
         }

         for(int var7 = 0; var7 < var6; ++var7) {
            a(var1, var2, new zx(zy.by));
         }

      }
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      int var5 = (Integer)var3.b(a);
      if (var5 < 3 && var4.nextInt(10) == 0) {
         var3 = var3.a(a, var5 + 1);
         var1.a((cj)var2, (alz)var3, 2);
      }

      super.b(var1, var2, var3, var4);
   }
}
