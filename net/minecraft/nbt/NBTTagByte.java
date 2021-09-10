package net.minecraft.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagByte extends NBTBase.NBTPrimitive {
   private byte data;

   public double getDouble() {
      return (double)this.data;
   }

   public int getInt() {
      return this.data;
   }

   NBTTagByte() {
   }

   public float getFloat() {
      return (float)this.data;
   }

   public byte getId() {
      return 1;
   }

   public byte getByte() {
      return this.data;
   }

   public NBTBase copy() {
      return new NBTTagByte(this.data);
   }

   public String toString() {
      return this.data + "b";
   }

   void read(DataInput var1, int var2, NBTSizeTracker var3) throws IOException {
      var3.read(72L);
      this.data = var1.readByte();
   }

   public boolean equals(Object var1) {
      if (super.equals(var1)) {
         NBTTagByte var2 = (NBTTagByte)var1;
         return this.data == var2.data;
      } else {
         return false;
      }
   }

   public long getLong() {
      return (long)this.data;
   }

   public NBTTagByte(byte var1) {
      this.data = var1;
   }

   public short getShort() {
      return (short)this.data;
   }

   void write(DataOutput var1) throws IOException {
      var1.writeByte(this.data);
   }

   public int hashCode() {
      return super.hashCode() ^ this.data;
   }
}
