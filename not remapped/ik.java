import java.io.IOException;

public class ik implements ff<ic> {
   private int f;
   private int a;
   private short d;
   private int c;
   private zx e;
   private int b;

   public short d() {
      return this.d;
   }

   public ik(int var1, int var2, int var3, int var4, zx var5, short var6) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.e = var5 != null ? var5.k() : null;
      this.d = var6;
      this.f = var4;
   }

   public zx e() {
      return this.e;
   }

   public void a(ic var1) {
      var1.a(this);
   }

   public int c() {
      return this.c;
   }

   public int a() {
      return this.a;
   }

   public void b(em var1) throws IOException {
      var1.writeByte(this.a);
      var1.writeShort(this.b);
      var1.writeByte(this.c);
      var1.writeShort(this.d);
      var1.writeByte(this.f);
      var1.a(this.e);
   }

   public int f() {
      return this.f;
   }

   public void a(em var1) throws IOException {
      this.a = var1.readByte();
      this.b = var1.readShort();
      this.c = var1.readByte();
      this.d = var1.readShort();
      this.f = var1.readByte();
      this.e = var1.i();
   }

   public void a(ep var1) {
      this.a((ic)var1);
   }

   public int b() {
      return this.b;
   }

   public ik() {
   }
}
