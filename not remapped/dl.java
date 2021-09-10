import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

public class dl extends eb {
   private byte[] b;

   void a(DataOutput var1) throws IOException {
      var1.writeInt(this.b.length);
      var1.write(this.b);
   }

   public byte a() {
      return 7;
   }

   void a(DataInput var1, int var2, dw var3) throws IOException {
      var3.a(192L);
      int var4 = var1.readInt();
      var3.a((long)(8 * var4));
      this.b = new byte[var4];
      var1.readFully(this.b);
   }

   dl() {
   }

   public boolean equals(Object var1) {
      return super.equals(var1) ? Arrays.equals(this.b, ((dl)var1).b) : false;
   }

   public int hashCode() {
      return super.hashCode() ^ Arrays.hashCode(this.b);
   }

   public eb b() {
      byte[] var1 = new byte[this.b.length];
      System.arraycopy(this.b, 0, var1, 0, this.b.length);
      return new dl(var1);
   }

   public dl(byte[] var1) {
      this.b = var1;
   }

   public String toString() {
      return "[" + this.b.length + " bytes]";
   }

   public byte[] c() {
      return this.b;
   }
}
