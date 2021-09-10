public class acr extends aci {
   public final int a;
   private static final String[] E = new String[]{"all", "fire", "fall", "explosion", "projectile"};
   private static final int[] F = new int[]{1, 10, 5, 5, 3};
   private static final int[] G = new int[]{11, 8, 6, 8, 6};
   private static final int[] H = new int[]{20, 12, 10, 12, 15};

   public static double a(pk var0, double var1) {
      int var3 = ack.a(aci.f.B, var0.as());
      if (var3 > 0) {
         var1 -= (double)ns.c(var1 * (double)((float)var3 * 0.15F));
      }

      return var1;
   }

   public acr(int var1, jy var2, int var3, int var4) {
      super(var1, var2, var3, acj.b);
      this.a = var4;
      if (var4 == 2) {
         this.C = acj.c;
      }

   }

   public boolean a(aci var1) {
      if (var1 instanceof acr) {
         acr var2 = (acr)var1;
         if (var2.a == this.a) {
            return false;
         } else {
            return this.a == 2 || var2.a == 2;
         }
      } else {
         return super.a(var1);
      }
   }

   public int a(int var1) {
      return F[this.a] + (var1 - 1) * G[this.a];
   }

   public int b(int var1) {
      return this.a(var1) + H[this.a];
   }

   public static int a(pk var0, int var1) {
      int var2 = ack.a(aci.d.B, var0.as());
      if (var2 > 0) {
         var1 -= ns.d((float)var1 * (float)var2 * 0.15F);
      }

      return var1;
   }

   public int a(int var1, ow var2) {
      if (var2.g()) {
         return 0;
      } else {
         float var3 = (float)(6 + var1 * var1) / 3.0F;
         if (this.a == 0) {
            return ns.d(var3 * 0.75F);
         } else if (this.a == 1 && var2.o()) {
            return ns.d(var3 * 1.25F);
         } else if (this.a == 2 && var2 == ow.i) {
            return ns.d(var3 * 2.5F);
         } else if (this.a == 3 && var2.c()) {
            return ns.d(var3 * 1.5F);
         } else {
            return this.a == 4 && var2.a() ? ns.d(var3 * 1.5F) : 0;
         }
      }
   }

   public int b() {
      return 4;
   }

   public String a() {
      return "enchantment.protect." + E[this.a];
   }
}
