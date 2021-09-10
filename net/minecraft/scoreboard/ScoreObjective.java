package net.minecraft.scoreboard;

public class ScoreObjective {
   private final String name;
   private IScoreObjectiveCriteria.EnumRenderType renderType;
   private final Scoreboard theScoreboard;
   private final IScoreObjectiveCriteria objectiveCriteria;
   private String displayName;

   public IScoreObjectiveCriteria getCriteria() {
      return this.objectiveCriteria;
   }

   public void setDisplayName(String var1) {
      this.displayName = var1;
      this.theScoreboard.onObjectiveDisplayNameChanged(this);
   }

   public ScoreObjective(Scoreboard var1, String var2, IScoreObjectiveCriteria var3) {
      this.theScoreboard = var1;
      this.name = var2;
      this.objectiveCriteria = var3;
      this.displayName = var2;
      this.renderType = var3.getRenderType();
   }

   public Scoreboard getScoreboard() {
      return this.theScoreboard;
   }

   public String getDisplayName() {
      return this.displayName;
   }

   public String getName() {
      return this.name;
   }

   public IScoreObjectiveCriteria.EnumRenderType getRenderType() {
      return this.renderType;
   }

   public void setRenderType(IScoreObjectiveCriteria.EnumRenderType var1) {
      this.renderType = var1;
      this.theScoreboard.onObjectiveDisplayNameChanged(this);
   }
}
