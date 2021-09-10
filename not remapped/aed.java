import java.util.Random;

public class aed extends ady {
   public aed(int var1) {
      super(var1);
      this.au.clear();
      this.ak = afi.m.Q();
      this.al = afi.m.Q();
      this.as.A = -999;
      this.as.D = 2;
      this.as.F = 50;
      this.as.G = 10;
      this.au.clear();
   }

   public void a(adm var1, Random var2, cj var3) {
      super.a(var1, var2, var3);
      if (var2.nextInt(1000) == 0) {
         int var4 = var2.nextInt(16) + 8;
         int var5 = var2.nextInt(16) + 8;
         cj var6 = var1.m(var3.a(var4, 0, var5)).a();
         (new aor()).b(var1, var2, var6);
      }

   }
}
