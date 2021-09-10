package net.optifine.shaders.uniform;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.optifine.expr.ExpressionType;
import net.optifine.expr.IExpressionBool;

public enum ShaderParameterBool implements IExpressionBool {
   IS_SNEAKING("is_sneaking"),
   IS_ALIVE("is_alive"),
   IS_INVISIBLE("is_invisible"),
   IS_HURT("is_hurt"),
   IS_RIDDEN("is_ridden");

   private static final ShaderParameterBool[] VALUES = values();
   IS_IN_WATER("is_in_water");

   private String name;
   IS_ON_GROUND("is_on_ground"),
   IS_WET("is_wet");

   private RenderManager renderManager;
   private static int[] $SWITCH_TABLE$net$optifine$shaders$uniform$ShaderParameterBool;
   IS_CHILD("is_child"),
   IS_GLOWING("is_glowing"),
   IS_BURNING("is_burning"),
   IS_RIDING("is_riding"),
   IS_IN_LAVA("is_in_lava"),
   IS_SPRINTING("is_sprinting");

   private static final ShaderParameterBool[] ENUM$VALUES = new ShaderParameterBool[]{IS_ALIVE, IS_BURNING, IS_CHILD, IS_GLOWING, IS_HURT, IS_IN_LAVA, IS_IN_WATER, IS_INVISIBLE, IS_ON_GROUND, IS_RIDDEN, IS_RIDING, IS_SNEAKING, IS_SPRINTING, IS_WET};

   private ShaderParameterBool(String var3) {
      this.name = var3;
      this.renderManager = Minecraft.getMinecraft().getRenderManager();
   }

   public boolean eval() {
      Entity var1 = Minecraft.getMinecraft().getRenderViewEntity();
      if (var1 instanceof EntityLivingBase) {
         EntityLivingBase var2 = (EntityLivingBase)var1;
         switch($SWITCH_TABLE$net$optifine$shaders$uniform$ShaderParameterBool()[this.ordinal()]) {
         case 1:
            return var2.isEntityAlive();
         case 2:
            return var2.isBurning();
         case 3:
            return var2.isChild();
         case 4:
         default:
            break;
         case 5:
            if (var2.hurtTime > 0) {
               return true;
            }

            return false;
         case 6:
            return var2.isInLava();
         case 7:
            return var2.isInWater();
         case 8:
            return var2.isInvisible();
         case 9:
            return var2.onGround;
         case 10:
            if (var2.riddenByEntity != null) {
               return true;
            }

            return false;
         case 11:
            return var2.isRiding();
         case 12:
            return var2.isSneaking();
         case 13:
            return var2.isSprinting();
         case 14:
            return var2.isWet();
         }
      }

      return false;
   }

   static int[] $SWITCH_TABLE$net$optifine$shaders$uniform$ShaderParameterBool() {
      int[] var10000 = $SWITCH_TABLE$net$optifine$shaders$uniform$ShaderParameterBool;
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

         $SWITCH_TABLE$net$optifine$shaders$uniform$ShaderParameterBool = var0;
         return var0;
      }
   }

   public String getName() {
      return this.name;
   }

   public static ShaderParameterBool parse(String var0) {
      if (var0 == null) {
         return null;
      } else {
         for(int var1 = 0; var1 < VALUES.length; ++var1) {
            ShaderParameterBool var2 = VALUES[var1];
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
}
