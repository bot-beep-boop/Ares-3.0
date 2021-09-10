import java.util.Iterator;
import java.util.List;

public abstract class yz {
   public static final yz m;
   private boolean r = true;
   public static final yz j;
   public static final yz g;
   public static final yz e = new yz(3, "transportation") {
      public zw e() {
         return zw.a(afi.D);
      }
   };
   private final String o;
   public static final yz b = new yz(0, "buildingBlocks") {
      public zw e() {
         return zw.a(afi.V);
      }
   };
   private String p = "items.png";
   private zx t;
   public static final yz[] a = new yz[12];
   public static final yz c = new yz(1, "decorations") {
      public int f() {
         return agi.b.f.a();
      }

      public zw e() {
         return zw.a((afh)afi.cF);
      }
   };
   private acj[] s;
   public static final yz i;
   public static final yz k;
   public static final yz l;
   private final int n;
   public static final yz d = new yz(2, "redstone") {
      public zw e() {
         return zy.aC;
      }
   };
   public static final yz h;
   public static final yz f;
   private boolean q = true;

   static {
      f = (new yz(4, "misc") {
         public zw e() {
            return zy.ay;
         }
      }).a(new acj[]{acj.a});
      g = (new yz(5, "search") {
         public zw e() {
            return zy.aQ;
         }
      }).a("item_search.png");
      h = new yz(6, "food") {
         public zw e() {
            return zy.e;
         }
      };
      i = (new yz(7, "tools") {
         public zw e() {
            return zy.c;
         }
      }).a(new acj[]{acj.h, acj.i, acj.j});
      j = (new yz(8, "combat") {
         public zw e() {
            return zy.B;
         }
      }).a(new acj[]{acj.b, acj.c, acj.f, acj.d, acj.e, acj.k, acj.g});
      k = new yz(9, "brewing") {
         public zw e() {
            return zy.bz;
         }
      };
      l = new yz(10, "materials") {
         public zw e() {
            return zy.y;
         }
      };
      m = (new yz(11, "inventory") {
         public zw e() {
            return zw.a((afh)afi.ae);
         }
      }).a("inventory.png").k().i();
   }

   public String c() {
      return "itemGroup." + this.b();
   }

   public int l() {
      return this.n % 6;
   }

   public yz k() {
      this.q = false;
      return this;
   }

   public yz i() {
      this.r = false;
      return this;
   }

   public yz(int var1, String var2) {
      this.n = var1;
      this.o = var2;
      a[var1] = this;
   }

   public acj[] n() {
      return this.s;
   }

   public String g() {
      return this.p;
   }

   public yz a(String var1) {
      this.p = var1;
      return this;
   }

   public void a(List<zx> var1, acj... var2) {
      aci[] var3 = aci.b;
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         aci var6 = var3[var5];
         if (var6 != null && var6.C != null) {
            boolean var7 = false;

            for(int var8 = 0; var8 < var2.length && !var7; ++var8) {
               if (var6.C == var2[var8]) {
                  var7 = true;
               }
            }

            if (var7) {
               var1.add(zy.cd.a(new acl(var6, var6.b())));
            }
         }
      }

   }

   public int a() {
      return this.n;
   }

   public int f() {
      return 0;
   }

   public void a(List<zx> var1) {
      Iterator var2 = zw.e.iterator();

      while(var2.hasNext()) {
         zw var3 = (zw)var2.next();
         if (var3 != null && var3.c() == this) {
            var3.a(var3, this, var1);
         }
      }

      if (this.n() != null) {
         this.a(var1, this.n());
      }

   }

   public yz a(acj... var1) {
      this.s = var1;
      return this;
   }

   public String b() {
      return this.o;
   }

   public boolean h() {
      return this.r;
   }

   public zx d() {
      if (this.t == null) {
         this.t = new zx(this.e(), 1, this.f());
      }

      return this.t;
   }

   public abstract zw e();

   public boolean j() {
      return this.q;
   }

   public boolean m() {
      return this.n < 6;
   }

   public boolean a(acj var1) {
      if (this.s == null) {
         return false;
      } else {
         acj[] var2 = this.s;
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            acj var5 = var2[var4];
            if (var5 == var1) {
               return true;
            }
         }

         return false;
      }
   }
}
