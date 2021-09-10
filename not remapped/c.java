import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public class c {
   private final String b;
   private final List<c.a> c = Lists.newArrayList();
   private StackTraceElement[] d = new StackTraceElement[0];
   private final b a;

   public void a(String var1, Object var2) {
      this.c.add(new c.a(var1, var2));
   }

   public StackTraceElement[] a() {
      return this.d;
   }

   public void b(int var1) {
      StackTraceElement[] var2 = new StackTraceElement[this.d.length - var1];
      System.arraycopy(this.d, 0, var2, 0, var2.length);
      this.d = var2;
   }

   public static void a(c var0, cj var1, alz var2) {
      var0.a("Block", new Callable<String>(var2) {
         final alz a;

         {
            this.a = var1;
         }

         public String a() throws Exception {
            return this.a.toString();
         }

         public Object call() throws Exception {
            return this.a();
         }
      });
      var0.a("Block location", new Callable<String>(var1) {
         final cj a;

         {
            this.a = var1;
         }

         public Object call() throws Exception {
            return this.a();
         }

         public String a() throws Exception {
            return c.a(this.a);
         }
      });
   }

   public c(b var1, String var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(String var1, Callable<String> var2) {
      try {
         this.a(var1, var2.call());
      } catch (Throwable var4) {
         this.a(var1, var4);
      }

   }

   public void a(StringBuilder var1) {
      var1.append("-- ").append(this.b).append(" --\n");
      var1.append("Details:");
      Iterator var2 = this.c.iterator();

      while(var2.hasNext()) {
         c.a var3 = (c.a)var2.next();
         var1.append("\n\t");
         var1.append(var3.a());
         var1.append(": ");
         var1.append(var3.b());
      }

      if (this.d != null && this.d.length > 0) {
         var1.append("\nStacktrace:");
         StackTraceElement[] var6 = this.d;
         int var7 = var6.length;

         for(int var4 = 0; var4 < var7; ++var4) {
            StackTraceElement var5 = var6[var4];
            var1.append("\n\tat ");
            var1.append(var5.toString());
         }
      }

   }

   public static void a(c var0, cj var1, afh var2, int var3) {
      int var4 = afh.a(var2);
      var0.a("Block type", new Callable<String>(var4, var2) {
         final int a;
         final afh b;

         public Object call() throws Exception {
            return this.a();
         }

         public String a() throws Exception {
            try {
               return String.format("ID #%d (%s // %s)", this.a, this.b.a(), this.b.getClass().getCanonicalName());
            } catch (Throwable var2) {
               return "ID #" + this.a;
            }
         }

         {
            this.a = var1;
            this.b = var2;
         }
      });
      var0.a("Block data value", new Callable<String>(var3) {
         final int a;

         public String a() throws Exception {
            if (this.a < 0) {
               return "Unknown? (Got " + this.a + ")";
            } else {
               String var1 = String.format("%4s", Integer.toBinaryString(this.a)).replace(" ", "0");
               return String.format("%1$d / 0x%1$X / 0b%2$s", this.a, var1);
            }
         }

         public Object call() throws Exception {
            return this.a();
         }

         {
            this.a = var1;
         }
      });
      var0.a("Block location", new Callable<String>(var1) {
         final cj a;

         {
            this.a = var1;
         }

         public String a() throws Exception {
            return c.a(this.a);
         }

         public Object call() throws Exception {
            return this.a();
         }
      });
   }

   public static String a(double var0, double var2, double var4) {
      return String.format("%.2f,%.2f,%.2f - %s", var0, var2, var4, a(new cj(var0, var2, var4)));
   }

   public static String a(cj var0) {
      int var1 = var0.n();
      int var2 = var0.o();
      int var3 = var0.p();
      StringBuilder var4 = new StringBuilder();

      try {
         var4.append(String.format("World: (%d,%d,%d)", var1, var2, var3));
      } catch (Throwable var17) {
         var4.append("(Error finding world loc)");
      }

      var4.append(", ");

      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      try {
         var5 = var1 >> 4;
         var6 = var3 >> 4;
         var7 = var1 & 15;
         var8 = var2 >> 4;
         var9 = var3 & 15;
         var10 = var5 << 4;
         var11 = var6 << 4;
         var12 = (var5 + 1 << 4) - 1;
         var13 = (var6 + 1 << 4) - 1;
         var4.append(String.format("Chunk: (at %d,%d,%d in %d,%d; contains blocks %d,0,%d to %d,255,%d)", var7, var8, var9, var5, var6, var10, var11, var12, var13));
      } catch (Throwable var16) {
         var4.append("(Error finding chunk loc)");
      }

      var4.append(", ");

      try {
         var5 = var1 >> 9;
         var6 = var3 >> 9;
         var7 = var5 << 5;
         var8 = var6 << 5;
         var9 = (var5 + 1 << 5) - 1;
         var10 = (var6 + 1 << 5) - 1;
         var11 = var5 << 9;
         var12 = var6 << 9;
         var13 = (var5 + 1 << 9) - 1;
         int var14 = (var6 + 1 << 9) - 1;
         var4.append(String.format("Region: (%d,%d; contains chunks %d,%d to %d,%d, blocks %d,0,%d to %d,255,%d)", var5, var6, var7, var8, var9, var10, var11, var12, var13, var14));
      } catch (Throwable var15) {
         var4.append("(Error finding world loc)");
      }

      return var4.toString();
   }

   public int a(int var1) {
      StackTraceElement[] var2 = Thread.currentThread().getStackTrace();
      if (var2.length <= 0) {
         return 0;
      } else {
         this.d = new StackTraceElement[var2.length - 3 - var1];
         System.arraycopy(var2, 3 + var1, this.d, 0, this.d.length);
         return this.d.length;
      }
   }

   public void a(String var1, Throwable var2) {
      this.a((String)var1, (Object)var2);
   }

   public boolean a(StackTraceElement var1, StackTraceElement var2) {
      if (this.d.length != 0 && var1 != null) {
         StackTraceElement var3 = this.d[0];
         if (var3.isNativeMethod() == var1.isNativeMethod() && var3.getClassName().equals(var1.getClassName()) && var3.getFileName().equals(var1.getFileName()) && var3.getMethodName().equals(var1.getMethodName())) {
            if (var2 != null != this.d.length > 1) {
               return false;
            } else if (var2 != null && !this.d[1].equals(var2)) {
               return false;
            } else {
               this.d[0] = var1;
               return true;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   static class a {
      private final String a;
      private final String b;

      public String b() {
         return this.b;
      }

      public String a() {
         return this.a;
      }

      public a(String var1, Object var2) {
         this.a = var1;
         if (var2 == null) {
            this.b = "~~NULL~~";
         } else if (var2 instanceof Throwable) {
            Throwable var3 = (Throwable)var2;
            this.b = "~~ERROR~~ " + var3.getClass().getSimpleName() + ": " + var3.getMessage();
         } else {
            this.b = var2.toString();
         }

      }
   }
}
