import java.util.Arrays;
import org.apache.commons.lang3.ArrayUtils;

public class ayi extends awd {
   private int x = 0;
   private final ave v;
   private final ayj u;
   private final awd.a[] w;

   public ayi(ayj var1, ave var2) {
      super(var2, var1.l, var1.m, 63, var1.m - 32, 20);
      this.u = var1;
      this.v = var2;
      avb[] var3 = (avb[])ArrayUtils.clone(var2.t.ax);
      this.w = new awd.a[var3.length + avb.c().size()];
      Arrays.sort(var3);
      int var4 = 0;
      String var5 = null;
      avb[] var6 = var3;
      int var7 = var3.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         avb var9 = var6[var8];
         String var10 = var9.e();
         if (!var10.equals(var5)) {
            var5 = var10;
            this.w[var4++] = new ayi.a(this, var10);
         }

         int var11 = var2.k.a(bnq.a(var9.g()));
         if (var11 > this.x) {
            this.x = var11;
         }

         this.w[var4++] = new ayi.b(this, var9);
      }

   }

   public awd.a b(int var1) {
      return this.w[var1];
   }

   static ayj b(ayi var0) {
      return var0.u;
   }

   static int c(ayi var0) {
      return var0.x;
   }

   protected int d() {
      return super.d() + 15;
   }

   protected int b() {
      return this.w.length;
   }

   static ave a(ayi var0) {
      return var0.v;
   }

   public int c() {
      return super.c() + 32;
   }

   public class b implements awd.a {
      private final avs d;
      final ayi a;
      private final avs e;
      private final String c;
      private final avb b;

      public boolean a(int var1, int var2, int var3, int var4, int var5, int var6) {
         if (this.d.c(ayi.a(this.a), var2, var3)) {
            ayi.b(this.a).f = this.b;
            return true;
         } else if (this.e.c(ayi.a(this.a), var2, var3)) {
            ayi.a(this.a).t.a(this.b, this.b.h());
            avb.b();
            return true;
         } else {
            return false;
         }
      }

      b(ayi var1, avb var2, Object var3) {
         this(var1, var2);
      }

      public void a(int var1, int var2, int var3) {
      }

      public void a(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
         boolean var9 = ayi.b(this.a).f == this.b;
         ayi.a(this.a).k.a(this.c, var2 + 90 - ayi.c(this.a), var3 + var5 / 2 - ayi.a(this.a).k.a / 2, 16777215);
         this.e.h = var2 + 190;
         this.e.i = var3;
         this.e.l = this.b.i() != this.b.h();
         this.e.a(ayi.a(this.a), var6, var7);
         this.d.h = var2 + 105;
         this.d.i = var3;
         this.d.j = avh.c(this.b.i());
         boolean var10 = false;
         if (this.b.i() != 0) {
            avb[] var11 = ayi.a(this.a).t.ax;
            int var12 = var11.length;

            for(int var13 = 0; var13 < var12; ++var13) {
               avb var14 = var11[var13];
               if (var14 != this.b && var14.i() == this.b.i()) {
                  var10 = true;
                  break;
               }
            }
         }

         if (var9) {
            this.d.j = .a.p + "> " + .a.o + this.d.j + .a.p + " <";
         } else if (var10) {
            this.d.j = .a.m + this.d.j;
         }

         this.d.a(ayi.a(this.a), var6, var7);
      }

      public void b(int var1, int var2, int var3, int var4, int var5, int var6) {
         this.d.a(var2, var3);
         this.e.a(var2, var3);
      }

      private b(ayi var1, avb var2) {
         this.a = var1;
         this.b = var2;
         this.c = bnq.a(var2.g());
         this.d = new avs(0, 0, 0, 75, 20, bnq.a(var2.g()));
         this.e = new avs(0, 0, 0, 50, 20, bnq.a("controls.reset"));
      }
   }

   public class a implements awd.a {
      private final String b;
      final ayi a;
      private final int c;

      public a(ayi var1, String var2) {
         this.a = var1;
         this.b = bnq.a(var2);
         this.c = ayi.a(var1).k.a(this.b);
      }

      public void a(int var1, int var2, int var3) {
      }

      public boolean a(int var1, int var2, int var3, int var4, int var5, int var6) {
         return false;
      }

      public void a(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
         ayi.a(this.a).k.a(this.b, ayi.a(this.a).m.l / 2 - this.c / 2, var3 + var5 - ayi.a(this.a).k.a - 1, 16777215);
      }

      public void b(int var1, int var2, int var3, int var4, int var5, int var6) {
      }
   }
}
