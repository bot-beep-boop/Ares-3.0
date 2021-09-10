public class of implements oo {
   private oo c;
   private oo b;
   private String a;

   public of(String var1, oo var2, oo var3) {
      this.a = var1;
      if (var2 == null) {
         var2 = var3;
      }

      if (var3 == null) {
         var3 = var2;
      }

      this.b = var2;
      this.c = var3;
      if (var2.r_()) {
         var3.a(var2.i());
      } else if (var3.r_()) {
         var2.a(var3.i());
      }

   }

   public int q_() {
      return this.b.q_();
   }

   public int g() {
      return 0;
   }

   public void l() {
      this.b.l();
      this.c.l();
   }

   public void a(int var1, zx var2) {
      if (var1 >= this.b.o_()) {
         this.c.a(var1 - this.b.o_(), var2);
      } else {
         this.b.a(var1, var2);
      }

   }

   public String k() {
      return this.b.k();
   }

   public int a_(int var1) {
      return 0;
   }

   public boolean a(wn var1) {
      return this.b.a(var1) && this.c.a(var1);
   }

   public zx a(int var1) {
      return var1 >= this.b.o_() ? this.c.a(var1 - this.b.o_()) : this.b.a(var1);
   }

   public eu f_() {
      return (eu)(this.l_() ? new fa(this.e_()) : new fb(this.e_(), new Object[0]));
   }

   public zx a(int var1, int var2) {
      return var1 >= this.b.o_() ? this.c.a(var1 - this.b.o_(), var2) : this.b.a(var1, var2);
   }

   public String e_() {
      if (this.b.l_()) {
         return this.b.e_();
      } else {
         return this.c.l_() ? this.c.e_() : this.a;
      }
   }

   public boolean b(int var1, zx var2) {
      return true;
   }

   public void b(int var1, int var2) {
   }

   public xi a(wm var1, wn var2) {
      return new xo(var1, this, var2);
   }

   public boolean r_() {
      return this.b.r_() || this.c.r_();
   }

   public boolean l_() {
      return this.b.l_() || this.c.l_();
   }

   public void b(wn var1) {
      this.b.b(var1);
      this.c.b(var1);
   }

   public int o_() {
      return this.b.o_() + this.c.o_();
   }

   public void c(wn var1) {
      this.b.c(var1);
      this.c.c(var1);
   }

   public void p_() {
      this.b.p_();
      this.c.p_();
   }

   public zx b(int var1) {
      return var1 >= this.b.o_() ? this.c.b(var1 - this.b.o_()) : this.b.b(var1);
   }

   public void a(on var1) {
      this.b.a(var1);
      this.c.a(var1);
   }

   public boolean a(og var1) {
      return this.b == var1 || this.c == var1;
   }

   public on i() {
      return this.b.i();
   }
}
