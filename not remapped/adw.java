public class adw implements Comparable<adw> {
   private static long d;
   private long f;
   public int c;
   private final afh e;
   public long b;
   public final cj a;

   public int a(adw var1) {
      if (this.b < var1.b) {
         return -1;
      } else if (this.b > var1.b) {
         return 1;
      } else if (this.c != var1.c) {
         return this.c - var1.c;
      } else if (this.f < var1.f) {
         return -1;
      } else {
         return this.f > var1.f ? 1 : 0;
      }
   }

   public int compareTo(Object var1) {
      return this.a((adw)var1);
   }

   public adw a(long var1) {
      this.b = var1;
      return this;
   }

   public boolean equals(Object var1) {
      if (!(var1 instanceof adw)) {
         return false;
      } else {
         adw var2 = (adw)var1;
         return this.a.equals(var2.a) && afh.a(this.e, var2.e);
      }
   }

   public String toString() {
      return afh.a(this.e) + ": " + this.a + ", " + this.b + ", " + this.c + ", " + this.f;
   }

   public adw(cj var1, afh var2) {
      this.f = (long)(d++);
      this.a = var1;
      this.e = var2;
   }

   public int hashCode() {
      return this.a.hashCode();
   }

   public afh a() {
      return this.e;
   }

   public void a(int var1) {
      this.c = var1;
   }
}
