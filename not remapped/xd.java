public class xd extends ws {
   protected void h() {
      this.ac.a(10, (byte)0);
   }

   public boolean l() {
      return this.ac.a(10) == 1;
   }

   public xd(adm var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      super(var1, var2, var4, var6, var8, var10, var12);
      this.a(0.3125F, 0.3125F);
   }

   protected float j() {
      return this.l() ? 0.73F : super.j();
   }

   public void a(boolean var1) {
      this.ac.b(10, Byte.valueOf((byte)(var1 ? 1 : 0)));
   }

   public xd(adm var1, pr var2, double var3, double var5, double var7) {
      super(var1, var2, var3, var5, var7);
      this.a(0.3125F, 0.3125F);
   }

   public float a(adi var1, adm var2, cj var3, alz var4) {
      float var5 = super.a(var1, var2, var3, var4);
      afh var6 = var4.c();
      if (this.l() && uk.a(var6)) {
         var5 = Math.min(0.8F, var5);
      }

      return var5;
   }

   public boolean ad() {
      return false;
   }

   public boolean a(ow var1, float var2) {
      return false;
   }

   public xd(adm var1) {
      super(var1);
      this.a(0.3125F, 0.3125F);
   }

   public boolean at() {
      return false;
   }

   protected void a(auh var1) {
      if (!this.o.D) {
         if (var1.d != null) {
            if (this.a != null) {
               if (var1.d.a(ow.a(this.a), 8.0F)) {
                  if (!var1.d.ai()) {
                     this.a.h(5.0F);
                  } else {
                     this.a(this.a, var1.d);
                  }
               }
            } else {
               var1.d.a(ow.l, 5.0F);
            }

            if (var1.d instanceof pr) {
               byte var2 = 0;
               if (this.o.aa() == oj.c) {
                  var2 = 10;
               } else if (this.o.aa() == oj.d) {
                  var2 = 40;
               }

               if (var2 > 0) {
                  ((pr)var1.d).c(new pf(pe.v.H, 20 * var2, 1));
               }
            }
         }

         this.o.a(this, this.s, this.t, this.u, 1.0F, false, this.o.Q().b("mobGriefing"));
         this.J();
      }

   }
}
