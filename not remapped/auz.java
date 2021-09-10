import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

public class auz {
   private static final IntBuffer a = avd.f(16);
   private static float h;
   private static final FloatBuffer b = avd.h(16);
   private static float i;
   private static float g;
   private static float f;
   private static float j;
   private static aui e = new aui(0.0D, 0.0D, 0.0D);
   private static final FloatBuffer c = avd.h(16);
   private static final FloatBuffer d = avd.h(3);

   public static float d() {
      return h;
   }

   public static float b() {
      return f;
   }

   public static afh a(adm var0, pk var1, float var2) {
      aui var3 = a(var1, (double)var2);
      cj var4 = new cj(var3);
      alz var5 = var0.p(var4);
      afh var6 = var5.c();
      if (var6.t().d()) {
         float var7 = 0.0F;
         if (var5.c() instanceof ahv) {
            var7 = ahv.b((Integer)var5.b(ahv.b)) - 0.11111111F;
         }

         float var8 = (float)(var4.o() + 1) - var7;
         if (var3.b >= (double)var8) {
            var6 = var0.p(var4.a()).c();
         }
      }

      return var6;
   }

   public static float c() {
      return g;
   }

   public static float f() {
      return j;
   }

   public static aui a() {
      return e;
   }

   public static float e() {
      return i;
   }

   public static aui a(pk var0, double var1) {
      double var3 = var0.p + (var0.s - var0.p) * var1;
      double var5 = var0.q + (var0.t - var0.q) * var1;
      double var7 = var0.r + (var0.u - var0.r) * var1;
      double var9 = var3 + e.a;
      double var11 = var5 + e.b;
      double var13 = var7 + e.c;
      return new aui(var9, var11, var13);
   }

   public static void a(wn var0, boolean var1) {
      bfl.a(2982, b);
      bfl.a(2983, c);
      GL11.glGetInteger(2978, a);
      float var2 = (float)((a.get(0) + a.get(2)) / 2);
      float var3 = (float)((a.get(1) + a.get(3)) / 2);
      GLU.gluUnProject(var2, var3, 0.0F, b, c, a, d);
      e = new aui((double)d.get(0), (double)d.get(1), (double)d.get(2));
      int var4 = var1 ? 1 : 0;
      float var5 = var0.z;
      float var6 = var0.y;
      f = ns.b(var6 * 3.1415927F / 180.0F) * (float)(1 - var4 * 2);
      h = ns.a(var6 * 3.1415927F / 180.0F) * (float)(1 - var4 * 2);
      i = -h * ns.a(var5 * 3.1415927F / 180.0F) * (float)(1 - var4 * 2);
      j = f * ns.a(var5 * 3.1415927F / 180.0F) * (float)(1 - var4 * 2);
      g = ns.b(var5 * 3.1415927F / 180.0F);
   }
}
