import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

public class avh {
   public boolean Q;
   public avb au;
   public float H;
   public boolean aG;
   public avb Y;
   public List<String> l = Lists.newArrayList();
   public boolean V;
   public boolean w;
   private static final String[] aZ = new String[]{"options.off", "options.graphics.fast", "options.graphics.fancy"};
   private static final String[] aV = new String[]{"options.stream.compression.low", "options.stream.compression.medium", "options.stream.compression.high"};
   public boolean s;
   public avb ac;
   public int aM;
   public avb[] ax;
   public boolean z;
   public int h = 2;
   public boolean t;
   public float L;
   private static final String[] aS = new String[]{"options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large"};
   protected ave ay;
   public int B;
   public boolean x;
   public int S;
   public float F;
   public float a = 0.5F;
   public boolean aC;
   public boolean v;
   public int T;
   private static final String[] aW = new String[]{"options.stream.chat.enabled.streaming", "options.stream.chat.enabled.always", "options.stream.chat.enabled.never"};
   public boolean X;
   public float aK;
   public int P;
   private static final Gson aQ = new Gson();
   private static final String[] aU = new String[]{"options.ao.off", "options.ao.min", "options.ao.max"};
   public avb as;
   public boolean D;
   public boolean n;
   public int C;
   public avb ah;
   public float M;
   private static final String[] aY = new String[]{"options.stream.mic_toggle.mute", "options.stream.mic_toggle.talk"};
   private File bc;
   public boolean f = true;
   public boolean aD;
   public avb av;
   public boolean aE;
   public boolean d = true;
   public boolean u;
   public avb ae;
   public boolean i = true;
   public float G;
   public boolean e;
   public String aN;
   public avb am;
   public avb ar;
   public float K;
   public String R;
   private static final String[] aX = new String[]{"options.stream.chat.userFilter.all", "options.stream.chat.userFilter.subs", "options.stream.chat.userFilter.mods"};
   public float aJ;
   private static final String[] aT = new String[]{"options.particles.all", "options.particles.decreased", "options.particles.minimal"};
   public int U;
   public boolean o;
   public boolean y;
   public avb af;
   public String aF;
   public avb aj;
   private final Set<wo> ba;
   public avb ak;
   public avb an;
   public boolean aA;
   public avb ai;
   public boolean aO;
   public boolean b;
   public boolean aH;
   private static final Logger aP = LogManager.getLogger();
   public wn.b m;
   public int aB;
   public avb ap;
   public List<String> k = Lists.newArrayList();
   public int g = 120;
   public float N;
   public float O;
   public int j = 2;
   private Map<bpg, Float> bb;
   public avb aa;
   public avb[] aw;
   public boolean r;
   public float q;
   public int J;
   public oj az;
   private static final ParameterizedType aR = new ParameterizedType() {
      public Type getRawType() {
         return List.class;
      }

      public Type[] getActualTypeArguments() {
         return new Type[]{String.class};
      }

      public Type getOwnerType() {
         return null;
      }
   };
   public avb at;
   public int c = -1;
   public avb ab;
   public boolean A;
   public avb aq;
   public avb ag;
   public avb ad;
   public avb Z;
   public avb al;
   public float aI;
   public avb ao;
   public float E;
   public boolean I;
   public int aL;
   public boolean W;
   public boolean p;

