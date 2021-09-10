import java.io.IOException;

public class gm implements ff<fj> {
   private float c;
   private int b;
   public static final String[] a = new String[]{"tile.bed.notValid"};

   public float b() {
      return this.c;
   }

   public void a(em var1) throws IOException {
      this.b = var1.readUnsignedByte();
      this.c = var1.readFloat();
   }

   public gm() {
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public void b(em var1) throws IOException {
      var1.writeByte(this.b);
      var1.writeFloat(this.c);
   }

   public int a() {
      return this.b;
   }

   public gm(int var1, float var2) {
      this.b = var1;
      this.c = var2;
   }
}
