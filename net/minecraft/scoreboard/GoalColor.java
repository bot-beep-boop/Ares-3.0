package net.minecraft.scoreboard;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;

public class GoalColor implements IScoreObjectiveCriteria {
   private final String goalName;

   public IScoreObjectiveCriteria.EnumRenderType getRenderType() {
      return IScoreObjectiveCriteria.EnumRenderType.INTEGER;
   }

   public int setScore(List<EntityPlayer> var1) {
      return 0;
   }

   public boolean isReadOnly() {
      return false;
   }

   public GoalColor(String var1, EnumChatFormatting var2) {
      this.goalName = var1 + var2.getFriendlyName();
      IScoreObjectiveCriteria.INSTANCES.put(this.goalName, this);
   }

   public String getName() {
      return this.goalName;
   }
}
