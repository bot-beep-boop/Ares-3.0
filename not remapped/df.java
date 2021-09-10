import com.google.common.base.Objects;

public class df implements Comparable<df> {
   private final int d;
   private final int a;
   private final int c;
   public static final df b = new df(0, 0, 0);

   public df d(df var1) {
      return new df(this.o() * var1.p() - this.p() * var1.o(), this.p() * var1.n() - this.n() * var1.p(), this.n() * var1.o() - this.o() * var1.n());
   }

   public String toString() {
      return Objects.toStringHelper(this).add("x", this.n()).add("y", this.o()).add("z", this.p()).toString();
   }

   public df(double var1, double var3, double var5) {
      this(ns.c(var1), ns.c(var3), ns.c(var5));
   }

   public df(int var1, int var2, int var3) {
      this.a = var1;
      this.c = var2;
      this.d = var3;
   }

   public double i(df var1) {
      return this.c((double)var1.n(), (double)var1.o(), (double)var1.p());
   }

   public int n() {
      return this.a;
   }

   public int o() {
      return this.c;
   }

   public int g(df var1) {
      if (this.o() == var1.o()) {
         return this.p() == var1.p() ? this.n() - var1.n() : this.p() - var1.p();
      } else {
         return this.o() - var1.o();
      }
   }

   public int compareTo(Object var1) {
      return this.g((df)var1);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof df)) {
         return false;
      } else {
         df var2 = (df)var1;
         if (this.n() != var2.n()) {
            return false;
         } else if (this.o() != var2.o()) {
            return false;
         } else {
            return this.p() == var2.p();
         }
      }
   }

   public double c(double var1, double var3, double var5) {
      double var7 = (double)this.n() - var1;
      double var9 = (double)this.o() - var3;
      double var11 = (double)this.p() - var5;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public int hashCode() {
      return (this.o() + this.p() * 31) * 31 + this.n();
   }

   public int p() {
      return this.d;
   }

   public double d(double var1, double var3, double var5) {
      double var7 = (double)this.n() + 0.5D - var1;
      double var9 = (double)this.o() + 0.5D - var3;
      double var11 = (double)this.p() + 0.5D - var5;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }
}
