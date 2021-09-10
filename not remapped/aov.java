import java.util.Random;

public class aov extends apv {
   private final alz a;
   private final alz b;

   public boolean b(adm var1, Random var2, cj var3) {
      afh var4;
      while(((var4 = var1.p(var3).c()).t() == arm.a || var4.t() == arm.j) && var3.o() > 0) {
         var3 = var3.b();
      }

      afh var5 = var1.p(var3).c();
      if (var5 == afi.d || var5 == afi.c) {
         var3 = var3.a();
         this.a(var1, var3, this.b);

         for(int var6 = var3.o(); var6 <= var3.o() + 2; ++var6) {
            int var7 = var6 - var3.o();
            int var8 = 2 - var7;

            for(int var9 = var3.n() - var8; var9 <= var3.n() + var8; ++var9) {
               int var10 = var9 - var3.n();

               for(int var11 = var3.p() - var8; var11 <= var3.p() + var8; ++var11) {
                  int var12 = var11 - var3.p();
                  if (Math.abs(var10) != var8 || Math.abs(var12) != var8 || var2.nextInt(2) != 0) {
                     cj var13 = new cj(var9, var6, var11);
                     if (!var1.p(var13).c().o()) {
                        this.a(var1, var13, this.a);
                     }
                  }
               }
            }
         }
      }

      return true;
   }

   public aov(alz var1, alz var2) {
      super(false);
      this.b = var1;
      this.a = var2;
   }
}
