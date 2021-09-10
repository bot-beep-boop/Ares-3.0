import java.util.Random;

public class aeu extends ady {
   private int aI;
   private static final apk aD = new apk();
   private static final aok aH;
   private static final apf aF = new apf(false, false);
   private static final aps aE = new aps(false);
   private static final apf aG = new apf(false, true);

   public void a(adm var1, Random var2, ans var3, int var4, int var5, double var6) {
      if (this.aI == 1 || this.aI == 2) {
         this.ak = afi.c.Q();
         this.al = afi.d.Q();
         if (var6 > 1.75D) {
            this.ak = afi.d.Q().a(agf.a, agf.a.b);
         } else if (var6 > -0.95D) {
            this.ak = afi.d.Q().a(agf.a, agf.a.c);
         }
      }

      this.b(var1, var2, var3, var4, var5, var6);
   }

   protected ady d(int var1) {
      return this.az == ady.V.az ? (new aeu(var1, 2)).a(5858897, true).a("Mega Spruce Taiga").a(5159473).a(0.25F, 0.8F).a(new ady.a(this.an, this.ao)) : super.d(var1);
   }

   static {
      aH = new aok(afi.Y, 0);
   }

   public aeu(int var1, int var2) {
      super(var1);
      this.aI = var2;
      this.au.add(new ady.c(ua.class, 8, 4, 4));
      this.as.A = 10;
      if (var2 != 1 && var2 != 2) {
         this.as.C = 1;
         this.as.E = 1;
      } else {
         this.as.C = 7;
         this.as.D = 1;
         this.as.E = 3;
      }

   }

   public void a(adm var1, Random var2, cj var3) {
      int var4;
      int var5;
      int var6;
      int var7;
      if (this.aI == 1 || this.aI == 2) {
         var4 = var2.nextInt(3);

         for(var5 = 0; var5 < var4; ++var5) {
            var6 = var2.nextInt(16) + 8;
            var7 = var2.nextInt(16) + 8;
            cj var8 = var1.m(var3.a(var6, 0, var7));
            aH.b(var1, var2, var8);
         }
      }

      ag.a(agi.b.d);

      for(var4 = 0; var4 < 7; ++var4) {
         var5 = var2.nextInt(16) + 8;
         var6 = var2.nextInt(16) + 8;
         var7 = var2.nextInt(var1.m(var3.a(var5, 0, var6)).o() + 32);
         ag.b(var1, var2, var3.a(var5, var7, var6));
      }

      super.a(var1, var2, var3);
   }

   public aoh a(Random var1) {
      if ((this.aI == 1 || this.aI == 2) && var1.nextInt(3) == 0) {
         return this.aI != 2 && var1.nextInt(13) != 0 ? aF : aG;
      } else {
         return (aoh)(var1.nextInt(3) == 0 ? aD : aE);
      }
   }

   public aot b(Random var1) {
      return var1.nextInt(5) > 0 ? new apu(akc.a.c) : new apu(akc.a.b);
   }
}
