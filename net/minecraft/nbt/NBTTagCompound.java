package net.minecraft.nbt;

import com.google.common.collect.Maps;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.util.ReportedException;

public class NBTTagCompound extends NBTBase {
   private Map<String, NBTBase> tagMap = Maps.newHashMap();

   private static void writeEntry(String var0, NBTBase var1, DataOutput var2) throws IOException {
      var2.writeByte(var1.getId());
      if (var1.getId() != 0) {
         var2.writeUTF(var0);
         var1.write(var2);
      }

   }

   public int[] getIntArray(String var1) {
      try {
         return !this.hasKey(var1, 11) ? new int[0] : ((NBTTagIntArray)this.tagMap.get(var1)).getIntArray();
      } catch (ClassCastException var3) {
         throw new ReportedException(this.createCrashReport(var1, 11, var3));
      }
   }

   public void setString(String var1, String var2) {
      this.tagMap.put(var1, new NBTTagString(var2));
   }

   public int hashCode() {
      return super.hashCode() ^ this.tagMap.hashCode();
   }

   public float getFloat(String var1) {
      try {
         return !this.hasKey(var1, 99) ? 0.0F : ((NBTBase.NBTPrimitive)this.tagMap.get(var1)).getFloat();
      } catch (ClassCastException var3) {
         return 0.0F;
      }
   }

   public NBTBase copy() {
      NBTTagCompound var1 = new NBTTagCompound();
      Iterator var3 = this.tagMap.keySet().iterator();

      while(var3.hasNext()) {
         String var2 = (String)var3.next();
         var1.setTag(var2, ((NBTBase)this.tagMap.get(var2)).copy());
      }

      return var1;
   }

   static NBTBase readNBT(byte var0, String var1, DataInput var2, int var3, NBTSizeTracker var4) throws IOException {
      NBTBase var5 = NBTBase.createNewByType(var0);

      try {
         var5.read(var2, var3, var4);
         return var5;
      } catch (IOException var9) {
         CrashReport var7 = CrashReport.makeCrashReport(var9, "Loading NBT data");
         CrashReportCategory var8 = var7.makeCategory("NBT Tag");
         var8.addCrashSection("Tag name", var1);
         var8.addCrashSection("Tag type", var0);
         throw new ReportedException(var7);
      }
   }

   public void setByteArray(String var1, byte[] var2) {
      this.tagMap.put(var1, new NBTTagByteArray(var2));
   }

   public short getShort(String var1) {
      try {
         return !this.hasKey(var1, 99) ? 0 : ((NBTBase.NBTPrimitive)this.tagMap.get(var1)).getShort();
      } catch (ClassCastException var3) {
         return 0;
      }
   }

   public boolean getBoolean(String var1) {
      return this.getByte(var1) != 0;
   }

   public boolean hasKey(String var1, int var2) {
      byte var3 = this.getTagId(var1);
      if (var3 == var2) {
         return true;
      } else if (var2 != 99) {
         if (var3 > 0) {
         }

         return false;
      } else {
         return var3 == 1 || var3 == 2 || var3 == 3 || var3 == 4 || var3 == 5 || var3 == 6;
      }
   }

   public void setLong(String var1, long var2) {
      this.tagMap.put(var1, new NBTTagLong(var2));
   }

   public byte getByte(String var1) {
      try {
         return !this.hasKey(var1, 99) ? 0 : ((NBTBase.NBTPrimitive)this.tagMap.get(var1)).getByte();
      } catch (ClassCastException var3) {
         return 0;
      }
   }

   public byte getId() {
      return 10;
   }

   public void removeTag(String var1) {
      this.tagMap.remove(var1);
   }

   public byte getTagId(String var1) {
      NBTBase var2 = (NBTBase)this.tagMap.get(var1);
      return var2 != null ? var2.getId() : 0;
   }

   public void setBoolean(String var1, boolean var2) {
      this.setByte(var1, (byte)(var2 ? 1 : 0));
   }

   public void setFloat(String var1, float var2) {
      this.tagMap.put(var1, new NBTTagFloat(var2));
   }

   public boolean equals(Object var1) {
      if (super.equals(var1)) {
         NBTTagCompound var2 = (NBTTagCompound)var1;
         return this.tagMap.entrySet().equals(var2.tagMap.entrySet());
      } else {
         return false;
      }
   }

   public boolean hasNoTags() {
      return this.tagMap.isEmpty();
   }

   public void setInteger(String var1, int var2) {
      this.tagMap.put(var1, new NBTTagInt(var2));
   }

   private static byte readType(DataInput var0, NBTSizeTracker var1) throws IOException {
      return var0.readByte();
   }

   public NBTBase getTag(String var1) {
      return (NBTBase)this.tagMap.get(var1);
   }

   public NBTTagCompound getCompoundTag(String var1) {
      try {
         return !this.hasKey(var1, 10) ? new NBTTagCompound() : (NBTTagCompound)this.tagMap.get(var1);
      } catch (ClassCastException var3) {
         throw new ReportedException(this.createCrashReport(var1, 10, var3));
      }
   }

   public NBTTagList getTagList(String var1, int var2) {
      try {
         if (this.getTagId(var1) != 9) {
            return new NBTTagList();
         } else {
            NBTTagList var3 = (NBTTagList)this.tagMap.get(var1);
            return var3.tagCount() > 0 && var3.getTagType() != var2 ? new NBTTagList() : var3;
         }
      } catch (ClassCastException var4) {
         throw new ReportedException(this.createCrashReport(var1, 9, var4));
      }
   }

