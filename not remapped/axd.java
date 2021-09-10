import com.google.common.base.Predicate;
import com.google.common.primitives.Floats;
import java.util.Random;

public class axd extends axu implements awg.b, avx.a {
   private ant.a E = new ant.a();
   private avs s;
   protected String g = "Basic Settings";
   private boolean A = false;
   private Random G = new Random();
   private axb i;
   private avs t;
   private int B = 0;
   private Predicate<String> D = new Predicate<String>(this) {
      final axd a;

      public boolean a(String var1) {
         Float var2 = Floats.tryParse(var1);
         return var1.length() == 0 || var2 != null && Floats.isFinite(var2) && var2 >= 0.0F;
      }

      public boolean apply(Object var1) {
         return this.a((String)var1);
      }

      {
         this.a = var1;
      }
   };
   protected String f = "Page 1 of 3";
   private ant.a F;
   private awg r;
   private avs x;
   private avs z;
   private avs u;
   private avs v;
   private boolean C = false;
   protected String[] h = new String[4];
   private avs w;
   private avs y;
   protected String a = "Customize World Settings";

   private void b(boolean var1) {
      this.x.m = var1;
      this.y.m = var1;
      this.t.l = !var1;
      this.s.l = !var1;
      this.v.l = !var1;
      this.w.l = !var1;
      this.u.l = this.A && !var1;
      this.z.l = !var1;
      this.r.a(!var1);
   }

   protected void a(int var1, int var2, int var3) {
      super.a(var1, var2, var3);
      if (this.B == 0 && !this.C) {
         this.r.b(var1, var2, var3);
      }
   }

   public void b() {
      int var1 = 0;
      int var2 = 0;
      if (this.r != null) {
         var1 = this.r.e();
         var2 = this.r.n();
      }

      this.a = bnq.a("options.customizeTitle");
      this.n.clear();
      this.n.add(this.v = new avs(302, 20, 5, 80, 20, bnq.a("createWorld.customize.custom.prev")));
      this.n.add(this.w = new avs(303, this.l - 100, 5, 80, 20, bnq.a("createWorld.customize.custom.next")));
      this.n.add(this.u = new avs(304, this.l / 2 - 187, this.m - 27, 90, 20, bnq.a("createWorld.customize.custom.defaults")));
      this.n.add(this.t = new avs(301, this.l / 2 - 92, this.m - 27, 90, 20, bnq.a("createWorld.customize.custom.randomize")));
      this.n.add(this.z = new avs(305, this.l / 2 + 3, this.m - 27, 90, 20, bnq.a("createWorld.customize.custom.presets")));
      this.n.add(this.s = new avs(300, this.l / 2 + 98, this.m - 27, 90, 20, bnq.a("gui.done")));
      this.u.l = this.A;
      this.x = new avs(306, this.l / 2 - 55, 160, 50, 20, bnq.a("gui.yes"));
      this.x.m = false;
      this.n.add(this.x);
      this.y = new avs(307, this.l / 2 + 5, 160, 50, 20, bnq.a("gui.no"));
      this.y.m = false;
      this.n.add(this.y);
      if (this.B != 0) {
         this.x.m = true;
         this.y.m = true;
      }

      this.f();
      if (var1 != 0) {
         this.r.c(var1);
         this.r.h(var2);
         this.i();
      }

   }

