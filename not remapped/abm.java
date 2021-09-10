import com.google.common.collect.Lists;
import java.util.ArrayList;

public class abm implements abs {
   private zx a;

   public zx b() {
      return this.a;
   }

   public zx[] b(xp var1) {
      zx[] var2 = new zx[var1.o_()];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         zx var4 = var1.a(var3);
         if (var4 != null && var4.b().r()) {
            var2[var3] = new zx(var4.b().q());
         }
      }

      return var2;
   }

   public zx a(xp var1) {
      return this.a.k();
   }

   public boolean a(xp var1, adm var2) {
      this.a = null;
      int var3 = 0;
      int var4 = 0;
      int var5 = 0;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;

      for(int var9 = 0; var9 < var1.o_(); ++var9) {
         zx var10 = var1.a(var9);
         if (var10 != null) {
            if (var10.b() == zy.H) {
               ++var4;
            } else if (var10.b() == zy.cc) {
               ++var6;
            } else if (var10.b() == zy.aW) {
               ++var5;
            } else if (var10.b() == zy.aK) {
               ++var3;
            } else if (var10.b() == zy.aT) {
               ++var7;
            } else if (var10.b() == zy.i) {
               ++var7;
            } else if (var10.b() == zy.bL) {
               ++var8;
            } else if (var10.b() == zy.G) {
               ++var8;
            } else if (var10.b() == zy.bx) {
               ++var8;
            } else {
               if (var10.b() != zy.bX) {
                  return false;
               }

               ++var8;
            }
         }
      }

      var7 += var5 + var8;
      if (var4 <= 3 && var3 <= 1) {
         dn var16;
         dn var19;
         if (var4 >= 1 && var3 == 1 && var7 == 0) {
            this.a = new zx(zy.cb);
            if (var6 > 0) {
               var16 = new dn();
               var19 = new dn();
               du var25 = new du();

               for(int var22 = 0; var22 < var1.o_(); ++var22) {
                  zx var26 = var1.a(var22);
                  if (var26 != null && var26.b() == zy.cc && var26.n() && var26.o().b("Explosion", 10)) {
                     var25.a((eb)var26.o().m("Explosion"));
                  }
               }

               var19.a((String)"Explosions", (eb)var25);
               var19.a("Flight", (byte)var4);
               var16.a((String)"Fireworks", (eb)var19);
               this.a.d(var16);
            }

            return true;
         } else if (var4 == 1 && var3 == 0 && var6 == 0 && var5 > 0 && var8 <= 1) {
            this.a = new zx(zy.cc);
            var16 = new dn();
            var19 = new dn();
            byte var23 = 0;
            ArrayList var12 = Lists.newArrayList();

            for(int var13 = 0; var13 < var1.o_(); ++var13) {
               zx var14 = var1.a(var13);
               if (var14 != null) {
                  if (var14.b() == zy.aW) {
                     var12.add(ze.a[var14.i() & 15]);
                  } else if (var14.b() == zy.aT) {
                     var19.a("Flicker", true);
                  } else if (var14.b() == zy.i) {
                     var19.a("Trail", true);
                  } else if (var14.b() == zy.bL) {
                     var23 = 1;
                  } else if (var14.b() == zy.G) {
                     var23 = 4;
                  } else if (var14.b() == zy.bx) {
                     var23 = 2;
                  } else if (var14.b() == zy.bX) {
                     var23 = 3;
                  }
               }
            }

            int[] var24 = new int[var12.size()];

            for(int var27 = 0; var27 < var24.length; ++var27) {
               var24[var27] = (Integer)var12.get(var27);
            }

            var19.a("Colors", var24);
            var19.a("Type", var23);
            var16.a((String)"Explosion", (eb)var19);
            this.a.d(var16);
            return true;
         } else if (var4 == 0 && var3 == 0 && var6 == 1 && var5 > 0 && var5 == var7) {
            ArrayList var15 = Lists.newArrayList();

            for(int var17 = 0; var17 < var1.o_(); ++var17) {
               zx var11 = var1.a(var17);
               if (var11 != null) {
                  if (var11.b() == zy.aW) {
                     var15.add(ze.a[var11.i() & 15]);
                  } else if (var11.b() == zy.cc) {
                     this.a = var11.k();
                     this.a.b = 1;
                  }
               }
            }

            int[] var18 = new int[var15.size()];

            for(int var20 = 0; var20 < var18.length; ++var20) {
               var18[var20] = (Integer)var15.get(var20);
            }

            if (this.a != null && this.a.n()) {
               dn var21 = this.a.o().m("Explosion");
               if (var21 == null) {
                  return false;
               } else {
                  var21.a("FadeColors", var18);
                  return true;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public int a() {
      return 10;
   }
}
