public class vg extends va {
   public vg(adm var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   public va.a s() {
      return va.a.a;
   }

   public boolean e(wn var1) {
      if (this.l != null && this.l instanceof wn && this.l != var1) {
         return true;
      } else if (this.l != null && this.l != var1) {
         return false;
      } else {
         if (!this.o.D) {
            var1.a((pk)this);
         }

         return true;
      }
   }

   public void a(int var1, int var2, int var3, boolean var4) {
      if (var4) {
         if (this.l != null) {
            this.l.a((pk)null);
         }

         if (this.q() == 0) {
            this.k(-this.r());
            this.j(10);
            this.a(50.0F);
            this.ac();
         }
      }

   }

   public vg(adm var1) {
      super(var1);
   }
}
