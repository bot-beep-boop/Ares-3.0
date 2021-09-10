import java.util.Random;

public class vz extends vv {
   private vz.b a;

   protected zw A() {
      return null;
   }

   public void t_() {
      this.aI = this.y;
      super.t_();
   }

   public vz(adm var1) {
      super(var1);
      this.a(0.4F, 0.3F);
      this.i.a(1, new ra(this));
      this.i.a(3, this.a = new vz.b(this));
      this.i.a(4, new rl(this, wn.class, 1.0D, false));
      this.i.a(5, new vz.a(this));
      this.bi.a(1, new sm(this, true, new Class[0]));
      this.bi.a(2, new sp(this, wn.class, true));
   }

   public pw bz() {
      return pw.c;
   }

   public float aS() {
      return 0.1F;
   }

   public boolean bR() {
      if (super.bR()) {
         wn var1 = this.o.a(this, 5.0D);
         return var1 == null;
      } else {
         return false;
      }
   }

   public float a(cj var1) {
      return this.o.p(var1.b()).c() == afi.b ? 10.0F : super.a(var1);
   }

   protected String z() {
      return "mob.silverfish.say";
   }

   protected String bp() {
      return "mob.silverfish.kill";
   }

   protected boolean s_() {
      return false;
   }

   public double am() {
      return 0.2D;
   }

   protected void a(cj var1, afh var2) {
      this.a("mob.silverfish.step", 0.15F, 1.0F);
   }

   protected String bo() {
      return "mob.silverfish.hit";
   }

   protected boolean n_() {
      return true;
   }

   protected void aX() {
      super.aX();
      this.a(vy.a).a(8.0D);
      this.a(vy.d).a(0.25D);
      this.a(vy.e).a(1.0D);
   }

   public boolean a(ow var1, float var2) {
      if (this.b(var1)) {
         return false;
      } else {
         if (var1 instanceof ox || var1 == ow.l) {
            this.a.f();
         }

         return super.a(var1, var2);
      }
   }

   static class b extends rd {
      private int b;
      private vz a;

      public void f() {
         if (this.b == 0) {
            this.b = 20;
         }

      }

      public boolean a() {
         return this.b > 0;
      }

      public b(vz var1) {
         this.a = var1;
      }

      public void e() {
         --this.b;
         if (this.b <= 0) {
            adm var1 = this.a.o;
            Random var2 = this.a.bc();
            cj var3 = new cj(this.a);

            for(int var4 = 0; var4 <= 5 && var4 >= -5; var4 = var4 <= 0 ? 1 - var4 : 0 - var4) {
               for(int var5 = 0; var5 <= 10 && var5 >= -10; var5 = var5 <= 0 ? 1 - var5 : 0 - var5) {
                  for(int var6 = 0; var6 <= 10 && var6 >= -10; var6 = var6 <= 0 ? 1 - var6 : 0 - var6) {
                     cj var7 = var3.a(var5, var4, var6);
                     alz var8 = var1.p(var7);
                     if (var8.c() == afi.be) {
                        if (var1.Q().b("mobGriefing")) {
                           var1.b(var7, true);
                        } else {
                           var1.a((cj)var7, (alz)((ahz.a)var8.b(ahz.a)).d(), 3);
                        }

                        if (var2.nextBoolean()) {
                           return;
                        }
                     }
                  }
               }
            }
         }

      }
   }

   static class a extends rz {
      private final vz a;
      private cq b;
      private boolean c;

      public a(vz var1) {
         super(var1, 1.0D, 10);
         this.a = var1;
         this.a(1);
      }

      public boolean b() {
         return this.c ? false : super.b();
      }

      public boolean a() {
         if (this.a.u() != null) {
            return false;
         } else if (!this.a.s().m()) {
            return false;
         } else {
            Random var1 = this.a.bc();
            if (var1.nextInt(10) == 0) {
               this.b = cq.a(var1);
               cj var2 = (new cj(this.a.s, this.a.t + 0.5D, this.a.u)).a(this.b);
               alz var3 = this.a.o.p(var2);
               if (ahz.d(var3)) {
                  this.c = true;
                  return true;
               }
            }

            this.c = false;
            return super.a();
         }
      }

      public void c() {
         if (!this.c) {
            super.c();
         } else {
            adm var1 = this.a.o;
            cj var2 = (new cj(this.a.s, this.a.t + 0.5D, this.a.u)).a(this.b);
            alz var3 = var1.p(var2);
            if (ahz.d(var3)) {
               var1.a((cj)var2, (alz)afi.be.Q().a(ahz.a, ahz.a.a(var3)), 3);
               this.a.y();
               this.a.J();
            }

         }
      }
   }
}
