import java.util.Random;

public class aeg extends ady {
   private int aG;
   protected static final apn aF = new apn(false);
   protected static final aoj aE = new aoj(false, false);
   protected static final aoj aD = new aoj(false, true);

   public int b(cj var1) {
      int var2 = super.b(var1);
      return this.aG == 3 ? (var2 & 16711422) + 2634762 >> 1 : var2;
   }

   public aeg(int var1, int var2) {
      super(var1);
      this.aG = var2;
      this.as.A = 10;
      this.as.C = 2;
      if (this.aG == 1) {
         this.as.A = 6;
         this.as.B = 100;
         this.as.C = 1;
      }

      this.a(5159473);
      this.a(0.7F, 0.8F);
      if (this.aG == 2) {
         this.aj = 353825;
         this.ai = 3175492;
         this.a(0.6F, 0.6F);
      }

      if (this.aG == 0) {
         this.au.add(new ady.c(ua.class, 5, 4, 4));
      }

      if (this.aG == 3) {
         this.as.A = -999;
      }

   }

   public aoh a(Random var1) {
      if (this.aG == 3 && var1.nextInt(3) > 0) {
         return aF;
      } else {
         return (aoh)(this.aG != 2 && var1.nextInt(5) != 0 ? this.aA : aE);
      }
   }

   protected ady d(int var1) {
      if (this.az == ady.t.az) {
         aeg var2 = new aeg(var1, 1);
         var2.a(new ady.a(this.an, this.ao + 0.2F));
         var2.a("Flower Forest");
         var2.a(6976549, true);
         var2.a(8233509);
         return var2;
      } else {
         return this.az != ady.Q.az && this.az != ady.R.az ? new aem(this, var1, this) {
            final aeg aD;

            {
               this.aD = var1;
            }

            public void a(adm var1, Random var2, cj var3) {
               this.aE.a(var1, var2, var3);
            }
         } : new aem(this, var1, this) {
            final aeg aD;

            {
               this.aD = var1;
            }

            public aoh a(Random var1) {
               return var1.nextBoolean() ? aeg.aD : aeg.aE;
            }
         };
      }
   }

   public void a(adm var1, Random var2, cj var3) {
      int var4;
      int var5;
      int var6;
      int var7;
      if (this.aG == 3) {
         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               var6 = var4 * 4 + 1 + 8 + var2.nextInt(3);
               var7 = var5 * 4 + 1 + 8 + var2.nextInt(3);
               cj var8 = var1.m(var3.a(var6, 0, var7));
               if (var2.nextInt(20) == 0) {
                  aoz var9 = new aoz();
                  var9.b(var1, var2, var8);
               } else {
                  aoh var12 = this.a(var2);
                  var12.e();
                  if (var12.b(var1, var2, var8)) {
                     var12.a(var1, var2, var8);
                  }
               }
            }
         }
      }

      var4 = var2.nextInt(5) - 3;
      if (this.aG == 1) {
         var4 += 2;
      }

      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var2.nextInt(3);
         if (var6 == 0) {
            ag.a(agi.b.b);
         } else if (var6 == 1) {
            ag.a(agi.b.e);
         } else if (var6 == 2) {
            ag.a(agi.b.f);
         }

         for(var7 = 0; var7 < 5; ++var7) {
            int var11 = var2.nextInt(16) + 8;
            int var13 = var2.nextInt(16) + 8;
            int var10 = var2.nextInt(var1.m(var3.a(var11, 0, var13)).o() + 32);
            if (ag.b(var1, var2, new cj(var3.n() + var11, var10, var3.p() + var13))) {
               break;
            }
         }
      }

      super.a(var1, var2, var3);
   }

   protected ady a(int var1, boolean var2) {
      if (this.aG == 2) {
         this.aj = 353825;
         this.ai = var1;
         if (var2) {
            this.aj = (this.aj & 16711422) >> 1;
         }

         return this;
      } else {
         return super.a(var1, var2);
      }
   }

   public agw.a a(Random var1, cj var2) {
      if (this.aG == 1) {
         double var3 = ns.a((1.0D + af.a((double)var2.n() / 48.0D, (double)var2.p() / 48.0D)) / 2.0D, 0.0D, 0.9999D);
         agw.a var5 = agw.a.values()[(int)(var3 * (double)agw.a.values().length)];
         return var5 == agw.a.c ? agw.a.b : var5;
      } else {
         return super.a(var1, var2);
      }
   }
}
