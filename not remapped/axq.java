import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.lwjgl.input.Keyboard;

public class axq extends axu {
   private String h;
   private static final List<axq.a> a = Lists.newArrayList();
   private String i;
   private avs s;
   private String g;
   private axq.b r;
   private avw t;
   private final axa f;

   public void a() {
      boolean var1 = this.g();
      this.s.l = var1;
   }

   static avw f(axq var0) {
      return var0.t;
   }

   private static void a(String var0, zw var1, int var2, ady var3, List<String> var4, aqa... var5) {
      apz var6 = new apz();

      for(int var7 = var5.length - 1; var7 >= 0; --var7) {
         var6.c().add(var5[var7]);
      }

      var6.a(var3.az);
      var6.d();
      if (var4 != null) {
         Iterator var9 = var4.iterator();

         while(var9.hasNext()) {
            String var8 = (String)var9.next();
            var6.b().put(var8, Maps.newHashMap());
         }
      }

      a.add(new axq.a(var1, var2, var0, var6.toString()));
   }

   public axq(axa var1) {
      this.f = var1;
   }

   static float a(axq var0) {
      return var0.e;
   }

   static List f() {
      return a;
   }

   public void b() {
      this.n.clear();
      Keyboard.enableRepeatEvents(true);
      this.g = bnq.a("createWorld.customize.presets.title");
      this.h = bnq.a("createWorld.customize.presets.share");
      this.i = bnq.a("createWorld.customize.presets.list");
      this.t = new avw(2, this.q, 50, 40, this.l - 100, 20);
      this.r = new axq.b(this);
      this.t.f(1230);
      this.t.a(this.f.a());
      this.n.add(this.s = new avs(0, this.l / 2 - 155, this.m - 28, 150, 20, bnq.a("createWorld.customize.presets.select")));
      this.n.add(new avs(1, this.l / 2 + 5, this.m - 28, 150, 20, bnq.a("gui.cancel")));
      this.a();
   }

   protected void a(char var1, int var2) {
      if (!this.t.a(var1, var2)) {
         super.a(var1, var2);
      }

   }

   static {
      a("Classic Flat", zw.a((afh)afi.c), ady.q, Arrays.asList("village"), new aqa(1, afi.c), new aqa(2, afi.d), new aqa(1, afi.h));
      a("Tunnelers' Dream", zw.a(afi.b), ady.s, Arrays.asList("biome_1", "dungeon", "decoration", "stronghold", "mineshaft"), new aqa(1, afi.c), new aqa(5, afi.d), new aqa(230, afi.b), new aqa(1, afi.h));
      a("Water World", zy.ax, ady.N, Arrays.asList("biome_1", "oceanmonument"), new aqa(90, afi.j), new aqa(5, afi.m), new aqa(5, afi.d), new aqa(5, afi.b), new aqa(1, afi.h));
      a("Overworld", zw.a((afh)afi.H), akc.a.b.a(), ady.q, Arrays.asList("village", "biome_1", "decoration", "stronghold", "mineshaft", "dungeon", "lake", "lava_lake"), new aqa(1, afi.c), new aqa(3, afi.d), new aqa(59, afi.b), new aqa(1, afi.h));
      a("Snowy Kingdom", zw.a(afi.aH), ady.B, Arrays.asList("village", "biome_1"), new aqa(1, afi.aH), new aqa(1, afi.c), new aqa(3, afi.d), new aqa(59, afi.b), new aqa(1, afi.h));
      a("Bottomless Pit", zy.G, ady.q, Arrays.asList("village", "biome_1"), new aqa(1, afi.c), new aqa(3, afi.d), new aqa(2, afi.e));
      a("Desert", zw.a((afh)afi.m), ady.r, Arrays.asList("village", "biome_1", "decoration", "stronghold", "mineshaft", "dungeon"), new aqa(8, afi.m), new aqa(52, afi.A), new aqa(3, afi.b), new aqa(1, afi.h));
      a("Redstone Ready", zy.aC, ady.r, new aqa(52, afi.A), new aqa(3, afi.b), new aqa(1, afi.h));
   }

