package net.minecraft.entity.ai;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.Vec3;

public class EntityAIAvoidEntity<T extends Entity> extends EntityAIBase {
   private PathNavigate entityPathNavigate;
   protected EntityCreature theEntity;
   private double farSpeed;
   private float avoidDistance;
   private final Predicate<Entity> canBeSeenSelector;
   private PathEntity entityPathEntity;
   private Predicate<? super T> avoidTargetSelector;
   protected T closestLivingEntity;
   private double nearSpeed;
   private Class<T> classToAvoid;

   public boolean continueExecuting() {
      return !this.entityPathNavigate.noPath();
   }

   public void startExecuting() {
      this.entityPathNavigate.setPath(this.entityPathEntity, this.farSpeed);
   }

   public EntityAIAvoidEntity(EntityCreature var1, Class<T> var2, Predicate<? super T> var3, float var4, double var5, double var7) {
      this.canBeSeenSelector = new Predicate<Entity>(this) {
         final EntityAIAvoidEntity this$0;

         public boolean apply(Entity var1) {
            return var1.isEntityAlive() && this.this$0.theEntity.getEntitySenses().canSee(var1);
         }

         public boolean apply(Object var1) {
            return this.apply((Entity)var1);
         }

         {
            this.this$0 = var1;
         }
      };
      this.theEntity = var1;
      this.classToAvoid = var2;
      this.avoidTargetSelector = var3;
      this.avoidDistance = var4;
      this.farSpeed = var5;
      this.nearSpeed = var7;
      this.entityPathNavigate = var1.getNavigator();
      this.setMutexBits(1);
   }

   public void resetTask() {
      this.closestLivingEntity = null;
   }

   public void updateTask() {
      if (this.theEntity.getDistanceSqToEntity(this.closestLivingEntity) < 49.0D) {
         this.theEntity.getNavigator().setSpeed(this.nearSpeed);
      } else {
         this.theEntity.getNavigator().setSpeed(this.farSpeed);
      }

   }

   public boolean shouldExecute() {
      List var1 = this.theEntity.worldObj.getEntitiesWithinAABB(this.classToAvoid, this.theEntity.getEntityBoundingBox().expand((double)this.avoidDistance, 3.0D, (double)this.avoidDistance), Predicates.and(new Predicate[]{EntitySelectors.NOT_SPECTATING, this.canBeSeenSelector, this.avoidTargetSelector}));
      if (var1.isEmpty()) {
         return false;
      } else {
         this.closestLivingEntity = (Entity)var1.get(0);
         Vec3 var2 = RandomPositionGenerator.findRandomTargetBlockAwayFrom(this.theEntity, 16, 7, new Vec3(this.closestLivingEntity.posX, this.closestLivingEntity.posY, this.closestLivingEntity.posZ));
         if (var2 == null) {
            return false;
         } else if (this.closestLivingEntity.getDistanceSq(var2.xCoord, var2.yCoord, var2.zCoord) < this.closestLivingEntity.getDistanceSqToEntity(this.theEntity)) {
            return false;
         } else {
            this.entityPathEntity = this.entityPathNavigate.getPathToXYZ(var2.xCoord, var2.yCoord, var2.zCoord);
            return this.entityPathEntity == null ? false : this.entityPathEntity.isDestinationSame(var2);
         }
      }
   }

   public EntityAIAvoidEntity(EntityCreature var1, Class<T> var2, float var3, double var4, double var6) {
      this(var1, var2, Predicates.alwaysTrue(), var3, var4, var6);
   }
}
