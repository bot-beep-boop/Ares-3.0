import java.util.List;
import java.util.Random;

public class afl extends afc {
   public static final amk[] a = new amk[]{amk.a("has_bottle_0"), amk.a("has_bottle_1"), amk.a("has_bottle_2")};

   public boolean c() {
      return false;
   }

   public afl() {
      super(arm.f);
      this.j(this.M.b().a(a[0], false).a(a[1], false).a(a[2], false));
   }

   public String f() {
      return di.a("item.brewingStand.name");
   }

   public adf m() {
      return adf.c;
   }

   public int c(alz var1) {
      int var2 = 0;

      for(int var3 = 0; var3 < 3; ++var3) {
         if ((Boolean)var1.b(a[var3])) {
            var2 |= 1 << var3;
         }
      }

      return var2;
   }

   public akw a(adm var1, int var2) {
      return new akx();
   }

   public void a(adm var1, cj var2, alz var3, aug var4, List<aug> var5, pk var6) {
      this.a(0.4375F, 0.0F, 0.4375F, 0.5625F, 0.875F, 0.5625F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.j();
      super.a(var1, var2, var3, var4, var5, var6);
   }

   public int b() {
      return 3;
   }

   public void j() {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if (var1.D) {
         return true;
      } else {
         akw var9 = var1.s(var2);
         if (var9 instanceof akx) {
            var4.a((og)((akx)var9));
            var4.b(na.M);
         }

         return true;
      }
   }

   public zw c(adm var1, cj var2) {
      return zy.bF;
   }

   public zw a(alz var1, Random var2, int var3) {
      return zy.bF;
   }

   public void c(adm var1, cj var2, alz var3, Random var4) {
      double var5 = (double)((float)var2.n() + 0.4F + var4.nextFloat() * 0.2F);
      double var7 = (double)((float)var2.o() + 0.7F + var4.nextFloat() * 0.3F);
      double var9 = (double)((float)var2.p() + 0.4F + var4.nextFloat() * 0.2F);
      var1.a(cy.l, var5, var7, var9, 0.0D, 0.0D, 0.0D);
   }

   protected ama e() {
      return new ama(this, new amo[]{a[0], a[1], a[2]});
   }

   public boolean d() {
      return false;
   }

   public void a(adm var1, cj var2, alz var3, pr var4, zx var5) {
      if (var5.s()) {
         akw var6 = var1.s(var2);
         if (var6 instanceof akx) {
            ((akx)var6).a(var5.q());
         }
      }

   }

   public int l(adm var1, cj var2) {
      return xi.a(var1.s(var2));
   }

   public boolean O() {
      return true;
   }

   public alz a(int var1) {
      alz var2 = this.Q();

      for(int var3 = 0; var3 < 3; ++var3) {
         var2 = var2.a(a[var3], (var1 & 1 << var3) > 0);
      }

      return var2;
   }

   public void b(adm var1, cj var2, alz var3) {
      akw var4 = var1.s(var2);
      if (var4 instanceof akx) {
         oi.a(var1, (cj)var2, (akx)var4);
      }

      super.b(var1, var2, var3);
   }
}
