import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.List;

public abstract class agw extends afm {
   protected amm<agw.a> a;

   public int a(alz var1) {
      return ((agw.a)var1.b(this.n())).b();
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      agw.a[] var4 = agw.a.a(this.l());
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         agw.a var7 = var4[var6];
         var3.add(new zx(var1, 1, var7.b()));
      }

   }

   public int c(alz var1) {
      return ((agw.a)var1.b(this.n())).b();
   }

   public amo<agw.a> n() {
      if (this.a == null) {
         this.a = amm.a("type", agw.a.class, new Predicate<agw.a>(this) {
            final agw a;

            public boolean a(agw.a var1) {
               return var1.a() == this.a.l();
            }

            public boolean apply(Object var1) {
               return this.a((agw.a)var1);
            }

            {
               this.a = var1;
            }
         });
      }

      return this.a;
   }

   protected agw() {
      this.j(this.M.b().a(this.n(), this.l() == agw.b.b ? agw.a.b : agw.a.a));
   }

   protected ama e() {
      return new ama(this, new amo[]{this.n()});
   }

   public afh.a R() {
      return afh.a.b;
   }

   public abstract agw.b l();

   public alz a(int var1) {
      return this.Q().a(this.n(), agw.a.a(this.l(), var1));
   }

   public static enum b {
      a,
      b;

      private static final agw.b[] c = new agw.b[]{a, b};

      public agw a() {
         return this == a ? afi.N : afi.O;
      }
   }

   public static enum a implements nw {
      d(agw.b.b, 2, "allium"),
      i(agw.b.b, 7, "pink_tulip", "tulipPink");

      private final String o;
      h(agw.b.b, 6, "white_tulip", "tulipWhite"),
      a(agw.b.a, 0, "dandelion");

      private final int m;
      private static final agw.a[] p = new agw.a[]{a, b, c, d, e, f, g, h, i, j};
      j(agw.b.b, 8, "oxeye_daisy", "oxeyeDaisy"),
      e(agw.b.b, 3, "houstonia"),
      f(agw.b.b, 4, "red_tulip", "tulipRed"),
      c(agw.b.b, 1, "blue_orchid", "blueOrchid"),
      b(agw.b.b, 0, "poppy");

      private final String n;
      g(agw.b.b, 5, "orange_tulip", "tulipOrange");

      private final agw.b l;
      private static final agw.a[][] k = new agw.a[agw.b.values().length][];

      public String toString() {
         return this.n;
      }

      public static agw.a[] a(agw.b var0) {
         return k[var0.ordinal()];
      }

      public String d() {
         return this.o;
      }

      public String l() {
         return this.n;
      }

      static {
         agw.b[] var0 = agw.b.values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            agw.b var3 = var0[var2];
            Collection var4 = Collections2.filter(Lists.newArrayList(values()), new Predicate<agw.a>(var3) {
               final agw.b a;

               public boolean a(agw.a var1) {
                  return var1.a() == this.a;
               }

               {
                  this.a = var1;
               }

               public boolean apply(Object var1) {
                  return this.a((agw.a)var1);
               }
            });
            k[var3.ordinal()] = (agw.a[])var4.toArray(new agw.a[var4.size()]);
         }

      }

      private a(agw.b var3, int var4, String var5) {
         this(var3, var4, var5, var5);
      }

      public static agw.a a(agw.b var0, int var1) {
         agw.a[] var2 = k[var0.ordinal()];
         if (var1 < 0 || var1 >= var2.length) {
            var1 = 0;
         }

         return var2[var1];
      }

      public agw.b a() {
         return this.l;
      }

      private a(agw.b var3, int var4, String var5, String var6) {
         this.l = var3;
         this.m = var4;
         this.n = var5;
         this.o = var6;
      }

      public int b() {
         return this.m;
      }
   }
}
