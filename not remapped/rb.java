public class rb extends rd {
   private qa d;
   private boolean i;
   private double f;
   float b;
   private int h;
   adm a;
   private pr e;
   float c;
   private sw g;

   public boolean b() {
      return !this.g.m() && this.d.h(this.e) > (double)(this.b * this.b) && !this.d.cn();
   }

   public void c() {
      this.h = 0;
      this.i = ((sv)this.d.s()).e();
      ((sv)this.d.s()).a(false);
   }

   public void d() {
      this.e = null;
      this.g.n();
      ((sv)this.d.s()).a(true);
   }

   public boolean a() {
      pr var1 = this.d.co();
      if (var1 == null) {
         return false;
      } else if (var1 instanceof wn && ((wn)var1).v()) {
         return false;
      } else if (this.d.cn()) {
         return false;
      } else if (this.d.h(var1) < (double)(this.c * this.c)) {
         return false;
      } else {
         this.e = var1;
         return true;
      }
   }

   private boolean a(cj var1) {
      alz var2 = this.a.p(var1);
      afh var3 = var2.c();
      if (var3 == afi.a) {
         return true;
      } else {
         return !var3.d();
      }
   }

   public rb(qa var1, double var2, float var4, float var5) {
      this.d = var1;
      this.a = var1.o;
      this.f = var2;
      this.g = var1.s();
      this.c = var4;
      this.b = var5;
      this.a(3);
      if (!(var1.s() instanceof sv)) {
         throw new IllegalArgumentException("Unsupported mob type for FollowOwnerGoal");
      }
   }

   public void e() {
      this.d.p().a(this.e, 10.0F, (float)this.d.bQ());
      if (!this.d.cn()) {
         if (--this.h <= 0) {
            this.h = 10;
            if (!this.g.a((pk)this.e, this.f)) {
               if (!this.d.cc()) {
                  if (!(this.d.h(this.e) < 144.0D)) {
                     int var1 = ns.c(this.e.s) - 2;
                     int var2 = ns.c(this.e.u) - 2;
                     int var3 = ns.c(this.e.aR().b);

                     for(int var4 = 0; var4 <= 4; ++var4) {
                        for(int var5 = 0; var5 <= 4; ++var5) {
                           if ((var4 < 1 || var5 < 1 || var4 > 3 || var5 > 3) && adm.a((adq)this.a, (cj)(new cj(var1 + var4, var3 - 1, var2 + var5))) && this.a(new cj(var1 + var4, var3, var2 + var5)) && this.a(new cj(var1 + var4, var3 + 1, var2 + var5))) {
                              this.d.b((double)((float)(var1 + var4) + 0.5F), (double)var3, (double)((float)(var2 + var5) + 0.5F), this.d.y, this.d.z);
                              this.g.n();
                              return;
                           }
                        }
                     }

                  }
               }
            }
         }
      }
   }
}
