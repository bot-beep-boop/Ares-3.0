import java.io.IOException;

public class ge implements ff<fj> {
   private int c;
   private int a;
   private int b;

   public int a() {
      return this.a;
   }

   public int c() {
      return this.c;
   }

   public ge(int var1, int var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public void a(em var1) throws IOException {
      this.a = var1.readUnsignedByte();
      this.b = var1.readShort();
      this.c = var1.readShort();
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void b(em var1) throws IOException {
      var1.writeByte(this.a);
      var1.writeShort(this.b);
      var1.writeShort(this.c);
   }

   public int b() {
      return this.b;
   }

   public ge() {
   }
}
