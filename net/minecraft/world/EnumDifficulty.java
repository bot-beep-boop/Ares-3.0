package net.minecraft.world;

public enum EnumDifficulty {
   private static final EnumDifficulty[] difficultyEnums = new EnumDifficulty[values().length];
   private final String difficultyResourceKey;
   private final int difficultyId;
   HARD(3, "options.difficulty.hard"),
   EASY(1, "options.difficulty.easy");

   private static final EnumDifficulty[] ENUM$VALUES = new EnumDifficulty[]{PEACEFUL, EASY, NORMAL, HARD};
   NORMAL(2, "options.difficulty.normal"),
   PEACEFUL(0, "options.difficulty.peaceful");

   public String getDifficultyResourceKey() {
      return this.difficultyResourceKey;
   }

   static {
      EnumDifficulty[] var3;
      int var2 = (var3 = values()).length;

      for(int var1 = 0; var1 < var2; ++var1) {
         EnumDifficulty var0 = var3[var1];
         difficultyEnums[var0.difficultyId] = var0;
      }

   }

   public static EnumDifficulty getDifficultyEnum(int var0) {
      return difficultyEnums[var0 % difficultyEnums.length];
   }

   public int getDifficultyId() {
      return this.difficultyId;
   }

   private EnumDifficulty(int var3, String var4) {
      this.difficultyId = var3;
      this.difficultyResourceKey = var4;
   }
}
