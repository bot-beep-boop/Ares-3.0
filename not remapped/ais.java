import com.google.common.base.Predicate;

public class ais extends afe {
   public static final amk N = amk.a("powered");
   public static final amm<afe.b> b = amm.a("shape", afe.b.class, new Predicate<afe.b>() {
      public boolean a(afe.b var1) {
         return var1 != afe.b.j && var1 != afe.b.i && var1 != afe.b.g && var1 != afe.b.h;
      }

      public boolean apply(Object var1) {
         return this.a((afe.b)var1);
      }
   });

   protected ais() {
      super(true);
      this.j(this.M.b().a(b, afe.b.a).a(N, false));
   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((afe.b)var1.b(b)).a();
      if ((Boolean)var1.b(N)) {
         var3 |= 8;
      }

      return var3;
   }

   protected void b(adm var1, cj var2, alz var3, afh var4) {
      boolean var5 = (Boolean)var3.b(N);
      boolean var6 = var1.z(var2) || this.a(var1, var2, var3, true, 0) || this.a(var1, var2, var3, false, 0);
      if (var6 != var5) {
         var1.a((cj)var2, (alz)var3.a(N, var6), 3);
         var1.c((cj)var2.b(), (afh)this);
         if (((afe.b)var3.b(b)).c()) {
            var1.c((cj)var2.a(), (afh)this);
         }
      }

   }

   protected boolean a(adm var1, cj var2, alz var3, boolean var4, int var5) {
      if (var5 >= 8) {
         return false;
      } else {
         int var6 = var2.n();
         int var7 = var2.o();
         int var8 = var2.p();
         boolean var9 = true;
         afe.b var10 = (afe.b)var3.b(b);
         switch(var10) {
         case a:
            if (var4) {
               ++var8;
            } else {
               --var8;
            }
            break;
         case b:
            if (var4) {
               --var6;
            } else {
               ++var6;
            }
            break;
         case c:
            if (var4) {
               --var6;
            } else {
               ++var6;
               ++var7;
               var9 = false;
            }

            var10 = afe.b.b;
            break;
         case d:
            if (var4) {
               --var6;
               ++var7;
               var9 = false;
            } else {
               ++var6;
            }

            var10 = afe.b.b;
            break;
         case e:
            if (var4) {
               ++var8;
            } else {
               --var8;
               ++var7;
               var9 = false;
            }

            var10 = afe.b.a;
            break;
         case f:
            if (var4) {
               ++var8;
               ++var7;
               var9 = false;
            } else {
               --var8;
            }

            var10 = afe.b.a;
         }

         if (this.a(var1, new cj(var6, var7, var8), var4, var5, var10)) {
            return true;
         } else {
            return var9 && this.a(var1, new cj(var6, var7 - 1, var8), var4, var5, var10);
         }
      }
   }

   protected boolean a(adm var1, cj var2, boolean var3, int var4, afe.b var5) {
      alz var6 = var1.p(var2);
      if (var6.c() != this) {
         return false;
      } else {
         afe.b var7 = (afe.b)var6.b(b);
         if (var5 == afe.b.b && (var7 == afe.b.a || var7 == afe.b.e || var7 == afe.b.f)) {
            return false;
         } else if (var5 == afe.b.a && (var7 == afe.b.b || var7 == afe.b.c || var7 == afe.b.d)) {
            return false;
         } else if ((Boolean)var6.b(N)) {
            return var1.z(var2) ? true : this.a(var1, var2, var6, var3, var4 + 1);
         } else {
            return false;
         }
      }
   }

   protected ama e() {
      return new ama(this, new amo[]{b, N});
   }

   public amo<afe.b> n() {
      return b;
   }

   public alz a(int var1) {
      return this.Q().a(b, afe.b.a(var1 & 7)).a(N, (var1 & 8) > 0);
   }
}
