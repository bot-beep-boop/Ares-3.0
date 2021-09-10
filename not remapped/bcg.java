public class bcg {
   public float c;
   public float b;
   public aui a;

   public bcg a(float var1, float var2) {
      return new bcg(this, var1, var2);
   }

   public bcg(aui var1, float var2, float var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public bcg(float var1, float var2, float var3, float var4, float var5) {
      this(new aui((double)var1, (double)var2, (double)var3), var4, var5);
   }

   public bcg(bcg var1, float var2, float var3) {
      this.a = var1.a;
      this.b = var2;
      this.c = var3;
   }
}
