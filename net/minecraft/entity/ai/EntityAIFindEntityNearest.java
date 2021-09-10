package net.minecraft.entity.ai;

import com.google.common.base.Predicate;
import java.util.Collections;
import java.util.List;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayerMP;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EntityAIFindEntityNearest extends EntityAIBase {
   private EntityLiving mob;
   private static final Logger LOGGER = LogManager.getLogger();
   private final Predicate<EntityLivingBase> field_179443_c;
   private Class<? extends EntityLivingBase> field_179439_f;
   private EntityLivingBase target;
   private final EntityAINearestAttackableTarget.Sorter field_179440_d;

   public EntityAIFindEntityNearest(EntityLiving var1, Class<? extends EntityLivingBase> var2) {
      this.mob = var1;
      this.field_179439_f = var2;
      if (var1 instanceof EntityCreature) {
         LOGGER.warn("Use NearestAttackableTargetGoal.class for PathfinerMob mobs!");
      }

      this.field_179443_c = new Predicate<EntityLivingBase>(this) {
         final EntityAIFindEntityNearest this$0;

         public boolean apply(Object var1) {
            return this.apply((EntityLivingBase)var1);
         }

         public boolean apply(EntityLivingBase var1) {
            double var2 = this.this$0.getFollowRange();
            if (var1.isSneaking()) {
               var2 *= 0.800000011920929D;
            }

            if (var1.isInvisible()) {
               return false;
            } else {
               return (double)var1.getDistanceToEntity(EntityAIFindEntityNearest.access$0(this.this$0)) > var2 ? false : EntityAITarget.isSuitableTarget(EntityAIFindEntityNearest.access$0(this.this$0), var1, false, true);
            }
         }

         {
            this.this$0 = var1;
         }
      };
      this.field_179440_d = new EntityAINearestAttackableTarget.Sorter(var1);
   }

   protected double getFollowRange() {
      IAttributeInstance var1 = this.mob.getEntityAttribute(SharedMonsterAttributes.followRange);
      return var1 == null ? 16.0D : var1.getAttributeValue();
   }

   public void startExecuting() {
      this.mob.setAttackTarget(this.target);
      super.startExecuting();
   }

   public void resetTask() {
      this.mob.setAttackTarget((EntityLivingBase)null);
      super.startExecuting();
   }

   static EntityLiving access$0(EntityAIFindEntityNearest var0) {
      return var0.mob;
   }

   public boolean shouldExecute() {
      double var1 = this.getFollowRange();
      List var3 = this.mob.worldObj.getEntitiesWithinAABB(this.field_179439_f, this.mob.getEntityBoundingBox().expand(var1, 4.0D, var1), this.field_179443_c);
      Collections.sort(var3, this.field_179440_d);
      if (var3.isEmpty()) {
         return false;
      } else {
         this.target = (EntityLivingBase)var3.get(0);
         return true;
      }
   }

   public boolean continueExecuting() {
      EntityLivingBase var1 = this.mob.getAttackTarget();
      if (var1 == null) {
         return false;
      } else if (!var1.isEntityAlive()) {
         return false;
      } else {
         double var2 = this.getFollowRange();
         if (this.mob.getDistanceSqToEntity(var1) > var2 * var2) {
            return false;
         } else {
            return !(var1 instanceof EntityPlayerMP) || !((EntityPlayerMP)var1).theItemInWorldManager.isCreative();
         }
      }
   }
}
