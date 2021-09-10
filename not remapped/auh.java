public class auh {
   public pk d;
   private cj e;
   public cq b;
   public auh.a a;
   public aui c;

   public auh(aui var1, cq var2, cj var3) {
      this(auh.a.b, var1, var2, var3);
   }

   public auh(pk var1, aui var2) {
      this.a = auh.a.c;
      this.d = var1;
      this.c = var2;
   }

   public auh(auh.a var1, aui var2, cq var3, cj var4) {
      this.a = var1;
      this.e = var4;
      this.b = var3;
      this.c = new aui(var2.a, var2.b, var2.c);
   }

   public auh(aui var1, cq var2) {
      this(auh.a.b, var1, var2, cj.a);
   }

   public String toString() {
      return "HitResult{type=" + this.a + ", blockpos=" + this.e + ", f=" + this.b + ", pos=" + this.c + ", entity=" + this.d + '}';
   }

   public cj a() {
      return this.e;
   }

   public auh(pk var1) {
      this(var1, new aui(var1.s, var1.t, var1.u));
   }

   public static enum a {
      b;

      private static final auh.a[] d = new auh.a[]{a, b, c};
      c,
      a;
   }
}
