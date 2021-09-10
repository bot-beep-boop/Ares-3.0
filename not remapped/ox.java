public class ox extends ow {
   protected pk q;
   private boolean r = false;

   public boolean r() {
      return this.q != null && this.q instanceof pr && !(this.q instanceof wn);
   }

   public ox(String var1, pk var2) {
      super(var1);
      this.q = var2;
   }

   public eu b(pr var1) {
      zx var2 = this.q instanceof pr ? ((pr)this.q).bA() : null;
      String var3 = "death.attack." + this.p;
      String var4 = var3 + ".item";
      return var2 != null && var2.s() && di.c(var4) ? new fb(var4, new Object[]{var1.f_(), this.q.f_(), var2.C()}) : new fb(var3, new Object[]{var1.f_(), this.q.f_()});
   }

   public ox v() {
      this.r = true;
      return this;
   }

   public pk j() {
      return this.q;
   }

   public boolean w() {
      return this.r;
   }
}
