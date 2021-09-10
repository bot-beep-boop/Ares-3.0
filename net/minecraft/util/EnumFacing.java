package net.minecraft.util;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public enum EnumFacing implements IStringSerializable {
   UP(1, 0, -1, "up", EnumFacing.AxisDirection.POSITIVE, EnumFacing.Axis.Y, new Vec3i(0, 1, 0));

   private final int index;
   private static final EnumFacing[] HORIZONTALS = new EnumFacing[4];
   private final int opposite;
   EAST(5, 4, 3, "east", EnumFacing.AxisDirection.POSITIVE, EnumFacing.Axis.X, new Vec3i(1, 0, 0)),
   DOWN(0, 1, -1, "down", EnumFacing.AxisDirection.NEGATIVE, EnumFacing.Axis.Y, new Vec3i(0, -1, 0));

   private final int horizontalIndex;
   public static final EnumFacing[] VALUES = new EnumFacing[6];
   private final EnumFacing.AxisDirection axisDirection;
   private final EnumFacing.Axis axis;
   private static final Map<String, EnumFacing> NAME_LOOKUP = Maps.newHashMap();
   private final Vec3i directionVec;
   private static int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
   private final String name;
   private static final EnumFacing[] ENUM$VALUES = new EnumFacing[]{DOWN, UP, NORTH, SOUTH, WEST, EAST};
   WEST(4, 5, 1, "west", EnumFacing.AxisDirection.NEGATIVE, EnumFacing.Axis.X, new Vec3i(-1, 0, 0));

   private static int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
   SOUTH(3, 2, 0, "south", EnumFacing.AxisDirection.POSITIVE, EnumFacing.Axis.Z, new Vec3i(0, 0, 1)),
   NORTH(2, 3, 2, "north", EnumFacing.AxisDirection.NEGATIVE, EnumFacing.Axis.Z, new Vec3i(0, 0, -1));

   public int getFrontOffsetX() {
      return this.axis == EnumFacing.Axis.X ? this.axisDirection.getOffset() : 0;
   }

   public int getHorizontalIndex() {
      return this.horizontalIndex;
   }

   static int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis() {
      int[] var10000 = $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[EnumFacing.Axis.values().length];

         try {
            var0[EnumFacing.Axis.X.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[EnumFacing.Axis.Y.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[EnumFacing.Axis.Z.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis = var0;
         return var0;
      }
   }

   public String toString() {
      return this.name;
   }

   public EnumFacing.AxisDirection getAxisDirection() {
      return this.axisDirection;
   }

   public static EnumFacing byName(String var0) {
      return var0 == null ? null : (EnumFacing)NAME_LOOKUP.get(var0.toLowerCase());
   }

   public EnumFacing.Axis getAxis() {
      return this.axis;
   }

   public EnumFacing rotateY() {
      switch($SWITCH_TABLE$net$minecraft$util$EnumFacing()[this.ordinal()]) {
      case 3:
         return EAST;
      case 4:
         return WEST;
      case 5:
         return NORTH;
      case 6:
         return SOUTH;
      default:
         throw new IllegalStateException("Unable to get Y-rotated facing of " + this);
      }
   }

   public static EnumFacing getFacingFromVector(float var0, float var1, float var2) {
      EnumFacing var3 = NORTH;
      float var4 = Float.MIN_VALUE;
      EnumFacing[] var8;
      int var7 = (var8 = values()).length;

      for(int var6 = 0; var6 < var7; ++var6) {
         EnumFacing var5 = var8[var6];
         float var9 = var0 * (float)var5.directionVec.getX() + var1 * (float)var5.directionVec.getY() + var2 * (float)var5.directionVec.getZ();
         if (var9 > var4) {
            var4 = var9;
            var3 = var5;
         }
      }

      return var3;
   }

   public Vec3i getDirectionVec() {
      return this.directionVec;
   }

   public int getFrontOffsetZ() {
      return this.axis == EnumFacing.Axis.Z ? this.axisDirection.getOffset() : 0;
   }

   static int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
      int[] var10000 = $SWITCH_TABLE$net$minecraft$util$EnumFacing;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[values().length];

         try {
            var0[DOWN.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[EAST.ordinal()] = 6;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[NORTH.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[SOUTH.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[UP.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[WEST.ordinal()] = 5;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$minecraft$util$EnumFacing = var0;
         return var0;
      }
   }

   public String getName() {
      return this.name;
   }

   public static EnumFacing getHorizontal(int var0) {
      return HORIZONTALS[MathHelper.abs_int(var0 % HORIZONTALS.length)];
   }

   private EnumFacing rotateX() {
      switch($SWITCH_TABLE$net$minecraft$util$EnumFacing()[this.ordinal()]) {
      case 1:
         return SOUTH;
      case 2:
         return NORTH;
      case 3:
         return DOWN;
      case 4:
         return UP;
      case 5:
      case 6:
      default:
         throw new IllegalStateException("Unable to get X-rotated facing of " + this);
      }
   }

   public static EnumFacing fromAngle(double var0) {
      return getHorizontal(MathHelper.floor_double(var0 / 90.0D + 0.5D) & 3);
   }

   private EnumFacing rotateZ() {
      switch($SWITCH_TABLE$net$minecraft$util$EnumFacing()[this.ordinal()]) {
      case 1:
         return WEST;
      case 2:
         return EAST;
      case 3:
      case 4:
      default:
         throw new IllegalStateException("Unable to get Z-rotated facing of " + this);
      case 5:
         return UP;
      case 6:
         return DOWN;
      }
   }

   public int getFrontOffsetY() {
      return this.axis == EnumFacing.Axis.Y ? this.axisDirection.getOffset() : 0;
   }

   public EnumFacing rotateAround(EnumFacing.Axis var1) {
      switch($SWITCH_TABLE$net$minecraft$util$EnumFacing$Axis()[var1.ordinal()]) {
      case 1:
         if (this != WEST && this != EAST) {
            return this.rotateX();
         }

         return this;
      case 2:
         if (this != UP && this != DOWN) {
            return this.rotateY();
         }

         return this;
      case 3:
         if (this != NORTH && this != SOUTH) {
            return this.rotateZ();
         }

         return this;
      default:
         throw new IllegalStateException("Unable to get CW facing for axis " + var1);
      }
   }

   public String getName2() {
      return this.name;
   }

   public EnumFacing rotateYCCW() {
      switch($SWITCH_TABLE$net$minecraft$util$EnumFacing()[this.ordinal()]) {
      case 3:
         return WEST;
      case 4:
         return EAST;
      case 5:
         return SOUTH;
      case 6:
         return NORTH;
      default:
         throw new IllegalStateException("Unable to get CCW facing of " + this);
      }
   }

   public static EnumFacing random(Random var0) {
      return values()[var0.nextInt(values().length)];
   }

   public EnumFacing getOpposite() {
      return VALUES[this.opposite];
   }

   public int getIndex() {
      return this.index;
   }

   static {
      EnumFacing[] var3;
      int var2 = (var3 = values()).length;

      for(int var1 = 0; var1 < var2; ++var1) {
         EnumFacing var0 = var3[var1];
         VALUES[var0.index] = var0;
         if (var0.getAxis().isHorizontal()) {
            HORIZONTALS[var0.horizontalIndex] = var0;
         }

         NAME_LOOKUP.put(var0.getName2().toLowerCase(), var0);
      }

   }

   private EnumFacing(int var3, int var4, int var5, String var6, EnumFacing.AxisDirection var7, EnumFacing.Axis var8, Vec3i var9) {
      this.index = var3;
      this.horizontalIndex = var5;
      this.opposite = var4;
      this.name = var6;
      this.axis = var8;
      this.axisDirection = var7;
      this.directionVec = var9;
   }

   public static EnumFacing getFront(int var0) {
      return VALUES[MathHelper.abs_int(var0 % VALUES.length)];
   }

   public static EnumFacing getFacingFromAxis(EnumFacing.AxisDirection var0, EnumFacing.Axis var1) {
      EnumFacing[] var5;
      int var4 = (var5 = values()).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         EnumFacing var2 = var5[var3];
         if (var2.getAxisDirection() == var0 && var2.getAxis() == var1) {
            return var2;
         }
      }

      throw new IllegalArgumentException("No such direction: " + var0 + " " + var1);
   }

   public static enum AxisDirection {
      NEGATIVE(-1, "Towards negative");

      private final String description;
      private final int offset;
      POSITIVE(1, "Towards positive");

      private static final EnumFacing.AxisDirection[] ENUM$VALUES = new EnumFacing.AxisDirection[]{POSITIVE, NEGATIVE};

      private AxisDirection(int var3, String var4) {
         this.offset = var3;
         this.description = var4;
      }

      public int getOffset() {
         return this.offset;
      }

      public String toString() {
         return this.description;
      }
   }

   public static enum Axis implements Predicate<EnumFacing>, IStringSerializable {
      private static final EnumFacing.Axis[] ENUM$VALUES = new EnumFacing.Axis[]{X, Y, Z};
      Z("z", EnumFacing.Plane.HORIZONTAL);

      private final String name;
      private static final Map<String, EnumFacing.Axis> NAME_LOOKUP = Maps.newHashMap();
      X("x", EnumFacing.Plane.HORIZONTAL),
      Y("y", EnumFacing.Plane.VERTICAL);

      private final EnumFacing.Plane plane;

      public boolean isHorizontal() {
         return this.plane == EnumFacing.Plane.HORIZONTAL;
      }

      public String getName() {
         return this.name;
      }

      public static EnumFacing.Axis byName(String var0) {
         return var0 == null ? null : (EnumFacing.Axis)NAME_LOOKUP.get(var0.toLowerCase());
      }

      static {
         EnumFacing.Axis[] var3;
         int var2 = (var3 = values()).length;

         for(int var1 = 0; var1 < var2; ++var1) {
            EnumFacing.Axis var0 = var3[var1];
            NAME_LOOKUP.put(var0.getName2().toLowerCase(), var0);
         }

      }

      public boolean apply(EnumFacing var1) {
         return var1 != null && var1.getAxis() == this;
      }

      private Axis(String var3, EnumFacing.Plane var4) {
         this.name = var3;
         this.plane = var4;
      }

      public EnumFacing.Plane getPlane() {
         return this.plane;
      }

      public String toString() {
         return this.name;
      }

      public String getName2() {
         return this.name;
      }

      public boolean isVertical() {
         return this.plane == EnumFacing.Plane.VERTICAL;
      }

      public boolean apply(Object var1) {
         return this.apply((EnumFacing)var1);
      }
   }

   public static enum Plane implements Predicate<EnumFacing>, Iterable<EnumFacing> {
      HORIZONTAL;

      private static final EnumFacing.Plane[] ENUM$VALUES = new EnumFacing.Plane[]{HORIZONTAL, VERTICAL};
      private static int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Plane;
      VERTICAL;

      public EnumFacing[] facings() {
         switch($SWITCH_TABLE$net$minecraft$util$EnumFacing$Plane()[this.ordinal()]) {
         case 1:
            return new EnumFacing[]{EnumFacing.NORTH, EnumFacing.EAST, EnumFacing.SOUTH, EnumFacing.WEST};
         case 2:
            return new EnumFacing[]{EnumFacing.UP, EnumFacing.DOWN};
         default:
            throw new Error("Someone's been tampering with the universe!");
         }
      }

      static int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing$Plane() {
         int[] var10000 = $SWITCH_TABLE$net$minecraft$util$EnumFacing$Plane;
         if (var10000 != null) {
            return var10000;
         } else {
            int[] var0 = new int[values().length];

            try {
               var0[HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError var2) {
            }

            try {
               var0[VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError var1) {
            }

            $SWITCH_TABLE$net$minecraft$util$EnumFacing$Plane = var0;
            return var0;
         }
      }

      public boolean apply(Object var1) {
         return this.apply((EnumFacing)var1);
      }

      public EnumFacing random(Random var1) {
         EnumFacing[] var2 = this.facings();
         return var2[var1.nextInt(var2.length)];
      }

      public Iterator<EnumFacing> iterator() {
         return Iterators.forArray(this.facings());
      }

      public boolean apply(EnumFacing var1) {
         return var1 != null && var1.getAxis().getPlane() == this;
      }
   }
}
