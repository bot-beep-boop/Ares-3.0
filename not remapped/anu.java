import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class anu implements amv {
   private final adm d;
   private static final int b;
   private static final int c;
   private static final List<alz> a = Lists.newArrayList();

   public amy a(cj var1) {
      return this.d(var1.n() >> 4, var1.p() >> 4);
   }

   public void c() {
   }

   public anu(adm var1) {
      this.d = var1;
   }

   static {
      Iterator var0 = afh.c.iterator();

      while(var0.hasNext()) {
         afh var1 = (afh)var0.next();
         a.addAll(var1.P().a());
      }

      b = ns.f(ns.c((float)a.size()));
      c = ns.f((float)a.size() / (float)b);
   }

   public List<ady.c> a(pt var1, cj var2) {
      ady var3 = this.d.b(var2);
      return var3.a(var1);
   }

   public int g() {
      return 0;
   }

   public cj a(adm var1, String var2, cj var3) {
      return null;
   }

   public void a(amy var1, int var2, int var3) {
   }

   public static alz b(int var0, int var1) {
      alz var2 = null;
      if (var0 > 0 && var1 > 0 && var0 % 2 != 0 && var1 % 2 != 0) {
         var0 /= 2;
         var1 /= 2;
         if (var0 <= b && var1 <= c) {
            int var3 = ns.a(var0 * b + var1);
            if (var3 < a.size()) {
               var2 = (alz)a.get(var3);
            }
         }
      }

      return var2;
   }

   public String f() {
      return "DebugLevelSource";
   }

   public boolean a(int var1, int var2) {
      return true;
   }

   public boolean a(boolean var1, nu var2) {
      return true;
   }

   public boolean d() {
      return false;
   }

   public boolean e() {
      return true;
   }

   public boolean a(amv var1, amy var2, int var3, int var4) {
      return false;
   }

   public amy d(int var1, int var2) {
      ans var3 = new ans();

      int var7;
      for(int var4 = 0; var4 < 16; ++var4) {
         for(int var5 = 0; var5 < 16; ++var5) {
            int var6 = var1 * 16 + var4;
            var7 = var2 * 16 + var5;
            var3.a(var4, 60, var5, afi.cv.Q());
            alz var8 = b(var6, var7);
            if (var8 != null) {
               var3.a(var4, 70, var5, var8);
            }
         }
      }

      amy var9 = new amy(this.d, var3, var1, var2);
      var9.b();
      ady[] var10 = this.d.v().b((ady[])null, var1 * 16, var2 * 16, 16, 16);
      byte[] var11 = var9.k();

      for(var7 = 0; var7 < var11.length; ++var7) {
         var11[var7] = (byte)var10[var7].az;
      }

      var9.b();
      return var9;
   }

   public void a(amv var1, int var2, int var3) {
   }
}
