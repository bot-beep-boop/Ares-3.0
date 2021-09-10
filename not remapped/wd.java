import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class wd extends vv implements vx {
   private static final UUID a = UUID.fromString("5CD17E52-A79A-43D3-A529-90FDE04B181E");
   private static final zw[] c;
   private static final qd b;
   private int bm;

   protected void h() {
      super.h();
      this.H().a(21, (byte)0);
   }

   public wd(adm var1) {
      super(var1);
      this.a(0.6F, 1.95F);
      this.i.a(1, new ra(this));
      this.i.a(2, new sa(this, 1.0D, 60, 10.0F));
      this.i.a(2, new rz(this, 1.0D));
      this.i.a(3, new ri(this, wn.class, 8.0F));
      this.i.a(3, new ry(this));
      this.bi.a(1, new sm(this, false, new Class[0]));
      this.bi.a(2, new sp(this, wn.class, true));
   }

   protected float c(ow var1, float var2) {
      var2 = super.c(var1, var2);
      if (var1.j() == this) {
         var2 = 0.0F;
      }

      if (var1.s()) {
         var2 = (float)((double)var2 * 0.15D);
      }

      return var2;
   }

   public void a(byte var1) {
      if (var1 == 15) {
         for(int var2 = 0; var2 < this.V.nextInt(35) + 10; ++var2) {
            this.o.a(cy.r, this.s + this.V.nextGaussian() * 0.12999999523162842D, this.aR().e + 0.5D + this.V.nextGaussian() * 0.12999999523162842D, this.u + this.V.nextGaussian() * 0.12999999523162842D, 0.0D, 0.0D, 0.0D);
         }
      } else {
         super.a(var1);
      }

   }

   protected String bo() {
      return null;
   }

   public void a(pr var1, float var2) {
      if (!this.n()) {
         xc var3 = new xc(this.o, this, 32732);
         double var4 = var1.t + (double)var1.aS() - 1.100000023841858D;
         var3.z -= -20.0F;
         double var6 = var1.s + var1.v - this.s;
         double var8 = var4 - this.t;
         double var10 = var1.u + var1.x - this.u;
         float var12 = ns.a(var6 * var6 + var10 * var10);
         if (var12 >= 8.0F && !var1.a(pe.d)) {
            var3.a(32698);
         } else if (var1.bn() >= 8.0F && !var1.a(pe.u)) {
            var3.a(32660);
         } else if (var12 <= 3.0F && !var1.a(pe.t) && this.V.nextFloat() < 0.25F) {
            var3.a(32696);
         }

         var3.c(var6, var8 + (double)(var12 * 0.2F), var10, 0.75F, 8.0F);
         this.o.d((pk)var3);
      }
   }

   public boolean n() {
      return this.H().a(21) == 1;
   }

   public void a(boolean var1) {
      this.H().b(21, Byte.valueOf((byte)(var1 ? 1 : 0)));
   }

   protected void aX() {
      super.aX();
      this.a(vy.a).a(26.0D);
      this.a(vy.d).a(0.25D);
   }

   protected String z() {
      return null;
   }

   static {
      b = (new qd(a, "Drinking speed penalty", -0.25D, 0)).a(false);
      c = new zw[]{zy.aT, zy.aY, zy.aC, zy.bB, zy.bA, zy.H, zy.y, zy.y};
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(3) + 1;

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = this.V.nextInt(3);
         zw var6 = c[this.V.nextInt(c.length)];
         if (var2 > 0) {
            var5 += this.V.nextInt(var2 + 1);
         }

         for(int var7 = 0; var7 < var5; ++var7) {
            this.a(var6, 1);
         }
      }

   }

   public void m() {
      if (!this.o.D) {
         if (this.n()) {
            if (this.bm-- <= 0) {
               this.a(false);
               zx var6 = this.bA();
               this.c(0, (zx)null);
               if (var6 != null && var6.b() == zy.bz) {
                  List var5 = zy.bz.h(var6);
                  if (var5 != null) {
                     Iterator var3 = var5.iterator();

                     while(var3.hasNext()) {
                        pf var4 = (pf)var3.next();
                        this.c(new pf(var4));
                     }
                  }
               }

               this.a(vy.d).c(b);
            }
         } else {
            short var1 = -1;
            if (this.V.nextFloat() < 0.15F && this.a(arm.h) && !this.a(pe.o)) {
               var1 = 8237;
            } else if (this.V.nextFloat() < 0.15F && this.at() && !this.a(pe.n)) {
               var1 = 16307;
            } else if (this.V.nextFloat() < 0.05F && this.bn() < this.bu()) {
               var1 = 16341;
            } else if (this.V.nextFloat() < 0.25F && this.u() != null && !this.a(pe.c) && this.u().h(this) > 121.0D) {
               var1 = 16274;
            } else if (this.V.nextFloat() < 0.25F && this.u() != null && !this.a(pe.c) && this.u().h(this) > 121.0D) {
               var1 = 16274;
            }

            if (var1 > -1) {
               this.c(0, new zx(zy.bz, 1, var1));
               this.bm = this.bA().l();
               this.a(true);
               qc var2 = this.a(vy.d);
               var2.c(b);
               var2.b(b);
            }
         }

         if (this.V.nextFloat() < 7.5E-4F) {
            this.o.a((pk)this, (byte)15);
         }
      }

      super.m();
   }

   protected String bp() {
      return null;
   }

   public float aS() {
      return 1.62F;
   }
}