   public String c(avh.a var1) {
      String var2 = bnq.a(var1.d()) + ": ";
      if (var1.a()) {
         float var6 = this.a(var1);
         float var4 = var1.c(var6);
         if (var1 == avh.a.b) {
            if (var4 == 0.0F) {
               return var2 + bnq.a("options.sensitivity.min");
            } else {
               return var4 == 1.0F ? var2 + bnq.a("options.sensitivity.max") : var2 + (int)(var4 * 200.0F) + "%";
            }
         } else if (var1 == avh.a.c) {
            if (var6 == 70.0F) {
               return var2 + bnq.a("options.fov.min");
            } else {
               return var6 == 110.0F ? var2 + bnq.a("options.fov.max") : var2 + (int)var6;
            }
         } else if (var1 == avh.a.i) {
            return var6 == avh.a.a(var1) ? var2 + bnq.a("options.framerateLimit.max") : var2 + (int)var6 + " fps";
         } else if (var1 == avh.a.k) {
            return var6 == avh.a.b(var1) ? var2 + bnq.a("options.cloudHeight.min") : var2 + ((int)var6 + 128);
         } else if (var1 == avh.a.d) {
            if (var4 == 0.0F) {
               return var2 + bnq.a("options.gamma.min");
            } else {
               return var4 == 1.0F ? var2 + bnq.a("options.gamma.max") : var2 + "+" + (int)(var4 * 100.0F) + "%";
            }
         } else if (var1 == avh.a.e) {
            return var2 + (int)(var4 * 400.0F) + "%";
         } else if (var1 == avh.a.s) {
            return var2 + (int)(var4 * 90.0F + 10.0F) + "%";
         } else if (var1 == avh.a.C) {
            return var2 + avt.b(var4) + "px";
         } else if (var1 == avh.a.B) {
            return var2 + avt.b(var4) + "px";
         } else if (var1 == avh.a.A) {
            return var2 + avt.a(var4) + "px";
         } else if (var1 == avh.a.f) {
            return var2 + (int)var6 + " chunks";
         } else if (var1 == avh.a.D) {
            return var6 == 0.0F ? var2 + bnq.a("options.off") : var2 + (int)var6;
         } else if (var1 == avh.a.J) {
            return var2 + bqn.a(var4) + " fps";
         } else if (var1 == avh.a.I) {
            return var2 + bqn.b(var4) + " Kbps";
         } else if (var1 == avh.a.F) {
            return var2 + String.format("%.3f bpp", bqn.c(var4));
         } else {
            return var4 == 0.0F ? var2 + bnq.a("options.off") : var2 + (int)(var4 * 100.0F) + "%";
         }
      } else if (var1.b()) {
         boolean var5 = this.b(var1);
         return var5 ? var2 + bnq.a("options.on") : var2 + bnq.a("options.off");
      } else if (var1 == avh.a.n) {
         return var2 + a(aS, this.aL);
      } else if (var1 == avh.a.p) {
         return var2 + bnq.a(this.m.b());
      } else if (var1 == avh.a.o) {
         return var2 + a(aT, this.aM);
      } else if (var1 == avh.a.m) {
         return var2 + a(aU, this.j);
      } else if (var1 == avh.a.K) {
         return var2 + a(aV, this.P);
      } else if (var1 == avh.a.M) {
         return var2 + a(aW, this.S);
      } else if (var1 == avh.a.N) {
         return var2 + a(aX, this.T);
      } else if (var1 == avh.a.O) {
         return var2 + a(aY, this.U);
      } else if (var1 == avh.a.k) {
         return var2 + a(aZ, this.h);
      } else if (var1 == avh.a.l) {
         if (this.i) {
            return var2 + bnq.a("options.graphics.fancy");
         } else {
            String var3 = "options.graphics.fast";
            return var2 + bnq.a("options.graphics.fast");
         }
      } else {
         return var2;
      }
   }

   public avh() {
      this.m = wn.b.a;
      this.n = true;
      this.o = true;
      this.p = true;
      this.q = 1.0F;
      this.r = true;
      this.t = true;
      this.u = false;
      this.v = true;
      this.w = false;
      this.z = true;
      this.ba = Sets.newHashSet(wo.values());
      this.D = true;
      this.E = 1.0F;
      this.F = 1.0F;
      this.G = 0.44366196F;
      this.H = 1.0F;
      this.I = true;
      this.J = 4;
      this.bb = Maps.newEnumMap(bpg.class);
      this.K = 0.5F;
      this.L = 1.0F;
      this.M = 1.0F;
      this.N = 0.5412844F;
      this.O = 0.31690142F;
      this.P = 1;
      this.Q = true;
      this.R = "";
      this.S = 0;
      this.T = 0;
      this.U = 0;
      this.V = true;
      this.W = true;
      this.X = true;
      this.Y = new avb("key.forward", 17, "key.categories.movement");
      this.Z = new avb("key.left", 30, "key.categories.movement");
      this.aa = new avb("key.back", 31, "key.categories.movement");
      this.ab = new avb("key.right", 32, "key.categories.movement");
      this.ac = new avb("key.jump", 57, "key.categories.movement");
      this.ad = new avb("key.sneak", 42, "key.categories.movement");
      this.ae = new avb("key.sprint", 29, "key.categories.movement");
      this.af = new avb("key.inventory", 18, "key.categories.inventory");
      this.ag = new avb("key.use", -99, "key.categories.gameplay");
      this.ah = new avb("key.drop", 16, "key.categories.gameplay");
      this.ai = new avb("key.attack", -100, "key.categories.gameplay");
      this.aj = new avb("key.pickItem", -98, "key.categories.gameplay");
      this.ak = new avb("key.chat", 20, "key.categories.multiplayer");
      this.al = new avb("key.playerlist", 15, "key.categories.multiplayer");
      this.am = new avb("key.command", 53, "key.categories.multiplayer");
      this.an = new avb("key.screenshot", 60, "key.categories.misc");
      this.ao = new avb("key.togglePerspective", 63, "key.categories.misc");
      this.ap = new avb("key.smoothCamera", 0, "key.categories.misc");
      this.aq = new avb("key.fullscreen", 87, "key.categories.misc");
      this.ar = new avb("key.spectatorOutlines", 0, "key.categories.misc");
      this.as = new avb("key.streamStartStop", 64, "key.categories.stream");
      this.at = new avb("key.streamPauseUnpause", 65, "key.categories.stream");
      this.au = new avb("key.streamCommercial", 0, "key.categories.stream");
      this.av = new avb("key.streamToggleMic", 0, "key.categories.stream");
      this.aw = new avb[]{new avb("key.hotbar.1", 2, "key.categories.inventory"), new avb("key.hotbar.2", 3, "key.categories.inventory"), new avb("key.hotbar.3", 4, "key.categories.inventory"), new avb("key.hotbar.4", 5, "key.categories.inventory"), new avb("key.hotbar.5", 6, "key.categories.inventory"), new avb("key.hotbar.6", 7, "key.categories.inventory"), new avb("key.hotbar.7", 8, "key.categories.inventory"), new avb("key.hotbar.8", 9, "key.categories.inventory"), new avb("key.hotbar.9", 10, "key.categories.inventory")};
      this.ax = (avb[])ArrayUtils.addAll(new avb[]{this.ai, this.ag, this.Y, this.Z, this.aa, this.ab, this.ac, this.ad, this.ae, this.ah, this.af, this.ak, this.al, this.aj, this.am, this.an, this.ao, this.ap, this.as, this.at, this.au, this.av, this.aq, this.ar}, this.aw);
      this.az = oj.c;
      this.aF = "";
      this.aI = 70.0F;
      this.aN = "en_US";
      this.aO = false;
   }

