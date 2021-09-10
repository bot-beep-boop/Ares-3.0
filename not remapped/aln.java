import com.google.gson.JsonParseException;
import net.minecraft.server.MinecraftServer;

public class aln extends akw {
   private boolean g = true;
   private final n i = new n();
   public int f = -1;
   private wn h;
   public final eu[] a = new eu[]{new fa(""), new fa(""), new fa(""), new fa("")};

   public boolean F() {
      return true;
   }

   public void b(dn var1) {
      super.b(var1);

      for(int var2 = 0; var2 < 4; ++var2) {
         String var3 = eu.a.a(this.a[var2]);
         var1.a("Text" + (var2 + 1), var3);
      }

      this.i.b(var1);
   }

   public ff y_() {
      eu[] var1 = new eu[4];
      System.arraycopy(this.a, 0, var1, 0, 4);
      return new hw(this.b, this.c, var1);
   }

   public n d() {
      return this.i;
   }

   public void a(dn var1) {
      this.g = false;
      super.a(var1);
      m var2 = new m(this) {
         final aln a;

         public boolean u_() {
            return false;
         }

         public cj c() {
            return this.a.c;
         }

         public void a(n.a var1, int var2) {
         }

         public void a(eu var1) {
         }

         public pk f() {
            return null;
         }

         public String e_() {
            return "Sign";
         }

         public aui d() {
            return new aui((double)this.a.c.n() + 0.5D, (double)this.a.c.o() + 0.5D, (double)this.a.c.p() + 0.5D);
         }

         public adm e() {
            return this.a.b;
         }

         public eu f_() {
            return new fa(this.e_());
         }

         {
            this.a = var1;
         }

         public boolean a(int var1, String var2) {
            return true;
         }
      };

      for(int var3 = 0; var3 < 4; ++var3) {
         String var4 = var1.j("Text" + (var3 + 1));

         try {
            eu var5 = eu.a.a(var4);

            try {
               this.a[var3] = ev.a(var2, var5, (pk)null);
            } catch (bz var7) {
               this.a[var3] = var5;
            }
         } catch (JsonParseException var8) {
            this.a[var3] = new fa(var4);
         }
      }

      this.i.a(var1);
   }

   public wn c() {
      return this.h;
   }

   public boolean b(wn var1) {
      m var2 = new m(this, var1) {
         final wn a;
         final aln b;

         public void a(eu var1) {
         }

         public aui d() {
            return new aui((double)this.b.c.n() + 0.5D, (double)this.b.c.o() + 0.5D, (double)this.b.c.p() + 0.5D);
         }

         public boolean a(int var1, String var2) {
            return var1 <= 2;
         }

         public adm e() {
            return this.a.e();
         }

         public pk f() {
            return this.a;
         }

         public cj c() {
            return this.b.c;
         }

         {
            this.b = var1;
            this.a = var2;
         }

         public void a(n.a var1, int var2) {
            aln.a(this.b).a(this, var1, var2);
         }

         public eu f_() {
            return this.a.f_();
         }

         public boolean u_() {
            return false;
         }

         public String e_() {
            return this.a.e_();
         }
      };

      for(int var3 = 0; var3 < this.a.length; ++var3) {
         ez var4 = this.a[var3] == null ? null : this.a[var3].b();
         if (var4 != null && var4.h() != null) {
            et var5 = var4.h();
            if (var5.a() == et.a.c) {
               MinecraftServer.N().P().a(var2, var5.b());
            }
         }
      }

      return true;
   }

   public void a(wn var1) {
      this.h = var1;
   }

   public boolean b() {
      return this.g;
   }

   public void a(boolean var1) {
      this.g = var1;
      if (!var1) {
         this.h = null;
      }

   }

   static n a(aln var0) {
      return var0.i;
   }
}
