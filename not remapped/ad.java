import java.util.List;
import net.minecraft.server.MinecraftServer;

public class ad extends i {
   public List<String> a(m var1, String[] var2, cj var3) {
      if (var2.length == 1) {
         return a(var2, MinecraftServer.N().K());
      } else if (var2.length > 1 && var2.length <= 4) {
         return a(var2, 1, var3);
      } else if (var2.length > 5 && var2.length <= 8 && "detect".equals(var2[4])) {
         return a(var2, 5, var3);
      } else {
         return var2.length == 9 && "detect".equals(var2[4]) ? a(var2, afh.c.c()) : null;
      }
   }

   public void a(m var1, String[] var2) throws bz {
      if (var2.length < 5) {
         throw new cf("commands.execute.usage", new Object[0]);
      } else {
         pk var3 = a(var1, var2[0], pk.class);
         double var4 = b(var3.s, var2[1], false);
         double var6 = b(var3.t, var2[2], false);
         double var8 = b(var3.u, var2[3], false);
         cj var10 = new cj(var4, var6, var8);
         byte var11 = 4;
         if ("detect".equals(var2[4]) && var2.length > 10) {
            adm var12 = var3.e();
            double var13 = b(var4, var2[5], false);
            double var15 = b(var6, var2[6], false);
            double var17 = b(var8, var2[7], false);
            afh var19 = g(var1, var2[8]);
            int var20 = a(var2[9], -1, 15);
            cj var21 = new cj(var13, var15, var17);
            alz var22 = var12.p(var21);
            if (var22.c() != var19 || var20 >= 0 && var22.c().c(var22) != var20) {
               throw new bz("commands.execute.failed", new Object[]{"detect", var3.e_()});
            }

            var11 = 10;
         }

         String var24 = a(var2, var11);
         m var14 = new m(this, var3, var1, var10, var4, var6, var8) {
            final ad g;
            final double d;
            final double e;
            final cj c;
            final double f;
            final m b;
            final pk a;

            public eu f_() {
               return this.a.f_();
            }

            public void a(eu var1) {
               this.b.a(var1);
            }

            public pk f() {
               return this.a;
            }

            public String e_() {
               return this.a.e_();
            }

            public void a(n.a var1, int var2) {
               this.a.a(var1, var2);
            }

            public aui d() {
               return new aui(this.d, this.e, this.f);
            }

            public boolean a(int var1, String var2) {
               return this.b.a(var1, var2);
            }

            public boolean u_() {
               MinecraftServer var1 = MinecraftServer.N();
               return var1 == null || var1.d[0].Q().b("commandBlockOutput");
            }

            public adm e() {
               return this.a.o;
            }

            public cj c() {
               return this.c;
            }

            {
               this.g = var1;
               this.a = var2;
               this.b = var3;
               this.c = var4;
               this.d = var5;
               this.e = var7;
               this.f = var9;
            }
         };
         l var25 = MinecraftServer.N().P();

         try {
            int var16 = var25.a(var14, var24);
            if (var16 < 1) {
               throw new bz("commands.execute.allInvocationsFailed", new Object[]{var24});
            }
         } catch (Throwable var23) {
            throw new bz("commands.execute.failed", new Object[]{var24, var3.e_()});
         }
      }
   }

   public int a() {
      return 2;
   }

   public boolean b(String[] var1, int var2) {
      return var2 == 0;
   }

   public String c(m var1) {
      return "commands.execute.usage";
   }

   public String c() {
      return "execute";
   }
}