   public float a(avh.a var1) {
      if (var1 == avh.a.c) {
         return this.aI;
      } else if (var1 == avh.a.d) {
         return this.aJ;
      } else if (var1 == avh.a.e) {
         return this.aK;
      } else if (var1 == avh.a.b) {
         return this.a;
      } else if (var1 == avh.a.s) {
         return this.q;
      } else if (var1 == avh.a.B) {
         return this.H;
      } else if (var1 == avh.a.C) {
         return this.G;
      } else if (var1 == avh.a.z) {
         return this.E;
      } else if (var1 == avh.a.A) {
         return this.F;
      } else if (var1 == avh.a.i) {
         return (float)this.g;
      } else if (var1 == avh.a.D) {
         return (float)this.J;
      } else if (var1 == avh.a.f) {
         return (float)this.c;
      } else if (var1 == avh.a.F) {
         return this.K;
      } else if (var1 == avh.a.G) {
         return this.L;
      } else if (var1 == avh.a.H) {
         return this.M;
      } else if (var1 == avh.a.I) {
         return this.N;
      } else {
         return var1 == avh.a.J ? this.O : 0.0F;
      }
   }

   public boolean b(avh.a var1) {
      switch(var1) {
      case a:
         return this.b;
      case g:
         return this.d;
      case h:
         return this.e;
      case j:
         return this.f;
      case q:
         return this.n;
      case r:
         return this.o;
      case t:
         return this.p;
      case u:
         return this.r;
      case v:
         return this.s;
      case w:
         return this.t;
      case x:
         return this.u;
      case y:
         return this.A;
      case L:
         return this.Q;
      case E:
         return this.aO;
      case P:
         return this.v;
      case Q:
         return this.w;
      case R:
         return this.W;
      case S:
         return this.X;
      default:
         return false;
      }
   }

   public Set<wo> d() {
      return ImmutableSet.copyOf(this.ba);
   }

   public void a(wo var1, boolean var2) {
      if (var2) {
         this.ba.add(var1);
      } else {
         this.ba.remove(var1);
      }

      this.c();
   }

   public void a(avh.a var1, float var2) {
      if (var1 == avh.a.b) {
         this.a = var2;
      }

      if (var1 == avh.a.c) {
         this.aI = var2;
      }

      if (var1 == avh.a.d) {
         this.aJ = var2;
      }

      if (var1 == avh.a.i) {
         this.g = (int)var2;
      }

      if (var1 == avh.a.s) {
         this.q = var2;
         this.ay.q.d().b();
      }

      if (var1 == avh.a.B) {
         this.H = var2;
         this.ay.q.d().b();
      }

      if (var1 == avh.a.C) {
         this.G = var2;
         this.ay.q.d().b();
      }

      if (var1 == avh.a.A) {
         this.F = var2;
         this.ay.q.d().b();
      }

      if (var1 == avh.a.z) {
         this.E = var2;
         this.ay.q.d().b();
      }

      if (var1 == avh.a.D) {
         int var3 = this.J;
         this.J = (int)var2;
         if ((float)var3 != var2) {
            this.ay.T().a(this.J);
            this.ay.P().a(bmh.g);
            this.ay.T().a(false, this.J > 0);
            this.ay.B();
         }
      }

      if (var1 == avh.a.P) {
         this.v = !this.v;
         this.ay.g.a();
      }

      if (var1 == avh.a.f) {
         this.c = (int)var2;
         this.ay.g.m();
      }

      if (var1 == avh.a.F) {
         this.K = var2;
      }

      if (var1 == avh.a.G) {
         this.L = var2;
         this.ay.Y().p();
      }

      if (var1 == avh.a.H) {
         this.M = var2;
         this.ay.Y().p();
      }

      if (var1 == avh.a.I) {
         this.N = var2;
      }

      if (var1 == avh.a.J) {
         this.O = var2;
      }

   }

