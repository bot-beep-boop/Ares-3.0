package net.minecraft.entity.ai;

import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityTameable;

public class EntityAITargetNonTamed<T extends EntityLivingBase> extends EntityAINearestAttackableTarget {
   private EntityTameable theTameable;

   public boolean shouldExecute() {
      return !this.theTameable.isTamed() && super.shouldExecute();
   }

   public EntityAITargetNonTamed(EntityTameable var1, Class<T> var2, boolean var3, Predicate<? super T> var4) {
      super(var1, var2, 10, var3, false, var4);
      this.theTameable = var1;
   }
}
