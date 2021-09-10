package net.minecraft.entity.passive;

import com.google.common.base.Predicate;
import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAIRunAroundLikeCrazy;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.AnimalChest;
import net.minecraft.inventory.IInvBasic;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.potion.Potion;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public class EntityHorse extends EntityAnimal implements IInvBasic {
   private static final IAttribute horseJumpStrength = (new RangedAttribute((IAttribute)null, "horse.jumpStrength", 0.7D, 0.0D, 2.0D)).setDescription("Jump Strength").setShouldWatch(true);
   private boolean field_175508_bO = false;
   private float prevRearingAmount;
   private AnimalChest horseChest;
   protected int temper;
   private float prevHeadLean;
   private float headLean;
   public int field_110278_bp;
   private String[] horseTexturesArray = new String[3];
   protected float jumpPower;
   private String texturePrefix;
   private static final String[] HORSE_TEXTURES_ABBR = new String[]{"hwh", "hcr", "hch", "hbr", "hbl", "hgr", "hdb"};
   private static final String[] HORSE_ARMOR_TEXTURES_ABBR = new String[]{"", "meo", "goo", "dio"};
   private int openMouthCounter;
   private boolean field_110294_bI;
   public int field_110279_bq;
   protected boolean horseJumping;
   private boolean hasReproduced;
   private int gallopTime;
   private int eatingHaystackCounter;
   private float mouthOpenness;
   private static final String[] horseMarkingTextures = new String[]{null, "textures/entity/horse/horse_markings_white.png", "textures/entity/horse/horse_markings_whitefield.png", "textures/entity/horse/horse_markings_whitedots.png", "textures/entity/horse/horse_markings_blackdots.png"};
   private static final String[] horseArmorTextures = new String[]{null, "textures/entity/horse/armor/horse_armor_iron.png", "textures/entity/horse/armor/horse_armor_gold.png", "textures/entity/horse/armor/horse_armor_diamond.png"};
   private int jumpRearingCounter;
   private float rearingAmount;
   private static final String[] HORSE_MARKING_TEXTURES_ABBR = new String[]{"", "wo_", "wmo", "wdo", "bdo"};
   private float prevMouthOpenness;
   private static final Predicate<Entity> horseBreedingSelector = new Predicate<Entity>() {
      public boolean apply(Object var1) {
         return this.apply((Entity)var1);
      }

      public boolean apply(Entity var1) {
         return var1 instanceof EntityHorse && ((EntityHorse)var1).isBreeding();
      }
   };
   private static final int[] armorValues = new int[]{0, 5, 7, 11};
   private static final String[] horseTextures = new String[]{"textures/entity/horse/horse_white.png", "textures/entity/horse/horse_creamy.png", "textures/entity/horse/horse_chestnut.png", "textures/entity/horse/horse_brown.png", "textures/entity/horse/horse_black.png", "textures/entity/horse/horse_gray.png", "textures/entity/horse/horse_darkbrown.png"};

   public String getOwnerId() {
      return this.dataWatcher.getWatchableObjectString(21);
   }

   public void handleStatusUpdate(byte var1) {
      if (var1 == 7) {
         this.spawnHorseParticles(true);
      } else if (var1 == 6) {
         this.spawnHorseParticles(false);
      } else {
         super.handleStatusUpdate(var1);
      }

   }

   public void setHorseArmorStack(ItemStack var1) {
      this.dataWatcher.updateObject(22, this.getHorseArmorIndex(var1));
      this.resetTexturePrefix();
   }

   public boolean func_110239_cn() {
      return this.getHorseType() == 0 || this.getHorseArmorIndexSynced() > 0;
   }

   public boolean canWearArmor() {
      return this.getHorseType() == 0;
   }

   public EntityHorse(World var1) {
      super(var1);
      this.setSize(1.4F, 1.6F);
      this.isImmuneToFire = false;
      this.setChested(false);
      ((PathNavigateGround)this.getNavigator()).setAvoidsWater(true);
      this.tasks.addTask(0, new EntityAISwimming(this));
      this.tasks.addTask(1, new EntityAIPanic(this, 1.2D));
      this.tasks.addTask(1, new EntityAIRunAroundLikeCrazy(this, 1.2D));
      this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
      this.tasks.addTask(4, new EntityAIFollowParent(this, 1.0D));
      this.tasks.addTask(6, new EntityAIWander(this, 0.7D));
      this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      this.tasks.addTask(8, new EntityAILookIdle(this));
      this.initHorseChest();
   }

   private boolean getHorseWatchableBoolean(int var1) {
      return (this.dataWatcher.getWatchableObjectInt(16) & var1) != 0;
   }

   protected void applyEntityAttributes() {
      super.applyEntityAttributes();
      this.getAttributeMap().registerAttribute(horseJumpStrength);
      this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(53.0D);
      this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.22499999403953552D);
   }

   public void setHorseTamed(boolean var1) {
      this.setHorseWatchableBoolean(2, var1);
   }

   public void moveEntityWithHeading(float var1, float var2) {
      if (this.riddenByEntity != null && this.riddenByEntity instanceof EntityLivingBase && this.isHorseSaddled()) {
         this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
         this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5F;
         this.setRotation(this.rotationYaw, this.rotationPitch);
         this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
         var1 = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5F;
         var2 = ((EntityLivingBase)this.riddenByEntity).moveForward;
         if (var2 <= 0.0F) {
            var2 *= 0.25F;
            this.gallopTime = 0;
         }

         if (this.onGround && this.jumpPower == 0.0F && this.isRearing() && !this.field_110294_bI) {
            var1 = 0.0F;
            var2 = 0.0F;
         }

         if (this.jumpPower > 0.0F && !this.isHorseJumping() && this.onGround) {
            this.motionY = this.getHorseJumpStrength() * (double)this.jumpPower;
            if (this.isPotionActive(Potion.jump)) {
               this.motionY += (double)((float)(this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F);
            }

            this.setHorseJumping(true);
            this.isAirBorne = true;
            if (var2 > 0.0F) {
               float var3 = MathHelper.sin(this.rotationYaw * 3.1415927F / 180.0F);
               float var4 = MathHelper.cos(this.rotationYaw * 3.1415927F / 180.0F);
               this.motionX += (double)(-0.4F * var3 * this.jumpPower);
               this.motionZ += (double)(0.4F * var4 * this.jumpPower);
               this.playSound("mob.horse.jump", 0.4F, 1.0F);
            }

            this.jumpPower = 0.0F;
         }

         this.stepHeight = 1.0F;
         this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;
         if (!this.worldObj.isRemote) {
            this.setAIMoveSpeed((float)this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
            super.moveEntityWithHeading(var1, var2);
         }

         if (this.onGround) {
            this.jumpPower = 0.0F;
            this.setHorseJumping(false);
         }

         this.prevLimbSwingAmount = this.limbSwingAmount;
         double var8 = this.posX - this.prevPosX;
         double var5 = this.posZ - this.prevPosZ;
         float var7 = MathHelper.sqrt_double(var8 * var8 + var5 * var5) * 4.0F;
         if (var7 > 1.0F) {
            var7 = 1.0F;
         }

         this.limbSwingAmount += (var7 - this.limbSwingAmount) * 0.4F;
         this.limbSwing += this.limbSwingAmount;
      } else {
         this.stepHeight = 0.5F;
         this.jumpMovementFactor = 0.02F;
         super.moveEntityWithHeading(var1, var2);
      }

   }

   public boolean func_110253_bW() {
      return this.isAdultHorse();
   }

   public void dropChestItems() {
      this.dropItemsInChest(this, this.horseChest);
      this.dropChests();
   }

   public float getHorseSize() {
      return 0.5F;
   }

   public void onUpdate() {
      super.onUpdate();
      if (this.worldObj.isRemote && this.dataWatcher.hasObjectChanged()) {
         this.dataWatcher.func_111144_e();
         this.resetTexturePrefix();
      }

      if (this.openMouthCounter > 0 && ++this.openMouthCounter > 30) {
         this.openMouthCounter = 0;
         this.setHorseWatchableBoolean(128, false);
      }

      if (!this.worldObj.isRemote && this.jumpRearingCounter > 0 && ++this.jumpRearingCounter > 20) {
         this.jumpRearingCounter = 0;
         this.setRearing(false);
      }

      if (this.field_110278_bp > 0 && ++this.field_110278_bp > 8) {
         this.field_110278_bp = 0;
      }

      if (this.field_110279_bq > 0) {
         ++this.field_110279_bq;
         if (this.field_110279_bq > 300) {
            this.field_110279_bq = 0;
         }
      }

      this.prevHeadLean = this.headLean;
      if (this.isEatingHaystack()) {
         this.headLean += (1.0F - this.headLean) * 0.4F + 0.05F;
         if (this.headLean > 1.0F) {
            this.headLean = 1.0F;
         }
      } else {
         this.headLean += (0.0F - this.headLean) * 0.4F - 0.05F;
         if (this.headLean < 0.0F) {
            this.headLean = 0.0F;
         }
      }

      this.prevRearingAmount = this.rearingAmount;
      if (this.isRearing()) {
         this.prevHeadLean = this.headLean = 0.0F;
         this.rearingAmount += (1.0F - this.rearingAmount) * 0.4F + 0.05F;
         if (this.rearingAmount > 1.0F) {
            this.rearingAmount = 1.0F;
         }
      } else {
         this.field_110294_bI = false;
         this.rearingAmount += (0.8F * this.rearingAmount * this.rearingAmount * this.rearingAmount - this.rearingAmount) * 0.6F - 0.05F;
         if (this.rearingAmount < 0.0F) {
            this.rearingAmount = 0.0F;
         }
      }

      this.prevMouthOpenness = this.mouthOpenness;
      if (this.getHorseWatchableBoolean(128)) {
         this.mouthOpenness += (1.0F - this.mouthOpenness) * 0.7F + 0.05F;
         if (this.mouthOpenness > 1.0F) {
            this.mouthOpenness = 1.0F;
         }
      } else {
         this.mouthOpenness += (0.0F - this.mouthOpenness) * 0.7F - 0.05F;
         if (this.mouthOpenness < 0.0F) {
            this.mouthOpenness = 0.0F;
         }
      }

   }

   private boolean canMate() {
      return this.riddenByEntity == null && this.ridingEntity == null && this.isTame() && this.isAdultHorse() && !this.isSterile() && this.getHealth() >= this.getMaxHealth() && this.isInLove();
   }

   public boolean attackEntityFrom(DamageSource var1, float var2) {
      Entity var3 = var1.getEntity();
      return this.riddenByEntity != null && this.riddenByEntity.equals(var3) ? false : super.attackEntityFrom(var1, var2);
   }

   public boolean func_175507_cI() {
      return this.field_175508_bO;
   }

   public void readEntityFromNBT(NBTTagCompound var1) {
      super.readEntityFromNBT(var1);
      this.setEatingHaystack(var1.getBoolean("EatingHaystack"));
      this.setBreeding(var1.getBoolean("Bred"));
      this.setChested(var1.getBoolean("ChestedHorse"));
      this.setHasReproduced(var1.getBoolean("HasReproduced"));
      this.setHorseType(var1.getInteger("Type"));
      this.setHorseVariant(var1.getInteger("Variant"));
      this.setTemper(var1.getInteger("Temper"));
      this.setHorseTamed(var1.getBoolean("Tame"));
      String var2 = "";
      if (var1.hasKey("OwnerUUID", 8)) {
         var2 = var1.getString("OwnerUUID");
      } else {
         String var3 = var1.getString("Owner");
         var2 = PreYggdrasilConverter.getStringUUIDFromName(var3);
      }

      if (var2.length() > 0) {
         this.setOwnerId(var2);
      }

      IAttributeInstance var8 = this.getAttributeMap().getAttributeInstanceByName("Speed");
      if (var8 != null) {
         this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(var8.getBaseValue() * 0.25D);
      }

      if (this.isChested()) {
         NBTTagList var4 = var1.getTagList("Items", 10);
         this.initHorseChest();

         for(int var5 = 0; var5 < var4.tagCount(); ++var5) {
            NBTTagCompound var6 = var4.getCompoundTagAt(var5);
            int var7 = var6.getByte("Slot") & 255;
            if (var7 >= 2 && var7 < this.horseChest.getSizeInventory()) {
               this.horseChest.setInventorySlotContents(var7, ItemStack.loadItemStackFromNBT(var6));
            }
         }
      }

      ItemStack var9;
      if (var1.hasKey("ArmorItem", 10)) {
         var9 = ItemStack.loadItemStackFromNBT(var1.getCompoundTag("ArmorItem"));
         if (var9 != null && isArmorItem(var9.getItem())) {
            this.horseChest.setInventorySlotContents(1, var9);
         }
      }

      if (var1.hasKey("SaddleItem", 10)) {
         var9 = ItemStack.loadItemStackFromNBT(var1.getCompoundTag("SaddleItem"));
         if (var9 != null && var9.getItem() == Items.saddle) {
            this.horseChest.setInventorySlotContents(0, var9);
         }
      } else if (var1.getBoolean("Saddle")) {
         this.horseChest.setInventorySlotContents(0, new ItemStack(Items.saddle));
      }

      this.updateHorseSlots();
   }

   protected EntityHorse getClosestHorse(Entity var1, double var2) {
      double var4 = Double.MAX_VALUE;
      Entity var6 = null;
      Iterator var8 = this.worldObj.getEntitiesInAABBexcluding(var1, var1.getEntityBoundingBox().addCoord(var2, var2, var2), horseBreedingSelector).iterator();

      while(var8.hasNext()) {
         Entity var7 = (Entity)var8.next();
         double var9 = var7.getDistanceSq(var1.posX, var1.posY, var1.posZ);
         if (var9 < var4) {
            var6 = var7;
            var4 = var9;
         }
      }

      return (EntityHorse)var6;
   }

   public boolean canBePushed() {
      return this.riddenByEntity == null;
   }

   protected float getSoundVolume() {
      return 0.8F;
   }

   public EntityAgeable createChild(EntityAgeable var1) {
      EntityHorse var2 = (EntityHorse)var1;
      EntityHorse var3 = new EntityHorse(this.worldObj);
      int var4 = this.getHorseType();
      int var5 = var2.getHorseType();
      int var6 = 0;
      if (var4 == var5) {
         var6 = var4;
      } else if (var4 == 0 && var5 == 1 || var4 == 1 && var5 == 0) {
         var6 = 2;
      }

      if (var6 == 0) {
         int var7 = this.rand.nextInt(9);
         int var8;
         if (var7 < 4) {
            var8 = this.getHorseVariant() & 255;
         } else if (var7 < 8) {
            var8 = var2.getHorseVariant() & 255;
         } else {
            var8 = this.rand.nextInt(7);
         }

         int var9 = this.rand.nextInt(5);
         if (var9 < 2) {
            var8 |= this.getHorseVariant() & '\uff00';
         } else if (var9 < 4) {
            var8 |= var2.getHorseVariant() & '\uff00';
         } else {
            var8 |= this.rand.nextInt(5) << 8 & '\uff00';
         }

         var3.setHorseVariant(var8);
      }

      var3.setHorseType(var6);
      double var13 = this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + var1.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + (double)this.getModifiedMaxHealth();
      var3.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(var13 / 3.0D);
      double var14 = this.getEntityAttribute(horseJumpStrength).getBaseValue() + var1.getEntityAttribute(horseJumpStrength).getBaseValue() + this.getModifiedJumpStrength();
      var3.getEntityAttribute(horseJumpStrength).setBaseValue(var14 / 3.0D);
      double var11 = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() + var1.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() + this.getModifiedMovementSpeed();
      var3.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(var11 / 3.0D);
      return var3;
   }

   public boolean isSterile() {
      return this.isUndead() || this.getHorseType() == 2;
   }

   public void writeEntityToNBT(NBTTagCompound var1) {
      super.writeEntityToNBT(var1);
      var1.setBoolean("EatingHaystack", this.isEatingHaystack());
      var1.setBoolean("ChestedHorse", this.isChested());
      var1.setBoolean("HasReproduced", this.getHasReproduced());
      var1.setBoolean("Bred", this.isBreeding());
      var1.setInteger("Type", this.getHorseType());
      var1.setInteger("Variant", this.getHorseVariant());
      var1.setInteger("Temper", this.getTemper());
      var1.setBoolean("Tame", this.isTame());
      var1.setString("OwnerUUID", this.getOwnerId());
      if (this.isChested()) {
         NBTTagList var2 = new NBTTagList();

         for(int var3 = 2; var3 < this.horseChest.getSizeInventory(); ++var3) {
            ItemStack var4 = this.horseChest.getStackInSlot(var3);
            if (var4 != null) {
               NBTTagCompound var5 = new NBTTagCompound();
               var5.setByte("Slot", (byte)var3);
               var4.writeToNBT(var5);
               var2.appendTag(var5);
            }
         }

         var1.setTag("Items", var2);
      }

      if (this.horseChest.getStackInSlot(1) != null) {
         var1.setTag("ArmorItem", this.horseChest.getStackInSlot(1).writeToNBT(new NBTTagCompound()));
      }

      if (this.horseChest.getStackInSlot(0) != null) {
         var1.setTag("SaddleItem", this.horseChest.getStackInSlot(0).writeToNBT(new NBTTagCompound()));
      }

   }

   public boolean canMateWith(EntityAnimal var1) {
      if (var1 == this) {
         return false;
      } else if (var1.getClass() != this.getClass()) {
         return false;
      } else {
         EntityHorse var2 = (EntityHorse)var1;
         if (this.canMate() && var2.canMate()) {
            int var3 = this.getHorseType();
            int var4 = var2.getHorseType();
            return var3 == var4 || var3 == 0 && var4 == 1 || var3 == 1 && var4 == 0;
         } else {
            return false;
         }
      }
   }

   public boolean isBreedingItem(ItemStack var1) {
      return false;
   }

   public boolean replaceItemInInventory(int var1, ItemStack var2) {
      if (var1 == 499 && this.canCarryChest()) {
         if (var2 == null && this.isChested()) {
            this.setChested(false);
            this.initHorseChest();
            return true;
         }

         if (var2 != null && var2.getItem() == Item.getItemFromBlock(Blocks.chest) && !this.isChested()) {
            this.setChested(true);
            this.initHorseChest();
            return true;
         }
      }

      int var3 = var1 - 400;
      if (var3 >= 0 && var3 < 2 && var3 < this.horseChest.getSizeInventory()) {
         if (var3 == 0 && var2 != null && var2.getItem() != Items.saddle) {
            return false;
         } else if (var3 == 1 && (var2 != null && !isArmorItem(var2.getItem()) || !this.canWearArmor())) {
            return false;
         } else {
            this.horseChest.setInventorySlotContents(var3, var2);
            this.updateHorseSlots();
            return true;
         }
      } else {
         int var4 = var1 - 500 + 2;
         if (var4 >= 2 && var4 < this.horseChest.getSizeInventory()) {
            this.horseChest.setInventorySlotContents(var4, var2);
            return true;
         } else {
            return false;
         }
      }
   }

   private void mountTo(EntityPlayer var1) {
      var1.rotationYaw = this.rotationYaw;
      var1.rotationPitch = this.rotationPitch;
      this.setEatingHaystack(false);
      this.setRearing(false);
      if (!this.worldObj.isRemote) {
         var1.mountEntity(this);
      }

   }

   public float getRearingAmount(float var1) {
      return this.prevRearingAmount + (this.rearingAmount - this.prevRearingAmount) * var1;
   }

   public IEntityLivingData onInitialSpawn(DifficultyInstance var1, IEntityLivingData var2) {
      Object var7 = super.onInitialSpawn(var1, var2);
      boolean var3 = false;
      int var4 = 0;
      int var8;
      if (var7 instanceof EntityHorse.GroupData) {
         var8 = ((EntityHorse.GroupData)var7).horseType;
         var4 = ((EntityHorse.GroupData)var7).horseVariant & 255 | this.rand.nextInt(5) << 8;
      } else {
         if (this.rand.nextInt(10) == 0) {
            var8 = 1;
         } else {
            int var5 = this.rand.nextInt(7);
            int var6 = this.rand.nextInt(5);
            var8 = 0;
            var4 = var5 | var6 << 8;
         }

         var7 = new EntityHorse.GroupData(var8, var4);
      }

      this.setHorseType(var8);
      this.setHorseVariant(var4);
      if (this.rand.nextInt(5) == 0) {
         this.setGrowingAge(-24000);
      }

      if (var8 != 4 && var8 != 3) {
         this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.getModifiedMaxHealth());
         if (var8 == 0) {
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.getModifiedMovementSpeed());
         } else {
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.17499999701976776D);
         }
      } else {
         this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0D);
         this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224D);
      }

      if (var8 != 2 && var8 != 1) {
         this.getEntityAttribute(horseJumpStrength).setBaseValue(this.getModifiedJumpStrength());
      } else {
         this.getEntityAttribute(horseJumpStrength).setBaseValue(0.5D);
      }

      this.setHealth(this.getMaxHealth());
      return (IEntityLivingData)var7;
   }

   private void setHorseTexturePaths() {
      this.texturePrefix = "horse/";
      this.horseTexturesArray[0] = null;
      this.horseTexturesArray[1] = null;
      this.horseTexturesArray[2] = null;
      int var1 = this.getHorseType();
      int var2 = this.getHorseVariant();
      int var3;
      if (var1 == 0) {
         var3 = var2 & 255;
         int var4 = (var2 & '\uff00') >> 8;
         if (var3 >= horseTextures.length) {
            this.field_175508_bO = false;
            return;
         }

         this.horseTexturesArray[0] = horseTextures[var3];
         this.texturePrefix = this.texturePrefix + HORSE_TEXTURES_ABBR[var3];
         if (var4 >= horseMarkingTextures.length) {
            this.field_175508_bO = false;
            return;
         }

         this.horseTexturesArray[1] = horseMarkingTextures[var4];
         this.texturePrefix = this.texturePrefix + HORSE_MARKING_TEXTURES_ABBR[var4];
      } else {
         this.horseTexturesArray[0] = "";
         this.texturePrefix = this.texturePrefix + "_" + var1 + "_";
      }

      var3 = this.getHorseArmorIndexSynced();
      if (var3 >= horseArmorTextures.length) {
         this.field_175508_bO = false;
      } else {
         this.horseTexturesArray[2] = horseArmorTextures[var3];
         this.texturePrefix = this.texturePrefix + HORSE_ARMOR_TEXTURES_ABBR[var3];
         this.field_175508_bO = true;
      }

   }

   public boolean interact(EntityPlayer var1) {
      ItemStack var2 = var1.inventory.getCurrentItem();
      if (var2 != null && var2.getItem() == Items.spawn_egg) {
         return super.interact(var1);
      } else if (!this.isTame() && this.isUndead()) {
         return false;
      } else if (this.isTame() && this.isAdultHorse() && var1.isSneaking()) {
         this.openGUI(var1);
         return true;
      } else if (this.func_110253_bW() && this.riddenByEntity != null) {
         return super.interact(var1);
      } else {
         if (var2 != null) {
            boolean var3 = false;
            if (this.canWearArmor()) {
               byte var4 = -1;
               if (var2.getItem() == Items.iron_horse_armor) {
                  var4 = 1;
               } else if (var2.getItem() == Items.golden_horse_armor) {
                  var4 = 2;
               } else if (var2.getItem() == Items.diamond_horse_armor) {
                  var4 = 3;
               }

               if (var4 >= 0) {
                  if (!this.isTame()) {
                     this.makeHorseRearWithSound();
                     return true;
                  }

                  this.openGUI(var1);
                  return true;
               }
            }

            if (!var3 && !this.isUndead()) {
               float var7 = 0.0F;
               short var5 = 0;
               byte var6 = 0;
               if (var2.getItem() == Items.wheat) {
                  var7 = 2.0F;
                  var5 = 20;
                  var6 = 3;
               } else if (var2.getItem() == Items.sugar) {
                  var7 = 1.0F;
                  var5 = 30;
                  var6 = 3;
               } else if (Block.getBlockFromItem(var2.getItem()) == Blocks.hay_block) {
                  var7 = 20.0F;
                  var5 = 180;
               } else if (var2.getItem() == Items.apple) {
                  var7 = 3.0F;
                  var5 = 60;
                  var6 = 3;
               } else if (var2.getItem() == Items.golden_carrot) {
                  var7 = 4.0F;
                  var5 = 60;
                  var6 = 5;
                  if (this.isTame() && this.getGrowingAge() == 0) {
                     var3 = true;
                     this.setInLove(var1);
                  }
               } else if (var2.getItem() == Items.golden_apple) {
                  var7 = 10.0F;
                  var5 = 240;
                  var6 = 10;
                  if (this.isTame() && this.getGrowingAge() == 0) {
                     var3 = true;
                     this.setInLove(var1);
                  }
               }

               if (this.getHealth() < this.getMaxHealth() && var7 > 0.0F) {
                  this.heal(var7);
                  var3 = true;
               }

               if (!this.isAdultHorse() && var5 > 0) {
                  this.addGrowth(var5);
                  var3 = true;
               }

               if (var6 > 0 && (var3 || !this.isTame()) && var6 < this.getMaxTemper()) {
                  var3 = true;
                  this.increaseTemper(var6);
               }

               if (var3) {
                  this.func_110266_cB();
               }
            }

            if (!this.isTame() && !var3) {
               if (var2 != null && var2.interactWithEntity(var1, this)) {
                  return true;
               }

               this.makeHorseRearWithSound();
               return true;
            }

            if (!var3 && this.canCarryChest() && !this.isChested() && var2.getItem() == Item.getItemFromBlock(Blocks.chest)) {
               this.setChested(true);
               this.playSound("mob.chickenplop", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
               var3 = true;
               this.initHorseChest();
            }

            if (!var3 && this.func_110253_bW() && !this.isHorseSaddled() && var2.getItem() == Items.saddle) {
               this.openGUI(var1);
               return true;
            }

            if (var3) {
               if (!var1.capabilities.isCreativeMode && --var2.stackSize == 0) {
                  var1.inventory.setInventorySlotContents(var1.inventory.currentItem, (ItemStack)null);
               }

               return true;
            }
         }

         if (this.func_110253_bW() && this.riddenByEntity == null) {
            if (var2 != null && var2.interactWithEntity(var1, this)) {
               return true;
            } else {
               this.mountTo(var1);
               return true;
            }
         } else {
            return super.interact(var1);
         }
      }
   }

   private void dropItemsInChest(Entity var1, AnimalChest var2) {
      if (var2 != null && !this.worldObj.isRemote) {
         for(int var3 = 0; var3 < var2.getSizeInventory(); ++var3) {
            ItemStack var4 = var2.getStackInSlot(var3);
            if (var4 != null) {
               this.entityDropItem(var4, 0.0F);
            }
         }
      }

   }

   public float getEyeHeight() {
      return this.height;
   }

   public void setEating(boolean var1) {
      this.setHorseWatchableBoolean(32, var1);
   }

   public static boolean isArmorItem(Item var0) {
      return var0 == Items.iron_horse_armor || var0 == Items.golden_horse_armor || var0 == Items.diamond_horse_armor;
   }

   private float getModifiedMaxHealth() {
      return 15.0F + (float)this.rand.nextInt(8) + (float)this.rand.nextInt(9);
   }

   public int getTalkInterval() {
      return 400;
   }

   public boolean canCarryChest() {
      int var1 = this.getHorseType();
      return var1 == 2 || var1 == 1;
   }

   public String getHorseTexture() {
      if (this.texturePrefix == null) {
         this.setHorseTexturePaths();
      }

      return this.texturePrefix;
   }

   public boolean isOnLadder() {
      return false;
   }

   public void setEatingHaystack(boolean var1) {
      this.setEating(var1);
   }

   public float getMouthOpennessAngle(float var1) {
      return this.prevMouthOpenness + (this.mouthOpenness - this.prevMouthOpenness) * var1;
   }

   private void func_110266_cB() {
      this.openHorseMouth();
      if (!this.isSilent()) {
         this.worldObj.playSoundAtEntity(this, "eating", 1.0F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
      }

   }

   public void updateRiderPosition() {
      super.updateRiderPosition();
      if (this.prevRearingAmount > 0.0F) {
         float var1 = MathHelper.sin(this.renderYawOffset * 3.1415927F / 180.0F);
         float var2 = MathHelper.cos(this.renderYawOffset * 3.1415927F / 180.0F);
         float var3 = 0.7F * this.prevRearingAmount;
         float var4 = 0.15F * this.prevRearingAmount;
         this.riddenByEntity.setPosition(this.posX + (double)(var3 * var1), this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset() + (double)var4, this.posZ - (double)(var3 * var2));
         if (this.riddenByEntity instanceof EntityLivingBase) {
            ((EntityLivingBase)this.riddenByEntity).renderYawOffset = this.renderYawOffset;
         }
      }

   }

   public void onLivingUpdate() {
      if (this.rand.nextInt(200) == 0) {
         this.func_110210_cH();
      }

      super.onLivingUpdate();
      if (!this.worldObj.isRemote) {
         if (this.rand.nextInt(900) == 0 && this.deathTime == 0) {
            this.heal(1.0F);
         }

         if (!this.isEatingHaystack() && this.riddenByEntity == null && this.rand.nextInt(300) == 0 && this.worldObj.getBlockState(new BlockPos(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY) - 1, MathHelper.floor_double(this.posZ))).getBlock() == Blocks.grass) {
            this.setEatingHaystack(true);
         }

         if (this.isEatingHaystack() && ++this.eatingHaystackCounter > 50) {
            this.eatingHaystackCounter = 0;
            this.setEatingHaystack(false);
         }

         if (this.isBreeding() && !this.isAdultHorse() && !this.isEatingHaystack()) {
            EntityHorse var1 = this.getClosestHorse(this, 16.0D);
            if (var1 != null && this.getDistanceSqToEntity(var1) > 4.0D) {
               this.navigator.getPathToEntityLiving(var1);
            }
         }
      }

   }

   public void onInventoryChanged(InventoryBasic var1) {
      int var2 = this.getHorseArmorIndexSynced();
      boolean var3 = this.isHorseSaddled();
      this.updateHorseSlots();
      if (this.ticksExisted > 20) {
         if (var2 == 0 && var2 != this.getHorseArmorIndexSynced()) {
            this.playSound("mob.horse.armor", 0.5F, 1.0F);
         } else if (var2 != this.getHorseArmorIndexSynced()) {
            this.playSound("mob.horse.armor", 0.5F, 1.0F);
         }

         if (!var3 && this.isHorseSaddled()) {
            this.playSound("mob.horse.leather", 0.5F, 1.0F);
         }
      }

   }

   public float getGrassEatingAmount(float var1) {
      return this.prevHeadLean + (this.headLean - this.prevHeadLean) * var1;
   }

   public double getHorseJumpStrength() {
      return this.getEntityAttribute(horseJumpStrength).getAttributeValue();
   }

   public void makeHorseRearWithSound() {
      this.makeHorseRear();
      String var1 = this.getAngrySoundName();
      if (var1 != null) {
         this.playSound(var1, this.getSoundVolume(), this.getSoundPitch());
      }

   }

   public void onDeath(DamageSource var1) {
      super.onDeath(var1);
      if (!this.worldObj.isRemote) {
         this.dropChestItems();
      }

   }

   private void setHorseWatchableBoolean(int var1, boolean var2) {
      int var3 = this.dataWatcher.getWatchableObjectInt(16);
      if (var2) {
         this.dataWatcher.updateObject(16, var3 | var1);
      } else {
         this.dataWatcher.updateObject(16, var3 & ~var1);
      }

   }

   public boolean allowLeashing() {
      return !this.isUndead() && super.allowLeashing();
   }

   private void func_110210_cH() {
      this.field_110278_bp = 1;
   }

   protected String getAngrySoundName() {
      this.openHorseMouth();
      this.makeHorseRear();
      int var1 = this.getHorseType();
      if (var1 != 3 && var1 != 4) {
         return var1 != 1 && var1 != 2 ? "mob.horse.angry" : "mob.horse.donkey.angry";
      } else {
         return null;
      }
   }

   public void openGUI(EntityPlayer var1) {
      if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == var1) && this.isTame()) {
         this.horseChest.setCustomName(this.getName());
         var1.displayGUIHorse(this, this.horseChest);
      }

   }

   private void initHorseChest() {
      AnimalChest var1 = this.horseChest;
      this.horseChest = new AnimalChest("HorseChest", this.getChestSize());
      this.horseChest.setCustomName(this.getName());
      if (var1 != null) {
         var1.removeInventoryChangeListener(this);
         int var2 = Math.min(var1.getSizeInventory(), this.horseChest.getSizeInventory());

         for(int var3 = 0; var3 < var2; ++var3) {
            ItemStack var4 = var1.getStackInSlot(var3);
            if (var4 != null) {
               this.horseChest.setInventorySlotContents(var3, var4.copy());
            }
         }
      }

      this.horseChest.addInventoryChangeListener(this);
      this.updateHorseSlots();
   }

   protected void playStepSound(BlockPos var1, Block var2) {
      Block.SoundType var3 = var2.stepSound;
      if (this.worldObj.getBlockState(var1.up()).getBlock() == Blocks.snow_layer) {
         var3 = Blocks.snow_layer.stepSound;
      }

      if (!var2.getMaterial().isLiquid()) {
         int var4 = this.getHorseType();
         if (this.riddenByEntity != null && var4 != 1 && var4 != 2) {
            ++this.gallopTime;
            if (this.gallopTime > 5 && this.gallopTime % 3 == 0) {
               this.playSound("mob.horse.gallop", var3.getVolume() * 0.15F, var3.getFrequency());
               if (var4 == 0 && this.rand.nextInt(10) == 0) {
                  this.playSound("mob.horse.breathe", var3.getVolume() * 0.6F, var3.getFrequency());
               }
            } else if (this.gallopTime <= 5) {
               this.playSound("mob.horse.wood", var3.getVolume() * 0.15F, var3.getFrequency());
            }
         } else if (var3 == Block.soundTypeWood) {
            this.playSound("mob.horse.wood", var3.getVolume() * 0.15F, var3.getFrequency());
         } else {
            this.playSound("mob.horse.soft", var3.getVolume() * 0.15F, var3.getFrequency());
         }
      }

   }

   protected void entityInit() {
      super.entityInit();
      this.dataWatcher.addObject(16, 0);
      this.dataWatcher.addObject(19, (byte)0);
      this.dataWatcher.addObject(20, 0);
      this.dataWatcher.addObject(21, String.valueOf(""));
      this.dataWatcher.addObject(22, 0);
   }

   public int getMaxSpawnedInChunk() {
      return 6;
   }

   public String getName() {
      if (this.hasCustomName()) {
         return this.getCustomNameTag();
      } else {
         int var1 = this.getHorseType();
         switch(var1) {
         case 0:
         default:
            return StatCollector.translateToLocal("entity.horse.name");
         case 1:
            return StatCollector.translateToLocal("entity.donkey.name");
         case 2:
            return StatCollector.translateToLocal("entity.mule.name");
         case 3:
            return StatCollector.translateToLocal("entity.zombiehorse.name");
         case 4:
            return StatCollector.translateToLocal("entity.skeletonhorse.name");
         }
      }
   }

   public void setHorseJumping(boolean var1) {
      this.horseJumping = var1;
   }

   public void setHorseType(int var1) {
      this.dataWatcher.updateObject(19, (byte)var1);
      this.resetTexturePrefix();
   }

   public String[] getVariantTexturePaths() {
      if (this.texturePrefix == null) {
         this.setHorseTexturePaths();
      }

      return this.horseTexturesArray;
   }

   private int getHorseArmorIndex(ItemStack var1) {
      if (var1 == null) {
         return 0;
      } else {
         Item var2 = var1.getItem();
         if (var2 == Items.iron_horse_armor) {
            return 1;
         } else if (var2 == Items.golden_horse_armor) {
            return 2;
         } else {
            return var2 == Items.diamond_horse_armor ? 3 : 0;
         }
      }
   }

   public void setHorseVariant(int var1) {
      this.dataWatcher.updateObject(20, var1);
      this.resetTexturePrefix();
   }

   protected void func_142017_o(float var1) {
      if (var1 > 6.0F && this.isEatingHaystack()) {
         this.setEatingHaystack(false);
      }

   }

   public boolean isHorseSaddled() {
      return this.getHorseWatchableBoolean(4);
   }

   public int getHorseType() {
      return this.dataWatcher.getWatchableObjectByte(19);
   }

   private void makeHorseRear() {
      if (!this.worldObj.isRemote) {
         this.jumpRearingCounter = 1;
         this.setRearing(true);
      }

   }

   private void resetTexturePrefix() {
      this.texturePrefix = null;
   }

   private double getModifiedJumpStrength() {
      return 0.4000000059604645D + this.rand.nextDouble() * 0.2D + this.rand.nextDouble() * 0.2D + this.rand.nextDouble() * 0.2D;
   }

   public boolean isHorseJumping() {
      return this.horseJumping;
   }

   public int getMaxTemper() {
      return 100;
   }

   public boolean isAdultHorse() {
      return !this.isChild();
   }

   private void openHorseMouth() {
      if (!this.worldObj.isRemote) {
         this.openMouthCounter = 1;
         this.setHorseWatchableBoolean(128, true);
      }

   }

   public void setRearing(boolean var1) {
      if (var1) {
         this.setEatingHaystack(false);
      }

      this.setHorseWatchableBoolean(64, var1);
   }

   public void setBreeding(boolean var1) {
      this.setHorseWatchableBoolean(16, var1);
   }

   public int increaseTemper(int var1) {
      int var2 = MathHelper.clamp_int(this.getTemper() + var1, 0, this.getMaxTemper());
      this.setTemper(var2);
      return var2;
   }

   public int getHorseVariant() {
      return this.dataWatcher.getWatchableObjectInt(20);
   }

   protected String getLivingSound() {
      this.openHorseMouth();
      if (this.rand.nextInt(10) == 0 && !this.isMovementBlocked()) {
         this.makeHorseRear();
      }

      int var1 = this.getHorseType();
      if (var1 == 3) {
         return "mob.horse.zombie.idle";
      } else if (var1 == 4) {
         return "mob.horse.skeleton.idle";
      } else {
         return var1 != 1 && var1 != 2 ? "mob.horse.idle" : "mob.horse.donkey.idle";
      }
   }

   private int getChestSize() {
      int var1 = this.getHorseType();
      return this.isChested() && (var1 == 1 || var1 == 2) ? 17 : 2;
   }

   public int getHorseArmorIndexSynced() {
      return this.dataWatcher.getWatchableObjectInt(22);
   }

   public boolean setTamedBy(EntityPlayer var1) {
      this.setOwnerId(var1.getUniqueID().toString());
      this.setHorseTamed(true);
      return true;
   }

   private void updateHorseSlots() {
      if (!this.worldObj.isRemote) {
         this.setHorseSaddled(this.horseChest.getStackInSlot(0) != null);
         if (this.canWearArmor()) {
            this.setHorseArmorStack(this.horseChest.getStackInSlot(1));
         }
      }

   }

   public boolean isTame() {
      return this.getHorseWatchableBoolean(2);
   }

   protected Item getDropItem() {
      boolean var1 = this.rand.nextInt(4) == 0;
      int var2 = this.getHorseType();
      if (var2 == 4) {
         return Items.bone;
      } else if (var2 == 3) {
         return var1 ? null : Items.rotten_flesh;
      } else {
         return Items.leather;
      }
   }

   public boolean prepareChunkForSpawn() {
      int var1 = MathHelper.floor_double(this.posX);
      int var2 = MathHelper.floor_double(this.posZ);
      this.worldObj.getBiomeGenForCoords(new BlockPos(var1, 0, var2));
      return true;
   }

   protected String getDeathSound() {
      this.openHorseMouth();
      int var1 = this.getHorseType();
      if (var1 == 3) {
         return "mob.horse.zombie.death";
      } else if (var1 == 4) {
         return "mob.horse.skeleton.death";
      } else {
         return var1 != 1 && var1 != 2 ? "mob.horse.death" : "mob.horse.donkey.death";
      }
   }

   private double getModifiedMovementSpeed() {
      return (0.44999998807907104D + this.rand.nextDouble() * 0.3D + this.rand.nextDouble() * 0.3D + this.rand.nextDouble() * 0.3D) * 0.25D;
   }

   public void setOwnerId(String var1) {
      this.dataWatcher.updateObject(21, var1);
   }

   public void fall(float var1, float var2) {
      if (var1 > 1.0F) {
         this.playSound("mob.horse.land", 0.4F, 1.0F);
      }

      int var3 = MathHelper.ceiling_float_int((var1 * 0.5F - 3.0F) * var2);
      if (var3 > 0) {
         this.attackEntityFrom(DamageSource.fall, (float)var3);
         if (this.riddenByEntity != null) {
            this.riddenByEntity.attackEntityFrom(DamageSource.fall, (float)var3);
         }

         Block var4 = this.worldObj.getBlockState(new BlockPos(this.posX, this.posY - 0.2D - (double)this.prevRotationYaw, this.posZ)).getBlock();
         if (var4.getMaterial() != Material.air && !this.isSilent()) {
            Block.SoundType var5 = var4.stepSound;
            this.worldObj.playSoundAtEntity(this, var5.getStepSound(), var5.getVolume() * 0.5F, var5.getFrequency() * 0.75F);
         }
      }

   }

   public int getTemper() {
      return this.temper;
   }

   public void setJumpPower(int var1) {
      if (this.isHorseSaddled()) {
         if (var1 < 0) {
            var1 = 0;
         } else {
            this.field_110294_bI = true;
            this.makeHorseRear();
         }

         if (var1 >= 90) {
            this.jumpPower = 1.0F;
         } else {
            this.jumpPower = 0.4F + 0.4F * (float)var1 / 90.0F;
         }
      }

   }

   public void setHasReproduced(boolean var1) {
      this.hasReproduced = var1;
   }

   public boolean isUndead() {
      int var1 = this.getHorseType();
      return var1 == 3 || var1 == 4;
   }

   public int getTotalArmorValue() {
      return armorValues[this.getHorseArmorIndexSynced()];
   }

   public boolean isEatingHaystack() {
      return this.getHorseWatchableBoolean(32);
   }

   protected void spawnHorseParticles(boolean var1) {
      EnumParticleTypes var2 = var1 ? EnumParticleTypes.HEART : EnumParticleTypes.SMOKE_NORMAL;

      for(int var3 = 0; var3 < 7; ++var3) {
         double var4 = this.rand.nextGaussian() * 0.02D;
         double var6 = this.rand.nextGaussian() * 0.02D;
         double var8 = this.rand.nextGaussian() * 0.02D;
         this.worldObj.spawnParticle(var2, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 0.5D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, var4, var6, var8);
      }

   }

   protected boolean isMovementBlocked() {
      if (this.riddenByEntity != null && this.isHorseSaddled()) {
         return true;
      } else {
         return this.isEatingHaystack() || this.isRearing();
      }
   }

   public boolean isBreeding() {
      return this.getHorseWatchableBoolean(16);
   }

   public void dropChests() {
      if (!this.worldObj.isRemote && this.isChested()) {
         this.dropItem(Item.getItemFromBlock(Blocks.chest), 1);
         this.setChested(false);
      }

   }

   public void setHorseSaddled(boolean var1) {
      this.setHorseWatchableBoolean(4, var1);
   }

   public boolean getHasReproduced() {
      return this.hasReproduced;
   }

   public void setScaleForAge(boolean var1) {
      if (var1) {
         this.setScale(this.getHorseSize());
      } else {
         this.setScale(1.0F);
      }

   }

   public boolean isChested() {
      return this.getHorseWatchableBoolean(8);
   }

   public void setChested(boolean var1) {
      this.setHorseWatchableBoolean(8, var1);
   }

   public boolean getCanSpawnHere() {
      this.prepareChunkForSpawn();
      return super.getCanSpawnHere();
   }

   public boolean isRearing() {
      return this.getHorseWatchableBoolean(64);
   }

   protected String getHurtSound() {
      this.openHorseMouth();
      if (this.rand.nextInt(3) == 0) {
         this.makeHorseRear();
      }

      int var1 = this.getHorseType();
      if (var1 == 3) {
         return "mob.horse.zombie.hit";
      } else if (var1 == 4) {
         return "mob.horse.skeleton.hit";
      } else {
         return var1 != 1 && var1 != 2 ? "mob.horse.hit" : "mob.horse.donkey.hit";
      }
   }

   public void setTemper(int var1) {
      this.temper = var1;
   }

   public static class GroupData implements IEntityLivingData {
      public int horseType;
      public int horseVariant;

      public GroupData(int var1, int var2) {
         this.horseType = var1;
         this.horseVariant = var2;
      }
   }
}
