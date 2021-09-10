package net.minecraft.tileentity;

import io.netty.buffer.ByteBuf;
import net.minecraft.command.CommandResultStats;
import net.minecraft.command.server.CommandBlockLogic;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class TileEntityCommandBlock extends TileEntity {
   private final CommandBlockLogic commandBlockLogic = new CommandBlockLogic(this) {
      final TileEntityCommandBlock this$0;

      public Entity getCommandSenderEntity() {
         return null;
      }

      public void updateCommand() {
         this.this$0.getWorld().markBlockForUpdate(this.this$0.pos);
      }

      public World getEntityWorld() {
         return this.this$0.getWorld();
      }

      public int func_145751_f() {
         return 0;
      }

      {
         this.this$0 = var1;
      }

      public BlockPos getPosition() {
         return this.this$0.pos;
      }

      public void setCommand(String var1) {
         super.setCommand(var1);
         this.this$0.markDirty();
      }

      public Vec3 getPositionVector() {
         return new Vec3((double)this.this$0.pos.getX() + 0.5D, (double)this.this$0.pos.getY() + 0.5D, (double)this.this$0.pos.getZ() + 0.5D);
      }

      public void func_145757_a(ByteBuf var1) {
         var1.writeInt(this.this$0.pos.getX());
         var1.writeInt(this.this$0.pos.getY());
         var1.writeInt(this.this$0.pos.getZ());
      }
   };

   public void readFromNBT(NBTTagCompound var1) {
      super.readFromNBT(var1);
      this.commandBlockLogic.readDataFromNBT(var1);
   }

   public boolean func_183000_F() {
      return true;
   }

   public CommandBlockLogic getCommandBlockLogic() {
      return this.commandBlockLogic;
   }

   public Packet getDescriptionPacket() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.writeToNBT(var1);
      return new S35PacketUpdateTileEntity(this.pos, 2, var1);
   }

   public void writeToNBT(NBTTagCompound var1) {
      super.writeToNBT(var1);
      this.commandBlockLogic.writeDataToNBT(var1);
   }

   public CommandResultStats getCommandResultStats() {
      return this.commandBlockLogic.getCommandResultStats();
   }
}
