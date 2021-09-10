import java.io.IOException;

public class hm implements ff<fj> {
   private int b;
   private int d;
   private int a;
   private int c;

   public hm() {
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void b(em var1) throws IOException {
      var1.b(this.a);
      var1.writeShort(this.b);
      var1.writeShort(this.c);
      var1.writeShort(this.d);
   }

   public int a() {
      return this.a;
   }

   public hm(int var1, double var2, double var4, double var6) {
      this.a = var1;
      double var8 = 3.9D;
      if (var2 < -var8) {
         var2 = -var8;
      }

      if (var4 < -var8) {
         var4 = -var8;
      }

      if (var6 < -var8) {
         var6 = -var8;
      }

      if (var2 > var8) {
         var2 = var8;
      }

      if (var4 > var8) {
         var4 = var8;
      }

      if (var6 > var8) {
         var6 = var8;
      }

      this.b = (int)(var2 * 8000.0D);
      this.c = (int)(var4 * 8000.0D);
      this.d = (int)(var6 * 8000.0D);
   }

   public void a(em var1) throws IOException {
      this.a = var1.e();
      this.b = var1.readShort();
      this.c = var1.readShort();
      this.d = var1.readShort();
   }

   public int d() {
      return this.d;
   }

   public int b() {
      return this.b;
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public int c() {
      return this.c;
   }

   public hm(pk var1) {
      this(var1.F(), var1.v, var1.w, var1.x);
   }
}
