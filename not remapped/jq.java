import java.io.IOException;

public class jq implements ff<jp> {
   private long a;

   public void a(em var1) throws IOException {
      this.a = var1.readLong();
   }

   public void a(jp var1) {
      var1.a(this);
   }

   public jq() {
   }

   public void b(em var1) throws IOException {
      var1.writeLong(this.a);
   }

   public jq(long var1) {
      this.a = var1;
   }

   public void a(ep var1) {
      this.a((jp)var1);
   }
}
