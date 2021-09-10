import com.google.common.collect.Lists;
import java.util.List;

public class awf extends awd {
   private final List<awf.a> u = Lists.newArrayList();

   protected int b() {
      return this.u.size();
   }

   public int c() {
      return 400;
   }

   private avs a(ave var1, int var2, int var3, avh.a var4) {
      if (var4 == null) {
         return null;
      } else {
         int var5 = var4.c();
         return (avs)(var4.a() ? new awj(var5, var2, var3, var4) : new awe(var5, var2, var3, var4, var1.t.c(var4)));
      }
   }

   public awf.a c(int var1) {
      return (awf.a)this.u.get(var1);
   }

   public awf(ave var1, int var2, int var3, int var4, int var5, int var6, avh.a... var7) {
      super(var1, var2, var3, var4, var5, var6);
      this.k = false;

      for(int var8 = 0; var8 < var7.length; var8 += 2) {
         avh.a var9 = var7[var8];
         avh.a var10 = var8 < var7.length - 1 ? var7[var8 + 1] : null;
         avs var11 = this.a(var1, var2 / 2 - 155, 0, var9);
         avs var12 = this.a(var1, var2 / 2 - 155 + 160, 0, var10);
         this.u.add(new awf.a(var11, var12));
      }

   }

   public awd.a b(int var1) {
      return this.c(var1);
   }

   protected int d() {
      return super.d() + 32;
   }

   public static class a implements awd.a {
      private final avs b;
      private final avs c;
      private final ave a = ave.A();

      public a(avs var1, avs var2) {
         this.b = var1;
         this.c = var2;
      }

      public void a(int var1, int var2, int var3) {
      }

      public void b(int var1, int var2, int var3, int var4, int var5, int var6) {
         if (this.b != null) {
            this.b.a(var2, var3);
         }

         if (this.c != null) {
            this.c.a(var2, var3);
         }

      }

      public boolean a(int var1, int var2, int var3, int var4, int var5, int var6) {
         if (this.b.c(this.a, var2, var3)) {
            if (this.b instanceof awe) {
               this.a.t.a((avh.a)((awe)this.b).c(), 1);
               this.b.j = this.a.t.c(avh.a.a(this.b.k));
            }

            return true;
         } else if (this.c != null && this.c.c(this.a, var2, var3)) {
            if (this.c instanceof awe) {
               this.a.t.a((avh.a)((awe)this.c).c(), 1);
               this.c.j = this.a.t.c(avh.a.a(this.c.k));
            }

            return true;
         } else {
            return false;
         }
      }

      public void a(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
         if (this.b != null) {
            this.b.i = var3;
            this.b.a(this.a, var6, var7);
         }

         if (this.c != null) {
            this.c.i = var3;
            this.c.a(this.a, var6, var7);
         }

      }
   }
}