   public void a(avh.a var1, int var2) {
      if (var1 == avh.a.a) {
         this.b = !this.b;
      }

      if (var1 == avh.a.n) {
         this.aL = this.aL + var2 & 3;
      }

      if (var1 == avh.a.o) {
         this.aM = (this.aM + var2) % 3;
      }

      if (var1 == avh.a.g) {
         this.d = !this.d;
      }

      if (var1 == avh.a.k) {
         this.h = (this.h + var2) % 3;
      }

      if (var1 == avh.a.E) {
         this.aO = !this.aO;
         this.ay.k.a(this.ay.S().a() || this.aO);
      }

      if (var1 == avh.a.j) {
         this.f = !this.f;
      }

      if (var1 == avh.a.h) {
         this.e = !this.e;
         this.ay.e();
      }

      if (var1 == avh.a.l) {
         this.i = !this.i;
         this.ay.g.a();
      }

      if (var1 == avh.a.m) {
         this.j = (this.j + var2) % 3;
         this.ay.g.a();
      }

      if (var1 == avh.a.p) {
         this.m = wn.b.a((this.m.a() + var2) % 3);
      }

      if (var1 == avh.a.K) {
         this.P = (this.P + var2) % 3;
      }

      if (var1 == avh.a.L) {
         this.Q = !this.Q;
      }

      if (var1 == avh.a.M) {
         this.S = (this.S + var2) % 3;
      }

      if (var1 == avh.a.N) {
         this.T = (this.T + var2) % 3;
      }

      if (var1 == avh.a.O) {
         this.U = (this.U + var2) % 2;
      }

      if (var1 == avh.a.q) {
         this.n = !this.n;
      }

      if (var1 == avh.a.r) {
         this.o = !this.o;
      }

      if (var1 == avh.a.t) {
         this.p = !this.p;
      }

      if (var1 == avh.a.u) {
         this.r = !this.r;
      }

      if (var1 == avh.a.y) {
         this.A = !this.A;
      }

      if (var1 == avh.a.v) {
         this.s = !this.s;
         if (this.ay.K() != this.s) {
            this.ay.q();
         }
      }

      if (var1 == avh.a.w) {
         this.t = !this.t;
         Display.setVSyncEnabled(this.t);
      }

      if (var1 == avh.a.x) {
         this.u = !this.u;
         this.ay.g.a();
      }

      if (var1 == avh.a.P) {
         this.v = !this.v;
         this.ay.g.a();
      }

      if (var1 == avh.a.Q) {
         this.w = !this.w;
      }

      if (var1 == avh.a.R) {
         this.W = !this.W;
      }

      if (var1 == avh.a.S) {
         this.X = !this.X;
      }

      this.b();
   }

   private static String a(String[] var0, int var1) {
      if (var1 < 0 || var1 >= var0.length) {
         var1 = 0;
      }

      return bnq.a(var0[var1]);
   }

   public static boolean a(avb var0) {
      if (var0.i() == 0) {
         return false;
      } else {
         return var0.i() < 0 ? Mouse.isButtonDown(var0.i() + 100) : Keyboard.isKeyDown(var0.i());
      }
   }

   public avh(ave var1, File var2) {
      this.m = wn.b.a;
      this.n = true;
      this.o = true;
      this.p = true;
      this.q = 1.0F;
      this.r = true;
      this.t = true;
      this.u = false;
      this.v = true;
      this.w = false;
      this.z = true;
      this.ba = Sets.newHashSet(wo.values());
      this.D = true;
      this.E = 1.0F;
      this.F = 1.0F;
      this.G = 0.44366196F;
      this.H = 1.0F;
      this.I = true;
      this.J = 4;
      this.bb = Maps.newEnumMap(bpg.class);
      this.K = 0.5F;
      this.L = 1.0F;
      this.M = 1.0F;
      this.N = 0.5412844F;
      this.O = 0.31690142F;
      this.P = 1;
      this.Q = true;
      this.R = "";
      this.S = 0;
      this.T = 0;
      this.U = 0;
      this.V = true;
      this.W = true;
      this.X = true;
      this.Y = new avb("key.forward", 17, "key.categories.movement");
      this.Z = new avb("key.left", 30, "key.categories.movement");
      this.aa = new avb("key.back", 31, "key.categories.movement");
      this.ab = new avb("key.right", 32, "key.categories.movement");
      this.ac = new avb("key.jump", 57, "key.categories.movement");
      this.ad = new avb("key.sneak", 42, "key.categories.movement");
      this.ae = new avb("key.sprint", 29, "key.categories.movement");
      this.af = new avb("key.inventory", 18, "key.categories.inventory");
      this.ag = new avb("key.use", -99, "key.categories.gameplay");
      this.ah = new avb("key.drop", 16, "key.categories.gameplay");
      this.ai = new avb("key.attack", -100, "key.categories.gameplay");
      this.aj = new avb("key.pickItem", -98, "key.categories.gameplay");
      this.ak = new avb("key.chat", 20, "key.categories.multiplayer");
      this.al = new avb("key.playerlist", 15, "key.categories.multiplayer");
      this.am = new avb("key.command", 53, "key.categories.multiplayer");
      this.an = new avb("key.screenshot", 60, "key.categories.misc");
      this.ao = new avb("key.togglePerspective", 63, "key.categories.misc");
      this.ap = new avb("key.smoothCamera", 0, "key.categories.misc");
      this.aq = new avb("key.fullscreen", 87, "key.categories.misc");
      this.ar = new avb("key.spectatorOutlines", 0, "key.categories.misc");
      this.as = new avb("key.streamStartStop", 64, "key.categories.stream");
      this.at = new avb("key.streamPauseUnpause", 65, "key.categories.stream");
      this.au = new avb("key.streamCommercial", 0, "key.categories.stream");
      this.av = new avb("key.streamToggleMic", 0, "key.categories.stream");
      this.aw = new avb[]{new avb("key.hotbar.1", 2, "key.categories.inventory"), new avb("key.hotbar.2", 3, "key.categories.inventory"), new avb("key.hotbar.3", 4, "key.categories.inventory"), new avb("key.hotbar.4", 5, "key.categories.inventory"), new avb("key.hotbar.5", 6, "key.categories.inventory"), new avb("key.hotbar.6", 7, "key.categories.inventory"), new avb("key.hotbar.7", 8, "key.categories.inventory"), new avb("key.hotbar.8", 9, "key.categories.inventory"), new avb("key.hotbar.9", 10, "key.categories.inventory")};
      this.ax = (avb[])ArrayUtils.addAll(new avb[]{this.ai, this.ag, this.Y, this.Z, this.aa, this.ab, this.ac, this.ad, this.ae, this.ah, this.af, this.ak, this.al, this.aj, this.am, this.an, this.ao, this.ap, this.as, this.at, this.au, this.av, this.aq, this.ar}, this.aw);
      this.az = oj.c;
      this.aF = "";
      this.aI = 70.0F;
      this.aN = "en_US";
      this.aO = false;
      this.ay = var1;
      this.bc = new File(var2, "options.txt");
      if (var1.U() && Runtime.getRuntime().maxMemory() >= 1000000000L) {
         avh.a.f.a(32.0F);
      } else {
         avh.a.f.a(16.0F);
      }

      this.c = var1.U() ? 12 : 8;
      this.a();
   }

