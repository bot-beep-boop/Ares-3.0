import java.util.List;

public class zt extends zs {
   public aaj g(zx var1) {
      return var1.i() == 0 ? aaj.c : aaj.d;
   }

   protected void c(zx var1, adm var2, wn var3) {
      if (!var2.D) {
         var3.c(new pf(pe.x.H, 2400, 0));
      }

      if (var1.i() > 0) {
         if (!var2.D) {
            var3.c(new pf(pe.l.H, 600, 4));
            var3.c(new pf(pe.m.H, 6000, 0));
            var3.c(new pf(pe.n.H, 6000, 0));
         }
      } else {
         super.c(var1, var2, var3);
      }

   }

   public zt(int var1, float var2, boolean var3) {
      super(var1, var2, var3);
      this.a(true);
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      var3.add(new zx(var1, 1, 0));
      var3.add(new zx(var1, 1, 1));
   }

   public boolean f(zx var1) {
      return var1.i() > 0;
   }
}
