import com.google.common.base.Predicate;

public interface vq extends pi {
   Predicate<pk> d = new Predicate<pk>() {
      public boolean a(pk var1) {
         return var1 instanceof vq;
      }

      public boolean apply(Object var1) {
         return this.a((pk)var1);
      }
   };
   Predicate<pk> e = new Predicate<pk>() {
      public boolean apply(Object var1) {
         return this.a((pk)var1);
      }

      public boolean a(pk var1) {
         return var1 instanceof vq && !var1.ax();
      }
   };
}
