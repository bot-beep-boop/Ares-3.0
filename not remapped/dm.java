import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class dm extends eb.a {
   private byte b;

   public int d() {
      return this.b;
   }

   void a(DataOutput var1) throws IOException {
      var1.writeByte(this.b);
   }

   public dm(byte var1) {
      this.b = var1;
   }

   public boolean equals(Object var1) {
      if (super.equals(var1)) {
         dm var2 = (dm)var1;
         return this.b == var2.b;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ this.b;
   }

   void a(DataInput var1, int var2, dw var3) throws IOException {
      var3.a(72L);
      this.b = var1.readByte();
   }

   public eb b() {
      return new dm(this.b);
   }

   public short e() {
      return (short)this.b;
   }

   dm() {
   }

   public byte f() {
      return this.b;
   }

   public String toString() {
      return "" + this.b + "b";
   }

   public double g() {
      return (double)this.b;
   }

   public float h() {
      return (float)this.b;
   }

   public long c() {
      return (long)this.b;
   }

   public byte a() {
      return 1;
   }
}
