import java.util.BitSet;
import java.util.Iterator;
import java.util.Set;

public class bhx {
   private static final int a = cq.values().length;
   private final BitSet b;

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append(' ');
      cq[] var2 = cq.values();
      int var3 = var2.length;

      int var4;
      cq var5;
      for(var4 = 0; var4 < var3; ++var4) {
         var5 = var2[var4];
         var1.append(' ').append(var5.toString().toUpperCase().charAt(0));
      }

      var1.append('\n');
      var2 = cq.values();
      var3 = var2.length;

      for(var4 = 0; var4 < var3; ++var4) {
         var5 = var2[var4];
         var1.append(var5.toString().toUpperCase().charAt(0));
         cq[] var6 = cq.values();
         int var7 = var6.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            cq var9 = var6[var8];
            if (var5 == var9) {
               var1.append("  ");
            } else {
               boolean var10 = this.a(var5, var9);
               var1.append(' ').append((char)(var10 ? 'Y' : 'n'));
            }
         }

         var1.append('\n');
      }

      return var1.toString();
   }

   public void a(cq var1, cq var2, boolean var3) {
      this.b.set(var1.ordinal() + var2.ordinal() * a, var3);
      this.b.set(var2.ordinal() + var1.ordinal() * a, var3);
   }

   public boolean a(cq var1, cq var2) {
      return this.b.get(var1.ordinal() + var2.ordinal() * a);
   }

   public bhx() {
      this.b = new BitSet(a * a);
   }

   public void a(boolean var1) {
      this.b.set(0, this.b.size(), var1);
   }

   public void a(Set<cq> var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         cq var3 = (cq)var2.next();
         Iterator var4 = var1.iterator();

         while(var4.hasNext()) {
            cq var5 = (cq)var4.next();
            this.a(var3, var5, true);
         }
      }

   }
}
