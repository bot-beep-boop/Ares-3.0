import java.util.Iterator;
import org.lwjgl.opengl.GL11;

public class bft extends bfh {
   public void a(adf var1) {
      if (this.b) {
         Iterator var2 = this.a.iterator();

         while(var2.hasNext()) {
            bht var3 = (bht)var2.next();
            bhs var4 = (bhs)var3;
            bfl.E();
            this.a(var3);
            GL11.glCallList(var4.a(var1, var4.g()));
            bfl.F();
         }

         bfl.G();
         this.a.clear();
      }
   }
}
