package net.minecraft.client.renderer.entity;

import com.google.common.collect.Lists;
import java.nio.FloatBuffer;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Team;
import net.minecraft.src.Config;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.optifine.EmissiveTextures;
import net.optifine.entity.model.CustomEntityModels;
import net.optifine.reflect.Reflector;
import net.optifine.shaders.Shaders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;

public abstract class RendererLivingEntity<T extends EntityLivingBase> extends Render<T> {
   public ModelBase mainModel;
   public float renderScaleFactor;
   public static final boolean animateModelLiving = Boolean.getBoolean("animate.model.living");
   public EntityLivingBase renderEntity;
   protected boolean renderOutlines = false;
   protected List<LayerRenderer<T>> layerRenderers = Lists.newArrayList();
   public float renderPartialTicks;
   public float renderLimbSwing;
   private boolean renderModelPushMatrix;
   private static final DynamicTexture textureBrightness = new DynamicTexture(16, 16);
   public float renderHeadPitch;
   public static float NAME_TAG_RANGE_SNEAK = 32.0F;
   public static float NAME_TAG_RANGE = 64.0F;
   protected FloatBuffer brightnessBuffer = GLAllocation.createDirectFloatBuffer(4);
   public float renderAgeInTicks;
   public float renderHeadYaw;
   private static int[] $SWITCH_TABLE$net$minecraft$scoreboard$Team$EnumVisible;
   private boolean renderLayersPushMatrix;
   private static final Logger logger = LogManager.getLogger();
   public float renderLimbSwingAmount;

