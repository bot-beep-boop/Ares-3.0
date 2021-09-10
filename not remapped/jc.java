import java.io.IOException;

public class jc implements ff<jd> {
   private el d;
   private String b;
   private int c;
   private int a;

   public void a(em var1) throws IOException {
      this.a = var1.e();
      this.b = var1.c(255);
      this.c = var1.readUnsignedShort();
      this.d = el.a(var1.e());
   }

   public jc(int var1, String var2, int var3, el var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public void b(em var1) throws IOException {
      var1.b(this.a);
      var1.a(this.b);
      var1.writeShort(this.c);
      var1.b(this.d.a());
   }

   public jc() {
   }

   public int b() {
      return this.a;
   }

   public el a() {
      return this.d;
   }

   public void a(jd var1) {
      var1.a(this);
   }

   public void a(ep var1) {
      this.a((jd)var1);
   }
}
