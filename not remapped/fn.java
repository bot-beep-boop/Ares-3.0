import java.io.IOException;
import java.util.List;

public class fn implements ff<fj> {
   private pz l;
   private byte i;
   private int h;
   private int g;
   private List<pz.a> m;
   private int d;
   private int f;
   private int e;
   private int c;
   private byte k;
   private int a;
   private byte j;
   private int b;

   public byte j() {
      return this.i;
   }

   public int h() {
      return this.g;
   }

   public int f() {
      return this.e;
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public fn() {
   }

   public int c() {
      return this.b;
   }

   public byte l() {
      return this.k;
   }

   public int i() {
      return this.h;
   }

   public void a(em var1) throws IOException {
      this.a = var1.e();
      this.b = var1.readByte() & 255;
      this.c = var1.readInt();
      this.d = var1.readInt();
      this.e = var1.readInt();
      this.i = var1.readByte();
      this.j = var1.readByte();
      this.k = var1.readByte();
      this.f = var1.readShort();
      this.g = var1.readShort();
      this.h = var1.readShort();
      this.m = pz.b(var1);
   }

   public byte k() {
      return this.j;
   }

   public int b() {
      return this.a;
   }

   public List<pz.a> a() {
      if (this.m == null) {
         this.m = this.l.c();
      }

      return this.m;
   }

   public int g() {
      return this.f;
   }

   public fn(pr var1) {
      this.a = var1.F();
      this.b = (byte)pm.a((pk)var1);
      this.c = ns.c(var1.s * 32.0D);
      this.d = ns.c(var1.t * 32.0D);
      this.e = ns.c(var1.u * 32.0D);
      this.i = (byte)((int)(var1.y * 256.0F / 360.0F));
      this.j = (byte)((int)(var1.z * 256.0F / 360.0F));
      this.k = (byte)((int)(var1.aK * 256.0F / 360.0F));
      double var2 = 3.9D;
      double var4 = var1.v;
      double var6 = var1.w;
      double var8 = var1.x;
      if (var4 < -var2) {
         var4 = -var2;
      }

      if (var6 < -var2) {
         var6 = -var2;
      }

      if (var8 < -var2) {
         var8 = -var2;
      }

      if (var4 > var2) {
         var4 = var2;
      }

      if (var6 > var2) {
         var6 = var2;
      }

      if (var8 > var2) {
         var8 = var2;
      }

      this.f = (int)(var4 * 8000.0D);
      this.g = (int)(var6 * 8000.0D);
      this.h = (int)(var8 * 8000.0D);
      this.l = var1.H();
   }

   public int d() {
      return this.c;
   }

   public void b(em var1) throws IOException {
      var1.b(this.a);
      var1.writeByte(this.b & 255);
      var1.writeInt(this.c);
      var1.writeInt(this.d);
      var1.writeInt(this.e);
      var1.writeByte(this.i);
      var1.writeByte(this.j);
      var1.writeByte(this.k);
      var1.writeShort(this.f);
      var1.writeShort(this.g);
      var1.writeShort(this.h);
      this.l.a(var1);
   }

   public int e() {
      return this.d;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }
}
