import java.io.IOException;
import java.util.List;

public class hk implements ff<fj> {
   private int a;
   private List<pz.a> b;

   public void a(fj var1) {
      var1.a(this);
   }

   public hk(int var1, pz var2, boolean var3) {
      this.a = var1;
      if (var3) {
         this.b = var2.c();
      } else {
         this.b = var2.b();
      }

   }

   public hk() {
   }

   public void a(em var1) throws IOException {
      this.a = var1.e();
      this.b = pz.b(var1);
   }

   public List<pz.a> a() {
      return this.b;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public int b() {
      return this.a;
   }

   public void b(em var1) throws IOException {
      var1.b(this.a);
      pz.a(this.b, var1);
   }
}
