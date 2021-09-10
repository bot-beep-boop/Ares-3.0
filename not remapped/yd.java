public class yd extends oq {
   private alf a;

   public void c(wn var1) {
      if (this.a != null) {
         this.a.d();
      }

      super.c(var1);
      this.a = null;
   }

   public void b(wn var1) {
      if (this.a != null) {
         this.a.b();
      }

      super.b(var1);
   }

   public boolean a(wn var1) {
      return this.a != null && !this.a.a(var1) ? false : super.a(var1);
   }

   public yd() {
      super("container.enderchest", false, 27);
   }

   public void a(du var1) {
      int var2;
      for(var2 = 0; var2 < this.o_(); ++var2) {
         this.a(var2, (zx)null);
      }

      for(var2 = 0; var2 < var1.c(); ++var2) {
         dn var3 = var1.b(var2);
         int var4 = var3.d("Slot") & 255;
         if (var4 >= 0 && var4 < this.o_()) {
            this.a(var4, zx.a(var3));
         }
      }

   }

   public du h() {
      du var1 = new du();

      for(int var2 = 0; var2 < this.o_(); ++var2) {
         zx var3 = this.a(var2);
         if (var3 != null) {
            dn var4 = new dn();
            var4.a("Slot", (byte)var2);
            var3.b(var4);
            var1.a((eb)var4);
         }
      }

      return var1;
   }

   public void a(alf var1) {
      this.a = var1;
   }
}
