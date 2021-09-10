package net.optifine.texture;

public enum InternalFormat {
   RG16F(33327),
   RG16(33324),
   RGB32I(36227),
   RGB32UI(36209),
   RG8(33323),
   R16(33322),
   RGBA32UI(36208),
   RGB5_A1(32855),
   R3_G3_B2(10768),
   R32UI(33334),
   RG16_SNORM(36761),
   R11F_G11F_B10F(35898);

   private static final InternalFormat[] ENUM$VALUES = new InternalFormat[]{R8, RG8, RGB8, RGBA8, R8_SNORM, RG8_SNORM, RGB8_SNORM, RGBA8_SNORM, R16, RG16, RGB16, RGBA16, R16_SNORM, RG16_SNORM, RGB16_SNORM, RGBA16_SNORM, R16F, RG16F, RGB16F, RGBA16F, R32F, RG32F, RGB32F, RGBA32F, R32I, RG32I, RGB32I, RGBA32I, R32UI, RG32UI, RGB32UI, RGBA32UI, R3_G3_B2, RGB5_A1, RGB10_A2, R11F_G11F_B10F, RGB9_E5};
   RGB9_E5(35901),
   RGBA16_SNORM(36763),
   RG32I(33339),
   R32F(33326),
   R32I(33333),
   RG8_SNORM(36757),
   RGBA32F(34836),
   RGB16F(34843),
   RG32F(33328);

   private int id;
   RGB32F(34837),
   RGB16_SNORM(36762),
   RGB8(32849),
   RGBA32I(36226),
   RGB10_A2(32857),
   RG32UI(33340),
   R8(33321),
   RGB16(32852),
   RGBA8(32856),
   R16F(33325),
   RGBA8_SNORM(36759),
   RGBA16(32859),
   RGBA16F(34842),
   R8_SNORM(36756),
   R16_SNORM(36760),
   RGB8_SNORM(36758);

   private InternalFormat(int var3) {
      this.id = var3;
   }

   public int getId() {
      return this.id;
   }
}