import java.io.IOException;

public class hw implements ff<fj> {
   private eu[] c;
   private adm a;
   private cj b;

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void a(em var1) throws IOException {
      this.b = var1.c();
      this.c = new eu[4];

      for(int var2 = 0; var2 < 4; ++var2) {
         this.c[var2] = var1.d();
      }

   }

   public hw() {
   }

   public hw(adm var1, cj var2, eu[] var3) {
      this.a = var1;
      this.b = var2;
      this.c = new eu[]{var3[0], var3[1], var3[2], var3[3]};
   }

   public void b(em var1) throws IOException {
      var1.a(this.b);

      for(int var2 = 0; var2 < 4; ++var2) {
         var1.a(this.c[var2]);
      }

   }

   public cj a() {
      return this.b;
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public eu[] b() {
      return this.c;
   }
}
