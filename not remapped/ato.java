import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;

public class ato {
   private long k;
   private String n;
   private adk K;
   private oj z;
   private long h;
   private adp.a u;
   private dn l;
   private boolean y;
   private boolean v;
   private int J;
   private int e;
   private double B;
   private int p;
   private int g;
   private boolean w;
   private int f;
   private double C;
   private boolean x;
   private String d;
   private boolean A;
   private adr c;
   private long i;
   private int o;
   private boolean q;
   private long j;
   private long b;
   private double H;
   private int t;
   private long E;
   private double G;
   private boolean s;
   public static final oj a;
   private int m;
   private int I;
   private double D;
   private double F;
   private int r;

   protected ato() {
      this.c = adr.b;
      this.d = "";
      this.B = 0.0D;
      this.C = 0.0D;
      this.D = 6.0E7D;
      this.E = 0L;
      this.F = 0.0D;
      this.G = 5.0D;
      this.H = 0.2D;
      this.I = 5;
      this.J = 15;
      this.K = new adk();
   }

   public long g() {
      return this.i;
   }

   public void e(boolean var1) {
      this.A = var1;
   }

   public void a(adr var1) {
      this.c = var1;
   }

   public dn a() {
      dn var1 = new dn();
      this.a(var1, this.l);
      return var1;
   }

   public void e(int var1) {
      this.o = var1;
   }

   static int f(ato var0) {
      return var0.g;
   }

   static long h(ato var0) {
      return var0.i;
   }

   public boolean w() {
      return this.y;
   }

   public int J() {
      return this.I;
   }

   public void a(int var1) {
      this.e = var1;
   }

   public void c(long var1) {
      this.i = var1;
   }

   public void a(adp.a var1) {
      this.u = var1;
   }

   public void a(c var1) {
      var1.a("Level seed", new Callable<String>(this) {
         final ato a;

         public Object call() throws Exception {
            return this.a();
         }

         {
            this.a = var1;
         }

         public String a() throws Exception {
            return String.valueOf(this.a.b());
         }
      });
      var1.a("Level generator", new Callable<String>(this) {
         final ato a;

         {
            this.a = var1;
         }

         public String a() throws Exception {
            return String.format("ID %02d - %s, ver %d. Features enabled: %b", ato.a(this.a).g(), ato.a(this.a).a(), ato.a(this.a).d(), ato.b(this.a));
         }

         public Object call() throws Exception {
            return this.a();
         }
      });
      var1.a("Level generator options", new Callable<String>(this) {
         final ato a;

         public String a() throws Exception {
            return ato.c(this.a);
         }

         public Object call() throws Exception {
            return this.a();
         }

         {
            this.a = var1;
         }
      });
      var1.a("Level spawn location", new Callable<String>(this) {
         final ato a;

         public Object call() throws Exception {
            return this.a();
         }

         public String a() throws Exception {
            return c.a((double)ato.d(this.a), (double)ato.e(this.a), (double)ato.f(this.a));
         }

         {
            this.a = var1;
         }
      });
      var1.a("Level time", new Callable<String>(this) {
         final ato a;

         {
            this.a = var1;
         }

         public Object call() throws Exception {
            return this.a();
         }

         public String a() throws Exception {
            return String.format("%d game time, %d day time", ato.g(this.a), ato.h(this.a));
         }
      });
      var1.a("Level dimension", new Callable<String>(this) {
         final ato a;

         public Object call() throws Exception {
            return this.a();
         }

         public String a() throws Exception {
            return String.valueOf(ato.i(this.a));
         }

         {
            this.a = var1;
         }
      });
      var1.a("Level storage version", new Callable<String>(this) {
         final ato a;

         public String a() throws Exception {
            String var1 = "Unknown?";

            try {
               switch(ato.j(this.a)) {
               case 19132:
                  var1 = "McRegion";
                  break;
               case 19133:
                  var1 = "Anvil";
               }
            } catch (Throwable var3) {
            }

            return String.format("0x%05X - %s", ato.j(this.a), var1);
         }

         {
            this.a = var1;
         }

         public Object call() throws Exception {
            return this.a();
         }
      });
      var1.a("Level weather", new Callable<String>(this) {
         final ato a;

         public Object call() throws Exception {
            return this.a();
         }

         public String a() throws Exception {
            return String.format("Rain time: %d (now: %b), thunder time: %d (now: %b)", ato.k(this.a), ato.l(this.a), ato.m(this.a), ato.n(this.a));
         }

         {
            this.a = var1;
         }
      });
      var1.a("Level game mode", new Callable<String>(this) {
         final ato a;

         public Object call() throws Exception {
            return this.a();
         }

         public String a() throws Exception {
            return String.format("Game mode: %s (ID %d). Hardcore: %b. Cheats: %b", ato.o(this.a).b(), ato.o(this.a).a(), ato.p(this.a), ato.q(this.a));
         }

         {
            this.a = var1;
         }
      });
   }

