import java.io.IOException;

public class gr implements ff<fj> {
   private float b;
   private float h;
   private cy a;
   private float f;
   private int i;
   private float c;
   private float e;
   private boolean j;
   private float d;
   private float g;
   private int[] k;

   public float h() {
      return this.g;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public gr(cy var1, boolean var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, int var10, int... var11) {
      this.a = var1;
      this.j = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      this.e = var6;
      this.f = var7;
      this.g = var8;
      this.h = var9;
      this.i = var10;
      this.k = var11;
   }

   public float f() {
      return this.e;
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public boolean b() {
      return this.j;
   }

   public float i() {
      return this.h;
   }

   public int j() {
      return this.i;
   }

   public int[] k() {
      return this.k;
   }

   public double e() {
      return (double)this.d;
   }

   public cy a() {
      return this.a;
   }

   public double c() {
      return (double)this.b;
   }

   public float g() {
      return this.f;
   }

   public void a(em var1) throws IOException {
      this.a = cy.a(var1.readInt());
      if (this.a == null) {
         this.a = cy.J;
      }

      this.j = var1.readBoolean();
      this.b = var1.readFloat();
      this.c = var1.readFloat();
      this.d = var1.readFloat();
      this.e = var1.readFloat();
      this.f = var1.readFloat();
      this.g = var1.readFloat();
      this.h = var1.readFloat();
      this.i = var1.readInt();
      int var2 = this.a.d();
      this.k = new int[var2];

      for(int var3 = 0; var3 < var2; ++var3) {
         this.k[var3] = var1.e();
      }

   }

   public void b(em var1) throws IOException {
      var1.writeInt(this.a.c());
      var1.writeBoolean(this.j);
      var1.writeFloat(this.b);
      var1.writeFloat(this.c);
      var1.writeFloat(this.d);
      var1.writeFloat(this.e);
      var1.writeFloat(this.f);
      var1.writeFloat(this.g);
      var1.writeFloat(this.h);
      var1.writeInt(this.i);
      int var2 = this.a.d();

      for(int var3 = 0; var3 < var2; ++var3) {
         var1.b(this.k[var3]);
      }

   }

   public double d() {
      return (double)this.c;
   }

   public gr() {
   }
}
