import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Map.Entry;

public final class zx {
   private afh h;
   private int f;
   private dn e;
   public int b;
   private zw d;
   private afh j;
   private boolean i;
   private uo g;
   private boolean k;
   public static final DecimalFormat a = new DecimalFormat("#.###");
   public int c;

   public boolean f() {
      return this.d.k();
   }

   public zx(afh var1, int var2) {
      this((afh)var1, var2, 0);
   }

   public zw b() {
      return this.d;
   }

   public void c(int var1) {
      if (!this.n()) {
         this.e = new dn();
      }

      this.e.a("RepairCost", var1);
   }

   public boolean c(afh var1) {
      if (var1 == this.h) {
         return this.i;
      } else {
         this.h = var1;
         if (this.n() && this.e.b("CanDestroy", 9)) {
            du var2 = this.e.c("CanDestroy", 8);

            for(int var3 = 0; var3 < var2.c(); ++var3) {
               afh var4 = afh.b(var2.f(var3));
               if (var4 == var1) {
                  this.i = true;
                  return true;
               }
            }
         }

         this.i = false;
         return false;
      }
   }

   public zx a(adm var1, wn var2) {
      return this.b().a(this, var1, var2);
   }

   public zx k() {
      zx var1 = new zx(this.d, this.b, this.f);
      if (this.e != null) {
         var1.e = (dn)this.e.b();
      }

      return var1;
   }

   public static boolean a(zx var0, zx var1) {
      if (var0 == null && var1 == null) {
         return true;
      } else if (var0 != null && var1 != null) {
         if (var0.e == null && var1.e != null) {
            return false;
         } else {
            return var0.e == null || var0.e.equals(var1.e);
         }
      } else {
         return false;
      }
   }

   public boolean c(zx var1) {
      return this.d(var1);
   }

   public boolean b(afh var1) {
      return this.d.b(var1);
   }

   public int c() {
      return this.b().j();
   }

   public uo z() {
      return this.g;
   }

   public int A() {
      return this.n() && this.e.b("RepairCost", 3) ? this.e.f("RepairCost") : 0;
   }

   public String toString() {
      return this.b + "x" + this.d.a() + "@" + this.f;
   }

   public aba m() {
      return this.b().e(this);
   }

   private boolean d(zx var1) {
      if (this.b != var1.b) {
         return false;
      } else if (this.d != var1.d) {
         return false;
      } else if (this.f != var1.f) {
         return false;
      } else if (this.e == null && var1.e != null) {
         return false;
      } else {
         return this.e == null || this.e.equals(var1.e);
      }
   }

   public int j() {
      return this.d.l();
   }

   public zx b(adm var1, wn var2) {
      return this.b().b(this, var1, var2);
   }

   public eu C() {
      fa var1 = new fa(this.q());
      if (this.s()) {
         var1.b().b(true);
      }

      eu var2 = (new fa("[")).a(var1).a("]");
      if (this.d != null) {
         dn var3 = new dn();
         this.b(var3);
         var2.b().a(new ew(ew.a.c, new fa(var3.toString())));
         var2.b().a(this.u().e);
      }

      return var2;
   }

   public zx(zw var1, int var2) {
      this((zw)var1, var2, 0);
   }

   public void a(int var1, pr var2) {
      if (!(var2 instanceof wn) || !((wn)var2).bA.d) {
         if (this.e()) {
            if (this.a(var1, var2.bc())) {
               var2.b(this);
               --this.b;
               if (var2 instanceof wn) {
                  wn var3 = (wn)var2;
                  var3.b(na.ae[zw.b(this.d)]);
                  if (this.b == 0 && this.b() instanceof yt) {
                     var3.ca();
                  }
               }

               if (this.b < 0) {
                  this.b = 0;
               }

               this.f = 0;
            }

         }
      }
   }

   public boolean a(zx var1) {
      return var1 != null && this.d == var1.d && this.f == var1.f;
   }

   public void a(pr var1, wn var2) {
      boolean var3 = this.d.a((zx)this, (pr)var1, (pr)var2);
      if (var3) {
         var2.b(na.ad[zw.b(this.d)]);
      }

   }

   public String a() {
      return this.d.e_(this);
   }

   public aaj u() {
      return this.b().g(this);
   }

   public dn o() {
      return this.e;
   }

   public boolean a(wn var1, pr var2) {
      return this.d.a(this, var1, var2);
   }

