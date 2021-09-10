import java.util.Random;

public class aet extends ady {
   public int c(cj var1) {
      return 6975545;
   }

   public int b(cj var1) {
      double var2 = af.a((double)var1.n() * 0.0225D, (double)var1.p() * 0.0225D);
      return var2 < -0.1D ? 5011004 : 6975545;
   }

   public agw.a a(Random var1, cj var2) {
      return agw.a.c;
   }

   public void a(adm var1, Random var2, ans var3, int var4, int var5, double var6) {
      double var8 = af.a((double)var4 * 0.25D, (double)var5 * 0.25D);
      if (var8 > 0.0D) {
         int var10 = var4 & 15;
         int var11 = var5 & 15;

         for(int var12 = 255; var12 >= 0; --var12) {
            if (var3.a(var11, var12, var10).c().t() != arm.a) {
               if (var12 == 62 && var3.a(var11, var12, var10).c() != afi.j) {
                  var3.a(var11, var12, var10, afi.j.Q());
                  if (var8 < 0.12D) {
                     var3.a(var11, var12 + 1, var10, afi.bx.Q());
                  }
               }
               break;
            }
         }
      }

      this.b(var1, var2, var3, var4, var5, var6);
   }

   public aoh a(Random var1) {
      return this.aC;
   }

   protected aet(int var1) {
      super(var1);
      this.as.A = 2;
      this.as.B = 1;
      this.as.D = 1;
      this.as.E = 8;
      this.as.F = 10;
      this.as.J = 1;
      this.as.z = 4;
      this.as.I = 0;
      this.as.H = 0;
      this.as.C = 5;
      this.ar = 14745518;
      this.at.add(new ady.c(wb.class, 1, 1, 1));
   }
}
