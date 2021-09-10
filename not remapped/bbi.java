public class bbi extends bbz {
   private final bct b = new bct(this, 32, 0);

   public void a(pk var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      super.a(var1, var2, var3, var4, var5, var6, var7);
      this.b.a(var7);
   }

   public bbi() {
      super(0, 0, 64, 64);
      this.b.a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.25F);
      this.b.a(0.0F, 0.0F, 0.0F);
   }

   public void a(float var1, float var2, float var3, float var4, float var5, float var6, pk var7) {
      super.a(var1, var2, var3, var4, var5, var6, var7);
      this.b.g = this.a.g;
      this.b.f = this.a.f;
   }
}
