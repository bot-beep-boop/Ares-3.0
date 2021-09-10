import java.io.IOException;

public class gb implements ff<fj> {
   private int a;

   public gb() {
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void a(em var1) throws IOException {
      this.a = var1.readUnsignedByte();
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public void b(em var1) throws IOException {
      var1.writeByte(this.a);
   }

   public gb(int var1) {
      this.a = var1;
   }
}
