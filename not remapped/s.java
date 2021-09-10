import java.util.List;

public class s extends i {
   public String c() {
      return "blockdata";
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 4) {
         throw new cf("commands.blockdata.usage", new Object[0]);
      } else {
         var1.a(n.a.b, 0);
         cj var3 = a(var1, var2, 0, false);
         adm var4 = var1.e();
         if (!var4.e(var3)) {
            throw new bz("commands.blockdata.outOfWorld", new Object[0]);
         } else {
            akw var5 = var4.s(var3);
            if (var5 == null) {
               throw new bz("commands.blockdata.notValid", new Object[0]);
            } else {
               dn var6 = new dn();
               var5.b(var6);
               dn var7 = (dn)var6.b();

               dn var8;
               try {
                  var8 = ed.a(a(var1, var2, 3).c());
               } catch (ec var10) {
                  throw new bz("commands.blockdata.tagError", new Object[]{var10.getMessage()});
               }

               var6.a(var8);
               var6.a("x", var3.n());
               var6.a("y", var3.o());
               var6.a("z", var3.p());
               if (var6.equals(var7)) {
                  throw new bz("commands.blockdata.failed", new Object[]{var6.toString()});
               } else {
                  var5.a(var6);
                  var5.p_();
                  var4.h(var3);
                  var1.a(n.a.b, 1);
                  a(var1, this, "commands.blockdata.success", new Object[]{var6.toString()});
               }
            }
         }
      }
   }

   public int a() {
      return 2;
   }

   public String c(m var1) {
      return "commands.blockdata.usage";
   }

   public List<String> a(m var1, String[] var2, cj var3) {
      return var2.length > 0 && var2.length <= 3 ? a(var2, 0, var3) : null;
   }
}
