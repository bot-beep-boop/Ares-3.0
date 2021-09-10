import java.io.IOException;

public class ix implements ff<ic> {
   private cj a;
   private eu[] b;

   public ix() {
   }

   public void b(em var1) throws IOException {
      var1.a(this.a);

      for(int var2 = 0; var2 < 4; ++var2) {
         eu var3 = this.b[var2];
         String var4 = eu.a.a(var3);
         var1.a(var4);
      }

   }

   public void a(ic var1) {
      var1.a(this);
   }

   public eu[] b() {
      return this.b;
   }

   public ix(cj var1, eu[] var2) {
      this.a = var1;
      this.b = new eu[]{var2[0], var2[1], var2[2], var2[3]};
   }

   public void a(em var1) throws IOException {
      this.a = var1.c();
      this.b = new eu[4];

      for(int var2 = 0; var2 < 4; ++var2) {
         String var3 = var1.c(384);
         eu var4 = eu.a.a(var3);
         this.b[var2] = var4;
      }

   }

   public cj a() {
      return this.a;
   }

   public void a(ep var1) {
      this.a((ic)var1);
   }
}
