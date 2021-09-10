public class xb extends wy {
   public xb(adm var1) {
      super(var1);
   }

   protected float j() {
      return 0.7F;
   }

   protected float l() {
      return -20.0F;
   }

   protected void a(auh var1) {
      if (!this.o.D) {
         this.o.b(2002, new cj(this), 0);
         int var2 = 3 + this.o.s.nextInt(5) + this.o.s.nextInt(5);

         while(var2 > 0) {
            int var3 = pp.a(var2);
            var2 -= var3;
            this.o.d((pk)(new pp(this.o, this.s, this.t, this.u, var3)));
         }

         this.J();
      }

   }

   protected float m() {
      return 0.07F;
   }

   public xb(adm var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   public xb(adm var1, pr var2) {
      super(var1, var2);
   }
}