   public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
      this.doRender((EntityLivingBase)var1, var2, var4, var6, var8, var9);
   }

   protected boolean setDoRenderBrightness(T var1, float var2) {
      return this.setBrightness(var1, var2, true);
   }

   public void renderName(Entity var1, double var2, double var4, double var6) {
      this.renderName((EntityLivingBase)var1, var2, var4, var6);
   }

   public void transformHeldFull3DItemLayer() {
   }

   protected boolean setScoreTeamColor(T var1) {
      int var2 = 16777215;
      if (var1 instanceof EntityPlayer) {
         ScorePlayerTeam var3 = (ScorePlayerTeam)var1.getTeam();
         if (var3 != null) {
            String var4 = FontRenderer.getFormatFromString(var3.getColorPrefix());
            if (var4.length() >= 2) {
               var2 = this.getFontRendererFromRenderManager().getColorCode(var4.charAt(1));
            }
         }
      }

      float var6 = (float)(var2 >> 16 & 255) / 255.0F;
      float var7 = (float)(var2 >> 8 & 255) / 255.0F;
      float var5 = (float)(var2 & 255) / 255.0F;
      GlStateManager.disableLighting();
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
      GlStateManager.color(var6, var7, var5, 1.0F);
      GlStateManager.disableTexture2D();
      GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
      GlStateManager.disableTexture2D();
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
      return true;
   }

   protected float interpolateRotation(float var1, float var2, float var3) {
      float var4;
      for(var4 = var2 - var1; var4 < -180.0F; var4 += 360.0F) {
      }

      while(var4 >= 180.0F) {
         var4 -= 360.0F;
      }

      return var1 + var3 * var4;
   }

   protected boolean setBrightness(T var1, float var2, boolean var3) {
      float var4 = var1.getBrightness(var2);
      int var5 = this.getColorMultiplier(var1, var4, var2);
      boolean var6 = (var5 >> 24 & 255) > 0;
      boolean var7 = var1.hurtTime > 0 || var1.deathTime > 0;
      if (!var6 && !var7) {
         return false;
      } else if (!var6 && !var3) {
         return false;
      } else {
         GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
         GlStateManager.enableTexture2D();
         GL11.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, 8448);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.defaultTexUnit);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PRIMARY_COLOR);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 7681);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.defaultTexUnit);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
         GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
         GlStateManager.enableTexture2D();
         GL11.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, OpenGlHelper.GL_INTERPOLATE);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.GL_CONSTANT);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PREVIOUS);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE2_RGB, OpenGlHelper.GL_CONSTANT);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND2_RGB, 770);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 7681);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.GL_PREVIOUS);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
         this.brightnessBuffer.position(0);
         if (var7) {
            this.brightnessBuffer.put(1.0F);
            this.brightnessBuffer.put(0.0F);
            this.brightnessBuffer.put(0.0F);
            this.brightnessBuffer.put(0.3F);
            if (Config.isShaders()) {
               Shaders.setEntityColor(1.0F, 0.0F, 0.0F, 0.3F);
            }
         } else {
            float var8 = (float)(var5 >> 24 & 255) / 255.0F;
            float var9 = (float)(var5 >> 16 & 255) / 255.0F;
            float var10 = (float)(var5 >> 8 & 255) / 255.0F;
            float var11 = (float)(var5 & 255) / 255.0F;
            this.brightnessBuffer.put(var9);
            this.brightnessBuffer.put(var10);
            this.brightnessBuffer.put(var11);
            this.brightnessBuffer.put(1.0F - var8);
            if (Config.isShaders()) {
               Shaders.setEntityColor(var9, var10, var11, 1.0F - var8);
            }
         }

         this.brightnessBuffer.flip();
         GL11.glTexEnv(8960, 8705, this.brightnessBuffer);
         GlStateManager.setActiveTexture(OpenGlHelper.GL_TEXTURE2);
         GlStateManager.enableTexture2D();
         GlStateManager.bindTexture(textureBrightness.getGlTextureId());
         GL11.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, 8448);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.GL_PREVIOUS);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.lightmapTexUnit);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 7681);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.GL_PREVIOUS);
         GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
         GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
         return true;
      }
   }

   protected void rotateCorpse(T var1, float var2, float var3, float var4) {
      GlStateManager.rotate(180.0F - var3, 0.0F, 1.0F, 0.0F);
      if (var1.deathTime > 0) {
         float var5 = ((float)var1.deathTime + var4 - 1.0F) / 20.0F * 1.6F;
         var5 = MathHelper.sqrt_float(var5);
         if (var5 > 1.0F) {
            var5 = 1.0F;
         }

         GlStateManager.rotate(var5 * this.getDeathMaxRotation(var1), 0.0F, 0.0F, 1.0F);
      } else {
         String var6 = EnumChatFormatting.getTextWithoutFormattingCodes(var1.getName());
         if (var6 != null && (var6.equals("Dinnerbone") || var6.equals("Grumm")) && !(var1 instanceof EntityPlayer)) {
            GlStateManager.translate(0.0F, var1.height + 0.1F, 0.0F);
            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
         }
      }

   }

   protected void renderModel(T var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      boolean var8 = !var1.isInvisible();
      boolean var9 = !var8 && !var1.isInvisibleToPlayer(Minecraft.getMinecraft().thePlayer);
      if (var8 || var9) {
         if (!this.bindEntityTexture(var1)) {
            return;
         }

         if (var9) {
            GlStateManager.pushMatrix();
            GlStateManager.color(1.0F, 1.0F, 1.0F, 0.15F);
            GlStateManager.depthMask(false);
            GlStateManager.enableBlend();
            GlStateManager.blendFunc(770, 771);
            GlStateManager.alphaFunc(516, 0.003921569F);
         }

         this.mainModel.render(var1, var2, var3, var4, var5, var6, var7);
         if (var9) {
            GlStateManager.disableBlend();
            GlStateManager.alphaFunc(516, 0.1F);
            GlStateManager.popMatrix();
            GlStateManager.depthMask(true);
         }
      }

   }

   protected void renderLayers(T var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      Iterator var10 = this.layerRenderers.iterator();

      while(var10.hasNext()) {
         LayerRenderer var9 = (LayerRenderer)var10.next();
         boolean var11 = this.setBrightness(var1, var4, var9.shouldCombineTextures());
         if (EmissiveTextures.isActive()) {
            EmissiveTextures.beginRender();
         }

         if (this.renderLayersPushMatrix) {
            GlStateManager.pushMatrix();
         }

         var9.doRenderLayer(var1, var2, var3, var4, var5, var6, var7, var8);
         if (this.renderLayersPushMatrix) {
            GlStateManager.popMatrix();
         }

         if (EmissiveTextures.isActive()) {
            if (EmissiveTextures.hasEmissive()) {
               this.renderLayersPushMatrix = true;
               EmissiveTextures.beginRenderEmissive();
               GlStateManager.pushMatrix();
               var9.doRenderLayer(var1, var2, var3, var4, var5, var6, var7, var8);
               GlStateManager.popMatrix();
               EmissiveTextures.endRenderEmissive();
            }

            EmissiveTextures.endRender();
         }

         if (var11) {
            this.unsetBrightness();
         }
      }

   }

   public List<LayerRenderer<T>> getLayerRenderers() {
      return this.layerRenderers;
   }

   public void setRenderOutlines(boolean var1) {
      this.renderOutlines = var1;
   }

   protected boolean canRenderName(Entity var1) {
      return this.canRenderName((EntityLivingBase)var1);
   }

   protected void preRenderCallback(T var1, float var2) {
   }

   public ModelBase getMainModel() {
      return this.mainModel;
   }

   static int[] $SWITCH_TABLE$net$minecraft$scoreboard$Team$EnumVisible() {
      int[] var10000 = $SWITCH_TABLE$net$minecraft$scoreboard$Team$EnumVisible;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[Team.EnumVisible.values().length];

         try {
            var0[Team.EnumVisible.ALWAYS.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[Team.EnumVisible.HIDE_FOR_OTHER_TEAMS.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[Team.EnumVisible.HIDE_FOR_OWN_TEAM.ordinal()] = 4;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[Team.EnumVisible.NEVER.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$minecraft$scoreboard$Team$EnumVisible = var0;
         return var0;
      }
   }

   public void doRender(T var1, double var2, double var4, double var6, float var8, float var9) {
      if (!Reflector.RenderLivingEvent_Pre_Constructor.exists() || !Reflector.postForgeBusEvent(Reflector.RenderLivingEvent_Pre_Constructor, var1, this, var2, var4, var6)) {
         if (animateModelLiving) {
            var1.limbSwingAmount = 1.0F;
         }

         GlStateManager.pushMatrix();
         GlStateManager.disableCull();
         this.mainModel.swingProgress = this.getSwingProgress(var1, var9);
         this.mainModel.isRiding = var1.isRiding();
         if (Reflector.ForgeEntity_shouldRiderSit.exists()) {
            this.mainModel.isRiding = var1.isRiding() && var1.ridingEntity != null && Reflector.callBoolean(var1.ridingEntity, Reflector.ForgeEntity_shouldRiderSit);
         }

         this.mainModel.isChild = var1.isChild();

         try {
            float var10 = this.interpolateRotation(var1.prevRenderYawOffset, var1.renderYawOffset, var9);
            float var11 = this.interpolateRotation(var1.prevRotationYawHead, var1.rotationYawHead, var9);
            float var12 = var11 - var10;
            float var14;
            if (this.mainModel.isRiding && var1.ridingEntity instanceof EntityLivingBase) {
               EntityLivingBase var13 = (EntityLivingBase)var1.ridingEntity;
               var10 = this.interpolateRotation(var13.prevRenderYawOffset, var13.renderYawOffset, var9);
               var12 = var11 - var10;
               var14 = MathHelper.wrapAngleTo180_float(var12);
               if (var14 < -85.0F) {
                  var14 = -85.0F;
               }

               if (var14 >= 85.0F) {
                  var14 = 85.0F;
               }

               var10 = var11 - var14;
               if (var14 * var14 > 2500.0F) {
                  var10 += var14 * 0.2F;
               }

               var12 = var11 - var10;
            }

            float var20 = var1.prevRotationPitch + (var1.rotationPitch - var1.prevRotationPitch) * var9;
            this.renderLivingAt(var1, var2, var4, var6);
            var14 = this.handleRotationFloat(var1, var9);
            this.rotateCorpse(var1, var14, var10, var9);
            GlStateManager.enableRescaleNormal();
            GlStateManager.scale(-1.0F, -1.0F, 1.0F);
            this.preRenderCallback(var1, var9);
            float var15 = 0.0625F;
            GlStateManager.translate(0.0F, -1.5078125F, 0.0F);
            float var16 = var1.prevLimbSwingAmount + (var1.limbSwingAmount - var1.prevLimbSwingAmount) * var9;
            float var17 = var1.limbSwing - var1.limbSwingAmount * (1.0F - var9);
            if (var1.isChild()) {
               var17 *= 3.0F;
            }

            if (var16 > 1.0F) {
               var16 = 1.0F;
            }

            GlStateManager.enableAlpha();
            this.mainModel.setLivingAnimations(var1, var17, var16, var9);
            this.mainModel.setRotationAngles(var17, var16, var14, var12, var20, 0.0625F, var1);
            if (CustomEntityModels.isActive()) {
               this.renderEntity = var1;
               this.renderLimbSwing = var17;
               this.renderLimbSwingAmount = var16;
               this.renderAgeInTicks = var14;
               this.renderHeadYaw = var12;
               this.renderHeadPitch = var20;
               this.renderScaleFactor = var15;
               this.renderPartialTicks = var9;
            }

            boolean var18;
            if (this.renderOutlines) {
               var18 = this.setScoreTeamColor(var1);
               this.renderModel(var1, var17, var16, var14, var12, var20, 0.0625F);
               if (var18) {
                  this.unsetScoreTeamColor();
               }
            } else {
               var18 = this.setDoRenderBrightness(var1, var9);
               if (EmissiveTextures.isActive()) {
                  EmissiveTextures.beginRender();
               }

               if (this.renderModelPushMatrix) {
                  GlStateManager.pushMatrix();
               }

               this.renderModel(var1, var17, var16, var14, var12, var20, 0.0625F);
               if (this.renderModelPushMatrix) {
                  GlStateManager.popMatrix();
               }

               if (EmissiveTextures.isActive()) {
                  if (EmissiveTextures.hasEmissive()) {
                     this.renderModelPushMatrix = true;
                     EmissiveTextures.beginRenderEmissive();
                     GlStateManager.pushMatrix();
                     this.renderModel(var1, var17, var16, var14, var12, var20, var15);
                     GlStateManager.popMatrix();
                     EmissiveTextures.endRenderEmissive();
                  }

                  EmissiveTextures.endRender();
               }

               if (var18) {
                  this.unsetBrightness();
               }

               GlStateManager.depthMask(true);
               if (!(var1 instanceof EntityPlayer) || !((EntityPlayer)var1).isSpectator()) {
                  this.renderLayers(var1, var17, var16, var9, var14, var12, var20, 0.0625F);
               }
            }

            if (CustomEntityModels.isActive()) {
               this.renderEntity = null;
            }

            GlStateManager.disableRescaleNormal();
         } catch (Exception var19) {
            logger.error("Couldn't render entity", var19);
         }

         GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
         GlStateManager.enableTexture2D();
         GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
         GlStateManager.enableCull();
         GlStateManager.popMatrix();
         if (!this.renderOutlines) {
            super.doRender(var1, var2, var4, var6, var8, var9);
         }

         if (Reflector.RenderLivingEvent_Post_Constructor.exists()) {
            Reflector.postForgeBusEvent(Reflector.RenderLivingEvent_Post_Constructor, var1, this, var2, var4, var6);
         }
      }

   }

   protected float getSwingProgress(T var1, float var2) {
      return var1.getSwingProgress(var2);
   }

   public void renderName(T var1, double var2, double var4, double var6) {
      if (!Reflector.RenderLivingEvent_Specials_Pre_Constructor.exists() || !Reflector.postForgeBusEvent(Reflector.RenderLivingEvent_Specials_Pre_Constructor, var1, this, var2, var4, var6)) {
         if (this.canRenderName(var1)) {
            double var8 = var1.getDistanceSqToEntity(this.renderManager.livingPlayer);
            float var10 = var1.isSneaking() ? NAME_TAG_RANGE_SNEAK : NAME_TAG_RANGE;
            if (var8 < (double)(var10 * var10)) {
               String var11 = var1.getDisplayName().getFormattedText();
               float var12 = 0.02666667F;
               GlStateManager.alphaFunc(516, 0.1F);
               if (var1.isSneaking()) {
                  FontRenderer var13 = this.getFontRendererFromRenderManager();
                  GlStateManager.pushMatrix();
                  GlStateManager.translate((float)var2, (float)var4 + var1.height + 0.5F - (var1.isChild() ? var1.height / 2.0F : 0.0F), (float)var6);
                  GL11.glNormal3f(0.0F, 1.0F, 0.0F);
                  GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
                  GlStateManager.rotate(this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
                  GlStateManager.scale(-0.02666667F, -0.02666667F, 0.02666667F);
                  GlStateManager.translate(0.0F, 9.374999F, 0.0F);
                  GlStateManager.disableLighting();
                  GlStateManager.depthMask(false);
                  GlStateManager.enableBlend();
                  GlStateManager.disableTexture2D();
                  GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                  int var14 = var13.getStringWidth(var11) / 2;
                  Tessellator var15 = Tessellator.getInstance();
                  WorldRenderer var16 = var15.getWorldRenderer();
                  var16.begin(7, DefaultVertexFormats.POSITION_COLOR);
                  var16.pos((double)(-var14 - 1), -1.0D, 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
                  var16.pos((double)(-var14 - 1), 8.0D, 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
                  var16.pos((double)(var14 + 1), 8.0D, 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
                  var16.pos((double)(var14 + 1), -1.0D, 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
                  var15.draw();
                  GlStateManager.enableTexture2D();
                  GlStateManager.depthMask(true);
                  var13.drawString(var11, -var13.getStringWidth(var11) / 2, 0, 553648127);
                  GlStateManager.enableLighting();
                  GlStateManager.disableBlend();
                  GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                  GlStateManager.popMatrix();
               } else {
                  this.renderOffsetLivingLabel(var1, var2, var4 - (var1.isChild() ? (double)(var1.height / 2.0F) : 0.0D), var6, var11, 0.02666667F, var8);
               }
            }
         }

         if (Reflector.RenderLivingEvent_Specials_Post_Constructor.exists()) {
            Reflector.postForgeBusEvent(Reflector.RenderLivingEvent_Specials_Post_Constructor, var1, this, var2, var4, var6);
         }
      }

   }

   protected void unsetBrightness() {
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
      GlStateManager.enableTexture2D();
      GL11.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, 8448);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, OpenGlHelper.defaultTexUnit);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PRIMARY_COLOR);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 8448);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, OpenGlHelper.defaultTexUnit);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_ALPHA, OpenGlHelper.GL_PRIMARY_COLOR);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_ALPHA, 770);
      GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
      GL11.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, 8448);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, 5890);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PREVIOUS);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 8448);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, 5890);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.setActiveTexture(OpenGlHelper.GL_TEXTURE2);
      GlStateManager.disableTexture2D();
      GlStateManager.bindTexture(0);
      GL11.glTexEnvi(8960, 8704, OpenGlHelper.GL_COMBINE);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_RGB, 8448);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_RGB, 768);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND1_RGB, 768);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_RGB, 5890);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE1_RGB, OpenGlHelper.GL_PREVIOUS);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_COMBINE_ALPHA, 8448);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_OPERAND0_ALPHA, 770);
      GL11.glTexEnvi(8960, OpenGlHelper.GL_SOURCE0_ALPHA, 5890);
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
      if (Config.isShaders()) {
         Shaders.setEntityColor(0.0F, 0.0F, 0.0F, 0.0F);
      }

   }

   protected void unsetScoreTeamColor() {
      GlStateManager.enableLighting();
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
      GlStateManager.enableTexture2D();
      GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
      GlStateManager.enableTexture2D();
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
   }

   protected boolean canRenderName(T var1) {
      EntityPlayerSP var2 = Minecraft.getMinecraft().thePlayer;
      if (var1 instanceof EntityPlayer) {
         Team var3 = var1.getTeam();
         Team var4 = var2.getTeam();
         if (var3 != null) {
            Team.EnumVisible var5 = var3.getNameTagVisibility();
            switch($SWITCH_TABLE$net$minecraft$scoreboard$Team$EnumVisible()[var5.ordinal()]) {
            case 1:
               return true;
            case 2:
               return false;
            case 3:
               if (var4 != null && !var3.isSameTeam(var4)) {
                  return false;
               }

               return true;
            case 4:
               if (var4 != null && var3.isSameTeam(var4)) {
                  return false;
               }

               return true;
            default:
               return true;
            }
         }
      }

      return Minecraft.isGuiEnabled() && !var1.isInvisibleToPlayer(var2) && var1.riddenByEntity == null;
   }

   protected void renderLivingAt(T var1, double var2, double var4, double var6) {
      GlStateManager.translate((float)var2, (float)var4, (float)var6);
   }

   protected <V extends EntityLivingBase, U extends LayerRenderer<V>> boolean removeLayer(U var1) {
      return this.layerRenderers.remove(var1);
   }

   public <V extends EntityLivingBase, U extends LayerRenderer<V>> boolean addLayer(U var1) {
      return this.layerRenderers.add(var1);
   }

   public RendererLivingEntity(RenderManager var1, ModelBase var2, float var3) {
      super(var1);
      this.mainModel = var2;
      this.shadowSize = var3;
      this.renderModelPushMatrix = this.mainModel instanceof ModelSpider;
   }

   protected int getColorMultiplier(T var1, float var2, float var3) {
      return 0;
   }

   protected float handleRotationFloat(T var1, float var2) {
      return (float)var1.ticksExisted + var2;
   }

   protected float getDeathMaxRotation(T var1) {
      return 90.0F;
   }

   static {
      int[] var0 = textureBrightness.getTextureData();

      for(int var1 = 0; var1 < 256; ++var1) {
         var0[var1] = -1;
      }

      textureBrightness.updateDynamicTexture();
   }
}
