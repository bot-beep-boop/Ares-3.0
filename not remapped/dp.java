import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class dp extends eb.a {
   private double b;

   public boolean equals(Object var1) {
      if (super.equals(var1)) {
         dp var2 = (dp)var1;
         return this.b == var2.b;
      } else {
         return false;
      }
   }

   public byte f() {
      return (byte)(ns.c(this.b) & 255);
   }

   public float h() {
      return (float)this.b;
   }

   void a(DataInput var1, int var2, dw var3) throws IOException {
      var3.a(128L);
      this.b = var1.readDouble();
   }

   public short e() {
      return (short)(ns.c(this.b) & '\uffff');
   }

   public dp(double var1) {
      this.b = var1;
   }

   public byte a() {
      return 6;
   }

   public int d() {
      return ns.c(this.b);
   }

   public eb b() {
      return new dp(this.b);
   }

   public long c() {
      return (long)Math.floor(this.b);
   }

   public int hashCode() {
      long var1 = Double.doubleToLongBits(this.b);
      return super.hashCode() ^ (int)(var1 ^ var1 >>> 32);
   }

   void a(DataOutput var1) throws IOException {
      var1.writeDouble(this.b);
   }

   dp() {
   }

   public String toString() {
      return "" + this.b + "d";
   }

   public double g() {
      return this.b;
   }
}