   public boolean s() {
      if (this.e == null) {
         return false;
      } else {
         return !this.e.b("display", 10) ? false : this.e.m("display").b("Name", 8);
      }
   }

   public zx a(int var1) {
      zx var2 = new zx(this.d, var1, this.f);
      if (this.e != null) {
         var2.e = (dn)this.e.b();
      }

      this.b -= var1;
      return var2;
   }

   public boolean t() {
      return this.b().f(this);
   }

   public static boolean b(zx var0, zx var1) {
      if (var0 == null && var1 == null) {
         return true;
      } else {
         return var0 != null && var1 != null ? var0.d(var1) : false;
      }
   }

   public void r() {
      if (this.e != null) {
         if (this.e.b("display", 10)) {
            dn var1 = this.e.m("display");
            var1.o("Name");
            if (var1.c_()) {
               this.e.o("display");
               if (this.e.c_()) {
                  this.d((dn)null);
               }
            }

         }
      }
   }

   public int i() {
      return this.f;
   }

   public static zx b(zx var0) {
      return var0 == null ? null : var0.k();
   }

   public du p() {
      return this.e == null ? null : this.e.c("ench", 10);
   }

   public float a(afh var1) {
      return this.b().a(this, var1);
   }

   public String q() {
      String var1 = this.b().a(this);
      if (this.e != null && this.e.b("display", 10)) {
         dn var2 = this.e.m("display");
         if (var2.b("Name", 8)) {
            var1 = var2.j("Name");
         }
      }

      return var1;
   }

   public boolean e() {
      if (this.d == null) {
         return false;
      } else if (this.d.l() <= 0) {
         return false;
      } else {
         return !this.n() || !this.o().n("Unbreakable");
      }
   }

   public boolean d() {
      return this.c() > 1 && (!this.e() || !this.g());
   }

   public List<String> a(wn var1, boolean var2) {
      ArrayList var3 = Lists.newArrayList();
      String var4 = this.q();
      if (this.s()) {
         var4 = a.u + var4;
      }

      var4 = var4 + a.v;
      if (var2) {
         String var5 = "";
         if (var4.length() > 0) {
            var4 = var4 + " (";
            var5 = ")";
         }

         int var6 = zw.b(this.d);
         if (this.f()) {
            var4 = var4 + String.format("#%04d/%d%s", var6, this.f, var5);
         } else {
            var4 = var4 + String.format("#%04d%s", var6, var5);
         }
      } else if (!this.s() && this.d == zy.bd) {
         var4 = var4 + " #" + this.f;
      }

      var3.add(var4);
      int var14 = 0;
      if (this.n() && this.e.b("HideFlags", 99)) {
         var14 = this.e.f("HideFlags");
      }

      if ((var14 & 32) == 0) {
         this.d.a(this, var1, var3, var2);
      }

      du var18;
      int var20;
      if (this.n()) {
         if ((var14 & 1) == 0) {
            du var15 = this.p();
            if (var15 != null) {
               for(int var7 = 0; var7 < var15.c(); ++var7) {
                  short var8 = var15.b(var7).e("id");
                  short var9 = var15.b(var7).e("lvl");
                  if (aci.c(var8) != null) {
                     var3.add(aci.c(var8).d(var9));
                  }
               }
            }
         }

         if (this.e.b("display", 10)) {
            dn var16 = this.e.m("display");
            if (var16.b("color", 3)) {
               if (var2) {
                  var3.add("Color: #" + Integer.toHexString(var16.f("color")).toUpperCase());
               } else {
                  var3.add(a.u + di.a("item.dyed"));
               }
            }

            if (var16.b("Lore") == 9) {
               var18 = var16.c("Lore", 8);
               if (var18.c() > 0) {
                  for(var20 = 0; var20 < var18.c(); ++var20) {
                     var3.add(a.f + "" + a.u + var18.f(var20));
                  }
               }
            }
         }
      }

      Multimap var17 = this.B();
      if (!var17.isEmpty() && (var14 & 2) == 0) {
         var3.add("");
         Iterator var19 = var17.entries().iterator();

         while(var19.hasNext()) {
            Entry var21 = (Entry)var19.next();
            qd var22 = (qd)var21.getValue();
            double var10 = var22.d();
            if (var22.a() == zw.f) {
               var10 += (double)ack.a(this, pw.a);
            }

            double var12;
            if (var22.c() != 1 && var22.c() != 2) {
               var12 = var10;
            } else {
               var12 = var10 * 100.0D;
            }

            if (var10 > 0.0D) {
               var3.add(a.j + di.a("attribute.modifier.plus." + var22.c(), a.format(var12), di.a("attribute.name." + (String)var21.getKey())));
            } else if (var10 < 0.0D) {
               var12 *= -1.0D;
               var3.add(a.m + di.a("attribute.modifier.take." + var22.c(), a.format(var12), di.a("attribute.name." + (String)var21.getKey())));
            }
         }
      }

      if (this.n() && this.o().n("Unbreakable") && (var14 & 4) == 0) {
         var3.add(a.j + di.a("item.unbreakable"));
      }

      afh var23;
      if (this.n() && this.e.b("CanDestroy", 9) && (var14 & 8) == 0) {
         var18 = this.e.c("CanDestroy", 8);
         if (var18.c() > 0) {
            var3.add("");
            var3.add(a.h + di.a("item.canBreak"));

            for(var20 = 0; var20 < var18.c(); ++var20) {
               var23 = afh.b(var18.f(var20));
               if (var23 != null) {
                  var3.add(a.i + var23.f());
               } else {
                  var3.add(a.i + "missingno");
               }
            }
         }
      }

      if (this.n() && this.e.b("CanPlaceOn", 9) && (var14 & 16) == 0) {
         var18 = this.e.c("CanPlaceOn", 8);
         if (var18.c() > 0) {
            var3.add("");
            var3.add(a.h + di.a("item.canPlace"));

            for(var20 = 0; var20 < var18.c(); ++var20) {
               var23 = afh.b(var18.f(var20));
               if (var23 != null) {
                  var3.add(a.i + var23.f());
               } else {
                  var3.add(a.i + "missingno");
               }
            }
         }
      }

      if (var2) {
         if (this.g()) {
            var3.add("Durability: " + (this.j() - this.h()) + " / " + this.j());
         }

         var3.add(a.i + ((jy)zw.e.c(this.d)).toString());
         if (this.n()) {
            var3.add(a.i + "NBT: " + this.o().c().size() + " tag(s)");
         }
      }

      return var3;
   }

