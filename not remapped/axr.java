public class axr extends axu implements nu {
   private String f = "";
   private int g;
   private boolean h;
   private String a = "";

   public void a(String var1) {
      this.b(var1);
   }

   public void a(int var1) {
      this.g = var1;
   }

   public void b(String var1) {
      this.a = var1;
      this.c("Working...");
   }

   public void c(String var1) {
      this.f = var1;
      this.a(0);
   }

   public void a(int var1, int var2, float var3) {
      if (this.h) {
         if (!this.j.al()) {
            this.j.a((axu)null);
         }

      } else {
         this.c();
         this.a(this.q, this.a, this.l / 2, 70, 16777215);
         this.a(this.q, this.f + " " + this.g + "%", this.l / 2, 90, 16777215);
         super.a(var1, var2, var3);
      }
   }

   public void a() {
      this.h = true;
   }
}
