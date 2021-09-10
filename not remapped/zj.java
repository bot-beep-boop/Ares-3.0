public class zj extends zw {
   public zx a(zx var1, adm var2, wn var3) {
      auh var4 = this.a(var2, var3, false);
      if (var4 != null && var4.a == auh.a.b && var2.p(var4.a()).c() == afi.bG) {
         return var1;
      } else {
         if (!var2.D) {
            cj var5 = var2.a("Stronghold", new cj(var3));
            if (var5 != null) {
               wr var6 = new wr(var2, var3.s, var3.t, var3.u);
               var6.a(var5);
               var2.d((pk)var6);
               var2.a((pk)var3, "random.bow", 0.5F, 0.4F / (g.nextFloat() * 0.4F + 0.8F));
               var2.a((wn)null, 1002, new cj(var3), 0);
               if (!var3.bA.d) {
                  --var1.b;
               }

               var3.b(na.ad[zw.b((zw)this)]);
            }
         }

         return var1;
      }
   }

   public zj() {
      this.a(yz.f);
   }

   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      alz var9 = var3.p(var4);
      if (var2.a(var4.a(var5), var5, var1) && var9.c() == afi.bG && !(Boolean)var9.b(ago.b)) {
         if (var3.D) {
            return true;
         } else {
            var3.a((cj)var4, (alz)var9.a(ago.b, true), 2);
            var3.e(var4, afi.bG);
            --var1.b;

            for(int var10 = 0; var10 < 16; ++var10) {
               double var11 = (double)((float)var4.n() + (5.0F + g.nextFloat() * 6.0F) / 16.0F);
               double var13 = (double)((float)var4.o() + 0.8125F);
               double var15 = (double)((float)var4.p() + (5.0F + g.nextFloat() * 6.0F) / 16.0F);
               double var17 = 0.0D;
               double var19 = 0.0D;
               double var21 = 0.0D;
               var3.a(cy.l, var11, var13, var15, var17, var19, var21);
            }

            cq var23 = (cq)var9.b(ago.a);
            int var24 = 0;
            int var12 = 0;
            boolean var25 = false;
            boolean var14 = true;
            cq var26 = var23.e();

            for(int var16 = -2; var16 <= 2; ++var16) {
               cj var28 = var4.a(var26, var16);
               alz var18 = var3.p(var28);
               if (var18.c() == afi.bG) {
                  if (!(Boolean)var18.b(ago.b)) {
                     var14 = false;
                     break;
                  }

                  var12 = var16;
                  if (!var25) {
                     var24 = var16;
                     var25 = true;
                  }
               }
            }

            if (var14 && var12 == var24 + 2) {
               cj var27 = var4.a(var23, 4);

               int var29;
               for(var29 = var24; var29 <= var12; ++var29) {
                  cj var30 = var27.a(var26, var29);
                  alz var32 = var3.p(var30);
                  if (var32.c() != afi.bG || !(Boolean)var32.b(ago.b)) {
                     var14 = false;
                     break;
                  }
               }

               int var31;
               cj var33;
               for(var29 = var24 - 1; var29 <= var12 + 1; var29 += 4) {
                  var27 = var4.a(var26, var29);

                  for(var31 = 1; var31 <= 3; ++var31) {
                     var33 = var27.a(var23, var31);
                     alz var20 = var3.p(var33);
                     if (var20.c() != afi.bG || !(Boolean)var20.b(ago.b)) {
                        var14 = false;
                        break;
                     }
                  }
               }

               if (var14) {
                  for(var29 = var24; var29 <= var12; ++var29) {
                     var27 = var4.a(var26, var29);

                     for(var31 = 1; var31 <= 3; ++var31) {
                        var33 = var27.a(var23, var31);
                        var3.a((cj)var33, (alz)afi.bF.Q(), 2);
                     }
                  }
               }
            }

            return true;
         }
      } else {
         return false;
      }
   }
}
