public class adv implements adq {
   protected int a;
   protected amy[][] c;
   protected boolean d;
   protected int b;
   protected adm e;

   public boolean W() {
      return this.d;
   }

   public boolean d(cj var1) {
      return this.p(var1).c().t() == arm.a;
   }

   private int a(ads var1, cj var2) {
      if (var1 == ads.a && this.e.t.o()) {
         return 0;
      } else if (var2.o() >= 0 && var2.o() < 256) {
         int var3;
         if (this.p(var2).c().s()) {
            var3 = 0;
            cq[] var9 = cq.values();
            int var5 = var9.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               cq var7 = var9[var6];
               int var8 = this.b(var1, var2.a(var7));
               if (var8 > var3) {
                  var3 = var8;
               }

               if (var3 >= 15) {
                  return var3;
               }
            }

            return var3;
         } else {
            var3 = (var2.n() >> 4) - this.a;
            int var4 = (var2.p() >> 4) - this.b;
            return this.c[var3][var4].a(var1, var2);
         }
      } else {
         return var1.c;
      }
   }

   public int b(ads var1, cj var2) {
      if (var2.o() >= 0 && var2.o() < 256) {
         int var3 = (var2.n() >> 4) - this.a;
         int var4 = (var2.p() >> 4) - this.b;
         return this.c[var3][var4].a(var1, var2);
      } else {
         return var1.c;
      }
   }

   public ady b(cj var1) {
      return this.e.b(var1);
   }

   public int a(cj var1, cq var2) {
      alz var3 = this.p(var1);
      return var3.c().b((adq)this, var1, var3, (cq)var2);
   }

   public alz p(cj var1) {
      if (var1.o() >= 0 && var1.o() < 256) {
         int var2 = (var1.n() >> 4) - this.a;
         int var3 = (var1.p() >> 4) - this.b;
         if (var2 >= 0 && var2 < this.c.length && var3 >= 0 && var3 < this.c[var2].length) {
            amy var4 = this.c[var2][var3];
            if (var4 != null) {
               return var4.g(var1);
            }
         }
      }

      return afi.a.Q();
   }

   public akw s(cj var1) {
      int var2 = (var1.n() >> 4) - this.a;
      int var3 = (var1.p() >> 4) - this.b;
      return this.c[var2][var3].a(var1, amy.a.a);
   }

   public adv(adm var1, cj var2, cj var3, int var4) {
      this.e = var1;
      this.a = var2.n() - var4 >> 4;
      this.b = var2.p() - var4 >> 4;
      int var5 = var3.n() + var4 >> 4;
      int var6 = var3.p() + var4 >> 4;
      this.c = new amy[var5 - this.a + 1][var6 - this.b + 1];
      this.d = true;

      int var7;
      int var8;
      for(var7 = this.a; var7 <= var5; ++var7) {
         for(var8 = this.b; var8 <= var6; ++var8) {
            this.c[var7 - this.a][var8 - this.b] = var1.a(var7, var8);
         }
      }

      for(var7 = var2.n() >> 4; var7 <= var3.n() >> 4; ++var7) {
         for(var8 = var2.p() >> 4; var8 <= var3.p() >> 4; ++var8) {
            amy var9 = this.c[var7 - this.a][var8 - this.b];
            if (var9 != null && !var9.c(var2.o(), var3.o())) {
               this.d = false;
            }
         }
      }

   }

   public adr G() {
      return this.e.G();
   }

   public int b(cj var1, int var2) {
      int var3 = this.a(ads.a, var1);
      int var4 = this.a(ads.b, var1);
      if (var4 < var2) {
         var4 = var2;
      }

      return var3 << 20 | var4 << 4;
   }
}