   public void a(int var1, String var2) {
      float var3 = 0.0F;

      try {
         var3 = Float.parseFloat(var2);
      } catch (NumberFormatException var5) {
      }

      float var4 = 0.0F;
      switch(var1) {
      case 132:
         var4 = this.F.i = ns.a(var3, 1.0F, 5000.0F);
         break;
      case 133:
         var4 = this.F.j = ns.a(var3, 1.0F, 5000.0F);
         break;
      case 134:
         var4 = this.F.k = ns.a(var3, 1.0F, 5000.0F);
         break;
      case 135:
         var4 = this.F.f = ns.a(var3, 1.0F, 2000.0F);
         break;
      case 136:
         var4 = this.F.g = ns.a(var3, 1.0F, 2000.0F);
         break;
      case 137:
         var4 = this.F.h = ns.a(var3, 0.01F, 20.0F);
         break;
      case 138:
         var4 = this.F.l = ns.a(var3, 1.0F, 25.0F);
         break;
      case 139:
         var4 = this.F.b = ns.a(var3, 1.0F, 6000.0F);
         break;
      case 140:
         var4 = this.F.c = ns.a(var3, 1.0F, 6000.0F);
         break;
      case 141:
         var4 = this.F.m = ns.a(var3, 0.01F, 50.0F);
         break;
      case 142:
         var4 = this.F.d = ns.a(var3, 1.0F, 5000.0F);
         break;
      case 143:
         var4 = this.F.e = ns.a(var3, 1.0F, 5000.0F);
         break;
      case 144:
         var4 = this.F.n = ns.a(var3, 1.0F, 20.0F);
         break;
      case 145:
         var4 = this.F.o = ns.a(var3, 0.0F, 20.0F);
         break;
      case 146:
         var4 = this.F.p = ns.a(var3, 1.0F, 20.0F);
         break;
      case 147:
         var4 = this.F.q = ns.a(var3, 0.0F, 20.0F);
      }

      if (var4 != var3 && var3 != 0.0F) {
         ((avw)this.r.d(var1)).a(this.b(var1, var4));
      }

      ((avx)this.r.d(var1 - 132 + 100)).a(var4, false);
      if (!this.F.equals(this.E)) {
         this.a(true);
      }

   }

   protected void b(int var1, int var2, int var3) {
      super.b(var1, var2, var3);
      if (this.C) {
         this.C = false;
      } else if (this.B == 0) {
         this.r.c(var1, var2, var3);
      }
   }

   public void k() {
      super.k();
      this.r.p();
   }

   protected void a(char var1, int var2) {
      super.a(var1, var2);
      if (this.B == 0) {
         switch(var2) {
         case 200:
            this.a(1.0F);
            break;
         case 208:
            this.a(-1.0F);
            break;
         default:
            this.r.a(var1, var2);
         }

      }
   }

   public axd(axu var1, String var2) {
      this.i = (axb)var1;
      this.a(var2);
   }

   public String a(int var1, String var2, float var3) {
      return var2 + ": " + this.b(var1, var3);
   }

   private void g() {
      this.F.a();
      this.f();
      this.a(false);
   }

   public void a(String var1) {
      if (var1 != null && var1.length() != 0) {
         this.F = ant.a.a(var1);
      } else {
         this.F = new ant.a();
      }

   }

   private String b(int var1, float var2) {
      switch(var1) {
      case 100:
      case 101:
      case 102:
      case 103:
      case 104:
      case 107:
      case 108:
      case 110:
      case 111:
      case 132:
      case 133:
      case 134:
      case 135:
      case 136:
      case 139:
      case 140:
      case 142:
      case 143:
         return String.format("%5.3f", var2);
      case 105:
      case 106:
      case 109:
      case 112:
      case 113:
      case 114:
      case 115:
      case 137:
      case 138:
      case 141:
      case 144:
      case 145:
      case 146:
      case 147:
         return String.format("%2.3f", var2);
      case 116:
      case 117:
      case 118:
      case 119:
      case 120:
      case 121:
      case 122:
      case 123:
      case 124:
      case 125:
      case 126:
      case 127:
      case 128:
      case 129:
      case 130:
      case 131:
      case 148:
      case 149:
      case 150:
      case 151:
      case 152:
      case 153:
      case 154:
      case 155:
      case 156:
      case 157:
      case 158:
      case 159:
      case 160:
      case 161:
      default:
         return String.format("%d", (int)var2);
      case 162:
         if (var2 < 0.0F) {
            return bnq.a("gui.all");
         } else {
            ady var3;
            if ((int)var2 >= ady.x.az) {
               var3 = ady.n()[(int)var2 + 2];
               return var3 != null ? var3.ah : "?";
            } else {
               var3 = ady.n()[(int)var2];
               return var3 != null ? var3.ah : "?";
            }
         }
      }
   }

   public String a() {
      return this.F.toString().replace("\n", "");
   }

