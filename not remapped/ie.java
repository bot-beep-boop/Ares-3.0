import java.io.IOException;

public class ie implements ff<ic> {
   private String a;

   public void a(ic var1) {
      var1.a(this);
   }

   public ie(String var1) {
      if (var1.length() > 100) {
         var1 = var1.substring(0, 100);
      }

      this.a = var1;
   }

   public String a() {
      return this.a;
   }

   public void a(ep var1) {
      this.a((ic)var1);
   }

   public void a(em var1) throws IOException {
      this.a = var1.c(100);
   }

   public void b(em var1) throws IOException {
      var1.a(this.a);
   }

   public ie() {
   }
}
