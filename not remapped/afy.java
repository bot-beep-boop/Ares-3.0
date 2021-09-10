public class afy extends afh {
   protected afy() {
      super(arm.d);
      this.a(yz.c);
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if (var1.D) {
         return true;
      } else {
         var4.a((ol)(new afy.a(var1, var2)));
         var4.b(na.Z);
         return true;
      }
   }

   public static class a implements ol {
      private final adm a;
      private final cj b;

      public String e_() {
         return null;
      }

      public boolean l_() {
         return false;
      }

      public eu f_() {
         return new fb(afi.ai.a() + ".name", new Object[0]);
      }

      public String k() {
         return "minecraft:crafting_table";
      }

      public xi a(wm var1, wn var2) {
         return new xq(var1, this.a, this.b);
      }

      public a(adm var1, cj var2) {
         this.a = var1;
         this.b = var2;
      }
   }
}
