import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class bal implements bah, bag {
   private final List<bah> a = Lists.newArrayList();

   public void a(float var1, int var2) {
      ave.A().P().a(awm.a);
      avp.a(0, 0, 16.0F, 0.0F, 16, 16, 256.0F, 256.0F);
   }

   public bal() {
      ave var1 = ave.A();
      Iterator var2 = var1.f.Z().g().iterator();

      while(var2.hasNext()) {
         aul var3 = (aul)var2.next();
         this.a.add(new bal.a(this, var3));
      }

   }

   public eu A_() {
      return new fa("Teleport to team member");
   }

   public eu b() {
      return new fa("Select a team to teleport to");
   }

   public boolean B_() {
      Iterator var1 = this.a.iterator();

      bah var2;
      do {
         if (!var1.hasNext()) {
            return false;
         }

         var2 = (bah)var1.next();
      } while(!var2.B_());

      return true;
   }

   public void a(baf var1) {
      var1.a(this);
   }

   public List<bah> a() {
      return this.a;
   }

   class a implements bah {
      private final List<bdc> d;
      final bal a;
      private final jy c;
      private final aul b;

      public a(bal var1, aul var2) {
         this.a = var1;
         this.b = var2;
         this.d = Lists.newArrayList();
         Iterator var3 = var2.d().iterator();

         while(var3.hasNext()) {
            String var4 = (String)var3.next();
            bdc var5 = ave.A().u().a(var4);
            if (var5 != null) {
               this.d.add(var5);
            }
         }

         if (!this.d.isEmpty()) {
            String var6 = ((bdc)this.d.get((new Random()).nextInt(this.d.size()))).a().getName();
            this.c = bet.c(var6);
            bet.a(this.c, var6);
         } else {
            this.c = bmz.a();
         }

      }

      public void a(baf var1) {
         var1.a(new bak(this.d));
      }

      public eu A_() {
         return new fa(this.b.c());
      }

      public void a(float var1, int var2) {
         int var3 = -1;
         String var4 = avn.b(this.b.e());
         if (var4.length() >= 2) {
            var3 = ave.A().k.b(var4.charAt(1));
         }

         if (var3 >= 0) {
            float var5 = (float)(var3 >> 16 & 255) / 255.0F;
            float var6 = (float)(var3 >> 8 & 255) / 255.0F;
            float var7 = (float)(var3 & 255) / 255.0F;
            avp.a(1, 1, 15, 15, ns.b(var5 * var1, var6 * var1, var7 * var1) | var2 << 24);
         }

         ave.A().P().a(this.c);
         bfl.c(var1, var1, var1, (float)var2 / 255.0F);
         avp.a(2, 2, 8.0F, 8.0F, 8, 8, 12, 12, 64.0F, 64.0F);
         avp.a(2, 2, 40.0F, 8.0F, 8, 8, 12, 12, 64.0F, 64.0F);
      }

      public boolean B_() {
         return !this.d.isEmpty();
      }
   }
}
