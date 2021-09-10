import java.io.IOException;

public class gi implements ff<fj> {
   private int a;
   private byte b;

   public void a(fj var1) {
      var1.a(this);
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public pk a(adm var1) {
      return var1.a(this.a);
   }

   public gi() {
   }

   public void a(em var1) throws IOException {
      this.a = var1.readInt();
      this.b = var1.readByte();
   }

   public gi(pk var1, byte var2) {
      this.a = var1.F();
      this.b = var2;
   }

   public byte a() {
      return this.b;
   }

   public void b(em var1) throws IOException {
      var1.writeInt(this.a);
      var1.writeByte(this.b);
   }
}
