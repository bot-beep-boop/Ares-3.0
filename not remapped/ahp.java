import java.util.Random;

public class ahp extends ahj {
   public adf m() {
      return adf.d;
   }

   public int a(Random var1) {
      return 0;
   }

   public ahp() {
      super(arm.w, false);
      this.L = 0.98F;
      this.a(true);
      this.a(yz.b);
   }

   public int k() {
      return 0;
   }

   public void a(adm var1, wn var2, cj var3, alz var4, akw var5) {
      var2.b(na.ab[afh.a((afh)this)]);
      var2.a(0.025F);
      if (this.I() && ack.e(var2)) {
         zx var8 = this.i(var4);
         if (var8 != null) {
            a(var1, var3, var8);
         }
      } else {
         if (var1.t.n()) {
            var1.g(var3);
            return;
         }

         int var6 = ack.f(var2);
         this.b(var1, var3, var4, var6);
         arm var7 = var1.p(var3.b()).c().t();
         if (var7.c() || var7.d()) {
            var1.a(var3, afi.i.Q());
         }
      }

   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      if (var1.b(ads.b, var2) > 11 - this.p()) {
         if (var1.t.n()) {
            var1.g(var2);
         } else {
            this.b(var1, var2, var1.p(var2), 0);
            var1.a(var2, afi.j.Q());
         }
      }
   }
}
