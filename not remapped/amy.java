import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class amy {
   private static final Logger c = LogManager.getLogger();
   private final int[] j;
   public final int b;
   private final byte[] e;
   private boolean o;
   private boolean q;
   private boolean r;
   private int v;
   private boolean h;
   private boolean k;
   private int t;
   private final int[] f;
   private boolean p;
   private final Map<cj, akw> l;
   private final amz[] d;
   public final int a;
   private long u;
   private final ne<pk>[] m;
   private ConcurrentLinkedQueue<cj> w;
   private final adm i;
   private final boolean[] g;
   private long s;
   private boolean n;

   public int b(cj var1) {
      return this.a(var1).p();
   }

   public boolean i() {
      return this.p && this.n && this.o;
   }

   public void a(amv var1, amv var2, int var3, int var4) {
      boolean var5 = var1.a(var3, var4 - 1);
      boolean var6 = var1.a(var3 + 1, var4);
      boolean var7 = var1.a(var3, var4 + 1);
      boolean var8 = var1.a(var3 - 1, var4);
      boolean var9 = var1.a(var3 - 1, var4 - 1);
      boolean var10 = var1.a(var3 + 1, var4 + 1);
      boolean var11 = var1.a(var3 - 1, var4 + 1);
      boolean var12 = var1.a(var3 + 1, var4 - 1);
      if (var6 && var7 && var10) {
         if (!this.n) {
            var1.a(var2, var3, var4);
         } else {
            var1.a(var2, this, var3, var4);
         }
      }

      amy var13;
      if (var8 && var7 && var11) {
         var13 = var1.d(var3 - 1, var4);
         if (!var13.n) {
            var1.a(var2, var3 - 1, var4);
         } else {
            var1.a(var2, var13, var3 - 1, var4);
         }
      }

      if (var5 && var6 && var12) {
         var13 = var1.d(var3, var4 - 1);
         if (!var13.n) {
            var1.a(var2, var3, var4 - 1);
         } else {
            var1.a(var2, var13, var3, var4 - 1);
         }
      }

      if (var9 && var5 && var8) {
         var13 = var1.d(var3 - 1, var4 - 1);
         if (!var13.n) {
            var1.a(var2, var3 - 1, var4 - 1);
         } else {
            var1.a(var2, var13, var3 - 1, var4 - 1);
         }
      }

   }

   public afh a(int var1, int var2, int var3) {
      try {
         return this.f(var1 & 15, var2, var3 & 15);
      } catch (e var6) {
         c var5 = var6.a().a("Block being got");
         var5.a("Location", new Callable<String>(this, var1, var2, var3) {
            final amy d;
            final int c;
            final int a;
            final int b;

            public String a() throws Exception {
               return c.a(new cj(this.d.a * 16 + this.a, this.b, this.d.b * 16 + this.c));
            }

            public Object call() throws Exception {
               return this.a();
            }

            {
               this.d = var1;
               this.a = var2;
               this.b = var3;
               this.c = var4;
            }
         });
         throw var6;
      }
   }

   public adm p() {
      return this.i;
   }

   public Random a(long var1) {
      return new Random(this.i.J() + (long)(this.a * this.a * 4987142) + (long)(this.a * 5947611) + (long)(this.b * this.b) * 4392871L + (long)(this.b * 389711) ^ var1);
   }

   public void d(boolean var1) {
      this.n = var1;
   }

   public int v() {
      return this.t;
   }

   private int g(int var1, int var2, int var3) {
      if (var2 >> 4 >= this.d.length) {
         return 0;
      } else {
         amz var4 = this.d[var2 >> 4];
         return var4 != null ? var4.c(var1, var2 & 15, var3) : 0;
      }
   }

   public void a(cj var1, akw var2) {
      var2.a(this.i);
      var2.a(var1);
      if (this.a(var1) instanceof agq) {
         if (this.l.containsKey(var1)) {
            ((akw)this.l.get(var1)).y();
         }

         var2.D();
         this.l.put(var1, var2);
      }
   }

   public adg j() {
      return new adg(this.a, this.b);
   }

   public boolean u() {
      return this.o;
   }

   private akw i(cj var1) {
      afh var2 = this.a(var1);
      return !var2.z() ? null : ((agq)var2).a(this.i, this.c(var1));
   }

   public boolean a(int var1, int var2) {
      return var1 == this.a && var2 == this.b;
   }

   public void a(akw var1) {
      this.a(var1.v(), var1);
      if (this.h) {
         this.i.a(var1);
      }

   }

   public void b(boolean var1) {
      if (this.k && !this.i.t.o() && !var1) {
         this.h(this.i.D);
      }

      this.p = true;
      if (!this.o && this.n) {
         this.n();
      }

      while(!this.w.isEmpty()) {
         cj var2 = (cj)this.w.poll();
         if (this.a(var2, amy.a.c) == null && this.a(var2).z()) {
            akw var3 = this.i(var2);
            this.i.a(var2, var3);
            this.i.b(var2, var2);
         }
      }

   }

   public int[] q() {
      return this.j;
   }

   private int e(int var1, int var2, int var3) {
      return this.f(var1, var2, var3).p();
   }

   public void a(pk var1, int var2) {
      if (var2 < 0) {
         var2 = 0;
      }

      if (var2 >= this.m.length) {
         var2 = this.m.length - 1;
      }

      this.m[var2].remove(var1);
   }

   public void a(byte[] var1) {
      if (this.e.length != var1.length) {
         c.warn("Could not set level chunk biomes, array length is " + var1.length + " instead of " + this.e.length);
      } else {
         for(int var2 = 0; var2 < this.e.length; ++var2) {
            this.e[var2] = var1[var2];
         }

      }
   }

   public afh a(cj var1) {
      try {
         return this.f(var1.n() & 15, var1.o(), var1.p() & 15);
      } catch (e var4) {
         c var3 = var4.a().a("Block being got");
         var3.a("Location", new Callable<String>(this, var1) {
            final cj a;
            final amy b;

            public Object call() throws Exception {
               return this.a();
            }

            {
               this.b = var1;
               this.a = var2;
            }

            public String a() throws Exception {
               return c.a(this.a);
            }
         });
         throw var4;
      }
   }

   private void h(boolean var1) {
      this.i.B.a("recheckGaps");
      if (this.i.a((cj)(new cj(this.a * 16 + 8, 0, this.b * 16 + 8)), (int)16)) {
         for(int var2 = 0; var2 < 16; ++var2) {
            for(int var3 = 0; var3 < 16; ++var3) {
               if (this.g[var2 + var3 * 16]) {
                  this.g[var2 + var3 * 16] = false;
                  int var4 = this.b(var2, var3);
                  int var5 = this.a * 16 + var2;
                  int var6 = this.b * 16 + var3;
                  int var7 = Integer.MAX_VALUE;

                  Iterator var8;
                  cq var9;
                  for(var8 = cq.c.a.iterator(); var8.hasNext(); var7 = Math.min(var7, this.i.b(var5 + var9.g(), var6 + var9.i()))) {
                     var9 = (cq)var8.next();
                  }

                  this.c(var5, var6, var7);
                  var8 = cq.c.a.iterator();

                  while(var8.hasNext()) {
                     var9 = (cq)var8.next();
                     this.c(var5 + var9.g(), var6 + var9.i(), var4);
                  }

                  if (var1) {
                     this.i.B.b();
                     return;
                  }
               }
            }
         }

         this.k = false;
      }

      this.i.B.b();
   }

   private void a(cq var1) {
      if (this.n) {
         int var2;
         if (var1 == cq.f) {
            for(var2 = 0; var2 < 16; ++var2) {
               this.e(15, var2);
            }
         } else if (var1 == cq.e) {
            for(var2 = 0; var2 < 16; ++var2) {
               this.e(0, var2);
            }
         } else if (var1 == cq.d) {
            for(var2 = 0; var2 < 16; ++var2) {
               this.e(var2, 15);
            }
         } else if (var1 == cq.c) {
            for(var2 = 0; var2 < 16; ++var2) {
               this.e(var2, 0);
            }
         }

      }
   }

   public void l() {
      this.v = 0;
   }

   public void m() {
      cj var1 = new cj(this.a << 4, 0, this.b << 4);

      for(int var2 = 0; var2 < 8; ++var2) {
         if (this.v >= 4096) {
            return;
         }

         int var3 = this.v % 16;
         int var4 = this.v / 16 % 16;
         int var5 = this.v / 256;
         ++this.v;

         for(int var6 = 0; var6 < 16; ++var6) {
            cj var7 = var1.a(var4, (var3 << 4) + var6, var5);
            boolean var8 = var6 == 0 || var6 == 15 || var4 == 0 || var4 == 15 || var5 == 0 || var5 == 15;
            if (this.d[var3] == null && var8 || this.d[var3] != null && this.d[var3].b(var4, var6, var5).t() == arm.a) {
               cq[] var9 = cq.values();
               int var10 = var9.length;

               for(int var11 = 0; var11 < var10; ++var11) {
                  cq var12 = var9[var11];
                  cj var13 = var7.a(var12);
                  if (this.i.p(var13).c().r() > 0) {
                     this.i.x(var13);
                  }
               }

               this.i.x(var7);
            }
         }
      }

   }

   public boolean d(cj var1) {
      int var2 = var1.n() & 15;
      int var3 = var1.o();
      int var4 = var1.p() & 15;
      return var3 >= this.j[var4 << 4 | var2];
   }

   public void b(long var1) {
      this.s = var1;
   }

   public akw a(cj var1, amy.a var2) {
      akw var3 = (akw)this.l.get(var1);
      if (var3 == null) {
         if (var2 == amy.a.a) {
            var3 = this.i(var1);
            this.i.a(var1, var3);
         } else if (var2 == amy.a.b) {
            this.w.add(var1);
         }
      } else if (var3.x()) {
         this.l.remove(var1);
         return null;
      }

      return var3;
   }

   public void f(boolean var1) {
      this.q = var1;
   }

   public void c(boolean var1) {
      this.h = var1;
   }

   public void d() {
      this.h = false;
      Iterator var1 = this.l.values().iterator();

      while(var1.hasNext()) {
         akw var2 = (akw)var1.next();
         this.i.b(var2);
      }

      for(int var3 = 0; var3 < this.m.length; ++var3) {
         this.i.c((Collection)this.m[var3]);
      }

   }

   public ne<pk>[] s() {
      return this.m;
   }

   public int g() {
      for(int var1 = this.d.length - 1; var1 >= 0; --var1) {
         if (this.d[var1] != null) {
            return this.d[var1].d();
         }
      }

      return 0;
   }

   public int a(cj var1, int var2) {
      int var3 = var1.n() & 15;
      int var4 = var1.o();
      int var5 = var1.p() & 15;
      amz var6 = this.d[var4 >> 4];
      if (var6 == null) {
         return !this.i.t.o() && var2 < ads.a.c ? ads.a.c - var2 : 0;
      } else {
         int var7 = this.i.t.o() ? 0 : var6.d(var3, var4 & 15, var5);
         var7 -= var2;
         int var8 = var6.e(var3, var4 & 15, var5);
         if (var8 > var7) {
            var7 = var8;
         }

         return var7;
      }
   }

   public void a(int[] var1) {
      if (this.j.length != var1.length) {
         c.warn("Could not set level chunk heightmap, array length is " + var1.length + " instead of " + this.j.length);
      } else {
         for(int var2 = 0; var2 < this.j.length; ++var2) {
            this.j[var2] = var1[var2];
         }

      }
   }

   protected void a() {
      int var1 = this.g();
      this.t = Integer.MAX_VALUE;

      for(int var2 = 0; var2 < 16; ++var2) {
         for(int var3 = 0; var3 < 16; ++var3) {
            this.f[var2 + (var3 << 4)] = -999;

            for(int var4 = var1 + 16; var4 > 0; --var4) {
               afh var5 = this.f(var2, var4 - 1, var3);
               if (var5.p() != 0) {
                  this.j[var3 << 4 | var2] = var4;
                  if (var4 < this.t) {
                     this.t = var4;
                  }
                  break;
               }
            }
         }
      }

      this.q = true;
   }

   public boolean c(int var1, int var2) {
      if (var1 < 0) {
         var1 = 0;
      }

      if (var2 >= 256) {
         var2 = 255;
      }

      for(int var3 = var1; var3 <= var2; var3 += 16) {
         amz var4 = this.d[var3 >> 4];
         if (var4 != null && !var4.a()) {
            return false;
         }
      }

      return true;
   }

   public amz[] h() {
      return this.d;
   }

   public boolean o() {
      return this.h;
   }

   public byte[] k() {
      return this.e;
   }

   public amy(adm var1, ans var2, int var3, int var4) {
      this(var1, var3, var4);
      short var5 = 256;
      boolean var6 = !var1.t.o();

      for(int var7 = 0; var7 < 16; ++var7) {
         for(int var8 = 0; var8 < 16; ++var8) {
            for(int var9 = 0; var9 < var5; ++var9) {
               int var10 = var7 * var5 * 16 | var8 * var5 | var9;
               alz var11 = var2.a(var10);
               if (var11.c().t() != arm.a) {
                  int var12 = var9 >> 4;
                  if (this.d[var12] == null) {
                     this.d[var12] = new amz(var12 << 4, var6);
                  }

                  this.d[var12].a(var7, var9 & 15, var8, var11);
               }
            }
         }
      }

   }

   private void d(int var1, int var2) {
      this.g[var1 + var2 * 16] = true;
      this.k = true;
   }

   public Map<cj, akw> r() {
      return this.l;
   }

   public void b(pk var1) {
      this.a(var1, var1.af);
   }

   public amy(adm var1, int var2, int var3) {
      this.d = new amz[16];
      this.e = new byte[256];
      this.f = new int[256];
      this.g = new boolean[256];
      this.l = Maps.newHashMap();
      this.v = 4096;
      this.w = Queues.newConcurrentLinkedQueue();
      this.m = (ne[])(new ne[16]);
      this.i = var1;
      this.a = var2;
      this.b = var3;
      this.j = new int[256];

      for(int var4 = 0; var4 < this.m.length; ++var4) {
         this.m[var4] = new ne(pk.class);
      }

      Arrays.fill(this.f, -999);
      Arrays.fill(this.e, (byte)-1);
   }

   public int b(int var1, int var2) {
      return this.j[var2 << 4 | var1];
   }

   public ady a(cj var1, aec var2) {
      int var3 = var1.n() & 15;
      int var4 = var1.p() & 15;
      int var5 = this.e[var4 << 4 | var3] & 255;
      ady var6;
      if (var5 == 255) {
         var6 = var2.a(var1, ady.q);
         var5 = var6.az;
         this.e[var4 << 4 | var3] = (byte)(var5 & 255);
      }

      var6 = ady.e(var5);
      return var6 == null ? ady.q : var6;
   }

   public alz g(cj var1) {
      if (this.i.G() == adr.g) {
         alz var7 = null;
         if (var1.o() == 60) {
            var7 = afi.cv.Q();
         }

         if (var1.o() == 70) {
            var7 = anu.b(var1.n(), var1.p());
         }

         return var7 == null ? afi.a.Q() : var7;
      } else {
         try {
            if (var1.o() >= 0 && var1.o() >> 4 < this.d.length) {
               amz var2 = this.d[var1.o() >> 4];
               if (var2 != null) {
                  int var8 = var1.n() & 15;
                  int var9 = var1.o() & 15;
                  int var5 = var1.p() & 15;
                  return var2.a(var8, var9, var5);
               }
            }

            return afi.a.Q();
         } catch (Throwable var6) {
            b var3 = b.a(var6, "Getting block state");
            c var4 = var3.a("Block being got");
            var4.a("Location", new Callable<String>(this, var1) {
               final amy b;
               final cj a;

               public String a() throws Exception {
                  return c.a(this.a);
               }

               {
                  this.b = var1;
                  this.a = var2;
               }

               public Object call() throws Exception {
                  return this.a();
               }
            });
            throw new e(var3);
         }
      }
   }

   public void a(ads var1, cj var2, int var3) {
      int var4 = var2.n() & 15;
      int var5 = var2.o();
      int var6 = var2.p() & 15;
      amz var7 = this.d[var5 >> 4];
      if (var7 == null) {
         var7 = this.d[var5 >> 4] = new amz(var5 >> 4 << 4, !this.i.t.o());
         this.b();
      }

      this.q = true;
      if (var1 == ads.a) {
         if (!this.i.t.o()) {
            var7.a(var4, var5 & 15, var6, var3);
         }
      } else if (var1 == ads.b) {
         var7.b(var4, var5 & 15, var6, var3);
      }

   }

   public void a(amz[] var1) {
      if (this.d.length != var1.length) {
         c.warn("Could not set level chunk sections, array length is " + var1.length + " instead of " + this.d.length);
      } else {
         for(int var2 = 0; var2 < this.d.length; ++var2) {
            this.d[var2] = var1[var2];
         }

      }
   }

   public void a(byte[] var1, int var2, boolean var3) {
      int var4 = 0;
      boolean var5 = !this.i.t.o();

      int var6;
      for(var6 = 0; var6 < this.d.length; ++var6) {
         if ((var2 & 1 << var6) != 0) {
            if (this.d[var6] == null) {
               this.d[var6] = new amz(var6 << 4, var5);
            }

            char[] var7 = this.d[var6].g();

            for(int var8 = 0; var8 < var7.length; ++var8) {
               var7[var8] = (char)((var1[var4 + 1] & 255) << 8 | var1[var4] & 255);
               var4 += 2;
            }
         } else if (var3 && this.d[var6] != null) {
            this.d[var6] = null;
         }
      }

      amw var9;
      for(var6 = 0; var6 < this.d.length; ++var6) {
         if ((var2 & 1 << var6) != 0 && this.d[var6] != null) {
            var9 = this.d[var6].h();
            System.arraycopy(var1, var4, var9.a(), 0, var9.a().length);
            var4 += var9.a().length;
         }
      }

      if (var5) {
         for(var6 = 0; var6 < this.d.length; ++var6) {
            if ((var2 & 1 << var6) != 0 && this.d[var6] != null) {
               var9 = this.d[var6].i();
               System.arraycopy(var1, var4, var9.a(), 0, var9.a().length);
               var4 += var9.a().length;
            }
         }
      }

      if (var3) {
         System.arraycopy(var1, var4, this.e, 0, this.e.length);
         int var10000 = var4 + this.e.length;
      }

      for(var6 = 0; var6 < this.d.length; ++var6) {
         if (this.d[var6] != null && (var2 & 1 << var6) != 0) {
            this.d[var6].e();
         }
      }

      this.o = true;
      this.n = true;
      this.a();
      Iterator var11 = this.l.values().iterator();

      while(var11.hasNext()) {
         akw var10 = (akw)var11.next();
         var10.E();
      }

   }

   private void c(int var1, int var2, int var3) {
      int var4 = this.i.m(new cj(var1, 0, var2)).o();
      if (var4 > var3) {
         this.a(var1, var2, var3, var4 + 1);
      } else if (var4 < var3) {
         this.a(var1, var2, var4, var3 + 1);
      }

   }

   public int a(ads var1, cj var2) {
      int var3 = var2.n() & 15;
      int var4 = var2.o();
      int var5 = var2.p() & 15;
      amz var6 = this.d[var4 >> 4];
      if (var6 == null) {
         return this.d(var2) ? var1.c : 0;
      } else if (var1 == ads.a) {
         return this.i.t.o() ? 0 : var6.d(var3, var4 & 15, var5);
      } else {
         return var1 == ads.b ? var6.e(var3, var4 & 15, var5) : var1.c;
      }
   }

   public boolean a(boolean var1) {
      if (var1) {
         if (this.r && this.i.K() != this.s || this.q) {
            return true;
         }
      } else if (this.r && this.i.K() >= this.s + 600L) {
         return true;
      }

      return this.q;
   }

   public void e(boolean var1) {
      this.o = var1;
   }

   private void d(int var1, int var2, int var3) {
      int var4 = this.j[var3 << 4 | var1] & 255;
      int var5 = var4;
      if (var2 > var4) {
         var5 = var2;
      }

      while(var5 > 0 && this.e(var1, var5 - 1, var3) == 0) {
         --var5;
      }

      if (var5 != var4) {
         this.i.a(var1 + this.a * 16, var3 + this.b * 16, var5, var4);
         this.j[var3 << 4 | var1] = var5;
         int var6 = this.a * 16 + var1;
         int var7 = this.b * 16 + var3;
         int var8;
         int var13;
         if (!this.i.t.o()) {
            amz var9;
            if (var5 < var4) {
               for(var8 = var5; var8 < var4; ++var8) {
                  var9 = this.d[var8 >> 4];
                  if (var9 != null) {
                     var9.a(var1, var8 & 15, var3, 15);
                     this.i.n(new cj((this.a << 4) + var1, var8, (this.b << 4) + var3));
                  }
               }
            } else {
               for(var8 = var4; var8 < var5; ++var8) {
                  var9 = this.d[var8 >> 4];
                  if (var9 != null) {
                     var9.a(var1, var8 & 15, var3, 0);
                     this.i.n(new cj((this.a << 4) + var1, var8, (this.b << 4) + var3));
                  }
               }
            }

            var8 = 15;

            while(var5 > 0 && var8 > 0) {
               --var5;
               var13 = this.e(var1, var5, var3);
               if (var13 == 0) {
                  var13 = 1;
               }

               var8 -= var13;
               if (var8 < 0) {
                  var8 = 0;
               }

               amz var10 = this.d[var5 >> 4];
               if (var10 != null) {
                  var10.a(var1, var5 & 15, var3, var8);
               }
            }
         }

         var8 = this.j[var3 << 4 | var1];
         var13 = var4;
         int var14 = var8;
         if (var8 < var4) {
            var13 = var8;
            var14 = var4;
         }

         if (var8 < this.t) {
            this.t = var8;
         }

         if (!this.i.t.o()) {
            Iterator var11 = cq.c.a.iterator();

            while(var11.hasNext()) {
               cq var12 = (cq)var11.next();
               this.a(var6 + var12.g(), var7 + var12.i(), var13, var14);
            }

            this.a(var6, var7, var13, var14);
         }

         this.q = true;
      }
   }

   private void y() {
      for(int var1 = 0; var1 < this.g.length; ++var1) {
         this.g[var1] = true;
      }

      this.h(false);
   }

   public alz a(cj var1, alz var2) {
      int var3 = var1.n() & 15;
      int var4 = var1.o();
      int var5 = var1.p() & 15;
      int var6 = var5 << 4 | var3;
      if (var4 >= this.f[var6] - 1) {
         this.f[var6] = -999;
      }

      int var7 = this.j[var6];
      alz var8 = this.g(var1);
      if (var8 == var2) {
         return null;
      } else {
         afh var9 = var2.c();
         afh var10 = var8.c();
         amz var11 = this.d[var4 >> 4];
         boolean var12 = false;
         if (var11 == null) {
            if (var9 == afi.a) {
               return null;
            }

            var11 = this.d[var4 >> 4] = new amz(var4 >> 4 << 4, !this.i.t.o());
            var12 = var4 >= var7;
         }

         var11.a(var3, var4 & 15, var5, var2);
         if (var10 != var9) {
            if (!this.i.D) {
               var10.b(this.i, var1, var8);
            } else if (var10 instanceof agq) {
               this.i.t(var1);
            }
         }

         if (var11.b(var3, var4 & 15, var5) != var9) {
            return null;
         } else {
            if (var12) {
               this.b();
            } else {
               int var13 = var9.p();
               int var14 = var10.p();
               if (var13 > 0) {
                  if (var4 >= var7) {
                     this.d(var3, var4 + 1, var5);
                  }
               } else if (var4 == var7 - 1) {
                  this.d(var3, var4, var5);
               }

               if (var13 != var14 && (var13 < var14 || this.a(ads.a, var1) > 0 || this.a(ads.b, var1) > 0)) {
                  this.d(var3, var5);
               }
            }

            akw var15;
            if (var10 instanceof agq) {
               var15 = this.a(var1, amy.a.c);
               if (var15 != null) {
                  var15.E();
               }
            }

            if (!this.i.D && var10 != var9) {
               var9.c(this.i, var1, var2);
            }

            if (var9 instanceof agq) {
               var15 = this.a(var1, amy.a.c);
               if (var15 == null) {
                  var15 = ((agq)var9).a(this.i, var9.c(var2));
                  this.i.a(var1, var15);
               }

               if (var15 != null) {
                  var15.E();
               }
            }

            this.q = true;
            return var8;
         }
      }
   }

   private afh f(int var1, int var2, int var3) {
      afh var4 = afi.a;
      if (var2 >= 0 && var2 >> 4 < this.d.length) {
         amz var5 = this.d[var2 >> 4];
         if (var5 != null) {
            try {
               var4 = var5.b(var1, var2 & 15, var3);
            } catch (Throwable var8) {
               b var7 = b.a(var8, "Getting block");
               throw new e(var7);
            }
         }
      }

      return var4;
   }

   public void c(long var1) {
      this.u = var1;
   }

   public <T extends pk> void a(Class<? extends T> var1, aug var2, List<T> var3, Predicate<? super T> var4) {
      int var5 = ns.c((var2.b - 2.0D) / 16.0D);
      int var6 = ns.c((var2.e + 2.0D) / 16.0D);
      var5 = ns.a(var5, 0, this.m.length - 1);
      var6 = ns.a(var6, 0, this.m.length - 1);

      label42:
      for(int var7 = var5; var7 <= var6; ++var7) {
         Iterator var8 = this.m[var7].c(var1).iterator();

         while(true) {
            pk var9;
            do {
               do {
                  if (!var8.hasNext()) {
                     continue label42;
                  }

                  var9 = (pk)var8.next();
               } while(!var9.aR().b(var2));
            } while(var4 != null && !var4.apply(var9));

            var3.add(var9);
         }
      }

   }

   public void a(pk var1) {
      this.r = true;
      int var2 = ns.c(var1.s / 16.0D);
      int var3 = ns.c(var1.u / 16.0D);
      if (var2 != this.a || var3 != this.b) {
         c.warn("Wrong location! (" + var2 + ", " + var3 + ") should be (" + this.a + ", " + this.b + "), " + var1, new Object[]{var1});
         var1.J();
      }

      int var4 = ns.c(var1.t / 16.0D);
      if (var4 < 0) {
         var4 = 0;
      }

      if (var4 >= this.m.length) {
         var4 = this.m.length - 1;
      }

      var1.ad = true;
      var1.ae = this.a;
      var1.af = var4;
      var1.ag = this.b;
      this.m[var4].add(var1);
   }

   public void a(pk var1, aug var2, List<pk> var3, Predicate<? super pk> var4) {
      int var5 = ns.c((var2.b - 2.0D) / 16.0D);
      int var6 = ns.c((var2.e + 2.0D) / 16.0D);
      var5 = ns.a(var5, 0, this.m.length - 1);
      var6 = ns.a(var6, 0, this.m.length - 1);

      label83:
      for(int var7 = var5; var7 <= var6; ++var7) {
         if (!this.m[var7].isEmpty()) {
            Iterator var8 = this.m[var7].iterator();

            while(true) {
               pk var9;
               pk[] var10;
               do {
                  do {
                     do {
                        if (!var8.hasNext()) {
                           continue label83;
                        }

                        var9 = (pk)var8.next();
                     } while(!var9.aR().b(var2));
                  } while(var9 == var1);

                  if (var4 == null || var4.apply(var9)) {
                     var3.add(var9);
                  }

                  var10 = var9.aB();
               } while(var10 == null);

               for(int var11 = 0; var11 < var10.length; ++var11) {
                  var9 = var10[var11];
                  if (var9 != var1 && var9.aR().b(var2) && (var4 == null || var4.apply(var9))) {
                     var3.add(var9);
                  }
               }
            }
         }
      }

   }

   public void e() {
      this.q = true;
   }

   private void a(int var1, int var2, int var3, int var4) {
      if (var4 > var3 && this.i.a((cj)(new cj(var1, 0, var2)), (int)16)) {
         for(int var5 = var3; var5 < var4; ++var5) {
            this.i.c(ads.a, new cj(var1, var5, var2));
         }

         this.q = true;
      }

   }

   public boolean f() {
      return false;
   }

   private boolean e(int var1, int var2) {
      int var3 = this.g();
      boolean var4 = false;
      boolean var5 = false;
      cj.a var6 = new cj.a((this.a << 4) + var1, 0, (this.b << 4) + var2);

      int var7;
      for(var7 = var3 + 16 - 1; var7 > this.i.F() || var7 > 0 && !var5; --var7) {
         var6.c(var6.n(), var7, var6.p());
         int var8 = this.b((cj)var6);
         if (var8 == 255 && var6.o() < this.i.F()) {
            var5 = true;
         }

         if (!var4 && var8 > 0) {
            var4 = true;
         } else if (var4 && var8 == 0 && !this.i.x(var6)) {
            return false;
         }
      }

      for(var7 = var6.o(); var7 > 0; --var7) {
         var6.c(var6.n(), var7, var6.p());
         if (this.a((cj)var6).r() > 0) {
            this.i.x(var6);
         }
      }

      return true;
   }

   public void g(boolean var1) {
      this.r = var1;
   }

   public void e(cj var1) {
      if (this.h) {
         akw var2 = (akw)this.l.remove(var1);
         if (var2 != null) {
            var2.y();
         }
      }

   }

   public void b() {
      int var1 = this.g();
      this.t = Integer.MAX_VALUE;

      for(int var2 = 0; var2 < 16; ++var2) {
         for(int var3 = 0; var3 < 16; ++var3) {
            this.f[var2 + (var3 << 4)] = -999;

            int var4;
            for(var4 = var1 + 16; var4 > 0; --var4) {
               if (this.e(var2, var4 - 1, var3) != 0) {
                  this.j[var3 << 4 | var2] = var4;
                  if (var4 < this.t) {
                     this.t = var4;
                  }
                  break;
               }
            }

            if (!this.i.t.o()) {
               var4 = 15;
               int var5 = var1 + 16 - 1;

               do {
                  int var6 = this.e(var2, var5, var3);
                  if (var6 == 0 && var4 != 15) {
                     var6 = 1;
                  }

                  var4 -= var6;
                  if (var4 > 0) {
                     amz var7 = this.d[var5 >> 4];
                     if (var7 != null) {
                        var7.a(var2, var5 & 15, var3, var4);
                        this.i.n(new cj((this.a << 4) + var2, var5, (this.b << 4) + var3));
                     }
                  }

                  --var5;
               } while(var5 > 0 && var4 > 0);
            }
         }
      }

      this.q = true;
   }

   public long w() {
      return this.u;
   }

   public boolean t() {
      return this.n;
   }

   public void n() {
      this.n = true;
      this.o = true;
      cj var1 = new cj(this.a << 4, 0, this.b << 4);
      if (!this.i.t.o()) {
         if (this.i.a(var1.a(-1, 0, -1), var1.a(16, this.i.F(), 16))) {
            label58:
            for(int var2 = 0; var2 < 16; ++var2) {
               for(int var3 = 0; var3 < 16; ++var3) {
                  if (!this.e(var2, var3)) {
                     this.o = false;
                     break label58;
                  }
               }
            }

            if (this.o) {
               Iterator var5 = cq.c.a.iterator();

               while(var5.hasNext()) {
                  cq var6 = (cq)var5.next();
                  int var4 = var6.c() == cq.b.a ? 16 : 1;
                  this.i.f(var1.a(var6, var4)).a(var6.d());
               }

               this.y();
            }
         } else {
            this.o = false;
         }
      }

   }

   public int f(cj var1) {
      return this.b(var1.n() & 15, var1.p() & 15);
   }

   public void c() {
      this.h = true;
      this.i.a(this.l.values());

      for(int var1 = 0; var1 < this.m.length; ++var1) {
         Iterator var2 = this.m[var1].iterator();

         while(var2.hasNext()) {
            pk var3 = (pk)var2.next();
            var3.ah();
         }

         this.i.b((Collection)this.m[var1]);
      }

   }

   public cj h(cj var1) {
      int var2 = var1.n() & 15;
      int var3 = var1.p() & 15;
      int var4 = var2 | var3 << 4;
      cj var5 = new cj(var1.n(), this.f[var4], var1.p());
      if (var5.o() == -999) {
         int var6 = this.g() + 15;
         var5 = new cj(var1.n(), var6, var1.p());
         int var7 = -1;

         while(true) {
            while(var5.o() > 0 && var7 == -1) {
               afh var8 = this.a(var5);
               arm var9 = var8.t();
               if (!var9.c() && !var9.d()) {
                  var5 = var5.b();
               } else {
                  var7 = var5.o() + 1;
               }
            }

            this.f[var4] = var7;
            break;
         }
      }

      return new cj(var1.n(), this.f[var4], var1.p());
   }

   public int c(cj var1) {
      return this.g(var1.n() & 15, var1.o(), var1.p() & 15);
   }

   public static enum a {
      c,
      a;

      private static final amy.a[] d = new amy.a[]{a, b, c};
      b;
   }
}
