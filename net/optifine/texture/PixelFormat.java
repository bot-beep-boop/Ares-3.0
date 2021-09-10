package net.optifine.texture;

public enum PixelFormat {
   BGRA_INTEGER(36251),
   BGR_INTEGER(36250),
   RED_INTEGER(36244),
   RGB(6407),
   RGB_INTEGER(36248),
   RG_INTEGER(33320),
   RGBA(6408),
   RG(33319);

   private int id;
   private static final PixelFormat[] ENUM$VALUES = new PixelFormat[]{RED, RG, RGB, BGR, RGBA, BGRA, RED_INTEGER, RG_INTEGER, RGB_INTEGER, BGR_INTEGER, RGBA_INTEGER, BGRA_INTEGER};
   RGBA_INTEGER(36249),
   BGR(32992),
   BGRA(32993),
   RED(6403);

   private PixelFormat(int var3) {
      this.id = var3;
   }

   public int getId() {
      return this.id;
   }
}
