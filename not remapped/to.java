public class to extends tm {
   protected void aX() {
      super.aX();
      this.a((qb)vy.a).a(10.0D);
      this.a((qb)vy.d).a(0.20000000298023224D);
   }

   public ph a(ph var1) {
      return this.b(var1);
   }

   protected float bB() {
      return 0.4F;
   }

   protected void a(cj var1, afh var2) {
      this.a("mob.cow.step", 0.15F, 1.0F);
   }

   protected String z() {
      return "mob.cow.say";
   }

   public float aS() {
      return this.K;
   }

   protected String bo() {
      return "mob.cow.hurt";
   }

   public boolean a(wn var1) {
      zx var2 = var1.bi.h();
      if (var2 != null && var2.b() == zy.aw && !var1.bA.d && !this.j_()) {
         if (var2.b-- == 1) {
            var1.bi.a(var1.bi.c, new zx(zy.aG));
         } else if (!var1.bi.a(new zx(zy.aG))) {
            var1.a(new zx(zy.aG, 1, 0), false);
         }

         return true;
      } else {
         return super.a(var1);
      }
   }

   protected zw A() {
      return zy.aF;
   }

   public to b(ph var1) {
      return new to(this.o);
   }

   protected String bp() {
      return "mob.cow.hurt";
   }

   public to(adm var1) {
      super(var1);
      this.a(0.9F, 1.3F);
      ((sv)this.s()).a(true);
      this.i.a(0, new ra(this));
      this.i.a(1, new rv(this, 2.0D));
      this.i.a(2, new qv(this, 1.0D));
      this.i.a(3, new sh(this, 1.25D, zy.O, false));
      this.i.a(4, new rc(this, 1.25D));
      this.i.a(5, new rz(this, 1.0D));
      this.i.a(6, new ri(this, wn.class, 6.0F));
      this.i.a(7, new ry(this));
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(3) + this.V.nextInt(1 + var2);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.a(zy.aF, 1);
      }

      var3 = this.V.nextInt(3) + 1 + this.V.nextInt(1 + var2);

      for(var4 = 0; var4 < var3; ++var4) {
         if (this.at()) {
            this.a(zy.bj, 1);
         } else {
            this.a(zy.bi, 1);
         }
      }

   }
}
