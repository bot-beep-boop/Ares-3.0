import java.io.IOException;

public class ju implements ff<jt> {
   private long a;

   public ju(long var1) {
      this.a = var1;
   }

   public long a() {
      return this.a;
   }

   public void a(ep var1) {
      this.a((jt)var1);
   }

   public void a(jt var1) {
      var1.a(this);
   }

   public void a(em var1) throws IOException {
      this.a = var1.readLong();
   }

   public void b(em var1) throws IOException {
      var1.writeLong(this.a);
   }

   public ju() {
   }
}
