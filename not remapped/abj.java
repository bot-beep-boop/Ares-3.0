public class abj {
   void a(abt var1) {
      zd[] var2 = zd.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         zd var5 = var2[var4];
         var1.a(new zx(zy.cE, 1, var5.b()), "###", "###", " | ", '#', new zx(afi.L, 1, var5.a()), '|', zy.y);
      }

      var1.a(new abj.b());
      var1.a(new abj.a());
   }

   static class b implements abs {
      private b() {
      }

      b(Object var1) {
         this();
      }

      public zx b() {
         return null;
      }

      public zx[] b(xp var1) {
         zx[] var2 = new zx[var1.o_()];

         for(int var3 = 0; var3 < var2.length; ++var3) {
            zx var4 = var1.a(var3);
            if (var4 != null) {
               if (var4.b().r()) {
                  var2[var3] = new zx(var4.b().q());
               } else if (var4.n() && aku.c(var4) > 0) {
                  var2[var3] = var4.k();
                  var2[var3].b = 1;
               }
            }
         }

         return var2;
      }

      public boolean a(xp var1, adm var2) {
         zx var3 = null;
         zx var4 = null;

         for(int var5 = 0; var5 < var1.o_(); ++var5) {
            zx var6 = var1.a(var5);
            if (var6 != null) {
               if (var6.b() != zy.cE) {
                  return false;
               }

               if (var3 != null && var4 != null) {
                  return false;
               }

               int var7 = aku.b(var6);
               boolean var8 = aku.c(var6) > 0;
               if (var3 != null) {
                  if (var8) {
                     return false;
                  }

                  if (var7 != aku.b(var3)) {
                     return false;
                  }

                  var4 = var6;
               } else if (var4 != null) {
                  if (!var8) {
                     return false;
                  }

                  if (var7 != aku.b(var4)) {
                     return false;
                  }

                  var3 = var6;
               } else if (var8) {
                  var3 = var6;
               } else {
                  var4 = var6;
               }
            }
         }

         return var3 != null && var4 != null;
      }

      public zx a(xp var1) {
         for(int var2 = 0; var2 < var1.o_(); ++var2) {
            zx var3 = var1.a(var2);
            if (var3 != null && aku.c(var3) > 0) {
               zx var4 = var3.k();
               var4.b = 1;
               return var4;
            }
         }

         return null;
      }

      public int a() {
         return 2;
      }
   }

   static class a implements abs {
      public zx b() {
         return null;
      }

      private aku.a c(xp var1) {
         aku.a[] var2 = aku.a.values();
         int var3 = var2.length;

         for(int var4 = 0; var4 < var3; ++var4) {
            aku.a var5 = var2[var4];
            if (var5.d()) {
               boolean var6 = true;
               int var9;
               if (var5.e()) {
                  boolean var7 = false;
                  boolean var8 = false;

                  for(var9 = 0; var9 < var1.o_() && var6; ++var9) {
                     zx var10 = var1.a(var9);
                     if (var10 != null && var10.b() != zy.cE) {
                        if (var10.b() == zy.aW) {
                           if (var8) {
                              var6 = false;
                              break;
                           }

                           var8 = true;
                        } else {
                           if (var7 || !var10.a(var5.f())) {
                              var6 = false;
                              break;
                           }

                           var7 = true;
                        }
                     }
                  }

                  if (!var7) {
                     var6 = false;
                  }
               } else if (var1.o_() == var5.c().length * var5.c()[0].length()) {
                  int var12 = -1;

                  for(int var13 = 0; var13 < var1.o_() && var6; ++var13) {
                     var9 = var13 / 3;
                     int var14 = var13 % 3;
                     zx var11 = var1.a(var13);
                     if (var11 != null && var11.b() != zy.cE) {
                        if (var11.b() != zy.aW) {
                           var6 = false;
                           break;
                        }

                        if (var12 != -1 && var12 != var11.i()) {
                           var6 = false;
                           break;
                        }

                        if (var5.c()[var9].charAt(var14) == ' ') {
                           var6 = false;
                           break;
                        }

                        var12 = var11.i();
                     } else if (var5.c()[var9].charAt(var14) != ' ') {
                        var6 = false;
                        break;
                     }
                  }
               } else {
                  var6 = false;
               }

               if (var6) {
                  return var5;
               }
            }
         }

         return null;
      }

      private a() {
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
         zx var2 = null;

         for(int var3 = 0; var3 < var1.o_(); ++var3) {
            zx var4 = var1.a(var3);
            if (var4 != null && var4.b() == zy.cE) {
               var2 = var4.k();
               var2.b = 1;
               break;
            }
         }

         aku.a var8 = this.c(var1);
         if (var8 != null) {
            int var9 = 0;

            zx var6;
            for(int var5 = 0; var5 < var1.o_(); ++var5) {
               var6 = var1.a(var5);
               if (var6 != null && var6.b() == zy.aW) {
                  var9 = var6.i();
                  break;
               }
            }

            dn var10 = var2.a("BlockEntityTag", true);
            var6 = null;
            du var11;
            if (var10.b("Patterns", 9)) {
               var11 = var10.c("Patterns", 10);
            } else {
               var11 = new du();
               var10.a((String)"Patterns", (eb)var11);
            }

            dn var7 = new dn();
            var7.a("Pattern", var8.b());
            var7.a("Color", var9);
            var11.a((eb)var7);
         }

         return var2;
      }

      public boolean a(xp var1, adm var2) {
         boolean var3 = false;

         for(int var4 = 0; var4 < var1.o_(); ++var4) {
            zx var5 = var1.a(var4);
            if (var5 != null && var5.b() == zy.cE) {
               if (var3) {
                  return false;
               }

               if (aku.c(var5) >= 6) {
                  return false;
               }

               var3 = true;
            }
         }

         if (!var3) {
            return false;
         } else {
            return this.c(var1) != null;
         }
      }

      a(Object var1) {
         this();
      }

      public int a() {
         return 10;
      }
   }
}
