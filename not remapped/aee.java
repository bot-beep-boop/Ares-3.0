import java.util.Random;

public class aee extends ady {
   private int aI;
   private int aH;
   private int aG;
   private aot aD;
   private aps aE;
   private int aF;

   protected ady d(int var1) {
      return (new aee(var1, false)).b(this);
   }

   public void a(adm var1, Random var2, cj var3) {
      super.a(var1, var2, var3);
      int var4 = 3 + var2.nextInt(6);

      int var5;
      int var6;
      int var7;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var2.nextInt(16);
         var7 = var2.nextInt(28) + 4;
         int var8 = var2.nextInt(16);
         cj var9 = var3.a(var6, var7, var8);
         if (var1.p(var9).c() == afi.b) {
            var1.a((cj)var9, (alz)afi.bP.Q(), 2);
         }
      }

      for(var4 = 0; var4 < 7; ++var4) {
         var5 = var2.nextInt(16);
         var6 = var2.nextInt(64);
         var7 = var2.nextInt(16);
         this.aD.b(var1, var2, var3.a(var5, var6, var7));
      }

   }

   public void a(adm var1, Random var2, ans var3, int var4, int var5, double var6) {
      this.ak = afi.c.Q();
      this.al = afi.d.Q();
      if ((var6 < -1.0D || var6 > 2.0D) && this.aI == this.aH) {
         this.ak = afi.n.Q();
         this.al = afi.n.Q();
      } else if (var6 > 1.0D && this.aI != this.aG) {
         this.ak = afi.b.Q();
         this.al = afi.b.Q();
      }

      this.b(var1, var2, var3, var4, var5, var6);
   }

   public aoh a(Random var1) {
      return (aoh)(var1.nextInt(3) > 0 ? this.aE : super.a(var1));
   }

   protected aee(int var1, boolean var2) {
      super(var1);
      this.aD = new apj(afi.be.Q().a(ahz.a, ahz.a.a), 9);
      this.aE = new aps(false);
      this.aF = 0;
      this.aG = 1;
      this.aH = 2;
      this.aI = this.aF;
      if (var2) {
         this.as.A = 3;
         this.aI = this.aG;
      }

   }

   private aee b(ady var1) {
      this.aI = this.aH;
      this.a(var1.ai, true);
      this.a(var1.ah + " M");
      this.a(new ady.a(var1.an, var1.ao));
      this.a(var1.ap, var1.aq);
      return this;
   }
}