   static axq.b e(axq var0) {
      return var0.r;
   }

   static float d(axq var0) {
      return var0.e;
   }

   private static void a(String var0, zw var1, ady var2, List<String> var3, aqa... var4) {
      a(var0, var1, 0, var2, var3, var4);
   }

   public void m() {
      Keyboard.enableRepeatEvents(false);
   }

   public void e() {
      this.t.a();
      super.e();
   }

   static float c(axq var0) {
      return var0.e;
   }

   private boolean g() {
      return this.r.u > -1 && this.r.u < a.size() || this.t.b().length() > 1;
   }

   protected void a(avs var1) {
      if (var1.k == 0 && this.g()) {
         this.f.a(this.t.b());
         this.j.a((axu)this.f);
      } else if (var1.k == 1) {
         this.j.a((axu)this.f);
      }

   }

   protected void a(int var1, int var2, int var3) {
      this.t.a(var1, var2, var3);
      super.a(var1, var2, var3);
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      this.r.a(var1, var2, var3);
      this.a(this.q, this.g, this.l / 2, 8, 16777215);
      this.c(this.q, this.h, 50, 30, 10526880);
      this.c(this.q, this.i, 50, 70, 10526880);
      this.t.g();
      super.a(var1, var2, var3);
   }

   public void k() {
      super.k();
      this.r.p();
   }

   static float b(axq var0) {
      return var0.e;
   }

   private static void a(String var0, zw var1, ady var2, aqa... var3) {
      a(var0, var1, 0, var2, (List)null, var3);
   }

   static class a {
      public String d;
      public int b;
      public String c;
      public zw a;

      public a(zw var1, int var2, String var3, String var4) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
      }
   }

   class b extends awi {
      final axq v;
      public int u;

      protected void a(int var1, int var2, int var3, int var4, int var5, int var6) {
         axq.a var7 = (axq.a)axq.f().get(var1);
         this.a(var2, var3, var7.a, var7.b);
         this.v.q.a(var7.c, var2 + 18 + 5, var3 + 6, 16777215);
      }

      protected void a(int var1, boolean var2, int var3, int var4) {
         this.u = var1;
         this.v.a();
         axq.f(this.v).a(((axq.a)axq.f().get(axq.e(this.v).u)).d);
      }

      protected boolean a(int var1) {
         return var1 == this.u;
      }

      protected int b() {
         return axq.f().size();
      }

      public b(axq var1) {
         super(var1.j, var1.l, var1.m, 80, var1.m - 37, 24);
         this.v = var1;
         this.u = -1;
      }

      private void e(int var1, int var2) {
         this.d(var1, var2, 0, 0);
      }

      private void d(int var1, int var2, int var3, int var4) {
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         this.a.P().a(avp.c);
         float var5 = 0.0078125F;
         float var6 = 0.0078125F;
         boolean var7 = true;
         boolean var8 = true;
         bfx var9 = bfx.a();
         bfd var10 = var9.c();
         var10.a(7, bms.g);
         var10.b((double)var1, (double)(var2 + 18), (double)axq.a(this.v)).a((double)((float)var3 * 0.0078125F), (double)((float)(var4 + 18) * 0.0078125F)).d();
         var10.b((double)(var1 + 18), (double)(var2 + 18), (double)axq.b(this.v)).a((double)((float)(var3 + 18) * 0.0078125F), (double)((float)(var4 + 18) * 0.0078125F)).d();
         var10.b((double)(var1 + 18), (double)var2, (double)axq.c(this.v)).a((double)((float)(var3 + 18) * 0.0078125F), (double)((float)var4 * 0.0078125F)).d();
         var10.b((double)var1, (double)var2, (double)axq.d(this.v)).a((double)((float)var3 * 0.0078125F), (double)((float)var4 * 0.0078125F)).d();
         var9.b();
      }

      private void a(int var1, int var2, zw var3, int var4) {
         this.e(var1 + 1, var2 + 1);
         bfl.B();
         avc.c();
         this.v.k.a(new zx(var3, 1, var4), var1 + 2, var2 + 2);
         avc.a();
         bfl.C();
      }

      protected void a() {
      }
   }
}
