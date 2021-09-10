import java.io.IOException;

public class ja implements ff<ic> {
   private float f;
   private int c;
   private cj b;
   private static final cj a = new cj(-1, -1, -1);
   private float e;
   private float g;
   private zx d;

   public void b(em var1) throws IOException {
      var1.a(this.b);
      var1.writeByte(this.c);
      var1.a(this.d);
      var1.writeByte((int)(this.e * 16.0F));
      var1.writeByte((int)(this.f * 16.0F));
      var1.writeByte((int)(this.g * 16.0F));
   }

   public ja(zx var1) {
      this(a, 255, var1, 0.0F, 0.0F, 0.0F);
   }

   public ja(cj var1, int var2, zx var3, float var4, float var5, float var6) {
      this.b = var1;
      this.c = var2;
      this.d = var3 != null ? var3.k() : null;
      this.e = var4;
      this.f = var5;
      this.g = var6;
   }

   public ja() {
   }

   public void a(ep var1) {
      this.a((ic)var1);
   }

   public float d() {
      return this.e;
   }

   public zx c() {
      return this.d;
   }

   public float f() {
      return this.g;
   }

   public int b() {
      return this.c;
   }

   public float e() {
      return this.f;
   }

   public cj a() {
      return this.b;
   }

   public void a(ic var1) {
      var1.a(this);
   }

   public void a(em var1) throws IOException {
      this.b = var1.c();
      this.c = var1.readUnsignedByte();
      this.d = var1.i();
      this.e = (float)var1.readUnsignedByte() / 16.0F;
      this.f = (float)var1.readUnsignedByte() / 16.0F;
      this.g = (float)var1.readUnsignedByte() / 16.0F;
   }
}
