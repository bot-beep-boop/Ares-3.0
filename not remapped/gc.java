import java.io.IOException;

public class gc implements ff<fj> {
   private int a;
   private int d;
   private int e;
   private String b;
   private eu c;

   public int d() {
      return this.d;
   }

   public gc() {
   }

   public void b(em var1) throws IOException {
      var1.writeByte(this.a);
      var1.a(this.b);
      var1.a(this.c);
      var1.writeByte(this.d);
      if (this.b.equals("EntityHorse")) {
         var1.writeInt(this.e);
      }

   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public int a() {
      return this.a;
   }

   public String b() {
      return this.b;
   }

   public gc(int var1, String var2, eu var3, int var4, int var5) {
      this(var1, var2, var3, var4);
      this.e = var5;
   }

   public gc(int var1, String var2, eu var3) {
      this(var1, var2, var3, 0);
   }

   public void a(em var1) throws IOException {
      this.a = var1.readUnsignedByte();
      this.b = var1.c(32);
      this.c = var1.d();
      this.d = var1.readUnsignedByte();
      if (this.b.equals("EntityHorse")) {
         this.e = var1.readInt();
      }

   }

   public boolean f() {
      return this.d > 0;
   }

   public int e() {
      return this.e;
   }

   public gc(int var1, String var2, eu var3, int var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public eu c() {
      return this.c;
   }
}