   public adr u() {
      return this.c;
   }

   public double I() {
      return this.H;
   }

   public void b(int var1) {
      this.f = var1;
   }

   static boolean q(ato var0) {
      return var0.x;
   }

   public dn i() {
      return this.l;
   }

   public void c(int var1) {
      this.g = var1;
   }

   static boolean b(ato var0) {
      return var0.v;
   }

   public int A() {
      return this.p;
   }

   public void j(int var1) {
      this.I = var1;
   }

   public void a(String var1) {
      this.n = var1;
   }

   static String c(ato var0) {
      return var0.d;
   }

   static int j(ato var0) {
      return var0.o;
   }

   public void d(double var1) {
      this.B = var1;
   }

   public dn a(dn var1) {
      dn var2 = new dn();
      this.a(var2, var1);
      return var2;
   }

   public boolean n() {
      return this.s;
   }

   public void a(double var1) {
      this.D = var1;
   }

   public int K() {
      return this.J;
   }

   public adk x() {
      return this.K;
   }

   public void i(int var1) {
      this.p = var1;
   }

   public oj y() {
      return this.z;
   }

   public void c(boolean var1) {
      this.x = var1;
   }

   public ato(dn var1) {
      this.c = adr.b;
      this.d = "";
      this.B = 0.0D;
      this.C = 0.0D;
      this.D = 6.0E7D;
      this.E = 0L;
      this.F = 0.0D;
      this.G = 5.0D;
      this.H = 0.2D;
      this.I = 5;
      this.J = 15;
      this.K = new adk();
      this.b = var1.g("RandomSeed");
      if (var1.b("generatorName", 8)) {
         String var2 = var1.j("generatorName");
         this.c = adr.a(var2);
         if (this.c == null) {
            this.c = adr.b;
         } else if (this.c.f()) {
            int var3 = 0;
            if (var1.b("generatorVersion", 99)) {
               var3 = var1.f("generatorVersion");
            }

            this.c = this.c.a(var3);
         }

         if (var1.b("generatorOptions", 8)) {
            this.d = var1.j("generatorOptions");
         }
      }

      this.u = adp.a.a(var1.f("GameType"));
      if (var1.b("MapFeatures", 99)) {
         this.v = var1.n("MapFeatures");
      } else {
         this.v = true;
      }

      this.e = var1.f("SpawnX");
      this.f = var1.f("SpawnY");
      this.g = var1.f("SpawnZ");
      this.h = var1.g("Time");
      if (var1.b("DayTime", 99)) {
         this.i = var1.g("DayTime");
      } else {
         this.i = this.h;
      }

      this.j = var1.g("LastPlayed");
      this.k = var1.g("SizeOnDisk");
      this.n = var1.j("LevelName");
      this.o = var1.f("version");
      this.p = var1.f("clearWeatherTime");
      this.r = var1.f("rainTime");
      this.q = var1.n("raining");
      this.t = var1.f("thunderTime");
      this.s = var1.n("thundering");
      this.w = var1.n("hardcore");
      if (var1.b("initialized", 99)) {
         this.y = var1.n("initialized");
      } else {
         this.y = true;
      }

      if (var1.b("allowCommands", 99)) {
         this.x = var1.n("allowCommands");
      } else {
         this.x = this.u == adp.a.c;
      }

      if (var1.b("Player", 10)) {
         this.l = var1.m("Player");
         this.m = this.l.f("Dimension");
      }

      if (var1.b("GameRules", 10)) {
         this.K.a(var1.m("GameRules"));
      }

      if (var1.b("Difficulty", 99)) {
         this.z = oj.a(var1.d("Difficulty"));
      }

      if (var1.b("DifficultyLocked", 1)) {
         this.A = var1.n("DifficultyLocked");
      }

      if (var1.b("BorderCenterX", 99)) {
         this.B = var1.i("BorderCenterX");
      }

      if (var1.b("BorderCenterZ", 99)) {
         this.C = var1.i("BorderCenterZ");
      }

      if (var1.b("BorderSize", 99)) {
         this.D = var1.i("BorderSize");
      }

      if (var1.b("BorderSizeLerpTime", 99)) {
         this.E = var1.g("BorderSizeLerpTime");
      }

      if (var1.b("BorderSizeLerpTarget", 99)) {
         this.F = var1.i("BorderSizeLerpTarget");
      }

      if (var1.b("BorderSafeZone", 99)) {
         this.G = var1.i("BorderSafeZone");
      }

      if (var1.b("BorderDamagePerBlock", 99)) {
         this.H = var1.i("BorderDamagePerBlock");
      }

      if (var1.b("BorderWarningBlocks", 99)) {
         this.I = var1.f("BorderWarningBlocks");
      }

      if (var1.b("BorderWarningTime", 99)) {
         this.J = var1.f("BorderWarningTime");
      }

   }

