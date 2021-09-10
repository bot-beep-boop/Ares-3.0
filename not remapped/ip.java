import java.io.IOException;

public class ip implements ff<ic> {
   protected boolean h;
   protected boolean f;
   protected double a;
   protected float e;
   protected float d;
   protected double c;
   protected double b;
   protected boolean g;

   public void b(em var1) throws IOException {
      var1.writeByte(this.f ? 1 : 0);
   }

   public float d() {
      return this.d;
   }

   public ip(boolean var1) {
      this.f = var1;
   }

   public boolean f() {
      return this.f;
   }

   public void a(em var1) throws IOException {
      this.f = var1.readUnsignedByte() != 0;
   }

   public double a() {
      return this.a;
   }

   public double c() {
      return this.c;
   }

   public boolean g() {
      return this.g;
   }

   public ip() {
   }

   public boolean h() {
      return this.h;
   }

   public void a(boolean var1) {
      this.g = var1;
   }

   public float e() {
      return this.e;
   }

   public void a(ic var1) {
      var1.a(this);
   }

   public void a(ep var1) {
      this.a((ic)var1);
   }

   public double b() {
      return this.b;
   }

   public static class b extends ip {
      public b() {
         this.g = true;
         this.h = true;
      }

      public void a(ep var1) {
         super.a((ic)var1);
      }

      public void b(em var1) throws IOException {
         var1.writeDouble(this.a);
         var1.writeDouble(this.b);
         var1.writeDouble(this.c);
         var1.writeFloat(this.d);
         var1.writeFloat(this.e);
         super.b(var1);
      }

      public void a(em var1) throws IOException {
         this.a = var1.readDouble();
         this.b = var1.readDouble();
         this.c = var1.readDouble();
         this.d = var1.readFloat();
         this.e = var1.readFloat();
         super.a(var1);
      }

      public b(double var1, double var3, double var5, float var7, float var8, boolean var9) {
         this.a = var1;
         this.b = var3;
         this.c = var5;
         this.d = var7;
         this.e = var8;
         this.f = var9;
         this.h = true;
         this.g = true;
      }
   }

   public static class c extends ip {
      public c(float var1, float var2, boolean var3) {
         this.d = var1;
         this.e = var2;
         this.f = var3;
         this.h = true;
      }

      public void a(ep var1) {
         super.a((ic)var1);
      }

      public void b(em var1) throws IOException {
         var1.writeFloat(this.d);
         var1.writeFloat(this.e);
         super.b(var1);
      }

      public void a(em var1) throws IOException {
         this.d = var1.readFloat();
         this.e = var1.readFloat();
         super.a(var1);
      }

      public c() {
         this.h = true;
      }
   }

   public static class a extends ip {
      public a() {
         this.g = true;
      }

      public void b(em var1) throws IOException {
         var1.writeDouble(this.a);
         var1.writeDouble(this.b);
         var1.writeDouble(this.c);
         super.b(var1);
      }

      public void a(ep var1) {
         super.a((ic)var1);
      }

      public void a(em var1) throws IOException {
         this.a = var1.readDouble();
         this.b = var1.readDouble();
         this.c = var1.readDouble();
         super.a(var1);
      }

      public a(double var1, double var3, double var5, boolean var7) {
         this.a = var1;
         this.b = var3;
         this.c = var5;
         this.f = var7;
         this.g = true;
      }
   }
}
