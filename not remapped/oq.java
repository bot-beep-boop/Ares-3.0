import com.google.common.collect.Lists;
import java.util.List;

public class oq implements og {
   private zx[] c;
   private int b;
   private String a;
   private boolean e;
   private List<oh> d;

   public int q_() {
      return 64;
   }

   public oq(eu var1, int var2) {
      this(var1.c(), true, var2);
   }

   public String e_() {
      return this.a;
   }

   public zx a(zx var1) {
      zx var2 = var1.k();

      for(int var3 = 0; var3 < this.b; ++var3) {
         zx var4 = this.a(var3);
         if (var4 == null) {
            this.a(var3, var2);
            this.p_();
            return null;
         }

         if (zx.c(var4, var2)) {
            int var5 = Math.min(this.q_(), var4.c());
            int var6 = Math.min(var2.b, var5 - var4.b);
            if (var6 > 0) {
               var4.b += var6;
               var2.b -= var6;
               if (var2.b <= 0) {
                  this.p_();
                  return null;
               }
            }
         }
      }

      if (var2.b != var1.b) {
         this.p_();
      }

      return var2;
   }

   public void a(oh var1) {
      if (this.d == null) {
         this.d = Lists.newArrayList();
      }

      this.d.add(var1);
   }

   public int o_() {
      return this.b;
   }

   public void b(oh var1) {
      this.d.remove(var1);
   }

   public zx b(int var1) {
      if (this.c[var1] != null) {
         zx var2 = this.c[var1];
         this.c[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public zx a(int var1, int var2) {
      if (this.c[var1] != null) {
         zx var3;
         if (this.c[var1].b <= var2) {
            var3 = this.c[var1];
            this.c[var1] = null;
            this.p_();
            return var3;
         } else {
            var3 = this.c[var1].a(var2);
            if (this.c[var1].b == 0) {
               this.c[var1] = null;
            }

            this.p_();
            return var3;
         }
      } else {
         return null;
      }
   }

   public void a(String var1) {
      this.e = true;
      this.a = var1;
   }

   public void b(wn var1) {
   }

   public boolean b(int var1, zx var2) {
      return true;
   }

   public zx a(int var1) {
      return var1 >= 0 && var1 < this.c.length ? this.c[var1] : null;
   }

   public void l() {
      for(int var1 = 0; var1 < this.c.length; ++var1) {
         this.c[var1] = null;
      }

   }

   public eu f_() {
      return (eu)(this.l_() ? new fa(this.e_()) : new fb(this.e_(), new Object[0]));
   }

   public oq(String var1, boolean var2, int var3) {
      this.a = var1;
      this.e = var2;
      this.b = var3;
      this.c = new zx[var3];
   }

   public void p_() {
      if (this.d != null) {
         for(int var1 = 0; var1 < this.d.size(); ++var1) {
            ((oh)this.d.get(var1)).a(this);
         }
      }

   }

   public int a_(int var1) {
      return 0;
   }

   public int g() {
      return 0;
   }

   public void c(wn var1) {
   }

   public boolean a(wn var1) {
      return true;
   }

   public boolean l_() {
      return this.e;
   }

   public void a(int var1, zx var2) {
      this.c[var1] = var2;
      if (var2 != null && var2.b > this.q_()) {
         var2.b = this.q_();
      }

      this.p_();
   }

   public void b(int var1, int var2) {
   }
}
