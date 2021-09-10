import java.util.Random;

public class afp extends afh {
   public static final amn a = amn.a("bites", 0, 6);

   public int c(alz var1) {
      return (Integer)var1.b(a);
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      this.b(var1, var2, var3, var4);
      return true;
   }

   public int l(adm var1, cj var2) {
      return (7 - (Integer)var1.p(var2).b(a)) * 2;
   }

   protected afp() {
      super(arm.F);
      this.j(this.M.b().a(a, 0));
      this.a(true);
   }

   public aug a(adm var1, cj var2, alz var3) {
      float var4 = 0.0625F;
      float var5 = (float)(1 + (Integer)var3.b(a) * 2) / 16.0F;
      float var6 = 0.5F;
      return new aug((double)((float)var2.n() + var5), (double)var2.o(), (double)((float)var2.p() + var4), (double)((float)(var2.n() + 1) - var4), (double)((float)var2.o() + var6), (double)((float)(var2.p() + 1) - var4));
   }

   public boolean d(adm var1, cj var2) {
      return super.d(var1, var2) ? this.e(var1, var2) : false;
   }

   public zw c(adm var1, cj var2) {
      return zy.aZ;
   }

   public boolean c() {
      return false;
   }

   public boolean O() {
      return true;
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public void j() {
      float var1 = 0.0625F;
      float var2 = 0.5F;
      this.a(var1, 0.0F, var1, 1.0F - var1, var2, 1.0F - var1);
   }

   public alz a(int var1) {
      return this.Q().a(a, var1);
   }

   private void b(adm var1, cj var2, alz var3, wn var4) {
      if (var4.j(false)) {
         var4.b(na.H);
         var4.cl().a(2, 0.1F);
         int var5 = (Integer)var3.b(a);
         if (var5 < 6) {
            var1.a((cj)var2, (alz)var3.a(a, var5 + 1), 3);
         } else {
            var1.g(var2);
         }

      }
   }

   public boolean d() {
      return false;
   }

   public zw a(alz var1, Random var2, int var3) {
      return null;
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (!this.e(var1, var2)) {
         var1.g(var2);
      }

   }

   public aug b(adm var1, cj var2) {
      return this.a(var1, var2, var1.p(var2));
   }

   public void a(adm var1, cj var2, wn var3) {
      this.b(var1, var2, var1.p(var2), var3);
   }

   private boolean e(adm var1, cj var2) {
      return var1.p(var2.b()).c().t().a();
   }

   public adf m() {
      return adf.c;
   }

   public int a(Random var1) {
      return 0;
   }

   public void a(adq var1, cj var2) {
      float var3 = 0.0625F;
      float var4 = (float)(1 + (Integer)var1.p(var2).b(a) * 2) / 16.0F;
      float var5 = 0.5F;
      this.a(var4, 0.0F, var3, 1.0F - var3, var5, 1.0F - var3);
   }
}
