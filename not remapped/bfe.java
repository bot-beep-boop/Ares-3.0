import java.nio.ByteBuffer;
import java.util.List;
import org.lwjgl.opengl.GL11;

public class bfe {
   public void a(bfd var1) {
      if (var1.h() > 0) {
         bmu var2 = var1.g();
         int var3 = var2.g();
         ByteBuffer var4 = var1.f();
         List var5 = var2.h();

         int var6;
         int var10;
         for(var6 = 0; var6 < var5.size(); ++var6) {
            bmv var7 = (bmv)var5.get(var6);
            bmv.b var8 = var7.b();
            int var9 = var7.a().c();
            var10 = var7.d();
            var4.position(var2.d(var6));
            switch(var8) {
            case a:
               GL11.glVertexPointer(var7.c(), var9, var3, var4);
               GL11.glEnableClientState(32884);
               break;
            case d:
               bqs.l(bqs.q + var10);
               GL11.glTexCoordPointer(var7.c(), var9, var3, var4);
               GL11.glEnableClientState(32888);
               bqs.l(bqs.q);
               break;
            case c:
               GL11.glColorPointer(var7.c(), var9, var3, var4);
               GL11.glEnableClientState(32886);
               break;
            case b:
               GL11.glNormalPointer(var9, var3, var4);
               GL11.glEnableClientState(32885);
            }
         }

         GL11.glDrawArrays(var1.i(), 0, var1.h());
         var6 = 0;

         for(int var11 = var5.size(); var6 < var11; ++var6) {
            bmv var12 = (bmv)var5.get(var6);
            bmv.b var13 = var12.b();
            var10 = var12.d();
            switch(var13) {
            case a:
               GL11.glDisableClientState(32884);
               break;
            case d:
               bqs.l(bqs.q + var10);
               GL11.glDisableClientState(32888);
               bqs.l(bqs.q);
               break;
            case c:
               GL11.glDisableClientState(32886);
               bfl.G();
               break;
            case b:
               GL11.glDisableClientState(32885);
            }
         }
      }

      var1.b();
   }
}
