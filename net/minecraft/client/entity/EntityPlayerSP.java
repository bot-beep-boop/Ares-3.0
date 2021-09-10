package net.minecraft.client.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.MovingSoundMinecartRiding;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.GuiCommandBlock;
import net.minecraft.client.gui.GuiEnchantment;
import net.minecraft.client.gui.GuiHopper;
import net.minecraft.client.gui.GuiMerchant;
import net.minecraft.client.gui.GuiRepair;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.client.gui.inventory.GuiBeacon;
import net.minecraft.client.gui.inventory.GuiBrewingStand;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.client.gui.inventory.GuiDispenser;
import net.minecraft.client.gui.inventory.GuiEditSign;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.client.gui.inventory.GuiScreenHorseInventory;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.command.server.CommandBlockLogic;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C0APacketAnimation;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.network.play.client.C0CPacketInput;
import net.minecraft.network.play.client.C0DPacketCloseWindow;
import net.minecraft.network.play.client.C13PacketPlayerAbilities;
import net.minecraft.network.play.client.C16PacketClientStatus;
import net.minecraft.potion.Potion;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MovementInput;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;

public class EntityPlayerSP extends AbstractClientPlayer {
   private boolean hasValidHealth;
   private boolean serverSprintState;
   private float lastReportedPitch;
   private final StatFileWriter statWriter;
   private float horseJumpPower;
   private boolean serverSneakState;
   public int sprintingTicksLeft;
   private double lastReportedPosY;
   public final NetHandlerPlayClient sendQueue;
   private double lastReportedPosZ;
   public float renderArmPitch;
   public float prevTimeInPortal;
   private int horseJumpPowerCounter;
   protected int sprintToggleTimer;
   private int positionUpdateTicks;
   protected Minecraft mc;
   private String clientBrand;
   public float renderArmYaw;
   private float lastReportedYaw;
   private double lastReportedPosX;
   public MovementInput movementInput;
   public float prevRenderArmPitch;
   public float timeInPortal;
   public float prevRenderArmYaw;

   public void closeScreenAndDropStack() {
      this.inventory.setItemStack((ItemStack)null);
      super.closeScreen();
      this.mc.displayGuiScreen((GuiScreen)null);
   }

   public void setXPStats(float var1, int var2, int var3) {
      this.experience = var1;
      this.experienceTotal = var2;
      this.experienceLevel = var3;
   }

   private boolean isOpenBlockSpace(BlockPos var1) {
      return !this.worldObj.getBlockState(var1).getBlock().isNormalCube() && !this.worldObj.getBlockState(var1.up()).getBlock().isNormalCube();
   }

   public void playSound(String var1, float var2, float var3) {
      this.worldObj.playSound(this.posX, this.posY, this.posZ, var1, var2, var3, false);
   }

   public EntityItem dropOneItem(boolean var1) {
      C07PacketPlayerDigging.Action var2 = var1 ? C07PacketPlayerDigging.Action.DROP_ALL_ITEMS : C07PacketPlayerDigging.Action.DROP_ITEM;
      this.sendQueue.addToSendQueue(new C07PacketPlayerDigging(var2, BlockPos.ORIGIN, EnumFacing.DOWN));
      return null;
   }

   public EntityPlayerSP(Minecraft var1, World var2, NetHandlerPlayClient var3, StatFileWriter var4) {
      super(var2, var3.getGameProfile());
      this.sendQueue = var3;
      this.statWriter = var4;
      this.mc = var1;
      this.dimension = 0;
   }

   public BlockPos getPosition() {
      return new BlockPos(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D);
   }

