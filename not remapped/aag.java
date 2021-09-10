import com.google.common.collect.Sets;
import java.util.Set;

public class aag extends za {
   private static final Set<afh> c;

   public float a(zx var1, afh var2) {
      return var2.t() != arm.f && var2.t() != arm.g && var2.t() != arm.e ? super.a(var1, var2) : this.a;
   }

   public boolean b(afh var1) {
      if (var1 == afi.Z) {
         return this.b.d() == 3;
      } else if (var1 != afi.ah && var1 != afi.ag) {
         if (var1 != afi.bP && var1 != afi.bT) {
            if (var1 != afi.R && var1 != afi.o) {
               if (var1 != afi.S && var1 != afi.p) {
                  if (var1 != afi.y && var1 != afi.x) {
                     if (var1 != afi.aC && var1 != afi.aD) {
                        if (var1.t() == arm.e) {
                           return true;
                        } else if (var1.t() == arm.f) {
                           return true;
                        } else {
                           return var1.t() == arm.g;
                        }
                     } else {
                        return this.b.d() >= 2;
                     }
                  } else {
                     return this.b.d() >= 1;
                  }
               } else {
                  return this.b.d() >= 1;
               }
            } else {
               return this.b.d() >= 2;
            }
         } else {
            return this.b.d() >= 2;
         }
      } else {
         return this.b.d() >= 2;
      }
   }

   static {
      c = Sets.newHashSet(new afh[]{afi.cs, afi.q, afi.e, afi.E, afi.ah, afi.ag, afi.T, afi.D, afi.R, afi.o, afi.aI, afi.S, afi.p, afi.y, afi.x, afi.aD, afi.Y, afi.aV, afi.cB, afi.av, afi.aC, afi.A, afi.cM, afi.b, afi.U});
   }

   protected aag(zw.a var1) {
      super(2.0F, var1, c);
   }
}
