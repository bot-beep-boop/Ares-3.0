package net.minecraft.entity.monster;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.world.World;

public abstract class EntityGolem extends EntityCreature implements IAnimals {
   public int getTalkInterval() {
      return 120;
   }

   public EntityGolem(World var1) {
      super(var1);
   }

   protected String getLivingSound() {
      return "none";
   }

   protected String getHurtSound() {
      return "none";
   }

   public void fall(float var1, float var2) {
   }

   protected boolean canDespawn() {
      return false;
   }

   protected String getDeathSound() {
      return "none";
   }
}