   private float a(String var1) {
      if (var1.equals("true")) {
         return 1.0F;
      } else {
         return var1.equals("false") ? 0.0F : Float.parseFloat(var1);
      }
   }

   public int e() {
      return this.c >= 4 ? this.h : 0;
   }

   public static String c(int var0) {
      if (var0 < 0) {
         return bnq.a("key.mouseButton", var0 + 101);
      } else {
         return var0 < 256 ? Keyboard.getKeyName(var0) : String.format("%c", (char)(var0 - 256)).toUpperCase();
      }
   }

   public void c() {
      if (this.ay.h != null) {
         int var1 = 0;

         wo var3;
         for(Iterator var2 = this.ba.iterator(); var2.hasNext(); var1 |= var3.a()) {
            var3 = (wo)var2.next();
         }

         this.ay.h.a.a((ff)(new ih(this.aN, this.c, this.m, this.n, var1)));
      }

   }

   public boolean f() {
      return this.V;
   }

   public void b() {
      try {
         PrintWriter var1 = new PrintWriter(new FileWriter(this.bc));
         var1.println("invertYMouse:" + this.b);
         var1.println("mouseSensitivity:" + this.a);
         var1.println("fov:" + (this.aI - 70.0F) / 40.0F);
         var1.println("gamma:" + this.aJ);
         var1.println("saturation:" + this.aK);
         var1.println("renderDistance:" + this.c);
         var1.println("guiScale:" + this.aL);
         var1.println("particles:" + this.aM);
         var1.println("bobView:" + this.d);
         var1.println("anaglyph3d:" + this.e);
         var1.println("maxFps:" + this.g);
         var1.println("fboEnable:" + this.f);
         var1.println("difficulty:" + this.az.a());
         var1.println("fancyGraphics:" + this.i);
         var1.println("ao:" + this.j);
         switch(this.h) {
         case 0:
            var1.println("renderClouds:false");
            break;
         case 1:
            var1.println("renderClouds:fast");
            break;
         case 2:
            var1.println("renderClouds:true");
         }

         var1.println("resourcePacks:" + aQ.toJson(this.k));
         var1.println("incompatibleResourcePacks:" + aQ.toJson(this.l));
         var1.println("lastServer:" + this.aF);
         var1.println("lang:" + this.aN);
         var1.println("chatVisibility:" + this.m.a());
         var1.println("chatColors:" + this.n);
         var1.println("chatLinks:" + this.o);
         var1.println("chatLinksPrompt:" + this.p);
         var1.println("chatOpacity:" + this.q);
         var1.println("snooperEnabled:" + this.r);
         var1.println("fullscreen:" + this.s);
         var1.println("enableVsync:" + this.t);
         var1.println("useVbo:" + this.u);
         var1.println("hideServerAddress:" + this.x);
         var1.println("advancedItemTooltips:" + this.y);
         var1.println("pauseOnLostFocus:" + this.z);
         var1.println("touchscreen:" + this.A);
         var1.println("overrideWidth:" + this.B);
         var1.println("overrideHeight:" + this.C);
         var1.println("heldItemTooltips:" + this.D);
         var1.println("chatHeightFocused:" + this.H);
         var1.println("chatHeightUnfocused:" + this.G);
         var1.println("chatScale:" + this.E);
         var1.println("chatWidth:" + this.F);
         var1.println("showInventoryAchievementHint:" + this.I);
         var1.println("mipmapLevels:" + this.J);
         var1.println("streamBytesPerPixel:" + this.K);
         var1.println("streamMicVolume:" + this.L);
         var1.println("streamSystemVolume:" + this.M);
         var1.println("streamKbps:" + this.N);
         var1.println("streamFps:" + this.O);
         var1.println("streamCompression:" + this.P);
         var1.println("streamSendMetadata:" + this.Q);
         var1.println("streamPreferredServer:" + this.R);
         var1.println("streamChatEnabled:" + this.S);
         var1.println("streamChatUserFilter:" + this.T);
         var1.println("streamMicToggleBehavior:" + this.U);
         var1.println("forceUnicodeFont:" + this.aO);
         var1.println("allowBlockAlternatives:" + this.v);
         var1.println("reducedDebugInfo:" + this.w);
         var1.println("useNativeTransport:" + this.V);
         var1.println("entityShadows:" + this.W);
         var1.println("realmsNotifications:" + this.X);
         avb[] var2 = this.ax;
         int var3 = var2.length;

         int var4;
         for(var4 = 0; var4 < var3; ++var4) {
            avb var5 = var2[var4];
            var1.println("key_" + var5.g() + ":" + var5.i());
         }

         bpg[] var7 = bpg.values();
         var3 = var7.length;

         for(var4 = 0; var4 < var3; ++var4) {
            bpg var9 = var7[var4];
            var1.println("soundCategory_" + var9.a() + ":" + this.a(var9));
         }

         wo[] var8 = wo.values();
         var3 = var8.length;

         for(var4 = 0; var4 < var3; ++var4) {
            wo var10 = var8[var4];
            var1.println("modelPart_" + var10.c() + ":" + this.ba.contains(var10));
         }

         var1.close();
      } catch (Exception var6) {
         aP.error("Failed to save options", var6);
      }

      this.c();
   }

