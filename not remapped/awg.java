import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class awg extends awd {
   private final List<awg.d> u = Lists.newArrayList();
   private final awg.f[][] x;
   private final nm<avp> v = new nm();
   private awg.b z;
   private int y;
   private final List<avw> w = Lists.newArrayList();
   private avp A;

   public void i() {
      if (this.y < this.x.length - 1) {
         this.c(this.y + 1);
      }

   }

   public awd.a b(int var1) {
      return this.e(var1);
   }

   private void e(int var1, int var2) {
      awg.f[] var3 = this.x[var1];
      int var4 = var3.length;

      int var5;
      awg.f var6;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3[var5];
         if (var6 != null) {
            this.a((avp)this.v.a(var6.b()), false);
         }
      }

      var3 = this.x[var2];
      var4 = var3.length;

      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3[var5];
         if (var6 != null) {
            this.a((avp)this.v.a(var6.b()), true);
         }
      }

   }

   public avp d(int var1) {
      return (avp)this.v.a(var1);
   }

   public int c() {
      return 400;
   }

   private avy a(int var1, int var2, awg.e var3, boolean var4) {
      avy var5;
      if (var4) {
         var5 = new avy(this.a.k, var3.b(), var1, var2, this.b - var1 * 2, 20, -1);
      } else {
         var5 = new avy(this.a.k, var3.b(), var1, var2, 150, 20, -1);
      }

      var5.j = var3.d();
      var5.a(var3.c());
      var5.a();
      return var5;
   }

   private avw a(int var1, int var2, awg.c var3) {
      avw var4 = new avw(var3.b(), this.a.k, var1, var2, 150, 20);
      var4.a(var3.c());
      var4.a(this.z);
      var4.e(var3.d());
      var4.a(var3.a());
      return var4;
   }

   private awb a(int var1, int var2, awg.a var3) {
      awb var4 = new awb(this.z, var3.b(), var1, var2, var3.c(), var3.a());
      var4.m = var3.d();
      return var4;
   }

   public awg(ave var1, int var2, int var3, int var4, int var5, int var6, awg.b var7, awg.f[]... var8) {
      super(var1, var2, var3, var4, var5, var6);
      this.z = var7;
      this.x = var8;
      this.k = false;
      this.s();
      this.t();
   }

   protected int d() {
      return super.d() + 32;
   }

   public void a(boolean var1) {
      Iterator var2 = this.u.iterator();

      while(var2.hasNext()) {
         awg.d var3 = (awg.d)var2.next();
         if (awg.d.a(var3) instanceof avs) {
            ((avs)awg.d.a(var3)).l = var1;
         }

         if (awg.d.b(var3) instanceof avs) {
            ((avs)awg.d.b(var3)).l = var1;
         }
      }

   }

   public int e() {
      return this.y;
   }

   public void h() {
      if (this.y > 0) {
         this.c(this.y - 1);
      }

   }

   public int f() {
      return this.x.length;
   }

   private void a(avp var1, boolean var2) {
      if (var1 instanceof avs) {
         ((avs)var1).m = var2;
      } else if (var1 instanceof avw) {
         ((avw)var1).e(var2);
      } else if (var1 instanceof avy) {
         ((avy)var1).j = var2;
      }

   }

   public avp g() {
      return this.A;
   }

   public boolean b(int var1, int var2, int var3) {
      boolean var4 = super.b(var1, var2, var3);
      int var5 = this.c(var1, var2);
      if (var5 >= 0) {
         awg.d var6 = this.e(var5);
         if (this.A != awg.d.c(var6) && this.A != null && this.A instanceof avw) {
            ((avw)this.A).b(false);
         }

         this.A = awg.d.c(var6);
      }

      return var4;
   }

   private void t() {
      this.u.clear();

      for(int var1 = 0; var1 < this.x[this.y].length; var1 += 2) {
         awg.f var2 = this.x[this.y][var1];
         awg.f var3 = var1 < this.x[this.y].length - 1 ? this.x[this.y][var1 + 1] : null;
         avp var4 = (avp)this.v.a(var2.b());
         avp var5 = var3 != null ? (avp)this.v.a(var3.b()) : null;
         awg.d var6 = new awg.d(var4, var5);
         this.u.add(var6);
      }

   }

   public void a(char var1, int var2) {
      if (this.A instanceof avw) {
         avw var3 = (avw)this.A;
         int var6;
         if (!axu.e(var2)) {
            if (var2 == 15) {
               var3.b(false);
               int var12 = this.w.indexOf(this.A);
               if (axu.r()) {
                  if (var12 == 0) {
                     var12 = this.w.size() - 1;
                  } else {
                     --var12;
                  }
               } else if (var12 == this.w.size() - 1) {
                  var12 = 0;
               } else {
                  ++var12;
               }

               this.A = (avp)this.w.get(var12);
               var3 = (avw)this.A;
               var3.b(true);
               int var13 = var3.f + this.h;
               var6 = var3.f;
               if (var13 > this.e) {
                  this.n += (float)(var13 - this.e);
               } else if (var6 < this.d) {
                  this.n = (float)var6;
               }
            } else {
               var3.a(var1, var2);
            }

         } else {
            String var4 = axu.o();
            String[] var5 = var4.split(";");
            var6 = this.w.indexOf(this.A);
            int var7 = var6;
            String[] var8 = var5;
            int var9 = var5.length;

            for(int var10 = 0; var10 < var9; ++var10) {
               String var11 = var8[var10];
               ((avw)this.w.get(var7)).a(var11);
               if (var7 == this.w.size() - 1) {
                  var7 = 0;
               } else {
                  ++var7;
               }

               if (var7 == var6) {
                  break;
               }
            }

         }
      }
   }

   private avp a(awg.f var1, int var2, boolean var3) {
      if (var1 instanceof awg.g) {
         return this.a(this.b / 2 - 155 + var2, 0, (awg.g)((awg.g)var1));
      } else if (var1 instanceof awg.a) {
         return this.a(this.b / 2 - 155 + var2, 0, (awg.a)((awg.a)var1));
      } else if (var1 instanceof awg.c) {
         return this.a(this.b / 2 - 155 + var2, 0, (awg.c)((awg.c)var1));
      } else {
         return var1 instanceof awg.e ? this.a(this.b / 2 - 155 + var2, 0, (awg.e)var1, var3) : null;
      }
   }

   public int b() {
      return this.u.size();
   }

   private void s() {
      awg.f[][] var1 = this.x;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         awg.f[] var4 = var1[var3];

         for(int var5 = 0; var5 < var4.length; var5 += 2) {
            awg.f var6 = var4[var5];
            awg.f var7 = var5 < var4.length - 1 ? var4[var5 + 1] : null;
            avp var8 = this.a(var6, 0, var7 == null);
            avp var9 = this.a(var7, 160, var6 == null);
            awg.d var10 = new awg.d(var8, var9);
            this.u.add(var10);
            if (var6 != null && var8 != null) {
               this.v.a(var6.b(), var8);
               if (var8 instanceof avw) {
                  this.w.add((avw)var8);
               }
            }

            if (var7 != null && var9 != null) {
               this.v.a(var7.b(), var9);
               if (var9 instanceof avw) {
                  this.w.add((avw)var9);
               }
            }
         }
      }

   }

   public awg.d e(int var1) {
      return (awg.d)this.u.get(var1);
   }

   private avx a(int var1, int var2, awg.g var3) {
      avx var4 = new avx(this.z, var3.b(), var1, var2, var3.c(), var3.e(), var3.f(), var3.g(), var3.a());
      var4.m = var3.d();
      return var4;
   }

   public void c(int var1) {
      if (var1 != this.y) {
         int var2 = this.y;
         this.y = var1;
         this.t();
         this.e(var2, var1);
         this.n = 0.0F;
      }
   }

   public static class g extends awg.f {
      private final avx.a a;
      private final float d;
      private final float b;
      private final float c;

      public g(int var1, String var2, boolean var3, avx.a var4, float var5, float var6, float var7) {
         super(var1, var2, var3);
         this.a = var4;
         this.b = var5;
         this.c = var6;
         this.d = var7;
      }

      public avx.a a() {
         return this.a;
      }

      public float g() {
         return this.d;
      }

      public float f() {
         return this.c;
      }

      public float e() {
         return this.b;
      }
   }

   public static class d implements awd.a {
      private final avp c;
      private final avp b;
      private final ave a = ave.A();
      private avp d;

      public d(avp var1, avp var2) {
         this.b = var1;
         this.c = var2;
      }

      public boolean a(int var1, int var2, int var3, int var4, int var5, int var6) {
         boolean var7 = this.a(this.b, var2, var3, var4);
         boolean var8 = this.a(this.c, var2, var3, var4);
         return var7 || var8;
      }

      public void b(int var1, int var2, int var3, int var4, int var5, int var6) {
         this.b(this.b, var2, var3, var4);
         this.b(this.c, var2, var3, var4);
      }

      static avp b(awg.d var0) {
         return var0.c;
      }

      private void a(avs var1, int var2, int var3, int var4, boolean var5) {
         var1.i = var2;
         if (!var5) {
            var1.a(this.a, var3, var4);
         }

      }

      static avp a(awg.d var0) {
         return var0.b;
      }

      public void a(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8) {
         this.a(this.b, var3, var6, var7, false);
         this.a(this.c, var3, var6, var7, false);
      }

      public avp a() {
         return this.b;
      }

      private void a(avw var1, int var2, boolean var3) {
         var1.f = var2;
         if (!var3) {
            var1.g();
         }

      }

      private void b(avp var1, int var2, int var3, int var4) {
         if (var1 != null) {
            if (var1 instanceof avs) {
               this.b((avs)var1, var2, var3, var4);
            }

         }
      }

      static avp c(awg.d var0) {
         return var0.d;
      }

      private void b(avs var1, int var2, int var3, int var4) {
         var1.a(var2, var3);
      }

      private void a(avp var1, int var2, int var3, int var4, boolean var5) {
         if (var1 != null) {
            if (var1 instanceof avs) {
               this.a((avs)var1, var2, var3, var4, var5);
            } else if (var1 instanceof avw) {
               this.a((avw)var1, var2, var5);
            } else if (var1 instanceof avy) {
               this.a((avy)var1, var2, var3, var4, var5);
            }

         }
      }

      public void a(int var1, int var2, int var3) {
         this.a((avp)this.b, var3, 0, 0, true);
         this.a((avp)this.c, var3, 0, 0, true);
      }

      private void a(avw var1, int var2, int var3, int var4) {
         var1.a(var2, var3, var4);
         if (var1.m()) {
            this.d = var1;
         }

      }

      private boolean a(avs var1, int var2, int var3, int var4) {
         boolean var5 = var1.c(this.a, var2, var3);
         if (var5) {
            this.d = var1;
         }

         return var5;
      }

      private boolean a(avp var1, int var2, int var3, int var4) {
         if (var1 == null) {
            return false;
         } else if (var1 instanceof avs) {
            return this.a((avs)var1, var2, var3, var4);
         } else {
            if (var1 instanceof avw) {
               this.a((avw)var1, var2, var3, var4);
            }

            return false;
         }
      }

      public avp b() {
         return this.c;
      }

      private void a(avy var1, int var2, int var3, int var4, boolean var5) {
         var1.h = var2;
         if (!var5) {
            var1.a(this.a, var3, var4);
         }

      }
   }

   public static class c extends awg.f {
      private final Predicate<String> a;

      public Predicate<String> a() {
         return this.a;
      }

      public c(int var1, String var2, boolean var3, Predicate<String> var4) {
         super(var1, var2, var3);
         this.a = (Predicate)Objects.firstNonNull(var4, Predicates.alwaysTrue());
      }
   }

   public interface b {
      void a(int var1, boolean var2);

      void a(int var1, String var2);

      void a(int var1, float var2);
   }

   public static class e extends awg.f {
      public e(int var1, String var2, boolean var3) {
         super(var1, var2, var3);
      }
   }

   public static class a extends awg.f {
      private final boolean a;

      public a(int var1, String var2, boolean var3, boolean var4) {
         super(var1, var2, var3);
         this.a = var4;
      }

      public boolean a() {
         return this.a;
      }
   }

   public static class f {
      private final int a;
      private final boolean c;
      private final String b;

      public boolean d() {
         return this.c;
      }

      public f(int var1, String var2, boolean var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      public int b() {
         return this.a;
      }

      public String c() {
         return this.b;
      }
   }
}
