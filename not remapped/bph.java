import com.google.common.collect.Lists;
import java.util.List;

public class bph {
   private boolean b;
   private final List<bph.a> a = Lists.newArrayList();
   private bpg c;

   public void a(bpg var1) {
      this.c = var1;
   }

   public bpg c() {
      return this.c;
   }

   public List<bph.a> a() {
      return this.a;
   }

   public void a(boolean var1) {
      this.b = var1;
   }

   public boolean b() {
      return this.b;
   }

   public static class a {
      private bph.a.a e;
      private float c = 1.0F;
      private boolean f;
      private float b = 1.0F;
      private int d = 1;
      private String a;

      public String a() {
         return this.a;
      }

      public a() {
         this.e = bph.a.a.a;
         this.f = false;
      }

      public float c() {
         return this.c;
      }

      public bph.a.a e() {
         return this.e;
      }

      public float b() {
         return this.b;
      }

      public void b(float var1) {
         this.c = var1;
      }

      public boolean f() {
         return this.f;
      }

      public int d() {
         return this.d;
      }

      public void a(String var1) {
         this.a = var1;
      }

      public void a(float var1) {
         this.b = var1;
      }

      public void a(boolean var1) {
         this.f = var1;
      }

      public void a(bph.a.a var1) {
         this.e = var1;
      }

      public void a(int var1) {
         this.d = var1;
      }

      public static enum a {
         private static final bph.a.a[] d = new bph.a.a[]{a, b};
         b("event"),
         a("file");

         private final String c;

         private a(String var3) {
            this.c = var3;
         }

         public static bph.a.a a(String var0) {
            bph.a.a[] var1 = values();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
               bph.a.a var4 = var1[var3];
               if (var4.c.equals(var0)) {
                  return var4;
               }
            }

            return null;
         }
      }
   }
}
