package net.java.games.input;

final class LinuxAxisDescriptor {
   private int type;
   private int code;

   public final int getType() {
      return this.type;
   }

   public final boolean equals(Object var1) {
      if (!(var1 instanceof LinuxAxisDescriptor)) {
         return false;
      } else {
         LinuxAxisDescriptor var2 = (LinuxAxisDescriptor)var1;
         return var2.type == this.type && var2.code == this.code;
      }
   }

   public final int getCode() {
      return this.code;
   }

   public final void set(int var1, int var2) {
      this.type = var1;
      this.code = var2;
   }

   public final String toString() {
      return "LinuxAxis: type = 0x" + Integer.toHexString(this.type) + ", code = 0x" + Integer.toHexString(this.code);
   }

   public final int hashCode() {
      return this.type ^ this.code;
   }
}
