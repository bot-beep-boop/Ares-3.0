package net.minecraft.client.entity;

import com.aresclient.user.cosmetic.imp.capes.AresCapeUtils;
import com.mojang.authlib.GameProfile;
import java.io.File;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;
import net.optifine.player.CapeUtils;
import net.optifine.player.PlayerConfigurations;
import net.optifine.reflect.Reflector;

public abstract class AbstractClientPlayer extends EntityPlayer {
   private long reloadCapeTimeMs = 0L;
   private ResourceLocation locationOfAresCape = null;
   private ResourceLocation locationOptifineCape = null;
   private ResourceLocation locationOfCape = null;
   private static final ResourceLocation TEXTURE_ELYTRA = new ResourceLocation("textures/entity/elytra.png");
   private ResourceLocation locationOfOfflineCape = null;
   private String nameClear = null;
   private boolean elytraOfCape = false;
   private NetworkPlayerInfo playerInfo;

   public void setLocationOfCape(ResourceLocation var1) {
      this.locationOfCape = var1;
   }

   public ResourceLocation getlocationOfOfflineCape() {
      return this.locationOfOfflineCape != null ? this.locationOfOfflineCape : this.locationOfOfflineCape;
   }

   public void setLocationOfOptifineCape(ResourceLocation var1) {
      this.locationOptifineCape = var1;
   }

   public static ResourceLocation getLocationSkin(String var0) {
      return new ResourceLocation("skins/" + StringUtils.stripControlCodes(var0));
   }

   public boolean isElytraOfCape() {
      return this.elytraOfCape;
   }

   protected NetworkPlayerInfo getPlayerInfo() {
      if (this.playerInfo == null) {
         this.playerInfo = Minecraft.getMinecraft().getNetHandler().getPlayerInfo(this.getUniqueID());
      }

      return this.playerInfo;
   }

   public ResourceLocation getLocationCape() {
      if (!Config.isShowCapes()) {
         return null;
      } else {
         if (this.reloadCapeTimeMs != 0L && System.currentTimeMillis() > this.reloadCapeTimeMs) {
            CapeUtils.reloadCape(this);
            this.reloadCapeTimeMs = 0L;
         }

         if (this.locationOfCape != null) {
            return this.locationOfCape;
         } else {
            NetworkPlayerInfo var1 = this.getPlayerInfo();
            return var1 == null ? null : var1.getLocationCape();
         }
      }
   }

   public String getSkinType() {
      NetworkPlayerInfo var1 = this.getPlayerInfo();
      return var1 == null ? DefaultPlayerSkin.getSkinType(this.getUniqueID()) : var1.getSkinType();
   }

   public boolean hasSkin() {
      NetworkPlayerInfo var1 = this.getPlayerInfo();
      return var1 != null && var1.hasLocationSkin();
   }

   public ResourceLocation getLocationAresCape() {
      return this.locationOfAresCape != null ? this.locationOfAresCape : this.locationOfAresCape;
   }

   public void setLocationOfOfflineCape(ResourceLocation var1) {
      this.locationOfOfflineCape = var1;
   }

   public long getReloadCapeTimeMs() {
      return this.reloadCapeTimeMs;
   }

   public void setElytraOfCape(boolean var1) {
      this.elytraOfCape = var1;
   }

   public float getFovModifier() {
      float var1 = 1.0F;
      if (this.capabilities.isFlying) {
         var1 *= 1.1F;
      }

      IAttributeInstance var2 = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
      var1 = (float)((double)var1 * ((var2.getAttributeValue() / (double)this.capabilities.getWalkSpeed() + 1.0D) / 2.0D));
      if (this.capabilities.getWalkSpeed() == 0.0F || Float.isNaN(var1) || Float.isInfinite(var1)) {
         var1 = 1.0F;
      }

      if (this.isUsingItem() && this.getItemInUse().getItem() == Items.bow) {
         int var3 = this.getItemInUseDuration();
         float var4 = (float)var3 / 20.0F;
         if (var4 > 1.0F) {
            var4 = 1.0F;
         } else {
            var4 *= var4;
         }

         var1 *= 1.0F - var4 * 0.15F;
      }

      return Reflector.ForgeHooksClient_getOffsetFOV.exists() ? Reflector.callFloat(Reflector.ForgeHooksClient_getOffsetFOV, this, var1) : var1;
   }

   public boolean isSpectator() {
      NetworkPlayerInfo var1 = Minecraft.getMinecraft().getNetHandler().getPlayerInfo(this.getGameProfile().getId());
      return var1 != null && var1.getGameType() == WorldSettings.GameType.SPECTATOR;
   }

   public AbstractClientPlayer(World var1, GameProfile var2) {
      super(var1, var2);
      this.nameClear = var2.getName();
      if (this.nameClear != null && !this.nameClear.isEmpty()) {
         this.nameClear = StringUtils.stripControlCodes(this.nameClear);
      }

      CapeUtils.downloadCape(this);
      AresCapeUtils.downloadCape(this);
      PlayerConfigurations.getPlayerConfiguration(this);
   }

   public static ThreadDownloadImageData getDownloadImageSkin(ResourceLocation var0, String var1) {
      TextureManager var2 = Minecraft.getMinecraft().getTextureManager();
      Object var3 = var2.getTexture(var0);
      if (var3 == null) {
         var3 = new ThreadDownloadImageData((File)null, String.format("http://skins.minecraft.net/MinecraftSkins/%s.png", StringUtils.stripControlCodes(var1)), DefaultPlayerSkin.getDefaultSkin(getOfflineUUID(var1)), new ImageBufferDownload());
         var2.loadTexture(var0, (ITextureObject)var3);
      }

      return (ThreadDownloadImageData)var3;
   }

   public boolean hasElytraCape() {
      ResourceLocation var1 = this.getLocationCape();
      if (var1 == null) {
         return false;
      } else {
         return var1 == this.locationOfCape ? this.elytraOfCape : true;
      }
   }

   public boolean hasPlayerInfo() {
      return this.getPlayerInfo() != null;
   }

   public ResourceLocation getLocationOfCape() {
      return this.locationOfCape;
   }

   public String getNameClear() {
      return this.nameClear;
   }

   public ResourceLocation getLocationSkin() {
      NetworkPlayerInfo var1 = this.getPlayerInfo();
      return var1 == null ? DefaultPlayerSkin.getDefaultSkin(this.getUniqueID()) : var1.getLocationSkin();
   }

   public void setReloadCapeTimeMs(long var1) {
      this.reloadCapeTimeMs = var1;
   }

   public Vec3 getLook(float var1) {
      return this.getVectorForRotation(this.rotationPitch, this.rotationYaw);
   }

   public void setLocationOfAresCape(ResourceLocation var1) {
      this.locationOfAresCape = var1;
   }

   public ResourceLocation getLocationOptifineCape() {
      return this.locationOptifineCape != null ? this.locationOptifineCape : this.locationOptifineCape;
   }
}
