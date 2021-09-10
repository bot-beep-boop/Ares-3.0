public class ya implements og {
   private final acy a;
   private final wn c;
   private zx[] b = new zx[3];
   private acz d;
   private int e;

   public void a(int var1, zx var2) {
      this.b[var1] = var2;
      if (var2 != null && var2.b > this.q_()) {
         var2.b = this.q_();
      }

      if (this.e(var1)) {
         this.h();
      }

   }

   public void d(int var1) {
      this.e = var1;
      this.h();
   }

   public void l() {
      for(int var1 = 0; var1 < this.b.length; ++var1) {
         this.b[var1] = null;
      }

   }

   public zx a(int var1) {
      return this.b[var1];
   }

   public int a_(int var1) {
      return 0;
   }

   public int q_() {
      return 64;
   }

   public int o_() {
      return this.b.length;
   }

   public ya(wn var1, acy var2) {
      this.c = var1;
      this.a = var2;
   }

   public int g() {
      return 0;
   }

   public boolean l_() {
      return false;
   }

   public boolean b(int var1, zx var2) {
      return true;
   }

   public String e_() {
      return "mob.villager";
   }

   public void h() {
      this.d = null;
      zx var1 = this.b[0];
      zx var2 = this.b[1];
      if (var1 == null) {
         var1 = var2;
         var2 = null;
      }

      if (var1 == null) {
         this.a(2, (zx)null);
      } else {
         ada var3 = this.a.b_(this.c);
         if (var3 != null) {
            acz var4 = var3.a(var1, var2, this.e);
            if (var4 != null && !var4.h()) {
               this.d = var4;
               this.a(2, var4.d().k());
            } else if (var2 != null) {
               var4 = var3.a(var2, var1, this.e);
               if (var4 != null && !var4.h()) {
                  this.d = var4;
                  this.a(2, var4.d().k());
               } else {
                  this.a(2, (zx)null);
               }
            } else {
               this.a(2, (zx)null);
            }
         }
      }

      this.a.a_(this.a(2));
   }

   public eu f_() {
      return (eu)(this.l_() ? new fa(this.e_()) : new fb(this.e_(), new Object[0]));
   }

   public boolean a(wn var1) {
      return this.a.v_() == var1;
   }

   public acz i() {
      return this.d;
   }

   public zx b(int var1) {
      if (this.b[var1] != null) {
         zx var2 = this.b[var1];
         this.b[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void b(wn var1) {
   }

   public zx a(int var1, int var2) {
      if (this.b[var1] != null) {
         zx var3;
         if (var1 == 2) {
            var3 = this.b[var1];
            this.b[var1] = null;
            return var3;
         } else if (this.b[var1].b <= var2) {
            var3 = this.b[var1];
            this.b[var1] = null;
            if (this.e(var1)) {
               this.h();
            }

            return var3;
         } else {
            var3 = this.b[var1].a(var2);
            if (this.b[var1].b == 0) {
               this.b[var1] = null;
            }

            if (this.e(var1)) {
               this.h();
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   public void p_() {
      this.h();
   }

   public void b(int var1, int var2) {
   }

   private boolean e(int var1) {
      return var1 == 0 || var1 == 1;
   }

   public void c(wn var1) {
   }
}
