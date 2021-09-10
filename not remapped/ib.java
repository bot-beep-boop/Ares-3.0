import java.io.IOException;

public class ib implements ff<fj> {
   private int d;
   private int a;
   private byte e;
   private byte c;
   private byte b;

   public void a(em var1) throws IOException {
      this.a = var1.e();
      this.b = var1.readByte();
      this.c = var1.readByte();
      this.d = var1.e();
      this.e = var1.readByte();
   }

   public boolean f() {
      return this.e != 0;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public ib() {
   }

   public boolean a() {
      return this.d == 32767;
   }

   public int b() {
      return this.a;
   }

   public int e() {
      return this.d;
   }

   public void b(em var1) throws IOException {
      var1.b(this.a);
      var1.writeByte(this.b);
      var1.writeByte(this.c);
      var1.b(this.d);
      var1.writeByte(this.e);
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public byte d() {
      return this.c;
   }

   public byte c() {
      return this.b;
   }

   public ib(int var1, pf var2) {
      this.a = var1;
      this.b = (byte)(var2.a() & 255);
      this.c = (byte)(var2.c() & 255);
      if (var2.b() > 32767) {
         this.d = 32767;
      } else {
         this.d = var2.b();
      }

      this.e = (byte)(var2.f() ? 1 : 0);
   }
}