   public boolean a(int var1, Random var2) {
      if (!this.e()) {
         return false;
      } else {
         if (var1 > 0) {
            int var3 = ack.a(aci.t.B, this);
            int var4 = 0;

            for(int var5 = 0; var3 > 0 && var5 < var1; ++var5) {
               if (acg.a(this, var3, var2)) {
                  ++var4;
               }
            }

            var1 -= var4;
            if (var1 <= 0) {
               return false;
            }
         }

         this.f += var1;
         return this.f > this.j();
      }
   }

   public static boolean c(zx var0, zx var1) {
      if (var0 == null && var1 == null) {
         return true;
      } else {
         return var0 != null && var1 != null ? var0.a(var1) : false;
      }
   }

   public void a(adm var1, pk var2, int var3, boolean var4) {
      if (this.c > 0) {
         --this.c;
      }

      this.d.a(this, var1, var2, var3, var4);
   }

   public void b(int var1) {
      this.f = var1;
      if (this.f < 0) {
         this.f = 0;
      }

   }

   public void c(dn var1) {
      if (var1.b("id", 8)) {
         this.d = zw.d(var1.j("id"));
      } else {
         this.d = zw.b(var1.e("id"));
      }

      this.b = var1.d("Count");
      this.f = var1.e("Damage");
      if (this.f < 0) {
         this.f = 0;
      }

      if (var1.b("tag", 10)) {
         this.e = var1.m("tag");
         if (this.d != null) {
            this.d.a(this.e);
         }
      }

   }

   public boolean g() {
      return this.e() && this.f > 0;
   }

   public boolean v() {
      if (!this.b().f_(this)) {
         return false;
      } else {
         return !this.w();
      }
   }

   public void a(uo var1) {
      this.g = var1;
   }

   public int h() {
      return this.f;
   }

   public static zx a(dn var0) {
      zx var1 = new zx();
      var1.c(var0);
      return var1.b() != null ? var1 : null;
   }

