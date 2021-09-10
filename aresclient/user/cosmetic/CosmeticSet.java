package com.aresclient.user.cosmetic;

import com.google.common.collect.Sets;
import java.util.Set;

public class CosmeticSet {
   public static Set<CosmeticBase.CosmeticEnum> UNLOCKALL = Sets.newHashSet(CosmeticBase.CosmeticEnum.values());
   public static Set<CosmeticBase.CosmeticEnum> NONE;

   static {
      NONE = Sets.newHashSet(new CosmeticBase.CosmeticEnum[]{CosmeticBase.CosmeticEnum.NONE});
   }
}
