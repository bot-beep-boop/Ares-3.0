import java.io.IOException;

public class hz implements ff<fj> {
   private int b;
   private int d;
   private int c;
   private boolean g;
   private byte f;
   private int a;
   private byte e;

   public void b(em var1) throws IOException {
      var1.b(this.a);
      var1.writeInt(this.b);
      var1.writeInt(this.c);
      var1.writeInt(this.d);
      var1.writeByte(this.e);
      var1.writeByte(this.f);
      var1.writeBoolean(this.g);
   }

   public int c() {
      return this.c;
   }

   public byte f() {
      return this.f;
   }

   public int b() {
      return this.b;
   }

   public boolean g() {
      return this.g;
   }

   public int d() {
      return this.d;
   }

   public void a(em var1) throws IOException {
      this.a = var1.e();
      this.b = var1.readInt();
      this.c = var1.readInt();
      this.d = var1.readInt();
      this.e = var1.readByte();
      this.f = var1.readByte();
      this.g = var1.readBoolean();
   }

   public hz() {
   }

   public hz(pk var1) {
      this.a = var1.F();
      this.b = ns.c(var1.s * 32.0D);
      this.c = ns.c(var1.t * 32.0D);
      this.d = ns.c(var1.u * 32.0D);
      this.e = (byte)((int)(var1.y * 256.0F / 360.0F));
      this.f = (byte)((int)(var1.z * 256.0F / 360.0F));
      this.g = var1.C;
   }

   public int a() {
      return this.a;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public byte e() {
      return this.e;
   }

   public hz(int var1, int var2, int var3, int var4, byte var5, byte var6, boolean var7) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = var6;
      this.g = var7;
   }

   public void a(fj var1) {
      var1.a(this);
   }
}
