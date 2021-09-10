import java.io.IOException;

public class ga implements ff<fj> {
   private short b;
   private boolean c;
   private int a;

   public void a(fj var1) {
      var1.a(this);
   }

   public ga() {
   }

   public boolean c() {
      return this.c;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public short b() {
      return this.b;
   }

   public void b(em var1) throws IOException {
      var1.writeByte(this.a);
      var1.writeShort(this.b);
      var1.writeBoolean(this.c);
   }

   public int a() {
      return this.a;
   }

   public void a(em var1) throws IOException {
      this.a = var1.readUnsignedByte();
      this.b = var1.readShort();
      this.c = var1.readBoolean();
   }

   public ga(int var1, short var2, boolean var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }
}
