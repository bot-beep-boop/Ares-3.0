package net.minecraft.stats;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IJsonSerializable;
import net.minecraft.util.TupleIntJsonSerializable;

public class StatFileWriter {
   protected final Map<StatBase, TupleIntJsonSerializable> statsData = Maps.newConcurrentMap();

   public int func_150874_c(Achievement var1) {
      if (this.hasAchievementUnlocked(var1)) {
         return 0;
      } else {
         int var2 = 0;

         for(Achievement var3 = var1.parentAchievement; var3 != null && !this.hasAchievementUnlocked(var3); ++var2) {
            var3 = var3.parentAchievement;
         }

         return var2;
      }
   }

   public boolean canUnlockAchievement(Achievement var1) {
      return var1.parentAchievement == null || this.hasAchievementUnlocked(var1.parentAchievement);
   }

   public void unlockAchievement(EntityPlayer var1, StatBase var2, int var3) {
      TupleIntJsonSerializable var4 = (TupleIntJsonSerializable)this.statsData.get(var2);
      if (var4 == null) {
         var4 = new TupleIntJsonSerializable();
         this.statsData.put(var2, var4);
      }

      var4.setIntegerValue(var3);
   }

   public boolean hasAchievementUnlocked(Achievement var1) {
      return this.readStat(var1) > 0;
   }

   public void increaseStat(EntityPlayer var1, StatBase var2, int var3) {
      if (!var2.isAchievement() || this.canUnlockAchievement((Achievement)var2)) {
         this.unlockAchievement(var1, var2, this.readStat(var2) + var3);
      }

   }

   public int readStat(StatBase var1) {
      TupleIntJsonSerializable var2 = (TupleIntJsonSerializable)this.statsData.get(var1);
      return var2 == null ? 0 : var2.getIntegerValue();
   }

   public <T extends IJsonSerializable> T func_150870_b(StatBase var1) {
      TupleIntJsonSerializable var2 = (TupleIntJsonSerializable)this.statsData.get(var1);
      return var2 != null ? var2.getJsonSerializableValue() : null;
   }

   public <T extends IJsonSerializable> T func_150872_a(StatBase var1, T var2) {
      TupleIntJsonSerializable var3 = (TupleIntJsonSerializable)this.statsData.get(var1);
      if (var3 == null) {
         var3 = new TupleIntJsonSerializable();
         this.statsData.put(var1, var3);
      }

      var3.setJsonSerializableValue(var2);
      return var2;
   }
}
