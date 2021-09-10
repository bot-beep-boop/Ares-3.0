import com.google.common.base.Predicate;
import java.util.Collections;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class so extends rd {
   private final sp.a d;
   private static final Logger a = LogManager.getLogger();
   private final Predicate<pk> c;
   private ps b;
   private pr e;

   public boolean a() {
      double var1 = this.f();
      List var3 = this.b.o.a(wn.class, this.b.aR().b(var1, 4.0D, var1), this.c);
      Collections.sort(var3, this.d);
      if (var3.isEmpty()) {
         return false;
      } else {
         this.e = (pr)var3.get(0);
         return true;
      }
   }

   public void d() {
      this.b.d((pr)null);
      super.c();
   }

   public so(ps var1) {
      this.b = var1;
      if (var1 instanceof py) {
         a.warn("Use NearestAttackableTargetGoal.class for PathfinerMob mobs!");
      }

      this.c = new Predicate<pk>(this) {
         final so a;

         {
            this.a = var1;
         }

         public boolean a(pk var1) {
            if (!(var1 instanceof wn)) {
               return false;
            } else if (((wn)var1).bA.a) {
               return false;
            } else {
               double var2 = this.a.f();
               if (var1.av()) {
                  var2 *= 0.800000011920929D;
               }

               if (var1.ax()) {
                  float var4 = ((wn)var1).bY();
                  if (var4 < 0.1F) {
                     var4 = 0.1F;
                  }

                  var2 *= (double)(0.7F * var4);
               }

               return (double)var1.g((pk)so.a(this.a)) > var2 ? false : st.a(so.a(this.a), (pr)var1, false, true);
            }
         }

         public boolean apply(Object var1) {
            return this.a((pk)var1);
         }
      };
      this.d = new sp.a(var1);
   }

   static ps a(so var0) {
      return var0.b;
   }

   public void c() {
      this.b.d(this.e);
      super.c();
   }

   public boolean b() {
      pr var1 = this.b.u();
      if (var1 == null) {
         return false;
      } else if (!var1.ai()) {
         return false;
      } else if (var1 instanceof wn && ((wn)var1).bA.a) {
         return false;
      } else {
         auq var2 = this.b.bO();
         auq var3 = var1.bO();
         if (var2 != null && var3 == var2) {
            return false;
         } else {
            double var4 = this.f();
            if (this.b.h(var1) > var4 * var4) {
               return false;
            } else {
               return !(var1 instanceof lf) || !((lf)var1).c.d();
            }
         }
      }
   }

   protected double f() {
      qc var1 = this.b.a((qb)vy.b);
      return var1 == null ? 16.0D : var1.e();
   }
}
