import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class dz extends eb.a {
   private short b;

   public byte f() {
      return (byte)(this.b & 255);
   }

   public String toString() {
      return "" + this.b + "s";
   }

   public dz() {
   }

   public boolean equals(Object var1) {
      if (super.equals(var1)) {
         dz var2 = (dz)var1;
         return this.b == var2.b;
      } else {
         return false;
      }
   }

   public float h() {
      return (float)this.b;
   }

   public long c() {
      return (long)this.b;
   }

   public int hashCode() {
      return super.hashCode() ^ this.b;
   }

   public short e() {
      return this.b;
   }

   public byte a() {
      return 2;
   }

   void a(DataOutput var1) throws IOException {
      var1.writeShort(this.b);
   }

   public int d() {
      return this.b;
   }

   public dz(short var1) {
      this.b = var1;
   }

   public double g() {
      return (double)this.b;
   }

   void a(DataInput var1, int var2, dw var3) throws IOException {
      var3.a(80L);
      this.b = var1.readShort();
   }

   public eb b() {
      return new dz(this.b);
   }
}
