import java.util.Random;

public class aej extends ady {
   private static final alz aE;
   private boolean aD;
   private static final alz aG;
   private static final alz aF;

   public void a(adm var1, Random var2, cj var3) {
      super.a(var1, var2, var3);
      int var4 = var2.nextInt(16) + 8;
      int var5 = var2.nextInt(16) + 8;
      int var6 = var2.nextInt(var1.m(var3.a(var4, 0, var5)).o() * 2);
      (new aph()).b(var1, var2, var3.a(var4, var6, var5));
      apw var9 = new apw();

      for(var5 = 0; var5 < 50; ++var5) {
         var6 = var2.nextInt(16) + 8;
         boolean var7 = true;
         int var8 = var2.nextInt(16) + 8;
         var9.b(var1, var2, var3.a(var6, 128, var8));
      }

   }

   public aoh a(Random var1) {
      if (var1.nextInt(10) == 0) {
         return this.aB;
      } else if (var1.nextInt(2) == 0) {
         return new aov(aE, aG);
      } else {
         return (aoh)(!this.aD && var1.nextInt(3) == 0 ? new ape(false, 10, 20, aE, aF) : new apv(false, 4 + var1.nextInt(7), aE, aF, true));
      }
   }

   static {
      aE = afi.r.Q().a(ail.b, aio.a.d);
      aF = afi.t.Q().a(aik.Q, aio.a.d).a(ahs.b, false);
      aG = afi.t.Q().a(aik.Q, aio.a.a).a(ahs.b, false);
   }

   public aej(int var1, boolean var2) {
      super(var1);
      this.aD = var2;
      if (var2) {
         this.as.A = 2;
      } else {
         this.as.A = 50;
      }

      this.as.C = 25;
      this.as.B = 4;
      if (!var2) {
         this.at.add(new ady.c(ts.class, 2, 1, 1));
      }

      this.au.add(new ady.c(tn.class, 10, 4, 4));
   }

   public aot b(Random var1) {
      return var1.nextInt(4) == 0 ? new apu(akc.a.c) : new apu(akc.a.b);
   }
}
