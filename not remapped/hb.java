import java.io.IOException;

public class hb implements ff<fj> {
   private int[] a;

   public hb() {
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public hb(int... var1) {
      this.a = var1;
   }

   public int[] a() {
      return this.a;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void a(em var1) throws IOException {
      this.a = new int[var1.e()];

      for(int var2 = 0; var2 < this.a.length; ++var2) {
         this.a[var2] = var1.e();
      }

   }

   public void b(em var1) throws IOException {
      var1.b(this.a.length);

      for(int var2 = 0; var2 < this.a.length; ++var2) {
         var1.b(this.a[var2]);
      }

   }
}
