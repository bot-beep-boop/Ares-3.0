public class ac extends i {
   public String c(m var1) {
      return "commands.entitydata.usage";
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 2) {
         throw new cf("commands.entitydata.usage", new Object[0]);
      } else {
         pk var3 = b(var1, var2[0]);
         if (var3 instanceof wn) {
            throw new bz("commands.entitydata.noPlayers", new Object[]{var3.f_()});
         } else {
            dn var4 = new dn();
            var3.e(var4);
            dn var5 = (dn)var4.b();

            dn var6;
            try {
               var6 = ed.a(a(var1, var2, 1).c());
            } catch (ec var8) {
               throw new bz("commands.entitydata.tagError", new Object[]{var8.getMessage()});
            }

            var6.o("UUIDMost");
            var6.o("UUIDLeast");
            var4.a(var6);
            if (var4.equals(var5)) {
               throw new bz("commands.entitydata.failed", new Object[]{var4.toString()});
            } else {
               var3.f(var4);
               a(var1, this, "commands.entitydata.success", new Object[]{var4.toString()});
            }
         }
      }
   }

   public String c() {
      return "entitydata";
   }

   public int a() {
      return 2;
   }
}
