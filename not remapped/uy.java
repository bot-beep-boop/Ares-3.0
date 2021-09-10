import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;

public class uy extends pk {
   private boolean e;
   private float h = 2.0F;
   public int a;
   private int g = 40;
   private alz d;
   private boolean f;
   public dn c;
   public boolean b = true;

   public void a(c var1) {
      super.a(var1);
      if (this.d != null) {
         afh var2 = this.d.c();
         var1.a((String)"Immitating block ID", (Object)afh.a(var2));
         var1.a((String)"Immitating block data", (Object)var2.c(this.d));
      }

   }

   public alz l() {
      return this.d;
   }

   public void t_() {
      afh var1 = this.d.c();
      if (var1.t() == arm.a) {
         this.J();
      } else {
         this.p = this.s;
         this.q = this.t;
         this.r = this.u;
         cj var2;
         if (this.a++ == 0) {
            var2 = new cj(this);
            if (this.o.p(var2).c() == var1) {
               this.o.g(var2);
            } else if (!this.o.D) {
               this.J();
               return;
            }
         }

         this.w -= 0.03999999910593033D;
         this.d(this.v, this.w, this.x);
         this.v *= 0.9800000190734863D;
         this.w *= 0.9800000190734863D;
         this.x *= 0.9800000190734863D;
         if (!this.o.D) {
            var2 = new cj(this);
            if (this.C) {
               this.v *= 0.699999988079071D;
               this.x *= 0.699999988079071D;
               this.w *= -0.5D;
               if (this.o.p(var2).c() != afi.M) {
                  this.J();
                  if (!this.e) {
                     if (this.o.a(var1, var2, true, cq.b, (pk)null, (zx)null) && !agr.e(this.o, var2.b()) && this.o.a((cj)var2, (alz)this.d, 3)) {
                        if (var1 instanceof agr) {
                           ((agr)var1).a_(this.o, var2);
                        }

                        if (this.c != null && var1 instanceof agq) {
                           akw var3 = this.o.s(var2);
                           if (var3 != null) {
                              dn var4 = new dn();
                              var3.b(var4);
                              Iterator var5 = this.c.c().iterator();

                              while(var5.hasNext()) {
                                 String var6 = (String)var5.next();
                                 eb var7 = this.c.a(var6);
                                 if (!var6.equals("x") && !var6.equals("y") && !var6.equals("z")) {
                                    var4.a(var6, var7.b());
                                 }
                              }

                              var3.a(var4);
                              var3.p_();
                           }
                        }
                     } else if (this.b && this.o.Q().b("doEntityDrops")) {
                        this.a(new zx(var1, 1, var1.a(this.d)), 0.0F);
                     }
                  }
               }
            } else if (this.a > 100 && !this.o.D && (var2.o() < 1 || var2.o() > 256) || this.a > 600) {
               if (this.b && this.o.Q().b("doEntityDrops")) {
                  this.a(new zx(var1, 1, var1.a(this.d)), 0.0F);
               }

               this.J();
            }
         }

      }
   }

   protected boolean s_() {
      return false;
   }

   public uy(adm var1) {
      super(var1);
   }

   public boolean ad() {
      return !this.I;
   }

   public adm j() {
      return this.o;
   }

   public uy(adm var1, double var2, double var4, double var6, alz var8) {
      super(var1);
      this.d = var8;
      this.k = true;
      this.a(0.98F, 0.98F);
      this.b(var2, var4, var6);
      this.v = 0.0D;
      this.w = 0.0D;
      this.x = 0.0D;
      this.p = var2;
      this.q = var4;
      this.r = var6;
   }

   protected void h() {
   }

   public void e(float var1, float var2) {
      afh var3 = this.d.c();
      if (this.f) {
         int var4 = ns.f(var1 - 1.0F);
         if (var4 > 0) {
            ArrayList var5 = Lists.newArrayList(this.o.b((pk)this, (aug)this.aR()));
            boolean var6 = var3 == afi.cf;
            ow var7 = var6 ? ow.n : ow.o;
            Iterator var8 = var5.iterator();

            while(var8.hasNext()) {
               pk var9 = (pk)var8.next();
               var9.a(var7, (float)Math.min(ns.d((float)var4 * this.h), this.g));
            }

            if (var6 && (double)this.V.nextFloat() < 0.05000000074505806D + (double)var4 * 0.05D) {
               int var10 = (Integer)this.d.b(aez.b);
               ++var10;
               if (var10 > 2) {
                  this.e = true;
               } else {
                  this.d = this.d.a(aez.b, var10);
               }
            }
         }
      }

   }

   protected void b(dn var1) {
      afh var2 = this.d != null ? this.d.c() : afi.a;
      jy var3 = (jy)afh.c.c(var2);
      var1.a("Block", var3 == null ? "" : var3.toString());
      var1.a("Data", (byte)var2.c(this.d));
      var1.a("Time", (byte)this.a);
      var1.a("DropItem", this.b);
      var1.a("HurtEntities", this.f);
      var1.a("FallHurtAmount", this.h);
      var1.a("FallHurtMax", this.g);
      if (this.c != null) {
         var1.a((String)"TileEntityData", (eb)this.c);
      }

   }

   public void a(boolean var1) {
      this.f = var1;
   }

   protected void a(dn var1) {
      int var2 = var1.d("Data") & 255;
      if (var1.b("Block", 8)) {
         this.d = afh.b(var1.j("Block")).a(var2);
      } else if (var1.b("TileID", 99)) {
         this.d = afh.c(var1.f("TileID")).a(var2);
      } else {
         this.d = afh.c(var1.d("Tile") & 255).a(var2);
      }

      this.a = var1.d("Time") & 255;
      afh var3 = this.d.c();
      if (var1.b("HurtEntities", 99)) {
         this.f = var1.n("HurtEntities");
         this.h = var1.h("FallHurtAmount");
         this.g = var1.f("FallHurtMax");
      } else if (var3 == afi.cf) {
         this.f = true;
      }

      if (var1.b("DropItem", 99)) {
         this.b = var1.n("DropItem");
      }

      if (var1.b("TileEntityData", 10)) {
         this.c = var1.m("TileEntityData");
      }

      if (var3 == null || var3.t() == arm.a) {
         this.d = afi.m.Q();
      }

   }

   public boolean aJ() {
      return false;
   }
}
