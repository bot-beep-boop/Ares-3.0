import com.google.common.collect.Lists;
import java.util.List;
import org.lwjgl.input.Keyboard;

public class axc extends axu {
   private String t;
   private avs h;
   protected String a = "Customize World Presets";
   private static final List<axc.a> f = Lists.newArrayList();
   private String s;
   private avw i;
   private axc.b g;
   private axd r;

   static {
      ant.a var0 = ant.a.a("{ \"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":512.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":5000.0, \"mainNoiseScaleY\":1000.0, \"mainNoiseScaleZ\":5000.0, \"baseSize\":8.5, \"stretchY\":8.0, \"biomeDepthWeight\":2.0, \"biomeDepthOffset\":0.5, \"biomeScaleWeight\":2.0, \"biomeScaleOffset\":0.375, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":255 }");
      jy var1 = new jy("textures/gui/presets/water.png");
      f.add(new axc.a(bnq.a("createWorld.customize.custom.preset.waterWorld"), var1, var0));
      var0 = ant.a.a("{\"coordinateScale\":3000.0, \"heightScale\":6000.0, \"upperLimitScale\":250.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":80.0, \"mainNoiseScaleY\":160.0, \"mainNoiseScaleZ\":80.0, \"baseSize\":8.5, \"stretchY\":10.0, \"biomeDepthWeight\":1.0, \"biomeDepthOffset\":0.0, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":0.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":63 }");
      var1 = new jy("textures/gui/presets/isles.png");
      f.add(new axc.a(bnq.a("createWorld.customize.custom.preset.isleLand"), var1, var0));
      var0 = ant.a.a("{\"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":512.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":5000.0, \"mainNoiseScaleY\":1000.0, \"mainNoiseScaleZ\":5000.0, \"baseSize\":8.5, \"stretchY\":5.0, \"biomeDepthWeight\":2.0, \"biomeDepthOffset\":1.0, \"biomeScaleWeight\":4.0, \"biomeScaleOffset\":1.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":63 }");
      var1 = new jy("textures/gui/presets/delight.png");
      f.add(new axc.a(bnq.a("createWorld.customize.custom.preset.caveDelight"), var1, var0));
      var0 = ant.a.a("{\"coordinateScale\":738.41864, \"heightScale\":157.69133, \"upperLimitScale\":801.4267, \"lowerLimitScale\":1254.1643, \"depthNoiseScaleX\":374.93652, \"depthNoiseScaleZ\":288.65228, \"depthNoiseScaleExponent\":1.2092624, \"mainNoiseScaleX\":1355.9908, \"mainNoiseScaleY\":745.5343, \"mainNoiseScaleZ\":1183.464, \"baseSize\":1.8758626, \"stretchY\":1.7137525, \"biomeDepthWeight\":1.7553768, \"biomeDepthOffset\":3.4701107, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":2.535211, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":63 }");
      var1 = new jy("textures/gui/presets/madness.png");
      f.add(new axc.a(bnq.a("createWorld.customize.custom.preset.mountains"), var1, var0));
      var0 = ant.a.a("{\"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":512.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":1000.0, \"mainNoiseScaleY\":3000.0, \"mainNoiseScaleZ\":1000.0, \"baseSize\":8.5, \"stretchY\":10.0, \"biomeDepthWeight\":1.0, \"biomeDepthOffset\":0.0, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":0.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":20 }");
      var1 = new jy("textures/gui/presets/drought.png");
      f.add(new axc.a(bnq.a("createWorld.customize.custom.preset.drought"), var1, var0));
      var0 = ant.a.a("{\"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":2.0, \"lowerLimitScale\":64.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":80.0, \"mainNoiseScaleY\":160.0, \"mainNoiseScaleZ\":80.0, \"baseSize\":8.5, \"stretchY\":12.0, \"biomeDepthWeight\":1.0, \"biomeDepthOffset\":0.0, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":0.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":false, \"seaLevel\":6 }");
      var1 = new jy("textures/gui/presets/chaos.png");
      f.add(new axc.a(bnq.a("createWorld.customize.custom.preset.caveChaos"), var1, var0));
      var0 = ant.a.a("{\"coordinateScale\":684.412, \"heightScale\":684.412, \"upperLimitScale\":512.0, \"lowerLimitScale\":512.0, \"depthNoiseScaleX\":200.0, \"depthNoiseScaleZ\":200.0, \"depthNoiseScaleExponent\":0.5, \"mainNoiseScaleX\":80.0, \"mainNoiseScaleY\":160.0, \"mainNoiseScaleZ\":80.0, \"baseSize\":8.5, \"stretchY\":12.0, \"biomeDepthWeight\":1.0, \"biomeDepthOffset\":0.0, \"biomeScaleWeight\":1.0, \"biomeScaleOffset\":0.0, \"useCaves\":true, \"useDungeons\":true, \"dungeonChance\":8, \"useStrongholds\":true, \"useVillages\":true, \"useMineShafts\":true, \"useTemples\":true, \"useRavines\":true, \"useWaterLakes\":true, \"waterLakeChance\":4, \"useLavaLakes\":true, \"lavaLakeChance\":80, \"useLavaOceans\":true, \"seaLevel\":40 }");
      var1 = new jy("textures/gui/presets/luck.png");
      f.add(new axc.a(bnq.a("createWorld.customize.custom.preset.goodLuck"), var1, var0));
   }

