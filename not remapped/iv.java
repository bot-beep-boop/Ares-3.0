import java.io.IOException;

public class iv implements ff<ic> {
   private int a;

   public void b(em var1) throws IOException {
      var1.writeShort(this.a);
   }

   public void a(ep var1) {
      this.a((ic)var1);
   }

   public void a(ic var1) {
      var1.a(this);
   }

   public iv() {
   }

   public int a() {
      return this.a;
   }

   public void a(em var1) throws IOException {
      this.a = var1.readShort();
   }

   public iv(int var1) {
      this.a = var1;
   }
}
