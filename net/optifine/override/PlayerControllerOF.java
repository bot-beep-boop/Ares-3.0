package net.optifine.override;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class PlayerControllerOF extends PlayerControllerMP {
   private Entity lastClickEntity = null;
   private boolean acting = false;
   private BlockPos lastClickBlockPos = null;

   public boolean isPlayerRightClickingOnEntity(EntityPlayer var1, Entity var2, MovingObjectPosition var3) {
      this.lastClickEntity = var2;
      return super.isPlayerRightClickingOnEntity(var1, var2, var3);
   }

   public Entity getLastClickEntity() {
      return this.lastClickEntity;
   }

   public boolean sendUseItem(EntityPlayer var1, World var2, ItemStack var3) {
      this.acting = true;
      boolean var4 = super.sendUseItem(var1, var2, var3);
      this.acting = false;
      return var4;
   }

   public boolean clickBlock(BlockPos var1, EnumFacing var2) {
      this.acting = true;
      this.lastClickBlockPos = var1;
      boolean var3 = super.clickBlock(var1, var2);
      this.acting = false;
      return var3;
   }

   public BlockPos getLastClickBlockPos() {
      return this.lastClickBlockPos;
   }

   public boolean isActing() {
      return this.acting;
   }

   public PlayerControllerOF(Minecraft var1, NetHandlerPlayClient var2) {
      super(var1, var2);
   }

   public boolean interactWithEntitySendPacket(EntityPlayer var1, Entity var2) {
      this.lastClickEntity = var2;
      return super.interactWithEntitySendPacket(var1, var2);
   }

   public boolean onPlayerDamageBlock(BlockPos var1, EnumFacing var2) {
      this.acting = true;
      this.lastClickBlockPos = var1;
      boolean var3 = super.onPlayerDamageBlock(var1, var2);
      this.acting = false;
      return var3;
   }

   public boolean onPlayerRightClick(EntityPlayerSP var1, WorldClient var2, ItemStack var3, BlockPos var4, EnumFacing var5, Vec3 var6) {
      this.acting = true;
      this.lastClickBlockPos = var4;
      boolean var7 = super.onPlayerRightClick(var1, var2, var3, var4, var5, var6);
      this.acting = false;
      return var7;
   }
}
