import java.util.Iterator;
import java.util.List;

public class xc extends wy {
   private zx c;

   protected float l() {
      return -20.0F;
   }

   public xc(adm var1, double var2, double var4, double var6, int var8) {
      this(var1, var2, var4, var6, new zx(zy.bz, 1, var8));
   }

   public xc(adm var1, pr var2, zx var3) {
      super(var1, var2);
      this.c = var3;
   }

   public int o() {
      if (this.c == null) {
         this.c = new zx(zy.bz, 1, 0);
      }

      return this.c.i();
   }

   public void b(dn var1) {
      super.b(var1);
      if (this.c != null) {
         var1.a((String)"Potion", (eb)this.c.b(new dn()));
      }

   }

   protected float m() {
      return 0.05F;
   }

   public void a(int var1) {
      if (this.c == null) {
         this.c = new zx(zy.bz, 1, 0);
      }

      this.c.b(var1);
   }

   protected float j() {
      return 0.5F;
   }

   public xc(adm var1, pr var2, int var3) {
      this(var1, var2, new zx(zy.bz, 1, var3));
   }

   public xc(adm var1, double var2, double var4, double var6, zx var8) {
      super(var1, var2, var4, var6);
      this.c = var8;
   }

   public xc(adm var1) {
      super(var1);
   }

   public void a(dn var1) {
      super.a(var1);
      if (var1.b("Potion", 10)) {
         this.c = zx.a(var1.m("Potion"));
      } else {
         this.a(var1.f("potionValue"));
      }

      if (this.c == null) {
         this.J();
      }

   }

   protected void a(auh var1) {
      if (!this.o.D) {
         List var2 = zy.bz.h(this.c);
         if (var2 != null && !var2.isEmpty()) {
            aug var3 = this.aR().b(4.0D, 2.0D, 4.0D);
            List var4 = this.o.a(pr.class, var3);
            if (!var4.isEmpty()) {
               Iterator var5 = var4.iterator();

               label63:
               while(true) {
                  pr var6;
                  double var7;
                  do {
                     if (!var5.hasNext()) {
                        break label63;
                     }

                     var6 = (pr)var5.next();
                     var7 = this.h(var6);
                  } while(!(var7 < 16.0D));

                  double var9 = 1.0D - Math.sqrt(var7) / 4.0D;
                  if (var6 == var1.d) {
                     var9 = 1.0D;
                  }

                  Iterator var11 = var2.iterator();

                  while(var11.hasNext()) {
                     pf var12 = (pf)var11.next();
                     int var13 = var12.a();
                     if (pe.a[var13].b()) {
                        pe.a[var13].a(this, this.n(), var6, var12.c(), var9);
                     } else {
                        int var14 = (int)(var9 * (double)var12.b() + 0.5D);
                        if (var14 > 20) {
                           var6.c(new pf(var13, var14, var12.c()));
                        }
                     }
                  }
               }
            }
         }

         this.o.b(2002, new cj(this), this.o());
         this.J();
      }

   }
}
