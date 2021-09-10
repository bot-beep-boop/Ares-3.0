import java.util.List;

public class au extends i {
   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 8) {
         throw new cf("commands.particle.usage", new Object[0]);
      } else {
         boolean var3 = false;
         cy var4 = null;
         cy[] var5 = cy.values();
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            cy var8 = var5[var7];
            if (var8.f()) {
               if (var2[0].startsWith(var8.b())) {
                  var3 = true;
                  var4 = var8;
                  break;
               }
            } else if (var2[0].equals(var8.b())) {
               var3 = true;
               var4 = var8;
               break;
            }
         }

         if (!var3) {
            throw new bz("commands.particle.notFound", new Object[]{var2[0]});
         } else {
            String var30 = var2[0];
            aui var31 = var1.d();
            double var32 = (double)((float)b(var31.a, var2[1], true));
            double var9 = (double)((float)b(var31.b, var2[2], true));
            double var11 = (double)((float)b(var31.c, var2[3], true));
            double var13 = (double)((float)c(var2[4]));
            double var15 = (double)((float)c(var2[5]));
            double var17 = (double)((float)c(var2[6]));
            double var19 = (double)((float)c(var2[7]));
            int var21 = 0;
            if (var2.length > 8) {
               var21 = a(var2[8], 0);
            }

            boolean var22 = false;
            if (var2.length > 9 && "force".equals(var2[9])) {
               var22 = true;
            }

            adm var23 = var1.e();
            if (var23 instanceof le) {
               le var24 = (le)var23;
               int[] var25 = new int[var4.d()];
               if (var4.f()) {
                  String[] var26 = var2[0].split("_", 3);

                  for(int var27 = 1; var27 < var26.length; ++var27) {
                     try {
                        var25[var27 - 1] = Integer.parseInt(var26[var27]);
                     } catch (NumberFormatException var29) {
                        throw new bz("commands.particle.notFound", new Object[]{var2[0]});
                     }
                  }
               }

               var24.a(var4, var22, var32, var9, var11, var21, var13, var15, var17, var19, var25);
               a(var1, this, "commands.particle.success", new Object[]{var30, Math.max(var21, 1)});
            }

         }
      }
   }

   public int a() {
      return 2;
   }

   public String c() {
      return "particle";
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length == 1) {
         return a(var2, cy.a());
      } else if (var2.length > 1 && var2.length <= 4) {
         return a(var2, 1, var3);
      } else {
         return var2.length == 10 ? a(var2, new String[]{"normal", "force"}) : null;
      }
   }

   public String c(m var1) {
      return "commands.particle.usage";
   }
}