   public void a(wo var1) {
      if (!this.d().contains(var1)) {
         this.ba.add(var1);
      } else {
         this.ba.remove(var1);
      }

      this.c();
   }

   public void a(avb var1, int var2) {
      var1.b(var2);
      this.b();
   }

   public float a(bpg var1) {
      return this.bb.containsKey(var1) ? (Float)this.bb.get(var1) : 1.0F;
   }

   public void a(bpg var1, float var2) {
      this.ay.W().a(var1, var2);
      this.bb.put(var1, var2);
   }

   public void a() {
      try {
         if (!this.bc.exists()) {
            return;
         }

         BufferedReader var1 = new BufferedReader(new FileReader(this.bc));
         String var2 = "";
         this.bb.clear();

         while((var2 = var1.readLine()) != null) {
            try {
               String[] var3 = var2.split(":");
               if (var3[0].equals("mouseSensitivity")) {
                  this.a = this.a(var3[1]);
               }

               if (var3[0].equals("fov")) {
                  this.aI = this.a(var3[1]) * 40.0F + 70.0F;
               }

               if (var3[0].equals("gamma")) {
                  this.aJ = this.a(var3[1]);
               }

               if (var3[0].equals("saturation")) {
                  this.aK = this.a(var3[1]);
               }

               if (var3[0].equals("invertYMouse")) {
                  this.b = var3[1].equals("true");
               }

               if (var3[0].equals("renderDistance")) {
                  this.c = Integer.parseInt(var3[1]);
               }

               if (var3[0].equals("guiScale")) {
                  this.aL = Integer.parseInt(var3[1]);
               }

               if (var3[0].equals("particles")) {
                  this.aM = Integer.parseInt(var3[1]);
               }

               if (var3[0].equals("bobView")) {
                  this.d = var3[1].equals("true");
               }

               if (var3[0].equals("anaglyph3d")) {
                  this.e = var3[1].equals("true");
               }

               if (var3[0].equals("maxFps")) {
                  this.g = Integer.parseInt(var3[1]);
               }

               if (var3[0].equals("fboEnable")) {
                  this.f = var3[1].equals("true");
               }

               if (var3[0].equals("difficulty")) {
                  this.az = oj.a(Integer.parseInt(var3[1]));
               }

               if (var3[0].equals("fancyGraphics")) {
                  this.i = var3[1].equals("true");
               }

               if (var3[0].equals("ao")) {
                  if (var3[1].equals("true")) {
                     this.j = 2;
                  } else if (var3[1].equals("false")) {
                     this.j = 0;
                  } else {
                     this.j = Integer.parseInt(var3[1]);
                  }
               }

               if (var3[0].equals("renderClouds")) {
                  if (var3[1].equals("true")) {
                     this.h = 2;
                  } else if (var3[1].equals("false")) {
                     this.h = 0;
                  } else if (var3[1].equals("fast")) {
                     this.h = 1;
                  }
               }

               if (var3[0].equals("resourcePacks")) {
                  this.k = (List)aQ.fromJson(var2.substring(var2.indexOf(58) + 1), aR);
                  if (this.k == null) {
                     this.k = Lists.newArrayList();
                  }
               }

               if (var3[0].equals("incompatibleResourcePacks")) {
                  this.l = (List)aQ.fromJson(var2.substring(var2.indexOf(58) + 1), aR);
                  if (this.l == null) {
                     this.l = Lists.newArrayList();
                  }
               }

               if (var3[0].equals("lastServer") && var3.length >= 2) {
                  this.aF = var2.substring(var2.indexOf(58) + 1);
               }

               if (var3[0].equals("lang") && var3.length >= 2) {
                  this.aN = var3[1];
               }

               if (var3[0].equals("chatVisibility")) {
                  this.m = wn.b.a(Integer.parseInt(var3[1]));
               }

               if (var3[0].equals("chatColors")) {
                  this.n = var3[1].equals("true");
               }

               if (var3[0].equals("chatLinks")) {
                  this.o = var3[1].equals("true");
               }

               if (var3[0].equals("chatLinksPrompt")) {
                  this.p = var3[1].equals("true");
               }

               if (var3[0].equals("chatOpacity")) {
                  this.q = this.a(var3[1]);
               }

               if (var3[0].equals("snooperEnabled")) {
                  this.r = var3[1].equals("true");
               }

               if (var3[0].equals("fullscreen")) {
                  this.s = var3[1].equals("true");
               }

               if (var3[0].equals("enableVsync")) {
                  this.t = var3[1].equals("true");
               }

               if (var3[0].equals("useVbo")) {
                  this.u = var3[1].equals("true");
               }

               if (var3[0].equals("hideServerAddress")) {
                  this.x = var3[1].equals("true");
               }

               if (var3[0].equals("advancedItemTooltips")) {
                  this.y = var3[1].equals("true");
               }

               if (var3[0].equals("pauseOnLostFocus")) {
                  this.z = var3[1].equals("true");
               }

               if (var3[0].equals("touchscreen")) {
                  this.A = var3[1].equals("true");
               }

               if (var3[0].equals("overrideHeight")) {
                  this.C = Integer.parseInt(var3[1]);
               }

               if (var3[0].equals("overrideWidth")) {
                  this.B = Integer.parseInt(var3[1]);
               }

               if (var3[0].equals("heldItemTooltips")) {
                  this.D = var3[1].equals("true");
               }

               if (var3[0].equals("chatHeightFocused")) {
                  this.H = this.a(var3[1]);
               }

               if (var3[0].equals("chatHeightUnfocused")) {
                  this.G = this.a(var3[1]);
               }

               if (var3[0].equals("chatScale")) {
                  this.E = this.a(var3[1]);
               }

               if (var3[0].equals("chatWidth")) {
                  this.F = this.a(var3[1]);
               }

               if (var3[0].equals("showInventoryAchievementHint")) {
                  this.I = var3[1].equals("true");
               }

               if (var3[0].equals("mipmapLevels")) {
                  this.J = Integer.parseInt(var3[1]);
               }

               if (var3[0].equals("streamBytesPerPixel")) {
                  this.K = this.a(var3[1]);
               }

               if (var3[0].equals("streamMicVolume")) {
                  this.L = this.a(var3[1]);
               }

               if (var3[0].equals("streamSystemVolume")) {
                  this.M = this.a(var3[1]);
               }

               if (var3[0].equals("streamKbps")) {
                  this.N = this.a(var3[1]);
               }

               if (var3[0].equals("streamFps")) {
                  this.O = this.a(var3[1]);
               }

               if (var3[0].equals("streamCompression")) {
                  this.P = Integer.parseInt(var3[1]);
               }

               if (var3[0].equals("streamSendMetadata")) {
                  this.Q = var3[1].equals("true");
               }

               if (var3[0].equals("streamPreferredServer") && var3.length >= 2) {
                  this.R = var2.substring(var2.indexOf(58) + 1);
               }

               if (var3[0].equals("streamChatEnabled")) {
                  this.S = Integer.parseInt(var3[1]);
               }

               if (var3[0].equals("streamChatUserFilter")) {
                  this.T = Integer.parseInt(var3[1]);
               }

               if (var3[0].equals("streamMicToggleBehavior")) {
                  this.U = Integer.parseInt(var3[1]);
               }

               if (var3[0].equals("forceUnicodeFont")) {
                  this.aO = var3[1].equals("true");
               }

               if (var3[0].equals("allowBlockAlternatives")) {
                  this.v = var3[1].equals("true");
               }

               if (var3[0].equals("reducedDebugInfo")) {
                  this.w = var3[1].equals("true");
               }

               if (var3[0].equals("useNativeTransport")) {
                  this.V = var3[1].equals("true");
               }

               if (var3[0].equals("entityShadows")) {
                  this.W = var3[1].equals("true");
               }

               if (var3[0].equals("realmsNotifications")) {
                  this.X = var3[1].equals("true");
               }

               avb[] var4 = this.ax;
               int var5 = var4.length;

               int var6;
               for(var6 = 0; var6 < var5; ++var6) {
                  avb var7 = var4[var6];
                  if (var3[0].equals("key_" + var7.g())) {
                     var7.b(Integer.parseInt(var3[1]));
                  }
               }

               bpg[] var10 = bpg.values();
               var5 = var10.length;

               for(var6 = 0; var6 < var5; ++var6) {
                  bpg var12 = var10[var6];
                  if (var3[0].equals("soundCategory_" + var12.a())) {
                     this.bb.put(var12, this.a(var3[1]));
                  }
               }

               wo[] var11 = wo.values();
               var5 = var11.length;

               for(var6 = 0; var6 < var5; ++var6) {
                  wo var13 = var11[var6];
                  if (var3[0].equals("modelPart_" + var13.c())) {
                     this.a(var13, var3[1].equals("true"));
                  }
               }
            } catch (Exception var8) {
               aP.warn("Skipping bad option: " + var2);
            }
         }

         avb.b();
         var1.close();
      } catch (Exception var9) {
         aP.error("Failed to load options", var9);
      }

   }

