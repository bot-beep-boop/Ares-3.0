import net.minecraft.realms.RealmsScrolledSelectionList;

public class aws extends awi {
   private final RealmsScrolledSelectionList u;

   public aws(RealmsScrolledSelectionList var1, int var2, int var3, int var4, int var5, int var6) {
      super(ave.A(), var2, var3, var4, var5, var6);
      this.u = var1;
   }

   public int f() {
      return super.j;
   }

   public int g() {
      return super.i;
   }

   protected void a(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.u.renderItem(var1, var2, var3, var4, var5, var6);
   }

   protected int b() {
      return this.u.getItemCount();
   }

   protected void a() {
      this.u.renderBackground();
   }

   protected int d() {
      return this.u.getScrollbarPosition();
   }

   protected void a(int var1, boolean var2, int var3, int var4) {
      this.u.selectItem(var1, var2, var3, var4);
   }

   protected boolean a(int var1) {
      return this.u.isSelectedItem(var1);
   }

   public int e() {
      return super.b;
   }

   public void p() {
      super.p();
   }

   protected int k() {
      return this.u.getMaxPosition();
   }
}
