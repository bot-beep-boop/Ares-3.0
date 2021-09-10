public enum oj {
   private final String g;
   private static final oj[] e = new oj[values().length];
   private final int f;
   c(2, "options.difficulty.normal"),
   b(1, "options.difficulty.easy");

   private static final oj[] h = new oj[]{a, b, c, d};
   d(3, "options.difficulty.hard"),
   a(0, "options.difficulty.peaceful");

   public static oj a(int var0) {
      return e[var0 % e.length];
   }

   public int a() {
      return this.f;
   }

   private oj(int var3, String var4) {
      this.f = var3;
      this.g = var4;
   }

   public String b() {
      return this.g;
   }

   static {
      oj[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         oj var3 = var0[var2];
         e[var3.f] = var3;
      }

   }
}
