import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class atg extends ate {
   private Map<wn, atg.a> i = Maps.newHashMap();
   public byte[] f = new byte[16384];
   public byte d;
   public int c;
   public int b;
   public List<atg.a> g = Lists.newArrayList();
   public byte e;
   public Map<String, atf> h = Maps.newLinkedHashMap();

   public atg.a a(wn var1) {
      atg.a var2 = (atg.a)this.i.get(var1);
      if (var2 == null) {
         var2 = new atg.a(this, var1);
         this.i.put(var1, var2);
         this.g.add(var2);
      }

      return var2;
   }

   public void a(double var1, double var3, int var5) {
      int var6 = 128 * (1 << var5);
      int var7 = ns.c((var1 + 64.0D) / (double)var6);
      int var8 = ns.c((var3 + 64.0D) / (double)var6);
      this.b = var7 * var6 + var6 / 2 - 64;
      this.c = var8 * var6 + var6 / 2 - 64;
   }

   public void b(dn var1) {
      var1.a("dimension", this.d);
      var1.a("xCenter", this.b);
      var1.a("zCenter", this.c);
      var1.a("scale", this.e);
      var1.a("width", (short)128);
      var1.a("height", (short)128);
      var1.a("colors", this.f);
   }

   public void a(wn var1, zx var2) {
      if (!this.i.containsKey(var1)) {
         atg.a var3 = new atg.a(this, var1);
         this.i.put(var1, var3);
         this.g.add(var3);
      }

      if (!var1.bi.c(var2)) {
         this.h.remove(var1.e_());
      }

      for(int var6 = 0; var6 < this.g.size(); ++var6) {
         atg.a var4 = (atg.a)this.g.get(var6);
         if (!var4.a.I && (var4.a.bi.c(var2) || var2.y())) {
            if (!var2.y() && var4.a.am == this.d) {
               this.a(0, var4.a.o, var4.a.e_(), var4.a.s, var4.a.u, (double)var4.a.y);
            }
         } else {
            this.i.remove(var4.a);
            this.g.remove(var4);
         }
      }

      if (var2.y()) {
         uo var7 = var2.z();
         cj var8 = var7.n();
         this.a(1, var1.o, "frame-" + var7.F(), (double)var8.n(), (double)var8.p(), (double)(var7.b.b() * 90));
      }

      if (var2.n() && var2.o().b("Decorations", 9)) {
         du var9 = var2.o().c("Decorations", 10);

         for(int var10 = 0; var10 < var9.c(); ++var10) {
            dn var5 = var9.b(var10);
            if (!this.h.containsKey(var5.j("id"))) {
               this.a(var5.d("type"), var1.o, var5.j("id"), var5.i("x"), var5.i("z"), var5.i("rot"));
            }
         }
      }

   }

   public void a(int var1, int var2) {
      super.c();
      Iterator var3 = this.g.iterator();

      while(var3.hasNext()) {
         atg.a var4 = (atg.a)var3.next();
         var4.a(var1, var2);
      }

   }

   public ff a(zx var1, adm var2, wn var3) {
      atg.a var4 = (atg.a)this.i.get(var3);
      return var4 == null ? null : var4.a(var1);
   }

   private void a(int var1, adm var2, String var3, double var4, double var6, double var8) {
      int var10 = 1 << this.e;
      float var11 = (float)(var4 - (double)this.b) / (float)var10;
      float var12 = (float)(var6 - (double)this.c) / (float)var10;
      byte var13 = (byte)((int)((double)(var11 * 2.0F) + 0.5D));
      byte var14 = (byte)((int)((double)(var12 * 2.0F) + 0.5D));
      byte var16 = 63;
      byte var15;
      if (var11 >= (float)(-var16) && var12 >= (float)(-var16) && var11 <= (float)var16 && var12 <= (float)var16) {
         var8 += var8 < 0.0D ? -8.0D : 8.0D;
         var15 = (byte)((int)(var8 * 16.0D / 360.0D));
         if (this.d < 0) {
            int var17 = (int)(var2.P().g() / 10L);
            var15 = (byte)(var17 * var17 * 34187121 + var17 * 121 >> 15 & 15);
         }
      } else {
         if (!(Math.abs(var11) < 320.0F) || !(Math.abs(var12) < 320.0F)) {
            this.h.remove(var3);
            return;
         }

         var1 = 6;
         var15 = 0;
         if (var11 <= (float)(-var16)) {
            var13 = (byte)((int)((double)(var16 * 2) + 2.5D));
         }

         if (var12 <= (float)(-var16)) {
            var14 = (byte)((int)((double)(var16 * 2) + 2.5D));
         }

         if (var11 >= (float)var16) {
            var13 = (byte)(var16 * 2 + 1);
         }

         if (var12 >= (float)var16) {
            var14 = (byte)(var16 * 2 + 1);
         }
      }

      this.h.put(var3, new atf((byte)var1, var13, var14, var15));
   }

   public void a(dn var1) {
      this.d = var1.d("dimension");
      this.b = var1.f("xCenter");
      this.c = var1.f("zCenter");
      this.e = var1.d("scale");
      this.e = (byte)ns.a(this.e, 0, 4);
      short var2 = var1.e("width");
      short var3 = var1.e("height");
      if (var2 == 128 && var3 == 128) {
         this.f = var1.k("colors");
      } else {
         byte[] var4 = var1.k("colors");
         this.f = new byte[16384];
         int var5 = (128 - var2) / 2;
         int var6 = (128 - var3) / 2;

         for(int var7 = 0; var7 < var3; ++var7) {
            int var8 = var7 + var6;
            if (var8 >= 0 || var8 < 128) {
               for(int var9 = 0; var9 < var2; ++var9) {
                  int var10 = var9 + var5;
                  if (var10 >= 0 || var10 < 128) {
                     this.f[var10 + var8 * 128] = var4[var9 + var7 * var2];
                  }
               }
            }
         }
      }

   }

   public atg(String var1) {
      super(var1);
   }

   public class a {
      private int g;
      public int b;
      private int i;
      public final wn a;
      private int h;
      private boolean d;
      private int e;
      private int f;
      final atg c;

      public ff a(zx var1) {
         if (this.d) {
            this.d = false;
            return new gu(var1.i(), this.c.e, this.c.h.values(), this.c.f, this.e, this.f, this.g + 1 - this.e, this.h + 1 - this.f);
         } else {
            return this.i++ % 5 == 0 ? new gu(var1.i(), this.c.e, this.c.h.values(), this.c.f, 0, 0, 0, 0) : null;
         }
      }

      public void a(int var1, int var2) {
         if (this.d) {
            this.e = Math.min(this.e, var1);
            this.f = Math.min(this.f, var2);
            this.g = Math.max(this.g, var1);
            this.h = Math.max(this.h, var2);
         } else {
            this.d = true;
            this.e = var1;
            this.f = var2;
            this.g = var1;
            this.h = var2;
         }

      }

      public a(atg var1, wn var2) {
         this.c = var1;
         this.d = true;
         this.e = 0;
         this.f = 0;
         this.g = 127;
         this.h = 127;
         this.a = var2;
      }
   }
}
