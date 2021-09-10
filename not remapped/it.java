import java.io.IOException;

public class it implements ff<ic> {
   private float a;
   private boolean c;
   private boolean d;
   private float b;

   public boolean c() {
      return this.c;
   }

   public boolean d() {
      return this.d;
   }

   public float b() {
      return this.b;
   }

   public void a(ic var1) {
      var1.a(this);
   }

   public void a(em var1) throws IOException {
      this.a = var1.readFloat();
      this.b = var1.readFloat();
      byte var2 = var1.readByte();
      this.c = (var2 & 1) > 0;
      this.d = (var2 & 2) > 0;
   }

   public void a(ep var1) {
      this.a((ic)var1);
   }

   public it() {
   }

   public it(float var1, float var2, boolean var3, boolean var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public float a() {
      return this.a;
   }

   public void b(em var1) throws IOException {
      var1.writeFloat(this.a);
      var1.writeFloat(this.b);
      byte var2 = 0;
      if (this.c) {
         var2 = (byte)(var2 | 1);
      }

      if (this.d) {
         var2 = (byte)(var2 | 2);
      }

      var1.writeByte(var2);
   }
}
