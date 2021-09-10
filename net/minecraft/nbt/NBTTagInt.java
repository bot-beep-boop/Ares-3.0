package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagInt extends NBTBase.NBTPrimitive {
   private int data;

   public double getDouble() {
      return (double)this.data;
   }

   public long getLong() {
      return (long)this.data;
   }

   void write(DataOutput var1) throws IOException {
      var1.writeInt(this.data);
   }

   public float getFloat() {
      return (float)this.data;
   }

   void read(DataInput var1, int var2, NBTSizeTracker var3) throws IOException {
      var3.read(96L);
      this.data = var1.readInt();
   }

   public NBTTagInt(int var1) {
      this.data = var1;
   }

   public byte getByte() {
      return (byte)(this.data & 255);
   }

   NBTTagInt() {
   }

   public short getShort() {
      return (short)(this.data & '\uffff');
   }

   public NBTBase copy() {
      return new NBTTagInt(this.data);
   }

   public byte getId() {
      return 3;
   }

   public boolean equals(Object var1) {
      if (super.equals(var1)) {
         NBTTagInt var2 = (NBTTagInt)var1;
         return this.data == var2.data;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ this.data;
   }

   public String toString() {
      return "" + this.data;
   }

   public int getInt() {
      return this.data;
   }
}
