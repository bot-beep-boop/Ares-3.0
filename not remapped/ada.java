import java.io.IOException;
import java.util.ArrayList;

public class ada extends ArrayList<acz> {
   public ada(dn var1) {
      this.a(var1);
   }

   public ada() {
   }

   public acz a(zx var1, zx var2, int var3) {
      if (var3 > 0 && var3 < this.size()) {
         acz var6 = (acz)this.get(var3);
         return !this.a(var1, var6.a()) || (var2 != null || var6.c()) && (!var6.c() || !this.a(var2, var6.b())) || var1.b < var6.a().b || var6.c() && var2.b < var6.b().b ? null : var6;
      } else {
         for(int var4 = 0; var4 < this.size(); ++var4) {
            acz var5 = (acz)this.get(var4);
            if (this.a(var1, var5.a()) && var1.b >= var5.a().b && (!var5.c() && var2 == null || var5.c() && this.a(var2, var5.b()) && var2.b >= var5.b().b)) {
               return var5;
            }
         }

         return null;
      }
   }

   public void a(em var1) {
      var1.writeByte((byte)(this.size() & 255));

      for(int var2 = 0; var2 < this.size(); ++var2) {
         acz var3 = (acz)this.get(var2);
         var1.a(var3.a());
         var1.a(var3.d());
         zx var4 = var3.b();
         var1.writeBoolean(var4 != null);
         if (var4 != null) {
            var1.a(var4);
         }

         var1.writeBoolean(var3.h());
         var1.writeInt(var3.e());
         var1.writeInt(var3.f());
      }

   }

   public static ada b(em var0) throws IOException {
      ada var1 = new ada();
      int var2 = var0.readByte() & 255;

      for(int var3 = 0; var3 < var2; ++var3) {
         zx var4 = var0.i();
         zx var5 = var0.i();
         zx var6 = null;
         if (var0.readBoolean()) {
            var6 = var0.i();
         }

         boolean var7 = var0.readBoolean();
         int var8 = var0.readInt();
         int var9 = var0.readInt();
         acz var10 = new acz(var4, var6, var5, var8, var9);
         if (var7) {
            var10.i();
         }

         var1.add(var10);
      }

      return var1;
   }

   private boolean a(zx var1, zx var2) {
      return zx.c(var1, var2) && (!var2.n() || var1.n() && dy.a(var2.o(), var1.o(), false));
   }

   public void a(dn var1) {
      du var2 = var1.c("Recipes", 10);

      for(int var3 = 0; var3 < var2.c(); ++var3) {
         dn var4 = var2.b(var3);
         this.add(new acz(var4));
      }

   }

   public dn a() {
      dn var1 = new dn();
      du var2 = new du();

      for(int var3 = 0; var3 < this.size(); ++var3) {
         acz var4 = (acz)this.get(var3);
         var2.a((eb)var4.k());
      }

      var1.a((String)"Recipes", (eb)var2);
      return var1;
   }
}