   public void setByte(String var1, byte var2) {
      this.tagMap.put(var1, new NBTTagByte(var2));
   }

   private CrashReport createCrashReport(String var1, int var2, ClassCastException var3) {
      CrashReport var4 = CrashReport.makeCrashReport(var3, "Reading NBT data");
      CrashReportCategory var5 = var4.makeCategoryDepth("Corrupt NBT tag", 1);
      var5.addCrashSectionCallable("Tag type found", new Callable<String>(this, var1) {
         private final String val$key;
         final NBTTagCompound this$0;

         public String call() throws Exception {
            return NBTBase.NBT_TYPES[((NBTBase)NBTTagCompound.access$0(this.this$0).get(this.val$key)).getId()];
         }

         {
            this.this$0 = var1;
            this.val$key = var2;
         }

         public Object call() throws Exception {
            return this.call();
         }
      });
      var5.addCrashSectionCallable("Tag type expected", new Callable<String>(this, var2) {
         final NBTTagCompound this$0;
         private final int val$expectedType;

         public Object call() throws Exception {
            return this.call();
         }

         public String call() throws Exception {
            return NBTBase.NBT_TYPES[this.val$expectedType];
         }

         {
            this.this$0 = var1;
            this.val$expectedType = var2;
         }
      });
      var5.addCrashSection("Tag name", var1);
      return var4;
   }

   public void setDouble(String var1, double var2) {
      this.tagMap.put(var1, new NBTTagDouble(var2));
   }

   public void setTag(String var1, NBTBase var2) {
      this.tagMap.put(var1, var2);
   }

   static Map access$0(NBTTagCompound var0) {
      return var0.tagMap;
   }

   public void setShort(String var1, short var2) {
      this.tagMap.put(var1, new NBTTagShort(var2));
   }

   public Set<String> getKeySet() {
      return this.tagMap.keySet();
   }

   public boolean hasKey(String var1) {
      return this.tagMap.containsKey(var1);
   }

   public double getDouble(String var1) {
      try {
         return !this.hasKey(var1, 99) ? 0.0D : ((NBTBase.NBTPrimitive)this.tagMap.get(var1)).getDouble();
      } catch (ClassCastException var3) {
         return 0.0D;
      }
   }

   public byte[] getByteArray(String var1) {
      try {
         return !this.hasKey(var1, 7) ? new byte[0] : ((NBTTagByteArray)this.tagMap.get(var1)).getByteArray();
      } catch (ClassCastException var3) {
         throw new ReportedException(this.createCrashReport(var1, 7, var3));
      }
   }

   void write(DataOutput var1) throws IOException {
      Iterator var3 = this.tagMap.keySet().iterator();

      while(var3.hasNext()) {
         String var2 = (String)var3.next();
         NBTBase var4 = (NBTBase)this.tagMap.get(var2);
         writeEntry(var2, var4, var1);
      }

      var1.writeByte(0);
   }

   public void setIntArray(String var1, int[] var2) {
      this.tagMap.put(var1, new NBTTagIntArray(var2));
   }

   public long getLong(String var1) {
      try {
         return !this.hasKey(var1, 99) ? 0L : ((NBTBase.NBTPrimitive)this.tagMap.get(var1)).getLong();
      } catch (ClassCastException var3) {
         return 0L;
      }
   }

   public String getString(String var1) {
      try {
         return !this.hasKey(var1, 8) ? "" : ((NBTBase)this.tagMap.get(var1)).getString();
      } catch (ClassCastException var3) {
         return "";
      }
   }

   public int getInteger(String var1) {
      try {
         return !this.hasKey(var1, 99) ? 0 : ((NBTBase.NBTPrimitive)this.tagMap.get(var1)).getInt();
      } catch (ClassCastException var3) {
         return 0;
      }
   }

   void read(DataInput var1, int var2, NBTSizeTracker var3) throws IOException {
      var3.read(384L);
      if (var2 > 512) {
         throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
      } else {
         this.tagMap.clear();

         byte var4;
         while((var4 = readType(var1, var3)) != 0) {
            String var5 = readKey(var1, var3);
            var3.read((long)(224 + 16 * var5.length()));
            NBTBase var6 = readNBT(var4, var5, var1, var2 + 1, var3);
            if (this.tagMap.put(var5, var6) != null) {
               var3.read(288L);
            }
         }

      }
   }

   public void merge(NBTTagCompound var1) {
      Iterator var3 = var1.tagMap.keySet().iterator();

      while(var3.hasNext()) {
         String var2 = (String)var3.next();
         NBTBase var4 = (NBTBase)var1.tagMap.get(var2);
         if (var4.getId() == 10) {
            if (this.hasKey(var2, 10)) {
               NBTTagCompound var5 = this.getCompoundTag(var2);
               var5.merge((NBTTagCompound)var4);
            } else {
               this.setTag(var2, var4.copy());
            }
         } else {
            this.setTag(var2, var4.copy());
         }
      }

   }

   private static String readKey(DataInput var0, NBTSizeTracker var1) throws IOException {
      return var0.readUTF();
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder("{");

      Entry var2;
      for(Iterator var3 = this.tagMap.entrySet().iterator(); var3.hasNext(); var1.append((String)var2.getKey()).append(':').append(var2.getValue())) {
         var2 = (Entry)var3.next();
         if (var1.length() != 1) {
            var1.append(',');
         }
      }

      return var1.append('}').toString();
   }
}
