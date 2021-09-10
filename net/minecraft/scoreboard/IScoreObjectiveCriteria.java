package net.minecraft.scoreboard;

import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;

public interface IScoreObjectiveCriteria {
   Map<String, IScoreObjectiveCriteria> INSTANCES = Maps.newHashMap();
   IScoreObjectiveCriteria deathCount = new ScoreDummyCriteria("deathCount");
   IScoreObjectiveCriteria[] field_178792_h = new IScoreObjectiveCriteria[]{new GoalColor("teamkill.", EnumChatFormatting.BLACK), new GoalColor("teamkill.", EnumChatFormatting.DARK_BLUE), new GoalColor("teamkill.", EnumChatFormatting.DARK_GREEN), new GoalColor("teamkill.", EnumChatFormatting.DARK_AQUA), new GoalColor("teamkill.", EnumChatFormatting.DARK_RED), new GoalColor("teamkill.", EnumChatFormatting.DARK_PURPLE), new GoalColor("teamkill.", EnumChatFormatting.GOLD), new GoalColor("teamkill.", EnumChatFormatting.GRAY), new GoalColor("teamkill.", EnumChatFormatting.DARK_GRAY), new GoalColor("teamkill.", EnumChatFormatting.BLUE), new GoalColor("teamkill.", EnumChatFormatting.GREEN), new GoalColor("teamkill.", EnumChatFormatting.AQUA), new GoalColor("teamkill.", EnumChatFormatting.RED), new GoalColor("teamkill.", EnumChatFormatting.LIGHT_PURPLE), new GoalColor("teamkill.", EnumChatFormatting.YELLOW), new GoalColor("teamkill.", EnumChatFormatting.WHITE)};
   IScoreObjectiveCriteria playerKillCount = new ScoreDummyCriteria("playerKillCount");
   IScoreObjectiveCriteria DUMMY = new ScoreDummyCriteria("dummy");
   IScoreObjectiveCriteria health = new ScoreHealthCriteria("health");
   IScoreObjectiveCriteria TRIGGER = new ScoreDummyCriteria("trigger");
   IScoreObjectiveCriteria totalKillCount = new ScoreDummyCriteria("totalKillCount");
   IScoreObjectiveCriteria[] field_178793_i = new IScoreObjectiveCriteria[]{new GoalColor("killedByTeam.", EnumChatFormatting.BLACK), new GoalColor("killedByTeam.", EnumChatFormatting.DARK_BLUE), new GoalColor("killedByTeam.", EnumChatFormatting.DARK_GREEN), new GoalColor("killedByTeam.", EnumChatFormatting.DARK_AQUA), new GoalColor("killedByTeam.", EnumChatFormatting.DARK_RED), new GoalColor("killedByTeam.", EnumChatFormatting.DARK_PURPLE), new GoalColor("killedByTeam.", EnumChatFormatting.GOLD), new GoalColor("killedByTeam.", EnumChatFormatting.GRAY), new GoalColor("killedByTeam.", EnumChatFormatting.DARK_GRAY), new GoalColor("killedByTeam.", EnumChatFormatting.BLUE), new GoalColor("killedByTeam.", EnumChatFormatting.GREEN), new GoalColor("killedByTeam.", EnumChatFormatting.AQUA), new GoalColor("killedByTeam.", EnumChatFormatting.RED), new GoalColor("killedByTeam.", EnumChatFormatting.LIGHT_PURPLE), new GoalColor("killedByTeam.", EnumChatFormatting.YELLOW), new GoalColor("killedByTeam.", EnumChatFormatting.WHITE)};

   int setScore(List<EntityPlayer> var1);

   IScoreObjectiveCriteria.EnumRenderType getRenderType();

   String getName();

   boolean isReadOnly();

   public static enum EnumRenderType {
      private static final IScoreObjectiveCriteria.EnumRenderType[] ENUM$VALUES = new IScoreObjectiveCriteria.EnumRenderType[]{INTEGER, HEARTS};
      private final String field_178798_d;
      private static final Map<String, IScoreObjectiveCriteria.EnumRenderType> field_178801_c = Maps.newHashMap();
      INTEGER("integer"),
      HEARTS("hearts");

      private EnumRenderType(String var3) {
         this.field_178798_d = var3;
      }

      public static IScoreObjectiveCriteria.EnumRenderType func_178795_a(String var0) {
         IScoreObjectiveCriteria.EnumRenderType var1 = (IScoreObjectiveCriteria.EnumRenderType)field_178801_c.get(var0);
         return var1 == null ? INTEGER : var1;
      }

      public String func_178796_a() {
         return this.field_178798_d;
      }

      static {
         IScoreObjectiveCriteria.EnumRenderType[] var3;
         int var2 = (var3 = values()).length;

         for(int var1 = 0; var1 < var2; ++var1) {
            IScoreObjectiveCriteria.EnumRenderType var0 = var3[var1];
            field_178801_c.put(var0.func_178796_a(), var0);
         }

      }
   }
}
