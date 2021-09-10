import java.util.Random;

public class ajf extends agd {
   public static final amn b = amn.a("delay", 1, 4);
   public static final amk a = amk.a("locked");

   protected alz k(alz var1) {
      Integer var2 = (Integer)var1.b(b);
      Boolean var3 = (Boolean)var1.b(a);
      cq var4 = (cq)var1.b(O);
      return afi.bb.Q().a(O, var4).a(b, var2).a(a, var3);
   }

   protected ama e() {
      return new ama(this, new amo[]{O, b, a});
   }

   public void c(adm var1, cj var2, alz var3, Random var4) {
      if (this.N) {
         cq var5 = (cq)var3.b(O);
         double var6 = (double)((float)var2.n() + 0.5F) + (double)(var4.nextFloat() - 0.5F) * 0.2D;
         double var8 = (double)((float)var2.o() + 0.4F) + (double)(var4.nextFloat() - 0.5F) * 0.2D;
         double var10 = (double)((float)var2.p() + 0.5F) + (double)(var4.nextFloat() - 0.5F) * 0.2D;
         float var12 = -5.0F;
         if (var4.nextBoolean()) {
            var12 = (float)((Integer)var3.b(b) * 2 - 1);
         }

         var12 /= 16.0F;
         double var13 = (double)(var12 * (float)var5.g());
         double var15 = (double)(var12 * (float)var5.i());
         var1.a(cy.E, var6 + var13, var8, var10 + var15, 0.0D, 0.0D, 0.0D);
      }
   }

   public void b(adm var1, cj var2, alz var3) {
      super.b(var1, var2, var3);
      this.h(var1, var2, var3);
   }

   public alz a(int var1) {
      return this.Q().a(O, cq.b(var1)).a(a, false).a(b, 1 + (var1 >> 2));
   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((cq)var1.b(O)).b();
      var3 |= (Integer)var1.b(b) - 1 << 2;
      return var3;
   }

   protected ajf(boolean var1) {
      super(var1);
      this.j(this.M.b().a(O, cq.c).a(b, 1).a(a, false));
   }

   public alz a(alz var1, adq var2, cj var3) {
      return var1.a(a, this.b(var2, var3, var1));
   }

   public zw a(alz var1, Random var2, int var3) {
      return zy.bb;
   }

   public boolean b(adq var1, cj var2, alz var3) {
      return this.c(var1, var2, var3) > 0;
   }

   public String f() {
      return di.a("item.diode.name");
   }

   protected int d(alz var1) {
      return (Integer)var1.b(b) * 2;
   }

   protected alz e(alz var1) {
      Integer var2 = (Integer)var1.b(b);
      Boolean var3 = (Boolean)var1.b(a);
      cq var4 = (cq)var1.b(O);
      return afi.bc.Q().a(O, var4).a(b, var2).a(a, var3);
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if (!var4.bA.e) {
         return false;
      } else {
         var1.a((cj)var2, (alz)var3.a(b), 3);
         return true;
      }
   }

   public zw c(adm var1, cj var2) {
      return zy.bb;
   }

   protected boolean c(afh var1) {
      return d(var1);
   }
}
