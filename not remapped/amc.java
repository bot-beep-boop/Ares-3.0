import com.google.common.base.Predicate;

public class amc {
   private boolean f;
   private final adm a;
   private final cj b;
   private final boolean c;
   private alz d;
   private akw e;

   public cj d() {
      return this.b;
   }

   public alz a() {
      if (this.d == null && (this.c || this.a.e(this.b))) {
         this.d = this.a.p(this.b);
      }

      return this.d;
   }

   public akw b() {
      if (this.e == null && !this.f) {
         this.e = this.a.s(this.b);
         this.f = true;
      }

      return this.e;
   }

   public amc(adm var1, cj var2, boolean var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public static Predicate<amc> a(Predicate<alz> var0) {
      return new Predicate<amc>(var0) {
         final Predicate a;

         {
            this.a = var1;
         }

         public boolean apply(Object var1) {
            return this.a((amc)var1);
         }

         public boolean a(amc var1) {
            return var1 != null && this.a.apply(var1.a());
         }
      };
   }
}
