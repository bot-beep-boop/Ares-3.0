public class awb extends avs {
   private String p;
   private final awg.b q;
   private boolean o;

   public void b(boolean var1) {
      this.o = var1;
      this.j = this.c();
      this.q.a(this.k, var1);
   }

   public awb(awg.b var1, int var2, int var3, int var4, String var5, boolean var6) {
      super(var2, var3, var4, 150, 20, "");
      this.p = var5;
      this.o = var6;
      this.j = this.c();
      this.q = var1;
   }

   private String c() {
      return bnq.a(this.p) + ": " + (this.o ? bnq.a("gui.yes") : bnq.a("gui.no"));
   }

   public boolean c(ave var1, int var2, int var3) {
      if (super.c(var1, var2, var3)) {
         this.o = !this.o;
         this.j = this.c();
         this.q.a(this.k, this.o);
         return true;
      } else {
         return false;
      }
   }
}
