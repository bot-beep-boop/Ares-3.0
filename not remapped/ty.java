import com.google.common.base.Predicate;

public class ty extends tq {
   private int b;
   private int bm;
   tf a;
   private int c;

   public tf n() {
      return this.a;
   }

   public void l(boolean var1) {
      byte var2 = this.ac.a(16);
      if (var1) {
         this.ac.b(16, (byte)(var2 | 1));
      } else {
         this.ac.b(16, (byte)(var2 & -2));
      }

   }

   public boolean a(Class<? extends pr> var1) {
      if (this.cn() && wn.class.isAssignableFrom(var1)) {
         return false;
      } else {
         return var1 == vn.class ? false : super.a(var1);
      }
   }

   protected String bp() {
      return "mob.irongolem.death";
   }

   protected int j(int var1) {
      return var1;
   }

   public void m() {
      super.m();
      if (this.c > 0) {
         --this.c;
      }

      if (this.bm > 0) {
         --this.bm;
      }

      if (this.v * this.v + this.x * this.x > 2.500000277905201E-7D && this.V.nextInt(5) == 0) {
         int var1 = ns.c(this.s);
         int var2 = ns.c(this.t - 0.20000000298023224D);
         int var3 = ns.c(this.u);
         alz var4 = this.o.p(new cj(var1, var2, var3));
         afh var5 = var4.c();
         if (var5.t() != arm.a) {
            this.o.a(cy.L, this.s + ((double)this.V.nextFloat() - 0.5D) * (double)this.J, this.aR().b + 0.1D, this.u + ((double)this.V.nextFloat() - 0.5D) * (double)this.J, 4.0D * ((double)this.V.nextFloat() - 0.5D), 0.5D, ((double)this.V.nextFloat() - 0.5D) * 4.0D, afh.f(var4));
         }
      }

   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(3);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.a(zw.a((afh)afi.O), 1, (float)agw.a.b.b());
      }

      var4 = 3 + this.V.nextInt(3);

      for(int var5 = 0; var5 < var4; ++var5) {
         this.a(zy.j, 1);
      }

   }

   protected void E() {
      if (--this.b <= 0) {
         this.b = 70 + this.V.nextInt(50);
         this.a = this.o.ae().a(new cj(this), 32);
         if (this.a == null) {
            this.cj();
         } else {
            cj var1 = this.a.a();
            this.a(var1, (int)((float)this.a.b() * 0.6F));
         }
      }

      super.E();
   }

   protected void a(cj var1, afh var2) {
      this.a("mob.irongolem.walk", 1.0F, 1.0F);
   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("PlayerCreated", this.cn());
   }

   protected void aX() {
      super.aX();
      this.a((qb)vy.a).a(100.0D);
      this.a((qb)vy.d).a(0.25D);
   }

   public void a(byte var1) {
      if (var1 == 4) {
         this.c = 10;
         this.a("mob.irongolem.throw", 1.0F, 1.0F);
      } else if (var1 == 11) {
         this.bm = 400;
      } else {
         super.a(var1);
      }

   }

   public void a(ow var1) {
      if (!this.cn() && this.aN != null && this.a != null) {
         this.a.a(this.aN.e_(), -5);
      }

      super.a(var1);
   }

   public void a(boolean var1) {
      this.bm = var1 ? 400 : 0;
      this.o.a((pk)this, (byte)11);
   }

   protected void h() {
      super.h();
      this.ac.a(16, (byte)0);
   }

   public int cm() {
      return this.bm;
   }

   public void a(dn var1) {
      super.a(var1);
      this.l(var1.n("PlayerCreated"));
   }

   public int cl() {
      return this.c;
   }

   public boolean r(pk var1) {
      this.c = 10;
      this.o.a((pk)this, (byte)4);
      boolean var2 = var1.a(ow.a((pr)this), (float)(7 + this.V.nextInt(15)));
      if (var2) {
         var1.w += 0.4000000059604645D;
         this.a(this, var1);
      }

      this.a("mob.irongolem.throw", 1.0F, 1.0F);
      return var2;
   }

   protected void s(pk var1) {
      if (var1 instanceof vq && !(var1 instanceof vn) && this.bc().nextInt(20) == 0) {
         this.d((pr)var1);
      }

      super.s(var1);
   }

   protected String bo() {
      return "mob.irongolem.hit";
   }

   public ty(adm var1) {
      super(var1);
      this.a(1.4F, 2.9F);
      ((sv)this.s()).a(true);
      this.i.a(1, new rl(this, 1.0D, true));
      this.i.a(2, new rq(this, 0.9D, 32.0F));
      this.i.a(3, new rn(this, 0.6D, true));
      this.i.a(4, new rp(this, 1.0D));
      this.i.a(5, new rt(this));
      this.i.a(6, new rz(this, 0.6D));
      this.i.a(7, new ri(this, wn.class, 6.0F));
      this.i.a(8, new ry(this));
      this.bi.a(1, new sl(this));
      this.bi.a(2, new sm(this, false, new Class[0]));
      this.bi.a(3, new ty.a(this, ps.class, 10, false, true, vq.e));
   }

   public boolean cn() {
      return (this.ac.a(16) & 1) != 0;
   }

   static class a<T extends pr> extends sp<T> {
      public a(py var1, Class<T> var2, int var3, boolean var4, boolean var5, Predicate<? super T> var6) {
         super(var1, var2, var3, var4, var5, var6);
         this.c = new Predicate<T>(this, var6, var1) {
            final ty.a c;
            final Predicate a;
            final py b;

            public boolean a(T var1) {
               if (this.a != null && !this.a.apply(var1)) {
                  return false;
               } else if (var1 instanceof vn) {
                  return false;
               } else {
                  if (var1 instanceof wn) {
                     double var2 = ty.a.a(this.c);
                     if (var1.av()) {
                        var2 *= 0.800000011920929D;
                     }

                     if (var1.ax()) {
                        float var4 = ((wn)var1).bY();
                        if (var4 < 0.1F) {
                           var4 = 0.1F;
                        }

                        var2 *= (double)(0.7F * var4);
                     }

                     if ((double)var1.g(this.b) > var2) {
                        return false;
                     }
                  }

                  return ty.a.a(this.c, var1, false);
               }
            }

            public boolean apply(Object var1) {
               return this.a((pr)var1);
            }

            {
               this.c = var1;
               this.a = var2;
               this.b = var3;
            }
         };
      }

      static boolean a(ty.a var0, pr var1, boolean var2) {
         return var0.a(var1, var2);
      }

      static double a(ty.a var0) {
         return var0.f();
      }
   }
}
