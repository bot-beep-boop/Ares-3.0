import java.util.Random;

public class us extends oa.a {
   private float c;
   private final zx b;
   private boolean d;

   public us a() {
      this.d = true;
      return this;
   }

   public us(zx var1, int var2) {
      super(var2);
      this.b = var1;
   }

   public zx a(Random var1) {
      zx var2 = this.b.k();
      if (this.c > 0.0F) {
         int var3 = (int)(this.c * (float)this.b.j());
         int var4 = var2.j() - var1.nextInt(var1.nextInt(var3) + 1);
         if (var4 > var3) {
            var4 = var3;
         }

         if (var4 < 1) {
            var4 = 1;
         }

         var2.b(var4);
      }

      if (this.d) {
         ack.a(var1, var2, 30);
      }

      return var2;
   }

   public us a(float var1) {
      this.c = var1;
      return this;
   }
}
