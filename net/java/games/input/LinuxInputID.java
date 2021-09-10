package net.java.games.input;

final class LinuxInputID {
   private final int version;
   private final int vendor;
   private final int bustype;
   private final int product;

   public final String toString() {
      return "LinuxInputID: bustype = 0x" + Integer.toHexString(this.bustype) + " | vendor = 0x" + Integer.toHexString(this.vendor) + " | product = 0x" + Integer.toHexString(this.product) + " | version = 0x" + Integer.toHexString(this.version);
   }

   public final Controller.PortType getPortType() {
      return LinuxNativeTypesMap.getPortType(this.bustype);
   }

   public LinuxInputID(int var1, int var2, int var3, int var4) {
      this.bustype = var1;
      this.vendor = var2;
      this.product = var3;
      this.version = var4;
   }
}
