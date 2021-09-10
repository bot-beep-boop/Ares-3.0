package net.optifine.shaders;

public enum ProgramStage {
   NONE(""),
   GBUFFERS("gbuffers"),
   SHADOW("shadow"),
   COMPOSITE("composite"),
   DEFERRED("deferred");

   private String name;
   private static final ProgramStage[] ENUM$VALUES = new ProgramStage[]{NONE, SHADOW, GBUFFERS, DEFERRED, COMPOSITE};

   public String getName() {
      return this.name;
   }

   private ProgramStage(String var3) {
      this.name = var3;
   }
}
