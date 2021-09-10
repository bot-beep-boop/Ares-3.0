public class adr {
   private boolean n;
   public static final adr e = (new adr(3, "amplified")).j();
   public static final adr c = new adr(1, "flat");
   private boolean m;
   private final int k;
   private final int i;
   public static final adr[] a = new adr[16];
   public static final adr d = new adr(2, "largeBiomes");
   public static final adr h = (new adr(8, "default_1_1", 0)).a(false);
   public static final adr f = new adr(4, "customized");
   private final String j;
   public static final adr g = new adr(5, "debug_all_block_states");
   public static final adr b = (new adr(0, "default", 1)).i();
   private boolean l;

   public String a() {
      return this.j;
   }

   public boolean h() {
      return this.n;
   }

   public int d() {
      return this.k;
   }

   private adr(int var1, String var2, int var3) {
      this.j = var2;
      this.k = var3;
      this.l = true;
      this.i = var1;
      a[var1] = this;
   }

   private adr(int var1, String var2) {
      this(var1, var2, 0);
   }

   public String b() {
      return "generator." + this.j;
   }

   private adr j() {
      this.n = true;
      return this;
   }

   public adr a(int var1) {
      return this == b && var1 == 0 ? h : this;
   }

   public int g() {
      return this.i;
   }

   public static adr a(String var0) {
      for(int var1 = 0; var1 < a.length; ++var1) {
         if (a[var1] != null && a[var1].j.equalsIgnoreCase(var0)) {
            return a[var1];
         }
      }

      return null;
   }

   public boolean e() {
      return this.l;
   }

   public boolean f() {
      return this.m;
   }

   private adr i() {
      this.m = true;
      return this;
   }

   public String c() {
      return this.b() + ".info";
   }

   private adr a(boolean var1) {
      this.l = var1;
      return this;
   }
}