   public void a(aci var1, int var2) {
      if (this.e == null) {
         this.d(new dn());
      }

      if (!this.e.b("ench", 9)) {
         this.e.a((String)"ench", (eb)(new du()));
      }

      du var3 = this.e.c("ench", 10);
      dn var4 = new dn();
      var4.a("id", (short)var1.B);
      var4.a("lvl", (short)((byte)var2));
      var3.a((eb)var4);
   }

   public boolean d(afh var1) {
      if (var1 == this.j) {
         return this.k;
      } else {
         this.j = var1;
         if (this.n() && this.e.b("CanPlaceOn", 9)) {
            du var2 = this.e.c("CanPlaceOn", 8);

            for(int var3 = 0; var3 < var2.c(); ++var3) {
               afh var4 = afh.b(var2.f(var3));
               if (var4 == var1) {
                  this.k = true;
                  return true;
               }
            }
         }

         this.k = false;
         return false;
      }
   }

   public boolean n() {
      return this.e != null;
   }

   public void b(adm var1, wn var2, int var3) {
      this.b().a(this, var1, var2, var3);
   }

   public boolean x() {
      return this.b().s();
   }

   public Multimap<String, qd> B() {
      Object var1;
      if (this.n() && this.e.b("AttributeModifiers", 9)) {
         var1 = HashMultimap.create();
         du var2 = this.e.c("AttributeModifiers", 10);

         for(int var3 = 0; var3 < var2.c(); ++var3) {
            dn var4 = var2.b(var3);
            qd var5 = vy.a(var4);
            if (var5 != null && var5.a().getLeastSignificantBits() != 0L && var5.a().getMostSignificantBits() != 0L) {
               ((Multimap)var1).put(var4.j("AttributeName"), var5);
            }
         }
      } else {
         var1 = this.b().i();
      }

      return (Multimap)var1;
   }

   public void a(zw var1) {
      this.d = var1;
   }

   public dn a(String var1, boolean var2) {
      if (this.e != null && this.e.b(var1, 10)) {
         return this.e.m(var1);
      } else if (var2) {
         dn var3 = new dn();
         this.a((String)var1, (eb)var3);
         return var3;
      } else {
         return null;
      }
   }

   public zx(afh var1, int var2, int var3) {
      this(zw.a(var1), var2, var3);
   }

   public zx c(String var1) {
      if (this.e == null) {
         this.e = new dn();
      }

      if (!this.e.b("display", 10)) {
         this.e.a((String)"display", (eb)(new dn()));
      }

      this.e.m("display").a("Name", var1);
      return this;
   }

   public dn b(dn var1) {
      jy var2 = (jy)zw.e.c(this.d);
      var1.a("id", var2 == null ? "minecraft:air" : var2.toString());
      var1.a("Count", (byte)this.b);
      var1.a("Damage", (short)this.f);
      if (this.e != null) {
         var1.a((String)"tag", (eb)this.e);
      }

      return var1;
   }

   public void a(adm var1, afh var2, cj var3, wn var4) {
      boolean var5 = this.d.a(this, var1, var2, var3, var4);
      if (var5) {
         var4.b(na.ad[zw.b(this.d)]);
      }

   }

   public boolean w() {
      return this.e != null && this.e.b("ench", 9);
   }

   public void d(dn var1) {
      this.e = var1;
   }

   public boolean y() {
      return this.g != null;
   }

   public zx(zw var1) {
      this((zw)var1, 1);
   }

   public boolean a(wn var1, adm var2, cj var3, cq var4, float var5, float var6, float var7) {
      boolean var8 = this.b().a(this, var1, var2, var3, var4, var5, var6, var7);
      if (var8) {
         var1.b(na.ad[zw.b(this.d)]);
      }

      return var8;
   }

   public int l() {
      return this.b().d(this);
   }

   public void a(adm var1, wn var2, int var3) {
      var2.a(na.ac[zw.b(this.d)], var3);
      this.d.d(this, var1, var2);
   }

   public zx(afh var1) {
      this((afh)var1, 1);
   }

   public zx(zw var1, int var2, int var3) {
      this.h = null;
      this.i = false;
      this.j = null;
      this.k = false;
      this.d = var1;
      this.b = var2;
      this.f = var3;
      if (this.f < 0) {
         this.f = 0;
      }

   }

   public void a(String var1, eb var2) {
      if (this.e == null) {
         this.d(new dn());
      }

      this.e.a(var1, var2);
   }

   private zx() {
      this.h = null;
      this.i = false;
      this.j = null;
      this.k = false;
   }
}
