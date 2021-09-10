import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class dr extends eb.a {
   private float b;

   public long c() {
      return (long)this.b;
   }

   dr() {
   }

   public eb b() {
      return new dr(this.b);
   }

   public boolean equals(Object var1) {
      if (super.equals(var1)) {
         dr var2 = (dr)var1;
         return this.b == var2.b;
      } else {
         return false;
      }
   }

   public String toString() {
      return "" + this.b + "f";
   }

   public int hashCode() {
      return super.hashCode() ^ Float.floatToIntBits(this.b);
   }

   public int d() {
      return ns.d(this.b);
   }

   public dr(float var1) {
      this.b = var1;
   }

   public short e() {
      return (short)(ns.d(this.b) & '\uffff');
   }

   public double g() {
      return (double)this.b;
   }

   void a(DataInput var1, int var2, dw var3) throws IOException {
      var3.a(96L);
      this.b = var1.readFloat();
   }

   void a(DataOutput var1) throws IOException {
      var1.writeFloat(this.b);
   }

   public float h() {
      return this.b;
   }

   public byte a() {
      return 5;
   }

   public byte f() {
      return (byte)(ns.d(this.b) & 255);
   }
}
