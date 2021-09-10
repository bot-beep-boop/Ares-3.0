import java.io.IOException;

public class hj implements ff<fj> {
   private int a;
   private String b;

   public hj(int var1, auk var2) {
      this.a = var1;
      if (var2 == null) {
         this.b = "";
      } else {
         this.b = var2.b();
      }

   }

   public int a() {
      return this.a;
   }

   public void b(em var1) throws IOException {
      var1.writeByte(this.a);
      var1.a(this.b);
   }

   public void a(em var1) throws IOException {
      this.a = var1.readByte();
      this.b = var1.c(16);
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public String b() {
      return this.b;
   }

   public hj() {
   }
}
