import java.io.IOException;
import org.apache.commons.lang3.Validate;

public class gs implements ff<fj> {
   private int b;
   private int f;
   private int c = Integer.MAX_VALUE;
   private float e;
   private int d;
   private String a;

   public void b(em var1) throws IOException {
      var1.a(this.a);
      var1.writeInt(this.b);
      var1.writeInt(this.c);
      var1.writeInt(this.d);
      var1.writeFloat(this.e);
      var1.writeByte(this.f);
   }

   public double c() {
      return (double)((float)this.c / 8.0F);
   }

   public void a(em var1) throws IOException {
      this.a = var1.c(256);
      this.b = var1.readInt();
      this.c = var1.readInt();
      this.d = var1.readInt();
      this.e = var1.readFloat();
      this.f = var1.readUnsignedByte();
   }

   public gs() {
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public gs(String var1, double var2, double var4, double var6, float var8, float var9) {
      Validate.notNull(var1, "name", new Object[0]);
      this.a = var1;
      this.b = (int)(var2 * 8.0D);
      this.c = (int)(var4 * 8.0D);
      this.d = (int)(var6 * 8.0D);
      this.e = var8;
      this.f = (int)(var9 * 63.0F);
      var9 = ns.a(var9, 0.0F, 255.0F);
   }

   public float e() {
      return this.e;
   }

   public String a() {
      return this.a;
   }

   public double d() {
      return (double)((float)this.d / 8.0F);
   }

   public double b() {
      return (double)((float)this.b / 8.0F);
   }

   public float f() {
      return (float)this.f / 63.0F;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }
}
