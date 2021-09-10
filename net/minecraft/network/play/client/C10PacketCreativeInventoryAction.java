package net.minecraft.network.play.client;

import java.io.IOException;
import net.minecraft.item.ItemStack;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayServer;

public class C10PacketCreativeInventoryAction implements Packet<INetHandlerPlayServer> {
   private int slotId;
   private ItemStack stack;

   public C10PacketCreativeInventoryAction() {
   }

   public int getSlotId() {
      return this.slotId;
   }

   public void readPacketData(PacketBuffer var1) throws IOException {
      this.slotId = var1.readShort();
      this.stack = var1.readItemStackFromBuffer();
   }

   public C10PacketCreativeInventoryAction(int var1, ItemStack var2) {
      this.slotId = var1;
      this.stack = var2 != null ? var2.copy() : null;
   }

   public void processPacket(INetHandler var1) {
      this.processPacket((INetHandlerPlayServer)var1);
   }

   public void processPacket(INetHandlerPlayServer var1) {
      var1.processCreativeInventoryAction(this);
   }

   public void writePacketData(PacketBuffer var1) throws IOException {
      var1.writeShort(this.slotId);
      var1.writeItemStackToBuffer(this.stack);
   }

   public ItemStack getStack() {
      return this.stack;
   }
}
