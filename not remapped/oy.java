public class oy extends ox {
   private pk r;

   public oy(String var1, pk var2, pk var3) {
      super(var1, var2);
      this.r = var3;
   }

   public eu b(pr var1) {
      eu var2 = this.r == null ? this.q.f_() : this.r.f_();
      zx var3 = this.r instanceof pr ? ((pr)this.r).bA() : null;
      String var4 = "death.attack." + this.p;
      String var5 = var4 + ".item";
      return var3 != null && var3.s() && di.c(var5) ? new fb(var5, new Object[]{var1.f_(), var2, var3.C()}) : new fb(var4, new Object[]{var1.f_(), var2});
   }

   public pk j() {
      return this.r;
   }

   public pk i() {
      return this.q;
   }
}
