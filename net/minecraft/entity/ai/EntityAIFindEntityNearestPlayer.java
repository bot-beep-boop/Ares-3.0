package net.minecraft.entity.ai;

import com.google.common.base.Predicate;
import java.util.Collections;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.scoreboard.Team;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityAIFindEntityNearestPlayer extends EntityAIBase {
   private final EntityAINearestAttackableTarget.Sorter sorter;
   private EntityLiving entityLiving;
   private static final Logger LOGGER = LogManager.getLogger();
   private EntityLivingBase entityTarget;
   private final Predicate<Entity> predicate;

   static EntityLiving access$0(EntityAIFindEntityNearestPlayer var0) {
      return var0.entityLiving;
   }

   public boolean shouldExecute() {
      double var1 = this.maxTargetRange();
      List var3 = this.entityLiving.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.entityLiving.getEntityBoundingBox().expand(var1, 4.0D, var1), this.predicate);
      Collections.sort(var3, this.sorter);
      if (var3.isEmpty()) {
         return false;
      } else {
         this.entityTarget = (EntityLivingBase)var3.get(0);
         return true;
      }
   }

   protected double maxTargetRange() {
      IAttributeInstance var1 = this.entityLiving.getEntityAttribute(SharedMonsterAttributes.followRange);
      return var1 == null ? 16.0D : var1.getAttributeValue();
   }

   public EntityAIFindEntityNearestPlayer(EntityLiving var1) {
      this.entityLiving = var1;
      if (var1 instanceof EntityCreature) {
         LOGGER.warn("Use NearestAttackableTargetGoal.class for PathfinerMob mobs!");
      }

      this.predicate = new Predicate<Entity>(this) {
         final EntityAIFindEntityNearestPlayer this$0;

         public boolean apply(Entity var1) {
            if (!(var1 instanceof EntityPlayer)) {
               return false;
            } else if (((EntityPlayer)var1).capabilities.disableDamage) {
               return false;
            } else {
               double var2 = this.this$0.maxTargetRange();
               if (var1.isSneaking()) {
                  var2 *= 0.800000011920929D;
               }

               if (var1.isInvisible()) {
                  float var4 = ((EntityPlayer)var1).getArmorVisibility();
                  if (var4 < 0.1F) {
                     var4 = 0.1F;
                  }

                  var2 *= (double)(0.7F * var4);
               }

               return (double)var1.getDistanceToEntity(EntityAIFindEntityNearestPlayer.access$0(this.this$0)) > var2 ? false : EntityAITarget.isSuitableTarget(EntityAIFindEntityNearestPlayer.access$0(this.this$0), (EntityLivingBase)var1, false, true);
            }
         }

         {
            this.this$0 = var1;
         }

         public boolean apply(Object var1) {
            return this.apply((Entity)var1);
         }
      };
      this.sorter = new EntityAINearestAttackableTarget.Sorter(var1);
   }

   public void startExecuting() {
      this.entityLiving.setAttackTarget(this.entityTarget);
      super.startExecuting();
   }

   public boolean continueExecuting() {
      EntityLivingBase var1 = this.entityLiving.getAttackTarget();
      if (var1 == null) {
         return false;
      } else if (!var1.isEntityAlive()) {
         return false;
      } else if (var1 instanceof EntityPlayer && ((EntityPlayer)var1).capabilities.disableDamage) {
         return false;
      } else {
         Team var2 = this.entityLiving.getTeam();
         Team var3 = var1.getTeam();
         if (var2 != null && var3 == var2) {
            return false;
         } else {
            double var4 = this.maxTargetRange();
            if (this.entityLiving.getDistanceSqToEntity(var1) > var4 * var4) {
               return false;
            } else {
               return !(var1 instanceof EntityPlayerMP) || !((EntityPlayerMP)var1).theItemInWorldManager.isCreative();
            }
         }
      }
   }

   public void resetTask() {
      this.entityLiving.setAttackTarget((EntityLivingBase)null);
      super.startExecuting();
   }
}
