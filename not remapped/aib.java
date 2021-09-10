import java.util.Random;

public class aib extends afh {
   public static final amk a = amk.a("snowy");

   public void b(adm var1, cj var2, alz var3, Random var4) {
      if (!var1.D) {
         if (var1.l(var2.a()) < 4 && var1.p(var2.a()).c().p() > 2) {
            var1.a(var2, afi.d.Q().a(agf.a, agf.a.a));
         } else {
            if (var1.l(var2.a()) >= 9) {
               for(int var5 = 0; var5 < 4; ++var5) {
                  cj var6 = var2.a(var4.nextInt(3) - 1, var4.nextInt(5) - 3, var4.nextInt(3) - 1);
                  alz var7 = var1.p(var6);
                  afh var8 = var1.p(var6.a()).c();
                  if (var7.c() == afi.d && var7.b(agf.a) == agf.a.a && var1.l(var6.a()) >= 4 && var8.p() <= 2) {
                     var1.a(var6, this.Q());
                  }
               }
            }

         }
      }
   }

   public int c(alz var1) {
      return 0;
   }

   public alz a(alz var1, adq var2, cj var3) {
      afh var4 = var2.p(var3.a()).c();
      return var1.a(a, var4 == afi.aJ || var4 == afi.aH);
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   protected aib() {
      super(arm.b, arn.z);
      this.j(this.M.b().a(a, false));
      this.a(true);
      this.a(yz.b);
   }

   public void c(adm var1, cj var2, alz var3, Random var4) {
      super.c(var1, var2, var3, var4);
      if (var4.nextInt(10) == 0) {
         var1.a(cy.w, (double)((float)var2.n() + var4.nextFloat()), (double)((float)var2.o() + 1.1F), (double)((float)var2.p() + var4.nextFloat()), 0.0D, 0.0D, 0.0D);
      }

   }

   public zw a(alz var1, Random var2, int var3) {
      return afi.d.a(afi.d.Q().a(agf.a, agf.a.a), var2, var3);
   }
}
