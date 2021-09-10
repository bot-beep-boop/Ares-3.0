import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class dv extends eb.a {
   private long b;

   public float h() {
      return (float)this.b;
   }

   void a(DataOutput var1) throws IOException {
      var1.writeLong(this.b);
   }

   public byte f() {
      return (byte)((int)(this.b & 255L));
   }

   dv() {
   }

   void a(DataInput var1, int var2, dw var3) throws IOException {
      var3.a(128L);
      this.b = var1.readLong();
   }

   public byte a() {
      return 4;
   }

   public boolean equals(Object var1) {
      if (super.equals(var1)) {
         dv var2 = (dv)var1;
         return this.b == var2.b;
      } else {
         return false;
      }
   }

   public long c() {
      return this.b;
   }

   public int d() {
      return (int)(this.b & -1L);
   }

   public dv(long var1) {
      this.b = var1;
   }

   public eb b() {
      return new dv(this.b);
   }

   public short e() {
      return (short)((int)(this.b & 65535L));
   }

   public double g() {
      return (double)this.b;
   }

   public String toString() {
      return "" + this.b + "L";
   }

   public int hashCode() {
      return super.hashCode() ^ (int)(this.b ^ this.b >>> 32);
   }
}
