package net.optifine.shaders;

import java.util.ArrayList;
import java.util.HashSet;
import net.minecraft.src.Config;
import net.optifine.config.MatchBlock;

public class BlockAlias {
   private int blockAliasId;
   private MatchBlock[] matchBlocks;

   public BlockAlias(int var1, MatchBlock[] var2) {
      this.blockAliasId = var1;
      this.matchBlocks = var2;
   }

   public int[] getMatchBlockIds() {
      HashSet var1 = new HashSet();

      for(int var2 = 0; var2 < this.matchBlocks.length; ++var2) {
         MatchBlock var3 = this.matchBlocks[var2];
         int var4 = var3.getBlockId();
         var1.add(var4);
      }

      Integer[] var5 = (Integer[])var1.toArray(new Integer[var1.size()]);
      int[] var6 = Config.toPrimitive(var5);
      return var6;
   }

   public String toString() {
      return "block." + this.blockAliasId + "=" + Config.arrayToString((Object[])this.matchBlocks);
   }

   public MatchBlock[] getMatchBlocks(int var1) {
      ArrayList var2 = new ArrayList();

      for(int var3 = 0; var3 < this.matchBlocks.length; ++var3) {
         MatchBlock var4 = this.matchBlocks[var3];
         if (var4.getBlockId() == var1) {
            var2.add(var4);
         }
      }

      MatchBlock[] var5 = (MatchBlock[])var2.toArray(new MatchBlock[var2.size()]);
      return var5;
   }

   public boolean matches(int var1, int var2) {
      for(int var3 = 0; var3 < this.matchBlocks.length; ++var3) {
         MatchBlock var4 = this.matchBlocks[var3];
         if (var4.matches(var1, var2)) {
            return true;
         }
      }

      return false;
   }

   public int getBlockAliasId() {
      return this.blockAliasId;
   }
}
