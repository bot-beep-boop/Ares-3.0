package net.optifine.entity.model.anim;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import net.optifine.expr.ExpressionType;
import net.optifine.expr.IExpressionBool;

public enum RenderEntityParameterBool implements IExpressionBool {
   IS_IN_LAVA("is_in_lava"),
   IS_CHILD("is_child"),
   IS_HURT("is_hurt"),
   IS_IN_WATER("is_in_water");

   private RenderManager renderManager;
   IS_RIDDEN("is_ridden"),
   IS_ALIVE("is_alive"),
   IS_SNEAKING("is_sneaking"),
   IS_ON_GROUND("is_on_ground");

   private String name;
   IS_WET("is_wet");

   private static final RenderEntityParameterBool[] VALUES = values();
   private static final RenderEntityParameterBool[] ENUM$VALUES = new RenderEntityParameterBool[]{IS_ALIVE, IS_BURNING, IS_CHILD, IS_GLOWING, IS_HURT, IS_IN_LAVA, IS_IN_WATER, IS_INVISIBLE, IS_ON_GROUND, IS_RIDDEN, IS_RIDING, IS_SNEAKING, IS_SPRINTING, IS_WET};
   private static int[] $SWITCH_TABLE$net$optifine$entity$model$anim$RenderEntityParameterBool;
   IS_RIDING("is_riding"),
   IS_SPRINTING("is_sprinting"),
   IS_INVISIBLE("is_invisible"),
   IS_GLOWING("is_glowing"),
   IS_BURNING("is_burning");

   public static RenderEntityParameterBool parse(String var0) {
      if (var0 == null) {
         return null;
      } else {
         for(int var1 = 0; var1 < VALUES.length; ++var1) {
            RenderEntityParameterBool var2 = VALUES[var1];
            if (var2.getName().equals(var0)) {
               return var2;
            }
         }

         return null;
      }
   }

   public ExpressionType getExpressionType() {
      return ExpressionType.BOOL;
   }

   static int[] $SWITCH_TABLE$net$optifine$entity$model$anim$RenderEntityParameterBool() {
      int[] var10000 = $SWITCH_TABLE$net$optifine$entity$model$anim$RenderEntityParameterBool;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[values().length];

         try {
            var0[IS_ALIVE.ordinal()] = 1;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[IS_BURNING.ordinal()] = 2;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[IS_CHILD.ordinal()] = 3;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[IS_GLOWING.ordinal()] = 4;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[IS_HURT.ordinal()] = 5;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[IS_INVISIBLE.ordinal()] = 8;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[IS_IN_LAVA.ordinal()] = 6;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[IS_IN_WATER.ordinal()] = 7;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[IS_ON_GROUND.ordinal()] = 9;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[IS_RIDDEN.ordinal()] = 10;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[IS_RIDING.ordinal()] = 11;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[IS_SNEAKING.ordinal()] = 12;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[IS_SPRINTING.ordinal()] = 13;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[IS_WET.ordinal()] = 14;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$optifine$entity$model$anim$RenderEntityParameterBool = var0;
         return var0;
      }
   }

   private RenderEntityParameterBool(String var3) {
      this.name = var3;
      this.renderManager = Minecraft.getMinecraft().getRenderManager();
   }

   public String getName() {
      return this.name;
   }

   public boolean eval() {
      Render var1 = this.renderManager.renderRender;
      if (var1 == null) {
         return false;
      } else {
         if (var1 instanceof RendererLivingEntity) {
            RendererLivingEntity var2 = (RendererLivingEntity)var1;
            EntityLivingBase var3 = var2.renderEntity;
            if (var3 == null) {
               return false;
            }

            switch($SWITCH_TABLE$net$optifine$entity$model$anim$RenderEntityParameterBool()[this.ordinal()]) {
            case 1:
               return var3.isEntityAlive();
            case 2:
               return var3.isBurning();
            case 3:
               return var3.isChild();
            case 4:
            default:
               break;
            case 5:
               if (var3.hurtTime > 0) {
                  return true;
               }

               return false;
            case 6:
               return var3.isInLava();
            case 7:
               return var3.isInWater();
            case 8:
               return var3.isInvisible();
            case 9:
               return var3.onGround;
            case 10:
               if (var3.riddenByEntity != null) {
                  return true;
               }

               return false;
            case 11:
               return var3.isRiding();
            case 12:
               return var3.isSneaking();
            case 13:
               return var3.isSprinting();
            case 14:
               return var3.isWet();
            }
         }

         return false;
      }
   }
}
