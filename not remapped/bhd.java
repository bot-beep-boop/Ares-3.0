public abstract class bhd<T extends akw> {
   protected static final jy[] a = new jy[]{new jy("textures/blocks/destroy_stage_0.png"), new jy("textures/blocks/destroy_stage_1.png"), new jy("textures/blocks/destroy_stage_2.png"), new jy("textures/blocks/destroy_stage_3.png"), new jy("textures/blocks/destroy_stage_4.png"), new jy("textures/blocks/destroy_stage_5.png"), new jy("textures/blocks/destroy_stage_6.png"), new jy("textures/blocks/destroy_stage_7.png"), new jy("textures/blocks/destroy_stage_8.png"), new jy("textures/blocks/destroy_stage_9.png")};
   protected bhc b;

   protected adm b() {
      return this.b.f;
   }

   public avn c() {
      return this.b.a();
   }

   public void a(bhc var1) {
      this.b = var1;
   }

   public abstract void a(T var1, double var2, double var4, double var6, float var8, int var9);

   public boolean a() {
      return false;
   }

   protected void a(jy var1) {
      bmj var2 = this.b.e;
      if (var2 != null) {
         var2.a(var1);
      }

   }
}
