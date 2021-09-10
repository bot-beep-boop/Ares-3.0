import java.io.IOException;

public class hd implements ff<fj> {
   private String b;
   private String a;

   public String a() {
      return this.a;
   }

   public void a(em var1) throws IOException {
      this.a = var1.c(32767);
      this.b = var1.c(40);
   }

   public void b(em var1) throws IOException {
      var1.a(this.a);
      var1.a(this.b);
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public hd(String var1, String var2) {
      this.a = var1;
      this.b = var2;
      if (var2.length() > 40) {
         throw new IllegalArgumentException("Hash is too long (max 40, was " + var2.length() + ")");
      }
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public String b() {
      return this.b;
   }

   public hd() {
   }
}
