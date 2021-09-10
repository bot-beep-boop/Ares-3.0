package net.minecraft.entity.boss;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityDragon extends EntityLiving implements IEntityMultiPart, IMob, IBossDisplayData {
   public EntityEnderCrystal healingEnderCrystal;
   public float animTime;
   public EntityDragonPart dragonPartTail2;
   public boolean slowed;
   public double targetX;
   public EntityDragonPart dragonPartHead;
   public EntityDragonPart dragonPartTail1;
   public EntityDragonPart dragonPartWing2;
   public EntityDragonPart[] dragonPartArray;
   private Entity target;
   public double targetY;
   public int ringBufferIndex = -1;
   public boolean forceNewTarget;
   public EntityDragonPart dragonPartTail3;
   public EntityDragonPart dragonPartBody;
   public int deathTicks;
   public float prevAnimTime;
   public double[][] ringBuffer = new double[64][3];
   public double targetZ;
   public EntityDragonPart dragonPartWing1;

   public EntityDragon(World var1) {
      super(var1);
      this.dragonPartArray = new EntityDragonPart[]{this.dragonPartHead = new EntityDragonPart(this, "head", 6.0F, 6.0F), this.dragonPartBody = new EntityDragonPart(this, "body", 8.0F, 8.0F), this.dragonPartTail1 = new EntityDragonPart(this, "tail", 4.0F, 4.0F), this.dragonPartTail2 = new EntityDragonPart(this, "tail", 4.0F, 4.0F), this.dragonPartTail3 = new EntityDragonPart(this, "tail", 4.0F, 4.0F), this.dragonPartWing1 = new EntityDragonPart(this, "wing", 4.0F, 4.0F), this.dragonPartWing2 = new EntityDragonPart(this, "wing", 4.0F, 4.0F)};
      this.setHealth(this.getMaxHealth());
      this.setSize(16.0F, 8.0F);
      this.noClip = true;
      this.isImmuneToFire = true;
      this.targetY = 100.0D;
      this.ignoreFrustumCheck = true;
   }

   private void updateDragonEnderCrystal() {
      if (this.healingEnderCrystal != null) {
         if (this.healingEnderCrystal.isDead) {
            if (!this.worldObj.isRemote) {
               this.attackEntityFromPart(this.dragonPartHead, DamageSource.setExplosionSource((Explosion)null), 10.0F);
            }

            this.healingEnderCrystal = null;
         } else if (this.ticksExisted % 10 == 0 && this.getHealth() < this.getMaxHealth()) {
            this.setHealth(this.getHealth() + 1.0F);
         }
      }

      if (this.rand.nextInt(10) == 0) {
         float var1 = 32.0F;
         List var2 = this.worldObj.getEntitiesWithinAABB(EntityEnderCrystal.class, this.getEntityBoundingBox().expand((double)var1, (double)var1, (double)var1));
         EntityEnderCrystal var3 = null;
         double var4 = Double.MAX_VALUE;
         Iterator var7 = var2.iterator();

         while(var7.hasNext()) {
            EntityEnderCrystal var6 = (EntityEnderCrystal)var7.next();
            double var8 = var6.getDistanceSqToEntity(this);
            if (var8 < var4) {
               var4 = var8;
               var3 = var6;
            }
         }

         this.healingEnderCrystal = var3;
      }

   }

   public boolean attackEntityFromPart(EntityDragonPart var1, DamageSource var2, float var3) {
      if (var1 != this.dragonPartHead) {
         var3 = var3 / 4.0F + 1.0F;
      }

      float var4 = this.rotationYaw * 3.1415927F / 180.0F;
      float var5 = MathHelper.sin(var4);
      float var6 = MathHelper.cos(var4);
      this.targetX = this.posX + (double)(var5 * 5.0F) + (double)((this.rand.nextFloat() - 0.5F) * 2.0F);
      this.targetY = this.posY + (double)(this.rand.nextFloat() * 3.0F) + 1.0D;
      this.targetZ = this.posZ - (double)(var6 * 5.0F) + (double)((this.rand.nextFloat() - 0.5F) * 2.0F);
      this.target = null;
      if (var2.getEntity() instanceof EntityPlayer || var2.isExplosion()) {
         this.attackDragonFrom(var2, var3);
      }

      return true;
   }

   public World getWorld() {
      return this.worldObj;
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0D);
   }

   private void collideWithEntities(List<Entity> var1) {
      double var2 = (this.dragonPartBody.getEntityBoundingBox().minX + this.dragonPartBody.getEntityBoundingBox().maxX) / 2.0D;
      double var4 = (this.dragonPartBody.getEntityBoundingBox().minZ + this.dragonPartBody.getEntityBoundingBox().maxZ) / 2.0D;
      Iterator var7 = var1.iterator();

      while(var7.hasNext()) {
         Entity var6 = (Entity)var7.next();
         if (var6 instanceof EntityLivingBase) {
            double var8 = var6.posX - var2;
            double var10 = var6.posZ - var4;
            double var12 = var8 * var8 + var10 * var10;
            var6.addVelocity(var8 / var12 * 4.0D, 0.20000000298023224D, var10 / var12 * 4.0D);
         }
      }

   }

   private float simplifyAngle(double var1) {
      return (float)MathHelper.wrapAngleTo180_double(var1);
   }

   public boolean attackEntityFrom(DamageSource var1, float var2) {
      if (var1 instanceof EntityDamageSource && ((EntityDamageSource)var1).getIsThornsDamage()) {
         this.attackDragonFrom(var1, var2);
      }

      return false;
   }

   protected String getHurtSound() {
      return "mob.enderdragon.hit";
   }

   private void attackEntitiesInList(List<Entity> var1) {
      for(int var2 = 0; var2 < var1.size(); ++var2) {
         Entity var3 = (Entity)var1.get(var2);
         if (var3 instanceof EntityLivingBase) {
            var3.attackEntityFrom(DamageSource.causeMobDamage(this), 10.0F);
            this.applyEnchantments(this, var3);
         }
      }

   }

   protected String getLivingSound() {
      return "mob.enderdragon.growl";
   }

   protected void onDeathUpdate() {
      ++this.deathTicks;
      if (this.deathTicks >= 180 && this.deathTicks <= 200) {
         float var1 = (this.rand.nextFloat() - 0.5F) * 8.0F;
         float var2 = (this.rand.nextFloat() - 0.5F) * 4.0F;
         float var3 = (this.rand.nextFloat() - 0.5F) * 8.0F;
         this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.posX + (double)var1, this.posY + 2.0D + (double)var2, this.posZ + (double)var3, 0.0D, 0.0D, 0.0D);
      }

      boolean var4 = this.worldObj.getGameRules().getBoolean("doMobLoot");
      int var5;
      int var6;
      if (!this.worldObj.isRemote) {
         if (this.deathTicks > 150 && this.deathTicks % 5 == 0 && var4) {
            var5 = 1000;

            while(var5 > 0) {
               var6 = EntityXPOrb.getXPSplit(var5);
               var5 -= var6;
               this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var6));
            }
         }

         if (this.deathTicks == 1) {
            this.worldObj.playBroadcastSound(1018, new BlockPos(this), 0);
         }
      }

      this.moveEntity(0.0D, 0.10000000149011612D, 0.0D);
      this.renderYawOffset = this.rotationYaw += 20.0F;
      if (this.deathTicks == 200 && !this.worldObj.isRemote) {
         if (var4) {
            var5 = 2000;

            while(var5 > 0) {
               var6 = EntityXPOrb.getXPSplit(var5);
               var5 -= var6;
               this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, var6));
            }
         }

         this.generatePortal(new BlockPos(this.posX, 64.0D, this.posZ));
         this.setDead();
      }

   }

   protected boolean attackDragonFrom(DamageSource var1, float var2) {
      return super.attackEntityFrom(var1, var2);
   }

   public void onKillCommand() {
      this.setDead();
   }

   private void setNewTarget() {
      this.forceNewTarget = false;
      ArrayList var1 = Lists.newArrayList(this.worldObj.playerEntities);
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         if (((EntityPlayer)var2.next()).isSpectator()) {
            var2.remove();
         }
      }

      if (this.rand.nextInt(2) == 0 && !var1.isEmpty()) {
         this.target = (Entity)var1.get(this.rand.nextInt(var1.size()));
      } else {
         boolean var9;
         do {
            this.targetX = 0.0D;
            this.targetY = (double)(70.0F + this.rand.nextFloat() * 50.0F);
            this.targetZ = 0.0D;
            this.targetX += (double)(this.rand.nextFloat() * 120.0F - 60.0F);
            this.targetZ += (double)(this.rand.nextFloat() * 120.0F - 60.0F);
            double var3 = this.posX - this.targetX;
            double var5 = this.posY - this.targetY;
            double var7 = this.posZ - this.targetZ;
            var9 = var3 * var3 + var5 * var5 + var7 * var7 > 100.0D;
         } while(!var9);

         this.target = null;
      }

   }

   public Entity[] getParts() {
      return this.dragonPartArray;
   }

   public boolean canBeCollidedWith() {
      return false;
   }

   protected float getSoundVolume() {
      return 5.0F;
   }

   public double[] getMovementOffsets(int var1, float var2) {
      if (this.getHealth() <= 0.0F) {
         var2 = 0.0F;
      }

      var2 = 1.0F - var2;
      int var3 = this.ringBufferIndex - var1 * 1 & 63;
      int var4 = this.ringBufferIndex - var1 * 1 - 1 & 63;
      double[] var5 = new double[3];
      double var6 = this.ringBuffer[var3][0];
      double var8 = MathHelper.wrapAngleTo180_double(this.ringBuffer[var4][0] - var6);
      var5[0] = var6 + var8 * (double)var2;
      var6 = this.ringBuffer[var3][1];
      var8 = this.ringBuffer[var4][1] - var6;
      var5[1] = var6 + var8 * (double)var2;
      var5[2] = this.ringBuffer[var3][2] + (this.ringBuffer[var4][2] - this.ringBuffer[var3][2]) * (double)var2;
      return var5;
   }

   protected void entityInit() {
      super.entityInit();
   }

   private void generatePortal(BlockPos var1) {
      boolean var2 = true;
      double var3 = 12.25D;
      double var5 = 6.25D;

      for(int var7 = -1; var7 <= 32; ++var7) {
         for(int var8 = -4; var8 <= 4; ++var8) {
            for(int var9 = -4; var9 <= 4; ++var9) {
               double var10 = (double)(var8 * var8 + var9 * var9);
               if (!(var10 > 12.25D)) {
                  BlockPos var12 = var1.add(var8, var7, var9);
                  if (var7 < 0) {
                     if (var10 <= 6.25D) {
                        this.worldObj.setBlockState(var12, Blocks.bedrock.getDefaultState());
                     }
                  } else if (var7 > 0) {
                     this.worldObj.setBlockState(var12, Blocks.air.getDefaultState());
                  } else if (var10 > 6.25D) {
                     this.worldObj.setBlockState(var12, Blocks.bedrock.getDefaultState());
                  } else {
                     this.worldObj.setBlockState(var12, Blocks.end_portal.getDefaultState());
                  }
               }
            }
         }
      }

      this.worldObj.setBlockState(var1, Blocks.bedrock.getDefaultState());
      this.worldObj.setBlockState(var1.up(), Blocks.bedrock.getDefaultState());
      BlockPos var13 = var1.up(2);
      this.worldObj.setBlockState(var13, Blocks.bedrock.getDefaultState());
      this.worldObj.setBlockState(var13.west(), Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, EnumFacing.EAST));
      this.worldObj.setBlockState(var13.east(), Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, EnumFacing.WEST));
      this.worldObj.setBlockState(var13.north(), Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, EnumFacing.SOUTH));
      this.worldObj.setBlockState(var13.south(), Blocks.torch.getDefaultState().withProperty(BlockTorch.FACING, EnumFacing.NORTH));
      this.worldObj.setBlockState(var1.up(3), Blocks.bedrock.getDefaultState());
      this.worldObj.setBlockState(var1.up(4), Blocks.dragon_egg.getDefaultState());
   }

   public void onLivingUpdate() {
      float var1;
      float var2;
      if (this.worldObj.isRemote) {
         var1 = MathHelper.cos(this.animTime * 3.1415927F * 2.0F);
         var2 = MathHelper.cos(this.prevAnimTime * 3.1415927F * 2.0F);
         if (var2 <= -0.3F && var1 >= -0.3F && !this.isSilent()) {
            this.worldObj.playSound(this.posX, this.posY, this.posZ, "mob.enderdragon.wings", 5.0F, 0.8F + this.rand.nextFloat() * 0.3F, false);
         }
      }

      this.prevAnimTime = this.animTime;
      float var3;
      if (this.getHealth() <= 0.0F) {
         var1 = (this.rand.nextFloat() - 0.5F) * 8.0F;
         var2 = (this.rand.nextFloat() - 0.5F) * 4.0F;
         var3 = (this.rand.nextFloat() - 0.5F) * 8.0F;
         this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX + (double)var1, this.posY + 2.0D + (double)var2, this.posZ + (double)var3, 0.0D, 0.0D, 0.0D);
      } else {
         this.updateDragonEnderCrystal();
         var1 = 0.2F / (MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ) * 10.0F + 1.0F);
         var1 *= (float)Math.pow(2.0D, this.motionY);
         if (this.slowed) {
            this.animTime += var1 * 0.5F;
         } else {
            this.animTime += var1;
         }

         this.rotationYaw = MathHelper.wrapAngleTo180_float(this.rotationYaw);
         if (this.isAIDisabled()) {
            this.animTime = 0.5F;
         } else {
            if (this.ringBufferIndex < 0) {
               for(int var27 = 0; var27 < this.ringBuffer.length; ++var27) {
                  this.ringBuffer[var27][0] = (double)this.rotationYaw;
                  this.ringBuffer[var27][1] = this.posY;
               }
            }

            if (++this.ringBufferIndex == this.ringBuffer.length) {
               this.ringBufferIndex = 0;
            }

            this.ringBuffer[this.ringBufferIndex][0] = (double)this.rotationYaw;
            this.ringBuffer[this.ringBufferIndex][1] = this.posY;
            double var4;
            double var6;
            double var8;
            float var19;
            double var28;
            float var32;
            if (this.worldObj.isRemote) {
               if (this.newPosRotationIncrements > 0) {
                  var28 = this.posX + (this.newPosX - this.posX) / (double)this.newPosRotationIncrements;
                  var4 = this.posY + (this.newPosY - this.posY) / (double)this.newPosRotationIncrements;
                  var6 = this.posZ + (this.newPosZ - this.posZ) / (double)this.newPosRotationIncrements;
                  var8 = MathHelper.wrapAngleTo180_double(this.newRotationYaw - (double)this.rotationYaw);
                  this.rotationYaw = (float)((double)this.rotationYaw + var8 / (double)this.newPosRotationIncrements);
                  this.rotationPitch = (float)((double)this.rotationPitch + (this.newRotationPitch - (double)this.rotationPitch) / (double)this.newPosRotationIncrements);
                  --this.newPosRotationIncrements;
                  this.setPosition(var28, var4, var6);
                  this.setRotation(this.rotationYaw, this.rotationPitch);
               }
            } else {
               var28 = this.targetX - this.posX;
               var4 = this.targetY - this.posY;
               var6 = this.targetZ - this.posZ;
               var8 = var28 * var28 + var4 * var4 + var6 * var6;
               double var16;
               if (this.target != null) {
                  this.targetX = this.target.posX;
                  this.targetZ = this.target.posZ;
                  double var10 = this.targetX - this.posX;
                  double var12 = this.targetZ - this.posZ;
                  double var14 = Math.sqrt(var10 * var10 + var12 * var12);
                  var16 = 0.4000000059604645D + var14 / 80.0D - 1.0D;
                  if (var16 > 10.0D) {
                     var16 = 10.0D;
                  }

                  this.targetY = this.target.getEntityBoundingBox().minY + var16;
               } else {
                  this.targetX += this.rand.nextGaussian() * 2.0D;
                  this.targetZ += this.rand.nextGaussian() * 2.0D;
               }

               if (this.forceNewTarget || var8 < 100.0D || var8 > 22500.0D || this.isCollidedHorizontally || this.isCollidedVertically) {
                  this.setNewTarget();
               }

               var4 /= (double)MathHelper.sqrt_double(var28 * var28 + var6 * var6);
               var32 = 0.6F;
               var4 = MathHelper.clamp_double(var4, (double)(-var32), (double)var32);
               this.motionY += var4 * 0.10000000149011612D;
               this.rotationYaw = MathHelper.wrapAngleTo180_float(this.rotationYaw);
               double var11 = 180.0D - MathHelper.atan2(var28, var6) * 180.0D / 3.1415927410125732D;
               double var13 = MathHelper.wrapAngleTo180_double(var11 - (double)this.rotationYaw);
               if (var13 > 50.0D) {
                  var13 = 50.0D;
               }

               if (var13 < -50.0D) {
                  var13 = -50.0D;
               }

               Vec3 var15 = (new Vec3(this.targetX - this.posX, this.targetY - this.posY, this.targetZ - this.posZ)).normalize();
               var16 = (double)(-MathHelper.cos(this.rotationYaw * 3.1415927F / 180.0F));
               Vec3 var18 = (new Vec3((double)MathHelper.sin(this.rotationYaw * 3.1415927F / 180.0F), this.motionY, var16)).normalize();
               var19 = ((float)var18.dotProduct(var15) + 0.5F) / 1.5F;
               if (var19 < 0.0F) {
                  var19 = 0.0F;
               }

               this.randomYawVelocity *= 0.8F;
               float var20 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ) * 1.0F + 1.0F;
               double var21 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ) * 1.0D + 1.0D;
               if (var21 > 40.0D) {
                  var21 = 40.0D;
               }

               this.randomYawVelocity = (float)((double)this.randomYawVelocity + var13 * (0.699999988079071D / var21 / (double)var20));
               this.rotationYaw += this.randomYawVelocity * 0.1F;
               float var23 = (float)(2.0D / (var21 + 1.0D));
               float var24 = 0.06F;
               this.moveFlying(0.0F, -1.0F, var24 * (var19 * var23 + (1.0F - var23)));
               if (this.slowed) {
                  this.moveEntity(this.motionX * 0.800000011920929D, this.motionY * 0.800000011920929D, this.motionZ * 0.800000011920929D);
               } else {
                  this.moveEntity(this.motionX, this.motionY, this.motionZ);
               }

               Vec3 var25 = (new Vec3(this.motionX, this.motionY, this.motionZ)).normalize();
               float var26 = ((float)var25.dotProduct(var18) + 1.0F) / 2.0F;
               var26 = 0.8F + 0.15F * var26;
               this.motionX *= (double)var26;
               this.motionZ *= (double)var26;
               this.motionY *= 0.9100000262260437D;
            }

            this.renderYawOffset = this.rotationYaw;
            this.dragonPartHead.width = this.dragonPartHead.height = 3.0F;
            this.dragonPartTail1.width = this.dragonPartTail1.height = 2.0F;
            this.dragonPartTail2.width = this.dragonPartTail2.height = 2.0F;
            this.dragonPartTail3.width = this.dragonPartTail3.height = 2.0F;
            this.dragonPartBody.height = 3.0F;
            this.dragonPartBody.width = 5.0F;
            this.dragonPartWing1.height = 2.0F;
            this.dragonPartWing1.width = 4.0F;
            this.dragonPartWing2.height = 3.0F;
            this.dragonPartWing2.width = 4.0F;
            var2 = (float)(this.getMovementOffsets(5, 1.0F)[1] - this.getMovementOffsets(10, 1.0F)[1]) * 10.0F / 180.0F * 3.1415927F;
            var3 = MathHelper.cos(var2);
            float var29 = -MathHelper.sin(var2);
            float var5 = this.rotationYaw * 3.1415927F / 180.0F;
            float var30 = MathHelper.sin(var5);
            float var7 = MathHelper.cos(var5);
            this.dragonPartBody.onUpdate();
            this.dragonPartBody.setLocationAndAngles(this.posX + (double)(var30 * 0.5F), this.posY, this.posZ - (double)(var7 * 0.5F), 0.0F, 0.0F);
            this.dragonPartWing1.onUpdate();
            this.dragonPartWing1.setLocationAndAngles(this.posX + (double)(var7 * 4.5F), this.posY + 2.0D, this.posZ + (double)(var30 * 4.5F), 0.0F, 0.0F);
            this.dragonPartWing2.onUpdate();
            this.dragonPartWing2.setLocationAndAngles(this.posX - (double)(var7 * 4.5F), this.posY + 2.0D, this.posZ - (double)(var30 * 4.5F), 0.0F, 0.0F);
            if (!this.worldObj.isRemote && this.hurtTime == 0) {
               this.collideWithEntities(this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.dragonPartWing1.getEntityBoundingBox().expand(4.0D, 2.0D, 4.0D).offset(0.0D, -2.0D, 0.0D)));
               this.collideWithEntities(this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.dragonPartWing2.getEntityBoundingBox().expand(4.0D, 2.0D, 4.0D).offset(0.0D, -2.0D, 0.0D)));
               this.attackEntitiesInList(this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.dragonPartHead.getEntityBoundingBox().expand(1.0D, 1.0D, 1.0D)));
            }

            double[] var31 = this.getMovementOffsets(5, 1.0F);
            double[] var9 = this.getMovementOffsets(0, 1.0F);
            var32 = MathHelper.sin(this.rotationYaw * 3.1415927F / 180.0F - this.randomYawVelocity * 0.01F);
            float var33 = MathHelper.cos(this.rotationYaw * 3.1415927F / 180.0F - this.randomYawVelocity * 0.01F);
            this.dragonPartHead.onUpdate();
            this.dragonPartHead.setLocationAndAngles(this.posX + (double)(var32 * 5.5F * var3), this.posY + (var9[1] - var31[1]) * 1.0D + (double)(var29 * 5.5F), this.posZ - (double)(var33 * 5.5F * var3), 0.0F, 0.0F);

            for(int var34 = 0; var34 < 3; ++var34) {
               EntityDragonPart var36 = null;
               if (var34 == 0) {
                  var36 = this.dragonPartTail1;
               }

               if (var34 == 1) {
                  var36 = this.dragonPartTail2;
               }

               if (var34 == 2) {
                  var36 = this.dragonPartTail3;
               }

               double[] var35 = this.getMovementOffsets(12 + var34 * 2, 1.0F);
               float var37 = this.rotationYaw * 3.1415927F / 180.0F + this.simplifyAngle(var35[0] - var31[0]) * 3.1415927F / 180.0F * 1.0F;
               float var38 = MathHelper.sin(var37);
               float var17 = MathHelper.cos(var37);
               float var39 = 1.5F;
               var19 = (float)(var34 + 1) * 2.0F;
               var36.onUpdate();
               var36.setLocationAndAngles(this.posX - (double)((var30 * var39 + var38 * var19) * var3), this.posY + (var35[1] - var31[1]) * 1.0D - (double)((var19 + var39) * var29) + 1.5D, this.posZ + (double)((var7 * var39 + var17 * var19) * var3), 0.0F, 0.0F);
            }

            if (!this.worldObj.isRemote) {
               this.slowed = this.destroyBlocksInAABB(this.dragonPartHead.getEntityBoundingBox()) | this.destroyBlocksInAABB(this.dragonPartBody.getEntityBoundingBox());
            }
         }
      }

   }

   protected void despawnEntity() {
   }

   private boolean destroyBlocksInAABB(AxisAlignedBB var1) {
      int var2 = MathHelper.floor_double(var1.minX);
      int var3 = MathHelper.floor_double(var1.minY);
      int var4 = MathHelper.floor_double(var1.minZ);
      int var5 = MathHelper.floor_double(var1.maxX);
      int var6 = MathHelper.floor_double(var1.maxY);
      int var7 = MathHelper.floor_double(var1.maxZ);
      boolean var8 = false;
      boolean var9 = false;

      for(int var10 = var2; var10 <= var5; ++var10) {
         for(int var11 = var3; var11 <= var6; ++var11) {
            for(int var12 = var4; var12 <= var7; ++var12) {
               BlockPos var13 = new BlockPos(var10, var11, var12);
               Block var14 = this.worldObj.getBlockState(var13).getBlock();
               if (var14.getMaterial() != Material.air) {
                  if (var14 != Blocks.barrier && var14 != Blocks.obsidian && var14 != Blocks.end_stone && var14 != Blocks.bedrock && var14 != Blocks.command_block && this.worldObj.getGameRules().getBoolean("mobGriefing")) {
                     var9 = this.worldObj.setBlockToAir(var13) || var9;
                  } else {
                     var8 = true;
                  }
               }
            }
         }
      }

      if (var9) {
         double var16 = var1.minX + (var1.maxX - var1.minX) * (double)this.rand.nextFloat();
         double var17 = var1.minY + (var1.maxY - var1.minY) * (double)this.rand.nextFloat();
         double var18 = var1.minZ + (var1.maxZ - var1.minZ) * (double)this.rand.nextFloat();
         this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, var16, var17, var18, 0.0D, 0.0D, 0.0D);
      }

      return var8;
   }
}
