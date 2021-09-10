import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public abstract class add {
   private int g = 200;
   private int h = 800;
   private int k = 6;
   private add.a d;
   private int l = 16;
   private String b = "Pig";
   private final List<add.a> c = Lists.newArrayList();
   private int m = 4;
   private double f;
   private pk j;
   private int a = 20;
   private double e;
   private int i = 4;

   public void c() {
      if (this.g()) {
         cj var1 = this.b();
         double var6;
         if (this.a().D) {
            double var13 = (double)((float)var1.n() + this.a().s.nextFloat());
            double var14 = (double)((float)var1.o() + this.a().s.nextFloat());
            var6 = (double)((float)var1.p() + this.a().s.nextFloat());
            this.a().a(cy.l, var13, var14, var6, 0.0D, 0.0D, 0.0D);
            this.a().a(cy.A, var13, var14, var6, 0.0D, 0.0D, 0.0D);
            if (this.a > 0) {
               --this.a;
            }

            this.f = this.e;
            this.e = (this.e + (double)(1000.0F / ((float)this.a + 200.0F))) % 360.0D;
         } else {
            if (this.a == -1) {
               this.h();
            }

            if (this.a > 0) {
               --this.a;
               return;
            }

            boolean var2 = false;
            int var3 = 0;

            while(true) {
               if (var3 >= this.i) {
                  if (var2) {
                     this.h();
                  }
                  break;
               }

               pk var4 = pm.a(this.f(), this.a());
               if (var4 == null) {
                  return;
               }

               int var5 = this.a().a(var4.getClass(), (new aug((double)var1.n(), (double)var1.o(), (double)var1.p(), (double)(var1.n() + 1), (double)(var1.o() + 1), (double)(var1.p() + 1))).b((double)this.m, (double)this.m, (double)this.m)).size();
               if (var5 >= this.k) {
                  this.h();
                  return;
               }

               var6 = (double)var1.n() + (this.a().s.nextDouble() - this.a().s.nextDouble()) * (double)this.m + 0.5D;
               double var8 = (double)(var1.o() + this.a().s.nextInt(3) - 1);
               double var10 = (double)var1.p() + (this.a().s.nextDouble() - this.a().s.nextDouble()) * (double)this.m + 0.5D;
               ps var12 = var4 instanceof ps ? (ps)var4 : null;
               var4.b(var6, var8, var10, this.a().s.nextFloat() * 360.0F, 0.0F);
               if (var12 == null || var12.bR() && var12.bS()) {
                  this.a(var4, true);
                  this.a().b(2004, var1, 0);
                  if (var12 != null) {
                     var12.y();
                  }

                  var2 = true;
               }

               ++var3;
            }
         }

      }
   }

   public void a(dn var1) {
      this.b = var1.j("EntityId");
      this.a = var1.e("Delay");
      this.c.clear();
      if (var1.b("SpawnPotentials", 9)) {
         du var2 = var1.c("SpawnPotentials", 10);

         for(int var3 = 0; var3 < var2.c(); ++var3) {
            this.c.add(new add.a(this, var2.b(var3)));
         }
      }

      if (var1.b("SpawnData", 10)) {
         this.a(new add.a(this, var1.m("SpawnData"), this.b));
      } else {
         this.a((add.a)null);
      }

      if (var1.b("MinSpawnDelay", 99)) {
         this.g = var1.e("MinSpawnDelay");
         this.h = var1.e("MaxSpawnDelay");
         this.i = var1.e("SpawnCount");
      }

      if (var1.b("MaxNearbyEntities", 99)) {
         this.k = var1.e("MaxNearbyEntities");
         this.l = var1.e("RequiredPlayerRange");
      }

      if (var1.b("SpawnRange", 99)) {
         this.m = var1.e("SpawnRange");
      }

      if (this.a() != null) {
         this.j = null;
      }

   }

   public void a(add.a var1) {
      this.d = var1;
   }

   public abstract cj b();

   private pk a(pk var1, boolean var2) {
      if (this.i() != null) {
         dn var3 = new dn();
         var1.d(var3);
         Iterator var4 = add.a.b(this.i()).c().iterator();

         while(var4.hasNext()) {
            String var5 = (String)var4.next();
            eb var6 = add.a.b(this.i()).a(var5);
            var3.a(var5, var6.b());
         }

         var1.f(var3);
         if (var1.o != null && var2) {
            var1.o.d(var1);
         }

         dn var12;
         for(pk var11 = var1; var3.b("Riding", 10); var3 = var12) {
            var12 = var3.m("Riding");
            pk var13 = pm.a(var12.j("id"), var1.o);
            if (var13 != null) {
               dn var7 = new dn();
               var13.d(var7);
               Iterator var8 = var12.c().iterator();

               while(var8.hasNext()) {
                  String var9 = (String)var8.next();
                  eb var10 = var12.a(var9);
                  var7.a(var9, var10.b());
               }

               var13.f(var7);
               var13.b(var11.s, var11.t, var11.u, var11.y, var11.z);
               if (var1.o != null && var2) {
                  var1.o.d(var13);
               }

               var11.a(var13);
            }

            var11 = var13;
         }
      } else if (var1 instanceof pr && var1.o != null && var2) {
         if (var1 instanceof ps) {
            ((ps)var1).a(var1.o.E(new cj(var1)), (pu)null);
         }

         var1.o.d(var1);
      }

      return var1;
   }

   public pk a(adm var1) {
      if (this.j == null) {
         pk var2 = pm.a(this.f(), var1);
         if (var2 != null) {
            var2 = this.a(var2, false);
            this.j = var2;
         }
      }

      return this.j;
   }

   private String f() {
      if (this.i() == null) {
         if (this.b != null && this.b.equals("Minecart")) {
            this.b = "MinecartRideable";
         }

         return this.b;
      } else {
         return add.a.a(this.i());
      }
   }

   private void h() {
      if (this.h <= this.g) {
         this.a = this.g;
      } else {
         int var10003 = this.h - this.g;
         this.a = this.g + this.a().s.nextInt(var10003);
      }

      if (this.c.size() > 0) {
         this.a((add.a)oa.a(this.a().s, this.c));
      }

      this.a(1);
   }

   public boolean b(int var1) {
      if (var1 == 1 && this.a().D) {
         this.a = this.g;
         return true;
      } else {
         return false;
      }
   }

   public void a(String var1) {
      this.b = var1;
   }

   public double d() {
      return this.e;
   }

   private boolean g() {
      cj var1 = this.b();
      return this.a().b((double)var1.n() + 0.5D, (double)var1.o() + 0.5D, (double)var1.p() + 0.5D, (double)this.l);
   }

   public void b(dn var1) {
      String var2 = this.f();
      if (!nx.b(var2)) {
         var1.a("EntityId", var2);
         var1.a("Delay", (short)this.a);
         var1.a("MinSpawnDelay", (short)this.g);
         var1.a("MaxSpawnDelay", (short)this.h);
         var1.a("SpawnCount", (short)this.i);
         var1.a("MaxNearbyEntities", (short)this.k);
         var1.a("RequiredPlayerRange", (short)this.l);
         var1.a("SpawnRange", (short)this.m);
         if (this.i() != null) {
            var1.a("SpawnData", add.a.b(this.i()).b());
         }

         if (this.i() != null || this.c.size() > 0) {
            du var3 = new du();
            if (this.c.size() > 0) {
               Iterator var4 = this.c.iterator();

               while(var4.hasNext()) {
                  add.a var5 = (add.a)var4.next();
                  var3.a((eb)var5.a());
               }
            } else {
               var3.a((eb)this.i().a());
            }

            var1.a((String)"SpawnPotentials", (eb)var3);
         }

      }
   }

   private add.a i() {
      return this.d;
   }

   public abstract void a(int var1);

   public abstract adm a();

   public double e() {
      return this.f;
   }

   public class a extends oa.a {
      private final dn c;
      private final String d;
      final add b;

      private a(add var1, dn var2, String var3, int var4) {
         super(var4);
         this.b = var1;
         if (var3.equals("Minecart")) {
            if (var2 != null) {
               var3 = va.a.a(var2.f("Type")).b();
            } else {
               var3 = "MinecartRideable";
            }
         }

         this.c = var2;
         this.d = var3;
      }

      static dn b(add.a var0) {
         return var0.c;
      }

      static String a(add.a var0) {
         return var0.d;
      }

      public dn a() {
         dn var1 = new dn();
         var1.a((String)"Properties", (eb)this.c);
         var1.a("Type", this.d);
         var1.a("Weight", this.a);
         return var1;
      }

      public a(add var1, dn var2, String var3) {
         this(var1, var2, var3, 1);
      }

      public a(add var1, dn var2) {
         this(var1, var2.m("Properties"), var2.j("Type"), var2.f("Weight"));
      }
   }
}
