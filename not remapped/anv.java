import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class anv implements amv {
   private adm a;
   private final boolean f;
   private final alz[] c = new alz[256];
   private Random b;
   private final apz d;
   private apc i;
   private final boolean g;
   private final List<aqq> e = Lists.newArrayList();
   private apc h;

   public cj a(adm var1, String var2, cj var3) {
      if ("Stronghold".equals(var2)) {
         Iterator var4 = this.e.iterator();

         while(var4.hasNext()) {
            aqq var5 = (aqq)var4.next();
            if (var5 instanceof aqo) {
               return var5.b(var1, var3);
            }
         }
      }

      return null;
   }

   public int g() {
      return 0;
   }

   public boolean a(amv var1, amy var2, int var3, int var4) {
      return false;
   }

   public String f() {
      return "FlatLevelSource";
   }

   public anv(adm var1, long var2, boolean var4, String var5) {
      this.a = var1;
      this.b = new Random(var2);
      this.d = apz.a(var5);
      if (var4) {
         Map var6 = this.d.b();
         if (var6.containsKey("village")) {
            Map var7 = (Map)var6.get("village");
            if (!var7.containsKey("size")) {
               var7.put("size", "1");
            }

            this.e.add(new aqv(var7));
         }

         if (var6.containsKey("biome_1")) {
            this.e.add(new aqm((Map)var6.get("biome_1")));
         }

         if (var6.containsKey("mineshaft")) {
            this.e.add(new aqf((Map)var6.get("mineshaft")));
         }

         if (var6.containsKey("stronghold")) {
            this.e.add(new aqo((Map)var6.get("stronghold")));
         }

         if (var6.containsKey("oceanmonument")) {
            this.e.add(new aqk((Map)var6.get("oceanmonument")));
         }
      }

      if (this.d.b().containsKey("lake")) {
         this.h = new apc(afi.j);
      }

      if (this.d.b().containsKey("lava_lake")) {
         this.i = new apc(afi.l);
      }

      this.g = this.d.b().containsKey("dungeon");
      int var13 = 0;
      int var14 = 0;
      boolean var8 = true;
      Iterator var9 = this.d.c().iterator();

      while(var9.hasNext()) {
         aqa var10 = (aqa)var9.next();

         for(int var11 = var10.d(); var11 < var10.d() + var10.b(); ++var11) {
            alz var12 = var10.c();
            if (var12.c() != afi.a) {
               var8 = false;
               this.c[var11] = var12;
            }
         }

         if (var10.c().c() == afi.a) {
            var14 += var10.b();
         } else {
            var13 += var10.b() + var14;
            var14 = 0;
         }
      }

      var1.b(var13);
      this.f = var8 ? false : this.d.b().containsKey("decoration");
   }

   public boolean d() {
      return false;
   }

   public boolean a(boolean var1, nu var2) {
      return true;
   }

   public void a(amv var1, int var2, int var3) {
      int var4 = var2 * 16;
      int var5 = var3 * 16;
      cj var6 = new cj(var4, 0, var5);
      ady var7 = this.a.b(new cj(var4 + 16, 0, var5 + 16));
      boolean var8 = false;
      this.b.setSeed(this.a.J());
      long var9 = this.b.nextLong() / 2L * 2L + 1L;
      long var11 = this.b.nextLong() / 2L * 2L + 1L;
      this.b.setSeed((long)var2 * var9 + (long)var3 * var11 ^ this.a.J());
      adg var13 = new adg(var2, var3);
      Iterator var14 = this.e.iterator();

      while(var14.hasNext()) {
         aqq var15 = (aqq)var14.next();
         boolean var16 = var15.a(this.a, this.b, var13);
         if (var15 instanceof aqv) {
            var8 |= var16;
         }
      }

      if (this.h != null && !var8 && this.b.nextInt(4) == 0) {
         this.h.b(this.a, this.b, var6.a(this.b.nextInt(16) + 8, this.b.nextInt(256), this.b.nextInt(16) + 8));
      }

      if (this.i != null && !var8 && this.b.nextInt(8) == 0) {
         cj var17 = var6.a(this.b.nextInt(16) + 8, this.b.nextInt(this.b.nextInt(248) + 8), this.b.nextInt(16) + 8);
         if (var17.o() < this.a.F() || this.b.nextInt(10) == 0) {
            this.i.b(this.a, this.b, var17);
         }
      }

      if (this.g) {
         for(int var18 = 0; var18 < 8; ++var18) {
            (new api()).b(this.a, this.b, var6.a(this.b.nextInt(16) + 8, this.b.nextInt(256), this.b.nextInt(16) + 8));
         }
      }

      if (this.f) {
         var7.a(this.a, this.b, var6);
      }

   }

   public void a(amy var1, int var2, int var3) {
      Iterator var4 = this.e.iterator();

      while(var4.hasNext()) {
         aqq var5 = (aqq)var4.next();
         var5.a(this, this.a, var2, var3, (ans)null);
      }

   }

   public amy d(int var1, int var2) {
      ans var3 = new ans();

      int var7;
      for(int var4 = 0; var4 < this.c.length; ++var4) {
         alz var5 = this.c[var4];
         if (var5 != null) {
            for(int var6 = 0; var6 < 16; ++var6) {
               for(var7 = 0; var7 < 16; ++var7) {
                  var3.a(var6, var4, var7, var5);
               }
            }
         }
      }

      Iterator var8 = this.e.iterator();

      while(var8.hasNext()) {
         any var10 = (any)var8.next();
         var10.a(this, this.a, var1, var2, var3);
      }

      amy var9 = new amy(this.a, var3, var1, var2);
      ady[] var11 = this.a.v().b((ady[])null, var1 * 16, var2 * 16, 16, 16);
      byte[] var12 = var9.k();

      for(var7 = 0; var7 < var12.length; ++var7) {
         var12[var7] = (byte)var11[var7].az;
      }

      var9.b();
      return var9;
   }

   public boolean e() {
      return true;
   }

   public List<ady.c> a(pt var1, cj var2) {
      ady var3 = this.a.b(var2);
      return var3.a(var1);
   }

   public boolean a(int var1, int var2) {
      return true;
   }

   public amy a(cj var1) {
      return this.d(var1.n() >> 4, var1.p() >> 4);
   }

   public void c() {
   }
}
