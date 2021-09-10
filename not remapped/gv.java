import java.io.IOException;

public class gv implements ff<fj> {
   protected byte f;
   protected byte d;
   protected byte e;
   protected boolean h;
   protected byte c;
   protected int a;
   protected byte b;
   protected boolean g;

   public void a(fj var1) {
      var1.a(this);
   }

   public boolean g() {
      return this.g;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public byte c() {
      return this.d;
   }

   public void b(em var1) throws IOException {
      var1.b(this.a);
   }

   public gv() {
   }

   public String toString() {
      return "Entity_" + super.toString();
   }

   public pk a(adm var1) {
      return var1.a(this.a);
   }

   public byte e() {
      return this.f;
   }

   public void a(em var1) throws IOException {
      this.a = var1.e();
   }

   public boolean f() {
      return this.h;
   }

   public byte a() {
      return this.b;
   }

   public byte b() {
      return this.c;
   }

   public byte d() {
      return this.e;
   }

   public gv(int var1) {
      this.a = var1;
   }

   public static class c extends gv {
      public c() {
         this.h = true;
      }

      public void a(em var1) throws IOException {
         super.a(var1);
         this.e = var1.readByte();
         this.f = var1.readByte();
         this.g = var1.readBoolean();
      }

      public void b(em var1) throws IOException {
         super.b(var1);
         var1.writeByte(this.e);
         var1.writeByte(this.f);
         var1.writeBoolean(this.g);
      }

      public c(int var1, byte var2, byte var3, boolean var4) {
         super(var1);
         this.e = var2;
         this.f = var3;
         this.h = true;
         this.g = var4;
      }

      public void a(ep var1) {
         super.a((fj)var1);
      }
   }

   public static class b extends gv {
      public void a(em var1) throws IOException {
         super.a(var1);
         this.b = var1.readByte();
         this.c = var1.readByte();
         this.d = var1.readByte();
         this.e = var1.readByte();
         this.f = var1.readByte();
         this.g = var1.readBoolean();
      }

      public void a(ep var1) {
         super.a((fj)var1);
      }

      public void b(em var1) throws IOException {
         super.b(var1);
         var1.writeByte(this.b);
         var1.writeByte(this.c);
         var1.writeByte(this.d);
         var1.writeByte(this.e);
         var1.writeByte(this.f);
         var1.writeBoolean(this.g);
      }

      public b() {
         this.h = true;
      }

      public b(int var1, byte var2, byte var3, byte var4, byte var5, byte var6, boolean var7) {
         super(var1);
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
         this.f = var6;
         this.g = var7;
         this.h = true;
      }
   }

   public static class a extends gv {
      public a() {
      }

      public void a(em var1) throws IOException {
         super.a(var1);
         this.b = var1.readByte();
         this.c = var1.readByte();
         this.d = var1.readByte();
         this.g = var1.readBoolean();
      }

      public void a(ep var1) {
         super.a((fj)var1);
      }

      public a(int var1, byte var2, byte var3, byte var4, boolean var5) {
         super(var1);
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.g = var5;
      }

      public void b(em var1) throws IOException {
         super.b(var1);
         var1.writeByte(this.b);
         var1.writeByte(this.c);
         var1.writeByte(this.d);
         var1.writeBoolean(this.g);
      }
   }
}
