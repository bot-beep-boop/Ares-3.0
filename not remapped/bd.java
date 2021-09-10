import java.util.Iterator;
import net.minecraft.server.MinecraftServer;

public class bd extends j implements h {
   public bd() {
      this.a(new br());
      this.a(new ah());
      this.a(new ag());
      this.a(new y());
      this.a(new am());
      this.a(new bt());
      this.a(new bv());
      this.a(new ae());
      this.a(new bn());
      this.a(new aj());
      this.a(new ax());
      this.a(new bk());
      this.a(new z());
      this.a(new ab());
      this.a(new au());
      this.a(new aa());
      this.a(new bi());
      this.a(new ak());
      this.a(new x());
      this.a(new ap());
      this.a(new bb());
      this.a(new bh());
      this.a(new bf());
      this.a(new ai());
      this.a(new t());
      this.a(new bq());
      this.a(new bj());
      this.a(new av());
      this.a(new bc());
      this.a(new ad());
      this.a(new bu());
      this.a(new p());
      this.a(new bm());
      this.a(new be());
      this.a(new af());
      this.a(new u());
      this.a(new v());
      this.a(new s());
      this.a(new bp());
      this.a(new aq());
      this.a(new bx());
      this.a(new bs());
      this.a(new ac());
      if (MinecraftServer.N().ae()) {
         this.a(new ar());
         this.a(new w());
         this.a(new bl());
         this.a(new ay());
         this.a(new az());
         this.a(new ba());
         this.a(new q());
         this.a(new as());
         this.a(new r());
         this.a(new an());
         this.a(new at());
         this.a(new al());
         this.a(new ao());
         this.a(new bw());
         this.a(new bg());
      } else {
         this.a(new aw());
      }

      i.a((h)this);
   }

   public void a(m var1, k var2, int var3, String var4, Object... var5) {
      boolean var6 = true;
      MinecraftServer var7 = MinecraftServer.N();
      if (!var1.u_()) {
         var6 = false;
      }

      fb var8 = new fb("chat.type.admin", new Object[]{var1.e_(), new fb(var4, var5)});
      var8.b().a(a.h);
      var8.b().b(true);
      if (var6) {
         Iterator var9 = var7.ap().v().iterator();

         label103:
         while(true) {
            wn var10;
            boolean var11;
            boolean var12;
            do {
               do {
                  do {
                     do {
                        if (!var9.hasNext()) {
                           break label103;
                        }

                        var10 = (wn)var9.next();
                     } while(var10 == var1);
                  } while(!var7.ap().h(var10.cd()));
               } while(!var2.a(var1));

               var11 = var1 instanceof MinecraftServer && MinecraftServer.N().r();
               var12 = var1 instanceof mj && MinecraftServer.N().q();
            } while(!var11 && !var12 && (var1 instanceof mj || var1 instanceof MinecraftServer));

            var10.a((eu)var8);
         }
      }

      if (var1 != var7 && var7.d[0].Q().b("logAdminCommands")) {
         var7.a(var8);
      }

      boolean var13 = var7.d[0].Q().b("sendCommandFeedback");
      if (var1 instanceof adc) {
         var13 = ((adc)var1).m();
      }

      if ((var3 & 1) != 1 && var13 || var1 instanceof MinecraftServer) {
         var1.a(new fb(var4, var5));
      }

   }
}
