public class bgd implements bnj {
   private final bge e = new bge();
   private final avh b;
   private final bgf c = new bgf();
   private final bgb d = new bgb();
   private bgc a;

   public void a(bni var1) {
      this.e.a();
   }

   private boq a(alz var1, cj var2) {
      boq var3 = this.a.b(var1);
      if (var2 != null && this.b.v && var3 instanceof box) {
         var3 = ((box)var3).a(ns.a((df)var2));
      }

      return var3;
   }

   public bgd(bgc var1, avh var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(alz var1, float var2) {
      int var3 = var1.c().b();
      if (var3 != -1) {
         switch(var3) {
         case 1:
         default:
            break;
         case 2:
            this.d.a(var1.c(), var2);
            break;
         case 3:
            boq var4 = this.a(var1, (cj)null);
            this.c.a(var4, var1, var2, true);
         }

      }
   }

   public boolean a(afh var1, int var2) {
      if (var1 == null) {
         return false;
      } else {
         int var3 = var1.b();
         if (var3 == 3) {
            return false;
         } else {
            return var3 == 2;
         }
      }
   }

   public bgf b() {
      return this.c;
   }

   public boolean a(alz var1, cj var2, adq var3, bfd var4) {
      try {
         int var5 = var1.c().b();
         if (var5 == -1) {
            return false;
         } else {
            switch(var5) {
            case 1:
               return this.e.a(var3, var1, var2, var4);
            case 2:
               return false;
            case 3:
               boq var9 = this.a(var1, var3, var2);
               return this.c.a(var3, var9, var1, var2, var4);
            default:
               return false;
            }
         }
      } catch (Throwable var8) {
         b var6 = b.a(var8, "Tesselating block in world");
         c var7 = var6.a("Block being tesselated");
         c.a(var7, var2, var1.c(), var1.c().c(var1));
         throw new e(var6);
      }
   }

   public bgc a() {
      return this.a;
   }

   public void a(alz var1, cj var2, bmi var3, adq var4) {
      afh var5 = var1.c();
      int var6 = var5.b();
      if (var6 == 3) {
         var1 = var5.a(var1, var4, var2);
         boq var7 = this.a.b(var1);
         boq var8 = (new bow.a(var7, var3)).b();
         this.c.a(var4, var8, var1, var2, bfx.a().c());
      }
   }

   public boq a(alz var1, adq var2, cj var3) {
      afh var4 = var1.c();
      if (var2.G() != adr.g) {
         try {
            var1 = var4.a(var1, var2, var3);
         } catch (Exception var6) {
         }
      }

      boq var5 = this.a.b(var1);
      if (var3 != null && this.b.v && var5 instanceof box) {
         var5 = ((box)var5).a(ns.a((df)var3));
      }

      return var5;
   }
}
