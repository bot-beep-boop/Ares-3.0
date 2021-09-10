import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.Validate;

public abstract class un extends pk {
   protected cj a;
   public cq b;
   private int c;

   private double a(int var1) {
      return var1 % 32 == 0 ? 0.5D : 0.0D;
   }

   public boolean j() {
      if (!this.o.a((pk)this, (aug)this.aR()).isEmpty()) {
         return false;
      } else {
         int var1 = Math.max(1, this.l() / 16);
         int var2 = Math.max(1, this.m() / 16);
         cj var3 = this.a.a(this.b.d());
         cq var4 = this.b.f();

         for(int var5 = 0; var5 < var1; ++var5) {
            for(int var6 = 0; var6 < var2; ++var6) {
               cj var7 = var3.a(var4, var5).b(var6);
               afh var8 = this.o.p(var7).c();
               if (!var8.t().a() && !agd.d(var8)) {
                  return false;
               }
            }
         }

         List var9 = this.o.b((pk)this, (aug)this.aR());
         Iterator var10 = var9.iterator();

         pk var11;
         do {
            if (!var10.hasNext()) {
               return true;
            }

            var11 = (pk)var10.next();
         } while(!(var11 instanceof un));

         return false;
      }
   }

   public void t_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      if (this.c++ == 100 && !this.o.D) {
         this.c = 0;
         if (!this.I && !this.j()) {
            this.J();
            this.b((pk)null);
         }
      }

   }

   public void b(dn var1) {
      var1.a("Facing", (byte)this.b.b());
      var1.a("TileX", this.n().n());
      var1.a("TileY", this.n().o());
      var1.a("TileZ", this.n().p());
   }

   public void d(double var1, double var3, double var5) {
      if (!this.o.D && !this.I && var1 * var1 + var3 * var3 + var5 * var5 > 0.0D) {
         this.J();
         this.b((pk)null);
      }

   }

   public void g(double var1, double var3, double var5) {
      if (!this.o.D && !this.I && var1 * var1 + var3 * var3 + var5 * var5 > 0.0D) {
         this.J();
         this.b((pk)null);
      }

   }

   public void a(dn var1) {
      this.a = new cj(var1.f("TileX"), var1.f("TileY"), var1.f("TileZ"));
      cq var2;
      if (var1.b("Direction", 99)) {
         var2 = cq.b(var1.d("Direction"));
         this.a = this.a.a(var2);
      } else if (var1.b("Facing", 99)) {
         var2 = cq.b(var1.d("Facing"));
      } else {
         var2 = cq.b(var1.d("Dir"));
      }

      this.a(var2);
   }

   public void b(double var1, double var3, double var5) {
      this.s = var1;
      this.t = var3;
      this.u = var5;
      cj var7 = this.a;
      this.a = new cj(var1, var3, var5);
      if (!this.a.equals(var7)) {
         this.o();
         this.ai = true;
      }

   }

   private void o() {
      if (this.b != null) {
         double var1 = (double)this.a.n() + 0.5D;
         double var3 = (double)this.a.o() + 0.5D;
         double var5 = (double)this.a.p() + 0.5D;
         double var7 = 0.46875D;
         double var9 = this.a(this.l());
         double var11 = this.a(this.m());
         var1 -= (double)this.b.g() * 0.46875D;
         var5 -= (double)this.b.i() * 0.46875D;
         var3 += var11;
         cq var13 = this.b.f();
         var1 += var9 * (double)var13.g();
         var5 += var9 * (double)var13.i();
         this.s = var1;
         this.t = var3;
         this.u = var5;
         double var14 = (double)this.l();
         double var16 = (double)this.m();
         double var18 = (double)this.l();
         if (this.b.k() == cq.a.c) {
            var18 = 1.0D;
         } else {
            var14 = 1.0D;
         }

         var14 /= 32.0D;
         var16 /= 32.0D;
         var18 /= 32.0D;
         this.a((aug)(new aug(var1 - var14, var3 - var16, var5 - var18, var1 + var14, var3 + var16, var5 + var18)));
      }
   }

   public abstract void b(pk var1);

   protected void a(cq var1) {
      Validate.notNull(var1);
      Validate.isTrue(var1.k().c());
      this.b = var1;
      this.A = this.y = (float)(this.b.b() * 90);
      this.o();
   }

   public abstract int l();

   public abstract int m();

   public boolean l(pk var1) {
      return var1 instanceof wn ? this.a(ow.a((wn)var1), 0.0F) : false;
   }

   protected boolean af() {
      return false;
   }

   public cj n() {
      return this.a;
   }

   protected void h() {
   }

   public cq aP() {
      return this.b;
   }

   public boolean a(ow var1, float var2) {
      if (this.b((ow)var1)) {
         return false;
      } else {
         if (!this.I && !this.o.D) {
            this.J();
            this.ac();
            this.b(var1.j());
         }

         return true;
      }
   }

   public un(adm var1) {
      super(var1);
      this.a(0.5F, 0.5F);
   }

   public boolean ad() {
      return true;
   }

   public un(adm var1, cj var2) {
      this(var1);
      this.a = var2;
   }
}
