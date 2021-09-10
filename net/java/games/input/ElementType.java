package net.java.games.input;

final class ElementType {
   public static final ElementType INPUT_AXIS = new ElementType(3);
   public static final ElementType INPUT_SCANCODES = new ElementType(4);
   private final int type_id;
   public static final ElementType INPUT_MISC = new ElementType(1);
   public static final ElementType FEATURE = new ElementType(257);
   public static final ElementType COLLECTION = new ElementType(513);
   public static final ElementType INPUT_BUTTON = new ElementType(2);
   private static final ElementType[] map = new ElementType[514];
   public static final ElementType OUTPUT = new ElementType(129);

   public static final ElementType map(int var0) {
      return var0 >= 0 && var0 < map.length ? map[var0] : null;
   }

   private ElementType(int var1) {
      map[var1] = this;
      this.type_id = var1;
   }

   public final String toString() {
      return "ElementType (0x" + Integer.toHexString(this.type_id) + ")";
   }
}
