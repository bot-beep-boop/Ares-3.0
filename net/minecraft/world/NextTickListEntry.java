package net.minecraft.world;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;

public class NextTickListEntry implements Comparable<NextTickListEntry> {
   public final BlockPos position;
   private final Block block;
   public int priority;
   private long tickEntryID;
   public long scheduledTime;
   private static long nextTickEntryID;

   public int hashCode() {
      return this.position.hashCode();
   }

   public NextTickListEntry(BlockPos var1, Block var2) {
      this.tickEntryID = (long)(nextTickEntryID++);
      this.position = var1;
      this.block = var2;
   }

   public NextTickListEntry setScheduledTime(long var1) {
      this.scheduledTime = var1;
      return this;
   }

   public void setPriority(int var1) {
      this.priority = var1;
   }

   public Block getBlock() {
      return this.block;
   }

   public boolean equals(Object var1) {
      if (!(var1 instanceof NextTickListEntry)) {
         return false;
      } else {
         NextTickListEntry var2 = (NextTickListEntry)var1;
         return this.position.equals(var2.position) && Block.isEqualTo(this.block, var2.block);
      }
   }

   public String toString() {
      return Block.getIdFromBlock(this.block) + ": " + this.position + ", " + this.scheduledTime + ", " + this.priority + ", " + this.tickEntryID;
   }

   public int compareTo(Object var1) {
      return this.compareTo((NextTickListEntry)var1);
   }

   public int compareTo(NextTickListEntry var1) {
      if (this.scheduledTime < var1.scheduledTime) {
         return -1;
      } else if (this.scheduledTime > var1.scheduledTime) {
         return 1;
      } else if (this.priority != var1.priority) {
         return this.priority - var1.priority;
      } else if (this.tickEntryID < var1.tickEntryID) {
         return -1;
      } else {
         return this.tickEntryID > var1.tickEntryID ? 1 : 0;
      }
   }
}
