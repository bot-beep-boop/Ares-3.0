import java.util.Random;

public class agb extends afm {
   protected agb() {
      super(arm.l);
      float var1 = 0.4F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.8F, 0.5F + var1);
   }

   public zw a(alz var1, Random var2, int var3) {
      return null;
   }

   public arn g(alz var1) {
      return arn.o;
   }

   public boolean a(adm var1, cj var2) {
      return true;
   }

   public void a(adm var1, wn var2, cj var3, alz var4, akw var5) {
      if (!var1.D && var2.bZ() != null && var2.bZ().b() == zy.be) {
         var2.b(na.ab[afh.a((afh)this)]);
         a(var1, var3, new zx(afi.I, 1, 0));
      } else {
         super.a(var1, var2, var3, var4, var5);
      }

   }

   protected boolean c(afh var1) {
      return var1 == afi.m || var1 == afi.cz || var1 == afi.cu || var1 == afi.d;
   }
}
