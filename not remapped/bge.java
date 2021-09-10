public class bge {
   private bmi[] b = new bmi[2];
   private bmi[] a = new bmi[2];

   protected void a() {
      bmh var1 = ave.A().T();
      this.a[0] = var1.a("minecraft:blocks/lava_still");
      this.a[1] = var1.a("minecraft:blocks/lava_flow");
      this.b[0] = var1.a("minecraft:blocks/water_still");
      this.b[1] = var1.a("minecraft:blocks/water_flow");
   }

   public bge() {
      this.a();
   }

   public boolean a(adq var1, alz var2, cj var3, bfd var4) {
      ahv var5 = (ahv)var2.c();
      var5.a(var1, var3);
      bmi[] var6 = var5.t() == arm.i ? this.a : this.b;
      int var7 = var5.d(var1, var3);
      float var8 = (float)(var7 >> 16 & 255) / 255.0F;
      float var9 = (float)(var7 >> 8 & 255) / 255.0F;
      float var10 = (float)(var7 & 255) / 255.0F;
      boolean var11 = var5.a(var1, var3.a(), cq.b);
      boolean var12 = var5.a(var1, var3.b(), cq.a);
      boolean[] var13 = new boolean[]{var5.a(var1, var3.c(), cq.c), var5.a(var1, var3.d(), cq.d), var5.a(var1, var3.e(), cq.e), var5.a(var1, var3.f(), cq.f)};
      if (!var11 && !var12 && !var13[0] && !var13[1] && !var13[2] && !var13[3]) {
         return false;
      } else {
         boolean var14 = false;
         float var15 = 0.5F;
         float var16 = 1.0F;
         float var17 = 0.8F;
         float var18 = 0.6F;
         arm var19 = var5.t();
         float var20 = this.a(var1, var3, var19);
         float var21 = this.a(var1, var3.d(), var19);
         float var22 = this.a(var1, var3.f().d(), var19);
         float var23 = this.a(var1, var3.f(), var19);
         double var24 = (double)var3.n();
         double var26 = (double)var3.o();
         double var28 = (double)var3.p();
         float var30 = 0.001F;
         bmi var31;
         float var32;
         float var33;
         float var34;
         float var35;
         float var36;
         float var37;
         float var46;
         if (var11) {
            var14 = true;
            var31 = var6[0];
            var32 = (float)ahv.a(var1, var3, var19);
            if (var32 > -999.0F) {
               var31 = var6[1];
            }

            var20 -= var30;
            var21 -= var30;
            var22 -= var30;
            var23 -= var30;
            float var38;
            float var39;
            float var40;
            if (var32 < -999.0F) {
               var33 = var31.a(0.0D);
               var37 = var31.b(0.0D);
               var34 = var33;
               var38 = var31.b(16.0D);
               var35 = var31.a(16.0D);
               var39 = var38;
               var36 = var35;
               var40 = var37;
            } else {
               float var41 = ns.a(var32) * 0.25F;
               float var42 = ns.b(var32) * 0.25F;
               float var43 = 8.0F;
               var33 = var31.a((double)(8.0F + (-var42 - var41) * 16.0F));
               var37 = var31.b((double)(8.0F + (-var42 + var41) * 16.0F));
               var34 = var31.a((double)(8.0F + (-var42 + var41) * 16.0F));
               var38 = var31.b((double)(8.0F + (var42 + var41) * 16.0F));
               var35 = var31.a((double)(8.0F + (var42 + var41) * 16.0F));
               var39 = var31.b((double)(8.0F + (var42 - var41) * 16.0F));
               var36 = var31.a((double)(8.0F + (var42 - var41) * 16.0F));
               var40 = var31.b((double)(8.0F + (-var42 - var41) * 16.0F));
            }

            int var67 = var5.c(var1, var3);
            int var68 = var67 >> 16 & '\uffff';
            int var70 = var67 & '\uffff';
            float var44 = var16 * var8;
            float var45 = var16 * var9;
            var46 = var16 * var10;
            var4.b(var24 + 0.0D, var26 + (double)var20, var28 + 0.0D).a(var44, var45, var46, 1.0F).a((double)var33, (double)var37).a(var68, var70).d();
            var4.b(var24 + 0.0D, var26 + (double)var21, var28 + 1.0D).a(var44, var45, var46, 1.0F).a((double)var34, (double)var38).a(var68, var70).d();
            var4.b(var24 + 1.0D, var26 + (double)var22, var28 + 1.0D).a(var44, var45, var46, 1.0F).a((double)var35, (double)var39).a(var68, var70).d();
            var4.b(var24 + 1.0D, var26 + (double)var23, var28 + 0.0D).a(var44, var45, var46, 1.0F).a((double)var36, (double)var40).a(var68, var70).d();
            if (var5.g(var1, var3.a())) {
               var4.b(var24 + 0.0D, var26 + (double)var20, var28 + 0.0D).a(var44, var45, var46, 1.0F).a((double)var33, (double)var37).a(var68, var70).d();
               var4.b(var24 + 1.0D, var26 + (double)var23, var28 + 0.0D).a(var44, var45, var46, 1.0F).a((double)var36, (double)var40).a(var68, var70).d();
               var4.b(var24 + 1.0D, var26 + (double)var22, var28 + 1.0D).a(var44, var45, var46, 1.0F).a((double)var35, (double)var39).a(var68, var70).d();
               var4.b(var24 + 0.0D, var26 + (double)var21, var28 + 1.0D).a(var44, var45, var46, 1.0F).a((double)var34, (double)var38).a(var68, var70).d();
            }
         }

         if (var12) {
            var32 = var6[0].e();
            var33 = var6[0].f();
            var34 = var6[0].g();
            var35 = var6[0].h();
            int var62 = var5.c(var1, var3.b());
            int var63 = var62 >> 16 & '\uffff';
            int var64 = var62 & '\uffff';
            var4.b(var24, var26, var28 + 1.0D).a(var15, var15, var15, 1.0F).a((double)var32, (double)var35).a(var63, var64).d();
            var4.b(var24, var26, var28).a(var15, var15, var15, 1.0F).a((double)var32, (double)var34).a(var63, var64).d();
            var4.b(var24 + 1.0D, var26, var28).a(var15, var15, var15, 1.0F).a((double)var33, (double)var34).a(var63, var64).d();
            var4.b(var24 + 1.0D, var26, var28 + 1.0D).a(var15, var15, var15, 1.0F).a((double)var33, (double)var35).a(var63, var64).d();
            var14 = true;
         }

         for(int var58 = 0; var58 < 4; ++var58) {
            int var59 = 0;
            int var60 = 0;
            if (var58 == 0) {
               --var60;
            }

            if (var58 == 1) {
               ++var60;
            }

            if (var58 == 2) {
               --var59;
            }

            if (var58 == 3) {
               ++var59;
            }

            cj var61 = var3.a(var59, 0, var60);
            var31 = var6[1];
            if (var13[var58]) {
               double var65;
               double var66;
               double var69;
               double var71;
               if (var58 == 0) {
                  var36 = var20;
                  var37 = var23;
                  var65 = var24;
                  var69 = var24 + 1.0D;
                  var66 = var28 + (double)var30;
                  var71 = var28 + (double)var30;
               } else if (var58 == 1) {
                  var36 = var22;
                  var37 = var21;
                  var65 = var24 + 1.0D;
                  var69 = var24;
                  var66 = var28 + 1.0D - (double)var30;
                  var71 = var28 + 1.0D - (double)var30;
               } else if (var58 == 2) {
                  var36 = var21;
                  var37 = var20;
                  var65 = var24 + (double)var30;
                  var69 = var24 + (double)var30;
                  var66 = var28 + 1.0D;
                  var71 = var28;
               } else {
                  var36 = var23;
                  var37 = var22;
                  var65 = var24 + 1.0D - (double)var30;
                  var69 = var24 + 1.0D - (double)var30;
                  var66 = var28;
                  var71 = var28 + 1.0D;
               }

               var14 = true;
               var46 = var31.a(0.0D);
               float var47 = var31.a(8.0D);
               float var48 = var31.b((double)((1.0F - var36) * 16.0F * 0.5F));
               float var49 = var31.b((double)((1.0F - var37) * 16.0F * 0.5F));
               float var50 = var31.b(8.0D);
               int var51 = var5.c(var1, var61);
               int var52 = var51 >> 16 & '\uffff';
               int var53 = var51 & '\uffff';
               float var54 = var58 < 2 ? var17 : var18;
               float var55 = var16 * var54 * var8;
               float var56 = var16 * var54 * var9;
               float var57 = var16 * var54 * var10;
               var4.b(var65, var26 + (double)var36, var66).a(var55, var56, var57, 1.0F).a((double)var46, (double)var48).a(var52, var53).d();
               var4.b(var69, var26 + (double)var37, var71).a(var55, var56, var57, 1.0F).a((double)var47, (double)var49).a(var52, var53).d();
               var4.b(var69, var26 + 0.0D, var71).a(var55, var56, var57, 1.0F).a((double)var47, (double)var50).a(var52, var53).d();
               var4.b(var65, var26 + 0.0D, var66).a(var55, var56, var57, 1.0F).a((double)var46, (double)var50).a(var52, var53).d();
               var4.b(var65, var26 + 0.0D, var66).a(var55, var56, var57, 1.0F).a((double)var46, (double)var50).a(var52, var53).d();
               var4.b(var69, var26 + 0.0D, var71).a(var55, var56, var57, 1.0F).a((double)var47, (double)var50).a(var52, var53).d();
               var4.b(var69, var26 + (double)var37, var71).a(var55, var56, var57, 1.0F).a((double)var47, (double)var49).a(var52, var53).d();
               var4.b(var65, var26 + (double)var36, var66).a(var55, var56, var57, 1.0F).a((double)var46, (double)var48).a(var52, var53).d();
            }
         }

         return var14;
      }
   }

   private float a(adq var1, cj var2, arm var3) {
      int var4 = 0;
      float var5 = 0.0F;

      for(int var6 = 0; var6 < 4; ++var6) {
         cj var7 = var2.a(-(var6 & 1), 0, -(var6 >> 1 & 1));
         if (var1.p(var7.a()).c().t() == var3) {
            return 1.0F;
         }

         alz var8 = var1.p(var7);
         arm var9 = var8.c().t();
         if (var9 != var3) {
            if (!var9.a()) {
               ++var5;
               ++var4;
            }
         } else {
            int var10 = (Integer)var8.b(ahv.b);
            if (var10 >= 8 || var10 == 0) {
               var5 += ahv.b(var10) * 10.0F;
               var4 += 10;
            }

            var5 += ahv.b(var10);
            ++var4;
         }
      }

      return 1.0F - var5 / (float)var4;
   }
}
