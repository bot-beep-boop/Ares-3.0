import java.util.UUID;

public abstract class py extends ps {
   private boolean bm;
   private cj a;
   public static final UUID bk = UUID.fromString("E199AD21-BA8A-4C53-8D13-6182D5C69D3A");
   private rd c;
   private float b;
   public static final qd bl;

   public py(adm var1) {
      super(var1);
      this.a = cj.a;
      this.b = -1.0F;
      this.c = new rp(this, 1.0D);
   }

   protected void ca() {
      super.ca();
      if (this.cc() && this.cd() != null && this.cd().o == this.o) {
         pk var1 = this.cd();
         this.a(new cj((int)var1.s, (int)var1.t, (int)var1.u), 5);
         float var2 = this.g(var1);
         if (this instanceof qa && ((qa)this).cn()) {
            if (var2 > 10.0F) {
               this.a(true, true);
            }

            return;
         }

         if (!this.bm) {
            this.i.a(2, this.c);
            if (this.s() instanceof sv) {
               ((sv)this.s()).a(false);
            }

            this.bm = true;
         }

         this.o(var2);
         if (var2 > 4.0F) {
            this.s().a(var1, 1.0D);
         }

         if (var2 > 6.0F) {
            double var3 = (var1.s - this.s) / (double)var2;
            double var5 = (var1.t - this.t) / (double)var2;
            double var7 = (var1.u - this.u) / (double)var2;
            this.v += var3 * Math.abs(var3) * 0.4D;
            this.w += var5 * Math.abs(var5) * 0.4D;
            this.x += var7 * Math.abs(var7) * 0.4D;
         }

         if (var2 > 10.0F) {
            this.a(true, true);
         }
      } else if (!this.cc() && this.bm) {
         this.bm = false;
         this.i.a(this.c);
         if (this.s() instanceof sv) {
            ((sv)this.s()).a(true);
         }

         this.cj();
      }

   }

   public boolean cg() {
      return this.e(new cj(this));
   }

   public boolean ck() {
      return this.b != -1.0F;
   }

   public float a(cj var1) {
      return 0.0F;
   }

   public boolean cf() {
      return !this.h.m();
   }

   protected void o(float var1) {
   }

   public void cj() {
      this.b = -1.0F;
   }

   public void a(cj var1, int var2) {
      this.a = var1;
      this.b = (float)var2;
   }

   public float ci() {
      return this.b;
   }

   static {
      bl = (new qd(bk, "Fleeing speed bonus", 2.0D, 2)).a(false);
   }

   public boolean bR() {
      return super.bR() && this.a(new cj(this.s, this.aR().b, this.u)) >= 0.0F;
   }

   public boolean e(cj var1) {
      if (this.b == -1.0F) {
         return true;
      } else {
         return this.a.i(var1) < (double)(this.b * this.b);
      }
   }

   public cj ch() {
      return this.a;
   }
}
