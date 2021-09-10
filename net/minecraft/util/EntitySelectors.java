package net.minecraft.util;

import com.google.common.base.Predicate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public final class EntitySelectors {
   public static final Predicate<Entity> selectAnything = new Predicate<Entity>() {
      public boolean apply(Object var1) {
         return this.apply((Entity)var1);
      }

      public boolean apply(Entity var1) {
         return var1.isEntityAlive();
      }
   };
   public static final Predicate<Entity> NOT_SPECTATING = new Predicate<Entity>() {
      public boolean apply(Object var1) {
         return this.apply((Entity)var1);
      }

      public boolean apply(Entity var1) {
         return !(var1 instanceof EntityPlayer) || !((EntityPlayer)var1).isSpectator();
      }
   };
   public static final Predicate<Entity> selectInventories = new Predicate<Entity>() {
      public boolean apply(Entity var1) {
         return var1 instanceof IInventory && var1.isEntityAlive();
      }

      public boolean apply(Object var1) {
         return this.apply((Entity)var1);
      }
   };
   public static final Predicate<Entity> IS_STANDALONE = new Predicate<Entity>() {
      public boolean apply(Object var1) {
         return this.apply((Entity)var1);
      }

      public boolean apply(Entity var1) {
         return var1.isEntityAlive() && var1.riddenByEntity == null && var1.ridingEntity == null;
      }
   };

   public static class ArmoredMob implements Predicate<Entity> {
      private final ItemStack armor;

      public boolean apply(Entity var1) {
         if (!var1.isEntityAlive()) {
            return false;
         } else if (!(var1 instanceof EntityLivingBase)) {
            return false;
         } else {
            EntityLivingBase var2 = (EntityLivingBase)var1;
            if (var2.getEquipmentInSlot(EntityLiving.getArmorPosition(this.armor)) != null) {
               return false;
            } else if (var2 instanceof EntityLiving) {
               return ((EntityLiving)var2).canPickUpLoot();
            } else {
               return var2 instanceof EntityArmorStand ? true : var2 instanceof EntityPlayer;
            }
         }
      }

      public boolean apply(Object var1) {
         return this.apply((Entity)var1);
      }

      public ArmoredMob(ItemStack var1) {
         this.armor = var1;
      }
   }
}
