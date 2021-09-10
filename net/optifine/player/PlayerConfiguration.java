package net.optifine.player;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.src.Config;

public class PlayerConfiguration {
   private boolean initialized = false;
   private PlayerItemModel[] playerItemModels = new PlayerItemModel[0];

   public void addPlayerItemModel(PlayerItemModel var1) {
      this.playerItemModels = (PlayerItemModel[])Config.addObjectToArray(this.playerItemModels, var1);
   }

   public boolean isInitialized() {
      return this.initialized;
   }

   public PlayerItemModel[] getPlayerItemModels() {
      return this.playerItemModels;
   }

   public void renderPlayerItems(ModelBiped var1, AbstractClientPlayer var2, float var3, float var4) {
      if (this.initialized) {
         for(int var5 = 0; var5 < this.playerItemModels.length; ++var5) {
            PlayerItemModel var6 = this.playerItemModels[var5];
            var6.render(var1, var2, var3, var4);
         }
      }

   }

   public void setInitialized(boolean var1) {
      this.initialized = var1;
   }
}
