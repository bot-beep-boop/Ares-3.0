import java.io.IOException;

public class ii implements ff<ic> {
   private int a;
   private boolean c;
   private short b;

   public void b(em var1) throws IOException {
      var1.writeByte(this.a);
      var1.writeShort(this.b);
      var1.writeByte(this.c ? 1 : 0);
   }

   public ii() {
   }

   public void a(ep var1) {
      this.a((ic)var1);
   }

   public ii(int var1, short var2, boolean var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public int a() {
      return this.a;
   }

   public void a(em var1) throws IOException {
      this.a = var1.readByte();
      this.b = var1.readShort();
      this.c = var1.readByte() != 0;
   }

   public void a(ic var1) {
      var1.a(this);
   }

   public short b() {
      return this.b;
   }
}
