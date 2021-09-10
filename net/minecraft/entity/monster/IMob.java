package net.minecraft.entity.monster;

import com.google.common.base.Predicate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.IAnimals;

public interface IMob extends IAnimals {
   Predicate<Entity> VISIBLE_MOB_SELECTOR = new Predicate<Entity>() {
      public boolean apply(Entity var1) {
         return var1 instanceof IMob && !var1.isInvisible();
      }

      public boolean apply(Object var1) {
         return this.apply((Entity)var1);
      }
   };
   Predicate<Entity> mobSelector = new Predicate<Entity>() {
      public boolean apply(Object var1) {
         return this.apply((Entity)var1);
      }

      public boolean apply(Entity var1) {
         return var1 instanceof IMob;
      }
   };
}
