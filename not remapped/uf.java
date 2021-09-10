public class uf extends pk {
   public int b;
   public int a;

   protected void a(dn var1) {
   }

   public uf(adm var1) {
      super(var1);
      this.k = true;
      this.a(2.0F, 2.0F);
      this.b = 5;
      this.a = this.V.nextInt(100000);
   }

   protected void h() {
      this.ac.a(8, this.b);
   }

   public void t_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      ++this.a;
      this.ac.b(8, this.b);
      int var1 = ns.c(this.s);
      int var2 = ns.c(this.t);
      int var3 = ns.c(this.u);
      if (this.o.t instanceof anp && this.o.p(new cj(var1, var2, var3)).c() != afi.ab) {
         this.o.a(new cj(var1, var2, var3), afi.ab.Q());
      }

   }

   public boolean a(ow var1, float var2) {
      if (this.b(var1)) {
         return false;
      } else {
         if (!this.I && !this.o.D) {
            this.b = 0;
            if (this.b <= 0) {
               this.J();
               if (!this.o.D) {
                  this.o.a((pk)null, this.s, this.t, this.u, 6.0F, true);
               }
            }
         }

         return true;
      }
   }

   public uf(adm var1, double var2, double var4, double var6) {
      this(var1);
      this.b(var2, var4, var6);
   }

   protected void b(dn var1) {
   }

   public boolean ad() {
      return true;
   }

   protected boolean s_() {
      return false;
   }
}
