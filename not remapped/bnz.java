public class bnz {
   private final int a;
   private final int b;

   public int c() {
      return this.a;
   }

   public bnz(int var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public bnz(int var1) {
      this(var1, -1);
   }

   public boolean a() {
      return this.b == -1;
   }

   public int b() {
      return this.b;
   }
}
