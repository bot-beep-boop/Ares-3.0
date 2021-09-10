import java.util.Iterator;
import java.util.List;

public class rw extends rd {
   private double c;
   private pr b;
   private wi a;
   private int d;

   public boolean b() {
      return this.d > 0;
   }

   public boolean a() {
      if (this.a.l() >= 0) {
         return false;
      } else if (this.a.bc().nextInt(400) != 0) {
         return false;
      } else {
         List var1 = this.a.o.a(wi.class, this.a.aR().b(6.0D, 3.0D, 6.0D));
         double var2 = Double.MAX_VALUE;
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            wi var5 = (wi)var4.next();
            if (var5 != this.a && !var5.cn() && var5.l() < 0) {
               double var6 = var5.h(this.a);
               if (!(var6 > var2)) {
                  var2 = var6;
                  this.b = var5;
               }
            }
         }

         if (this.b == null) {
            aui var8 = tc.a(this.a, 16, 3);
            if (var8 == null) {
               return false;
            }
         }

         return true;
      }
   }

   public rw(wi var1, double var2) {
      this.a = var1;
      this.c = var2;
      this.a(1);
   }

   public void e() {
      --this.d;
      if (this.b != null) {
         if (this.a.h(this.b) > 4.0D) {
            this.a.s().a((pk)this.b, this.c);
         }
      } else if (this.a.s().m()) {
         aui var1 = tc.a(this.a, 16, 3);
         if (var1 == null) {
            return;
         }

         this.a.s().a(var1.a, var1.b, var1.c, this.c);
      }

   }

   public void c() {
      if (this.b != null) {
         this.a.m(true);
      }

      this.d = 1000;
   }

   public void d() {
      this.a.m(false);
      this.b = null;
   }
}