   public void a(int var1, float var2) {
      switch(var1) {
      case 100:
         this.F.i = var2;
         break;
      case 101:
         this.F.j = var2;
         break;
      case 102:
         this.F.k = var2;
         break;
      case 103:
         this.F.f = var2;
         break;
      case 104:
         this.F.g = var2;
         break;
      case 105:
         this.F.h = var2;
         break;
      case 106:
         this.F.l = var2;
         break;
      case 107:
         this.F.b = var2;
         break;
      case 108:
         this.F.c = var2;
         break;
      case 109:
         this.F.m = var2;
         break;
      case 110:
         this.F.d = var2;
         break;
      case 111:
         this.F.e = var2;
         break;
      case 112:
         this.F.n = var2;
         break;
      case 113:
         this.F.o = var2;
         break;
      case 114:
         this.F.p = var2;
         break;
      case 115:
         this.F.q = var2;
      case 116:
      case 117:
      case 118:
      case 119:
      case 120:
      case 121:
      case 122:
      case 123:
      case 124:
      case 125:
      case 126:
      case 127:
      case 128:
      case 129:
      case 130:
      case 131:
      case 132:
      case 133:
      case 134:
      case 135:
      case 136:
      case 137:
      case 138:
      case 139:
      case 140:
      case 141:
      case 142:
      case 143:
      case 144:
      case 145:
      case 146:
      case 147:
      case 148:
      case 149:
      case 150:
      case 151:
      case 152:
      case 153:
      case 154:
      case 155:
      case 156:
      case 161:
      case 188:
      default:
         break;
      case 157:
         this.F.u = (int)var2;
         break;
      case 158:
         this.F.C = (int)var2;
         break;
      case 159:
         this.F.E = (int)var2;
         break;
      case 160:
         this.F.r = (int)var2;
         break;
      case 162:
         this.F.G = (int)var2;
         break;
      case 163:
         this.F.H = (int)var2;
         break;
      case 164:
         this.F.I = (int)var2;
         break;
      case 165:
         this.F.J = (int)var2;
         break;
      case 166:
         this.F.K = (int)var2;
         break;
      case 167:
         this.F.L = (int)var2;
         break;
      case 168:
         this.F.M = (int)var2;
         break;
      case 169:
         this.F.N = (int)var2;
         break;
      case 170:
         this.F.O = (int)var2;
         break;
      case 171:
         this.F.P = (int)var2;
         break;
      case 172:
         this.F.Q = (int)var2;
         break;
      case 173:
         this.F.R = (int)var2;
         break;
      case 174:
         this.F.S = (int)var2;
         break;
      case 175:
         this.F.T = (int)var2;
         break;
      case 176:
         this.F.U = (int)var2;
         break;
      case 177:
         this.F.V = (int)var2;
         break;
      case 178:
         this.F.W = (int)var2;
         break;
      case 179:
         this.F.X = (int)var2;
         break;
      case 180:
         this.F.Y = (int)var2;
         break;
      case 181:
         this.F.Z = (int)var2;
         break;
      case 182:
         this.F.aa = (int)var2;
         break;
      case 183:
         this.F.ab = (int)var2;
         break;
      case 184:
         this.F.ac = (int)var2;
         break;
      case 185:
         this.F.ad = (int)var2;
         break;
      case 186:
         this.F.ae = (int)var2;
         break;
      case 187:
         this.F.af = (int)var2;
         break;
      case 189:
         this.F.ag = (int)var2;
         break;
      case 190:
         this.F.ah = (int)var2;
         break;
      case 191:
         this.F.ai = (int)var2;
         break;
      case 192:
         this.F.aj = (int)var2;
         break;
      case 193:
         this.F.ak = (int)var2;
         break;
      case 194:
         this.F.al = (int)var2;
         break;
      case 195:
         this.F.am = (int)var2;
         break;
      case 196:
         this.F.an = (int)var2;
         break;
      case 197:
         this.F.ao = (int)var2;
         break;
      case 198:
         this.F.ap = (int)var2;
         break;
      case 199:
         this.F.aq = (int)var2;
         break;
      case 200:
         this.F.ar = (int)var2;
         break;
      case 201:
         this.F.as = (int)var2;
         break;
      case 202:
         this.F.at = (int)var2;
         break;
      case 203:
         this.F.au = (int)var2;
         break;
      case 204:
         this.F.av = (int)var2;
         break;
      case 205:
         this.F.aw = (int)var2;
         break;
      case 206:
         this.F.ax = (int)var2;
         break;
      case 207:
         this.F.ay = (int)var2;
         break;
      case 208:
         this.F.az = (int)var2;
         break;
      case 209:
         this.F.aA = (int)var2;
      }

      if (var1 >= 100 && var1 < 116) {
         avp var3 = this.r.d(var1 - 100 + 132);
         if (var3 != null) {
            ((avw)var3).a(this.b(var1, var2));
         }
      }

      if (!this.F.equals(this.E)) {
         this.a(true);
      }

   }

