import java.util.Iterator;

public class ahu extends afh {
   public static final amm<ahu.a> a = amm.a("facing", ahu.a.class);
   public static final amk b = amk.a("powered");

   public boolean b(adm var1, cj var2, cq var3) {
      return a(var1, var2, var3.d());
   }

   public alz a(int var1) {
      return this.Q().a(a, ahu.a.a(var1 & 7)).a(b, (var1 & 8) > 0);
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (this.e(var1, var2, var3) && !a(var1, var2, ((ahu.a)var3.b(a)).c().d())) {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
      }

   }

   public static int a(cq var0) {
      switch(var0) {
      case a:
         return 0;
      case b:
         return 5;
      case c:
         return 4;
      case d:
         return 3;
      case e:
         return 2;
      case f:
         return 1;
      default:
         return -1;
      }
   }

   public boolean i() {
      return true;
   }

   public int b(adq var1, cj var2, alz var3, cq var4) {
      if (!(Boolean)var3.b(b)) {
         return 0;
      } else {
         return ((ahu.a)var3.b(a)).c() == var4 ? 15 : 0;
      }
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if (var1.D) {
         return true;
      } else {
         var3 = var3.a(b);
         var1.a((cj)var2, (alz)var3, 3);
         var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, "random.click", 0.3F, (Boolean)var3.b(b) ? 0.6F : 0.5F);
         var1.c((cj)var2, (afh)this);
         cq var9 = ((ahu.a)var3.b(a)).c();
         var1.c((cj)var2.a(var9.d()), (afh)this);
         return true;
      }
   }

   public boolean d(adm var1, cj var2) {
      cq[] var3 = cq.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         cq var6 = var3[var5];
         if (a(var1, var2, var6)) {
            return true;
         }
      }

      return false;
   }

   protected ama e() {
      return new ama(this, new amo[]{a, b});
   }

   public void b(adm var1, cj var2, alz var3) {
      if ((Boolean)var3.b(b)) {
         var1.c((cj)var2, (afh)this);
         cq var4 = ((ahu.a)var3.b(a)).c();
         var1.c((cj)var2.a(var4.d()), (afh)this);
      }

      super.b(var1, var2, var3);
   }

   private boolean e(adm var1, cj var2, alz var3) {
      if (this.d(var1, var2)) {
         return true;
      } else {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
         return false;
      }
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   protected ahu() {
      super(arm.q);
      this.j(this.M.b().a(a, ahu.a.e).a(b, false));
      this.a(yz.d);
   }

   public void a(adq var1, cj var2) {
      float var3 = 0.1875F;
      switch((ahu.a)var1.p(var2).b(a)) {
      case b:
         this.a(0.0F, 0.2F, 0.5F - var3, var3 * 2.0F, 0.8F, 0.5F + var3);
         break;
      case c:
         this.a(1.0F - var3 * 2.0F, 0.2F, 0.5F - var3, 1.0F, 0.8F, 0.5F + var3);
         break;
      case d:
         this.a(0.5F - var3, 0.2F, 0.0F, 0.5F + var3, 0.8F, var3 * 2.0F);
         break;
      case e:
         this.a(0.5F - var3, 0.2F, 1.0F - var3 * 2.0F, 0.5F + var3, 0.8F, 1.0F);
         break;
      case f:
      case g:
         var3 = 0.25F;
         this.a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, 0.6F, 0.5F + var3);
         break;
      case a:
      case h:
         var3 = 0.25F;
         this.a(0.5F - var3, 0.4F, 0.5F - var3, 0.5F + var3, 1.0F, 0.5F + var3);
      }

   }

   public aug a(adm var1, cj var2, alz var3) {
      return null;
   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((ahu.a)var1.b(a)).a();
      if ((Boolean)var1.b(b)) {
         var3 |= 8;
      }

      return var3;
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      alz var9 = this.Q().a(b, false);
      if (a(var1, var2, var3.d())) {
         return var9.a(a, ahu.a.a(var3, var8.aP()));
      } else {
         Iterator var10 = cq.c.a.iterator();

         cq var11;
         do {
            if (!var10.hasNext()) {
               if (adm.a((adq)var1, (cj)var2.b())) {
                  return var9.a(a, ahu.a.a(cq.b, var8.aP()));
               }

               return var9;
            }

            var11 = (cq)var10.next();
         } while(var11 == var3 || !a(var1, var2, var11.d()));

         return var9.a(a, ahu.a.a(var11, var8.aP()));
      }
   }

   protected static boolean a(adm var0, cj var1, cq var2) {
      return afn.a(var0, var1, var2);
   }

   public int a(adq var1, cj var2, alz var3, cq var4) {
      return (Boolean)var3.b(b) ? 15 : 0;
   }

   public static enum a implements nw {
      a(0, "down_x", cq.a);

      private static final ahu.a[] m = new ahu.a[]{a, b, c, d, e, f, g, h};
      private final cq l;
      private final int j;
      b(1, "east", cq.f),
      f(5, "up_z", cq.b),
      d(3, "south", cq.d);

      private final String k;
      c(2, "west", cq.e),
      e(4, "north", cq.c),
      h(7, "down_z", cq.a);

      private static final ahu.a[] i = new ahu.a[values().length];
      g(6, "up_x", cq.b);

      public int a() {
         return this.j;
      }

      private a(int var3, String var4, cq var5) {
         this.j = var3;
         this.k = var4;
         this.l = var5;
      }

      public static ahu.a a(int var0) {
         if (var0 < 0 || var0 >= i.length) {
            var0 = 0;
         }

         return i[var0];
      }

      public static ahu.a a(cq var0, cq var1) {
         switch(var0) {
         case a:
            switch(var1.k()) {
            case a:
               return a;
            case c:
               return h;
            default:
               throw new IllegalArgumentException("Invalid entityFacing " + var1 + " for facing " + var0);
            }
         case b:
            switch(var1.k()) {
            case a:
               return g;
            case c:
               return f;
            default:
               throw new IllegalArgumentException("Invalid entityFacing " + var1 + " for facing " + var0);
            }
         case c:
            return e;
         case d:
            return d;
         case e:
            return c;
         case f:
            return b;
         default:
            throw new IllegalArgumentException("Invalid facing: " + var0);
         }
      }

      static {
         ahu.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            ahu.a var3 = var0[var2];
            i[var3.a()] = var3;
         }

      }

      public String toString() {
         return this.k;
      }

      public String l() {
         return this.k;
      }

      public cq c() {
         return this.l;
      }
   }
}
