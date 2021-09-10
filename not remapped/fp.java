import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class fp implements ff<fj> {
   private int e;
   private List<pz.a> j;
   private byte f;
   private byte g;
   private pz i;
   private int d;
   private int h;
   private UUID b;
   private int c;
   private int a;

   public void b(em var1) throws IOException {
      var1.b(this.a);
      var1.a(this.b);
      var1.writeInt(this.c);
      var1.writeInt(this.d);
      var1.writeInt(this.e);
      var1.writeByte(this.f);
      var1.writeByte(this.g);
      var1.writeShort(this.h);
      this.i.a(var1);
   }

   public void a(em var1) throws IOException {
      this.a = var1.e();
      this.b = var1.g();
      this.c = var1.readInt();
      this.d = var1.readInt();
      this.e = var1.readInt();
      this.f = var1.readByte();
      this.g = var1.readByte();
      this.h = var1.readShort();
      this.j = pz.b(var1);
   }

   public byte h() {
      return this.g;
   }

   public int i() {
      return this.h;
   }

   public byte g() {
      return this.f;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public int e() {
      return this.d;
   }

   public int b() {
      return this.a;
   }

   public fp(wn var1) {
      this.a = var1.F();
      this.b = var1.cd().getId();
      this.c = ns.c(var1.s * 32.0D);
      this.d = ns.c(var1.t * 32.0D);
      this.e = ns.c(var1.u * 32.0D);
      this.f = (byte)((int)(var1.y * 256.0F / 360.0F));
      this.g = (byte)((int)(var1.z * 256.0F / 360.0F));
      zx var2 = var1.bi.h();
      this.h = var2 == null ? 0 : zw.b(var2.b());
      this.i = var1.H();
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public List<pz.a> a() {
      if (this.j == null) {
         this.j = this.i.c();
      }

      return this.j;
   }

   public fp() {
   }

   public UUID c() {
      return this.b;
   }

   public int d() {
      return this.c;
   }

   public int f() {
      return this.e;
   }
}
