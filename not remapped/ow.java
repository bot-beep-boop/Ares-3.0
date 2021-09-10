public class ow {
   private boolean y;
   public static ow k = (new ow("generic")).k();
   private boolean v;
   public String p;
   public static ow f = (new ow("drown")).k();
   public static ow h = new ow("cactus");
   private boolean w;
   public static ow b = new ow("lightningBolt");
   private boolean s;
   public static ow c = (new ow("onFire")).k().n();
   private float t = 0.3F;
   private boolean q;
   public static ow l = (new ow("magic")).k().t();
   public static ow m = (new ow("wither")).k();
   private boolean x;
   public static ow j = (new ow("outOfWorld")).k().l();
   public static ow i = (new ow("fall")).k();
   private boolean u;
   public static ow o = new ow("fallingBlock");
   public static ow n = new ow("anvil");
   public static ow d = (new ow("lava")).n();
   public static ow a = (new ow("inFire")).n();
   private boolean r;
   public static ow g = (new ow("starve")).k().m();
   public static ow e = (new ow("inWall")).k();

   public float f() {
      return this.t;
   }

   public boolean e() {
      return this.q;
   }

   public boolean u() {
      pk var1 = this.j();
      return var1 instanceof wn && ((wn)var1).bA.d;
   }

   public boolean s() {
      return this.x;
   }

   protected ow(String var1) {
      this.p = var1;
   }

   public static ow a(wn var0) {
      return new ox("player", var0);
   }

   protected ow k() {
      this.q = true;
      this.t = 0.0F;
      return this;
   }

   public String p() {
      return this.p;
   }

   public ow d() {
      this.y = true;
      return this;
   }

   public pk i() {
      return this.j();
   }

   public static ow a(pk var0) {
      return (new ox("thorns", var0)).v().t();
   }

   public boolean h() {
      return this.s;
   }

   public boolean g() {
      return this.r;
   }

   public boolean a() {
      return this.v;
   }

   protected ow n() {
      this.u = true;
      return this;
   }

   public static ow b(pk var0, pk var1) {
      return (new oy("indirectMagic", var0, var1)).k().t();
   }

   public static ow a(wq var0, pk var1) {
      return (new oy("arrow", var0, var1)).b();
   }

   public eu b(pr var1) {
      pr var2 = var1.bt();
      String var3 = "death.attack." + this.p;
      String var4 = var3 + ".player";
      return var2 != null && di.c(var4) ? new fb(var4, new Object[]{var1.f_(), var2.f_()}) : new fb(var3, new Object[]{var1.f_()});
   }

   public pk j() {
      return null;
   }

   public ow b() {
      this.v = true;
      return this;
   }

   public static ow a(pk var0, pk var1) {
      return (new oy("thrown", var0, var1)).b();
   }

   public boolean c() {
      return this.y;
   }

   protected ow m() {
      this.s = true;
      this.t = 0.0F;
      return this;
   }

   public static ow a(adi var0) {
      return var0 != null && var0.c() != null ? (new ox("explosion.player", var0.c())).q().d() : (new ow("explosion")).q().d();
   }

   public ow t() {
      this.x = true;
      return this;
   }

   public boolean o() {
      return this.u;
   }

   public ow q() {
      this.w = true;
      return this;
   }

   public static ow a(ws var0, pk var1) {
      return var1 == null ? (new oy("onFire", var0, var0)).n().b() : (new oy("fireball", var0, var1)).n().b();
   }

   protected ow l() {
      this.r = true;
      return this;
   }

   public static ow a(pr var0) {
      return new ox("mob", var0);
   }

   public boolean r() {
      return this.w;
   }
}