   static adp.a o(ato var0) {
      return var0.u;
   }

   static int e(ato var0) {
      return var0.f;
   }

   public int e() {
      return this.g;
   }

   static int k(ato var0) {
      return var0.r;
   }

   public ato(ato var1) {
      this.c = adr.b;
      this.d = "";
      this.B = 0.0D;
      this.C = 0.0D;
      this.D = 6.0E7D;
      this.E = 0L;
      this.F = 0.0D;
      this.G = 5.0D;
      this.H = 0.2D;
      this.I = 5;
      this.J = 15;
      this.K = new adk();
      this.b = var1.b;
      this.c = var1.c;
      this.d = var1.d;
      this.u = var1.u;
      this.v = var1.v;
      this.e = var1.e;
      this.f = var1.f;
      this.g = var1.g;
      this.h = var1.h;
      this.i = var1.i;
      this.j = var1.j;
      this.k = var1.k;
      this.l = var1.l;
      this.m = var1.m;
      this.n = var1.n;
      this.o = var1.o;
      this.r = var1.r;
      this.q = var1.q;
      this.t = var1.t;
      this.s = var1.s;
      this.w = var1.w;
      this.x = var1.x;
      this.y = var1.y;
      this.K = var1.K;
      this.z = var1.z;
      this.A = var1.A;
      this.B = var1.B;
      this.C = var1.C;
      this.D = var1.D;
      this.E = var1.E;
      this.F = var1.F;
      this.G = var1.G;
      this.H = var1.H;
      this.J = var1.J;
      this.I = var1.I;
   }

   public int c() {
      return this.e;
   }

   static int i(ato var0) {
      return var0.m;
   }

   public void a(boolean var1) {
      this.s = var1;
   }

   public void a(oj var1) {
      this.z = var1;
   }

   public void f(int var1) {
      this.t = var1;
   }

   public double D() {
      return this.C;
   }

   public boolean s() {
      return this.v;
   }

