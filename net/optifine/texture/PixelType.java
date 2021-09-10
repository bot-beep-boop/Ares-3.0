package net.optifine.texture;

public enum PixelType {
   INT(5124),
   SHORT(5122);

   private int id;
   UNSIGNED_INT_8_8_8_8(32821),
   UNSIGNED_BYTE_2_3_3_REV(33634),
   UNSIGNED_SHORT_4_4_4_4_REV(33637),
   UNSIGNED_INT_2_10_10_10_REV(33640),
   UNSIGNED_INT_8_8_8_8_REV(33639),
   BYTE(5120),
   UNSIGNED_INT(5125),
   UNSIGNED_BYTE_3_3_2(32818),
   UNSIGNED_BYTE(5121),
   FLOAT(5126),
   UNSIGNED_SHORT_4_4_4_4(32819),
   UNSIGNED_SHORT_5_6_5_REV(33636),
   UNSIGNED_INT_10_10_10_2(32822),
   UNSIGNED_SHORT(5123),
   HALF_FLOAT(5131),
   UNSIGNED_SHORT_5_6_5(33635),
   UNSIGNED_SHORT_5_5_5_1(32820),
   UNSIGNED_SHORT_1_5_5_5_REV(33638);

   private static final PixelType[] ENUM$VALUES = new PixelType[]{BYTE, SHORT, INT, HALF_FLOAT, FLOAT, UNSIGNED_BYTE, UNSIGNED_BYTE_3_3_2, UNSIGNED_BYTE_2_3_3_REV, UNSIGNED_SHORT, UNSIGNED_SHORT_5_6_5, UNSIGNED_SHORT_5_6_5_REV, UNSIGNED_SHORT_4_4_4_4, UNSIGNED_SHORT_4_4_4_4_REV, UNSIGNED_SHORT_5_5_5_1, UNSIGNED_SHORT_1_5_5_5_REV, UNSIGNED_INT, UNSIGNED_INT_8_8_8_8, UNSIGNED_INT_8_8_8_8_REV, UNSIGNED_INT_10_10_10_2, UNSIGNED_INT_2_10_10_10_REV};

   public int getId() {
      return this.id;
   }

   private PixelType(int var3) {
      this.id = var3;
   }
}