public class bnr implements Comparable<bnr> {
   private final String a;
   private final String c;
   private final boolean d;
   private final String b;

   public int compareTo(Object var1) {
      return this.a((bnr)var1);
   }

   public int hashCode() {
      return this.a.hashCode();
   }

   public boolean b() {
      return this.d;
   }

   public String toString() {
      return String.format("%s (%s)", this.c, this.b);
   }

   public int a(bnr var1) {
      return this.a.compareTo(var1.a);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else {
         return !(var1 instanceof bnr) ? false : this.a.equals(((bnr)var1).a);
      }
   }

   public bnr(String var1, String var2, String var3, boolean var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public String a() {
      return this.a;
   }
}
