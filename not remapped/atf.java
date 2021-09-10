public class atf {
   private byte c;
   private byte b;
   private byte a;
   private byte d;

   public atf(byte var1, byte var2, byte var3, byte var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   public atf(atf var1) {
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
      this.d = var1.d;
   }

   public int hashCode() {
      byte var1 = this.a;
      int var2 = 31 * var1 + this.b;
      var2 = 31 * var2 + this.c;
      var2 = 31 * var2 + this.d;
      return var2;
   }

   public byte c() {
      return this.c;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof atf)) {
         return false;
      } else {
         atf var2 = (atf)var1;
         if (this.a != var2.a) {
            return false;
         } else if (this.d != var2.d) {
            return false;
         } else if (this.b != var2.b) {
            return false;
         } else {
            return this.c == var2.c;
         }
      }
   }

   public byte a() {
      return this.a;
   }

   public byte b() {
      return this.b;
   }

   public byte d() {
      return this.d;
   }
}
