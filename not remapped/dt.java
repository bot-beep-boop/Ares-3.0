import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class dt extends eb.a {
   private int b;

   public long c() {
      return (long)this.b;
   }

   public boolean equals(Object var1) {
      if (super.equals(var1)) {
         dt var2 = (dt)var1;
         return this.b == var2.b;
      } else {
         return false;
      }
   }

   dt() {
   }

   public int d() {
      return this.b;
   }

   public byte f() {
      return (byte)(this.b & 255);
   }

   public byte a() {
      return 3;
   }

   public double g() {
      return (double)this.b;
   }

   public String toString() {
      return "" + this.b;
   }

   public eb b() {
      return new dt(this.b);
   }

   public short e() {
      return (short)(this.b & '\uffff');
   }

   void a(DataOutput var1) throws IOException {
      var1.writeInt(this.b);
   }

   public float h() {
      return (float)this.b;
   }

   public int hashCode() {
      return super.hashCode() ^ this.b;
   }

   void a(DataInput var1, int var2, dw var3) throws IOException {
      var3.a(96L);
      this.b = var1.readInt();
   }

   public dt(int var1) {
      this.b = var1;
   }
}