   private void b(int var1) {
      this.B = var1;
      this.b(true);
   }

   private void a(float var1) {
      avp var2 = this.r.g();
      if (var2 instanceof avw) {
         float var3 = var1;
         if (axu.r()) {
            var3 = var1 * 0.1F;
            if (axu.q()) {
               var3 *= 0.1F;
            }
         } else if (axu.q()) {
            var3 = var1 * 10.0F;
            if (axu.s()) {
               var3 *= 10.0F;
            }
         }

         avw var4 = (avw)var2;
         Float var5 = Floats.tryParse(var4.b());
         if (var5 != null) {
            var5 = var5 + var3;
            int var6 = var4.d();
            String var7 = this.b(var4.d(), var5);
            var4.a(var7);
            this.a(var6, var7);
         }
      }
   }

   protected void a(avs var1) {
      if (var1.l) {
         switch(var1.k) {
         case 300:
            this.i.a = this.F.toString();
            this.j.a((axu)this.i);
            break;
         case 301:
            for(int var2 = 0; var2 < this.r.b(); ++var2) {
               awg.d var3 = this.r.e(var2);
               avp var4 = var3.a();
               if (var4 instanceof avs) {
                  avs var5 = (avs)var4;
                  if (var5 instanceof avx) {
                     float var6 = ((avx)var5).d() * (0.75F + this.G.nextFloat() * 0.5F) + (this.G.nextFloat() * 0.1F - 0.05F);
                     ((avx)var5).a(ns.a(var6, 0.0F, 1.0F));
                  } else if (var5 instanceof awb) {
                     ((awb)var5).b(this.G.nextBoolean());
                  }
               }

               avp var8 = var3.b();
               if (var8 instanceof avs) {
                  avs var9 = (avs)var8;
                  if (var9 instanceof avx) {
                     float var7 = ((avx)var9).d() * (0.75F + this.G.nextFloat() * 0.5F) + (this.G.nextFloat() * 0.1F - 0.05F);
                     ((avx)var9).a(ns.a(var7, 0.0F, 1.0F));
                  } else if (var9 instanceof awb) {
                     ((awb)var9).b(this.G.nextBoolean());
                  }
               }
            }

            return;
         case 302:
            this.r.h();
            this.i();
            break;
         case 303:
            this.r.i();
            this.i();
            break;
         case 304:
            if (this.A) {
               this.b(304);
            }
            break;
         case 305:
            this.j.a((axu)(new axc(this)));
            break;
         case 306:
            this.h();
            break;
         case 307:
            this.B = 0;
            this.h();
         }

      }
   }

   private void a(boolean var1) {
      this.A = var1;
      this.u.l = var1;
   }

