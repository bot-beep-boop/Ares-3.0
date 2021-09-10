public class xp implements og {
   private final xi d;
   private final int c;
   private final zx[] a;
   private final int b;

   public zx b(int var1) {
      if (this.a[var1] != null) {
         zx var2 = this.a[var1];
         this.a[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void b(int var1, int var2) {
   }

   public zx c(int var1, int var2) {
      return var1 >= 0 && var1 < this.b && var2 >= 0 && var2 <= this.c ? this.a(var1 + var2 * this.b) : null;
   }

   public int h() {
      return this.c;
   }

   public boolean a(wn var1) {
      return true;
   }

   public void c(wn var1) {
   }

   public eu f_() {
      return (eu)(this.l_() ? new fa(this.e_()) : new fb(this.e_(), new Object[0]));
   }

   public xp(xi var1, int var2, int var3) {
      int var4 = var2 * var3;
      this.a = new zx[var4];
      this.d = var1;
      this.b = var2;
      this.c = var3;
   }

   public zx a(int var1) {
      return var1 >= this.o_() ? null : this.a[var1];
   }

   public String e_() {
      return "container.crafting";
   }

   public void l() {
      for(int var1 = 0; var1 < this.a.length; ++var1) {
         this.a[var1] = null;
      }

   }

   public int a_(int var1) {
      return 0;
   }

   public void a(int var1, zx var2) {
      this.a[var1] = var2;
      this.d.a((og)this);
   }

   public void p_() {
   }

   public void b(wn var1) {
   }

   public int q_() {
      return 64;
   }

   public int g() {
      return 0;
   }

   public int i() {
      return this.b;
   }

   public boolean b(int var1, zx var2) {
      return true;
   }

   public boolean l_() {
      return false;
   }

   public zx a(int var1, int var2) {
      if (this.a[var1] != null) {
         zx var3;
         if (this.a[var1].b <= var2) {
            var3 = this.a[var1];
            this.a[var1] = null;
            this.d.a((og)this);
            return var3;
         } else {
            var3 = this.a[var1].a(var2);
            if (this.a[var1].b == 0) {
               this.a[var1] = null;
            }

            this.d.a((og)this);
            return var3;
         }
      } else {
         return null;
      }
   }

   public int o_() {
      return this.a.length;
   }
}
