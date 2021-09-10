import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class mw {
   private Class<? extends mz> d;
   public static mx h;
   public static mx j;
   public boolean f;
   private final auu c;
   private final eu a;
   private final mx b;
   public static mx g;
   private static NumberFormat k;
   public final String e;
   public static mx i;
   private static DecimalFormat l;

   public boolean d() {
      return false;
   }

   static NumberFormat m() {
      return k;
   }

   public String a(int var1) {
      return this.b.a(var1);
   }

   public mw i() {
      this.f = true;
      return this;
   }

   static DecimalFormat n() {
      return l;
   }

   public String toString() {
      return "Stat{id=" + this.e + ", nameId=" + this.a + ", awardLocallyOnly=" + this.f + ", formatter=" + this.b + ", objectiveCriteria=" + this.c + '}';
   }

   public eu j() {
      eu var1 = this.e();
      eu var2 = (new fa("[")).a(var1).a("]");
      var2.a(var1.b());
      return var2;
   }

   public int hashCode() {
      return this.e.hashCode();
   }

   static {
      k = NumberFormat.getIntegerInstance(Locale.US);
      g = new mx() {
         public String a(int var1) {
            return mw.m().format((long)var1);
         }
      };
      l = new DecimalFormat("########0.00");
      h = new mx() {
         public String a(int var1) {
            double var2 = (double)var1 / 20.0D;
            double var4 = var2 / 60.0D;
            double var6 = var4 / 60.0D;
            double var8 = var6 / 24.0D;
            double var10 = var8 / 365.0D;
            if (var10 > 0.5D) {
               return mw.n().format(var10) + " y";
            } else if (var8 > 0.5D) {
               return mw.n().format(var8) + " d";
            } else if (var6 > 0.5D) {
               return mw.n().format(var6) + " h";
            } else {
               return var4 > 0.5D ? mw.n().format(var4) + " m" : var2 + " s";
            }
         }
      };
      i = new mx() {
         public String a(int var1) {
            double var2 = (double)var1 / 100.0D;
            double var4 = var2 / 1000.0D;
            if (var4 > 0.5D) {
               return mw.n().format(var4) + " km";
            } else {
               return var2 > 0.5D ? mw.n().format(var2) + " m" : var1 + " cm";
            }
         }
      };
      j = new mx() {
         public String a(int var1) {
            return mw.n().format((double)var1 * 0.1D);
         }
      };
   }

   public mw(String var1, eu var2, mx var3) {
      this.e = var1;
      this.a = var2;
      this.b = var3;
      this.c = new auv(this);
      auu.a.put(this.c.a(), this.c);
   }

   public mw b(Class<? extends mz> var1) {
      this.d = var1;
      return this;
   }

   public eu e() {
      eu var1 = this.a.f();
      var1.b().a(a.h);
      var1.b().a(new ew(ew.a.b, new fa(this.e)));
      return var1;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         mw var2 = (mw)var1;
         return this.e.equals(var2.e);
      } else {
         return false;
      }
   }

   public mw(String var1, eu var2) {
      this(var1, var2, g);
   }

   public mw h() {
      if (na.a.containsKey(this.e)) {
         throw new RuntimeException("Duplicate stat id: \"" + ((mw)na.a.get(this.e)).a + "\" and \"" + this.a + "\" at id " + this.e);
      } else {
         na.b.add(this);
         na.a.put(this.e, this);
         return this;
      }
   }

   public Class<? extends mz> l() {
      return this.d;
   }

   public auu k() {
      return this.c;
   }
}
