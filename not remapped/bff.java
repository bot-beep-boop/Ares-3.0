import java.util.Arrays;

public class bff extends adv {
   private int[] h;
   private static final alz f;
   private alz[] i;
   private final cj g;

   public bff(adm var1, cj var2, cj var3, int var4) {
      super(var1, var2, var3, var4);
      this.g = var2.b(new df(var4, var4, var4));
      boolean var5 = true;
      this.h = new int[8000];
      Arrays.fill(this.h, -1);
      this.i = new alz[8000];
   }

   public int b(cj var1, int var2) {
      int var3 = this.e(var1);
      int var4 = this.h[var3];
      if (var4 == -1) {
         var4 = super.b(var1, var2);
         this.h[var3] = var4;
      }

      return var4;
   }

   public alz p(cj var1) {
      int var2 = this.e(var1);
      alz var3 = this.i[var2];
      if (var3 == null) {
         var3 = this.c(var1);
         this.i[var2] = var3;
      }

      return var3;
   }

   public akw s(cj var1) {
      int var2 = (var1.n() >> 4) - this.a;
      int var3 = (var1.p() >> 4) - this.b;
      return this.c[var2][var3].a(var1, amy.a.b);
   }

   private alz c(cj var1) {
      if (var1.o() >= 0 && var1.o() < 256) {
         int var2 = (var1.n() >> 4) - this.a;
         int var3 = (var1.p() >> 4) - this.b;
         return this.c[var2][var3].g(var1);
      } else {
         return f;
      }
   }

   private int e(cj var1) {
      int var2 = var1.n() - this.g.n();
      int var3 = var1.o() - this.g.o();
      int var4 = var1.p() - this.g.p();
      return var2 * 400 + var4 * 20 + var3;
   }

   static {
      f = afi.a.Q();
   }
}
