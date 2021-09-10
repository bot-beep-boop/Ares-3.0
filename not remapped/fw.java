import java.io.IOException;

public class fw implements ff<fj> {
   private boolean b;
   private oj a;

   public void a(em var1) throws IOException {
      this.a = oj.a(var1.readUnsignedByte());
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public fw(oj var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   public boolean a() {
      return this.b;
   }

   public oj b() {
      return this.a;
   }

   public void a(fj var1) {
      var1.a(this);
   }

   public void b(em var1) throws IOException {
      var1.writeByte(this.a.a());
   }

   public fw() {
   }
}
