import com.google.common.base.Predicate;
import java.util.Collections;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class sn extends rd {
   private pr e;
   private static final Logger a = LogManager.getLogger();
   private final sp.a d;
   private ps b;
   private final Predicate<pr> c;
   private Class<? extends pr> f;

   public boolean a() {
      double var1 = this.f();
      List var3 = this.b.o.a(this.f, this.b.aR().b(var1, 4.0D, var1), this.c);
      Collections.sort(var3, this.d);
      if (var3.isEmpty()) {
         return false;
      } else {
         this.e = (pr)var3.get(0);
         return true;
      }
   }

   static ps a(sn var0) {
      return var0.b;
   }

   protected double f() {
      qc var1 = this.b.a((qb)vy.b);
      return var1 == null ? 16.0D : var1.e();
   }

   public boolean b() {
      pr var1 = this.b.u();
      if (var1 == null) {
         return false;
      } else if (!var1.ai()) {
         return false;
      } else {
         double var2 = this.f();
         if (this.b.h(var1) > var2 * var2) {
            return false;
         } else {
            return !(var1 instanceof lf) || !((lf)var1).c.d();
         }
      }
   }

   public void c() {
      this.b.d(this.e);
      super.c();
   }

   public sn(ps var1, Class<? extends pr> var2) {
      this.b = var1;
      this.f = var2;
      if (var1 instanceof py) {
         a.warn("Use NearestAttackableTargetGoal.class for PathfinerMob mobs!");
      }

      this.c = new Predicate<pr>(this) {
         final sn a;

         public boolean apply(Object var1) {
            return this.a((pr)var1);
         }

         {
            this.a = var1;
         }

         public boolean a(pr var1) {
            double var2 = this.a.f();
            if (var1.av()) {
               var2 *= 0.800000011920929D;
            }

            if (var1.ax()) {
               return false;
            } else {
               return (double)var1.g(sn.a(this.a)) > var2 ? false : st.a(sn.a(this.a), var1, false, true);
            }
         }
      };
      this.d = new sp.a(var1);
   }

   public void d() {
      this.b.d((pr)null);
      super.c();
   }
}
