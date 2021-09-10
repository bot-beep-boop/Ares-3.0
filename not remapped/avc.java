import java.nio.FloatBuffer;
import org.lwjgl.opengl.GL11;

public class avc {
   private static final aui b = (new aui(0.20000000298023224D, 1.0D, -0.699999988079071D)).a();
   private static final aui c = (new aui(-0.20000000298023224D, 1.0D, 0.699999988079071D)).a();
   private static FloatBuffer a = avd.h(16);

   private static FloatBuffer a(double var0, double var2, double var4, double var6) {
      return a((float)var0, (float)var2, (float)var4, (float)var6);
   }

   public static void c() {
      bfl.E();
      bfl.b(-30.0F, 0.0F, 1.0F, 0.0F);
      bfl.b(165.0F, 1.0F, 0.0F, 0.0F);
      b();
      bfl.F();
   }

   public static void b() {
      bfl.e();
      bfl.a(0);
      bfl.a(1);
      bfl.g();
      bfl.a(1032, 5634);
      float var0 = 0.4F;
      float var1 = 0.6F;
      float var2 = 0.0F;
      GL11.glLight(16384, 4611, a(b.a, b.b, b.c, 0.0D));
      GL11.glLight(16384, 4609, a(var1, var1, var1, 1.0F));
      GL11.glLight(16384, 4608, a(0.0F, 0.0F, 0.0F, 1.0F));
      GL11.glLight(16384, 4610, a(var2, var2, var2, 1.0F));
      GL11.glLight(16385, 4611, a(c.a, c.b, c.c, 0.0D));
      GL11.glLight(16385, 4609, a(var1, var1, var1, 1.0F));
      GL11.glLight(16385, 4608, a(0.0F, 0.0F, 0.0F, 1.0F));
      GL11.glLight(16385, 4610, a(var2, var2, var2, 1.0F));
      bfl.j(7424);
      GL11.glLightModel(2899, a(var0, var0, var0, 1.0F));
   }

   private static FloatBuffer a(float var0, float var1, float var2, float var3) {
      a.clear();
      a.put(var0).put(var1).put(var2).put(var3);
      a.flip();
      return a;
   }

   public static void a() {
      bfl.f();
      bfl.b(0);
      bfl.b(1);
      bfl.h();
   }
}
