package net.minecraft.entity.item;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityXPOrb extends Entity {
   private int xpOrbHealth = 5;
   public int xpOrbAge;
   public int delayBeforeCanPickup;
   public int xpColor;
   private int xpValue;
   private EntityPlayer closestPlayer;
   private int xpTargetColor;

   protected void dealFireDamage(int var1) {
      this.attackEntityFrom(DamageSource.inFire, (float)var1);
   }

   public static int getXPSplit(int var0) {
      if (var0 >= 2477) {
         return 2477;
      } else if (var0 >= 1237) {
         return 1237;
      } else if (var0 >= 617) {
         return 617;
      } else if (var0 >= 307) {
         return 307;
      } else if (var0 >= 149) {
         return 149;
      } else if (var0 >= 73) {
         return 73;
      } else if (var0 >= 37) {
         return 37;
      } else if (var0 >= 17) {
         return 17;
      } else if (var0 >= 7) {
         return 7;
      } else {
         return var0 >= 3 ? 3 : 1;
      }
   }

   public boolean handleWaterMovement() {
      return this.worldObj.handleMaterialAcceleration(this.getEntityBoundingBox(), Material.water, this);
   }

   public EntityXPOrb(World var1, double var2, double var4, double var6, int var8) {
      super(var1);
      this.setSize(0.5F, 0.5F);
      this.setPosition(var2, var4, var6);
      this.rotationYaw = (float)(Math.random() * 360.0D);
      this.motionX = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
      this.motionY = (double)((float)(Math.random() * 0.2D) * 2.0F);
      this.motionZ = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
      this.xpValue = var8;
   }

   public int getTextureByXP() {
      if (this.xpValue >= 2477) {
         return 10;
      } else if (this.xpValue >= 1237) {
         return 9;
      } else if (this.xpValue >= 617) {
         return 8;
      } else if (this.xpValue >= 307) {
         return 7;
      } else if (this.xpValue >= 149) {
         return 6;
      } else if (this.xpValue >= 73) {
         return 5;
      } else if (this.xpValue >= 37) {
         return 4;
      } else if (this.xpValue >= 17) {
         return 3;
      } else if (this.xpValue >= 7) {
         return 2;
      } else {
         return this.xpValue >= 3 ? 1 : 0;
      }
   }

   public void readEntityFromNBT(NBTTagCompound var1) {
      this.xpOrbHealth = var1.getShort("Health") & 255;
      this.xpOrbAge = var1.getShort("Age");
      this.xpValue = var1.getShort("Value");
   }

   public int getBrightnessForRender(float var1) {
      float var2 = 0.5F;
      var2 = MathHelper.clamp_float(var2, 0.0F, 1.0F);
      int var3 = super.getBrightnessForRender(var1);
      int var4 = var3 & 255;
      int var5 = var3 >> 16 & 255;
      var4 += (int)(var2 * 15.0F * 16.0F);
      if (var4 > 240) {
         var4 = 240;
      }

      return var4 | var5 << 16;
   }

   public boolean canAttackWithItem() {
      return false;
   }

   protected void entityInit() {
   }

   public void onCollideWithPlayer(EntityPlayer var1) {
      if (!this.worldObj.isRemote && this.delayBeforeCanPickup == 0 && var1.xpCooldown == 0) {
         var1.xpCooldown = 2;
         this.worldObj.playSoundAtEntity(var1, "random.orb", 0.1F, 0.5F * ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.8F));
         var1.onItemPickup(this, 1);
         var1.addExperience(this.xpValue);
         this.setDead();
      }

   }

   public void writeEntityToNBT(NBTTagCompound var1) {
      var1.setShort("Health", (short)((byte)this.xpOrbHealth));
      var1.setShort("Age", (short)this.xpOrbAge);
      var1.setShort("Value", (short)this.xpValue);
   }

   public void onUpdate() {
      super.onUpdate();
      if (this.delayBeforeCanPickup > 0) {
         --this.delayBeforeCanPickup;
      }

      this.prevPosX = this.posX;
      this.prevPosY = this.posY;
      this.prevPosZ = this.posZ;
      this.motionY -= 0.029999999329447746D;
      if (this.worldObj.getBlockState(new BlockPos(this)).getBlock().getMaterial() == Material.lava) {
         this.motionY = 0.20000000298023224D;
         this.motionX = (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
         this.motionZ = (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
         this.playSound("random.fizz", 0.4F, 2.0F + this.rand.nextFloat() * 0.4F);
      }

      this.pushOutOfBlocks(this.posX, (this.getEntityBoundingBox().minY + this.getEntityBoundingBox().maxY) / 2.0D, this.posZ);
      double var1 = 8.0D;
      if (this.xpTargetColor < this.xpColor - 20 + this.getEntityId() % 100) {
         if (this.closestPlayer == null || this.closestPlayer.getDistanceSqToEntity(this) > var1 * var1) {
            this.closestPlayer = this.worldObj.getClosestPlayerToEntity(this, var1);
         }

         this.xpTargetColor = this.xpColor;
      }

      if (this.closestPlayer != null && this.closestPlayer.isSpectator()) {
         this.closestPlayer = null;
      }

      if (this.closestPlayer != null) {
         double var3 = (this.closestPlayer.posX - this.posX) / var1;
         double var5 = (this.closestPlayer.posY + (double)this.closestPlayer.getEyeHeight() - this.posY) / var1;
         double var7 = (this.closestPlayer.posZ - this.posZ) / var1;
         double var9 = Math.sqrt(var3 * var3 + var5 * var5 + var7 * var7);
         double var11 = 1.0D - var9;
         if (var11 > 0.0D) {
            var11 *= var11;
            this.motionX += var3 / var9 * var11 * 0.1D;
            this.motionY += var5 / var9 * var11 * 0.1D;
            this.motionZ += var7 / var9 * var11 * 0.1D;
         }
      }

      this.moveEntity(this.motionX, this.motionY, this.motionZ);
      float var13 = 0.98F;
      if (this.onGround) {
         var13 = this.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.getEntityBoundingBox().minY) - 1, MathHelper.floor_double(this.posZ))).getBlock().slipperiness * 0.98F;
      }

      this.motionX *= (double)var13;
      this.motionY *= 0.9800000190734863D;
      this.motionZ *= (double)var13;
      if (this.onGround) {
         this.motionY *= -0.8999999761581421D;
      }

      ++this.xpColor;
      ++this.xpOrbAge;
      if (this.xpOrbAge >= 6000) {
         this.setDead();
      }

   }

   public boolean attackEntityFrom(DamageSource var1, float var2) {
      if (this.isEntityInvulnerable(var1)) {
         return false;
      } else {
         this.setBeenAttacked();
         this.xpOrbHealth = (int)((float)this.xpOrbHealth - var2);
         if (this.xpOrbHealth <= 0) {
            this.setDead();
         }

         return false;
      }
   }

   public EntityXPOrb(World var1) {
      super(var1);
      this.setSize(0.25F, 0.25F);
   }

   public int getXpValue() {
      return this.xpValue;
   }

   protected boolean canTriggerWalking() {
      return false;
   }
}