   private void f() {
      awg.f[] var1 = new awg.f[]{new awg.g(160, bnq.a("createWorld.customize.custom.seaLevel"), true, this, 1.0F, 255.0F, (float)this.F.r), new awg.a(148, bnq.a("createWorld.customize.custom.useCaves"), true, this.F.s), new awg.a(150, bnq.a("createWorld.customize.custom.useStrongholds"), true, this.F.v), new awg.a(151, bnq.a("createWorld.customize.custom.useVillages"), true, this.F.w), new awg.a(152, bnq.a("createWorld.customize.custom.useMineShafts"), true, this.F.x), new awg.a(153, bnq.a("createWorld.customize.custom.useTemples"), true, this.F.y), new awg.a(210, bnq.a("createWorld.customize.custom.useMonuments"), true, this.F.z), new awg.a(154, bnq.a("createWorld.customize.custom.useRavines"), true, this.F.A), new awg.a(149, bnq.a("createWorld.customize.custom.useDungeons"), true, this.F.t), new awg.g(157, bnq.a("createWorld.customize.custom.dungeonChance"), true, this, 1.0F, 100.0F, (float)this.F.u), new awg.a(155, bnq.a("createWorld.customize.custom.useWaterLakes"), true, this.F.B), new awg.g(158, bnq.a("createWorld.customize.custom.waterLakeChance"), true, this, 1.0F, 100.0F, (float)this.F.C), new awg.a(156, bnq.a("createWorld.customize.custom.useLavaLakes"), true, this.F.D), new awg.g(159, bnq.a("createWorld.customize.custom.lavaLakeChance"), true, this, 10.0F, 100.0F, (float)this.F.E), new awg.a(161, bnq.a("createWorld.customize.custom.useLavaOceans"), true, this.F.F), new awg.g(162, bnq.a("createWorld.customize.custom.fixedBiome"), true, this, -1.0F, 37.0F, (float)this.F.G), new awg.g(163, bnq.a("createWorld.customize.custom.biomeSize"), true, this, 1.0F, 8.0F, (float)this.F.H), new awg.g(164, bnq.a("createWorld.customize.custom.riverSize"), true, this, 1.0F, 5.0F, (float)this.F.I)};
      awg.f[] var2 = new awg.f[]{new awg.e(416, bnq.a("tile.dirt.name"), false), null, new awg.g(165, bnq.a("createWorld.customize.custom.size"), false, this, 1.0F, 50.0F, (float)this.F.J), new awg.g(166, bnq.a("createWorld.customize.custom.count"), false, this, 0.0F, 40.0F, (float)this.F.K), new awg.g(167, bnq.a("createWorld.customize.custom.minHeight"), false, this, 0.0F, 255.0F, (float)this.F.L), new awg.g(168, bnq.a("createWorld.customize.custom.maxHeight"), false, this, 0.0F, 255.0F, (float)this.F.M), new awg.e(417, bnq.a("tile.gravel.name"), false), null, new awg.g(169, bnq.a("createWorld.customize.custom.size"), false, this, 1.0F, 50.0F, (float)this.F.N), new awg.g(170, bnq.a("createWorld.customize.custom.count"), false, this, 0.0F, 40.0F, (float)this.F.O), new awg.g(171, bnq.a("createWorld.customize.custom.minHeight"), false, this, 0.0F, 255.0F, (float)this.F.P), new awg.g(172, bnq.a("createWorld.customize.custom.maxHeight"), false, this, 0.0F, 255.0F, (float)this.F.Q), new awg.e(418, bnq.a("tile.stone.granite.name"), false), null, new awg.g(173, bnq.a("createWorld.customize.custom.size"), false, this, 1.0F, 50.0F, (float)this.F.R), new awg.g(174, bnq.a("createWorld.customize.custom.count"), false, this, 0.0F, 40.0F, (float)this.F.S), new awg.g(175, bnq.a("createWorld.customize.custom.minHeight"), false, this, 0.0F, 255.0F, (float)this.F.T), new awg.g(176, bnq.a("createWorld.customize.custom.maxHeight"), false, this, 0.0F, 255.0F, (float)this.F.U), new awg.e(419, bnq.a("tile.stone.diorite.name"), false), null, new awg.g(177, bnq.a("createWorld.customize.custom.size"), false, this, 1.0F, 50.0F, (float)this.F.V), new awg.g(178, bnq.a("createWorld.customize.custom.count"), false, this, 0.0F, 40.0F, (float)this.F.W), new awg.g(179, bnq.a("createWorld.customize.custom.minHeight"), false, this, 0.0F, 255.0F, (float)this.F.X), new awg.g(180, bnq.a("createWorld.customize.custom.maxHeight"), false, this, 0.0F, 255.0F, (float)this.F.Y), new awg.e(420, bnq.a("tile.stone.andesite.name"), false), null, new awg.g(181, bnq.a("createWorld.customize.custom.size"), false, this, 1.0F, 50.0F, (float)this.F.Z), new awg.g(182, bnq.a("createWorld.customize.custom.count"), false, this, 0.0F, 40.0F, (float)this.F.aa), new awg.g(183, bnq.a("createWorld.customize.custom.minHeight"), false, this, 0.0F, 255.0F, (float)this.F.ab), new awg.g(184, bnq.a("createWorld.customize.custom.maxHeight"), false, this, 0.0F, 255.0F, (float)this.F.ac), new awg.e(421, bnq.a("tile.oreCoal.name"), false), null, new awg.g(185, bnq.a("createWorld.customize.custom.size"), false, this, 1.0F, 50.0F, (float)this.F.ad), new awg.g(186, bnq.a("createWorld.customize.custom.count"), false, this, 0.0F, 40.0F, (float)this.F.ae), new awg.g(187, bnq.a("createWorld.customize.custom.minHeight"), false, this, 0.0F, 255.0F, (float)this.F.af), new awg.g(189, bnq.a("createWorld.customize.custom.maxHeight"), false, this, 0.0F, 255.0F, (float)this.F.ag), new awg.e(422, bnq.a("tile.oreIron.name"), false), null, new awg.g(190, bnq.a("createWorld.customize.custom.size"), false, this, 1.0F, 50.0F, (float)this.F.ah), new awg.g(191, bnq.a("createWorld.customize.custom.count"), false, this, 0.0F, 40.0F, (float)this.F.ai), new awg.g(192, bnq.a("createWorld.customize.custom.minHeight"), false, this, 0.0F, 255.0F, (float)this.F.aj), new awg.g(193, bnq.a("createWorld.customize.custom.maxHeight"), false, this, 0.0F, 255.0F, (float)this.F.ak), new awg.e(423, bnq.a("tile.oreGold.name"), false), null, new awg.g(194, bnq.a("createWorld.customize.custom.size"), false, this, 1.0F, 50.0F, (float)this.F.al), new awg.g(195, bnq.a("createWorld.customize.custom.count"), false, this, 0.0F, 40.0F, (float)this.F.am), new awg.g(196, bnq.a("createWorld.customize.custom.minHeight"), false, this, 0.0F, 255.0F, (float)this.F.an), new awg.g(197, bnq.a("createWorld.customize.custom.maxHeight"), false, this, 0.0F, 255.0F, (float)this.F.ao), new awg.e(424, bnq.a("tile.oreRedstone.name"), false), null, new awg.g(198, bnq.a("createWorld.customize.custom.size"), false, this, 1.0F, 50.0F, (float)this.F.ap), new awg.g(199, bnq.a("createWorld.customize.custom.count"), false, this, 0.0F, 40.0F, (float)this.F.aq), new awg.g(200, bnq.a("createWorld.customize.custom.minHeight"), false, this, 0.0F, 255.0F, (float)this.F.ar), new awg.g(201, bnq.a("createWorld.customize.custom.maxHeight"), false, this, 0.0F, 255.0F, (float)this.F.as), new awg.e(425, bnq.a("tile.oreDiamond.name"), false), null, new awg.g(202, bnq.a("createWorld.customize.custom.size"), false, this, 1.0F, 50.0F, (float)this.F.at), new awg.g(203, bnq.a("createWorld.customize.custom.count"), false, this, 0.0F, 40.0F, (float)this.F.au), new awg.g(204, bnq.a("createWorld.customize.custom.minHeight"), false, this, 0.0F, 255.0F, (float)this.F.av), new awg.g(205, bnq.a("createWorld.customize.custom.maxHeight"), false, this, 0.0F, 255.0F, (float)this.F.aw), new awg.e(426, bnq.a("tile.oreLapis.name"), false), null, new awg.g(206, bnq.a("createWorld.customize.custom.size"), false, this, 1.0F, 50.0F, (float)this.F.ax), new awg.g(207, bnq.a("createWorld.customize.custom.count"), false, this, 0.0F, 40.0F, (float)this.F.ay), new awg.g(208, bnq.a("createWorld.customize.custom.center"), false, this, 0.0F, 255.0F, (float)this.F.az), new awg.g(209, bnq.a("createWorld.customize.custom.spread"), false, this, 0.0F, 255.0F, (float)this.F.aA)};
      awg.f[] var3 = new awg.f[]{new awg.g(100, bnq.a("createWorld.customize.custom.mainNoiseScaleX"), false, this, 1.0F, 5000.0F, this.F.i), new awg.g(101, bnq.a("createWorld.customize.custom.mainNoiseScaleY"), false, this, 1.0F, 5000.0F, this.F.j), new awg.g(102, bnq.a("createWorld.customize.custom.mainNoiseScaleZ"), false, this, 1.0F, 5000.0F, this.F.k), new awg.g(103, bnq.a("createWorld.customize.custom.depthNoiseScaleX"), false, this, 1.0F, 2000.0F, this.F.f), new awg.g(104, bnq.a("createWorld.customize.custom.depthNoiseScaleZ"), false, this, 1.0F, 2000.0F, this.F.g), new awg.g(105, bnq.a("createWorld.customize.custom.depthNoiseScaleExponent"), false, this, 0.01F, 20.0F, this.F.h), new awg.g(106, bnq.a("createWorld.customize.custom.baseSize"), false, this, 1.0F, 25.0F, this.F.l), new awg.g(107, bnq.a("createWorld.customize.custom.coordinateScale"), false, this, 1.0F, 6000.0F, this.F.b), new awg.g(108, bnq.a("createWorld.customize.custom.heightScale"), false, this, 1.0F, 6000.0F, this.F.c), new awg.g(109, bnq.a("createWorld.customize.custom.stretchY"), false, this, 0.01F, 50.0F, this.F.m), new awg.g(110, bnq.a("createWorld.customize.custom.upperLimitScale"), false, this, 1.0F, 5000.0F, this.F.d), new awg.g(111, bnq.a("createWorld.customize.custom.lowerLimitScale"), false, this, 1.0F, 5000.0F, this.F.e), new awg.g(112, bnq.a("createWorld.customize.custom.biomeDepthWeight"), false, this, 1.0F, 20.0F, this.F.n), new awg.g(113, bnq.a("createWorld.customize.custom.biomeDepthOffset"), false, this, 0.0F, 20.0F, this.F.o), new awg.g(114, bnq.a("createWorld.customize.custom.biomeScaleWeight"), false, this, 1.0F, 20.0F, this.F.p), new awg.g(115, bnq.a("createWorld.customize.custom.biomeScaleOffset"), false, this, 0.0F, 20.0F, this.F.q)};
      awg.f[] var4 = new awg.f[]{new awg.e(400, bnq.a("createWorld.customize.custom.mainNoiseScaleX") + ":", false), new awg.c(132, String.format("%5.3f", this.F.i), false, this.D), new awg.e(401, bnq.a("createWorld.customize.custom.mainNoiseScaleY") + ":", false), new awg.c(133, String.format("%5.3f", this.F.j), false, this.D), new awg.e(402, bnq.a("createWorld.customize.custom.mainNoiseScaleZ") + ":", false), new awg.c(134, String.format("%5.3f", this.F.k), false, this.D), new awg.e(403, bnq.a("createWorld.customize.custom.depthNoiseScaleX") + ":", false), new awg.c(135, String.format("%5.3f", this.F.f), false, this.D), new awg.e(404, bnq.a("createWorld.customize.custom.depthNoiseScaleZ") + ":", false), new awg.c(136, String.format("%5.3f", this.F.g), false, this.D), new awg.e(405, bnq.a("createWorld.customize.custom.depthNoiseScaleExponent") + ":", false), new awg.c(137, String.format("%2.3f", this.F.h), false, this.D), new awg.e(406, bnq.a("createWorld.customize.custom.baseSize") + ":", false), new awg.c(138, String.format("%2.3f", this.F.l), false, this.D), new awg.e(407, bnq.a("createWorld.customize.custom.coordinateScale") + ":", false), new awg.c(139, String.format("%5.3f", this.F.b), false, this.D), new awg.e(408, bnq.a("createWorld.customize.custom.heightScale") + ":", false), new awg.c(140, String.format("%5.3f", this.F.c), false, this.D), new awg.e(409, bnq.a("createWorld.customize.custom.stretchY") + ":", false), new awg.c(141, String.format("%2.3f", this.F.m), false, this.D), new awg.e(410, bnq.a("createWorld.customize.custom.upperLimitScale") + ":", false), new awg.c(142, String.format("%5.3f", this.F.d), false, this.D), new awg.e(411, bnq.a("createWorld.customize.custom.lowerLimitScale") + ":", false), new awg.c(143, String.format("%5.3f", this.F.e), false, this.D), new awg.e(412, bnq.a("createWorld.customize.custom.biomeDepthWeight") + ":", false), new awg.c(144, String.format("%2.3f", this.F.n), false, this.D), new awg.e(413, bnq.a("createWorld.customize.custom.biomeDepthOffset") + ":", false), new awg.c(145, String.format("%2.3f", this.F.o), false, this.D), new awg.e(414, bnq.a("createWorld.customize.custom.biomeScaleWeight") + ":", false), new awg.c(146, String.format("%2.3f", this.F.p), false, this.D), new awg.e(415, bnq.a("createWorld.customize.custom.biomeScaleOffset") + ":", false), new awg.c(147, String.format("%2.3f", this.F.q), false, this.D)};
      this.r = new awg(this.j, this.l, this.m, 32, this.m - 32, 25, this, new awg.f[][]{var1, var2, var3, var4});

      for(int var5 = 0; var5 < 4; ++var5) {
         this.h[var5] = bnq.a("createWorld.customize.custom.page" + var5);
      }

      this.i();
   }

