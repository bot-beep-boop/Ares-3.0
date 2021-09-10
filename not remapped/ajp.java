import java.util.Random;

public class ajp extends afh {
   public static final amn a = amn.a("layers", 1, 8);

   public int c(alz var1) {
      return (Integer)var1.b(a) - 1;
   }

   public alz a(int var1) {
      return this.Q().a(a, (var1 & 7) + 1);
   }

   private boolean e(adm var1, cj var2, alz var3) {
      if (!this.d(var1, var2)) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
         return false;
      } else {
         return true;
      }
   }

   public void a(adq var1, cj var2) {
      alz var3 = var1.p(var2);
      this.b((Integer)var3.b(a));
   }

   public aug a(adm var1, cj var2, alz var3) {
      int var4 = (Integer)var3.b(a) - 1;
      float var5 = 0.125F;
      return new aug((double)var2.n() + this.B, (double)var2.o() + this.C, (double)var2.p() + this.D, (double)var2.n() + this.E, (double)((float)var2.o() + (float)var4 * var5), (double)var2.p() + this.G);
   }

   public boolean c() {
      return false;
   }

   protected ajp() {
      super(arm.y);
      this.j(this.M.b().a(a, 1));
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
      this.a(true);
      this.a(yz.c);
      this.j();
   }

   public int a(Random var1) {
      return 0;
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      if (var1.b(ads.b, var2) > 11) {
         this.b(var1, var2, var1.p(var2), 0);
         var1.g(var2);
      }

   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      this.e(var1, var2, var3);
   }

   public zw a(alz var1, Random var2, int var3) {
      return zy.aD;
   }

   public boolean a(adq var1, cj var2, cq var3) {
      return var3 == cq.b ? true : super.a(var1, var2, var3);
   }

   public boolean b(adq var1, cj var2) {
      return (Integer)var1.p(var2).b(a) < 5;
   }

   protected void b(int var1) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, (float)var1 / 8.0F, 1.0F);
   }

   public boolean d() {
      return false;
   }

   public boolean a(adm var1, cj var2) {
      return (Integer)var1.p(var2).b(a) == 1;
   }

   public boolean d(adm var1, cj var2) {
      alz var3 = var1.p(var2.b());
      afh var4 = var3.c();
      if (var4 != afi.aI && var4 != afi.cB) {
         if (var4.t() == arm.j) {
            return true;
         } else if (var4 == this && (Integer)var3.b(a) >= 7) {
            return true;
         } else {
            return var4.c() && var4.J.c();
         }
      } else {
         return false;
      }
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public void a(adm var1, wn var2, cj var3, alz var4, akw var5) {
      a((adm)var1, var3, (zx)(new zx(zy.aD, (Integer)var4.b(a) + 1, 0)));
      var1.g(var3);
      var2.b(na.ab[afh.a((afh)this)]);
   }

   public void j() {
      this.b(0);
   }
}
