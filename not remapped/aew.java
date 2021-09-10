public class aew extends aeb {
   protected aot M;

   public aew() {
      this.M = new apq(afi.bH);
   }

   protected void a(ady var1) {
      this.a();
      if (this.b.nextInt(5) == 0) {
         int var2 = this.b.nextInt(16) + 8;
         int var3 = this.b.nextInt(16) + 8;
         this.M.b(this.a, this.b, this.a.r(this.c.a(var2, 0, var3)));
      }

      if (this.c.n() == 0 && this.c.p() == 0) {
         ug var4 = new ug(this.a);
         var4.b(0.0D, 128.0D, 0.0D, this.b.nextFloat() * 360.0F, 0.0F);
         this.a.d((pk)var4);
      }

   }
}