   public void onUpdateWalkingPlayer() {
      boolean var1 = this.isSprinting();
      if (var1 != this.serverSprintState) {
         if (var1) {
            this.sendQueue.addToSendQueue(new C0BPacketEntityAction(this, C0BPacketEntityAction.Action.START_SPRINTING));
         } else {
            this.sendQueue.addToSendQueue(new C0BPacketEntityAction(this, C0BPacketEntityAction.Action.STOP_SPRINTING));
         }

         this.serverSprintState = var1;
      }

      boolean var2 = this.isSneaking();
      if (var2 != this.serverSneakState) {
         if (var2) {
            this.sendQueue.addToSendQueue(new C0BPacketEntityAction(this, C0BPacketEntityAction.Action.START_SNEAKING));
         } else {
            this.sendQueue.addToSendQueue(new C0BPacketEntityAction(this, C0BPacketEntityAction.Action.STOP_SNEAKING));
         }

         this.serverSneakState = var2;
      }

      if (this.isCurrentViewEntity()) {
         double var3 = this.posX - this.lastReportedPosX;
         double var5 = this.getEntityBoundingBox().minY - this.lastReportedPosY;
         double var7 = this.posZ - this.lastReportedPosZ;
         double var9 = (double)(this.rotationYaw - this.lastReportedYaw);
         double var11 = (double)(this.rotationPitch - this.lastReportedPitch);
         boolean var13 = var3 * var3 + var5 * var5 + var7 * var7 > 9.0E-4D || this.positionUpdateTicks >= 20;
         boolean var14 = var9 != 0.0D || var11 != 0.0D;
         if (this.ridingEntity == null) {
            if (var13 && var14) {
               this.sendQueue.addToSendQueue(new C03PacketPlayer.C06PacketPlayerPosLook(this.posX, this.getEntityBoundingBox().minY, this.posZ, this.rotationYaw, this.rotationPitch, this.onGround));
            } else if (var13) {
               this.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(this.posX, this.getEntityBoundingBox().minY, this.posZ, this.onGround));
            } else if (var14) {
               this.sendQueue.addToSendQueue(new C03PacketPlayer.C05PacketPlayerLook(this.rotationYaw, this.rotationPitch, this.onGround));
            } else {
               this.sendQueue.addToSendQueue(new C03PacketPlayer(this.onGround));
            }
         } else {
            this.sendQueue.addToSendQueue(new C03PacketPlayer.C06PacketPlayerPosLook(this.motionX, -999.0D, this.motionZ, this.rotationYaw, this.rotationPitch, this.onGround));
            var13 = false;
         }

         ++this.positionUpdateTicks;
         if (var13) {
            this.lastReportedPosX = this.posX;
            this.lastReportedPosY = this.getEntityBoundingBox().minY;
            this.lastReportedPosZ = this.posZ;
            this.positionUpdateTicks = 0;
         }

         if (var14) {
            this.lastReportedYaw = this.rotationYaw;
            this.lastReportedPitch = this.rotationPitch;
         }
      }

   }

   public void setClientBrand(String var1) {
      this.clientBrand = var1;
   }

   public void displayGUIHorse(EntityHorse var1, IInventory var2) {
      this.mc.displayGuiScreen(new GuiScreenHorseInventory(this.inventory, var2, var1));
   }

   protected void damageEntity(DamageSource var1, float var2) {
      if (!this.isEntityInvulnerable(var1)) {
         this.setHealth(this.getHealth() - var2);
      }

   }

   public void sendChatMessage(String var1) {
      this.sendQueue.addToSendQueue(new C01PacketChatMessage(var1));
   }

   public void displayVillagerTradeGui(IMerchant var1) {
      this.mc.displayGuiScreen(new GuiMerchant(this.inventory, var1, this.worldObj));
   }

   public void displayGui(IInteractionObject var1) {
      String var2 = var1.getGuiID();
      if ("minecraft:crafting_table".equals(var2)) {
         this.mc.displayGuiScreen(new GuiCrafting(this.inventory, this.worldObj));
      } else if ("minecraft:enchanting_table".equals(var2)) {
         this.mc.displayGuiScreen(new GuiEnchantment(this.inventory, this.worldObj, var1));
      } else if ("minecraft:anvil".equals(var2)) {
         this.mc.displayGuiScreen(new GuiRepair(this.inventory, this.worldObj));
      }

   }

   public boolean isRidingHorse() {
      return this.ridingEntity != null && this.ridingEntity instanceof EntityHorse && ((EntityHorse)this.ridingEntity).isHorseSaddled();
   }

   public void setPlayerSPHealth(float var1) {
      if (this.hasValidHealth) {
         float var2 = this.getHealth() - var1;
         if (var2 <= 0.0F) {
            this.setHealth(var1);
            if (var2 < 0.0F) {
               this.hurtResistantTime = this.maxHurtResistantTime / 2;
            }
         } else {
            this.lastDamage = var2;
            this.setHealth(this.getHealth());
            this.hurtResistantTime = this.maxHurtResistantTime;
            this.damageEntity(DamageSource.generic, var2);
            this.hurtTime = this.maxHurtTime = 10;
         }
      } else {
         this.setHealth(var1);
         this.hasValidHealth = true;
      }

   }

   public void onCriticalHit(Entity var1) {
      this.mc.effectRenderer.emitParticleAtEntity(var1, EnumParticleTypes.CRIT);
   }

   public String getClientBrand() {
      return this.clientBrand;
   }

   public void setSprinting(boolean var1) {
      super.setSprinting(var1);
      this.sprintingTicksLeft = var1 ? 600 : 0;
   }

   public void respawnPlayer() {
      this.sendQueue.addToSendQueue(new C16PacketClientStatus(C16PacketClientStatus.EnumState.PERFORM_RESPAWN));
   }

   public void onLivingUpdate() {
      if (this.sprintingTicksLeft > 0) {
         --this.sprintingTicksLeft;
         if (this.sprintingTicksLeft == 0) {
            this.setSprinting(false);
         }
      }

      if (this.sprintToggleTimer > 0) {
         --this.sprintToggleTimer;
      }

      this.prevTimeInPortal = this.timeInPortal;
      if (this.inPortal) {
         if (this.mc.currentScreen != null && !this.mc.currentScreen.doesGuiPauseGame()) {
            this.mc.displayGuiScreen((GuiScreen)null);
         }

         if (this.timeInPortal == 0.0F) {
            this.mc.getSoundHandler().playSound(PositionedSoundRecord.create(new ResourceLocation("portal.trigger"), this.rand.nextFloat() * 0.4F + 0.8F));
         }

         this.timeInPortal += 0.0125F;
         if (this.timeInPortal >= 1.0F) {
            this.timeInPortal = 1.0F;
         }

         this.inPortal = false;
      } else if (this.isPotionActive(Potion.confusion) && this.getActivePotionEffect(Potion.confusion).getDuration() > 60) {
         this.timeInPortal += 0.006666667F;
         if (this.timeInPortal > 1.0F) {
            this.timeInPortal = 1.0F;
         }
      } else {
         if (this.timeInPortal > 0.0F) {
            this.timeInPortal -= 0.05F;
         }

         if (this.timeInPortal < 0.0F) {
            this.timeInPortal = 0.0F;
         }
      }

      if (this.timeUntilPortal > 0) {
         --this.timeUntilPortal;
      }

      boolean var1 = this.movementInput.jump;
      boolean var2 = this.movementInput.sneak;
      float var3 = 0.8F;
      boolean var4 = this.movementInput.moveForward >= var3;
      this.movementInput.updatePlayerMoveState();
      if (this.isUsingItem() && !this.isRiding()) {
         MovementInput var10000 = this.movementInput;
         var10000.moveStrafe *= 0.2F;
         var10000 = this.movementInput;
         var10000.moveForward *= 0.2F;
         this.sprintToggleTimer = 0;
      }

      this.pushOutOfBlocks(this.posX - (double)this.width * 0.35D, this.getEntityBoundingBox().minY + 0.5D, this.posZ + (double)this.width * 0.35D);
      this.pushOutOfBlocks(this.posX - (double)this.width * 0.35D, this.getEntityBoundingBox().minY + 0.5D, this.posZ - (double)this.width * 0.35D);
      this.pushOutOfBlocks(this.posX + (double)this.width * 0.35D, this.getEntityBoundingBox().minY + 0.5D, this.posZ - (double)this.width * 0.35D);
      this.pushOutOfBlocks(this.posX + (double)this.width * 0.35D, this.getEntityBoundingBox().minY + 0.5D, this.posZ + (double)this.width * 0.35D);
      boolean var5 = (float)this.getFoodStats().getFoodLevel() > 6.0F || this.capabilities.allowFlying;
      if (this.onGround && !var2 && !var4 && this.movementInput.moveForward >= var3 && !this.isSprinting() && var5 && !this.isUsingItem() && !this.isPotionActive(Potion.blindness)) {
         if (this.sprintToggleTimer <= 0 && !this.mc.gameSettings.keyBindSprint.isKeyDown()) {
            this.sprintToggleTimer = 7;
         } else {
            this.setSprinting(true);
         }
      }

      if (!this.isSprinting() && this.movementInput.moveForward >= var3 && var5 && !this.isUsingItem() && !this.isPotionActive(Potion.blindness) && this.mc.gameSettings.keyBindSprint.isKeyDown()) {
         this.setSprinting(true);
      }

      if (this.isSprinting() && (this.movementInput.moveForward < var3 || this.isCollidedHorizontally || !var5)) {
         this.setSprinting(false);
      }

      if (this.capabilities.allowFlying) {
         if (this.mc.playerController.isSpectatorMode()) {
            if (!this.capabilities.isFlying) {
               this.capabilities.isFlying = true;
               this.sendPlayerAbilities();
            }
         } else if (!var1 && this.movementInput.jump) {
            if (this.flyToggleTimer == 0) {
               this.flyToggleTimer = 7;
            } else {
               this.capabilities.isFlying = !this.capabilities.isFlying;
               this.sendPlayerAbilities();
               this.flyToggleTimer = 0;
            }
         }
      }

      if (this.capabilities.isFlying && this.isCurrentViewEntity()) {
         if (this.movementInput.sneak) {
            this.motionY -= (double)(this.capabilities.getFlySpeed() * 3.0F);
         }

         if (this.movementInput.jump) {
            this.motionY += (double)(this.capabilities.getFlySpeed() * 3.0F);
         }
      }

      if (this.isRidingHorse()) {
         if (this.horseJumpPowerCounter < 0) {
            ++this.horseJumpPowerCounter;
            if (this.horseJumpPowerCounter == 0) {
               this.horseJumpPower = 0.0F;
            }
         }

         if (var1 && !this.movementInput.jump) {
            this.horseJumpPowerCounter = -10;
            this.sendHorseJump();
         } else if (!var1 && this.movementInput.jump) {
            this.horseJumpPowerCounter = 0;
            this.horseJumpPower = 0.0F;
         } else if (var1) {
            ++this.horseJumpPowerCounter;
            if (this.horseJumpPowerCounter < 10) {
               this.horseJumpPower = (float)this.horseJumpPowerCounter * 0.1F;
            } else {
               this.horseJumpPower = 0.8F + 2.0F / (float)(this.horseJumpPowerCounter - 9) * 0.1F;
            }
         }
      } else {
         this.horseJumpPower = 0.0F;
      }

      super.onLivingUpdate();
      if (this.onGround && this.capabilities.isFlying && !this.mc.playerController.isSpectatorMode()) {
         this.capabilities.isFlying = false;
         this.sendPlayerAbilities();
      }

   }

   public boolean isUser() {
      return true;
   }

   public void addChatMessage(IChatComponent var1) {
      this.mc.ingameGUI.getChatGUI().printChatMessage(var1);
   }

   public void swingItem() {
      super.swingItem();
      this.sendQueue.addToSendQueue(new C0APacketAnimation());
   }

   public boolean canCommandSenderUseCommand(int var1, String var2) {
      return var1 <= 0;
   }

   public void onEnchantmentCritical(Entity var1) {
      this.mc.effectRenderer.emitParticleAtEntity(var1, EnumParticleTypes.CRIT_MAGIC);
   }

   public void sendHorseInventory() {
      this.sendQueue.addToSendQueue(new C0BPacketEntityAction(this, C0BPacketEntityAction.Action.OPEN_INVENTORY));
   }

   public void openEditCommandBlock(CommandBlockLogic var1) {
      this.mc.displayGuiScreen(new GuiCommandBlock(var1));
   }

   public void sendPlayerAbilities() {
      this.sendQueue.addToSendQueue(new C13PacketPlayerAbilities(this.capabilities));
   }

   public void addChatComponentMessage(IChatComponent var1) {
      this.mc.ingameGUI.getChatGUI().printChatMessage(var1);
   }

   public boolean isSneaking() {
      boolean var1 = this.movementInput != null ? this.movementInput.sneak : false;
      return var1 && !this.sleeping;
   }

   protected boolean pushOutOfBlocks(double var1, double var3, double var5) {
      if (this.noClip) {
         return false;
      } else {
         BlockPos var7 = new BlockPos(var1, var3, var5);
         double var8 = var1 - (double)var7.getX();
         double var10 = var5 - (double)var7.getZ();
         if (!this.isOpenBlockSpace(var7)) {
            byte var12 = -1;
            double var13 = 9999.0D;
            if (this.isOpenBlockSpace(var7.west()) && var8 < var13) {
               var13 = var8;
               var12 = 0;
            }

            if (this.isOpenBlockSpace(var7.east()) && 1.0D - var8 < var13) {
               var13 = 1.0D - var8;
               var12 = 1;
            }

            if (this.isOpenBlockSpace(var7.north()) && var10 < var13) {
               var13 = var10;
               var12 = 4;
            }

            if (this.isOpenBlockSpace(var7.south()) && 1.0D - var10 < var13) {
               var13 = 1.0D - var10;
               var12 = 5;
            }

            float var15 = 0.1F;
            if (var12 == 0) {
               this.motionX = (double)(-var15);
            }

            if (var12 == 1) {
               this.motionX = (double)var15;
            }

            if (var12 == 4) {
               this.motionZ = (double)(-var15);
            }

            if (var12 == 5) {
               this.motionZ = (double)var15;
            }
         }

         return false;
      }
   }

   public boolean isServerWorld() {
      return true;
   }

   public void heal(float var1) {
   }

   public void updateEntityActionState() {
      super.updateEntityActionState();
      if (this.isCurrentViewEntity()) {
         this.moveStrafing = this.movementInput.moveStrafe;
         this.moveForward = this.movementInput.moveForward;
         this.isJumping = this.movementInput.jump;
         this.prevRenderArmYaw = this.renderArmYaw;
         this.prevRenderArmPitch = this.renderArmPitch;
         this.renderArmPitch = (float)((double)this.renderArmPitch + (double)(this.rotationPitch - this.renderArmPitch) * 0.5D);
         this.renderArmYaw = (float)((double)this.renderArmYaw + (double)(this.rotationYaw - this.renderArmYaw) * 0.5D);
      }

   }

   public void mountEntity(Entity var1) {
      super.mountEntity(var1);
      if (var1 instanceof EntityMinecart) {
         this.mc.getSoundHandler().playSound(new MovingSoundMinecartRiding(this, (EntityMinecart)var1));
      }

   }

   protected boolean isCurrentViewEntity() {
      return this.mc.getRenderViewEntity() == this;
   }

   public void closeScreen() {
      this.sendQueue.addToSendQueue(new C0DPacketCloseWindow(this.openContainer.windowId));
      this.closeScreenAndDropStack();
   }

   public void openEditSign(TileEntitySign var1) {
      this.mc.displayGuiScreen(new GuiEditSign(var1));
   }

   public void onUpdate() {
      if (this.worldObj.isBlockLoaded(new BlockPos(this.posX, 0.0D, this.posZ))) {
         super.onUpdate();
         if (this.isRiding()) {
            this.sendQueue.addToSendQueue(new C03PacketPlayer.C05PacketPlayerLook(this.rotationYaw, this.rotationPitch, this.onGround));
            this.sendQueue.addToSendQueue(new C0CPacketInput(this.moveStrafing, this.moveForward, this.movementInput.jump, this.movementInput.sneak));
         } else {
            this.onUpdateWalkingPlayer();
         }
      }

   }

   public boolean attackEntityFrom(DamageSource var1, float var2) {
      return false;
   }

   public StatFileWriter getStatFileWriter() {
      return this.statWriter;
   }

   public void addStat(StatBase var1, int var2) {
      if (var1 != null && var1.isIndependent) {
         super.addStat(var1, var2);
      }

   }

   public void displayGUIChest(IInventory var1) {
      String var2 = var1 instanceof IInteractionObject ? ((IInteractionObject)var1).getGuiID() : "minecraft:container";
      if ("minecraft:chest".equals(var2)) {
         this.mc.displayGuiScreen(new GuiChest(this.inventory, var1));
      } else if ("minecraft:hopper".equals(var2)) {
         this.mc.displayGuiScreen(new GuiHopper(this.inventory, var1));
      } else if ("minecraft:furnace".equals(var2)) {
         this.mc.displayGuiScreen(new GuiFurnace(this.inventory, var1));
      } else if ("minecraft:brewing_stand".equals(var2)) {
         this.mc.displayGuiScreen(new GuiBrewingStand(this.inventory, var1));
      } else if ("minecraft:beacon".equals(var2)) {
         this.mc.displayGuiScreen(new GuiBeacon(this.inventory, var1));
      } else if (!"minecraft:dispenser".equals(var2) && !"minecraft:dropper".equals(var2)) {
         this.mc.displayGuiScreen(new GuiChest(this.inventory, var1));
      } else {
         this.mc.displayGuiScreen(new GuiDispenser(this.inventory, var1));
      }

   }

   protected void sendHorseJump() {
      this.sendQueue.addToSendQueue(new C0BPacketEntityAction(this, C0BPacketEntityAction.Action.RIDING_JUMP, (int)(this.getHorseJumpPower() * 100.0F)));
   }

   public float getHorseJumpPower() {
      return this.horseJumpPower;
   }

   public void displayGUIBook(ItemStack var1) {
      Item var2 = var1.getItem();
      if (var2 == Items.writable_book) {
         this.mc.displayGuiScreen(new GuiScreenBook(this, var1, true));
      }

   }

   protected void joinEntityItemWithWorld(EntityItem var1) {
   }
}
