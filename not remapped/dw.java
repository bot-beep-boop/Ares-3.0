public class dw {
   private final long b;
   private long c;
   public static final dw a = new dw(0L) {
      public void a(long var1) {
      }
   };

   public dw(long var1) {
      this.b = var1;
   }

   public void a(long var1) {
      this.c += var1 / 8L;
      if (this.c > this.b) {
         throw new RuntimeException("Tried to read NBT tag that was too big; tried to allocate: " + this.c + "bytes where max allowed: " + this.b);
      }
   }
}
