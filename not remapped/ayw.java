import java.util.Collection;
import java.util.Iterator;

public abstract class ayw extends ayl {
   private boolean u;

   public void a(int var1, int var2, float var3) {
      super.a(var1, var2, var3);
      if (this.u) {
         this.f();
      }

   }

   public void b() {
      super.b();
      this.a();
   }

   protected void a() {
      if (!this.j.h.bl().isEmpty()) {
         this.i = 160 + (this.l - this.f - 200) / 2;
         this.u = true;
      } else {
         this.i = (this.l - this.f) / 2;
         this.u = false;
      }

   }

   public ayw(xi var1) {
      super(var1);
   }

   private void f() {
      int var1 = this.i - 124;
      int var2 = this.r;
      boolean var3 = true;
      Collection var4 = this.j.h.bl();
      if (!var4.isEmpty()) {
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         bfl.f();
         int var5 = 33;
         if (var4.size() > 5) {
            var5 = 132 / (var4.size() - 1);
         }

         for(Iterator var6 = this.j.h.bl().iterator(); var6.hasNext(); var2 += var5) {
            pf var7 = (pf)var6.next();
            pe var8 = pe.a[var7.a()];
            bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
            this.j.P().a(a);
            this.b(var1, var2, 0, 166, 140, 32);
            if (var8.e()) {
               int var9 = var8.f();
               this.b(var1 + 6, var2 + 7, 0 + var9 % 8 * 18, 198 + var9 / 8 * 18, 18, 18);
            }

            String var11 = bnq.a(var8.a());
            if (var7.c() == 1) {
               var11 = var11 + " " + bnq.a("enchantment.level.2");
            } else if (var7.c() == 2) {
               var11 = var11 + " " + bnq.a("enchantment.level.3");
            } else if (var7.c() == 3) {
               var11 = var11 + " " + bnq.a("enchantment.level.4");
            }

            this.q.a(var11, (float)(var1 + 10 + 18), (float)(var2 + 6), 16777215);
            String var10 = pe.a(var7);
            this.q.a(var10, (float)(var1 + 10 + 18), (float)(var2 + 6 + 10), 8355711);
         }

      }
   }
}
