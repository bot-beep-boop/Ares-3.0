public class ade {
   private int d;
   private int c;
   private afh b;
   private cj a;

   public boolean equals(Object var1) {
      if (!(var1 instanceof ade)) {
         return false;
      } else {
         ade var2 = (ade)var1;
         return this.a.equals(var2.a) && this.c == var2.c && this.d == var2.d && this.b == var2.b;
      }
   }

   public cj a() {
      return this.a;
   }

   public String toString() {
      return "TE(" + this.a + ")," + this.c + "," + this.d + "," + this.b;
   }

   public int c() {
      return this.d;
   }

   public afh d() {
      return this.b;
   }

   public ade(cj var1, afh var2, int var3, int var4) {
      this.a = var1;
      this.c = var3;
      this.d = var4;
      this.b = var2;
   }

   public int b() {
      return this.c;
   }
}
