import java.util.Iterator;
import java.util.Random;

public class afo extends afh {
   public static final amn a = amn.a("age", 0, 15);

   protected afo() {
      super(arm.A);
      this.j(this.M.b().a(a, 0));
      this.a(true);
      this.a(yz.c);
   }

   public adf m() {
      return adf.c;
   }

   public boolean d(adm var1, cj var2) {
      return super.d(var1, var2) ? this.e(var1, var2) : false;
   }

   public boolean e(adm var1, cj var2) {
      Iterator var3 = cq.c.a.iterator();

      while(var3.hasNext()) {
         cq var4 = (cq)var3.next();
         if (var1.p(var2.a(var4)).c().t().a()) {
            return false;
         }
      }

      afh var5 = var1.p(var2.b()).c();
      return var5 == afi.aK || var5 == afi.m;
   }

   public alz a(int var1) {
      return this.Q().a(a, var1);
   }

   public int c(alz var1) {
      return (Integer)var1.b(a);
   }

   public void a(adm var1, cj var2, alz var3, pk var4) {
      var4.a(ow.h, 1.0F);
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (!this.e(var1, var2)) {
         var1.b(var2, true);
      }

   }

   public boolean c() {
      return false;
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      cj var5 = var2.a();
      if (var1.d(var5)) {
         int var6;
         for(var6 = 1; var1.p(var2.c(var6)).c() == this; ++var6) {
         }

         if (var6 < 3) {
            int var7 = (Integer)var3.b(a);
            if (var7 == 15) {
               var1.a(var5, this.Q());
               alz var8 = var3.a(a, 0);
               var1.a((cj)var2, (alz)var8, 4);
               this.a(var1, var5, var8, (afh)this);
            } else {
               var1.a((cj)var2, (alz)var3.a(a, var7 + 1), 4);
            }

         }
      }
   }

   public aug b(adm var1, cj var2) {
      float var3 = 0.0625F;
      return new aug((double)((float)var2.n() + var3), (double)var2.o(), (double)((float)var2.p() + var3), (double)((float)(var2.n() + 1) - var3), (double)(var2.o() + 1), (double)((float)(var2.p() + 1) - var3));
   }

   public boolean d() {
      return false;
   }

   public aug a(adm var1, cj var2, alz var3) {
      float var4 = 0.0625F;
      return new aug((double)((float)var2.n() + var4), (double)var2.o(), (double)((float)var2.p() + var4), (double)((float)(var2.n() + 1) - var4), (double)((float)(var2.o() + 1) - var4), (double)((float)(var2.p() + 1) - var4));
   }
}
