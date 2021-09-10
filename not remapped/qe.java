public abstract class qe implements qb {
   private final double c;
   private final qb a;
   private final String b;
   private boolean d;

   protected qe(qb var1, String var2, double var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      if (var2 == null) {
         throw new IllegalArgumentException("Name cannot be null!");
      }
   }

   public boolean equals(Object var1) {
      return var1 instanceof qb && this.b.equals(((qb)var1).a());
   }

   public String a() {
      return this.b;
   }

   public qe a(boolean var1) {
      this.d = var1;
      return this;
   }

   public int hashCode() {
      return this.b.hashCode();
   }

   public double b() {
      return this.c;
   }

   public qb d() {
      return this.a;
   }

   public boolean c() {
      return this.d;
   }
}
