import java.util.Iterator;
import org.lwjgl.opengl.GL11;

public class bfy extends bfh {
   public void a(adf var1) {
      if (this.b) {
         Iterator var2 = this.a.iterator();

         while(var2.hasNext()) {
            bht var3 = (bht)var2.next();
            bmt var4 = var3.b(var1.ordinal());
            bfl.E();
            this.a(var3);
            var3.f();
            var4.a();
            this.a();
            var4.a(7);
            bfl.F();
         }

         bqs.g(bqs.R, 0);
         bfl.G();
         this.a.clear();
      }
   }

   private void a() {
      GL11.glVertexPointer(3, 5126, 28, 0L);
      GL11.glColorPointer(4, 5121, 28, 12L);
      GL11.glTexCoordPointer(2, 5126, 28, 16L);
      bqs.l(bqs.r);
      GL11.glTexCoordPointer(2, 5122, 28, 24L);
      bqs.l(bqs.q);
   }
}