   private void h() {
      switch(this.B) {
      case 300:
         this.a((avs)((awb)this.r.d(300)));
         break;
      case 304:
         this.g();
      }

      this.B = 0;
      this.C = true;
      this.b(false);
   }

   private void i() {
      this.v.l = this.r.e() != 0;
      this.w.l = this.r.e() != this.r.f() - 1;
      this.f = bnq.a("book.pageIndicator", this.r.e() + 1, this.r.f());
      this.g = this.h[this.r.e()];
      this.t.l = this.r.e() != this.r.f() - 1;
   }

   public void a(int var1, int var2, float var3) {
      this.c();
      this.r.a(var1, var2, var3);
      this.a(this.q, this.a, this.l / 2, 2, 16777215);
      this.a(this.q, this.f, this.l / 2, 12, 16777215);
      this.a(this.q, this.g, this.l / 2, 22, 16777215);
      super.a(var1, var2, var3);
      if (this.B != 0) {
         a(0, 0, this.l, this.m, Integer.MIN_VALUE);
         this.a(this.l / 2 - 91, this.l / 2 + 90, 99, -2039584);
         this.a(this.l / 2 - 91, this.l / 2 + 90, 185, -6250336);
         this.b(this.l / 2 - 91, 99, 185, -2039584);
         this.b(this.l / 2 + 90, 99, 185, -6250336);
         float var4 = 85.0F;
         float var5 = 180.0F;
         bfl.f();
         bfl.n();
         bfx var6 = bfx.a();
         bfd var7 = var6.c();
         this.j.P().a(b);
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         float var8 = 32.0F;
         var7.a(7, bms.i);
         var7.b((double)(this.l / 2 - 90), 185.0D, 0.0D).a(0.0D, 2.65625D).b(64, 64, 64, 64).d();
         var7.b((double)(this.l / 2 + 90), 185.0D, 0.0D).a(5.625D, 2.65625D).b(64, 64, 64, 64).d();
         var7.b((double)(this.l / 2 + 90), 100.0D, 0.0D).a(5.625D, 0.0D).b(64, 64, 64, 64).d();
         var7.b((double)(this.l / 2 - 90), 100.0D, 0.0D).a(0.0D, 0.0D).b(64, 64, 64, 64).d();
         var6.b();
         this.a(this.q, bnq.a("createWorld.customize.custom.confirmTitle"), this.l / 2, 105, 16777215);
         this.a(this.q, bnq.a("createWorld.customize.custom.confirm1"), this.l / 2, 125, 16777215);
         this.a(this.q, bnq.a("createWorld.customize.custom.confirm2"), this.l / 2, 135, 16777215);
         this.x.a(this.j, var1, var2);
         this.y.a(this.j, var1, var2);
      }

   }

   public void a(int var1, boolean var2) {
      switch(var1) {
      case 148:
         this.F.s = var2;
         break;
      case 149:
         this.F.t = var2;
         break;
      case 150:
         this.F.v = var2;
         break;
      case 151:
         this.F.w = var2;
         break;
      case 152:
         this.F.x = var2;
         break;
      case 153:
         this.F.y = var2;
         break;
      case 154:
         this.F.A = var2;
         break;
      case 155:
         this.F.B = var2;
         break;
      case 156:
         this.F.D = var2;
         break;
      case 161:
         this.F.F = var2;
         break;
      case 210:
         this.F.z = var2;
      }

      if (!this.F.equals(this.E)) {
         this.a(true);
      }

   }
}
