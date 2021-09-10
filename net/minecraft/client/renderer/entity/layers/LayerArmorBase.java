package net.minecraft.client.renderer.entity.layers;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.CustomItems;
import net.optifine.reflect.Reflector;
import net.optifine.reflect.ReflectorForge;
import net.optifine.shaders.Shaders;
import net.optifine.shaders.ShadersRender;

public abstract class LayerArmorBase<T extends ModelBase> implements LayerRenderer<EntityLivingBase> {
   private final RendererLivingEntity<?> renderer;
   protected static final ResourceLocation ENCHANTED_ITEM_GLINT_RES = new ResourceLocation("textures/misc/enchanted_item_glint.png");
   private boolean skipRenderGlint;
   private float colorG = 1.0F;
   private static final Map<String, ResourceLocation> ARMOR_TEXTURE_RES_MAP = Maps.newHashMap();
   private static int[] $SWITCH_TABLE$net$minecraft$item$ItemArmor$ArmorMaterial;
   protected T modelLeggings;
   private float alpha = 1.0F;
   protected T modelArmor;
   private float colorR = 1.0F;
   private float colorB = 1.0F;

   public LayerArmorBase(RendererLivingEntity<?> var1) {
      this.renderer = var1;
      this.initArmor();
   }

   static int[] $SWITCH_TABLE$net$minecraft$item$ItemArmor$ArmorMaterial() {
      int[] var10000 = $SWITCH_TABLE$net$minecraft$item$ItemArmor$ArmorMaterial;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[ItemArmor.ArmorMaterial.values().length];

         try {
            var0[ItemArmor.ArmorMaterial.CHAIN.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[ItemArmor.ArmorMaterial.DIAMOND.ordinal()] = 5;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[ItemArmor.ArmorMaterial.GOLD.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[ItemArmor.ArmorMaterial.IRON.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[ItemArmor.ArmorMaterial.LEATHER.ordinal()] = 1;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$minecraft$item$ItemArmor$ArmorMaterial = var0;
         return var0;
      }
   }

   private ResourceLocation getArmorResource(ItemArmor var1, boolean var2) {
      return this.getArmorResource(var1, var2, (String)null);
   }

   public ItemStack getCurrentArmor(EntityLivingBase var1, int var2) {
      return var1.getCurrentArmor(var2 - 1);
   }

   public ResourceLocation getArmorResource(Entity var1, ItemStack var2, int var3, String var4) {
      ItemArmor var5 = (ItemArmor)var2.getItem();
      String var6 = var5.getArmorMaterial().getName();
      String var7 = "minecraft";
      int var8 = var6.indexOf(58);
      if (var8 != -1) {
         var7 = var6.substring(0, var8);
         var6 = var6.substring(var8 + 1);
      }

      String var9 = String.format("%s:textures/models/armor/%s_layer_%d%s.png", var7, var6, this.isSlotForLeggings(var3) ? 2 : 1, var4 == null ? "" : String.format("_%s", var4));
      var9 = Reflector.callString(Reflector.ForgeHooksClient_getArmorTexture, var1, var2, var9, var3, var4);
      ResourceLocation var10 = (ResourceLocation)ARMOR_TEXTURE_RES_MAP.get(var9);
      if (var10 == null) {
         var10 = new ResourceLocation(var9);
         ARMOR_TEXTURE_RES_MAP.put(var9, var10);
      }

      return var10;
   }

   protected T getArmorModelHook(EntityLivingBase var1, ItemStack var2, int var3, T var4) {
      return var4;
   }

   public void doRenderLayer(EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.renderLayer(var1, var2, var3, var4, var5, var6, var7, var8, 4);
      this.renderLayer(var1, var2, var3, var4, var5, var6, var7, var8, 3);
      this.renderLayer(var1, var2, var3, var4, var5, var6, var7, var8, 2);
      this.renderLayer(var1, var2, var3, var4, var5, var6, var7, var8, 1);
   }

   private boolean isSlotForLeggings(int var1) {
      return var1 == 2;
   }

   protected abstract void initArmor();

   public boolean shouldCombineTextures() {
      return false;
   }

   private void renderGlint(EntityLivingBase var1, T var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
      if (!Config.isShaders() || !Shaders.isShadowPass) {
         float var10 = (float)var1.ticksExisted + var5;
         this.renderer.bindTexture(ENCHANTED_ITEM_GLINT_RES);
         if (Config.isShaders()) {
            ShadersRender.renderEnchantedGlintBegin();
         }

         GlStateManager.enableBlend();
         GlStateManager.depthFunc(514);
         GlStateManager.depthMask(false);
         float var11 = 0.5F;
         GlStateManager.color(var11, var11, var11, 1.0F);

         for(int var12 = 0; var12 < 2; ++var12) {
            GlStateManager.disableLighting();
            GlStateManager.blendFunc(768, 1);
            float var13 = 0.76F;
            GlStateManager.color(0.5F * var13, 0.25F * var13, 0.8F * var13, 1.0F);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            float var14 = 0.33333334F;
            GlStateManager.scale(var14, var14, var14);
            GlStateManager.rotate(30.0F - (float)var12 * 60.0F, 0.0F, 0.0F, 1.0F);
            GlStateManager.translate(0.0F, var10 * (0.001F + (float)var12 * 0.003F) * 20.0F, 0.0F);
            GlStateManager.matrixMode(5888);
            var2.render(var1, var3, var4, var6, var7, var8, var9);
         }

         GlStateManager.matrixMode(5890);
         GlStateManager.loadIdentity();
         GlStateManager.matrixMode(5888);
         GlStateManager.enableLighting();
         GlStateManager.depthMask(true);
         GlStateManager.depthFunc(515);
         GlStateManager.disableBlend();
         if (Config.isShaders()) {
            ShadersRender.renderEnchantedGlintEnd();
         }
      }

   }

   private void renderLayer(EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9) {
      ItemStack var10 = this.getCurrentArmor(var1, var9);
      if (var10 != null && var10.getItem() instanceof ItemArmor) {
         ItemArmor var11 = (ItemArmor)var10.getItem();
         ModelBase var12 = this.getArmorModel(var9);
         var12.setModelAttributes(this.renderer.getMainModel());
         var12.setLivingAnimations(var1, var2, var3, var4);
         if (Reflector.ForgeHooksClient.exists()) {
            var12 = this.getArmorModelHook(var1, var10, var9, var12);
         }

         this.setModelPartVisible(var12, var9);
         boolean var13 = this.isSlotForLeggings(var9);
         if (!Config.isCustomItems() || !CustomItems.bindCustomArmorTexture(var10, var13 ? 2 : 1, (String)null)) {
            if (Reflector.ForgeHooksClient_getArmorTexture.exists()) {
               this.renderer.bindTexture(this.getArmorResource(var1, var10, var13 ? 2 : 1, (String)null));
            } else {
               this.renderer.bindTexture(this.getArmorResource(var11, var13));
            }
         }

         int var14;
         float var15;
         float var16;
         float var17;
         if (Reflector.ForgeHooksClient_getArmorTexture.exists()) {
            if (ReflectorForge.armorHasOverlay(var11, var10)) {
               var14 = var11.getColor(var10);
               var15 = (float)(var14 >> 16 & 255) / 255.0F;
               var16 = (float)(var14 >> 8 & 255) / 255.0F;
               var17 = (float)(var14 & 255) / 255.0F;
               GlStateManager.color(this.colorR * var15, this.colorG * var16, this.colorB * var17, this.alpha);
               var12.render(var1, var2, var3, var5, var6, var7, var8);
               if (!Config.isCustomItems() || !CustomItems.bindCustomArmorTexture(var10, var13 ? 2 : 1, "overlay")) {
                  this.renderer.bindTexture(this.getArmorResource(var1, var10, var13 ? 2 : 1, "overlay"));
               }
            }

            GlStateManager.color(this.colorR, this.colorG, this.colorB, this.alpha);
            var12.render(var1, var2, var3, var5, var6, var7, var8);
            if (!this.skipRenderGlint && var10.hasEffect() && (!Config.isCustomItems() || !CustomItems.renderCustomArmorEffect(var1, var10, var12, var2, var3, var4, var5, var6, var7, var8))) {
               this.renderGlint(var1, var12, var2, var3, var4, var5, var6, var7, var8);
            }

            return;
         }

         switch($SWITCH_TABLE$net$minecraft$item$ItemArmor$ArmorMaterial()[var11.getArmorMaterial().ordinal()]) {
         case 1:
            var14 = var11.getColor(var10);
            var15 = (float)(var14 >> 16 & 255) / 255.0F;
            var16 = (float)(var14 >> 8 & 255) / 255.0F;
            var17 = (float)(var14 & 255) / 255.0F;
            GlStateManager.color(this.colorR * var15, this.colorG * var16, this.colorB * var17, this.alpha);
            var12.render(var1, var2, var3, var5, var6, var7, var8);
            if (!Config.isCustomItems() || !CustomItems.bindCustomArmorTexture(var10, var13 ? 2 : 1, "overlay")) {
               this.renderer.bindTexture(this.getArmorResource(var11, var13, "overlay"));
            }
         case 2:
         case 3:
         case 4:
         case 5:
            GlStateManager.color(this.colorR, this.colorG, this.colorB, this.alpha);
            var12.render(var1, var2, var3, var5, var6, var7, var8);
         }

         if (!this.skipRenderGlint && var10.isItemEnchanted() && (!Config.isCustomItems() || !CustomItems.renderCustomArmorEffect(var1, var10, var12, var2, var3, var4, var5, var6, var7, var8))) {
            this.renderGlint(var1, var12, var2, var3, var4, var5, var6, var7, var8);
         }
      }

   }

   public T getArmorModel(int var1) {
      return this.isSlotForLeggings(var1) ? this.modelLeggings : this.modelArmor;
   }

   protected abstract void setModelPartVisible(T var1, int var2);

   private ResourceLocation getArmorResource(ItemArmor var1, boolean var2, String var3) {
      String var4 = String.format("textures/models/armor/%s_layer_%d%s.png", var1.getArmorMaterial().getName(), var2 ? 2 : 1, var3 == null ? "" : String.format("_%s", var3));
      ResourceLocation var5 = (ResourceLocation)ARMOR_TEXTURE_RES_MAP.get(var4);
      if (var5 == null) {
         var5 = new ResourceLocation(var4);
         ARMOR_TEXTURE_RES_MAP.put(var4, var5);
      }

      return var5;
   }
}
