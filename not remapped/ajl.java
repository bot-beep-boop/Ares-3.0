import java.util.Random;

public class ajl extends afc {
   protected ajl() {
      super(arm.d);
      float var1 = 0.25F;
      float var2 = 1.0F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, var2, 0.5F + var1);
   }

   public boolean b(adq var1, cj var2) {
      return true;
   }

   public boolean c() {
      return false;
   }

   public aug b(adm var1, cj var2) {
      this.a(var1, var2);
      return super.b(var1, var2);
   }

   public boolean g() {
      return true;
   }

   public boolean d(adm var1, cj var2) {
      return !this.e(var1, var2) && super.d(var1, var2);
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if (var1.D) {
         return true;
      } else {
         akw var9 = var1.s(var2);
         return var9 instanceof aln ? ((aln)var9).b(var4) : false;
      }
   }

   public boolean d() {
      return false;
   }

   public zw a(alz var1, Random var2, int var3) {
      return zy.ap;
   }

   public zw c(adm var1, cj var2) {
      return zy.ap;
   }

   public akw a(adm var1, int var2) {
      return new aln();
   }

   public aug a(adm var1, cj var2, alz var3) {
      return null;
   }
}
