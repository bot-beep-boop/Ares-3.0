import java.util.List;

public class bm extends i {
   public String c(m var1) {
      return "commands.summon.usage";
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 1) {
         throw new cf("commands.summon.usage", new Object[0]);
      } else {
         String var3 = var2[0];
         cj var4 = var1.c();
         aui var5 = var1.d();
         double var6 = var5.a;
         double var8 = var5.b;
         double var10 = var5.c;
         if (var2.length >= 4) {
            var6 = b(var6, var2[1], true);
            var8 = b(var8, var2[2], false);
            var10 = b(var10, var2[3], true);
            var4 = new cj(var6, var8, var10);
         }

         adm var12 = var1.e();
         if (!var12.e(var4)) {
            throw new bz("commands.summon.outOfWorld", new Object[0]);
         } else if ("LightningBolt".equals(var3)) {
            var12.c((pk)(new uv(var12, var6, var8, var10)));
            a(var1, this, "commands.summon.success", new Object[0]);
         } else {
            dn var13 = new dn();
            boolean var14 = false;
            if (var2.length >= 5) {
               eu var15 = a(var1, var2, 4);

               try {
                  var13 = ed.a(var15.c());
                  var14 = true;
               } catch (ec var20) {
                  throw new bz("commands.summon.tagError", new Object[]{var20.getMessage()});
               }
            }

            var13.a("id", var3);

            pk var21;
            try {
               var21 = pm.a(var13, var12);
            } catch (RuntimeException var19) {
               throw new bz("commands.summon.failed", new Object[0]);
            }

            if (var21 == null) {
               throw new bz("commands.summon.failed", new Object[0]);
            } else {
               var21.b(var6, var8, var10, var21.y, var21.z);
               if (!var14 && var21 instanceof ps) {
                  ((ps)var21).a(var12.E(new cj(var21)), (pu)null);
               }

               var12.d(var21);
               pk var16 = var21;

               for(dn var17 = var13; var16 != null && var17.b("Riding", 10); var17 = var17.m("Riding")) {
                  pk var18 = pm.a(var17.m("Riding"), var12);
                  if (var18 != null) {
                     var18.b(var6, var8, var10, var18.y, var18.z);
                     var12.d(var18);
                     var16.a(var18);
                  }

                  var16 = var18;
               }

               a(var1, this, "commands.summon.success", new Object[0]);
            }
         }
      }
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length == 1) {
         return a(var2, pm.b());
      } else {
         return var2.length > 1 && var2.length <= 4 ? a(var2, 1, var3) : null;
      }
   }

   public int a() {
      return 2;
   }

   public String c() {
      return "summon";
   }
}
