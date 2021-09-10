package net.optifine.entity.model.anim;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import net.optifine.expr.ExpressionType;
import net.optifine.expr.IExpressionFloat;

public enum RenderEntityParameterFloat implements IExpressionFloat {
   HEALTH("health"),
   AGE("age"),
   MAX_HEALTH("max_health"),
   LIMB_SWING("limb_swing");

   private static final RenderEntityParameterFloat[] VALUES = values();
   PARTIAL_TICKS("partial_ticks"),
   HEAD_YAW("head_yaw"),
   HURT_TIME("hurt_time"),
   SCALE("scale"),
   LIMB_SWING_SPEED("limb_speed"),
   HEAD_PITCH("head_pitch"),
   REVENGE_TIME("revenge_time"),
   MOVE_STRAFING("move_strafing");

   private String name;
   private static int[] $SWITCH_TABLE$net$optifine$entity$model$anim$RenderEntityParameterFloat;
   MOVE_FORWARD("move_forward"),
   POS_X("pos_x"),
   SWING_PROGRESS("swing_progress");

   private static final RenderEntityParameterFloat[] ENUM$VALUES = new RenderEntityParameterFloat[]{LIMB_SWING, LIMB_SWING_SPEED, AGE, HEAD_YAW, HEAD_PITCH, SCALE, HEALTH, HURT_TIME, IDLE_TIME, MAX_HEALTH, MOVE_FORWARD, MOVE_STRAFING, PARTIAL_TICKS, POS_X, POS_Y, POS_Z, REVENGE_TIME, SWING_PROGRESS};
   POS_Y("pos_Y"),
   IDLE_TIME("idle_time"),
   POS_Z("pos_Z");

   private RenderManager renderManager;

   static int[] $SWITCH_TABLE$net$optifine$entity$model$anim$RenderEntityParameterFloat() {
      int[] var10000 = $SWITCH_TABLE$net$optifine$entity$model$anim$RenderEntityParameterFloat;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[values().length];

         try {
            var0[AGE.ordinal()] = 3;
         } catch (NoSuchFieldError var18) {
         }

         try {
            var0[HEAD_PITCH.ordinal()] = 5;
         } catch (NoSuchFieldError var17) {
         }

         try {
            var0[HEAD_YAW.ordinal()] = 4;
         } catch (NoSuchFieldError var16) {
         }

         try {
            var0[HEALTH.ordinal()] = 7;
         } catch (NoSuchFieldError var15) {
         }

         try {
            var0[HURT_TIME.ordinal()] = 8;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[IDLE_TIME.ordinal()] = 9;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[LIMB_SWING.ordinal()] = 1;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[LIMB_SWING_SPEED.ordinal()] = 2;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[MAX_HEALTH.ordinal()] = 10;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[MOVE_FORWARD.ordinal()] = 11;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[MOVE_STRAFING.ordinal()] = 12;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[PARTIAL_TICKS.ordinal()] = 13;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[POS_X.ordinal()] = 14;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[POS_Y.ordinal()] = 15;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[POS_Z.ordinal()] = 16;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[REVENGE_TIME.ordinal()] = 17;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[SCALE.ordinal()] = 6;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[SWING_PROGRESS.ordinal()] = 18;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$optifine$entity$model$anim$RenderEntityParameterFloat = var0;
         return var0;
      }
   }

   public static RenderEntityParameterFloat parse(String var0) {
      if (var0 == null) {
         return null;
      } else {
         for(int var1 = 0; var1 < VALUES.length; ++var1) {
            RenderEntityParameterFloat var2 = VALUES[var1];
            if (var2.getName().equals(var0)) {
               return var2;
            }
         }

         return null;
      }
   }

   private RenderEntityParameterFloat(String var3) {
      this.name = var3;
      this.renderManager = Minecraft.getMinecraft().getRenderManager();
   }

   public String getName() {
      return this.name;
   }

   public float eval() {
      Render var1 = this.renderManager.renderRender;
      if (var1 == null) {
         return 0.0F;
      } else {
         if (var1 instanceof RendererLivingEntity) {
            RendererLivingEntity var2 = (RendererLivingEntity)var1;
            switch($SWITCH_TABLE$net$optifine$entity$model$anim$RenderEntityParameterFloat()[this.ordinal()]) {
            case 1:
               return var2.renderLimbSwing;
            case 2:
               return var2.renderLimbSwingAmount;
            case 3:
               return var2.renderAgeInTicks;
            case 4:
               return var2.renderHeadYaw;
            case 5:
               return var2.renderHeadPitch;
            case 6:
               return var2.renderScaleFactor;
            default:
               EntityLivingBase var3 = var2.renderEntity;
               if (var3 == null) {
                  return 0.0F;
               }

               switch($SWITCH_TABLE$net$optifine$entity$model$anim$RenderEntityParameterFloat()[this.ordinal()]) {
               case 7:
                  return var3.getHealth();
               case 8:
                  return (float)var3.hurtTime;
               case 9:
                  return (float)var3.getAge();
               case 10:
                  return var3.getMaxHealth();
               case 11:
                  return var3.moveForward;
               case 12:
                  return var3.moveStrafing;
               case 13:
               default:
                  break;
               case 14:
                  return (float)var3.posX;
               case 15:
                  return (float)var3.posY;
               case 16:
                  return (float)var3.posZ;
               case 17:
                  return (float)var3.getRevengeTimer();
               case 18:
                  return var3.getSwingProgress(var2.renderPartialTicks);
               }
            }
         }

         return 0.0F;
      }
   }

   public ExpressionType getExpressionType() {
      return ExpressionType.FLOAT;
   }
}
