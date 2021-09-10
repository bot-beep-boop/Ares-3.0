import java.util.Random;

public class aer extends ady {
   private static final app aD = new app(false);

   public aoh a(Random var1) {
      return (aoh)(var1.nextInt(5) > 0 ? aD : this.aA);
   }

   protected aer(int var1) {
      super(var1);
      this.au.add(new ady.c(tp.class, 1, 2, 6));
      this.as.A = 1;
      this.as.B = 4;
      this.as.C = 20;
   }

   protected ady d(int var1) {
      aer.a var2 = new aer.a(var1, this);
      var2.ap = (this.ap + 1.0F) * 0.5F;
      var2.an = this.an * 0.5F + 0.3F;
      var2.ao = this.ao * 0.5F + 1.2F;
      return var2;
   }

   public void a(adm var1, Random var2, cj var3) {
      ag.a(agi.b.c);

      for(int var4 = 0; var4 < 7; ++var4) {
         int var5 = var2.nextInt(16) + 8;
         int var6 = var2.nextInt(16) + 8;
         int var7 = var2.nextInt(var1.m(var3.a(var5, 0, var6)).o() + 32);
         ag.b(var1, var2, var3.a(var5, var7, var6));
      }

      super.a(var1, var2, var3);
   }

   public static class a extends aem {
      public a(int var1, ady var2) {
         super(var1, var2);
         this.as.A = 2;
         this.as.B = 2;
         this.as.C = 5;
      }

      public void a(adm var1, Random var2, ans var3, int var4, int var5, double var6) {
         this.ak = afi.c.Q();
         this.al = afi.d.Q();
         if (var6 > 1.75D) {
            this.ak = afi.b.Q();
            this.al = afi.b.Q();
         } else if (var6 > -0.5D) {
            this.ak = afi.d.Q().a(agf.a, agf.a.b);
         }

         this.b(var1, var2, var3, var4, var5, var6);
      }

      public void a(adm var1, Random var2, cj var3) {
         this.as.a(var1, var2, this, var3);
      }
   }
}
