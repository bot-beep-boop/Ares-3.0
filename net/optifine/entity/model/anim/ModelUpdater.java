package net.optifine.entity.model.anim;

public class ModelUpdater {
   private ModelVariableUpdater[] modelVariableUpdaters;

   public boolean initialize(IModelResolver var1) {
      for(int var2 = 0; var2 < this.modelVariableUpdaters.length; ++var2) {
         ModelVariableUpdater var3 = this.modelVariableUpdaters[var2];
         if (!var3.initialize(var1)) {
            return false;
         }
      }

      return true;
   }

   public ModelUpdater(ModelVariableUpdater[] var1) {
      this.modelVariableUpdaters = var1;
   }

   public void update() {
      for(int var1 = 0; var1 < this.modelVariableUpdaters.length; ++var1) {
         ModelVariableUpdater var2 = this.modelVariableUpdaters[var1];
         var2.update();
      }

   }
}
