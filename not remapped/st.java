import org.apache.commons.lang3.StringUtils;

public abstract class st extends rd {
   private boolean a;
   private int c;
   protected final py e;
   private int b;
   protected boolean f;
   private int d;

   public static boolean a(ps var0, pr var1, boolean var2, boolean var3) {
      if (var1 == null) {
         return false;
      } else if (var1 == var0) {
         return false;
      } else if (!var1.ai()) {
         return false;
      } else if (!var0.a(var1.getClass())) {
         return false;
      } else {
         auq var4 = var0.bO();
         auq var5 = var1.bO();
         if (var4 != null && var5 == var4) {
            return false;
         } else {
            if (var0 instanceof px && StringUtils.isNotEmpty(((px)var0).b())) {
               if (var1 instanceof px && ((px)var0).b().equals(((px)var1).b())) {
                  return false;
               }

               if (var1 == ((px)var0).m_()) {
                  return false;
               }
            } else if (var1 instanceof wn && !var2 && ((wn)var1).bA.a) {
               return false;
            }

            return !var3 || var0.t().a(var1);
         }
      }
   }

   public st(py var1, boolean var2) {
      this(var1, var2, false);
   }

   public boolean b() {
      pr var1 = this.e.u();
      if (var1 == null) {
         return false;
      } else if (!var1.ai()) {
         return false;
      } else {
         auq var2 = this.e.bO();
         auq var3 = var1.bO();
         if (var2 != null && var3 == var2) {
            return false;
         } else {
            double var4 = this.f();
            if (this.e.h(var1) > var4 * var4) {
               return false;
            } else {
               if (this.f) {
                  if (this.e.t().a(var1)) {
                     this.d = 0;
                  } else if (++this.d > 60) {
                     return false;
                  }
               }

               return !(var1 instanceof wn) || !((wn)var1).bA.a;
            }
         }
      }
   }

   public void d() {
      this.e.d((pr)null);
   }

   protected boolean a(pr var1, boolean var2) {
      if (!a(this.e, var1, var2, this.f)) {
         return false;
      } else if (!this.e.e(new cj(var1))) {
         return false;
      } else {
         if (this.a) {
            if (--this.c <= 0) {
               this.b = 0;
            }

            if (this.b == 0) {
               this.b = this.a(var1) ? 1 : 2;
            }

            if (this.b == 2) {
               return false;
            }
         }

         return true;
      }
   }

   protected double f() {
      qc var1 = this.e.a(vy.b);
      return var1 == null ? 16.0D : var1.e();
   }

   public void c() {
      this.b = 0;
      this.c = 0;
      this.d = 0;
   }

   private boolean a(pr var1) {
      this.c = 10 + this.e.bc().nextInt(5);
      asx var2 = this.e.s().a((pk)var1);
      if (var2 == null) {
         return false;
      } else {
         asv var3 = var2.c();
         if (var3 == null) {
            return false;
         } else {
            int var4 = var3.a - ns.c(var1.s);
            int var5 = var3.c - ns.c(var1.u);
            return (double)(var4 * var4 + var5 * var5) <= 2.25D;
         }
      }
   }

   public st(py var1, boolean var2, boolean var3) {
      this.e = var1;
      this.f = var2;
      this.a = var3;
   }
}
