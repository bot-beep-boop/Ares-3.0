import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.apache.logging.log4j.Logger;

public class g {
   public static <V> V a(FutureTask<V> var0, Logger var1) {
      try {
         var0.run();
         return var0.get();
      } catch (ExecutionException var3) {
         var1.fatal("Error executing task", var3);
      } catch (InterruptedException var4) {
         var1.fatal("Error executing task", var4);
      }

      return null;
   }

   public static g.a a() {
      String var0 = System.getProperty("os.name").toLowerCase();
      if (var0.contains("win")) {
         return g.a.c;
      } else if (var0.contains("mac")) {
         return g.a.d;
      } else if (var0.contains("solaris")) {
         return g.a.b;
      } else if (var0.contains("sunos")) {
         return g.a.b;
      } else if (var0.contains("linux")) {
         return g.a.a;
      } else {
         return var0.contains("unix") ? g.a.a : g.a.e;
      }
   }

   public static enum a {
      private static final g.a[] f = new g.a[]{a, b, c, d, e};
      e,
      d,
      b,
      c,
      a;
   }
}
