import java.io.IOException;

public class fx implements ff<fj> {
   private String[] a;

   public void b(em var1) throws IOException {
      var1.b(this.a.length);
      String[] var2 = this.a;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         var1.a(var5);
      }

   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public fx() {
   }

   public void a(em var1) throws IOException {
      this.a = new String[var1.e()];

      for(int var2 = 0; var2 < this.a.length; ++var2) {
         this.a[var2] = var1.c(32767);
      }

   }

   public String[] a() {
      return this.a;
   }

   public fx(String[] var1) {
      this.a = var1;
   }
}
