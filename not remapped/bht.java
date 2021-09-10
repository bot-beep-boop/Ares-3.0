import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.nio.FloatBuffer;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class bht {
   private adm d;
   private final bmt[] m;
   private final int k;
   private final FloatBuffer l;
   private final Set<akw> j;
   private int n;
   public aug c;
   private bhn i;
   private final ReentrantLock g;
   private final bfr e;
   public static int a;
   private boolean o;
   private EnumMap<cq, cj> p;
   private cj f;
   private final ReentrantLock h;
   public bhq b;

   private void a(bfd var1, cj var2) {
      var1.a(7, bms.a);
      var1.c((double)(-var2.n()), (double)(-var2.o()), (double)(-var2.p()));
   }

   public void a(float var1, float var2, float var3, bhn var4) {
      bhq var5 = var4.c();
      if (var5.c() != null && !var5.b(adf.d)) {
         this.a(var4.d().a(adf.d), this.f);
         var4.d().a(adf.d).a(var5.c());
         this.a(adf.d, var1, var2, var3, var4.d().a(adf.d), var5);
      }
   }

   protected void b() {
      this.g.lock();

      try {
         if (this.i != null && this.i.a() != bhn.a.d) {
            this.i.e();
            this.i = null;
         }
      } finally {
         this.g.unlock();
      }

   }

   public void h() {
      this.b();
      this.b = bhq.a;
   }

   public boolean l() {
      return this.o;
   }

   public ReentrantLock c() {
      return this.g;
   }

   public cj j() {
      return this.f;
   }

   public bhn d() {
      this.g.lock();

      bhn var1;
      try {
         this.b();
         this.i = new bhn(this, bhn.b.a);
         var1 = this.i;
      } finally {
         this.g.unlock();
      }

      return var1;
   }

   public void a(boolean var1) {
      this.o = var1;
   }

   public bmt b(int var1) {
      return this.m[var1];
   }

   public bhn e() {
      this.g.lock();

      bhn var1;
      try {
         if (this.i == null || this.i.a() != bhn.a.a) {
            if (this.i != null && this.i.a() != bhn.a.d) {
               this.i.e();
               this.i = null;
            }

            this.i = new bhn(this, bhn.b.b);
            this.i.a(this.b);
            var1 = this.i;
            return var1;
         }

         var1 = null;
      } finally {
         this.g.unlock();
      }

      return var1;
   }

   public boolean a(int var1) {
      if (this.n == var1) {
         return false;
      } else {
         this.n = var1;
         return true;
      }
   }

   private void m() {
      bfl.E();
      bfl.D();
      float var1 = 1.000001F;
      bfl.b(-8.0F, -8.0F, -8.0F);
      bfl.a(var1, var1, var1);
      bfl.b(8.0F, 8.0F, 8.0F);
      bfl.a(2982, this.l);
      bfl.F();
   }

   public cj a(cq var1) {
      return (cj)this.p.get(var1);
   }

   public void a() {
      this.h();
      this.d = null;

      for(int var1 = 0; var1 < adf.values().length; ++var1) {
         if (this.m[var1] != null) {
            this.m[var1].c();
         }
      }

   }

   public void f() {
      bfl.a(this.l);
   }

   public bhq g() {
      return this.b;
   }

   public bht(adm var1, bfr var2, cj var3, int var4) {
      this.b = bhq.a;
      this.g = new ReentrantLock();
      this.h = new ReentrantLock();
      this.i = null;
      this.j = Sets.newHashSet();
      this.l = avd.h(16);
      this.m = new bmt[adf.values().length];
      this.n = -1;
      this.o = true;
      this.p = Maps.newEnumMap(cq.class);
      this.d = var1;
      this.e = var2;
      this.k = var4;
      if (!var3.equals(this.j())) {
         this.a(var3);
      }

      if (bqs.f()) {
         for(int var5 = 0; var5 < adf.values().length; ++var5) {
            this.m[var5] = new bmt(bms.a);
         }
      }

   }

   public void b(float var1, float var2, float var3, bhn var4) {
      bhq var5 = new bhq();
      boolean var6 = true;
      cj var7 = this.f;
      cj var8 = var7.a(15, 15, 15);
      var4.f().lock();

      bff var9;
      try {
         if (var4.a() != bhn.a.b) {
            return;
         }

         var9 = new bff(this.d, var7.a(-1, -1, -1), var8.a(1, 1, 1), 1);
         var4.a(var5);
      } finally {
         var4.f().unlock();
      }

      bhw var10 = new bhw();
      HashSet var11 = Sets.newHashSet();
      if (!var9.W()) {
         ++a;
         boolean[] var12 = new boolean[adf.values().length];
         bgd var13 = ave.A().ae();
         Iterator var14 = cj.b(var7, var8).iterator();

         while(var14.hasNext()) {
            cj.a var15 = (cj.a)var14.next();
            alz var16 = var9.p(var15);
            afh var17 = var16.c();
            if (var17.c()) {
               var10.a(var15);
            }

            if (var17.z()) {
               akw var18 = var9.s(new cj(var15));
               bhd var19 = bhc.a.b(var18);
               if (var18 != null && var19 != null) {
                  var5.a(var18);
                  if (var19.a()) {
                     var11.add(var18);
                  }
               }
            }

            adf var34 = var17.m();
            int var35 = var34.ordinal();
            if (var17.b() != -1) {
               bfd var20 = var4.d().a(var35);
               if (!var5.d(var34)) {
                  var5.c(var34);
                  this.a(var20, var7);
               }

               var12[var35] |= var13.a(var16, var15, (adq)var9, (bfd)var20);
            }
         }

         adf[] var30 = adf.values();
         int var31 = var30.length;

         for(int var32 = 0; var32 < var31; ++var32) {
            adf var33 = var30[var32];
            if (var12[var33.ordinal()]) {
               var5.a(var33);
            }

            if (var5.d(var33)) {
               this.a(var33, var1, var2, var3, var4.d().a(var33), var5);
            }
         }
      }

      var5.a(var10.a());
      this.g.lock();

      try {
         HashSet var28 = Sets.newHashSet(var11);
         HashSet var29 = Sets.newHashSet(this.j);
         var28.removeAll(this.j);
         var29.removeAll(var11);
         this.j.clear();
         this.j.addAll(var11);
         this.e.a((Collection)var29, (Collection)var28);
      } finally {
         this.g.unlock();
      }

   }

   public void a(cj var1) {
      this.h();
      this.f = var1;
      this.c = new aug(var1, var1.a(16, 16, 16));
      cq[] var2 = cq.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         cq var5 = var2[var4];
         this.p.put(var5, var1.a(var5, 16));
      }

      this.m();
   }

   public void a(bhq var1) {
      this.h.lock();

      try {
         this.b = var1;
      } finally {
         this.h.unlock();
      }

   }

   private void a(adf var1, float var2, float var3, float var4, bfd var5, bhq var6) {
      if (var1 == adf.d && !var6.b(var1)) {
         var5.a(var2, var3, var4);
         var6.a(var5.a());
      }

      var5.e();
   }
}
