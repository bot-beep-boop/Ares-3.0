import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class qv extends rd {
   private tm d;
   private tm e;
   int b;
   adm a;
   double c;

   public boolean b() {
      return this.e.ai() && this.e.cr() && this.b < 60;
   }

   public void d() {
      this.e = null;
      this.b = 0;
   }

   public qv(tm var1, double var2) {
      this.d = var1;
      this.a = var1.o;
      this.c = var2;
      this.a(3);
   }

   private void g() {
      ph var1 = this.d.a((ph)this.e);
      if (var1 != null) {
         wn var2 = this.d.cq();
         if (var2 == null && this.e.cq() != null) {
            var2 = this.e.cq();
         }

         if (var2 != null) {
            var2.b(na.A);
            if (this.d instanceof to) {
               var2.b((mw)mr.H);
            }
         }

         this.d.b(6000);
         this.e.b(6000);
         this.d.cs();
         this.e.cs();
         var1.b(-24000);
         var1.b(this.d.s, this.d.t, this.d.u, 0.0F, 0.0F);
         this.a.d((pk)var1);
         Random var3 = this.d.bc();

         for(int var4 = 0; var4 < 7; ++var4) {
            double var5 = var3.nextGaussian() * 0.02D;
            double var7 = var3.nextGaussian() * 0.02D;
            double var9 = var3.nextGaussian() * 0.02D;
            double var11 = var3.nextDouble() * (double)this.d.J * 2.0D - (double)this.d.J;
            double var13 = 0.5D + var3.nextDouble() * (double)this.d.K;
            double var15 = var3.nextDouble() * (double)this.d.J * 2.0D - (double)this.d.J;
            this.a.a(cy.I, this.d.s + var11, this.d.t + var13, this.d.u + var15, var5, var7, var9);
         }

         if (this.a.Q().b("doMobLoot")) {
            this.a.d((pk)(new pp(this.a, this.d.s, this.d.t, this.d.u, var3.nextInt(7) + 1)));
         }

      }
   }

   private tm f() {
      float var1 = 8.0F;
      List var2 = this.a.a(this.d.getClass(), this.d.aR().b((double)var1, (double)var1, (double)var1));
      double var3 = Double.MAX_VALUE;
      tm var5 = null;
      Iterator var6 = var2.iterator();

      while(var6.hasNext()) {
         tm var7 = (tm)var6.next();
         if (this.d.a(var7) && this.d.h(var7) < var3) {
            var5 = var7;
            var3 = this.d.h(var7);
         }
      }

      return var5;
   }

   public void e() {
      this.d.p().a(this.e, 10.0F, (float)this.d.bQ());
      this.d.s().a((pk)this.e, this.c);
      ++this.b;
      if (this.b >= 60 && this.d.h(this.e) < 9.0D) {
         this.g();
      }

   }

   public boolean a() {
      if (!this.d.cr()) {
         return false;
      } else {
         this.e = this.f();
         return this.e != null;
      }
   }
}
