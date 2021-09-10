import net.minecraft.realms.RealmsButton;

public class awp extends avs {
   private RealmsButton o;

   public int c(boolean var1) {
      return super.a(var1);
   }

   public int b() {
      return super.b();
   }

   public void b(boolean var1) {
      super.l = var1;
   }

   public int c() {
      return super.k;
   }

   public void a(int var1, int var2) {
      this.o.released(var1, var2);
   }

   public awp(RealmsButton var1, int var2, int var3, int var4, String var5, int var6, int var7) {
      super(var2, var3, var4, var6, var7, var5);
      this.o = var1;
   }

   public RealmsButton f() {
      return this.o;
   }

   public void b(ave var1, int var2, int var3) {
      this.o.renderBg(var2, var3);
   }

   public boolean d() {
      return super.l;
   }

   public int e() {
      return super.i;
   }

   public int g() {
      return this.g;
   }

   public void a(String var1) {
      super.j = var1;
   }

   public boolean c(ave var1, int var2, int var3) {
      if (super.c(var1, var2, var3)) {
         this.o.clicked(var2, var3);
      }

      return super.c(var1, var2, var3);
   }

   public awp(RealmsButton var1, int var2, int var3, int var4, String var5) {
      super(var2, var3, var4, var5);
      this.o = var1;
   }

   public int a(boolean var1) {
      return this.o.getYImage(var1);
   }
}
