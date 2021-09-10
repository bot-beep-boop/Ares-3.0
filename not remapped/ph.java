public abstract class ph extends py {
   private float bn;
   private float bm = -1.0F;
   protected int a;
   protected int c;
   protected int b;

   public ph(adm var1) {
      super(var1);
   }

   public boolean j_() {
      return this.l() < 0;
   }

   public boolean a(wn var1) {
      zx var2 = var1.bi.h();
      if (var2 != null && var2.b() == zy.bJ) {
         if (!this.o.D) {
            Class var3 = pm.a(var2.i());
            if (var3 != null && this.getClass() == var3) {
               ph var4 = this.a(this);
               if (var4 != null) {
                  var4.b(-24000);
                  var4.b(this.s, this.t, this.u, 0.0F, 0.0F);
                  this.o.d((pk)var4);
                  if (var2.s()) {
                     var4.a((String)var2.q());
                  }

                  if (!var1.bA.d) {
                     --var2.b;
                     if (var2.b <= 0) {
                        var1.bi.a(var1.bi.c, (zx)null);
                     }
                  }
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   protected void h() {
      super.h();
      this.ac.a(12, (byte)0);
   }

   protected final void a(float var1) {
      super.a(this.bm * var1, this.bn * var1);
   }

   public void a(int var1, boolean var2) {
      int var3 = this.l();
      int var4 = var3;
      var3 += var1 * 20;
      if (var3 > 0) {
         var3 = 0;
         if (var4 < 0) {
            this.n();
         }
      }

      int var5 = var3 - var4;
      this.b(var3);
      if (var2) {
         this.b += var5;
         if (this.c == 0) {
            this.c = 40;
         }
      }

      if (this.l() == 0) {
         this.b(this.b);
      }

   }

   public void a(dn var1) {
      super.a(var1);
      this.b(var1.f("Age"));
      this.b = var1.f("ForcedAge");
   }

   protected final void a(float var1, float var2) {
      boolean var3 = this.bm > 0.0F;
      this.bm = var1;
      this.bn = var2;
      if (!var3) {
         this.a(1.0F);
      }

   }

   public void a(int var1) {
      this.a(var1, false);
   }

   public int l() {
      return this.o.D ? this.ac.a(12) : this.a;
   }

   protected void n() {
   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("Age", this.l());
      var1.a("ForcedAge", this.b);
   }

   public void m() {
      super.m();
      if (this.o.D) {
         if (this.c > 0) {
            if (this.c % 4 == 0) {
               this.o.a(cy.v, this.s + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, this.t + 0.5D + (double)(this.V.nextFloat() * this.K), this.u + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, 0.0D, 0.0D, 0.0D);
            }

            --this.c;
         }

         this.a(this.j_());
      } else {
         int var1 = this.l();
         if (var1 < 0) {
            ++var1;
            this.b(var1);
            if (var1 == 0) {
               this.n();
            }
         } else if (var1 > 0) {
            --var1;
            this.b(var1);
         }
      }

   }

   public void b(int var1) {
      this.ac.b(12, (byte)ns.a(var1, -1, 1));
      this.a = var1;
      this.a(this.j_());
   }

   public void a(boolean var1) {
      this.a(var1 ? 0.5F : 1.0F);
   }

   public abstract ph a(ph var1);
}
