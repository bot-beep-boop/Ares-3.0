import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class fb extends es {
   public static final Pattern c = Pattern.compile("%(?:(\\d+)\\$)?([A-Za-z%]|$)");
   private long g = -1L;
   private final Object f = new Object();
   private final Object[] e;
   List<eu> b = Lists.newArrayList();
   private final String d;

   public eu a(ez var1) {
      super.a(var1);
      Object[] var2 = this.e;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Object var5 = var2[var4];
         if (var5 instanceof eu) {
            ((eu)var5).b().a(this.b());
         }
      }

      if (this.g > -1L) {
         Iterator var6 = this.b.iterator();

         while(var6.hasNext()) {
            eu var7 = (eu)var6.next();
            var7.b().a(var1);
         }
      }

      return this;
   }

   public String toString() {
      return "TranslatableComponent{key='" + this.d + '\'' + ", args=" + Arrays.toString(this.e) + ", siblings=" + this.a + ", style=" + this.b() + '}';
   }

   public Object[] j() {
      return this.e;
   }

   public fb(String var1, Object... var2) {
      this.d = var1;
      this.e = var2;
      Object[] var3 = var2;
      int var4 = var2.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Object var6 = var3[var5];
         if (var6 instanceof eu) {
            ((eu)var6).b().a(this.b());
         }
      }

   }

   public String e() {
      this.g();
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = this.b.iterator();

      while(var2.hasNext()) {
         eu var3 = (eu)var2.next();
         var1.append(var3.e());
      }

      return var1.toString();
   }

   private eu a(int var1) {
      if (var1 >= this.e.length) {
         throw new fc(this, var1);
      } else {
         Object var2 = this.e[var1];
         Object var3;
         if (var2 instanceof eu) {
            var3 = (eu)var2;
         } else {
            var3 = new fa(var2 == null ? "null" : var2.toString());
            ((eu)var3).b().a(this.b());
         }

         return (eu)var3;
      }
   }

   public fb h() {
      Object[] var1 = new Object[this.e.length];

      for(int var2 = 0; var2 < this.e.length; ++var2) {
         if (this.e[var2] instanceof eu) {
            var1[var2] = ((eu)this.e[var2]).f();
         } else {
            var1[var2] = this.e[var2];
         }
      }

      fb var5 = new fb(this.d, var1);
      var5.a(this.b().m());
      Iterator var3 = this.a().iterator();

      while(var3.hasNext()) {
         eu var4 = (eu)var3.next();
         var5.a(var4.f());
      }

      return var5;
   }

   public String i() {
      return this.d;
   }

   synchronized void g() {
      synchronized(this.f) {
         long var2 = di.a();
         if (var2 == this.g) {
            return;
         }

         this.g = var2;
         this.b.clear();
      }

      try {
         this.b(di.a(this.d));
      } catch (fc var6) {
         this.b.clear();

         try {
            this.b(di.b(this.d));
         } catch (fc var5) {
            throw var6;
         }
      }

   }

   public eu f() {
      return this.h();
   }

   public Iterator<eu> iterator() {
      this.g();
      return Iterators.concat(a(this.b), a(this.a));
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof fb)) {
         return false;
      } else {
         fb var2 = (fb)var1;
         return Arrays.equals(this.e, var2.e) && this.d.equals(var2.d) && super.equals(var1);
      }
   }

   public int hashCode() {
      int var1 = super.hashCode();
      var1 = 31 * var1 + this.d.hashCode();
      var1 = 31 * var1 + Arrays.hashCode(this.e);
      return var1;
   }

   protected void b(String var1) {
      boolean var2 = false;
      Matcher var3 = c.matcher(var1);
      int var4 = 0;
      int var5 = 0;

      try {
         int var7;
         for(; var3.find(var5); var5 = var7) {
            int var6 = var3.start();
            var7 = var3.end();
            if (var6 > var5) {
               fa var8 = new fa(String.format(var1.substring(var5, var6)));
               var8.b().a(this.b());
               this.b.add(var8);
            }

            String var14 = var3.group(2);
            String var9 = var1.substring(var6, var7);
            if ("%".equals(var14) && "%%".equals(var9)) {
               fa var15 = new fa("%");
               var15.b().a(this.b());
               this.b.add(var15);
            } else {
               if (!"s".equals(var14)) {
                  throw new fc(this, "Unsupported format: '" + var9 + "'");
               }

               String var10 = var3.group(1);
               int var11 = var10 != null ? Integer.parseInt(var10) - 1 : var4++;
               if (var11 < this.e.length) {
                  this.b.add(this.a(var11));
               }
            }
         }

         if (var5 < var1.length()) {
            fa var13 = new fa(String.format(var1.substring(var5)));
            var13.b().a(this.b());
            this.b.add(var13);
         }

      } catch (IllegalFormatException var12) {
         throw new fc(this, var12);
      }
   }
}
