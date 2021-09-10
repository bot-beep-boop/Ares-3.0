public abstract class qx extends rd {
   boolean d;
   protected cj b;
   float e;
   protected agh c;
   protected ps a;
   float f;

   public qx(ps var1) {
      this.b = cj.a;
      this.a = var1;
      if (!(var1.s() instanceof sv)) {
         throw new IllegalArgumentException("Unsupported mob type for DoorInteractGoal");
      }
   }

   public boolean b() {
      return !this.d;
   }

   private agh a(cj var1) {
      afh var2 = this.a.o.p(var1).c();
      return var2 instanceof agh && var2.t() == arm.d ? (agh)var2 : null;
   }

   public void e() {
      float var1 = (float)((double)((float)this.b.n() + 0.5F) - this.a.s);
      float var2 = (float)((double)((float)this.b.p() + 0.5F) - this.a.u);
      float var3 = this.e * var1 + this.f * var2;
      if (var3 < 0.0F) {
         this.d = true;
      }

   }

   public boolean a() {
      if (!this.a.D) {
         return false;
      } else {
         sv var1 = (sv)this.a.s();
         asx var2 = var1.j();
         if (var2 != null && !var2.b() && var1.g()) {
            for(int var3 = 0; var3 < Math.min(var2.e() + 2, var2.d()); ++var3) {
               asv var4 = var2.a(var3);
               this.b = new cj(var4.a, var4.b + 1, var4.c);
               if (!(this.a.e((double)this.b.n(), this.a.t, (double)this.b.p()) > 2.25D)) {
                  this.c = this.a(this.b);
                  if (this.c != null) {
                     return true;
                  }
               }
            }

            this.b = (new cj(this.a)).a();
            this.c = this.a(this.b);
            return this.c != null;
         } else {
            return false;
         }
      }
   }

   public void c() {
      this.d = false;
      this.e = (float)((double)((float)this.b.n() + 0.5F) - this.a.s);
      this.f = (float)((double)((float)this.b.p() + 0.5F) - this.a.u);
   }
}
