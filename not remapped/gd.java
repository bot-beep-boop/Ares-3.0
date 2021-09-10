import java.io.IOException;
import java.util.List;

public class gd implements ff<fj> {
   private int a;
   private zx[] b;

   public int a() {
      return this.a;
   }

   public void b(em var1) throws IOException {
      var1.writeByte(this.a);
      var1.writeShort(this.b.length);
      zx[] var2 = this.b;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         zx var5 = var2[var4];
         var1.a(var5);
      }

   }

   public zx[] b() {
      return this.b;
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public gd() {
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void a(em var1) throws IOException {
      this.a = var1.readUnsignedByte();
      short var2 = var1.readShort();
      this.b = new zx[var2];

      for(int var3 = 0; var3 < var2; ++var3) {
         this.b[var3] = var1.i();
      }

   }

   public gd(int var1, List<zx> var2) {
      this.a = var1;
      this.b = new zx[var2.size()];

      for(int var3 = 0; var3 < this.b.length; ++var3) {
         zx var4 = (zx)var2.get(var3);
         this.b[var3] = var4 == null ? null : var4.k();
      }

   }
}
