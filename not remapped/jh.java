import java.io.IOException;
import java.security.PublicKey;

public class jh implements ff<jf> {
   private byte[] c;
   private String a;
   private PublicKey b;

   public void a(em var1) throws IOException {
      this.a = var1.c(20);
      this.b = ng.a(var1.a());
      this.c = var1.a();
   }

   public jh() {
   }

   public jh(String var1, PublicKey var2, byte[] var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void b(em var1) throws IOException {
      var1.a(this.a);
      var1.a(this.b.getEncoded());
      var1.a(this.c);
   }

   public PublicKey b() {
      return this.b;
   }

   public byte[] c() {
      return this.c;
   }

   public String a() {
      return this.a;
   }

   public void a(jf var1) {
      var1.a(this);
   }

   public void a(ep var1) {
      this.a((jf)var1);
   }
}