   private void a(dn var1, dn var2) {
      var1.a("RandomSeed", this.b);
      var1.a("generatorName", this.c.a());
      var1.a("generatorVersion", this.c.d());
      var1.a("generatorOptions", this.d);
      var1.a("GameType", this.u.a());
      var1.a("MapFeatures", this.v);
      var1.a("SpawnX", this.e);
      var1.a("SpawnY", this.f);
      var1.a("SpawnZ", this.g);
      var1.a("Time", this.h);
      var1.a("DayTime", this.i);
      var1.a("SizeOnDisk", this.k);
      var1.a("LastPlayed", MinecraftServer.az());
      var1.a("LevelName", this.n);
      var1.a("version", this.o);
      var1.a("clearWeatherTime", this.p);
      var1.a("rainTime", this.r);
      var1.a("raining", this.q);
      var1.a("thunderTime", this.t);
      var1.a("thundering", this.s);
      var1.a("hardcore", this.w);
      var1.a("allowCommands", this.x);
      var1.a("initialized", this.y);
      var1.a("BorderCenterX", this.B);
      var1.a("BorderCenterZ", this.C);
      var1.a("BorderSize", this.D);
      var1.a("BorderSizeLerpTime", this.E);
      var1.a("BorderSafeZone", this.G);
      var1.a("BorderDamagePerBlock", this.H);
      var1.a("BorderSizeLerpTarget", this.F);
      var1.a("BorderWarningBlocks", (double)this.I);
      var1.a("BorderWarningTime", (double)this.J);
      if (this.z != null) {
         var1.a("Difficulty", (byte)this.z.a());
      }

      var1.a("DifficultyLocked", this.A);
      var1.a((String)"GameRules", (eb)this.K.a());
      if (var2 != null) {
         var1.a((String)"Player", (eb)var2);
      }

   }

   public String k() {
      return this.n;
   }

   public void a(adp var1) {
      this.b = var1.d();
      this.u = var1.e();
      this.v = var1.g();
      this.w = var1.f();
      this.c = var1.h();
      this.d = var1.j();
      this.x = var1.i();
   }

   public long f() {
      return this.h;
   }

   public void b(double var1) {
      this.F = var1;
   }

   public double G() {
      return this.F;
   }

   public void e(double var1) {
      this.G = var1;
   }

   static int m(ato var0) {
      return var0.t;
   }

   public long m() {
      return this.j;
   }

   static adr a(ato var0) {
      return var0.c;
   }

   public void g(boolean var1) {
      this.w = var1;
   }

   static boolean n(ato var0) {
      return var0.s;
   }

   public void a(cj var1) {
      this.e = var1.n();
      this.f = var1.o();
      this.g = var1.p();
   }

   public boolean v() {
      return this.x;
   }

   static {
      a = oj.c;
   }

   public long F() {
      return this.E;
   }

   public void g(int var1) {
      this.r = var1;
   }

   public int o() {
      return this.t;
   }

   public adp.a r() {
      return this.u;
   }

   public ato(adp var1, String var2) {
      this.c = adr.b;
      this.d = "";
      this.B = 0.0D;
      this.C = 0.0D;
      this.D = 6.0E7D;
      this.E = 0L;
      this.F = 0.0D;
      this.G = 5.0D;
      this.H = 0.2D;
      this.I = 5;
      this.J = 15;
      this.K = new adk();
      this.a(var1);
      this.n = var2;
      this.z = a;
      this.y = false;
   }

   public void f(double var1) {
      this.H = var1;
   }

   public void b(long var1) {
      this.h = var1;
   }

   public double H() {
      return this.G;
   }

   public int d() {
      return this.f;
   }

   public boolean z() {
      return this.A;
   }

   public long h() {
      return this.k;
   }

   public void d(boolean var1) {
      this.y = var1;
   }

   public void b(boolean var1) {
      this.q = var1;
   }

   public boolean t() {
      return this.w;
   }

   static long g(ato var0) {
      return var0.h;
   }

   static boolean l(ato var0) {
      return var0.q;
   }

   public boolean p() {
      return this.q;
   }

   public int l() {
      return this.o;
   }

   public double C() {
      return this.B;
   }

   public void c(double var1) {
      this.C = var1;
   }

   public void f(boolean var1) {
      this.v = var1;
   }

   public String B() {
      return this.d;
   }

   public int q() {
      return this.r;
   }

   public long b() {
      return this.b;
   }

   public void k(int var1) {
      this.J = var1;
   }

   static int d(ato var0) {
      return var0.e;
   }

   static boolean p(ato var0) {
      return var0.w;
   }

   public void e(long var1) {
      this.E = var1;
   }

   public double E() {
      return this.D;
   }
}
