import java.util.Random;

public class ahe extends afh implements afj {
   public static final amk a = amk.a("snowy");

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      if (!var1.D) {
         if (var1.l(var2.a()) < 4 && var1.p(var2.a()).c().p() > 2) {
            var1.a(var2, afi.d.Q());
         } else {
            if (var1.l(var2.a()) >= 9) {
               for(int var5 = 0; var5 < 4; ++var5) {
                  cj var6 = var2.a(var4.nextInt(3) - 1, var4.nextInt(5) - 3, var4.nextInt(3) - 1);
                  afh var7 = var1.p(var6.a()).c();
                  alz var8 = var1.p(var6);
                  if (var8.c() == afi.d && var8.b(agf.a) == agf.a.a && var1.l(var6.a()) >= 4 && var7.p() <= 2) {
                     var1.a(var6, afi.c.Q());
                  }
               }
            }

         }
      }
   }

   public int c(alz var1) {
      return 0;
   }

   public boolean a(adm var1, Random var2, cj var3, alz var4) {
      return true;
   }

   public boolean a(adm var1, cj var2, alz var3, boolean var4) {
      return true;
   }

   public void b(adm var1, Random var2, cj var3, alz var4) {
      cj var5 = var3.a();

      label53:
      for(int var6 = 0; var6 < 128; ++var6) {
         cj var7 = var5;

         for(int var8 = 0; var8 < var6 / 16; ++var8) {
            var7 = var7.a(var2.nextInt(3) - 1, (var2.nextInt(3) - 1) * var2.nextInt(3) / 2, var2.nextInt(3) - 1);
            if (var1.p(var7.b()).c() != afi.c || var1.p(var7).c().v()) {
               continue label53;
            }
         }

         if (var1.p(var7).c().J == arm.a) {
            if (var2.nextInt(8) == 0) {
               agw.a var11 = var1.b(var7).a(var2, var7);
               agw var9 = var11.a().a();
               alz var10 = var9.Q().a(var9.n(), var11);
               if (var9.f(var1, var7, var10)) {
                  var1.a((cj)var7, (alz)var10, 3);
               }
            } else {
               alz var12 = afi.H.Q().a(akc.a, akc.a.b);
               if (afi.H.f(var1, var7, var12)) {
                  var1.a((cj)var7, (alz)var12, 3);
               }
            }
         }
      }

   }

   public int H() {
      return adl.a(0.5D, 1.0D);
   }

   public int a(adq var1, cj var2, int var3) {
      return aea.a(var1, var2);
   }

   protected ahe() {
      super(arm.b);
      this.j(this.M.b().a(a, false));
      this.a(true);
      this.a(yz.b);
   }

   public alz a(alz var1, adq var2, cj var3) {
      afh var4 = var2.p(var3.a()).c();
      return var1.a(a, var4 == afi.aJ || var4 == afi.aH);
   }

   public int h(alz var1) {
      return this.H();
   }

   public adf m() {
      return adf.b;
   }

   public zw a(alz var1, Random var2, int var3) {
      return afi.d.a(afi.d.Q().a(agf.a, agf.a.a), var2, var3);
   }
}
