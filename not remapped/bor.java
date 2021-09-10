import com.google.common.collect.Maps;
import java.util.Map;
import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

public enum bor {
   o(270, 180),
   n(270, 90);

   private final Matrix4f s;
   f(90, 90),
   k(180, 180);

   private final int u;
   j(180, 90),
   b(0, 90),
   i(180, 0);

   private static final Map<Integer, bor> q = Maps.newHashMap();
   l(180, 270);

   private final int t;
   e(90, 0),
   c(0, 180),
   a(0, 0),
   h(90, 270);

   private static final bor[] v = new bor[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p};
   p(270, 270),
   d(0, 270),
   m(270, 0);

   private final int r;
   g(90, 180);

   static {
      bor[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         bor var3 = var0[var2];
         q.put(var3.r, var3);
      }

   }

   private bor(int var3, int var4) {
      this.r = b(var3, var4);
      this.s = new Matrix4f();
      Matrix4f var5 = new Matrix4f();
      var5.setIdentity();
      Matrix4f.rotate((float)(-var3) * 0.017453292F, new Vector3f(1.0F, 0.0F, 0.0F), var5, var5);
      this.t = ns.a(var3 / 90);
      Matrix4f var6 = new Matrix4f();
      var6.setIdentity();
      Matrix4f.rotate((float)(-var4) * 0.017453292F, new Vector3f(0.0F, 1.0F, 0.0F), var6, var6);
      this.u = ns.a(var4 / 90);
      Matrix4f.mul(var6, var5, this.s);
   }

   public cq a(cq var1) {
      cq var2 = var1;

      int var3;
      for(var3 = 0; var3 < this.t; ++var3) {
         var2 = var2.a(cq.a.a);
      }

      if (var2.k() != cq.a.b) {
         for(var3 = 0; var3 < this.u; ++var3) {
            var2 = var2.a(cq.a.b);
         }
      }

      return var2;
   }

   private static int b(int var0, int var1) {
      return var0 * 360 + var1;
   }

   public int a(cq var1, int var2) {
      int var3 = var2;
      if (var1.k() == cq.a.a) {
         var3 = (var2 + this.t) % 4;
      }

      cq var4 = var1;

      for(int var5 = 0; var5 < this.t; ++var5) {
         var4 = var4.a(cq.a.a);
      }

      if (var4.k() == cq.a.b) {
         var3 = (var3 + this.u) % 4;
      }

      return var3;
   }

   public static bor a(int var0, int var1) {
      return (bor)q.get(b(ns.b(var0, 360), ns.b(var1, 360)));
   }

   public Matrix4f a() {
      return this.s;
   }
}
