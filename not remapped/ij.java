import java.io.IOException;

public class ij implements ff<ic> {
   private int b;
   private int a;

   public void a(em var1) throws IOException {
      this.a = var1.readByte();
      this.b = var1.readByte();
   }

   public int a() {
      return this.a;
   }

   public void a(ic var1) {
      var1.a(this);
   }

   public ij() {
   }

   public int b() {
      return this.b;
   }

   public void b(em var1) throws IOException {
      var1.writeByte(this.a);
      var1.writeByte(this.b);
   }

   public ij(int var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(ep var1) {
      this.a((ic)var1);
   }
}
