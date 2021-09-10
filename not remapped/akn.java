import java.util.List;

public class akn extends afm {
   public void a(adm var1, cj var2, alz var3, aug var4, List<aug> var5, pk var6) {
      if (var6 == null || !(var6 instanceof ux)) {
         super.a(var1, var2, var3, var4, var5, var6);
      }

   }

   public int h(alz var1) {
      return 7455580;
   }

   protected akn() {
      float var1 = 0.5F;
      float var2 = 0.015625F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var2, 0.5F + var1);
      this.a(yz.c);
   }

   public boolean f(adm var1, cj var2, alz var3) {
      if (var2.o() >= 0 && var2.o() < 256) {
         alz var4 = var1.p(var2.b());
         return var4.c().t() == arm.h && (Integer)var4.b(ahv.b) == 0;
      } else {
         return false;
      }
   }

   protected boolean c(afh var1) {
      return var1 == afi.j;
   }

   public int a(adq var1, cj var2, int var3) {
      return 2129968;
   }

   public int H() {
      return 7455580;
   }

   public aug a(adm var1, cj var2, alz var3) {
      return new aug((double)var2.n() + this.B, (double)var2.o() + this.C, (double)var2.p() + this.D, (double)var2.n() + this.E, (double)var2.o() + this.F, (double)var2.p() + this.G);
   }

   public int c(alz var1) {
      return 0;
   }
}