   public void k() {
      super.k();
      this.g.p();
   }

   static void d(axc var0, int var1, int var2, int var3, int var4) {
      var0.b(var1, var2, var3, var4);
   }

   static void a(axc var0, int var1, int var2, int var3, int var4) {
      var0.a(var1, var2, var3, var4);
   }

   static avw b(axc var0) {
      return var0.i;
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      this.g.a(var1, var2, var3);
      this.a(this.q, this.a, this.l / 2, 8, 16777215);
      this.c(this.q, this.s, 50, 30, 10526880);
      this.c(this.q, this.t, 50, 70, 10526880);
      this.i.g();
      super.a(var1, var2, var3);
   }

   public void a() {
      this.h.l = this.g();
   }

   public axc(axd var1) {
      this.r = var1;
   }

   static List f() {
      return f;
   }

   public void e() {
      this.i.a();
      super.e();
   }

   static void b(axc var0, int var1, int var2, int var3, int var4) {
      var0.a(var1, var2, var3, var4);
   }

   static void c(axc var0, int var1, int var2, int var3, int var4) {
      var0.b(var1, var2, var3, var4);
   }

   protected void a(char var1, int var2) {
      if (!this.i.a(var1, var2)) {
         super.a(var1, var2);
      }

   }

   static axc.b a(axc var0) {
      return var0.g;
   }

   protected void a(avs var1) {
      switch(var1.k) {
      case 0:
         this.r.a(this.i.b());
         this.j.a((axu)this.r);
         break;
      case 1:
         this.j.a((axu)this.r);
      }

   }

   protected void a(int var1, int var2, int var3) {
      this.i.a(var1, var2, var3);
      super.a(var1, var2, var3);
   }

   private boolean g() {
      return this.g.u > -1 && this.g.u < f.size() || this.i.b().length() > 1;
   }

   public void m() {
      Keyboard.enableRepeatEvents(false);
   }

   public void b() {
      this.n.clear();
      Keyboard.enableRepeatEvents(true);
      this.a = bnq.a("createWorld.customize.custom.presets.title");
      this.s = bnq.a("createWorld.customize.presets.share");
      this.t = bnq.a("createWorld.customize.presets.list");
      this.i = new avw(2, this.q, 50, 40, this.l - 100, 20);
      this.g = new axc.b(this);
      this.i.f(2000);
      this.i.a(this.r.a());
      this.n.add(this.h = new avs(0, this.l / 2 - 102, this.m - 27, 100, 20, bnq.a("createWorld.customize.presets.select")));
      this.n.add(new avs(1, this.l / 2 + 3, this.m - 27, 100, 20, bnq.a("gui.cancel")));
      this.a();
   }

   static class a {
      public String a;
      public jy b;
      public ant.a c;

      public a(String var1, jy var2, ant.a var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }
   }

   class b extends awi {
      public int u;
      final axc v;

      protected int b() {
         return axc.f().size();
      }

      protected void a(int var1, boolean var2, int var3, int var4) {
         this.u = var1;
         this.v.a();
         axc.b(this.v).a(((axc.a)axc.f().get(axc.a(this.v).u)).c.toString());
      }

      protected void a(int var1, int var2, int var3, int var4, int var5, int var6) {
         axc.a var7 = (axc.a)axc.f().get(var1);
         this.a(var2, var3, var7.b);
         this.v.q.a(var7.a, var2 + 32 + 10, var3 + 14, 16777215);
      }

      protected void a() {
      }

      private void a(int var1, int var2, jy var3) {
         int var4 = var1 + 5;
         axc.a(this.v, var4 - 1, var4 + 32, var2 - 1, -2039584);
         axc.b(this.v, var4 - 1, var4 + 32, var2 + 32, -6250336);
         axc.c(this.v, var4 - 1, var2 - 1, var2 + 32, -2039584);
         axc.d(this.v, var4 + 32, var2 - 1, var2 + 32, -6250336);
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         this.a.P().a(var3);
         boolean var6 = true;
         boolean var7 = true;
         bfx var8 = bfx.a();
         bfd var9 = var8.c();
         var9.a(7, bms.g);
         var9.b((double)var4, (double)(var2 + 32), 0.0D).a(0.0D, 1.0D).d();
         var9.b((double)(var4 + 32), (double)(var2 + 32), 0.0D).a(1.0D, 1.0D).d();
         var9.b((double)(var4 + 32), (double)var2, 0.0D).a(1.0D, 0.0D).d();
         var9.b((double)var4, (double)var2, 0.0D).a(0.0D, 0.0D).d();
         var8.b();
      }

      public b(axc var1) {
         super(var1.j, var1.l, var1.m, 80, var1.m - 32, 38);
         this.v = var1;
         this.u = -1;
      }

      protected boolean a(int var1) {
         return var1 == this.u;
      }
   }
}
