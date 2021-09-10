import com.google.common.base.Predicate;

public final class po {
   public static final Predicate<pk> a = new Predicate<pk>() {
      public boolean a(pk var1) {
         return var1.ai();
      }

      public boolean apply(Object var1) {
         return this.a((pk)var1);
      }
   };
   public static final Predicate<pk> d = new Predicate<pk>() {
      public boolean a(pk var1) {
         return !(var1 instanceof wn) || !((wn)var1).v();
      }

      public boolean apply(Object var1) {
         return this.a((pk)var1);
      }
   };
   public static final Predicate<pk> b = new Predicate<pk>() {
      public boolean a(pk var1) {
         return var1.ai() && var1.l == null && var1.m == null;
      }

      public boolean apply(Object var1) {
         return this.a((pk)var1);
      }
   };
   public static final Predicate<pk> c = new Predicate<pk>() {
      public boolean a(pk var1) {
         return var1 instanceof og && var1.ai();
      }

      public boolean apply(Object var1) {
         return this.a((pk)var1);
      }
   };

   public static class a implements Predicate<pk> {
      private final zx a;

      public a(zx var1) {
         this.a = var1;
      }

      public boolean apply(Object var1) {
         return this.a((pk)var1);
      }

      public boolean a(pk var1) {
         if (!var1.ai()) {
            return false;
         } else if (!(var1 instanceof pr)) {
            return false;
         } else {
            pr var2 = (pr)var1;
            if (var2.p(ps.c(this.a)) != null) {
               return false;
            } else if (var2 instanceof ps) {
               return ((ps)var2).bY();
            } else if (var2 instanceof um) {
               return true;
            } else {
               return var2 instanceof wn;
            }
         }
      }
   }
}
