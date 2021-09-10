package net.minecraft.client.network;

import com.aresclient.utils.config.ConfigManager;
import com.google.common.base.Objects;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.network.play.server.S38PacketPlayerListItem;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldSettings;

public class NetworkPlayerInfo {
   private String skinType;
   private ResourceLocation locationAresCape;
   private ResourceLocation locationCape;
   private long field_178868_l = 0L;
   private long field_178871_k = 0L;
   private int field_178870_j = 0;
   private long field_178869_m = 0L;
   protected ResourceLocation locationSkin;
   private WorldSettings.GameType gameType;
   private IChatComponent displayName;
   private int responseTime;
   protected final GameProfile gameProfile;
   private int field_178873_i = 0;
   private boolean playerTexturesLoaded = false;

   public NetworkPlayerInfo(GameProfile var1) {
      this.gameProfile = var1;
   }

   public void func_178836_b(int var1) {
      this.field_178873_i = var1;
   }

   public long func_178858_o() {
      return this.field_178868_l;
   }

   public void setDisplayName(IChatComponent var1) {
      this.displayName = var1;
   }

   public int func_178835_l() {
      return this.field_178873_i;
   }

   static void access$2(NetworkPlayerInfo var0, ResourceLocation var1) {
      var0.locationCape = var1;
   }

   public ResourceLocation getLocationSkin() {
      if (this.locationSkin == null) {
         this.loadPlayerTextures();
      }

      return ConfigManager.settings.SkinChanger == 2 && this.gameProfile.getName().equals(Minecraft.getMinecraft().getSession().getUsername()) ? new ResourceLocation(ConfigManager.settings.skinpath) : (ResourceLocation)Objects.firstNonNull(this.locationSkin, DefaultPlayerSkin.getDefaultSkin(this.gameProfile.getId()));
   }

   public ResourceLocation getLocationCape() {
      if (this.locationCape == null) {
         this.loadPlayerTextures();
      }

      return this.locationCape;
   }

   public long func_178855_p() {
      return this.field_178869_m;
   }

   public GameProfile getGameProfile() {
      return this.gameProfile;
   }

   protected void setGameType(WorldSettings.GameType var1) {
      this.gameType = var1;
   }

   static String access$1(NetworkPlayerInfo var0) {
      return var0.skinType;
   }

   public ScorePlayerTeam getPlayerTeam() {
      return Minecraft.getMinecraft().theWorld.getScoreboard().getPlayersTeam(this.getGameProfile().getName());
   }

   public IChatComponent getDisplayName() {
      return this.displayName;
   }

   public long func_178847_n() {
      return this.field_178871_k;
   }

   static void access$0(NetworkPlayerInfo var0, String var1) {
      var0.skinType = var1;
   }

   public WorldSettings.GameType getGameType() {
      return this.gameType;
   }

   public boolean hasLocationSkin() {
      return this.locationSkin != null;
   }

   public void func_178846_a(long var1) {
      this.field_178871_k = var1;
   }

   public void func_178857_c(int var1) {
      this.field_178870_j = var1;
   }

   public void setLocationSkin(ResourceLocation var1) {
      this.locationSkin = var1;
   }

   protected void setResponseTime(int var1) {
      this.responseTime = var1;
   }

   public int getResponseTime() {
      return this.responseTime;
   }

   public String getSkinType() {
      if (ConfigManager.settings.SkinChanger == 2) {
         return ConfigManager.settings.SkinType == 1 ? null : "slim";
      } else {
         return this.skinType == null ? DefaultPlayerSkin.getSkinType(this.gameProfile.getId()) : this.skinType;
      }
   }

   public ResourceLocation getLocationAresCape() {
      if (this.locationAresCape == null) {
         this.loadPlayerTextures();
      }

      return this.locationAresCape;
   }

   public NetworkPlayerInfo(S38PacketPlayerListItem.AddPlayerData var1) {
      this.gameProfile = var1.getProfile();
      this.gameType = var1.getGameMode();
      this.responseTime = var1.getPing();
      this.displayName = var1.getDisplayName();
   }

   protected void loadPlayerTextures() {
      synchronized(this) {
         if (!this.playerTexturesLoaded) {
            this.playerTexturesLoaded = true;
            Minecraft.getMinecraft().getSkinManager().loadProfileTextures(this.gameProfile, new SkinManager.SkinAvailableCallback(this) {
               final NetworkPlayerInfo this$0;
               private static int[] $SWITCH_TABLE$com$mojang$authlib$minecraft$MinecraftProfileTexture$Type;

               public void skinAvailable(Type var1, ResourceLocation var2, MinecraftProfileTexture var3) {
                  switch($SWITCH_TABLE$com$mojang$authlib$minecraft$MinecraftProfileTexture$Type()[var1.ordinal()]) {
                  case 1:
                     this.this$0.locationSkin = var2;
                     NetworkPlayerInfo.access$0(this.this$0, var3.getMetadata("model"));
                     if (NetworkPlayerInfo.access$1(this.this$0) == null) {
                        NetworkPlayerInfo.access$0(this.this$0, "default");
                     }
                     break;
                  case 2:
                     NetworkPlayerInfo.access$2(this.this$0, var2);
                  }

               }

               static int[] $SWITCH_TABLE$com$mojang$authlib$minecraft$MinecraftProfileTexture$Type() {
                  int[] var10000 = $SWITCH_TABLE$com$mojang$authlib$minecraft$MinecraftProfileTexture$Type;
                  if (var10000 != null) {
                     return var10000;
                  } else {
                     int[] var0 = new int[Type.values().length];

                     try {
                        var0[Type.CAPE.ordinal()] = 2;
                     } catch (NoSuchFieldError var2) {
                     }

                     try {
                        var0[Type.SKIN.ordinal()] = 1;
                     } catch (NoSuchFieldError var1) {
                     }

                     $SWITCH_TABLE$com$mojang$authlib$minecraft$MinecraftProfileTexture$Type = var0;
                     return var0;
                  }
               }

               {
                  this.this$0 = var1;
               }
            }, true);
         }

      }
   }

   public void func_178843_c(long var1) {
      this.field_178869_m = var1;
   }

   public void func_178844_b(long var1) {
      this.field_178868_l = var1;
   }

   public int func_178860_m() {
      return this.field_178870_j;
   }
}
