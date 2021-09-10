public enum wo {
   private static final wo[] l = new wo[]{a, b, c, d, e, f, g};
   g(6, "hat");

   private final String j;
   a(0, "cape"),
   c(2, "left_sleeve");

   private final int i;
   private final eu k;
   private final int h;
   b(1, "jacket"),
   d(3, "right_sleeve"),
   e(4, "left_pants_leg"),
   f(5, "right_pants_leg");

   private wo(int var3, String var4) {
      this.h = var3;
      this.i = 1 << var3;
      this.j = var4;
      this.k = new fb("options.modelPart." + var4, new Object[0]);
   }

   public int b() {
      return this.h;
   }

   public int a() {
      return this.i;
   }

   public String c() {
      return this.j;
   }

   public eu d() {
      return this.k;
   }
}