   public static enum a {
      Q("options.reducedDebugInfo", false, true),
      j("options.fboEnable", false, true),
      b("options.sensitivity", true, false),
      u("options.snooper", false, true),
      f("options.renderDistance", true, false, 2.0F, 16.0F, 1.0F),
      n("options.guiScale", false, false),
      g("options.viewBobbing", false, true);

      private final boolean U;
      y("options.touchscreen", false, true),
      F("options.stream.bytesPerPixel", true, false),
      c("options.fov", true, false, 30.0F, 110.0F, 1.0F);

      private final boolean T;
      v("options.fullscreen", false, true),
      r("options.chat.links", false, true),
      O("options.stream.micToggleBehavior", false, false),
      J("options.stream.fps", true, false),
      h("options.anaglyph", false, true),
      K("options.stream.compression", false, false);

      private float Y;
      x("options.vbo", false, true),
      o("options.particles", false, false);

      private final String V;
      B("options.chat.height.focused", true, false);

      private static final avh.a[] Z = new avh.a[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S};
      w("options.vsync", false, true),
      z("options.chat.scale", true, false),
      S("options.realmsNotifications", false, true),
      l("options.graphics", false, false),
      L("options.stream.sendMetadata", false, true),
      D("options.mipmapLevels", true, false, 0.0F, 4.0F, 1.0F);

