public class ays extends ayl {
   private static final jy u = new jy("textures/gui/container/crafting_table.png");

   protected void a(float var1, int var2, int var3) {
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      this.j.P().a(u);
      int var4 = (this.l - this.f) / 2;
      int var5 = (this.m - this.g) / 2;
      this.b(var4, var5, 0, 0, this.f, this.g);
   }

   protected void b(int var1, int var2) {
      this.q.a(bnq.a("container.crafting"), 28, 6, 4210752);
      this.q.a(bnq.a("container.inventory"), 8, this.g - 96 + 2, 4210752);
   }

   public ays(wm var1, adm var2) {
      this(var1, var2, cj.a);
   }

   public ays(wm var1, adm var2, cj var3) {
      super(new xq(var1, var2, var3));
   }
}
