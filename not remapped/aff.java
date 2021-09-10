public class aff extends afc {
   public aff() {
      super(arm.s, arn.G);
      this.c(3.0F);
      this.a(yz.f);
   }

   public boolean d() {
      return false;
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if (var1.D) {
         return true;
      } else {
         akw var9 = var1.s(var2);
         if (var9 instanceof akv) {
            var4.a((og)((akv)var9));
            var4.b(na.N);
         }

         return true;
      }
   }

   public boolean c() {
      return false;
   }

   public adf m() {
      return adf.c;
   }

   public static void f(adm var0, cj var1) {
      nj.a.submit(new Runnable(var0, var1) {
         final adm a;
         final cj b;

         public void run() {
            amy var1 = this.a.f(this.b);

            for(int var2 = this.b.o() - 1; var2 >= 0; --var2) {
               cj var3 = new cj(this.b.n(), var2, this.b.p());
               if (!var1.d(var3)) {
                  break;
               }

               alz var4 = this.a.p(var3);
               if (var4.c() == afi.bY) {
                  ((le)this.a).a(new Runnable(this, var3) {
                     final cj a;
                     final <undefinedtype> b;

                     {
                        this.b = var1;
                        this.a = var2;
                     }

                     public void run() {
                        akw var1 = this.b.a.s(this.a);
                        if (var1 instanceof akv) {
                           ((akv)var1).m();
                           this.b.a.c(this.a, afi.bY, 1, 0);
                        }

                     }
                  });
               }
            }

         }

         {
            this.a = var1;
            this.b = var2;
         }
      });
   }

   public akw a(adm var1, int var2) {
      return new akv();
   }

   public int b() {
      return 3;
   }

   public void a(adm var1, cj var2, alz var3, pr var4, zx var5) {
      super.a(var1, var2, var3, var4, var5);
      if (var5.s()) {
         akw var6 = var1.s(var2);
         if (var6 instanceof akv) {
            ((akv)var6).a(var5.q());
         }
      }

   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      akw var5 = var1.s(var2);
      if (var5 instanceof akv) {
         ((akv)var5).m();
         var1.c(var2, this, 1, 0);
      }

   }
}
