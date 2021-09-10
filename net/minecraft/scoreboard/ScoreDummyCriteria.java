package net.minecraft.scoreboard;

import java.util.List;
import net.minecraft.entity.player.EntityPlayer;

public class ScoreDummyCriteria implements IScoreObjectiveCriteria {
   private final String dummyName;

   public IScoreObjectiveCriteria.EnumRenderType getRenderType() {
      return IScoreObjectiveCriteria.EnumRenderType.INTEGER;
   }

   public int setScore(List<EntityPlayer> var1) {
      return 0;
   }

   public ScoreDummyCriteria(String var1) {
      this.dummyName = var1;
      IScoreObjectiveCriteria.INSTANCES.put(var1, this);
   }

   public boolean isReadOnly() {
      return false;
   }

   public String getName() {
      return this.dummyName;
   }
}
