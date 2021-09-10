import java.io.IOException;
import java.util.List;

public class gp implements ff<fj> {
   private int[] a;
   private go.a[] c;
   private boolean d;
   private int[] b;

   public int b(int var1) {
      return this.b[var1];
   }

   public int d(int var1) {
      return this.c[var1].b;
   }

   public byte[] c(int var1) {
      return this.c[var1].a;
   }

   public void a(em var1) throws IOException {
      this.d = var1.readBoolean();
      int var2 = var1.e();
      this.a = new int[var2];
      this.b = new int[var2];
      this.c = new go.a[var2];

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         this.a[var3] = var1.readInt();
         this.b[var3] = var1.readInt();
         this.c[var3] = new go.a();
         this.c[var3].b = var1.readShort() & '\uffff';
         this.c[var3].a = new byte[go.a(Integer.bitCount(this.c[var3].b), this.d, true)];
      }

      for(var3 = 0; var3 < var2; ++var3) {
         var1.readBytes(this.c[var3].a);
      }

   }

   public int a() {
      return this.a.length;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public gp(List<amy> var1) {
      int var2 = var1.size();
      this.a = new int[var2];
      this.b = new int[var2];
      this.c = new go.a[var2];
      this.d = !((amy)var1.get(0)).p().t.o();

      for(int var3 = 0; var3 < var2; ++var3) {
         amy var4 = (amy)var1.get(var3);
         go.a var5 = go.a(var4, true, this.d, 65535);
         this.a[var3] = var4.a;
         this.b[var3] = var4.b;
         this.c[var3] = var5;
      }

   }

   public gp() {
   }

   public int a(int var1) {
      return this.a[var1];
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public void b(em var1) throws IOException {
      var1.writeBoolean(this.d);
      var1.b(this.c.length);

      int var2;
      for(var2 = 0; var2 < this.a.length; ++var2) {
         var1.writeInt(this.a[var2]);
         var1.writeInt(this.b[var2]);
         var1.writeShort((short)(this.c[var2].b & '\uffff'));
      }

      for(var2 = 0; var2 < this.a.length; ++var2) {
         var1.writeBytes(this.c[var2].a);
      }

   }
}
