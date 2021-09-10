import java.io.IOException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.SecretKey;

public class jm implements ff<jk> {
   private byte[] a = new byte[0];
   private byte[] b = new byte[0];

   public jm(SecretKey var1, PublicKey var2, byte[] var3) {
      this.a = ng.a((Key)var2, (byte[])var1.getEncoded());
      this.b = ng.a((Key)var2, (byte[])var3);
   }

   public jm() {
   }

   public void b(em var1) throws IOException {
      var1.a(this.a);
      var1.a(this.b);
   }

   public byte[] b(PrivateKey var1) {
      return var1 == null ? this.b : ng.b(var1, this.b);
   }

   public SecretKey a(PrivateKey var1) {
      return ng.a(var1, this.a);
   }

   public void a(em var1) throws IOException {
      this.a = var1.a();
      this.b = var1.a();
   }

   public void a(ep var1) {
      this.a((jk)var1);
   }

   public void a(jk var1) {
      var1.a(this);
   }
}
