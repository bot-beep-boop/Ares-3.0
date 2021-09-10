public class acf extends aci {
   private static final String[] E = new String[]{"all", "undead", "arthropods"};
   private static final int[] F = new int[]{1, 5, 5};
   private static final int[] H = new int[]{20, 20, 20};
   private static final int[] G = new int[]{11, 8, 8};
   public final int a;

   public void a(pr var1, pk var2, int var3) {
      if (var2 instanceof pr) {
         pr var4 = (pr)var2;
         if (this.a == 2 && var4.bz() == pw.c) {
            int var5 = 20 + var1.bc().nextInt(10 * var3);
            var4.c(new pf(pe.d.H, var5, 3));
         }
      }

   }

   public float a(int var1, pw var2) {
      if (this.a == 0) {
         return (float)var1 * 1.25F;
      } else if (this.a == 1 && var2 == pw.b) {
         return (float)var1 * 2.5F;
      } else {
         return this.a == 2 && var2 == pw.c ? (float)var1 * 2.5F : 0.0F;
      }
   }

   public int a(int var1) {
      return F[this.a] + (var1 - 1) * G[this.a];
   }

   public boolean a(zx var1) {
      return var1.b() instanceof yl ? true : super.a(var1);
   }

   public int b() {
      return 5;
   }

   public int b(int var1) {
      return this.a(var1) + H[this.a];
   }

   public String a() {
      return "enchantment.damage." + E[this.a];
   }

   public boolean a(aci var1) {
      return !(var1 instanceof acf);
   }

   public acf(int var1, jy var2, int var3, int var4) {
      super(var1, var2, var3, acj.g);
      this.a = var4;
   }
}
