public class bld implements blb<wb> {
   private final bjy a;
   private final bbo b = new bcc(0);

   public bld(bjy var1) {
      this.a = var1;
   }

   public void a(wb var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (!var1.ax()) {
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         bfl.z();
         bfl.l();
         bfl.b(770, 771);
         this.b.a(this.a.b());
         this.b.a(var1, var2, var3, var5, var6, var7, var8);
         bfl.k();
         bfl.A();
      }
   }

   public void a(pr var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.a((wb)var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public boolean b() {
      return true;
   }
}
