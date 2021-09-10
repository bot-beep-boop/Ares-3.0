public abstract class alk extends akw implements ol, oo {
   private on a;

   public alk() {
      this.a = on.a;
   }

   public void b(dn var1) {
      super.b(var1);
      if (this.a != null) {
         this.a.a(var1);
      }

   }

   public boolean r_() {
      return this.a != null && !this.a.a();
   }

   public void a(on var1) {
      this.a = var1;
   }

   public eu f_() {
      return (eu)(this.l_() ? new fa(this.e_()) : new fb(this.e_(), new Object[0]));
   }

   public on i() {
      return this.a;
   }

   public void a(dn var1) {
      super.a(var1);
      this.a = on.b(var1);
   }
}
