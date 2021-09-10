import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ea extends eb {
   private String b;

   void a(DataInput var1, int var2, dw var3) throws IOException {
      var3.a(288L);
      this.b = var1.readUTF();
      var3.a((long)(16 * this.b.length()));
   }

   void a(DataOutput var1) throws IOException {
      var1.writeUTF(this.b);
   }

   public ea(String var1) {
      this.b = var1;
      if (var1 == null) {
         throw new IllegalArgumentException("Empty string not allowed");
      }
   }

   public int hashCode() {
      return super.hashCode() ^ this.b.hashCode();
   }

   public eb b() {
      return new ea(this.b);
   }

   public boolean c_() {
      return this.b.isEmpty();
   }

   public String a_() {
      return this.b;
   }

   public String toString() {
      return "\"" + this.b.replace("\"", "\\\"") + "\"";
   }

   public ea() {
      this.b = "";
   }

   public boolean equals(Object var1) {
      if (!super.equals(var1)) {
         return false;
      } else {
         ea var2 = (ea)var1;
         return this.b == null && var2.b == null || this.b != null && this.b.equals(var2.b);
      }
   }

   public byte a() {
      return 8;
   }
}
