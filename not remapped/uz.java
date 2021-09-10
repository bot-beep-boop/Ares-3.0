import java.util.Iterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class uz extends pk {
   private int e;
   private String f;
   private int c;
   private String g;
   private int d;
   private static final Logger b = LogManager.getLogger();
   public float a;

   public void a(zx var1) {
      this.H().b(10, var1);
      this.H().i(10);
   }

   public int o() {
      return this.c;
   }

   public uz(adm var1) {
      super(var1);
      this.e = 5;
      this.a = (float)(Math.random() * 3.141592653589793D * 2.0D);
      this.a(0.25F, 0.25F);
      this.a(new zx(afi.a, 0));
   }

   public void p() {
      this.d = 10;
   }

   public void a(dn var1) {
      this.e = var1.e("Health") & 255;
      this.c = var1.e("Age");
      if (var1.c("PickupDelay")) {
         this.d = var1.e("PickupDelay");
      }

      if (var1.c("Owner")) {
         this.g = var1.j("Owner");
      }

      if (var1.c("Thrower")) {
         this.f = var1.j("Thrower");
      }

      dn var2 = var1.m("Item");
      this.a(zx.a(var2));
      if (this.l() == null) {
         this.J();
      }

   }

   public void d(wn var1) {
      if (!this.o.D) {
         zx var2 = this.l();
         int var3 = var2.b;
         if (this.d == 0 && (this.g == null || 6000 - this.c <= 200 || this.g.equals(var1.e_())) && var1.bi.a(var2)) {
            if (var2.b() == zw.a(afi.r)) {
               var1.b((mw)mr.g);
            }

            if (var2.b() == zw.a(afi.s)) {
               var1.b((mw)mr.g);
            }

            if (var2.b() == zy.aF) {
               var1.b((mw)mr.t);
            }

            if (var2.b() == zy.i) {
               var1.b((mw)mr.w);
            }

            if (var2.b() == zy.bv) {
               var1.b((mw)mr.A);
            }

            if (var2.b() == zy.i && this.n() != null) {
               wn var4 = this.o.a(this.n());
               if (var4 != null && var4 != var1) {
                  var4.b((mw)mr.x);
               }
            }

            if (!this.R()) {
               this.o.a((pk)var1, "random.pop", 0.2F, ((this.V.nextFloat() - this.V.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            }

            var1.a((pk)this, var3);
            if (var2.b <= 0) {
               this.J();
            }
         }

      }
   }

   public void b(dn var1) {
      var1.a("Health", (short)((byte)this.e));
      var1.a("Age", (short)this.c);
      var1.a("PickupDelay", (short)this.d);
      if (this.n() != null) {
         var1.a("Thrower", this.f);
      }

      if (this.m() != null) {
         var1.a("Owner", this.g);
      }

      if (this.l() != null) {
         var1.a((String)"Item", (eb)this.l().b(new dn()));
      }

   }

   public boolean W() {
      if (this.o.a((aug)this.aR(), (arm)arm.h, (pk)this)) {
         if (!this.Y && !this.aa) {
            this.X();
         }

         this.Y = true;
      } else {
         this.Y = false;
      }

      return this.Y;
   }

   private void w() {
      Iterator var1 = this.o.a(uz.class, this.aR().b(0.5D, 0.0D, 0.5D)).iterator();

      while(var1.hasNext()) {
         uz var2 = (uz)var1.next();
         this.a(var2);
      }

   }

   public void j() {
      this.c = 4800;
   }

   protected boolean s_() {
      return false;
   }

   public void v() {
      this.r();
      this.c = 5999;
   }

   public void q() {
      this.d = 0;
   }

   public String m() {
      return this.g;
   }

   public String n() {
      return this.f;
   }

   private boolean a(uz var1) {
      if (var1 == this) {
         return false;
      } else if (var1.ai() && this.ai()) {
         zx var2 = this.l();
         zx var3 = var1.l();
         if (this.d != 32767 && var1.d != 32767) {
            if (this.c != -32768 && var1.c != -32768) {
               if (var3.b() != var2.b()) {
                  return false;
               } else if (var3.n() ^ var2.n()) {
                  return false;
               } else if (var3.n() && !var3.o().equals(var2.o())) {
                  return false;
               } else if (var3.b() == null) {
                  return false;
               } else if (var3.b().k() && var3.i() != var2.i()) {
                  return false;
               } else if (var3.b < var2.b) {
                  return var1.a(this);
               } else if (var3.b + var2.b > var3.c()) {
                  return false;
               } else {
                  var3.b += var2.b;
                  var1.d = Math.max(var1.d, this.d);
                  var1.c = Math.min(var1.c, this.c);
                  var1.a(var3);
                  this.J();
                  return true;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public void c(int var1) {
      super.c(var1);
      if (!this.o.D) {
         this.w();
      }

   }

   public String e_() {
      return this.l_() ? this.aM() : di.a("item." + this.l().a());
   }

   public void a(int var1) {
      this.d = var1;
   }

   public void c(String var1) {
      this.f = var1;
   }

   protected void f(int var1) {
      this.a(ow.a, (float)var1);
   }

   public boolean a(ow var1, float var2) {
      if (this.b((ow)var1)) {
         return false;
      } else if (this.l() != null && this.l().b() == zy.bZ && var1.c()) {
         return false;
      } else {
         this.ac();
         this.e = (int)((float)this.e - var2);
         if (this.e <= 0) {
            this.J();
         }

         return false;
      }
   }

   public void u() {
      this.c = -6000;
   }

   public void t_() {
      if (this.l() == null) {
         this.J();
      } else {
         super.t_();
         if (this.d > 0 && this.d != 32767) {
            --this.d;
         }

         this.p = this.s;
         this.q = this.t;
         this.r = this.u;
         this.w -= 0.03999999910593033D;
         this.T = this.j(this.s, (this.aR().b + this.aR().e) / 2.0D, this.u);
         this.d(this.v, this.w, this.x);
         boolean var1 = (int)this.p != (int)this.s || (int)this.q != (int)this.t || (int)this.r != (int)this.u;
         if (var1 || this.W % 25 == 0) {
            if (this.o.p(new cj(this)).c().t() == arm.i) {
               this.w = 0.20000000298023224D;
               this.v = (double)((this.V.nextFloat() - this.V.nextFloat()) * 0.2F);
               this.x = (double)((this.V.nextFloat() - this.V.nextFloat()) * 0.2F);
               this.a("random.fizz", 0.4F, 2.0F + this.V.nextFloat() * 0.4F);
            }

            if (!this.o.D) {
               this.w();
            }
         }

         float var2 = 0.98F;
         if (this.C) {
            var2 = this.o.p(new cj(ns.c(this.s), ns.c(this.aR().b) - 1, ns.c(this.u))).c().L * 0.98F;
         }

         this.v *= (double)var2;
         this.w *= 0.9800000190734863D;
         this.x *= (double)var2;
         if (this.C) {
            this.w *= -0.5D;
         }

         if (this.c != -32768) {
            ++this.c;
         }

         this.W();
         if (!this.o.D && this.c >= 6000) {
            this.J();
         }

      }
   }

   public void b(String var1) {
      this.g = var1;
   }

   public boolean s() {
      return this.d > 0;
   }

   public boolean aD() {
      return false;
   }

   public uz(adm var1, double var2, double var4, double var6) {
      super(var1);
      this.e = 5;
      this.a = (float)(Math.random() * 3.141592653589793D * 2.0D);
      this.a(0.25F, 0.25F);
      this.b(var2, var4, var6);
      this.y = (float)(Math.random() * 360.0D);
      this.v = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D));
      this.w = 0.20000000298023224D;
      this.x = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D));
   }

   public zx l() {
      zx var1 = this.H().f(10);
      if (var1 == null) {
         if (this.o != null) {
            b.error("Item entity " + this.F() + " has no item?!");
         }

         return new zx(afi.b);
      } else {
         return var1;
      }
   }

   protected void h() {
      this.H().a(10, 5);
   }

   public void r() {
      this.d = 32767;
   }

   public uz(adm var1, double var2, double var4, double var6, zx var8) {
      this(var1, var2, var4, var6);
      this.a(var8);
   }
}
