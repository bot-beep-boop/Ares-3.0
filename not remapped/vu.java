public class vu extends wb {
   protected void ch() {
      this.a *= 0.9F;
   }

   protected cy n() {
      return cy.A;
   }

   protected wb cf() {
      return new vu(this.o);
   }

   protected void bH() {
      this.w = (double)(0.22F + (float)this.cm() * 0.05F);
      this.ai = true;
   }

   protected int cj() {
      return super.cj() + 2;
   }

   public boolean bR() {
      return this.o.aa() != oj.a;
   }

   public float c(float var1) {
      return 1.0F;
   }

   protected int cg() {
      return super.cg() * 4;
   }

   public int b(float var1) {
      return 15728880;
   }

   protected void aX() {
      super.aX();
      this.a(vy.d).a(0.20000000298023224D);
   }

   protected void bF() {
      this.w = (double)(0.42F + (float)this.cm() * 0.1F);
      this.ai = true;
   }

   public boolean at() {
      return false;
   }

   public boolean bS() {
      return this.o.a((aug)this.aR(), (pk)this) && this.o.a((pk)this, (aug)this.aR()).isEmpty() && !this.o.d(this.aR());
   }

   public vu(adm var1) {
      super(var1);
      this.ab = true;
   }

   protected zw A() {
      return zy.bE;
   }

   protected boolean ci() {
      return true;
   }

   public int br() {
      return this.cm() * 3;
   }

   protected String ck() {
      return this.cm() > 1 ? "mob.magmacube.big" : "mob.magmacube.small";
   }

   protected void b(boolean var1, int var2) {
      zw var3 = this.A();
      if (var3 != null && this.cm() > 1) {
         int var4 = this.V.nextInt(4) - 2;
         if (var2 > 0) {
            var4 += this.V.nextInt(var2 + 1);
         }

         for(int var5 = 0; var5 < var4; ++var5) {
            this.a(var3, 1);
         }
      }

   }

   protected boolean cl() {
      return true;
   }

   public void e(float var1, float var2) {
   }
}
