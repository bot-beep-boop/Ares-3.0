package net.minecraft.client.renderer.vertex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VertexFormatElement {
   private static final Logger LOGGER = LogManager.getLogger();
   private int index;
   private final VertexFormatElement.EnumType type;
   private final VertexFormatElement.EnumUsage usage;
   private int elementCount;

   public final int getSize() {
      return this.type.getSize() * this.elementCount;
   }

   public final boolean isPositionElement() {
      return this.usage == VertexFormatElement.EnumUsage.POSITION;
   }

   public VertexFormatElement(int var1, VertexFormatElement.EnumType var2, VertexFormatElement.EnumUsage var3, int var4) {
      if (!this.func_177372_a(var1, var3)) {
         LOGGER.warn("Multiple vertex elements of the same type other than UVs are not supported. Forcing type to UV.");
         this.usage = VertexFormatElement.EnumUsage.UV;
      } else {
         this.usage = var3;
      }

      this.type = var2;
      this.index = var1;
      this.elementCount = var4;
   }

   public String toString() {
      return this.elementCount + "," + this.usage.getDisplayName() + "," + this.type.getDisplayName();
   }

   public final VertexFormatElement.EnumUsage getUsage() {
      return this.usage;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         VertexFormatElement var2 = (VertexFormatElement)var1;
         if (this.elementCount != var2.elementCount) {
            return false;
         } else if (this.index != var2.index) {
            return false;
         } else if (this.type != var2.type) {
            return false;
         } else {
            return this.usage == var2.usage;
         }
      } else {
         return false;
      }
   }

   public final int getIndex() {
      return this.index;
   }

   public int hashCode() {
      int var1 = this.type.hashCode();
      var1 = 31 * var1 + this.usage.hashCode();
      var1 = 31 * var1 + this.index;
      var1 = 31 * var1 + this.elementCount;
      return var1;
   }

   public final int getElementCount() {
      return this.elementCount;
   }

   private final boolean func_177372_a(int var1, VertexFormatElement.EnumUsage var2) {
      return var1 == 0 || var2 == VertexFormatElement.EnumUsage.UV;
   }

   public final VertexFormatElement.EnumType getType() {
      return this.type;
   }

   public static enum EnumType {
      INT(4, "Int", 5124),
      USHORT(2, "Unsigned Short", 5123);

      private final String displayName;
      SHORT(2, "Short", 5122);

      private static final VertexFormatElement.EnumType[] ENUM$VALUES = new VertexFormatElement.EnumType[]{FLOAT, UBYTE, BYTE, USHORT, SHORT, UINT, INT};
      UBYTE(1, "Unsigned Byte", 5121),
      BYTE(1, "Byte", 5120),
      UINT(4, "Unsigned Int", 5125);

      private final int glConstant;
      FLOAT(4, "Float", 5126);

      private final int size;

      private EnumType(int var3, String var4, int var5) {
         this.size = var3;
         this.displayName = var4;
         this.glConstant = var5;
      }

      public String getDisplayName() {
         return this.displayName;
      }

      public int getGlConstant() {
         return this.glConstant;
      }

      public int getSize() {
         return this.size;
      }
   }

   public static enum EnumUsage {
      COLOR("Vertex Color");

      private static final VertexFormatElement.EnumUsage[] ENUM$VALUES = new VertexFormatElement.EnumUsage[]{POSITION, NORMAL, COLOR, UV, MATRIX, BLEND_WEIGHT, PADDING};
      private final String displayName;
      BLEND_WEIGHT("Blend Weight"),
      POSITION("Position"),
      NORMAL("Normal"),
      MATRIX("Bone Matrix"),
      PADDING("Padding"),
      UV("UV");

      public String getDisplayName() {
         return this.displayName;
      }

      private EnumUsage(String var3) {
         this.displayName = var3;
      }
   }
}
