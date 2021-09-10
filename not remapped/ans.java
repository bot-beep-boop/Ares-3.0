public class ans {
   private final short[] a = new short[65536];
   private final alz b;

   public ans() {
      this.b = afi.a.Q();
   }

   public void a(int var1, int var2, int var3, alz var4) {
      int var5 = var1 << 12 | var3 << 8 | var2;
      this.a(var5, var4);
   }

   public alz a(int var1, int var2, int var3) {
      int var4 = var1 << 12 | var3 << 8 | var2;
      return this.a(var4);
   }

   public alz a(int var1) {
      if (var1 >= 0 && var1 < this.a.length) {
         alz var2 = (alz)afh.d.a(this.a[var1]);
         return var2 != null ? var2 : this.b;
      } else {
         throw new IndexOutOfBoundsException("The coordinate is out of range");
      }
   }

   public void a(int var1, alz var2) {
      if (var1 >= 0 && var1 < this.a.length) {
         this.a[var1] = (short)afh.d.b(var2);
      } else {
         throw new IndexOutOfBoundsException("The coordinate is out of range");
      }
   }
}
