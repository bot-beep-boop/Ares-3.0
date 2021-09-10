package net.minecraft.village;

import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;

public class VillageSiege {
   private int field_75533_d;
   private World worldObj;
   private int field_75539_i;
   private int field_75538_h;
   private Village theVillage;
   private int field_75536_c = -1;
   private boolean field_75535_b;
   private int field_75532_g;
   private int field_75534_e;

   private boolean func_75529_b() {
      List var1 = this.worldObj.playerEntities;
      Iterator var2 = var1.iterator();

      Vec3 var11;
      do {
         do {
            do {
               do {
                  do {
                     EntityPlayer var3;
                     do {
                        if (!var2.hasNext()) {
                           return false;
                        }

                        var3 = (EntityPlayer)var2.next();
                     } while(var3.isSpectator());

                     this.theVillage = this.worldObj.getVillageCollection().getNearestVillage(new BlockPos(var3), 1);
                  } while(this.theVillage == null);
               } while(this.theVillage.getNumVillageDoors() < 10);
            } while(this.theVillage.getTicksSinceLastDoorAdding() < 20);
         } while(this.theVillage.getNumVillagers() < 20);

         BlockPos var4 = this.theVillage.getCenter();
         float var5 = (float)this.theVillage.getVillageRadius();
         boolean var6 = false;

         for(int var7 = 0; var7 < 10; ++var7) {
            float var8 = this.worldObj.rand.nextFloat() * 3.1415927F * 2.0F;
            this.field_75532_g = var4.getX() + (int)((double)(MathHelper.cos(var8) * var5) * 0.9D);
            this.field_75538_h = var4.getY();
            this.field_75539_i = var4.getZ() + (int)((double)(MathHelper.sin(var8) * var5) * 0.9D);
            var6 = false;
            Iterator var10 = this.worldObj.getVillageCollection().getVillageList().iterator();

            while(var10.hasNext()) {
               Village var9 = (Village)var10.next();
               if (var9 != this.theVillage && var9.func_179866_a(new BlockPos(this.field_75532_g, this.field_75538_h, this.field_75539_i))) {
                  var6 = true;
                  break;
               }
            }

            if (!var6) {
               break;
            }
         }

         if (var6) {
            return false;
         }

         var11 = this.func_179867_a(new BlockPos(this.field_75532_g, this.field_75538_h, this.field_75539_i));
      } while(var11 == null);

      this.field_75534_e = 0;
      this.field_75533_d = 20;
      return true;
   }

   private Vec3 func_179867_a(BlockPos var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         BlockPos var3 = var1.add(this.worldObj.rand.nextInt(16) - 8, this.worldObj.rand.nextInt(6) - 3, this.worldObj.rand.nextInt(16) - 8);
         if (this.theVillage.func_179866_a(var3) && SpawnerAnimals.canCreatureTypeSpawnAtLocation(EntityLiving.SpawnPlacementType.ON_GROUND, this.worldObj, var3)) {
            return new Vec3((double)var3.getX(), (double)var3.getY(), (double)var3.getZ());
         }
      }

      return null;
   }

   private boolean spawnZombie() {
      Vec3 var1 = this.func_179867_a(new BlockPos(this.field_75532_g, this.field_75538_h, this.field_75539_i));
      if (var1 == null) {
         return false;
      } else {
         EntityZombie var2;
         try {
            var2 = new EntityZombie(this.worldObj);
            var2.onInitialSpawn(this.worldObj.getDifficultyForLocation(new BlockPos(var2)), (IEntityLivingData)null);
            var2.setVillager(false);
         } catch (Exception var4) {
            var4.printStackTrace();
            return false;
         }

         var2.setLocationAndAngles(var1.xCoord, var1.yCoord, var1.zCoord, this.worldObj.rand.nextFloat() * 360.0F, 0.0F);
         this.worldObj.spawnEntityInWorld(var2);
         BlockPos var3 = this.theVillage.getCenter();
         var2.setHomePosAndDistance(var3, this.theVillage.getVillageRadius());
         return true;
      }
   }

   public VillageSiege(World var1) {
      this.worldObj = var1;
   }

   public void tick() {
      if (this.worldObj.isDaytime()) {
         this.field_75536_c = 0;
      } else if (this.field_75536_c != 2) {
         if (this.field_75536_c == 0) {
            float var1 = this.worldObj.getCelestialAngle(0.0F);
            if ((double)var1 < 0.5D || (double)var1 > 0.501D) {
               return;
            }

            this.field_75536_c = this.worldObj.rand.nextInt(10) == 0 ? 1 : 2;
            this.field_75535_b = false;
            if (this.field_75536_c == 2) {
               return;
            }
         }

         if (this.field_75536_c != -1) {
            if (!this.field_75535_b) {
               if (!this.func_75529_b()) {
                  return;
               }

               this.field_75535_b = true;
            }

            if (this.field_75534_e > 0) {
               --this.field_75534_e;
            } else {
               this.field_75534_e = 2;
               if (this.field_75533_d > 0) {
                  this.spawnZombie();
                  --this.field_75533_d;
               } else {
                  this.field_75536_c = 2;
               }
            }
         }
      }

   }
}
