package com.aresclient.user.cosmetic;

import com.google.common.collect.Sets;
import java.util.Set;

public class CosmeticBase {
   public String userUUID;
   public Set<CosmeticBase.CosmeticEnum> activecosmetics;

   public void changeCosmetic(CosmeticBase.CosmeticEnum var1, boolean var2) {
      if (this.activecosmetics.contains(CosmeticBase.CosmeticEnum.NONE) && var2) {
         this.activecosmetics.remove(CosmeticBase.CosmeticEnum.NONE);
         this.activecosmetics.add(var1);
         System.out.println("added to: " + this.userUUID);
      } else if (var2) {
         this.activecosmetics.add(var1);
      } else {
         this.activecosmetics.remove(var1);
         if (this.activecosmetics.isEmpty()) {
            this.activecosmetics.add(CosmeticBase.CosmeticEnum.NONE);
         }
      }

      if (!this.activecosmetics.contains(var1)) {
         this.activecosmetics.add(var1);
      } else {
         this.activecosmetics.remove(var1);
      }

   }

   public Set<CosmeticBase.CosmeticEnum> getActivecosmetics() {
      return this.activecosmetics;
   }

   public CosmeticBase(String var1, Set<CosmeticBase.CosmeticEnum> var2) {
      this.activecosmetics = Sets.newHashSet(new CosmeticBase.CosmeticEnum[]{CosmeticBase.CosmeticEnum.NONE});
      this.activecosmetics = var2;
      this.userUUID = var1;
   }

   public static enum CosmeticEnum {
      BANDANA,
      BLAZE,
      HALO,
      SWORDAURA,
      NONE,
      DRAGONWINGS,
      WITCH,
      BUNNYEARS,
      CAPE;

      private static final CosmeticBase.CosmeticEnum[] ENUM$VALUES = new CosmeticBase.CosmeticEnum[]{NONE, CAPE, DRAGONWINGS, WITCH, BANDANA, BLAZE, BUNNYEARS, HALO, SWORDAURA};
   }
}
