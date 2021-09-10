public class bqc implements bqb<bpw> {
   private final int b;
   private final bpw a;

   public bpw b() {
      return new bpw(this.a);
   }

   public int a() {
      return this.b;
   }

   public Object g() {
      return this.b();
   }

   bqc(bpw var1, int var2) {
      this.a = var1;
      this.b = var2;
   }
}
