import org.lwjgl.opengl.GL11;

public abstract class bly implements bmk {
   protected boolean b;
   protected int a = -1;
   protected boolean e;
   protected boolean c;
   protected boolean d;

   public int b() {
      if (this.a == -1) {
         this.a = bml.a();
      }

      return this.a;
   }

   public void a() {
      this.a(this.d, this.e);
   }

   public void b(boolean var1, boolean var2) {
      this.d = this.b;
      this.e = this.c;
      this.a(var1, var2);
   }

   public void a(boolean var1, boolean var2) {
      this.b = var1;
      this.c = var2;
      boolean var3 = true;
      boolean var4 = true;
      int var5;
      short var6;
      if (var1) {
         var5 = var2 ? 9987 : 9729;
         var6 = 9729;
      } else {
         var5 = var2 ? 9986 : 9728;
         var6 = 9728;
      }

      GL11.glTexParameteri(3553, 10241, var5);
      GL11.glTexParameteri(3553, 10240, var6);
   }

   public void c() {
      if (this.a != -1) {
         bml.a(this.a);
         this.a = -1;
      }

   }
}
