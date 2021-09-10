public class nh {
   private int d;
   private final long[] a = new long[240];
   private int c;
   private int b;

   public int b() {
      return this.d;
   }

   public int a(long var1, int var3) {
      double var4 = (double)var1 / 1.6666666E7D;
      return (int)(var4 * (double)var3);
   }

   public void a(long var1) {
      this.a[this.d] = var1;
      ++this.d;
      if (this.d == 240) {
         this.d = 0;
      }

      if (this.c < 240) {
         this.b = 0;
         ++this.c;
      } else {
         this.b = this.b(this.d + 1);
      }

   }

   public int b(int var1) {
      return var1 % 240;
   }

   public long[] c() {
      return this.a;
   }

   public int a() {
      return this.b;
   }
}
