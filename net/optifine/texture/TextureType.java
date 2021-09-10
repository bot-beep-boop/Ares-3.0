package net.optifine.texture;

public enum TextureType {
   TEXTURE_3D(32879),
   TEXTURE_1D(3552);

   private static final TextureType[] ENUM$VALUES = new TextureType[]{TEXTURE_1D, TEXTURE_2D, TEXTURE_3D, TEXTURE_RECTANGLE};
   private int id;
   TEXTURE_2D(3553),
   TEXTURE_RECTANGLE(34037);

   private TextureType(int var3) {
      this.id = var3;
   }

   public int getId() {
      return this.id;
   }
}