      private final float W;
      A("options.chat.width", true, false),
      M("options.stream.chat.enabled", false, false),
      p("options.chat.visibility", false, false),
      t("options.chat.links.prompt", false, true),
      q("options.chat.color", false, true),
      I("options.stream.kbps", true, false),
      G("options.stream.micVolumne", true, false),
      d("options.gamma", true, false),
      R("options.entityShadows", false, true),
      E("options.forceUnicodeFont", false, true),
      a("options.invertMouse", false, true),
      i("options.framerateLimit", true, false, 10.0F, 260.0F, 10.0F),
      k("options.renderClouds", false, false),
      C("options.chat.height.unfocused", true, false),
      m("options.ao", false, false),
      P("options.blockAlternatives", false, true);

      private float X;
      e("options.saturation", true, false),
      s("options.chat.opacity", true, false),
      N("options.stream.chat.userFilter", false, false),
      H("options.stream.systemVolume", true, false);

      static float a(avh.a var0) {
         return var0.Y;
      }

      public float e(float var1) {
         var1 = this.f(var1);
         return ns.a(var1, this.X, this.Y);
      }

      public void a(float var1) {
         this.Y = var1;
      }

      static float b(avh.a var0) {
         return var0.X;
      }

      public boolean a() {
         return this.T;
      }

      public static avh.a a(int var0) {
         avh.a[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            avh.a var4 = var1[var3];
            if (var4.c() == var0) {
               return var4;
            }
         }

         return null;
      }

      public float f() {
         return this.Y;
      }

      private a(String var3, boolean var4, boolean var5) {
         this(var3, var4, var5, 0.0F, 1.0F, 0.0F);
      }

      protected float f(float var1) {
         if (this.W > 0.0F) {
            var1 = this.W * (float)Math.round(var1 / this.W);
         }

         return var1;
      }

      public String d() {
         return this.V;
      }

      public float d(float var1) {
         return this.e(this.X + (this.Y - this.X) * ns.a(var1, 0.0F, 1.0F));
      }

      public boolean b() {
         return this.U;
      }

      public float c(float var1) {
         return ns.a((this.e(var1) - this.X) / (this.Y - this.X), 0.0F, 1.0F);
      }

      private a(String var3, boolean var4, boolean var5, float var6, float var7, float var8) {
         this.V = var3;
         this.T = var4;
         this.U = var5;
         this.X = var6;
         this.Y = var7;
         this.W = var8;
      }

      public int c() {
         return this.ordinal();
      }
   }
}
