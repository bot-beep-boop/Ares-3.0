import java.io.IOException;

public class hu implements ff<fj> {
   private long a;
   private long b;

   public void b(em var1) throws IOException {
      var1.writeLong(this.a);
      var1.writeLong(this.b);
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public long a() {
      return this.a;
   }

   public void a(em var1) throws IOException {
      this.a = var1.readLong();
      this.b = var1.readLong();
   }

   public long b() {
      return this.b;
   }

   public hu(long var1, long var3, boolean var5) {
      this.a = var1;
      this.b = var3;
      if (!var5) {
         this.b = -this.b;
         if (this.b == 0L) {
            this.b = -1L;
         }
      }

   }

   public hu() {
   }

   public void a(fj var1) {
      var1.a(this);
   }
}
