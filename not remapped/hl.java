import java.io.IOException;

public class hl implements ff<fj> {
   private int b;
   private int c;
   private int a;

   public void a(fj var1) {
      var1.a(this);
   }

   public hl() {
   }

   public hl(int var1, pk var2, pk var3) {
      this.a = var1;
      this.b = var2.F();
      this.c = var3 != null ? var3.F() : -1;
   }

   public void b(em var1) throws IOException {
      var1.writeInt(this.b);
      var1.writeInt(this.c);
      var1.writeByte(this.a);
   }

   public int b() {
      return this.b;
   }

   public int a() {
      return this.a;
   }

   public void a(em var1) throws IOException {
      this.b = var1.readInt();
      this.c = var1.readInt();
      this.a = var1.readUnsignedByte();
   }

   public int c() {
      return this.c;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }
}
